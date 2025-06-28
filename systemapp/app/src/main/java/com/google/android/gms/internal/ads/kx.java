package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

/* compiled from: source */
/* loaded from: classes.dex */
final class kx implements zzaz {
    private File a = null;
    private final /* synthetic */ Context b;

    kx(Context context) {
        this.b = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final File a() {
        if (this.a == null) {
            this.a = new File(this.b.getCacheDir(), "volley");
        }
        return this.a;
    }
}
