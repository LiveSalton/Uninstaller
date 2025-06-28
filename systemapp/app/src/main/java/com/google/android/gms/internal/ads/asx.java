package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: source */
/* loaded from: classes.dex */
class asx extends asy {
    protected final byte[] b;

    asx(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.b = bArr;
    }

    protected int l() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    public byte a(int i) {
        return this.b[i];
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    byte b(int i) {
        return this.b[i];
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    public int b() {
        return this.b.length;
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    public final zzeiu a(int i, int i2) {
        int c = c(i, i2, b());
        if (c == 0) {
            return zzeiu.a;
        }
        return new asv(this.b, l() + i, c);
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    protected void b(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.b, i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    final void a(zzeiv zzeivVar) throws IOException {
        zzeivVar.a(this.b, l(), b());
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    protected final String a(Charset charset) {
        return new String(this.b, l(), b(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    public final boolean f() {
        int l = l();
        return awc.a(this.b, l, b() + l);
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    protected final int a(int i, int i2, int i3) {
        int l = l() + i2;
        return awc.a(i, this.b, l, i3 + l);
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeiu) || b() != ((zzeiu) obj).b()) {
            return false;
        }
        if (b() == 0) {
            return true;
        }
        if (obj instanceof asx) {
            asx asxVar = (asx) obj;
            int k = k();
            int k2 = asxVar.k();
            if (k == 0 || k2 == 0 || k == k2) {
                return a(asxVar, 0, b());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.ads.asy
    final boolean a(zzeiu zzeiuVar, int i, int i2) {
        if (i2 > zzeiuVar.b()) {
            int b = b();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(b);
            throw new IllegalArgumentException(sb.toString());
        }
        int i3 = i + i2;
        if (i3 > zzeiuVar.b()) {
            int b2 = zzeiuVar.b();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(b2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (zzeiuVar instanceof asx) {
            asx asxVar = (asx) zzeiuVar;
            byte[] bArr = this.b;
            byte[] bArr2 = asxVar.b;
            int l = l() + i2;
            int l2 = l();
            int l3 = asxVar.l() + i;
            while (l2 < l) {
                if (bArr[l2] != bArr2[l3]) {
                    return false;
                }
                l2++;
                l3++;
            }
            return true;
        }
        return zzeiuVar.a(i, i3).equals(a(0, i2));
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    protected final int b(int i, int i2, int i3) {
        return zzekk.a(i, this.b, l() + i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    public final zzejj g() {
        return zzejj.a(this.b, l(), b(), true);
    }
}
