package com.google.android.gms.internal.measurement;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzeg {
    int a;
    private int b;
    private boolean c;

    static zzeg a(byte[] bArr, int i, int i2, boolean z) {
        an anVar = new an(bArr, 0, i2, false);
        try {
            anVar.a(i2);
            return anVar;
        } catch (zzfo e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract int a();

    public abstract int a(int i) throws zzfo;

    /* JADX INFO: Access modifiers changed from: private */
    zzeg() {
        this.a = 100;
        this.b = Integer.MAX_VALUE;
        this.c = false;
    }

    /* synthetic */ zzeg(ao aoVar) {
        this();
    }
}
