package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzov extends IOException {
    private final int a;
    private final zzoo b;

    public zzov(String str, zzoo zzooVar, int i) {
        super(str);
        this.b = zzooVar;
        this.a = 1;
    }

    public zzov(IOException iOException, zzoo zzooVar, int i) {
        super(iOException);
        this.b = zzooVar;
        this.a = i;
    }

    public zzov(String str, IOException iOException, zzoo zzooVar, int i) {
        super(str, iOException);
        this.b = zzooVar;
        this.a = 1;
    }
}
