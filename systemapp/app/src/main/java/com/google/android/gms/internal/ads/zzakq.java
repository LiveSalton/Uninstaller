package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Predicate;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzakq implements zzakj, zzako {
    private final zzbdv a;

    public zzakq(Context context, zzazh zzazhVar, zzef zzefVar, com.google.android.gms.ads.internal.zzb zzbVar) throws zzbeh {
        zzp.d();
        this.a = zzbed.a(context, zzbfn.a(), "", false, false, zzefVar, null, zzazhVar, null, null, null, zzts.a(), null, false, null, null);
        this.a.getView().setWillNotDraw(true);
    }

    @Override // com.google.android.gms.internal.ads.zzakj
    public final void a(String str, String str2) {
        zzaki.a(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzakb
    public final void a(String str, Map map) {
        zzaki.a(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzaky
    public final void a(String str, JSONObject jSONObject) {
        zzaki.a(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzakj, com.google.android.gms.internal.ads.zzakb
    public final void b(String str, JSONObject jSONObject) {
        zzaki.b(this, str, jSONObject);
    }

    private static void a(Runnable runnable) {
        zzwq.a();
        if (zzayr.b()) {
            runnable.run();
        } else {
            com.google.android.gms.ads.internal.util.zzm.a.post(runnable);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzakj, com.google.android.gms.internal.ads.zzaky
    public final void d(String str) {
        a(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.bk
            private final zzakq a;
            private final String b;

            {
                this.a = this;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.e(this.b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzako
    public final void a(String str) {
        a(new bl(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str)));
    }

    @Override // com.google.android.gms.internal.ads.zzako
    public final void b(String str) {
        a(new bo(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzako
    public final void c(String str) {
        a(new bn(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzalz
    public final void a(String str, zzahv<? super zzalz> zzahvVar) {
        this.a.a(str, new bp(this, zzahvVar));
    }

    @Override // com.google.android.gms.internal.ads.zzalz
    public final void b(String str, zzahv<? super zzalz> zzahvVar) {
        this.a.a(str, new Predicate(zzahvVar) { // from class: com.google.android.gms.internal.ads.bj
            private final zzahv a;

            {
                this.a = zzahvVar;
            }

            @Override // com.google.android.gms.common.util.Predicate
            public final boolean a(Object obj) {
                zzahv zzahvVar2;
                zzahv zzahvVar3 = this.a;
                zzahv zzahvVar4 = (zzahv) obj;
                if (!(zzahvVar4 instanceof bp)) {
                    return false;
                }
                zzahvVar2 = ((bp) zzahvVar4).a;
                return zzahvVar2.equals(zzahvVar3);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzako
    public final void a(zzakr zzakrVar) {
        zzbfg z = this.a.z();
        zzakrVar.getClass();
        z.a(bm.a(zzakrVar));
    }

    @Override // com.google.android.gms.internal.ads.zzako
    public final zzaly c() {
        return new zzamb(this);
    }

    @Override // com.google.android.gms.internal.ads.zzako
    public final void a() {
        this.a.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzako
    public final boolean b() {
        return this.a.F();
    }

    final /* synthetic */ void e(String str) {
        this.a.d(str);
    }
}
