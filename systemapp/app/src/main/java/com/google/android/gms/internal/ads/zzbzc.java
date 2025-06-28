package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzbzc {
    private final zzcaf a;
    private final zzbdv b;

    public zzbzc(zzcaf zzcafVar) {
        this(zzcafVar, null);
    }

    public zzbzc(zzcaf zzcafVar, zzbdv zzbdvVar) {
        this.a = zzcafVar;
        this.b = zzbdvVar;
    }

    public final zzcaf a() {
        return this.a;
    }

    public final zzbdv b() {
        return this.b;
    }

    public final View c() {
        if (this.b != null) {
            return this.b.getWebView();
        }
        return null;
    }

    public final View d() {
        if (this.b == null) {
            return null;
        }
        return this.b.getWebView();
    }

    public Set<zzbxy<zzbru>> a(zzbqu zzbquVar) {
        return Collections.singleton(zzbxy.a(zzbquVar, zzazj.f));
    }

    public Set<zzbxy<zzbxn>> b(zzbqu zzbquVar) {
        return Collections.singleton(zzbxy.a(zzbquVar, zzazj.f));
    }

    public final zzbxy<zzbvs> a(Executor executor) {
        return new zzbxy<>(new zzbvs(this.b) { // from class: com.google.android.gms.internal.ads.qh
            private final zzbdv a;

            {
                this.a = zzbdvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbvs
            public final void a() {
                zzbdv zzbdvVar2 = this.a;
                if (zzbdvVar2.v() != null) {
                    zzbdvVar2.v().a();
                }
            }
        }, executor);
    }
}
