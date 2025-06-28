package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
final class cq implements zzaih {
    private final zzalo a;
    private final zzazq<O> b;
    private final /* synthetic */ zzamm c;

    public cq(zzamm zzammVar, zzalo zzaloVar, zzazq<O> zzazqVar) {
        this.c = zzammVar;
        this.a = zzaloVar;
        this.b = zzazqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaih
    public final void a(JSONObject jSONObject) {
        zzamf zzamfVar;
        try {
            try {
                zzazq<O> zzazqVar = this.b;
                zzamfVar = this.c.a;
                zzazqVar.b(zzamfVar.a(jSONObject));
                this.a.a();
            } catch (IllegalStateException unused) {
                this.a.a();
            } catch (JSONException e) {
                this.b.a(e);
                this.a.a();
            }
        } catch (Throwable th) {
            this.a.a();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaih
    public final void a(String str) {
        try {
            if (str == null) {
                this.b.a(new zzama());
            } else {
                this.b.a(new zzama(str));
            }
            this.a.a();
        } catch (IllegalStateException unused) {
            this.a.a();
        } catch (Throwable th) {
            this.a.a();
            throw th;
        }
    }
}
