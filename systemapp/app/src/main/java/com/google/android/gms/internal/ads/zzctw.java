package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbl;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzctw implements zzcrh<zzcbt, zzdoe, zzcst> {
    private final Context a;
    private final zzcat b;
    private final Executor c;

    public zzctw(Context context, zzcat zzcatVar, Executor executor) {
        this.a = context;
        this.b = zzcatVar;
        this.c = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final void a(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb<zzdoe, zzcst> zzcrbVar) throws zzdnr {
        zzcrbVar.b.a(this.a, zzdnjVar.a.a.d, zzdmuVar.u.toString(), com.google.android.gms.ads.internal.util.zzbk.a((zzbl) zzdmuVar.r), zzcrbVar.c, zzdnjVar.a.a.i, zzdnjVar.a.a.g);
    }

    private static boolean a(zzdnj zzdnjVar, int i) {
        return zzdnjVar.a.a.g.contains(Integer.toString(i));
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final /* synthetic */ zzcbt b(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb<zzdoe, zzcst> zzcrbVar) throws zzdnr, zzcuq {
        zzcce a;
        zzanv h = zzcrbVar.b.h();
        zzanw i = zzcrbVar.b.i();
        zzaob l = zzcrbVar.b.l();
        if (l != null && a(zzdnjVar, 6)) {
            a = zzcce.a(l);
        } else if (h != null && a(zzdnjVar, 6)) {
            a = zzcce.b(h);
        } else if (h != null && a(zzdnjVar, 2)) {
            a = zzcce.a(h);
        } else if (i != null && a(zzdnjVar, 6)) {
            a = zzcce.b(i);
        } else if (i != null && a(zzdnjVar, 1)) {
            a = zzcce.a(i);
        } else {
            throw new zzcuq(zzdok.INTERNAL_ERROR, "No native ad mappers");
        }
        if (!zzdnjVar.a.a.g.contains(Integer.toString(a.a()))) {
            throw new zzcuq(zzdok.INTERNAL_ERROR, "No corresponding native ad listener");
        }
        zzccf a2 = this.b.a(new zzbos(zzdnjVar, zzdmuVar, zzcrbVar.a), new zzccq(a), new zzceb(i, h, l));
        zzcrbVar.c.a((zzano) a2.f());
        a2.a().a((zzbso) new zzbjt(zzcrbVar.b), this.c);
        return a2.h();
    }
}
