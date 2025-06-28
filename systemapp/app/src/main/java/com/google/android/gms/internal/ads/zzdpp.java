package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdpp implements zzdpq {
    private final Object[] a;

    public zzdpp(zzvk zzvkVar, String str, int i, String str2, zzvw zzvwVar) {
        HashSet hashSet = new HashSet(Arrays.asList(str2.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(zzvkVar.b));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(a(zzvkVar.c));
        } else if (hashSet.contains("npa")) {
            arrayList.add(zzvkVar.c.getString("npa"));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(zzvkVar.d));
        }
        if (hashSet.contains("keywords")) {
            if (zzvkVar.e != null) {
                arrayList.add(zzvkVar.e.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(zzvkVar.f));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(zzvkVar.g));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(zzvkVar.h));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(zzvkVar.i);
        }
        if (hashSet.contains("location")) {
            if (zzvkVar.k != null) {
                arrayList.add(zzvkVar.k.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(zzvkVar.l);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(a(zzvkVar.m));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(a(zzvkVar.n));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (zzvkVar.o != null) {
                arrayList.add(zzvkVar.o.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(zzvkVar.p);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(zzvkVar.q);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(zzvkVar.r));
        }
        if (hashSet.contains("tagForUnderAgeOfConsent")) {
            arrayList.add(Integer.valueOf(zzvkVar.t));
        }
        if (hashSet.contains("maxAdContentRating")) {
            arrayList.add(zzvkVar.u);
        }
        if (hashSet.contains("orientation")) {
            if (zzvwVar != null) {
                arrayList.add(Integer.valueOf(zzvwVar.a));
            } else {
                arrayList.add(null);
            }
        }
        this.a = arrayList.toArray();
    }

    @Override // com.google.android.gms.internal.ads.zzdpq
    public final boolean equals(Object obj) {
        if (obj instanceof zzdpp) {
            return Arrays.equals(this.a, ((zzdpp) obj).a);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdpq
    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public final String toString() {
        int hashCode = hashCode();
        String arrays = Arrays.toString(this.a);
        StringBuilder sb = new StringBuilder(22 + String.valueOf(arrays).length());
        sb.append("[PoolKey#");
        sb.append(hashCode);
        sb.append(" ");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }

    private static String a(Bundle bundle) {
        String obj;
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj2 = bundle.get((String) it.next());
            if (obj2 == null) {
                obj = "null";
            } else if (obj2 instanceof Bundle) {
                obj = a((Bundle) obj2);
            } else {
                obj = obj2.toString();
            }
            sb.append(obj);
        }
        return sb.toString();
    }
}
