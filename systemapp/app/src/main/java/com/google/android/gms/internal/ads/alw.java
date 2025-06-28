package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;

/* compiled from: source */
/* loaded from: classes.dex */
final class alw implements Runnable {
    private final /* synthetic */ zzdt a;

    alw(zzdt zzdtVar) {
        this.a = zzdtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        boolean z;
        zzfa zzfaVar;
        ConditionVariable conditionVariable2;
        if (this.a.b != null) {
            return;
        }
        conditionVariable = zzdt.d;
        synchronized (conditionVariable) {
            if (this.a.b != null) {
                return;
            }
            boolean z2 = false;
            try {
                z = zzabf.bd.a().booleanValue();
            } catch (IllegalStateException unused) {
                z = false;
            }
            if (z) {
                try {
                    zzfaVar = this.a.c;
                    zzdt.a = new zztx(zzfaVar.a, "ADSHIELD", null);
                } catch (Throwable unused2) {
                }
            }
            z2 = z;
            this.a.b = Boolean.valueOf(z2);
            conditionVariable2 = zzdt.d;
            conditionVariable2.open();
        }
    }
}
