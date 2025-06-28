package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzub {
    private final byte[] a;
    private int b;
    private int c;
    private final /* synthetic */ zztx d;

    /* JADX INFO: Access modifiers changed from: private */
    zzub(zztx zztxVar, byte[] bArr) {
        this.d = zztxVar;
        this.a = bArr;
    }

    public final synchronized void a() {
        try {
            if (this.d.b) {
                this.d.a.a(this.a);
                this.d.a.a(this.b);
                this.d.a.b(this.c);
                this.d.a.a((int[]) null);
                this.d.a.a();
            }
        } catch (RemoteException e) {
            zzaza.b("Clearcut log failed", e);
        }
    }

    public final zzub a(int i) {
        this.b = i;
        return this;
    }

    public final zzub b(int i) {
        this.c = i;
        return this;
    }

    /* synthetic */ zzub(zztx zztxVar, byte[] bArr, bcz bczVar) {
        this(zztxVar, bArr);
    }
}
