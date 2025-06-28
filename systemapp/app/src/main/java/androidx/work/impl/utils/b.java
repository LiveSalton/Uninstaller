package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.e;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.j;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.k;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class b implements Runnable {
    private static final String a = androidx.work.h.a("EnqueueRunnable");
    private final androidx.work.impl.f b;
    private final androidx.work.impl.b c = new androidx.work.impl.b();

    public b(androidx.work.impl.f fVar) {
        this.b = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.b.j()) {
                throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.b));
            }
            if (b()) {
                d.a(this.b.a().b(), RescheduleReceiver.class, true);
                c();
            }
            this.c.a(k.a);
        } catch (Throwable th) {
            this.c.a(new k.a.C0053a(th));
        }
    }

    public k a() {
        return this.c;
    }

    public boolean b() {
        WorkDatabase c = this.b.a().c();
        c.g();
        try {
            boolean a2 = a(this.b);
            c.j();
            return a2;
        } finally {
            c.h();
        }
    }

    public void c() {
        androidx.work.impl.h a2 = this.b.a();
        androidx.work.impl.e.a(a2.d(), a2.c(), a2.e());
    }

    private static boolean a(androidx.work.impl.f fVar) {
        List<androidx.work.impl.f> h = fVar.h();
        boolean z = false;
        if (h != null) {
            boolean z2 = false;
            for (androidx.work.impl.f fVar2 : h) {
                if (!fVar2.f()) {
                    z2 |= a(fVar2);
                } else {
                    androidx.work.h.a().d(a, String.format("Already enqueued work ids (%s).", TextUtils.join(", ", fVar2.e())), new Throwable[0]);
                }
            }
            z = z2;
        }
        return b(fVar) | z;
    }

    private static boolean b(androidx.work.impl.f fVar) {
        boolean a2 = a(fVar.a(), fVar.d(), (String[]) androidx.work.impl.f.a(fVar).toArray(new String[0]), fVar.b(), fVar.c());
        fVar.g();
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b1 A[LOOP:4: B:87:0x01ab->B:89:0x01b1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01da A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(androidx.work.impl.h r19, java.util.List<? extends androidx.work.p> r20, java.lang.String[] r21, java.lang.String r22, androidx.work.f r23) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.b.a(androidx.work.impl.h, java.util.List, java.lang.String[], java.lang.String, androidx.work.f):boolean");
    }

    private static void a(j jVar) {
        androidx.work.c cVar = jVar.j;
        if (cVar.d() || cVar.e()) {
            String str = jVar.c;
            e.a aVar = new e.a();
            aVar.a(jVar.e).a("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            jVar.c = ConstraintTrackingWorker.class.getName();
            jVar.e = aVar.a();
        }
    }

    private static boolean a(androidx.work.impl.h hVar, String str) {
        try {
            Class<?> cls = Class.forName(str);
            Iterator<androidx.work.impl.d> it = hVar.e().iterator();
            while (it.hasNext()) {
                if (cls.isAssignableFrom(it.next().getClass())) {
                    return true;
                }
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
