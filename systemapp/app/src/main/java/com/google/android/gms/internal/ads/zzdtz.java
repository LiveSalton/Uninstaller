package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdtz {
    private final File a;

    @VisibleForTesting
    private final File b;
    private final SharedPreferences c;
    private final zzgn d;

    public zzdtz(Context context, zzgn zzgnVar) {
        this.c = context.getSharedPreferences("pcvmspf", 0);
        this.a = zzduc.a(context.getDir("pccache", 0), false);
        this.b = zzduc.a(context.getDir("tmppccache", 0), true);
        this.d = zzgnVar;
    }

    public final zzdua a(int i) {
        zzgt b = b(i);
        if (b == null) {
            return null;
        }
        String a = b.a();
        File a2 = zzduc.a(a, "pcam.jar", a());
        if (!a2.exists()) {
            a2 = zzduc.a(a, "pcam", a());
        }
        return new zzdua(b, a2, zzduc.a(a, "pcbc", a()), zzduc.a(a, "pcopt", a()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x014a, code lost:
    
        if (r0.commit() != false) goto L110;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(com.google.android.gms.internal.ads.zzgp r8, com.google.android.gms.internal.ads.zzduf r9) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdtz.a(com.google.android.gms.internal.ads.zzgp, com.google.android.gms.internal.ads.zzduf):boolean");
    }

    private final File a() {
        File file = new File(this.a, Integer.toString(this.d.a()));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    @VisibleForTesting
    private static String a(zzgt zzgtVar) {
        return Hex.a(zzgtVar.k().d());
    }

    private final String b() {
        int a = this.d.a();
        StringBuilder sb = new StringBuilder(17);
        sb.append("FBAMTD");
        sb.append(a);
        return sb.toString();
    }

    private final String c() {
        int a = this.d.a();
        StringBuilder sb = new StringBuilder(17);
        sb.append("LATMTD");
        sb.append(a);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006d A[RETURN] */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.android.gms.internal.ads.zzgt b(int r6) {
        /*
            r5 = this;
            int r0 = com.google.android.gms.internal.ads.zzduh.a
            r1 = 0
            if (r6 != r0) goto L10
            android.content.SharedPreferences r6 = r5.c
            java.lang.String r0 = r5.c()
            java.lang.String r6 = r6.getString(r0, r1)
            goto L20
        L10:
            int r0 = com.google.android.gms.internal.ads.zzduh.b
            if (r6 != r0) goto L1f
            android.content.SharedPreferences r6 = r5.c
            java.lang.String r0 = r5.b()
            java.lang.String r6 = r6.getString(r0, r1)
            goto L20
        L1f:
            r6 = r1
        L20:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L27
            return r1
        L27:
            byte[] r6 = com.google.android.gms.common.util.Hex.a(r6)     // Catch: com.google.android.gms.internal.ads.zzeks -> L6d
            com.google.android.gms.internal.ads.zzeiu r6 = com.google.android.gms.internal.ads.zzeiu.a(r6)     // Catch: com.google.android.gms.internal.ads.zzeks -> L6d
            com.google.android.gms.internal.ads.zzgt r6 = com.google.android.gms.internal.ads.zzgt.a(r6)     // Catch: com.google.android.gms.internal.ads.zzeks -> L6d
            java.lang.String r0 = r6.a()     // Catch: com.google.android.gms.internal.ads.zzeks -> L6d
            java.lang.String r2 = "pcam.jar"
            java.io.File r3 = r5.a()     // Catch: com.google.android.gms.internal.ads.zzeks -> L6d
            java.io.File r2 = com.google.android.gms.internal.ads.zzduc.a(r0, r2, r3)     // Catch: com.google.android.gms.internal.ads.zzeks -> L6d
            boolean r3 = r2.exists()     // Catch: com.google.android.gms.internal.ads.zzeks -> L6d
            if (r3 != 0) goto L51
            java.lang.String r2 = "pcam"
            java.io.File r3 = r5.a()     // Catch: com.google.android.gms.internal.ads.zzeks -> L6d
            java.io.File r2 = com.google.android.gms.internal.ads.zzduc.a(r0, r2, r3)     // Catch: com.google.android.gms.internal.ads.zzeks -> L6d
        L51:
            java.lang.String r3 = "pcbc"
            java.io.File r4 = r5.a()     // Catch: com.google.android.gms.internal.ads.zzeks -> L6d
            java.io.File r0 = com.google.android.gms.internal.ads.zzduc.a(r0, r3, r4)     // Catch: com.google.android.gms.internal.ads.zzeks -> L6d
            boolean r2 = r2.exists()     // Catch: com.google.android.gms.internal.ads.zzeks -> L6d
            if (r2 == 0) goto L69
            boolean r0 = r0.exists()     // Catch: com.google.android.gms.internal.ads.zzeks -> L6d
            if (r0 == 0) goto L69
            r0 = 1
            goto L6a
        L69:
            r0 = 0
        L6a:
            if (r0 == 0) goto L6d
            return r6
        L6d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdtz.b(int):com.google.android.gms.internal.ads.zzgt");
    }
}
