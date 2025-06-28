package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbvy extends zzbwk<AppEventListener> implements zzaha {
    public zzbvy(Set<zzbxy<AppEventListener>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzaha
    public final synchronized void a(String str, String str2) {
        a(new zzbwm(str, str2) { // from class: com.google.android.gms.internal.ads.pe
            private final String a;
            private final String b;

            {
                this.a = str;
                this.b = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbwm
            public final void a(Object obj) {
                ((AppEventListener) obj).a(this.a, this.b);
            }
        });
    }
}
