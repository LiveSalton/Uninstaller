package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.Hex;
import java.io.File;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdui {
    private static final Object e = new Object();
    private final Context a;
    private final SharedPreferences b;
    private final String c;
    private final zzdtn d;

    public zzdui(Context context, zzgn zzgnVar, zzdtn zzdtnVar) {
        this.a = context;
        this.c = Integer.toString(zzgnVar.a());
        this.b = context.getSharedPreferences("pcvmspf", 0);
        this.d = zzdtnVar;
    }

    public final zzdua a(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (e) {
            zzgt b = b(i);
            if (b == null) {
                a(4022, currentTimeMillis);
                return null;
            }
            File a = a(b.a());
            File file = new File(a, "pcam.jar");
            if (!file.exists()) {
                file = new File(a, "pcam");
            }
            File file2 = new File(a, "pcbc");
            File file3 = new File(a, "pcopt");
            a(5016, currentTimeMillis);
            return new zzdua(b, file, file2, file3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00bc A[Catch: all -> 0x0197, DONT_GENERATE, TryCatch #0 {, blocks: (B:4:0x000b, B:6:0x001c, B:8:0x0026, B:9:0x002b, B:12:0x002d, B:14:0x003d, B:17:0x004a, B:20:0x0055, B:23:0x00bc, B:25:0x00be, B:27:0x00de, B:28:0x00e3, B:30:0x00e5, B:32:0x00f3, B:33:0x00f8, B:36:0x00fc, B:38:0x0102, B:39:0x010a, B:41:0x010c, B:43:0x012e, B:44:0x0135, B:46:0x013b, B:48:0x0142, B:50:0x0144, B:52:0x0151, B:53:0x0158, B:55:0x0160, B:56:0x0167, B:58:0x017d, B:60:0x0189, B:62:0x018c, B:65:0x018f, B:66:0x0194, B:70:0x0088, B:72:0x008e, B:75:0x009d, B:77:0x00a7, B:78:0x00b1, B:79:0x00ac), top: B:3:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00be A[Catch: all -> 0x0197, TryCatch #0 {, blocks: (B:4:0x000b, B:6:0x001c, B:8:0x0026, B:9:0x002b, B:12:0x002d, B:14:0x003d, B:17:0x004a, B:20:0x0055, B:23:0x00bc, B:25:0x00be, B:27:0x00de, B:28:0x00e3, B:30:0x00e5, B:32:0x00f3, B:33:0x00f8, B:36:0x00fc, B:38:0x0102, B:39:0x010a, B:41:0x010c, B:43:0x012e, B:44:0x0135, B:46:0x013b, B:48:0x0142, B:50:0x0144, B:52:0x0151, B:53:0x0158, B:55:0x0160, B:56:0x0167, B:58:0x017d, B:60:0x0189, B:62:0x018c, B:65:0x018f, B:66:0x0194, B:70:0x0088, B:72:0x008e, B:75:0x009d, B:77:0x00a7, B:78:0x00b1, B:79:0x00ac), top: B:3:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(com.google.android.gms.internal.ads.zzgp r18, com.google.android.gms.internal.ads.zzduf r19) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdui.a(com.google.android.gms.internal.ads.zzgp, com.google.android.gms.internal.ads.zzduf):boolean");
    }

    public final boolean a(zzgp zzgpVar) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (e) {
            if (!zzduc.a(new File(a(zzgpVar.a().a()), "pcbc"), zzgpVar.c().d())) {
                a(4020, currentTimeMillis);
                return false;
            }
            String b = b(zzgpVar);
            SharedPreferences.Editor edit = this.b.edit();
            edit.putString(b(), b);
            boolean commit = edit.commit();
            if (commit) {
                a(5015, currentTimeMillis);
            } else {
                a(4021, currentTimeMillis);
            }
            return commit;
        }
    }

    private final zzgt b(int i) {
        String string;
        if (i == zzduh.a) {
            string = this.b.getString(b(), null);
        } else {
            string = i == zzduh.b ? this.b.getString(a(), null) : null;
        }
        if (string == null) {
            return null;
        }
        try {
            return zzgt.a(zzeiu.a(Hex.a(string)), zzeju.b());
        } catch (zzeks unused) {
            return null;
        }
    }

    private final File a(String str) {
        return new File(new File(this.a.getDir("pccache", 0), this.c), str);
    }

    private final String a() {
        String valueOf = String.valueOf("FBAMTD");
        String valueOf2 = String.valueOf(this.c);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private final String b() {
        String valueOf = String.valueOf("LATMTD");
        String valueOf2 = String.valueOf(this.c);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private static String b(zzgp zzgpVar) {
        return Hex.a(((zzgt) ((zzekh) zzgt.f().a(zzgpVar.a().a()).b(zzgpVar.a().b()).b(zzgpVar.a().d()).c(zzgpVar.a().e()).a(zzgpVar.a().c()).g())).k().d());
    }

    private final void a(int i, long j) {
        if (this.d != null) {
            this.d.a(i, j);
        }
    }

    private final void a(int i, long j, String str) {
        if (this.d != null) {
            this.d.a(i, j, str);
        }
    }
}
