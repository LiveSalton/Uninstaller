package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.work.h;
import androidx.work.impl.b.j;

/* compiled from: source */
/* loaded from: classes.dex */
public class f implements androidx.work.impl.d {
    private static final String a = h.a("SystemAlarmScheduler");
    private final Context b;

    public f(Context context) {
        this.b = context.getApplicationContext();
    }

    @Override // androidx.work.impl.d
    public void a(j... jVarArr) {
        for (j jVar : jVarArr) {
            a(jVar);
        }
    }

    @Override // androidx.work.impl.d
    public void a(String str) {
        this.b.startService(b.c(this.b, str));
    }

    private void a(j jVar) {
        h.a().b(a, String.format("Scheduling work with workSpecId %s", jVar.a), new Throwable[0]);
        this.b.startService(b.a(this.b, jVar.a));
    }
}
