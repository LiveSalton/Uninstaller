package com.google.android.material.bottomappbar;

import com.google.android.material.i.b;
import com.google.android.material.i.d;

/* compiled from: source */
/* loaded from: classes.dex */
public class a extends b {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;

    public a(float f, float f2, float f3) {
        this.b = f;
        this.a = f2;
        this.d = f3;
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.e = 0.0f;
    }

    @Override // com.google.android.material.i.b
    public void a(float f, float f2, d dVar) {
        if (this.c == 0.0f) {
            dVar.b(f, 0.0f);
            return;
        }
        float f3 = ((this.b * 2.0f) + this.c) / 2.0f;
        float f4 = f2 * this.a;
        float f5 = (f / 2.0f) + this.e;
        float f6 = (this.d * f2) + ((1.0f - f2) * f3);
        if (f6 / f3 >= 1.0f) {
            dVar.b(f, 0.0f);
            return;
        }
        float f7 = f3 + f4;
        float f8 = f6 + f4;
        float sqrt = (float) Math.sqrt((f7 * f7) - (f8 * f8));
        float f9 = f5 - sqrt;
        float f10 = f5 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f8));
        float f11 = 90.0f - degrees;
        float f12 = f9 - f4;
        dVar.b(f12, 0.0f);
        float f13 = f4 * 2.0f;
        dVar.a(f12, 0.0f, f9 + f4, f13, 270.0f, degrees);
        dVar.a(f5 - f3, (-f3) - f6, f5 + f3, f3 - f6, 180.0f - f11, (f11 * 2.0f) - 180.0f);
        dVar.a(f10 - f4, 0.0f, f10 + f4, f13, 270.0f - degrees, degrees);
        dVar.b(f, 0.0f);
    }

    void a(float f) {
        this.e = f;
    }

    float a() {
        return this.e;
    }

    float b() {
        return this.d;
    }

    void b(float f) {
        this.d = f;
    }

    float c() {
        return this.c;
    }

    void c(float f) {
        this.c = f;
    }

    float d() {
        return this.b;
    }

    void d(float f) {
        this.b = f;
    }

    float e() {
        return this.a;
    }

    void e(float f) {
        this.a = f;
    }
}
