package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
class m {
    private final ArrayList<Fragment> a = new ArrayList<>();
    private final HashMap<String, l> b = new HashMap<>();

    m() {
    }

    void a() {
        this.b.clear();
    }

    void a(List<String> list) {
        this.a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment e = e(str);
                if (e == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (i.a(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + e);
                }
                a(e);
            }
        }
    }

    void a(l lVar) {
        this.b.put(lVar.a().f, lVar);
    }

    void a(Fragment fragment) {
        if (this.a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.a) {
            this.a.add(fragment);
        }
        fragment.k = true;
    }

    void a(int i) {
        Iterator<Fragment> it = this.a.iterator();
        while (it.hasNext()) {
            l lVar = this.b.get(it.next().f);
            if (lVar != null) {
                lVar.a(i);
            }
        }
        for (l lVar2 : this.b.values()) {
            if (lVar2 != null) {
                lVar2.a(i);
            }
        }
    }

    void b(Fragment fragment) {
        synchronized (this.a) {
            this.a.remove(fragment);
        }
        fragment.k = false;
    }

    void b(l lVar) {
        Fragment a = lVar.a();
        for (l lVar2 : this.b.values()) {
            if (lVar2 != null) {
                Fragment a2 = lVar2.a();
                if (a.f.equals(a2.i)) {
                    a2.h = a;
                    a2.i = null;
                }
            }
        }
        this.b.put(a.f, null);
        if (a.i != null) {
            a.h = e(a.i);
        }
    }

    void b() {
        this.b.values().removeAll(Collections.singleton(null));
    }

    ArrayList<FragmentState> c() {
        ArrayList<FragmentState> arrayList = new ArrayList<>(this.b.size());
        for (l lVar : this.b.values()) {
            if (lVar != null) {
                Fragment a = lVar.a();
                FragmentState k = lVar.k();
                arrayList.add(k);
                if (i.a(2)) {
                    Log.v("FragmentManager", "Saved state of " + a + ": " + k.m);
                }
            }
        }
        return arrayList;
    }

    ArrayList<String> d() {
        synchronized (this.a) {
            if (this.a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.a.size());
            Iterator<Fragment> it = this.a.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.f);
                if (i.a(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.f + "): " + next);
                }
            }
            return arrayList;
        }
    }

    List<Fragment> e() {
        ArrayList arrayList;
        if (this.a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        return arrayList;
    }

    List<Fragment> f() {
        ArrayList arrayList = new ArrayList();
        for (l lVar : this.b.values()) {
            if (lVar != null) {
                arrayList.add(lVar.a());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    Fragment b(int i) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.a.get(size);
            if (fragment != null && fragment.v == i) {
                return fragment;
            }
        }
        for (l lVar : this.b.values()) {
            if (lVar != null) {
                Fragment a = lVar.a();
                if (a.v == i) {
                    return a;
                }
            }
        }
        return null;
    }

    Fragment a(String str) {
        if (str != null) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.a.get(size);
                if (fragment != null && str.equals(fragment.x)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (l lVar : this.b.values()) {
            if (lVar != null) {
                Fragment a = lVar.a();
                if (str.equals(a.x)) {
                    return a;
                }
            }
        }
        return null;
    }

    boolean b(String str) {
        return this.b.containsKey(str);
    }

    l c(String str) {
        return this.b.get(str);
    }

    Fragment d(String str) {
        Fragment a;
        for (l lVar : this.b.values()) {
            if (lVar != null && (a = lVar.a().a(str)) != null) {
                return a;
            }
        }
        return null;
    }

    Fragment e(String str) {
        l lVar = this.b.get(str);
        if (lVar != null) {
            return lVar.a();
        }
        return null;
    }

    Fragment c(Fragment fragment) {
        ViewGroup viewGroup = fragment.E;
        View view = fragment.F;
        if (viewGroup == null || view == null) {
            return null;
        }
        for (int indexOf = this.a.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
            Fragment fragment2 = this.a.get(indexOf);
            if (fragment2.E == viewGroup && fragment2.F != null) {
                return fragment2;
            }
        }
        return null;
    }

    void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.b.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments:");
            for (l lVar : this.b.values()) {
                printWriter.print(str);
                if (lVar != null) {
                    Fragment a = lVar.a();
                    printWriter.println(a);
                    a.a(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size; i++) {
                Fragment fragment = this.a.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }
}
