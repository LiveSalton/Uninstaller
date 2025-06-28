package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcwx {
    private final ConcurrentHashMap<String, zzapo> a = new ConcurrentHashMap<>();
    private final zzciq b;

    public zzcwx(zzciq zzciqVar) {
        this.b = zzciqVar;
    }

    public final void a(String str) {
        try {
            this.a.put(str, this.b.a(str));
        } catch (RemoteException e) {
            zzd.c("Couldn't create RTB adapter : ", e);
        }
    }

    @CheckForNull
    public final zzapo b(String str) {
        if (this.a.containsKey(str)) {
            return this.a.get(str);
        }
        return null;
    }
}
