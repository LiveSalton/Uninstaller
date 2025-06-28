package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcuo {
    private final zzdoa a;
    private final zzcil b;
    private final zzckq c;

    public zzcuo(zzdoa zzdoaVar, zzcil zzcilVar, zzckq zzckqVar) {
        this.a = zzdoaVar;
        this.b = zzcilVar;
        this.c = zzckqVar;
    }

    public final void a(zzdmz zzdmzVar, zzdmu zzdmuVar, int i, @Nullable zzcrd zzcrdVar, long j) {
        zzcim zzcimVar;
        zzckp a = this.c.a().a(zzdmzVar).a(zzdmuVar).a("action", "adapter_status").a("adapter_l", String.valueOf(j));
        a.a("sc", Integer.toString(i));
        if (zzcrdVar != null) {
            a.a("arec", Integer.toString(zzcrdVar.b().a));
            String a2 = this.a.a(zzcrdVar.getMessage());
            if (a2 != null) {
                a.a("areec", a2);
            }
        }
        zzcil zzcilVar = this.b;
        Iterator<String> it = zzdmuVar.s.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzcimVar = null;
                break;
            } else {
                zzcimVar = zzcilVar.a(it.next());
                if (zzcimVar != null) {
                    break;
                }
            }
        }
        if (zzcimVar != null) {
            a.a("ancn", zzcimVar.a);
            if (zzcimVar.b != null) {
                a.a("adapter_v", zzcimVar.b.toString());
            }
            if (zzcimVar.c != null) {
                a.a("adapter_sv", zzcimVar.c.toString());
            }
        }
        a.a();
    }
}
