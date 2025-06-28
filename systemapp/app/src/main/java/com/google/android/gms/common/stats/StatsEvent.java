package com.google.android.gms.common.stats;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    /* compiled from: source */
    @KeepForSdk
    public interface Types {
    }

    public abstract long a();

    public abstract int b();

    public abstract long c();

    public abstract String d();

    public String toString() {
        long a = a();
        int b = b();
        long c = c();
        String d = d();
        StringBuilder sb = new StringBuilder(53 + String.valueOf(d).length());
        sb.append(a);
        sb.append("\t");
        sb.append(b);
        sb.append("\t");
        sb.append(c);
        sb.append(d);
        return sb.toString();
    }
}
