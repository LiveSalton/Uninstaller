package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbbw implements zzon {
    private final zzpd<zzon> a;
    private final Context b;
    private final zzon c;
    private final zzbby d;
    private final String e;
    private final int f;
    private InputStream h;
    private boolean i;
    private Uri j;
    private volatile zztf k;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private long p = 0;
    private final AtomicLong r = new AtomicLong(-1);
    private zzdyz<Long> q = null;
    private final boolean g = ((Boolean) zzwq.e().a(zzabf.aW)).booleanValue();

    public zzbbw(Context context, zzon zzonVar, String str, int i, zzpd<zzon> zzpdVar, zzbby zzbbyVar) {
        this.b = context;
        this.c = zzonVar;
        this.a = zzpdVar;
        this.d = zzbbyVar;
        this.e = str;
        this.f = i;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final void c() throws IOException {
        if (!this.i) {
            throw new IOException("Attempt to close an already closed CacheDataSource.");
        }
        this.i = false;
        this.j = null;
        boolean z = (this.g && this.h == null) ? false : true;
        if (this.h != null) {
            IOUtils.a(this.h);
            this.h = null;
        } else {
            this.c.c();
        }
        if (!z || this.a == null) {
            return;
        }
        this.a.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x020d  */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8 */
    @Override // com.google.android.gms.internal.ads.zzon
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long a(com.google.android.gms.internal.ads.zzoo r13) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 559
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbw.a(com.google.android.gms.internal.ads.zzoo):long");
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final int a(byte[] bArr, int i, int i2) throws IOException {
        int a;
        if (!this.i) {
            throw new IOException("Attempt to read closed CacheDataSource.");
        }
        if (this.h != null) {
            a = this.h.read(bArr, i, i2);
        } else {
            a = this.c.a(bArr, i, i2);
        }
        if ((!this.g || this.h != null) && this.a != null) {
            this.a.a((zzpd<zzon>) this, a);
        }
        return a;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final Uri a() {
        return this.j;
    }

    public final boolean b() {
        return this.l;
    }

    public final boolean d() {
        return this.m;
    }

    public final boolean e() {
        return this.n;
    }

    public final boolean f() {
        return this.o;
    }

    public final long g() {
        return this.p;
    }

    public final long h() {
        if (this.k == null) {
            return -1L;
        }
        if (this.r.get() != -1) {
            return this.r.get();
        }
        synchronized (this) {
            if (this.q == null) {
                this.q = zzazj.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.hf
                    private final zzbbw a;

                    {
                        this.a = this;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.a.i();
                    }
                });
            }
        }
        if (!this.q.isDone()) {
            return -1L;
        }
        try {
            this.r.compareAndSet(-1L, this.q.get().longValue());
            return this.r.get();
        } catch (InterruptedException | ExecutionException unused) {
            return -1L;
        }
    }

    private final void b(zzoo zzooVar) {
        if (this.a != null) {
            this.a.a((zzpd<zzon>) this, zzooVar);
        }
    }

    private final boolean j() {
        if (!this.g) {
            return false;
        }
        if (!((Boolean) zzwq.e().a(zzabf.bZ)).booleanValue() || this.n) {
            return ((Boolean) zzwq.e().a(zzabf.ca)).booleanValue() && !this.o;
        }
        return true;
    }

    final /* synthetic */ Long i() throws Exception {
        return Long.valueOf(zzp.i().b(this.k));
    }
}
