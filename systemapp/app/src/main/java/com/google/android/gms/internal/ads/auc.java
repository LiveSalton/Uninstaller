package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class auc implements avg {
    private static final auk b = new auf();
    private final auk a;

    public auc() {
        this(new aue(atr.a(), a()));
    }

    private auc(auk aukVar) {
        this.a = (auk) zzekk.a(aukVar, "messageInfoFactory");
    }

    @Override // com.google.android.gms.internal.ads.avg
    public final <T> avd<T> a(Class<T> cls) {
        avf.a((Class<?>) cls);
        aul b2 = this.a.b(cls);
        if (b2.b()) {
            if (zzekh.class.isAssignableFrom(cls)) {
                return aup.a(avf.c(), atm.a(), b2.c());
            }
            return aup.a(avf.a(), atm.b(), b2.c());
        }
        if (zzekh.class.isAssignableFrom(cls)) {
            if (a(b2)) {
                return auo.a(cls, b2, aut.b(), atz.b(), avf.c(), atm.a(), aui.b());
            }
            return auo.a(cls, b2, aut.b(), atz.b(), avf.c(), (atk<?>) null, aui.b());
        }
        if (a(b2)) {
            return auo.a(cls, b2, aut.a(), atz.a(), avf.a(), atm.b(), aui.a());
        }
        return auo.a(cls, b2, aut.a(), atz.a(), avf.b(), (atk<?>) null, aui.a());
    }

    private static boolean a(aul aulVar) {
        return aulVar.a() == zzemd.a;
    }

    private static auk a() {
        try {
            return (auk) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return b;
        }
    }
}
