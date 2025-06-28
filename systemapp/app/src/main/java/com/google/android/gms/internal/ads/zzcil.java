package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcil {

    @GuardedBy("this")
    private final Map<String, zzcim> a = new HashMap();

    zzcil() {
    }

    final synchronized void a(String str, zzdoe zzdoeVar) {
        if (this.a.containsKey(str)) {
            return;
        }
        try {
            this.a.put(str, new zzcim(str, zzdoeVar.m(), zzdoeVar.n()));
        } catch (zzdnr unused) {
        }
    }

    final synchronized void a(String str, zzapo zzapoVar) {
        if (this.a.containsKey(str)) {
            return;
        }
        try {
            this.a.put(str, new zzcim(str, zzapoVar.a(), zzapoVar.b()));
        } catch (Throwable unused) {
        }
    }

    @Nullable
    public final synchronized zzcim a(String str) {
        return this.a.get(str);
    }
}
