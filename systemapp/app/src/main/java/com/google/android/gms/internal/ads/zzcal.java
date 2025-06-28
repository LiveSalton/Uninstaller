package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.internal.ads.zzue;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcal implements zzbru, zzbxn {
    private final zzawu a;
    private final Context b;
    private final zzawx c;
    private final View d;
    private String e;
    private final zzue.zza.EnumC0075zza f;

    public zzcal(zzawu zzawuVar, Context context, zzawx zzawxVar, View view, zzue.zza.EnumC0075zza enumC0075zza) {
        this.a = zzawuVar;
        this.b = context;
        this.c = zzawxVar;
        this.d = view;
        this.f = enumC0075zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbxn
    public final void a() {
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void f() {
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void g() {
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void h() {
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void c() {
        if (this.d != null && this.e != null) {
            this.c.c(this.d.getContext(), this.e);
        }
        this.a.a(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void d() {
        this.a.a(false);
    }

    @Override // com.google.android.gms.internal.ads.zzbxn
    public final void e() {
        this.e = this.c.b(this.b);
        String valueOf = String.valueOf(this.e);
        String valueOf2 = String.valueOf(this.f == zzue.zza.EnumC0075zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial");
        this.e = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    @ParametersAreNonnullByDefault
    public final void a(zzauf zzaufVar, String str, String str2) {
        if (this.c.a(this.b)) {
            try {
                this.c.a(this.b, this.c.e(this.b), this.a.a(), zzaufVar.a(), zzaufVar.b());
            } catch (RemoteException e) {
                zzd.d("Remote Exception to get reward item.", e);
            }
        }
    }
}
