package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefr;
import java.security.GeneralSecurityException;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeap {
    private static final Logger a = Logger.getLogger(zzeap.class.getName());
    private static final ConcurrentMap<String, a> b = new ConcurrentHashMap();
    private static final ConcurrentMap<String, b> c = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> d = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzdzw<?>> e = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, zzeao<?>> f = new ConcurrentHashMap();

    /* compiled from: source */
    interface a {
        zzdzz<?> a();

        <P> zzdzz<P> a(Class<P> cls) throws GeneralSecurityException;

        Class<?> b();

        Set<Class<?>> c();

        Class<?> d();
    }

    /* compiled from: source */
    interface b {
    }

    private static <KeyProtoT extends zzels> a a(zzeae<KeyProtoT> zzeaeVar) {
        return new aoi(zzeaeVar);
    }

    private static <KeyProtoT extends zzels> b b(zzeae<KeyProtoT> zzeaeVar) {
        return new aok(zzeaeVar);
    }

    private static synchronized a b(String str) throws GeneralSecurityException {
        a aVar;
        synchronized (zzeap.class) {
            if (!b.containsKey(str)) {
                String valueOf = String.valueOf(str);
                throw new GeneralSecurityException(valueOf.length() != 0 ? "No key manager found for key type ".concat(valueOf) : new String("No key manager found for key type "));
            }
            aVar = b.get(str);
        }
        return aVar;
    }

    @Deprecated
    public static zzdzw<?> a(String str) throws GeneralSecurityException {
        if (str == null) {
            throw new IllegalArgumentException("catalogueName must be non-null.");
        }
        zzdzw<?> zzdzwVar = e.get(str.toLowerCase(Locale.US));
        if (zzdzwVar != null) {
            return zzdzwVar;
        }
        String format = String.format("no catalogue found for %s. ", str);
        if (str.toLowerCase(Locale.US).startsWith("tinkaead")) {
            format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
        }
        if (str.toLowerCase(Locale.US).startsWith("tinkdeterministicaead")) {
            format = String.valueOf(format).concat("Maybe call DeterministicAeadConfig.register().");
        } else if (str.toLowerCase(Locale.US).startsWith("tinkstreamingaead")) {
            format = String.valueOf(format).concat("Maybe call StreamingAeadConfig.register().");
        } else if (str.toLowerCase(Locale.US).startsWith("tinkhybriddecrypt") || str.toLowerCase(Locale.US).startsWith("tinkhybridencrypt")) {
            format = String.valueOf(format).concat("Maybe call HybridConfig.register().");
        } else if (str.toLowerCase(Locale.US).startsWith("tinkmac")) {
            format = String.valueOf(format).concat("Maybe call MacConfig.register().");
        } else if (str.toLowerCase(Locale.US).startsWith("tinkpublickeysign") || str.toLowerCase(Locale.US).startsWith("tinkpublickeyverify")) {
            format = String.valueOf(format).concat("Maybe call SignatureConfig.register().");
        } else if (str.toLowerCase(Locale.US).startsWith("tink")) {
            format = String.valueOf(format).concat("Maybe call TinkConfig.register().");
        }
        throw new GeneralSecurityException(format);
    }

    private static <T> T a(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    private static synchronized void a(String str, Class<?> cls, boolean z) throws GeneralSecurityException {
        synchronized (zzeap.class) {
            if (b.containsKey(str)) {
                a aVar = b.get(str);
                if (!aVar.b().equals(cls)) {
                    Logger logger = a;
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(str);
                    logger.logp(level, "com.google.crypto.tink.Registry", "ensureKeyManagerInsertable", valueOf.length() != 0 ? "Attempted overwrite of a registered key manager for key type ".concat(valueOf) : new String("Attempted overwrite of a registered key manager for key type "));
                    throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", str, aVar.b().getName(), cls.getName()));
                }
                if (!z || d.get(str).booleanValue()) {
                    return;
                }
                String valueOf2 = String.valueOf(str);
                throw new GeneralSecurityException(valueOf2.length() != 0 ? "New keys are already disallowed for key type ".concat(valueOf2) : new String("New keys are already disallowed for key type "));
            }
        }
    }

    public static synchronized <P> void a(zzdzz<P> zzdzzVar, boolean z) throws GeneralSecurityException {
        synchronized (zzeap.class) {
            try {
                if (zzdzzVar == null) {
                    throw new IllegalArgumentException("key manager must be non-null.");
                }
                String a2 = zzdzzVar.a();
                a(a2, zzdzzVar.getClass(), z);
                b.putIfAbsent(a2, new aoj(zzdzzVar));
                d.put(a2, Boolean.valueOf(z));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized <KeyProtoT extends zzels> void a(zzeae<KeyProtoT> zzeaeVar, boolean z) throws GeneralSecurityException {
        synchronized (zzeap.class) {
            String b2 = zzeaeVar.b();
            a(b2, zzeaeVar.getClass(), true);
            if (!b.containsKey(b2)) {
                b.put(b2, a((zzeae) zzeaeVar));
                c.put(b2, b(zzeaeVar));
            }
            d.put(b2, true);
        }
    }

    public static synchronized <KeyProtoT extends zzels, PublicKeyProtoT extends zzels> void a(zzeaq<KeyProtoT, PublicKeyProtoT> zzeaqVar, zzeae<PublicKeyProtoT> zzeaeVar, boolean z) throws GeneralSecurityException {
        Class<?> d2;
        synchronized (zzeap.class) {
            String b2 = zzeaqVar.b();
            String b3 = zzeaeVar.b();
            a(b2, zzeaqVar.getClass(), true);
            a(b3, zzeaeVar.getClass(), false);
            if (b2.equals(b3)) {
                throw new GeneralSecurityException("Private and public key type must be different.");
            }
            if (b.containsKey(b2) && (d2 = b.get(b2).d()) != null && !d2.equals(zzeaeVar.getClass())) {
                Logger logger = a;
                Level level = Level.WARNING;
                StringBuilder sb = new StringBuilder(96 + String.valueOf(b2).length() + String.valueOf(b3).length());
                sb.append("Attempted overwrite of a registered key manager for key type ");
                sb.append(b2);
                sb.append(" with inconsistent public key type ");
                sb.append(b3);
                logger.logp(level, "com.google.crypto.tink.Registry", "registerAsymmetricKeyManagers", sb.toString());
                throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", zzeaqVar.getClass().getName(), d2.getName(), zzeaeVar.getClass().getName()));
            }
            if (!b.containsKey(b2) || b.get(b2).d() == null) {
                b.put(b2, new aol(zzeaqVar, zzeaeVar));
                c.put(b2, b(zzeaqVar));
            }
            d.put(b2, true);
            if (!b.containsKey(b3)) {
                b.put(b3, a((zzeae) zzeaeVar));
            }
            d.put(b3, false);
        }
    }

    public static synchronized <P> void a(zzeao<P> zzeaoVar) throws GeneralSecurityException {
        synchronized (zzeap.class) {
            try {
                if (zzeaoVar == null) {
                    throw new IllegalArgumentException("wrapper must be non-null");
                }
                Class<P> a2 = zzeaoVar.a();
                if (f.containsKey(a2)) {
                    zzeao<?> zzeaoVar2 = f.get(a2);
                    if (!zzeaoVar.getClass().equals(zzeaoVar2.getClass())) {
                        Logger logger = a;
                        Level level = Level.WARNING;
                        String valueOf = String.valueOf(a2);
                        StringBuilder sb = new StringBuilder(56 + String.valueOf(valueOf).length());
                        sb.append("Attempted overwrite of a registered SetWrapper for type ");
                        sb.append(valueOf);
                        logger.logp(level, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", sb.toString());
                        throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", a2.getName(), zzeaoVar2.getClass().getName(), zzeaoVar.getClass().getName()));
                    }
                }
                f.put(a2, zzeaoVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static zzdzz<?> c(String str) throws GeneralSecurityException {
        return b(str).a();
    }

    private static <P> zzdzz<P> a(String str, Class<P> cls) throws GeneralSecurityException {
        a b2 = b(str);
        if (cls == null) {
            return (zzdzz<P>) b2.a();
        }
        if (b2.c().contains(cls)) {
            return b2.a(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(b2.b());
        Set<Class<?>> c2 = b2.c();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class<?> cls2 : c2) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z = false;
        }
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder(77 + String.valueOf(name).length() + String.valueOf(valueOf).length() + String.valueOf(sb2).length());
        sb3.append("Primitive type ");
        sb3.append(name);
        sb3.append(" not supported by key manager of type ");
        sb3.append(valueOf);
        sb3.append(", supported primitives: ");
        sb3.append(sb2);
        throw new GeneralSecurityException(sb3.toString());
    }

    public static synchronized zzefh a(zzefn zzefnVar) throws GeneralSecurityException {
        zzefh c2;
        synchronized (zzeap.class) {
            zzdzz<?> c3 = c(zzefnVar.a());
            if (d.get(zzefnVar.a()).booleanValue()) {
                c2 = c3.c(zzefnVar.b());
            } else {
                String valueOf = String.valueOf(zzefnVar.a());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return c2;
    }

    public static synchronized zzels b(zzefn zzefnVar) throws GeneralSecurityException {
        zzels b2;
        synchronized (zzeap.class) {
            zzdzz<?> c2 = c(zzefnVar.a());
            if (d.get(zzefnVar.a()).booleanValue()) {
                b2 = c2.b(zzefnVar.b());
            } else {
                String valueOf = String.valueOf(zzefnVar.a());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return b2;
    }

    public static <P> P a(String str, zzels zzelsVar, Class<P> cls) throws GeneralSecurityException {
        return (P) a(str, (Class) a(cls)).a(zzelsVar);
    }

    private static <P> P a(String str, zzeiu zzeiuVar, Class<P> cls) throws GeneralSecurityException {
        return (P) a(str, cls).a(zzeiuVar);
    }

    public static <P> P a(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return (P) a(str, zzeiu.a(bArr), (Class) a(cls));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <P> zzeam<P> a(zzeaf zzeafVar, zzdzz<P> zzdzzVar, Class<P> cls) throws GeneralSecurityException {
        Class cls2 = (Class) a(cls);
        aom.b(zzeafVar.a());
        zzeam<P> zzeamVar = (zzeam<P>) zzeam.a(cls2);
        for (zzefr.zza zzaVar : zzeafVar.a().b()) {
            if (zzaVar.c() == zzefl.ENABLED) {
                zzeal a2 = zzeamVar.a(a(zzaVar.b().a(), zzaVar.b().b(), cls2), zzaVar);
                if (zzaVar.d() == zzeafVar.a().a()) {
                    zzeamVar.a(a2);
                }
            }
        }
        return zzeamVar;
    }

    public static <P> P a(zzeam<P> zzeamVar) throws GeneralSecurityException {
        zzeao<?> zzeaoVar = f.get(zzeamVar.b());
        if (zzeaoVar == null) {
            String valueOf = String.valueOf(zzeamVar.b().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "No wrapper found for ".concat(valueOf) : new String("No wrapper found for "));
        }
        return (P) zzeaoVar.a(zzeamVar);
    }

    private zzeap() {
    }
}
