package com.jumobile.manager.systemapp.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.jumobile.manager.systemapp.i.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public class e implements d.a {
    private static final String a = "e";
    private final Context b;
    private a g;
    private String i;
    private int c = 1;
    private ArrayList<com.jumobile.manager.systemapp.d.f> d = new ArrayList<>();
    private boolean e = false;
    private com.jumobile.manager.systemapp.i.d f = null;
    private ArrayList<b> h = new ArrayList<>();
    private final Comparator<com.jumobile.manager.systemapp.d.f> j = new Comparator<com.jumobile.manager.systemapp.d.f>() { // from class: com.jumobile.manager.systemapp.c.e.1
        private final Collator b = Collator.getInstance();

        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.f fVar, com.jumobile.manager.systemapp.d.f fVar2) {
            if (fVar.a > fVar2.a) {
                return 1;
            }
            if (fVar.a < fVar2.a) {
                return -1;
            }
            if (fVar.f == null || fVar2.f == null) {
                return fVar.f != null ? -1 : 1;
            }
            return this.b.compare(fVar.f, fVar2.f);
        }
    };
    private final Comparator<com.jumobile.manager.systemapp.d.f> k = new Comparator<com.jumobile.manager.systemapp.d.f>() { // from class: com.jumobile.manager.systemapp.c.e.2
        private final Collator b = Collator.getInstance();

        AnonymousClass2() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.f fVar, com.jumobile.manager.systemapp.d.f fVar2) {
            if (fVar.f == null || fVar2.f == null) {
                return fVar.f != null ? -1 : 1;
            }
            return this.b.compare(fVar.f, fVar2.f);
        }
    };
    private final Comparator<com.jumobile.manager.systemapp.d.f> l = new Comparator<com.jumobile.manager.systemapp.d.f>() { // from class: com.jumobile.manager.systemapp.c.e.3
        private final Collator b = Collator.getInstance();

        AnonymousClass3() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.f fVar, com.jumobile.manager.systemapp.d.f fVar2) {
            if (fVar.h < fVar2.h) {
                return 1;
            }
            if (fVar.h > fVar2.h) {
                return -1;
            }
            if (fVar.f == null || fVar2.f == null) {
                return fVar.f != null ? -1 : 1;
            }
            return this.b.compare(fVar.f, fVar2.f);
        }
    };
    private final Comparator<com.jumobile.manager.systemapp.d.f> m = new Comparator<com.jumobile.manager.systemapp.d.f>() { // from class: com.jumobile.manager.systemapp.c.e.4
        private final Collator b = Collator.getInstance();

        AnonymousClass4() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.f fVar, com.jumobile.manager.systemapp.d.f fVar2) {
            if (fVar.d < fVar2.d) {
                return 1;
            }
            if (fVar.d > fVar2.d) {
                return -1;
            }
            if (fVar.f == null || fVar2.f == null) {
                return fVar.f != null ? -1 : 1;
            }
            return this.b.compare(fVar.f, fVar2.f);
        }
    };
    private final Comparator<com.jumobile.manager.systemapp.d.f> n = new Comparator<com.jumobile.manager.systemapp.d.f>() { // from class: com.jumobile.manager.systemapp.c.e.5
        private final Collator b = Collator.getInstance();

        AnonymousClass5() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.f fVar, com.jumobile.manager.systemapp.d.f fVar2) {
            String a2 = fVar.a();
            String a3 = fVar2.a();
            if (a2 == null || a3 == null) {
                return a2 != null ? -1 : 1;
            }
            return this.b.compare(a2, a3);
        }
    };

    /* compiled from: source */
    public class b {
        Handler a;
        int b;

        public b() {
        }
    }

    public e(Context context) {
        this.b = context;
    }

    protected void finalize() throws Throwable {
        if (this.g != null) {
            this.g.b();
        }
        super.finalize();
    }

    public void a(Handler handler, int i) {
        b bVar = new b();
        bVar.a = handler;
        bVar.b = i;
        synchronized (this.h) {
            this.h.add(bVar);
        }
    }

    public void a(Handler handler) {
        synchronized (this.h) {
            Iterator<b> it = this.h.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next.a == handler) {
                    this.h.remove(next);
                    return;
                }
            }
        }
    }

    public void a() {
        if (this.g != null) {
            this.g.b();
            this.g = null;
        }
        this.e = true;
    }

    public void a(int i, int i2, Object obj) {
        synchronized (this.h) {
            Iterator<b> it = this.h.iterator();
            while (it.hasNext()) {
                b next = it.next();
                next.a.sendMessage(next.a.obtainMessage(next.b, i, i2, obj));
            }
        }
    }

    public void a(String str) {
        this.i = str;
        if (!TextUtils.isEmpty(this.i)) {
            this.i = str.toLowerCase();
        }
        a(2, 0, 0);
    }

    public ArrayList<com.jumobile.manager.systemapp.d.f> b() {
        ArrayList<com.jumobile.manager.systemapp.d.f> arrayList = new ArrayList<>();
        if (1 == this.c) {
            k();
            return arrayList;
        }
        synchronized (this.d) {
            for (int i = 0; i < this.d.size(); i++) {
                if (TextUtils.isEmpty(this.i) || this.d.get(i).f.toLowerCase().contains(this.i)) {
                    arrayList.add(this.d.get(i));
                }
            }
        }
        return arrayList;
    }

    public static String a(Context context) {
        String a2 = com.jumobile.manager.systemapp.f.a.a(context, "settings_system_app_recycle_bin_path", "");
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return Environment.getExternalStorageDirectory().getPath() + "/jumobile/recyclebin/";
    }

    public static String a(Context context, String str) {
        return a(context) + str + ".backup";
    }

    public boolean c() {
        return com.jumobile.manager.systemapp.f.a.a(this.b, "settings_system_app_auto_backup", true);
    }

    public boolean a(com.jumobile.manager.systemapp.d.f fVar) {
        String str = fVar.b.sourceDir;
        com.jumobile.manager.systemapp.h.a.a(str, "RW");
        if ((fVar.b.flags & 128) != 0) {
            com.jumobile.manager.systemapp.h.a.a("pm uninstall " + fVar.b.packageName, 20000L);
            ApplicationInfo applicationInfo = null;
            try {
                applicationInfo = this.b.getPackageManager().getApplicationInfo(fVar.b.packageName, 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (applicationInfo != null) {
                if (c()) {
                    String a2 = a(this.b, new File(applicationInfo.sourceDir).getName());
                    File file = new File(a2);
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    com.jumobile.manager.systemapp.h.a.a(applicationInfo.sourceDir, a2, false, false, fVar.h / 100);
                    b(applicationInfo.sourceDir);
                }
                com.jumobile.manager.systemapp.h.a.a(applicationInfo.sourceDir, false, fVar.h / 1000);
                str = applicationInfo.sourceDir;
                String replace = applicationInfo.sourceDir.replace(".apk", ".odex");
                File file2 = new File(replace);
                if (file2.exists()) {
                    if (c()) {
                        com.jumobile.manager.systemapp.h.a.a(replace, a(this.b, file2.getName()), false, false, fVar.h / 100);
                    }
                    com.jumobile.manager.systemapp.h.a.a(replace, false, fVar.h / 1000);
                }
                com.jumobile.manager.systemapp.h.a.a("pm uninstall " + applicationInfo.packageName, 20000L);
            }
        } else {
            if (c()) {
                String a3 = a(this.b, new File(fVar.b.sourceDir).getName());
                File file3 = new File(a3);
                if (!file3.getParentFile().exists()) {
                    file3.getParentFile().mkdirs();
                }
                com.jumobile.manager.systemapp.h.a.a(fVar.b.sourceDir, a3, false, false, fVar.h / 100);
                b(fVar.b.sourceDir);
            }
            com.jumobile.manager.systemapp.h.a.a(fVar.b.sourceDir, false, fVar.h / 1000);
            str = fVar.b.sourceDir;
            String replace2 = fVar.b.sourceDir.replace(".apk", ".odex");
            File file4 = new File(replace2);
            if (file4.exists()) {
                if (c()) {
                    com.jumobile.manager.systemapp.h.a.a(replace2, a(this.b, file4.getName()), false, false, fVar.h / 100);
                }
                com.jumobile.manager.systemapp.h.a.a(replace2, false, fVar.h / 1000);
            }
            com.jumobile.manager.systemapp.h.a.a("pm uninstall " + fVar.b.packageName, 20000L);
        }
        if (!new File(str).exists()) {
            return true;
        }
        try {
            this.b.getPackageManager().getPackageInfo(fVar.b.packageName, 0);
            return false;
        } catch (PackageManager.NameNotFoundException unused2) {
            return true;
        }
    }

    public void b(String str) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(a(this.b, new File(str).getName().replace(".apk", ".conf")))));
                try {
                    objectOutputStream.writeUTF(str);
                    objectOutputStream.writeInt(com.jumobile.manager.systemapp.h.a.c(str).b());
                } catch (Exception unused) {
                    objectOutputStream2 = objectOutputStream;
                    if (objectOutputStream2 != null) {
                        objectOutputStream2.close();
                    }
                    return;
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream2 = objectOutputStream;
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        } catch (Exception unused4) {
        }
    }

    private void k() {
        if (this.g == null) {
            this.g = new a();
            this.g.a();
        }
        l();
        this.c = 2;
        this.d.clear();
        this.e = false;
        this.f = new com.jumobile.manager.systemapp.i.d(this.b, this);
        this.f.start();
    }

    private void l() {
        if (this.f != null && this.f.isAlive()) {
            this.e = true;
            try {
                this.f.join();
            } catch (InterruptedException unused) {
            }
        }
        this.f = null;
    }

    @Override // com.jumobile.manager.systemapp.i.d.a
    public boolean d() {
        return this.e;
    }

    @Override // com.jumobile.manager.systemapp.i.d.a
    public void e() {
        a(1, 0, 0);
    }

    @Override // com.jumobile.manager.systemapp.i.d.a
    public void b(com.jumobile.manager.systemapp.d.f fVar) {
        synchronized (this.d) {
            this.d.add(fVar);
        }
        a(2, 0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.jumobile.manager.systemapp.i.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r4) {
        /*
            r3 = this;
            r0 = 4
            switch(r4) {
                case 0: goto Le;
                case 1: goto L9;
                case 2: goto L5;
                default: goto L4;
            }
        L4:
            goto L10
        L5:
            r4 = 7
            r3.c = r4
            goto L10
        L9:
            r4 = 8
            r3.c = r4
            goto L10
        Le:
            r3.c = r0
        L10:
            android.content.Context r4 = r3.b
            java.lang.String r1 = "system_app_sort_by"
            int r4 = com.jumobile.manager.systemapp.f.a.a(r4, r1, r0)
            r1 = 6
            if (r4 == r1) goto L2b
            switch(r4) {
                case 1: goto L28;
                case 2: goto L25;
                case 3: goto L22;
                case 4: goto L1f;
                default: goto L1e;
            }
        L1e:
            goto L2d
        L1f:
            java.util.Comparator<com.jumobile.manager.systemapp.d.f> r4 = r3.j
            goto L2f
        L22:
            java.util.Comparator<com.jumobile.manager.systemapp.d.f> r4 = r3.m
            goto L2f
        L25:
            java.util.Comparator<com.jumobile.manager.systemapp.d.f> r4 = r3.l
            goto L2f
        L28:
            java.util.Comparator<com.jumobile.manager.systemapp.d.f> r4 = r3.k
            goto L2f
        L2b:
            java.util.Comparator<com.jumobile.manager.systemapp.d.f> r4 = r3.n
        L2d:
            java.util.Comparator<com.jumobile.manager.systemapp.d.f> r4 = r3.j
        L2f:
            java.util.ArrayList<com.jumobile.manager.systemapp.d.f> r1 = r3.d
            monitor-enter(r1)
            java.util.ArrayList<com.jumobile.manager.systemapp.d.f> r2 = r3.d     // Catch: java.lang.Throwable -> L44
            java.util.Collections.sort(r2, r4)     // Catch: java.lang.Throwable -> L44
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L44
            r4 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r3.a(r0, r4, r1)
            r4 = 0
            r3.f = r4
            return
        L44:
            r4 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L44
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumobile.manager.systemapp.c.e.a(int):void");
    }

    /* compiled from: source */
    private class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(e eVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        void a() {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
            intentFilter.addDataScheme("package");
            e.this.b.registerReceiver(this, intentFilter);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE");
            intentFilter2.addAction("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE");
            e.this.b.registerReceiver(this, intentFilter2);
        }

        void b() {
            e.this.b.unregisterReceiver(this);
            androidx.f.a.a.a(e.this.b).a(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String[] stringArrayExtra;
            String action = intent.getAction();
            if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                e.this.c(intent.getData().getEncodedSchemeSpecificPart());
                e.this.a(2, 0, 0);
                return;
            }
            if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                e.this.d(intent.getData().getEncodedSchemeSpecificPart());
                e.this.a(2, 0, 0);
                return;
            }
            if ("android.intent.action.PACKAGE_CHANGED".equals(action)) {
                String encodedSchemeSpecificPart = intent.getData().getEncodedSchemeSpecificPart();
                e.this.c(encodedSchemeSpecificPart);
                e.this.d(encodedSchemeSpecificPart);
                e.this.a(2, 0, 0);
                return;
            }
            if ((!"android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE".equals(action) && !"android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE".equals(action)) || (stringArrayExtra = intent.getStringArrayExtra("android.intent.extra.changed_package_list")) == null || stringArrayExtra.length == 0) {
                return;
            }
            if ("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE".equals(action)) {
                for (String str : stringArrayExtra) {
                    e.this.d(str);
                    e.this.c(str);
                }
            }
            e.this.a(2, 0, 0);
        }
    }

    void c(String str) {
        try {
            ApplicationInfo applicationInfo = this.b.getPackageManager().getApplicationInfo(str, 8704);
            if ((applicationInfo.flags & 1) != 0) {
                com.jumobile.manager.systemapp.d.f fVar = new com.jumobile.manager.systemapp.d.f(applicationInfo);
                if (fVar.a(this.b)) {
                    fVar.a = 0;
                    synchronized (this.d) {
                        this.d.add(fVar);
                        Collections.sort(this.d, this.j);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    void d(String str) {
        synchronized (this.d) {
            Iterator<com.jumobile.manager.systemapp.d.f> it = this.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.jumobile.manager.systemapp.d.f next = it.next();
                if (next.b.packageName.equals(str)) {
                    this.d.remove(next);
                    break;
                }
            }
        }
    }

    public void f() {
        a(this.j);
    }

    public void g() {
        a(this.k);
    }

    public void h() {
        a(this.l);
    }

    public void i() {
        a(this.m);
    }

    public void j() {
        a(this.n);
    }

    private void a(Comparator<com.jumobile.manager.systemapp.d.f> comparator) {
        synchronized (this.d) {
            Collections.sort(this.d, comparator);
        }
        a(2, 0, 0);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.c.e$1 */
    class AnonymousClass1 implements Comparator<com.jumobile.manager.systemapp.d.f> {
        private final Collator b = Collator.getInstance();

        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.f fVar, com.jumobile.manager.systemapp.d.f fVar2) {
            if (fVar.a > fVar2.a) {
                return 1;
            }
            if (fVar.a < fVar2.a) {
                return -1;
            }
            if (fVar.f == null || fVar2.f == null) {
                return fVar.f != null ? -1 : 1;
            }
            return this.b.compare(fVar.f, fVar2.f);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.c.e$2 */
    class AnonymousClass2 implements Comparator<com.jumobile.manager.systemapp.d.f> {
        private final Collator b = Collator.getInstance();

        AnonymousClass2() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.f fVar, com.jumobile.manager.systemapp.d.f fVar2) {
            if (fVar.f == null || fVar2.f == null) {
                return fVar.f != null ? -1 : 1;
            }
            return this.b.compare(fVar.f, fVar2.f);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.c.e$3 */
    class AnonymousClass3 implements Comparator<com.jumobile.manager.systemapp.d.f> {
        private final Collator b = Collator.getInstance();

        AnonymousClass3() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.f fVar, com.jumobile.manager.systemapp.d.f fVar2) {
            if (fVar.h < fVar2.h) {
                return 1;
            }
            if (fVar.h > fVar2.h) {
                return -1;
            }
            if (fVar.f == null || fVar2.f == null) {
                return fVar.f != null ? -1 : 1;
            }
            return this.b.compare(fVar.f, fVar2.f);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.c.e$4 */
    class AnonymousClass4 implements Comparator<com.jumobile.manager.systemapp.d.f> {
        private final Collator b = Collator.getInstance();

        AnonymousClass4() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.f fVar, com.jumobile.manager.systemapp.d.f fVar2) {
            if (fVar.d < fVar2.d) {
                return 1;
            }
            if (fVar.d > fVar2.d) {
                return -1;
            }
            if (fVar.f == null || fVar2.f == null) {
                return fVar.f != null ? -1 : 1;
            }
            return this.b.compare(fVar.f, fVar2.f);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.c.e$5 */
    class AnonymousClass5 implements Comparator<com.jumobile.manager.systemapp.d.f> {
        private final Collator b = Collator.getInstance();

        AnonymousClass5() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.f fVar, com.jumobile.manager.systemapp.d.f fVar2) {
            String a2 = fVar.a();
            String a3 = fVar2.a();
            if (a2 == null || a3 == null) {
                return a2 != null ? -1 : 1;
            }
            return this.b.compare(a2, a3);
        }
    }

    public boolean a(com.jumobile.manager.systemapp.d.f fVar, String str) throws IOException {
        String str2 = fVar.b.sourceDir;
        String str3 = str + "/" + fVar.c(this.b);
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        if (fVar.b.sourceDir.contains("app-private")) {
            return a(str2, str3);
        }
        boolean a2 = com.jumobile.manager.systemapp.util.a.a(str2, str3);
        return !a2 ? a(str2, str3) : a2;
    }

    private boolean a(String str, String str2) {
        return com.jumobile.manager.systemapp.h.a.a(str, str2, false, false, new File(str).length() / 100);
    }
}
