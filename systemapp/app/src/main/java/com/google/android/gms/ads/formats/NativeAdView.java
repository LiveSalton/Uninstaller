package com.google.android.gms.ads.formats;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzaen;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzwq;

/* compiled from: source */
@Deprecated
/* loaded from: classes.dex */
public class NativeAdView extends FrameLayout {
    private final FrameLayout a;
    private final zzaen b;

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = a(context);
        this.b = a();
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = a(context);
        this.b = a();
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        a("1098", adChoicesView);
    }

    public AdChoicesView getAdChoicesView() {
        View a = a("1098");
        if (a instanceof AdChoicesView) {
            return (AdChoicesView) a;
        }
        return null;
    }

    protected final void a(String str, View view) {
        try {
            this.b.a(str, ObjectWrapper.a(view));
        } catch (RemoteException e) {
            zzaza.c("Unable to call setAssetView on delegate", e);
        }
    }

    protected final View a(String str) {
        try {
            IObjectWrapper a = this.b.a(str);
            if (a != null) {
                return (View) ObjectWrapper.a(a);
            }
            return null;
        } catch (RemoteException e) {
            zzaza.c("Unable to call getAssetView on delegate", e);
            return null;
        }
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.b.a((IObjectWrapper) nativeAd.a());
        } catch (RemoteException e) {
            zzaza.c("Unable to call setNativeAd on delegate", e);
        }
    }

    private final FrameLayout a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzaen a() {
        Preconditions.a(this.a, "createDelegate must be called after mOverlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzwq.b().a(this.a.getContext(), this, this.a);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.a);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.a == view) {
            return;
        }
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.a);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.a != view) {
            super.bringChildToFront(this.a);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.b != null) {
            try {
                this.b.a(ObjectWrapper.a(view), i);
            } catch (RemoteException e) {
                zzaza.c("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (((Boolean) zzwq.e().a(zzabf.bt)).booleanValue() && this.b != null) {
            try {
                this.b.c(ObjectWrapper.a(motionEvent));
            } catch (RemoteException e) {
                zzaza.c("Unable to call handleTouchEvent on delegate", e);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
