package com.google.android.material.a;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* compiled from: source */
/* loaded from: classes.dex */
public class f extends Property<ImageView, Matrix> {
    private final Matrix a;

    public f() {
        super(Matrix.class, "imageMatrixProperty");
        this.a = new Matrix();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Matrix get(ImageView imageView) {
        this.a.set(imageView.getImageMatrix());
        return this.a;
    }
}
