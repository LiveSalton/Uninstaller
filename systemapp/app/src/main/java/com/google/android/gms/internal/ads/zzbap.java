package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;

/* compiled from: source */
@TargetApi(14)
/* loaded from: classes.dex */
public abstract class zzbap extends TextureView implements gs {
    protected final zzbaz a;
    protected final zzbbj b;

    public zzbap(Context context) {
        super(context);
        this.a = new zzbaz();
        this.b = new zzbbj(context, this);
    }

    public abstract String a();

    public abstract void a(float f, float f2);

    public abstract void a(int i);

    public abstract void a(zzbam zzbamVar);

    public abstract void b();

    public abstract void c();

    public void c(int i) {
    }

    public abstract void d();

    public void d(int i) {
    }

    public abstract long e();

    public void e(int i) {
    }

    public abstract long f();

    public void f(int i) {
    }

    public abstract int g();

    public void g(int i) {
    }

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract long getTotalBytes();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void h();

    public abstract void setVideoPath(String str);

    public void a(String str, String[] strArr) {
        setVideoPath(str);
    }
}
