package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefr;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeam<P> {
    private static final Charset a = Charset.forName("UTF-8");
    private ConcurrentMap<String, List<zzeal<P>>> b = new ConcurrentHashMap();
    private zzeal<P> c;
    private final Class<P> d;

    public final zzeal<P> a() {
        return this.c;
    }

    private zzeam(Class<P> cls) {
        this.d = cls;
    }

    public static <P> zzeam<P> a(Class<P> cls) {
        return new zzeam<>(cls);
    }

    public final void a(zzeal<P> zzealVar) {
        if (zzealVar == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        }
        if (zzealVar.b() != zzefl.ENABLED) {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
        List<zzeal<P>> list = this.b.get(new String(zzealVar.d(), a));
        if (list == null) {
            list = Collections.emptyList();
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        }
        this.c = zzealVar;
    }

    public final zzeal<P> a(P p, zzefr.zza zzaVar) throws GeneralSecurityException {
        byte[] array;
        if (zzaVar.c() != zzefl.ENABLED) {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
        switch (zzaVar.e()) {
            case LEGACY:
            case CRUNCHY:
                array = ByteBuffer.allocate(5).put((byte) 0).putInt(zzaVar.d()).array();
                break;
            case TINK:
                array = ByteBuffer.allocate(5).put((byte) 1).putInt(zzaVar.d()).array();
                break;
            case RAW:
                array = zzdzv.a;
                break;
            default:
                throw new GeneralSecurityException("unknown output prefix type");
        }
        zzeal<P> zzealVar = new zzeal<>(p, array, zzaVar.c(), zzaVar.e(), zzaVar.d());
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzealVar);
        String str = new String(zzealVar.d(), a);
        List<zzeal<P>> put = this.b.put(str, Collections.unmodifiableList(arrayList));
        if (put != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(put);
            arrayList2.add(zzealVar);
            this.b.put(str, Collections.unmodifiableList(arrayList2));
        }
        return zzealVar;
    }

    public final Class<P> b() {
        return this.d;
    }
}
