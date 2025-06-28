package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaqj extends zzaqu {
    private final Map<String, String> a;
    private final Context b;
    private String c;
    private long d;
    private long e;
    private String f;
    private String g;

    public zzaqj(zzbdv zzbdvVar, Map<String, String> map) {
        super(zzbdvVar, "createCalendarEvent");
        this.a = map;
        this.b = zzbdvVar.g();
        this.c = d("description");
        this.f = d("summary");
        this.d = e("start_ticks");
        this.e = e("end_ticks");
        this.g = d("location");
    }

    private final String d(String str) {
        return TextUtils.isEmpty(this.a.get(str)) ? "" : this.a.get(str);
    }

    private final long e(String str) {
        String str2 = this.a.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public final void a() {
        if (this.b == null) {
            a("Activity context is not available.");
            return;
        }
        zzp.c();
        if (!com.google.android.gms.ads.internal.util.zzm.e(this.b).d()) {
            a("This feature is not available on the device.");
            return;
        }
        zzp.c();
        AlertDialog.Builder d = com.google.android.gms.ads.internal.util.zzm.d(this.b);
        Resources d2 = zzp.g().d();
        d.setTitle(d2 != null ? d2.getString(R.string.s5) : "Create calendar event");
        d.setMessage(d2 != null ? d2.getString(R.string.s6) : "Allow Ad to create a calendar event?");
        d.setPositiveButton(d2 != null ? d2.getString(R.string.s3) : "Accept", new dl(this));
        d.setNegativeButton(d2 != null ? d2.getString(R.string.s4) : "Decline", new dm(this));
        d.create().show();
    }

    @TargetApi(14)
    final Intent b() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.c);
        data.putExtra("eventLocation", this.g);
        data.putExtra("description", this.f);
        if (this.d > -1) {
            data.putExtra("beginTime", this.d);
        }
        if (this.e > -1) {
            data.putExtra("endTime", this.e);
        }
        data.setFlags(268435456);
        return data;
    }
}
