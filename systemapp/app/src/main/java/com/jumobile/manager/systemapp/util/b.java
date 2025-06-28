package com.jumobile.manager.systemapp.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public class b {
    private final Context a;
    private HashMap<com.jumobile.manager.systemapp.d.c, a> b = new HashMap<>();
    private ReferenceQueue<Drawable> c = new ReferenceQueue<>();

    /* compiled from: source */
    private class a extends SoftReference<Drawable> {
        public com.jumobile.manager.systemapp.d.c a;

        public a(com.jumobile.manager.systemapp.d.c cVar, Drawable drawable, ReferenceQueue<Drawable> referenceQueue) {
            super(drawable, referenceQueue);
            this.a = null;
            this.a = cVar;
        }
    }

    public b(Context context) {
        this.a = context;
    }

    public Drawable a(com.jumobile.manager.systemapp.d.c cVar) {
        Drawable b = cVar.b(this.a);
        this.b.put(cVar, new a(cVar, b, this.c));
        return b;
    }

    public Drawable b(com.jumobile.manager.systemapp.d.c cVar) {
        a();
        Drawable drawable = this.b.containsKey(cVar) ? this.b.get(cVar).get() : null;
        return drawable == null ? a(cVar) : drawable;
    }

    public void a() {
        while (true) {
            a aVar = (a) this.c.poll();
            if (aVar == null) {
                return;
            } else {
                this.b.remove(aVar.a);
            }
        }
    }
}
