package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzok implements zzon {
    private final byte[] a;
    private Uri b;
    private int c;
    private int d;

    public zzok(byte[] bArr) {
        zzpc.a(bArr);
        zzpc.a(bArr.length > 0);
        this.a = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final long a(zzoo zzooVar) throws IOException {
        this.b = zzooVar.a;
        this.c = (int) zzooVar.d;
        this.d = (int) (zzooVar.e == -1 ? this.a.length - zzooVar.d : zzooVar.e);
        if (this.d <= 0 || this.c + this.d > this.a.length) {
            int i = this.c;
            long j = zzooVar.e;
            int length = this.a.length;
            StringBuilder sb = new StringBuilder(77);
            sb.append("Unsatisfiable range: [");
            sb.append(i);
            sb.append(", ");
            sb.append(j);
            sb.append("], length: ");
            sb.append(length);
            throw new IOException(sb.toString());
        }
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final int a(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.d == 0) {
            return -1;
        }
        int min = Math.min(i2, this.d);
        System.arraycopy(this.a, this.c, bArr, i, min);
        this.c += min;
        this.d -= min;
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final Uri a() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final void c() throws IOException {
        this.b = null;
    }
}
