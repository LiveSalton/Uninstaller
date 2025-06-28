package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzafc extends NativeContentAd {
    private final zzafb a;
    private final zzaek c;
    private final NativeAd.AdChoicesInfo e;
    private final List<NativeAd.Image> b = new ArrayList();
    private final VideoController d = new VideoController();

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|(3:2|3|(2:5|(5:8|(1:22)(2:12|(1:14)(1:21))|(3:16|17|18)(1:20)|19|6)))|(2:24|25)|(7:27|28|29|30|(2:32|33)|35|36)|41|28|29|30|(0)|35|36) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0087, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0088, code lost:
    
        com.google.android.gms.internal.ads.zzaza.c("", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007a A[Catch: RemoteException -> 0x0087, TRY_LEAVE, TryCatch #2 {RemoteException -> 0x0087, blocks: (B:30:0x0072, B:32:0x007a), top: B:29:0x0072 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzafc(com.google.android.gms.internal.ads.zzafb r5) {
        /*
            r4 = this;
            r4.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r4.b = r0
            com.google.android.gms.ads.VideoController r0 = new com.google.android.gms.ads.VideoController
            r0.<init>()
            r4.d = r0
            r4.a = r5
            r5 = 0
            com.google.android.gms.internal.ads.zzafb r0 = r4.a     // Catch: android.os.RemoteException -> L55
            java.util.List r0 = r0.c()     // Catch: android.os.RemoteException -> L55
            if (r0 == 0) goto L5b
            java.util.Iterator r0 = r0.iterator()     // Catch: android.os.RemoteException -> L55
        L20:
            boolean r1 = r0.hasNext()     // Catch: android.os.RemoteException -> L55
            if (r1 == 0) goto L5b
            java.lang.Object r1 = r0.next()     // Catch: android.os.RemoteException -> L55
            boolean r2 = r1 instanceof android.os.IBinder     // Catch: android.os.RemoteException -> L55
            if (r2 == 0) goto L47
            android.os.IBinder r1 = (android.os.IBinder) r1     // Catch: android.os.RemoteException -> L55
            if (r1 == 0) goto L47
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)     // Catch: android.os.RemoteException -> L55
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaej     // Catch: android.os.RemoteException -> L55
            if (r3 == 0) goto L40
            r1 = r2
            com.google.android.gms.internal.ads.zzaej r1 = (com.google.android.gms.internal.ads.zzaej) r1     // Catch: android.os.RemoteException -> L55
            goto L48
        L40:
            com.google.android.gms.internal.ads.zzael r2 = new com.google.android.gms.internal.ads.zzael     // Catch: android.os.RemoteException -> L55
            r2.<init>(r1)     // Catch: android.os.RemoteException -> L55
            r1 = r2
            goto L48
        L47:
            r1 = r5
        L48:
            if (r1 == 0) goto L20
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r2 = r4.b     // Catch: android.os.RemoteException -> L55
            com.google.android.gms.internal.ads.zzaek r3 = new com.google.android.gms.internal.ads.zzaek     // Catch: android.os.RemoteException -> L55
            r3.<init>(r1)     // Catch: android.os.RemoteException -> L55
            r2.add(r3)     // Catch: android.os.RemoteException -> L55
            goto L20
        L55:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzaza.c(r1, r0)
        L5b:
            com.google.android.gms.internal.ads.zzafb r0 = r4.a     // Catch: android.os.RemoteException -> L69
            com.google.android.gms.internal.ads.zzaej r0 = r0.e()     // Catch: android.os.RemoteException -> L69
            if (r0 == 0) goto L6f
            com.google.android.gms.internal.ads.zzaek r1 = new com.google.android.gms.internal.ads.zzaek     // Catch: android.os.RemoteException -> L69
            r1.<init>(r0)     // Catch: android.os.RemoteException -> L69
            goto L70
        L69:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzaza.c(r1, r0)
        L6f:
            r1 = r5
        L70:
            r4.c = r1
            com.google.android.gms.internal.ads.zzafb r0 = r4.a     // Catch: android.os.RemoteException -> L87
            com.google.android.gms.internal.ads.zzaeb r0 = r0.k()     // Catch: android.os.RemoteException -> L87
            if (r0 == 0) goto L8d
            com.google.android.gms.internal.ads.zzaec r0 = new com.google.android.gms.internal.ads.zzaec     // Catch: android.os.RemoteException -> L87
            com.google.android.gms.internal.ads.zzafb r1 = r4.a     // Catch: android.os.RemoteException -> L87
            com.google.android.gms.internal.ads.zzaeb r1 = r1.k()     // Catch: android.os.RemoteException -> L87
            r0.<init>(r1)     // Catch: android.os.RemoteException -> L87
            r5 = r0
            goto L8d
        L87:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzaza.c(r1, r0)
        L8d:
            r4.e = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafc.<init>(com.google.android.gms.internal.ads.zzafb):void");
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    /* renamed from: i */
    public final IObjectWrapper a() {
        try {
            return this.a.a();
        } catch (RemoteException e) {
            zzaza.c("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence b() {
        try {
            return this.a.b();
        } catch (RemoteException e) {
            zzaza.c("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final List<NativeAd.Image> c() {
        return this.b;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence d() {
        try {
            return this.a.d();
        } catch (RemoteException e) {
            zzaza.c("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final NativeAd.Image e() {
        return this.c;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence f() {
        try {
            return this.a.f();
        } catch (RemoteException e) {
            zzaza.c("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence g() {
        try {
            return this.a.g();
        } catch (RemoteException e) {
            zzaza.c("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final VideoController h() {
        try {
            if (this.a.j() != null) {
                this.d.a(this.a.j());
            }
        } catch (RemoteException e) {
            zzaza.c("Exception occurred while getting video controller", e);
        }
        return this.d;
    }
}
