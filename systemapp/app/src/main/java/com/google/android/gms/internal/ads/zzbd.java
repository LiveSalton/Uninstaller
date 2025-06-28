package com.google.android.gms.internal.ads;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbd extends zzar {
    private final zzbf a;
    private final SSLSocketFactory b;

    public zzbd() {
        this(null);
    }

    private zzbd(zzbf zzbfVar) {
        this(null, null);
    }

    private zzbd(zzbf zzbfVar, SSLSocketFactory sSLSocketFactory) {
        this.a = null;
        this.b = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a8 A[Catch: all -> 0x00fd, TryCatch #1 {all -> 0x00fd, blocks: (B:3:0x0040, B:4:0x0048, B:6:0x004e, B:8:0x005e, B:9:0x0062, B:10:0x0065, B:11:0x00f7, B:12:0x00fc, B:14:0x0069, B:15:0x0072, B:16:0x0078, B:17:0x007e, B:18:0x0084, B:19:0x008a, B:20:0x0093, B:21:0x009c, B:22:0x00a1, B:24:0x00a8, B:25:0x00af, B:26:0x00b0, B:38:0x00cc), top: B:2:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b0 A[Catch: all -> 0x00fd, TryCatch #1 {all -> 0x00fd, blocks: (B:3:0x0040, B:4:0x0048, B:6:0x004e, B:8:0x005e, B:9:0x0062, B:10:0x0065, B:11:0x00f7, B:12:0x00fc, B:14:0x0069, B:15:0x0072, B:16:0x0078, B:17:0x007e, B:18:0x0084, B:19:0x008a, B:20:0x0093, B:21:0x009c, B:22:0x00a1, B:24:0x00a8, B:25:0x00af, B:26:0x00b0, B:38:0x00cc), top: B:2:0x0040 }] */
    @Override // com.google.android.gms.internal.ads.zzar
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.ads.zzbb a(com.google.android.gms.internal.ads.zzaa<?> r7, java.util.Map<java.lang.String, java.lang.String> r8) throws java.io.IOException, com.google.android.gms.internal.ads.zzl {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbd.a(com.google.android.gms.internal.ads.zzaa, java.util.Map):com.google.android.gms.internal.ads.zzbb");
    }

    private static List<zzu> a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(new zzu(entry.getKey(), it.next()));
                }
            }
        }
        return arrayList;
    }

    public static InputStream b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private static void a(HttpURLConnection httpURLConnection, zzaa<?> zzaaVar) throws IOException, zzl {
        byte[] a = zzaaVar.a();
        if (a != null) {
            httpURLConnection.setDoOutput(true);
            if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
                String valueOf = String.valueOf("UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", valueOf.length() != 0 ? "application/x-www-form-urlencoded; charset=".concat(valueOf) : new String("application/x-www-form-urlencoded; charset="));
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(a);
            dataOutputStream.close();
        }
    }
}
