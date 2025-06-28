package com.google.android.gms.internal.ads;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

/* compiled from: source */
/* loaded from: classes.dex */
final class axr extends ayn {
    private byte[] a;

    public axr(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.a = bArr;
    }

    @Override // com.google.android.gms.internal.ads.ayn, java.security.cert.Certificate
    public final byte[] getEncoded() throws CertificateEncodingException {
        return this.a;
    }
}
