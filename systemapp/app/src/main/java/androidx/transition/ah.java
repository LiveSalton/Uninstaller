package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* compiled from: source */
/* loaded from: classes.dex */
class ah implements ai {
    private final ViewOverlay a;

    ah(View view) {
        this.a = view.getOverlay();
    }

    @Override // androidx.transition.ai
    public void a(Drawable drawable) {
        this.a.add(drawable);
    }

    @Override // androidx.transition.ai
    public void b(Drawable drawable) {
        this.a.remove(drawable);
    }
}
