package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzagk extends UnifiedNativeAd {
    private final zzagj a;
    private final zzaek c;
    private final NativeAd.AdChoicesInfo e;
    private final List<NativeAd.Image> b = new ArrayList();
    private final VideoController d = new VideoController();
    private final List<MuteThisAdReason> f = new ArrayList();

    /* JADX WARN: Can't wrap try/catch for region: R(16:0|1|2|3|(2:5|(5:8|(1:22)(2:12|(1:14)(1:21))|(3:16|17|18)(1:20)|19|6))|(3:24|25|(2:27|(5:30|(1:32)(1:39)|(3:34|35|36)(1:38)|37|28)))|41|42|(7:44|45|46|47|(2:49|50)|52|53)|58|45|46|47|(0)|52|53) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c4, code lost:
    
        com.google.android.gms.internal.ads.zzaza.c("", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b6 A[Catch: RemoteException -> 0x00c3, TRY_LEAVE, TryCatch #1 {RemoteException -> 0x00c3, blocks: (B:47:0x00ae, B:49:0x00b6), top: B:46:0x00ae }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzagk(com.google.android.gms.internal.ads.zzagj r5) {
        /*
            r4 = this;
            r4.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r4.b = r0
            com.google.android.gms.ads.VideoController r0 = new com.google.android.gms.ads.VideoController
            r0.<init>()
            r4.d = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r4.f = r0
            r4.a = r5
            r5 = 0
            com.google.android.gms.internal.ads.zzagj r0 = r4.a     // Catch: android.os.RemoteException -> L5c
            java.util.List r0 = r0.b()     // Catch: android.os.RemoteException -> L5c
            if (r0 == 0) goto L62
            java.util.Iterator r0 = r0.iterator()     // Catch: android.os.RemoteException -> L5c
        L27:
            boolean r1 = r0.hasNext()     // Catch: android.os.RemoteException -> L5c
            if (r1 == 0) goto L62
            java.lang.Object r1 = r0.next()     // Catch: android.os.RemoteException -> L5c
            boolean r2 = r1 instanceof android.os.IBinder     // Catch: android.os.RemoteException -> L5c
            if (r2 == 0) goto L4e
            android.os.IBinder r1 = (android.os.IBinder) r1     // Catch: android.os.RemoteException -> L5c
            if (r1 == 0) goto L4e
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)     // Catch: android.os.RemoteException -> L5c
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaej     // Catch: android.os.RemoteException -> L5c
            if (r3 == 0) goto L47
            r1 = r2
            com.google.android.gms.internal.ads.zzaej r1 = (com.google.android.gms.internal.ads.zzaej) r1     // Catch: android.os.RemoteException -> L5c
            goto L4f
        L47:
            com.google.android.gms.internal.ads.zzael r2 = new com.google.android.gms.internal.ads.zzael     // Catch: android.os.RemoteException -> L5c
            r2.<init>(r1)     // Catch: android.os.RemoteException -> L5c
            r1 = r2
            goto L4f
        L4e:
            r1 = r5
        L4f:
            if (r1 == 0) goto L27
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r2 = r4.b     // Catch: android.os.RemoteException -> L5c
            com.google.android.gms.internal.ads.zzaek r3 = new com.google.android.gms.internal.ads.zzaek     // Catch: android.os.RemoteException -> L5c
            r3.<init>(r1)     // Catch: android.os.RemoteException -> L5c
            r2.add(r3)     // Catch: android.os.RemoteException -> L5c
            goto L27
        L5c:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzaza.c(r1, r0)
        L62:
            com.google.android.gms.internal.ads.zzagj r0 = r4.a     // Catch: android.os.RemoteException -> L91
            java.util.List r0 = r0.r()     // Catch: android.os.RemoteException -> L91
            if (r0 == 0) goto L97
            java.util.Iterator r0 = r0.iterator()     // Catch: android.os.RemoteException -> L91
        L6e:
            boolean r1 = r0.hasNext()     // Catch: android.os.RemoteException -> L91
            if (r1 == 0) goto L97
            java.lang.Object r1 = r0.next()     // Catch: android.os.RemoteException -> L91
            boolean r2 = r1 instanceof android.os.IBinder     // Catch: android.os.RemoteException -> L91
            if (r2 == 0) goto L83
            android.os.IBinder r1 = (android.os.IBinder) r1     // Catch: android.os.RemoteException -> L91
            com.google.android.gms.internal.ads.zzyd r1 = com.google.android.gms.internal.ads.zzyg.a(r1)     // Catch: android.os.RemoteException -> L91
            goto L84
        L83:
            r1 = r5
        L84:
            if (r1 == 0) goto L6e
            java.util.List<com.google.android.gms.ads.MuteThisAdReason> r2 = r4.f     // Catch: android.os.RemoteException -> L91
            com.google.android.gms.internal.ads.zzyi r3 = new com.google.android.gms.internal.ads.zzyi     // Catch: android.os.RemoteException -> L91
            r3.<init>(r1)     // Catch: android.os.RemoteException -> L91
            r2.add(r3)     // Catch: android.os.RemoteException -> L91
            goto L6e
        L91:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzaza.c(r1, r0)
        L97:
            com.google.android.gms.internal.ads.zzagj r0 = r4.a     // Catch: android.os.RemoteException -> La5
            com.google.android.gms.internal.ads.zzaej r0 = r0.d()     // Catch: android.os.RemoteException -> La5
            if (r0 == 0) goto Lab
            com.google.android.gms.internal.ads.zzaek r1 = new com.google.android.gms.internal.ads.zzaek     // Catch: android.os.RemoteException -> La5
            r1.<init>(r0)     // Catch: android.os.RemoteException -> La5
            goto Lac
        La5:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzaza.c(r1, r0)
        Lab:
            r1 = r5
        Lac:
            r4.c = r1
            com.google.android.gms.internal.ads.zzagj r0 = r4.a     // Catch: android.os.RemoteException -> Lc3
            com.google.android.gms.internal.ads.zzaeb r0 = r0.m()     // Catch: android.os.RemoteException -> Lc3
            if (r0 == 0) goto Lc9
            com.google.android.gms.internal.ads.zzaec r0 = new com.google.android.gms.internal.ads.zzaec     // Catch: android.os.RemoteException -> Lc3
            com.google.android.gms.internal.ads.zzagj r1 = r4.a     // Catch: android.os.RemoteException -> Lc3
            com.google.android.gms.internal.ads.zzaeb r1 = r1.m()     // Catch: android.os.RemoteException -> Lc3
            r0.<init>(r1)     // Catch: android.os.RemoteException -> Lc3
            r5 = r0
            goto Lc9
        Lc3:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzaza.c(r1, r0)
        Lc9:
            r4.e = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagk.<init>(com.google.android.gms.internal.ads.zzagj):void");
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    /* renamed from: m */
    public final IObjectWrapper k() {
        try {
            return this.a.n();
        } catch (RemoteException e) {
            zzaza.c("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Object l() {
        try {
            IObjectWrapper o = this.a.o();
            if (o != null) {
                return ObjectWrapper.a(o);
            }
            return null;
        } catch (RemoteException e) {
            zzaza.c("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String a() {
        try {
            return this.a.a();
        } catch (RemoteException e) {
            zzaza.c("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<NativeAd.Image> b() {
        return this.b;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String c() {
        try {
            return this.a.c();
        } catch (RemoteException e) {
            zzaza.c("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.Image d() {
        return this.c;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String e() {
        try {
            return this.a.e();
        } catch (RemoteException e) {
            zzaza.c("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Double g() {
        try {
            double g = this.a.g();
            if (g == -1.0d) {
                return null;
            }
            return Double.valueOf(g);
        } catch (RemoteException e) {
            zzaza.c("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String h() {
        try {
            return this.a.h();
        } catch (RemoteException e) {
            zzaza.c("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String i() {
        try {
            return this.a.i();
        } catch (RemoteException e) {
            zzaza.c("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final VideoController j() {
        try {
            if (this.a.j() != null) {
                this.d.a(this.a.j());
            }
        } catch (RemoteException e) {
            zzaza.c("Exception occurred while getting video controller", e);
        }
        return this.d;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String f() {
        try {
            return this.a.f();
        } catch (RemoteException e) {
            zzaza.c("", e);
            return null;
        }
    }
}
