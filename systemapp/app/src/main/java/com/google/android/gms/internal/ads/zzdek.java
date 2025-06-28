package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdek implements zzdfi<zzdel> {
    private final zzdzc a;
    private final ScheduledExecutorService b;
    private final zzcwz c;
    private final Context d;
    private final zzdnn e;
    private final zzcwx f;
    private String g;

    public zzdek(zzdzc zzdzcVar, ScheduledExecutorService scheduledExecutorService, String str, zzcwz zzcwzVar, Context context, zzdnn zzdnnVar, zzcwx zzcwxVar) {
        this.a = zzdzcVar;
        this.b = scheduledExecutorService;
        this.g = str;
        this.c = zzcwzVar;
        this.d = context;
        this.e = zzdnnVar;
        this.f = zzcwxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdel> a() {
        if (((Boolean) zzwq.e().a(zzabf.aL)).booleanValue()) {
            return zzdyr.a(new zzdxz(this) { // from class: com.google.android.gms.internal.ads.adx
                private final zzdek a;

                {
                    this.a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdxz
                public final zzdyz a() {
                    return this.a.b();
                }
            }, this.a);
        }
        return zzdyr.a((Object) null);
    }

    final /* synthetic */ zzdyz a(String str, List list, Bundle bundle) throws Exception {
        zzazq zzazqVar = new zzazq();
        this.f.a(str);
        zzapo b = this.f.b(str);
        if (b == null) {
            throw new NullPointerException();
        }
        b.a(ObjectWrapper.a(this.d), this.g, bundle, (Bundle) list.get(0), this.e.e, new zzcxf(str, b, zzazqVar));
        return zzazqVar;
    }

    final /* synthetic */ zzdyz b() {
        Map<String, List<Bundle>> a = this.c.a(this.g, this.e.f);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<Bundle>> entry : a.entrySet()) {
            String key = entry.getKey();
            arrayList.add(zzdyi.c(zzdyr.a(new zzdxz(this, key, entry.getValue(), this.e.d.m != null ? this.e.d.m.getBundle(key) : null) { // from class: com.google.android.gms.internal.ads.adw
                private final zzdek a;
                private final String b;
                private final List c;
                private final Bundle d;

                {
                    this.a = this;
                    this.b = key;
                    this.c = value;
                    this.d = bundle;
                }

                @Override // com.google.android.gms.internal.ads.zzdxz
                public final zzdyz a() {
                    return this.a.a(this.b, this.c, this.d);
                }
            }, this.a)).a(((Long) zzwq.e().a(zzabf.aK)).longValue(), TimeUnit.MILLISECONDS, this.b).a(Throwable.class, new zzdvm(key) { // from class: com.google.android.gms.internal.ads.adz
                private final String a;

                {
                    this.a = key;
                }

                @Override // com.google.android.gms.internal.ads.zzdvm
                public final Object a(Object obj) {
                    String valueOf = String.valueOf(this.a);
                    zzd.c(valueOf.length() != 0 ? "Error calling adapter: ".concat(valueOf) : new String("Error calling adapter: "));
                    return null;
                }
            }, this.a));
        }
        return zzdyr.c(arrayList).a(new Callable(arrayList) { // from class: com.google.android.gms.internal.ads.ady
            private final List a;

            {
                this.a = arrayList;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List<zzdyz> list = this.a;
                JSONArray jSONArray = new JSONArray();
                for (zzdyz zzdyzVar : list) {
                    if (((JSONObject) zzdyzVar.get()) != null) {
                        jSONArray.put(zzdyzVar.get());
                    }
                }
                if (jSONArray.length() == 0) {
                    return null;
                }
                return new zzdel(jSONArray.toString());
            }
        }, this.a);
    }
}
