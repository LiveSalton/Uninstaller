package com.google.android.gms.ads.formats;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzaza;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public final class NativeAdViewHolder {
    public static WeakHashMap<View, NativeAdViewHolder> a = new WeakHashMap<>();
    private zzaeq b;
    private WeakReference<View> c;

    public final void a(NativeAd nativeAd) {
        a((IObjectWrapper) nativeAd.a());
    }

    public final void a(UnifiedNativeAd unifiedNativeAd) {
        a((IObjectWrapper) unifiedNativeAd.k());
    }

    private final void a(IObjectWrapper iObjectWrapper) {
        View view = this.c != null ? this.c.get() : null;
        if (view == null) {
            zzaza.e("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!a.containsKey(view)) {
            a.put(view, this);
        }
        if (this.b != null) {
            try {
                this.b.a(iObjectWrapper);
            } catch (RemoteException e) {
                zzaza.c("Unable to call setNativeAd on delegate", e);
            }
        }
    }
}
