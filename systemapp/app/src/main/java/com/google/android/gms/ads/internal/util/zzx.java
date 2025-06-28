package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: source */
@TargetApi(19)
/* loaded from: classes.dex */
public class zzx extends zzy {
    @Override // com.google.android.gms.ads.internal.util.zzy, com.google.android.gms.ads.internal.util.zzu
    public final boolean a(View view) {
        return view.isAttachedToWindow();
    }

    @Override // com.google.android.gms.ads.internal.util.zzu
    public final ViewGroup.LayoutParams c() {
        return new ViewGroup.LayoutParams(-1, -1);
    }
}
