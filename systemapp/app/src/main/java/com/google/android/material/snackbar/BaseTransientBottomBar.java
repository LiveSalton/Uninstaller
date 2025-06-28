package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.a.c;
import androidx.core.h.w;
import com.google.android.material.a;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.b;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    static final Handler a;
    private static final boolean d;
    private static final int[] e;
    protected final e b;
    final b.a c;
    private final ViewGroup f;
    private final com.google.android.material.snackbar.a g;
    private List<a<B>> h;
    private Behavior i;
    private final AccessibilityManager j;

    /* compiled from: source */
    public static abstract class a<B> {
        public void a(B b) {
        }

        public void a(B b, int i) {
        }
    }

    /* compiled from: source */
    protected interface c {
        void a(View view);

        void b(View view);
    }

    /* compiled from: source */
    protected interface d {
        void a(View view, int i, int i2, int i3, int i4);
    }

    static {
        d = Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 19;
        e = new int[]{a.b.snackbarStyle};
        a = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.1
            AnonymousClass1() {
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        ((BaseTransientBottomBar) message.obj).c();
                        break;
                    case 1:
                        ((BaseTransientBottomBar) message.obj).b(message.arg1);
                        break;
                }
                return true;
            }
        });
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$1 */
    static class AnonymousClass1 implements Handler.Callback {
        AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    ((BaseTransientBottomBar) message.obj).c();
                    break;
                case 1:
                    ((BaseTransientBottomBar) message.obj).b(message.arg1);
                    break;
            }
            return true;
        }
    }

    protected void a(int i) {
        com.google.android.material.snackbar.b.a().a(this.c, i);
    }

    public boolean a() {
        return com.google.android.material.snackbar.b.a().e(this.c);
    }

    protected SwipeDismissBehavior<? extends View> b() {
        return new Behavior();
    }

    final void c() {
        if (this.b.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.d) {
                CoordinatorLayout.d dVar = (CoordinatorLayout.d) layoutParams;
                SwipeDismissBehavior<? extends View> b2 = this.i == null ? b() : this.i;
                if (b2 instanceof Behavior) {
                    ((Behavior) b2).a((BaseTransientBottomBar<?>) this);
                }
                b2.a(new SwipeDismissBehavior.a() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.4
                    AnonymousClass4() {
                    }

                    @Override // com.google.android.material.behavior.SwipeDismissBehavior.a
                    public void a(View view) {
                        view.setVisibility(8);
                        BaseTransientBottomBar.this.a(0);
                    }

                    @Override // com.google.android.material.behavior.SwipeDismissBehavior.a
                    public void a(int i) {
                        switch (i) {
                            case 0:
                                com.google.android.material.snackbar.b.a().d(BaseTransientBottomBar.this.c);
                                break;
                            case 1:
                            case 2:
                                com.google.android.material.snackbar.b.a().c(BaseTransientBottomBar.this.c);
                                break;
                        }
                    }
                });
                dVar.a(b2);
                dVar.g = 80;
            }
            this.f.addView(this.b);
        }
        this.b.setOnAttachStateChangeListener(new c() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.5
            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.c
            public void a(View view) {
            }

            AnonymousClass5() {
            }

            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.c
            public void b(View view) {
                if (BaseTransientBottomBar.this.a()) {
                    BaseTransientBottomBar.a.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.5.1
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            BaseTransientBottomBar.this.c(3);
                        }
                    });
                }
            }

            /* compiled from: source */
            /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$5$1 */
            class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    BaseTransientBottomBar.this.c(3);
                }
            }
        });
        if (w.C(this.b)) {
            if (f()) {
                d();
                return;
            } else {
                e();
                return;
            }
        }
        this.b.setOnLayoutChangeListener(new d() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.6
            AnonymousClass6() {
            }

            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.d
            public void a(View view, int i, int i2, int i3, int i4) {
                BaseTransientBottomBar.this.b.setOnLayoutChangeListener(null);
                if (BaseTransientBottomBar.this.f()) {
                    BaseTransientBottomBar.this.d();
                } else {
                    BaseTransientBottomBar.this.e();
                }
            }
        });
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$4 */
    class AnonymousClass4 implements SwipeDismissBehavior.a {
        AnonymousClass4() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.a
        public void a(View view) {
            view.setVisibility(8);
            BaseTransientBottomBar.this.a(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.a
        public void a(int i) {
            switch (i) {
                case 0:
                    com.google.android.material.snackbar.b.a().d(BaseTransientBottomBar.this.c);
                    break;
                case 1:
                case 2:
                    com.google.android.material.snackbar.b.a().c(BaseTransientBottomBar.this.c);
                    break;
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$5 */
    class AnonymousClass5 implements c {
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.c
        public void a(View view) {
        }

        AnonymousClass5() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.c
        public void b(View view) {
            if (BaseTransientBottomBar.this.a()) {
                BaseTransientBottomBar.a.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.5.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        BaseTransientBottomBar.this.c(3);
                    }
                });
            }
        }

        /* compiled from: source */
        /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$5$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseTransientBottomBar.this.c(3);
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$6 */
    class AnonymousClass6 implements d {
        AnonymousClass6() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.d
        public void a(View view, int i, int i2, int i3, int i4) {
            BaseTransientBottomBar.this.b.setOnLayoutChangeListener(null);
            if (BaseTransientBottomBar.this.f()) {
                BaseTransientBottomBar.this.d();
            } else {
                BaseTransientBottomBar.this.e();
            }
        }
    }

    void d() {
        int h = h();
        if (d) {
            w.f(this.b, h);
        } else {
            this.b.setTranslationY(h);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(h, 0);
        valueAnimator.setInterpolator(com.google.android.material.a.a.b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.7
            AnonymousClass7() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.g.a(70, 180);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.e();
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.8
            final /* synthetic */ int a;
            private int c;

            AnonymousClass8(int h2) {
                h = h2;
                this.c = h;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int intValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.d) {
                    w.f(BaseTransientBottomBar.this.b, intValue - this.c);
                } else {
                    BaseTransientBottomBar.this.b.setTranslationY(intValue);
                }
                this.c = intValue;
            }
        });
        valueAnimator.start();
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$7 */
    class AnonymousClass7 extends AnimatorListenerAdapter {
        AnonymousClass7() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.g.a(70, 180);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.e();
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$8 */
    class AnonymousClass8 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;
        private int c;

        AnonymousClass8(int h2) {
            h = h2;
            this.c = h;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator2) {
            int intValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.d) {
                w.f(BaseTransientBottomBar.this.b, intValue - this.c);
            } else {
                BaseTransientBottomBar.this.b.setTranslationY(intValue);
            }
            this.c = intValue;
        }
    }

    private void d(int i) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, h());
        valueAnimator.setInterpolator(com.google.android.material.a.a.b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.2
            final /* synthetic */ int a;

            AnonymousClass2(int i2) {
                i = i2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.g.b(0, 180);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.c(i);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.3
            private int b = 0;

            AnonymousClass3() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int intValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.d) {
                    w.f(BaseTransientBottomBar.this.b, intValue - this.b);
                } else {
                    BaseTransientBottomBar.this.b.setTranslationY(intValue);
                }
                this.b = intValue;
            }
        });
        valueAnimator.start();
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$2 */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        AnonymousClass2(int i2) {
            i = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.g.b(0, 180);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.c(i);
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$3 */
    class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        private int b = 0;

        AnonymousClass3() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator2) {
            int intValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.d) {
                w.f(BaseTransientBottomBar.this.b, intValue - this.b);
            } else {
                BaseTransientBottomBar.this.b.setTranslationY(intValue);
            }
            this.b = intValue;
        }
    }

    private int h() {
        int height = this.b.getHeight();
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    final void b(int i) {
        if (f() && this.b.getVisibility() == 0) {
            d(i);
        } else {
            c(i);
        }
    }

    void e() {
        com.google.android.material.snackbar.b.a().b(this.c);
        if (this.h != null) {
            for (int size = this.h.size() - 1; size >= 0; size--) {
                this.h.get(size).a(this);
            }
        }
    }

    void c(int i) {
        com.google.android.material.snackbar.b.a().a(this.c);
        if (this.h != null) {
            for (int size = this.h.size() - 1; size >= 0; size--) {
                this.h.get(size).a(this, i);
            }
        }
        ViewParent parent = this.b.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.b);
        }
    }

    boolean f() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.j.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    /* compiled from: source */
    protected static class e extends FrameLayout {
        private final AccessibilityManager a;
        private final c.a b;
        private d c;
        private c d;

        protected e(Context context) {
            this(context, null);
        }

        protected e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(a.k.SnackbarLayout_elevation)) {
                w.a(this, obtainStyledAttributes.getDimensionPixelSize(a.k.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            this.a = (AccessibilityManager) context.getSystemService("accessibility");
            this.b = new c.a() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.e.1
                AnonymousClass1() {
                }

                @Override // androidx.core.h.a.c.a
                public void a(boolean z) {
                    e.this.setClickableOrFocusableBasedOnAccessibility(z);
                }
            };
            androidx.core.h.a.c.a(this.a, this.b);
            setClickableOrFocusableBasedOnAccessibility(this.a.isTouchExplorationEnabled());
        }

        /* compiled from: source */
        /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$e$1 */
        class AnonymousClass1 implements c.a {
            AnonymousClass1() {
            }

            @Override // androidx.core.h.a.c.a
            public void a(boolean z) {
                e.this.setClickableOrFocusableBasedOnAccessibility(z);
            }
        }

        public void setClickableOrFocusableBasedOnAccessibility(boolean z) {
            setClickable(!z);
            setFocusable(z);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.c != null) {
                this.c.a(this, i, i2, i3, i4);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.d != null) {
                this.d.a(this);
            }
            w.t(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.d != null) {
                this.d.b(this);
            }
            androidx.core.h.a.c.b(this.a, this.b);
        }

        void setOnLayoutChangeListener(d dVar) {
            this.c = dVar;
        }

        void setOnAttachStateChangeListener(c cVar) {
            this.d = cVar;
        }
    }

    /* compiled from: source */
    public static class Behavior extends SwipeDismissBehavior<View> {
        private final b g = new b(this);

        public void a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.g.a(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean a(View view) {
            return this.g.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.g.a(coordinatorLayout, view, motionEvent);
            return super.a(coordinatorLayout, (CoordinatorLayout) view, motionEvent);
        }
    }

    /* compiled from: source */
    public static class b {
        private b.a a;

        public b(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.a(0.1f);
            swipeDismissBehavior.b(0.6f);
            swipeDismissBehavior.a(0);
        }

        public void a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.a = baseTransientBottomBar.c;
        }

        public boolean a(View view) {
            return view instanceof e;
        }

        public void a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 3) {
                switch (actionMasked) {
                    case 0:
                        if (coordinatorLayout.a(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                            com.google.android.material.snackbar.b.a().c(this.a);
                            break;
                        }
                        break;
                }
            }
            com.google.android.material.snackbar.b.a().d(this.a);
        }
    }
}
