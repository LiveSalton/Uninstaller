package androidx.work.impl.a;

import android.content.Context;
import androidx.work.h;
import androidx.work.impl.a.a.c;
import androidx.work.impl.a.a.e;
import androidx.work.impl.a.a.f;
import androidx.work.impl.a.a.g;
import androidx.work.impl.b.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class d implements c.a {
    private static final String a = h.a("WorkConstraintsTracker");
    private final c b;
    private final androidx.work.impl.a.a.c<?>[] c;
    private final Object d;

    public d(Context context, androidx.work.impl.utils.b.a aVar, c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.b = cVar;
        this.c = new androidx.work.impl.a.a.c[]{new androidx.work.impl.a.a.a(applicationContext, aVar), new androidx.work.impl.a.a.b(applicationContext, aVar), new androidx.work.impl.a.a.h(applicationContext, aVar), new androidx.work.impl.a.a.d(applicationContext, aVar), new g(applicationContext, aVar), new f(applicationContext, aVar), new e(applicationContext, aVar)};
        this.d = new Object();
    }

    public void a(List<j> list) {
        synchronized (this.d) {
            for (androidx.work.impl.a.a.c<?> cVar : this.c) {
                cVar.a((c.a) null);
            }
            for (androidx.work.impl.a.a.c<?> cVar2 : this.c) {
                cVar2.a(list);
            }
            for (androidx.work.impl.a.a.c<?> cVar3 : this.c) {
                cVar3.a((c.a) this);
            }
        }
    }

    public void a() {
        synchronized (this.d) {
            for (androidx.work.impl.a.a.c<?> cVar : this.c) {
                cVar.a();
            }
        }
    }

    public boolean a(String str) {
        synchronized (this.d) {
            for (androidx.work.impl.a.a.c<?> cVar : this.c) {
                if (cVar.a(str)) {
                    h.a().b(a, String.format("Work %s constrained by %s", str, cVar.getClass().getSimpleName()), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    @Override // androidx.work.impl.a.a.c.a
    public void b(List<String> list) {
        synchronized (this.d) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (a(str)) {
                    h.a().b(a, String.format("Constraints met for %s", str), new Throwable[0]);
                    arrayList.add(str);
                }
            }
            if (this.b != null) {
                this.b.a(arrayList);
            }
        }
    }

    @Override // androidx.work.impl.a.a.c.a
    public void c(List<String> list) {
        synchronized (this.d) {
            if (this.b != null) {
                this.b.b(list);
            }
        }
    }
}
