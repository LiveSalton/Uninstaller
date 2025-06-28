package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzabb implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context g;
    private final Object a = new Object();
    private final ConditionVariable b = new ConditionVariable();
    private volatile boolean c = false;

    @VisibleForTesting
    private volatile boolean d = false;
    private SharedPreferences e = null;
    private Bundle f = new Bundle();
    private JSONObject h = new JSONObject();

    public final void a(Context context) {
        if (this.c) {
            return;
        }
        synchronized (this.a) {
            if (this.c) {
                return;
            }
            if (!this.d) {
                this.d = true;
            }
            this.g = context.getApplicationContext() == null ? context : context.getApplicationContext();
            try {
                this.f = Wrappers.a(this.g).a(this.g.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            }
            try {
                Context a = GooglePlayServicesUtilLight.a(context);
                if (a == null && context != null && (a = context.getApplicationContext()) == null) {
                    a = context;
                }
                if (a == null) {
                    return;
                }
                zzwq.c();
                this.e = a.getSharedPreferences("google_ads_flags", 0);
                if (this.e != null) {
                    this.e.registerOnSharedPreferenceChangeListener(this);
                }
                zzado.a(new l(this));
                b();
                this.c = true;
            } finally {
                this.d = false;
                this.b.open();
            }
        }
    }

    public final <T> T a(zzaaq<T> zzaaqVar) {
        if (!this.b.block(5000L)) {
            synchronized (this.a) {
                if (!this.d) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.c || this.e == null) {
            synchronized (this.a) {
                if (this.c && this.e != null) {
                }
                return zzaaqVar.b();
            }
        }
        if (zzaaqVar.c() == 2) {
            if (this.f == null) {
                return zzaaqVar.b();
            }
            return zzaaqVar.a(this.f);
        }
        if (zzaaqVar.c() == 1 && this.h.has(zzaaqVar.a())) {
            return zzaaqVar.a(this.h);
        }
        return (T) com.google.android.gms.ads.internal.util.zzbu.a(new zzdwf(this, zzaaqVar) { // from class: com.google.android.gms.internal.ads.k
            private final zzabb a;
            private final zzaaq b;

            {
                this.a = this;
                this.b = zzaaqVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdwf
            public final Object a() {
                return this.a.b(this.b);
            }
        });
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            b();
        }
    }

    private final void b() {
        if (this.e == null) {
            return;
        }
        try {
            this.h = new JSONObject((String) com.google.android.gms.ads.internal.util.zzbu.a(new zzdwf(this) { // from class: com.google.android.gms.internal.ads.m
                private final zzabb a;

                {
                    this.a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdwf
                public final Object a() {
                    return this.a.a();
                }
            }));
        } catch (JSONException unused) {
        }
    }

    final /* synthetic */ String a() {
        return this.e.getString("flag_configuration", "{}");
    }

    final /* synthetic */ Object b(zzaaq zzaaqVar) {
        return zzaaqVar.a(this.e);
    }
}
