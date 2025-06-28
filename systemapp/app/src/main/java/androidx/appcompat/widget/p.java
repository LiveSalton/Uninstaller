package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;

/* compiled from: source */
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class p {
    private static Class<?> d;
    private static final int[] b = {R.attr.state_checked};
    private static final int[] c = new int[0];
    public static final Rect a = new Rect();

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                d = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0099 A[Catch: Exception -> 0x00b8, TryCatch #0 {Exception -> 0x00b8, blocks: (B:11:0x0024, B:13:0x003d, B:15:0x004c, B:25:0x0095, B:29:0x0099, B:31:0x00a0, B:33:0x00a7, B:35:0x00ae, B:37:0x006c, B:40:0x0076, B:43:0x0080, B:46:0x008a), top: B:10:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0 A[Catch: Exception -> 0x00b8, TryCatch #0 {Exception -> 0x00b8, blocks: (B:11:0x0024, B:13:0x003d, B:15:0x004c, B:25:0x0095, B:29:0x0099, B:31:0x00a0, B:33:0x00a7, B:35:0x00ae, B:37:0x006c, B:40:0x0076, B:43:0x0080, B:46:0x008a), top: B:10:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a7 A[Catch: Exception -> 0x00b8, TryCatch #0 {Exception -> 0x00b8, blocks: (B:11:0x0024, B:13:0x003d, B:15:0x004c, B:25:0x0095, B:29:0x0099, B:31:0x00a0, B:33:0x00a7, B:35:0x00ae, B:37:0x006c, B:40:0x0076, B:43:0x0080, B:46:0x008a), top: B:10:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ae A[Catch: Exception -> 0x00b8, TRY_LEAVE, TryCatch #0 {Exception -> 0x00b8, blocks: (B:11:0x0024, B:13:0x003d, B:15:0x004c, B:25:0x0095, B:29:0x0099, B:31:0x00a0, B:33:0x00a7, B:35:0x00ae, B:37:0x006c, B:40:0x0076, B:43:0x0080, B:46:0x008a), top: B:10:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Rect a(android.graphics.drawable.Drawable r10) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 < r1) goto L20
            android.graphics.Insets r10 = r10.getOpticalInsets()
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            int r1 = r10.left
            r0.left = r1
            int r1 = r10.right
            r0.right = r1
            int r1 = r10.top
            r0.top = r1
            int r10 = r10.bottom
            r0.bottom = r10
            return r0
        L20:
            java.lang.Class<?> r0 = androidx.appcompat.widget.p.d
            if (r0 == 0) goto Lbf
            android.graphics.drawable.Drawable r10 = androidx.core.graphics.drawable.a.h(r10)     // Catch: java.lang.Exception -> Lb8
            java.lang.Class r0 = r10.getClass()     // Catch: java.lang.Exception -> Lb8
            java.lang.String r1 = "getOpticalInsets"
            r2 = 0
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> Lb8
            java.lang.reflect.Method r0 = r0.getMethod(r1, r3)     // Catch: java.lang.Exception -> Lb8
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> Lb8
            java.lang.Object r10 = r0.invoke(r10, r1)     // Catch: java.lang.Exception -> Lb8
            if (r10 == 0) goto Lbf
            android.graphics.Rect r0 = new android.graphics.Rect     // Catch: java.lang.Exception -> Lb8
            r0.<init>()     // Catch: java.lang.Exception -> Lb8
            java.lang.Class<?> r1 = androidx.appcompat.widget.p.d     // Catch: java.lang.Exception -> Lb8
            java.lang.reflect.Field[] r1 = r1.getFields()     // Catch: java.lang.Exception -> Lb8
            int r3 = r1.length     // Catch: java.lang.Exception -> Lb8
            r4 = r2
        L4a:
            if (r4 >= r3) goto Lb7
            r5 = r1[r4]     // Catch: java.lang.Exception -> Lb8
            java.lang.String r6 = r5.getName()     // Catch: java.lang.Exception -> Lb8
            r7 = -1
            int r8 = r6.hashCode()     // Catch: java.lang.Exception -> Lb8
            r9 = -1383228885(0xffffffffad8d9a2b, float:-1.6098308E-11)
            if (r8 == r9) goto L8a
            r9 = 115029(0x1c155, float:1.6119E-40)
            if (r8 == r9) goto L80
            r9 = 3317767(0x32a007, float:4.649182E-39)
            if (r8 == r9) goto L76
            r9 = 108511772(0x677c21c, float:4.6598146E-35)
            if (r8 == r9) goto L6c
            goto L94
        L6c:
            java.lang.String r8 = "right"
            boolean r6 = r6.equals(r8)     // Catch: java.lang.Exception -> Lb8
            if (r6 == 0) goto L94
            r6 = 2
            goto L95
        L76:
            java.lang.String r8 = "left"
            boolean r6 = r6.equals(r8)     // Catch: java.lang.Exception -> Lb8
            if (r6 == 0) goto L94
            r6 = r2
            goto L95
        L80:
            java.lang.String r8 = "top"
            boolean r6 = r6.equals(r8)     // Catch: java.lang.Exception -> Lb8
            if (r6 == 0) goto L94
            r6 = 1
            goto L95
        L8a:
            java.lang.String r8 = "bottom"
            boolean r6 = r6.equals(r8)     // Catch: java.lang.Exception -> Lb8
            if (r6 == 0) goto L94
            r6 = 3
            goto L95
        L94:
            r6 = r7
        L95:
            switch(r6) {
                case 0: goto Lae;
                case 1: goto La7;
                case 2: goto La0;
                case 3: goto L99;
                default: goto L98;
            }     // Catch: java.lang.Exception -> Lb8
        L98:
            goto Lb4
        L99:
            int r5 = r5.getInt(r10)     // Catch: java.lang.Exception -> Lb8
            r0.bottom = r5     // Catch: java.lang.Exception -> Lb8
            goto Lb4
        La0:
            int r5 = r5.getInt(r10)     // Catch: java.lang.Exception -> Lb8
            r0.right = r5     // Catch: java.lang.Exception -> Lb8
            goto Lb4
        La7:
            int r5 = r5.getInt(r10)     // Catch: java.lang.Exception -> Lb8
            r0.top = r5     // Catch: java.lang.Exception -> Lb8
            goto Lb4
        Lae:
            int r5 = r5.getInt(r10)     // Catch: java.lang.Exception -> Lb8
            r0.left = r5     // Catch: java.lang.Exception -> Lb8
        Lb4:
            int r4 = r4 + 1
            goto L4a
        Lb7:
            return r0
        Lb8:
            java.lang.String r10 = "DrawableUtils"
            java.lang.String r0 = "Couldn't obtain the optical insets. Ignoring."
            android.util.Log.e(r10, r0)
        Lbf:
            android.graphics.Rect r10 = androidx.appcompat.widget.p.a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.p.a(android.graphics.drawable.Drawable):android.graphics.Rect");
    }

    static void b(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            d(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean c(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
                return true;
            }
            for (Drawable drawable2 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                if (!c(drawable2)) {
                    return false;
                }
            }
            return true;
        }
        if (drawable instanceof androidx.core.graphics.drawable.c) {
            return c(((androidx.core.graphics.drawable.c) drawable).a());
        }
        if (drawable instanceof androidx.appcompat.b.a.c) {
            return c(((androidx.appcompat.b.a.c) drawable).a());
        }
        if (drawable instanceof ScaleDrawable) {
            return c(((ScaleDrawable) drawable).getDrawable());
        }
        return true;
    }

    private static void d(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(b);
        } else {
            drawable.setState(c);
        }
        drawable.setState(state);
    }

    public static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
