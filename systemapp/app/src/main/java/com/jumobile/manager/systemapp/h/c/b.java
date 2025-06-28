package com.jumobile.manager.systemapp.h.c;

/* compiled from: source */
/* loaded from: classes.dex */
public class b extends a {
    private StringBuilder l;

    @Override // com.jumobile.manager.systemapp.h.c.a
    public void a(int i, int i2) {
    }

    @Override // com.jumobile.manager.systemapp.h.c.a
    public void b(int i, String str) {
    }

    public b(int i, String... strArr) {
        super(i, strArr);
        this.l = new StringBuilder();
    }

    public b(int i, boolean z, String... strArr) {
        super(i, z, strArr);
        this.l = new StringBuilder();
    }

    @Override // com.jumobile.manager.systemapp.h.c.a
    public void a(int i, String str) {
        StringBuilder sb = this.l;
        sb.append(str);
        sb.append('\n');
        com.jumobile.manager.systemapp.h.a.b("Command", "ID: " + i + ", " + str);
    }

    public String toString() {
        return this.l.toString();
    }
}
