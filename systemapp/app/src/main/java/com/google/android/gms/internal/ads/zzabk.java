package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzabk {
    public static void a(zzabi zzabiVar, zzabj zzabjVar) {
        if (zzabjVar.b() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        }
        if (TextUtils.isEmpty(zzabjVar.c())) {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        zzabiVar.a(zzabjVar.b(), zzabjVar.c(), zzabjVar.a(), zzabjVar.d());
    }
}
