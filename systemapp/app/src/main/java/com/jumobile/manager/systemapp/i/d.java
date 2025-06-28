package com.jumobile.manager.systemapp.i;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Process;
import com.jumobile.manager.systemapp.d.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class d extends Thread {
    private static final String a = "d";
    private final Context b;
    private a c;

    /* compiled from: source */
    public interface a {
        void a(int i);

        void b(f fVar);

        boolean d();

        void e();
    }

    public d(Context context, a aVar) {
        this.c = null;
        this.b = context;
        this.c = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        int i;
        int i2;
        ArrayList arrayList;
        Iterator<ApplicationInfo> it;
        boolean z;
        super.run();
        Process.setThreadPriority(10);
        this.c.e();
        List<ApplicationInfo> installedApplications = this.b.getPackageManager().getInstalledApplications(0);
        if (installedApplications == null) {
            this.c.a(1);
            return;
        }
        List f = com.jumobile.manager.systemapp.util.f.f(this.b, "systemapp.conf");
        if (f == null) {
            f = new ArrayList();
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        HashMap hashMap = new HashMap();
        Iterator it2 = f.iterator();
        while (true) {
            i = 2;
            if (!it2.hasNext()) {
                break;
            }
            String[] split = ((String) it2.next()).split(";");
            if (split[0].equals("0")) {
                if (split.length >= 2) {
                    arrayList2.add(split[1]);
                }
            } else if (split[0].equals("1")) {
                if (split.length >= 2) {
                    arrayList3.add(split[1]);
                }
                if (split.length >= 3) {
                    hashMap.put(split[1], split[2]);
                }
            } else if (split[0].equals("2")) {
                if (split.length >= 2) {
                    arrayList4.add(split[1]);
                }
                if (split.length >= 3) {
                    hashMap.put(split[1], split[2]);
                }
            } else if (split[0].equals("-1")) {
                if (split.length >= 3) {
                    hashMap.put(split[1], split[2]);
                }
            } else if (split[0].equals("-2")) {
                if (split.length >= 2) {
                    arrayList5.add(split[1]);
                }
            } else if (split[0].equals("-3") && split.length >= 2) {
                arrayList6.add(split[1]);
            }
        }
        String a2 = com.jumobile.manager.systemapp.util.f.a(this.b);
        if (a2 != null) {
            arrayList2.add(a2);
        }
        ArrayList arrayList7 = new ArrayList();
        Iterator it3 = arrayList5.iterator();
        while (true) {
            i2 = 64;
            if (!it3.hasNext()) {
                break;
            }
            try {
                PackageInfo packageInfo = this.b.getPackageManager().getPackageInfo((String) it3.next(), 64);
                if (packageInfo != null && packageInfo.signatures != null) {
                    for (int i3 = 0; i3 < packageInfo.signatures.length; i3++) {
                        arrayList7.add(packageInfo.signatures[i3]);
                    }
                }
            } catch (Exception unused) {
            }
        }
        boolean a3 = com.jumobile.manager.systemapp.f.a.a(this.b, "settings_system_app_hide_core", true);
        Iterator<ApplicationInfo> it4 = installedApplications.iterator();
        while (it4.hasNext()) {
            ApplicationInfo next = it4.next();
            if (this.c.d()) {
                this.c.a(i);
                return;
            }
            if (a(next)) {
                if (!a3 || (!arrayList2.contains(next.packageName) && !arrayList6.contains(next.packageName))) {
                    f fVar = new f(next);
                    if (fVar.a(this.b)) {
                        if (!a3 && arrayList6.contains(next.packageName)) {
                            fVar.a = 60;
                        } else if (!a3 && arrayList2.contains(next.packageName)) {
                            fVar.a = 50;
                        } else if (arrayList3.contains(next.packageName)) {
                            fVar.a = 30;
                        } else if (arrayList4.contains(next.packageName)) {
                            fVar.a = 10;
                        } else {
                            try {
                                PackageInfo packageInfo2 = this.b.getPackageManager().getPackageInfo(fVar.b.packageName, i2);
                                if (packageInfo2 != null && packageInfo2.signatures != null) {
                                    Iterator it5 = arrayList7.iterator();
                                    while (it5.hasNext()) {
                                        Signature signature = (Signature) it5.next();
                                        Signature[] signatureArr = packageInfo2.signatures;
                                        int length = signatureArr.length;
                                        arrayList = arrayList7;
                                        int i4 = 0;
                                        while (true) {
                                            if (i4 >= length) {
                                                it = it4;
                                                z = false;
                                                break;
                                            }
                                            it = it4;
                                            try {
                                                int i5 = length;
                                                if (signatureArr[i4].hashCode() == signature.hashCode()) {
                                                    fVar.a = 40;
                                                    z = true;
                                                    break;
                                                } else {
                                                    i4++;
                                                    it4 = it;
                                                    length = i5;
                                                }
                                            } catch (Exception unused2) {
                                            }
                                        }
                                        if (z) {
                                            break;
                                        }
                                        arrayList7 = arrayList;
                                        it4 = it;
                                    }
                                }
                            } catch (Exception unused3) {
                            }
                        }
                        arrayList = arrayList7;
                        it = it4;
                        fVar.c = (String) hashMap.get(next.packageName);
                        this.c.b(fVar);
                        arrayList7 = arrayList;
                        it4 = it;
                        i2 = 64;
                        i = 2;
                    }
                }
            }
            arrayList = arrayList7;
            it = it4;
            arrayList7 = arrayList;
            it4 = it;
            i2 = 64;
            i = 2;
        }
        this.c.a(0);
    }

    public static boolean a(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) != 0;
    }
}
