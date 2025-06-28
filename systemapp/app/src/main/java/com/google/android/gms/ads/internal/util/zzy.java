package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.os.Environment;
import android.os.StatFs;
import android.view.View;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzwq;

/* compiled from: source */
@TargetApi(18)
/* loaded from: classes.dex */
public class zzy extends zzv {
    @Override // com.google.android.gms.ads.internal.util.zzu
    public final int b() {
        return 14;
    }

    @Override // com.google.android.gms.ads.internal.util.zzu
    public boolean a(View view) {
        return super.a(view) || view.getWindowId() != null;
    }

    @Override // com.google.android.gms.ads.internal.util.zzu
    public final long e() {
        if (((Boolean) zzwq.e().a(zzabf.bx)).booleanValue()) {
            return new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / 1024;
        }
        return -1L;
    }
}
