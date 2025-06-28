package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcfd {
    public final int a;
    public final String b;
    public final String c;
    public final zzadv d;

    @VisibleForTesting
    public zzcfd(String str, String str2) {
        this.a = 1;
        this.b = str;
        this.c = str2;
        this.d = null;
    }

    @VisibleForTesting
    public zzcfd(String str, zzadv zzadvVar) {
        this.a = 2;
        this.b = str;
        this.c = null;
        this.d = zzadvVar;
    }
}
