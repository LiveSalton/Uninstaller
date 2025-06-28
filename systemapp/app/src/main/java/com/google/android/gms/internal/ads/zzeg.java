package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzby;
import com.google.android.gms.internal.ads.zzcf;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeg extends zzdx {
    public static zzeg a(String str, Context context, boolean z) {
        return b(str, context, false, zzcw.a);
    }

    public static zzeg b(String str, Context context, boolean z, int i) {
        a(context, z);
        a(str, context, z, i);
        return new zzeg(context, str, z, i);
    }

    private zzeg(Context context, String str, boolean z, int i) {
        super(context, str, z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzdx
    protected final List<Callable<Void>> a(zzfa zzfaVar, Context context, zzcf.zza.C0060zza c0060zza, zzby.zza zzaVar) {
        if (zzfaVar.c() == null || !this.a) {
            return super.a(zzfaVar, context, c0060zza, zzaVar);
        }
        int o = zzfaVar.o();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.a(zzfaVar, context, c0060zza, zzaVar));
        arrayList.add(new zzfu(zzfaVar, "nzsGgLmkYoH07JBds4475Hi1VD4Q7uBNBbOuNVMIAgaPK31s5yXBWpEE3pcrsbq6", "YtmG0d5ZvAZhPKacOdj22mtx44uyqECBIblkm9VYJ9w=", c0060zza, o, 24));
        return arrayList;
    }
}
