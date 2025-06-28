package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdon implements zzaym, zzbrz {

    @GuardedBy("this")
    private final HashSet<zzayf> a = new HashSet<>();
    private final Context b;
    private final zzayq c;

    public zzdon(Context context, zzayq zzayqVar) {
        this.b = context;
        this.c = zzayqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrz
    public final synchronized void a_(zzve zzveVar) {
        if (zzveVar.a != 3) {
            this.c.a(this.a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaym
    public final synchronized void a(HashSet<zzayf> hashSet) {
        this.a.clear();
        this.a.addAll(hashSet);
    }

    public final Bundle a() {
        return this.c.a(this.b, this);
    }
}
