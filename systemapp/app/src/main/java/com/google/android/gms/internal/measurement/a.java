package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: source */
/* loaded from: classes.dex */
final class a extends zzx.a {
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ Context e;
    private final /* synthetic */ Bundle f;
    private final /* synthetic */ zzx g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    a(zzx zzxVar, String str, String str2, Context context, Bundle bundle) {
        super(zzxVar);
        this.g = zzxVar;
        this.c = str;
        this.d = str2;
        this.e = context;
        this.f = bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0072, code lost:
    
        if (r4 < r3) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0054 A[Catch: RemoteException -> 0x009e, TryCatch #0 {RemoteException -> 0x009e, blocks: (B:3:0x0002, B:5:0x0019, B:6:0x002a, B:11:0x003f, B:13:0x0054, B:16:0x0060, B:18:0x006e, B:22:0x0081), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060 A[Catch: RemoteException -> 0x009e, TryCatch #0 {RemoteException -> 0x009e, blocks: (B:3:0x0002, B:5:0x0019, B:6:0x002a, B:11:0x003f, B:13:0x0054, B:16:0x0060, B:18:0x006e, B:22:0x0081), top: B:2:0x0002 }] */
    @Override // com.google.android.gms.internal.measurement.zzx.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            r14 = this;
            r0 = 1
            r1 = 0
            com.google.android.gms.internal.measurement.zzx r2 = r14.g     // Catch: android.os.RemoteException -> L9e
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.os.RemoteException -> L9e
            r3.<init>()     // Catch: android.os.RemoteException -> L9e
            com.google.android.gms.internal.measurement.zzx.a(r2, r3)     // Catch: android.os.RemoteException -> L9e
            com.google.android.gms.internal.measurement.zzx r2 = r14.g     // Catch: android.os.RemoteException -> L9e
            java.lang.String r3 = r14.c     // Catch: android.os.RemoteException -> L9e
            java.lang.String r4 = r14.d     // Catch: android.os.RemoteException -> L9e
            boolean r2 = com.google.android.gms.internal.measurement.zzx.a(r2, r3, r4)     // Catch: android.os.RemoteException -> L9e
            r3 = 0
            if (r2 == 0) goto L27
            java.lang.String r3 = r14.d     // Catch: android.os.RemoteException -> L9e
            java.lang.String r2 = r14.c     // Catch: android.os.RemoteException -> L9e
            com.google.android.gms.internal.measurement.zzx r4 = r14.g     // Catch: android.os.RemoteException -> L9e
            java.lang.String r4 = com.google.android.gms.internal.measurement.zzx.b(r4)     // Catch: android.os.RemoteException -> L9e
            r10 = r2
            r11 = r3
            r9 = r4
            goto L2a
        L27:
            r9 = r3
            r10 = r9
            r11 = r10
        L2a:
            android.content.Context r2 = r14.e     // Catch: android.os.RemoteException -> L9e
            com.google.android.gms.internal.measurement.zzx.a(r2)     // Catch: android.os.RemoteException -> L9e
            java.lang.Boolean r2 = com.google.android.gms.internal.measurement.zzx.h()     // Catch: android.os.RemoteException -> L9e
            boolean r2 = r2.booleanValue()     // Catch: android.os.RemoteException -> L9e
            if (r2 != 0) goto L3e
            if (r10 == 0) goto L3c
            goto L3e
        L3c:
            r2 = r1
            goto L3f
        L3e:
            r2 = r0
        L3f:
            com.google.android.gms.internal.measurement.zzx r3 = r14.g     // Catch: android.os.RemoteException -> L9e
            com.google.android.gms.internal.measurement.zzx r4 = r14.g     // Catch: android.os.RemoteException -> L9e
            android.content.Context r5 = r14.e     // Catch: android.os.RemoteException -> L9e
            com.google.android.gms.internal.measurement.zzm r4 = r4.a(r5, r2)     // Catch: android.os.RemoteException -> L9e
            com.google.android.gms.internal.measurement.zzx.a(r3, r4)     // Catch: android.os.RemoteException -> L9e
            com.google.android.gms.internal.measurement.zzx r3 = r14.g     // Catch: android.os.RemoteException -> L9e
            com.google.android.gms.internal.measurement.zzm r3 = com.google.android.gms.internal.measurement.zzx.c(r3)     // Catch: android.os.RemoteException -> L9e
            if (r3 != 0) goto L60
            com.google.android.gms.internal.measurement.zzx r2 = r14.g     // Catch: android.os.RemoteException -> L9e
            java.lang.String r2 = com.google.android.gms.internal.measurement.zzx.b(r2)     // Catch: android.os.RemoteException -> L9e
            java.lang.String r3 = "Failed to connect to measurement client."
            android.util.Log.w(r2, r3)     // Catch: android.os.RemoteException -> L9e
            return
        L60:
            android.content.Context r3 = r14.e     // Catch: android.os.RemoteException -> L9e
            int r3 = com.google.android.gms.internal.measurement.zzx.b(r3)     // Catch: android.os.RemoteException -> L9e
            android.content.Context r4 = r14.e     // Catch: android.os.RemoteException -> L9e
            int r4 = com.google.android.gms.internal.measurement.zzx.c(r4)     // Catch: android.os.RemoteException -> L9e
            if (r2 == 0) goto L79
            int r2 = java.lang.Math.max(r3, r4)     // Catch: android.os.RemoteException -> L9e
            if (r4 >= r3) goto L76
        L74:
            r3 = r0
            goto L77
        L76:
            r3 = r1
        L77:
            r8 = r3
            goto L81
        L79:
            if (r3 <= 0) goto L7d
            r2 = r3
            goto L7e
        L7d:
            r2 = r4
        L7e:
            if (r3 <= 0) goto L76
            goto L74
        L81:
            com.google.android.gms.internal.measurement.zzv r13 = new com.google.android.gms.internal.measurement.zzv     // Catch: android.os.RemoteException -> L9e
            r4 = 18202(0x471a, double:8.993E-320)
            long r6 = (long) r2     // Catch: android.os.RemoteException -> L9e
            android.os.Bundle r12 = r14.f     // Catch: android.os.RemoteException -> L9e
            r3 = r13
            r3.<init>(r4, r6, r8, r9, r10, r11, r12)     // Catch: android.os.RemoteException -> L9e
            com.google.android.gms.internal.measurement.zzx r2 = r14.g     // Catch: android.os.RemoteException -> L9e
            com.google.android.gms.internal.measurement.zzm r2 = com.google.android.gms.internal.measurement.zzx.c(r2)     // Catch: android.os.RemoteException -> L9e
            android.content.Context r3 = r14.e     // Catch: android.os.RemoteException -> L9e
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.ObjectWrapper.a(r3)     // Catch: android.os.RemoteException -> L9e
            long r4 = r14.a     // Catch: android.os.RemoteException -> L9e
            r2.a(r3, r13, r4)     // Catch: android.os.RemoteException -> L9e
            return
        L9e:
            r2 = move-exception
            com.google.android.gms.internal.measurement.zzx r3 = r14.g
            com.google.android.gms.internal.measurement.zzx.a(r3, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.a.a():void");
    }
}
