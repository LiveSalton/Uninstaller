package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzaze;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbp extends zza {
    private final zzaze a;
    private final String b;

    public zzbp(Context context, String str, String str2) {
        this(str2, zzp.c().b(context, str));
    }

    private zzbp(String str, String str2) {
        this.a = new zzaze(str2);
        this.b = str;
    }

    @Override // com.google.android.gms.ads.internal.util.zza
    public final void a() {
        this.a.a(this.b);
    }
}
