package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: source */
/* loaded from: classes.dex */
final class vs implements zzdyo<zzdnj> {
    private final /* synthetic */ zzcnh a;

    vs(zzcnh zzcnhVar) {
        this.a = zzcnhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        Pattern pattern;
        zzcpx zzcpxVar;
        if (((Boolean) zzwq.e().a(zzabf.ds)).booleanValue()) {
            pattern = zzcnh.f;
            Matcher matcher = pattern.matcher(th.getMessage());
            if (matcher.matches()) {
                String group = matcher.group(1);
                zzcpxVar = this.a.e;
                zzcpxVar.a(Integer.parseInt(group));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(zzdnj zzdnjVar) {
        zzcpx zzcpxVar;
        zzcpx zzcpxVar2;
        zzdnj zzdnjVar2 = zzdnjVar;
        if (((Boolean) zzwq.e().a(zzabf.ds)).booleanValue()) {
            zzcpxVar = this.a.e;
            zzcpxVar.a(zzdnjVar2.b.b.e);
            zzcpxVar2 = this.a.e;
            zzcpxVar2.a(zzdnjVar2.b.b.f);
        }
    }
}
