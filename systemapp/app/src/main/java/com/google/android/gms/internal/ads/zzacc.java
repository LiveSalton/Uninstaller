package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzacc extends zzaca {
    private final OnCustomRenderedAdLoadedListener a;

    public zzacc(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.a = onCustomRenderedAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzacb
    public final void a(zzabw zzabwVar) {
        this.a.a(new zzabx(zzabwVar));
    }
}
