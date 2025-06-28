package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzze {
    private final zzanj a;
    private final Context b;
    private final zzvl c;
    private AdListener d;
    private zzva e;
    private zzxg f;
    private String g;
    private AdMetadataListener h;
    private AppEventListener i;
    private OnCustomRenderedAdLoadedListener j;
    private RewardedVideoAdListener k;
    private boolean l;
    private boolean m;
    private OnPaidEventListener n;

    public zzze(Context context) {
        this(context, zzvl.a, null);
    }

    @VisibleForTesting
    private zzze(Context context, zzvl zzvlVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.a = new zzanj();
        this.b = context;
        this.c = zzvlVar;
    }

    public final boolean a() {
        try {
            if (this.f == null) {
                return false;
            }
            return this.f.c();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final void a(zzza zzzaVar) {
        try {
            if (this.f == null) {
                if (this.g == null) {
                    b("loadAd");
                }
                zzvn b = this.l ? zzvn.b() : new zzvn();
                zzvx b2 = zzwq.b();
                Context context = this.b;
                this.f = new bec(b2, context, b, this.g, this.a).a(context, false);
                if (this.d != null) {
                    this.f.a(new zzvg(this.d));
                }
                if (this.e != null) {
                    this.f.a(new zzuz(this.e));
                }
                if (this.h != null) {
                    this.f.a(new zzvh(this.h));
                }
                if (this.i != null) {
                    this.f.a(new zzvt(this.i));
                }
                if (this.j != null) {
                    this.f.a(new zzacc(this.j));
                }
                if (this.k != null) {
                    this.f.a(new zzaus(this.k));
                }
                this.f.a(new zzaaf(this.n));
                this.f.b(this.m);
            }
            if (this.f.a(zzvl.a(this.b, zzzaVar))) {
                this.a.a(zzzaVar.k());
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    public final void a(AdListener adListener) {
        try {
            this.d = adListener;
            if (this.f != null) {
                this.f.a(adListener != null ? new zzvg(adListener) : null);
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    public final void a(zzva zzvaVar) {
        try {
            this.e = zzvaVar;
            if (this.f != null) {
                this.f.a(zzvaVar != null ? new zzuz(zzvaVar) : null);
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    public final void a(String str) {
        if (this.g != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.g = str;
    }

    public final void a(AdMetadataListener adMetadataListener) {
        try {
            this.h = adMetadataListener;
            if (this.f != null) {
                this.f.a(adMetadataListener != null ? new zzvh(adMetadataListener) : null);
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    public final Bundle b() {
        try {
            if (this.f != null) {
                return this.f.f();
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
        return new Bundle();
    }

    public final void a(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.k = rewardedVideoAdListener;
            if (this.f != null) {
                this.f.a(rewardedVideoAdListener != null ? new zzaus(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    public final void a(boolean z) {
        this.l = true;
    }

    public final void c() {
        try {
            b("show");
            this.f.g();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    public final void b(boolean z) {
        try {
            this.m = z;
            if (this.f != null) {
                this.f.b(z);
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    private final void b(String str) {
        if (this.f == null) {
            StringBuilder sb = new StringBuilder(63 + String.valueOf(str).length());
            sb.append("The ad unit ID must be set on InterstitialAd before ");
            sb.append(str);
            sb.append(" is called.");
            throw new IllegalStateException(sb.toString());
        }
    }
}
