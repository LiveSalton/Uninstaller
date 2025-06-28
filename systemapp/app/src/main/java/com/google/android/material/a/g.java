package com.google.android.material.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* compiled from: source */
/* loaded from: classes.dex */
public class g implements TypeEvaluator<Matrix> {
    private final float[] a = new float[9];
    private final float[] b = new float[9];
    private final Matrix c = new Matrix();

    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.a);
        matrix2.getValues(this.b);
        for (int i = 0; i < 9; i++) {
            this.b[i] = this.a[i] + ((this.b[i] - this.a[i]) * f);
        }
        this.c.setValues(this.b);
        return this.c;
    }
}
