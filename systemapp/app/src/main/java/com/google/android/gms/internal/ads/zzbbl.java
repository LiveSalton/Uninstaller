package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: source */
@TargetApi(16)
/* loaded from: classes.dex */
public final class zzbbl extends zzbap implements TextureView.SurfaceTextureListener, zzbck {
    private final zzbbe c;
    private final zzbbh d;
    private final boolean e;
    private final zzbbf f;
    private zzbam g;
    private Surface h;
    private zzbca i;
    private String j;
    private String[] k;
    private boolean l;
    private int m;
    private zzbbc n;
    private final boolean o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;
    private float v;

    public zzbbl(Context context, zzbbh zzbbhVar, zzbbe zzbbeVar, boolean z, boolean z2, zzbbf zzbbfVar) {
        super(context);
        this.m = 1;
        this.e = z2;
        this.c = zzbbeVar;
        this.d = zzbbhVar;
        this.o = z;
        this.f = zzbbfVar;
        setSurfaceTextureListener(this);
        this.d.a(this);
    }

    private final zzbca o() {
        return new zzbca(this.c.getContext(), this.f, this.c);
    }

    private final String p() {
        return zzp.c().b(this.c.getContext(), this.c.m().a);
    }

    private final boolean q() {
        return (this.i == null || this.i.a() == null || this.l) ? false : true;
    }

    private final boolean r() {
        return q() && this.m != 1;
    }

    private final void s() {
        if (this.i != null || this.j == null || this.h == null) {
            return;
        }
        if (this.j.startsWith("cache:")) {
            zzbcx a = this.c.a(this.j);
            if (a instanceof zzbdi) {
                this.i = ((zzbdi) a).c();
                if (this.i.a() == null) {
                    zzd.e("Precached video player has been released.");
                    return;
                }
            } else if (a instanceof zzbdj) {
                zzbdj zzbdjVar = (zzbdj) a;
                String p = p();
                ByteBuffer e = zzbdjVar.e();
                boolean d = zzbdjVar.d();
                String c = zzbdjVar.c();
                if (c == null) {
                    zzd.e("Stream cache URL is null.");
                    return;
                } else {
                    this.i = o();
                    this.i.a(new Uri[]{Uri.parse(c)}, p, e, d);
                }
            } else {
                String valueOf = String.valueOf(this.j);
                zzd.e(valueOf.length() != 0 ? "Stream cache miss: ".concat(valueOf) : new String("Stream cache miss: "));
                return;
            }
        } else {
            this.i = o();
            String p2 = p();
            Uri[] uriArr = new Uri[this.k.length];
            for (int i = 0; i < this.k.length; i++) {
                uriArr[i] = Uri.parse(this.k[i]);
            }
            this.i.a(uriArr, p2);
        }
        this.i.a((zzbck) this);
        a(this.h, false);
        if (this.i.a() != null) {
            this.m = this.i.a().a();
            if (this.m == 3) {
                t();
            }
        }
    }

    private final void a(Surface surface, boolean z) {
        if (this.i != null) {
            this.i.a(surface, z);
        } else {
            zzd.e("Trying to set surface before player is initalized.");
        }
    }

