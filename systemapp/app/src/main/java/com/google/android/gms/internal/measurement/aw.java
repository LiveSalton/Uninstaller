package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;

/* compiled from: source */
/* loaded from: classes.dex */
final class aw implements bl {
    private static final aw a = new aw();

    private aw() {
    }

    public static aw a() {
        return a;
    }

    @Override // com.google.android.gms.internal.measurement.bl
    public final boolean a(Class<?> cls) {
        return zzfd.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.measurement.bl
    public final bm b(Class<?> cls) {
        if (!zzfd.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (bm) zzfd.a(cls.asSubclass(zzfd.class)).a(zzfd.zze.c, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
