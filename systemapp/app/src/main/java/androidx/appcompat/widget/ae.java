package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* compiled from: source */
/* loaded from: classes.dex */
class ae extends w {
    private final WeakReference<Context> a;

    public ae(Context context, Resources resources) {
        super(resources);
        this.a = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.w, android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i);
        Context context = this.a.get();
        if (drawable != null && context != null) {
            v.a().a(context, i, drawable);
        }
        return drawable;
    }
}
