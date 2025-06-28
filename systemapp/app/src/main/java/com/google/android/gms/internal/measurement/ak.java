package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;

/* compiled from: source */
/* loaded from: classes.dex */
class ak extends al {
    protected final byte[] b;

    ak(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.b = bArr;
    }

    protected int e() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public byte a(int i) {
        return this.b[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    byte b(int i) {
        return this.b[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public int a() {
        return this.b.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final zzdu a(int i, int i2) {
        int b = b(0, i2, a());
        if (b == 0) {
            return zzdu.a;
        }
        return new aj(this.b, e(), b);
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    protected final String a(Charset charset) {
        return new String(this.b, e(), a(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final boolean c() {
        int e = e();
        return cr.a(this.b, e, a() + e);
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdu) || a() != ((zzdu) obj).a()) {
            return false;
        }
        if (a() == 0) {
            return true;
        }
        if (obj instanceof ak) {
            ak akVar = (ak) obj;
            int d = d();
            int d2 = akVar.d();
            if (d == 0 || d2 == 0 || d == d2) {
                return a(akVar, 0, a());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.measurement.al
    final boolean a(zzdu zzduVar, int i, int i2) {
        if (i2 > zzduVar.a()) {
            int a = a();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(a);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 > zzduVar.a()) {
            int a2 = zzduVar.a();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(a2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (zzduVar instanceof ak) {
            ak akVar = (ak) zzduVar;
            byte[] bArr = this.b;
            byte[] bArr2 = akVar.b;
            int e = e() + i2;
            int e2 = e();
            int e3 = akVar.e();
            while (e2 < e) {
                if (bArr[e2] != bArr2[e3]) {
                    return false;
                }
                e2++;
                e3++;
            }
            return true;
        }
        return zzduVar.a(0, i2).equals(a(0, i2));
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    protected final int a(int i, int i2, int i3) {
        return zzff.a(i, this.b, e(), i3);
    }
}
