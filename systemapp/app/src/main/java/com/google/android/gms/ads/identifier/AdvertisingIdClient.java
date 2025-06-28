package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class AdvertisingIdClient {

    @GuardedBy("this")
    private BlockingServiceConnection a;

    @GuardedBy("this")
    private zze b;

    @GuardedBy("this")
    private boolean c;
    private final Object d;

    @GuardedBy("mAutoDisconnectTaskLock")
    private a e;

    @GuardedBy("this")
    private final Context f;
    private final boolean g;
    private final long h;

    @KeepForSdkWithMembers
    public static final class Info {
        private final String a;
        private final boolean b;

        public Info(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        public final String getId() {
            return this.a;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.b;
        }

        public final String toString() {
            String str = this.a;
            boolean z = this.b;
            StringBuilder sb = new StringBuilder(7 + String.valueOf(str).length());
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    @VisibleForTesting
    static class a extends Thread {
        CountDownLatch a = new CountDownLatch(1);
        boolean b = false;
        private WeakReference<AdvertisingIdClient> c;
        private long d;

        public a(AdvertisingIdClient advertisingIdClient, long j) {
            this.c = new WeakReference<>(advertisingIdClient);
            this.d = j;
            start();
        }

        private final void a() {
            AdvertisingIdClient advertisingIdClient = this.c.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.b = true;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                if (this.a.await(this.d, TimeUnit.MILLISECONDS)) {
                    return;
                }
                a();
            } catch (InterruptedException unused) {
                a();
            }
        }
    }

    @KeepForSdk
    public AdvertisingIdClient(Context context) {
        this(context, 30000L, false, false);
    }

    @VisibleForTesting
    private AdvertisingIdClient(Context context, long j, boolean z, boolean z2) {
        Context applicationContext;
        this.d = new Object();
        Preconditions.a(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f = context;
        this.c = false;
        this.h = j;
        this.g = z2;
    }

    private static BlockingServiceConnection a(Context context, boolean z) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int a2 = GoogleApiAvailabilityLight.a().a(context, GooglePlayServicesUtilLight.a);
            if (a2 != 0 && a2 != 2) {
                throw new IOException("Google Play services not available");
            }
            String str = z ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
            BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
            Intent intent = new Intent(str);
            intent.setPackage("com.google.android.gms");
            try {
                if (ConnectionTracker.a().a(context, intent, blockingServiceConnection, 1)) {
                    return blockingServiceConnection;
                }
                throw new IOException("Connection failure");
            } catch (Throwable th) {
                throw new IOException(th);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    @VisibleForTesting
    private static zze a(Context context, BlockingServiceConnection blockingServiceConnection) throws IOException {
        try {
            return zzf.a(blockingServiceConnection.a(10000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private final void a() {
        synchronized (this.d) {
            if (this.e != null) {
                this.e.a.countDown();
                try {
                    this.e.join();
                } catch (InterruptedException unused) {
                }
            }
            if (this.h > 0) {
                this.e = new a(this, this.h);
            }
        }
    }

    @VisibleForTesting
    private final void a(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        Preconditions.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.c) {
                finish();
            }
            this.a = a(this.f, this.g);
            this.b = a(this.f, this.a);
            this.c = true;
            if (z) {
                a();
            }
        }
    }

    @VisibleForTesting
    private final boolean a(Info info, boolean z, float f, long j, String str, Throwable th) {
        if (Math.random() > f) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("app_context", z ? "1" : "0");
        if (info != null) {
            hashMap.put("limit_ad_tracking", info.isLimitAdTrackingEnabled() ? "1" : "0");
        }
        if (info != null && info.getId() != null) {
            hashMap.put("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        if (str != null && !str.isEmpty()) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j));
        new com.google.android.gms.ads.identifier.a(this, hashMap).start();
        return true;
    }

    private final boolean b() throws IOException {
        boolean b;
        Preconditions.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.c) {
                synchronized (this.d) {
                    if (this.e != null && this.e.b) {
                    }
                    throw new IOException("AdvertisingIdClient is not connected.");
                }
                try {
                    a(false);
                    if (!this.c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                }
            }
            Preconditions.a(this.a);
            Preconditions.a(this.b);
            try {
                b = this.b.b();
            } catch (RemoteException e2) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                throw new IOException("Remote exception");
            }
        }
        a();
        return b;
    }

    @KeepForSdk
    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb zzbVar = new zzb(context);
        boolean a2 = zzbVar.a("gads:ad_id_app_context:enabled", false);
        float a3 = zzbVar.a("gads:ad_id_app_context:ping_ratio", 0.0f);
        String a4 = zzbVar.a("gads:ad_id_use_shared_preference:experiment_id", "");
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, a2, zzbVar.a("gads:ad_id_use_persistent_service:enabled", false));
        try {
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                advertisingIdClient.a(false);
                Info info = advertisingIdClient.getInfo();
                advertisingIdClient.a(info, a2, a3, SystemClock.elapsedRealtime() - elapsedRealtime, a4, null);
                return info;
            } finally {
            }
        } finally {
            advertisingIdClient.finish();
        }
    }

    @KeepForSdk
    public static boolean getIsAdIdFakeForDebugLogging(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb zzbVar = new zzb(context);
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, zzbVar.a("gads:ad_id_app_context:enabled", false), zzbVar.a("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
        try {
            advertisingIdClient.a(false);
            return advertisingIdClient.b();
        } finally {
            advertisingIdClient.finish();
        }
    }

    @KeepForSdk
    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    protected void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    public final void finish() {
        Preconditions.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f == null || this.a == null) {
                return;
            }
            try {
                if (this.c) {
                    ConnectionTracker.a().a(this.f, this.a);
                }
            } catch (Throwable th) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
            }
            this.c = false;
            this.b = null;
            this.a = null;
        }
    }

    @KeepForSdk
    public Info getInfo() throws IOException {
        Info info;
        Preconditions.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.c) {
                synchronized (this.d) {
                    if (this.e != null && this.e.b) {
                    }
                    throw new IOException("AdvertisingIdClient is not connected.");
                }
                try {
                    a(false);
                    if (!this.c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                }
            }
            Preconditions.a(this.a);
            Preconditions.a(this.b);
            try {
                info = new Info(this.b.a(), this.b.a(true));
            } catch (RemoteException e2) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                throw new IOException("Remote exception");
            }
        }
        a();
        return info;
    }

    @KeepForSdk
    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        a(true);
    }
}
