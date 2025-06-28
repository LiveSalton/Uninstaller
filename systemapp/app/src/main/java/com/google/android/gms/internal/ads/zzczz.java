package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzczz implements zzdfi<zzczw> {
    private final zzdzc a;
    private final Context b;
    private final zzdnn c;
    private final View d;

    public zzczz(zzdzc zzdzcVar, Context context, zzdnn zzdnnVar, ViewGroup viewGroup) {
        this.a = zzdzcVar;
        this.b = context;
        this.c = zzdnnVar;
        this.d = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzczw> a() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.acd
            private final zzczz a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.b();
            }
        });
    }

    final /* synthetic */ zzczw b() throws Exception {
        Context context = this.b;
        zzvn zzvnVar = this.c.e;
        ArrayList arrayList = new ArrayList();
        View view = this.d;
        while (view != null) {
            Object parent = view.getParent();
            if (parent == null) {
                break;
            }
            int indexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", indexOfChild);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzczw(context, zzvnVar, arrayList);
    }
}
