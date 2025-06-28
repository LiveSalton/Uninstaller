package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzalb {
    private final Object a;
    private final Context b;
    private final String c;
    private final zzazh d;
    private com.google.android.gms.ads.internal.util.zzau<zzako> e;
    private com.google.android.gms.ads.internal.util.zzau<zzako> f;
    private zzals g;
    private int h;

    private zzalb(Context context, zzazh zzazhVar, String str) {
        this.a = new Object();
        this.h = 1;
        this.c = str;
        this.b = context.getApplicationContext();
        this.d = zzazhVar;
        this.e = new zzalp();
        this.f = new zzalp();
    }

    public zzalb(Context context, zzazh zzazhVar, String str, com.google.android.gms.ads.internal.util.zzau<zzako> zzauVar, com.google.android.gms.ads.internal.util.zzau<zzako> zzauVar2) {
        this(context, zzazhVar, str);
        this.e = zzauVar;
        this.f = zzauVar2;
    }

    protected final zzals a(zzef zzefVar) {
        zzals zzalsVar = new zzals(this.f);
        zzazj.e.execute(new Runnable(this, zzefVar, zzalsVar) { // from class: com.google.android.gms.internal.ads.bq
            private final zzalb a;
            private final zzef b;
            private final zzals c;

            {
                this.a = this;
                this.b = zzefVar;
                this.c = zzalsVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(this.b, this.c);
            }
        });
        zzalsVar.a(new bz(this, zzalsVar), new cc(this, zzalsVar));
        return zzalsVar;
    }

    public final zzalo b(zzef zzefVar) {
        synchronized (this.a) {
            synchronized (this.a) {
                if (this.g != null && this.h == 0) {
                    this.g.a(new zzazu(this) { // from class: com.google.android.gms.internal.ads.bs
                        private final zzalb a;

                        {
                            this.a = this;
                        }

                        @Override // com.google.android.gms.internal.ads.zzazu
                        public final void a(Object obj) {
                            this.a.a((zzako) obj);
                        }
                    }, br.a);
                }
            }
            if (this.g != null && this.g.e() != -1) {
                if (this.h == 0) {
                    return this.g.a();
                }
                if (this.h == 1) {
                    this.h = 2;
                    a((zzef) null);
                    return this.g.a();
                }
                if (this.h == 2) {
                    return this.g.a();
                }
                return this.g.a();
            }
            this.h = 2;
            this.g = a((zzef) null);
            return this.g.a();
        }
    }

    final /* synthetic */ void a(zzako zzakoVar) {
        if (zzakoVar.b()) {
            this.h = 1;
        }
    }

    final /* synthetic */ void a(zzef zzefVar, zzals zzalsVar) {
        zzako zzakqVar;
        try {
            Context context = this.b;
            zzazh zzazhVar = this.d;
            if (zzadm.c.a().booleanValue()) {
                zzakqVar = new zzaka(context, zzazhVar);
            } else {
                zzakqVar = new zzakq(context, zzazhVar, zzefVar, null);
            }
            zzakqVar.a(new zzakr(this, zzalsVar, zzakqVar) { // from class: com.google.android.gms.internal.ads.bu
                private final zzalb a;
                private final zzals b;
                private final zzako c;

                {
                    this.a = this;
                    this.b = zzalsVar;
                    this.c = zzakqVar;
                }

                @Override // com.google.android.gms.internal.ads.zzakr
                public final void a() {
                    com.google.android.gms.ads.internal.util.zzm.a.postDelayed(new Runnable(this.a, this.b, this.c) { // from class: com.google.android.gms.internal.ads.bt
                        private final zzalb a;
                        private final zzals b;
                        private final zzako c;

                        {
                            this.a = r1;
                            this.b = r2;
                            this.c = r3;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.a(this.b, this.c);
                        }
                    }, cb.b);
                }
            });
            zzakqVar.a("/jsLoaded", new bv(this, zzalsVar, zzakqVar));
            com.google.android.gms.ads.internal.util.zzbr zzbrVar = new com.google.android.gms.ads.internal.util.zzbr();
            by byVar = new by(this, zzefVar, zzakqVar, zzbrVar);
            zzbrVar.a(byVar);
            zzakqVar.a("/requestReload", byVar);
            if (this.c.endsWith(".js")) {
                zzakqVar.a(this.c);
            } else if (this.c.startsWith("<html>")) {
                zzakqVar.b(this.c);
            } else {
                zzakqVar.c(this.c);
            }
            com.google.android.gms.ads.internal.util.zzm.a.postDelayed(new bx(this, zzalsVar, zzakqVar), cb.a);
        } catch (Throwable th) {
            zzd.c("Error creating webview.", th);
            zzp.g().a(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzalsVar.d();
        }
    }

    final /* synthetic */ void a(zzals zzalsVar, zzako zzakoVar) {
        synchronized (this.a) {
            if (zzalsVar.e() != -1 && zzalsVar.e() != 1) {
                zzalsVar.d();
                zzdzc zzdzcVar = zzazj.e;
                zzakoVar.getClass();
                zzdzcVar.execute(bw.a(zzakoVar));
                zzd.a("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }
}
