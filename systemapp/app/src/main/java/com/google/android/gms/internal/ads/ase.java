package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

/* compiled from: source */
/* loaded from: classes.dex */
final class ase extends ThreadLocal<SecureRandom> {
    ase() {
    }

    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ SecureRandom initialValue() {
        SecureRandom b;
        b = zzehx.b();
        return b;
    }
}
