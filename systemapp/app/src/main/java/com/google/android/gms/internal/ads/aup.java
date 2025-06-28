package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class aup<T> implements avd<T> {
    private final zzels a;
    private final avw<?, ?> b;
    private final boolean c;
    private final atk<?> d;

    private aup(avw<?, ?> avwVar, atk<?> atkVar, zzels zzelsVar) {
        this.b = avwVar;
        this.c = atkVar.a(zzelsVar);
        this.d = atkVar;
        this.a = zzelsVar;
    }

    static <T> aup<T> a(avw<?, ?> avwVar, atk<?> atkVar, zzels zzelsVar) {
        return new aup<>(avwVar, atkVar, zzelsVar);
    }

    @Override // com.google.android.gms.internal.ads.avd
    public final T a() {
        return (T) this.a.v().f();
    }

    @Override // com.google.android.gms.internal.ads.avd
    public final boolean a(T t, T t2) {
        if (!this.b.b(t).equals(this.b.b(t2))) {
            return false;
        }
        if (this.c) {
            return this.d.a(t).equals(this.d.a(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.avd
    public final int a(T t) {
        int hashCode = this.b.b(t).hashCode();
        return this.c ? (hashCode * 53) + this.d.a(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.ads.avd
    public final void b(T t, T t2) {
        avf.a(this.b, t, t2);
        if (this.c) {
            avf.a(this.d, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.ads.avd
    public final void a(T t, awo awoVar) throws IOException {
        Iterator<Map.Entry<?, Object>> d = this.d.a(t).d();
        while (d.hasNext()) {
            Map.Entry<?, Object> next = d.next();
            zzejz zzejzVar = (zzejz) next.getKey();
            if (zzejzVar.c() != zzenz.MESSAGE || zzejzVar.d() || zzejzVar.e()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (next instanceof atu) {
                awoVar.a(zzejzVar.a(), (Object) ((atu) next).a().c());
            } else {
                awoVar.a(zzejzVar.a(), next.getValue());
            }
        }
        avw<?, ?> avwVar = this.b;
        avwVar.b((avw<?, ?>) avwVar.b(t), awoVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0098 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
    @Override // com.google.android.gms.internal.ads.avd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(T r9, byte[] r10, int r11, int r12, com.google.android.gms.internal.ads.asp r13) throws java.io.IOException {
        /*
            r8 = this;
            r0 = r9
            com.google.android.gms.internal.ads.zzekh r0 = (com.google.android.gms.internal.ads.zzekh) r0
            com.google.android.gms.internal.ads.zzeni r1 = r0.zzino
            com.google.android.gms.internal.ads.zzeni r2 = com.google.android.gms.internal.ads.zzeni.a()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.ads.zzeni r1 = com.google.android.gms.internal.ads.zzeni.b()
            r0.zzino = r1
        L11:
            com.google.android.gms.internal.ads.zzekh$zzb r9 = (com.google.android.gms.internal.ads.zzekh.zzb) r9
            r9.a()
            r9 = 0
            r0 = r9
        L18:
            if (r11 >= r12) goto La3
            int r4 = com.google.android.gms.internal.ads.asm.a(r10, r11, r13)
            int r2 = r13.a
            r11 = 11
            r3 = 2
            if (r2 == r11) goto L51
            r11 = r2 & 7
            if (r11 != r3) goto L4c
            com.google.android.gms.internal.ads.atk<?> r11 = r8.d
            com.google.android.gms.internal.ads.zzeju r0 = r13.d
            com.google.android.gms.internal.ads.zzels r3 = r8.a
            int r5 = r2 >>> 3
            java.lang.Object r11 = r11.a(r0, r3, r5)
            r0 = r11
            com.google.android.gms.internal.ads.zzekh$zzd r0 = (com.google.android.gms.internal.ads.zzekh.zzd) r0
            if (r0 == 0) goto L43
            com.google.android.gms.internal.ads.auw.a()
            java.lang.NoSuchMethodError r9 = new java.lang.NoSuchMethodError
            r9.<init>()
            throw r9
        L43:
            r3 = r10
            r5 = r12
            r6 = r1
            r7 = r13
            int r11 = com.google.android.gms.internal.ads.asm.a(r2, r3, r4, r5, r6, r7)
            goto L18
        L4c:
            int r11 = com.google.android.gms.internal.ads.asm.a(r2, r10, r4, r12, r13)
            goto L18
        L51:
            r11 = 0
            r2 = r11
            r11 = r9
        L54:
            if (r4 >= r12) goto L98
            int r4 = com.google.android.gms.internal.ads.asm.a(r10, r4, r13)
            int r5 = r13.a
            int r6 = r5 >>> 3
            r7 = r5 & 7
            switch(r6) {
                case 2: goto L7a;
                case 3: goto L64;
                default: goto L63;
            }
        L63:
            goto L8f
        L64:
            if (r0 == 0) goto L6f
            com.google.android.gms.internal.ads.auw.a()
            java.lang.NoSuchMethodError r9 = new java.lang.NoSuchMethodError
            r9.<init>()
            throw r9
        L6f:
            if (r7 != r3) goto L8f
            int r4 = com.google.android.gms.internal.ads.asm.e(r10, r4, r13)
            java.lang.Object r11 = r13.c
            com.google.android.gms.internal.ads.zzeiu r11 = (com.google.android.gms.internal.ads.zzeiu) r11
            goto L54
        L7a:
            if (r7 != 0) goto L8f
            int r4 = com.google.android.gms.internal.ads.asm.a(r10, r4, r13)
            int r2 = r13.a
            com.google.android.gms.internal.ads.atk<?> r0 = r8.d
            com.google.android.gms.internal.ads.zzeju r5 = r13.d
            com.google.android.gms.internal.ads.zzels r6 = r8.a
            java.lang.Object r0 = r0.a(r5, r6, r2)
            com.google.android.gms.internal.ads.zzekh$zzd r0 = (com.google.android.gms.internal.ads.zzekh.zzd) r0
            goto L54
        L8f:
            r6 = 12
            if (r5 == r6) goto L98
            int r4 = com.google.android.gms.internal.ads.asm.a(r5, r10, r4, r12, r13)
            goto L54
        L98:
            if (r11 == 0) goto La0
            int r2 = r2 << 3
            r2 = r2 | r3
            r1.a(r2, r11)
        La0:
            r11 = r4
            goto L18
        La3:
            if (r11 == r12) goto Laa
            com.google.android.gms.internal.ads.zzeks r9 = com.google.android.gms.internal.ads.zzeks.h()
            throw r9
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aup.a(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.asp):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[LOOP:0: B:2:0x000c->B:20:?, LOOP_END, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.avd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(T r11, com.google.android.gms.internal.ads.aux r12, com.google.android.gms.internal.ads.zzeju r13) throws java.io.IOException {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.avw<?, ?> r0 = r10.b
            com.google.android.gms.internal.ads.atk<?> r1 = r10.d
            java.lang.Object r2 = r0.c(r11)
            com.google.android.gms.internal.ads.atl r3 = r1.b(r11)
        Lc:
            int r4 = r12.a()     // Catch: java.lang.Throwable -> L8f
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 != r5) goto L19
            r0.b(r11, r2)
            return
        L19:
            int r4 = r12.b()     // Catch: java.lang.Throwable -> L8f
            r6 = 11
            if (r4 == r6) goto L3e
            r5 = r4 & 7
            r6 = 2
            if (r5 != r6) goto L39
            com.google.android.gms.internal.ads.zzels r5 = r10.a     // Catch: java.lang.Throwable -> L8f
            int r4 = r4 >>> 3
            java.lang.Object r4 = r1.a(r13, r5, r4)     // Catch: java.lang.Throwable -> L8f
            if (r4 == 0) goto L34
            r1.a(r12, r4, r13, r3)     // Catch: java.lang.Throwable -> L8f
            goto L88
        L34:
            boolean r4 = r0.a(r2, r12)     // Catch: java.lang.Throwable -> L8f
            goto L89
        L39:
            boolean r4 = r12.c()     // Catch: java.lang.Throwable -> L8f
            goto L89
        L3e:
            r4 = 0
            r6 = 0
            r7 = r4
            r4 = r6
        L42:
            int r8 = r12.a()     // Catch: java.lang.Throwable -> L8f
            if (r8 == r5) goto L70
            int r8 = r12.b()     // Catch: java.lang.Throwable -> L8f
            r9 = 16
            if (r8 != r9) goto L5b
            int r7 = r12.o()     // Catch: java.lang.Throwable -> L8f
            com.google.android.gms.internal.ads.zzels r6 = r10.a     // Catch: java.lang.Throwable -> L8f
            java.lang.Object r6 = r1.a(r13, r6, r7)     // Catch: java.lang.Throwable -> L8f
            goto L42
        L5b:
            r9 = 26
            if (r8 != r9) goto L6a
            if (r6 == 0) goto L65
            r1.a(r12, r6, r13, r3)     // Catch: java.lang.Throwable -> L8f
            goto L42
        L65:
            com.google.android.gms.internal.ads.zzeiu r4 = r12.n()     // Catch: java.lang.Throwable -> L8f
            goto L42
        L6a:
            boolean r8 = r12.c()     // Catch: java.lang.Throwable -> L8f
            if (r8 != 0) goto L42
        L70:
            int r5 = r12.b()     // Catch: java.lang.Throwable -> L8f
            r8 = 12
            if (r5 == r8) goto L7d
            com.google.android.gms.internal.ads.zzeks r12 = com.google.android.gms.internal.ads.zzeks.e()     // Catch: java.lang.Throwable -> L8f
            throw r12     // Catch: java.lang.Throwable -> L8f
        L7d:
            if (r4 == 0) goto L88
            if (r6 == 0) goto L85
            r1.a(r4, r6, r13, r3)     // Catch: java.lang.Throwable -> L8f
            goto L88
        L85:
            r0.a(r2, r7, r4)     // Catch: java.lang.Throwable -> L8f
        L88:
            r4 = 1
        L89:
            if (r4 != 0) goto Lc
            r0.b(r11, r2)
            return
        L8f:
            r12 = move-exception
            r0.b(r11, r2)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aup.a(java.lang.Object, com.google.android.gms.internal.ads.aux, com.google.android.gms.internal.ads.zzeju):void");
    }

    @Override // com.google.android.gms.internal.ads.avd
    public final void c(T t) {
        this.b.d(t);
        this.d.c(t);
    }

    @Override // com.google.android.gms.internal.ads.avd
    public final boolean d(T t) {
        return this.d.a(t).f();
    }

    @Override // com.google.android.gms.internal.ads.avd
    public final int b(T t) {
        avw<?, ?> avwVar = this.b;
        int e = 0 + avwVar.e(avwVar.b(t));
        return this.c ? e + this.d.a(t).g() : e;
    }
}
