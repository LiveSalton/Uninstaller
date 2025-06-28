package androidx.work.impl;

import android.text.TextUtils;
import androidx.work.k;
import androidx.work.m;
import androidx.work.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public class f extends m {
    private static final String a = androidx.work.h.a("WorkContinuationImpl");
    private final h b;
    private final String c;
    private final androidx.work.f d;
    private final List<? extends p> e;
    private final List<String> f;
    private final List<String> g;
    private final List<f> h;
    private boolean i;
    private k j;

    public h a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public androidx.work.f c() {
        return this.d;
    }

    public List<? extends p> d() {
        return this.e;
    }

    public List<String> e() {
        return this.f;
    }

    public boolean f() {
        return this.i;
    }

    public void g() {
        this.i = true;
    }

    public List<f> h() {
        return this.h;
    }

    f(h hVar, List<? extends p> list) {
        this(hVar, null, androidx.work.f.KEEP, list, null);
    }

    f(h hVar, String str, androidx.work.f fVar, List<? extends p> list, List<f> list2) {
        this.b = hVar;
        this.c = str;
        this.d = fVar;
        this.e = list;
        this.h = list2;
        this.f = new ArrayList(this.e.size());
        this.g = new ArrayList();
        if (list2 != null) {
            Iterator<f> it = list2.iterator();
            while (it.hasNext()) {
                this.g.addAll(it.next().g);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String a2 = list.get(i).a();
            this.f.add(a2);
            this.g.add(a2);
        }
    }

    public k i() {
        if (!this.i) {
            androidx.work.impl.utils.b bVar = new androidx.work.impl.utils.b(this);
            this.b.g().a(bVar);
            this.j = bVar.a();
        } else {
            androidx.work.h.a().d(a, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.f)), new Throwable[0]);
        }
        return this.j;
    }

    public boolean j() {
        return a(this, new HashSet());
    }

    private static boolean a(f fVar, Set<String> set) {
        set.addAll(fVar.e());
        Set<String> a2 = a(fVar);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (a2.contains(it.next())) {
                return true;
            }
        }
        List<f> h = fVar.h();
        if (h != null && !h.isEmpty()) {
            Iterator<f> it2 = h.iterator();
            while (it2.hasNext()) {
                if (a(it2.next(), set)) {
                    return true;
                }
            }
        }
        set.removeAll(fVar.e());
        return false;
    }

    public static Set<String> a(f fVar) {
        HashSet hashSet = new HashSet();
        List<f> h = fVar.h();
        if (h != null && !h.isEmpty()) {
            Iterator<f> it = h.iterator();
            while (it.hasNext()) {
                hashSet.addAll(it.next().e());
            }
        }
        return hashSet;
    }
}
