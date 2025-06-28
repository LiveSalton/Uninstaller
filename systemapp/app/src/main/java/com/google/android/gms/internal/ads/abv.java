package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class abv implements zzdvm {
    static final zzdvm a = new abv();

    private abv() {
    }

    @Override // com.google.android.gms.internal.ads.zzdvm
    public final Object a(Object obj) {
        String optString;
        optString = ((JSONObject) obj).optString("nas");
        return optString;
    }
}
