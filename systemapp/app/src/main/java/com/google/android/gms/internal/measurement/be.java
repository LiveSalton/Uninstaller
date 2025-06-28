package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;

/* compiled from: source */
/* loaded from: classes.dex */
final class be implements by {
    private static final bl b = new bg();
    private final bl a;

    public be() {
        this(new bf(aw.a(), a()));
    }

    private be(bl blVar) {
        this.a = (bl) zzff.a(blVar, "messageInfoFactory");
    }

    @Override // com.google.android.gms.internal.measurement.by
    public final <T> bw<T> a(Class<T> cls) {
        bx.a((Class<?>) cls);
        bm b2 = this.a.b(cls);
        if (b2.b()) {
            if (zzfd.class.isAssignableFrom(cls)) {
                return bp.a(bx.c(), aq.a(), b2.c());
            }
            return bp.a(bx.a(), aq.b(), b2.c());
        }
        if (zzfd.class.isAssignableFrom(cls)) {
            if (a(b2)) {
                return bo.a(cls, b2, bs.b(), bb.b(), bx.c(), aq.a(), bj.b());
            }
            return bo.a(cls, b2, bs.b(), bb.b(), bx.c(), null, bj.b());
        }
        if (a(b2)) {
            return bo.a(cls, b2, bs.a(), bb.a(), bx.a(), aq.b(), bj.a());
        }
        return bo.a(cls, b2, bs.a(), bb.a(), bx.b(), null, bj.a());
    }

    private static boolean a(bm bmVar) {
        return bmVar.a() == zzfd.zze.h;
    }

    private static bl a() {
        try {
            return (bl) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return b;
        }
    }
}
