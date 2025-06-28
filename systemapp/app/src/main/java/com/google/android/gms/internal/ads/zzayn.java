package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzayn {

    @VisibleForTesting
    private final String g;
    private final zzf h;

    @VisibleForTesting
    private long b = -1;

    @VisibleForTesting
    private long c = -1;

    @VisibleForTesting
    @GuardedBy("lock")
    private int d = -1;

    @VisibleForTesting
    int a = -1;

    @VisibleForTesting
    private long e = 0;
    private final Object f = new Object();

    @VisibleForTesting
    @GuardedBy("lock")
    private int i = 0;

    @VisibleForTesting
    @GuardedBy("lock")
    private int j = 0;

    public zzayn(String str, zzf zzfVar) {
        this.g = str;
        this.h = zzfVar;
    }

    public final void a() {
        synchronized (this.f) {
            this.i++;
        }
    }

    public final void b() {
        synchronized (this.f) {
            this.j++;
        }
    }

    public final void a(zzvk zzvkVar, long j) {
        synchronized (this.f) {
            long i = this.h.i();
            long a = zzp.j().a();
            if (this.c == -1) {
                if (a - i > ((Long) zzwq.e().a(zzabf.ar)).longValue()) {
                    this.a = -1;
                } else {
                    this.a = this.h.j();
                }
                this.c = j;
                this.b = this.c;
            } else {
                this.b = j;
            }
            if (zzvkVar == null || zzvkVar.c == null || zzvkVar.c.getInt("gw", 2) != 1) {
                this.d++;
                this.a++;
                if (this.a == 0) {
                    this.e = 0L;
                    this.h.b(a);
                } else {
                    this.e = a - this.h.k();
                }
            }
        }
    }

    public final Bundle a(Context context, String str) {
        Bundle bundle;
        synchronized (this.f) {
            bundle = new Bundle();
            bundle.putString("session_id", this.g);
            bundle.putLong("basets", this.c);
            bundle.putLong("currts", this.b);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.d);
            bundle.putInt("preqs_in_session", this.a);
            bundle.putLong("time_in_session", this.e);
            bundle.putInt("pclick", this.i);
            bundle.putInt("pimp", this.j);
            bundle.putBoolean("support_transparent_background", a(context));
        }
        return bundle;
    }

    private static boolean a(Context context) {
        Context b = zzauc.b(context);
        int identifier = b.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            zzd.d("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == b.getPackageManager().getActivityInfo(new ComponentName(b.getPackageName(), "com.google.android.gms.ads.AdActivity"), 0).theme) {
                return true;
            }
            zzd.d("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            zzd.e("Fail to fetch AdActivity theme");
            zzd.d("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }
}
