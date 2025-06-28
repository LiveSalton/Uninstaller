package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdps implements zzdpq {
    private final String a;

    public zzdps(String str) {
        this.a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdpq
    public final boolean equals(Object obj) {
        if (obj instanceof zzdps) {
            return this.a.equals(((zzdps) obj).a);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdpq
    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a;
    }
}
