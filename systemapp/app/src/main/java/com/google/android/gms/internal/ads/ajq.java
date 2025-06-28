package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
final class ajq implements zzduf {
    private final /* synthetic */ zzdsg a;

    ajq(zzdp zzdpVar, zzdsg zzdsgVar) {
        this.a = zzdsgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzduf
    public final boolean a(File file) {
        try {
            return this.a.a(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
