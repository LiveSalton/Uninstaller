package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzawd extends zzavf {
    private final String a;
    private final int b;

    public zzawd(zzava zzavaVar) {
        this(zzavaVar != null ? zzavaVar.a : "", zzavaVar != null ? zzavaVar.b : 1);
    }

    public zzawd(String str, int i) {
        this.a = str;
        this.b = i;
    }

    @Override // com.google.android.gms.internal.ads.zzavc
    public final String a() throws RemoteException {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzavc
    public final int b() throws RemoteException {
        return this.b;
    }
}
