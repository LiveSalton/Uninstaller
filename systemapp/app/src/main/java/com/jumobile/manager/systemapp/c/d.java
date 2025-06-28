package com.jumobile.manager.systemapp.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.jumobile.manager.systemapp.i.c;
import java.io.File;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public class d implements c.a {
    private static final String b = "d";
    private final Context c;
    private int d = 1;
    private ArrayList<com.jumobile.manager.systemapp.d.e> e = new ArrayList<>();
    private boolean f = false;
    private com.jumobile.manager.systemapp.i.c g = null;
    private a h = null;
    ArrayList<b> a = new ArrayList<>();
    private final Comparator<com.jumobile.manager.systemapp.d.e> i = new Comparator<com.jumobile.manager.systemapp.d.e>() { // from class: com.jumobile.manager.systemapp.c.d.1
        private final Collator b = Collator.getInstance();

        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.e eVar, com.jumobile.manager.systemapp.d.e eVar2) {
            if (eVar.f == null || eVar2.f == null) {
                return eVar.f != null ? -1 : 1;
            }
            return this.b.compare(eVar.f, eVar2.f);
        }
    };

    public static String e() {
        return "/system/app/";
    }

    /* compiled from: source */
    public class b {
        Handler a;
        int b;

        public b() {
        }
    }

    public d(Context context) {
        this.c = context;
    }

    protected void finalize() throws Throwable {
        if (this.h != null) {
            this.h.b();
            this.h = null;
        }
        super.finalize();
    }

    public void a(Handler handler, int i) {
        b bVar = new b();
        bVar.a = handler;
        bVar.b = i;
        synchronized (this.a) {
            this.a.add(bVar);
        }
    }

    public void a(Handler handler) {
        synchronized (this.a) {
            Iterator<b> it = this.a.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next.a == handler) {
                    this.a.remove(next);
                    return;
                }
            }
        }
    }

    public void a() {
        if (this.h != null) {
            this.h.b();
            this.h = null;
        }
        this.f = true;
    }

    public void a(int i, int i2, Object obj) {
        synchronized (this.a) {
            Iterator<b> it = this.a.iterator();
            while (it.hasNext()) {
                b next = it.next();
                next.a.sendMessage(next.a.obtainMessage(next.b, i, i2, obj));
            }
        }
    }

    public void a(int i, int i2, Object obj, long j) {
        synchronized (this.a) {
            Iterator<b> it = this.a.iterator();
            while (it.hasNext()) {
                b next = it.next();
                next.a.sendMessageDelayed(next.a.obtainMessage(next.b, i, i2, obj), j);
            }
        }
    }

    public void b() {
        d();
        a(2, 0, 0);
    }

    public ArrayList<com.jumobile.manager.systemapp.d.e> c() {
        ArrayList<com.jumobile.manager.systemapp.d.e> arrayList = new ArrayList<>();
        if (1 == this.d) {
            h();
            return arrayList;
        }
        synchronized (this.e) {
            for (int i = 0; i < this.e.size(); i++) {
                arrayList.add(this.e.get(i));
            }
        }
        return arrayList;
    }

    public void d() {
        synchronized (this.e) {
            this.e.clear();
        }
        i();
        this.d = 1;
    }

    public void a(com.jumobile.manager.systemapp.d.e eVar) {
        new File(eVar.a).delete();
        File file = new File(eVar.a.replace(".apk", ".odex"));
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(eVar.a.replace(".apk", ".conf"));
        if (file2.exists()) {
            file2.delete();
        }
        synchronized (this.e) {
            this.e.remove(eVar);
        }
        a(2, 0, 0);
    }

    public static String a(String str) {
        return e() + str;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(com.jumobile.manager.systemapp.d.e r21) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumobile.manager.systemapp.c.d.b(com.jumobile.manager.systemapp.d.e):void");
    }

    private void h() {
        if (this.h == null) {
            this.h = new a();
            this.h.a();
        }
        i();
        this.d = 2;
        this.e.clear();
        this.f = false;
        this.g = new com.jumobile.manager.systemapp.i.c(this.c, this);
        this.g.start();
    }

    private void i() {
        if (this.g != null && this.g.isAlive()) {
            this.f = true;
            try {
                this.g.join();
            } catch (InterruptedException unused) {
            }
        }
        this.g = null;
    }

    @Override // com.jumobile.manager.systemapp.i.c.a
    public boolean f() {
        return this.f;
    }

    @Override // com.jumobile.manager.systemapp.i.c.a
    public void g() {
        a(1, 0, 0);
    }

    @Override // com.jumobile.manager.systemapp.i.c.a
    public void c(com.jumobile.manager.systemapp.d.e eVar) {
        synchronized (this.e) {
            this.e.add(eVar);
        }
        a(2, 0, 0);
    }

    @Override // com.jumobile.manager.systemapp.i.c.a
    public void a(int i) {
        if (i == 0) {
            this.d = 4;
        } else if (i == 2) {
            this.d = 7;
        } else if (i == 9) {
            this.d = 9;
        }
        synchronized (this.e) {
            Collections.sort(this.e, this.i);
        }
        a(4, 0, 0);
        this.g = null;
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.c.d$1 */
    class AnonymousClass1 implements Comparator<com.jumobile.manager.systemapp.d.e> {
        private final Collator b = Collator.getInstance();

        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.e eVar, com.jumobile.manager.systemapp.d.e eVar2) {
            if (eVar.f == null || eVar2.f == null) {
                return eVar.f != null ? -1 : 1;
            }
            return this.b.compare(eVar.f, eVar2.f);
        }
    }

    /* compiled from: source */
    private class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(d dVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        void a() {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
            intentFilter.addDataScheme("package");
            d.this.c.registerReceiver(this, intentFilter);
            IntentFilter intentFilter2 = new IntentFilter("android.intent.action.MEDIA_MOUNTED");
            intentFilter2.addAction("android.intent.action.MEDIA_UNMOUNTED");
            intentFilter2.addAction("android.intent.action.MEDIA_SHARED");
            intentFilter2.addAction("android.intent.action.MEDIA_EJECT");
            intentFilter2.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
            intentFilter2.addDataScheme("file");
            d.this.c.registerReceiver(this, intentFilter2);
        }

        void b() {
            d.this.c.unregisterReceiver(this);
            androidx.f.a.a.a(d.this.c).a(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_SHARED".equals(action) || "android.intent.action.MEDIA_EJECT".equals(action) || "android.intent.action.MEDIA_BAD_REMOVAL".equals(action)) {
                d.this.d();
                d.this.a(2, 0, 0);
            } else if ("android.intent.action.MEDIA_MOUNTED".equals(action)) {
                d.this.d();
                d.this.a(2, 0, (Object) 0, 1000L);
            } else if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                d.this.b(intent.getData().getEncodedSchemeSpecificPart());
                d.this.a(2, 0, 0);
            }
        }
    }

    void b(String str) {
        synchronized (this.e) {
            Iterator<com.jumobile.manager.systemapp.d.e> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.jumobile.manager.systemapp.d.e next = it.next();
                if (next.b.equals(str)) {
                    a(next);
                    break;
                }
            }
        }
    }
}
