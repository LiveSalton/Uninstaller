package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdhu implements zzepf<zzdfl<JSONObject>> {
    public static zzdfl<JSONObject> a(zzaxy zzaxyVar, Object obj, zzdgc zzdgcVar, zzdhd zzdhdVar, zzeoz<zzdfw> zzeozVar, zzeoz<zzdgg> zzeozVar2, zzeoz<zzdgk> zzeozVar3, zzeoz<zzdgq> zzeozVar4, zzeoz<zzdgz> zzeozVar5, zzeoz<zzdhe> zzeozVar6, zzeoz<zzdhi> zzeozVar7, zzeoz<zzdhw> zzeozVar8, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        HashSet hashSet = new HashSet();
        hashSet.add((aey) obj);
        hashSet.add(zzdgcVar);
        hashSet.add(zzdhdVar);
        if (((Boolean) zzwq.e().a(zzabf.cV)).booleanValue()) {
            hashSet.add(zzeozVar.b());
        }
        if (((Boolean) zzwq.e().a(zzabf.cW)).booleanValue()) {
            hashSet.add(zzeozVar2.b());
        }
        if (((Boolean) zzwq.e().a(zzabf.cX)).booleanValue()) {
            hashSet.add(zzeozVar3.b());
        }
        if (((Boolean) zzwq.e().a(zzabf.cY)).booleanValue()) {
            hashSet.add(zzeozVar4.b());
        }
        if (((Boolean) zzwq.e().a(zzabf.da)).booleanValue()) {
            hashSet.add(new zzddx(zzeozVar6.b(), ((Long) zzwq.e().a(zzabf.bL)).longValue(), scheduledExecutorService));
        }
        if (((Boolean) zzwq.e().a(zzabf.db)).booleanValue()) {
            hashSet.add(zzeozVar7.b());
        }
        if (((Boolean) zzwq.e().a(zzabf.dc)).booleanValue()) {
            hashSet.add(zzeozVar8.b());
        }
        return (zzdfl) zzepl.a(new zzdfl(executor, hashSet), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        throw new NoSuchMethodError();
    }
}
