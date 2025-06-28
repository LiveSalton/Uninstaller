package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class by implements zzahv<zzalz> {
    private final /* synthetic */ zzef a;
    private final /* synthetic */ zzako b;
    private final /* synthetic */ com.google.android.gms.ads.internal.util.zzbr c;
    private final /* synthetic */ zzalb d;

    by(zzalb zzalbVar, zzef zzefVar, zzako zzakoVar, com.google.android.gms.ads.internal.util.zzbr zzbrVar) {
        this.d = zzalbVar;
        this.a = zzefVar;
        this.b = zzakoVar;
        this.c = zzbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final /* synthetic */ void a(zzalz zzalzVar, Map map) {
        Object obj;
        int i;
        obj = this.d.a;
        synchronized (obj) {
            zzd.d("JS Engine is requesting an update");
            i = this.d.h;
            if (i == 0) {
                zzd.d("Starting reload.");
                this.d.h = 2;
                this.d.a(this.a);
            }
            this.b.b("/requestReload", (zzahv<? super zzalz>) this.c.a());
        }
    }
}
