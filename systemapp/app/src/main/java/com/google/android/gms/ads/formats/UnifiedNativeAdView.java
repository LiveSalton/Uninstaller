package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzadu;
import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzaee;
import com.google.android.gms.internal.ads.zzaen;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzwq;
import com.google.android.gms.internal.ads.zzzm;

/* compiled from: source */
/* loaded from: classes.dex */
public final class UnifiedNativeAdView extends FrameLayout {
    private final FrameLayout a;
    private final zzaen b;

    public UnifiedNativeAdView(Context context) {
        super(context);
        this.a = a(context);
        this.b = a();
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = a(context);
        this.b = a();
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = a(context);
        this.b = a();
    }

    @TargetApi(21)
    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = a(context);
        this.b = a();
    }

    private final void a(String str, View view) {
        try {
            this.b.a(str, ObjectWrapper.a(view));
        } catch (RemoteException e) {
            zzaza.c("Unable to call setAssetView on delegate", e);
        }
    }

    public final void setHeadlineView(View view) {
        a("3001", view);
    }

    public final void setCallToActionView(View view) {
        a("3002", view);
    }

    public final void setIconView(View view) {
        a("3003", view);
    }

    public final void setBodyView(View view) {
        a("3004", view);
    }

    public final void setAdvertiserView(View view) {
        a("3005", view);
    }

    public final void setStoreView(View view) {
        a("3006", view);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.b.b(ObjectWrapper.a(view));
        } catch (RemoteException e) {
            zzaza.c("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    public final void setPriceView(View view) {
        a("3007", view);
    }

    public final void setImageView(View view) {
        a("3008", view);
    }

    public final void setStarRatingView(View view) {
        a("3009", view);
    }

    public final void setMediaView(MediaView mediaView) {
        a("3010", mediaView);
        if (mediaView != null) {
            mediaView.a(new zzadu(this) { // from class: com.google.android.gms.ads.formats.b
                private final UnifiedNativeAdView a;

                {
                    this.a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzadu
                public final void a(MediaContent mediaContent) {
                    this.a.a(mediaContent);
                }
            });
            mediaView.a(new zzadw(this) { // from class: com.google.android.gms.ads.formats.c
                private final UnifiedNativeAdView a;

                {
                    this.a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzadw
                public final void a(ImageView.ScaleType scaleType) {
                    this.a.a(scaleType);
                }
            });
        }
    }

    public final void setAdChoicesView(AdChoicesView adChoicesView) {
        a("3011", adChoicesView);
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        try {
            this.b.a((IObjectWrapper) unifiedNativeAd.k());
        } catch (RemoteException e) {
            zzaza.c("Unable to call setNativeAd on delegate", e);
        }
    }

    private final View a(String str) {
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

    public final View getHeadlineView() {
        return a("3001");
    }

    public final View getCallToActionView() {
        return a("3002");
    }

    public final View getIconView() {
        return a("3003");
    }

    public final View getBodyView() {
        return a("3004");
    }

    public final View getStoreView() {
        return a("3006");
    }

    public final View getPriceView() {
        return a("3007");
    }

    public final View getAdvertiserView() {
        return a("3005");
    }

    public final View getImageView() {
        return a("3008");
    }

    public final View getStarRatingView() {
        return a("3009");
    }

    public final MediaView getMediaView() {
        View a = a("3010");
        if (a instanceof MediaView) {
            return (MediaView) a;
        }
        if (a == null) {
            return null;
        }
        zzaza.b("View is not an instance of MediaView");
        return null;
    }

    public final AdChoicesView getAdChoicesView() {
        View a = a("3011");
        if (a instanceof AdChoicesView) {
            return (AdChoicesView) a;
        }
        return null;
    }

    private final FrameLayout a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzaen a() {
        Preconditions.a(this.a, "createDelegate must be called after overlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzwq.b().a(this.a.getContext(), this, this.a);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.a);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.a == view) {
            return;
        }
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.a);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.a != view) {
            super.bringChildToFront(this.a);
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
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
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (((Boolean) zzwq.e().a(zzabf.bt)).booleanValue() && this.b != null) {
            try {
                this.b.c(ObjectWrapper.a(motionEvent));
            } catch (RemoteException e) {
                zzaza.c("Unable to call handleTouchEvent on delegate", e);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    final /* synthetic */ void a(ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            try {
                this.b.d(ObjectWrapper.a(scaleType));
            } catch (RemoteException e) {
                zzaza.c("Unable to call setMediaViewImageScaleType on delegate", e);
            }
        }
    }

    final /* synthetic */ void a(MediaContent mediaContent) {
        try {
            if (mediaContent instanceof zzzm) {
                this.b.a(((zzzm) mediaContent).a());
            } else if (mediaContent == null) {
                this.b.a((zzaee) null);
            } else {
                zzaza.b("Use MediaContent provided by UnifiedNativeAd.getMediaContent");
            }
        } catch (RemoteException e) {
            zzaza.c("Unable to call setMediaContent on delegate", e);
        }
    }
}
