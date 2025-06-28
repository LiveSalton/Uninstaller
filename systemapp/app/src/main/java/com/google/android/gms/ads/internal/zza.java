package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.internal.ads.zzasw;
import com.google.android.gms.internal.ads.zzawq;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zza {
    private final Context a;
    private boolean b;
    private zzawq c;
    private zzasw d;

    public zza(Context context, zzawq zzawqVar, zzasw zzaswVar) {
        this.a = context;
        this.c = zzawqVar;
        this.d = null;
        if (this.d == null) {
            this.d = new zzasw();
        }
    }

    private final boolean c() {
        return (this.c != null && this.c.a().f) || this.d.a;
    }

    public final void a() {
        this.b = true;
    }

    public final boolean b() {
        return !c() || this.b;
    }

    public final void a(String str) {
        if (c()) {
            if (str == null) {
                str = "";
            }
            if (this.c != null) {
                this.c.a(str, null, 3);
                return;
            }
            if (!this.d.a || this.d.b == null) {
                return;
            }
            for (String str2 : this.d.b) {
                if (!TextUtils.isEmpty(str2)) {
                    String replace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                    zzp.c();
                    zzm.a(this.a, "", replace);
                }
            }
        }
    }
}
