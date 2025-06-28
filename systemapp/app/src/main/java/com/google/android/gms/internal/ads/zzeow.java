package com.google.android.gms.internal.ads;

import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeow extends zzeox {
    private Logger a;

    public zzeow(String str) {
        this.a = Logger.getLogger(str);
    }

    @Override // com.google.android.gms.internal.ads.zzeox
    public final void a(String str) {
        this.a.logp(Level.FINE, "com.googlecode.mp4parser.util.JuliLogger", "logDebug", str);
    }
}
