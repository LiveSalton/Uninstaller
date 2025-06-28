package com.jumobile.manager.systemapp.c;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.jumobile.manager.systemapp.d.g;
import com.jumobile.manager.systemapp.i.e;
import java.io.File;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public class f implements e.a {
    private static final String c = "f";
    private final Context d;
    private a i;
    private String k;
    private ArrayList<g> e = new ArrayList<>();
    private int f = 1;
    private boolean g = false;
    private com.jumobile.manager.systemapp.i.e h = null;
    ArrayList<b> a = new ArrayList<>();
    private boolean j = false;
    public final Comparator<g> b = new Comparator<g>() { // from class: com.jumobile.manager.systemapp.c.f.1
        private final Collator b = Collator.getInstance();

        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(g gVar, g gVar2) {
            if (gVar.a(f.this.d) != gVar2.a(f.this.d)) {
                return gVar.a(f.this.d) == g.l ? -1 : 1;
            }
            if (gVar.f == null || gVar2.f == null) {
                return gVar.f != null ? -1 : 1;
            }
            return this.b.compare(gVar.f, gVar2.f);
        }
    };
    private final Comparator<g> l = new Comparator<g>() { // from class: com.jumobile.manager.systemapp.c.f.2
        private final Collator b = Collator.getInstance();

        AnonymousClass2() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(g gVar, g gVar2) {
            if (gVar.f == null || gVar2.f == null) {
                return gVar.f != null ? -1 : 1;
            }
            return this.b.compare(gVar.f, gVar2.f);
        }
    };
    private final Comparator<g> m = new Comparator<g>() { // from class: com.jumobile.manager.systemapp.c.f.3
        private final Collator b = Collator.getInstance();

        AnonymousClass3() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(g gVar, g gVar2) {
            if (gVar.h < gVar2.h) {
                return 1;
            }
            if (gVar.h > gVar2.h) {
                return -1;
            }
            if (gVar.f == null || gVar2.f == null) {
                return gVar.f != null ? -1 : 1;
            }
            return this.b.compare(gVar.f, gVar2.f);
        }
    };
    private final Comparator<g> n = new Comparator<g>() { // from class: com.jumobile.manager.systemapp.c.f.4
        private final Collator b = Collator.getInstance();

        AnonymousClass4() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(g gVar, g gVar2) {
            if (gVar.c < gVar2.c) {
                return 1;
            }
            if (gVar.c > gVar2.c) {
                return -1;
            }
            if (gVar.f == null || gVar2.f == null) {
                return gVar.f != null ? -1 : 1;
            }
            return this.b.compare(gVar.f, gVar2.f);
        }
    };
    private final Comparator<g> o = new Comparator<g>() { // from class: com.jumobile.manager.systemapp.c.f.5
        private final Collator b = Collator.getInstance();

        AnonymousClass5() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(g gVar, g gVar2) {
            String d = gVar.d();
            String d2 = gVar2.d();
            if (d == null || d2 == null) {
                return d != null ? -1 : 1;
            }
            return this.b.compare(d, d2);
        }
    };

    /* compiled from: source */
    public class b {
        Handler a;
        int b;

        public b() {
        }
    }

    public f(Context context) {
        this.d = context;
    }

    public void a(boolean z) {
        this.j = z;
    }

    protected void finalize() throws Throwable {
        if (this.i != null) {
            this.i.b();
        }
        super.finalize();
    }

    public void a(Handler handler, int i) {
        b bVar = new b();
        bVar.a = handler;
        bVar.b = i;
        synchronized (this.a) {
            this.a.add(bVar);
        }
    }

    public void a(Handler handler) {
        synchronized (this.a) {
            Iterator<b> it = this.a.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next.a == handler) {
                    this.a.remove(next);
                    return;
                }
            }
        }
    }

    public void a() {
        if (this.i != null) {
            this.i.b();
            this.i = null;
        }
        this.g = true;
    }

    public void a(int i, int i2, Object obj) {
        synchronized (this.a) {
            Iterator<b> it = this.a.iterator();
            while (it.hasNext()) {
                b next = it.next();
                next.a.sendMessage(next.a.obtainMessage(next.b, i, i2, obj));
            }
        }
    }

    public void a(String str) {
        this.k = str;
        if (!TextUtils.isEmpty(this.k)) {
            this.k = str.toLowerCase();
        }
        a(2, 0, (Object) 0);
    }

    public ArrayList<g> b() {
        ArrayList<g> arrayList = new ArrayList<>();
        if (1 == this.f) {
            k();
            return arrayList;
        }
        synchronized (this.e) {
            for (int i = 0; i < this.e.size(); i++) {
                if (TextUtils.isEmpty(this.k) || this.e.get(i).f.toLowerCase().contains(this.k)) {
                    arrayList.add(this.e.get(i));
                }
            }
        }
        return arrayList;
    }

    public boolean a(g gVar, String str) throws IOException {
        String str2 = gVar.b.sourceDir;
        String str3 = str + "/" + gVar.e(this.d);
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        if (gVar.b.sourceDir.contains("app-private")) {
            return a(str2, str3);
        }
        boolean a2 = com.jumobile.manager.systemapp.util.a.a(str2, str3);
        return !a2 ? a(str2, str3) : a2;
    }

    private boolean a(String str, String str2) {
        return com.jumobile.manager.systemapp.h.a.a(str, str2, false, false, new File(str).length() / 100);
    }

    public void a(g gVar, Activity activity, int i) {
        Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:" + gVar.b.packageName));
        intent.addFlags(268435456);
        try {
            activity.startActivityForResult(intent, i);
        } catch (Exception unused) {
        }
    }

    public void a(g gVar) {
        try {
            if (Build.VERSION.SDK_INT >= 9) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", gVar.b.packageName, null));
                intent.setFlags(276824064);
                try {
                    this.d.startActivity(intent);
                } catch (Exception unused) {
                    intent.setAction("android.intent.action.VIEW");
                    intent.setClassName("com.android.settings", "com.android.settings.applications.InstalledAppDetails");
                    this.d.startActivity(intent);
                }
            } else {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                intent2.putExtra("pkg", gVar.b.packageName);
                intent2.addFlags(268435456);
                this.d.startActivity(intent2);
            }
        } catch (Exception unused2) {
        }
    }

    public boolean b(g gVar) {
        return com.jumobile.manager.systemapp.util.f.j(this.d, gVar.b.packageName);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.c.f$1 */
    class AnonymousClass1 implements Comparator<g> {
        private final Collator b = Collator.getInstance();

        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(g gVar, g gVar2) {
            if (gVar.a(f.this.d) != gVar2.a(f.this.d)) {
                return gVar.a(f.this.d) == g.l ? -1 : 1;
            }
            if (gVar.f == null || gVar2.f == null) {
                return gVar.f != null ? -1 : 1;
            }
            return this.b.compare(gVar.f, gVar2.f);
        }
    }

    public void c() {
        l();
    }

    public void d() {
        a(this.l);
    }

    public void e() {
        a(this.m);
    }

    public void f() {
        a(this.n);
    }

    public void g() {
        a(this.o);
    }

    public void h() {
        a(this.b);
    }

    private void a(Comparator<g> comparator) {
        synchronized (this.e) {
            Collections.sort(this.e, comparator);
        }
        a(2, 0, (Object) 0);
    }

    private void k() {
        if (this.i == null) {
            this.i = new a();
            this.i.a();
        }
        l();
        this.f = 2;
        this.e.clear();
        this.g = false;
        this.h = new com.jumobile.manager.systemapp.i.e(this.d, this);
        this.h.start();
    }

    private void l() {
        if (this.h != null && this.h.isAlive()) {
            this.g = true;
            try {
                this.h.join();
            } catch (InterruptedException unused) {
            }
        }
        this.h = null;
    }

    @Override // com.jumobile.manager.systemapp.i.e.a
    public boolean i() {
        return this.g;
    }

    @Override // com.jumobile.manager.systemapp.i.e.a
    public void j() {
        a(1, 0, (Object) 0);
    }

    @Override // com.jumobile.manager.systemapp.i.e.a
    public void c(g gVar) {
        synchronized (this.e) {
            this.e.add(gVar);
        }
        a(2, 0, (Object) 0);
    }

    @Override // com.jumobile.manager.systemapp.i.e.a
    public void a(int i) {
        int a2;
        Comparator<g> comparator;
        switch (i) {
            case 0:
                this.f = 4;
                break;
            case 1:
                this.f = 7;
                break;
            case 2:
                this.f = 8;
                break;
        }
        if (this.j) {
            a2 = com.jumobile.manager.systemapp.f.a.a(this.d, "move_app_sort_by", 7);
        } else {
            a2 = com.jumobile.manager.systemapp.f.a.a(this.d, "user_app_sort_by", 1);
        }
        if (a2 != 7) {
            switch (a2) {
                case 1:
                    comparator = this.l;
                    break;
                case 2:
                    comparator = this.m;
                    break;
                case 3:
                    comparator = this.n;
                    break;
                default:
                    comparator = this.l;
                    break;
            }
        } else {
            comparator = this.b;
        }
        synchronized (this.e) {
            Collections.sort(this.e, comparator);
        }
        a(4, 0, (Object) 0);
        this.h = null;
    }

    /* compiled from: source */
    private class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(f fVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        void a() {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
            intentFilter.addDataScheme("package");
            f.this.d.registerReceiver(this, intentFilter);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE");
            intentFilter2.addAction("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE");
            f.this.d.registerReceiver(this, intentFilter2);
        }

        void b() {
            f.this.d.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String[] stringArrayExtra;
            String action = intent.getAction();
            if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                f.this.b(intent.getData().getEncodedSchemeSpecificPart());
                f.this.a(2, 0, (Object) 0);
                return;
            }
            if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                f.this.c(intent.getData().getEncodedSchemeSpecificPart());
                f.this.a(2, 0, (Object) 0);
                return;
            }
            if ("android.intent.action.PACKAGE_CHANGED".equals(action)) {
                String encodedSchemeSpecificPart = intent.getData().getEncodedSchemeSpecificPart();
                f.this.b(encodedSchemeSpecificPart);
                f.this.c(encodedSchemeSpecificPart);
                f.this.a(2, 0, (Object) 0);
                return;
            }
            if ((!"android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE".equals(action) && !"android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE".equals(action)) || (stringArrayExtra = intent.getStringArrayExtra("android.intent.extra.changed_package_list")) == null || stringArrayExtra.length == 0) {
                return;
            }
            if ("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE".equals(action)) {
                for (String str : stringArrayExtra) {
                    f.this.c(str);
                    f.this.b(str);
                }
            }
            f.this.a(2, 0, (Object) 0);
        }
    }

    void b(String str) {
        try {
            ApplicationInfo applicationInfo = this.d.getPackageManager().getApplicationInfo(str, 0);
            if (com.jumobile.manager.systemapp.i.e.a(applicationInfo)) {
                g gVar = new g(applicationInfo);
                if (gVar.d(this.d)) {
                    synchronized (this.e) {
                        this.e.add(gVar);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    void c(String str) {
        synchronized (this.e) {
            Iterator<g> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                g next = it.next();
                if (next.b.packageName.equals(str)) {
                    this.e.remove(next);
                    break;
                }
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.c.f$2 */
    class AnonymousClass2 implements Comparator<g> {
        private final Collator b = Collator.getInstance();

        AnonymousClass2() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(g gVar, g gVar2) {
            if (gVar.f == null || gVar2.f == null) {
                return gVar.f != null ? -1 : 1;
            }
            return this.b.compare(gVar.f, gVar2.f);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.c.f$3 */
    class AnonymousClass3 implements Comparator<g> {
        private final Collator b = Collator.getInstance();

        AnonymousClass3() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(g gVar, g gVar2) {
            if (gVar.h < gVar2.h) {
                return 1;
            }
            if (gVar.h > gVar2.h) {
                return -1;
            }
            if (gVar.f == null || gVar2.f == null) {
                return gVar.f != null ? -1 : 1;
            }
            return this.b.compare(gVar.f, gVar2.f);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.c.f$4 */
    class AnonymousClass4 implements Comparator<g> {
        private final Collator b = Collator.getInstance();

        AnonymousClass4() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(g gVar, g gVar2) {
            if (gVar.c < gVar2.c) {
                return 1;
            }
            if (gVar.c > gVar2.c) {
                return -1;
            }
            if (gVar.f == null || gVar2.f == null) {
                return gVar.f != null ? -1 : 1;
            }
            return this.b.compare(gVar.f, gVar2.f);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.c.f$5 */
    class AnonymousClass5 implements Comparator<g> {
        private final Collator b = Collator.getInstance();

        AnonymousClass5() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(g gVar, g gVar2) {
            String d = gVar.d();
            String d2 = gVar2.d();
            if (d == null || d2 == null) {
                return d != null ? -1 : 1;
            }
            return this.b.compare(d, d2);
        }
    }

    public static String a(Context context) {
        String a2 = com.jumobile.manager.systemapp.f.a.a(context, "settings_user_app_backup_path", "");
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return Environment.getExternalStorageDirectory().getPath() + "/jumobile/backup/";
    }
}
