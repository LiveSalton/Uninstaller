package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzk extends zzq {
    private final AtomicReference<Bundle> a = new AtomicReference<>();
    private boolean b;

    @Override // com.google.android.gms.internal.measurement.zzn
    public final void a(Bundle bundle) {
        synchronized (this.a) {
            try {
                this.a.set(bundle);
                this.b = true;
            } finally {
                this.a.notify();
            }
        }
    }

    public final String a(long j) {
        return (String) a(b(j), String.class);
    }

    public final Bundle b(long j) {
        Bundle bundle;
        synchronized (this.a) {
            if (!this.b) {
                try {
                    this.a.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = this.a.get();
        }
        return bundle;
    }

    public static <T> T a(Bundle bundle, Class<T> cls) {
        Object obj;
        if (bundle == null || (obj = bundle.get("r")) == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            Log.w("AM", String.format(String.valueOf("Unexpected object type. Expected, Received").concat(": %s, %s"), cls.getCanonicalName(), obj.getClass().getCanonicalName()), e);
            throw e;
        }
    }
}
