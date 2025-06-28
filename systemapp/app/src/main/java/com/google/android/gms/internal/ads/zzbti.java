package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbti extends zzbwk<AdMetadataListener> implements zzagy {
    private Bundle a;

    public zzbti(Set<zzbxy<AdMetadataListener>> set) {
        super(set);
        this.a = new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzagy
    public final synchronized void a(String str, Bundle bundle) {
        this.a.putAll(bundle);
        a(nk.a);
    }

    public final synchronized Bundle a() {
        return new Bundle(this.a);
    }
}
