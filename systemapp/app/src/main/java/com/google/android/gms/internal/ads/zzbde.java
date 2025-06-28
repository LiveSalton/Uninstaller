package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbde extends zzbcx {
    private static final Set<String> d = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat e = new DecimalFormat("#,###");
    private File f;
    private boolean g;

    public zzbde(zzbbe zzbbeVar) {
        super(zzbbeVar);
        File cacheDir = this.a.getCacheDir();
        if (cacheDir == null) {
            zzd.e("Context.getCacheDir() returned null");
            return;
        }
        this.f = new File(cacheDir, "admobVideoStreams");
        if (!this.f.isDirectory() && !this.f.mkdirs()) {
            String valueOf = String.valueOf(this.f.getAbsolutePath());
            zzd.e(valueOf.length() != 0 ? "Could not create preload cache directory at ".concat(valueOf) : new String("Could not create preload cache directory at "));
            this.f = null;
        } else {
            if (this.f.setReadable(true, false) && this.f.setExecutable(true, false)) {
                return;
            }
            String valueOf2 = String.valueOf(this.f.getAbsolutePath());
            zzd.e(valueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(valueOf2) : new String("Could not set cache file permissions at "));
            this.f = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:130:0x01fd, code lost:
    
        if ((r5 instanceof java.net.HttpURLConnection) == false) goto L413;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x01ff, code lost:
    
        r1 = r5.getResponseCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0208, code lost:
    
        if (r1 < 400) goto L413;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x020c, code lost:
    
        r4 = java.lang.String.valueOf(java.lang.Integer.toString(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x021a, code lost:
    
        if (r4.length() == 0) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x021c, code lost:
    
        r3 = "HTTP request failed. Code: ".concat(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0227, code lost:
    
        r6 = new java.lang.StringBuilder(32 + java.lang.String.valueOf(r33).length());
        r6.append("HTTP status code ");
        r6.append(r1);
        r6.append(" at ");
        r6.append(r33);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0250, code lost:
    
        throw new java.io.IOException(r6.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0251, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0252, code lost:
    
        r1 = r0;
        r4 = r3;
        r3 = "badUrl";
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x025a, code lost:
    
        r2 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0226, code lost:
    
        r3 = new java.lang.String("HTTP request failed. Code: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0256, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0257, code lost:
    
        r1 = r0;
        r3 = "badUrl";
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x025d, code lost:
    
        r7 = r5.getContentLength();
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0261, code lost:
    
        if (r7 >= 0) goto L421;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0263, code lost:
    
        r2 = java.lang.String.valueOf(r33);
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x026d, code lost:
    
        if (r2.length() == 0) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x026f, code lost:
    
        r1 = "Stream cache aborted, missing content-length header at ".concat(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x027a, code lost:
    
        com.google.android.gms.ads.internal.util.zzd.e(r1);
        a(r33, r12.getAbsolutePath(), "contentLengthMissing", null);
        com.google.android.gms.internal.ads.zzbde.d.remove(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x028b, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0274, code lost:
    
        r1 = new java.lang.String("Stream cache aborted, missing content-length header at ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x028c, code lost:
    
        r1 = com.google.android.gms.internal.ads.zzbde.e.format(r7);
        r3 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzwq.e().a(com.google.android.gms.internal.ads.zzabf.m)).intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x02a3, code lost:
    
        if (r7 <= r3) goto L430;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02a7, code lost:
    
        r3 = new java.lang.StringBuilder((33 + java.lang.String.valueOf(r1).length()) + java.lang.String.valueOf(r33).length());
        r3.append("Content length ");
        r3.append(r1);
        r3.append(" exceeds limit at ");
        r3.append(r33);
        com.google.android.gms.ads.internal.util.zzd.e(r3.toString());
        r1 = java.lang.String.valueOf(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x02df, code lost:
    
        if (r1.length() == 0) goto L427;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x02e1, code lost:
    
        r1 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x02eb, code lost:
    
        a(r33, r12.getAbsolutePath(), "sizeExceeded", r1);
        com.google.android.gms.internal.ads.zzbde.d.remove(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x02f9, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02e6, code lost:
    
        r1 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x02fa, code lost:
    
        r2 = new java.lang.StringBuilder((20 + java.lang.String.valueOf(r1).length()) + java.lang.String.valueOf(r33).length());
        r2.append("Caching ");
        r2.append(r1);
        r2.append(" bytes from ");
        r2.append(r33);
        com.google.android.gms.ads.internal.util.zzd.b(r2.toString());
        r5 = java.nio.channels.Channels.newChannel(r5.getInputStream());
        r4 = new java.io.FileOutputStream(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0335, code lost:
    
        r2 = r4.getChannel();
        r1 = java.nio.ByteBuffer.allocate(1048576);
        r10 = com.google.android.gms.ads.internal.zzp.j();
        r17 = r10.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0353, code lost:
    
        r20 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0355, code lost:
    
        r11 = new com.google.android.gms.ads.internal.util.zzbs(((java.lang.Long) com.google.android.gms.internal.ads.zzwq.e().a(com.google.android.gms.internal.ads.zzabf.p)).longValue());
        r14 = ((java.lang.Long) com.google.android.gms.internal.ads.zzwq.e().a(com.google.android.gms.internal.ads.zzabf.o)).longValue();
        r6 = 0;
        r1 = r1;
        r2 = r2;
        r5 = r5;
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x036f, code lost:
    
        r21 = r5.read(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0373, code lost:
    
        if (r21 < 0) goto L585;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0375, code lost:
    
        r6 = r6 + r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0377, code lost:
    
        if (r6 <= r3) goto L552;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x03bd, code lost:
    
        r1.flip();
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x03c4, code lost:
    
        if (r2.write(r1) > 0) goto L477;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x03c6, code lost:
    
        r1.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x03d5, code lost:
    
        if ((r10.a() - r17) <= (1000 * r14)) goto L463;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0406, code lost:
    
        r25 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x040a, code lost:
    
        if (r32.g == false) goto L469;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x041a, code lost:
    
        if (r11.a() == false) goto L475;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x041c, code lost:
    
        r26 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0426, code lost:
    
        r27 = r11;
        r23 = r25;
        r24 = r2;
        r25 = r3;
        r28 = r14;
        r14 = r4;
        r19 = r6;
        r30 = r5;
        r21 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0445, code lost:
    
        com.google.android.gms.internal.ads.zzayr.a.post(new com.google.android.gms.internal.ads.ht(r32, r33, r12.getAbsolutePath(), r6, r7, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0460, code lost:
    
        r4 = r14;
        r6 = r19;
        r7 = r21;
        r1 = r23;
        r2 = r24;
        r3 = r25;
        r10 = r26;
        r11 = r27;
        r14 = r28;
        r5 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x04c2, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x047b, code lost:
    
        r1 = r0;
        r10 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x03b7, code lost:
    
        r3 = "error";
        r2 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x044c, code lost:
    
        r24 = r2;
        r30 = r5;
        r19 = r6;
        r21 = r7;
        r26 = r10;
        r27 = r11;
        r28 = r14;
        r23 = r25;
        r25 = r3;
        r14 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0415, code lost:
    
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x03d9, code lost:
    
        r2 = java.lang.Long.toString(r14);
        r5 = new java.lang.StringBuilder(29 + java.lang.String.valueOf(r2).length());
        r5.append("Timeout exceeded. Limit: ");
        r5.append(r2);
        r5.append(" sec");
        r5.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x0405, code lost:
    
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x0479, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x047a, code lost:
    
        r14 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x037b, code lost:
    
        r3 = java.lang.String.valueOf(java.lang.Integer.toString(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0389, code lost:
    
        if (r3.length() == 0) goto L442;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x038b, code lost:
    
        r2 = "File too big for full file cache. Size: ".concat(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x039e, code lost:
    
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0391, code lost:
    
        new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x039f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x03a0, code lost:
    
        r3 = r1;
        r2 = r20;
        r1 = r0;
        r31 = r10;
        r10 = r4;
        r4 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x03ab, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x03ac, code lost:
    
        r3 = r1;
        r10 = r4;
        r2 = r20;
        r4 = null;
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x047f, code lost:
    
        r14 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0481, code lost:
    
        r14.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0488, code lost:
    
        if (com.google.android.gms.ads.internal.util.zzd.a(3) == false) goto L488;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x048a, code lost:
    
        r1 = com.google.android.gms.internal.ads.zzbde.e.format(r6);
        r3 = new java.lang.StringBuilder((22 + java.lang.String.valueOf(r1).length()) + java.lang.String.valueOf(r33).length());
        r3.append("Preloaded ");
        r3.append(r1);
        r3.append(" bytes from ");
        r3.append(r33);
        com.google.android.gms.ads.internal.util.zzd.b(r3.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x04c6, code lost:
    
        r12.setReadable(true, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x04cd, code lost:
    
        if (r13.isFile() == false) goto L543;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x04cf, code lost:
    
        r13.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x04d7, code lost:
    
        r13.createNewFile();
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x04ec, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x04f0, code lost:
    
        r2 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x04ee, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x04ef, code lost:
    
        r14 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x04f3, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x04f4, code lost:
    
        r14 = r4;
        r2 = r15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0547  */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v6, types: [com.google.android.gms.common.util.Clock] */
    /* JADX WARN: Type inference failed for: r1v107 */
    /* JADX WARN: Type inference failed for: r1v46, types: [java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r1v66 */
    /* JADX WARN: Type inference failed for: r2v33, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r5v20, types: [java.nio.channels.ReadableByteChannel] */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    @Override // com.google.android.gms.internal.ads.zzbcx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(java.lang.String r33) {
        /*
            Method dump skipped, instructions count: 1447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbde.a(java.lang.String):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzbcx
    public final void a() {
        this.g = true;
    }

    private final File a(File file) {
        return new File(this.f, String.valueOf(file.getName()).concat(".done"));
    }
}
