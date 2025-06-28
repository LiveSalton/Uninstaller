package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
class p extends q {
    p() {
    }

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
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    @Override // androidx.fragment.app.q
    public void a(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a(targets, arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        a(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.q
    public void a(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            a(view, rect);
            ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.fragment.app.p.1
                final /* synthetic */ Rect a;

                AnonymousClass1(Rect rect2) {
                    rect = rect2;
                }

                @Override // android.transition.Transition.EpicenterCallback
                public Rect onGetEpicenter(Transition transition) {
                    return rect;
                }
            });
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.p$1 */
    class AnonymousClass1 extends Transition.EpicenterCallback {
        final /* synthetic */ Rect a;

        AnonymousClass1(Rect rect2) {
            rect = rect2;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
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
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                a(transitionSet.getTransitionAt(i), arrayList);
                i++;
            }
            return;
        }
        if (a(transition) || !a((List) transition.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            transition.addTarget(arrayList.get(i));
            i++;
        }
    }

    private static boolean a(Transition transition) {
        return (a((List) transition.getTargetIds()) && a((List) transition.getTargetNames()) && a((List) transition.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.q
    public Object a(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.p$2 */
    class AnonymousClass2 implements Transition.TransitionListener {
        final /* synthetic */ View a;
        final /* synthetic */ ArrayList b;

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        AnonymousClass2(View view, ArrayList arrayList) {
            view = view;
            arrayList = arrayList;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            transition.removeListener(this);
            transition.addListener(this);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            view.setVisibility(8);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((View) arrayList.get(i)).setVisibility(0);
            }
        }
    }

    @Override // androidx.fragment.app.q
    public void b(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new Transition.TransitionListener() { // from class: androidx.fragment.app.p.2
            final /* synthetic */ View a;
            final /* synthetic */ ArrayList b;

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
            }

            AnonymousClass2(View view2, ArrayList arrayList2) {
                view = view2;
                arrayList = arrayList2;
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                transition.removeListener(this);
                transition.addListener(this);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
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
            transition = new TransitionSet().addTransition(transition).addTransition(transition2).setOrdering(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    @Override // androidx.fragment.app.q
    public void a(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.p$3 */
    class AnonymousClass3 implements Transition.TransitionListener {
        final /* synthetic */ Object a;
        final /* synthetic */ ArrayList b;
        final /* synthetic */ Object c;
        final /* synthetic */ ArrayList d;
        final /* synthetic */ Object e;
        final /* synthetic */ ArrayList f;

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        AnonymousClass3(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            obj2 = obj;
            arrayList = arrayList;
            obj3 = obj2;
            arrayList2 = arrayList2;
            obj4 = obj3;
            arrayList3 = arrayList3;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            if (obj2 != null) {
                p.this.b(obj2, arrayList, (ArrayList<View>) null);
            }
            if (obj3 != null) {
                p.this.b(obj3, arrayList2, (ArrayList<View>) null);
            }
            if (obj4 != null) {
                p.this.b(obj4, arrayList3, (ArrayList<View>) null);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }
    }

    @Override // androidx.fragment.app.q
    public void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new Transition.TransitionListener() { // from class: androidx.fragment.app.p.3
            final /* synthetic */ Object a;
            final /* synthetic */ ArrayList b;
            final /* synthetic */ Object c;
            final /* synthetic */ ArrayList d;
            final /* synthetic */ Object e;
            final /* synthetic */ ArrayList f;

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
            }

            AnonymousClass3(Object obj22, ArrayList arrayList4, Object obj32, ArrayList arrayList22, Object obj42, ArrayList arrayList32) {
                obj2 = obj22;
                arrayList = arrayList4;
                obj3 = obj32;
                arrayList2 = arrayList22;
                obj4 = obj42;
                arrayList3 = arrayList32;
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                if (obj2 != null) {
                    p.this.b(obj2, arrayList, (ArrayList<View>) null);
                }
                if (obj3 != null) {
                    p.this.b(obj3, arrayList2, (ArrayList<View>) null);
                }
                if (obj4 != null) {
                    p.this.b(obj4, arrayList3, (ArrayList<View>) null);
                }
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
            }
        });
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.p$4 */
    class AnonymousClass4 implements Transition.TransitionListener {
        final /* synthetic */ Runnable a;

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }

        AnonymousClass4(Runnable runnable) {
            runnable = runnable;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            runnable.run();
        }
    }

    @Override // androidx.fragment.app.q
    public void a(Fragment fragment, Object obj, androidx.core.d.a aVar, Runnable runnable) {
        ((Transition) obj).addListener(new Transition.TransitionListener() { // from class: androidx.fragment.app.p.4
            final /* synthetic */ Runnable a;

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
            }

            AnonymousClass4(Runnable runnable2) {
                runnable = runnable2;
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                runnable.run();
            }
        });
    }

    @Override // androidx.fragment.app.q
    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            b((Object) transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.q
    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        List<View> targets;
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                b((Object) transitionSet.getTransitionAt(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (a(transition) || (targets = transition.getTargets()) == null || targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
            return;
        }
        int size = arrayList2 == null ? 0 : arrayList2.size();
        while (i < size) {
            transition.addTarget(arrayList2.get(i));
            i++;
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            transition.removeTarget(arrayList.get(size2));
        }
    }

    @Override // androidx.fragment.app.q
    public void b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.q
    public void c(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.p$5 */
    class AnonymousClass5 extends Transition.EpicenterCallback {
        final /* synthetic */ Rect a;

        AnonymousClass5(Rect rect) {
            rect = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return rect;
        }
    }

    @Override // androidx.fragment.app.q
    public void a(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.fragment.app.p.5
                final /* synthetic */ Rect a;

                AnonymousClass5(Rect rect2) {
                    rect = rect2;
                }

                @Override // android.transition.Transition.EpicenterCallback
                public Rect onGetEpicenter(Transition transition) {
                    if (rect == null || rect.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }
}
