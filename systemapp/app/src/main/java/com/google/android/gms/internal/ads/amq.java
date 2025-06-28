package com.google.android.gms.internal.ads;

import java.lang.Throwable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class amq<V, X extends Throwable, F, T> extends ani<V> implements Runnable {

    @NullableDecl
    private zzdyz<? extends V> a;

    @NullableDecl
    private Class<X> b;

    @NullableDecl
    private F c;

    static <X extends Throwable, V> zzdyz<V> a(zzdyz<? extends V> zzdyzVar, Class<X> cls, zzdyb<? super X, ? extends V> zzdybVar, Executor executor) {
        amp ampVar = new amp(zzdyzVar, cls, zzdybVar);
        zzdyzVar.a(ampVar, zzdzb.a(executor, ampVar));
        return ampVar;
    }

    @NullableDecl
    abstract T a(F f, X x) throws Exception;

    abstract void a(@NullableDecl T t);

    amq(zzdyz<? extends V> zzdyzVar, Class<X> cls, F f) {
        this.a = (zzdyz) zzdvv.a(zzdyzVar);
        this.b = (Class) zzdvv.a(cls);
        this.c = (F) zzdvv.a(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0091  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzdyz<? extends V> r0 = r9.a
            java.lang.Class<X extends java.lang.Throwable> r1 = r9.b
            F r2 = r9.c
            r3 = 0
            r4 = 1
            if (r0 != 0) goto Lc
            r5 = r4
            goto Ld
        Lc:
            r5 = r3
        Ld:
            if (r1 != 0) goto L11
            r6 = r4
            goto L12
        L11:
            r6 = r3
        L12:
            r5 = r5 | r6
            if (r2 != 0) goto L16
            r3 = r4
        L16:
            r3 = r3 | r5
            if (r3 != 0) goto Lb7
            boolean r3 = r9.isCancelled()
            if (r3 == 0) goto L21
            goto Lb7
        L21:
            r3 = 0
            r9.a = r3
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzdzr     // Catch: java.lang.Throwable -> L38 java.util.concurrent.ExecutionException -> L3b
            if (r4 == 0) goto L30
            r4 = r0
            com.google.android.gms.internal.ads.zzdzr r4 = (com.google.android.gms.internal.ads.zzdzr) r4     // Catch: java.lang.Throwable -> L38 java.util.concurrent.ExecutionException -> L3b
            java.lang.Throwable r4 = com.google.android.gms.internal.ads.zzdzu.a(r4)     // Catch: java.lang.Throwable -> L38 java.util.concurrent.ExecutionException -> L3b
            goto L31
        L30:
            r4 = r3
        L31:
            if (r4 != 0) goto L39
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzdyr.a(r0)     // Catch: java.lang.Throwable -> L38 java.util.concurrent.ExecutionException -> L3b
            goto L8b
        L38:
            r4 = move-exception
        L39:
            r5 = r3
            goto L8b
        L3b:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L89
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.Class r6 = r0.getClass()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r7 = 35
            java.lang.String r8 = java.lang.String.valueOf(r6)
            int r8 = r8.length()
            int r7 = r7 + r8
            java.lang.String r8 = java.lang.String.valueOf(r4)
            int r8 = r8.length()
            int r7 = r7 + r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r7)
            java.lang.String r7 = "Future type "
            r8.append(r7)
            r8.append(r6)
            java.lang.String r6 = " threw "
            r8.append(r6)
            r8.append(r4)
            java.lang.String r4 = " without a cause"
            r8.append(r4)
            java.lang.String r4 = r8.toString()
            r5.<init>(r4)
        L89:
            r4 = r5
            goto L39
        L8b:
            if (r4 != 0) goto L91
            r9.b(r5)
            return
        L91:
            boolean r1 = r1.isInstance(r4)
            if (r1 != 0) goto L9b
            r9.a(r0)
            return
        L9b:
            java.lang.Object r0 = r9.a(r2, r4)     // Catch: java.lang.Throwable -> La7 java.lang.Throwable -> La9
            r9.b = r3
            r9.c = r3
            r9.a(r0)
            return
        La7:
            r0 = move-exception
            goto Lb2
        La9:
            r0 = move-exception
            r9.a(r0)     // Catch: java.lang.Throwable -> La7
            r9.b = r3
            r9.c = r3
            return
        Lb2:
            r9.b = r3
            r9.c = r3
            throw r0
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.amq.run():void");
    }

    @Override // com.google.android.gms.internal.ads.zzdxo
    protected final String a() {
        zzdyz<? extends V> zzdyzVar = this.a;
        Class<X> cls = this.b;
        F f = this.c;
        String a = super.a();
        String str = "";
        if (zzdyzVar != null) {
            String valueOf = String.valueOf(zzdyzVar);
            StringBuilder sb = new StringBuilder(16 + String.valueOf(valueOf).length());
            sb.append("inputFuture=[");
            sb.append(valueOf);
            sb.append("], ");
            str = sb.toString();
        }
        if (cls == null || f == null) {
            if (a == null) {
                return null;
            }
            String valueOf2 = String.valueOf(str);
            String valueOf3 = String.valueOf(a);
            return valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2);
        }
        String valueOf4 = String.valueOf(cls);
        String valueOf5 = String.valueOf(f);
        StringBuilder sb2 = new StringBuilder(29 + String.valueOf(str).length() + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length());
        sb2.append(str);
        sb2.append("exceptionType=[");
        sb2.append(valueOf4);
        sb2.append("], fallback=[");
        sb2.append(valueOf5);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdxo
    protected final void b() {
        a((Future<?>) this.a);
        this.a = null;
        this.b = null;
        this.c = null;
    }
}
