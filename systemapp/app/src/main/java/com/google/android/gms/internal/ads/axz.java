package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
final class axz implements Handler.Callback, zznb, zznd, zzog {
    private int A;
    private aya B;
    private long C;
    private axy D;
    private axy E;
    private axy F;
    private zzhz G;
    private final zzhy[] a;
    private final zzhx[] b;
    private final zzoh c;
    private final zzht d;
    private final zzpo e;
    private final Handler f;
    private final HandlerThread g;
    private final Handler h;
    private final zzhd i;
    private final zzie j;
    private final zzib k;
    private zzho l;
    private zzhv m;
    private zzhy n;
    private zzpg o;
    private zzna p;
    private zzhy[] q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int x;
    private int y;
    private long z;
    private int w = 0;
    private int v = 1;

    public axz(zzhy[] zzhyVarArr, zzoh zzohVar, zzht zzhtVar, boolean z, int i, Handler handler, zzho zzhoVar, zzhd zzhdVar) {
        this.a = zzhyVarArr;
        this.c = zzohVar;
        this.d = zzhtVar;
        this.s = z;
        this.h = handler;
        this.l = zzhoVar;
        this.i = zzhdVar;
        this.b = new zzhx[zzhyVarArr.length];
        for (int i2 = 0; i2 < zzhyVarArr.length; i2++) {
            zzhyVarArr[i2].a(i2);
            this.b[i2] = zzhyVarArr[i2].b();
        }
        this.e = new zzpo();
        this.q = new zzhy[0];
        this.j = new zzie();
        this.k = new zzib();
        zzohVar.a((zzog) this);
        this.m = zzhv.a;
        this.g = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.g.start();
        this.f = new Handler(this.g.getLooper(), this);
    }

    public final void a(zzna zznaVar, boolean z) {
        this.f.obtainMessage(0, 1, 0, zznaVar).sendToTarget();
    }

    public final void a(boolean z) {
        this.f.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public final void a(zzhz zzhzVar, int i, long j) {
        this.f.obtainMessage(3, new aya(zzhzVar, i, j)).sendToTarget();
    }

    public final void a() {
        this.f.sendEmptyMessage(5);
    }

    public final void a(zzhi... zzhiVarArr) {
        if (this.r) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        } else {
            this.x++;
            this.f.obtainMessage(11, zzhiVarArr).sendToTarget();
        }
    }

