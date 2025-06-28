package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzeag<PrimitiveT, KeyT> {
    private final Class<PrimitiveT> a;

    public zzeag(Class<PrimitiveT> cls) {
        this.a = cls;
    }

    public abstract PrimitiveT a(KeyT keyt) throws GeneralSecurityException;

    final Class<PrimitiveT> a() {
        return this.a;
    }
}
