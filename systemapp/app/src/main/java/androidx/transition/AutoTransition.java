package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;

/* compiled from: source */
/* loaded from: classes.dex */
public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        t();
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        t();
    }

    private void t() {
        a(1);
        a(new Fade(2)).a(new ChangeBounds()).a(new Fade(1));
    }
}
