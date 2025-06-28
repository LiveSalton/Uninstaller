package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.d;

/* compiled from: source */
/* loaded from: classes.dex */
public class MultiInstanceInvalidationService extends Service {
    int a = 0;
    final androidx.b.h<String> b = new androidx.b.h<>();
    final RemoteCallbackList<c> c = new RemoteCallbackList<c>() { // from class: androidx.room.MultiInstanceInvalidationService.1
        AnonymousClass1() {
        }

        @Override // android.os.RemoteCallbackList
        /* renamed from: a */
        public void onCallbackDied(c cVar, Object obj) {
            MultiInstanceInvalidationService.this.b.b(((Integer) obj).intValue());
        }
    };
    private final d.a d = new d.a() { // from class: androidx.room.MultiInstanceInvalidationService.2
        AnonymousClass2() {
        }

        @Override // androidx.room.d
        public int a(c cVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.c) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i = multiInstanceInvalidationService.a + 1;
                multiInstanceInvalidationService.a = i;
                if (MultiInstanceInvalidationService.this.c.register(cVar, Integer.valueOf(i))) {
                    MultiInstanceInvalidationService.this.b.c(i, str);
                    return i;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.a--;
                return 0;
            }
        }

        @Override // androidx.room.d
        public void a(c cVar, int i) {
            synchronized (MultiInstanceInvalidationService.this.c) {
                MultiInstanceInvalidationService.this.c.unregister(cVar);
                MultiInstanceInvalidationService.this.b.b(i);
            }
        }

        @Override // androidx.room.d
        public void a(int i, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.c) {
                String a = MultiInstanceInvalidationService.this.b.a(i);
                if (a == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = MultiInstanceInvalidationService.this.c.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    try {
                        int intValue = ((Integer) MultiInstanceInvalidationService.this.c.getBroadcastCookie(i2)).intValue();
                        String a2 = MultiInstanceInvalidationService.this.b.a(intValue);
                        if (i != intValue && a.equals(a2)) {
                            try {
                                MultiInstanceInvalidationService.this.c.getBroadcastItem(i2).a(strArr);
                            } catch (RemoteException e) {
                                Log.w("ROOM", "Error invoking a remote callback", e);
                            }
                        }
                    } finally {
                        MultiInstanceInvalidationService.this.c.finishBroadcast();
                    }
                }
            }
        }
    };

    /* compiled from: source */
    /* renamed from: androidx.room.MultiInstanceInvalidationService$1 */
    class AnonymousClass1 extends RemoteCallbackList<c> {
        AnonymousClass1() {
        }

        @Override // android.os.RemoteCallbackList
        /* renamed from: a */
        public void onCallbackDied(c cVar, Object obj) {
            MultiInstanceInvalidationService.this.b.b(((Integer) obj).intValue());
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.room.MultiInstanceInvalidationService$2 */
    class AnonymousClass2 extends d.a {
        AnonymousClass2() {
        }

        @Override // androidx.room.d
        public int a(c cVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.c) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i = multiInstanceInvalidationService.a + 1;
                multiInstanceInvalidationService.a = i;
                if (MultiInstanceInvalidationService.this.c.register(cVar, Integer.valueOf(i))) {
                    MultiInstanceInvalidationService.this.b.c(i, str);
                    return i;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.a--;
                return 0;
            }
        }

        @Override // androidx.room.d
        public void a(c cVar, int i) {
            synchronized (MultiInstanceInvalidationService.this.c) {
                MultiInstanceInvalidationService.this.c.unregister(cVar);
                MultiInstanceInvalidationService.this.b.b(i);
            }
        }

        @Override // androidx.room.d
        public void a(int i, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.c) {
                String a = MultiInstanceInvalidationService.this.b.a(i);
                if (a == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = MultiInstanceInvalidationService.this.c.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    try {
                        int intValue = ((Integer) MultiInstanceInvalidationService.this.c.getBroadcastCookie(i2)).intValue();
                        String a2 = MultiInstanceInvalidationService.this.b.a(intValue);
                        if (i != intValue && a.equals(a2)) {
                            try {
                                MultiInstanceInvalidationService.this.c.getBroadcastItem(i2).a(strArr);
                            } catch (RemoteException e) {
                                Log.w("ROOM", "Error invoking a remote callback", e);
                            }
                        }
                    } finally {
                        MultiInstanceInvalidationService.this.c.finishBroadcast();
                    }
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.d;
    }
}
