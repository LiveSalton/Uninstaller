/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.core.content;

import static org.xmlpull.v1.XmlPullParser.END_DOCUMENT;
import static org.xmlpull.v1.XmlPullParser.START_TAG;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Service;
import android.content.ClipData;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.OpenableColumns;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;

import androidx.annotation.AnyRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.XmlRes;

import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * FileProvider is a special subclass of {@link ContentProvider} that facilitates secure sharing
 * of files associated with an app by creating a <code>content://</code> {@link Uri} for a file
 * instead of a <code>file:///</code> {@link Uri}.
 * <p>
 * A content URI allows you to grant read and write access using
 * temporary access permissions. When you create an {@link Intent} containing
 * a content URI, in order to send the content URI
 * to a client app, you can also call {@link Intent#setFlags(int) Intent.setFlags()} to add
 * permissions. These permissions are available to the client app for as long as the stack for
 * a receiving {@link Activity} is active. For an {@link Intent} going to a
 * {@link Service}, the permissions are available as long as the
 * {@link Service} is running.
 * <p>
 * In comparison, to control access to a <code>file:///</code> {@link Uri} you have to modify the
 * file system permissions of the underlying file. The permissions you provide become available to
 * <em>any</em> app, and remain in effect until you change them. This level of access is
 * fundamentally insecure.
 * <p>
 * The increased level of file access security offered by a content URI
 * makes FileProvider a key part of Android's security infrastructure.
 * <p>
 * This overview of FileProvider includes the following topics:
 * </p>
 * <ol>
 *     <li>Defining a FileProvider</li>
 *     <li>Specifying Available Files</li>
 *     <li>Generating the Content URI for a File</li>
 *     <li>Granting Temporary Permissions to a URI</li>
 *     <li>Serving a Content URI to Another App</li>
 * </ol>
 * <p>
 * <b>Defining a FileProvider</b>
 * <p>
 * Extend FileProvider with a default constructor, and call super with an XML resource file that
 * specifies the available files (see below for the structure of the XML file):
 * <pre class="prettyprint">
 * public class MyFileProvider extends FileProvider {
 *    public MyFileProvider() {
 *        super(R.xml.file_paths)
 *    }
 * }
 * </pre>
 * Add a
 * <code><a href="{@docRoot}guide/topics/manifest/provider-element.html">&lt;provider&gt;</a></code>
 * element to your app manifest. Set the <code>android:name</code> attribute to the FileProvider you
 * created. Set the <code>android:authorities</code> attribute to a URI authority based on a
 * domain you control; for example, if you control the domain <code>mydomain.com</code> you
 * should use the authority <code>com.mydomain.fileprovider</code>. Set the
 * <code>android:exported</code> attribute to <code>false</code>; the FileProvider does not need
 * to be public. Set the <a href="{@docRoot}guide/topics/manifest/provider-element.html#gprmsn"
 * >android:grantUriPermissions</a> attribute to <code>true</code>, to allow you to grant temporary
 * access to files. For example:
 * <pre class="prettyprint">
 * &lt;manifest&gt;
 *    ...
 *    &lt;application&gt;
 *        ...
 *        &lt;provider
 *            android:name="com.sample.MyFileProvider"
 *            android:authorities="com.mydomain.fileprovider"
 *            android:exported="false"
 *            android:grantUriPermissions="true"&gt;
 *            ...
 *        &lt;/provider&gt;
 *        ...
 *    &lt;/application&gt;
 * &lt;/manifest&gt;</pre>
 * <p>
 * It is possible to use FileProvider directly instead of extending it. However, this is not
 * reliable and will causes crashes on some devices.
 * <p>
 * <b>Specifying Available Files</b>
 * <p>
 * A FileProvider can only generate a content URI for files in directories that you specify
 * beforehand. To specify a directory, specify its storage area and path in XML, using child
 * elements of the <code>&lt;paths&gt;</code> element.
 * For example, the following <code>paths</code> element tells FileProvider that you intend to
 * request content URIs for the <code>images/</code> subdirectory of your private file area.
 * <pre class="prettyprint">
 * &lt;paths xmlns:android="http://schemas.android.com/apk/res/android"&gt;
 *    &lt;files-path name="my_images" path="images/"/&gt;
 *    ...
 * &lt;/paths&gt;
 * </pre>
 * <p>
 * The <code>&lt;paths&gt;</code> element must contain one or more of the following child elements:
 * <ul>
 *     <li>
 *     <pre class="prettyprint">&lt;files-path name="<i>name</i>" path="<i>path</i>" /&gt;</pre>
 *     Represents files in the <code>files/</code> subdirectory of your app's internal storage
 *     area. This subdirectory is the same as the value returned by {@link Context#getFilesDir()
 *     Context.getFilesDir()}.
 *     </li>
 *     <li><pre>&lt;cache-path name="<i>name</i>" path="<i>path</i>" /&gt;</pre>
 *     Represents files in the cache subdirectory of your app's internal storage area. The root path
 *     of this subdirectory is the same as the value returned by {@link Context#getCacheDir()
 *     getCacheDir()}.
 *     <li>
 *     <pre class="prettyprint">&lt;external-path name="<i>name</i>" path="<i>path</i>" /&gt;</pre>
 *     Represents files in the root of the external storage area. The root path of this subdirectory
 *     is the same as the value returned by
 *     {@link Environment#getExternalStorageDirectory() Environment.getExternalStorageDirectory()}.
 *     <li>
 *     <pre class="prettyprint">&lt;external-files-path name="<i>name</i>" path="<i>path</i>"
 *     /&gt;</pre>
 *     Represents files in the root of your app's external storage area. The root path of this
 *     subdirectory is the same as the value returned by
 *     {@link Context#getExternalFilesDir(String) Context.getExternalFilesDir(null)}.
 *     </li>
 *     <li>
 *     <pre class="prettyprint">&lt;external-cache-path name="<i>name</i>" path="<i>path</i>"
 *     /&gt;</pre>
 *     Represents files in the root of your app's external cache area. The root path of this
 *     subdirectory is the same as the value returned by
 *     {@link Context#getExternalCacheDir() Context.getExternalCacheDir()}.
 *     <li>
 *     <pre class="prettyprint">&lt;external-media-path name="<i>name</i>" path="<i>path</i>"
 *     /&gt;</pre>
 *     Represents files in the root of your app's external media area. The root path of this
 *     subdirectory is the same as the value returned by the first result of
 *     {@link Context#getExternalMediaDirs() Context.getExternalMediaDirs()}.
 *     <p><strong>Note:</strong> this directory is only available on API 21+ devices.</p>
 *     </li>
 * </ul>
 * <p>
 * These child elements all use the same attributes:
 * <ul>
 *     <li>
 *         <code>name="<i>name</i>"</code>
 *         <p>
 *         A URI path segment. To enforce security, this value hides the name of the subdirectory
 *         you're sharing. The subdirectory name for this value is contained in the
 *         <code>path</code> attribute.
 *     </li>
 *     <li>
 *         <code>path="<i>path</i>"</code>
 *         <p>
 *         The subdirectory you're sharing. While the <code>name</code> attribute is a URI path
 *         segment, the <code>path</code> value is an actual subdirectory name. Notice that the
 *         value refers to a <b>subdirectory</b>, not an individual file or files. You can't
 *         share a single file by its file name, nor can you specify a subset of files using
 *         wildcards.
 *     </li>
 * </ul>
 * <p>
 * You must specify a child element of <code>&lt;paths&gt;</code> for each directory that contains
 * files for which you want content URIs. For example, these XML elements specify two directories:
 * <pre class="prettyprint">
 * &lt;paths xmlns:android="http://schemas.android.com/apk/res/android"&gt;
 *    &lt;files-path name="my_images" path="images/"/&gt;
 *    &lt;files-path name="my_docs" path="docs/"/&gt;
 * &lt;/paths&gt;
 * </pre>
 * <p>
 * Put the <code>&lt;paths&gt;</code> element and its children in an XML file in your project.
 * For example, you can add them to a new file called <code>res/xml/file_paths.xml</code>.
 * </pre>
 * To link this file to the FileProvider, pass it to super() in the constructor for the
 * FileProvider you defined above, add a <a href="{@docRoot}guide/topics/manifest/meta-data
 * -element.html">&lt;meta-data&gt;</a> element as a child of the <code>&lt;provider&gt;</code>
 * element that defines the FileProvider. Set the <code>&lt;meta-data&gt;</code> element's
 * "android:name" attribute to <code>android.support.FILE_PROVIDER_PATHS</code>. Set the
 * element's "android:resource" attribute to <code>&#64;xml/file_paths</code> (notice that you
 * don't specify the <code>.xml</code> extension). For example:
 * <pre class="prettyprint">
 * &lt;provider
 *    android:name="com.sample.MyFileProvider"
 *    android:authorities="com.mydomain.fileprovider"
 *    android:exported="false"
 *    android:grantUriPermissions="true"&gt;
 *    &lt;meta-data
 *        android:name="android.support.FILE_PROVIDER_PATHS"
 *        android:resource="&#64;xml/file_paths" /&gt;
 * &lt;/provider&gt;
 * </pre>
 * <p>
 * <b>Generating the Content URI for a File</b>
 * <p>
 * To share a file with another app using a content URI, your app has to generate the content URI.
 * To generate the content URI, create a new {@link File} for the file, then pass the {@link File}
 * to {@link #getUriForFile(Context, String, File) getUriForFile()}. You can send the content URI
 * returned by {@link #getUriForFile(Context, String, File) getUriForFile()} to another app in an
 * {@link Intent}. The client app that receives the content URI can open the file
 * and access its contents by calling
 * {@link ContentResolver#openFileDescriptor(Uri, String)
 * ContentResolver.openFileDescriptor} to get a {@link ParcelFileDescriptor}.
 * <p>
 * For example, suppose your app is offering files to other apps with a FileProvider that has the
 * authority <code>com.mydomain.fileprovider</code>. To get a content URI for the file
 * <code>default_image.jpg</code> in the <code>images/</code> subdirectory of your internal storage
 * add the following code:
 * <pre class="prettyprint">
 * File imagePath = new File(Context.getFilesDir(), "my_images");
 * File newFile = new File(imagePath, "default_image.jpg");
 * Uri contentUri = getUriForFile(getContext(), "com.mydomain.fileprovider", newFile);
 * </pre>
 * As a result of the previous snippet,
 * {@link #getUriForFile(Context, String, File) getUriForFile()} returns the content URI
 * <code>content://com.mydomain.fileprovider/my_images/default_image.jpg</code>.
 * <p>
 * <b>Granting Temporary Permissions to a URI</b>
 * <p>
 * To grant an access permission to a content URI returned from
 * {@link #getUriForFile(Context, String, File) getUriForFile()}, you can either grant the
 * permission to a specific package or include the permission in an intent, as shown in the
 * following sections.
 * <h4>Grant Permission to a Specific Package</h4>
 * <p>
 *     Call the method
 *     {@link Context#grantUriPermission(String, Uri, int)
 *     Context.grantUriPermission(package, Uri, mode_flags)} for the <code>content://</code>
 *     {@link Uri}, using the desired mode flags. This grants temporary access permission for the
 *     content URI to the specified package, according to the value of the
 *     the <code>mode_flags</code> parameter, which you can set to
 *     {@link Intent#FLAG_GRANT_READ_URI_PERMISSION}, {@link Intent#FLAG_GRANT_WRITE_URI_PERMISSION}
 *     or both. The permission remains in effect until you revoke it by calling
 *     {@link Context#revokeUriPermission(Uri, int) revokeUriPermission()} or until the device
 *     reboots.
 * </p>
 * <h4>Include the Permission in an Intent</h4>
 * <p>
 *     To allow the user to choose which app receives the intent, and the permission to access the
 *     content, do the following:
 * </p>
 * <ol>
 * <li>
 *     Put the content URI in an {@link Intent} by calling {@link Intent#setData(Uri) setData()}.
 * </li>
 * <li>
 * <p>
 *     Call the method {@link Intent#setFlags(int) Intent.setFlags()} with either
 *     {@link Intent#FLAG_GRANT_READ_URI_PERMISSION} or
 *     {@link Intent#FLAG_GRANT_WRITE_URI_PERMISSION} or both.
 * </p>
 * <p>
 *     To support devices that run a version between Android 4.1 (API level 16) and Android 5.1
 *     (API level 22) inclusive, create a {@link ClipData} object from the content
 *     URI, and set the access permissions on the <code>ClipData</code> object:
 * </p>
 * <pre class="prettyprint">
 * shareContentIntent.setClipData(ClipData.newRawUri("", contentUri));
 * shareContentIntent.addFlags(
 *         Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
 * </pre>
 * </li>
 * <li>
 *     Send the {@link Intent} to
 *     another app. Most often, you do this by calling
 *     {@link Activity#setResult(int, Intent) setResult()}.
 * </li>
 * </ol>
 * <p>
 * Permissions granted in an {@link Intent} remain in effect while the stack of the receiving
 * {@link Activity} is active. When the stack finishes, the permissions are
 * automatically removed. Permissions granted to one {@link Activity} in a client
 * app are automatically extended to other components of that app.
 * <p>
 * <b>Serving a Content URI to Another App</b>
 * <p>
 * There are a variety of ways to serve the content URI for a file to a client app. One common way
 * is for the client app to start your app by calling
 * {@link Activity#startActivityForResult(Intent, int, Bundle) startActivityResult()},
 * which sends an {@link Intent} to your app to start an {@link Activity} in your app.
 * In response, your app can immediately return a content URI to the client app or present a user
 * interface that allows the user to pick a file. In the latter case, once the user picks the file
 * your app can return its content URI. In both cases, your app returns the content URI in an
 * {@link Intent} sent via {@link Activity#setResult(int, Intent) setResult()}.
 * </p>
 * <p>
 *  You can also put the content URI in a {@link ClipData} object and then add the
 *  object to an {@link Intent} you send to a client app. To do this, call
 *  {@link Intent#setClipData(ClipData) Intent.setClipData()}. When you use this approach, you can
 *  add multiple {@link ClipData} objects to the {@link Intent}, each with its own
 *  content URI. When you call {@link Intent#setFlags(int) Intent.setFlags()} on the {@link Intent}
 *  to set temporary access permissions, the same permissions are applied to all of the content
 *  URIs.
 * </p>
 * <p class="note">
 *  <strong>Note:</strong> The {@link Intent#setClipData(ClipData) Intent.setClipData()} method is
 *  only available in platform version 16 (Android 4.1) and later. If you want to maintain
 *  compatibility with previous versions, you should send one content URI at a time in the
 *  {@link Intent}. Set the action to {@link Intent#ACTION_SEND} and put the URI in data by calling
 *  {@link Intent#setData setData()}.
 * </p>
 * <b>More Information</b>
 * <p>
 *    To learn more about FileProvider, see the Android training class
 *    <a href="{@docRoot}training/secure-file-sharing/index.html">Sharing Files Securely with
 *    URIs</a>.
 * </p>
 */
public class FileProvider extends ContentProvider {
    private static final String[] COLUMNS = {
            OpenableColumns.DISPLAY_NAME, OpenableColumns.SIZE };

    private static final String
            META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";

    private static final String TAG_ROOT_PATH = "root-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";

    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";

    private static final String DISPLAYNAME_FIELD = "displayName";

    private static final File DEVICE_ROOT = new File("/");

    @GuardedBy("sCache")
    private static final HashMap<String, PathStrategy> sCache = new HashMap<>();

    // Do not use {@code mLocalPathStrategy} directly; access it via {@link #getLocalPathStrategy}.
    @GuardedBy("this")
    @Nullable private PathStrategy mLocalPathStrategy;

    private int mResourceId;
    private String mAuthority;

    public FileProvider() {
        mResourceId = ID_NULL;
    }

    protected FileProvider(@XmlRes int resourceId) {
        mResourceId = resourceId;
    }

    @AnyRes
    public static final int ID_NULL = 0;

    /**
     * The default FileProvider implementation does not need to be initialized. If you want to
     * override this method, you must provide your own subclass of FileProvider.
     */
    @Override
    public boolean onCreate() {
        return true;
    }

    /**
     * After the FileProvider is instantiated, this method is called to provide the system with
     * information about the provider.
     *
     * @param context A {@link Context} for the current component.
     * @param info A {@link ProviderInfo} for the new provider.
     */
    @SuppressWarnings("StringSplitter")
    @Override
    public void attachInfo(@NonNull Context context, @NonNull ProviderInfo info) {
        super.attachInfo(context, info);

        // Check our security attributes
        if (info.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!info.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }

        mAuthority = info.authority.split(";")[0];
        synchronized (sCache) {
            sCache.remove(mAuthority);
        }
    }

    /**
     * Return a content URI for a given {@link File}. Specific temporary
     * permissions for the content URI can be set with
     * {@link Context#grantUriPermission(String, Uri, int)}, or added
     * to an {@link Intent} by calling {@link Intent#setData(Uri) setData()} and then
     * {@link Intent#setFlags(int) setFlags()}; in both cases, the applicable flags are
     * {@link Intent#FLAG_GRANT_READ_URI_PERMISSION} and
     * {@link Intent#FLAG_GRANT_WRITE_URI_PERMISSION}. A FileProvider can only return a
     * <code>content</code> {@link Uri} for file paths defined in their <code>&lt;paths&gt;</code>
     * meta-data element. See the Class Overview for more information.
     *
     * @param context A {@link Context} for the current component.
     * @param authority The authority of a {@link FileProvider} defined in a
     *            {@code <provider>} element in your app's manifest.
     * @param file A {@link File} pointing to the filename for which you want a
     * <code>content</code> {@link Uri}.
     * @return A content URI for the file.
     * @throws IllegalArgumentException When the given {@link File} is outside
     * the paths supported by the provider.
     */
    public static Uri getUriForFile(@NonNull Context context, @NonNull String authority,
                                    @NonNull File file) {
        final PathStrategy strategy = getPathStrategy(context, authority, ID_NULL);
        return strategy.getUriForFile(file);
    }

    /**
     * Return a content URI for a given {@link File}. Specific temporary
     * permissions for the content URI can be set with
     * {@link Context#grantUriPermission(String, Uri, int)}, or added
     * to an {@link Intent} by calling {@link Intent#setData(Uri) setData()} and then
     * {@link Intent#setFlags(int) setFlags()}; in both cases, the applicable flags are
     * {@link Intent#FLAG_GRANT_READ_URI_PERMISSION} and
     * {@link Intent#FLAG_GRANT_WRITE_URI_PERMISSION}. A FileProvider can only return a
     * <code>content</code> {@link Uri} for file paths defined in their <code>&lt;paths&gt;</code>
     * meta-data element. See the Class Overview for more information.
     *
     * @param context A {@link Context} for the current component.
     * @param authority The authority of a {@link FileProvider} defined in a
     *            {@code <provider>} element in your app's manifest.
     * @param file A {@link File} pointing to the filename for which you want a
     * <code>content</code> {@link Uri}.
     * @param displayName The filename to be displayed. This can be used if the original filename
     * is undesirable.
     * @return A content URI for the file.
     * @throws IllegalArgumentException When the given {@link File} is outside
     * the paths supported by the provider.
     */
    @SuppressLint("StreamFiles")
    @NonNull
    public static Uri getUriForFile(@NonNull Context context, @NonNull String authority,
                                    @NonNull File file, @NonNull String displayName) {
        Uri uri = getUriForFile(context, authority, file);
        return uri.buildUpon().appendQueryParameter(DISPLAYNAME_FIELD, displayName).build();
    }

    /**
     * Use a content URI returned by
     * {@link #getUriForFile(Context, String, File) getUriForFile()} to get information about a file
     * managed by the FileProvider.
     * FileProvider reports the column names defined in {@link OpenableColumns}:
     * <ul>
     * <li>{@link OpenableColumns#DISPLAY_NAME}</li>
     * <li>{@link OpenableColumns#SIZE}</li>
     * </ul>
     * For more information, see
     * {@link ContentProvider#query(Uri, String[], String, String[], String)
     * ContentProvider.query()}.
     *
     * @param uri A content URI returned by {@link #getUriForFile}.
     * @param projection The list of columns to put into the {@link Cursor}. If null all columns are
     * included.
     * @param selection Selection criteria to apply. If null then all data that matches the content
     * URI is returned.
     * @param selectionArgs An array of {@link String}, containing arguments to bind to
     * the <i>selection</i> parameter. The <i>query</i> method scans <i>selection</i> from left to
     * right and iterates through <i>selectionArgs</i>, replacing the current "?" character in
     * <i>selection</i> with the value at the current position in <i>selectionArgs</i>. The
     * values are bound to <i>selection</i> as {@link String} values.
     * @param sortOrder A {@link String} containing the column name(s) on which to sort
     * the resulting {@link Cursor}.
     * @return A {@link Cursor} containing the results of the query.
     *
     */
    @NonNull
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs,
                        @Nullable String sortOrder) {
        // ContentProvider has already checked granted permissions
        final File file = getLocalPathStrategy().getFileForUri(uri);
        String displayName = uri.getQueryParameter(DISPLAYNAME_FIELD);

        if (projection == null) {
            projection = COLUMNS;
        }

        String[] cols = new String[projection.length];
        Object[] values = new Object[projection.length];
        int i = 0;
        for (String col : projection) {
            if (OpenableColumns.DISPLAY_NAME.equals(col)) {
                cols[i] = OpenableColumns.DISPLAY_NAME;
                values[i++] = (displayName == null) ? file.getName() : displayName;
            } else if (OpenableColumns.SIZE.equals(col)) {
                cols[i] = OpenableColumns.SIZE;
                values[i++] = file.length();
            }
        }

        cols = copyOf(cols, i);
        values = copyOf(values, i);

        final MatrixCursor cursor = new MatrixCursor(cols, 1);
        cursor.addRow(values);
        return cursor;
    }

    /**
     * Returns the MIME type of a content URI returned by
     * {@link #getUriForFile(Context, String, File) getUriForFile()}.
     *
     * @param uri A content URI returned by
     * {@link #getUriForFile(Context, String, File) getUriForFile()}.
     * @return If the associated file has an extension, the MIME type associated with that
     * extension; otherwise <code>application/octet-stream</code>.
     */
    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        // ContentProvider has already checked granted permissions
        final File file = getLocalPathStrategy().getFileForUri(uri);

        final int lastDot = file.getName().lastIndexOf('.');
        if (lastDot >= 0) {
            final String extension = file.getName().substring(lastDot + 1);
            final String mime = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            if (mime != null) {
                return mime;
            }
        }

        return "application/octet-stream";
    }

    /**
     * Unrestricted version of getType
     * called, when caller does not have corresponding permissions
     */
    //@Override
    @SuppressWarnings("MissingOverride")
    @Nullable
    public String getTypeAnonymous(@NonNull Uri uri) {
        return "application/octet-stream";
    }

    /**
     * By default, this method throws an {@link UnsupportedOperationException}. You must
     * subclass FileProvider if you want to provide different functionality.
     */
    @Override
    public Uri insert(@NonNull Uri uri, @NonNull ContentValues values) {
        throw new UnsupportedOperationException("No external inserts");
    }

    /**
     * By default, this method throws an {@link UnsupportedOperationException}. You must
     * subclass FileProvider if you want to provide different functionality.
     */
    @Override
    public int update(@NonNull Uri uri, @NonNull ContentValues values, @Nullable String selection,
                      @Nullable String[] selectionArgs) {
        throw new UnsupportedOperationException("No external updates");
    }

    /**
     * Deletes the file associated with the specified content URI, as
     * returned by {@link #getUriForFile(Context, String, File) getUriForFile()}. Notice that this
     * method does <b>not</b> throw an {@link IOException}; you must check its return value.
     *
     * @param uri A content URI for a file, as returned by
     * {@link #getUriForFile(Context, String, File) getUriForFile()}.
     * @param selection Ignored. Set to {@code null}.
     * @param selectionArgs Ignored. Set to {@code null}.
     * @return 1 if the delete succeeds; otherwise, 0.
     */
    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection,
                      @Nullable String[] selectionArgs) {
        // ContentProvider has already checked granted permissions
        final File file = getLocalPathStrategy().getFileForUri(uri);
        return file.delete() ? 1 : 0;
    }

    /**
     * By default, FileProvider automatically returns the
     * {@link ParcelFileDescriptor} for a file associated with a <code>content://</code>
     * {@link Uri}. To get the {@link ParcelFileDescriptor}, call
     * {@link ContentResolver#openFileDescriptor(Uri, String)
     * ContentResolver.openFileDescriptor}.
     *
     * To override this method, you must provide your own subclass of FileProvider.
     *
     * @param uri A content URI associated with a file, as returned by
     * {@link #getUriForFile(Context, String, File) getUriForFile()}.
     * @param mode Access mode for the file. May be "r" for read-only access, "rw" for read and
     * write access, or "rwt" for read and write access that truncates any existing file.
     * @return A new {@link ParcelFileDescriptor} with which you can access the file.
     */
    @SuppressLint("UnknownNullness") // b/171012356
    @Override
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String mode)
            throws FileNotFoundException {
        // ContentProvider has already checked granted permissions
        final File file = getLocalPathStrategy().getFileForUri(uri);
        final int fileMode = modeToMode(mode);
        return ParcelFileDescriptor.open(file, fileMode);
    }

    /** Return the local {@link PathStrategy}, creating it if necessary. */
    private PathStrategy getLocalPathStrategy() {
        synchronized (this) {
            if (mLocalPathStrategy == null) {
                mLocalPathStrategy = getPathStrategy(getContext(), mAuthority, mResourceId);
            }

            return mLocalPathStrategy;
        }
    }

    /**
     * Return {@link PathStrategy} for given authority, either by parsing or
     * returning from cache.
     */
    private static PathStrategy getPathStrategy(Context context, String authority, int resourceId) {
        PathStrategy strat;
        synchronized (sCache) {
            strat = sCache.get(authority);
            if (strat == null) {
                try {
                    strat = parsePathStrategy(context, authority, resourceId);
                } catch (IOException e) {
                    throw new IllegalArgumentException(
                            "Failed to parse " + META_DATA_FILE_PROVIDER_PATHS + " meta-data", e);
                } catch (XmlPullParserException e) {
                    throw new IllegalArgumentException(
                            "Failed to parse " + META_DATA_FILE_PROVIDER_PATHS + " meta-data", e);
                }
                sCache.put(authority, strat);
            }
        }
        return strat;
    }

    @VisibleForTesting
    static XmlResourceParser getFileProviderPathsMetaData(Context context, String authority,
                                                          @Nullable ProviderInfo info,
                                                          int resourceId) {
        if (info == null) {
            throw new IllegalArgumentException(
                    "Couldn't find meta-data for provider with authority " + authority);
        }

        if (info.metaData == null && resourceId != ID_NULL) {
            info.metaData = new Bundle(1);
            info.metaData.putInt(META_DATA_FILE_PROVIDER_PATHS, resourceId);
        }

        final XmlResourceParser in = info.loadXmlMetaData(
                context.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        if (in == null) {
            throw new IllegalArgumentException(
                    "Missing " + META_DATA_FILE_PROVIDER_PATHS + " meta-data");
        }

        return in;
    }

    public static File[] getExternalFilesDirs(@NonNull Context context, @Nullable String type) {
        if (Build.VERSION.SDK_INT >= 19) {
            return context.getExternalFilesDirs(type);
        } else {
            return new File[]{context.getExternalFilesDir(type)};
        }
    }

    public static File[] getExternalCacheDirs(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return context.getExternalCacheDirs();
        } else {
            return new File[]{context.getExternalCacheDir()};
        }
    }

    /**
     * Parse and return {@link PathStrategy} for given authority as defined in
     * {@link #META_DATA_FILE_PROVIDER_PATHS} {@code <meta-data>}.
     *
     * @see #getPathStrategy(Context, String, int)
     */
    private static PathStrategy parsePathStrategy(Context context, String authority, int resourceId)
            throws IOException, XmlPullParserException {
        final SimplePathStrategy strat = new SimplePathStrategy(authority);

        final ProviderInfo info = context.getPackageManager()
                .resolveContentProvider(authority, PackageManager.GET_META_DATA);
        final XmlResourceParser in = getFileProviderPathsMetaData(context, authority, info,
                resourceId);

        int type;
        while ((type = in.next()) != END_DOCUMENT) {
            if (type == START_TAG) {
                final String tag = in.getName();

                final String name = in.getAttributeValue(null, ATTR_NAME);
                String path = in.getAttributeValue(null, ATTR_PATH);

                File target = null;
                if (TAG_ROOT_PATH.equals(tag)) {
                    target = DEVICE_ROOT;
                } else if (TAG_FILES_PATH.equals(tag)) {
                    target = context.getFilesDir();
                } else if (TAG_CACHE_PATH.equals(tag)) {
                    target = context.getCacheDir();
                } else if (TAG_EXTERNAL.equals(tag)) {
                    target = Environment.getExternalStorageDirectory();
                } else if (TAG_EXTERNAL_FILES.equals(tag)) {
                    File[] externalFilesDirs = getExternalFilesDirs(context, null);
                    if (externalFilesDirs.length > 0) {
                        target = externalFilesDirs[0];
                    }
                } else if (TAG_EXTERNAL_CACHE.equals(tag)) {
                    File[] externalCacheDirs = getExternalCacheDirs(context);
                    if (externalCacheDirs.length > 0) {
                        target = externalCacheDirs[0];
                    }
                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
                        && TAG_EXTERNAL_MEDIA.equals(tag)) {
                    File[] externalMediaDirs = Api21Impl.getExternalMediaDirs(context);
                    if (externalMediaDirs.length > 0) {
                        target = externalMediaDirs[0];
                    }
                }

                if (target != null) {
                    strat.addRoot(name, buildPath(target, path));
                }
            }
        }

        return strat;
    }

    /**
     * Strategy for mapping between {@link File} and {@link Uri}.
     * <p>
     * Strategies must be symmetric so that mapping a {@link File} to a
     * {@link Uri} and then back to a {@link File} points at the original
     * target.
     * <p>
     * Strategies must remain consistent across app launches, and not rely on
     * dynamic state. This ensures that any generated {@link Uri} can still be
     * resolved if your process is killed and later restarted.
     *
     * @see SimplePathStrategy
     */
    interface PathStrategy {
        /**
         * Return a {@link Uri} that represents the given {@link File}.
         */
        Uri getUriForFile(File file);

        /**
         * Return a {@link File} that represents the given {@link Uri}.
         */
        File getFileForUri(Uri uri);
    }

    /**
     * Strategy that provides access to files living under a narrow allowed list
     * of filesystem roots. It will throw {@link SecurityException} if callers try
     * accessing files outside the configured roots.
     * <p>
     * For example, if configured with
     * {@code addRoot("myfiles", context.getFilesDir())}, then
     * {@code context.getFileStreamPath("foo.txt")} would map to
     * {@code content://myauthority/myfiles/foo.txt}.
     */
    static class SimplePathStrategy implements PathStrategy {
        private final String mAuthority;
        private final HashMap<String, File> mRoots = new HashMap<>();

        SimplePathStrategy(String authority) {
            mAuthority = authority;
        }

        /**
         * Add a mapping from a name to a filesystem root. The provider only offers
         * access to files that live under configured roots.
         */
        void addRoot(String name, File root) {
            if (TextUtils.isEmpty(name)) {
                throw new IllegalArgumentException("Name must not be empty");
            }

            try {
                // Resolve to canonical path to keep path checking fast
                root = root.getCanonicalFile();
            } catch (IOException e) {
                throw new IllegalArgumentException(
                        "Failed to resolve canonical path for " + root, e);
            }

            mRoots.put(name, root);
        }

        @Override
        public Uri getUriForFile(File file) {
            String path;
            try {
                path = file.getCanonicalPath();
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }

            // Find the most-specific root path
            Map.Entry<String, File> mostSpecific = null;
            for (Map.Entry<String, File> root : mRoots.entrySet()) {
                final String rootPath = root.getValue().getPath();
                if (path.startsWith(rootPath) && (mostSpecific == null
                        || rootPath.length() > mostSpecific.getValue().getPath().length())) {
                    mostSpecific = root;
                }
            }

            if (mostSpecific == null) {
                throw new IllegalArgumentException(
                        "Failed to find configured root that contains " + path);
            }

            // Start at first char of path under root
            final String rootPath = mostSpecific.getValue().getPath();
            if (rootPath.endsWith("/")) {
                path = path.substring(rootPath.length());
            } else {
                path = path.substring(rootPath.length() + 1);
            }

            // Encode the tag and path separately
            path = Uri.encode(mostSpecific.getKey()) + '/' + Uri.encode(path, "/");
            return new Uri.Builder().scheme("content")
                    .authority(mAuthority).encodedPath(path).build();
        }

        @Override
        public File getFileForUri(Uri uri) {
            String path = uri.getEncodedPath();

            final int splitIndex = path.indexOf('/', 1);
            final String tag = Uri.decode(path.substring(1, splitIndex));
            path = Uri.decode(path.substring(splitIndex + 1));

            final File root = mRoots.get(tag);
            if (root == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }

            File file = new File(root, path);
            try {
                file = file.getCanonicalFile();
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }

            if (!file.getPath().startsWith(root.getPath())) {
                throw new SecurityException("Resolved path jumped beyond configured root");
            }

            return file;
        }
    }

    /**
     * Copied from ContentResolver.java
     */
    private static int modeToMode(String mode) {
        int modeBits;
        if ("r".equals(mode)) {
            modeBits = ParcelFileDescriptor.MODE_READ_ONLY;
        } else if ("w".equals(mode) || "wt".equals(mode)) {
            modeBits = ParcelFileDescriptor.MODE_WRITE_ONLY
                    | ParcelFileDescriptor.MODE_CREATE
                    | ParcelFileDescriptor.MODE_TRUNCATE;
        } else if ("wa".equals(mode)) {
            modeBits = ParcelFileDescriptor.MODE_WRITE_ONLY
                    | ParcelFileDescriptor.MODE_CREATE
                    | ParcelFileDescriptor.MODE_APPEND;
        } else if ("rw".equals(mode)) {
            modeBits = ParcelFileDescriptor.MODE_READ_WRITE
                    | ParcelFileDescriptor.MODE_CREATE;
        } else if ("rwt".equals(mode)) {
            modeBits = ParcelFileDescriptor.MODE_READ_WRITE
                    | ParcelFileDescriptor.MODE_CREATE
                    | ParcelFileDescriptor.MODE_TRUNCATE;
        } else {
            throw new IllegalArgumentException("Invalid mode: " + mode);
        }
        return modeBits;
    }

    private static File buildPath(File base, String... segments) {
        File cur = base;
        for (String segment : segments) {
            if (segment != null) {
                cur = new File(cur, segment);
            }
        }
        return cur;
    }

    private static String[] copyOf(String[] original, int newLength) {
        final String[] result = new String[newLength];
        System.arraycopy(original, 0, result, 0, newLength);
        return result;
    }

    private static Object[] copyOf(Object[] original, int newLength) {
        final Object[] result = new Object[newLength];
        System.arraycopy(original, 0, result, 0, newLength);
        return result;
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
            // This class is not instantiable.
        }

        @DoNotInline
        static File[] getExternalMediaDirs(Context context) {
            // Deprecated, otherwise this would belong on ContextCompat as a public method.
            return context.getExternalMediaDirs();
        }
    }
}
