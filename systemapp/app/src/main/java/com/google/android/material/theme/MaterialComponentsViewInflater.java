package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Keep;
import androidx.appcompat.app.e;
import androidx.appcompat.widget.AppCompatButton;
import com.google.android.material.button.MaterialButton;

/* compiled from: source */
@Keep
/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends e {
    @Override // androidx.appcompat.app.e
    protected AppCompatButton c(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }
}
