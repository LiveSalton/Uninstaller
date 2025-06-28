package com.google.android.gms.internal.measurement;

/* compiled from: source */
/* loaded from: classes.dex */
final class bf implements bl {
    private bl[] a;

    bf(bl... blVarArr) {
        this.a = blVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.bl
    public final boolean a(Class<?> cls) {
        for (bl blVar : this.a) {
            if (blVar.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.bl
    public final bm b(Class<?> cls) {
        for (bl blVar : this.a) {
            if (blVar.a(cls)) {
                return blVar.b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