    private final void a(float f, boolean z) {
        if (this.i != null) {
            this.i.a(f, z);
        } else {
            zzd.e("Trying to set volume before player is initalized.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbap, com.google.android.gms.internal.ads.gs
    public final void h() {
        a(this.b.a(), false);
    }

    private final void t() {
        if (this.p) {
            return;
        }
        this.p = true;
        com.google.android.gms.ads.internal.util.zzm.a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.gt
            private final zzbbl a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.n();
            }
        });
        h();
        this.d.a();
        if (this.q) {
            c();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final String a() {
        String valueOf = String.valueOf("ExoPlayer/3");
        String valueOf2 = String.valueOf(this.o ? " spherical" : "");
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void a(zzbam zzbamVar) {
        this.g = zzbamVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void setVideoPath(String str) {
        if (str != null) {
            this.j = str;
            this.k = new String[]{str};
            s();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void a(String str, String[] strArr) {
        if (str != null) {
            if (strArr == null) {
                setVideoPath(str);
            }
            this.j = str;
            this.k = (String[]) Arrays.copyOf(strArr, strArr.length);
            s();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void c() {
        if (r()) {
            if (this.f.a) {
                v();
            }
            this.i.a().a(true);
            this.d.c();
            this.b.b();
            this.a.a();
            com.google.android.gms.ads.internal.util.zzm.a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.gx
                private final zzbbl a;

                {
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.l();
                }
            });
            return;
        }
        this.q = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void b() {
        if (q()) {
            this.i.a().c();
            if (this.i != null) {
                a((Surface) null, true);
                if (this.i != null) {
                    this.i.a((zzbck) null);
                    this.i.e();
                    this.i = null;
                }
                this.m = 1;
                this.l = false;
                this.p = false;
                this.q = false;
            }
        }
        this.d.d();
        this.b.c();
        this.d.b();
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void d() {
        if (r()) {
            if (this.f.a) {
                w();
            }
            this.i.a().a(false);
            this.d.d();
            this.b.c();
            com.google.android.gms.ads.internal.util.zzm.a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.gw
                private final zzbbl a;

                {
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.k();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void a(int i) {
        if (r()) {
            this.i.a().a(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void c(int i) {
        if (this.i != null) {
            this.i.d().a(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void d(int i) {
        if (this.i != null) {
            this.i.d().b(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void e(int i) {
        if (this.i != null) {
            this.i.d().c(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void f(int i) {
        if (this.i != null) {
            this.i.d().d(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void g(int i) {
        if (this.i != null) {
            this.i.b(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void a(float f, float f2) {
        if (this.n != null) {
            this.n.a(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final int getCurrentPosition() {
        if (r()) {
            return (int) this.i.a().g();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final int getDuration() {
        if (r()) {
            return (int) this.i.a().f();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final int getVideoWidth() {
        return this.r;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final int getVideoHeight() {
        return this.s;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final long e() {
        if (this.i != null) {
            return this.i.g();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final long f() {
        if (this.i != null) {
            return this.i.h();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final long getTotalBytes() {
        if (this.i != null) {
            return this.i.i();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final int g() {
        if (this.i != null) {
            return this.i.j();
        }
        return -1;
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.v != 0.0f && this.n == null) {
            float f = measuredWidth;
            float f2 = f / measuredHeight;
            if (this.v > f2) {
                measuredHeight = (int) (f / this.v);
            }
            if (this.v < f2) {
                measuredWidth = (int) (measuredHeight * this.v);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        if (this.n != null) {
            this.n.a(measuredWidth, measuredHeight);
        }
        if (Build.VERSION.SDK_INT == 16) {
            if (((this.t > 0 && this.t != measuredWidth) || (this.u > 0 && this.u != measuredHeight)) && this.e && q()) {
                zzhd a = this.i.a();
                if (a.g() > 0 && !a.b()) {
                    a(0.0f, true);
                    a.a(true);
                    long g = a.g();
                    long a2 = zzp.j().a();
                    while (q() && a.g() == g && zzp.j().a() - a2 <= 250) {
                    }
                    a.a(false);
                    h();
                }
            }
            this.t = measuredWidth;
            this.u = measuredHeight;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.o) {
            this.n = new zzbbc(getContext());
            this.n.a(surfaceTexture, i, i2);
            this.n.start();
            SurfaceTexture b = this.n.b();
            if (b != null) {
                surfaceTexture = b;
            } else {
                this.n.a();
                this.n = null;
            }
        }
        this.h = new Surface(surfaceTexture);
        if (this.i == null) {
            s();
        } else {
            a(this.h, true);
            if (!this.f.a) {
                v();
            }
        }
        if (this.r == 0 || this.s == 0) {
            c(i, i2);
        } else {
            u();
        }
        com.google.android.gms.ads.internal.util.zzm.a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.gz
            private final zzbbl a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.j();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.n != null) {
            this.n.a(i, i2);
        }
        com.google.android.gms.ads.internal.util.zzm.a.post(new Runnable(this, i, i2) { // from class: com.google.android.gms.internal.ads.gy
            private final zzbbl a;
            private final int b;
            private final int c;

            {
                this.a = this;
                this.b = i;
                this.c = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.b(this.b, this.c);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.d.b(this);
        this.a.a(surfaceTexture, this.g);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        d();
        if (this.n != null) {
            this.n.a();
            this.n = null;
        }
        if (this.i != null) {
            w();
            if (this.h != null) {
                this.h.release();
            }
            this.h = null;
            a((Surface) null, true);
        }
        com.google.android.gms.ads.internal.util.zzm.a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.hb
            private final zzbbl a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.i();
            }
        });
        return true;
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        zzd.a(sb.toString());
        com.google.android.gms.ads.internal.util.zzm.a.post(new Runnable(this, i) { // from class: com.google.android.gms.internal.ads.ha
            private final zzbbl a;
            private final int b;

            {
                this.a = this;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.h(this.b);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final void a(boolean z, long j) {
        if (this.c != null) {
            zzazj.e.execute(new Runnable(this, z, j) { // from class: com.google.android.gms.internal.ads.hd
                private final zzbbl a;
                private final boolean b;
                private final long c;

                {
                    this.a = this;
                    this.b = z;
                    this.c = j;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b(this.b, this.c);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final void b(int i) {
        if (this.m != i) {
            this.m = i;
            switch (i) {
                case 3:
                    t();
                    break;
                case 4:
                    if (this.f.a) {
                        w();
                    }
                    this.d.d();
                    this.b.c();
                    com.google.android.gms.ads.internal.util.zzm.a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.gv
                        private final zzbbl a;

                        {
                            this.a = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.m();
                        }
                    });
                    break;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final void a(int i, int i2) {
        this.r = i;
        this.s = i2;
        u();
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final void a(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(2 + String.valueOf(str).length() + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        String sb2 = sb.toString();
        String valueOf = String.valueOf(sb2);
        zzd.e(valueOf.length() != 0 ? "ExoPlayerAdapter error: ".concat(valueOf) : new String("ExoPlayerAdapter error: "));
        this.l = true;
        if (this.f.a) {
            w();
        }
        com.google.android.gms.ads.internal.util.zzm.a.post(new Runnable(this, sb2) { // from class: com.google.android.gms.internal.ads.gu
            private final zzbbl a;
            private final String b;

            {
                this.a = this;
                this.b = sb2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(this.b);
            }
        });
    }

    private final void u() {
        c(this.r, this.s);
    }

    private final void c(int i, int i2) {
        float f = i2 > 0 ? i / i2 : 1.0f;
        if (this.v != f) {
            this.v = f;
            requestLayout();
        }
    }

    private final void v() {
        if (this.i != null) {
            this.i.b(true);
        }
    }

    private final void w() {
        if (this.i != null) {
            this.i.b(false);
        }
    }

    final /* synthetic */ void b(boolean z, long j) {
        this.c.a(z, j);
    }

    final /* synthetic */ void h(int i) {
        if (this.g != null) {
            this.g.onWindowVisibilityChanged(i);
        }
    }

    final /* synthetic */ void i() {
        if (this.g != null) {
            this.g.f();
        }
    }

    final /* synthetic */ void b(int i, int i2) {
        if (this.g != null) {
            this.g.a(i, i2);
        }
    }

    final /* synthetic */ void j() {
        if (this.g != null) {
            this.g.a();
        }
    }

    final /* synthetic */ void k() {
        if (this.g != null) {
            this.g.d();
        }
    }

    final /* synthetic */ void l() {
        if (this.g != null) {
            this.g.c();
        }
    }

    final /* synthetic */ void a(String str) {
        if (this.g != null) {
            this.g.a("ExoPlayerAdapter error", str);
        }
    }

    final /* synthetic */ void m() {
        if (this.g != null) {
            this.g.e();
        }
    }

    final /* synthetic */ void n() {
        if (this.g != null) {
            this.g.b();
        }
    }
}
