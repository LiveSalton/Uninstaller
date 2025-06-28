package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;

/* compiled from: source */
@TargetApi(16)
/* loaded from: classes.dex */
public final class zzls {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    private final String e;
    private final MediaCodecInfo.CodecCapabilities f;

    public static zzls a(String str) {
        return new zzls(str, null, null, false, false);
    }

    public static zzls a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new zzls(str, str2, codecCapabilities, z, z2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005a, code lost:
    
        if ((com.google.android.gms.internal.ads.zzpt.a >= 21 && r4.isFeatureSupported("secure-playback")) != false) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private zzls(java.lang.String r2, java.lang.String r3, android.media.MediaCodecInfo.CodecCapabilities r4, boolean r5, boolean r6) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzpc.a(r2)
            java.lang.String r2 = (java.lang.String) r2
            r1.a = r2
            r1.e = r3
            r1.f = r4
            r2 = 0
            r3 = 1
            if (r5 != 0) goto L2a
            if (r4 == 0) goto L2a
            int r5 = com.google.android.gms.internal.ads.zzpt.a
            r0 = 19
            if (r5 < r0) goto L25
            java.lang.String r5 = "adaptive-playback"
            boolean r5 = r4.isFeatureSupported(r5)
            if (r5 == 0) goto L25
            r5 = r3
            goto L26
        L25:
            r5 = r2
        L26:
            if (r5 == 0) goto L2a
            r5 = r3
            goto L2b
        L2a:
            r5 = r2
        L2b:
            r1.b = r5
            r5 = 21
            if (r4 == 0) goto L44
            int r0 = com.google.android.gms.internal.ads.zzpt.a
            if (r0 < r5) goto L3f
            java.lang.String r0 = "tunneled-playback"
            boolean r0 = r4.isFeatureSupported(r0)
            if (r0 == 0) goto L3f
            r0 = r3
            goto L40
        L3f:
            r0 = r2
        L40:
            if (r0 == 0) goto L44
            r0 = r3
            goto L45
        L44:
            r0 = r2
        L45:
            r1.c = r0
            if (r6 != 0) goto L5c
            if (r4 == 0) goto L5d
            int r6 = com.google.android.gms.internal.ads.zzpt.a
            if (r6 < r5) goto L59
            java.lang.String r5 = "secure-playback"
            boolean r4 = r4.isFeatureSupported(r5)
            if (r4 == 0) goto L59
            r4 = r3
            goto L5a
        L59:
            r4 = r2
        L5a:
            if (r4 == 0) goto L5d
        L5c:
            r2 = r3
        L5d:
            r1.d = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzls.<init>(java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean):void");
    }

    public final MediaCodecInfo.CodecProfileLevel[] a() {
        if (this.f == null || this.f.profileLevels == null) {
            return new MediaCodecInfo.CodecProfileLevel[0];
        }
        return this.f.profileLevels;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzls.b(java.lang.String):boolean");
    }

    @TargetApi(21)
    public final boolean a(int i, int i2, double d) {
        if (this.f == null) {
            c("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = this.f.getVideoCapabilities();
        if (videoCapabilities == null) {
            c("sizeAndRate.vCaps");
            return false;
        }
        if (a(videoCapabilities, i, i2, d)) {
            return true;
        }
        if (i >= i2 || !a(videoCapabilities, i2, i, d)) {
            StringBuilder sb = new StringBuilder(69);
            sb.append("sizeAndRate.support, ");
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            sb.append("x");
            sb.append(d);
            c(sb.toString());
            return false;
        }
        StringBuilder sb2 = new StringBuilder(69);
        sb2.append("sizeAndRate.rotated, ");
        sb2.append(i);
        sb2.append("x");
        sb2.append(i2);
        sb2.append("x");
        sb2.append(d);
        String sb3 = sb2.toString();
        String str = this.a;
        String str2 = this.e;
        String str3 = zzpt.e;
        StringBuilder sb4 = new StringBuilder(25 + String.valueOf(sb3).length() + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb4.append("AssumedSupport [");
        sb4.append(sb3);
        sb4.append("] [");
        sb4.append(str);
        sb4.append(", ");
        sb4.append(str2);
        sb4.append("] [");
        sb4.append(str3);
        sb4.append("]");
        Log.d("MediaCodecInfo", sb4.toString());
        return true;
    }

    @TargetApi(21)
    public final Point a(int i, int i2) {
        if (this.f == null) {
            c("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = this.f.getVideoCapabilities();
        if (videoCapabilities == null) {
            c("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(zzpt.a(i, widthAlignment) * widthAlignment, zzpt.a(i2, heightAlignment) * heightAlignment);
    }

    @TargetApi(21)
    public final boolean a(int i) {
        if (this.f == null) {
            c("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = this.f.getAudioCapabilities();
        if (audioCapabilities == null) {
            c("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("sampleRate.support, ");
        sb.append(i);
        c(sb.toString());
        return false;
    }

    @TargetApi(21)
    public final boolean b(int i) {
        if (this.f == null) {
            c("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = this.f.getAudioCapabilities();
        if (audioCapabilities == null) {
            c("channelCount.aCaps");
            return false;
        }
        if (audioCapabilities.getMaxInputChannelCount() >= i) {
            return true;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("channelCount.support, ");
        sb.append(i);
        c(sb.toString());
        return false;
    }

    private final void c(String str) {
        String str2 = this.a;
        String str3 = this.e;
        String str4 = zzpt.e;
        StringBuilder sb = new StringBuilder(20 + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("NoSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append("] [");
        sb.append(str4);
        sb.append("]");
        Log.d("MediaCodecInfo", sb.toString());
    }

    @TargetApi(21)
    private static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (d == -1.0d || d <= 0.0d) {
            return videoCapabilities.isSizeSupported(i, i2);
        }
        return videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }
}
