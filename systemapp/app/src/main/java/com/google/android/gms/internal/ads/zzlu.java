package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzlu extends Exception {
    private final String a;
    private final boolean b;
    private final String c;
    private final String d;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzlu(com.google.android.gms.internal.ads.zzhp r3, java.lang.Throwable r4, boolean r5, int r6) {
        /*
            r2 = this;
            java.lang.String r5 = java.lang.String.valueOf(r3)
            java.lang.String r0 = java.lang.String.valueOf(r5)
            int r0 = r0.length()
            r1 = 36
            int r1 = r1 + r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r1)
            java.lang.String r1 = "Decoder init failed: ["
            r0.append(r1)
            r0.append(r6)
            java.lang.String r1 = "], "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r2.<init>(r5, r4)
            java.lang.String r3 = r3.d
            r2.a = r3
            r3 = 0
            r2.b = r3
            r3 = 0
            r2.c = r3
            if (r6 >= 0) goto L3a
            java.lang.String r3 = "neg_"
            goto L3c
        L3a:
            java.lang.String r3 = ""
        L3c:
            int r4 = java.lang.Math.abs(r6)
            r5 = 64
            java.lang.String r6 = java.lang.String.valueOf(r3)
            int r6 = r6.length()
            int r5 = r5 + r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "com.google.android.exoplayer.MediaCodecTrackRenderer_"
            r6.append(r5)
            r6.append(r3)
            r6.append(r4)
            java.lang.String r3 = r6.toString()
            r2.d = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlu.<init>(com.google.android.gms.internal.ads.zzhp, java.lang.Throwable, boolean, int):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzlu(com.google.android.gms.internal.ads.zzhp r3, java.lang.Throwable r4, boolean r5, java.lang.String r6) {
        /*
            r2 = this;
            java.lang.String r5 = java.lang.String.valueOf(r3)
            java.lang.String r0 = java.lang.String.valueOf(r6)
            int r0 = r0.length()
            r1 = 23
            int r1 = r1 + r0
            java.lang.String r0 = java.lang.String.valueOf(r5)
            int r0 = r0.length()
            int r1 = r1 + r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r1)
            java.lang.String r1 = "Decoder init failed: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r1 = ", "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r2.<init>(r5, r4)
            java.lang.String r3 = r3.d
            r2.a = r3
            r3 = 0
            r2.b = r3
            r2.c = r6
            int r3 = com.google.android.gms.internal.ads.zzpt.a
            r5 = 0
            r6 = 21
            if (r3 < r6) goto L4e
            boolean r3 = r4 instanceof android.media.MediaCodec.CodecException
            if (r3 == 0) goto L4e
            android.media.MediaCodec$CodecException r4 = (android.media.MediaCodec.CodecException) r4
            java.lang.String r5 = r4.getDiagnosticInfo()
        L4e:
            r2.d = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlu.<init>(com.google.android.gms.internal.ads.zzhp, java.lang.Throwable, boolean, java.lang.String):void");
    }
}
