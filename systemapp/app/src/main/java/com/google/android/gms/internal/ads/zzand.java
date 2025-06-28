package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzand {
    private static zzand a;
    private AtomicBoolean b = new AtomicBoolean(false);

    public static zzand a() {
        if (a == null) {
            a = new zzand();
        }
        return a;
    }

    zzand() {
    }

    public final Thread a(Context context, String str) {
        if (!this.b.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new Runnable(this, context, str) { // from class: com.google.android.gms.internal.ads.cx
            private final zzand a;
            private final Context b;
            private final String c;

            {
                this.a = this;
                this.b = context;
                this.c = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Context context2 = this.b;
                String str2 = this.c;
                zzabf.a(context2);
                Bundle bundle = new Bundle();
                bundle.putBoolean("measurementEnabled", ((Boolean) zzwq.e().a(zzabf.Y)).booleanValue());
                try {
                    ((zzbgh) zzazd.a(context2, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", cy.a)).a(ObjectWrapper.a(context2), new zzana(AppMeasurementSdk.a(context2, "FA-Ads", "am", str2, bundle)));
                } catch (RemoteException | zzazf | NullPointerException e) {
                    zzaza.e("#007 Could not call remote method.", e);
                }
            }
        });
        thread.start();
        return thread;
    }
}
