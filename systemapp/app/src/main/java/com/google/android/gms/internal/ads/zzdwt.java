package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzdwt<E> extends zzdwl<E> implements Set<E> {

    @NullableDecl
    private transient zzdwm<E> a;

    public static <E> zzdwt<E> a(E e) {
        return new amn(e);
    }

    public static boolean b(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    boolean g() {
        return false;
    }

    @SafeVarargs
    public static <E> zzdwt<E> a(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        zzdvv.a(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        Object[] objArr = new Object[eArr.length + 6];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return b(objArr.length, objArr);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:202)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:61)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:281)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public static <E> com.google.android.gms.internal.ads.zzdwt<E> b(int r12, java.lang.Object... r13) {
        /*
        L0:
            r0 = 0
            switch(r12) {
                case 0: goto L17;
                case 1: goto L10;
                default: goto L4;
            }
        L4:
            int r1 = a(r12)
            java.lang.Object[] r5 = new java.lang.Object[r1]
            int r6 = r1 + (-1)
            r2 = r0
            r4 = r2
            r7 = r4
            goto L1a
        L10:
            r12 = r13[r0]
            com.google.android.gms.internal.ads.zzdwt r12 = a(r12)
            return r12
        L17:
            com.google.android.gms.internal.ads.aml<java.lang.Object> r12 = com.google.android.gms.internal.ads.aml.a
            return r12
        L1a:
            if (r2 >= r12) goto L45
            r3 = r13[r2]
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzdwx.a(r3, r2)
            int r8 = r3.hashCode()
            int r9 = com.google.android.gms.internal.ads.amb.a(r8)
        L2a:
            r10 = r9 & r6
            r11 = r5[r10]
            if (r11 != 0) goto L39
            int r9 = r7 + 1
            r13[r7] = r3
            r5[r10] = r3
            int r4 = r4 + r8
            r7 = r9
            goto L42
        L39:
            boolean r10 = r11.equals(r3)
            if (r10 != 0) goto L42
            int r9 = r9 + 1
            goto L2a
        L42:
            int r2 = r2 + 1
            goto L1a
        L45:
            r2 = 0
            java.util.Arrays.fill(r13, r7, r12, r2)
            r12 = 1
            if (r7 != r12) goto L54
            r12 = r13[r0]
            com.google.android.gms.internal.ads.amn r13 = new com.google.android.gms.internal.ads.amn
            r13.<init>(r12, r4)
            return r13
        L54:
            int r12 = a(r7)
            int r1 = r1 / 2
            if (r12 >= r1) goto L5e
            r12 = r7
            goto L0
        L5e:
            int r12 = r13.length
            boolean r12 = b(r7, r12)
            if (r12 == 0) goto L69
            java.lang.Object[] r13 = java.util.Arrays.copyOf(r13, r7)
        L69:
            r3 = r13
            com.google.android.gms.internal.ads.aml r12 = new com.google.android.gms.internal.ads.aml
            r2 = r12
            r2.<init>(r3, r4, r5, r6, r7)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdwt.b(int, java.lang.Object[]):com.google.android.gms.internal.ads.zzdwt");
    }

    static int a(int i) {
        int max = Math.max(i, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (highestOneBit * 0.7d < max) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        zzdvv.a(max < 1073741824, "collection too large");
        return 1073741824;
    }

    zzdwt() {
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzdwt) && g() && ((zzdwt) obj).g() && hashCode() != obj.hashCode()) {
            return false;
        }
        return zzdxf.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzdxf.a(this);
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    public zzdwm<E> e() {
        zzdwm<E> zzdwmVar = this.a;
        if (zzdwmVar != null) {
            return zzdwmVar;
        }
        zzdwm<E> h = h();
        this.a = h;
        return h;
    }

    zzdwm<E> h() {
        return zzdwm.b(toArray());
    }

    public static <E> zzdws<E> b(int i) {
        alz.a(i, "expectedSize");
        return new zzdws<>(i);
    }

    @Override // com.google.android.gms.internal.ads.zzdwl, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
