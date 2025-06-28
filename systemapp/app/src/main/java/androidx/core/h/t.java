package androidx.core.h;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

/* compiled from: source */
/* loaded from: classes.dex */
public final class t {
    private Object a;

    private t(Object obj) {
        this.a = obj;
    }

    public Object a() {
        return this.a;
    }

    public static t a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new t(PointerIcon.getSystemIcon(context, i));
        }
        return new t(null);
    }
}
