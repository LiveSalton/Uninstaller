package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbqo implements zzbui {
    private final Context a;
    private final zzdnn b;
    private final zzazh c;
    private final zzf d;
    private final zzclp e;

    public zzbqo(Context context, zzdnn zzdnnVar, zzazh zzazhVar, zzf zzfVar, zzclp zzclpVar) {
        this.a = context;
        this.b = zzdnnVar;
        this.c = zzazhVar;
        this.d = zzfVar;
        this.e = zzclpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void a(zzdnj zzdnjVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void a(zzatl zzatlVar) {
        if (((Boolean) zzwq.e().a(zzabf.bM)).booleanValue()) {
            zzp.k().a(this.a, this.c, this.b.f, this.d.h());
        }
        this.e.b();
    }
}
