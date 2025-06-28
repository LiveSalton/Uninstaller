package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class aue implements auk {
    private auk[] a;

    aue(auk... aukVarArr) {
        this.a = aukVarArr;
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final boolean a(Class<?> cls) {
        for (auk aukVar : this.a) {
            if (aukVar.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final aul b(Class<?> cls) {
        for (auk aukVar : this.a) {
            if (aukVar.a(cls)) {
                return aukVar.b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
