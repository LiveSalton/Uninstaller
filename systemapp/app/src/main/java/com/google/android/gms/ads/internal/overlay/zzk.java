package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbdv;

/* compiled from: source */
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzk {
    public final int a;
    public final ViewGroup.LayoutParams b;
    public final ViewGroup c;
    public final Context d;

    public zzk(zzbdv zzbdvVar) throws e {
        this.b = zzbdvVar.getLayoutParams();
        ViewParent parent = zzbdvVar.getParent();
        this.d = zzbdvVar.u();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new e("Could not get the parent of the WebView for an overlay.");
        }
        this.c = (ViewGroup) parent;
        this.a = this.c.indexOfChild(zzbdvVar.getView());
        this.c.removeView(zzbdvVar.getView());
        zzbdvVar.b(true);
    }
}
