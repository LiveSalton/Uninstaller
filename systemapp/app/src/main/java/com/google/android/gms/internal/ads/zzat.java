package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzat {
    private static final Comparator<byte[]> e = new eb();
    private final List<byte[]> a = new ArrayList();
    private final List<byte[]> b = new ArrayList(64);
    private int c = 0;
    private final int d = 4096;

    public zzat(int i) {
    }

    public final synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            byte[] bArr = this.b.get(i2);
            if (bArr.length >= i) {
                this.c -= bArr.length;
                this.b.remove(i2);
                this.a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public final synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.d) {
                this.a.add(bArr);
                int binarySearch = Collections.binarySearch(this.b, bArr, e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.b.add(binarySearch, bArr);
                this.c += bArr.length;
                a();
            }
        }
    }

    private final synchronized void a() {
        while (this.c > this.d) {
            byte[] remove = this.a.remove(0);
            this.b.remove(remove);
            this.c -= remove.length;
        }
    }
}
