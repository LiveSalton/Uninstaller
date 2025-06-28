package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzay;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbbh {
    private final Context a;
    private final String b;
    private final zzazh c;
    private final zzabq d;
    private final zzabs e;
    private final long[] g;
    private final String[] h;
    private boolean m;
    private zzbap n;
    private boolean o;
    private boolean p;
    private final com.google.android.gms.ads.internal.util.zzat f = new zzay().a("min_1", Double.MIN_VALUE, 1.0d).a("1_5", 1.0d, 5.0d).a("5_10", 5.0d, 10.0d).a("10_20", 10.0d, 20.0d).a("20_30", 20.0d, 30.0d).a("30_max", 30.0d, Double.MAX_VALUE).a();
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private long q = -1;

    public zzbbh(Context context, zzazh zzazhVar, String str, zzabs zzabsVar, zzabq zzabqVar) {
        this.a = context;
        this.c = zzazhVar;
        this.b = str;
        this.e = zzabsVar;
        this.d = zzabqVar;
        String str2 = (String) zzwq.e().a(zzabf.r);
        if (str2 == null) {
            this.h = new String[0];
            this.g = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.h = new String[split.length];
        this.g = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.g[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzd.d("Unable to parse frame hash target time number.", e);
                this.g[i] = -1;
            }
        }
    }

    public final void a(zzbap zzbapVar) {
        zzabn.a(this.e, this.d, "vpc2");
        this.i = true;
        if (this.e != null) {
            this.e.a("vpn", zzbapVar.a());
        }
        this.n = zzbapVar;
    }

    public final void a() {
        if (!this.i || this.j) {
            return;
        }
        zzabn.a(this.e, this.d, "vfr2");
        this.j = true;
    }

    public final void b() {
        if (!zzadn.a.a().booleanValue() || this.o) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "native-player-metrics");
        bundle.putString("request", this.b);
        bundle.putString("player", this.n.a());
        for (com.google.android.gms.ads.internal.util.zzav zzavVar : this.f.a()) {
            String valueOf = String.valueOf("fps_c_");
            String valueOf2 = String.valueOf(zzavVar.a);
            bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Integer.toString(zzavVar.c));
            String valueOf3 = String.valueOf("fps_p_");
            String valueOf4 = String.valueOf(zzavVar.a);
            bundle.putString(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), Double.toString(zzavVar.b));
        }
        for (int i = 0; i < this.g.length; i++) {
            String str = this.h[i];
            if (str != null) {
                String valueOf5 = String.valueOf(Long.valueOf(this.g[i]));
                StringBuilder sb = new StringBuilder(3 + String.valueOf(valueOf5).length());
                sb.append("fh_");
                sb.append(valueOf5);
                bundle.putString(sb.toString(), str);
            }
        }
        zzp.c().a(this.a, this.c.a, "gmob-apps", bundle, true);
        this.o = true;
    }

    public final void b(zzbap zzbapVar) {
        if (this.k && !this.l) {
            if (zzd.a() && !this.l) {
                zzd.a("VideoMetricsMixin first frame");
            }
            zzabn.a(this.e, this.d, "vff2");
            this.l = true;
        }
        long c = zzp.j().c();
        if (this.m && this.p && this.q != -1) {
            this.f.a(TimeUnit.SECONDS.toNanos(1L) / (c - this.q));
        }
        this.p = this.m;
        this.q = c;
        long longValue = ((Long) zzwq.e().a(zzabf.s)).longValue();
        long currentPosition = zzbapVar.getCurrentPosition();
        for (int i = 0; i < this.h.length; i++) {
            if (this.h[i] == null && longValue > Math.abs(currentPosition - this.g[i])) {
                String[] strArr = this.h;
                int i2 = 8;
                Bitmap bitmap = zzbapVar.getBitmap(8, 8);
                int i3 = 0;
                long j = 63;
                long j2 = 0;
                while (i3 < i2) {
                    long j3 = j;
                    long j4 = j2;
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j4 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1L : 0L) << ((int) j3);
                        i4++;
                        j3--;
                        i2 = 8;
                    }
                    i3++;
                    j2 = j4;
                    i2 = 8;
                    j = j3;
                }
                strArr[i] = String.format("%016X", Long.valueOf(j2));
                return;
            }
        }
    }

    public final void c() {
        this.m = true;
        if (!this.j || this.k) {
            return;
        }
        zzabn.a(this.e, this.d, "vfp2");
        this.k = true;
    }

    public final void d() {
        this.m = false;
    }
}
