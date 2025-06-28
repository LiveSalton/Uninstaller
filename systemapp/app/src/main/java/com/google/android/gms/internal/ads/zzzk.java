package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzzk extends zzyg {
    private final String a;
    private final String b;

    public zzzk(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzyd
    public final String a() throws RemoteException {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzyd
    public final String b() throws RemoteException {
        return this.b;
    }
}
