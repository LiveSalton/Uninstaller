package com.jumobile.manager.systemapp.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.jumobile.manager.systemapp.R;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.SyncFailedException;
import java.security.MessageDigest;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

/* compiled from: source */
/* loaded from: classes.dex */
public class f {
    private static final String a = "f";
    private static int b = 16;

    public static void a(String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(str, true);
            } catch (FileNotFoundException unused) {
            } catch (SyncFailedException unused2) {
            } catch (IOException unused3) {
            } catch (RuntimeException unused4) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.getFD().sync();
            } catch (FileNotFoundException unused5) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 == null) {
                    return;
                }
                fileOutputStream2.close();
            } catch (SyncFailedException unused6) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 == null) {
                    return;
                }
                fileOutputStream2.close();
            } catch (IOException unused7) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 == null) {
                    return;
                }
                fileOutputStream2.close();
            } catch (RuntimeException unused8) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 == null) {
                    return;
                }
                fileOutputStream2.close();
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException | RuntimeException unused9) {
                    }
                }
                throw th;
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (IOException | RuntimeException unused10) {
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        return c(b(str.getBytes()));
    }

    public static String a(byte[] bArr) {
        return c(b(bArr));
    }

    public static byte[] b(byte[] bArr) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (Exception unused) {
            messageDigest = null;
        }
        if (messageDigest == null) {
            return null;
        }
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    public static String c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(2 * bArr.length);
        for (int i = 0; i < bArr.length; i++) {
            sb.append("0123456789ABCDEF".charAt((bArr[i] >> 4) & 15));
            sb.append("0123456789ABCDEF".charAt(bArr[i] & 15));
        }
        return sb.toString();
    }

    public static boolean a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            return packageManager.getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void b(Context context, String str) {
        Uri uri;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    uri = FileProvider.a(context, "com.jumobile.manager.systemapp.FileProvider", new File(str));
                } catch (Exception unused) {
                    uri = null;
                }
                if (uri == null) {
                    File file = new File(context.getCacheDir().getPath() + "/apk_file/intermediate_install_file.apk");
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    if (a.a(str, file.getPath())) {
                        uri = FileProvider.a(context, "com.jumobile.manager.systemapp.FileProvider", file);
                    }
                }
                if (uri != null) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setFlags(268435456);
                    intent.setFlags(1);
                    intent.setDataAndType(uri, "application/vnd.android.package-archive");
                    context.startActivity(intent);
                } else {
                    m(context, "failed");
                }
            } else {
                Uri fromFile = Uri.fromFile(new File(str));
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setDataAndType(fromFile, "application/vnd.android.package-archive");
                intent2.addFlags(268435456);
                context.startActivity(intent2);
            }
        } catch (Exception unused2) {
        }
    }

    public static long c(Context context, String str) {
        HttpClient a2 = c.a(context);
        long j = -1;
        try {
            HttpResponse execute = a2.execute(new HttpGet(str));
            if (execute.getStatusLine().getStatusCode() != 200) {
                return -1L;
            }
            Header[] headers = execute.getHeaders("Last-Modified");
            int length = headers.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Header header = headers[i];
                if (header.getName().equals("Last-Modified")) {
                    try {
                        j = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US).parse(header.getValue()).getTime();
                        break;
                    } catch (Exception unused) {
                    }
                } else {
                    i++;
                }
            }
            a2.getConnectionManager().shutdown();
            return j;
        } catch (Exception unused2) {
            return -1L;
        }
    }

    public static String a(long j) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        if (j == 0) {
            return "0KB";
        }
        if (j < 1048576) {
            return numberFormat.format(j / 1024.0f) + "KB";
        }
        return numberFormat.format((j / 1024.0f) / 1024.0f) + "MB";
    }

    public static String d(Context context, String str) {
        return TextUtils.isEmpty(str) ? context.getString(R.string.user_app_version_default) : context.getString(R.string.user_app_version_format, str);
    }

    public static String e(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String a(Context context) {
        List<ResolveInfo> queryIntentActivities;
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        try {
            queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        } catch (Exception unused) {
        }
        if (queryIntentActivities == null) {
            return null;
        }
        if (1 == queryIntentActivities.size()) {
            return queryIntentActivities.get(0).activityInfo.packageName;
        }
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity != null && !"android".equals(resolveActivity.activityInfo.packageName)) {
            return resolveActivity.activityInfo.packageName;
        }
        return null;
    }

    public static List<String> a(Reader reader) {
        BufferedReader bufferedReader;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(reader, 1024);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (TextUtils.isEmpty(readLine)) {
                            try {
                                break;
                            } catch (Exception unused) {
                            }
                        } else if (!readLine.startsWith("#")) {
                            arrayList.add(readLine.trim());
                        }
                    } catch (Exception unused2) {
                        bufferedReader2 = bufferedReader;
                        ArrayList arrayList2 = new ArrayList(0);
                        try {
                            bufferedReader2.close();
                        } catch (Exception unused3) {
                        }
                        return arrayList2;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            bufferedReader.close();
                        } catch (Exception unused4) {
                        }
                        throw th;
                    }
                }
                bufferedReader.close();
                return arrayList.size() > 0 ? arrayList : new ArrayList(0);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
            }
        } catch (Exception unused5) {
        }
    }

    public static List<String> f(Context context, String str) {
        try {
            InputStream a2 = a(context.getAssets().open(str), str);
            if (a2 != null) {
                return a(new InputStreamReader(a2));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static InputStream a(InputStream inputStream, String str) {
        try {
            if (!SmartUtils.a()) {
                return null;
            }
            byte[] bytes = SmartUtils.getBytes(SmartUtils.getString(str).getBytes("UTF-8"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            int i = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    int i2 = i;
                    int i3 = 0;
                    while (i3 < read) {
                        bArr[i3] = (byte) (bytes[i2 % bytes.length] ^ bArr[i3]);
                        i3++;
                        i2++;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                    i = i2;
                } else {
                    return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static SpannableStringBuilder a(Context context, int i, int i2, String... strArr) {
        if (strArr == null) {
            return new SpannableStringBuilder(context.getString(i));
        }
        return a(context, context.getString(i, strArr), i2, strArr);
    }

    public static SpannableStringBuilder a(Context context, String str, int i, String... strArr) {
        if (strArr == null) {
            return new SpannableStringBuilder(str);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int color = context.getResources().getColor(i);
        int length = strArr.length;
        int[] iArr = new int[length];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = str.indexOf(strArr[i3], i2);
            if (-1 == iArr[i3]) {
                break;
            }
            i2 = iArr[i3] + strArr[i3].length();
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), iArr[i3], iArr[i3] + strArr[i3].length(), 34);
        }
        return spannableStringBuilder;
    }

    public static void g(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static void h(Context context, String str) {
        try {
            context.startActivity(context.getPackageManager().getLaunchIntentForPackage(str));
        } catch (Exception unused) {
        }
    }

    public static void i(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 9) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", str, null));
                intent.setFlags(276824064);
                try {
                    context.startActivity(intent);
                } catch (Exception unused) {
                    intent.setAction("android.intent.action.VIEW");
                    intent.setClassName("com.android.settings", "com.android.settings.applications.InstalledAppDetails");
                    context.startActivity(intent);
                }
            } else {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                intent2.putExtra("pkg", str);
                intent2.addFlags(268435456);
                context.startActivity(intent2);
            }
        } catch (Exception unused2) {
        }
    }

    public static boolean j(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 8) {
            try {
                Class<?> cls = Class.forName("android.app.admin.DevicePolicyManager");
                return ((Boolean) cls.getMethod("packageHasActiveAdmins", String.class).invoke(context.getSystemService("device_policy"), str)).booleanValue();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static void a(Activity activity, String str) {
        ArrayList<ComponentName> k = k(activity.getApplicationContext(), str);
        if (k == null || k.size() <= 0) {
            return;
        }
        Iterator<ComponentName> it = k.iterator();
        while (it.hasNext()) {
            a(activity, it.next());
        }
    }

    public static void a(Activity activity, ComponentName componentName) {
        Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.DeviceAdminAdd");
        intent.putExtra("android.app.extra.DEVICE_ADMIN", componentName);
        try {
            activity.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static ArrayList<ComponentName> k(Context context, String str) {
        try {
            List<ComponentName> list = (List) Class.forName("android.app.admin.DevicePolicyManager").getMethod("getActiveAdmins", (Class[]) null).invoke(context.getSystemService("device_policy"), (Object[]) null);
            if (list != null && list.size() > 0) {
                ArrayList<ComponentName> arrayList = new ArrayList<>();
                for (ComponentName componentName : list) {
                    if (componentName.getPackageName().equals(str)) {
                        arrayList.add(componentName);
                    }
                }
                return arrayList;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static List<String> l(Context context, String str) {
        File fileStreamPath = context.getFileStreamPath(str);
        if (!fileStreamPath.exists()) {
            return null;
        }
        try {
            return a(new FileReader(fileStreamPath));
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean a(Context context, String str, List<String> list) {
        BufferedWriter bufferedWriter;
        if (list == null) {
            return true;
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(context.getFileStreamPath(str)), 512);
        } catch (Exception unused) {
            bufferedWriter = null;
        } catch (Throwable th) {
            th = th;
            bufferedWriter = null;
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                bufferedWriter.write(it.next());
                bufferedWriter.newLine();
            }
            try {
                bufferedWriter.close();
            } catch (Exception unused2) {
            }
            return true;
        } catch (Exception unused3) {
            try {
                bufferedWriter.close();
            } catch (Exception unused4) {
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            try {
                bufferedWriter.close();
            } catch (Exception unused5) {
            }
            throw th;
        }
    }

    public static long c(String str) {
        ObjectInputStream objectInputStream = null;
        try {
            ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream(new File(str + ".time")));
            try {
                long readLong = objectInputStream2.readLong();
                if (objectInputStream2 == null) {
                    return readLong;
                }
                try {
                    objectInputStream2.close();
                    return readLong;
                } catch (Exception unused) {
                    return readLong;
                }
            } catch (Exception unused2) {
                objectInputStream = objectInputStream2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                return 0L;
            } catch (Throwable th) {
                th = th;
                objectInputStream = objectInputStream2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(String str, long j) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(str + ".time")));
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                objectOutputStream.writeLong(j);
            } catch (Exception unused2) {
                objectOutputStream2 = objectOutputStream;
                if (objectOutputStream2 != null) {
                    objectOutputStream2.close();
                }
                return;
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream2 = objectOutputStream;
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        } catch (Exception unused4) {
        }
    }

    public static void a(Context context, int i, int i2) {
        a(context, context.getString(i), i2);
    }

    public static void a(Context context, String str, int i) {
        Toast makeText = Toast.makeText(context, str, i);
        makeText.setGravity(81, 0, a(context, 120.0f));
        makeText.show();
    }

    public static void a(Context context, int i) {
        a(context, i, 0);
    }

    public static void m(Context context, String str) {
        a(context, str, 0);
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                Class<?> cls = Class.forName("android.os.Environment");
                if (((Boolean) cls.getMethod("isExternalStorageEmulated", new Class[0]).invoke(cls.getClass(), new Object[0])).booleanValue()) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static ArrayList<String> b(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                for (String str : (String[]) Class.forName("android.os.storage.StorageManager").getMethod("getVolumePaths", new Class[0]).invoke(context.getSystemService("storage"), new Object[0])) {
                    arrayList.add(str);
                }
            } else {
                String path = Environment.getExternalStorageDirectory().getPath();
                if (!TextUtils.isEmpty(path)) {
                    arrayList.add(path);
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/proc/mounts"))));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.contains("uid=1000") && readLine.contains("gid=1015") && !readLine.contains("asec")) {
                        String[] split = readLine.split(" ");
                        if (split.length >= 4) {
                            String str2 = split[1];
                            if (!arrayList.contains(str2)) {
                                arrayList.add(str2);
                            }
                        }
                    }
                }
                bufferedReader.close();
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static Object d(String str) {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(new File(str)));
        } catch (Exception unused) {
            objectInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Object readObject = objectInputStream.readObject();
            if (objectInputStream == null) {
                return readObject;
            }
            try {
                objectInputStream.close();
                return readObject;
            } catch (Exception unused2) {
                return readObject;
            }
        } catch (Exception unused3) {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (Exception unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            objectInputStream2 = objectInputStream;
            if (objectInputStream2 != null) {
                try {
                    objectInputStream2.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    public static void a(String str, Object obj) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(str)));
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                objectOutputStream.writeObject(obj);
            } catch (Exception unused2) {
                objectOutputStream2 = objectOutputStream;
                if (objectOutputStream2 != null) {
                    objectOutputStream2.close();
                }
                return;
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream2 = objectOutputStream;
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        } catch (Exception unused4) {
        }
    }
}
