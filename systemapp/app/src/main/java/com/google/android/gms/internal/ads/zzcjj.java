package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zztu;
import com.google.android.gms.internal.ads.zzue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcjj implements zzbrz, zzbsm, zzbtj, zzbui, zzbwl, zzva {
    private final zzts a;

    @GuardedBy("this")
    private boolean b = false;

    public zzcjj(zzts zztsVar, @Nullable zzdkt zzdktVar) {
        this.a = zztsVar;
        zztsVar.a(zztu.zza.EnumC0074zza.AD_REQUEST);
        if (zzdktVar != null) {
            zztsVar.a(zztu.zza.EnumC0074zza.REQUEST_IS_PREFETCH);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void a(zzatl zzatlVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void a(zzdnj zzdnjVar) {
        this.a.a(new zztv(zzdnjVar) { // from class: com.google.android.gms.internal.ads.ue
            private final zzdnj a;

            {
                this.a = zzdnjVar;
            }

            @Override // com.google.android.gms.internal.ads.zztv
            public final void a(zzue.zzi.zza zzaVar) {
                zzaVar.a(zzaVar.j().p().a(zzaVar.j().a().p().a(this.a.b.b.b)));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void a() {
        this.a.a(zztu.zza.EnumC0074zza.AD_LOADED);
    }

    @Override // com.google.android.gms.internal.ads.zzbrz
    public final void a_(zzve zzveVar) {
        switch (zzveVar.a) {
            case 1:
                this.a.a(zztu.zza.EnumC0074zza.AD_FAILED_TO_LOAD_INVALID_REQUEST);
                break;
            case 2:
                this.a.a(zztu.zza.EnumC0074zza.AD_FAILED_TO_LOAD_NETWORK_ERROR);
                break;
            case 3:
                this.a.a(zztu.zza.EnumC0074zza.AD_FAILED_TO_LOAD_NO_FILL);
                break;
            case 4:
                this.a.a(zztu.zza.EnumC0074zza.AD_FAILED_TO_LOAD_TIMEOUT);
                break;
            case 5:
                this.a.a(zztu.zza.EnumC0074zza.AD_FAILED_TO_LOAD_CANCELLED);
                break;
            case 6:
                this.a.a(zztu.zza.EnumC0074zza.AD_FAILED_TO_LOAD_NO_ERROR);
                break;
            case 7:
                this.a.a(zztu.zza.EnumC0074zza.AD_FAILED_TO_LOAD_NOT_FOUND);
                break;
            default:
                this.a.a(zztu.zza.EnumC0074zza.AD_FAILED_TO_LOAD);
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final synchronized void b() {
        this.a.a(zztu.zza.EnumC0074zza.AD_IMPRESSION);
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final synchronized void e() {
        if (!this.b) {
            this.a.a(zztu.zza.EnumC0074zza.AD_FIRST_CLICK);
            this.b = true;
        } else {
            this.a.a(zztu.zza.EnumC0074zza.AD_SUBSEQUENT_CLICK);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwl
    public final void a(zzue.zzb zzbVar) {
        this.a.a(new zztv(zzbVar) { // from class: com.google.android.gms.internal.ads.ud
            private final zzue.zzb a;

            {
                this.a = zzbVar;
            }

            @Override // com.google.android.gms.internal.ads.zztv
            public final void a(zzue.zzi.zza zzaVar) {
                zzaVar.a(this.a);
            }
        });
        this.a.a(zztu.zza.EnumC0074zza.REQUEST_LOADED_FROM_CACHE);
    }

    @Override // com.google.android.gms.internal.ads.zzbwl
    public final void b(zzue.zzb zzbVar) {
        this.a.a(new zztv(zzbVar) { // from class: com.google.android.gms.internal.ads.ug
            private final zzue.zzb a;

            {
                this.a = zzbVar;
            }

            @Override // com.google.android.gms.internal.ads.zztv
            public final void a(zzue.zzi.zza zzaVar) {
                zzaVar.a(this.a);
            }
        });
        this.a.a(zztu.zza.EnumC0074zza.REQUEST_SAVED_TO_CACHE);
    }

    @Override // com.google.android.gms.internal.ads.zzbwl
    public final void c(zzue.zzb zzbVar) {
        this.a.a(new zztv(zzbVar) { // from class: com.google.android.gms.internal.ads.uf
            private final zzue.zzb a;

            {
                this.a = zzbVar;
            }

            @Override // com.google.android.gms.internal.ads.zztv
            public final void a(zzue.zzi.zza zzaVar) {
                zzaVar.a(this.a);
            }
        });
        this.a.a(zztu.zza.EnumC0074zza.REQUEST_PREFETCH_INTERCEPTED);
    }

    @Override // com.google.android.gms.internal.ads.zzbwl
    public final void a(boolean z) {
        zztu.zza.EnumC0074zza enumC0074zza;
        zzts zztsVar = this.a;
        if (z) {
            enumC0074zza = zztu.zza.EnumC0074zza.REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED;
        } else {
            enumC0074zza = zztu.zza.EnumC0074zza.REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED;
        }
        zztsVar.a(enumC0074zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwl
    public final void b(boolean z) {
        zztu.zza.EnumC0074zza enumC0074zza;
        zzts zztsVar = this.a;
        if (z) {
            enumC0074zza = zztu.zza.EnumC0074zza.NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED;
        } else {
            enumC0074zza = zztu.zza.EnumC0074zza.NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED;
        }
        zztsVar.a(enumC0074zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwl
    public final void h_() {
        this.a.a(zztu.zza.EnumC0074zza.REQUEST_FAILED_TO_LOAD_FROM_CACHE);
    }
}
