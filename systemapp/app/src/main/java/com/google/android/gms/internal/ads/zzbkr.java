package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbkr implements zzqu {
    private zzbdv a;
    private final Executor b;
    private final zzbkg c;
    private final Clock d;
    private boolean e = false;
    private boolean f = false;
    private zzbkk g = new zzbkk();

    public zzbkr(Executor executor, zzbkg zzbkgVar, Clock clock) {
        this.b = executor;
        this.c = zzbkgVar;
        this.d = clock;
    }

    private final void c() {
        try {
            JSONObject a = this.c.a(this.g);
            if (this.a != null) {
                this.b.execute(new Runnable(this, a) { // from class: com.google.android.gms.internal.ads.lk
                    private final zzbkr a;
                    private final JSONObject b;

                    {
                        this.a = this;
                        this.b = a;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.a(this.b);
                    }
                });
            }
        } catch (JSONException e) {
            zzd.a("Failed to call video active view js", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void a(zzqv zzqvVar) {
        this.g.a = this.f ? false : zzqvVar.j;
        this.g.c = this.d.b();
        this.g.e = zzqvVar;
        if (this.e) {
            c();
        }
    }

    public final void a(zzbdv zzbdvVar) {
        this.a = zzbdvVar;
    }

    public final void a() {
        this.e = false;
    }

    public final void b() {
        this.e = true;
        c();
    }

    public final void a(boolean z) {
        this.f = z;
    }

    final /* synthetic */ void a(JSONObject jSONObject) {
        this.a.a("AFMA_updateActiveView", jSONObject);
    }
}
