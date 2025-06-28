package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzapu {
    public static zzapo a(String str) throws RemoteException {
        return new zzapx((RtbAdapter) Class.forName(str, false, zzapu.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    }
}
