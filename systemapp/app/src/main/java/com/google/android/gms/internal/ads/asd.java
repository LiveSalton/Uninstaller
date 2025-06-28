package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Mac;

/* compiled from: source */
/* loaded from: classes.dex */
final class asd extends ThreadLocal<Mac> {
    private final /* synthetic */ zzehw a;

    asd(zzehw zzehwVar) {
        this.a = zzehwVar;
    }

    @Override // java.lang.ThreadLocal
    /* renamed from: a */
    public final Mac initialValue() {
        String str;
        Key key;
        try {
            zzehh<zzehn, Mac> zzehhVar = zzehh.b;
            str = this.a.b;
            Mac a = zzehhVar.a(str);
            key = this.a.c;
            a.init(key);
            return a;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
