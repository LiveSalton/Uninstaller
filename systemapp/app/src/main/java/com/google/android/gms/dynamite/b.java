package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: source */
/* loaded from: classes.dex */
final class b implements DynamiteModule.VersionPolicy.zzb {
    b() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb
    public final int a(Context context, String str, boolean z) throws DynamiteModule.LoadingException {
        return DynamiteModule.a(context, str, z);
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb
    public final int a(Context context, String str) {
        return DynamiteModule.a(context, str);
    }
}
