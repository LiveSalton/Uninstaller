package androidx.work.impl;

import android.content.Context;
import androidx.work.WorkerParameters;
import androidx.work.impl.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/* compiled from: source */
/* loaded from: classes.dex */
public class c implements androidx.work.impl.a {
    private static final String a = androidx.work.h.a("Processor");
    private Context b;
    private androidx.work.b c;
    private androidx.work.impl.utils.b.a d;
    private WorkDatabase e;
    private List<d> g;
    private Map<String, i> f = new HashMap();
    private Set<String> h = new HashSet();
    private final List<androidx.work.impl.a> i = new ArrayList();
    private final Object j = new Object();

    public c(Context context, androidx.work.b bVar, androidx.work.impl.utils.b.a aVar, WorkDatabase workDatabase, List<d> list) {
        this.b = context;
        this.c = bVar;
        this.d = aVar;
        this.e = workDatabase;
        this.g = list;
    }

    public boolean a(String str) {
        return a(str, (WorkerParameters.a) null);
    }

    public boolean a(String str, WorkerParameters.a aVar) {
        synchronized (this.j) {
            if (this.f.containsKey(str)) {
                androidx.work.h.a().b(a, String.format("Work %s is already enqueued for processing", str), new Throwable[0]);
                return false;
            }
            i a2 = new i.a(this.b, this.c, this.d, this.e, str).a(this.g).a(aVar).a();
            com.google.a.a.a.a<Boolean> a3 = a2.a();
            a3.a(new a(this, str, a3), this.d.a());
            this.f.put(str, a2);
            this.d.b().execute(a2);
            androidx.work.h.a().b(a, String.format("%s: processing %s", getClass().getSimpleName(), str), new Throwable[0]);
            return true;
        }
    }

    public boolean b(String str) {
        synchronized (this.j) {
            androidx.work.h.a().b(a, String.format("Processor stopping %s", str), new Throwable[0]);
            i remove = this.f.remove(str);
            if (remove != null) {
                remove.a(false);
                androidx.work.h.a().b(a, String.format("WorkerWrapper stopped for %s", str), new Throwable[0]);
                return true;
            }
            androidx.work.h.a().b(a, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
            return false;
        }
    }

    public boolean c(String str) {
        synchronized (this.j) {
            androidx.work.h.a().b(a, String.format("Processor cancelling %s", str), new Throwable[0]);
            this.h.add(str);
            i remove = this.f.remove(str);
            if (remove != null) {
                remove.a(true);
                androidx.work.h.a().b(a, String.format("WorkerWrapper cancelled for %s", str), new Throwable[0]);
                return true;
            }
            androidx.work.h.a().b(a, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
            return false;
        }
    }

    public boolean d(String str) {
        boolean contains;
        synchronized (this.j) {
            contains = this.h.contains(str);
        }
        return contains;
    }

    public boolean e(String str) {
        boolean containsKey;
        synchronized (this.j) {
            containsKey = this.f.containsKey(str);
        }
        return containsKey;
    }

    public void a(androidx.work.impl.a aVar) {
        synchronized (this.j) {
            this.i.add(aVar);
        }
    }

    public void b(androidx.work.impl.a aVar) {
        synchronized (this.j) {
            this.i.remove(aVar);
        }
    }

    @Override // androidx.work.impl.a
    public void a(String str, boolean z) {
        synchronized (this.j) {
            this.f.remove(str);
            androidx.work.h.a().b(a, String.format("%s %s executed; reschedule = %s", getClass().getSimpleName(), str, Boolean.valueOf(z)), new Throwable[0]);
            Iterator<androidx.work.impl.a> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().a(str, z);
            }
        }
    }

    /* compiled from: source */
    private static class a implements Runnable {
        private androidx.work.impl.a a;
        private String b;
        private com.google.a.a.a.a<Boolean> c;

        a(androidx.work.impl.a aVar, String str, com.google.a.a.a.a<Boolean> aVar2) {
            this.a = aVar;
            this.b = str;
            this.c = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            try {
                z = this.c.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.a.a(this.b, z);
        }
    }
}
