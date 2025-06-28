package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzayp {

    @GuardedBy("this")
    private BigInteger a = BigInteger.ONE;

    @GuardedBy("this")
    private String b = "0";

    public final synchronized String a() {
        String bigInteger;
        bigInteger = this.a.toString();
        this.a = this.a.add(BigInteger.ONE);
        this.b = bigInteger;
        return bigInteger;
    }

    public final synchronized String b() {
        return this.b;
    }
}
