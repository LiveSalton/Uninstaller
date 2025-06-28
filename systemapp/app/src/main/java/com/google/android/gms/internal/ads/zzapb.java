package com.google.android.gms.internal.ads;

import com.google.ads.a;
import java.util.Date;
import java.util.HashSet;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzapb {
    public static int a(a.EnumC0056a enumC0056a) {
        switch (enumC0056a) {
            case INVALID_REQUEST:
                return 1;
            case NETWORK_ERROR:
                return 2;
            case NO_FILL:
                return 3;
            default:
                return 0;
        }
    }

    public static com.google.ads.mediation.a a(zzvk zzvkVar, boolean z) {
        a.b bVar;
        HashSet hashSet = zzvkVar.e != null ? new HashSet(zzvkVar.e) : null;
        Date date = new Date(zzvkVar.b);
        switch (zzvkVar.d) {
            case 1:
                bVar = a.b.MALE;
                break;
            case 2:
                bVar = a.b.FEMALE;
                break;
            default:
                bVar = a.b.UNKNOWN;
                break;
        }
        return new com.google.ads.mediation.a(date, bVar, hashSet, z, zzvkVar.k);
    }
}
