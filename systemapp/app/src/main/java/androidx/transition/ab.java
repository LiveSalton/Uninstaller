package androidx.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: source */
/* loaded from: classes.dex */
class ab extends ag implements ad {
    ab(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    static ab a(ViewGroup viewGroup) {
        return (ab) ag.d(viewGroup);
    }

    @Override // androidx.transition.ad
    public void a(View view) {
        this.a.a(view);
    }

    @Override // androidx.transition.ad
    public void b(View view) {
        this.a.b(view);
    }
}
