package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.os.Handler;

/* compiled from: source */
@TargetApi(23)
/* loaded from: classes.dex */
final class bbj implements MediaCodec.OnFrameRenderedListener {
    private final /* synthetic */ zzqa a;

    /* JADX INFO: Access modifiers changed from: private */
    bbj(zzqa zzqaVar, MediaCodec mediaCodec) {
        this.a = zzqaVar;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        if (this != this.a.b) {
            return;
        }
        this.a.v();
    }

    /* synthetic */ bbj(zzqa zzqaVar, MediaCodec mediaCodec, bbi bbiVar) {
        this(zzqaVar, mediaCodec);
    }
}
