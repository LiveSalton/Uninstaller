package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;
import com.google.android.gms.internal.ads.zzekh.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzekh<MessageType extends zzekh<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzeik<MessageType, BuilderType> {
    private static Map<Object, zzekh<?, ?>> zzinq = new ConcurrentHashMap();
    protected zzeni zzino = zzeni.a();
    private int zzinp = -1;

    /* compiled from: source */
    static final class a implements zzejz<a> {
        @Override // com.google.android.gms.internal.ads.zzejz
        public final int a() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        public final zzenw b() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        public final zzenz c() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        public final boolean d() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        public final boolean e() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        public final zzelr a(zzelr zzelrVar, zzels zzelsVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        public final zzelx a(zzelx zzelxVar, zzelx zzelxVar2) {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    /* compiled from: source */
    public static class zzc<T extends zzekh<T, ?>> extends zzeip<T> {
        private final T a;

        public zzc(T t) {
            this.a = t;
        }
    }

    /* compiled from: source */
    public static class zzd<ContainingType extends zzels, Type> extends zzejs<ContainingType, Type> {
    }

    /* compiled from: source */
    public enum zzf {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;
        private static final /* synthetic */ int[] h = {a, b, c, d, e, f, g};

        public static int[] a() {
            return (int[]) h.clone();
        }
    }

    protected abstract Object a(int i, Object obj, Object obj2);

    /* compiled from: source */
    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzekh<MessageType, BuilderType> implements zzelu {
        protected atl<a> zzinr = atl.a();

        final atl<a> a() {
            if (this.zzinr.c()) {
                this.zzinr = (atl) this.zzinr.clone();
            }
            return this.zzinr;
        }
    }

    public String toString() {
        return aum.a(this, super.toString());
    }

    public int hashCode() {
        if (this.zziij != 0) {
            return this.zziij;
        }
        this.zziij = auw.a().a((auw) this).a(this);
        return this.zziij;
    }

    /* compiled from: source */
    public static abstract class zza<MessageType extends zzekh<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzein<MessageType, BuilderType> {
        protected MessageType a;
        protected boolean b = false;
        private final MessageType c;

        protected zza(MessageType messagetype) {
            this.c = messagetype;
            this.a = (MessageType) messagetype.a(zzf.d, null, null);
        }

        protected void c() {
            MessageType messagetype = (MessageType) this.a.a(zzf.d, null, null);
            a(messagetype, this.a);
            this.a = messagetype;
        }

        @Override // com.google.android.gms.internal.ads.zzelu
        public final boolean o() {
            return zzekh.a(this.a, false);
        }

        @Override // com.google.android.gms.internal.ads.zzelr
        /* renamed from: d */
        public MessageType f() {
            if (this.b) {
                return this.a;
            }
            MessageType messagetype = this.a;
            auw.a().a((auw) messagetype).c(messagetype);
            this.b = true;
            return this.a;
        }

        @Override // com.google.android.gms.internal.ads.zzelr
        /* renamed from: e */
        public final MessageType g() {
            MessageType messagetype = (MessageType) f();
            if (messagetype.o()) {
                return messagetype;
            }
            throw new zzeng(messagetype);
        }

        @Override // com.google.android.gms.internal.ads.zzein
        public final BuilderType a(MessageType messagetype) {
            if (this.b) {
                c();
                this.b = false;
            }
            a(this.a, messagetype);
            return this;
        }

        private static void a(MessageType messagetype, MessageType messagetype2) {
            auw.a().a((auw) messagetype).b(messagetype, messagetype2);
        }

        private final BuilderType b(byte[] bArr, int i, int i2, zzeju zzejuVar) throws zzeks {
            if (this.b) {
                c();
                this.b = false;
            }
            try {
                auw.a().a((auw) this.a).a(this.a, bArr, 0, i2, new asp(zzejuVar));
                return this;
            } catch (zzeks e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw zzeks.a();
            }
        }

        @Override // com.google.android.gms.internal.ads.zzein
        /* renamed from: b */
        public final BuilderType a(zzejj zzejjVar, zzeju zzejuVar) throws IOException {
            if (this.b) {
                c();
                this.b = false;
            }
            try {
                auw.a().a((auw) this.a).a(this.a, atd.a(zzejjVar), zzejuVar);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzein
        public final /* synthetic */ zzein a(byte[] bArr, int i, int i2, zzeju zzejuVar) throws zzeks {
            return b(bArr, 0, i2, zzejuVar);
        }

        @Override // com.google.android.gms.internal.ads.zzein
        /* renamed from: b */
        public final /* synthetic */ zzein clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.ads.zzelu
        public final /* synthetic */ zzels w() {
            return this.c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.ads.zzein
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.c.a(zzf.e, null, null);
            zzaVar.a((zza) f());
            return zzaVar;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return auw.a().a((auw) this).a(this, (zzekh<MessageType, BuilderType>) obj);
        }
        return false;
    }

    protected final <MessageType extends zzekh<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType n() {
        return (BuilderType) a(zzf.e, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzelu
    public final boolean o() {
        return a(this, Boolean.TRUE.booleanValue());
    }

    public final BuilderType p() {
        BuilderType buildertype = (BuilderType) a(zzf.e, (Object) null, (Object) null);
        buildertype.a(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.ads.zzeik
    final int m() {
        return this.zzinp;
    }

    @Override // com.google.android.gms.internal.ads.zzeik
    final void a(int i) {
        this.zzinp = i;
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final void a(zzejo zzejoVar) throws IOException {
        auw.a().a((auw) this).a((avd) this, (awo) ath.a(zzejoVar));
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final int q() {
        if (this.zzinp == -1) {
            this.zzinp = auw.a().a((auw) this).b(this);
        }
        return this.zzinp;
    }

    static <T extends zzekh<?, ?>> T a(Class<T> cls) {
        zzekh<?, ?> zzekhVar = zzinq.get(cls);
        if (zzekhVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzekhVar = zzinq.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzekhVar == null) {
            zzekhVar = (T) ((zzekh) avz.a(cls)).a(zzf.f, (Object) null, (Object) null);
            if (zzekhVar == null) {
                throw new IllegalStateException();
            }
            zzinq.put(cls, zzekhVar);
        }
        return (T) zzekhVar;
    }

    protected static <T extends zzekh<?, ?>> void a(Class<T> cls, T t) {
        zzinq.put(cls, t);
    }

    protected static Object a(zzels zzelsVar, String str, Object[] objArr) {
        return new auy(zzelsVar, str, objArr);
    }

    static Object a(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static final <T extends zzekh<T, ?>> boolean a(T t, boolean z) {
        byte byteValue = ((Byte) t.a(zzf.a, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d = auw.a().a((auw) t).d(t);
        if (z) {
            t.a(zzf.b, d ? t : null, null);
        }
        return d;
    }

    protected static zzeko r() {
        return att.d();
    }

    protected static zzeko a(zzeko zzekoVar) {
        int size = zzekoVar.size();
        return zzekoVar.a(size == 0 ? 10 : size << 1);
    }

    protected static zzekq s() {
        return aud.d();
    }

    protected static <E> zzekp<E> t() {
        return auv.d();
    }

    protected static <E> zzekp<E> a(zzekp<E> zzekpVar) {
        int size = zzekpVar.size();
        return zzekpVar.a(size == 0 ? 10 : size << 1);
    }

    private static <T extends zzekh<T, ?>> T a(T t, zzejj zzejjVar, zzeju zzejuVar) throws zzeks {
        T t2 = (T) t.a(zzf.d, null, null);
        try {
            avd a2 = auw.a().a((auw) t2);
            a2.a(t2, atd.a(zzejjVar), zzejuVar);
            a2.c(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzeks) {
                throw ((zzeks) e.getCause());
            }
            throw new zzeks(e.getMessage()).a(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzeks) {
                throw ((zzeks) e2.getCause());
            }
            throw e2;
        }
    }

    private static <T extends zzekh<T, ?>> T a(T t, byte[] bArr, int i, int i2, zzeju zzejuVar) throws zzeks {
        T t2 = (T) t.a(zzf.d, null, null);
        try {
            avd a2 = auw.a().a((auw) t2);
            a2.a(t2, bArr, 0, i2, new asp(zzejuVar));
            a2.c(t2);
            if (t2.zziij != 0) {
                throw new RuntimeException();
            }
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzeks) {
                throw ((zzeks) e.getCause());
            }
            throw new zzeks(e.getMessage()).a(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzeks.a().a(t2);
        }
    }

    private static <T extends zzekh<T, ?>> T a(T t) throws zzeks {
        if (t == null || t.o()) {
            return t;
        }
        throw new zzeks(new zzeng(t).getMessage()).a(t);
    }

    protected static <T extends zzekh<T, ?>> T a(T t, zzeiu zzeiuVar) throws zzeks {
        return (T) a(a(b(t, zzeiuVar, zzeju.a())));
    }

    protected static <T extends zzekh<T, ?>> T a(T t, zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (T) a(b(t, zzeiuVar, zzejuVar));
    }

    private static <T extends zzekh<T, ?>> T b(T t, zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        try {
            zzejj g = zzeiuVar.g();
            T t2 = (T) a(t, g, zzejuVar);
            try {
                g.a(0);
                return t2;
            } catch (zzeks e) {
                throw e.a(t2);
            }
        } catch (zzeks e2) {
            throw e2;
        }
    }

    protected static <T extends zzekh<T, ?>> T a(T t, byte[] bArr) throws zzeks {
        return (T) a(a(t, bArr, 0, bArr.length, zzeju.a()));
    }

    protected static <T extends zzekh<T, ?>> T a(T t, byte[] bArr, zzeju zzejuVar) throws zzeks {
        return (T) a(a(t, bArr, 0, bArr.length, zzejuVar));
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final /* synthetic */ zzelr u() {
        zza zzaVar = (zza) a(zzf.e, (Object) null, (Object) null);
        zzaVar.a((zza) this);
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final /* synthetic */ zzelr v() {
        return (zza) a(zzf.e, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzelu
    public final /* synthetic */ zzels w() {
        return (zzekh) a(zzf.f, (Object) null, (Object) null);
    }
}
