package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* compiled from: source */
/* loaded from: classes.dex */
public class AppCompatToggleButton extends ToggleButton {
    private final l a;

    public AppCompatToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        aa.a(this, getContext());
        this.a = new l(this);
        this.a.a(attributeSet, i);
    }
}
