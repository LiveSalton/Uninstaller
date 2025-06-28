package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.cardview.widget.g;

/* compiled from: source */
/* loaded from: classes.dex */
class a extends c {
    a() {
    }

    /* compiled from: source */
    /* renamed from: androidx.cardview.widget.a$1 */
    class AnonymousClass1 implements g.a {
        AnonymousClass1() {
        }

        @Override // androidx.cardview.widget.g.a
        public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    @Override // androidx.cardview.widget.c, androidx.cardview.widget.e
    public void a() {
        g.a = new g.a() { // from class: androidx.cardview.widget.a.1
            AnonymousClass1() {
            }

            @Override // androidx.cardview.widget.g.a
            public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
                canvas.drawRoundRect(rectF, f, f, paint);
            }
        };
    }
}
