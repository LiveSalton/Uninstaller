package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import android.view.Window;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzddb implements zzdfi<zzdcy> {
    private final zzdzc a;
    private final ViewGroup b;
    private final Context c;
    private final Set<String> d;

    public zzddb(zzdzc zzdzcVar, ViewGroup viewGroup, Context context, Set<String> set) {
        this.a = zzdzcVar;
        this.d = set;
        this.b = viewGroup;
        this.c = context;
    }

    private static Boolean a(Activity activity) {
        Window window = activity.getWindow();
        boolean z = true;
        if (window != null && (window.getAttributes().flags & 16777216) != 0) {
            return true;
        }
        try {
            if ((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & 512) == 0) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdcy> a() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.adk
            private final zzddb a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.b();
            }
        });
    }

    final /* synthetic */ zzdcy b() throws Exception {
        if (((Boolean) zzwq.e().a(zzabf.de)).booleanValue() && this.b != null && this.d.contains("banner")) {
            return new zzdcy(Boolean.valueOf(this.b.isHardwareAccelerated()));
        }
        if (((Boolean) zzwq.e().a(zzabf.df)).booleanValue() && this.d.contains("native") && (this.c instanceof Activity)) {
            return new zzdcy(a((Activity) this.c));
        }
        return new zzdcy(null);
    }
}
