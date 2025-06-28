package androidx.core.h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* compiled from: source */
/* loaded from: classes.dex */
public final class aa {
    Runnable a = null;
    Runnable b = null;
    int c = -1;
    private WeakReference<View> d;

    aa(View view) {
        this.d = new WeakReference<>(view);
    }

    /* compiled from: source */
    static class a implements ab {
        aa a;
        boolean b;

        a(aa aaVar) {
            this.a = aaVar;
        }

        @Override // androidx.core.h.ab
        public void a(View view) {
            this.b = false;
            if (this.a.c > -1) {
                view.setLayerType(2, null);
            }
            if (this.a.a != null) {
                Runnable runnable = this.a.a;
                this.a.a = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            ab abVar = tag instanceof ab ? (ab) tag : null;
            if (abVar != null) {
                abVar.a(view);
            }
        }

        @Override // androidx.core.h.ab
        @SuppressLint({"WrongConstant"})
        public void b(View view) {
            if (this.a.c > -1) {
                view.setLayerType(this.a.c, null);
                this.a.c = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.b) {
                if (this.a.b != null) {
                    Runnable runnable = this.a.b;
                    this.a.b = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                ab abVar = tag instanceof ab ? (ab) tag : null;
                if (abVar != null) {
                    abVar.b(view);
                }
                this.b = true;
            }
        }

        @Override // androidx.core.h.ab
        public void c(View view) {
            Object tag = view.getTag(2113929216);
            ab abVar = tag instanceof ab ? (ab) tag : null;
            if (abVar != null) {
                abVar.c(view);
            }
        }
    }

    public aa a(long j) {
        View view = this.d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public aa a(float f) {
        View view = this.d.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public aa b(float f) {
        View view = this.d.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public long a() {
        View view = this.d.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public aa a(Interpolator interpolator) {
        View view = this.d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public aa b(long j) {
        View view = this.d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void b() {
        View view = this.d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public void c() {
        View view = this.d.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public aa a(ab abVar) {
        View view = this.d.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                a(view, abVar);
            } else {
                view.setTag(2113929216, abVar);
                a(view, new a(this));
            }
        }
        return this;
    }

    /* compiled from: source */
    /* renamed from: androidx.core.h.aa$1 */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ ab a;
        final /* synthetic */ View b;

        AnonymousClass1(ab abVar, View view) {
            abVar = abVar;
            view = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            abVar.c(view);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            abVar.b(view);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            abVar.a(view);
        }
    }

    private void a(View view, ab abVar) {
        if (abVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: androidx.core.h.aa.1
                final /* synthetic */ ab a;
                final /* synthetic */ View b;

                AnonymousClass1(ab abVar2, View view2) {
                    abVar = abVar2;
                    view = view2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    abVar.c(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    abVar.b(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    abVar.a(view);
                }
            });
        } else {
            view2.animate().setListener(null);
        }
    }

    public aa a(ad adVar) {
        View view = this.d.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(adVar != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.h.aa.2
                final /* synthetic */ ad a;
                final /* synthetic */ View b;

                AnonymousClass2(ad adVar2, View view2) {
                    adVar = adVar2;
                    view = view2;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    adVar.a(view);
                }
            } : null);
        }
        return this;
    }

    /* compiled from: source */
    /* renamed from: androidx.core.h.aa$2 */
    class AnonymousClass2 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ad a;
        final /* synthetic */ View b;

        AnonymousClass2(ad adVar2, View view2) {
            adVar = adVar2;
            view = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            adVar.a(view);
        }
    }
}
