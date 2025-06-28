package com.jumobile.manager.systemapp.util;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class e {
    private static final String a = "e";
    private static e b;
    private Thread d;
    private Context e;
    private Runnable f = new Runnable() { // from class: com.jumobile.manager.systemapp.util.e.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (e.this.c.size() == 0) {
                    Process.killProcess(Process.myPid());
                }
            } catch (Exception unused) {
            }
        }
    };
    private List<a> c = new ArrayList();

    /* compiled from: source */
    public static class a {
        public String a;

        public a(String str) {
            this.a = str;
        }
    }

    public static final synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (b == null) {
                b = new e(context);
            }
            eVar = b;
        }
        return eVar;
    }

    private e(Context context) {
        this.e = context.getApplicationContext();
    }

    public synchronized void a(String str) {
        this.c.add(new a(str));
    }

    public synchronized void b(String str) {
        Iterator<a> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next.a.equals(str)) {
                this.c.remove(next);
                break;
            }
        }
        a();
    }

    private synchronized void a() {
        b();
        if (this.c.size() == 0) {
            if (this.d != null) {
                this.d.interrupt();
            }
            this.d = new Thread(this.f);
            this.d.start();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.util.e$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (e.this.c.size() == 0) {
                    Process.killProcess(Process.myPid());
                }
            } catch (Exception unused) {
            }
        }
    }

    private void b() {
        for (a aVar : this.c) {
            Log.d(a, "activated entry: " + aVar.a);
        }
    }
}
