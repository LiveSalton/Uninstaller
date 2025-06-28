package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: source */
/* loaded from: classes.dex */
class j {
    static int a(RecyclerView.s sVar, h hVar, View view, View view2, RecyclerView.i iVar, boolean z, boolean z2) {
        int max;
        if (iVar.v() == 0 || sVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(iVar.d(view), iVar.d(view2));
        int max2 = Math.max(iVar.d(view), iVar.d(view2));
        if (z2) {
            max = Math.max(0, (sVar.e() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (!z) {
            return max;
        }
        return Math.round((max * (Math.abs(hVar.b(view2) - hVar.a(view)) / (Math.abs(iVar.d(view) - iVar.d(view2)) + 1))) + (hVar.c() - hVar.a(view)));
    }

    static int a(RecyclerView.s sVar, h hVar, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.v() == 0 || sVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(iVar.d(view) - iVar.d(view2)) + 1;
        }
        return Math.min(hVar.f(), hVar.b(view2) - hVar.a(view));
    }

    static int b(RecyclerView.s sVar, h hVar, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.v() == 0 || sVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return sVar.e();
        }
        return (int) (((hVar.b(view2) - hVar.a(view)) / (Math.abs(iVar.d(view) - iVar.d(view2)) + 1)) * sVar.e());
    }
}
