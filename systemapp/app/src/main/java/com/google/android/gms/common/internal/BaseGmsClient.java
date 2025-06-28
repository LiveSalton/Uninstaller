package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.IGmsServiceBroker;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public abstract class BaseGmsClient<T extends IInterface> {
    private final String A;
    private ConnectionResult B;
    private boolean C;
    private volatile com.google.android.gms.common.internal.zzc D;
    final Handler a;

    @VisibleForTesting
    protected ConnectionProgressReportCallbacks b;

    @VisibleForTesting
    protected AtomicInteger c;
    private int f;
    private long g;
    private long h;
    private int i;
    private long j;
    private volatile String k;

    @VisibleForTesting
    private zzk l;
    private final Context m;
    private final Looper n;
    private final GmsClientSupervisor o;
    private final GoogleApiAvailabilityLight p;
    private final Object q;
    private final Object r;

    @GuardedBy("mServiceBrokerLock")
    private IGmsServiceBroker s;

    @GuardedBy("mLock")
    private T t;
    private final ArrayList<zzc<?>> u;

    @GuardedBy("mLock")
    private zzd v;

    @GuardedBy("mLock")
    private int w;
    private final BaseConnectionCallbacks x;
    private final BaseOnConnectionFailedListener y;
    private final int z;
    private static final Feature[] e = new Feature[0];

    @KeepForSdk
    public static final String[] d = {"service_esmobile", "service_googleme"};

    /* compiled from: source */
    @KeepForSdk
    public interface BaseConnectionCallbacks {
        @KeepForSdk
        void a(int i);

        @KeepForSdk
        void a(Bundle bundle);
    }

    /* compiled from: source */
    @KeepForSdk
    public interface BaseOnConnectionFailedListener {
        @KeepForSdk
        void a(ConnectionResult connectionResult);
    }

    /* compiled from: source */
    @KeepForSdk
    public interface ConnectionProgressReportCallbacks {
        @KeepForSdk
        void a(ConnectionResult connectionResult);
    }

    /* compiled from: source */
    protected class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        @KeepForSdk
        public LegacyClientCallbackAdapter() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public void a(ConnectionResult connectionResult) {
            if (connectionResult.a()) {
                BaseGmsClient.this.a((IAccountAccessor) null, BaseGmsClient.this.t());
            } else if (BaseGmsClient.this.y != null) {
                BaseGmsClient.this.y.a(connectionResult);
            }
        }
    }

    /* compiled from: source */
    @KeepForSdk
    public interface SignOutCallbacks {
    }

    @KeepForSdk
    protected abstract T a(IBinder iBinder);

    @KeepForSdk
    protected abstract String a();

    @KeepForSdk
    void a(int i, T t) {
    }

    @KeepForSdk
    protected String b() {
        return "com.google.android.gms";
    }

    @KeepForSdk
    protected abstract String c();

    @KeepForSdk
    protected String d() {
        return null;
    }

    @KeepForSdk
    public Account k() {
        return null;
    }

    @KeepForSdk
    public Bundle o() {
        return null;
    }

    @KeepForSdk
    protected boolean q() {
        return false;
    }

    @KeepForSdk
    public boolean r() {
        return false;
    }

    @KeepForSdk
    public boolean s() {
        return false;
    }

    @KeepForSdk
    protected boolean v() {
        return false;
    }

    @KeepForSdk
    protected BaseGmsClient(Context context, Looper looper, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this(context, looper, GmsClientSupervisor.a(context), GoogleApiAvailabilityLight.a(), i, (BaseConnectionCallbacks) Preconditions.a(baseConnectionCallbacks), (BaseOnConnectionFailedListener) Preconditions.a(baseOnConnectionFailedListener), str);
    }

    /* compiled from: source */
    final class b extends com.google.android.gms.internal.common.zzi {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ConnectionResult connectionResult;
            ConnectionResult connectionResult2;
            if (BaseGmsClient.this.c.get() != message.arg1) {
                if (b(message)) {
                    a(message);
                    return;
                }
                return;
            }
            if ((message.what == 1 || message.what == 7 || ((message.what == 4 && !BaseGmsClient.this.q()) || message.what == 5)) && !BaseGmsClient.this.h()) {
                a(message);
                return;
            }
            if (message.what != 4) {
                if (message.what != 5) {
                    if (message.what == 3) {
                        ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, message.obj instanceof PendingIntent ? (PendingIntent) message.obj : null);
                        BaseGmsClient.this.b.a(connectionResult3);
                        BaseGmsClient.this.a(connectionResult3);
                        return;
                    }
                    if (message.what != 6) {
                        if (message.what == 2 && !BaseGmsClient.this.g()) {
                            a(message);
                            return;
                        }
                        if (b(message)) {
                            ((zzc) message.obj).c();
                            return;
                        }
                        int i = message.what;
                        StringBuilder sb = new StringBuilder(45);
                        sb.append("Don't know how to handle message: ");
                        sb.append(i);
                        Log.wtf("GmsClient", sb.toString(), new Exception());
                        return;
                    }
                    BaseGmsClient.this.b(5, null);
                    if (BaseGmsClient.this.x != null) {
                        BaseGmsClient.this.x.a(message.arg2);
                    }
                    BaseGmsClient.this.a(message.arg2);
                    BaseGmsClient.this.a(5, 1, (int) null);
                    return;
                }
                if (BaseGmsClient.this.B == null) {
                    connectionResult = new ConnectionResult(8);
                } else {
                    connectionResult = BaseGmsClient.this.B;
                }
                BaseGmsClient.this.b.a(connectionResult);
                BaseGmsClient.this.a(connectionResult);
                return;
            }
            BaseGmsClient.this.B = new ConnectionResult(message.arg2);
            if (BaseGmsClient.this.y() && !BaseGmsClient.this.C) {
                BaseGmsClient.this.b(3, null);
                return;
            }
            if (BaseGmsClient.this.B == null) {
                connectionResult2 = new ConnectionResult(8);
            } else {
                connectionResult2 = BaseGmsClient.this.B;
            }
            BaseGmsClient.this.b.a(connectionResult2);
            BaseGmsClient.this.a(connectionResult2);
        }

        private static void a(Message message) {
            zzc zzcVar = (zzc) message.obj;
            zzcVar.b();
            zzcVar.d();
        }

        private static boolean b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 7;
        }
    }

    /* compiled from: source */
    protected final class zzg extends a {
        public zzg(int i, Bundle bundle) {
            super(i, null);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.a
        protected final void a(ConnectionResult connectionResult) {
            if (!BaseGmsClient.this.q() || !BaseGmsClient.this.y()) {
                BaseGmsClient.this.b.a(connectionResult);
                BaseGmsClient.this.a(connectionResult);
            } else {
                BaseGmsClient.this.c(16);
            }
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.a
        protected final boolean a() {
            BaseGmsClient.this.b.a(ConnectionResult.a);
            return true;
        }
    }

    /* compiled from: source */
    protected abstract class zzc<TListener> {
        private TListener a;
        private boolean b = false;

        public zzc(TListener tlistener) {
            this.a = tlistener;
        }

        protected abstract void a(TListener tlistener);

        protected abstract void b();

        public final void c() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.a;
                if (this.b) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(47 + String.valueOf(valueOf).length());
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    a(tlistener);
                } catch (RuntimeException e) {
                    b();
                    throw e;
                }
            } else {
                b();
            }
            synchronized (this) {
                this.b = true;
            }
            d();
        }

        public final void d() {
            e();
            synchronized (BaseGmsClient.this.u) {
                BaseGmsClient.this.u.remove(this);
            }
        }

        public final void e() {
            synchronized (this) {
                this.a = null;
            }
        }
    }

    /* compiled from: source */
    @VisibleForTesting
    public final class zzd implements ServiceConnection {
        private final int a;

        public zzd(int i) {
            this.a = i;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IGmsServiceBroker aVar;
            if (iBinder == null) {
                BaseGmsClient.this.c(16);
                return;
            }
            synchronized (BaseGmsClient.this.r) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                if (iBinder == null) {
                    aVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (queryLocalInterface != null && (queryLocalInterface instanceof IGmsServiceBroker)) {
                        aVar = (IGmsServiceBroker) queryLocalInterface;
                    } else {
                        aVar = new IGmsServiceBroker.Stub.a(iBinder);
                    }
                }
                baseGmsClient.s = aVar;
            }
            BaseGmsClient.this.a(0, (Bundle) null, this.a);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (BaseGmsClient.this.r) {
                BaseGmsClient.this.s = null;
            }
            BaseGmsClient.this.a.sendMessage(BaseGmsClient.this.a.obtainMessage(6, this.a, 1));
        }
    }

    /* compiled from: source */
    @VisibleForTesting
    public static final class zze extends IGmsCallbacks.zza {
        private BaseGmsClient a;
        private final int b;

        public zze(BaseGmsClient baseGmsClient, int i) {
            this.a = baseGmsClient;
            this.b = i;
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        public final void a(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        public final void a(int i, IBinder iBinder, Bundle bundle) {
            Preconditions.a(this.a, "onPostInitComplete can be called only once per call to getRemoteService");
            this.a.a(i, iBinder, bundle, this.b);
            this.a = null;
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        public final void a(int i, IBinder iBinder, com.google.android.gms.common.internal.zzc zzcVar) {
            Preconditions.a(this.a, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            Preconditions.a(zzcVar);
            this.a.a(zzcVar);
            a(i, iBinder, zzcVar.a);
        }
    }

    /* compiled from: source */
    protected final class zzf extends a {
        private final IBinder a;

        public zzf(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.a = iBinder;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.a
        protected final void a(ConnectionResult connectionResult) {
            if (BaseGmsClient.this.y != null) {
                BaseGmsClient.this.y.a(connectionResult);
            }
            BaseGmsClient.this.a(connectionResult);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.a
        protected final boolean a() {
            try {
                String interfaceDescriptor = this.a.getInterfaceDescriptor();
                if (!BaseGmsClient.this.c().equals(interfaceDescriptor)) {
                    String c = BaseGmsClient.this.c();
                    StringBuilder sb = new StringBuilder(34 + String.valueOf(c).length() + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(c);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface a = BaseGmsClient.this.a(this.a);
                if (a == null || !(BaseGmsClient.this.a(2, 4, (int) a) || BaseGmsClient.this.a(3, 4, (int) a))) {
                    return false;
                }
                BaseGmsClient.this.B = null;
                Bundle o = BaseGmsClient.this.o();
                if (BaseGmsClient.this.x == null) {
                    return true;
                }
                BaseGmsClient.this.x.a(o);
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    /* compiled from: source */
    private abstract class a extends zzc<Boolean> {
        private final int a;
        private final Bundle b;

        protected a(int i, Bundle bundle) {
            super(true);
            this.a = i;
            this.b = bundle;
        }

        protected abstract void a(ConnectionResult connectionResult);

        protected abstract boolean a();

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zzc
        protected final void b() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zzc
        protected final /* synthetic */ void a(Boolean bool) {
            if (bool != null) {
                int i = this.a;
                if (i == 0) {
                    if (a()) {
                        return;
                    }
                    BaseGmsClient.this.b(1, null);
                    a(new ConnectionResult(8, null));
                    return;
                }
                if (i != 10) {
                    BaseGmsClient.this.b(1, null);
                    a(new ConnectionResult(this.a, this.b != null ? (PendingIntent) this.b.getParcelable("pendingIntent") : null));
                    return;
                } else {
                    BaseGmsClient.this.b(1, null);
                    throw new IllegalStateException(String.format("A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. ", getClass().getSimpleName(), BaseGmsClient.this.a(), BaseGmsClient.this.c()));
                }
            }
            BaseGmsClient.this.b(1, null);
        }
    }

    @VisibleForTesting
    @KeepForSdk
    protected BaseGmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this.k = null;
        this.q = new Object();
        this.r = new Object();
        this.u = new ArrayList<>();
        this.w = 1;
        this.B = null;
        this.C = false;
        this.D = null;
        this.c = new AtomicInteger(0);
        this.m = (Context) Preconditions.a(context, "Context must not be null");
        this.n = (Looper) Preconditions.a(looper, "Looper must not be null");
        this.o = (GmsClientSupervisor) Preconditions.a(gmsClientSupervisor, "Supervisor must not be null");
        this.p = (GoogleApiAvailabilityLight) Preconditions.a(googleApiAvailabilityLight, "API availability must not be null");
        this.a = new b(looper);
        this.z = i;
        this.x = baseConnectionCallbacks;
        this.y = baseOnConnectionFailedListener;
        this.A = str;
    }

    private final String w() {
        return this.A == null ? this.m.getClass().getName() : this.A;
    }

    public final void a(com.google.android.gms.common.internal.zzc zzcVar) {
        this.D = zzcVar;
    }

    @KeepForSdk
    public final Feature[] e() {
        com.google.android.gms.common.internal.zzc zzcVar = this.D;
        if (zzcVar == null) {
            return null;
        }
        return zzcVar.b;
    }

    @KeepForSdk
    protected void a(T t) {
        this.h = System.currentTimeMillis();
    }

    @KeepForSdk
    protected void a(int i) {
        this.f = i;
        this.g = System.currentTimeMillis();
    }

    @KeepForSdk
    protected void a(ConnectionResult connectionResult) {
        this.i = connectionResult.b();
        this.j = System.currentTimeMillis();
    }

    public final void b(int i, T t) {
        zzk zzkVar;
        Preconditions.b((i == 4) == (t != null));
        synchronized (this.q) {
            this.w = i;
            this.t = t;
            a(i, (int) t);
            switch (i) {
                case 1:
                    if (this.v != null) {
                        this.o.a(this.l.a(), this.l.b(), this.l.c(), this.v, w(), this.l.d());
                        this.v = null;
                        break;
                    }
                    break;
                case 2:
                case 3:
                    if (this.v != null && this.l != null) {
                        String a2 = this.l.a();
                        String b2 = this.l.b();
                        StringBuilder sb = new StringBuilder(70 + String.valueOf(a2).length() + String.valueOf(b2).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(a2);
                        sb.append(" on ");
                        sb.append(b2);
                        Log.e("GmsClient", sb.toString());
                        this.o.a(this.l.a(), this.l.b(), this.l.c(), this.v, w(), this.l.d());
                        this.c.incrementAndGet();
                    }
                    this.v = new zzd(this.c.get());
                    if (this.w == 3 && d() != null) {
                        zzkVar = new zzk(j().getPackageName(), d(), true, GmsClientSupervisor.a(), false);
                    } else {
                        zzkVar = new zzk(b(), a(), false, GmsClientSupervisor.a(), v());
                    }
                    this.l = zzkVar;
                    if (this.l.d() && u() < 17895000) {
                        String valueOf = String.valueOf(this.l.a());
                        throw new IllegalStateException(valueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                    }
                    if (!this.o.a(new GmsClientSupervisor.zza(this.l.a(), this.l.b(), this.l.c(), this.l.d()), this.v, w())) {
                        String a3 = this.l.a();
                        String b3 = this.l.b();
                        StringBuilder sb2 = new StringBuilder(34 + String.valueOf(a3).length() + String.valueOf(b3).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(a3);
                        sb2.append(" on ");
                        sb2.append(b3);
                        Log.e("GmsClient", sb2.toString());
                        a(16, (Bundle) null, this.c.get());
                        break;
                    }
                    break;
                case 4:
                    a((BaseGmsClient<T>) t);
                    break;
            }
        }
    }

    public final boolean a(int i, int i2, T t) {
        synchronized (this.q) {
            if (this.w != i) {
                return false;
            }
            b(i2, t);
            return true;
        }
    }

    @KeepForSdk
    public void f() {
        int a2 = this.p.a(this.m, u());
        if (a2 != 0) {
            b(1, null);
            a(new LegacyClientCallbackAdapter(), a2, (PendingIntent) null);
        } else {
            a(new LegacyClientCallbackAdapter());
        }
    }

    @KeepForSdk
    public void a(ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.b = (ConnectionProgressReportCallbacks) Preconditions.a(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        b(2, null);
    }

    @KeepForSdk
    public boolean g() {
        boolean z;
        synchronized (this.q) {
            z = this.w == 4;
        }
        return z;
    }

    @KeepForSdk
    public boolean h() {
        boolean z;
        synchronized (this.q) {
            z = this.w == 2 || this.w == 3;
        }
        return z;
    }

    private final boolean x() {
        boolean z;
        synchronized (this.q) {
            z = this.w == 3;
        }
        return z;
    }

    @KeepForSdk
    public void i() {
        this.c.incrementAndGet();
        synchronized (this.u) {
            int size = this.u.size();
            for (int i = 0; i < size; i++) {
                this.u.get(i).e();
            }
            this.u.clear();
        }
        synchronized (this.r) {
            this.s = null;
        }
        b(1, null);
    }

    @KeepForSdk
    public void b(int i) {
        this.a.sendMessage(this.a.obtainMessage(6, this.c.get(), i));
    }

    public final void c(int i) {
        int i2;
        if (x()) {
            i2 = 5;
            this.C = true;
        } else {
            i2 = 4;
        }
        this.a.sendMessage(this.a.obtainMessage(i2, this.c.get(), 16));
    }

    @VisibleForTesting
    @KeepForSdk
    protected void a(ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i, PendingIntent pendingIntent) {
        this.b = (ConnectionProgressReportCallbacks) Preconditions.a(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.a.sendMessage(this.a.obtainMessage(3, this.c.get(), i, pendingIntent));
    }

    @KeepForSdk
    public final Context j() {
        return this.m;
    }

    @KeepForSdk
    public Feature[] l() {
        return e;
    }

    @KeepForSdk
    protected Bundle m() {
        return new Bundle();
    }

    @KeepForSdk
    protected void a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.a.sendMessage(this.a.obtainMessage(1, i2, -1, new zzf(i, iBinder, bundle)));
    }

    protected final void a(int i, Bundle bundle, int i2) {
        this.a.sendMessage(this.a.obtainMessage(7, i2, -1, new zzg(i, null)));
    }

    @KeepForSdk
    protected final void n() {
        if (!g()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @KeepForSdk
    public final T p() throws DeadObjectException {
        T t;
        synchronized (this.q) {
            if (this.w == 5) {
                throw new DeadObjectException();
            }
            n();
            Preconditions.a(this.t != null, "Client is connected but service is null");
            t = this.t;
        }
        return t;
    }

    @KeepForSdk
    public void a(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        Bundle m = m();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.z);
        getServiceRequest.a = this.m.getPackageName();
        getServiceRequest.d = m;
        if (set != null) {
            getServiceRequest.c = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (r()) {
            getServiceRequest.e = k() != null ? k() : new Account("<<default account>>", "com.google");
            if (iAccountAccessor != null) {
                getServiceRequest.b = iAccountAccessor.asBinder();
            }
        } else if (s()) {
            getServiceRequest.e = k();
        }
        getServiceRequest.f = e;
        getServiceRequest.g = l();
        try {
            try {
                synchronized (this.r) {
                    if (this.s != null) {
                        this.s.a(new zze(this, this.c.get()), getServiceRequest);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                }
            } catch (DeadObjectException e2) {
                Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
                b(3);
            } catch (SecurityException e3) {
                throw e3;
            }
        } catch (RemoteException | RuntimeException e4) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e4);
            a(8, (IBinder) null, (Bundle) null, this.c.get());
        }
    }

    @KeepForSdk
    protected Set<Scope> t() {
        return Collections.emptySet();
    }

    public final boolean y() {
        if (this.C || TextUtils.isEmpty(c()) || TextUtils.isEmpty(d())) {
            return false;
        }
        try {
            Class.forName(c());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @KeepForSdk
    public int u() {
        return GoogleApiAvailabilityLight.a;
    }
}
