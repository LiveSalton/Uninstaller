package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.h;
import androidx.work.impl.b.j;
import androidx.work.impl.background.systemalarm.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
class c {
    private static final String a = h.a("ConstraintsCmdHandler");
    private final Context b;
    private final int c;
    private final e d;
    private final androidx.work.impl.a.d e;

    c(Context context, int i, e eVar) {
        this.b = context;
        this.c = i;
        this.d = eVar;
        this.e = new androidx.work.impl.a.d(this.b, this.d.e(), null);
    }

    void a() {
        List<j> c = this.d.d().c().o().c();
        ConstraintProxy.a(this.b, c);
        this.e.a(c);
        ArrayList arrayList = new ArrayList(c.size());
        long currentTimeMillis = System.currentTimeMillis();
        for (j jVar : c) {
            String str = jVar.a;
            if (currentTimeMillis >= jVar.c() && (!jVar.d() || this.e.a(str))) {
                arrayList.add(jVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = ((j) it.next()).a;
            Intent b = b.b(this.b, str2);
            h.a().b(a, String.format("Creating a delay_met command for workSpec with id (%s)", str2), new Throwable[0]);
            this.d.a(new e.a(this.d, b, this.c));
        }
        this.e.a();
    }
}
