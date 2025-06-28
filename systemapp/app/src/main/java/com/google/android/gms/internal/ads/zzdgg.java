package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdgg implements zzdfi<zzdgh> {
    private final zzato a;
    private final Context b;
    private final String c;
    private final zzdzc d;

    public zzdgg(zzato zzatoVar, Context context, String str, zzdzc zzdzcVar) {
        this.a = zzatoVar;
        this.b = context;
        this.c = str;
        this.d = zzdzcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdgh> a() {
        return this.d.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.aes
            private final zzdgg a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.b();
            }
        });
    }

    final /* synthetic */ zzdgh b() throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (this.a != null) {
            this.a.a(this.b, this.c, jSONObject);
        }
        return new zzdgh(jSONObject);
    }
}
