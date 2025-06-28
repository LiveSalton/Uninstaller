package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbnh implements zzepf<Boolean> {
    private final zzeps<zzdnn> a;

    public zzbnh(zzeps<zzdnn> zzepsVar) {
        this.a = zzepsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        boolean booleanValue;
        if (this.a.b().a() != null) {
            booleanValue = ((Boolean) zzwq.e().a(zzabf.aA)).booleanValue();
        } else {
            booleanValue = ((Boolean) zzwq.e().a(zzabf.cO)).booleanValue();
        }
        return Boolean.valueOf(booleanValue);
    }
}
