package com.jumobile.manager.systemapp.inappbilling.util;

/* compiled from: source */
/* loaded from: classes.dex */
public class c {
    int a;
    String b;

    public c(int i, String str) {
        this.a = i;
        if (str == null || str.trim().length() == 0) {
            this.b = b.a(i);
            return;
        }
        this.b = str + " (response: " + b.a(i) + ")";
    }

    public String a() {
        return this.b;
    }

    public boolean b() {
        return this.a == 0;
    }

    public boolean c() {
        return !b();
    }

    public String toString() {
        return "IabResult: " + a();
    }
}
