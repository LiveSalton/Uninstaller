package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* compiled from: source */
@TargetApi(16)
/* loaded from: classes.dex */
public final class zzbdi extends zzbcx implements zzbck {
    private zzbca d;
    private String e;
    private boolean f;
    private Exception g;
    private boolean h;

    public zzbdi(zzbbe zzbbeVar, zzbbf zzbbfVar) {
        super(zzbbeVar);
        this.d = new zzbca(zzbbeVar.getContext(), zzbbfVar, this.c.get());
        this.d.a((zzbck) this);
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final void a(int i, int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final void b(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final void a(boolean z, long j) {
        zzbbe zzbbeVar = this.c.get();
        if (zzbbeVar != null) {
            zzazj.e.execute(new Runnable(zzbbeVar, z, j) { // from class: com.google.android.gms.internal.ads.ia
                private final zzbbe a;
                private final boolean b;
                private final long c;

                {
                    this.a = zzbbeVar;
                    this.b = z;
                    this.c = j;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(this.b, this.c);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final void a(String str, Exception exc) {
        String str2 = (String) zzwq.e().a(zzabf.i);
        if (str2 != null) {
            List asList = Arrays.asList(str2.split(","));
            if (asList.contains("all") || asList.contains(exc.getClass().getCanonicalName())) {
                return;
            }
        }
        this.g = exc;
        zzd.d("Precache error", exc);
        c(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbcx
    public final void a(int i) {
        this.d.d().b(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbcx
    public final void c(int i) {
        this.d.d().a(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbcx
    public final void d(int i) {
        this.d.d().c(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbcx
    public final void e(int i) {
        this.d.d().d(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbcx
    public final void b() {
        if (this.d != null) {
            this.d.a((zzbck) null);
            this.d.e();
        }
        super.b();
    }

    @Override // com.google.android.gms.internal.ads.zzbcx
    protected final String b(String str) {
        String valueOf = String.valueOf("cache:");
        String valueOf2 = String.valueOf(super.b(str));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    @Override // com.google.android.gms.internal.ads.zzbcx
    public final boolean a(String str) {
        return a(str, new String[]{str});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [long] */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v9, types: [int] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v4, types: [long] */
    @Override // com.google.android.gms.internal.ads.zzbcx
    public final boolean a(String str, String[] strArr) {
        String str2;
        String str3;
        zzbdi zzbdiVar;
        Exception exc;
        String str4;
        zzbdi zzbdiVar2;
        String str5;
        ?? r5;
        Throwable th;
        Clock clock;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        String str6;
        long j6;
        long g;
        zzbdi zzbdiVar3 = this;
        String str7 = str;
        zzbdiVar3.e = str7;
        String b = b(str);
        String str8 = "error";
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                try {
                    uriArr[i] = Uri.parse(strArr[i]);
                } catch (Exception e) {
                    exc = e;
                    str4 = str7;
                    str3 = b;
                    zzbdiVar2 = zzbdiVar3;
                    String str9 = str8;
                    String message = exc.getMessage();
                    StringBuilder sb = new StringBuilder(34 + String.valueOf(str).length() + String.valueOf(message).length());
                    sb.append("Failed to preload url ");
                    sb.append(str4);
                    sb.append(" Exception: ");
                    sb.append(message);
                    zzd.e(sb.toString());
                    b();
                    zzbdiVar2.a(str4, str3, str9, b(str9, exc));
                    return false;
                }
            }
            zzbdiVar3.d.a(uriArr, zzbdiVar3.b);
            zzbbe zzbbeVar = zzbdiVar3.c.get();
            if (zzbbeVar != null) {
                zzbbeVar.a(b, zzbdiVar3);
            }
            Clock j7 = zzp.j();
            long a = j7.a();
            long longValue = ((Long) zzwq.e().a(zzabf.p)).longValue();
            long longValue2 = ((Long) zzwq.e().a(zzabf.o)).longValue() * 1000;
            long intValue = ((Integer) zzwq.e().a(zzabf.n)).intValue();
            boolean booleanValue = ((Boolean) zzwq.e().a(zzabf.aW)).booleanValue();
            ?? r1 = -1;
            ?? r6 = longValue2;
            while (true) {
                synchronized (this) {
                    try {
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        if (j7.a() - a > r6) {
                            ?? sb2 = new StringBuilder(47);
                            sb2.append("Timeout reached. Limit: ");
                            sb2.append(r6);
                            sb2.append(" ms");
                            throw new IOException(sb2.toString());
                        }
                        if (zzbdiVar3.f) {
                            if (zzbdiVar3.g != null) {
                                throw zzbdiVar3.g;
                            }
                            throw new IOException("Abort requested before buffering finished. ");
                        }
                        if (!zzbdiVar3.h) {
                            zzhd a2 = zzbdiVar3.d.a();
                            if (a2 == null) {
                                throw new IOException("ExoPlayer was released during preloading.");
                            }
                            clock = j7;
                            long f = a2.f();
                            if (f > 0) {
                                long h = a2.h();
                                if (h != r1) {
                                    boolean z = h > 0;
                                    if (booleanValue) {
                                        try {
                                            g = zzbdiVar3.d.g();
                                        } catch (Throwable th3) {
                                            th = th3;
                                            str2 = str7;
                                            str3 = b;
                                            zzbdiVar = zzbdiVar3;
                                            try {
                                                throw th;
                                            } catch (Exception e2) {
                                                e = e2;
                                                exc = e;
                                                zzbdiVar2 = zzbdiVar;
                                                str4 = str2;
                                                String str92 = str8;
                                                String message2 = exc.getMessage();
                                                StringBuilder sb3 = new StringBuilder(34 + String.valueOf(str).length() + String.valueOf(message2).length());
                                                sb3.append("Failed to preload url ");
                                                sb3.append(str4);
                                                sb3.append(" Exception: ");
                                                sb3.append(message2);
                                                zzd.e(sb3.toString());
                                                b();
                                                zzbdiVar2.a(str4, str3, str92, b(str92, exc));
                                                return false;
                                            }
                                        }
                                    } else {
                                        g = -1;
                                    }
                                    j = intValue;
                                    j2 = r6;
                                    long j8 = f;
                                    j5 = longValue;
                                    str6 = b;
                                    try {
                                        zzbdiVar3.a(str7, b, h, j8, z, g, booleanValue ? zzbdiVar3.d.h() : -1L, booleanValue ? zzbdiVar3.d.i() : -1L, zzbca.b(), zzbca.c());
                                        j3 = h;
                                        j6 = f;
                                        str5 = j8;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        str3 = str6;
                                        zzbdiVar = this;
                                        str2 = str;
                                        throw th;
                                    }
                                } else {
                                    j = intValue;
                                    j2 = r6;
                                    j5 = longValue;
                                    str6 = b;
                                    j3 = r1;
                                    j6 = f;
                                    str5 = r6;
                                }
                                r5 = (h > j6 ? 1 : (h == j6 ? 0 : -1));
                                if (r5 >= 0) {
                                    a(str, str6, j6);
                                } else {
                                    try {
                                        str3 = str6;
                                        zzbdi zzbdiVar4 = this;
                                        str5 = str;
                                        if (zzbdiVar4.d.f() < j || h <= 0) {
                                            j4 = j5;
                                            r5 = zzbdiVar4;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        th = th;
                                        zzbdiVar = r5;
                                        str2 = str5;
                                        throw th;
                                    }
                                }
                            } else {
                                j = intValue;
                                j2 = r6;
                                str5 = str7;
                                str3 = b;
                                r5 = zzbdiVar3;
                                j3 = r1;
                                j4 = longValue;
                            }
                            try {
                                r5.wait(j4);
                            } catch (InterruptedException unused) {
                                try {
                                    throw new IOException("Wait interrupted.");
                                } catch (Throwable th6) {
                                    th = th6;
                                    str8 = "interrupted";
                                    th = th;
                                    zzbdiVar = r5;
                                    str2 = str5;
                                    throw th;
                                }
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        str8 = r1;
                        str5 = str7;
                        str3 = b;
                        r5 = zzbdiVar3;
                        th = th;
                        zzbdiVar = r5;
                        str2 = str5;
                        throw th;
                    }
                }
                longValue = j4;
                r1 = j3;
                zzbdiVar3 = r5;
                str7 = str5;
                b = str3;
                j7 = clock;
                intValue = j;
                r6 = j2;
            }
            return true;
        } catch (Exception e3) {
            e = e3;
            str2 = str7;
            str3 = b;
            zzbdiVar = zzbdiVar3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcx
    public final void a() {
        c((String) null);
    }

    private final void c(String str) {
        synchronized (this) {
            this.f = true;
            notify();
            b();
        }
        if (this.e != null) {
            String b = b(this.e);
            if (this.g != null) {
                a(this.e, b, "badUrl", b(str, this.g));
            } else {
                a(this.e, b, "externalAbort", "Programmatic precache abort.");
            }
        }
    }

    public final zzbca c() {
        synchronized (this) {
            this.h = true;
            notify();
        }
        this.d.a((zzbck) null);
        zzbca zzbcaVar = this.d;
        this.d = null;
        return zzbcaVar;
    }

    private static String b(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(2 + String.valueOf(str).length() + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }
}
