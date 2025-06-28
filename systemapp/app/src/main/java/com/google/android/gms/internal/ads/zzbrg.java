package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzbrg {
    private final Context a;
    private final zzdnn b;
    private Bundle c;
    private final String d;
    private final zzdni e;

    /* compiled from: source */
    public static class zza {
        private Context a;
        private zzdnn b;
        private Bundle c;
        private String d;
        private zzdni e;

        public final zza a(Context context) {
            this.a = context;
            return this;
        }

        public final zza a(zzdnn zzdnnVar) {
            this.b = zzdnnVar;
            return this;
        }

        public final zza a(Bundle bundle) {
            this.c = bundle;
            return this;
        }

        public final zza a(String str) {
            this.d = str;
            return this;
        }

        public final zzbrg a() {
            return new zzbrg(this);
        }

        public final zza a(zzdni zzdniVar) {
            this.e = zzdniVar;
            return this;
        }
    }

    private zzbrg(zza zzaVar) {
        this.a = zzaVar.a;
        this.b = zzaVar.b;
        this.c = zzaVar.c;
        this.d = zzaVar.d;
        this.e = zzaVar.e;
    }

    final zza a() {
        return new zza().a(this.a).a(this.b).a(this.d).a(this.c);
    }

    final zzdnn b() {
        return this.b;
    }

    final zzdni c() {
        return this.e;
    }

    final Bundle d() {
        return this.c;
    }

    final String e() {
        return this.d;
    }

    final Context a(Context context) {
        return this.d != null ? context : this.a;
    }

    /* synthetic */ zzbrg(zza zzaVar, mq mqVar) {
        this(zzaVar);
    }
}
