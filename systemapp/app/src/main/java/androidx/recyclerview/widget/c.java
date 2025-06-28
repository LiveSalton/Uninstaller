package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.h.w;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class c extends k {
    private static TimeInterpolator i;
    private ArrayList<RecyclerView.v> j = new ArrayList<>();
    private ArrayList<RecyclerView.v> k = new ArrayList<>();
    private ArrayList<b> l = new ArrayList<>();
    private ArrayList<a> m = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.v>> a = new ArrayList<>();
    ArrayList<ArrayList<b>> b = new ArrayList<>();
    ArrayList<ArrayList<a>> c = new ArrayList<>();
    ArrayList<RecyclerView.v> d = new ArrayList<>();
    ArrayList<RecyclerView.v> e = new ArrayList<>();
    ArrayList<RecyclerView.v> f = new ArrayList<>();
    ArrayList<RecyclerView.v> g = new ArrayList<>();

    /* compiled from: source */
    private static class b {
        public RecyclerView.v a;
        public int b;
        public int c;
        public int d;
        public int e;

        b(RecyclerView.v vVar, int i, int i2, int i3, int i4) {
            this.a = vVar;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    /* compiled from: source */
    private static class a {
        public RecyclerView.v a;
        public RecyclerView.v b;
        public int c;
        public int d;
        public int e;
        public int f;

        private a(RecyclerView.v vVar, RecyclerView.v vVar2) {
            this.a = vVar;
            this.b = vVar2;
        }

        a(RecyclerView.v vVar, RecyclerView.v vVar2, int i, int i2, int i3, int i4) {
            this(vVar, vVar2);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public void a() {
        boolean z = !this.j.isEmpty();
        boolean z2 = !this.l.isEmpty();
        boolean z3 = !this.m.isEmpty();
        boolean z4 = !this.k.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.v> it = this.j.iterator();
            while (it.hasNext()) {
                u(it.next());
            }
            this.j.clear();
            if (z2) {
                ArrayList<b> arrayList = new ArrayList<>();
                arrayList.addAll(this.l);
                this.b.add(arrayList);
                this.l.clear();
                AnonymousClass1 anonymousClass1 = new Runnable() { // from class: androidx.recyclerview.widget.c.1
                    final /* synthetic */ ArrayList a;

                    AnonymousClass1(ArrayList arrayList2) {
                        arrayList = arrayList2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            b bVar = (b) it2.next();
                            c.this.b(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e);
                        }
                        arrayList.clear();
                        c.this.b.remove(arrayList);
                    }
                };
                if (z) {
                    w.a(arrayList2.get(0).a.a, anonymousClass1, g());
                } else {
                    anonymousClass1.run();
                }
            }
            if (z3) {
                ArrayList<a> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.m);
                this.c.add(arrayList2);
                this.m.clear();
                AnonymousClass2 anonymousClass2 = new Runnable() { // from class: androidx.recyclerview.widget.c.2
                    final /* synthetic */ ArrayList a;

                    AnonymousClass2(ArrayList arrayList22) {
                        arrayList2 = arrayList22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            c.this.a((a) it2.next());
                        }
                        arrayList2.clear();
                        c.this.c.remove(arrayList2);
                    }
                };
                if (z) {
                    w.a(arrayList22.get(0).a.a, anonymousClass2, g());
                } else {
                    anonymousClass2.run();
                }
            }
            if (z4) {
                ArrayList<RecyclerView.v> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.k);
                this.a.add(arrayList3);
                this.k.clear();
                AnonymousClass3 anonymousClass3 = new Runnable() { // from class: androidx.recyclerview.widget.c.3
                    final /* synthetic */ ArrayList a;

                    AnonymousClass3(ArrayList arrayList32) {
                        arrayList3 = arrayList32;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            c.this.c((RecyclerView.v) it2.next());
                        }
                        arrayList3.clear();
                        c.this.a.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    w.a(arrayList32.get(0).a, anonymousClass3, (z ? g() : 0L) + Math.max(z2 ? e() : 0L, z3 ? h() : 0L));
                } else {
                    anonymousClass3.run();
                }
            }
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.c$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ArrayList a;

        AnonymousClass1(ArrayList arrayList2) {
            arrayList = arrayList2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                b bVar = (b) it2.next();
                c.this.b(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e);
            }
            arrayList.clear();
            c.this.b.remove(arrayList);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.c$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ArrayList a;

        AnonymousClass2(ArrayList arrayList22) {
            arrayList2 = arrayList22;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                c.this.a((a) it2.next());
            }
            arrayList2.clear();
            c.this.c.remove(arrayList2);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.c$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ ArrayList a;

        AnonymousClass3(ArrayList arrayList32) {
            arrayList3 = arrayList32;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                c.this.c((RecyclerView.v) it2.next());
            }
            arrayList3.clear();
            c.this.a.remove(arrayList3);
        }
    }

    @Override // androidx.recyclerview.widget.k
    public boolean a(RecyclerView.v vVar) {
        v(vVar);
        this.j.add(vVar);
        return true;
    }

    private void u(RecyclerView.v vVar) {
        View view = vVar.a;
        ViewPropertyAnimator animate = view.animate();
        this.f.add(vVar);
        animate.setDuration(g()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.c.4
            final /* synthetic */ RecyclerView.v a;
            final /* synthetic */ ViewPropertyAnimator b;
            final /* synthetic */ View c;

            AnonymousClass4(RecyclerView.v vVar2, ViewPropertyAnimator animate2, View view2) {
                vVar = vVar2;
                animate = animate2;
                view = view2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                c.this.l(vVar);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                view.setAlpha(1.0f);
                c.this.i(vVar);
                c.this.f.remove(vVar);
                c.this.c();
            }
        }).start();
    }

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.c$4 */
    class AnonymousClass4 extends AnimatorListenerAdapter {
        final /* synthetic */ RecyclerView.v a;
        final /* synthetic */ ViewPropertyAnimator b;
        final /* synthetic */ View c;

        AnonymousClass4(RecyclerView.v vVar2, ViewPropertyAnimator animate2, View view2) {
            vVar = vVar2;
            animate = animate2;
            view = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.l(vVar);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            animate.setListener(null);
            view.setAlpha(1.0f);
            c.this.i(vVar);
            c.this.f.remove(vVar);
            c.this.c();
        }
    }

    @Override // androidx.recyclerview.widget.k
    public boolean b(RecyclerView.v vVar) {
        v(vVar);
        vVar.a.setAlpha(0.0f);
        this.k.add(vVar);
        return true;
    }

    void c(RecyclerView.v vVar) {
        View view = vVar.a;
        ViewPropertyAnimator animate = view.animate();
        this.d.add(vVar);
        animate.alpha(1.0f).setDuration(f()).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.c.5
            final /* synthetic */ RecyclerView.v a;
            final /* synthetic */ View b;
            final /* synthetic */ ViewPropertyAnimator c;

            AnonymousClass5(RecyclerView.v vVar2, View view2, ViewPropertyAnimator animate2) {
                vVar = vVar2;
                view = view2;
                animate = animate2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                c.this.n(vVar);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                c.this.k(vVar);
                c.this.d.remove(vVar);
                c.this.c();
            }
        }).start();
    }

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.c$5 */
    class AnonymousClass5 extends AnimatorListenerAdapter {
        final /* synthetic */ RecyclerView.v a;
        final /* synthetic */ View b;
        final /* synthetic */ ViewPropertyAnimator c;

        AnonymousClass5(RecyclerView.v vVar2, View view2, ViewPropertyAnimator animate2) {
            vVar = vVar2;
            view = view2;
            animate = animate2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.n(vVar);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            view.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            animate.setListener(null);
            c.this.k(vVar);
            c.this.d.remove(vVar);
            c.this.c();
        }
    }

    @Override // androidx.recyclerview.widget.k
    public boolean a(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
        View view = vVar.a;
        int translationX = i2 + ((int) vVar.a.getTranslationX());
        int translationY = i3 + ((int) vVar.a.getTranslationY());
        v(vVar);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            j(vVar);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.l.add(new b(vVar, translationX, translationY, i4, i5));
        return true;
    }

    void b(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
        View view = vVar.a;
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.e.add(vVar);
        animate.setDuration(e()).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.c.6
            final /* synthetic */ RecyclerView.v a;
            final /* synthetic */ int b;
            final /* synthetic */ View c;
            final /* synthetic */ int d;
            final /* synthetic */ ViewPropertyAnimator e;

            AnonymousClass6(RecyclerView.v vVar2, int i62, View view2, int i72, ViewPropertyAnimator animate2) {
                vVar = vVar2;
                i6 = i62;
                view = view2;
                i7 = i72;
                animate = animate2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                c.this.m(vVar);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i6 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i7 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                c.this.j(vVar);
                c.this.e.remove(vVar);
                c.this.c();
            }
        }).start();
    }

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.c$6 */
    class AnonymousClass6 extends AnimatorListenerAdapter {
        final /* synthetic */ RecyclerView.v a;
        final /* synthetic */ int b;
        final /* synthetic */ View c;
        final /* synthetic */ int d;
        final /* synthetic */ ViewPropertyAnimator e;

        AnonymousClass6(RecyclerView.v vVar2, int i62, View view2, int i72, ViewPropertyAnimator animate2) {
            vVar = vVar2;
            i6 = i62;
            view = view2;
            i7 = i72;
            animate = animate2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.m(vVar);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (i6 != 0) {
                view.setTranslationX(0.0f);
            }
            if (i7 != 0) {
                view.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            animate.setListener(null);
            c.this.j(vVar);
            c.this.e.remove(vVar);
            c.this.c();
        }
    }

    @Override // androidx.recyclerview.widget.k
    public boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5) {
        if (vVar == vVar2) {
            return a(vVar, i2, i3, i4, i5);
        }
        float translationX = vVar.a.getTranslationX();
        float translationY = vVar.a.getTranslationY();
        float alpha = vVar.a.getAlpha();
        v(vVar);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        vVar.a.setTranslationX(translationX);
        vVar.a.setTranslationY(translationY);
        vVar.a.setAlpha(alpha);
        if (vVar2 != null) {
            v(vVar2);
            vVar2.a.setTranslationX(-i6);
            vVar2.a.setTranslationY(-i7);
            vVar2.a.setAlpha(0.0f);
        }
        this.m.add(new a(vVar, vVar2, i2, i3, i4, i5));
        return true;
    }

    void a(a aVar) {
        RecyclerView.v vVar = aVar.a;
        View view = vVar == null ? null : vVar.a;
        RecyclerView.v vVar2 = aVar.b;
        View view2 = vVar2 != null ? vVar2.a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(h());
            this.g.add(aVar.a);
            duration.translationX(aVar.e - aVar.c);
            duration.translationY(aVar.f - aVar.d);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.c.7
                final /* synthetic */ a a;
                final /* synthetic */ ViewPropertyAnimator b;
                final /* synthetic */ View c;

                AnonymousClass7(a aVar2, ViewPropertyAnimator duration2, View view3) {
                    aVar = aVar2;
                    duration = duration2;
                    view = view3;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    c.this.b(aVar.a, true);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    c.this.a(aVar.a, true);
                    c.this.g.remove(aVar.a);
                    c.this.c();
                }
            }).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.g.add(aVar2.b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(h()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.c.8
                final /* synthetic */ a a;
                final /* synthetic */ ViewPropertyAnimator b;
                final /* synthetic */ View c;

                AnonymousClass8(a aVar2, ViewPropertyAnimator animate2, View view22) {
                    aVar = aVar2;
                    animate = animate2;
                    view2 = view22;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    c.this.b(aVar.b, false);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    animate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    c.this.a(aVar.b, false);
                    c.this.g.remove(aVar.b);
                    c.this.c();
                }
            }).start();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.c$7 */
    class AnonymousClass7 extends AnimatorListenerAdapter {
        final /* synthetic */ a a;
        final /* synthetic */ ViewPropertyAnimator b;
        final /* synthetic */ View c;

        AnonymousClass7(a aVar2, ViewPropertyAnimator duration2, View view3) {
            aVar = aVar2;
            duration = duration2;
            view = view3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.b(aVar.a, true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            duration.setListener(null);
            view.setAlpha(1.0f);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            c.this.a(aVar.a, true);
            c.this.g.remove(aVar.a);
            c.this.c();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.c$8 */
    class AnonymousClass8 extends AnimatorListenerAdapter {
        final /* synthetic */ a a;
        final /* synthetic */ ViewPropertyAnimator b;
        final /* synthetic */ View c;

        AnonymousClass8(a aVar2, ViewPropertyAnimator animate2, View view22) {
            aVar = aVar2;
            animate = animate2;
            view2 = view22;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.b(aVar.b, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            animate.setListener(null);
            view2.setAlpha(1.0f);
            view2.setTranslationX(0.0f);
            view2.setTranslationY(0.0f);
            c.this.a(aVar.b, false);
            c.this.g.remove(aVar.b);
            c.this.c();
        }
    }

    private void a(List<a> list, RecyclerView.v vVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (a(aVar, vVar) && aVar.a == null && aVar.b == null) {
                list.remove(aVar);
            }
        }
    }

    private void b(a aVar) {
        if (aVar.a != null) {
            a(aVar, aVar.a);
        }
        if (aVar.b != null) {
            a(aVar, aVar.b);
        }
    }

    private boolean a(a aVar, RecyclerView.v vVar) {
        boolean z = false;
        if (aVar.b == vVar) {
            aVar.b = null;
        } else {
            if (aVar.a != vVar) {
                return false;
            }
            aVar.a = null;
            z = true;
        }
        vVar.a.setAlpha(1.0f);
        vVar.a.setTranslationX(0.0f);
        vVar.a.setTranslationY(0.0f);
        a(vVar, z);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public void d(RecyclerView.v vVar) {
        View view = vVar.a;
        view.animate().cancel();
        int size = this.l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.l.get(size).a == vVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                j(vVar);
                this.l.remove(size);
            }
        }
        a(this.m, vVar);
        if (this.j.remove(vVar)) {
            view.setAlpha(1.0f);
            i(vVar);
        }
        if (this.k.remove(vVar)) {
            view.setAlpha(1.0f);
            k(vVar);
        }
        for (int size2 = this.c.size() - 1; size2 >= 0; size2--) {
            ArrayList<a> arrayList = this.c.get(size2);
            a(arrayList, vVar);
            if (arrayList.isEmpty()) {
                this.c.remove(size2);
            }
        }
        for (int size3 = this.b.size() - 1; size3 >= 0; size3--) {
            ArrayList<b> arrayList2 = this.b.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).a == vVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    j(vVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.b.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.a.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.v> arrayList3 = this.a.get(size5);
            if (arrayList3.remove(vVar)) {
                view.setAlpha(1.0f);
                k(vVar);
                if (arrayList3.isEmpty()) {
                    this.a.remove(size5);
                }
            }
        }
        this.f.remove(vVar);
        this.d.remove(vVar);
        this.g.remove(vVar);
        this.e.remove(vVar);
        c();
    }

    private void v(RecyclerView.v vVar) {
        if (i == null) {
            i = new ValueAnimator().getInterpolator();
        }
        vVar.a.animate().setInterpolator(i);
        d(vVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean b() {
        return (this.k.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.j.isEmpty() && this.e.isEmpty() && this.f.isEmpty() && this.d.isEmpty() && this.g.isEmpty() && this.b.isEmpty() && this.a.isEmpty() && this.c.isEmpty()) ? false : true;
    }

    void c() {
        if (b()) {
            return;
        }
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public void d() {
        int size = this.l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = this.l.get(size);
            View view = bVar.a.a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            j(bVar.a);
            this.l.remove(size);
        }
        for (int size2 = this.j.size() - 1; size2 >= 0; size2--) {
            i(this.j.get(size2));
            this.j.remove(size2);
        }
        int size3 = this.k.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.v vVar = this.k.get(size3);
            vVar.a.setAlpha(1.0f);
            k(vVar);
            this.k.remove(size3);
        }
        for (int size4 = this.m.size() - 1; size4 >= 0; size4--) {
            b(this.m.get(size4));
        }
        this.m.clear();
        if (b()) {
            for (int size5 = this.b.size() - 1; size5 >= 0; size5--) {
                ArrayList<b> arrayList = this.b.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    b bVar2 = arrayList.get(size6);
                    View view2 = bVar2.a.a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    j(bVar2.a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.b.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.a.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.v> arrayList2 = this.a.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.v vVar2 = arrayList2.get(size8);
                    vVar2.a.setAlpha(1.0f);
                    k(vVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.a.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.c.size() - 1; size9 >= 0; size9--) {
                ArrayList<a> arrayList3 = this.c.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.c.remove(arrayList3);
                    }
                }
            }
            a(this.f);
            a(this.e);
            a(this.d);
            a(this.g);
            i();
        }
    }

    void a(List<RecyclerView.v> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).a.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean a(RecyclerView.v vVar, List<Object> list) {
        return !list.isEmpty() || super.a(vVar, list);
    }
}
