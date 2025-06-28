package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzadv extends zzaei {
    private final Drawable a;
    private final Uri b;
    private final double c;
    private final int d;
    private final int e;

    public zzadv(Drawable drawable, Uri uri, double d, int i, int i2) {
        this.a = drawable;
        this.b = uri;
        this.c = d;
        this.d = i;
        this.e = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final IObjectWrapper a() throws RemoteException {
        return ObjectWrapper.a(this.a);
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final Uri b() throws RemoteException {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final double c() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final int d() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final int e() {
        return this.e;
    }
}
