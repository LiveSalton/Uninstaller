package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzwq;

/* compiled from: source */
@TargetApi(24)
/* loaded from: classes.dex */
public class zzz extends zzaa {
    @Override // com.google.android.gms.ads.internal.util.zzu
    public final boolean a(Activity activity, Configuration configuration) {
        if (!((Boolean) zzwq.e().a(zzabf.cp)).booleanValue()) {
            return false;
        }
        if (((Boolean) zzwq.e().a(zzabf.cr)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzwq.a();
        int a = zzayr.a(activity, configuration.screenHeightDp);
        int a2 = zzayr.a(activity, configuration.screenWidthDp);
        WindowManager windowManager = (WindowManager) activity.getApplicationContext().getSystemService("window");
        zzp.c();
        DisplayMetrics a3 = zzm.a(windowManager);
        int i = a3.heightPixels;
        int i2 = a3.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        int round = ((int) Math.round(activity.getResources().getDisplayMetrics().density + 0.5d)) * ((Integer) zzwq.e().a(zzabf.co)).intValue();
        return !(a(i, a + dimensionPixelSize, round) && a(i2, a2, round));
    }

    private static boolean a(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }
}
