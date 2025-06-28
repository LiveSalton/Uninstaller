package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: source */
/* loaded from: classes.dex */
class f {
    int b;
    int c;
    int d;
    int e;
    boolean h;
    boolean i;
    boolean a = true;
    int f = 0;
    int g = 0;

    f() {
    }

    boolean a(RecyclerView.s sVar) {
        return this.c >= 0 && this.c < sVar.e();
    }

    View a(RecyclerView.o oVar) {
        View c = oVar.c(this.c);
        this.c += this.d;
        return c;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.b + ", mCurrentPosition=" + this.c + ", mItemDirection=" + this.d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }
}
