package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* compiled from: source */
@TargetApi(21)
/* loaded from: classes.dex */
final class bah implements bag {
    private final int a;
    private MediaCodecInfo[] b;

    public bah(boolean z) {
        this.a = z ? 1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final boolean b() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final int a() {
        c();
        return this.b.length;
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final MediaCodecInfo a(int i) {
        c();
        return this.b[i];
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private final void c() {
        if (this.b == null) {
            this.b = new MediaCodecList(this.a).getCodecInfos();
        }
    }
}
