package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.SharedPreferencesUtils;

/* compiled from: source */
@TargetApi(17)
/* loaded from: classes.dex */
public class zzv extends zzu {
    public zzv() {
        super();
    }

    @Override // com.google.android.gms.ads.internal.util.zzu
    public final boolean a(Context context, WebSettings webSettings) {
        super.a(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        return true;
    }

    @Override // com.google.android.gms.ads.internal.util.zzu
    public final String b(Context context) {
        String str;
        zzbt a = zzbt.a();
        if (TextUtils.isEmpty(a.a)) {
            if (ClientLibraryUtils.a()) {
                str = (String) zzbu.a(context, new r(a, context));
            } else {
                str = (String) zzbu.a(context, new q(a, GooglePlayServicesUtilLight.a(context), context));
            }
            a.a = str;
        }
        return a.a;
    }

    @Override // com.google.android.gms.ads.internal.util.zzu
    public final void c(Context context) {
        zzbt a = zzbt.a();
        zzd.a("Updating user agent.");
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        if (!defaultUserAgent.equals(a.a)) {
            Context a2 = GooglePlayServicesUtilLight.a(context);
            if (ClientLibraryUtils.a() || a2 == null) {
                SharedPreferences.Editor putString = context.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", WebSettings.getDefaultUserAgent(context));
                if (a2 == null) {
                    putString.apply();
                } else {
                    SharedPreferencesUtils.a(context, putString, "admob_user_agent");
                }
            }
            a.a = defaultUserAgent;
        }
        zzd.a("User agent is updated.");
    }

    @Override // com.google.android.gms.ads.internal.util.zzu
    public final Drawable a(Context context, Bitmap bitmap, boolean z, float f) {
        if (!z || f <= 0.0f || f > 25.0f) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
        try {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
            Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
            RenderScript create = RenderScript.create(context);
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            return new BitmapDrawable(context.getResources(), createBitmap);
        } catch (RuntimeException unused) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzu
    public final int a(ContentResolver contentResolver) {
        return Settings.Global.getInt(contentResolver, "wifi_on", 0);
    }

    @Override // com.google.android.gms.ads.internal.util.zzu
    public final int b(ContentResolver contentResolver) {
        return Settings.Global.getInt(contentResolver, "airplane_mode_on", 0);
    }
}