    public final synchronized void b(zzhi... zzhiVarArr) {
        if (this.r) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        int i = this.x;
        this.x = i + 1;
        this.f.obtainMessage(11, zzhiVarArr).sendToTarget();
        while (this.y <= i) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public final synchronized void b() {
        if (this.r) {
            return;
        }
        this.f.sendEmptyMessage(6);
        while (!this.r) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        this.g.quit();
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final void a(zzhz zzhzVar, Object obj) {
        this.f.obtainMessage(7, Pair.create(zzhzVar, obj)).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zznb
    public final void a(zzmy zzmyVar) {
        this.f.obtainMessage(8, zzmyVar).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzog
    public final void c() {
        this.f.sendEmptyMessage(10);
    }

    /* JADX WARN: Removed duplicated region for block: B:182:0x028f A[Catch: IOException -> 0x08a7, zzhe -> 0x08ac, RuntimeException -> 0x08b1, TryCatch #2 {RuntimeException -> 0x08b1, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:279:0x0437, B:282:0x0445, B:287:0x0450, B:288:0x0463, B:290:0x0464, B:292:0x046c, B:293:0x06cf, B:295:0x06d5, B:297:0x06dd, B:299:0x06f8, B:301:0x0703, B:304:0x070c, B:306:0x0712, B:311:0x071e, B:316:0x0728, B:323:0x072f, B:324:0x0732, B:326:0x0736, B:328:0x0744, B:329:0x0757, B:333:0x0770, B:335:0x0778, B:337:0x077e, B:338:0x0808, B:340:0x080c, B:342:0x0811, B:344:0x0819, B:346:0x081d, B:350:0x082b, B:351:0x083f, B:352:0x0826, B:355:0x082f, B:357:0x0834, B:358:0x083a, B:359:0x0788, B:361:0x078d, B:364:0x0794, B:366:0x079c, B:369:0x07af, B:375:0x07e1, B:377:0x07e9, B:378:0x07b7, B:379:0x07c5, B:380:0x07a1, B:382:0x07db, B:383:0x07ed, B:385:0x07f2, B:389:0x07fe, B:390:0x07f8, B:391:0x0474, B:393:0x0478, B:394:0x04bb, B:396:0x04c3, B:398:0x059c, B:400:0x05a0, B:403:0x05a9, B:405:0x05ad, B:407:0x05b1, B:408:0x05b8, B:410:0x05bc, B:412:0x05c2, B:414:0x05ce, B:416:0x05f9, B:419:0x0600, B:421:0x0605, B:423:0x0611, B:425:0x0617, B:427:0x061d, B:429:0x0620, B:435:0x0624, B:437:0x0629, B:440:0x063b, B:445:0x0643, B:449:0x0646, B:451:0x064c, B:453:0x0654, B:457:0x0677, B:459:0x067c, B:462:0x068a, B:464:0x0690, B:466:0x06a0, B:468:0x06a6, B:469:0x06ad, B:471:0x06b0, B:473:0x06b9, B:477:0x06c9, B:475:0x06cc, B:483:0x05b5, B:484:0x04cb, B:486:0x04cf, B:488:0x0529, B:490:0x052d, B:492:0x054a, B:495:0x0558, B:497:0x058c, B:498:0x0590, B:499:0x0551, B:500:0x0534, B:501:0x04d5, B:504:0x04e6, B:506:0x0518, B:507:0x047d, B:509:0x0487, B:511:0x048f, B:514:0x049e, B:516:0x04a2, B:518:0x04af, B:519:0x0843, B:522:0x084b, B:524:0x0851, B:526:0x0858, B:528:0x085d, B:529:0x0866, B:531:0x086a, B:533:0x0870, B:536:0x087c, B:538:0x088b, B:539:0x0897), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0296 A[Catch: IOException -> 0x08a7, zzhe -> 0x08ac, RuntimeException -> 0x08b1, TryCatch #2 {RuntimeException -> 0x08b1, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:279:0x0437, B:282:0x0445, B:287:0x0450, B:288:0x0463, B:290:0x0464, B:292:0x046c, B:293:0x06cf, B:295:0x06d5, B:297:0x06dd, B:299:0x06f8, B:301:0x0703, B:304:0x070c, B:306:0x0712, B:311:0x071e, B:316:0x0728, B:323:0x072f, B:324:0x0732, B:326:0x0736, B:328:0x0744, B:329:0x0757, B:333:0x0770, B:335:0x0778, B:337:0x077e, B:338:0x0808, B:340:0x080c, B:342:0x0811, B:344:0x0819, B:346:0x081d, B:350:0x082b, B:351:0x083f, B:352:0x0826, B:355:0x082f, B:357:0x0834, B:358:0x083a, B:359:0x0788, B:361:0x078d, B:364:0x0794, B:366:0x079c, B:369:0x07af, B:375:0x07e1, B:377:0x07e9, B:378:0x07b7, B:379:0x07c5, B:380:0x07a1, B:382:0x07db, B:383:0x07ed, B:385:0x07f2, B:389:0x07fe, B:390:0x07f8, B:391:0x0474, B:393:0x0478, B:394:0x04bb, B:396:0x04c3, B:398:0x059c, B:400:0x05a0, B:403:0x05a9, B:405:0x05ad, B:407:0x05b1, B:408:0x05b8, B:410:0x05bc, B:412:0x05c2, B:414:0x05ce, B:416:0x05f9, B:419:0x0600, B:421:0x0605, B:423:0x0611, B:425:0x0617, B:427:0x061d, B:429:0x0620, B:435:0x0624, B:437:0x0629, B:440:0x063b, B:445:0x0643, B:449:0x0646, B:451:0x064c, B:453:0x0654, B:457:0x0677, B:459:0x067c, B:462:0x068a, B:464:0x0690, B:466:0x06a0, B:468:0x06a6, B:469:0x06ad, B:471:0x06b0, B:473:0x06b9, B:477:0x06c9, B:475:0x06cc, B:483:0x05b5, B:484:0x04cb, B:486:0x04cf, B:488:0x0529, B:490:0x052d, B:492:0x054a, B:495:0x0558, B:497:0x058c, B:498:0x0590, B:499:0x0551, B:500:0x0534, B:501:0x04d5, B:504:0x04e6, B:506:0x0518, B:507:0x047d, B:509:0x0487, B:511:0x048f, B:514:0x049e, B:516:0x04a2, B:518:0x04af, B:519:0x0843, B:522:0x084b, B:524:0x0851, B:526:0x0858, B:528:0x085d, B:529:0x0866, B:531:0x086a, B:533:0x0870, B:536:0x087c, B:538:0x088b, B:539:0x0897), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0292 A[Catch: IOException -> 0x08a7, zzhe -> 0x08ac, RuntimeException -> 0x08b1, TryCatch #2 {RuntimeException -> 0x08b1, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:279:0x0437, B:282:0x0445, B:287:0x0450, B:288:0x0463, B:290:0x0464, B:292:0x046c, B:293:0x06cf, B:295:0x06d5, B:297:0x06dd, B:299:0x06f8, B:301:0x0703, B:304:0x070c, B:306:0x0712, B:311:0x071e, B:316:0x0728, B:323:0x072f, B:324:0x0732, B:326:0x0736, B:328:0x0744, B:329:0x0757, B:333:0x0770, B:335:0x0778, B:337:0x077e, B:338:0x0808, B:340:0x080c, B:342:0x0811, B:344:0x0819, B:346:0x081d, B:350:0x082b, B:351:0x083f, B:352:0x0826, B:355:0x082f, B:357:0x0834, B:358:0x083a, B:359:0x0788, B:361:0x078d, B:364:0x0794, B:366:0x079c, B:369:0x07af, B:375:0x07e1, B:377:0x07e9, B:378:0x07b7, B:379:0x07c5, B:380:0x07a1, B:382:0x07db, B:383:0x07ed, B:385:0x07f2, B:389:0x07fe, B:390:0x07f8, B:391:0x0474, B:393:0x0478, B:394:0x04bb, B:396:0x04c3, B:398:0x059c, B:400:0x05a0, B:403:0x05a9, B:405:0x05ad, B:407:0x05b1, B:408:0x05b8, B:410:0x05bc, B:412:0x05c2, B:414:0x05ce, B:416:0x05f9, B:419:0x0600, B:421:0x0605, B:423:0x0611, B:425:0x0617, B:427:0x061d, B:429:0x0620, B:435:0x0624, B:437:0x0629, B:440:0x063b, B:445:0x0643, B:449:0x0646, B:451:0x064c, B:453:0x0654, B:457:0x0677, B:459:0x067c, B:462:0x068a, B:464:0x0690, B:466:0x06a0, B:468:0x06a6, B:469:0x06ad, B:471:0x06b0, B:473:0x06b9, B:477:0x06c9, B:475:0x06cc, B:483:0x05b5, B:484:0x04cb, B:486:0x04cf, B:488:0x0529, B:490:0x052d, B:492:0x054a, B:495:0x0558, B:497:0x058c, B:498:0x0590, B:499:0x0551, B:500:0x0534, B:501:0x04d5, B:504:0x04e6, B:506:0x0518, B:507:0x047d, B:509:0x0487, B:511:0x048f, B:514:0x049e, B:516:0x04a2, B:518:0x04af, B:519:0x0843, B:522:0x084b, B:524:0x0851, B:526:0x0858, B:528:0x085d, B:529:0x0866, B:531:0x086a, B:533:0x0870, B:536:0x087c, B:538:0x088b, B:539:0x0897), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x071e A[Catch: IOException -> 0x08a7, zzhe -> 0x08ac, RuntimeException -> 0x08b1, TryCatch #2 {RuntimeException -> 0x08b1, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:279:0x0437, B:282:0x0445, B:287:0x0450, B:288:0x0463, B:290:0x0464, B:292:0x046c, B:293:0x06cf, B:295:0x06d5, B:297:0x06dd, B:299:0x06f8, B:301:0x0703, B:304:0x070c, B:306:0x0712, B:311:0x071e, B:316:0x0728, B:323:0x072f, B:324:0x0732, B:326:0x0736, B:328:0x0744, B:329:0x0757, B:333:0x0770, B:335:0x0778, B:337:0x077e, B:338:0x0808, B:340:0x080c, B:342:0x0811, B:344:0x0819, B:346:0x081d, B:350:0x082b, B:351:0x083f, B:352:0x0826, B:355:0x082f, B:357:0x0834, B:358:0x083a, B:359:0x0788, B:361:0x078d, B:364:0x0794, B:366:0x079c, B:369:0x07af, B:375:0x07e1, B:377:0x07e9, B:378:0x07b7, B:379:0x07c5, B:380:0x07a1, B:382:0x07db, B:383:0x07ed, B:385:0x07f2, B:389:0x07fe, B:390:0x07f8, B:391:0x0474, B:393:0x0478, B:394:0x04bb, B:396:0x04c3, B:398:0x059c, B:400:0x05a0, B:403:0x05a9, B:405:0x05ad, B:407:0x05b1, B:408:0x05b8, B:410:0x05bc, B:412:0x05c2, B:414:0x05ce, B:416:0x05f9, B:419:0x0600, B:421:0x0605, B:423:0x0611, B:425:0x0617, B:427:0x061d, B:429:0x0620, B:435:0x0624, B:437:0x0629, B:440:0x063b, B:445:0x0643, B:449:0x0646, B:451:0x064c, B:453:0x0654, B:457:0x0677, B:459:0x067c, B:462:0x068a, B:464:0x0690, B:466:0x06a0, B:468:0x06a6, B:469:0x06ad, B:471:0x06b0, B:473:0x06b9, B:477:0x06c9, B:475:0x06cc, B:483:0x05b5, B:484:0x04cb, B:486:0x04cf, B:488:0x0529, B:490:0x052d, B:492:0x054a, B:495:0x0558, B:497:0x058c, B:498:0x0590, B:499:0x0551, B:500:0x0534, B:501:0x04d5, B:504:0x04e6, B:506:0x0518, B:507:0x047d, B:509:0x0487, B:511:0x048f, B:514:0x049e, B:516:0x04a2, B:518:0x04af, B:519:0x0843, B:522:0x084b, B:524:0x0851, B:526:0x0858, B:528:0x085d, B:529:0x0866, B:531:0x086a, B:533:0x0870, B:536:0x087c, B:538:0x088b, B:539:0x0897), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:373:0x07d7  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x05a0 A[Catch: IOException -> 0x08a7, zzhe -> 0x08ac, RuntimeException -> 0x08b1, TryCatch #2 {RuntimeException -> 0x08b1, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:279:0x0437, B:282:0x0445, B:287:0x0450, B:288:0x0463, B:290:0x0464, B:292:0x046c, B:293:0x06cf, B:295:0x06d5, B:297:0x06dd, B:299:0x06f8, B:301:0x0703, B:304:0x070c, B:306:0x0712, B:311:0x071e, B:316:0x0728, B:323:0x072f, B:324:0x0732, B:326:0x0736, B:328:0x0744, B:329:0x0757, B:333:0x0770, B:335:0x0778, B:337:0x077e, B:338:0x0808, B:340:0x080c, B:342:0x0811, B:344:0x0819, B:346:0x081d, B:350:0x082b, B:351:0x083f, B:352:0x0826, B:355:0x082f, B:357:0x0834, B:358:0x083a, B:359:0x0788, B:361:0x078d, B:364:0x0794, B:366:0x079c, B:369:0x07af, B:375:0x07e1, B:377:0x07e9, B:378:0x07b7, B:379:0x07c5, B:380:0x07a1, B:382:0x07db, B:383:0x07ed, B:385:0x07f2, B:389:0x07fe, B:390:0x07f8, B:391:0x0474, B:393:0x0478, B:394:0x04bb, B:396:0x04c3, B:398:0x059c, B:400:0x05a0, B:403:0x05a9, B:405:0x05ad, B:407:0x05b1, B:408:0x05b8, B:410:0x05bc, B:412:0x05c2, B:414:0x05ce, B:416:0x05f9, B:419:0x0600, B:421:0x0605, B:423:0x0611, B:425:0x0617, B:427:0x061d, B:429:0x0620, B:435:0x0624, B:437:0x0629, B:440:0x063b, B:445:0x0643, B:449:0x0646, B:451:0x064c, B:453:0x0654, B:457:0x0677, B:459:0x067c, B:462:0x068a, B:464:0x0690, B:466:0x06a0, B:468:0x06a6, B:469:0x06ad, B:471:0x06b0, B:473:0x06b9, B:477:0x06c9, B:475:0x06cc, B:483:0x05b5, B:484:0x04cb, B:486:0x04cf, B:488:0x0529, B:490:0x052d, B:492:0x054a, B:495:0x0558, B:497:0x058c, B:498:0x0590, B:499:0x0551, B:500:0x0534, B:501:0x04d5, B:504:0x04e6, B:506:0x0518, B:507:0x047d, B:509:0x0487, B:511:0x048f, B:514:0x049e, B:516:0x04a2, B:518:0x04af, B:519:0x0843, B:522:0x084b, B:524:0x0851, B:526:0x0858, B:528:0x085d, B:529:0x0866, B:531:0x086a, B:533:0x0870, B:536:0x087c, B:538:0x088b, B:539:0x0897), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:410:0x05bc A[Catch: IOException -> 0x08a7, zzhe -> 0x08ac, RuntimeException -> 0x08b1, LOOP:9: B:410:0x05bc->B:414:0x05ce, LOOP_START, TryCatch #2 {RuntimeException -> 0x08b1, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:279:0x0437, B:282:0x0445, B:287:0x0450, B:288:0x0463, B:290:0x0464, B:292:0x046c, B:293:0x06cf, B:295:0x06d5, B:297:0x06dd, B:299:0x06f8, B:301:0x0703, B:304:0x070c, B:306:0x0712, B:311:0x071e, B:316:0x0728, B:323:0x072f, B:324:0x0732, B:326:0x0736, B:328:0x0744, B:329:0x0757, B:333:0x0770, B:335:0x0778, B:337:0x077e, B:338:0x0808, B:340:0x080c, B:342:0x0811, B:344:0x0819, B:346:0x081d, B:350:0x082b, B:351:0x083f, B:352:0x0826, B:355:0x082f, B:357:0x0834, B:358:0x083a, B:359:0x0788, B:361:0x078d, B:364:0x0794, B:366:0x079c, B:369:0x07af, B:375:0x07e1, B:377:0x07e9, B:378:0x07b7, B:379:0x07c5, B:380:0x07a1, B:382:0x07db, B:383:0x07ed, B:385:0x07f2, B:389:0x07fe, B:390:0x07f8, B:391:0x0474, B:393:0x0478, B:394:0x04bb, B:396:0x04c3, B:398:0x059c, B:400:0x05a0, B:403:0x05a9, B:405:0x05ad, B:407:0x05b1, B:408:0x05b8, B:410:0x05bc, B:412:0x05c2, B:414:0x05ce, B:416:0x05f9, B:419:0x0600, B:421:0x0605, B:423:0x0611, B:425:0x0617, B:427:0x061d, B:429:0x0620, B:435:0x0624, B:437:0x0629, B:440:0x063b, B:445:0x0643, B:449:0x0646, B:451:0x064c, B:453:0x0654, B:457:0x0677, B:459:0x067c, B:462:0x068a, B:464:0x0690, B:466:0x06a0, B:468:0x06a6, B:469:0x06ad, B:471:0x06b0, B:473:0x06b9, B:477:0x06c9, B:475:0x06cc, B:483:0x05b5, B:484:0x04cb, B:486:0x04cf, B:488:0x0529, B:490:0x052d, B:492:0x054a, B:495:0x0558, B:497:0x058c, B:498:0x0590, B:499:0x0551, B:500:0x0534, B:501:0x04d5, B:504:0x04e6, B:506:0x0518, B:507:0x047d, B:509:0x0487, B:511:0x048f, B:514:0x049e, B:516:0x04a2, B:518:0x04af, B:519:0x0843, B:522:0x084b, B:524:0x0851, B:526:0x0858, B:528:0x085d, B:529:0x0866, B:531:0x086a, B:533:0x0870, B:536:0x087c, B:538:0x088b, B:539:0x0897), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:490:0x052d A[Catch: IOException -> 0x08a7, zzhe -> 0x08ac, RuntimeException -> 0x08b1, TryCatch #2 {RuntimeException -> 0x08b1, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:279:0x0437, B:282:0x0445, B:287:0x0450, B:288:0x0463, B:290:0x0464, B:292:0x046c, B:293:0x06cf, B:295:0x06d5, B:297:0x06dd, B:299:0x06f8, B:301:0x0703, B:304:0x070c, B:306:0x0712, B:311:0x071e, B:316:0x0728, B:323:0x072f, B:324:0x0732, B:326:0x0736, B:328:0x0744, B:329:0x0757, B:333:0x0770, B:335:0x0778, B:337:0x077e, B:338:0x0808, B:340:0x080c, B:342:0x0811, B:344:0x0819, B:346:0x081d, B:350:0x082b, B:351:0x083f, B:352:0x0826, B:355:0x082f, B:357:0x0834, B:358:0x083a, B:359:0x0788, B:361:0x078d, B:364:0x0794, B:366:0x079c, B:369:0x07af, B:375:0x07e1, B:377:0x07e9, B:378:0x07b7, B:379:0x07c5, B:380:0x07a1, B:382:0x07db, B:383:0x07ed, B:385:0x07f2, B:389:0x07fe, B:390:0x07f8, B:391:0x0474, B:393:0x0478, B:394:0x04bb, B:396:0x04c3, B:398:0x059c, B:400:0x05a0, B:403:0x05a9, B:405:0x05ad, B:407:0x05b1, B:408:0x05b8, B:410:0x05bc, B:412:0x05c2, B:414:0x05ce, B:416:0x05f9, B:419:0x0600, B:421:0x0605, B:423:0x0611, B:425:0x0617, B:427:0x061d, B:429:0x0620, B:435:0x0624, B:437:0x0629, B:440:0x063b, B:445:0x0643, B:449:0x0646, B:451:0x064c, B:453:0x0654, B:457:0x0677, B:459:0x067c, B:462:0x068a, B:464:0x0690, B:466:0x06a0, B:468:0x06a6, B:469:0x06ad, B:471:0x06b0, B:473:0x06b9, B:477:0x06c9, B:475:0x06cc, B:483:0x05b5, B:484:0x04cb, B:486:0x04cf, B:488:0x0529, B:490:0x052d, B:492:0x054a, B:495:0x0558, B:497:0x058c, B:498:0x0590, B:499:0x0551, B:500:0x0534, B:501:0x04d5, B:504:0x04e6, B:506:0x0518, B:507:0x047d, B:509:0x0487, B:511:0x048f, B:514:0x049e, B:516:0x04a2, B:518:0x04af, B:519:0x0843, B:522:0x084b, B:524:0x0851, B:526:0x0858, B:528:0x085d, B:529:0x0866, B:531:0x086a, B:533:0x0870, B:536:0x087c, B:538:0x088b, B:539:0x0897), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:494:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:497:0x058c A[Catch: IOException -> 0x08a7, zzhe -> 0x08ac, RuntimeException -> 0x08b1, TryCatch #2 {RuntimeException -> 0x08b1, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:279:0x0437, B:282:0x0445, B:287:0x0450, B:288:0x0463, B:290:0x0464, B:292:0x046c, B:293:0x06cf, B:295:0x06d5, B:297:0x06dd, B:299:0x06f8, B:301:0x0703, B:304:0x070c, B:306:0x0712, B:311:0x071e, B:316:0x0728, B:323:0x072f, B:324:0x0732, B:326:0x0736, B:328:0x0744, B:329:0x0757, B:333:0x0770, B:335:0x0778, B:337:0x077e, B:338:0x0808, B:340:0x080c, B:342:0x0811, B:344:0x0819, B:346:0x081d, B:350:0x082b, B:351:0x083f, B:352:0x0826, B:355:0x082f, B:357:0x0834, B:358:0x083a, B:359:0x0788, B:361:0x078d, B:364:0x0794, B:366:0x079c, B:369:0x07af, B:375:0x07e1, B:377:0x07e9, B:378:0x07b7, B:379:0x07c5, B:380:0x07a1, B:382:0x07db, B:383:0x07ed, B:385:0x07f2, B:389:0x07fe, B:390:0x07f8, B:391:0x0474, B:393:0x0478, B:394:0x04bb, B:396:0x04c3, B:398:0x059c, B:400:0x05a0, B:403:0x05a9, B:405:0x05ad, B:407:0x05b1, B:408:0x05b8, B:410:0x05bc, B:412:0x05c2, B:414:0x05ce, B:416:0x05f9, B:419:0x0600, B:421:0x0605, B:423:0x0611, B:425:0x0617, B:427:0x061d, B:429:0x0620, B:435:0x0624, B:437:0x0629, B:440:0x063b, B:445:0x0643, B:449:0x0646, B:451:0x064c, B:453:0x0654, B:457:0x0677, B:459:0x067c, B:462:0x068a, B:464:0x0690, B:466:0x06a0, B:468:0x06a6, B:469:0x06ad, B:471:0x06b0, B:473:0x06b9, B:477:0x06c9, B:475:0x06cc, B:483:0x05b5, B:484:0x04cb, B:486:0x04cf, B:488:0x0529, B:490:0x052d, B:492:0x054a, B:495:0x0558, B:497:0x058c, B:498:0x0590, B:499:0x0551, B:500:0x0534, B:501:0x04d5, B:504:0x04e6, B:506:0x0518, B:507:0x047d, B:509:0x0487, B:511:0x048f, B:514:0x049e, B:516:0x04a2, B:518:0x04af, B:519:0x0843, B:522:0x084b, B:524:0x0851, B:526:0x0858, B:528:0x085d, B:529:0x0866, B:531:0x086a, B:533:0x0870, B:536:0x087c, B:538:0x088b, B:539:0x0897), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:499:0x0551 A[Catch: IOException -> 0x08a7, zzhe -> 0x08ac, RuntimeException -> 0x08b1, TryCatch #2 {RuntimeException -> 0x08b1, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:279:0x0437, B:282:0x0445, B:287:0x0450, B:288:0x0463, B:290:0x0464, B:292:0x046c, B:293:0x06cf, B:295:0x06d5, B:297:0x06dd, B:299:0x06f8, B:301:0x0703, B:304:0x070c, B:306:0x0712, B:311:0x071e, B:316:0x0728, B:323:0x072f, B:324:0x0732, B:326:0x0736, B:328:0x0744, B:329:0x0757, B:333:0x0770, B:335:0x0778, B:337:0x077e, B:338:0x0808, B:340:0x080c, B:342:0x0811, B:344:0x0819, B:346:0x081d, B:350:0x082b, B:351:0x083f, B:352:0x0826, B:355:0x082f, B:357:0x0834, B:358:0x083a, B:359:0x0788, B:361:0x078d, B:364:0x0794, B:366:0x079c, B:369:0x07af, B:375:0x07e1, B:377:0x07e9, B:378:0x07b7, B:379:0x07c5, B:380:0x07a1, B:382:0x07db, B:383:0x07ed, B:385:0x07f2, B:389:0x07fe, B:390:0x07f8, B:391:0x0474, B:393:0x0478, B:394:0x04bb, B:396:0x04c3, B:398:0x059c, B:400:0x05a0, B:403:0x05a9, B:405:0x05ad, B:407:0x05b1, B:408:0x05b8, B:410:0x05bc, B:412:0x05c2, B:414:0x05ce, B:416:0x05f9, B:419:0x0600, B:421:0x0605, B:423:0x0611, B:425:0x0617, B:427:0x061d, B:429:0x0620, B:435:0x0624, B:437:0x0629, B:440:0x063b, B:445:0x0643, B:449:0x0646, B:451:0x064c, B:453:0x0654, B:457:0x0677, B:459:0x067c, B:462:0x068a, B:464:0x0690, B:466:0x06a0, B:468:0x06a6, B:469:0x06ad, B:471:0x06b0, B:473:0x06b9, B:477:0x06c9, B:475:0x06cc, B:483:0x05b5, B:484:0x04cb, B:486:0x04cf, B:488:0x0529, B:490:0x052d, B:492:0x054a, B:495:0x0558, B:497:0x058c, B:498:0x0590, B:499:0x0551, B:500:0x0534, B:501:0x04d5, B:504:0x04e6, B:506:0x0518, B:507:0x047d, B:509:0x0487, B:511:0x048f, B:514:0x049e, B:516:0x04a2, B:518:0x04af, B:519:0x0843, B:522:0x084b, B:524:0x0851, B:526:0x0858, B:528:0x085d, B:529:0x0866, B:531:0x086a, B:533:0x0870, B:536:0x087c, B:538:0x088b, B:539:0x0897), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:500:0x0534 A[Catch: IOException -> 0x08a7, zzhe -> 0x08ac, RuntimeException -> 0x08b1, TryCatch #2 {RuntimeException -> 0x08b1, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:279:0x0437, B:282:0x0445, B:287:0x0450, B:288:0x0463, B:290:0x0464, B:292:0x046c, B:293:0x06cf, B:295:0x06d5, B:297:0x06dd, B:299:0x06f8, B:301:0x0703, B:304:0x070c, B:306:0x0712, B:311:0x071e, B:316:0x0728, B:323:0x072f, B:324:0x0732, B:326:0x0736, B:328:0x0744, B:329:0x0757, B:333:0x0770, B:335:0x0778, B:337:0x077e, B:338:0x0808, B:340:0x080c, B:342:0x0811, B:344:0x0819, B:346:0x081d, B:350:0x082b, B:351:0x083f, B:352:0x0826, B:355:0x082f, B:357:0x0834, B:358:0x083a, B:359:0x0788, B:361:0x078d, B:364:0x0794, B:366:0x079c, B:369:0x07af, B:375:0x07e1, B:377:0x07e9, B:378:0x07b7, B:379:0x07c5, B:380:0x07a1, B:382:0x07db, B:383:0x07ed, B:385:0x07f2, B:389:0x07fe, B:390:0x07f8, B:391:0x0474, B:393:0x0478, B:394:0x04bb, B:396:0x04c3, B:398:0x059c, B:400:0x05a0, B:403:0x05a9, B:405:0x05ad, B:407:0x05b1, B:408:0x05b8, B:410:0x05bc, B:412:0x05c2, B:414:0x05ce, B:416:0x05f9, B:419:0x0600, B:421:0x0605, B:423:0x0611, B:425:0x0617, B:427:0x061d, B:429:0x0620, B:435:0x0624, B:437:0x0629, B:440:0x063b, B:445:0x0643, B:449:0x0646, B:451:0x064c, B:453:0x0654, B:457:0x0677, B:459:0x067c, B:462:0x068a, B:464:0x0690, B:466:0x06a0, B:468:0x06a6, B:469:0x06ad, B:471:0x06b0, B:473:0x06b9, B:477:0x06c9, B:475:0x06cc, B:483:0x05b5, B:484:0x04cb, B:486:0x04cf, B:488:0x0529, B:490:0x052d, B:492:0x054a, B:495:0x0558, B:497:0x058c, B:498:0x0590, B:499:0x0551, B:500:0x0534, B:501:0x04d5, B:504:0x04e6, B:506:0x0518, B:507:0x047d, B:509:0x0487, B:511:0x048f, B:514:0x049e, B:516:0x04a2, B:518:0x04af, B:519:0x0843, B:522:0x084b, B:524:0x0851, B:526:0x0858, B:528:0x085d, B:529:0x0866, B:531:0x086a, B:533:0x0870, B:536:0x087c, B:538:0x088b, B:539:0x0897), top: B:2:0x0005 }] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(android.os.Message r36) {
        /*
            Method dump skipped, instructions count: 2336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.axz.handleMessage(android.os.Message):boolean");
    }

    private final void a(int i) {
        if (this.v != i) {
            this.v = i;
            this.h.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private final void b(boolean z) {
        if (this.u != z) {
            this.u = z;
            this.h.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private final void d() throws zzhe {
        this.t = false;
        this.e.a();
        for (zzhy zzhyVar : this.q) {
            zzhyVar.e();
        }
    }

    private final void e() throws zzhe {
        this.e.b();
        for (zzhy zzhyVar : this.q) {
            a(zzhyVar);
        }
    }

    private final void f() throws zzhe {
        if (this.F == null) {
            return;
        }
        long f = this.F.a.f();
        if (f != -9223372036854775807L) {
            a(f);
        } else {
            if (this.n != null && !this.n.u()) {
                this.C = this.o.w();
                this.e.a(this.C);
            } else {
                this.C = this.e.w();
            }
            f = this.C - this.F.a();
        }
        this.l.c = f;
        this.z = SystemClock.elapsedRealtime() * 1000;
        long g = this.q.length == 0 ? Long.MIN_VALUE : this.F.a.g();
        zzho zzhoVar = this.l;
        if (g == Long.MIN_VALUE) {
            g = this.G.a(this.F.f, this.k, false).b;
        }
        zzhoVar.d = g;
    }

    private final void a(long j, long j2) {
        this.f.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.f.sendEmptyMessage(2);
        } else {
            this.f.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private final long a(int i, long j) throws zzhe {
        axy axyVar;
        e();
        this.t = false;
        a(2);
        if (this.F == null) {
            if (this.D != null) {
                this.D.d();
            }
            axyVar = null;
        } else {
            axyVar = null;
            for (axy axyVar2 = this.F; axyVar2 != null; axyVar2 = axyVar2.k) {
                if (axyVar2.f == i && axyVar2.i) {
                    axyVar = axyVar2;
                } else {
                    axyVar2.d();
                }
            }
        }
        if (this.F != axyVar || this.F != this.E) {
            for (zzhy zzhyVar : this.q) {
                zzhyVar.l();
            }
            this.q = new zzhy[0];
            this.o = null;
            this.n = null;
            this.F = null;
        }
        if (axyVar != null) {
            axyVar.k = null;
            this.D = axyVar;
            this.E = axyVar;
            b(axyVar);
            if (this.F.j) {
                j = this.F.a.c(j);
            }
            a(j);
            i();
        } else {
            this.D = null;
            this.E = null;
            this.F = null;
            a(j);
        }
        this.f.sendEmptyMessage(2);
        return j;
    }

    private final void a(long j) throws zzhe {
        this.C = this.F == null ? j + 60000000 : j + this.F.a();
        this.e.a(this.C);
        for (zzhy zzhyVar : this.q) {
            zzhyVar.a(this.C);
        }
    }

    private final void g() {
        c(true);
        this.d.b();
        a(1);
    }

    private final void c(boolean z) {
        this.f.removeMessages(2);
        this.t = false;
        this.e.b();
        this.o = null;
        this.n = null;
        this.C = 60000000L;
        for (zzhy zzhyVar : this.q) {
            try {
                a(zzhyVar);
                zzhyVar.l();
            } catch (zzhe | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.q = new zzhy[0];
        a(this.F != null ? this.F : this.D);
        this.D = null;
        this.E = null;
        this.F = null;
        b(false);
        if (z) {
            if (this.p != null) {
                this.p.b();
                this.p = null;
            }
            this.G = null;
        }
    }

    private static void a(zzhy zzhyVar) throws zzhe {
        if (zzhyVar.d() == 2) {
            zzhyVar.k();
        }
    }

    private final boolean b(long j) {
        if (j == -9223372036854775807L || this.l.c < j) {
            return true;
        }
        return this.F.k != null && this.F.k.i;
    }

    private final void h() throws IOException {
        if (this.D == null || this.D.i) {
            return;
        }
        if (this.E == null || this.E.k == this.D) {
            for (zzhy zzhyVar : this.q) {
                if (!zzhyVar.g()) {
                    return;
                }
            }
            this.D.a.c();
        }
    }

    private final void a(Object obj, int i) {
        this.l = new zzho(0, 0L);
        b(obj, i);
        this.l = new zzho(0, -9223372036854775807L);
        a(4);
        c(false);
    }

    private final void b(Object obj, int i) {
        this.h.obtainMessage(6, new zzhq(this.G, obj, this.l, i)).sendToTarget();
    }

    private final int a(int i, zzhz zzhzVar, zzhz zzhzVar2) {
        int c = zzhzVar.c();
        int i2 = i;
        int i3 = -1;
        for (int i4 = 0; i4 < c && i3 == -1; i4++) {
            i2 = zzhzVar.a(i2, this.k, this.j, this.w);
            i3 = zzhzVar2.a(zzhzVar.a(i2, this.k, true).a);
        }
        return i3;
    }

    private final boolean b(int i) {
        this.G.a(i, this.k, false);
        this.G.a(0, this.j, false);
        return this.G.a(i, this.k, this.j, this.w) == -1;
    }

    private final Pair<Integer, Long> a(aya ayaVar) {
        zzhz zzhzVar = ayaVar.a;
        if (zzhzVar.a()) {
            zzhzVar = this.G;
        }
        try {
            Pair<Integer, Long> b = b(zzhzVar, ayaVar.b, ayaVar.c);
            if (this.G == zzhzVar) {
                return b;
            }
            int a = this.G.a(zzhzVar.a(((Integer) b.first).intValue(), this.k, true).a);
            if (a != -1) {
                return Pair.create(Integer.valueOf(a), (Long) b.second);
            }
            int a2 = a(((Integer) b.first).intValue(), zzhzVar, this.G);
            if (a2 == -1) {
                return null;
            }
            this.G.a(a2, this.k, false);
            return b(0, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzhu(this.G, ayaVar.b, ayaVar.c);
        }
    }

    private final Pair<Integer, Long> b(int i, long j) {
        return b(this.G, 0, -9223372036854775807L);
    }

    private final Pair<Integer, Long> b(zzhz zzhzVar, int i, long j) {
        return a(zzhzVar, i, j, 0L);
    }

    private final Pair<Integer, Long> a(zzhz zzhzVar, int i, long j, long j2) {
        zzpc.a(i, 0, zzhzVar.b());
        zzhzVar.a(i, this.j, false, j2);
        if (j == -9223372036854775807L) {
            j = 0;
        }
        long j3 = j + 0;
        long j4 = zzhzVar.a(0, this.k, false).b;
        if (j4 != -9223372036854775807L) {
            int i2 = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
        }
        return Pair.create(0, Long.valueOf(j3));
    }

    private final void i() {
        long e = !this.D.i ? 0L : this.D.a.e();
        if (e == Long.MIN_VALUE) {
            b(false);
            return;
        }
        long a = this.C - this.D.a();
        boolean a2 = this.d.a(e - a);
        b(a2);
        if (a2) {
            this.D.a.b(a);
        }
    }

    private static void a(axy axyVar) {
        while (axyVar != null) {
            axyVar.d();
            axyVar = axyVar.k;
        }
    }

    private final void b(axy axyVar) throws zzhe {
        if (this.F == axyVar) {
            return;
        }
        boolean[] zArr = new boolean[this.a.length];
        int i = 0;
        for (int i2 = 0; i2 < this.a.length; i2++) {
            zzhy zzhyVar = this.a[i2];
            zArr[i2] = zzhyVar.d() != 0;
            zzoc a = axyVar.l.b.a(i2);
            if (a != null) {
                i++;
            }
            if (zArr[i2] && (a == null || (zzhyVar.i() && zzhyVar.f() == this.F.d[i2]))) {
                if (zzhyVar == this.n) {
                    this.e.a(this.o);
                    this.o = null;
                    this.n = null;
                }
                a(zzhyVar);
                zzhyVar.l();
            }
        }
        this.F = axyVar;
        this.h.obtainMessage(3, axyVar.l).sendToTarget();
        a(zArr, i);
    }

    private final void a(boolean[] zArr, int i) throws zzhe {
        this.q = new zzhy[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.a.length; i3++) {
            zzhy zzhyVar = this.a[i3];
            zzoc a = this.F.l.b.a(i3);
            if (a != null) {
                int i4 = i2 + 1;
                this.q[i2] = zzhyVar;
                if (zzhyVar.d() == 0) {
                    zzia zziaVar = this.F.l.d[i3];
                    boolean z = this.s && this.v == 3;
                    boolean z2 = !zArr[i3] && z;
                    zzhp[] zzhpVarArr = new zzhp[a.b()];
                    for (int i5 = 0; i5 < zzhpVarArr.length; i5++) {
                        zzhpVarArr[i5] = a.a(i5);
                    }
                    zzhyVar.a(zziaVar, zzhpVarArr, this.F.d[i3], this.C, z2, this.F.a());
                    zzpg c = zzhyVar.c();
                    if (c != null) {
                        if (this.o != null) {
                            throw zzhe.a(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                        this.o = c;
                        this.n = zzhyVar;
                        this.o.a(this.m);
                    }
                    if (z) {
                        zzhyVar.e();
                    }
                }
                i2 = i4;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final /* synthetic */ void a(zzmy zzmyVar) {
        this.f.obtainMessage(9, zzmyVar).sendToTarget();
    }
}
