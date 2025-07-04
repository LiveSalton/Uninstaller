package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.i;
import androidx.fragment.app.n;
import java.io.PrintWriter;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
final class a extends n implements i.c {
    final i a;
    boolean b;
    int c;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.c >= 0) {
            sb.append(" #");
            sb.append(this.c);
        }
        if (this.l != null) {
            sb.append(" ");
            sb.append(this.l);
        }
        sb.append("}");
        return sb.toString();
    }

    public void a(String str, PrintWriter printWriter) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.l);
            printWriter.print(" mIndex=");
            printWriter.print(this.c);
            printWriter.print(" mCommitted=");
            printWriter.println(this.b);
            if (this.i != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.i));
            }
            if (this.e != 0 || this.f != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.e));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f));
            }
            if (this.g != 0 || this.h != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (this.m != 0 || this.n != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.m));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.n);
            }
            if (this.o != 0 || this.p != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.o));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.p);
            }
        }
        if (this.d.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            n.a aVar = this.d.get(i);
            switch (aVar.a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.b);
            if (z) {
                if (aVar.c != 0 || aVar.d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.d));
                }
                if (aVar.e != 0 || aVar.f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f));
                }
            }
        }
    }

    a(i iVar) {
        super(iVar.y(), iVar.c != null ? iVar.c.j().getClassLoader() : null);
        this.c = -1;
        this.a = iVar;
    }

    @Override // androidx.fragment.app.n
    void a(int i, Fragment fragment, String str, int i2) {
        super.a(i, fragment, str, i2);
        fragment.r = this.a;
    }

    @Override // androidx.fragment.app.n
    public n a(Fragment fragment) {
        if (fragment.r != null && fragment.r != this.a) {
            throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.a(fragment);
    }

    void a(int i) {
        if (this.j) {
            if (i.a(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.d.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a aVar = this.d.get(i2);
                if (aVar.b != null) {
                    aVar.b.q += i;
                    if (i.a(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.b + " to " + aVar.b.q);
                    }
                }
            }
        }
    }

    public void a() {
        if (this.t != null) {
            for (int i = 0; i < this.t.size(); i++) {
                this.t.get(i).run();
            }
            this.t = null;
        }
    }

    @Override // androidx.fragment.app.n
    public int b() {
        return a(false);
    }

    @Override // androidx.fragment.app.n
    public void c() {
        g();
        this.a.b((i.c) this, true);
    }

    int a(boolean z) {
        if (this.b) {
            throw new IllegalStateException("commit already called");
        }
        if (i.a(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new androidx.core.g.b("FragmentManager"));
            a("  ", printWriter);
            printWriter.close();
        }
        this.b = true;
        if (this.j) {
            this.c = this.a.j();
        } else {
            this.c = -1;
        }
        this.a.a(this, z);
        return this.c;
    }

    @Override // androidx.fragment.app.i.c
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (i.a(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.j) {
            return true;
        }
        this.a.a(this);
        return true;
    }

    boolean b(int i) {
        int size = this.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            n.a aVar = this.d.get(i2);
            int i3 = aVar.b != null ? aVar.b.w : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    boolean a(ArrayList<a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.d.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            n.a aVar = this.d.get(i4);
            int i5 = aVar.b != null ? aVar.b.w : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    a aVar2 = arrayList.get(i6);
                    int size2 = aVar2.d.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        n.a aVar3 = aVar2.d.get(i7);
                        if ((aVar3.b != null ? aVar3.b.w : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    void d() {
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            n.a aVar = this.d.get(i);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                fragment.c(this.i);
            }
            int i2 = aVar.a;
            if (i2 == 1) {
                fragment.b(aVar.c);
                this.a.a(fragment, false);
                this.a.i(fragment);
            } else {
                switch (i2) {
                    case 3:
                        fragment.b(aVar.d);
                        this.a.j(fragment);
                        break;
                    case 4:
                        fragment.b(aVar.d);
                        this.a.k(fragment);
                        break;
                    case 5:
                        fragment.b(aVar.c);
                        this.a.a(fragment, false);
                        this.a.l(fragment);
                        break;
                    case 6:
                        fragment.b(aVar.d);
                        this.a.m(fragment);
                        break;
                    case 7:
                        fragment.b(aVar.c);
                        this.a.a(fragment, false);
                        this.a.n(fragment);
                        break;
                    case 8:
                        this.a.o(fragment);
                        break;
                    case 9:
                        this.a.o(null);
                        break;
                    case 10:
                        this.a.a(fragment, aVar.h);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                }
            }
            if (!this.s && aVar.a != 1 && fragment != null) {
                this.a.g(fragment);
            }
        }
        if (this.s) {
            return;
        }
        this.a.a(this.a.b, true);
    }

    void b(boolean z) {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            n.a aVar = this.d.get(size);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                fragment.c(i.d(this.i));
            }
            int i = aVar.a;
            if (i == 1) {
                fragment.b(aVar.f);
                this.a.a(fragment, true);
                this.a.j(fragment);
            } else {
                switch (i) {
                    case 3:
                        fragment.b(aVar.e);
                        this.a.i(fragment);
                        break;
                    case 4:
                        fragment.b(aVar.e);
                        this.a.l(fragment);
                        break;
                    case 5:
                        fragment.b(aVar.f);
                        this.a.a(fragment, true);
                        this.a.k(fragment);
                        break;
                    case 6:
                        fragment.b(aVar.e);
                        this.a.n(fragment);
                        break;
                    case 7:
                        fragment.b(aVar.f);
                        this.a.a(fragment, true);
                        this.a.m(fragment);
                        break;
                    case 8:
                        this.a.o(null);
                        break;
                    case 9:
                        this.a.o(fragment);
                        break;
                    case 10:
                        this.a.a(fragment, aVar.g);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                }
            }
            if (!this.s && aVar.a != 3 && fragment != null) {
                this.a.g(fragment);
            }
        }
        if (this.s || !z) {
            return;
        }
        this.a.a(this.a.b, true);
    }

    Fragment a(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.d.size()) {
            n.a aVar = this.d.get(i);
            switch (aVar.a) {
                case 1:
                case 7:
                    arrayList.add(aVar.b);
                    break;
                case 2:
                    Fragment fragment3 = aVar.b;
                    int i2 = fragment3.w;
                    Fragment fragment4 = fragment2;
                    int i3 = i;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment5 = arrayList.get(size);
                        if (fragment5.w == i2) {
                            if (fragment5 == fragment3) {
                                z = true;
                            } else {
                                if (fragment5 == fragment4) {
                                    this.d.add(i3, new n.a(9, fragment5));
                                    i3++;
                                    fragment4 = null;
                                }
                                n.a aVar2 = new n.a(3, fragment5);
                                aVar2.c = aVar.c;
                                aVar2.e = aVar.e;
                                aVar2.d = aVar.d;
                                aVar2.f = aVar.f;
                                this.d.add(i3, aVar2);
                                arrayList.remove(fragment5);
                                i3++;
                            }
                        }
                    }
                    if (z) {
                        this.d.remove(i3);
                        i3--;
                    } else {
                        aVar.a = 1;
                        arrayList.add(fragment3);
                    }
                    i = i3;
                    fragment2 = fragment4;
                    break;
                case 3:
                case 6:
                    arrayList.remove(aVar.b);
                    if (aVar.b == fragment2) {
                        this.d.add(i, new n.a(9, aVar.b));
                        i++;
                        fragment2 = null;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    this.d.add(i, new n.a(9, fragment2));
                    i++;
                    fragment2 = aVar.b;
                    break;
            }
            i++;
        }
        return fragment2;
    }

    Fragment b(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            n.a aVar = this.d.get(size);
            int i = aVar.a;
            if (i != 1) {
                if (i != 3) {
                    switch (i) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.b;
                            break;
                        case 10:
                            aVar.h = aVar.g;
                            break;
                    }
                }
                arrayList.add(aVar.b);
            }
            arrayList.remove(aVar.b);
        }
        return fragment;
    }

    boolean e() {
        for (int i = 0; i < this.d.size(); i++) {
            if (b(this.d.get(i))) {
                return true;
            }
        }
        return false;
    }

    void a(Fragment.c cVar) {
        for (int i = 0; i < this.d.size(); i++) {
            n.a aVar = this.d.get(i);
            if (b(aVar)) {
                aVar.b.a(cVar);
            }
        }
    }

    private static boolean b(n.a aVar) {
        Fragment fragment = aVar.b;
        return (fragment == null || !fragment.k || fragment.F == null || fragment.z || fragment.y || !fragment.aq()) ? false : true;
    }

    public String f() {
        return this.l;
    }
}
