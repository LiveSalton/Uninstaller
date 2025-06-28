package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzeci implements zzeao<zzdzx> {
    private static final Logger a = Logger.getLogger(zzeci.class.getName());

    /* compiled from: source */
    static class a implements zzdzx {
        private final zzeam<zzdzx> a;

        public a(zzeam<zzdzx> zzeamVar) {
            this.a = zzeamVar;
        }
    }

    zzeci() {
    }

    @Override // com.google.android.gms.internal.ads.zzeao
    public final Class<zzdzx> a() {
        return zzdzx.class;
    }

    @Override // com.google.android.gms.internal.ads.zzeao
    public final /* synthetic */ zzdzx a(zzeam<zzdzx> zzeamVar) throws GeneralSecurityException {
        return new a(zzeamVar);
    }
}
