package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzva;
import com.google.android.gms.internal.ads.zzzc;

/* compiled from: source */
/* loaded from: classes.dex */
class BaseAdView extends ViewGroup {
    protected final zzzc a;

    public BaseAdView(Context context, int i) {
        super(context);
        this.a = new zzzc(this, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.a = new zzzc(this, attributeSet, false, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.a = new zzzc(this, attributeSet, false, i2);
    }

    public void c() {
        this.a.a();
    }

    public AdListener getAdListener() {
        return this.a.b();
    }

    public AdSize getAdSize() {
        return this.a.c();
    }

    public String getAdUnitId() {
        return this.a.e();
    }

    public void a(AdRequest adRequest) {
        this.a.a(adRequest.a());
    }

    public void b() {
        this.a.h();
    }

    public void a() {
        this.a.i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdListener(AdListener adListener) {
        this.a.a(adListener);
        if (adListener == 0) {
            this.a.a((zzva) null);
            this.a.a((AppEventListener) null);
            return;
        }
        if (adListener instanceof zzva) {
            this.a.a((zzva) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.a.a((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.a.a(adSize);
    }

    public void setAdUnitId(String str) {
        this.a.a(str);
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        return this.a.j();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i5 = ((i3 - i) - measuredWidth) / 2;
        int i6 = ((i4 - i2) - measuredHeight) / 2;
        childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        } else {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzaza.c("Unable to retrieve ad size.", e);
            }
            if (adSize != null) {
                Context context = getContext();
                int b = adSize.b(context);
                i3 = adSize.a(context);
                i4 = b;
            } else {
                i3 = 0;
            }
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public ResponseInfo getResponseInfo() {
        return this.a.k();
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.a.a(onPaidEventListener);
    }
}
