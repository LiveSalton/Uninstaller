package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class rq implements zzahv {
    static final zzahv a = new rq();

    private rq() {
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final void a(Object obj, Map map) {
        zzd.b("Show native ad policy validator overlay.");
        ((zzbdv) obj).getView().setVisibility(0);
    }
}
