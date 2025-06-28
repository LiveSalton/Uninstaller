package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzue;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcqe {
    private static final SparseArray<zzue.zzo.zzc> g;
    private final Context a;
    private final zzbqz b;
    private final TelephonyManager c;
    private final zzcpx d;
    private final zzcpr e;
    private zzuo f;

    zzcqe(Context context, zzbqz zzbqzVar, zzcpx zzcpxVar, zzcpr zzcprVar) {
        this.a = context;
        this.b = zzbqzVar;
        this.d = zzcpxVar;
        this.e = zzcprVar;
        this.c = (TelephonyManager) context.getSystemService("phone");
    }

    private static zzuo b(boolean z) {
        return z ? zzuo.ENUM_TRUE : zzuo.ENUM_FALSE;
    }

    public final zzue.zzm a(Bundle bundle) {
        zzue.zzm.zza zzaVar;
        zzue.zzm.zzb a = zzue.zzm.a();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            this.f = zzuo.ENUM_TRUE;
        } else {
            this.f = zzuo.ENUM_FALSE;
            switch (i) {
                case 0:
                    a.a(zzue.zzm.zzc.CELL);
                    break;
                case 1:
                    a.a(zzue.zzm.zzc.WIFI);
                    break;
                default:
                    a.a(zzue.zzm.zzc.NETWORKTYPE_UNSPECIFIED);
                    break;
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzaVar = zzue.zzm.zza.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzaVar = zzue.zzm.zza.THREE_G;
                    break;
                case 13:
                    zzaVar = zzue.zzm.zza.LTE;
                    break;
                default:
                    zzaVar = zzue.zzm.zza.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            a.a(zzaVar);
        }
        return (zzue.zzm) ((zzekh) a.g());
    }

    public static zzue.zzo.zzc b(Bundle bundle) {
        return g.get(zzdnx.a(zzdnx.a(bundle, "device"), "network").getInt("active_network_state", -1), zzue.zzo.zzc.UNSPECIFIED);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<com.google.android.gms.internal.ads.zzue.zzc.zza> c(android.os.Bundle r5) {
        /*
            java.lang.String r0 = "ad_types"
            java.lang.Object r5 = r5.get(r0)
            boolean r0 = r5 instanceof java.util.List
            if (r0 == 0) goto Ld
            java.util.List r5 = (java.util.List) r5
            goto L17
        Ld:
            boolean r0 = r5 instanceof java.lang.String[]
            if (r0 == 0) goto L3d
            java.lang.String[] r5 = (java.lang.String[]) r5
            java.util.List r5 = java.util.Arrays.asList(r5)
        L17:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r5.size()
            r0.<init>(r1)
            java.util.Iterator r5 = r5.iterator()
        L24:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L38
            java.lang.Object r1 = r5.next()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L24
            java.lang.String r1 = (java.lang.String) r1
            r0.add(r1)
            goto L24
        L38:
            java.util.List r5 = java.util.Collections.unmodifiableList(r0)
            goto L41
        L3d:
            java.util.List r5 = java.util.Collections.emptyList()
        L41:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        L4a:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto Lac
            java.lang.Object r1 = r5.next()
            java.lang.String r1 = (java.lang.String) r1
            r2 = -1
            int r3 = r1.hashCode()
            r4 = -1396342996(0xffffffffacc57f2c, float:-5.6131957E-12)
            if (r3 == r4) goto L8e
            r4 = -1052618729(0xffffffffc1425017, float:-12.144553)
            if (r3 == r4) goto L84
            r4 = -239580146(0xfffffffff1b84c0e, float:-1.82519E30)
            if (r3 == r4) goto L7a
            r4 = 604727084(0x240b672c, float:3.022821E-17)
            if (r3 == r4) goto L70
            goto L97
        L70:
            java.lang.String r3 = "interstitial"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L97
            r2 = 1
            goto L97
        L7a:
            java.lang.String r3 = "rewarded"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L97
            r2 = 3
            goto L97
        L84:
            java.lang.String r3 = "native"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L97
            r2 = 2
            goto L97
        L8e:
            java.lang.String r3 = "banner"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L97
            r2 = 0
        L97:
            switch(r2) {
                case 0: goto La6;
                case 1: goto La3;
                case 2: goto La0;
                case 3: goto L9d;
                default: goto L9a;
            }
        L9a:
            com.google.android.gms.internal.ads.zzue$zzc$zza r1 = com.google.android.gms.internal.ads.zzue.zzc.zza.AD_FORMAT_TYPE_UNSPECIFIED
            goto La8
        L9d:
            com.google.android.gms.internal.ads.zzue$zzc$zza r1 = com.google.android.gms.internal.ads.zzue.zzc.zza.REWARD_BASED_VIDEO_AD
            goto La8
        La0:
            com.google.android.gms.internal.ads.zzue$zzc$zza r1 = com.google.android.gms.internal.ads.zzue.zzc.zza.NATIVE_APP_INSTALL
            goto La8
        La3:
            com.google.android.gms.internal.ads.zzue$zzc$zza r1 = com.google.android.gms.internal.ads.zzue.zzc.zza.INTERSTITIAL
            goto La8
        La6:
            com.google.android.gms.internal.ads.zzue$zzc$zza r1 = com.google.android.gms.internal.ads.zzue.zzc.zza.BANNER
        La8:
            r0.add(r1)
            goto L4a
        Lac:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcqe.c(android.os.Bundle):java.util.ArrayList");
    }

    public final byte[] a(boolean z, ArrayList<zzue.zzc.zza> arrayList, zzue.zzm zzmVar, zzue.zzo.zzc zzcVar) {
        return ((zzue.zzo.zza) ((zzekh) zzue.zzo.zza.c().a(arrayList).c(b(zzp.e().b(this.a.getContentResolver()) != 0)).d(zzp.e().a(this.a, this.c)).b(this.d.b()).c(this.d.d()).a(this.d.a()).a(zzcVar).a(zzmVar).e(this.f).a(b(z)).a(zzp.j().a()).b(b(zzp.e().a(this.a.getContentResolver()) != 0)).g())).l();
    }

    public final void a(boolean z) {
        zzdyr.a(this.b.a(), new xg(this, z), zzazj.f);
    }

    static {
        SparseArray<zzue.zzo.zzc> sparseArray = new SparseArray<>();
        g = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzue.zzo.zzc.CONNECTED);
        g.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzue.zzo.zzc.CONNECTING);
        g.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzue.zzo.zzc.CONNECTING);
        g.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzue.zzo.zzc.CONNECTING);
        g.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzue.zzo.zzc.DISCONNECTING);
        g.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzue.zzo.zzc.DISCONNECTED);
        g.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzue.zzo.zzc.DISCONNECTED);
        g.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzue.zzo.zzc.DISCONNECTED);
        g.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzue.zzo.zzc.DISCONNECTED);
        g.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzue.zzo.zzc.DISCONNECTED);
        g.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzue.zzo.zzc.SUSPENDED);
        if (Build.VERSION.SDK_INT >= 17) {
            g.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzue.zzo.zzc.CONNECTING);
        }
        g.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzue.zzo.zzc.CONNECTING);
    }
}
