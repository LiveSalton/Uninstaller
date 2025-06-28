package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzbgl {
    private final zzazh a;
    private final Context b;
    private final WeakReference<Context> c;

    /* compiled from: source */
    public static class zza {
        private zzazh a;
        private Context b;
        private WeakReference<Context> c;

        public final zza a(zzazh zzazhVar) {
            this.a = zzazhVar;
            return this;
        }

        public final zza a(Context context) {
            this.c = new WeakReference<>(context);
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.b = context;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    zzbgl(zza zzaVar) {
        this.a = zzaVar.a;
        this.b = zzaVar.b;
        this.c = zzaVar.c;
    }

    final Context a() {
        return this.b;
    }

    final WeakReference<Context> b() {
        return this.c;
    }

    final zzazh c() {
        return this.a;
    }

    final String d() {
        return zzp.c().b(this.b, this.a.a);
    }

    public final zzef e() {
        return new zzef(new zzf(this.b, this.a));
    }

    /* synthetic */ zzbgl(zza zzaVar, jn jnVar) {
        this(zzaVar);
    }
}
