package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.c;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcsm implements zzcqz<zzbyx> {
    private final Context a;
    private final zzbzx b;
    private final Executor c;
    private final zzdms d;

    public zzcsm(Context context, Executor executor, zzbzx zzbzxVar, zzdms zzdmsVar) {
        this.a = context;
        this.b = zzbzxVar;
        this.c = executor;
        this.d = zzdmsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final boolean a(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        return (this.a instanceof Activity) && PlatformVersion.a() && zzacf.a(this.a) && !TextUtils.isEmpty(a(zzdmuVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final zzdyz<zzbyx> b(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        String a = a(zzdmuVar);
        return zzdyr.a(zzdyr.a((Object) null), new zzdyb(this, a != null ? Uri.parse(a) : null, zzdnjVar, zzdmuVar) { // from class: com.google.android.gms.internal.ads.yn
            private final zzcsm a;
            private final Uri b;
            private final zzdnj c;
            private final zzdmu d;

            {
                this.a = this;
                this.b = parse;
                this.c = zzdnjVar;
                this.d = zzdmuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a(this.b, this.c, this.d, obj);
            }
        }, this.c);
    }

    private static String a(zzdmu zzdmuVar) {
        try {
            return zzdmuVar.u.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    final /* synthetic */ zzdyz a(Uri uri, zzdnj zzdnjVar, zzdmu zzdmuVar, Object obj) throws Exception {
        try {
            androidx.browser.customtabs.c a = new c.a().a();
            a.a.setData(uri);
            com.google.android.gms.ads.internal.overlay.zzb zzbVar = new com.google.android.gms.ads.internal.overlay.zzb(a.a);
            zzazq zzazqVar = new zzazq();
            zzbyz a2 = this.b.a(new zzbos(zzdnjVar, zzdmuVar, null), new zzbzc(new zzcaf(zzazqVar) { // from class: com.google.android.gms.internal.ads.yo
                private final zzazq a;

                {
                    this.a = zzazqVar;
                }

                @Override // com.google.android.gms.internal.ads.zzcaf
                public final void a(boolean z, Context context) {
                    zzazq zzazqVar2 = this.a;
                    try {
                        zzp.b();
                        zzo.a(context, (AdOverlayInfoParcel) zzazqVar2.get(), true);
                    } catch (Exception unused) {
                    }
                }
            }));
            zzazqVar.b(new AdOverlayInfoParcel(zzbVar, null, a2.i(), null, new zzazh(0, 0, false)));
            this.d.c();
            return zzdyr.a(a2.h());
        } catch (Throwable th) {
            zzd.c("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}
