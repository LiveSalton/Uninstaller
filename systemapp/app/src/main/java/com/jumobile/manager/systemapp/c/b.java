package com.jumobile.manager.systemapp.c;

import android.graphics.drawable.Drawable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public class b {
    private HashMap<String, a> a;
    private ReferenceQueue<Drawable> b;

    /* compiled from: source */
    private class a extends SoftReference<Drawable> {
        public String a;

        public a(String str, Drawable drawable, ReferenceQueue<Drawable> referenceQueue) {
            super(drawable, referenceQueue);
            this.a = null;
            this.a = str;
        }
    }

    public Drawable a(String str, Drawable drawable) {
        this.a.put(str, new a(str, drawable, this.b));
        return drawable;
    }

    public Drawable a(String str) {
        a();
        if (this.a.containsKey(str)) {
            return this.a.get(str).get();
        }
        return null;
    }

    public void a() {
        while (true) {
            a aVar = (a) this.b.poll();
            if (aVar == null) {
                return;
            } else {
                this.a.remove(aVar.a);
            }
        }
    }
}
