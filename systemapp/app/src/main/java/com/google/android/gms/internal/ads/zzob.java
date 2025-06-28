package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzob extends zzoh {
    private final SparseArray<Map<zznq, zzod>> a = new SparseArray<>();
    private final SparseBooleanArray b = new SparseBooleanArray();
    private int c = 0;
    private zzoa d;

    protected abstract zzoc[] a(zzhx[] zzhxVarArr, zznq[] zznqVarArr, int[][][] iArr) throws zzhe;

    public final void a(int i, boolean z) {
        if (this.b.get(i) == z) {
            return;
        }
        this.b.put(i, z);
        a();
    }

    @Override // com.google.android.gms.internal.ads.zzoh
    public final zzoj a(zzhx[] zzhxVarArr, zznq zznqVar) throws zzhe {
        int[] iArr;
        int[] iArr2 = new int[zzhxVarArr.length + 1];
        zznr[][] zznrVarArr = new zznr[zzhxVarArr.length + 1][];
        int[][][] iArr3 = new int[zzhxVarArr.length + 1][][];
        for (int i = 0; i < zznrVarArr.length; i++) {
            zznrVarArr[i] = new zznr[zznqVar.b];
            iArr3[i] = new int[zznqVar.b][];
        }
        int[] iArr4 = new int[zzhxVarArr.length];
        for (int i2 = 0; i2 < iArr4.length; i2++) {
            iArr4[i2] = zzhxVarArr[i2].m();
        }
        for (int i3 = 0; i3 < zznqVar.b; i3++) {
            zznr a = zznqVar.a(i3);
            int length = zzhxVarArr.length;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i4 >= zzhxVarArr.length) {
                    i4 = length;
                    break;
                }
                zzhx zzhxVar = zzhxVarArr[i4];
                int i6 = length;
                for (int i7 = 0; i7 < a.a; i7++) {
                    int a2 = zzhxVar.a(a.a(i7)) & 3;
                    if (a2 > i5) {
                        if (a2 == 3) {
                            break;
                        }
                        i6 = i4;
                        i5 = a2;
                    }
                }
                i4++;
                length = i6;
            }
            if (i4 == zzhxVarArr.length) {
                iArr = new int[a.a];
            } else {
                zzhx zzhxVar2 = zzhxVarArr[i4];
                int[] iArr5 = new int[a.a];
                for (int i8 = 0; i8 < a.a; i8++) {
                    iArr5[i8] = zzhxVar2.a(a.a(i8));
                }
                iArr = iArr5;
            }
            int i9 = iArr2[i4];
            zznrVarArr[i4][i9] = a;
            iArr3[i4][i9] = iArr;
            iArr2[i4] = iArr2[i4] + 1;
        }
        zznq[] zznqVarArr = new zznq[zzhxVarArr.length];
        int[] iArr6 = new int[zzhxVarArr.length];
        for (int i10 = 0; i10 < zzhxVarArr.length; i10++) {
            int i11 = iArr2[i10];
            zznqVarArr[i10] = new zznq((zznr[]) Arrays.copyOf(zznrVarArr[i10], i11));
            iArr3[i10] = (int[][]) Arrays.copyOf(iArr3[i10], i11);
            iArr6[i10] = zzhxVarArr[i10].a();
        }
        zznq zznqVar2 = new zznq((zznr[]) Arrays.copyOf(zznrVarArr[zzhxVarArr.length], iArr2[zzhxVarArr.length]));
        zzoc[] a3 = a(zzhxVarArr, zznqVarArr, iArr3);
        int i12 = 0;
        while (true) {
            if (i12 < zzhxVarArr.length) {
                if (this.b.get(i12)) {
                    a3[i12] = null;
                } else {
                    zznq zznqVar3 = zznqVarArr[i12];
                    Map<zznq, zzod> map = this.a.get(i12);
                    if ((map != null ? map.get(zznqVar3) : null) != null) {
                        throw new NoSuchMethodError();
                    }
                }
                i12++;
            } else {
                zzoa zzoaVar = new zzoa(iArr6, zznqVarArr, iArr4, iArr3, zznqVar2);
                zzia[] zziaVarArr = new zzia[zzhxVarArr.length];
                for (int i13 = 0; i13 < zzhxVarArr.length; i13++) {
                    zziaVarArr[i13] = a3[i13] != null ? zzia.a : null;
                }
                return new zzoj(zznqVar, new zzoe(a3), zzoaVar, zziaVarArr);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoh
    public final void a(Object obj) {
        this.d = (zzoa) obj;
    }
}
