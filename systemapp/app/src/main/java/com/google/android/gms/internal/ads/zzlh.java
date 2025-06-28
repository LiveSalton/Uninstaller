package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzlh implements zzjw {
    private static final zzkb a = new azu();
    private static final int b = zzpt.c("seig");
    private static final byte[] c = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private int A;
    private int B;
    private boolean C;
    private zzjy D;
    private zzkh E;
    private zzkh[] F;
    private boolean G;
    private final int d;
    private final zzlo e;
    private final SparseArray<azv> f;
    private final zzpn g;
    private final zzpn h;
    private final zzpn i;
    private final zzpn j;
    private final zzpr k;
    private final zzpn l;
    private final byte[] m;
    private final Stack<azk> n;
    private final LinkedList<azw> o;
    private int p;
    private int q;
    private long r;
    private int s;
    private zzpn t;
    private long u;
    private int v;
    private long w;
    private long x;
    private azv y;
    private int z;

    public zzlh() {
        this(0);
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final void c() {
    }

    private zzlh(int i) {
        this(0, null);
    }

    private zzlh(int i, zzpr zzprVar) {
        this(0, null, null);
    }

    private zzlh(int i, zzpr zzprVar, zzlo zzloVar) {
        this.d = 0;
        this.k = null;
        this.e = null;
        this.l = new zzpn(16);
        this.g = new zzpn(zzpi.a);
        this.h = new zzpn(5);
        this.i = new zzpn();
        this.j = new zzpn(1);
        this.m = new byte[16];
        this.n = new Stack<>();
        this.o = new LinkedList<>();
        this.f = new SparseArray<>();
        this.w = -9223372036854775807L;
        this.x = -9223372036854775807L;
        a();
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final boolean a(zzjz zzjzVar) throws IOException, InterruptedException {
        return baa.a(zzjzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final void a(zzjy zzjyVar) {
        this.D = zzjyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final void a(long j, long j2) {
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            this.f.valueAt(i).a();
        }
        this.o.clear();
        this.v = 0;
        this.n.clear();
        a();
    }

    /* JADX WARN: Removed duplicated region for block: B:180:0x038c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0617 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzjw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(com.google.android.gms.internal.ads.zzjz r27, com.google.android.gms.internal.ads.zzkc r28) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 1570
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlh.a(com.google.android.gms.internal.ads.zzjz, com.google.android.gms.internal.ads.zzkc):int");
    }

    private final void a() {
        this.p = 0;
        this.s = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0625  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0653  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x061d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0403  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a(long r54) throws com.google.android.gms.internal.ads.zzhw {
        /*
            Method dump skipped, instructions count: 1795
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlh.a(long):void");
    }

    private static void a(zzpn zzpnVar, int i, bab babVar) throws zzhw {
        zzpnVar.c(i + 8);
        int b2 = azh.b(zzpnVar.l());
        if ((b2 & 1) != 0) {
            throw new zzhw("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (b2 & 2) != 0;
        int o = zzpnVar.o();
        if (o != babVar.f) {
            int i2 = babVar.f;
            StringBuilder sb = new StringBuilder(41);
            sb.append("Length mismatch: ");
            sb.append(o);
            sb.append(", ");
            sb.append(i2);
            throw new zzhw(sb.toString());
        }
        Arrays.fill(babVar.n, 0, o, z);
        babVar.a(zzpnVar.b());
        zzpnVar.a(babVar.q.a, 0, babVar.p);
        babVar.q.c(0);
        babVar.r = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.gms.internal.ads.zzjo a(java.util.List<com.google.android.gms.internal.ads.azj> r14) {
        /*
            int r0 = r14.size()
            r1 = 0
            r2 = 0
            r3 = r1
            r4 = r2
        L8:
            if (r3 >= r0) goto Lb9
            java.lang.Object r5 = r14.get(r3)
            com.google.android.gms.internal.ads.azj r5 = (com.google.android.gms.internal.ads.azj) r5
            int r6 = r5.aO
            int r7 = com.google.android.gms.internal.ads.azh.U
            if (r6 != r7) goto Lb5
            if (r4 != 0) goto L1d
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L1d:
            com.google.android.gms.internal.ads.zzpn r5 = r5.aP
            byte[] r5 = r5.a
            com.google.android.gms.internal.ads.zzpn r6 = new com.google.android.gms.internal.ads.zzpn
            r6.<init>(r5)
            int r7 = r6.c()
            r8 = 32
            if (r7 >= r8) goto L30
        L2e:
            r6 = r2
            goto L99
        L30:
            r6.c(r1)
            int r7 = r6.l()
            int r8 = r6.b()
            int r8 = r8 + 4
            if (r7 == r8) goto L40
            goto L2e
        L40:
            int r7 = r6.l()
            int r8 = com.google.android.gms.internal.ads.azh.U
            if (r7 == r8) goto L49
            goto L2e
        L49:
            int r7 = r6.l()
            int r7 = com.google.android.gms.internal.ads.azh.a(r7)
            r8 = 1
            if (r7 <= r8) goto L6d
            java.lang.String r6 = "PsshAtomUtil"
            r8 = 37
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r8)
            java.lang.String r8 = "Unsupported pssh version: "
            r9.append(r8)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            android.util.Log.w(r6, r7)
            goto L2e
        L6d:
            java.util.UUID r9 = new java.util.UUID
            long r10 = r6.m()
            long r12 = r6.m()
            r9.<init>(r10, r12)
            if (r7 != r8) goto L85
            int r7 = r6.o()
            int r7 = r7 << 4
            r6.d(r7)
        L85:
            int r7 = r6.o()
            int r8 = r6.b()
            if (r7 == r8) goto L90
            goto L2e
        L90:
            byte[] r8 = new byte[r7]
            r6.a(r8, r1, r7)
            android.util.Pair r6 = android.util.Pair.create(r9, r8)
        L99:
            if (r6 != 0) goto L9d
            r6 = r2
            goto La1
        L9d:
            java.lang.Object r6 = r6.first
            java.util.UUID r6 = (java.util.UUID) r6
        La1:
            if (r6 != 0) goto Lab
            java.lang.String r5 = "FragmentedMp4Extractor"
            java.lang.String r6 = "Skipped pssh atom (failed to extract uuid)"
            android.util.Log.w(r5, r6)
            goto Lb5
        Lab:
            com.google.android.gms.internal.ads.zzjo$zza r7 = new com.google.android.gms.internal.ads.zzjo$zza
            java.lang.String r8 = "video/mp4"
            r7.<init>(r6, r8, r5)
            r4.add(r7)
        Lb5:
            int r3 = r3 + 1
            goto L8
        Lb9:
            if (r4 != 0) goto Lbc
            return r2
        Lbc:
            com.google.android.gms.internal.ads.zzjo r14 = new com.google.android.gms.internal.ads.zzjo
            r14.<init>(r4)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlh.a(java.util.List):com.google.android.gms.internal.ads.zzjo");
    }
}
