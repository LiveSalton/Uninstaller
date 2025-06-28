package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzayg {
    private Context e;
    private zzazh f;
    private zzdyz<ArrayList<String>> l;
    private final Object a = new Object();
    private final com.google.android.gms.ads.internal.util.zzi b = new com.google.android.gms.ads.internal.util.zzi();
    private final zzayq c = new zzayq(zzwq.f(), this.b);
    private boolean d = false;
    private zzabi g = null;
    private Boolean h = null;
    private final AtomicInteger i = new AtomicInteger(0);
    private final ff j = new ff(null);
    private final Object k = new Object();

    public final zzabi a() {
        zzabi zzabiVar;
        synchronized (this.a) {
            zzabiVar = this.g;
        }
        return zzabiVar;
    }

    public final void a(Boolean bool) {
        synchronized (this.a) {
            this.h = bool;
        }
    }

    public final Boolean b() {
        Boolean bool;
        synchronized (this.a) {
            bool = this.h;
        }
        return bool;
    }

    public final void c() {
        this.j.a();
    }

    @TargetApi(23)
    public final void a(Context context, zzazh zzazhVar) {
        synchronized (this.a) {
            if (!this.d) {
                this.e = context.getApplicationContext();
                this.f = zzazhVar;
                zzp.f().a(this.c);
                zzabi zzabiVar = null;
                this.b.a(this.e, (String) null, true);
                zzasn.a(this.e, this.f);
                zzp.l();
                if (!zzacu.c.a().booleanValue()) {
                    zzd.a("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                } else {
                    zzabiVar = new zzabi();
                }
                this.g = zzabiVar;
                if (this.g != null) {
                    zzazm.a(new fc(this).b(), "AppState.registerCsiReporter");
                }
                this.d = true;
                j();
            }
        }
        zzp.c().b(context, zzazhVar.a);
    }

    public final Resources d() {
        if (this.f.d) {
            return this.e.getResources();
        }
        try {
            zzazd.a(this.e).getResources();
            return null;
        } catch (zzazf e) {
            zzd.d("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final void a(Throwable th, String str) {
        zzasn.a(this.e, this.f).a(th, str);
    }

    public final void b(Throwable th, String str) {
        zzasn.a(this.e, this.f).a(th, str, zzadg.g.a().floatValue());
    }

    public final void e() {
        this.i.incrementAndGet();
    }

    public final void f() {
        this.i.decrementAndGet();
    }

    public final int g() {
        return this.i.get();
    }

    public final zzf h() {
        com.google.android.gms.ads.internal.util.zzi zziVar;
        synchronized (this.a) {
            zziVar = this.b;
        }
        return zziVar;
    }

    public final Context i() {
        return this.e;
    }

    public final zzdyz<ArrayList<String>> j() {
        if (PlatformVersion.b() && this.e != null) {
            if (!((Boolean) zzwq.e().a(zzabf.bk)).booleanValue()) {
                synchronized (this.k) {
                    if (this.l != null) {
                        return this.l;
                    }
                    zzdyz<ArrayList<String>> submit = zzazj.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.fd
                        private final zzayg a;

                        {
                            this.a = this;
                        }

                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.a.l();
                        }
                    });
                    this.l = submit;
                    return submit;
                }
            }
        }
        return zzdyr.a(new ArrayList());
    }

    @TargetApi(16)
    private static ArrayList<String> a(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            PackageInfo b = Wrappers.a(context).b(context.getApplicationInfo().packageName, 4096);
            if (b.requestedPermissions == null || b.requestedPermissionsFlags == null) {
                return arrayList;
            }
            for (int i = 0; i < b.requestedPermissions.length; i++) {
                if ((b.requestedPermissionsFlags[i] & 2) != 0) {
                    arrayList.add(b.requestedPermissions[i]);
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException unused) {
            return arrayList;
        }
    }

    public final zzayq k() {
        return this.c;
    }

    final /* synthetic */ ArrayList l() throws Exception {
        return a(zzauc.b(this.e));
    }
}
