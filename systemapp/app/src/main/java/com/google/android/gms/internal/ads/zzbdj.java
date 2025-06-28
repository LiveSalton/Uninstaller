package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbdj extends zzbcx implements zzpd<zzon> {
    private String d;
    private final zzbbf e;
    private boolean f;
    private final hz g;
    private final zzbcp h;
    private ByteBuffer i;
    private boolean j;
    private final Object k;
    private final String l;
    private final int m;
    private boolean n;

    public zzbdj(zzbbe zzbbeVar, zzbbf zzbbfVar) {
        super(zzbbeVar);
        this.e = zzbbfVar;
        this.g = new hz();
        this.h = new zzbcp();
        this.k = new Object();
        this.l = zzbbeVar != null ? zzbbeVar.j() : "";
        this.m = zzbbeVar != null ? zzbbeVar.k() : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final /* bridge */ /* synthetic */ void a(zzon zzonVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final /* bridge */ /* synthetic */ void a(zzon zzonVar, int i) {
    }

    public final String c() {
        return this.d;
    }

    public final boolean d() {
        return this.n;
    }

    @Override // com.google.android.gms.internal.ads.zzbcx
    protected final String b(String str) {
        String valueOf = String.valueOf("cache:");
        String valueOf2 = String.valueOf(super.b(str));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private final void f() {
        int a = (int) this.g.a();
        int a2 = (int) this.h.a(this.i);
        int position = this.i.position();
        int round = Math.round(a2 * (position / a));
        a(this.d, b(this.d), position, a, round, a2, round > 0, zzbca.b(), zzbca.c());
    }

    @Override // com.google.android.gms.internal.ads.zzbcx
    public final boolean a(String str) {
        Exception exc;
        String str2;
        zzon zzonVar;
        this.d = str;
        String b = b(str);
        String str3 = "error";
        try {
            zzon zzoqVar = new zzoq(this.b, null, this, this.e.d, this.e.e, true, null);
            if (this.e.i) {
                try {
                    zzoqVar = new zzbbw(this.a, zzoqVar, this.l, this.m, null, null);
                } catch (Exception e) {
                    e = e;
                    exc = e;
                    String canonicalName = exc.getClass().getCanonicalName();
                    String message = exc.getMessage();
                    StringBuilder sb = new StringBuilder(1 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
                    sb.append(canonicalName);
                    sb.append(":");
                    sb.append(message);
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder(34 + String.valueOf(str).length() + String.valueOf(sb2).length());
                    sb3.append("Failed to preload url ");
                    sb3.append(str);
                    sb3.append(" Exception: ");
                    sb3.append(sb2);
                    zzd.e(sb3.toString());
                    a(str, b, str3, sb2);
                    return false;
                }
            }
            zzoqVar.a(new zzoo(Uri.parse(str)));
            zzbbe zzbbeVar = this.c.get();
            if (zzbbeVar != null) {
                zzbbeVar.a(b, this);
            }
            Clock j = zzp.j();
            long a = j.a();
            long longValue = ((Long) zzwq.e().a(zzabf.p)).longValue();
            long longValue2 = ((Long) zzwq.e().a(zzabf.o)).longValue();
            this.i = ByteBuffer.allocate(this.e.c);
            int i = 8192;
            byte[] bArr = new byte[8192];
            long j2 = a;
            while (true) {
                int a2 = zzoqVar.a(bArr, 0, Math.min(this.i.remaining(), i));
                if (a2 == -1) {
                    this.n = true;
                    a(str, b, (int) this.h.a(this.i));
                    return true;
                }
                synchronized (this.k) {
                    str2 = str3;
                    if (this.f) {
                        zzonVar = zzoqVar;
                    } else {
                        zzonVar = zzoqVar;
                        this.i.put(bArr, 0, a2);
                    }
                }
                if (this.i.remaining() <= 0) {
                    f();
                    return true;
                }
                try {
                    if (this.f) {
                        int limit = this.i.limit();
                        StringBuilder sb4 = new StringBuilder(35);
                        sb4.append("Precache abort at ");
                        sb4.append(limit);
                        sb4.append(" bytes");
                        throw new IOException(sb4.toString());
                    }
                    long a3 = j.a();
                    if (a3 - j2 >= longValue) {
                        f();
                        j2 = a3;
                    }
                    if (a3 - a > 1000 * longValue2) {
                        StringBuilder sb5 = new StringBuilder(49);
                        sb5.append("Timeout exceeded. Limit: ");
                        sb5.append(longValue2);
                        sb5.append(" sec");
                        throw new IOException(sb5.toString());
                    }
                    str3 = str2;
                    zzoqVar = zzonVar;
                    i = 8192;
                } catch (Exception e2) {
                    exc = e2;
                    str3 = str2;
                    String canonicalName2 = exc.getClass().getCanonicalName();
                    String message2 = exc.getMessage();
                    StringBuilder sb6 = new StringBuilder(1 + String.valueOf(canonicalName2).length() + String.valueOf(message2).length());
                    sb6.append(canonicalName2);
                    sb6.append(":");
                    sb6.append(message2);
                    String sb22 = sb6.toString();
                    StringBuilder sb32 = new StringBuilder(34 + String.valueOf(str).length() + String.valueOf(sb22).length());
                    sb32.append("Failed to preload url ");
                    sb32.append(str);
                    sb32.append(" Exception: ");
                    sb32.append(sb22);
                    zzd.e(sb32.toString());
                    a(str, b, str3, sb22);
                    return false;
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcx
    public final void a() {
        this.f = true;
    }

    public final ByteBuffer e() {
        synchronized (this.k) {
            if (this.i != null && !this.j) {
                this.i.flip();
                this.j = true;
            }
            this.f = true;
        }
        return this.i;
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final /* synthetic */ void a(zzon zzonVar, zzoo zzooVar) {
        zzon zzonVar2 = zzonVar;
        if (zzonVar2 instanceof zzoq) {
            this.g.a((zzoq) zzonVar2);
        }
    }
}
