package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: source */
/* loaded from: classes.dex */
class c extends DataSetObservable {
    static final String a = "c";
    private static final Object e = new Object();
    private static final Map<String, c> f = new HashMap();
    final Context b;
    final String c;
    boolean d;
    private final Object g;
    private final List<a> h;
    private final List<C0009c> i;
    private Intent j;
    private b k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private d p;

    /* compiled from: source */
    public interface b {
        void a(Intent intent, List<a> list, List<C0009c> list2);
    }

    /* compiled from: source */
    public interface d {
        boolean a(c cVar, Intent intent);
    }

    public int a() {
        int size;
        synchronized (this.g) {
            e();
            size = this.h.size();
        }
        return size;
    }

    public ResolveInfo a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.g) {
            e();
            resolveInfo = this.h.get(i).a;
        }
        return resolveInfo;
    }

    public int a(ResolveInfo resolveInfo) {
        synchronized (this.g) {
            e();
            List<a> list = this.h;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public Intent b(int i) {
        synchronized (this.g) {
            if (this.j == null) {
                return null;
            }
            e();
            a aVar = this.h.get(i);
            ComponentName componentName = new ComponentName(aVar.a.activityInfo.packageName, aVar.a.activityInfo.name);
            Intent intent = new Intent(this.j);
            intent.setComponent(componentName);
            if (this.p != null) {
                if (this.p.a(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new C0009c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo b() {
        synchronized (this.g) {
            e();
            if (this.h.isEmpty()) {
                return null;
            }
            return this.h.get(0).a;
        }
    }

    public void c(int i) {
        synchronized (this.g) {
            e();
            a aVar = this.h.get(i);
            a aVar2 = this.h.get(0);
            a(new C0009c(new ComponentName(aVar.a.activityInfo.packageName, aVar.a.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.b - aVar.b) + 5.0f : 1.0f));
        }
    }

    private void d() {
        if (!this.m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.n) {
            this.n = false;
            if (TextUtils.isEmpty(this.c)) {
                return;
            }
            new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.i), this.c);
        }
    }

    public int c() {
        int size;
        synchronized (this.g) {
            e();
            size = this.i.size();
        }
        return size;
    }

    private void e() {
        boolean g = g() | h();
        i();
        if (g) {
            f();
            notifyChanged();
        }
    }

    private boolean f() {
        if (this.k == null || this.j == null || this.h.isEmpty() || this.i.isEmpty()) {
            return false;
        }
        this.k.a(this.j, this.h, Collections.unmodifiableList(this.i));
        return true;
    }

    private boolean g() {
        if (!this.o || this.j == null) {
            return false;
        }
        this.o = false;
        this.h.clear();
        List<ResolveInfo> queryIntentActivities = this.b.getPackageManager().queryIntentActivities(this.j, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.h.add(new a(queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean h() {
        if (!this.d || !this.n || TextUtils.isEmpty(this.c)) {
            return false;
        }
        this.d = false;
        this.m = true;
        j();
        return true;
    }

    private boolean a(C0009c c0009c) {
        boolean add = this.i.add(c0009c);
        if (add) {
            this.n = true;
            i();
            d();
            f();
            notifyChanged();
        }
        return add;
    }

    private void i() {
        int size = this.i.size() - this.l;
        if (size <= 0) {
            return;
        }
        this.n = true;
        for (int i = 0; i < size; i++) {
            this.i.remove(0);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.widget.c$c */
    public static final class C0009c {
        public final ComponentName a;
        public final long b;
        public final float c;

        public C0009c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public C0009c(ComponentName componentName, long j, float f) {
            this.a = componentName;
            this.b = j;
            this.c = f;
        }

        public int hashCode() {
            return (31 * ((((this.a == null ? 0 : this.a.hashCode()) + 31) * 31) + ((int) (this.b ^ (this.b >>> 32))))) + Float.floatToIntBits(this.c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0009c c0009c = (C0009c) obj;
            if (this.a == null) {
                if (c0009c.a != null) {
                    return false;
                }
            } else if (!this.a.equals(c0009c.a)) {
                return false;
            }
            return this.b == c0009c.b && Float.floatToIntBits(this.c) == Float.floatToIntBits(c0009c.c);
        }

        public String toString() {
            return "[; activity:" + this.a + "; time:" + this.b + "; weight:" + new BigDecimal(this.c) + "]";
        }
    }

    /* compiled from: source */
    public static final class a implements Comparable<a> {
        public final ResolveInfo a;
        public float b;

        public a(ResolveInfo resolveInfo) {
            this.a = resolveInfo;
        }

        public int hashCode() {
            return 31 + Float.floatToIntBits(this.b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.b) == Float.floatToIntBits(((a) obj).b);
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(a aVar) {
            return Float.floatToIntBits(aVar.b) - Float.floatToIntBits(this.b);
        }

        public String toString() {
            return "[resolveInfo:" + this.a.toString() + "; weight:" + new BigDecimal(this.b) + "]";
        }
    }

    private void j() {
        XmlPullParser newPullParser;
        try {
            FileInputStream openFileInput = this.b.openFileInput(this.c);
            try {
                try {
                    try {
                        newPullParser = Xml.newPullParser();
                        newPullParser.setInput(openFileInput, "UTF-8");
                        for (int i = 0; i != 1 && i != 2; i = newPullParser.next()) {
                        }
                    } catch (IOException e2) {
                        Log.e(a, "Error reading historical recrod file: " + this.c, e2);
                        if (openFileInput == null) {
                            return;
                        }
                    }
                } catch (XmlPullParserException e3) {
                    Log.e(a, "Error reading historical recrod file: " + this.c, e3);
                    if (openFileInput == null) {
                        return;
                    }
                }
                if (!"historical-records".equals(newPullParser.getName())) {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
                List<C0009c> list = this.i;
                list.clear();
                while (true) {
                    int next = newPullParser.next();
                    if (next == 1) {
                        if (openFileInput == null) {
                            return;
                        }
                    } else if (next != 3 && next != 4) {
                        if (!"historical-record".equals(newPullParser.getName())) {
                            throw new XmlPullParserException("Share records file not well-formed.");
                        }
                        list.add(new C0009c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                    }
                }
                try {
                    openFileInput.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    /* compiled from: source */
    private final class e extends AsyncTask<Object, Void, Void> {
        e() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x006f, code lost:
        
            if (r4 != null) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0071, code lost:
        
            r4.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00b8, code lost:
        
            if (r4 == null) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0096, code lost:
        
            if (r4 == null) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00da, code lost:
        
            if (r4 == null) goto L79;
         */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Void doInBackground(java.lang.Object... r12) {
            /*
                Method dump skipped, instructions count: 256
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.c.e.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }
}
