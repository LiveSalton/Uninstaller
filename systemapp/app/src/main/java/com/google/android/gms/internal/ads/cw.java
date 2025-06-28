package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
final class cw implements zzaih {
    private final zzazq<O> a;
    private final /* synthetic */ zzamx b;

    public cw(zzamx zzamxVar, zzazq<O> zzazqVar) {
        this.b = zzamxVar;
        this.a = zzazqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaih
    public final void a(JSONObject jSONObject) {
        zzamf zzamfVar;
        try {
            zzazq<O> zzazqVar = this.a;
            zzamfVar = this.b.a;
            zzazqVar.b(zzamfVar.a(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.a.a(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaih
    public final void a(String str) {
        try {
            if (str == null) {
                this.a.a(new zzama());
            } else {
                this.a.a(new zzama(str));
            }
        } catch (IllegalStateException unused) {
        }
    }
}
