package com.jumobile.manager.systemapp.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.widget.Toast;
import androidx.core.app.h;
import com.jumobile.manager.systemapp.R;
import com.jumobile.manager.systemapp.service.a;
import com.jumobile.manager.systemapp.service.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public class DownloadService extends Service implements a.InterfaceC0092a {
    private Context d;
    private NotificationManager e;
    private final HashMap<Integer, b> b = new HashMap<>();
    private final HashMap<Integer, b> c = new HashMap<>();
    final c a = new c();

    /* compiled from: source */
    class b {
        boolean a;
        DownloadEntry b;
        com.jumobile.manager.systemapp.service.a d;
        public PendingIntent g;
        public String h;
        public PendingIntent i;
        ArrayList<com.jumobile.manager.systemapp.service.b> c = new ArrayList<>();
        boolean e = false;
        boolean f = false;

        b() {
        }

        private void a() {
            if (this.f) {
                DownloadService.this.a.sendMessage(DownloadService.this.a.obtainMessage(1, this));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            synchronized (this.c) {
                Iterator<com.jumobile.manager.systemapp.service.b> it = this.c.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().a(this.b);
                    } catch (RemoteException unused) {
                    }
                }
            }
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            synchronized (this.c) {
                Iterator<com.jumobile.manager.systemapp.service.b> it = this.c.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().b(this.b);
                    } catch (RemoteException unused) {
                    }
                }
            }
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            synchronized (this.c) {
                Iterator<com.jumobile.manager.systemapp.service.b> it = this.c.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().a(this.b, i);
                    } catch (RemoteException unused) {
                    }
                }
            }
            a();
            if (this.i != null) {
                try {
                    this.i.send();
                } catch (Exception unused2) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(com.jumobile.manager.systemapp.service.b bVar) {
            if (bVar == null) {
                return;
            }
            synchronized (this.c) {
                Iterator<com.jumobile.manager.systemapp.service.b> it = this.c.iterator();
                while (it.hasNext()) {
                    com.jumobile.manager.systemapp.service.b next = it.next();
                    if (next.asBinder() == next.asBinder()) {
                        return;
                    }
                }
                this.c.add(bVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(com.jumobile.manager.systemapp.service.b bVar) {
            synchronized (this.c) {
                Iterator<com.jumobile.manager.systemapp.service.b> it = this.c.iterator();
                while (it.hasNext()) {
                    com.jumobile.manager.systemapp.service.b next = it.next();
                    if (next.asBinder() == next.asBinder()) {
                        this.c.remove(next);
                        return;
                    }
                }
                this.c.add(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(DownloadEntry downloadEntry) {
        synchronized (this.b) {
            Iterator<Map.Entry<Integer, b>> it = this.b.entrySet().iterator();
            while (it.hasNext()) {
                b value = it.next().getValue();
                if (value.b.a(downloadEntry)) {
                    return value.b.e;
                }
            }
            synchronized (this.c) {
                Iterator<Map.Entry<Integer, b>> it2 = this.c.entrySet().iterator();
                while (it2.hasNext()) {
                    b value2 = it2.next().getValue();
                    if (value2.b.a(downloadEntry)) {
                        return value2.b.e;
                    }
                }
                return -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b d(int i) {
        b bVar = this.b.get(Integer.valueOf(i));
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = this.c.get(Integer.valueOf(i));
        if (bVar2 != null) {
            return bVar2;
        }
        return null;
    }

    /* compiled from: source */
    private class a extends c.a {
        private a() {
        }

        @Override // com.jumobile.manager.systemapp.service.c
        public int a(DownloadEntry downloadEntry, com.jumobile.manager.systemapp.service.b bVar) throws RemoteException {
            int a = DownloadService.this.a(downloadEntry);
            if (-1 != a) {
                return a;
            }
            com.jumobile.manager.systemapp.service.a aVar = new com.jumobile.manager.systemapp.service.a(DownloadService.this.d, downloadEntry, DownloadService.this);
            int a2 = aVar.a();
            b bVar2 = DownloadService.this.new b();
            bVar2.a = false;
            bVar2.d = aVar;
            bVar2.b = downloadEntry;
            bVar2.b.e = a2;
            bVar2.b.g = 1;
            bVar2.a(bVar);
            bVar2.b();
            if (DownloadService.this.c.size() < 3) {
                DownloadService.this.c.put(Integer.valueOf(a2), bVar2);
                aVar.start();
            } else {
                DownloadService.this.b.put(Integer.valueOf(a2), bVar2);
            }
            return a2;
        }

        @Override // com.jumobile.manager.systemapp.service.c
        public int a(DownloadEntry downloadEntry) throws RemoteException {
            int a = DownloadService.this.a(downloadEntry);
            if (-1 == a) {
                return a;
            }
            b bVar = (b) DownloadService.this.b.remove(Integer.valueOf(a));
            if (bVar == null) {
                b bVar2 = (b) DownloadService.this.c.get(Integer.valueOf(a));
                if (bVar2 == null) {
                    return -1;
                }
                bVar2.a = true;
                bVar2.b.g = 5;
                bVar2.b();
                return a;
            }
            bVar.a(2);
            return a;
        }

        @Override // com.jumobile.manager.systemapp.service.c
        public int b(DownloadEntry downloadEntry) throws RemoteException {
            int a = DownloadService.this.a(downloadEntry);
            if (-1 == a) {
                return a;
            }
            b bVar = (b) DownloadService.this.b.remove(Integer.valueOf(a));
            if (bVar == null) {
                b bVar2 = (b) DownloadService.this.c.get(Integer.valueOf(a));
                if (bVar2 == null) {
                    return -1;
                }
                bVar2.a = true;
                bVar2.e = true;
                bVar2.b.g = 5;
                bVar2.b();
                return a;
            }
            bVar.b.g();
            bVar.a(2);
            return a;
        }

        @Override // com.jumobile.manager.systemapp.service.c
        public DownloadEntry b(DownloadEntry downloadEntry, com.jumobile.manager.systemapp.service.b bVar) throws RemoteException {
            b d;
            int a = DownloadService.this.a(downloadEntry);
            if (-1 == a || (d = DownloadService.this.d(a)) == null) {
                return null;
            }
            d.a(bVar);
            return d.b;
        }

        @Override // com.jumobile.manager.systemapp.service.c
        public int c(DownloadEntry downloadEntry, com.jumobile.manager.systemapp.service.b bVar) throws RemoteException {
            int a = DownloadService.this.a(downloadEntry);
            if (-1 == a) {
                return a;
            }
            b bVar2 = (b) DownloadService.this.b.get(Integer.valueOf(a));
            if (bVar2 == null) {
                b bVar3 = (b) DownloadService.this.c.get(Integer.valueOf(a));
                if (bVar3 != null) {
                    bVar3.b(bVar);
                }
                return a;
            }
            bVar2.b(bVar);
            return a;
        }

        @Override // com.jumobile.manager.systemapp.service.c
        public DownloadEntry c(DownloadEntry downloadEntry) throws RemoteException {
            b d;
            int a = DownloadService.this.a(downloadEntry);
            if (-1 == a || (d = DownloadService.this.d(a)) == null) {
                return null;
            }
            return d.b;
        }

        @Override // com.jumobile.manager.systemapp.service.c
        public int a(DownloadEntry downloadEntry, boolean z, String str, PendingIntent pendingIntent) throws RemoteException {
            int a = DownloadService.this.a(downloadEntry);
            if (-1 != a) {
                b d = DownloadService.this.d(a);
                d.f = z;
                d.h = str;
                d.g = pendingIntent;
            }
            return a;
        }

        @Override // com.jumobile.manager.systemapp.service.c
        public int a(DownloadEntry downloadEntry, PendingIntent pendingIntent) throws RemoteException {
            int a = DownloadService.this.a(downloadEntry);
            if (-1 != a) {
                DownloadService.this.d(a).i = pendingIntent;
            }
            return a;
        }
    }

    @Override // com.jumobile.manager.systemapp.service.a.InterfaceC0092a
    public boolean a(int i) {
        b bVar = this.c.get(Integer.valueOf(i));
        if (bVar != null) {
            return bVar.a;
        }
        return true;
    }

    @Override // com.jumobile.manager.systemapp.service.a.InterfaceC0092a
    public void b(int i) {
        b bVar = this.c.get(Integer.valueOf(i));
        if (bVar != null) {
            bVar.b.e();
            bVar.b();
        }
    }

    @Override // com.jumobile.manager.systemapp.service.a.InterfaceC0092a
    public void c(int i) {
        b bVar = this.c.get(Integer.valueOf(i));
        if (bVar != null) {
            bVar.b.f();
            bVar.b();
        }
    }

    @Override // com.jumobile.manager.systemapp.service.a.InterfaceC0092a
    public void a(int i, long j, long j2) {
        b bVar = this.c.get(Integer.valueOf(i));
        if (bVar != null) {
            bVar.b.a(j, j2);
            bVar.c();
        }
    }

    @Override // com.jumobile.manager.systemapp.service.a.InterfaceC0092a
    public void a(int i, int i2) {
        b remove = this.c.remove(Integer.valueOf(i));
        if (remove != null) {
            if (remove.e) {
                remove.b.g();
            } else {
                remove.b.a(i2);
            }
            remove.a(i2);
        }
        if (!this.b.isEmpty()) {
            Iterator<Integer> it = this.b.keySet().iterator();
            if (it.hasNext()) {
                int intValue = it.next().intValue();
                b remove2 = this.b.remove(Integer.valueOf(intValue));
                if (remove2 != null) {
                    this.c.put(Integer.valueOf(intValue), remove2);
                    remove2.d.start();
                }
            }
        }
        if (this.c.isEmpty()) {
            stopSelf();
        }
    }

    /* compiled from: source */
    class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 3) {
                    return;
                }
                Toast.makeText(DownloadService.this.d, message.arg1, 0).show();
                return;
            }
            b bVar = (b) message.obj;
            switch (bVar.b.g) {
                case 0:
                case 5:
                case 6:
                    DownloadService.this.e.cancel(1000 + bVar.b.e);
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 7:
                    DownloadService.this.e.notify(bVar.h, 1000 + bVar.b.e, new h.c(DownloadService.this.d).a(R.drawable.ic_launcher).a(bVar.h).b(bVar.b.a(DownloadService.this.d)).a(bVar.g).a(true).a(100, bVar.b.a(), false).a(0L).c(bVar.b.h()).b());
                    break;
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new a();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.d = getApplicationContext();
        this.e = (NotificationManager) getSystemService("notification");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }
}
