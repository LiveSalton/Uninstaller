package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdrx {
    private final zzcum a;
    private final String b;
    private final String c;
    private final String d;
    private final Context e;
    private final zzdni f;
    private final Clock g;
    private final zzef h;

    public zzdrx(zzcum zzcumVar, zzazh zzazhVar, String str, String str2, Context context, zzdni zzdniVar, Clock clock, zzef zzefVar) {
        this.a = zzcumVar;
        this.b = zzazhVar.a;
        this.c = str;
        this.d = str2;
        this.e = context;
        this.f = zzdniVar;
        this.g = clock;
        this.h = zzefVar;
    }

    public final List<String> a(zzdnj zzdnjVar, zzdmu zzdmuVar, List<String> list) {
        return a(zzdnjVar, zzdmuVar, false, "", "", list);
    }

    public static List<String> a(int i, int i2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            StringBuilder sb = new StringBuilder(23);
            sb.append(2);
            sb.append(".");
            sb.append(i2);
            arrayList.add(a(str, "@gw_mpe@", sb.toString()));
        }
        return arrayList;
    }

    public final List<String> a(zzdnj zzdnjVar, zzdmu zzdmuVar, boolean z, String str, String str2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String str3 = z ? "1" : "0";
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String a = a(a(a(it.next(), "@gw_adlocid@", zzdnjVar.a.a.f), "@gw_adnetrefresh@", str3), "@gw_sdkver@", this.b);
            if (zzdmuVar != null) {
                a = zzaxm.a(a(a(a(a, "@gw_qdata@", zzdmuVar.x), "@gw_adnetid@", zzdmuVar.w), "@gw_allocid@", zzdmuVar.v), this.e, zzdmuVar.Q);
            }
            String a2 = a(a(a(a, "@gw_adnetstatus@", this.a.a()), "@gw_seqnum@", this.c), "@gw_sessid@", this.d);
            boolean z2 = ((Boolean) zzwq.e().a(zzabf.bv)).booleanValue() && !TextUtils.isEmpty(str);
            boolean isEmpty = true ^ TextUtils.isEmpty(str2);
            if (z2 || isEmpty) {
                if (this.h.a(Uri.parse(a2))) {
                    Uri.Builder buildUpon = Uri.parse(a2).buildUpon();
                    if (z2) {
                        buildUpon = buildUpon.appendQueryParameter("ms", str);
                    }
                    if (isEmpty) {
                        buildUpon = buildUpon.appendQueryParameter("attok", str2);
                    }
                    a2 = buildUpon.build().toString();
                }
            }
            arrayList.add(a2);
        }
        return arrayList;
    }

    public final List<String> a(zzdmu zzdmuVar, List<String> list, zzauf zzaufVar) {
        ArrayList arrayList = new ArrayList();
        long a = this.g.a();
        try {
            String a2 = zzaufVar.a();
            String num = Integer.toString(zzaufVar.b());
            String a3 = this.f == null ? "" : a(this.f.a);
            String a4 = this.f == null ? "" : a(this.f.b);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(zzaxm.a(a(a(a(a(a(a(it.next(), "@gw_rwd_userid@", Uri.encode(a3)), "@gw_rwd_custom_data@", Uri.encode(a4)), "@gw_tmstmp@", Long.toString(a)), "@gw_rwd_itm@", Uri.encode(a2)), "@gw_rwd_amt@", num), "@gw_sdkver@", this.b), this.e, zzdmuVar.Q));
            }
            return arrayList;
        } catch (RemoteException e) {
            zzd.c("Unable to determine award type and amount.", e);
            return arrayList;
        }
    }

    private static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    private static String a(String str) {
        return (TextUtils.isEmpty(str) || !zzayu.c()) ? str : "fakeForAdDebugLog";
    }
}
