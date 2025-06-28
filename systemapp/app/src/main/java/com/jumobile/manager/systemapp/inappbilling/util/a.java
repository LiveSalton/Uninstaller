package com.jumobile.manager.systemapp.inappbilling.util;

/* compiled from: source */
/* loaded from: classes.dex */
public class a extends Exception {
    c a;

    public a(c cVar) {
        this(cVar, (Exception) null);
    }

    public a(int i, String str) {
        this(new c(i, str));
    }

    public a(c cVar, Exception exc) {
        super(cVar.a(), exc);
        this.a = cVar;
    }

    public a(int i, String str, Exception exc) {
        this(new c(i, str), exc);
    }

    public c a() {
        return this.a;
    }
}
