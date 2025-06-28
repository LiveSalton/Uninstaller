package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
final class bas implements zzpb {
    private final Uri a;
    private final zzon b;
    private final bar c;
    private final zzpe d;
    private volatile boolean f;
    private long h;
    private final /* synthetic */ bam j;
    private final zzkc e = new zzkc();
    private boolean g = true;
    private long i = -1;

    public bas(bam bamVar, Uri uri, zzon zzonVar, bar barVar, zzpe zzpeVar) {
        this.j = bamVar;
        this.a = (Uri) zzpc.a(uri);
        this.b = (zzon) zzpc.a(zzonVar);
        this.c = (bar) zzpc.a(barVar);
        this.d = zzpeVar;
    }

    public final void a(long j, long j2) {
        this.e.a = j;
        this.h = j2;
        this.g = true;
    }

    @Override // com.google.android.gms.internal.ads.zzpb
    public final void a() {
        this.f = true;
    }

    @Override // com.google.android.gms.internal.ads.zzpb
    public final boolean b() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.zzpb
    public final void c() throws IOException, InterruptedException {
        zzjx zzjxVar;
        String str;
        long j;
        Handler handler;
        Runnable runnable;
        int i = 0;
        while (i == 0 && !this.f) {
            try {
                long j2 = this.e.a;
                zzon zzonVar = this.b;
                Uri uri = this.a;
                str = this.j.h;
                this.i = zzonVar.a(new zzoo(uri, j2, -1L, str));
                if (this.i != -1) {
                    this.i += j2;
                }
                zzjxVar = new zzjx(this.b, j2, this.i);
                try {
                    zzjw a = this.c.a(zzjxVar, this.b.a());
                    if (this.g) {
                        a.a(j2, this.h);
                        this.g = false;
                    }
                    while (i == 0 && !this.f) {
                        this.d.c();
                        int a2 = a.a(zzjxVar, this.e);
                        try {
                            long b = zzjxVar.b();
                            j = this.j.i;
                            if (b > j + j2) {
                                j2 = zzjxVar.b();
                                this.d.b();
                                handler = this.j.o;
                                runnable = this.j.n;
                                handler.post(runnable);
                            }
                            i = a2;
                        } catch (Throwable th) {
                            th = th;
                            i = a2;
                            if (i != 1 && zzjxVar != null) {
                                this.e.a = zzjxVar.b();
                            }
                            zzpt.a(this.b);
                            throw th;
                        }
                    }
                    if (i == 1) {
                        i = 0;
                    } else {
                        this.e.a = zzjxVar.b();
                    }
                    zzpt.a(this.b);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                zzjxVar = null;
            }
        }
    }
}
