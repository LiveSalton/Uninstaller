package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.i;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
class h {
    private final CopyOnWriteArrayList<a> a = new CopyOnWriteArrayList<>();
    private final i b;

    /* compiled from: source */
    private static final class a {
        final i.a a;
        final boolean b;
    }

    h(i iVar) {
        this.b = iVar;
    }

    void a(Fragment fragment, Context context, boolean z) {
        Fragment l = this.b.l();
        if (l != null) {
            l.q().z().a(fragment, context, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.a(this.b, fragment, context);
            }
        }
    }

    void b(Fragment fragment, Context context, boolean z) {
        Fragment l = this.b.l();
        if (l != null) {
            l.q().z().b(fragment, context, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.b(this.b, fragment, context);
            }
        }
    }

    void a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment l = this.b.l();
        if (l != null) {
            l.q().z().a(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.a(this.b, fragment, bundle);
            }
        }
    }

    void b(Fragment fragment, Bundle bundle, boolean z) {
        Fragment l = this.b.l();
        if (l != null) {
            l.q().z().b(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.b(this.b, fragment, bundle);
            }
        }
    }

    void c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment l = this.b.l();
        if (l != null) {
            l.q().z().c(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.c(this.b, fragment, bundle);
            }
        }
    }

    void a(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment l = this.b.l();
        if (l != null) {
            l.q().z().a(fragment, view, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.a(this.b, fragment, view, bundle);
            }
        }
    }

    void a(Fragment fragment, boolean z) {
        Fragment l = this.b.l();
        if (l != null) {
            l.q().z().a(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.a(this.b, fragment);
            }
        }
    }

    void b(Fragment fragment, boolean z) {
        Fragment l = this.b.l();
        if (l != null) {
            l.q().z().b(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.b(this.b, fragment);
            }
        }
    }

    void c(Fragment fragment, boolean z) {
        Fragment l = this.b.l();
        if (l != null) {
            l.q().z().c(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.c(this.b, fragment);
            }
        }
    }

    void d(Fragment fragment, boolean z) {
        Fragment l = this.b.l();
        if (l != null) {
            l.q().z().d(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.d(this.b, fragment);
            }
        }
    }

    void d(Fragment fragment, Bundle bundle, boolean z) {
        Fragment l = this.b.l();
        if (l != null) {
            l.q().z().d(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.d(this.b, fragment, bundle);
            }
        }
    }

    void e(Fragment fragment, boolean z) {
        Fragment l = this.b.l();
        if (l != null) {
            l.q().z().e(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.e(this.b, fragment);
            }
        }
    }

    void f(Fragment fragment, boolean z) {
        Fragment l = this.b.l();
        if (l != null) {
            l.q().z().f(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.f(this.b, fragment);
            }
        }
    }

    void g(Fragment fragment, boolean z) {
        Fragment l = this.b.l();
        if (l != null) {
            l.q().z().g(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                next.a.g(this.b, fragment);
            }
        }
    }
}
