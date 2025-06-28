package androidx.transition;

import android.view.ViewGroup;
import androidx.transition.p;

/* compiled from: source */
/* loaded from: classes.dex */
public class r {
    private ViewGroup a;
    private Runnable b;

    public void a() {
        if (a(this.a) != this || this.b == null) {
            return;
        }
        this.b.run();
    }

    static void a(ViewGroup viewGroup, r rVar) {
        viewGroup.setTag(p.a.transition_current_scene, rVar);
    }

    public static r a(ViewGroup viewGroup) {
        return (r) viewGroup.getTag(p.a.transition_current_scene);
    }
}
