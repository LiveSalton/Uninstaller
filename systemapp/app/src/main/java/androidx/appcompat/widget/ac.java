package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public class ac extends ContextWrapper {
    private static final Object a = new Object();
    private static ArrayList<WeakReference<ac>> b;
    private final Resources c;
    private final Resources.Theme d;

    public static Context a(Context context) {
        if (!b(context)) {
            return context;
        }
        synchronized (a) {
            if (b == null) {
                b = new ArrayList<>();
            } else {
                for (int size = b.size() - 1; size >= 0; size--) {
                    WeakReference<ac> weakReference = b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        b.remove(size);
                    }
                }
                for (int size2 = b.size() - 1; size2 >= 0; size2--) {
                    WeakReference<ac> weakReference2 = b.get(size2);
                    ac acVar = weakReference2 != null ? weakReference2.get() : null;
                    if (acVar != null && acVar.getBaseContext() == context) {
                        return acVar;
                    }
                }
            }
            ac acVar2 = new ac(context);
            b.add(new WeakReference<>(acVar2));
            return acVar2;
        }
    }

    private static boolean b(Context context) {
        if ((context instanceof ac) || (context.getResources() instanceof ae) || (context.getResources() instanceof ak)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || ak.a();
    }

    private ac(Context context) {
        super(context);
        if (ak.a()) {
            this.c = new ak(this, context.getResources());
            this.d = this.c.newTheme();
            this.d.setTo(context.getTheme());
        } else {
            this.c = new ae(this, context.getResources());
            this.d = null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        return this.d == null ? super.getTheme() : this.d;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.d == null) {
            super.setTheme(i);
        } else {
            this.d.applyStyle(i, true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.c.getAssets();
    }
}
