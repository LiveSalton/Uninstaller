package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.c;
import androidx.room.d;
import androidx.room.f;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: source */
/* loaded from: classes.dex */
class g {
    Context a;
    final String b;
    int c;
    final f d;
    final f.b e;
    d f;
    final Executor g;
    final c h = new c.a() { // from class: androidx.room.g.1
        AnonymousClass1() {
        }

        /* compiled from: source */
        /* renamed from: androidx.room.g$1$1 */
        class RunnableC00461 implements Runnable {
            final /* synthetic */ String[] a;

            RunnableC00461(String[] strArr) {
                strArr = strArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.d.a(strArr);
            }
        }

        @Override // androidx.room.c
        public void a(String[] strArr) {
            g.this.g.execute(new Runnable() { // from class: androidx.room.g.1.1
                final /* synthetic */ String[] a;

                RunnableC00461(String[] strArr2) {
                    strArr = strArr2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    g.this.d.a(strArr);
                }
            });
        }
    };
    final AtomicBoolean i = new AtomicBoolean(false);
    final ServiceConnection j = new ServiceConnection() { // from class: androidx.room.g.2
        AnonymousClass2() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            g.this.f = d.a.a(iBinder);
            g.this.g.execute(g.this.k);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            g.this.g.execute(g.this.l);
            g.this.f = null;
            g.this.a = null;
        }
    };
    final Runnable k = new Runnable() { // from class: androidx.room.g.3
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d dVar = g.this.f;
                if (dVar != null) {
                    g.this.c = dVar.a(g.this.h, g.this.b);
                    g.this.d.a(g.this.e);
                }
            } catch (RemoteException e) {
                Log.w("ROOM", "Cannot register multi-instance invalidation callback", e);
            }
        }
    };
    final Runnable l = new Runnable() { // from class: androidx.room.g.4
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.d.b(g.this.e);
        }
    };
    private final Runnable m = new Runnable() { // from class: androidx.room.g.5
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.d.b(g.this.e);
            try {
                d dVar = g.this.f;
                if (dVar != null) {
                    dVar.a(g.this.h, g.this.c);
                }
            } catch (RemoteException e) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e);
            }
            if (g.this.a != null) {
                g.this.a.unbindService(g.this.j);
                g.this.a = null;
            }
        }
    };

    /* compiled from: source */
    /* renamed from: androidx.room.g$1 */
    class AnonymousClass1 extends c.a {
        AnonymousClass1() {
        }

        /* compiled from: source */
        /* renamed from: androidx.room.g$1$1 */
        class RunnableC00461 implements Runnable {
            final /* synthetic */ String[] a;

            RunnableC00461(String[] strArr2) {
                strArr = strArr2;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.d.a(strArr);
            }
        }

        @Override // androidx.room.c
        public void a(String[] strArr2) {
            g.this.g.execute(new Runnable() { // from class: androidx.room.g.1.1
                final /* synthetic */ String[] a;

                RunnableC00461(String[] strArr22) {
                    strArr = strArr22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    g.this.d.a(strArr);
                }
            });
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.room.g$2 */
    class AnonymousClass2 implements ServiceConnection {
        AnonymousClass2() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            g.this.f = d.a.a(iBinder);
            g.this.g.execute(g.this.k);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            g.this.g.execute(g.this.l);
            g.this.f = null;
            g.this.a = null;
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.room.g$3 */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d dVar = g.this.f;
                if (dVar != null) {
                    g.this.c = dVar.a(g.this.h, g.this.b);
                    g.this.d.a(g.this.e);
                }
            } catch (RemoteException e) {
                Log.w("ROOM", "Cannot register multi-instance invalidation callback", e);
            }
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.room.g$4 */
    class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.d.b(g.this.e);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.room.g$5 */
    class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.d.b(g.this.e);
            try {
                d dVar = g.this.f;
                if (dVar != null) {
                    dVar.a(g.this.h, g.this.c);
                }
            } catch (RemoteException e) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e);
            }
            if (g.this.a != null) {
                g.this.a.unbindService(g.this.j);
                g.this.a = null;
            }
        }
    }

    g(Context context, String str, f fVar, Executor executor) {
        this.a = context.getApplicationContext();
        this.b = str;
        this.d = fVar;
        this.g = executor;
        this.e = new f.b(fVar.b) { // from class: androidx.room.g.6
            @Override // androidx.room.f.b
            boolean a() {
                return true;
            }

            AnonymousClass6(String[] strArr) {
                super(strArr);
            }

            @Override // androidx.room.f.b
            public void a(Set<String> set) {
                if (g.this.i.get()) {
                    return;
                }
                try {
                    g.this.f.a(g.this.c, (String[]) set.toArray(new String[0]));
                } catch (RemoteException e) {
                    Log.w("ROOM", "Cannot broadcast invalidation", e);
                }
            }
        };
        this.a.bindService(new Intent(this.a, (Class<?>) MultiInstanceInvalidationService.class), this.j, 1);
    }

    /* compiled from: source */
    /* renamed from: androidx.room.g$6 */
    class AnonymousClass6 extends f.b {
        @Override // androidx.room.f.b
        boolean a() {
            return true;
        }

        AnonymousClass6(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.f.b
        public void a(Set<String> set) {
            if (g.this.i.get()) {
                return;
            }
            try {
                g.this.f.a(g.this.c, (String[]) set.toArray(new String[0]));
            } catch (RemoteException e) {
                Log.w("ROOM", "Cannot broadcast invalidation", e);
            }
        }
    }
}
