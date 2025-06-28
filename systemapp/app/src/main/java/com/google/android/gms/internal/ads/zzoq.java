package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Log;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzoq implements zzot {
    private static final Pattern b = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> c = new AtomicReference<>();
    private final int e;
    private final int f;
    private final String g;
    private final zzpd<? super zzoq> k;
    private zzoo l;
    private HttpURLConnection m;
    private InputStream n;
    private boolean o;
    private long p;
    private long q;
    private long r;
    private long s;
    private final zzpp<String> h = null;
    private final zzox j = new zzox();
    private final boolean d = true;
    private final zzox i = null;

    public zzoq(String str, zzpp<String> zzppVar, zzpd<? super zzoq> zzpdVar, int i, int i2, boolean z, zzox zzoxVar) {
        this.g = zzpc.a(str);
        this.k = zzpdVar;
        this.e = i;
        this.f = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final Uri a() {
        if (this.m == null) {
            return null;
        }
        return Uri.parse(this.m.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzot
    public final Map<String, List<String>> b() {
        if (this.m == null) {
            return null;
        }
        return this.m.getHeaderFields();
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final long a(zzoo zzooVar) throws zzov {
        HttpURLConnection a;
        this.l = zzooVar;
        long j = 0;
        this.s = 0L;
        this.r = 0L;
        try {
            URL url = new URL(zzooVar.a.toString());
            byte[] bArr = zzooVar.b;
            long j2 = zzooVar.d;
            long j3 = zzooVar.e;
            boolean a2 = zzooVar.a(1);
            if (this.d) {
                URL url2 = url;
                byte[] bArr2 = bArr;
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i <= 20) {
                        URL url3 = url2;
                        long j4 = j3;
                        long j5 = j2;
                        a = a(url2, bArr2, j2, j3, a2, false);
                        int responseCode = a.getResponseCode();
                        if (responseCode != 300) {
                            if (responseCode != 301) {
                                if (responseCode != 302) {
                                    if (responseCode != 303) {
                                        if (bArr2 != null) {
                                            break;
                                        }
                                        if (responseCode != 307 && responseCode != 308) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        bArr2 = null;
                        String headerField = a.getHeaderField("Location");
                        a.disconnect();
                        if (headerField == null) {
                            throw new ProtocolException("Null location redirect");
                        }
                        url2 = new URL(url3, headerField);
                        String protocol = url2.getProtocol();
                        if (!"https".equals(protocol) && !"http".equals(protocol)) {
                            String valueOf = String.valueOf(protocol);
                            throw new ProtocolException(valueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(valueOf) : new String("Unsupported protocol redirect: "));
                        }
                        i = i2;
                        j3 = j4;
                        j2 = j5;
                    } else {
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("Too many redirects: ");
                        sb.append(i2);
                        throw new NoRouteToHostException(sb.toString());
                    }
                }
            } else {
                a = a(url, bArr, j2, j3, a2, true);
            }
            this.m = a;
            try {
                int responseCode2 = this.m.getResponseCode();
                if (responseCode2 < 200 || responseCode2 > 299) {
                    Map<String, List<String>> headerFields = this.m.getHeaderFields();
                    d();
                    zzou zzouVar = new zzou(responseCode2, headerFields, zzooVar);
                    if (responseCode2 == 416) {
                        zzouVar.initCause(new zzop(0));
                        throw zzouVar;
                    }
                    throw zzouVar;
                }
                this.m.getContentType();
                if (responseCode2 == 200 && zzooVar.d != 0) {
                    j = zzooVar.d;
                }
                this.p = j;
                if (zzooVar.a(1)) {
                    this.q = zzooVar.e;
                } else {
                    if (zzooVar.e != -1) {
                        this.q = zzooVar.e;
                    } else {
                        long a3 = a(this.m);
                        this.q = a3 != -1 ? a3 - this.p : -1L;
                    }
                }
                try {
                    this.n = this.m.getInputStream();
                    this.o = true;
                    if (this.k != null) {
                        this.k.a((zzpd<? super zzoq>) this, zzooVar);
                    }
                    return this.q;
                } catch (IOException e) {
                    d();
                    throw new zzov(e, zzooVar, 1);
                }
            } catch (IOException e2) {
                d();
                String valueOf2 = String.valueOf(zzooVar.a.toString());
                throw new zzov(valueOf2.length() != 0 ? "Unable to connect to ".concat(valueOf2) : new String("Unable to connect to "), e2, zzooVar, 1);
            }
        } catch (IOException e3) {
            String valueOf3 = String.valueOf(zzooVar.a.toString());
            throw new zzov(valueOf3.length() != 0 ? "Unable to connect to ".concat(valueOf3) : new String("Unable to connect to "), e3, zzooVar, 1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final int a(byte[] bArr, int i, int i2) throws zzov {
        try {
            if (this.r != this.p) {
                byte[] andSet = c.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (this.r != this.p) {
                    int read = this.n.read(andSet, 0, (int) Math.min(this.p - this.r, andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.r += read;
                    if (this.k != null) {
                        this.k.a((zzpd<? super zzoq>) this, read);
                    }
                }
                c.set(andSet);
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.q != -1) {
                long j = this.q - this.s;
                if (j == 0) {
                    return -1;
                }
                i2 = (int) Math.min(i2, j);
            }
            int read2 = this.n.read(bArr, i, i2);
            if (read2 == -1) {
                if (this.q != -1) {
                    throw new EOFException();
                }
                return -1;
            }
            this.s += read2;
            if (this.k != null) {
                this.k.a((zzpd<? super zzoq>) this, read2);
            }
            return read2;
        } catch (IOException e) {
            throw new zzov(e, this.l, 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0038, code lost:
    
        if (r3 > 2048) goto L74;
     */
    @Override // com.google.android.gms.internal.ads.zzon
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c() throws com.google.android.gms.internal.ads.zzov {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.n     // Catch: java.lang.Throwable -> L91
            if (r2 == 0) goto L7b
            java.net.HttpURLConnection r2 = r9.m     // Catch: java.lang.Throwable -> L91
            long r3 = r9.q     // Catch: java.lang.Throwable -> L91
            r5 = -1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 != 0) goto L13
            long r3 = r9.q     // Catch: java.lang.Throwable -> L91
            goto L18
        L13:
            long r3 = r9.q     // Catch: java.lang.Throwable -> L91
            long r7 = r9.s     // Catch: java.lang.Throwable -> L91
            long r3 = r3 - r7
        L18:
            int r7 = com.google.android.gms.internal.ads.zzpt.a     // Catch: java.lang.Throwable -> L91
            r8 = 19
            if (r7 == r8) goto L24
            int r7 = com.google.android.gms.internal.ads.zzpt.a     // Catch: java.lang.Throwable -> L91
            r8 = 20
            if (r7 != r8) goto L6b
        L24:
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L91
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 != 0) goto L34
            int r3 = r2.read()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L91
            r4 = -1
            if (r3 != r4) goto L3a
            goto L6b
        L34:
            r5 = 2048(0x800, double:1.0118E-320)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L6b
        L3a:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L91
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L91
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L91
            if (r4 != 0) goto L52
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L91
            if (r3 == 0) goto L6b
        L52:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L91
            java.lang.Class r3 = r3.getSuperclass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L91
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L91
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L91
            r4 = 1
            r3.setAccessible(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L91
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L91
            r3.invoke(r2, r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L91
        L6b:
            java.io.InputStream r2 = r9.n     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L91
            r2.close()     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L91
            goto L7b
        L71:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzov r3 = new com.google.android.gms.internal.ads.zzov     // Catch: java.lang.Throwable -> L91
            com.google.android.gms.internal.ads.zzoo r4 = r9.l     // Catch: java.lang.Throwable -> L91
            r5 = 3
            r3.<init>(r2, r4, r5)     // Catch: java.lang.Throwable -> L91
            throw r3     // Catch: java.lang.Throwable -> L91
        L7b:
            r9.n = r0
            r9.d()
            boolean r0 = r9.o
            if (r0 == 0) goto L90
            r9.o = r1
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.zzoq> r0 = r9.k
            if (r0 == 0) goto L90
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.zzoq> r0 = r9.k
            r0.a(r9)
            return
        L90:
            return
        L91:
            r2 = move-exception
            r9.n = r0
            r9.d()
            boolean r0 = r9.o
            if (r0 == 0) goto La6
            r9.o = r1
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.zzoq> r0 = r9.k
            if (r0 == 0) goto La6
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.zzoq> r0 = r9.k
            r0.a(r9)
        La6:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoq.c():void");
    }

    private final HttpURLConnection a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.e);
        httpURLConnection.setReadTimeout(this.f);
        for (Map.Entry<String, String> entry : this.j.a().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        if (j != 0 || j2 != -1) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            String sb2 = sb.toString();
            if (j2 != -1) {
                String valueOf = String.valueOf(sb2);
                StringBuilder sb3 = new StringBuilder(20 + String.valueOf(valueOf).length());
                sb3.append(valueOf);
                sb3.append((j + j2) - 1);
                sb2 = sb3.toString();
            }
            httpURLConnection.setRequestProperty("Range", sb2);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.g);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long a(java.net.HttpURLConnection r8) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r8.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L37
            long r1 = java.lang.Long.parseLong(r0)     // Catch: java.lang.NumberFormatException -> L11
            goto L39
        L11:
            java.lang.String r1 = "DefaultHttpDataSource"
            r2 = 28
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unexpected Content-Length ["
            r3.append(r2)
            r3.append(r0)
            java.lang.String r2 = "]"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            android.util.Log.e(r1, r2)
        L37:
            r1 = -1
        L39:
            java.lang.String r3 = "Content-Range"
            java.lang.String r8 = r8.getHeaderField(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            if (r3 != 0) goto Ld6
            java.util.regex.Pattern r3 = com.google.android.gms.internal.ads.zzoq.b
            java.util.regex.Matcher r3 = r3.matcher(r8)
            boolean r4 = r3.find()
            if (r4 == 0) goto Ld6
            r4 = 2
            java.lang.String r4 = r3.group(r4)     // Catch: java.lang.NumberFormatException -> Lb0
            long r4 = java.lang.Long.parseLong(r4)     // Catch: java.lang.NumberFormatException -> Lb0
            r6 = 1
            java.lang.String r3 = r3.group(r6)     // Catch: java.lang.NumberFormatException -> Lb0
            long r6 = java.lang.Long.parseLong(r3)     // Catch: java.lang.NumberFormatException -> Lb0
            long r4 = r4 - r6
            r6 = 1
            long r3 = r4 + r6
            r5 = 0
            int r5 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r5 >= 0) goto L70
        L6e:
            r1 = r3
            goto Ld6
        L70:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Ld6
            java.lang.String r5 = "DefaultHttpDataSource"
            r6 = 26
            java.lang.String r7 = java.lang.String.valueOf(r0)     // Catch: java.lang.NumberFormatException -> Lb0
            int r7 = r7.length()     // Catch: java.lang.NumberFormatException -> Lb0
            int r6 = r6 + r7
            java.lang.String r7 = java.lang.String.valueOf(r8)     // Catch: java.lang.NumberFormatException -> Lb0
            int r7 = r7.length()     // Catch: java.lang.NumberFormatException -> Lb0
            int r6 = r6 + r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> Lb0
            r7.<init>(r6)     // Catch: java.lang.NumberFormatException -> Lb0
            java.lang.String r6 = "Inconsistent headers ["
            r7.append(r6)     // Catch: java.lang.NumberFormatException -> Lb0
            r7.append(r0)     // Catch: java.lang.NumberFormatException -> Lb0
            java.lang.String r0 = "] ["
            r7.append(r0)     // Catch: java.lang.NumberFormatException -> Lb0
            r7.append(r8)     // Catch: java.lang.NumberFormatException -> Lb0
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch: java.lang.NumberFormatException -> Lb0
            java.lang.String r0 = r7.toString()     // Catch: java.lang.NumberFormatException -> Lb0
            android.util.Log.w(r5, r0)     // Catch: java.lang.NumberFormatException -> Lb0
            long r3 = java.lang.Math.max(r1, r3)     // Catch: java.lang.NumberFormatException -> Lb0
            goto L6e
        Lb0:
            java.lang.String r0 = "DefaultHttpDataSource"
            r3 = 27
            java.lang.String r4 = java.lang.String.valueOf(r8)
            int r4 = r4.length()
            int r3 = r3 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Unexpected Content-Range ["
            r4.append(r3)
            r4.append(r8)
            java.lang.String r8 = "]"
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            android.util.Log.e(r0, r8)
        Ld6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoq.a(java.net.HttpURLConnection):long");
    }

    private final void d() {
        if (this.m != null) {
            try {
                this.m.disconnect();
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.m = null;
        }
    }
}
