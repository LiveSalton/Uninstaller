package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.zzd;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: source */
/* loaded from: classes.dex */
final class hc implements zzot {
    private static final Pattern b = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> c = new AtomicReference<>();
    private final int e;
    private final int f;
    private final String g;
    private final zzpd<? super hc> i;
    private zzoo j;
    private HttpURLConnection k;
    private InputStream l;
    private boolean m;
    private long n;
    private long o;
    private long p;
    private long q;
    private int r;
    private SSLSocketFactory d = new he(this);
    private Set<Socket> s = new HashSet();
    private final zzox h = new zzox();

    hc(String str, zzpd<? super hc> zzpdVar, int i, int i2, int i3) {
        this.g = zzpc.a(str);
        this.i = zzpdVar;
        this.e = i;
        this.f = i2;
        this.r = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final Uri a() {
        if (this.k == null) {
            return null;
        }
        return Uri.parse(this.k.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzot
    public final Map<String, List<String>> b() {
        if (this.k == null) {
            return null;
        }
        return this.k.getHeaderFields();
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0129, code lost:
    
        r24.k = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x012b, code lost:
    
        r3 = r24.k.getResponseCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0133, code lost:
    
        if (r3 < 200) goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0137, code lost:
    
        if (r3 <= 299) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x013a, code lost:
    
        if (r3 != 200) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x013c, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0142, code lost:
    
        if (r25.d == 0) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0144, code lost:
    
        r3 = r25.d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x014a, code lost:
    
        r24.n = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0151, code lost:
    
        if (r25.a(1) != false) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0159, code lost:
    
        if (r25.e == (-1)) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x015b, code lost:
    
        r24.o = r25.e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0176, code lost:
    
        r24.l = r24.k.getInputStream();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x017e, code lost:
    
        r24.m = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0183, code lost:
    
        if (r24.i == null) goto L215;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0185, code lost:
    
        r24.i.a((com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.hc>) r24, r25);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x018c, code lost:
    
        return r24.o;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x018d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x018e, code lost:
    
        d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0198, code lost:
    
        throw new com.google.android.gms.internal.ads.zzov(r0, r25, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0160, code lost:
    
        r3 = a(r24.k);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0168, code lost:
    
        if (r3 == (-1)) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x016a, code lost:
    
        r3 = r3 - r24.n;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x016f, code lost:
    
        r24.o = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x016e, code lost:
    
        r3 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0172, code lost:
    
        r24.o = r25.e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0149, code lost:
    
        r3 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0147, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0199, code lost:
    
        r4 = r24.k.getHeaderFields();
        d();
        r5 = new com.google.android.gms.internal.ads.zzou(r3, r4, r25);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01a9, code lost:
    
        if (r3 != 416) goto L271;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01ab, code lost:
    
        r5.initCause(new com.google.android.gms.internal.ads.zzop(0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01b4, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:?, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01b5, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01b6, code lost:
    
        d();
        r6 = java.lang.String.valueOf(r25.a.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01cc, code lost:
    
        if (r6.length() != 0) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01ce, code lost:
    
        r5 = "Unable to connect to ".concat(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01de, code lost:
    
        throw new com.google.android.gms.internal.ads.zzov(r5, r0, r25, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d4, code lost:
    
        r5 = new java.lang.String("Unable to connect to ");
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01f6 A[Catch: IOException -> 0x024c, TryCatch #2 {IOException -> 0x024c, blocks: (B:3:0x000d, B:4:0x0025, B:6:0x002b, B:8:0x0035, B:9:0x003d, B:10:0x0055, B:12:0x005b, B:20:0x00ce, B:22:0x00d7, B:23:0x00de, B:26:0x00e7, B:28:0x00ec, B:30:0x00f4, B:31:0x0109, B:46:0x0129, B:98:0x01e3, B:115:0x01ee, B:116:0x01f5, B:100:0x01f6, B:102:0x0207, B:105:0x020f, B:107:0x021d, B:108:0x0227, B:109:0x022a, B:110:0x0222, B:117:0x0106, B:119:0x0083, B:121:0x009f, B:122:0x00c9, B:125:0x0233, B:126:0x024b), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01ee A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d7 A[Catch: IOException -> 0x024c, TryCatch #2 {IOException -> 0x024c, blocks: (B:3:0x000d, B:4:0x0025, B:6:0x002b, B:8:0x0035, B:9:0x003d, B:10:0x0055, B:12:0x005b, B:20:0x00ce, B:22:0x00d7, B:23:0x00de, B:26:0x00e7, B:28:0x00ec, B:30:0x00f4, B:31:0x0109, B:46:0x0129, B:98:0x01e3, B:115:0x01ee, B:116:0x01f5, B:100:0x01f6, B:102:0x0207, B:105:0x020f, B:107:0x021d, B:108:0x0227, B:109:0x022a, B:110:0x0222, B:117:0x0106, B:119:0x0083, B:121:0x009f, B:122:0x00c9, B:125:0x0233, B:126:0x024b), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ec A[Catch: IOException -> 0x024c, TryCatch #2 {IOException -> 0x024c, blocks: (B:3:0x000d, B:4:0x0025, B:6:0x002b, B:8:0x0035, B:9:0x003d, B:10:0x0055, B:12:0x005b, B:20:0x00ce, B:22:0x00d7, B:23:0x00de, B:26:0x00e7, B:28:0x00ec, B:30:0x00f4, B:31:0x0109, B:46:0x0129, B:98:0x01e3, B:115:0x01ee, B:116:0x01f5, B:100:0x01f6, B:102:0x0207, B:105:0x020f, B:107:0x021d, B:108:0x0227, B:109:0x022a, B:110:0x0222, B:117:0x0106, B:119:0x0083, B:121:0x009f, B:122:0x00c9, B:125:0x0233, B:126:0x024b), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0111  */
    @Override // com.google.android.gms.internal.ads.zzon
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long a(com.google.android.gms.internal.ads.zzoo r25) throws com.google.android.gms.internal.ads.zzov {
        /*
            Method dump skipped, instructions count: 627
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.hc.a(com.google.android.gms.internal.ads.zzoo):long");
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final int a(byte[] bArr, int i, int i2) throws zzov {
        try {
            if (this.p != this.n) {
                byte[] andSet = c.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (this.p != this.n) {
                    int read = this.l.read(andSet, 0, (int) Math.min(this.n - this.p, andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.p += read;
                    if (this.i != null) {
                        this.i.a((zzpd<? super hc>) this, read);
                    }
                }
                c.set(andSet);
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.o != -1) {
                long j = this.o - this.q;
                if (j == 0) {
                    return -1;
                }
                i2 = (int) Math.min(i2, j);
            }
            int read2 = this.l.read(bArr, i, i2);
            if (read2 == -1) {
                if (this.o != -1) {
                    throw new EOFException();
                }
                return -1;
            }
            this.q += read2;
            if (this.i != null) {
                this.i.a((zzpd<? super hc>) this, read2);
            }
            return read2;
        } catch (IOException e) {
            throw new zzov(e, this.j, 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0038, code lost:
    
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
            java.io.InputStream r2 = r9.l     // Catch: java.lang.Throwable -> L95
            if (r2 == 0) goto L7b
            java.net.HttpURLConnection r2 = r9.k     // Catch: java.lang.Throwable -> L95
            long r3 = r9.o     // Catch: java.lang.Throwable -> L95
            r5 = -1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 != 0) goto L13
            long r3 = r9.o     // Catch: java.lang.Throwable -> L95
            goto L18
        L13:
            long r3 = r9.o     // Catch: java.lang.Throwable -> L95
            long r7 = r9.q     // Catch: java.lang.Throwable -> L95
            long r3 = r3 - r7
        L18:
            int r7 = com.google.android.gms.internal.ads.zzpt.a     // Catch: java.lang.Throwable -> L95
            r8 = 19
            if (r7 == r8) goto L24
            int r7 = com.google.android.gms.internal.ads.zzpt.a     // Catch: java.lang.Throwable -> L95
            r8 = 20
            if (r7 != r8) goto L6b
        L24:
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L95
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 != 0) goto L34
            int r3 = r2.read()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L95
            r4 = -1
            if (r3 != r4) goto L3a
            goto L6b
        L34:
            r5 = 2048(0x800, double:1.0118E-320)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L6b
        L3a:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L95
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L95
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L95
            if (r4 != 0) goto L52
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L95
            if (r3 == 0) goto L6b
        L52:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L95
            java.lang.Class r3 = r3.getSuperclass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L95
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L95
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L95
            r4 = 1
            r3.setAccessible(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L95
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L95
            r3.invoke(r2, r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L95
        L6b:
            java.io.InputStream r2 = r9.l     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L95
            r2.close()     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L95
            goto L7b
        L71:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzov r3 = new com.google.android.gms.internal.ads.zzov     // Catch: java.lang.Throwable -> L95
            com.google.android.gms.internal.ads.zzoo r4 = r9.j     // Catch: java.lang.Throwable -> L95
            r5 = 3
            r3.<init>(r2, r4, r5)     // Catch: java.lang.Throwable -> L95
            throw r3     // Catch: java.lang.Throwable -> L95
        L7b:
            r9.l = r0
            r9.d()
            boolean r0 = r9.m
            if (r0 == 0) goto L8f
            r9.m = r1
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.hc> r0 = r9.i
            if (r0 == 0) goto L8f
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.hc> r0 = r9.i
            r0.a(r9)
        L8f:
            java.util.Set<java.net.Socket> r0 = r9.s
            r0.clear()
            return
        L95:
            r2 = move-exception
            r9.l = r0
            r9.d()
            boolean r0 = r9.m
            if (r0 == 0) goto Laa
            r9.m = r1
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.hc> r0 = r9.i
            if (r0 == 0) goto Laa
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.hc> r0 = r9.i
            r0.a(r9)
        Laa:
            java.util.Set<java.net.Socket> r0 = r9.s
            r0.clear()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.hc.c():void");
    }

    final void a(int i) {
        this.r = i;
        for (Socket socket : this.s) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.r);
                } catch (SocketException e) {
                    zzd.d("Failed to update receive buffer size.", e);
                }
            }
        }
    }

    public final void a(Socket socket) {
        this.s.add(socket);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long a(java.net.HttpURLConnection r8) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r8.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L35
            long r1 = java.lang.Long.parseLong(r0)     // Catch: java.lang.NumberFormatException -> L11
            goto L37
        L11:
            r1 = 28
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Unexpected Content-Length ["
            r2.append(r1)
            r2.append(r0)
            java.lang.String r1 = "]"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.ads.internal.util.zzd.c(r1)
        L35:
            r1 = -1
        L37:
            java.lang.String r3 = "Content-Range"
            java.lang.String r8 = r8.getHeaderField(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            if (r3 != 0) goto Ld0
            java.util.regex.Pattern r3 = com.google.android.gms.internal.ads.hc.b
            java.util.regex.Matcher r3 = r3.matcher(r8)
            boolean r4 = r3.find()
            if (r4 == 0) goto Ld0
            r4 = 2
            java.lang.String r4 = r3.group(r4)     // Catch: java.lang.NumberFormatException -> Lac
            long r4 = java.lang.Long.parseLong(r4)     // Catch: java.lang.NumberFormatException -> Lac
            r6 = 1
            java.lang.String r3 = r3.group(r6)     // Catch: java.lang.NumberFormatException -> Lac
            long r6 = java.lang.Long.parseLong(r3)     // Catch: java.lang.NumberFormatException -> Lac
            long r4 = r4 - r6
            r6 = 1
            long r3 = r4 + r6
            r5 = 0
            int r5 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r5 >= 0) goto L6e
        L6c:
            r1 = r3
            goto Ld0
        L6e:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Ld0
            r5 = 26
            java.lang.String r6 = java.lang.String.valueOf(r0)     // Catch: java.lang.NumberFormatException -> Lac
            int r6 = r6.length()     // Catch: java.lang.NumberFormatException -> Lac
            int r5 = r5 + r6
            java.lang.String r6 = java.lang.String.valueOf(r8)     // Catch: java.lang.NumberFormatException -> Lac
            int r6 = r6.length()     // Catch: java.lang.NumberFormatException -> Lac
            int r5 = r5 + r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> Lac
            r6.<init>(r5)     // Catch: java.lang.NumberFormatException -> Lac
            java.lang.String r5 = "Inconsistent headers ["
            r6.append(r5)     // Catch: java.lang.NumberFormatException -> Lac
            r6.append(r0)     // Catch: java.lang.NumberFormatException -> Lac
            java.lang.String r0 = "] ["
            r6.append(r0)     // Catch: java.lang.NumberFormatException -> Lac
            r6.append(r8)     // Catch: java.lang.NumberFormatException -> Lac
            java.lang.String r0 = "]"
            r6.append(r0)     // Catch: java.lang.NumberFormatException -> Lac
            java.lang.String r0 = r6.toString()     // Catch: java.lang.NumberFormatException -> Lac
            com.google.android.gms.ads.internal.util.zzd.e(r0)     // Catch: java.lang.NumberFormatException -> Lac
            long r3 = java.lang.Math.max(r1, r3)     // Catch: java.lang.NumberFormatException -> Lac
            goto L6c
        Lac:
            r0 = 27
            java.lang.String r3 = java.lang.String.valueOf(r8)
            int r3 = r3.length()
            int r0 = r0 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r0 = "Unexpected Content-Range ["
            r3.append(r0)
            r3.append(r8)
            java.lang.String r8 = "]"
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            com.google.android.gms.ads.internal.util.zzd.c(r8)
        Ld0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.hc.a(java.net.HttpURLConnection):long");
    }

    private final void d() {
        if (this.k != null) {
            try {
                this.k.disconnect();
            } catch (Exception e) {
                zzd.c("Unexpected error while disconnecting", e);
            }
            this.k = null;
        }
    }
}
