package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: source */
/* loaded from: classes.dex */
final class h implements DynamiteModule.VersionPolicy {
    h() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.zza a(Context context, String str, DynamiteModule.VersionPolicy.zzb zzbVar) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.zza zzaVar = new DynamiteModule.VersionPolicy.zza();
        zzaVar.a = zzbVar.a(context, str);
        zzaVar.b = zzbVar.a(context, str, true);
        if (zzaVar.a == 0 && zzaVar.b == 0) {
            zzaVar.c = 0;
        } else if (zzaVar.b >= zzaVar.a) {
            zzaVar.c = 1;
        } else {
            zzaVar.c = -1;
        }
        return zzaVar;
    }
}
