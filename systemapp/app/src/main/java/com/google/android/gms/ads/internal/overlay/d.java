package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzag;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: source */
@VisibleForTesting
/* loaded from: classes.dex */
final class d extends RelativeLayout {

    @VisibleForTesting
    boolean a;

    @VisibleForTesting
    private zzag b;

    public d(Context context, String str, String str2) {
        super(context);
        this.b = new zzag(context, str);
        this.b.b(str2);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return false;
        }
        this.b.a(motionEvent);
        return false;
    }
}
