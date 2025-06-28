package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdhm implements zzepf<String> {
    private final zzdhn a;

    public zzdhm(zzdhn zzdhnVar) {
        this.a = zzdhnVar;
    }

    public static String a(zzdhn zzdhnVar) {
        return (String) zzepl.a(zzdhnVar.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a);
    }
}
