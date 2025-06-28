package com.google.android.gms.internal.measurement;

/* compiled from: source */
/* loaded from: classes.dex */
final class aj extends ak {
    private final int c;
    private final int d;

    aj(byte[] bArr, int i, int i2) {
        super(bArr);
        b(i, i + i2, bArr.length);
        this.c = i;
        this.d = i2;
    }

    @Override // com.google.android.gms.internal.measurement.ak, com.google.android.gms.internal.measurement.zzdu
    public final byte a(int i) {
        int a = a();
        if (((a - (i + 1)) | i) >= 0) {
            return this.b[this.c + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(a);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.measurement.ak, com.google.android.gms.internal.measurement.zzdu
    final byte b(int i) {
        return this.b[this.c + i];
    }

    @Override // com.google.android.gms.internal.measurement.ak, com.google.android.gms.internal.measurement.zzdu
    public final int a() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.measurement.ak
    protected final int e() {
        return this.c;
    }
}
