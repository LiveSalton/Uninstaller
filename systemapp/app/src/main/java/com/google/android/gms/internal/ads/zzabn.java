package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzabn {
    public static boolean a(zzabs zzabsVar, zzabq zzabqVar, String... strArr) {
        if (zzabsVar == null || zzabqVar == null || !zzabsVar.a || zzabqVar == null) {
            return false;
        }
        return zzabsVar.a(zzabqVar, zzp.j().b(), strArr);
    }

    public static zzabq a(zzabs zzabsVar) {
        if (zzabsVar == null) {
            return null;
        }
        return zzabsVar.a(zzp.j().b());
    }
}
