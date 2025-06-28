package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeaf {
    private final zzefr a;

    private zzeaf(zzefr zzefrVar) {
        this.a = zzefrVar;
    }

    static final zzeaf a(zzefr zzefrVar) throws GeneralSecurityException {
        if (zzefrVar == null || zzefrVar.c() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        return new zzeaf(zzefrVar);
    }

    final zzefr a() {
        return this.a;
    }

    public final String toString() {
        return aom.a(this.a).toString();
    }
}
