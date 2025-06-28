package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
class aj {
    static final Property<View, Float> a;
    static final Property<View, Rect> b;
    private static final ap c;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            c = new ao();
        } else if (Build.VERSION.SDK_INT >= 23) {
            c = new an();
        } else if (Build.VERSION.SDK_INT >= 22) {
            c = new am();
        } else if (Build.VERSION.SDK_INT >= 21) {
            c = new al();
        } else if (Build.VERSION.SDK_INT >= 19) {
            c = new ak();
        } else {
            c = new ap();
        }
        a = new Property<View, Float>(Float.class, "translationAlpha") { // from class: androidx.transition.aj.1
            AnonymousClass1(Class cls, String str) {
                super(cls, str);
            }

            @Override // android.util.Property
            /* renamed from: a */
            public Float get(View view) {
                return Float.valueOf(aj.c(view));
            }

            @Override // android.util.Property
            /* renamed from: a */
            public void set(View view, Float f) {
                aj.a(view, f.floatValue());
            }
        };
        b = new Property<View, Rect>(Rect.class, "clipBounds") { // from class: androidx.transition.aj.2
            AnonymousClass2(Class cls, String str) {
                super(cls, str);
            }

            @Override // android.util.Property
            /* renamed from: a */
            public Rect get(View view) {
                return androidx.core.h.w.E(view);
            }

            @Override // android.util.Property
            /* renamed from: a */
            public void set(View view, Rect rect) {
                androidx.core.h.w.a(view, rect);
            }
        };
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.aj$1 */
    static class AnonymousClass1 extends Property<View, Float> {
        AnonymousClass1(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(aj.c(view));
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(View view, Float f) {
            aj.a(view, f.floatValue());
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.aj$2 */
    static class AnonymousClass2 extends Property<View, Rect> {
        AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Rect get(View view) {
            return androidx.core.h.w.E(view);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(View view, Rect rect) {
            androidx.core.h.w.a(view, rect);
        }
    }

    static ai a(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ah(view);
        }
        return ag.d(view);
    }

    static at b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new as(view);
        }
        return new ar(view.getWindowToken());
    }

    static void a(View view, float f) {
        c.a(view, f);
    }

    static float c(View view) {
        return c.a(view);
    }

    static void d(View view) {
        c.b(view);
    }

    static void e(View view) {
        c.c(view);
    }

    static void a(View view, int i) {
        c.a(view, i);
    }

    static void a(View view, Matrix matrix) {
        c.a(view, matrix);
    }

    static void b(View view, Matrix matrix) {
        c.b(view, matrix);
    }

    static void c(View view, Matrix matrix) {
        c.c(view, matrix);
    }

    static void a(View view, int i, int i2, int i3, int i4) {
        c.a(view, i, i2, i3, i4);
    }
}
