package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzwp extends AdListener {
    private final Object a = new Object();
    private AdListener b;

    public final void a(AdListener adListener) {
        synchronized (this.a) {
            this.b = adListener;
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void c() {
        synchronized (this.a) {
            if (this.b != null) {
                this.b.c();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void a(int i) {
        synchronized (this.a) {
            if (this.b != null) {
                this.b.a(i);
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void a(LoadAdError loadAdError) {
        synchronized (this.a) {
            if (this.b != null) {
                this.b.a(loadAdError);
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void d() {
        synchronized (this.a) {
            if (this.b != null) {
                this.b.d();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void b() {
        synchronized (this.a) {
            if (this.b != null) {
                this.b.b();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void a() {
        synchronized (this.a) {
            if (this.b != null) {
                this.b.a();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void f() {
        synchronized (this.a) {
            if (this.b != null) {
                this.b.f();
            }
        }
    }
}
