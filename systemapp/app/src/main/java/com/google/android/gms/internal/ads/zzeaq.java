package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzels;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzeaq<KeyProtoT extends zzels, PublicKeyProtoT extends zzels> extends zzeae<KeyProtoT> {
    private final Class<PublicKeyProtoT> a;

    @SafeVarargs
    protected zzeaq(Class<KeyProtoT> cls, Class<PublicKeyProtoT> cls2, zzeag<?, KeyProtoT>... zzeagVarArr) {
        super(cls, zzeagVarArr);
        this.a = cls2;
    }
}
