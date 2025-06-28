package androidx.work.impl.a.a;

import android.content.Context;
import android.os.Build;
import androidx.work.i;
import androidx.work.impl.b.j;

/* compiled from: source */
/* loaded from: classes.dex */
public class e extends c<androidx.work.impl.a.b> {
    private static final String a = androidx.work.h.a("NetworkMeteredCtrlr");

    public e(Context context, androidx.work.impl.utils.b.a aVar) {
        super(androidx.work.impl.a.b.g.a(context, aVar).c());
    }

    @Override // androidx.work.impl.a.a.c
    boolean a(j jVar) {
        return jVar.j.a() == i.METERED;
    }

    @Override // androidx.work.impl.a.a.c
    /* renamed from: a */
    public boolean b(androidx.work.impl.a.b bVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            return (bVar.a() && bVar.c()) ? false : true;
        }
        androidx.work.h.a().b(a, "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
        return !bVar.a();
    }
}
