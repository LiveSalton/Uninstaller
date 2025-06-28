package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzels;
import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzead<KeyFormatProtoT extends zzels, KeyT> {
    private final Class<KeyFormatProtoT> a;

    public zzead(Class<KeyFormatProtoT> cls) {
        this.a = cls;
    }

    public abstract KeyFormatProtoT a(zzeiu zzeiuVar) throws zzeks;

    public abstract void a(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

    public abstract KeyT b(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

    public final Class<KeyFormatProtoT> a() {
        return this.a;
    }
}
