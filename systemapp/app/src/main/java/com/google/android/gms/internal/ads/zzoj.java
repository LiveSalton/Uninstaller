package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzoj {
    public final zznq a;
    public final zzoe b;
    public final Object c;
    public final zzia[] d;

    public zzoj(zznq zznqVar, zzoe zzoeVar, Object obj, zzia[] zziaVarArr) {
        this.a = zznqVar;
        this.b = zzoeVar;
        this.c = obj;
        this.d = zziaVarArr;
    }

    public final boolean a(zzoj zzojVar, int i) {
        return zzojVar != null && zzpt.a(this.b.a(i), zzojVar.b.a(i)) && zzpt.a(this.d[i], zzojVar.d[i]);
    }
}
