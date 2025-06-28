package com.google.android.material.a;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: source */
/* loaded from: classes.dex */
public class a {
    public static final TimeInterpolator a = new LinearInterpolator();
    public static final TimeInterpolator b = new androidx.d.a.a.b();
    public static final TimeInterpolator c = new androidx.d.a.a.a();
    public static final TimeInterpolator d = new androidx.d.a.a.c();
    public static final TimeInterpolator e = new DecelerateInterpolator();

    public static float a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int a(int i, int i2, float f) {
        return i + Math.round(f * (i2 - i));
    }
}
