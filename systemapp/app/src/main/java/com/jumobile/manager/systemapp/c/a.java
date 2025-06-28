package com.jumobile.manager.systemapp.c;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.jumobile.manager.systemapp.i.a;
import java.io.File;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public class a {
    private static final String b = "a";
    private final Context h;
    private String i;
    private int c = 1;
    private ArrayList<com.jumobile.manager.systemapp.d.a> d = new ArrayList<>();
    private boolean e = false;
    private com.jumobile.manager.systemapp.i.a f = null;
    private C0086a g = null;
    ArrayList<b> a = new ArrayList<>();
    private boolean j = true;
    private a.b k = new a.b() { // from class: com.jumobile.manager.systemapp.c.a.1
        AnonymousClass1() {
        }

        @Override // com.jumobile.manager.systemapp.i.a.b
        public boolean a() {
            return a.this.e;
        }

        @Override // com.jumobile.manager.systemapp.i.a.b
        public void b() {
            a.this.a(1, 0, (Object) 0);
        }

        @Override // com.jumobile.manager.systemapp.i.a.b
        public void a(com.jumobile.manager.systemapp.d.a aVar) {
            synchronized (a.this.d) {
                a.this.d.add(aVar);
            }
            a.this.a(2, 0, (Object) 0);
        }

        @Override // com.jumobile.manager.systemapp.i.a.b
        public void c() {
            a.this.a(3, 0, (Object) 0);
        }

        @Override // com.jumobile.manager.systemapp.i.a.b
        public void a(int i) {
            Comparator comparator;
            int a = com.jumobile.manager.systemapp.f.a.a(a.this.h, "apk_file_sort_by", 5);
            if (a != 5) {
                switch (a) {
                    case 1:
                        comparator = a.this.l;
                        break;
                    case 2:
                        comparator = a.this.o;
                        break;
                    case 3:
                        comparator = a.this.n;
                        break;
                    default:
                        comparator = a.this.m;
                        break;
                }
            } else {
                comparator = a.this.m;
            }
            synchronized (a.this.d) {
                Collections.sort(a.this.d, comparator);
            }
            if (i == 0) {
                a.this.c = 4;
            } else if (i == 2) {
                a.this.c = 7;
            } else if (i == 9) {
                a.this.c = 9;
            }
            a.this.a(2, 0, (Object) 0);
            a.this.a(4, a.this.c, (Object) 0);
        }
    };
    private final Comparator<com.jumobile.manager.systemapp.d.a> l = new Comparator<com.jumobile.manager.systemapp.d.a>() { // from class: com.jumobile.manager.systemapp.c.a.2
        private final Collator b = Collator.getInstance();

        AnonymousClass2() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.a aVar, com.jumobile.manager.systemapp.d.a aVar2) {
            if (aVar.f == null || aVar2.f == null) {
                return aVar.f != null ? -1 : 1;
            }
            return this.b.compare(aVar.f, aVar2.f);
        }
    };
    private final Comparator<com.jumobile.manager.systemapp.d.a> m = new Comparator<com.jumobile.manager.systemapp.d.a>() { // from class: com.jumobile.manager.systemapp.c.a.3
        private final Collator b = Collator.getInstance();

        AnonymousClass3() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.a aVar, com.jumobile.manager.systemapp.d.a aVar2) {
            if (aVar.b < aVar2.b) {
                return 1;
            }
            if (aVar.b > aVar2.b) {
                return -1;
            }
            if (aVar.f == null || aVar2.f == null) {
                return aVar.f != null ? -1 : 1;
            }
            return this.b.compare(aVar.f, aVar2.f);
        }
    };
    private final Comparator<com.jumobile.manager.systemapp.d.a> n = new Comparator<com.jumobile.manager.systemapp.d.a>() { // from class: com.jumobile.manager.systemapp.c.a.4
        private final Collator b = Collator.getInstance();

        AnonymousClass4() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.a aVar, com.jumobile.manager.systemapp.d.a aVar2) {
            if (aVar.d < aVar2.d) {
                return 1;
            }
            if (aVar.d > aVar2.d) {
                return -1;
            }
            if (aVar.f == null || aVar2.f == null) {
                return aVar.f != null ? -1 : 1;
            }
            return this.b.compare(aVar.f, aVar2.f);
        }
    };
    private final Comparator<com.jumobile.manager.systemapp.d.a> o = new Comparator<com.jumobile.manager.systemapp.d.a>() { // from class: com.jumobile.manager.systemapp.c.a.5
        private final Collator b = Collator.getInstance();

        AnonymousClass5() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.a aVar, com.jumobile.manager.systemapp.d.a aVar2) {
            if (aVar.h < aVar2.h) {
                return 1;
            }
            if (aVar.h > aVar2.h) {
                return -1;
            }
            if (aVar.f == null || aVar2.f == null) {
                return aVar.f != null ? -1 : 1;
            }
            return this.b.compare(aVar.f, aVar2.f);
        }
    };
    private final Comparator<com.jumobile.manager.systemapp.d.a> p = new Comparator<com.jumobile.manager.systemapp.d.a>() { // from class: com.jumobile.manager.systemapp.c.a.6
        private final Collator b = Collator.getInstance();

        AnonymousClass6() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.a aVar, com.jumobile.manager.systemapp.d.a aVar2) {
            if (aVar.a == null || aVar2.a == null) {
                return aVar.a != null ? -1 : 1;
            }
            return this.b.compare(aVar.a, aVar2.a);
        }
    };

    /* compiled from: source */
    public class b {
        Handler a;
        int b;

        public b() {
        }
    }

    public a(Context context) {
        this.h = context;
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
        if (this.g != null) {
            this.g.b();
            this.g = null;
        }
        this.e = true;
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

    protected void finalize() throws Throwable {
        if (this.g != null) {
            this.g.b();
        }
        super.finalize();
    }

    public void a(String str) {
        this.i = str;
        if (!TextUtils.isEmpty(this.i)) {
            this.i = str.toLowerCase();
        }
        a(2, 0, (Object) 0);
    }

    public ArrayList<com.jumobile.manager.systemapp.d.a> b() {
        ArrayList<com.jumobile.manager.systemapp.d.a> arrayList = new ArrayList<>();
        if (1 == this.c) {
            l();
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

    public boolean a(com.jumobile.manager.systemapp.d.a aVar) {
        synchronized (this.d) {
            for (int i = 0; i < this.d.size(); i++) {
                com.jumobile.manager.systemapp.d.a aVar2 = this.d.get(i);
                if (aVar2 == aVar) {
                    if (!new File(aVar2.a).delete()) {
                        return false;
                    }
                    this.d.remove(i);
                    a(2, 0, (Object) 0);
                    return true;
                }
            }
            return false;
        }
    }

    public void a(com.jumobile.manager.systemapp.d.a aVar, Activity activity, int i) {
        Uri uri;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    uri = FileProvider.a(this.h, "com.jumobile.manager.systemapp.FileProvider", new File(aVar.a));
                } catch (Exception unused) {
                    uri = null;
                }
                if (uri == null) {
                    File file = new File(this.h.getCacheDir().getPath() + "/apk_file/intermediate_install_file.apk");
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    if (com.jumobile.manager.systemapp.util.a.a(aVar.a, file.getPath())) {
                        uri = FileProvider.a(this.h, "com.jumobile.manager.systemapp.FileProvider", file);
                    }
                }
                if (uri != null) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setFlags(268435456);
                    intent.setFlags(1);
                    intent.setDataAndType(uri, "application/vnd.android.package-archive");
                    activity.startActivityForResult(intent, i);
                } else {
                    com.jumobile.manager.systemapp.util.f.m(this.h, "failed");
                }
            } else {
                Uri fromFile = Uri.fromFile(new File(aVar.a));
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setDataAndType(fromFile, "application/vnd.android.package-archive");
                intent2.addFlags(268435456);
                activity.startActivityForResult(intent2, i);
            }
        } catch (Exception unused2) {
        }
    }

    public void c() {
        this.e = true;
    }

    private void k() {
        if (this.f != null && this.f.isAlive()) {
            this.e = true;
            try {
                this.f.join();
            } catch (InterruptedException unused) {
            }
        }
        this.f = null;
    }

    public void d() {
        e();
        this.j = false;
        a(2, 0, (Object) 0);
    }

    public void e() {
        k();
        this.c = 1;
    }

    public int a(boolean z) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        synchronized (this.d) {
            Iterator<com.jumobile.manager.systemapp.d.a> it = this.d.iterator();
            while (it.hasNext()) {
                com.jumobile.manager.systemapp.d.a next = it.next();
                String str = next.e + "_versionCode_" + next.c;
                com.jumobile.manager.systemapp.d.a aVar = (com.jumobile.manager.systemapp.d.a) hashMap.get(str);
                if (aVar != null) {
                    if (next.a.contains("/jumobile/") && !aVar.a.contains("/jumobile/")) {
                        hashMap.put(str, next);
                        next.i = false;
                        aVar.i = true;
                        arrayList.add(aVar);
                    } else {
                        next.i = true;
                        arrayList.add(next);
                    }
                } else {
                    next.i = false;
                    hashMap.put(str, next);
                }
            }
            if (z && arrayList.size() > 0) {
                this.d.removeAll(arrayList);
                Collections.sort(this.d, this.l);
                Collections.sort(arrayList, this.l);
                this.d.addAll(0, arrayList);
            }
        }
        return arrayList.size();
    }

    private void l() {
        if (this.g == null) {
            this.g = new C0086a();
            this.g.a();
        }
        k();
        this.c = 2;
        this.d.clear();
        this.e = false;
        this.f = new com.jumobile.manager.systemapp.i.a(this.h, this.k);
        this.f.a(this.j);
        this.f.start();
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.c.a$1 */
    class AnonymousClass1 implements a.b {
        AnonymousClass1() {
        }

        @Override // com.jumobile.manager.systemapp.i.a.b
        public boolean a() {
            return a.this.e;
        }

        @Override // com.jumobile.manager.systemapp.i.a.b
        public void b() {
            a.this.a(1, 0, (Object) 0);
        }

        @Override // com.jumobile.manager.systemapp.i.a.b
        public void a(com.jumobile.manager.systemapp.d.a aVar) {
            synchronized (a.this.d) {
                a.this.d.add(aVar);
            }
            a.this.a(2, 0, (Object) 0);
        }

        @Override // com.jumobile.manager.systemapp.i.a.b
        public void c() {
            a.this.a(3, 0, (Object) 0);
        }

        @Override // com.jumobile.manager.systemapp.i.a.b
        public void a(int i) {
            Comparator comparator;
            int a = com.jumobile.manager.systemapp.f.a.a(a.this.h, "apk_file_sort_by", 5);
            if (a != 5) {
                switch (a) {
                    case 1:
                        comparator = a.this.l;
                        break;
                    case 2:
                        comparator = a.this.o;
                        break;
                    case 3:
                        comparator = a.this.n;
                        break;
                    default:
                        comparator = a.this.m;
                        break;
                }
            } else {
                comparator = a.this.m;
            }
            synchronized (a.this.d) {
                Collections.sort(a.this.d, comparator);
            }
            if (i == 0) {
                a.this.c = 4;
            } else if (i == 2) {
                a.this.c = 7;
            } else if (i == 9) {
                a.this.c = 9;
            }
            a.this.a(2, 0, (Object) 0);
            a.this.a(4, a.this.c, (Object) 0);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.c.a$a */
    private class C0086a extends BroadcastReceiver {
        private C0086a() {
        }

        /* synthetic */ C0086a(a aVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        void a() {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_MOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_SHARED");
            intentFilter.addAction("android.intent.action.MEDIA_EJECT");
            intentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
            intentFilter.addDataScheme("file");
            a.this.h.registerReceiver(this, intentFilter);
            IntentFilter intentFilter2 = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentFilter2.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter2.addAction("android.intent.action.PACKAGE_CHANGED");
            intentFilter2.addDataScheme("package");
            a.this.h.registerReceiver(this, intentFilter2);
        }

        void b() {
            a.this.h.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.MEDIA_MOUNTED".equals(action) || "android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_SHARED".equals(action) || "android.intent.action.MEDIA_EJECT".equals(action) || "android.intent.action.MEDIA_BAD_REMOVAL".equals(action)) {
                a.this.e();
                a.this.a(2, 0, (Object) 0);
            } else if ("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REMOVED".equals(action) || "android.intent.action.PACKAGE_CHANGED".equals(action)) {
                a.this.b(intent.getData().getEncodedSchemeSpecificPart());
                a.this.a(2, 0, (Object) 0);
            }
        }
    }

    public void b(String str) {
        synchronized (this.d) {
            Iterator<com.jumobile.manager.systemapp.d.a> it = this.d.iterator();
            while (it.hasNext()) {
                com.jumobile.manager.systemapp.d.a next = it.next();
                if (next.e.equals(str)) {
                    next.a(this.h);
                }
            }
        }
    }

    public void f() {
        a(this.m);
    }

    public void g() {
        a(this.l);
    }

    public void h() {
        a(this.o);
    }

    public void i() {
        a(this.n);
    }

    public void j() {
        a(this.p);
    }

    private void a(Comparator<com.jumobile.manager.systemapp.d.a> comparator) {
        synchronized (this.d) {
            Collections.sort(this.d, comparator);
        }
        a(2, 0, (Object) 0);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.c.a$2 */
    class AnonymousClass2 implements Comparator<com.jumobile.manager.systemapp.d.a> {
        private final Collator b = Collator.getInstance();

        AnonymousClass2() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.a aVar, com.jumobile.manager.systemapp.d.a aVar2) {
            if (aVar.f == null || aVar2.f == null) {
                return aVar.f != null ? -1 : 1;
            }
            return this.b.compare(aVar.f, aVar2.f);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.c.a$3 */
    class AnonymousClass3 implements Comparator<com.jumobile.manager.systemapp.d.a> {
        private final Collator b = Collator.getInstance();

        AnonymousClass3() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.a aVar, com.jumobile.manager.systemapp.d.a aVar2) {
            if (aVar.b < aVar2.b) {
                return 1;
            }
            if (aVar.b > aVar2.b) {
                return -1;
            }
            if (aVar.f == null || aVar2.f == null) {
                return aVar.f != null ? -1 : 1;
            }
            return this.b.compare(aVar.f, aVar2.f);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.c.a$4 */
    class AnonymousClass4 implements Comparator<com.jumobile.manager.systemapp.d.a> {
        private final Collator b = Collator.getInstance();

        AnonymousClass4() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.a aVar, com.jumobile.manager.systemapp.d.a aVar2) {
            if (aVar.d < aVar2.d) {
                return 1;
            }
            if (aVar.d > aVar2.d) {
                return -1;
            }
            if (aVar.f == null || aVar2.f == null) {
                return aVar.f != null ? -1 : 1;
            }
            return this.b.compare(aVar.f, aVar2.f);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.c.a$5 */
    class AnonymousClass5 implements Comparator<com.jumobile.manager.systemapp.d.a> {
        private final Collator b = Collator.getInstance();

        AnonymousClass5() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.a aVar, com.jumobile.manager.systemapp.d.a aVar2) {
            if (aVar.h < aVar2.h) {
                return 1;
            }
            if (aVar.h > aVar2.h) {
                return -1;
            }
            if (aVar.f == null || aVar2.f == null) {
                return aVar.f != null ? -1 : 1;
            }
            return this.b.compare(aVar.f, aVar2.f);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.c.a$6 */
    class AnonymousClass6 implements Comparator<com.jumobile.manager.systemapp.d.a> {
        private final Collator b = Collator.getInstance();

        AnonymousClass6() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.a aVar, com.jumobile.manager.systemapp.d.a aVar2) {
            if (aVar.a == null || aVar2.a == null) {
                return aVar.a != null ? -1 : 1;
            }
            return this.b.compare(aVar.a, aVar2.a);
        }
    }
}
