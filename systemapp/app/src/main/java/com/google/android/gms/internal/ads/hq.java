package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
final class hq implements zzon {
    private final zzon a;
    private final long b;
    private final zzon c;
    private long d;
    private Uri e;

    hq(zzon zzonVar, int i, zzon zzonVar2) {
        this.a = zzonVar;
        this.b = i;
        this.c = zzonVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final long a(zzoo zzooVar) throws IOException {
        long j;
        zzoo zzooVar2;
        this.e = zzooVar.a;
        zzoo zzooVar3 = null;
        if (zzooVar.d >= this.b) {
            zzooVar2 = null;
        } else {
            long j2 = zzooVar.d;
            if (zzooVar.e != -1) {
                j = Math.min(zzooVar.e, this.b - j2);
            } else {
                j = this.b - j2;
            }
            zzooVar2 = new zzoo(zzooVar.a, j2, j, null);
        }
        if (zzooVar.e == -1 || zzooVar.d + zzooVar.e > this.b) {
            zzooVar3 = new zzoo(zzooVar.a, Math.max(this.b, zzooVar.d), zzooVar.e != -1 ? Math.min(zzooVar.e, (zzooVar.d + zzooVar.e) - this.b) : -1L, null);
        }
        long a = zzooVar2 != null ? this.a.a(zzooVar2) : 0L;
        long a2 = zzooVar3 != null ? this.c.a(zzooVar3) : 0L;
        this.d = zzooVar.d;
        if (a == -1 || a2 == -1) {
            return -1L;
        }
        return a + a2;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final int a(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.d < this.b) {
            i3 = this.a.a(bArr, i, (int) Math.min(i2, this.b - this.d));
            this.d += i3;
        } else {
            i3 = 0;
        }
        if (this.d < this.b) {
            return i3;
        }
        int a = this.c.a(bArr, i + i3, i2 - i3);
        int i4 = i3 + a;
        this.d += a;
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final Uri a() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final void c() throws IOException {
        this.a.c();
        this.c.c();
    }
}
