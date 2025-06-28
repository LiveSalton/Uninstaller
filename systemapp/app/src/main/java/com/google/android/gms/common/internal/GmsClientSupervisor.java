package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public abstract class GmsClientSupervisor {
    private static int a = 129;
    private static final Object b = new Object();
    private static GmsClientSupervisor c;

    protected abstract boolean a(zza zzaVar, ServiceConnection serviceConnection, String str);

    protected abstract void b(zza zzaVar, ServiceConnection serviceConnection, String str);

    @KeepForSdk
    public static int a() {
        return a;
    }

    @KeepForSdk
    public static GmsClientSupervisor a(Context context) {
        synchronized (b) {
            if (c == null) {
                c = new c(context.getApplicationContext());
            }
        }
        return c;
    }

    /* compiled from: source */
    protected static final class zza {
        private static final Uri f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
        private final String a;
        private final String b;
        private final ComponentName c = null;
        private final int d;
        private final boolean e;

        public zza(String str, String str2, int i, boolean z) {
            this.a = Preconditions.a(str);
            this.b = Preconditions.a(str2);
            this.d = i;
            this.e = z;
        }

        public final String toString() {
            if (this.a == null) {
                Preconditions.a(this.c);
                return this.c.flattenToString();
            }
            return this.a;
        }

        public final String a() {
            return this.b;
        }

        public final ComponentName b() {
            return this.c;
        }

        public final int c() {
            return this.d;
        }

        public final Intent a(Context context) {
            if (this.a != null) {
                Intent b = this.e ? b(context) : null;
                return b == null ? new Intent(this.a).setPackage(this.b) : b;
            }
            return new Intent().setComponent(this.c);
        }

        private final Intent b(Context context) {
            Bundle bundle;
            Bundle bundle2 = new Bundle();
            bundle2.putString("serviceActionBundleKey", this.a);
            try {
                bundle = context.getContentResolver().call(f, "serviceIntentCall", (String) null, bundle2);
            } catch (IllegalArgumentException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(34 + String.valueOf(valueOf).length());
                sb.append("Dynamic intent resolution failed: ");
                sb.append(valueOf);
                Log.w("ConnectionStatusConfig", sb.toString());
                bundle = null;
            }
            Intent intent = bundle != null ? (Intent) bundle.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                String valueOf2 = String.valueOf(this.a);
                Log.w("ConnectionStatusConfig", valueOf2.length() != 0 ? "Dynamic lookup for intent failed for action: ".concat(valueOf2) : new String("Dynamic lookup for intent failed for action: "));
            }
            return intent;
        }

        public final int hashCode() {
            return Objects.a(this.a, this.b, this.c, Integer.valueOf(this.d), Boolean.valueOf(this.e));
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return Objects.a(this.a, zzaVar.a) && Objects.a(this.b, zzaVar.b) && Objects.a(this.c, zzaVar.c) && this.d == zzaVar.d && this.e == zzaVar.e;
        }
    }

    public final void a(String str, String str2, int i, ServiceConnection serviceConnection, String str3, boolean z) {
        b(new zza(str, str2, i, z), serviceConnection, str3);
    }
}
