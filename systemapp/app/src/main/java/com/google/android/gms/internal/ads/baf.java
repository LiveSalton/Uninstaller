package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* compiled from: source */
/* loaded from: classes.dex */
final class baf implements bag {
    /* JADX INFO: Access modifiers changed from: private */
    baf() {
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final boolean b() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final int a() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final MediaCodecInfo a(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "video/avc".equals(str);
    }

    /* synthetic */ baf(bae baeVar) {
        this();
    }
}
