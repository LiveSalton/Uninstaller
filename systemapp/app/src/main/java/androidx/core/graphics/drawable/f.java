package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* compiled from: source */
/* loaded from: classes.dex */
final class f extends Drawable.ConstantState {
    int a;
    Drawable.ConstantState b;
    ColorStateList c;
    PorterDuff.Mode d;

    f(f fVar) {
        this.c = null;
        this.d = d.a;
        if (fVar != null) {
            this.a = fVar.a;
            this.b = fVar.b;
            this.c = fVar.c;
            this.d = fVar.d;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new e(this, resources);
        }
        return new d(this, resources);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.a | (this.b != null ? this.b.getChangingConfigurations() : 0);
    }

    boolean a() {
        return this.b != null;
    }
}
