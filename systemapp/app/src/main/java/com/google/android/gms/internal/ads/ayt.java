package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

/* compiled from: source */
@TargetApi(24)
/* loaded from: classes.dex */
final class ayt {
    private final MediaCodec.CryptoInfo a;
    private final MediaCodec.CryptoInfo.Pattern b;

    /* JADX INFO: Access modifiers changed from: private */
    ayt(MediaCodec.CryptoInfo cryptoInfo) {
        this.a = cryptoInfo;
        this.b = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    public final void a(int i, int i2) {
        this.b.set(0, 0);
        this.a.setPattern(this.b);
    }

    /* synthetic */ ayt(MediaCodec.CryptoInfo cryptoInfo, ayu ayuVar) {
        this(cryptoInfo);
    }
}
