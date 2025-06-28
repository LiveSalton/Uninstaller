package com.jumobile.manager.systemapp.util;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Locale;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

/* compiled from: source */
/* loaded from: classes.dex */
public class c {
    private static final String[][] a = {new String[]{"cmwap", "10.0.0.172", "80"}, new String[]{"uniwap", "10.0.0.172", "80"}, new String[]{"uninet", "", ""}, new String[]{"ctwap", "10.0.0.200", "80"}, new String[]{"ctnet", "", ""}, new String[]{"3gwap", "10.0.0.172", "80"}, new String[]{"3gnet", "", ""}};

    public static HttpClient a(Context context, String str, int i) {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        ConnManagerParams.setTimeout(basicHttpParams, 10000L);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        ConnRouteParams.setDefaultProxy(basicHttpParams, c(context));
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        PlainSocketFactory socketFactory = PlainSocketFactory.getSocketFactory();
        schemeRegistry.register(new Scheme("http", socketFactory, 80));
        if (!TextUtils.isEmpty(str)) {
            schemeRegistry.register(new Scheme(str, socketFactory, i));
        }
        return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
    }

    public static HttpClient a(Context context) {
        return a(context, null, 0);
    }

    public static boolean b(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }

    private static HttpHost c(Context context) {
        if (b(context)) {
            return null;
        }
        String d = d(context);
        String str = "";
        String str2 = "";
        String[][] strArr = a;
        boolean z = false;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String[] strArr2 = strArr[i];
            if (strArr2[0].equals(d)) {
                str = strArr2[1];
                str2 = strArr2[2];
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            return e(context);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new HttpHost(str, Integer.parseInt(str2));
    }

    private static String d(Context context) {
        String str = "UNKNOWN";
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
            if (query != null) {
                if (query.moveToFirst()) {
                    String string = query.getString(query.getColumnIndex("apn"));
                    if (!TextUtils.isEmpty(string)) {
                        str = string.toLowerCase(Locale.getDefault());
                    }
                }
                query.close();
            }
        } catch (Exception unused) {
        }
        return str;
    }

    private static HttpHost e(Context context) {
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        if (defaultHost == null || defaultHost.length() <= 0) {
            return null;
        }
        return new HttpHost(defaultHost, defaultPort);
    }
}
