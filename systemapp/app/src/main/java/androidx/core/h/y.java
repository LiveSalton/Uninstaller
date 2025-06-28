package androidx.core.h;

import android.os.Build;
import android.view.ViewGroup;
import androidx.core.a;

/* compiled from: source */
/* loaded from: classes.dex */
public final class y {
    public static boolean a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(a.b.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && w.r(viewGroup) == null) ? false : true;
    }
}
