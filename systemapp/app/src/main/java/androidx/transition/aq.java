package androidx.transition;

import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class aq extends w {
    private static final String[] a = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    @Override // androidx.transition.w
    public void a(y yVar) {
        View view = yVar.b;
        Integer num = (Integer) yVar.a.get("android:visibility:visibility");
        if (num == null) {
            num = Integer.valueOf(view.getVisibility());
        }
        yVar.a.put("android:visibilityPropagation:visibility", num);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        iArr[0] = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = iArr[0] + (view.getWidth() / 2);
        iArr[1] = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = iArr[1] + (view.getHeight() / 2);
        yVar.a.put("android:visibilityPropagation:center", iArr);
    }

    @Override // androidx.transition.w
    public String[] a() {
        return a;
    }

    public int b(y yVar) {
        Integer num;
        if (yVar == null || (num = (Integer) yVar.a.get("android:visibilityPropagation:visibility")) == null) {
            return 8;
        }
        return num.intValue();
    }

    public int c(y yVar) {
        return a(yVar, 0);
    }

    public int d(y yVar) {
        return a(yVar, 1);
    }

    private static int a(y yVar, int i) {
        int[] iArr;
        if (yVar == null || (iArr = (int[]) yVar.a.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i];
    }
}
