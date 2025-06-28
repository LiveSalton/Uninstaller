package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzaka extends zzakn<zzalz> implements zzakj, zzako {
    private final zzbgb a;
    private zzakr b;

    public zzaka(Context context, zzazh zzazhVar) throws zzbeh {
        try {
            this.a = new zzbgb(context, new bf(this));
            this.a.setWillNotDraw(true);
            this.a.addJavascriptInterface(new bg(this), "GoogleJsInterface");
            zzp.c().a(context, zzazhVar.a, this.a.getSettings());
            super.a(this);
        } catch (Throwable th) {
            throw new zzbeh("Init failed.", th);
        }
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

    @Override // com.google.android.gms.internal.ads.zzako
    public final void a(String str) {
        b(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", str));
    }

    @Override // com.google.android.gms.internal.ads.zzako
    public final void b(String str) {
        zzazj.e.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.bc
            private final zzaka a;
            private final String b;

            {
                this.a = this;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.g(this.b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzako
    public final void c(String str) {
        zzazj.e.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.bb
            private final zzaka a;
            private final String b;

            {
                this.a = this;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.f(this.b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzako
    public final void a(zzakr zzakrVar) {
        this.b = zzakrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzako
    public final void a() {
        this.a.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzako
    public final boolean b() {
        return this.a.F();
    }

    @Override // com.google.android.gms.internal.ads.zzako
    public final zzaly c() {
        return new zzamb(this);
    }

    @Override // com.google.android.gms.internal.ads.zzakj, com.google.android.gms.internal.ads.zzaky
    public final void d(String str) {
        zzazj.e.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.be
            private final zzaka a;
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

    final /* synthetic */ void e(String str) {
        this.a.d(str);
    }

    final /* synthetic */ void f(String str) {
        this.a.loadUrl(str);
    }

    final /* synthetic */ void g(String str) {
        this.a.loadData(str, "text/html", "UTF-8");
    }
}
