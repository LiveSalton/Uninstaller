package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeah {
    private static final CopyOnWriteArrayList<zzeai> a = new CopyOnWriteArrayList<>();

    public static zzeai a(String str) throws GeneralSecurityException {
        Iterator<zzeai> it = a.iterator();
        while (it.hasNext()) {
            zzeai next = it.next();
            if (next.a(str)) {
                return next;
            }
        }
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No KMS client does support: ".concat(valueOf) : new String("No KMS client does support: "));
    }
}
