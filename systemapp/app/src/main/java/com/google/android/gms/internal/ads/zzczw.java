package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzp;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzczw implements zzdfj<Bundle> {
    private final Context a;
    private final zzvn b;
    private final List<Parcelable> c;

    public zzczw(Context context, zzvn zzvnVar, List<Parcelable> list) {
        this.a = context;
        this.b = zzvnVar;
        this.c = list;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (zzadd.a.a().booleanValue()) {
            Bundle bundle3 = new Bundle();
            zzp.c();
            bundle3.putString("activity", com.google.android.gms.ads.internal.util.zzm.f(this.a));
            Bundle bundle4 = new Bundle();
            bundle4.putInt("width", this.b.e);
            bundle4.putInt("height", this.b.b);
            bundle3.putBundle("size", bundle4);
            if (this.c.size() > 0) {
                bundle3.putParcelableArray("parents", (Parcelable[]) this.c.toArray(new Parcelable[this.c.size()]));
            }
            bundle2.putBundle("view_hierarchy", bundle3);
        }
    }
}
