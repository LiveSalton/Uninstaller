package com.google.android.gms.internal.measurement;

/* compiled from: source */
/* loaded from: classes.dex */
final class cv extends cs {
    cv() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00dc, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.measurement.cs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int a(int r18, byte[] r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cv.a(int, byte[], int, int):int");
    }

    private static int a(byte[] bArr, int i, long j, int i2) {
        int b;
        int b2;
        int b3;
        switch (i2) {
            case 0:
                b = cr.b(i);
                return b;
            case 1:
                b2 = cr.b(i, co.a(bArr, j));
                return b2;
            case 2:
                b3 = cr.b(i, co.a(bArr, j), co.a(bArr, j + 1));
                return b3;
            default:
                throw new AssertionError();
        }
    }
}
