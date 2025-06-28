package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzby;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.ExecutionException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzfn extends zzgl {
    private static final zzgo<zzcy> d = new zzgo<>();
    private final Context e;
    private zzby.zza f;

    public zzfn(zzfa zzfaVar, String str, String str2, zzcf.zza.C0060zza c0060zza, int i, int i2, Context context, zzby.zza zzaVar) {
        super(zzfaVar, str, str2, c0060zza, i, 27);
        this.f = null;
        this.e = context;
        this.f = zzaVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039 A[Catch: all -> 0x0114, TryCatch #0 {, blocks: (B:4:0x000d, B:6:0x0017, B:8:0x001f, B:10:0x0029, B:15:0x0039, B:17:0x0045, B:18:0x0082, B:21:0x0089, B:23:0x00ac, B:25:0x00db, B:26:0x00b6, B:27:0x00be, B:29:0x00c2, B:31:0x00cc, B:32:0x00cf, B:34:0x0048, B:37:0x0056, B:39:0x005c, B:42:0x006b, B:44:0x0075, B:46:0x007d, B:47:0x0080, B:49:0x00de, B:50:0x00e4), top: B:3:0x000d }] */
    @Override // com.google.android.gms.internal.ads.zzgl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void a() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfn.a():void");
    }

    private static String a(zzby.zza zzaVar) {
        if (zzaVar == null || !zzaVar.c() || zzff.b(zzaVar.d().a())) {
            return null;
        }
        return zzaVar.d().a();
    }

    private final String c() {
        try {
            if (this.a.m() != null) {
                this.a.m().get();
            }
            zzcf.zza l = this.a.l();
            if (l == null || !l.a()) {
                return null;
            }
            return l.b();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }
}
