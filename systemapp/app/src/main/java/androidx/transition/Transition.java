package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class Transition implements Cloneable {
    private b H;
    private androidx.b.a<String, String> I;
    w h;
    private ArrayList<y> y;
    private ArrayList<y> z;
    private static final int[] a = {2, 1, 3, 4};
    private static final PathMotion i = new PathMotion() { // from class: androidx.transition.Transition.1
        AnonymousClass1() {
        }

        @Override // androidx.transition.PathMotion
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };
    private static ThreadLocal<androidx.b.a<Animator, a>> A = new ThreadLocal<>();
    private String j = getClass().getName();
    private long k = -1;
    long b = -1;
    private TimeInterpolator l = null;
    ArrayList<Integer> c = new ArrayList<>();
    ArrayList<View> d = new ArrayList<>();
    private ArrayList<String> m = null;
    private ArrayList<Class<?>> n = null;
    private ArrayList<Integer> o = null;
    private ArrayList<View> p = null;
    private ArrayList<Class<?>> q = null;
    private ArrayList<String> r = null;
    private ArrayList<Integer> s = null;
    private ArrayList<View> t = null;
    private ArrayList<Class<?>> u = null;
    private z v = new z();
    private z w = new z();
    TransitionSet e = null;
    private int[] x = a;
    private ViewGroup B = null;
    boolean f = false;
    ArrayList<Animator> g = new ArrayList<>();
    private int C = 0;
    private boolean D = false;
    private boolean E = false;
    private ArrayList<c> F = null;
    private ArrayList<Animator> G = new ArrayList<>();
    private PathMotion J = i;

    /* compiled from: source */
    public static abstract class b {
        public abstract Rect a(Transition transition);
    }

    /* compiled from: source */
    public interface c {
        void a(Transition transition);

        void b(Transition transition);

        void c(Transition transition);

        void d(Transition transition);

        void e(Transition transition);
    }

    private static boolean a(int i2) {
        return i2 >= 1 && i2 <= 4;
    }

    public Animator a(ViewGroup viewGroup, y yVar, y yVar2) {
        return null;
    }

    public abstract void a(y yVar);

    public String[] a() {
        return null;
    }

    public abstract void b(y yVar);

    /* compiled from: source */
    /* renamed from: androidx.transition.Transition$1 */
    static class AnonymousClass1 extends PathMotion {
        AnonymousClass1() {
        }

        @Override // androidx.transition.PathMotion
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    public Transition() {
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long a2 = androidx.core.content.a.g.a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "duration", 1, -1);
        if (a2 >= 0) {
            a(a2);
        }
        long a3 = androidx.core.content.a.g.a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "startDelay", 2, -1);
        if (a3 > 0) {
            b(a3);
        }
        int c2 = androidx.core.content.a.g.c(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (c2 > 0) {
            a(AnimationUtils.loadInterpolator(context, c2));
        }
        String a4 = androidx.core.content.a.g.a(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (a4 != null) {
            a(b(a4));
        }
        obtainStyledAttributes.recycle();
    }

    private static int[] b(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i2] = 3;
            } else if ("instance".equalsIgnoreCase(trim)) {
                iArr[i2] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i2] = 2;
            } else if ("itemId".equalsIgnoreCase(trim)) {
                iArr[i2] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                i2--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i2++;
        }
        return iArr;
    }

    public Transition a(long j) {
        this.b = j;
        return this;
    }

    public long b() {
        return this.b;
    }

    public Transition b(long j) {
        this.k = j;
        return this;
    }

    public long c() {
        return this.k;
    }

    public Transition a(TimeInterpolator timeInterpolator) {
        this.l = timeInterpolator;
        return this;
    }

    public TimeInterpolator d() {
        return this.l;
    }

    public void a(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.x = a;
            return;
        }
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (!a(iArr[i2])) {
                throw new IllegalArgumentException("matches contains invalid value");
            }
            if (a(iArr, i2)) {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.x = (int[]) iArr.clone();
    }

    private static boolean a(int[] iArr, int i2) {
        int i3 = iArr[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            if (iArr[i4] == i3) {
                return true;
            }
        }
        return false;
    }

    private void a(androidx.b.a<View, y> aVar, androidx.b.a<View, y> aVar2) {
        y remove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View b2 = aVar.b(size);
            if (b2 != null && b(b2) && (remove = aVar2.remove(b2)) != null && b(remove.b)) {
                this.y.add(aVar.d(size));
                this.z.add(remove);
            }
        }
    }

    private void a(androidx.b.a<View, y> aVar, androidx.b.a<View, y> aVar2, androidx.b.d<View> dVar, androidx.b.d<View> dVar2) {
        View a2;
        int b2 = dVar.b();
        for (int i2 = 0; i2 < b2; i2++) {
            View c2 = dVar.c(i2);
            if (c2 != null && b(c2) && (a2 = dVar2.a(dVar.b(i2))) != null && b(a2)) {
                y yVar = aVar.get(c2);
                y yVar2 = aVar2.get(a2);
                if (yVar != null && yVar2 != null) {
                    this.y.add(yVar);
                    this.z.add(yVar2);
                    aVar.remove(c2);
                    aVar2.remove(a2);
                }
            }
        }
    }

    private void a(androidx.b.a<View, y> aVar, androidx.b.a<View, y> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            View valueAt = sparseArray.valueAt(i2);
            if (valueAt != null && b(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i2))) != null && b(view)) {
                y yVar = aVar.get(valueAt);
                y yVar2 = aVar2.get(view);
                if (yVar != null && yVar2 != null) {
                    this.y.add(yVar);
                    this.z.add(yVar2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void a(androidx.b.a<View, y> aVar, androidx.b.a<View, y> aVar2, androidx.b.a<String, View> aVar3, androidx.b.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i2 = 0; i2 < size; i2++) {
            View c2 = aVar3.c(i2);
            if (c2 != null && b(c2) && (view = aVar4.get(aVar3.b(i2))) != null && b(view)) {
                y yVar = aVar.get(c2);
                y yVar2 = aVar2.get(view);
                if (yVar != null && yVar2 != null) {
                    this.y.add(yVar);
                    this.z.add(yVar2);
                    aVar.remove(c2);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void b(androidx.b.a<View, y> aVar, androidx.b.a<View, y> aVar2) {
        for (int i2 = 0; i2 < aVar.size(); i2++) {
            y c2 = aVar.c(i2);
            if (b(c2.b)) {
                this.y.add(c2);
                this.z.add(null);
            }
        }
        for (int i3 = 0; i3 < aVar2.size(); i3++) {
            y c3 = aVar2.c(i3);
            if (b(c3.b)) {
                this.z.add(c3);
                this.y.add(null);
            }
        }
    }

    private void a(z zVar, z zVar2) {
        androidx.b.a<View, y> aVar = new androidx.b.a<>(zVar.a);
        androidx.b.a<View, y> aVar2 = new androidx.b.a<>(zVar2.a);
        for (int i2 = 0; i2 < this.x.length; i2++) {
            switch (this.x[i2]) {
                case 1:
                    a(aVar, aVar2);
                    break;
                case 2:
                    a(aVar, aVar2, zVar.d, zVar2.d);
                    break;
                case 3:
                    a(aVar, aVar2, zVar.b, zVar2.b);
                    break;
                case 4:
                    a(aVar, aVar2, zVar.c, zVar2.c);
                    break;
            }
        }
        b(aVar, aVar2);
    }

    protected void a(ViewGroup viewGroup, z zVar, z zVar2, ArrayList<y> arrayList, ArrayList<y> arrayList2) {
        Animator a2;
        int i2;
        int i3;
        View view;
        Animator animator;
        y yVar;
        Animator animator2;
        y yVar2;
        androidx.b.a<Animator, a> s = s();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = Long.MAX_VALUE;
        int i4 = 0;
        while (i4 < size) {
            y yVar3 = arrayList.get(i4);
            y yVar4 = arrayList2.get(i4);
            if (yVar3 != null && !yVar3.c.contains(this)) {
                yVar3 = null;
            }
            if (yVar4 != null && !yVar4.c.contains(this)) {
                yVar4 = null;
            }
            if (yVar3 != null || yVar4 != null) {
                if ((yVar3 == null || yVar4 == null || a(yVar3, yVar4)) && (a2 = a(viewGroup, yVar3, yVar4)) != null) {
                    if (yVar4 != null) {
                        view = yVar4.b;
                        String[] a3 = a();
                        if (a3 != null && a3.length > 0) {
                            yVar2 = new y(view);
                            i2 = size;
                            y yVar5 = zVar2.a.get(view);
                            if (yVar5 != null) {
                                int i5 = 0;
                                while (i5 < a3.length) {
                                    yVar2.a.put(a3[i5], yVar5.a.get(a3[i5]));
                                    i5++;
                                    i4 = i4;
                                    yVar5 = yVar5;
                                }
                            }
                            i3 = i4;
                            int size2 = s.size();
                            int i6 = 0;
                            while (true) {
                                if (i6 >= size2) {
                                    animator2 = a2;
                                    break;
                                }
                                a aVar = s.get(s.b(i6));
                                if (aVar.c != null && aVar.a == view && aVar.b.equals(r()) && aVar.c.equals(yVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i6++;
                            }
                        } else {
                            i2 = size;
                            i3 = i4;
                            animator2 = a2;
                            yVar2 = null;
                        }
                        animator = animator2;
                        yVar = yVar2;
                    } else {
                        i2 = size;
                        i3 = i4;
                        view = yVar3.b;
                        animator = a2;
                        yVar = null;
                    }
                    if (animator != null) {
                        if (this.h != null) {
                            long a4 = this.h.a(viewGroup, this, yVar3, yVar4);
                            sparseIntArray.put(this.G.size(), (int) a4);
                            j = Math.min(a4, j);
                        }
                        s.put(animator, new a(view, r(), this, aj.b(viewGroup), yVar));
                        this.G.add(animator);
                        j = j;
                    }
                    i4 = i3 + 1;
                    size = i2;
                }
            }
            i2 = size;
            i3 = i4;
            i4 = i3 + 1;
            size = i2;
        }
        if (sparseIntArray.size() != 0) {
            for (int i7 = 0; i7 < sparseIntArray.size(); i7++) {
                Animator animator3 = this.G.get(sparseIntArray.keyAt(i7));
                animator3.setStartDelay((sparseIntArray.valueAt(i7) - j) + animator3.getStartDelay());
            }
        }
    }

    boolean b(View view) {
        int id = view.getId();
        if (this.o != null && this.o.contains(Integer.valueOf(id))) {
            return false;
        }
        if (this.p != null && this.p.contains(view)) {
            return false;
        }
        if (this.q != null) {
            int size = this.q.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.q.get(i2).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.r != null && androidx.core.h.w.r(view) != null && this.r.contains(androidx.core.h.w.r(view))) {
            return false;
        }
        if ((this.c.size() == 0 && this.d.size() == 0 && ((this.n == null || this.n.isEmpty()) && (this.m == null || this.m.isEmpty()))) || this.c.contains(Integer.valueOf(id)) || this.d.contains(view)) {
            return true;
        }
        if (this.m != null && this.m.contains(androidx.core.h.w.r(view))) {
            return true;
        }
        if (this.n != null) {
            for (int i3 = 0; i3 < this.n.size(); i3++) {
                if (this.n.get(i3).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static androidx.b.a<Animator, a> s() {
        androidx.b.a<Animator, a> aVar = A.get();
        if (aVar != null) {
            return aVar;
        }
        androidx.b.a<Animator, a> aVar2 = new androidx.b.a<>();
        A.set(aVar2);
        return aVar2;
    }

    protected void e() {
        j();
        androidx.b.a<Animator, a> s = s();
        Iterator<Animator> it = this.G.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (s.containsKey(next)) {
                j();
                a(next, s);
            }
        }
        this.G.clear();
        k();
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.Transition$2 */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ androidx.b.a a;

        AnonymousClass2(androidx.b.a aVar) {
            aVar = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Transition.this.g.add(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            aVar.remove(animator);
            Transition.this.g.remove(animator);
        }
    }

    private void a(Animator animator, androidx.b.a<Animator, a> aVar) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.Transition.2
                final /* synthetic */ androidx.b.a a;

                AnonymousClass2(androidx.b.a aVar2) {
                    aVar = aVar2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    Transition.this.g.add(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    aVar.remove(animator2);
                    Transition.this.g.remove(animator2);
                }
            });
            a(animator);
        }
    }

    public Transition c(View view) {
        this.d.add(view);
        return this;
    }

    public Transition d(View view) {
        this.d.remove(view);
        return this;
    }

    public List<Integer> f() {
        return this.c;
    }

    public List<View> g() {
        return this.d;
    }

    public List<String> h() {
        return this.m;
    }

    public List<Class<?>> i() {
        return this.n;
    }

    void a(ViewGroup viewGroup, boolean z) {
        b(z);
        if ((this.c.size() > 0 || this.d.size() > 0) && ((this.m == null || this.m.isEmpty()) && (this.n == null || this.n.isEmpty()))) {
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.c.get(i2).intValue());
                if (findViewById != null) {
                    y yVar = new y(findViewById);
                    if (z) {
                        a(yVar);
                    } else {
                        b(yVar);
                    }
                    yVar.c.add(this);
                    c(yVar);
                    if (z) {
                        a(this.v, findViewById, yVar);
                    } else {
                        a(this.w, findViewById, yVar);
                    }
                }
            }
            for (int i3 = 0; i3 < this.d.size(); i3++) {
                View view = this.d.get(i3);
                y yVar2 = new y(view);
                if (z) {
                    a(yVar2);
                } else {
                    b(yVar2);
                }
                yVar2.c.add(this);
                c(yVar2);
                if (z) {
                    a(this.v, view, yVar2);
                } else {
                    a(this.w, view, yVar2);
                }
            }
        } else {
            c(viewGroup, z);
        }
        if (z || this.I == null) {
            return;
        }
        int size = this.I.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(this.v.d.remove(this.I.b(i4)));
        }
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = (View) arrayList.get(i5);
            if (view2 != null) {
                this.v.d.put(this.I.c(i5), view2);
            }
        }
    }

    private static void a(z zVar, View view, y yVar) {
        zVar.a.put(view, yVar);
        int id = view.getId();
        if (id >= 0) {
            if (zVar.b.indexOfKey(id) >= 0) {
                zVar.b.put(id, null);
            } else {
                zVar.b.put(id, view);
            }
        }
        String r = androidx.core.h.w.r(view);
        if (r != null) {
            if (zVar.d.containsKey(r)) {
                zVar.d.put(r, null);
            } else {
                zVar.d.put(r, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (zVar.c.c(itemIdAtPosition) >= 0) {
                    View a2 = zVar.c.a(itemIdAtPosition);
                    if (a2 != null) {
                        androidx.core.h.w.a(a2, false);
                        zVar.c.b(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                androidx.core.h.w.a(view, true);
                zVar.c.b(itemIdAtPosition, view);
            }
        }
    }

    void b(boolean z) {
        if (z) {
            this.v.a.clear();
            this.v.b.clear();
            this.v.c.c();
        } else {
            this.w.a.clear();
            this.w.b.clear();
            this.w.c.c();
        }
    }

    private void c(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (this.o == null || !this.o.contains(Integer.valueOf(id))) {
            if (this.p == null || !this.p.contains(view)) {
                if (this.q != null) {
                    int size = this.q.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.q.get(i2).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    y yVar = new y(view);
                    if (z) {
                        a(yVar);
                    } else {
                        b(yVar);
                    }
                    yVar.c.add(this);
                    c(yVar);
                    if (z) {
                        a(this.v, view, yVar);
                    } else {
                        a(this.w, view, yVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    if (this.s == null || !this.s.contains(Integer.valueOf(id))) {
                        if (this.t == null || !this.t.contains(view)) {
                            if (this.u != null) {
                                int size2 = this.u.size();
                                for (int i3 = 0; i3 < size2; i3++) {
                                    if (this.u.get(i3).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                c(viewGroup.getChildAt(i4), z);
                            }
                        }
                    }
                }
            }
        }
    }

    public y a(View view, boolean z) {
        if (this.e != null) {
            return this.e.a(view, z);
        }
        return (z ? this.v : this.w).a.get(view);
    }

    y b(View view, boolean z) {
        if (this.e != null) {
            return this.e.b(view, z);
        }
        ArrayList<y> arrayList = z ? this.y : this.z;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            y yVar = arrayList.get(i3);
            if (yVar == null) {
                return null;
            }
            if (yVar.b == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 >= 0) {
            return (z ? this.z : this.y).get(i2);
        }
        return null;
    }

    public void e(View view) {
        if (this.E) {
            return;
        }
        androidx.b.a<Animator, a> s = s();
        int size = s.size();
        at b2 = aj.b(view);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            a c2 = s.c(i2);
            if (c2.a != null && b2.equals(c2.d)) {
                androidx.transition.a.a(s.b(i2));
            }
        }
        if (this.F != null && this.F.size() > 0) {
            ArrayList arrayList = (ArrayList) this.F.clone();
            int size2 = arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ((c) arrayList.get(i3)).c(this);
            }
        }
        this.D = true;
    }

    public void f(View view) {
        if (this.D) {
            if (!this.E) {
                androidx.b.a<Animator, a> s = s();
                int size = s.size();
                at b2 = aj.b(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    a c2 = s.c(i2);
                    if (c2.a != null && b2.equals(c2.d)) {
                        androidx.transition.a.b(s.b(i2));
                    }
                }
                if (this.F != null && this.F.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.F.clone();
                    int size2 = arrayList.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((c) arrayList.get(i3)).d(this);
                    }
                }
            }
            this.D = false;
        }
    }

    void a(ViewGroup viewGroup) {
        a aVar;
        this.y = new ArrayList<>();
        this.z = new ArrayList<>();
        a(this.v, this.w);
        androidx.b.a<Animator, a> s = s();
        int size = s.size();
        at b2 = aj.b(viewGroup);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator b3 = s.b(i2);
            if (b3 != null && (aVar = s.get(b3)) != null && aVar.a != null && b2.equals(aVar.d)) {
                y yVar = aVar.c;
                View view = aVar.a;
                y a2 = a(view, true);
                y b4 = b(view, true);
                if (a2 == null && b4 == null) {
                    b4 = this.w.a.get(view);
                }
                if (!(a2 == null && b4 == null) && aVar.e.a(yVar, b4)) {
                    if (b3.isRunning() || b3.isStarted()) {
                        b3.cancel();
                    } else {
                        s.remove(b3);
                    }
                }
            }
        }
        a(viewGroup, this.v, this.w, this.y, this.z);
        e();
    }

    public boolean a(y yVar, y yVar2) {
        if (yVar == null || yVar2 == null) {
            return false;
        }
        String[] a2 = a();
        if (a2 != null) {
            for (String str : a2) {
                if (!a(yVar, yVar2, str)) {
                }
            }
            return false;
        }
        Iterator<String> it = yVar.a.keySet().iterator();
        while (it.hasNext()) {
            if (a(yVar, yVar2, it.next())) {
            }
        }
        return false;
        return true;
    }

    private static boolean a(y yVar, y yVar2, String str) {
        Object obj = yVar.a.get(str);
        Object obj2 = yVar2.a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    protected void a(Animator animator) {
        if (animator == null) {
            k();
            return;
        }
        if (b() >= 0) {
            animator.setDuration(b());
        }
        if (c() >= 0) {
            animator.setStartDelay(c() + animator.getStartDelay());
        }
        if (d() != null) {
            animator.setInterpolator(d());
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.Transition.3
            AnonymousClass3() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Transition.this.k();
                animator2.removeListener(this);
            }
        });
        animator.start();
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.Transition$3 */
    class AnonymousClass3 extends AnimatorListenerAdapter {
        AnonymousClass3() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator2) {
            Transition.this.k();
            animator2.removeListener(this);
        }
    }

    protected void j() {
        if (this.C == 0) {
            if (this.F != null && this.F.size() > 0) {
                ArrayList arrayList = (ArrayList) this.F.clone();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((c) arrayList.get(i2)).e(this);
                }
            }
            this.E = false;
        }
        this.C++;
    }

    protected void k() {
        this.C--;
        if (this.C == 0) {
            if (this.F != null && this.F.size() > 0) {
                ArrayList arrayList = (ArrayList) this.F.clone();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((c) arrayList.get(i2)).b(this);
                }
            }
            for (int i3 = 0; i3 < this.v.c.b(); i3++) {
                View c2 = this.v.c.c(i3);
                if (c2 != null) {
                    androidx.core.h.w.a(c2, false);
                }
            }
            for (int i4 = 0; i4 < this.w.c.b(); i4++) {
                View c3 = this.w.c.c(i4);
                if (c3 != null) {
                    androidx.core.h.w.a(c3, false);
                }
            }
            this.E = true;
        }
    }

    protected void l() {
        for (int size = this.g.size() - 1; size >= 0; size--) {
            this.g.get(size).cancel();
        }
        if (this.F == null || this.F.size() <= 0) {
            return;
        }
        ArrayList arrayList = (ArrayList) this.F.clone();
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((c) arrayList.get(i2)).a(this);
        }
    }

    public Transition a(c cVar) {
        if (this.F == null) {
            this.F = new ArrayList<>();
        }
        this.F.add(cVar);
        return this;
    }

    public Transition b(c cVar) {
        if (this.F == null) {
            return this;
        }
        this.F.remove(cVar);
        if (this.F.size() == 0) {
            this.F = null;
        }
        return this;
    }

    public void a(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.J = i;
        } else {
            this.J = pathMotion;
        }
    }

    public PathMotion m() {
        return this.J;
    }

    public void a(b bVar) {
        this.H = bVar;
    }

    public b n() {
        return this.H;
    }

    public Rect o() {
        if (this.H == null) {
            return null;
        }
        return this.H.a(this);
    }

    public void a(w wVar) {
        this.h = wVar;
    }

    public w p() {
        return this.h;
    }

    void c(y yVar) {
        String[] a2;
        if (this.h == null || yVar.a.isEmpty() || (a2 = this.h.a()) == null) {
            return;
        }
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= a2.length) {
                z = true;
                break;
            } else if (!yVar.a.containsKey(a2[i2])) {
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            return;
        }
        this.h.a(yVar);
    }

    public String toString() {
        return a("");
    }

    @Override // 
    /* renamed from: q */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.G = new ArrayList<>();
            transition.v = new z();
            transition.w = new z();
            transition.y = null;
            transition.z = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String r() {
        return this.j;
    }

    String a(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.b != -1) {
            str2 = str2 + "dur(" + this.b + ") ";
        }
        if (this.k != -1) {
            str2 = str2 + "dly(" + this.k + ") ";
        }
        if (this.l != null) {
            str2 = str2 + "interp(" + this.l + ") ";
        }
        if (this.c.size() <= 0 && this.d.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.c.size() > 0) {
            String str4 = str3;
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                if (i2 > 0) {
                    str4 = str4 + ", ";
                }
                str4 = str4 + this.c.get(i2);
            }
            str3 = str4;
        }
        if (this.d.size() > 0) {
            for (int i3 = 0; i3 < this.d.size(); i3++) {
                if (i3 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.d.get(i3);
            }
        }
        return str3 + ")";
    }

    /* compiled from: source */
    private static class a {
        View a;
        String b;
        y c;
        at d;
        Transition e;

        a(View view, String str, Transition transition, at atVar, y yVar) {
            this.a = view;
            this.b = str;
            this.c = yVar;
            this.d = atVar;
            this.e = transition;
        }
    }
}
