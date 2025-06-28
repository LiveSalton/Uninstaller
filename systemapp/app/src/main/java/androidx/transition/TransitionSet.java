package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: source */
/* loaded from: classes.dex */
public class TransitionSet extends Transition {
    int a;
    boolean i;
    private ArrayList<Transition> j;
    private boolean k;
    private int l;

    public TransitionSet() {
        this.j = new ArrayList<>();
        this.k = true;
        this.i = false;
        this.l = 0;
    }

    @SuppressLint({"RestrictedApi"})
    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new ArrayList<>();
        this.k = true;
        this.i = false;
        this.l = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.i);
        a(androidx.core.content.a.g.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    public TransitionSet a(int i) {
        switch (i) {
            case 0:
                this.k = true;
                return this;
            case 1:
                this.k = false;
                return this;
            default:
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
    }

    public TransitionSet a(Transition transition) {
        b(transition);
        if (this.b >= 0) {
            transition.a(this.b);
        }
        if ((this.l & 1) != 0) {
            transition.a(d());
        }
        if ((this.l & 2) != 0) {
            transition.a(p());
        }
        if ((this.l & 4) != 0) {
            transition.a(m());
        }
        if ((this.l & 8) != 0) {
            transition.a(n());
        }
        return this;
    }

    private void b(Transition transition) {
        this.j.add(transition);
        transition.e = this;
    }

    public int s() {
        return this.j.size();
    }

    public Transition b(int i) {
        if (i < 0 || i >= this.j.size()) {
            return null;
        }
        return this.j.get(i);
    }

    @Override // androidx.transition.Transition
    /* renamed from: c */
    public TransitionSet a(long j) {
        super.a(j);
        if (this.b >= 0 && this.j != null) {
            int size = this.j.size();
            for (int i = 0; i < size; i++) {
                this.j.get(i).a(j);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    /* renamed from: d */
    public TransitionSet b(long j) {
        return (TransitionSet) super.b(j);
    }

    @Override // androidx.transition.Transition
    /* renamed from: b */
    public TransitionSet a(TimeInterpolator timeInterpolator) {
        this.l |= 1;
        if (this.j != null) {
            int size = this.j.size();
            for (int i = 0; i < size; i++) {
                this.j.get(i).a(timeInterpolator);
            }
        }
        return (TransitionSet) super.a(timeInterpolator);
    }

    @Override // androidx.transition.Transition
    /* renamed from: a */
    public TransitionSet c(View view) {
        for (int i = 0; i < this.j.size(); i++) {
            this.j.get(i).c(view);
        }
        return (TransitionSet) super.c(view);
    }

    @Override // androidx.transition.Transition
    /* renamed from: c */
    public TransitionSet a(Transition.c cVar) {
        return (TransitionSet) super.a(cVar);
    }

    @Override // androidx.transition.Transition
    /* renamed from: g */
    public TransitionSet d(View view) {
        for (int i = 0; i < this.j.size(); i++) {
            this.j.get(i).d(view);
        }
        return (TransitionSet) super.d(view);
    }

    @Override // androidx.transition.Transition
    /* renamed from: d */
    public TransitionSet b(Transition.c cVar) {
        return (TransitionSet) super.b(cVar);
    }

    @Override // androidx.transition.Transition
    public void a(PathMotion pathMotion) {
        super.a(pathMotion);
        this.l |= 4;
        if (this.j != null) {
            for (int i = 0; i < this.j.size(); i++) {
                this.j.get(i).a(pathMotion);
            }
        }
    }

    private void t() {
        a aVar = new a(this);
        Iterator<Transition> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
        this.a = this.j.size();
    }

    /* compiled from: source */
    static class a extends u {
        TransitionSet a;

        a(TransitionSet transitionSet) {
            this.a = transitionSet;
        }

        @Override // androidx.transition.u, androidx.transition.Transition.c
        public void e(Transition transition) {
            if (this.a.i) {
                return;
            }
            this.a.j();
            this.a.i = true;
        }

        @Override // androidx.transition.u, androidx.transition.Transition.c
        public void b(Transition transition) {
            TransitionSet transitionSet = this.a;
            transitionSet.a--;
            if (this.a.a == 0) {
                this.a.i = false;
                this.a.k();
            }
            transition.b(this);
        }
    }

    @Override // androidx.transition.Transition
    protected void a(ViewGroup viewGroup, z zVar, z zVar2, ArrayList<y> arrayList, ArrayList<y> arrayList2) {
        long c = c();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            Transition transition = this.j.get(i);
            if (c > 0 && (this.k || i == 0)) {
                long c2 = transition.c();
                if (c2 > 0) {
                    transition.b(c2 + c);
                } else {
                    transition.b(c);
                }
            }
            transition.a(viewGroup, zVar, zVar2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    protected void e() {
        if (this.j.isEmpty()) {
            j();
            k();
            return;
        }
        t();
        if (!this.k) {
            for (int i = 1; i < this.j.size(); i++) {
                this.j.get(i - 1).a(new u() { // from class: androidx.transition.TransitionSet.1
                    final /* synthetic */ Transition a;

                    AnonymousClass1(Transition transition) {
                        transition2 = transition;
                    }

                    @Override // androidx.transition.u, androidx.transition.Transition.c
                    public void b(Transition transition) {
                        transition2.e();
                        transition.b(this);
                    }
                });
            }
            Transition transition = this.j.get(0);
            if (transition != null) {
                transition.e();
                return;
            }
            return;
        }
        Iterator<Transition> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.TransitionSet$1 */
    class AnonymousClass1 extends u {
        final /* synthetic */ Transition a;

        AnonymousClass1(Transition transition) {
            transition2 = transition;
        }

        @Override // androidx.transition.u, androidx.transition.Transition.c
        public void b(Transition transition) {
            transition2.e();
            transition.b(this);
        }
    }

    @Override // androidx.transition.Transition
    public void a(y yVar) {
        if (b(yVar.b)) {
            Iterator<Transition> it = this.j.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.b(yVar.b)) {
                    next.a(yVar);
                    yVar.c.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void b(y yVar) {
        if (b(yVar.b)) {
            Iterator<Transition> it = this.j.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.b(yVar.b)) {
                    next.b(yVar);
                    yVar.c.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    void c(y yVar) {
        super.c(yVar);
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            this.j.get(i).c(yVar);
        }
    }

    @Override // androidx.transition.Transition
    public void e(View view) {
        super.e(view);
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            this.j.get(i).e(view);
        }
    }

    @Override // androidx.transition.Transition
    public void f(View view) {
        super.f(view);
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            this.j.get(i).f(view);
        }
    }

    @Override // androidx.transition.Transition
    protected void l() {
        super.l();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            this.j.get(i).l();
        }
    }

    @Override // androidx.transition.Transition
    public void a(w wVar) {
        super.a(wVar);
        this.l |= 2;
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            this.j.get(i).a(wVar);
        }
    }

    @Override // androidx.transition.Transition
    public void a(Transition.b bVar) {
        super.a(bVar);
        this.l |= 8;
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            this.j.get(i).a(bVar);
        }
    }

    @Override // androidx.transition.Transition
    String a(String str) {
        String a2 = super.a(str);
        for (int i = 0; i < this.j.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append("\n");
            sb.append(this.j.get(i).a(str + "  "));
            a2 = sb.toString();
        }
        return a2;
    }

    @Override // androidx.transition.Transition
    /* renamed from: q */
    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.j = new ArrayList<>();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            transitionSet.b(this.j.get(i).clone());
        }
        return transitionSet;
    }
}
