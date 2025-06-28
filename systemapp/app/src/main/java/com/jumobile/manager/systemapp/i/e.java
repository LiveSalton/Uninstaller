package com.jumobile.manager.systemapp.i;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import com.jumobile.manager.systemapp.d.g;
import com.jumobile.manager.systemapp.util.f;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class e extends Thread {
    private static final String a = "e";
    private final Context b;
    private a c;

    /* compiled from: source */
    public interface a {
        void a(int i);

        void c(g gVar);

        boolean i();

        void j();
    }

    public e(Context context, a aVar) {
        this.c = null;
        this.b = context;
        this.c = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        Process.setThreadPriority(10);
        this.c.j();
        List<ApplicationInfo> installedApplications = this.b.getPackageManager().getInstalledApplications(0);
        if (installedApplications == null) {
            this.c.a(2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        String a2 = f.a(this.b);
        if (a2 != null) {
            arrayList.add(a2);
        }
        File file = new File(com.jumobile.manager.systemapp.c.f.a(this.b));
        for (ApplicationInfo applicationInfo : installedApplications) {
            if (this.c.i()) {
                this.c.a(1);
                return;
            }
            if (!arrayList.contains(applicationInfo.packageName) && a(applicationInfo)) {
                g gVar = new g(applicationInfo);
                if (gVar.d(this.b)) {
                    File file2 = new File(file.toString() + "/" + gVar.e(this.b));
                    if (file2.exists()) {
                        try {
                            if (file2.length() == gVar.h) {
                                gVar.d = true;
                            }
                        } catch (Exception unused) {
                        }
                    }
                    this.c.c(gVar);
                }
            }
        }
        this.c.a(0);
    }

    public static boolean a(ApplicationInfo applicationInfo) {
        if (applicationInfo.enabled) {
            return (applicationInfo.flags & 128) != 0 || (applicationInfo.flags & 1) == 0;
        }
        return false;
    }
}
