package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* compiled from: source */
@ShowFirstParty
@KeepForSdk
@CheckReturnValue
/* loaded from: classes.dex */
public class GoogleSignatureVerifier {

    @Nullable
    private static GoogleSignatureVerifier a;
    private final Context b;

    private GoogleSignatureVerifier(Context context) {
        this.b = context.getApplicationContext();
    }

    @KeepForSdk
    public static GoogleSignatureVerifier a(Context context) {
        Preconditions.a(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (a == null) {
                a.a(context);
                a = new GoogleSignatureVerifier(context);
            }
        }
        return a;
    }

    public static boolean a(PackageInfo packageInfo, boolean z) {
        b a2;
        if (packageInfo != null && packageInfo.signatures != null) {
            if (z) {
                a2 = a(packageInfo, f.a);
            } else {
                a2 = a(packageInfo, f.a[0]);
            }
            if (a2 != null) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    private static b a(PackageInfo packageInfo, b... bVarArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        d dVar = new d(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < bVarArr.length; i++) {
            if (bVarArr[i].equals(dVar)) {
                return bVarArr[i];
            }
        }
        return null;
    }
}
