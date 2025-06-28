package com.jumobile.manager.systemapp.i;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import java.io.File;

/* compiled from: source */
/* loaded from: classes.dex */
public class c extends Thread {
    private static final String a = "c";
    private final Context b;
    private a c;

    /* compiled from: source */
    public interface a {
        void a(int i);

        void c(com.jumobile.manager.systemapp.d.e eVar);

        boolean f();

        void g();
    }

    public c(Context context, a aVar) {
        this.c = null;
        this.b = context;
        this.c = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        File[] listFiles;
        File[] listFiles2;
        File[] listFiles3;
        super.run();
        Process.setThreadPriority(10);
        this.c.g();
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            this.c.a(9);
            return;
        }
        String str = Environment.getExternalStorageDirectory().getPath() + "/ljmobile/recyclebin/";
        File file = new File(str);
        if (file.exists() && (listFiles3 = file.listFiles()) != null) {
            for (File file2 : listFiles3) {
                if (this.c.f()) {
                    this.c.a(2);
                    return;
                }
                if (file2.isFile() && file2.getName().endsWith(".apk.backup")) {
                    com.jumobile.manager.systemapp.d.e eVar = new com.jumobile.manager.systemapp.d.e(file2.getPath());
                    if (eVar.a(this.b)) {
                        this.c.c(eVar);
                    }
                }
            }
        }
        String str2 = Environment.getExternalStorageDirectory().getPath() + "/jumobile/recyclebin/";
        File file3 = new File(str2);
        if (file3.exists() && (listFiles2 = file3.listFiles()) != null) {
            for (File file4 : listFiles2) {
                if (this.c.f()) {
                    this.c.a(2);
                    return;
                }
                if (file4.isFile() && file4.getName().endsWith(".apk.backup")) {
                    com.jumobile.manager.systemapp.d.e eVar2 = new com.jumobile.manager.systemapp.d.e(file4.getPath());
                    if (eVar2.a(this.b)) {
                        this.c.c(eVar2);
                    }
                }
            }
        }
        String a2 = com.jumobile.manager.systemapp.c.e.a(this.b);
        File file5 = new File(a2);
        if (!a2.equals(str) && !a2.equals(str2) && file5.exists() && (listFiles = file5.listFiles()) != null) {
            for (File file6 : listFiles) {
                if (this.c.f()) {
                    this.c.a(2);
                    return;
                }
                if (file6.isFile() && file6.getName().endsWith(".apk.backup")) {
                    com.jumobile.manager.systemapp.d.e eVar3 = new com.jumobile.manager.systemapp.d.e(file6.getPath());
                    if (eVar3.a(this.b)) {
                        this.c.c(eVar3);
                    }
                }
            }
        }
        this.c.a(0);
    }
}
