package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzeay implements zzeao<zzdzt> {
    private static final Logger a = Logger.getLogger(zzeay.class.getName());

    zzeay() {
    }

    @Override // com.google.android.gms.internal.ads.zzeao
    public final Class<zzdzt> a() {
        return zzdzt.class;
    }

    /* compiled from: source */
    static class a implements zzdzt {
        private final zzeam<zzdzt> a;

        private a(zzeam<zzdzt> zzeamVar) {
            this.a = zzeamVar;
        }

        @Override // com.google.android.gms.internal.ads.zzdzt
        public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return zzegr.a(this.a.a().d(), this.a.a().a().a(bArr, bArr2));
        }

        /* synthetic */ a(zzeam zzeamVar, aon aonVar) {
            this(zzeamVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeao
    public final /* synthetic */ zzdzt a(zzeam<zzdzt> zzeamVar) throws GeneralSecurityException {
        return new a(zzeamVar);
    }
}
