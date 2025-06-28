package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public class v {
    private static Transition b = new AutoTransition();
    private static ThreadLocal<WeakReference<androidx.b.a<ViewGroup, ArrayList<Transition>>>> c = new ThreadLocal<>();
    static ArrayList<ViewGroup> a = new ArrayList<>();

    static androidx.b.a<ViewGroup, ArrayList<Transition>> a() {
        androidx.b.a<ViewGroup, ArrayList<Transition>> aVar;
        WeakReference<androidx.b.a<ViewGroup, ArrayList<Transition>>> weakReference = c.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        androidx.b.a<ViewGroup, ArrayList<Transition>> aVar2 = new androidx.b.a<>();
        c.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    private static void b(ViewGroup viewGroup, Transition transition) {
        if (transition == null || viewGroup == null) {
            return;
        }
        a aVar = new a(transition, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    /* compiled from: source */
    private static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
        Transition a;
        ViewGroup b;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        a(Transition transition, ViewGroup viewGroup) {
            this.a = transition;
            this.b = viewGroup;
        }

        private void a() {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            v.a.remove(this.b);
            ArrayList<Transition> arrayList = v.a().get(this.b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().f(this.b);
                }
            }
            this.a.b(true);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!v.a.remove(this.b)) {
                return true;
            }
            androidx.b.a<ViewGroup, ArrayList<Transition>> a = v.a();
            ArrayList<Transition> arrayList = a.get(this.b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                a.put(this.b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.a);
            this.a.a(new u() { // from class: androidx.transition.v.a.1
                final /* synthetic */ androidx.b.a a;

                AnonymousClass1(androidx.b.a a2) {
                    a = a2;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // androidx.transition.u, androidx.transition.Transition.c
                public void b(Transition transition) {
                    ((ArrayList) a.get(a.this.b)).remove(transition);
                    transition.b(this);
                }
            });
            this.a.a(this.b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).f(this.b);
                }
            }
            this.a.a(this.b);
            return true;
        }

        /* compiled from: source */
        /* renamed from: androidx.transition.v$a$1 */
        class AnonymousClass1 extends u {
            final /* synthetic */ androidx.b.a a;

            AnonymousClass1(androidx.b.a a2) {
                a = a2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.transition.u, androidx.transition.Transition.c
            public void b(Transition transition) {
                ((ArrayList) a.get(a.this.b)).remove(transition);
                transition.b(this);
            }
        }
    }

    private static void c(ViewGroup viewGroup, Transition transition) {
        ArrayList<Transition> arrayList = a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Transition> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().e(viewGroup);
            }
        }
        if (transition != null) {
            transition.a(viewGroup, true);
        }
        r a2 = r.a(viewGroup);
        if (a2 != null) {
            a2.a();
        }
    }

    public static void a(ViewGroup viewGroup, Transition transition) {
        if (a.contains(viewGroup) || !androidx.core.h.w.C(viewGroup)) {
            return;
        }
        a.add(viewGroup);
        if (transition == null) {
            transition = b;
        }
        Transition clone = transition.clone();
        c(viewGroup, clone);
        r.a(viewGroup, null);
        b(viewGroup, clone);
    }
}
