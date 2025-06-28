package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import com.google.android.gms.internal.ads.zzels;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzeae<KeyProtoT extends zzels> {
    private final Class<KeyProtoT> a;
    private final Map<Class<?>, zzeag<?, KeyProtoT>> b;
    private final Class<?> c;

    @SafeVarargs
    protected zzeae(Class<KeyProtoT> cls, zzeag<?, KeyProtoT>... zzeagVarArr) {
        this.a = cls;
        HashMap hashMap = new HashMap();
        for (zzeag<?, KeyProtoT> zzeagVar : zzeagVarArr) {
            if (hashMap.containsKey(zzeagVar.a())) {
                String valueOf = String.valueOf(zzeagVar.a().getCanonicalName());
                throw new IllegalArgumentException(valueOf.length() != 0 ? "KeyTypeManager constructed with duplicate factories for primitive ".concat(valueOf) : new String("KeyTypeManager constructed with duplicate factories for primitive "));
            }
            hashMap.put(zzeagVar.a(), zzeagVar);
        }
        if (zzeagVarArr.length > 0) {
            this.c = zzeagVarArr[0].a();
        } else {
            this.c = Void.class;
        }
        this.b = Collections.unmodifiableMap(hashMap);
    }

    public abstract KeyProtoT a(zzeiu zzeiuVar) throws zzeks;

    public abstract void a(KeyProtoT keyprotot) throws GeneralSecurityException;

    public abstract String b();

    public abstract zzefh.zzb c();

    public final Class<KeyProtoT> a() {
        return this.a;
    }

    public final <P> P a(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        zzeag<?, KeyProtoT> zzeagVar = this.b.get(cls);
        if (zzeagVar == null) {
            String canonicalName = cls.getCanonicalName();
            StringBuilder sb = new StringBuilder(41 + String.valueOf(canonicalName).length());
            sb.append("Requested primitive class ");
            sb.append(canonicalName);
            sb.append(" not supported.");
            throw new IllegalArgumentException(sb.toString());
        }
        return (P) zzeagVar.a(keyprotot);
    }

    public final Set<Class<?>> d() {
        return this.b.keySet();
    }

    final Class<?> e() {
        return this.c;
    }

    public zzead<?, KeyProtoT> f() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }
}
