package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzels;
import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
final class aoh<KeyFormatProtoT extends zzels, KeyProtoT extends zzels> {
    private final zzead<KeyFormatProtoT, KeyProtoT> a;

    aoh(zzead<KeyFormatProtoT, KeyProtoT> zzeadVar) {
        this.a = zzeadVar;
    }

    final KeyProtoT a(zzeiu zzeiuVar) throws GeneralSecurityException, zzeks {
        KeyFormatProtoT a = this.a.a(zzeiuVar);
        this.a.a((zzead<KeyFormatProtoT, KeyProtoT>) a);
        return this.a.b(a);
    }
}
