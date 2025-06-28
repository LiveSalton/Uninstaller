package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

/* compiled from: source */
/* loaded from: classes.dex */
public interface l {
    ColorStateList getSupportImageTintList();

    PorterDuff.Mode getSupportImageTintMode();

    void setSupportImageTintList(ColorStateList colorStateList);

    void setSupportImageTintMode(PorterDuff.Mode mode);
}
