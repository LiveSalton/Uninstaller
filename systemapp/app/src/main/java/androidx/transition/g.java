package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.transition.p;
import java.util.ArrayList;

/* compiled from: source */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class g extends FrameLayout {
    private ViewGroup a;
    private boolean b;

    g(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.a = viewGroup;
        this.a.setTag(p.a.ghost_view_holder, this);
        ae.a(this.a).a(this);
        this.b = true;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (!this.b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        super.onViewAdded(view);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.a.setTag(p.a.ghost_view_holder, null);
            ae.a(this.a).b(this);
            this.b = false;
        }
    }

    static g a(ViewGroup viewGroup) {
        return (g) viewGroup.getTag(p.a.ghost_view_holder);
    }

    void a() {
        if (!this.b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        ae.a(this.a).b(this);
        ae.a(this.a).a(this);
    }

    void a(i iVar) {
        ArrayList<View> arrayList = new ArrayList<>();
        a(iVar.c, arrayList);
        int a = a(arrayList);
        if (a < 0 || a >= getChildCount()) {
            addView(iVar);
        } else {
            addView(iVar, a);
        }
    }

    private int a(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i = 0;
        while (i <= childCount) {
            int i2 = (i + childCount) / 2;
            a(((i) getChildAt(i2)).c, (ArrayList<View>) arrayList2);
            if (a(arrayList, (ArrayList<View>) arrayList2)) {
                i = i2 + 1;
            } else {
                childCount = i2 - 1;
            }
            arrayList2.clear();
        }
        return i;
    }

    private static boolean a(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int min = Math.min(arrayList.size(), arrayList2.size());
        for (int i = 1; i < min; i++) {
            View view = arrayList.get(i);
            View view2 = arrayList2.get(i);
            if (view != view2) {
                return a(view, view2);
            }
        }
        return arrayList2.size() == min;
    }

    private static void a(View view, ArrayList<View> arrayList) {
        Object parent = view.getParent();
        if (parent instanceof ViewGroup) {
            a((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    private static boolean a(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (Build.VERSION.SDK_INT >= 21 && view.getZ() != view2.getZ()) {
            return view.getZ() > view2.getZ();
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(ae.a(viewGroup, i));
            if (childAt == view) {
                return false;
            }
            if (childAt == view2) {
                return true;
            }
        }
        return true;
    }
}
