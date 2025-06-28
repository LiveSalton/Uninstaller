package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfd.zzb;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzfd<MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzdl<MessageType, BuilderType> {
    private static Map<Object, zzfd<?, ?>> zzd = new ConcurrentHashMap();
    protected zzhy zzb = zzhy.a();
    private int zzc = -1;

    /* compiled from: source */
    static final class a implements zzey<a> {
        @Override // com.google.android.gms.internal.measurement.zzey
        public final zzim a() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final zzip b() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final boolean c() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final zzgn a(zzgn zzgnVar, zzgo zzgoVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final zzgt a(zzgt zzgtVar, zzgt zzgtVar2) {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    /* compiled from: source */
    public static class zza<T extends zzfd<T, ?>> extends zzdp<T> {
    }

    /* compiled from: source */
    public enum zze {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;
        private static final /* synthetic */ int[] l = {a, b, c, d, e, f, g};
        public static final int h = 1;
        public static final int i = 2;
        private static final /* synthetic */ int[] m = {h, i};
        public static final int j = 1;
        public static final int k = 2;
        private static final /* synthetic */ int[] n = {j, k};
    }

    /* compiled from: source */
    public static class zzf<ContainingType extends zzgo, Type> extends zzer<ContainingType, Type> {
    }

    protected abstract Object a(int i, Object obj, Object obj2);

    /* compiled from: source */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzfd<MessageType, BuilderType> implements zzgq {
        protected at<a> zzc = at.a();

        final at<a> b() {
            if (this.zzc.c()) {
                this.zzc = (at) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    public String toString() {
        return bn.a(this, super.toString());
    }

    public int hashCode() {
        if (this.zza != 0) {
            return this.zza;
        }
        this.zza = bt.a().a((bt) this).a(this);
        return this.zza;
    }

    /* compiled from: source */
    public static abstract class zzb<MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzdn<MessageType, BuilderType> {
        protected MessageType a;
        private final MessageType b;
        private boolean c;

        protected final void b() {
            if (this.c) {
                MessageType messagetype = (MessageType) this.a.a(zze.d, null, null);
                a(messagetype, this.a);
                this.a = messagetype;
                this.c = false;
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzgq
        public final boolean o_() {
            return zzfd.a(this.a, false);
        }

        @Override // com.google.android.gms.internal.measurement.zzgn
        /* renamed from: c */
        public MessageType e() {
            if (this.c) {
                return this.a;
            }
            MessageType messagetype = this.a;
            bt.a().a((bt) messagetype).b(messagetype);
            this.c = true;
            return this.a;
        }

        @Override // com.google.android.gms.internal.measurement.zzgn
        /* renamed from: d */
        public final MessageType f() {
            MessageType messagetype = (MessageType) e();
            if (messagetype.o_()) {
                return messagetype;
            }
            throw new zzhw(messagetype);
        }

        @Override // com.google.android.gms.internal.measurement.zzdn
        public final BuilderType a(MessageType messagetype) {
            b();
            a(this.a, messagetype);
            return this;
        }

        private static void a(MessageType messagetype, MessageType messagetype2) {
            bt.a().a((bt) messagetype).b(messagetype, messagetype2);
        }

        @Override // com.google.android.gms.internal.measurement.zzdn
        /* renamed from: a */
        public final /* synthetic */ zzdn clone() {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.measurement.zzgq
        public final /* synthetic */ zzgo g() {
            return this.b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.measurement.zzdn
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzbVar = (zzb) this.b.a(zze.e, null, null);
            zzbVar.a((zzb) e());
            return zzbVar;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzfd) a(zze.f, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return bt.a().a((bt) this).a(this, (zzfd) obj);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzgq
    public final boolean o_() {
        return a(this, Boolean.TRUE.booleanValue());
    }

    static <T extends zzfd<?, ?>> T a(Class<T> cls) {
        zzfd<?, ?> zzfdVar = zzd.get(cls);
        if (zzfdVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzfdVar = zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzfdVar == null) {
            zzfdVar = (T) ((zzfd) co.a(cls)).a(zze.f, (Object) null, (Object) null);
            if (zzfdVar == null) {
                throw new IllegalStateException();
            }
            zzd.put(cls, zzfdVar);
        }
        return (T) zzfdVar;
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

    protected static final <T extends zzfd<T, ?>> boolean a(T t, boolean z) {
        byte byteValue = ((Byte) t.a(zze.a, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean c = bt.a().a((bt) t).c(t);
        if (z) {
            t.a(zze.b, c ? t : null, null);
        }
        return c;
    }
}
