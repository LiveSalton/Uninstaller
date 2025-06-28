package androidx.core.h;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

/* compiled from: source */
/* loaded from: classes.dex */
public interface u {
    ColorStateList getSupportBackgroundTintList();

    PorterDuff.Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(ColorStateList colorStateList);

    void setSupportBackgroundTintMode(PorterDuff.Mode mode);
}
