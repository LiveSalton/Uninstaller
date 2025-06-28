package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class aog implements Runnable {
    aog() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdsi zzdsiVar;
        zzdp zzdpVar;
        zzdp zzdpVar2;
        try {
            zzdpVar = zzdx.s;
            zzdpVar.a();
            zzdpVar2 = zzdx.s;
            zzdpVar2.b();
        } catch (Exception e) {
            zzdsiVar = zzdx.u;
            zzdsiVar.a(2001, -1L, e);
        }
    }
}
