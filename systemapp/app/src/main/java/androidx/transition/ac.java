package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* compiled from: source */
/* loaded from: classes.dex */
class ac implements ad {
    private final ViewGroupOverlay a;

    ac(ViewGroup viewGroup) {
        this.a = viewGroup.getOverlay();
    }

    @Override // androidx.transition.ai
    public void a(Drawable drawable) {
        this.a.add(drawable);
    }

    @Override // androidx.transition.ai
    public void b(Drawable drawable) {
        this.a.remove(drawable);
    }

    @Override // androidx.transition.ad
    public void a(View view) {
        this.a.add(view);
    }

    @Override // androidx.transition.ad
    public void b(View view) {
        this.a.remove(view);
    }
}
