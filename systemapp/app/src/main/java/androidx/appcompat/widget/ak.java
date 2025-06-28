package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* compiled from: source */
/* loaded from: classes.dex */
public class ak extends Resources {
    private static boolean a = false;
    private final WeakReference<Context> b;

    public static boolean a() {
        return b() && Build.VERSION.SDK_INT <= 20;
    }

    public ak(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.b = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Context context = this.b.get();
        if (context != null) {
            return v.a().a(context, this, i);
        }
        return super.getDrawable(i);
    }

    final Drawable a(int i) {
        return super.getDrawable(i);
    }

    public static boolean b() {
        return a;
    }
}
