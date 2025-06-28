package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.d.a;
import androidx.fragment.a;
import androidx.fragment.app.o;

/* compiled from: source */
/* loaded from: classes.dex */
class b {
    static a a(Context context, c cVar, Fragment fragment, boolean z) {
        int a2;
        int ak = fragment.ak();
        int aj = fragment.aj();
        boolean z2 = false;
        fragment.b(0);
        View a3 = cVar.a(fragment.w);
        if (a3 != null && a3.getTag(a.b.visible_removing_fragment_view_tag) != null) {
            a3.setTag(a.b.visible_removing_fragment_view_tag, null);
        }
        if (fragment.E != null && fragment.E.getLayoutTransition() != null) {
            return null;
        }
        Animation a4 = fragment.a(ak, z, aj);
        if (a4 != null) {
            return new a(a4);
        }
        Animator b = fragment.b(ak, z, aj);
        if (b != null) {
            return new a(b);
        }
        if (aj != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(aj));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, aj);
                    if (loadAnimation != null) {
                        return new a(loadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, aj);
                    if (loadAnimator != null) {
                        return new a(loadAnimator);
                    }
                } catch (RuntimeException e2) {
                    if (equals) {
                        throw e2;
                    }
                    Animation loadAnimation2 = AnimationUtils.loadAnimation(context, aj);
                    if (loadAnimation2 != null) {
                        return new a(loadAnimation2);
                    }
                }
            }
        }
        if (ak != 0 && (a2 = a(ak, z)) >= 0) {
            return new a(AnimationUtils.loadAnimation(context, a2));
        }
        return null;
    }

    static void a(Fragment fragment, a aVar, o.a aVar2) {
        View view = fragment.F;
        ViewGroup viewGroup = fragment.E;
        viewGroup.startViewTransition(view);
        androidx.core.d.a aVar3 = new androidx.core.d.a();
        aVar3.a(new a.InterfaceC0020a() { // from class: androidx.fragment.app.b.1
            AnonymousClass1() {
            }

            @Override // androidx.core.d.a.InterfaceC0020a
            public void a() {
                if (Fragment.this.an() != null) {
                    View an = Fragment.this.an();
                    Fragment.this.c((View) null);
                    an.clearAnimation();
                }
                Fragment.this.a((Animator) null);
            }
        });
        aVar2.a(fragment, aVar3);
        if (aVar.a != null) {
            RunnableC0037b runnableC0037b = new RunnableC0037b(aVar.a, viewGroup, view);
            fragment.c(fragment.F);
            runnableC0037b.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.b.2
                final /* synthetic */ ViewGroup a;
                final /* synthetic */ Fragment b;
                final /* synthetic */ o.a c;
                final /* synthetic */ androidx.core.d.a d;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                AnonymousClass2(ViewGroup viewGroup2, Fragment fragment2, o.a aVar22, androidx.core.d.a aVar32) {
                    viewGroup = viewGroup2;
                    fragment = fragment2;
                    aVar2 = aVar22;
                    aVar3 = aVar32;
                }

                /* compiled from: source */
                /* renamed from: androidx.fragment.app.b$2$1 */
                class AnonymousClass1 implements Runnable {
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (fragment.an() != null) {
                            fragment.c((View) null);
                            aVar2.b(fragment, aVar3);
                        }
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    viewGroup.post(new Runnable() { // from class: androidx.fragment.app.b.2.1
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (fragment.an() != null) {
                                fragment.c((View) null);
                                aVar2.b(fragment, aVar3);
                            }
                        }
                    });
                }
            });
            fragment2.F.startAnimation(runnableC0037b);
            return;
        }
        Animator animator = aVar.b;
        fragment2.a(aVar.b);
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.b.3
            final /* synthetic */ ViewGroup a;
            final /* synthetic */ View b;
            final /* synthetic */ Fragment c;
            final /* synthetic */ o.a d;
            final /* synthetic */ androidx.core.d.a e;

            AnonymousClass3(ViewGroup viewGroup2, View view2, Fragment fragment2, o.a aVar22, androidx.core.d.a aVar32) {
                viewGroup = viewGroup2;
                view = view2;
                fragment = fragment2;
                aVar2 = aVar22;
                aVar3 = aVar32;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                viewGroup.endViewTransition(view);
                Animator ao = fragment.ao();
                fragment.a((Animator) null);
                if (ao == null || viewGroup.indexOfChild(view) >= 0) {
                    return;
                }
                aVar2.b(fragment, aVar3);
            }
        });
        animator.setTarget(fragment2.F);
        animator.start();
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.b$1 */
    static class AnonymousClass1 implements a.InterfaceC0020a {
        AnonymousClass1() {
        }

        @Override // androidx.core.d.a.InterfaceC0020a
        public void a() {
            if (Fragment.this.an() != null) {
                View an = Fragment.this.an();
                Fragment.this.c((View) null);
                an.clearAnimation();
            }
            Fragment.this.a((Animator) null);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.b$2 */
    static class AnonymousClass2 implements Animation.AnimationListener {
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ Fragment b;
        final /* synthetic */ o.a c;
        final /* synthetic */ androidx.core.d.a d;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        AnonymousClass2(ViewGroup viewGroup2, Fragment fragment2, o.a aVar22, androidx.core.d.a aVar32) {
            viewGroup = viewGroup2;
            fragment = fragment2;
            aVar2 = aVar22;
            aVar3 = aVar32;
        }

        /* compiled from: source */
        /* renamed from: androidx.fragment.app.b$2$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (fragment.an() != null) {
                    fragment.c((View) null);
                    aVar2.b(fragment, aVar3);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            viewGroup.post(new Runnable() { // from class: androidx.fragment.app.b.2.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (fragment.an() != null) {
                        fragment.c((View) null);
                        aVar2.b(fragment, aVar3);
                    }
                }
            });
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.b$3 */
    static class AnonymousClass3 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ View b;
        final /* synthetic */ Fragment c;
        final /* synthetic */ o.a d;
        final /* synthetic */ androidx.core.d.a e;

        AnonymousClass3(ViewGroup viewGroup2, View view2, Fragment fragment2, o.a aVar22, androidx.core.d.a aVar32) {
            viewGroup = viewGroup2;
            view = view2;
            fragment = fragment2;
            aVar2 = aVar22;
            aVar3 = aVar32;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator2) {
            viewGroup.endViewTransition(view);
            Animator ao = fragment.ao();
            fragment.a((Animator) null);
            if (ao == null || viewGroup.indexOfChild(view) >= 0) {
                return;
            }
            aVar2.b(fragment, aVar3);
        }
    }

    private static int a(int i, boolean z) {
        if (i == 4097) {
            return z ? a.C0036a.fragment_open_enter : a.C0036a.fragment_open_exit;
        }
        if (i == 4099) {
            return z ? a.C0036a.fragment_fade_enter : a.C0036a.fragment_fade_exit;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? a.C0036a.fragment_close_enter : a.C0036a.fragment_close_exit;
    }

    /* compiled from: source */
    static class a {
        public final Animation a;
        public final Animator b;

        a(Animation animation) {
            this.a = animation;
            this.b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        a(Animator animator) {
            this.a = null;
            this.b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.b$b */
    private static class RunnableC0037b extends AnimationSet implements Runnable {
        private final ViewGroup a;
        private final View b;
        private boolean c;
        private boolean d;
        private boolean e;

        RunnableC0037b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.e = true;
            this.a = viewGroup;
            this.b = view;
            addAnimation(animation);
            this.a.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.e = true;
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.c = true;
                androidx.core.h.s.a(this.a, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.e = true;
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.c = true;
                androidx.core.h.s.a(this.a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.c && this.e) {
                this.e = false;
                this.a.post(this);
            } else {
                this.a.endViewTransition(this.b);
                this.d = true;
            }
        }
    }
}
