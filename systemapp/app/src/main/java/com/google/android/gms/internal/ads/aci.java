package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class aci implements zzdyb {
    static final zzdyb a = new aci();

    private aci() {
    }

    @Override // com.google.android.gms.internal.ads.zzdyb
    public final zzdyz a(Object obj) {
        return zzdyr.a(new zzdfj((String) obj) { // from class: com.google.android.gms.internal.ads.ach
            private final String a;

            {
                this.a = str;
            }

            @Override // com.google.android.gms.internal.ads.zzdfj
            public final void a(Object obj2) {
                ((Bundle) obj2).putString("ms", this.a);
            }
        });
    }
}
