package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.d.a;
import androidx.fragment.app.Fragment;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class e extends androidx.fragment.app.q {
    @Override // androidx.fragment.app.q
    public boolean a(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.q
    public Object b(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.q
    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.a((Transition) obj);
        return transitionSet;
    }

    @Override // androidx.fragment.app.q
    public void a(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> g = transitionSet.g();
        g.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a(g, arrayList.get(i));
        }
        g.add(view);
        arrayList.add(view);
        a(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.q
    public void a(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            a(view, rect);
            ((Transition) obj).a(new Transition.b() { // from class: androidx.transition.e.1
                final /* synthetic */ Rect a;

                AnonymousClass1(Rect rect2) {
                    rect = rect2;
                }

                @Override // androidx.transition.Transition.b
                public Rect a(Transition transition) {
                    return rect;
                }
            });
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.e$1 */
    class AnonymousClass1 extends Transition.b {
        final /* synthetic */ Rect a;

        AnonymousClass1(Rect rect2) {
            rect = rect2;
        }

        @Override // androidx.transition.Transition.b
        public Rect a(Transition transition) {
            return rect;
        }
    }

    @Override // androidx.fragment.app.q
    public void a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int s = transitionSet.s();
            while (i < s) {
                a(transitionSet.b(i), arrayList);
                i++;
            }
            return;
        }
        if (a(transition) || !a((List) transition.g())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            transition.c(arrayList.get(i));
            i++;
        }
    }

    private static boolean a(Transition transition) {
        return (a((List) transition.f()) && a((List) transition.h()) && a((List) transition.i())) ? false : true;
    }

    @Override // androidx.fragment.app.q
    public Object a(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.a((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.a((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.a((Transition) obj3);
        }
        return transitionSet;
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.e$2 */
    class AnonymousClass2 implements Transition.c {
        final /* synthetic */ View a;
        final /* synthetic */ ArrayList b;

        @Override // androidx.transition.Transition.c
        public void a(Transition transition) {
        }

        @Override // androidx.transition.Transition.c
        public void c(Transition transition) {
        }

        @Override // androidx.transition.Transition.c
        public void d(Transition transition) {
        }

        AnonymousClass2(View view, ArrayList arrayList) {
            view = view;
            arrayList = arrayList;
        }

        @Override // androidx.transition.Transition.c
        public void e(Transition transition) {
            transition.b(this);
            transition.a(this);
        }

        @Override // androidx.transition.Transition.c
        public void b(Transition transition) {
            transition.b(this);
            view.setVisibility(8);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((View) arrayList.get(i)).setVisibility(0);
            }
        }
    }

    @Override // androidx.fragment.app.q
    public void b(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).a(new Transition.c() { // from class: androidx.transition.e.2
            final /* synthetic */ View a;
            final /* synthetic */ ArrayList b;

            @Override // androidx.transition.Transition.c
            public void a(Transition transition) {
            }

            @Override // androidx.transition.Transition.c
            public void c(Transition transition) {
            }

            @Override // androidx.transition.Transition.c
            public void d(Transition transition) {
            }

            AnonymousClass2(View view2, ArrayList arrayList2) {
                view = view2;
                arrayList = arrayList2;
            }

            @Override // androidx.transition.Transition.c
            public void e(Transition transition) {
                transition.b(this);
                transition.a(this);
            }

            @Override // androidx.transition.Transition.c
            public void b(Transition transition) {
                transition.b(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }
        });
    }

    @Override // androidx.fragment.app.q
    public Object b(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().a(transition).a(transition2).a(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.a(transition);
        }
        transitionSet.a(transition3);
        return transitionSet;
    }

    @Override // androidx.fragment.app.q
    public void a(ViewGroup viewGroup, Object obj) {
        v.a(viewGroup, (Transition) obj);
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.e$3 */
    class AnonymousClass3 extends u {
        final /* synthetic */ Object a;
        final /* synthetic */ ArrayList b;
        final /* synthetic */ Object c;
        final /* synthetic */ ArrayList d;
        final /* synthetic */ Object e;
        final /* synthetic */ ArrayList f;

        AnonymousClass3(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            obj2 = obj;
            arrayList = arrayList;
            obj3 = obj2;
            arrayList2 = arrayList2;
            obj4 = obj3;
            arrayList3 = arrayList3;
        }

        @Override // androidx.transition.u, androidx.transition.Transition.c
        public void e(Transition transition) {
            if (obj2 != null) {
                e.this.b(obj2, arrayList, (ArrayList<View>) null);
            }
            if (obj3 != null) {
                e.this.b(obj3, arrayList2, (ArrayList<View>) null);
            }
            if (obj4 != null) {
                e.this.b(obj4, arrayList3, (ArrayList<View>) null);
            }
        }

        @Override // androidx.transition.u, androidx.transition.Transition.c
        public void b(Transition transition) {
            transition.b(this);
        }
    }

    @Override // androidx.fragment.app.q
    public void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).a(new u() { // from class: androidx.transition.e.3
            final /* synthetic */ Object a;
            final /* synthetic */ ArrayList b;
            final /* synthetic */ Object c;
            final /* synthetic */ ArrayList d;
            final /* synthetic */ Object e;
            final /* synthetic */ ArrayList f;

            AnonymousClass3(Object obj22, ArrayList arrayList4, Object obj32, ArrayList arrayList22, Object obj42, ArrayList arrayList32) {
                obj2 = obj22;
                arrayList = arrayList4;
                obj3 = obj32;
                arrayList2 = arrayList22;
                obj4 = obj42;
                arrayList3 = arrayList32;
            }

            @Override // androidx.transition.u, androidx.transition.Transition.c
            public void e(Transition transition) {
                if (obj2 != null) {
                    e.this.b(obj2, arrayList, (ArrayList<View>) null);
                }
                if (obj3 != null) {
                    e.this.b(obj3, arrayList2, (ArrayList<View>) null);
                }
                if (obj4 != null) {
                    e.this.b(obj4, arrayList3, (ArrayList<View>) null);
                }
            }

            @Override // androidx.transition.u, androidx.transition.Transition.c
            public void b(Transition transition) {
                transition.b(this);
            }
        });
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.e$4 */
    class AnonymousClass4 implements a.InterfaceC0020a {
        final /* synthetic */ Transition a;

        AnonymousClass4(Transition transition) {
            transition = transition;
        }

        @Override // androidx.core.d.a.InterfaceC0020a
        public void a() {
            transition.l();
        }
    }

    @Override // androidx.fragment.app.q
    public void a(Fragment fragment, Object obj, androidx.core.d.a aVar, Runnable runnable) {
        Transition transition = (Transition) obj;
        aVar.a(new a.InterfaceC0020a() { // from class: androidx.transition.e.4
            final /* synthetic */ Transition a;

            AnonymousClass4(Transition transition2) {
                transition = transition2;
            }

            @Override // androidx.core.d.a.InterfaceC0020a
            public void a() {
                transition.l();
            }
        });
        transition2.a(new Transition.c() { // from class: androidx.transition.e.5
            final /* synthetic */ Runnable a;

            @Override // androidx.transition.Transition.c
            public void a(Transition transition2) {
            }

            @Override // androidx.transition.Transition.c
            public void c(Transition transition2) {
            }

            @Override // androidx.transition.Transition.c
            public void d(Transition transition2) {
            }

            @Override // androidx.transition.Transition.c
            public void e(Transition transition2) {
            }

            AnonymousClass5(Runnable runnable2) {
                runnable = runnable2;
            }

            @Override // androidx.transition.Transition.c
            public void b(Transition transition2) {
                runnable.run();
            }
        });
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.e$5 */
    class AnonymousClass5 implements Transition.c {
        final /* synthetic */ Runnable a;

        @Override // androidx.transition.Transition.c
        public void a(Transition transition2) {
        }

        @Override // androidx.transition.Transition.c
        public void c(Transition transition2) {
        }

        @Override // androidx.transition.Transition.c
        public void d(Transition transition2) {
        }

        @Override // androidx.transition.Transition.c
        public void e(Transition transition2) {
        }

        AnonymousClass5(Runnable runnable2) {
            runnable = runnable2;
        }

        @Override // androidx.transition.Transition.c
        public void b(Transition transition2) {
            runnable.run();
        }
    }

    @Override // androidx.fragment.app.q
    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.g().clear();
            transitionSet.g().addAll(arrayList2);
            b((Object) transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.q
    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int s = transitionSet.s();
            while (i < s) {
                b((Object) transitionSet.b(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (a(transition)) {
            return;
        }
        List<View> g = transition.g();
        if (g.size() == arrayList.size() && g.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size) {
                transition.c(arrayList2.get(i));
                i++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                transition.d(arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.q
    public void b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).c(view);
        }
    }

    @Override // androidx.fragment.app.q
    public void c(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).d(view);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.e$6 */
    class AnonymousClass6 extends Transition.b {
        final /* synthetic */ Rect a;

        AnonymousClass6(Rect rect) {
            rect = rect;
        }

        @Override // androidx.transition.Transition.b
        public Rect a(Transition transition) {
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return rect;
        }
    }

    @Override // androidx.fragment.app.q
    public void a(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).a(new Transition.b() { // from class: androidx.transition.e.6
                final /* synthetic */ Rect a;

                AnonymousClass6(Rect rect2) {
                    rect = rect2;
                }

                @Override // androidx.transition.Transition.b
                public Rect a(Transition transition) {
                    if (rect == null || rect.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }
}
