package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class zzbcx implements Releasable {
    protected Context a;
    protected String b;
    protected WeakReference<zzbbe> c;

    public zzbcx(zzbbe zzbbeVar) {
        this.a = zzbbeVar.getContext();
        this.b = zzp.c().b(this.a, zzbbeVar.m().a);
        this.c = new WeakReference<>(zzbbeVar);
    }

    public abstract void a();

    protected void a(int i) {
    }

    public abstract boolean a(String str);

    public void b() {
    }

    protected void c(int i) {
    }

    protected void d(int i) {
    }

    protected void e(int i) {
    }

    public boolean a(String str, String[] strArr) {
        return a(str);
    }

    @VisibleForTesting
    public final void a(String str, String str2, long j, long j2, boolean z, long j3, long j4, long j5, int i, int i2) {
        zzayr.a.post(new hv(this, str, str2, j, j2, j3, j4, j5, z, i, i2));
    }

    @VisibleForTesting
    public final void a(String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        zzayr.a.post(new hu(this, str, str2, i, i2, j, j2, z, i3, i4));
    }

    protected final void a(String str, String str2, int i) {
        zzayr.a.post(new hx(this, str, str2, i));
    }

    @VisibleForTesting
    public final void a(String str, String str2, long j) {
        zzayr.a.post(new hw(this, str, str2, j));
    }

    @VisibleForTesting
    public final void a(String str, String str2, String str3, String str4) {
        zzayr.a.post(new hy(this, str, str2, str3, str4));
    }

    protected String b(String str) {
        return zzayr.a(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String c(String str) {
        char c;
        switch (str.hashCode()) {
            case -1947652542:
                if (str.equals("interrupted")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1396664534:
                if (str.equals("badUrl")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 3387234:
                if (str.equals("noop")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 96784904:
                if (str.equals("error")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
        }
        return "internal";
    }

    public final void a(String str, Map<String, String> map) {
        zzbbe zzbbeVar = this.c.get();
        if (zzbbeVar != null) {
            zzbbeVar.a(str, map);
        }
    }
}
