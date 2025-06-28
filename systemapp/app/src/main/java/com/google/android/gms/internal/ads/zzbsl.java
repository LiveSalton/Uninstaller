package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbsl extends zzbwk<zzbsm> {
    private boolean a;

    public zzbsl(Set<zzbxy<zzbsm>> set) {
        super(set);
        this.a = false;
    }

    public final synchronized void a() {
        if (!this.a) {
            a(my.a);
            this.a = true;
        }
    }
}
