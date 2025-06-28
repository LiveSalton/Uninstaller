package com.jumobile.manager.systemapp.util;

import android.content.Context;
import android.content.pm.Signature;

/* compiled from: source */
/* loaded from: classes.dex */
public class d {
    private static final String a = "d";

    public static boolean a(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr != null && signatureArr.length > 0) {
                for (Signature signature : signatureArr) {
                    if ("2B6CD59B26F73DFC5F4B3661B69BC76C".equals(f.a(signature.toByteArray()))) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
