package com.google.android.gms.internal.common;

import java.io.Serializable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzn {
    public static <T> zzo<T> a(zzo<T> zzoVar) {
        return ((zzoVar instanceof c) || (zzoVar instanceof d)) ? zzoVar : zzoVar instanceof Serializable ? new d(zzoVar) : new c(zzoVar);
    }
}
