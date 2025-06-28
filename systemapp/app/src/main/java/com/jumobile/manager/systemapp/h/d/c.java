package com.jumobile.manager.systemapp.h.d;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public class c {
    public boolean a(String str, String str2) {
        if (str.endsWith("/") && !str.equals("/")) {
            str = str.substring(0, str.lastIndexOf("/"));
        }
        String str3 = str;
        boolean z = false;
        while (!z) {
            try {
                Iterator<com.jumobile.manager.systemapp.h.a.a> it = com.jumobile.manager.systemapp.h.a.a().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.jumobile.manager.systemapp.h.a.a next = it.next();
                    com.jumobile.manager.systemapp.h.a.e(next.b().toString());
                    if (str3.equals(next.b().toString())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    try {
                        str3 = new File(str3).getParent();
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }
            } catch (Exception e2) {
                if (com.jumobile.manager.systemapp.h.a.a) {
                    e2.printStackTrace();
                }
                return false;
            }
        }
        com.jumobile.manager.systemapp.h.a.a a = a(str3);
        com.jumobile.manager.systemapp.h.a.b("RootTools v3.0", "Remounting " + a.b().getAbsolutePath() + " as " + str2.toLowerCase());
        if (!a.c().contains(str2.toLowerCase())) {
            try {
                com.jumobile.manager.systemapp.h.c.b bVar = new com.jumobile.manager.systemapp.h.c.b(0, true, "busybox mount -o remount," + str2.toLowerCase() + " " + a.a().getAbsolutePath() + " " + a.b().getAbsolutePath(), "toolbox mount -o remount," + str2.toLowerCase() + " " + a.a().getAbsolutePath() + " " + a.b().getAbsolutePath(), "mount -o remount," + str2.toLowerCase() + " " + a.a().getAbsolutePath() + " " + a.b().getAbsolutePath(), "/system/bin/toolbox mount -o remount," + str2.toLowerCase() + " " + a.a().getAbsolutePath() + " " + a.b().getAbsolutePath());
                com.jumobile.manager.systemapp.h.c.c.h().a(bVar);
                a(bVar, 10000L);
            } catch (Exception unused) {
            }
            a = a(str3);
        }
        Log.i("RootTools v3.0", a.c() + " AND " + str2.toLowerCase());
        if (a.c().contains(str2.toLowerCase())) {
            com.jumobile.manager.systemapp.h.a.e(a.c().toString());
            return true;
        }
        com.jumobile.manager.systemapp.h.a.e(a.c().toString());
        return false;
    }

    private com.jumobile.manager.systemapp.h.a.a a(String str) {
        try {
            ArrayList<com.jumobile.manager.systemapp.h.a.a> a = com.jumobile.manager.systemapp.h.a.a();
            File file = new File(str);
            while (file != null) {
                Iterator<com.jumobile.manager.systemapp.h.a.a> it = a.iterator();
                while (it.hasNext()) {
                    com.jumobile.manager.systemapp.h.a.a next = it.next();
                    if (next.b().equals(file)) {
                        return next;
                    }
                }
            }
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e2) {
            if (com.jumobile.manager.systemapp.h.a.a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    private void a(com.jumobile.manager.systemapp.h.c.a aVar, long j) {
        synchronized (aVar) {
            try {
                aVar.wait(j);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
