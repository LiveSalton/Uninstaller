package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import javax.annotation.Nullable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdby implements zzdfj<Bundle> {
    private final String a;

    public zzdby(@Nullable String str) {
        this.a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (TextUtils.isEmpty(this.a)) {
            return;
        }
        bundle2.putString("fwd_cld", this.a);
    }
}
