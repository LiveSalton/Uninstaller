package androidx.work.impl.a.b;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public class g {
    private static g a;
    private a b;
    private b c;
    private e d;
    private f e;

    public static synchronized g a(Context context, androidx.work.impl.utils.b.a aVar) {
        g gVar;
        synchronized (g.class) {
            if (a == null) {
                a = new g(context, aVar);
            }
            gVar = a;
        }
        return gVar;
    }

    private g(Context context, androidx.work.impl.utils.b.a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.b = new a(applicationContext, aVar);
        this.c = new b(applicationContext, aVar);
        this.d = new e(applicationContext, aVar);
        this.e = new f(applicationContext, aVar);
    }

    public a a() {
        return this.b;
    }

    public b b() {
        return this.c;
    }

    public e c() {
        return this.d;
    }

    public f d() {
        return this.e;
    }
}
