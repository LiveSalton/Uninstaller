package com.jumobile.manager.systemapp.c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.jumobile.manager.systemapp.i.b;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public class c implements b.a {
    ArrayList<C0087c> a;
    private int b;
    private int c;
    private final ArrayList<a> d;
    private final ArrayList<b> e;
    private Context f;
    private com.jumobile.manager.systemapp.c.b g;
    private Drawable h;

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.c.c$c */
    public class C0087c {
        Handler a;
        int b;
    }

    @Override // com.jumobile.manager.systemapp.i.b.a
    public boolean a() {
        return false;
    }

    /* compiled from: source */
    class b {
        com.jumobile.manager.systemapp.i.b a;
        String b;

        b() {
        }
    }

    /* compiled from: source */
    class a {
        String a;
        int b;

        public a(String str, int i) {
            this.a = str;
            this.b = i;
        }
    }

    public void a(Handler handler) {
        synchronized (this.a) {
            Iterator<C0087c> it = this.a.iterator();
            while (it.hasNext()) {
                C0087c next = it.next();
                if (next.a == handler) {
                    this.a.remove(next);
                    return;
                }
            }
        }
    }

    private void a(int i, int i2, Object obj) {
        synchronized (this.a) {
            Iterator<C0087c> it = this.a.iterator();
            while (it.hasNext()) {
                C0087c next = it.next();
                next.a.sendMessage(next.a.obtainMessage(next.b, i, i2, obj));
            }
        }
    }

    public Drawable a(String str, int i) {
        Drawable a2;
        if (str == null) {
            return this.h;
        }
        synchronized (this.g) {
            a2 = this.g.a(str);
        }
        if (a2 == null) {
            a2 = this.h;
            b(str, i);
            synchronized (this.e) {
                if (this.e.size() < 3) {
                    b bVar = new b();
                    bVar.a = new com.jumobile.manager.systemapp.i.b(this.f, this);
                    bVar.b = "";
                    this.e.add(bVar);
                    bVar.a.start();
                }
            }
        }
        return a2;
    }

    private void b(String str, int i) {
        synchronized (this.e) {
            Iterator<b> it = this.e.iterator();
            while (it.hasNext()) {
                if (it.next().b.equals(str)) {
                    return;
                }
            }
            synchronized (this.d) {
                Iterator<a> it2 = this.d.iterator();
                while (it2.hasNext()) {
                    if (it2.next().a.equals(str)) {
                        return;
                    }
                }
                this.d.add(new a(str, i));
            }
        }
    }

    @Override // com.jumobile.manager.systemapp.i.b.a
    public synchronized String a(com.jumobile.manager.systemapp.i.b bVar) {
        a aVar;
        synchronized (this.d) {
            aVar = null;
            while (this.d.size() > 0) {
                aVar = this.d.remove(0);
                if (aVar.b >= this.b && aVar.b < this.b + this.c) {
                    break;
                }
            }
        }
        if (aVar == null) {
            return null;
        }
        synchronized (this.e) {
            Iterator<b> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.a == bVar) {
                    next.b = aVar.a;
                    break;
                }
            }
        }
        return aVar.a;
    }

    @Override // com.jumobile.manager.systemapp.i.b.a
    public void a(String str, Drawable drawable) {
        synchronized (this.g) {
            this.g.a(str, drawable);
        }
        a(1, 0, 0);
    }

    @Override // com.jumobile.manager.systemapp.i.b.a
    public void a(com.jumobile.manager.systemapp.i.b bVar, int i) {
        synchronized (this.e) {
            Iterator<b> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.a == bVar) {
                    this.e.remove(next);
                    break;
                }
            }
        }
    }
}
