package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.a;
import androidx.transition.p;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class Visibility extends Transition {
    private static final String[] a = {"android:visibility:visibility", "android:visibility:parent"};
    private int i;

    public Animator a(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        return null;
    }

    public Animator b(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        return null;
    }

    /* compiled from: source */
    private static class b {
        boolean a;
        boolean b;
        int c;
        int d;
        ViewGroup e;
        ViewGroup f;

        b() {
        }
    }

    public Visibility() {
        this.i = 3;
    }

    @SuppressLint({"RestrictedApi"})
    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = 3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.e);
        int a2 = androidx.core.content.a.g.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (a2 != 0) {
            b(a2);
        }
    }

    public void b(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.i = i;
    }

    public int s() {
        return this.i;
    }

    @Override // androidx.transition.Transition
    public String[] a() {
        return a;
    }

    private void d(y yVar) {
        yVar.a.put("android:visibility:visibility", Integer.valueOf(yVar.b.getVisibility()));
        yVar.a.put("android:visibility:parent", yVar.b.getParent());
        int[] iArr = new int[2];
        yVar.b.getLocationOnScreen(iArr);
        yVar.a.put("android:visibility:screenLocation", iArr);
    }

    @Override // androidx.transition.Transition
    public void a(y yVar) {
        d(yVar);
    }

    @Override // androidx.transition.Transition
    public void b(y yVar) {
        d(yVar);
    }

    private b b(y yVar, y yVar2) {
        b bVar = new b();
        bVar.a = false;
        bVar.b = false;
        if (yVar != null && yVar.a.containsKey("android:visibility:visibility")) {
            bVar.c = ((Integer) yVar.a.get("android:visibility:visibility")).intValue();
            bVar.e = (ViewGroup) yVar.a.get("android:visibility:parent");
        } else {
            bVar.c = -1;
            bVar.e = null;
        }
        if (yVar2 != null && yVar2.a.containsKey("android:visibility:visibility")) {
            bVar.d = ((Integer) yVar2.a.get("android:visibility:visibility")).intValue();
            bVar.f = (ViewGroup) yVar2.a.get("android:visibility:parent");
        } else {
            bVar.d = -1;
            bVar.f = null;
        }
        if (yVar != null && yVar2 != null) {
            if (bVar.c == bVar.d && bVar.e == bVar.f) {
                return bVar;
            }
            if (bVar.c != bVar.d) {
                if (bVar.c == 0) {
                    bVar.b = false;
                    bVar.a = true;
                } else if (bVar.d == 0) {
                    bVar.b = true;
                    bVar.a = true;
                }
            } else if (bVar.f == null) {
                bVar.b = false;
                bVar.a = true;
            } else if (bVar.e == null) {
                bVar.b = true;
                bVar.a = true;
            }
        } else if (yVar == null && bVar.d == 0) {
            bVar.b = true;
            bVar.a = true;
        } else if (yVar2 == null && bVar.c == 0) {
            bVar.b = false;
            bVar.a = true;
        }
        return bVar;
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, y yVar, y yVar2) {
        b b2 = b(yVar, yVar2);
        if (!b2.a) {
            return null;
        }
        if (b2.e == null && b2.f == null) {
            return null;
        }
        if (b2.b) {
            return a(viewGroup, yVar, b2.c, yVar2, b2.d);
        }
        return b(viewGroup, yVar, b2.c, yVar2, b2.d);
    }

    public Animator a(ViewGroup viewGroup, y yVar, int i, y yVar2, int i2) {
        if ((this.i & 1) != 1 || yVar2 == null) {
            return null;
        }
        if (yVar == null) {
            View view = (View) yVar2.b.getParent();
            if (b(b(view, false), a(view, false)).a) {
                return null;
            }
        }
        return a(viewGroup, yVar2.b, yVar, yVar2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0080, code lost:
    
        if (r9.f != false) goto L106;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.animation.Animator b(android.view.ViewGroup r10, androidx.transition.y r11, int r12, androidx.transition.y r13, int r14) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.b(android.view.ViewGroup, androidx.transition.y, int, androidx.transition.y, int):android.animation.Animator");
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.Visibility$1 */
    class AnonymousClass1 extends u {
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ View b;
        final /* synthetic */ View c;

        AnonymousClass1(ViewGroup viewGroup, View view, View view2) {
            r2 = viewGroup;
            r3 = view;
            r4 = view2;
        }

        @Override // androidx.transition.u, androidx.transition.Transition.c
        public void c(Transition transition) {
            ae.a(r2).b(r3);
        }

        @Override // androidx.transition.u, androidx.transition.Transition.c
        public void d(Transition transition) {
            if (r3.getParent() == null) {
                ae.a(r2).a(r3);
            } else {
                Visibility.this.l();
            }
        }

        @Override // androidx.transition.u, androidx.transition.Transition.c
        public void b(Transition transition) {
            r4.setTag(p.a.save_overlay_view, null);
            ae.a(r2).b(r3);
            transition.b(this);
        }
    }

    @Override // androidx.transition.Transition
    public boolean a(y yVar, y yVar2) {
        if (yVar == null && yVar2 == null) {
            return false;
        }
        if (yVar != null && yVar2 != null && yVar2.a.containsKey("android:visibility:visibility") != yVar.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b b2 = b(yVar, yVar2);
        if (b2.a) {
            return b2.c == 0 || b2.d == 0;
        }
        return false;
    }

    /* compiled from: source */
    private static class a extends AnimatorListenerAdapter implements Transition.c, a.InterfaceC0049a {
        boolean a = false;
        private final View b;
        private final int c;
        private final ViewGroup d;
        private final boolean e;
        private boolean f;

        @Override // androidx.transition.Transition.c
        public void a(Transition transition) {
        }

        @Override // androidx.transition.Transition.c
        public void e(Transition transition) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        a(View view, int i, boolean z) {
            this.b = view;
            this.c = i;
            this.d = (ViewGroup) view.getParent();
            this.e = z;
            a(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.a.InterfaceC0049a
        public void onAnimationPause(Animator animator) {
            if (this.a) {
                return;
            }
            aj.a(this.b, this.c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.a.InterfaceC0049a
        public void onAnimationResume(Animator animator) {
            if (this.a) {
                return;
            }
            aj.a(this.b, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // androidx.transition.Transition.c
        public void b(Transition transition) {
            a();
            transition.b(this);
        }

        @Override // androidx.transition.Transition.c
        public void c(Transition transition) {
            a(false);
        }

        @Override // androidx.transition.Transition.c
        public void d(Transition transition) {
            a(true);
        }

        private void a() {
            if (!this.a) {
                aj.a(this.b, this.c);
                if (this.d != null) {
                    this.d.invalidate();
                }
            }
            a(false);
        }

        private void a(boolean z) {
            if (!this.e || this.f == z || this.d == null) {
                return;
            }
            this.f = z;
            ae.a(this.d, z);
        }
    }
}
