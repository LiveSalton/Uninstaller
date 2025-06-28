package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdal implements zzdfi<zzdai> {
    private final zzdfi<zzdfp> a;
    private final zzdnn b;
    private final Context c;
    private final zzayg d;

    public zzdal(zzdbw<zzdfp> zzdbwVar, zzdnn zzdnnVar, Context context, zzayg zzaygVar) {
        this.a = zzdbwVar;
        this.b = zzdnnVar;
        this.c = context;
        this.d = zzaygVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdai> a() {
        return zzdyr.a(this.a.a(), new zzdvm(this) { // from class: com.google.android.gms.internal.ads.acj
            private final zzdal a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdvm
            public final Object a(Object obj) {
                return this.a.a((zzdfp) obj);
            }
        }, zzazj.f);
    }

    final /* synthetic */ zzdai a(zzdfp zzdfpVar) {
        String str;
        boolean z;
        String str2;
        float f;
        int i;
        int i2;
        int i3;
        zzvn[] zzvnVarArr;
        int i4;
        int i5;
        DisplayMetrics displayMetrics;
        zzvn zzvnVar = this.b.e;
        if (zzvnVar.g == null) {
            str = zzvnVar.a;
            z = zzvnVar.i;
        } else {
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (zzvn zzvnVar2 : zzvnVar.g) {
                if (!zzvnVar2.i && !z2) {
                    str = zzvnVar2.a;
                    z2 = true;
                }
                if (zzvnVar2.i && !z3) {
                    z3 = true;
                    z = true;
                }
                if (z2 && z3) {
                    break;
                }
            }
        }
        Resources resources = this.c.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            str2 = null;
            f = 0.0f;
            i = 0;
            i2 = 0;
        } else {
            float f2 = displayMetrics.density;
            int i6 = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
            str2 = this.d.h().n();
            i = i6;
            f = f2;
        }
        StringBuilder sb = new StringBuilder();
        if (zzvnVar.g != null) {
            zzvn[] zzvnVarArr2 = zzvnVar.g;
            int length = zzvnVarArr2.length;
            int i7 = 0;
            boolean z4 = false;
            while (i7 < length) {
                zzvn zzvnVar3 = zzvnVarArr2[i7];
                if (zzvnVar3.i) {
                    zzvnVarArr = zzvnVarArr2;
                    z4 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    zzvnVarArr = zzvnVarArr2;
                    if (zzvnVar3.e == -1 && f != 0.0f) {
                        i4 = (int) (zzvnVar3.f / f);
                    } else {
                        i4 = zzvnVar3.e;
                    }
                    sb.append(i4);
                    sb.append("x");
                    if (zzvnVar3.b == -2 && f != 0.0f) {
                        i5 = (int) (zzvnVar3.c / f);
                    } else {
                        i5 = zzvnVar3.b;
                    }
                    sb.append(i5);
                }
                i7++;
                zzvnVarArr2 = zzvnVarArr;
            }
            if (z4) {
                if (sb.length() != 0) {
                    i3 = 0;
                    sb.insert(0, "|");
                } else {
                    i3 = 0;
                }
                sb.insert(i3, "320x50");
            }
        }
        return new zzdai(zzvnVar, str, z, sb.toString(), f, i, i2, str2, this.b.o);
    }
}
