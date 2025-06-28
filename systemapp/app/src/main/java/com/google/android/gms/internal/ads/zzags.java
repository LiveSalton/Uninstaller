package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeContentAd;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzags extends zzafn {
    private final NativeContentAd.OnContentAdLoadedListener a;

    public zzags(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.a = onContentAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final void a(zzafb zzafbVar) {
        this.a.a(new zzafc(zzafbVar));
    }
}
