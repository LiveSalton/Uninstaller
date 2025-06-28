package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzae;
import com.google.android.gms.internal.ads.zzait;
import com.google.android.gms.internal.ads.zzao;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzwq;
import java.io.File;
import java.util.regex.Pattern;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaq extends com.google.android.gms.internal.ads.zzau {
    private final Context a;

    public static zzae a(Context context) {
        zzae zzaeVar = new zzae(new com.google.android.gms.internal.ads.zzav(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzaq(context, new com.google.android.gms.internal.ads.zzbd()));
        zzaeVar.a();
        return zzaeVar;
    }

    private zzaq(Context context, com.google.android.gms.internal.ads.zzar zzarVar) {
        super(zzarVar);
        this.a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzau, com.google.android.gms.internal.ads.zzx
    public final com.google.android.gms.internal.ads.zzy a(com.google.android.gms.internal.ads.zzaa<?> zzaaVar) throws zzao {
        if (zzaaVar.i() && zzaaVar.c() == 0) {
            if (Pattern.matches((String) zzwq.e().a(zzabf.cc), zzaaVar.e())) {
                zzwq.a();
                if (zzayr.c(this.a, 13400000)) {
                    com.google.android.gms.internal.ads.zzy a = new zzait(this.a).a(zzaaVar);
                    if (a != null) {
                        String valueOf = String.valueOf(zzaaVar.e());
                        zzd.a(valueOf.length() != 0 ? "Got gmscore asset response: ".concat(valueOf) : new String("Got gmscore asset response: "));
                        return a;
                    }
                    String valueOf2 = String.valueOf(zzaaVar.e());
                    zzd.a(valueOf2.length() != 0 ? "Failed to get gmscore asset response: ".concat(valueOf2) : new String("Failed to get gmscore asset response: "));
                }
            }
        }
        return super.a(zzaaVar);
    }
}
