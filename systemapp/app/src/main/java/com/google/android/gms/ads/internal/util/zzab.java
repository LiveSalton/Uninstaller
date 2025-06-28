package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzwq;
import java.util.Locale;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
@TargetApi(28)
/* loaded from: classes.dex */
public final class zzab extends zzac {
    @Override // com.google.android.gms.ads.internal.util.zzu
    public final void a(Activity activity) {
        if (((Boolean) zzwq.e().a(zzabf.az)).booleanValue() && zzp.g().h().n() == null && !activity.isInMultiWindowMode()) {
            a(true, activity);
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(this, activity) { // from class: com.google.android.gms.ads.internal.util.a
                private final zzab a;
                private final Activity b;

                {
                    this.a = this;
                    this.b = activity;
                }

                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return zzab.a(this.b, view, windowInsets);
                }
            });
        }
    }

    private static void a(boolean z, Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i = attributes.layoutInDisplayCutoutMode;
        int i2 = z ? 1 : 2;
        if (i2 != i) {
            attributes.layoutInDisplayCutoutMode = i2;
            window.setAttributes(attributes);
        }
    }

    static /* synthetic */ WindowInsets a(Activity activity, View view, WindowInsets windowInsets) {
        if (zzp.g().h().n() == null) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                zzf h = zzp.g().h();
                String str = "";
                for (Rect rect : displayCutout.getBoundingRects()) {
                    String format = String.format(Locale.US, "%d,%d,%d,%d", Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom));
                    if (!TextUtils.isEmpty(str)) {
                        str = String.valueOf(str).concat("|");
                    }
                    String valueOf = String.valueOf(str);
                    String valueOf2 = String.valueOf(format);
                    str = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                }
                h.d(str);
            } else {
                zzp.g().h().d("");
            }
        }
        a(false, activity);
        return view.onApplyWindowInsets(windowInsets);
    }
}
