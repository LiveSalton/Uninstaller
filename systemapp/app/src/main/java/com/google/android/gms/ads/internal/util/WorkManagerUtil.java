package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.work.b;
import androidx.work.c;
import androidx.work.e;
import androidx.work.j;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.ads.internal.offline.buffering.OfflineNotificationPoster;
import com.google.android.gms.ads.internal.offline.buffering.OfflinePingSender;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaza;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public class WorkManagerUtil extends zzbi {
    @UsedByReflection("This class must be instantiated reflectively so that the default class loader can be used.")
    public WorkManagerUtil() {
    }

    private static void a(Context context) {
        try {
            androidx.work.o.a(context.getApplicationContext(), new b.a().a());
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzbf
    public final boolean zzd(IObjectWrapper iObjectWrapper, String str, String str2) {
        Context context = (Context) ObjectWrapper.a(iObjectWrapper);
        a(context);
        androidx.work.c a = new c.a().a(androidx.work.i.CONNECTED).a();
        try {
            androidx.work.o.a(context).a(new j.a(OfflineNotificationPoster.class).a(a).a(new e.a().a("uri", str).a("gws_query_id", str2).a()).a("offline_notification_work").e());
            return true;
        } catch (IllegalStateException e) {
            zzaza.d("Failed to instantiate WorkManager.", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzbf
    public final void zzap(IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.a(iObjectWrapper);
        a(context);
        try {
            androidx.work.o a = androidx.work.o.a(context);
            a.a("offline_ping_sender_work");
            a.a(new j.a(OfflinePingSender.class).a(new c.a().a(androidx.work.i.CONNECTED).a()).a("offline_ping_sender_work").e());
        } catch (IllegalStateException e) {
            zzaza.d("Failed to instantiate WorkManager.", e);
        }
    }
}
