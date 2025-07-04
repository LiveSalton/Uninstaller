package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: source */
@TargetApi(19)
/* loaded from: classes.dex */
public final class zzcif {
    private Context a;
    private PopupWindow b;

    public final void a(Context context, View view) {
        if (!PlatformVersion.e() || PlatformVersion.g()) {
            return;
        }
        this.b = b(context, view);
        if (this.b == null) {
            context = null;
        }
        this.a = context;
    }

    public final void a() {
        if (this.a == null || this.b == null) {
            return;
        }
        if ((this.a instanceof Activity) && ((Activity) this.a).isDestroyed()) {
            this.a = null;
            this.b = null;
        } else {
            if (this.b.isShowing()) {
                this.b.dismiss();
            }
            this.a = null;
            this.b = null;
        }
    }

    private static PopupWindow b(Context context, View view) {
        Window window = context instanceof Activity ? ((Activity) context).getWindow() : null;
        if (window == null || window.getDecorView() == null || ((Activity) context).isDestroyed()) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(view, -1, -1);
        PopupWindow popupWindow = new PopupWindow((View) frameLayout, 1, 1, false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setClippingEnabled(false);
        zzd.b("Displaying the 1x1 popup off the screen.");
        try {
            popupWindow.showAtLocation(window.getDecorView(), 0, -1, -1);
            return popupWindow;
        } catch (Exception unused) {
            return null;
        }
    }
}
