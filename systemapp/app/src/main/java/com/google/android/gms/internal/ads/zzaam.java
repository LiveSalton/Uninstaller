package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaam {
    private final Context a;

    public zzaam(Context context) {
        Preconditions.a(context, "Context can not be null");
        this.a = context;
    }

    public final boolean a() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return a(intent);
    }

    public final boolean b() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return a(intent);
    }

    public final boolean c() {
        return ((Boolean) com.google.android.gms.ads.internal.util.zzbu.a(this.a, new d())).booleanValue() && Wrappers.a(this.a).a("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(14)
    public final boolean d() {
        return a(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }

    private final boolean a(Intent intent) {
        Preconditions.a(intent, "Intent can not be null");
        return !this.a.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }
}
