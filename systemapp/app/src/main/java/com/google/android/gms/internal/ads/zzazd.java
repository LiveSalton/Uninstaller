package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzazd {
    public static <T> T a(Context context, String str, zzazc<IBinder, T> zzazcVar) throws zzazf {
        try {
            return zzazcVar.a(b(context).a(str));
        } catch (Exception e) {
            throw new zzazf(e);
        }
    }

    public static Context a(Context context) throws zzazf {
        return b(context).a();
    }

    private static DynamiteModule b(Context context) throws zzazf {
        try {
            return DynamiteModule.a(context, DynamiteModule.a, ModuleDescriptor.MODULE_ID);
        } catch (Exception e) {
            throw new zzazf(e);
        }
    }
}
