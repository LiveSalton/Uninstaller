package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class aki extends zzdsj {
    private final String a;
    private final boolean b;
    private final boolean c;

    /* JADX INFO: Access modifiers changed from: private */
    aki(String str, boolean z, boolean z2) {
        this.a = str;
        this.b = z;
        this.c = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzdsj
    public final String a() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzdsj
    public final boolean b() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzdsj
    public final boolean c() {
        return this.c;
    }

    public final String toString() {
        String str = this.a;
        boolean z = this.b;
        boolean z2 = this.c;
        StringBuilder sb = new StringBuilder(99 + String.valueOf(str).length());
        sb.append("AdShield2Options{clientVersion=");
        sb.append(str);
        sb.append(", shouldGetAdvertisingId=");
        sb.append(z);
        sb.append(", isGooglePlayServicesAvailable=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdsj)) {
            return false;
        }
        zzdsj zzdsjVar = (zzdsj) obj;
        return this.a.equals(zzdsjVar.a()) && this.b == zzdsjVar.b() && this.c == zzdsjVar.c();
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ (this.b ? 1231 : 1237)) * 1000003) ^ (this.c ? 1231 : 1237);
    }

    /* synthetic */ aki(String str, boolean z, boolean z2, akh akhVar) {
        this(str, z, z2);
    }
}
