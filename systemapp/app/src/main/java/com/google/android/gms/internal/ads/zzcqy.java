package com.google.android.gms.internal.ads;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import androidx.core.app.h;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcqy extends zzaqz {
    private final Context a;
    private final zzckq b;
    private final zzaze c;
    private final zzcqo d;

    public zzcqy(Context context, zzcqo zzcqoVar, zzaze zzazeVar, zzckq zzckqVar) {
        this.a = context;
        this.b = zzckqVar;
        this.c = zzazeVar;
        this.d = zzcqoVar;
    }

    public static void a(Context context, zzckq zzckqVar, zzcqo zzcqoVar, String str, String str2) {
        a(context, zzckqVar, zzcqoVar, str, str2, new HashMap());
    }

    public static void a(Context context, zzckq zzckqVar, zzcqo zzcqoVar, String str, String str2, Map<String, String> map) {
        zzckp a = zzckqVar.a();
        a.a("gqi", str);
        a.a("action", str2);
        zzp.c();
        a.a("device_connectivity", com.google.android.gms.ads.internal.util.zzm.p(context) ? "online" : "offline");
        a.a("event_timestamp", String.valueOf(zzp.j().a()));
        for (Map.Entry<String, String> entry : map.entrySet()) {
            a.a(entry.getKey(), entry.getValue());
        }
        zzcqoVar.a(new zzcqv(zzp.j().a(), str, a.b(), zzcql.b));
    }

    private final void a(String str, String str2, Map<String, String> map) {
        a(this.a, this.b, this.d, str, str2, map);
    }

    @Override // com.google.android.gms.internal.ads.zzaqw
    public final void a(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
            String stringExtra2 = intent.getStringExtra("gws_query_id");
            String stringExtra3 = intent.getStringExtra("uri");
            zzp.c();
            boolean p = com.google.android.gms.ads.internal.util.zzm.p(this.a);
            int i = xs.b;
            HashMap hashMap = new HashMap();
            if (stringExtra.equals("offline_notification_clicked")) {
                hashMap.put("offline_notification_action", "offline_notification_clicked");
                if (p) {
                    i = xs.a;
                }
                Context context = this.a;
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                if (launchIntentForPackage == null) {
                    launchIntentForPackage = new Intent("android.intent.action.VIEW");
                    launchIntentForPackage.setData(Uri.parse(stringExtra3));
                }
                launchIntentForPackage.addFlags(268435456);
                context.startActivity(launchIntentForPackage);
            } else {
                hashMap.put("offline_notification_action", "offline_notification_dismissed");
            }
            a(stringExtra2, "offline_notification_action", hashMap);
            try {
                SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
                if (i == xs.a) {
                    this.d.a(writableDatabase, this.c, stringExtra2);
                } else {
                    zzcqo.a(writableDatabase, stringExtra2);
                }
            } catch (SQLiteException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(51 + String.valueOf(valueOf).length());
                sb.append("Failed to get writable offline buffering database: ");
                sb.append(valueOf);
                zzd.c(sb.toString());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqw
    public final void a(IObjectWrapper iObjectWrapper, String str, String str2) {
        Context context = (Context) ObjectWrapper.a(iObjectWrapper);
        int i = PlatformVersion.h() ? 1140850688 : 1073741824;
        Intent intent = new Intent();
        intent.setClass(context, AdService.class);
        intent.setAction("offline_notification_clicked");
        intent.putExtra("offline_notification_action", "offline_notification_clicked");
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str);
        PendingIntent a = zzduy.a(context, 0, intent, i);
        Intent intent2 = new Intent();
        intent2.setClass(context, AdService.class);
        intent2.setAction("offline_notification_dismissed");
        intent2.putExtra("offline_notification_action", "offline_notification_dismissed");
        intent2.putExtra("gws_query_id", str2);
        PendingIntent a2 = zzduy.a(context, 0, intent2, i);
        Resources d = zzp.g().d();
        ((NotificationManager) context.getSystemService("notification")).notify(str2, 54321, new h.c(context, "offline_notification_channel").a(d == null ? "View the ad you saved when you were offline" : d.getString(R.string.offline_notification_title)).b(d == null ? "Tap to open ad" : d.getString(R.string.offline_notification_text)).a(true).b(a2).a(a).a(context.getApplicationInfo().icon).b());
        a(str2, "offline_notification_impression", new HashMap());
    }

    @Override // com.google.android.gms.internal.ads.zzaqw
    public final void a() {
        this.d.a(this.c);
    }
}
