package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListView;

/* compiled from: source */
/* loaded from: classes.dex */
public final class g {
    public static void a(ListView listView, int i) {
        View childAt;
        if (Build.VERSION.SDK_INT >= 19) {
            listView.scrollListBy(i);
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition == -1 || (childAt = listView.getChildAt(0)) == null) {
            return;
        }
        listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
    }

    public static boolean b(ListView listView, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            return listView.canScrollList(i);
        }
        int childCount = listView.getChildCount();
        if (childCount == 0) {
            return false;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (i > 0) {
            return firstVisiblePosition + childCount < listView.getCount() || listView.getChildAt(childCount + (-1)).getBottom() > listView.getHeight() - listView.getListPaddingBottom();
        }
        return firstVisiblePosition > 0 || listView.getChildAt(0).getTop() < listView.getListPaddingTop();
    }
}
