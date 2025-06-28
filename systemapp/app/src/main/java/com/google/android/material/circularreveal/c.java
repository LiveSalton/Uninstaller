package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.circularreveal.b;

/* compiled from: source */
/* loaded from: classes.dex */
public interface c extends b.a {
    void a();

    int getCircularRevealScrimColor();

    d getRevealInfo();

    void s_();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(d dVar);

    /* compiled from: source */
    public static class d {
        public float a;
        public float b;
        public float c;

        /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }

        private d() {
        }

        public d(float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }

        public d(d dVar) {
            this(dVar.a, dVar.b, dVar.c);
        }

        public void a(float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }

        public void a(d dVar) {
            a(dVar.a, dVar.b, dVar.c);
        }

        public boolean a() {
            return this.c == Float.MAX_VALUE;
        }
    }

    /* compiled from: source */
    public static class b extends Property<c, d> {
        public static final Property<c, d> a = new b("circularReveal");

        private b(String str) {
            super(d.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public d get(c cVar) {
            return cVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(c cVar, d dVar) {
            cVar.setRevealInfo(dVar);
        }
    }

    /* compiled from: source */
    public static class a implements TypeEvaluator<d> {
        public static final TypeEvaluator<d> a = new a();
        private final d b = new d();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public d evaluate(float f, d dVar, d dVar2) {
            this.b.a(com.google.android.material.e.a.a(dVar.a, dVar2.a, f), com.google.android.material.e.a.a(dVar.b, dVar2.b, f), com.google.android.material.e.a.a(dVar.c, dVar2.c, f));
            return this.b;
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.circularreveal.c$c */
    public static class C0081c extends Property<c, Integer> {
        public static final Property<c, Integer> a = new C0081c("circularRevealScrimColor");

        private C0081c(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(c cVar) {
            return Integer.valueOf(cVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(c cVar, Integer num) {
            cVar.setCircularRevealScrimColor(num.intValue());
        }
    }
}
