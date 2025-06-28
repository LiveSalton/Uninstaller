package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class akj extends zzdsm {
    private String a;
    private Boolean b;
    private Boolean c;

    akj() {
    }

    @Override // com.google.android.gms.internal.ads.zzdsm
    public final zzdsm a(String str) {
        if (str == null) {
            throw new NullPointerException("Null clientVersion");
        }
        this.a = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdsm
    public final zzdsm a(boolean z) {
        this.b = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdsm
    public final zzdsm b(boolean z) {
        this.c = true;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdsm
    public final zzdsj a() {
        String concat = this.a == null ? String.valueOf("").concat(" clientVersion") : "";
        if (this.b == null) {
            concat = String.valueOf(concat).concat(" shouldGetAdvertisingId");
        }
        if (this.c == null) {
            concat = String.valueOf(concat).concat(" isGooglePlayServicesAvailable");
        }
        if (!concat.isEmpty()) {
            String valueOf = String.valueOf(concat);
            throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
        }
        return new aki(this.a, this.b.booleanValue(), this.c.booleanValue());
    }
}
