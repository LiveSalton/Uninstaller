package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
final class aoa<V> implements Runnable {

    @NullableDecl
    private any<V> a;

    aoa(any<V> anyVar) {
        this.a = anyVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0005, code lost:
    
        r1 = ((com.google.android.gms.internal.ads.any) r0).a;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.any<V> r0 = r10.a
            if (r0 != 0) goto L5
            return
        L5:
            com.google.android.gms.internal.ads.zzdyz r1 = com.google.android.gms.internal.ads.any.a(r0)
            if (r1 != 0) goto Lc
            return
        Lc:
            r2 = 0
            r10.a = r2
            boolean r3 = r1.isDone()
            if (r3 == 0) goto L19
            r0.a(r1)
            return
        L19:
            r3 = 1
            java.util.concurrent.ScheduledFuture r4 = com.google.android.gms.internal.ads.any.b(r0)     // Catch: java.lang.Throwable -> La5
            com.google.android.gms.internal.ads.any.a(r0, r2)     // Catch: java.lang.Throwable -> La5
            java.lang.String r5 = "Timed out"
            if (r4 == 0) goto L61
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L5f
            long r6 = r4.getDelay(r6)     // Catch: java.lang.Throwable -> L5f
            long r6 = java.lang.Math.abs(r6)     // Catch: java.lang.Throwable -> L5f
            r8 = 10
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 <= 0) goto L61
            java.lang.String r4 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L5f
            r8 = 66
            java.lang.String r9 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L5f
            int r9 = r9.length()     // Catch: java.lang.Throwable -> L5f
            int r8 = r8 + r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5f
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L5f
            r9.append(r4)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r4 = " (timeout delayed by "
            r9.append(r4)     // Catch: java.lang.Throwable -> L5f
            r9.append(r6)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r4 = " ms after scheduled time)"
            r9.append(r4)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r4 = r9.toString()     // Catch: java.lang.Throwable -> L5f
            r5 = r4
            goto L61
        L5f:
            r4 = move-exception
            goto L9c
        L61:
            java.lang.String r4 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r6 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L5f
            r7 = 2
            java.lang.String r8 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L5f
            int r8 = r8.length()     // Catch: java.lang.Throwable -> L5f
            int r7 = r7 + r8
            java.lang.String r8 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L5f
            int r8 = r8.length()     // Catch: java.lang.Throwable -> L5f
            int r7 = r7 + r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5f
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L5f
            r8.append(r4)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r4 = ": "
            r8.append(r4)     // Catch: java.lang.Throwable -> L5f
            r8.append(r6)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r4 = r8.toString()     // Catch: java.lang.Throwable -> L5f
            com.google.android.gms.internal.ads.anz r5 = new com.google.android.gms.internal.ads.anz     // Catch: java.lang.Throwable -> La5
            r5.<init>(r4)     // Catch: java.lang.Throwable -> La5
            r0.a(r5)     // Catch: java.lang.Throwable -> La5
            r1.cancel(r3)
            return
        L9c:
            com.google.android.gms.internal.ads.anz r6 = new com.google.android.gms.internal.ads.anz     // Catch: java.lang.Throwable -> La5
            r6.<init>(r5)     // Catch: java.lang.Throwable -> La5
            r0.a(r6)     // Catch: java.lang.Throwable -> La5
            throw r4     // Catch: java.lang.Throwable -> La5
        La5:
            r0 = move-exception
            r1.cancel(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aoa.run():void");
    }
}
