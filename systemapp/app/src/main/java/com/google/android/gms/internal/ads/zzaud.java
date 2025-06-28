package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaud extends zzaue {
    private final String a;
    private final int b;

    public zzaud(String str, int i) {
        this.a = str;
        this.b = i;
    }

    @Override // com.google.android.gms.internal.ads.zzauf
    public final String a() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzauf
    public final int b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzaud)) {
            return false;
        }
        zzaud zzaudVar = (zzaud) obj;
        return Objects.a(this.a, zzaudVar.a) && Objects.a(Integer.valueOf(this.b), Integer.valueOf(zzaudVar.b));
    }
}
