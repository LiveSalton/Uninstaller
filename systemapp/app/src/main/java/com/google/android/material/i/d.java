package com.google.android.material.i;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class d {
    public float a;
    public float b;
    public float c;
    public float d;
    private final List<c> e = new ArrayList();

    /* compiled from: source */
    public static abstract class c {
        protected final Matrix g = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public d() {
        a(0.0f, 0.0f);
    }

    public void a(float f, float f2) {
        this.a = f;
        this.b = f2;
        this.c = f;
        this.d = f2;
        this.e.clear();
    }

    public void b(float f, float f2) {
        b bVar = new b();
        bVar.a = f;
        bVar.b = f2;
        this.e.add(bVar);
        this.c = f;
        this.d = f2;
    }

    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        a aVar = new a(f, f2, f3, f4);
        aVar.e = f5;
        aVar.f = f6;
        this.e.add(aVar);
        double d = f5 + f6;
        this.c = ((f + f3) * 0.5f) + (((f3 - f) / 2.0f) * ((float) Math.cos(Math.toRadians(d))));
        this.d = ((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.sin(Math.toRadians(d))));
    }

    public void a(Matrix matrix, Path path) {
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            this.e.get(i).a(matrix, path);
        }
    }

    /* compiled from: source */
    public static class b extends c {
        private float a;
        private float b;

        @Override // com.google.android.material.i.d.c
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.g;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.a, this.b);
            path.transform(matrix);
        }
    }

    /* compiled from: source */
    public static class a extends c {
        private static final RectF h = new RectF();
        public float a;
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;

        public a(float f, float f2, float f3, float f4) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
        }

        @Override // com.google.android.material.i.d.c
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.g;
            matrix.invert(matrix2);
            path.transform(matrix2);
            h.set(this.a, this.b, this.c, this.d);
            path.arcTo(h, this.e, this.f, false);
            path.transform(matrix);
        }
    }
}
