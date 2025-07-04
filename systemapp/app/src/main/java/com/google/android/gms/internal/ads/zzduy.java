package com.google.android.gms.internal.ads;

import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import javax.annotation.Nullable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzduy {
    private static final ClipData a = ClipData.newIntent("", new Intent());

    private static boolean a(int i, int i2) {
        return (i & i2) == i2;
    }

    @Nullable
    public static PendingIntent a(Context context, int i, Intent intent, int i2) {
        boolean z = true;
        zzdvv.a((i2 & 95) == 0, "Cannot set any dangerous parts of intent to be mutable.");
        zzdvv.a(intent.getComponent() != null, "Must set component on Intent.");
        if (a(0, 1)) {
            zzdvv.a(!a(i2, 67108864), "Cannot set mutability flags if PendingIntent.FLAG_IMMUTABLE is set.");
        } else {
            if (Build.VERSION.SDK_INT >= 23 && !a(i2, 67108864)) {
                z = false;
            }
            zzdvv.a(z, "Must set PendingIntent.FLAG_IMMUTABLE for SDK >= 23 if no parts of intent are mutable.");
        }
        Intent intent2 = new Intent(intent);
        if (Build.VERSION.SDK_INT < 23 || !a(i2, 67108864)) {
            if (intent2.getPackage() == null) {
                intent2.setPackage(intent2.getComponent().getPackageName());
            }
            if (!a(0, 3) && intent2.getAction() == null) {
                intent2.setAction("");
            }
            if (!a(0, 9) && intent2.getCategories() == null) {
                intent2.addCategory("");
            }
            if (!a(0, 5) && intent2.getData() == null) {
                intent2.setDataAndType(Uri.EMPTY, "*/*");
            }
            if (!a(0, 17) && intent2.getClipData() == null) {
                intent2.setClipData(a);
            }
        }
        return PendingIntent.getService(context, 0, intent2, i2);
    }
}
