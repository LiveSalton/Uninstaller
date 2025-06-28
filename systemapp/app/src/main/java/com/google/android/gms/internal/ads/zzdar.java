package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdar implements zzdfj<Bundle> {
    private final Bundle a;

    /* JADX INFO: Access modifiers changed from: private */
    zzdar(Bundle bundle) {
        this.a = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (this.a.isEmpty()) {
            return;
        }
        bundle2.putBundle("installed_adapter_data", this.a);
    }

    /* synthetic */ zzdar(Bundle bundle, acm acmVar) {
        this(bundle);
    }
}
