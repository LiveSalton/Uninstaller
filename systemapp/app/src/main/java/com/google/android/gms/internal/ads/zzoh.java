package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzoh {
    private zzog a;

    public abstract zzoj a(zzhx[] zzhxVarArr, zznq zznqVar) throws zzhe;

    public abstract void a(Object obj);

    public final void a(zzog zzogVar) {
        this.a = zzogVar;
    }

    protected final void a() {
        if (this.a != null) {
            this.a.c();
        }
    }
}
