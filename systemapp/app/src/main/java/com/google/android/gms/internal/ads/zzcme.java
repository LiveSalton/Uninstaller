package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzcme extends Exception {
    private final zzdok a;

    public zzcme(zzdok zzdokVar) {
        this.a = zzdokVar;
    }

    public zzcme(zzdok zzdokVar, String str) {
        super(str);
        this.a = zzdokVar;
    }

    public zzcme(zzdok zzdokVar, String str, Throwable th) {
        super(str, th);
        this.a = zzdokVar;
    }

    public final zzdok a() {
        return this.a;
    }
}
