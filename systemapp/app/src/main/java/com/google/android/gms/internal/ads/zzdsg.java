package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* compiled from: source */
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzdsg {

    @VisibleForTesting
    private static final byte[] c = {61, 122, 18, 35, 1, -102, -93, -99, -98, -96, -29, 67, 106, -73, -64, -119, 107, -5, 79, -74, 121, -12, -34, 95, -25, -62, 63, 50, 108, -113, -103, 74};

    @VisibleForTesting
    private static final byte[] d = {16, 57, 56, -18, 69, 55, -27, -98, -114, -25, -110, -10, 84, 80, 79, -72, 52, 111, -58, -77, 70, -48, -69, -60, 65, 95, -61, 57, -4, -4, -114, -63};
    private final byte[] a = d;
    private final byte[] b = c;

    public final boolean a(File file) throws GeneralSecurityException {
        byte[] digest = MessageDigest.getInstance("SHA-256").digest(a(file.getAbsolutePath()).getEncoded());
        if (Arrays.equals(this.b, digest)) {
            return true;
        }
        return !"user".equals(Build.TYPE) && Arrays.equals(this.a, digest);
    }

    private static X509Certificate a(String str) throws GeneralSecurityException {
        try {
            X509Certificate[][] a = zzb.a(str);
            if (a.length != 1) {
                throw new GeneralSecurityException("APK has more than one signature.");
            }
            return a[0][0];
        } catch (zzh e) {
            throw new GeneralSecurityException("Package is not signed", e);
        } catch (IOException | RuntimeException e2) {
            throw new GeneralSecurityException("Failed to verify signatures", e2);
        }
    }
}
