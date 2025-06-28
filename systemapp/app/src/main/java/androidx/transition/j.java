package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: source */
/* loaded from: classes.dex */
class j {
    static f a(View view, ViewGroup viewGroup, Matrix matrix) {
        if (Build.VERSION.SDK_INT == 28) {
            return h.a(view, viewGroup, matrix);
        }
        return i.b(view, viewGroup, matrix);
    }

    static void a(View view) {
        if (Build.VERSION.SDK_INT == 28) {
            h.a(view);
        } else {
            i.b(view);
        }
    }
}
