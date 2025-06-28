package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzabu extends zzabz {
    private final zzg a;
    private final String b;
    private final String c;

    public zzabu(zzg zzgVar, String str, String str2) {
        this.a = zzgVar;
        this.b = str;
        this.c = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzabw
    public final String a() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzabw
    public final String b() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzabw
    public final void a(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return;
        }
        this.a.a((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzabw
    public final void c() {
        this.a.a();
    }

    @Override // com.google.android.gms.internal.ads.zzabw
    public final void d() {
        this.a.b();
    }
}
