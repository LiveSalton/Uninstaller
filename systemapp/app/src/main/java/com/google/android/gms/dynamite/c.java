package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: source */
/* loaded from: classes.dex */
final class c implements DynamiteModule.VersionPolicy {
    c() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.zza a(Context context, String str, DynamiteModule.VersionPolicy.zzb zzbVar) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.zza zzaVar = new DynamiteModule.VersionPolicy.zza();
        zzaVar.b = zzbVar.a(context, str, false);
        if (zzaVar.b == 0) {
            zzaVar.c = 0;
        } else {
            zzaVar.c = 1;
        }
        return zzaVar;
    }
}
