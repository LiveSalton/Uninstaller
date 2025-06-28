package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbca implements zzhg, zzih, zzmz, zzpd<zzon>, zzqg {

    @VisibleForTesting
    private static int a;

    @VisibleForTesting
    private static int b;
    private final Context c;
    private final zzhy e;
    private final zzbbf h;
    private zzhd i;
    private ByteBuffer j;
    private boolean k;
    private final WeakReference<zzbbe> l;
    private zzbck m;
    private int n;
    private int o;
    private long p;
    private final String q;
    private final int r;
    private final ArrayList<zzot> s;
    private volatile zzbbw t;
    private Set<WeakReference<hc>> u = new HashSet();
    private final zzbcb d = new zzbcb();
    private final zzhy f = new zzjc(zzlx.a, com.google.android.gms.ads.internal.util.zzm.a, this);
    private final zzob g = new zznw();

    public zzbca(Context context, zzbbf zzbbfVar, zzbbe zzbbeVar) {
        this.c = context;
        this.h = zzbbfVar;
        this.l = new WeakReference<>(zzbbeVar);
        this.e = new zzqa(this.c, zzlx.a, 0L, com.google.android.gms.ads.internal.util.zzm.a, this, -1);
        if (zzd.a()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(28 + String.valueOf(valueOf).length());
            sb.append("ExoPlayerAdapter initialize ");
            sb.append(valueOf);
            zzd.a(sb.toString());
        }
        a++;
        this.i = zzhh.a(new zzhy[]{this.f, this.e}, this.g, this.d);
        this.i.a(this);
        this.n = 0;
        this.p = 0L;
        this.o = 0;
        this.s = new ArrayList<>();
        this.t = null;
        this.q = (zzbbeVar == null || zzbbeVar.j() == null) ? "" : zzbbeVar.j();
        this.r = zzbbeVar != null ? zzbbeVar.k() : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzih
    public final void a(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzih
    public final void a(int i, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzqg
    public final void a(Surface surface) {
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void a(zzhv zzhvVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void a(zzhz zzhzVar, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzqg
    public final void a(zzjm zzjmVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void a(zznq zznqVar, zzoe zzoeVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final /* bridge */ /* synthetic */ void a(zzon zzonVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzqg
    public final void a(String str, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void a(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzqg
    public final void b(zzjm zzjmVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzih
    public final void b(String str, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzih
    public final void c(zzjm zzjmVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzih
    public final void d(zzjm zzjmVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void k() {
    }

    public final zzhd a() {
        return this.i;
    }

    public static int b() {
        return a;
    }

    public static int c() {
        return b;
    }

    private static long a(Map<String, List<String>> map) {
        if (map == null) {
            return 0L;
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry != null) {
                try {
                    if (entry.getKey() != null && zzdve.a("content-length", entry.getKey()) && entry.getValue() != null && entry.getValue().get(0) != null) {
                        return Long.parseLong(entry.getValue().get(0));
                    }
                } catch (NumberFormatException unused) {
                    continue;
                }
            }
        }
        return 0L;
    }

    public final void a(zzbck zzbckVar) {
        this.m = zzbckVar;
    }

    public final zzbcb d() {
        return this.d;
    }

    public final void a(Uri[] uriArr, String str) {
        a(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void a(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzna zznfVar;
        if (this.i == null) {
            return;
        }
        this.j = byteBuffer;
        this.k = z;
        if (uriArr.length == 1) {
            zznfVar = a(uriArr[0], str);
        } else {
            zzna[] zznaVarArr = new zzna[uriArr.length];
            for (int i = 0; i < uriArr.length; i++) {
                zznaVarArr[i] = a(uriArr[i], str);
            }
            zznfVar = new zznf(zznaVarArr);
        }
        this.i.a(zznfVar);
        b++;
    }

    public final void e() {
        if (this.i != null) {
            this.i.b(this);
            this.i.d();
            this.i = null;
            b--;
        }
    }

    public final long f() {
        return this.n;
    }

    private final boolean l() {
        return this.t != null && this.t.d();
    }

    public final long g() {
        if (l()) {
            return 0L;
        }
        return this.n;
    }

    public final long h() {
        if (l() && this.t.e()) {
            return Math.min(this.n, this.t.g());
        }
        return 0L;
    }

    public final long i() {
        if (!l()) {
            while (!this.s.isEmpty()) {
                this.p += a(this.s.remove(0).b());
            }
            return this.p;
        }
        return this.t.h();
    }

    public final int j() {
        return this.o;
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void a(IOException iOException) {
        if (this.m != null) {
            this.m.a("onLoadError", iOException);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqg
    public final void a(zzhp zzhpVar) {
        zzbbe zzbbeVar = this.l.get();
        if (!((Boolean) zzwq.e().a(zzabf.aW)).booleanValue() || zzbbeVar == null || zzhpVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("frameRate", String.valueOf(zzhpVar.j));
        hashMap.put("bitRate", String.valueOf(zzhpVar.a));
        int i = zzhpVar.h;
        int i2 = zzhpVar.i;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        hashMap.put("resolution", sb.toString());
        hashMap.put("videoMime", zzhpVar.c);
        hashMap.put("videoCodec", zzhpVar.b);
        zzbbeVar.a("onMetadataEvent", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzqg
    public final void a(int i, long j) {
        this.o += i;
    }

    @Override // com.google.android.gms.internal.ads.zzqg
    public final void a(int i, int i2, int i3, float f) {
        if (this.m != null) {
            this.m.a(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzih
    public final void b(zzhp zzhpVar) {
        zzbbe zzbbeVar = this.l.get();
        if (!((Boolean) zzwq.e().a(zzabf.aW)).booleanValue() || zzbbeVar == null || zzhpVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("audioMime", zzhpVar.c);
        hashMap.put("audioCodec", zzhpVar.b);
        zzbbeVar.a("onMetadataEvent", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void a(boolean z, int i) {
        if (this.m != null) {
            this.m.b(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void a(zzhe zzheVar) {
        if (this.m != null) {
            this.m.a("onPlayerError", zzheVar);
        }
    }

    public final void b(int i) {
        Iterator<WeakReference<hc>> it = this.u.iterator();
        while (it.hasNext()) {
            hc hcVar = it.next().get();
            if (hcVar != null) {
                hcVar.a(i);
            }
        }
    }

    final void a(Surface surface, boolean z) {
        if (this.i == null) {
            return;
        }
        zzhi zzhiVar = new zzhi(this.e, 1, surface);
        if (z) {
            this.i.b(zzhiVar);
        } else {
            this.i.a(zzhiVar);
        }
    }

    final void a(float f, boolean z) {
        if (this.i == null) {
            return;
        }
        zzhi zzhiVar = new zzhi(this.f, 2, Float.valueOf(f));
        if (z) {
            this.i.b(zzhiVar);
        } else {
            this.i.a(zzhiVar);
        }
    }

    final void b(boolean z) {
        if (this.i == null) {
            return;
        }
        for (int i = 0; i < this.i.e(); i++) {
            this.g.a(i, !z);
        }
    }

    @VisibleForTesting
    private final zzna a(Uri uri, String str) {
        zzom zzomVar;
        zzom zzomVar2;
        zzkb zzkbVar;
        if (this.k && this.j.limit() > 0) {
            byte[] bArr = new byte[this.j.limit()];
            this.j.get(bArr);
            zzomVar2 = new zzom(bArr) { // from class: com.google.android.gms.internal.ads.hg
                private final byte[] a;

                {
                    this.a = bArr;
                }

                @Override // com.google.android.gms.internal.ads.zzom
                public final zzon a() {
                    return new zzok(this.a);
                }
            };
        } else {
            if (this.h.h > 0) {
                zzomVar = new zzom(this, str) { // from class: com.google.android.gms.internal.ads.hj
                    private final zzbca a;
                    private final String b;

                    {
                        this.a = this;
                        this.b = str;
                    }

                    @Override // com.google.android.gms.internal.ads.zzom
                    public final zzon a() {
                        return this.a.b(this.b);
                    }
                };
            } else {
                zzomVar = new zzom(this, str) { // from class: com.google.android.gms.internal.ads.hi
                    private final zzbca a;
                    private final String b;

                    {
                        this.a = this;
                        this.b = str;
                    }

                    @Override // com.google.android.gms.internal.ads.zzom
                    public final zzon a() {
                        return this.a.a(this.b);
                    }
                };
            }
            zzom zzomVar3 = this.h.i ? new zzom(this, zzomVar) { // from class: com.google.android.gms.internal.ads.hl
                private final zzbca a;
                private final zzom b;

                {
                    this.a = this;
                    this.b = zzomVar;
                }

                @Override // com.google.android.gms.internal.ads.zzom
                public final zzon a() {
                    return this.a.a(this.b);
                }
            } : zzomVar;
            if (this.j.limit() > 0) {
                byte[] bArr2 = new byte[this.j.limit()];
                this.j.get(bArr2);
                zzomVar3 = new zzom(zzomVar3, bArr2) { // from class: com.google.android.gms.internal.ads.hk
                    private final zzom a;
                    private final byte[] b;

                    {
                        this.a = zzomVar3;
                        this.b = bArr2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzom
                    public final zzon a() {
                        zzom zzomVar4 = this.a;
                        byte[] bArr3 = this.b;
                        return new hq(new zzok(bArr3), bArr3.length, zzomVar4.a());
                    }
                };
            }
            zzomVar2 = zzomVar3;
        }
        if (((Boolean) zzwq.e().a(zzabf.k)).booleanValue()) {
            zzkbVar = hn.a;
        } else {
            zzkbVar = hm.a;
        }
        return new zzmw(uri, zzomVar2, zzkbVar, this.h.j, com.google.android.gms.ads.internal.util.zzm.a, this, null, this.h.f);
    }

    public final void finalize() throws Throwable {
        a--;
        if (zzd.a()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(26 + String.valueOf(valueOf).length());
            sb.append("ExoPlayerAdapter finalize ");
            sb.append(valueOf);
            zzd.a(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final /* synthetic */ void a(zzon zzonVar, int i) {
        this.n += i;
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final /* synthetic */ void a(zzon zzonVar, zzoo zzooVar) {
        zzon zzonVar2 = zzonVar;
        if (zzonVar2 instanceof zzot) {
            this.s.add((zzot) zzonVar2);
            return;
        }
        if (zzonVar2 instanceof zzbbw) {
            this.t = (zzbbw) zzonVar2;
            zzbbe zzbbeVar = this.l.get();
            if (((Boolean) zzwq.e().a(zzabf.aW)).booleanValue() && zzbbeVar != null && this.t.b()) {
                HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.t.e()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.t.f()));
                com.google.android.gms.ads.internal.util.zzm.a.post(new Runnable(zzbbeVar, hashMap) { // from class: com.google.android.gms.internal.ads.hh
                    private final zzbbe a;
                    private final Map b;

                    {
                        this.a = zzbbeVar;
                        this.b = hashMap;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.a("onGcacheInfoEvent", this.b);
                    }
                });
            }
        }
    }

    final /* synthetic */ zzon a(zzom zzomVar) {
        return new zzbbw(this.c, zzomVar.a(), this.q, this.r, this, new zzbby(this) { // from class: com.google.android.gms.internal.ads.ho
            private final zzbca a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbby
            public final void a(boolean z, long j) {
                this.a.a(z, j);
            }
        });
    }

    final /* synthetic */ void a(boolean z, long j) {
        if (this.m != null) {
            this.m.a(z, j);
        }
    }

    final /* synthetic */ zzon a(String str) {
        return new zzoq(str, null, this.h.i ? null : this, this.h.d, this.h.e, true, null);
    }

    final /* synthetic */ zzon b(String str) {
        hc hcVar = new hc(str, this.h.i ? null : this, this.h.d, this.h.e, this.h.h);
        this.u.add(new WeakReference<>(hcVar));
        return hcVar;
    }
}
