package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
class o {
    private static final int[] a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
    private static final q b;
    private static final q c;

    /* compiled from: source */
    interface a {
        void a(Fragment fragment, androidx.core.d.a aVar);

        void b(Fragment fragment, androidx.core.d.a aVar);
    }

    static {
        b = Build.VERSION.SDK_INT >= 21 ? new p() : null;
        c = a();
    }

    private static q a() {
        try {
            return (q) Class.forName("androidx.transition.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static void a(i iVar, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z, a aVar) {
        if (iVar.b < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            androidx.fragment.app.a aVar2 = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                b(aVar2, (SparseArray<b>) sparseArray, z);
            } else {
                a(aVar2, (SparseArray<b>) sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(iVar.c.j());
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = sparseArray.keyAt(i4);
                androidx.b.a<String, String> a2 = a(keyAt, arrayList, arrayList2, i, i2);
                b bVar = (b) sparseArray.valueAt(i4);
                if (z) {
                    a(iVar, keyAt, bVar, view, a2, aVar);
                } else {
                    b(iVar, keyAt, bVar, view, a2, aVar);
                }
            }
        }
    }

    private static androidx.b.a<String, String> a(int i, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        androidx.b.a<String, String> aVar = new androidx.b.a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            androidx.fragment.app.a aVar2 = arrayList.get(i4);
            if (aVar2.b(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                if (aVar2.q != null) {
                    int size = aVar2.q.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.q;
                        arrayList4 = aVar2.r;
                    } else {
                        ArrayList<String> arrayList5 = aVar2.q;
                        arrayList3 = aVar2.r;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    private static void a(i iVar, int i, b bVar, View view, androidx.b.a<String, String> aVar, a aVar2) {
        Fragment fragment;
        Fragment fragment2;
        q a2;
        Object obj;
        ViewGroup viewGroup = iVar.d.a() ? (ViewGroup) iVar.d.a(i) : null;
        if (viewGroup == null || (a2 = a((fragment2 = bVar.d), (fragment = bVar.a))) == null) {
            return;
        }
        boolean z = bVar.b;
        boolean z2 = bVar.e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object a3 = a(a2, fragment, z);
        Object b2 = b(a2, fragment2, z2);
        Object a4 = a(a2, viewGroup, view, aVar, bVar, arrayList2, arrayList, a3, b2);
        if (a3 == null && a4 == null) {
            obj = b2;
            if (obj == null) {
                return;
            }
        } else {
            obj = b2;
        }
        ArrayList<View> a5 = a(a2, obj, fragment2, arrayList2, view);
        ArrayList<View> a6 = a(a2, a3, fragment, arrayList, view);
        a(a6, 4);
        Object a7 = a(a2, a3, obj, a4, fragment, z);
        if (fragment2 != null && a5 != null && (a5.size() > 0 || arrayList2.size() > 0)) {
            androidx.core.d.a aVar3 = new androidx.core.d.a();
            aVar2.a(fragment2, aVar3);
            a2.a(fragment2, a7, aVar3, new Runnable() { // from class: androidx.fragment.app.o.1
                final /* synthetic */ Fragment b;
                final /* synthetic */ androidx.core.d.a c;

                AnonymousClass1(Fragment fragment22, androidx.core.d.a aVar32) {
                    fragment2 = fragment22;
                    aVar3 = aVar32;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(fragment2, aVar3);
                }
            });
        }
        if (a7 != null) {
            a(a2, obj, fragment22, a5);
            ArrayList<String> a8 = a2.a(arrayList);
            a2.a(a7, a3, a6, obj, a5, a4, arrayList);
            a2.a(viewGroup, a7);
            a2.a(viewGroup, arrayList2, arrayList, a8, aVar);
            a(a6, 0);
            a2.a(a4, arrayList2, arrayList);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.o$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Fragment b;
        final /* synthetic */ androidx.core.d.a c;

        AnonymousClass1(Fragment fragment22, androidx.core.d.a aVar32) {
            fragment2 = fragment22;
            aVar3 = aVar32;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b(fragment2, aVar3);
        }
    }

    private static void a(q qVar, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.k && fragment.y && fragment.L) {
            fragment.k(true);
            qVar.b(obj, fragment.D(), arrayList);
            androidx.core.h.s.a(fragment.E, new Runnable() { // from class: androidx.fragment.app.o.2
                final /* synthetic */ ArrayList a;

                AnonymousClass2(ArrayList arrayList2) {
                    arrayList = arrayList2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    o.a((ArrayList<View>) arrayList, 4);
                }
            });
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.o$2 */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ ArrayList a;

        AnonymousClass2(ArrayList arrayList2) {
            arrayList = arrayList2;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.a((ArrayList<View>) arrayList, 4);
        }
    }

    private static void b(i iVar, int i, b bVar, View view, androidx.b.a<String, String> aVar, a aVar2) {
        Fragment fragment;
        Fragment fragment2;
        q a2;
        Object obj;
        ViewGroup viewGroup = iVar.d.a() ? (ViewGroup) iVar.d.a(i) : null;
        if (viewGroup == null || (a2 = a((fragment2 = bVar.d), (fragment = bVar.a))) == null) {
            return;
        }
        boolean z = bVar.b;
        boolean z2 = bVar.e;
        Object a3 = a(a2, fragment, z);
        Object b2 = b(a2, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object b3 = b(a2, viewGroup, view, aVar, bVar, arrayList, arrayList2, a3, b2);
        if (a3 == null && b3 == null) {
            obj = b2;
            if (obj == null) {
                return;
            }
        } else {
            obj = b2;
        }
        ArrayList<View> a4 = a(a2, obj, fragment2, (ArrayList<View>) arrayList, view);
        Object obj2 = (a4 == null || a4.isEmpty()) ? null : obj;
        a2.b(a3, view);
        Object a5 = a(a2, a3, obj2, b3, fragment, bVar.b);
        if (fragment2 != null && a4 != null && (a4.size() > 0 || arrayList.size() > 0)) {
            androidx.core.d.a aVar3 = new androidx.core.d.a();
            aVar2.a(fragment2, aVar3);
            a2.a(fragment2, a5, aVar3, new Runnable() { // from class: androidx.fragment.app.o.3
                final /* synthetic */ Fragment b;
                final /* synthetic */ androidx.core.d.a c;

                AnonymousClass3(Fragment fragment22, androidx.core.d.a aVar32) {
                    fragment2 = fragment22;
                    aVar3 = aVar32;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(fragment2, aVar3);
                }
            });
        }
        if (a5 != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            a2.a(a5, a3, arrayList3, obj2, a4, b3, arrayList2);
            a(a2, viewGroup, fragment, view, arrayList2, a3, arrayList3, obj2, a4);
            a2.a((View) viewGroup, arrayList2, (Map<String, String>) aVar);
            a2.a(viewGroup, a5);
            a2.a(viewGroup, arrayList2, (Map<String, String>) aVar);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.o$3 */
    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ Fragment b;
        final /* synthetic */ androidx.core.d.a c;

        AnonymousClass3(Fragment fragment22, androidx.core.d.a aVar32) {
            fragment2 = fragment22;
            aVar3 = aVar32;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b(fragment2, aVar3);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.o$4 */
    static class AnonymousClass4 implements Runnable {
        final /* synthetic */ Object a;
        final /* synthetic */ q b;
        final /* synthetic */ View c;
        final /* synthetic */ Fragment d;
        final /* synthetic */ ArrayList e;
        final /* synthetic */ ArrayList f;
        final /* synthetic */ ArrayList g;
        final /* synthetic */ Object h;

        AnonymousClass4(Object obj, q qVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            obj = obj;
            qVar = qVar;
            view = view;
            fragment = fragment;
            arrayList = arrayList;
            arrayList2 = arrayList2;
            arrayList3 = arrayList3;
            obj2 = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (obj != null) {
                qVar.c(obj, view);
                arrayList2.addAll(o.a(qVar, obj, fragment, (ArrayList<View>) arrayList, view));
            }
            if (arrayList3 != null) {
                if (obj2 != null) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    arrayList.add(view);
                    qVar.b(obj2, arrayList3, arrayList);
                }
                arrayList3.clear();
                arrayList3.add(view);
            }
        }
    }

    private static void a(q qVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        androidx.core.h.s.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.o.4
            final /* synthetic */ Object a;
            final /* synthetic */ q b;
            final /* synthetic */ View c;
            final /* synthetic */ Fragment d;
            final /* synthetic */ ArrayList e;
            final /* synthetic */ ArrayList f;
            final /* synthetic */ ArrayList g;
            final /* synthetic */ Object h;

            AnonymousClass4(Object obj3, q qVar2, View view2, Fragment fragment2, ArrayList arrayList4, ArrayList arrayList22, ArrayList arrayList32, Object obj22) {
                obj = obj3;
                qVar = qVar2;
                view = view2;
                fragment = fragment2;
                arrayList = arrayList4;
                arrayList2 = arrayList22;
                arrayList3 = arrayList32;
                obj2 = obj22;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (obj != null) {
                    qVar.c(obj, view);
                    arrayList2.addAll(o.a(qVar, obj, fragment, (ArrayList<View>) arrayList, view));
                }
                if (arrayList3 != null) {
                    if (obj2 != null) {
                        ArrayList<View> arrayList4 = new ArrayList<>();
                        arrayList4.add(view);
                        qVar.b(obj2, arrayList3, arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    private static q a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object Q = fragment.Q();
            if (Q != null) {
                arrayList.add(Q);
            }
            Object P = fragment.P();
            if (P != null) {
                arrayList.add(P);
            }
            Object T = fragment.T();
            if (T != null) {
                arrayList.add(T);
            }
        }
        if (fragment2 != null) {
            Object O = fragment2.O();
            if (O != null) {
                arrayList.add(O);
            }
            Object R = fragment2.R();
            if (R != null) {
                arrayList.add(R);
            }
            Object S = fragment2.S();
            if (S != null) {
                arrayList.add(S);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (b != null && a(b, arrayList)) {
            return b;
        }
        if (c != null && a(c, arrayList)) {
            return c;
        }
        if (b == null && c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    private static boolean a(q qVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!qVar.a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static Object a(q qVar, Fragment fragment, Fragment fragment2, boolean z) {
        Object S;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            S = fragment2.T();
        } else {
            S = fragment.S();
        }
        return qVar.c(qVar.b(S));
    }

    private static Object a(q qVar, Fragment fragment, boolean z) {
        Object O;
        if (fragment == null) {
            return null;
        }
        if (z) {
            O = fragment.R();
        } else {
            O = fragment.O();
        }
        return qVar.b(O);
    }

    private static Object b(q qVar, Fragment fragment, boolean z) {
        Object Q;
        if (fragment == null) {
            return null;
        }
        if (z) {
            Q = fragment.P();
        } else {
            Q = fragment.Q();
        }
        return qVar.b(Q);
    }

    private static Object a(q qVar, ViewGroup viewGroup, View view, androidx.b.a<String, String> aVar, b bVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = bVar.a;
        Fragment fragment2 = bVar.d;
        if (fragment != null) {
            fragment.E().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = bVar.b;
        Object a2 = aVar.isEmpty() ? null : a(qVar, fragment, fragment2, z);
        androidx.b.a<String, View> b2 = b(qVar, aVar, a2, bVar);
        androidx.b.a<String, View> a3 = a(qVar, aVar, a2, bVar);
        if (aVar.isEmpty()) {
            if (b2 != null) {
                b2.clear();
            }
            if (a3 != null) {
                a3.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, b2, aVar.keySet());
            a(arrayList2, a3, aVar.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (obj3 != null) {
            arrayList2.add(view);
            qVar.a(obj3, view, arrayList);
            a(qVar, obj3, obj2, b2, bVar.e, bVar.f);
            Rect rect2 = new Rect();
            View a4 = a(a3, bVar, obj, z);
            if (a4 != null) {
                qVar.a(obj, rect2);
            }
            rect = rect2;
            view2 = a4;
        } else {
            view2 = null;
            rect = null;
        }
        androidx.core.h.s.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.o.5
            final /* synthetic */ Fragment b;
            final /* synthetic */ boolean c;
            final /* synthetic */ androidx.b.a d;
            final /* synthetic */ View e;
            final /* synthetic */ q f;
            final /* synthetic */ Rect g;

            AnonymousClass5(Fragment fragment22, boolean z2, androidx.b.a a32, View view22, q qVar2, Rect rect3) {
                fragment2 = fragment22;
                z = z2;
                a3 = a32;
                view2 = view22;
                qVar = qVar2;
                rect = rect3;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.a(Fragment.this, fragment2, z, (androidx.b.a<String, View>) a3, false);
                if (view2 != null) {
                    qVar.a(view2, rect);
                }
            }
        });
        return obj3;
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.o$5 */
    static class AnonymousClass5 implements Runnable {
        final /* synthetic */ Fragment b;
        final /* synthetic */ boolean c;
        final /* synthetic */ androidx.b.a d;
        final /* synthetic */ View e;
        final /* synthetic */ q f;
        final /* synthetic */ Rect g;

        AnonymousClass5(Fragment fragment22, boolean z2, androidx.b.a a32, View view22, q qVar2, Rect rect3) {
            fragment2 = fragment22;
            z = z2;
            a3 = a32;
            view2 = view22;
            qVar = qVar2;
            rect = rect3;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.a(Fragment.this, fragment2, z, (androidx.b.a<String, View>) a3, false);
            if (view2 != null) {
                qVar.a(view2, rect);
            }
        }
    }

    private static void a(ArrayList<View> arrayList, androidx.b.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View c2 = aVar.c(size);
            if (collection.contains(w.r(c2))) {
                arrayList.add(c2);
            }
        }
    }

    private static Object b(q qVar, ViewGroup viewGroup, View view, androidx.b.a<String, String> aVar, b bVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object a2;
        androidx.b.a<String, String> aVar2;
        Object obj3;
        Rect rect;
        Fragment fragment = bVar.a;
        Fragment fragment2 = bVar.d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = bVar.b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            a2 = null;
        } else {
            a2 = a(qVar, fragment, fragment2, z);
            aVar2 = aVar;
        }
        androidx.b.a<String, View> b2 = b(qVar, aVar2, a2, bVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(b2.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (obj3 != null) {
            rect = new Rect();
            qVar.a(obj3, view, arrayList);
            a(qVar, obj3, obj2, b2, bVar.e, bVar.f);
            if (obj != null) {
                qVar.a(obj, rect);
            }
        } else {
            rect = null;
        }
        androidx.core.h.s.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.o.6
            final /* synthetic */ androidx.b.a b;
            final /* synthetic */ Object c;
            final /* synthetic */ b d;
            final /* synthetic */ ArrayList e;
            final /* synthetic */ View f;
            final /* synthetic */ Fragment g;
            final /* synthetic */ Fragment h;
            final /* synthetic */ boolean i;
            final /* synthetic */ ArrayList j;
            final /* synthetic */ Object k;
            final /* synthetic */ Rect l;

            AnonymousClass6(androidx.b.a aVar22, Object obj32, b bVar2, ArrayList arrayList22, View view2, Fragment fragment3, Fragment fragment22, boolean z2, ArrayList arrayList3, Object obj4, Rect rect2) {
                aVar3 = aVar22;
                obj4 = obj32;
                bVar = bVar2;
                arrayList2 = arrayList22;
                view = view2;
                fragment = fragment3;
                fragment2 = fragment22;
                z = z2;
                arrayList = arrayList3;
                obj = obj4;
                rect2 = rect2;
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.b.a<String, View> a3 = o.a(q.this, (androidx.b.a<String, String>) aVar3, obj4, bVar);
                if (a3 != null) {
                    arrayList2.addAll(a3.values());
                    arrayList2.add(view);
                }
                o.a(fragment, fragment2, z, a3, false);
                if (obj4 != null) {
                    q.this.a(obj4, arrayList, arrayList2);
                    View a4 = o.a(a3, bVar, obj, z);
                    if (a4 != null) {
                        q.this.a(a4, rect2);
                    }
                }
            }
        });
        return obj32;
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.o$6 */
    static class AnonymousClass6 implements Runnable {
        final /* synthetic */ androidx.b.a b;
        final /* synthetic */ Object c;
        final /* synthetic */ b d;
        final /* synthetic */ ArrayList e;
        final /* synthetic */ View f;
        final /* synthetic */ Fragment g;
        final /* synthetic */ Fragment h;
        final /* synthetic */ boolean i;
        final /* synthetic */ ArrayList j;
        final /* synthetic */ Object k;
        final /* synthetic */ Rect l;

        AnonymousClass6(androidx.b.a aVar22, Object obj32, b bVar2, ArrayList arrayList22, View view2, Fragment fragment3, Fragment fragment22, boolean z2, ArrayList arrayList3, Object obj4, Rect rect2) {
            aVar3 = aVar22;
            obj4 = obj32;
            bVar = bVar2;
            arrayList2 = arrayList22;
            view = view2;
            fragment = fragment3;
            fragment2 = fragment22;
            z = z2;
            arrayList = arrayList3;
            obj = obj4;
            rect2 = rect2;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.b.a<String, View> a3 = o.a(q.this, (androidx.b.a<String, String>) aVar3, obj4, bVar);
            if (a3 != null) {
                arrayList2.addAll(a3.values());
                arrayList2.add(view);
            }
            o.a(fragment, fragment2, z, a3, false);
            if (obj4 != null) {
                q.this.a(obj4, arrayList, arrayList2);
                View a4 = o.a(a3, bVar, obj, z);
                if (a4 != null) {
                    q.this.a(a4, rect2);
                }
            }
        }
    }

    private static androidx.b.a<String, View> b(q qVar, androidx.b.a<String, String> aVar, Object obj, b bVar) {
        androidx.core.app.m am;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = bVar.d;
        androidx.b.a<String, View> aVar2 = new androidx.b.a<>();
        qVar.a((Map<String, View>) aVar2, fragment.E());
        androidx.fragment.app.a aVar3 = bVar.f;
        if (bVar.e) {
            am = fragment.al();
            arrayList = aVar3.r;
        } else {
            am = fragment.am();
            arrayList = aVar3.q;
        }
        if (arrayList != null) {
            aVar2.a((Collection<?>) arrayList);
        }
        if (am != null) {
            am.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(w.r(view))) {
                    aVar.put(w.r(view), aVar.remove(str));
                }
            }
        } else {
            aVar.a((Collection<?>) aVar2.keySet());
        }
        return aVar2;
    }

    static androidx.b.a<String, View> a(q qVar, androidx.b.a<String, String> aVar, Object obj, b bVar) {
        androidx.core.app.m al;
        ArrayList<String> arrayList;
        String a2;
        Fragment fragment = bVar.a;
        View D = fragment.D();
        if (aVar.isEmpty() || obj == null || D == null) {
            aVar.clear();
            return null;
        }
        androidx.b.a<String, View> aVar2 = new androidx.b.a<>();
        qVar.a((Map<String, View>) aVar2, D);
        androidx.fragment.app.a aVar3 = bVar.c;
        if (bVar.b) {
            al = fragment.am();
            arrayList = aVar3.q;
        } else {
            al = fragment.al();
            arrayList = aVar3.r;
        }
        if (arrayList != null) {
            aVar2.a((Collection<?>) arrayList);
            aVar2.a((Collection<?>) aVar.values());
        }
        if (al != null) {
            al.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    String a3 = a(aVar, str);
                    if (a3 != null) {
                        aVar.remove(a3);
                    }
                } else if (!str.equals(w.r(view)) && (a2 = a(aVar, str)) != null) {
                    aVar.put(a2, w.r(view));
                }
            }
        } else {
            a(aVar, aVar2);
        }
        return aVar2;
    }

    private static String a(androidx.b.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.c(i))) {
                return aVar.b(i);
            }
        }
        return null;
    }

    static View a(androidx.b.a<String, View> aVar, b bVar, Object obj, boolean z) {
        String str;
        androidx.fragment.app.a aVar2 = bVar.c;
        if (obj == null || aVar == null || aVar2.q == null || aVar2.q.isEmpty()) {
            return null;
        }
        if (z) {
            str = aVar2.q.get(0);
        } else {
            str = aVar2.r.get(0);
        }
        return aVar.get(str);
    }

    private static void a(q qVar, Object obj, Object obj2, androidx.b.a<String, View> aVar, boolean z, androidx.fragment.app.a aVar2) {
        String str;
        if (aVar2.q == null || aVar2.q.isEmpty()) {
            return;
        }
        if (z) {
            str = aVar2.r.get(0);
        } else {
            str = aVar2.q.get(0);
        }
        View view = aVar.get(str);
        qVar.a(obj, view);
        if (obj2 != null) {
            qVar.a(obj2, view);
        }
    }

    private static void a(androidx.b.a<String, String> aVar, androidx.b.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.c(size))) {
                aVar.d(size);
            }
        }
    }

    static void a(Fragment fragment, Fragment fragment2, boolean z, androidx.b.a<String, View> aVar, boolean z2) {
        androidx.core.app.m al;
        if (z) {
            al = fragment2.al();
        } else {
            al = fragment.al();
        }
        if (al != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(aVar.b(i));
                arrayList.add(aVar.c(i));
            }
            if (z2) {
                al.a(arrayList2, arrayList, null);
            } else {
                al.b(arrayList2, arrayList, null);
            }
        }
    }

    static ArrayList<View> a(q qVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View D = fragment.D();
        if (D != null) {
            qVar.a(arrayList2, D);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        qVar.a(obj, arrayList2);
        return arrayList2;
    }

    static void a(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    private static Object a(q qVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else if (z) {
            z2 = fragment.V();
        } else {
            z2 = fragment.U();
        }
        if (z2) {
            return qVar.a(obj2, obj, obj3);
        }
        return qVar.b(obj2, obj, obj3);
    }

    public static void a(androidx.fragment.app.a aVar, SparseArray<b> sparseArray, boolean z) {
        int size = aVar.d.size();
        for (int i = 0; i < size; i++) {
            a(aVar, aVar.d.get(i), sparseArray, false, z);
        }
    }

    public static void b(androidx.fragment.app.a aVar, SparseArray<b> sparseArray, boolean z) {
        if (aVar.a.d.a()) {
            for (int size = aVar.d.size() - 1; size >= 0; size--) {
                a(aVar, aVar.d.get(size), sparseArray, true, z);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x002d, code lost:
    
        if (r0.k != false) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0083, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0065, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0081, code lost:
    
        if (r0.y == false) goto L156;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(androidx.fragment.app.a r8, androidx.fragment.app.n.a r9, android.util.SparseArray<androidx.fragment.app.o.b> r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.o.a(androidx.fragment.app.a, androidx.fragment.app.n$a, android.util.SparseArray, boolean, boolean):void");
    }

    private static b a(b bVar, SparseArray<b> sparseArray, int i) {
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        sparseArray.put(i, bVar2);
        return bVar2;
    }

    /* compiled from: source */
    static class b {
        public Fragment a;
        public boolean b;
        public androidx.fragment.app.a c;
        public Fragment d;
        public boolean e;
        public androidx.fragment.app.a f;

        b() {
        }
    }
}
