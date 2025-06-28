package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.android.gms.ads.internal.util.zzca;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class afg implements Callable {
    static final Callable a = new afg();

    private afg() {
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        HashMap hashMap = new HashMap();
        String str = (String) zzwq.e().a(zzabf.A);
        if (str != null && !str.isEmpty()) {
            if (Build.VERSION.SDK_INT >= ((Integer) zzwq.e().a(zzabf.B)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    hashMap.put(str2, zzca.a(str2));
                }
            }
        }
        return new zzdhx(hashMap);
    }
}
