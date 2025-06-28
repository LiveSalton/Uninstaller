package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzckv extends zzcky {
    private final Context c;
    private final String d;
    private final String e;

    public zzckv(Executor executor, zzaze zzazeVar, Context context, zzazh zzazhVar) {
        super(executor, zzazeVar);
        this.c = context;
        this.d = context.getPackageName();
        this.e = zzazhVar.a;
        b();
    }

    public final Map<String, String> a() {
        return new HashMap(this.a);
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    protected final void b() {
        this.a.put("s", "gmob_sdk");
        this.a.put("v", "3");
        this.a.put("os", Build.VERSION.RELEASE);
        this.a.put("api_v", Build.VERSION.SDK);
        Map<String, String> map = this.a;
        zzp.c();
        map.put("device", com.google.android.gms.ads.internal.util.zzm.b());
        this.a.put("app", this.d);
        Map<String, String> map2 = this.a;
        zzp.c();
        map2.put("is_lite_sdk", com.google.android.gms.ads.internal.util.zzm.j(this.c) ? "1" : "0");
        this.a.put("e", TextUtils.join(",", zzabf.b()));
        this.a.put("sdkVersion", this.e);
    }
}
