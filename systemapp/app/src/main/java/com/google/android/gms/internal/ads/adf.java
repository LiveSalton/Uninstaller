package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
final class adf implements zzdfj<Bundle> {
    private final String a;
    private final String b;
    private final Bundle c;

    /* JADX INFO: Access modifiers changed from: private */
    adf(String str, String str2, Bundle bundle) {
        this.a = str;
        this.b = str2;
        this.c = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("consent_string", this.a);
        bundle2.putString("fc_consent", this.b);
        bundle2.putBundle("iab_consent_info", this.c);
    }

    /* synthetic */ adf(String str, String str2, Bundle bundle, adg adgVar) {
        this(str, str2, bundle);
    }
}
