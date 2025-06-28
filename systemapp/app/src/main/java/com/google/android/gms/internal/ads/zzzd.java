package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzzd {

    @GuardedBy("InternalMobileAds.class")
    private static zzzd c;

    @GuardedBy("lock")
    private zzxw d;
    private RewardedVideoAd g;
    private InitializationStatus i;
    private final Object b = new Object();
    private boolean e = false;
    private boolean f = false;
    private RequestConfiguration h = new RequestConfiguration.Builder().a();
    private ArrayList<OnInitializationCompleteListener> a = new ArrayList<>();

    /* compiled from: source */
    class a extends zzajf {
        private a() {
        }

        @Override // com.google.android.gms.internal.ads.zzajc
        public final void a(List<zzaiz> list) throws RemoteException {
            int i = 0;
            zzzd.a(zzzd.this, false);
            zzzd.b(zzzd.this, true);
            InitializationStatus a = zzzd.a(zzzd.this, list);
            ArrayList arrayList = zzzd.a().a;
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((OnInitializationCompleteListener) obj).a(a);
            }
            zzzd.a().a.clear();
        }

        /* synthetic */ a(zzzd zzzdVar, bem bemVar) {
            this();
        }
    }

    private zzzd() {
    }

    public static zzzd a() {
        zzzd zzzdVar;
        synchronized (zzzd.class) {
            if (c == null) {
                c = new zzzd();
            }
            zzzdVar = c;
        }
        return zzzdVar;
    }

    public final void a(Context context, String str, OnInitializationCompleteListener onInitializationCompleteListener) {
        synchronized (this.b) {
            if (this.e) {
                if (onInitializationCompleteListener != null) {
                    a().a.add(onInitializationCompleteListener);
                }
                return;
            }
            if (this.f) {
                if (onInitializationCompleteListener != null) {
                    onInitializationCompleteListener.a(c());
                }
                return;
            }
            this.e = true;
            if (onInitializationCompleteListener != null) {
                a().a.add(onInitializationCompleteListener);
            }
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            }
            try {
                zzand.a().a(context, str);
                b(context);
                if (onInitializationCompleteListener != null) {
                    this.d.a(new a(this, null));
                }
                this.d.a(new zzanj());
                this.d.a();
                this.d.a(str, ObjectWrapper.a(new Runnable(this, context) { // from class: com.google.android.gms.internal.ads.bel
                    private final zzzd a;
                    private final Context b;

                    {
                        this.a = this;
                        this.b = context;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.a(this.b);
                    }
                }));
                if (this.h.a() != -1 || this.h.b() != -1) {
                    a(this.h);
                }
                zzabf.a(context);
                if (!((Boolean) zzwq.e().a(zzabf.cG)).booleanValue() && !b().endsWith("0")) {
                    zzaza.c("Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.");
                    this.i = new InitializationStatus(this) { // from class: com.google.android.gms.internal.ads.ben
                        private final zzzd a;

                        {
                            this.a = this;
                        }
                    };
                    if (onInitializationCompleteListener != null) {
                        zzayr.a.post(new Runnable(this, onInitializationCompleteListener) { // from class: com.google.android.gms.internal.ads.bek
                            private final zzzd a;
                            private final OnInitializationCompleteListener b;

                            {
                                this.a = this;
                                this.b = onInitializationCompleteListener;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.a(this.b);
                            }
                        });
                    }
                }
            } catch (RemoteException e) {
                zzaza.d("MobileAdsSettingManager initialization failed", e);
            }
        }
    }

    public final RewardedVideoAd a(Context context) {
        synchronized (this.b) {
            if (this.g != null) {
                return this.g;
            }
            this.g = new zzaux(context, new bei(zzwq.b(), context, new zzanj()).a(context, false));
            return this.g;
        }
    }

    public final String b() {
        String a2;
        synchronized (this.b) {
            Preconditions.a(this.d != null, "MobileAds.initialize() must be called prior to getting version string.");
            try {
                a2 = zzdwc.a(this.d.d());
            } catch (RemoteException e) {
                zzaza.c("Unable to get version string.", e);
                return "";
            }
        }
        return a2;
    }

    public final InitializationStatus c() {
        synchronized (this.b) {
            Preconditions.a(this.d != null, "MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                if (this.i != null) {
                    return this.i;
                }
                return a(this.d.e());
            } catch (RemoteException unused) {
                zzaza.c("Unable to get Initialization status.");
                return null;
            }
        }
    }

    private static InitializationStatus a(List<zzaiz> list) {
        HashMap hashMap = new HashMap();
        for (zzaiz zzaizVar : list) {
            hashMap.put(zzaizVar.a, new zzajh(zzaizVar.b ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY, zzaizVar.d, zzaizVar.c));
        }
        return new zzajg(hashMap);
    }

    public final RequestConfiguration d() {
        return this.h;
    }

    @GuardedBy("lock")
    private final void a(RequestConfiguration requestConfiguration) {
        try {
            this.d.a(new zzaae(requestConfiguration));
        } catch (RemoteException e) {
            zzaza.c("Unable to set request configuration parcel.", e);
        }
    }

    @GuardedBy("lock")
    private final void b(Context context) {
        if (this.d == null) {
            this.d = new bee(zzwq.b(), context).a(context, false);
        }
    }

    final /* synthetic */ void a(OnInitializationCompleteListener onInitializationCompleteListener) {
        onInitializationCompleteListener.a(this.i);
    }

    static /* synthetic */ boolean a(zzzd zzzdVar, boolean z) {
        zzzdVar.e = false;
        return false;
    }

    static /* synthetic */ boolean b(zzzd zzzdVar, boolean z) {
        zzzdVar.f = true;
        return true;
    }

    static /* synthetic */ InitializationStatus a(zzzd zzzdVar, List list) {
        return a((List<zzaiz>) list);
    }
}
