package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public class MurmurHash3 {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @KeepForSdk
    public static int a(byte[] bArr, int i, int i2, int i3) {
        int i4 = (i2 & (-4)) + i;
        while (i < i4) {
            int i5 = ((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | (bArr[i + 3] << 24)) * (-862048943);
            int i6 = i3 ^ (((i5 << 15) | (i5 >>> 17)) * 461845907);
            i3 = (((i6 >>> 19) | (i6 << 13)) * 5) - 430675100;
            i += 4;
        }
        int i7 = 0;
        switch (i2 & 3) {
            case 1:
                int i8 = ((bArr[i4] & 255) | i7) * (-862048943);
                i3 ^= ((i8 >>> 17) | (i8 << 15)) * 461845907;
                break;
            case 2:
                i7 |= (bArr[i4 + 1] & 255) << 8;
                int i82 = ((bArr[i4] & 255) | i7) * (-862048943);
                i3 ^= ((i82 >>> 17) | (i82 << 15)) * 461845907;
                break;
            case 3:
                i7 = (bArr[i4 + 2] & 255) << 16;
                i7 |= (bArr[i4 + 1] & 255) << 8;
                int i822 = ((bArr[i4] & 255) | i7) * (-862048943);
                i3 ^= ((i822 >>> 17) | (i822 << 15)) * 461845907;
                break;
        }
        int i9 = i3 ^ i2;
        int i10 = (i9 ^ (i9 >>> 16)) * (-2048144789);
        int i11 = (i10 ^ (i10 >>> 13)) * (-1028477387);
        return i11 ^ (i11 >>> 16);
    }

    private MurmurHash3() {
    }
}
