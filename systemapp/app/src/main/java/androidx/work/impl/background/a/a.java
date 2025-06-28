package androidx.work.impl.background.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.h;
import androidx.work.impl.a.c;
import androidx.work.impl.b.j;
import androidx.work.impl.d;
import androidx.work.n;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class a implements androidx.work.impl.a, c, d {
    private static final String a = h.a("GreedyScheduler");
    private androidx.work.impl.h b;
    private androidx.work.impl.a.d c;
    private boolean e;
    private List<j> d = new ArrayList();
    private final Object f = new Object();

    public a(Context context, androidx.work.impl.utils.b.a aVar, androidx.work.impl.h hVar) {
        this.b = hVar;
        this.c = new androidx.work.impl.a.d(context, aVar, this);
    }

    @Override // androidx.work.impl.d
    public void a(j... jVarArr) {
        a();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (j jVar : jVarArr) {
            if (jVar.b == n.a.ENQUEUED && !jVar.a() && jVar.g == 0 && !jVar.b()) {
                if (jVar.d()) {
                    if (Build.VERSION.SDK_INT < 24 || !jVar.j.i()) {
                        arrayList.add(jVar);
                        arrayList2.add(jVar.a);
                    }
                } else {
                    h.a().b(a, String.format("Starting work for %s", jVar.a), new Throwable[0]);
                    this.b.b(jVar.a);
                }
            }
        }
        synchronized (this.f) {
            if (!arrayList.isEmpty()) {
                h.a().b(a, String.format("Starting tracking for [%s]", TextUtils.join(",", arrayList2)), new Throwable[0]);
                this.d.addAll(arrayList);
                this.c.a(this.d);
            }
        }
    }

    @Override // androidx.work.impl.d
    public void a(String str) {
        a();
        h.a().b(a, String.format("Cancelling work ID %s", str), new Throwable[0]);
        this.b.c(str);
    }

    @Override // androidx.work.impl.a.c
    public void a(List<String> list) {
        for (String str : list) {
            h.a().b(a, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            this.b.b(str);
        }
    }

    @Override // androidx.work.impl.a.c
    public void b(List<String> list) {
        for (String str : list) {
            h.a().b(a, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.b.c(str);
        }
    }

    @Override // androidx.work.impl.a
    public void a(String str, boolean z) {
        b(str);
    }

    private void b(String str) {
        synchronized (this.f) {
            int size = this.d.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (this.d.get(i).a.equals(str)) {
                    h.a().b(a, String.format("Stopping tracking for %s", str), new Throwable[0]);
                    this.d.remove(i);
                    this.c.a(this.d);
                    break;
                }
                i++;
            }
        }
    }

    private void a() {
        if (this.e) {
            return;
        }
        this.b.f().a(this);
        this.e = true;
    }
}
