package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* compiled from: source */
/* loaded from: classes.dex */
class apx implements zzeao<zzeak> {
    private static final Logger a = Logger.getLogger(apx.class.getName());

    apx() {
    }

    @Override // com.google.android.gms.internal.ads.zzeao
    public final Class<zzeak> a() {
        return zzeak.class;
    }

    /* compiled from: source */
    static class a implements zzeak {
        private final zzeam<zzeak> a;
        private final byte[] b;

        private a(zzeam<zzeak> zzeamVar) {
            this.b = new byte[]{0};
            this.a = zzeamVar;
        }

        @Override // com.google.android.gms.internal.ads.zzeak
        public final byte[] a(byte[] bArr) throws GeneralSecurityException {
            if (this.a.a().c().equals(zzegd.LEGACY)) {
                return zzegr.a(this.a.a().d(), this.a.a().a().a(zzegr.a(bArr, this.b)));
            }
            return zzegr.a(this.a.a().d(), this.a.a().a().a(bArr));
        }

        /* synthetic */ a(zzeam zzeamVar, apy apyVar) {
            this(zzeamVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeao
    public final /* synthetic */ zzeak a(zzeam<zzeak> zzeamVar) throws GeneralSecurityException {
        return new a(zzeamVar);
    }
}
