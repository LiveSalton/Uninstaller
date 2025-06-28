package androidx.core.h;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.a;
import androidx.core.h.a;
import androidx.core.h.a.d;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: source */
/* loaded from: classes.dex */
public class w {
    private static Field b = null;
    private static boolean c = false;
    private static Field d = null;
    private static boolean e = false;
    private static WeakHashMap<View, String> f = null;
    private static WeakHashMap<View, aa> g = null;
    private static Field h = null;
    private static boolean i = false;
    private static ThreadLocal<Rect> j;
    private static final AtomicInteger a = new AtomicInteger(1);
    private static final int[] k = {a.b.accessibility_custom_action_0, a.b.accessibility_custom_action_1, a.b.accessibility_custom_action_2, a.b.accessibility_custom_action_3, a.b.accessibility_custom_action_4, a.b.accessibility_custom_action_5, a.b.accessibility_custom_action_6, a.b.accessibility_custom_action_7, a.b.accessibility_custom_action_8, a.b.accessibility_custom_action_9, a.b.accessibility_custom_action_10, a.b.accessibility_custom_action_11, a.b.accessibility_custom_action_12, a.b.accessibility_custom_action_13, a.b.accessibility_custom_action_14, a.b.accessibility_custom_action_15, a.b.accessibility_custom_action_16, a.b.accessibility_custom_action_17, a.b.accessibility_custom_action_18, a.b.accessibility_custom_action_19, a.b.accessibility_custom_action_20, a.b.accessibility_custom_action_21, a.b.accessibility_custom_action_22, a.b.accessibility_custom_action_23, a.b.accessibility_custom_action_24, a.b.accessibility_custom_action_25, a.b.accessibility_custom_action_26, a.b.accessibility_custom_action_27, a.b.accessibility_custom_action_28, a.b.accessibility_custom_action_29, a.b.accessibility_custom_action_30, a.b.accessibility_custom_action_31};
    private static a l = new a();

    /* compiled from: source */
    public interface f {
        boolean a(View view, KeyEvent keyEvent);
    }

    private static Rect a() {
        if (j == null) {
            j = new ThreadLocal<>();
        }
        Rect rect = j.get();
        if (rect == null) {
            rect = new Rect();
            j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void a(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            e.a(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    public static void a(View view, androidx.core.h.a.d dVar) {
        view.onInitializeAccessibilityNodeInfo(dVar.a());
    }

    public static void a(View view, androidx.core.h.a aVar) {
        if (aVar == null && (L(view) instanceof a.C0025a)) {
            aVar = new androidx.core.h.a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.a());
    }

    @SuppressLint({"InlinedApi"})
    public static int a(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void a(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i2);
        }
    }

    public static boolean b(View view) {
        return L(view) != null;
    }

    public static androidx.core.h.a c(View view) {
        View.AccessibilityDelegate L = L(view);
        if (L == null) {
            return null;
        }
        if (L instanceof a.C0025a) {
            return ((a.C0025a) L).a;
        }
        return new androidx.core.h.a(L);
    }

    static androidx.core.h.a d(View view) {
        androidx.core.h.a c2 = c(view);
        if (c2 == null) {
            c2 = new androidx.core.h.a();
        }
        a(view, c2);
        return c2;
    }

    private static View.AccessibilityDelegate L(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        return M(view);
    }

    private static View.AccessibilityDelegate M(View view) {
        if (i) {
            return null;
        }
        if (h == null) {
            try {
                h = View.class.getDeclaredField("mAccessibilityDelegate");
                h.setAccessible(true);
            } catch (Throwable unused) {
                i = true;
                return null;
            }
        }
        try {
            Object obj = h.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            i = true;
            return null;
        }
    }

    public static boolean e(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static void a(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    public static void f(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation(i2, i3, i4, i5);
        } else {
            view.postInvalidate(i2, i3, i4, i5);
        }
    }

    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void a(View view, Runnable runnable, long j2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j2);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j2);
        }
    }

    public static int g(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static void b(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setImportantForAccessibility(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (i2 == 4) {
                i2 = 2;
            }
            view.setImportantForAccessibility(i2);
        }
    }

    public static boolean a(View view, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i2, bundle);
        }
        return false;
    }

    public static void a(View view, d.a aVar, CharSequence charSequence, androidx.core.h.a.g gVar) {
        if (gVar == null && charSequence == null) {
            c(view, aVar.a());
        } else {
            a(view, aVar.a(charSequence, gVar));
        }
    }

    private static void a(View view, d.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            d(view);
            a(aVar.a(), view);
            N(view).add(aVar);
            h(view, 0);
        }
    }

    public static void c(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            a(i2, view);
            h(view, 0);
        }
    }

    private static void a(int i2, View view) {
        List<d.a> N = N(view);
        for (int i3 = 0; i3 < N.size(); i3++) {
            if (N.get(i3).a() == i2) {
                N.remove(i3);
                return;
            }
        }
    }

    private static List<d.a> N(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(a.b.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(a.b.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static void a(View view, Paint paint) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setLayerPaint(paint);
        } else {
            view.setLayerType(view.getLayerType(), paint);
            view.invalidate();
        }
    }

    public static int h(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static ViewParent i(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getParentForAccessibility();
        }
        return view.getParent();
    }

    public static int j(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static void d(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i2);
        }
    }

    public static int k(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    public static int l(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    public static void b(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    public static int m(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!c) {
            try {
                b = View.class.getDeclaredField("mMinWidth");
                b.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            c = true;
        }
        if (b == null) {
            return 0;
        }
        try {
            return ((Integer) b.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static int n(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!e) {
            try {
                d = View.class.getDeclaredField("mMinHeight");
                d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            e = true;
        }
        if (d == null) {
            return 0;
        }
        try {
            return ((Integer) d.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static aa o(View view) {
        if (g == null) {
            g = new WeakHashMap<>();
        }
        aa aaVar = g.get(view);
        if (aaVar != null) {
            return aaVar;
        }
        aa aaVar2 = new aa(view);
        g.put(view, aaVar2);
        return aaVar2;
    }

    public static void a(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    public static float p(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static void b(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(f2);
        }
    }

    public static float q(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTranslationZ();
        }
        return 0.0f;
    }

    public static void a(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f == null) {
            f = new WeakHashMap<>();
        }
        f.put(view, str);
    }

    public static String r(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        if (f == null) {
            return null;
        }
        return f.get(view);
    }

    public static int s(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static void t(View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else if (Build.VERSION.SDK_INT >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static boolean u(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    @Deprecated
    public static void b(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void a(View view, r rVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (rVar == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.core.h.w.1
                    AnonymousClass1() {
                    }

                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        return r.this.a(view2, ae.a(windowInsets)).l();
                    }
                });
            }
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.core.h.w$1 */
    class AnonymousClass1 implements View.OnApplyWindowInsetsListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
            return r.this.a(view2, ae.a(windowInsets)).l();
        }
    }

    public static ae a(View view, ae aeVar) {
        WindowInsets l2;
        if (Build.VERSION.SDK_INT >= 21 && (l2 = aeVar.l()) != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(l2);
            if (!onApplyWindowInsets.equals(l2)) {
                return ae.a(onApplyWindowInsets);
            }
        }
        return aeVar;
    }

    public static ae b(View view, ae aeVar) {
        WindowInsets l2;
        return (Build.VERSION.SDK_INT < 21 || (l2 = aeVar.l()) == null || view.dispatchApplyWindowInsets(l2).equals(l2)) ? aeVar : ae.a(l2);
    }

    public static ae v(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ae.a(d.a(view));
        }
        return null;
    }

    public static ae a(View view, ae aeVar, Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? c.a(view, aeVar, rect) : aeVar;
    }

    public static boolean w(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean x(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList y(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof u) {
            return ((u) view).getSupportBackgroundTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
                return;
            }
            return;
        }
        if (view instanceof u) {
            ((u) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PorterDuff.Mode z(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof u) {
            return ((u) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
                return;
            }
            return;
        }
        if (view instanceof u) {
            ((u) view).setSupportBackgroundTintMode(mode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean A(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof j) {
            return ((j) view).isNestedScrollingEnabled();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void B(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof j) {
            ((j) view).stopNestedScroll();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void e(View view, int i2) {
        if (view instanceof k) {
            ((k) view).a(i2);
        } else if (i2 == 0) {
            B(view);
        }
    }

    public static boolean C(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static float D(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static void f(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Rect a2 = a();
            boolean z = false;
            Object parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                a2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !a2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            i(view, i2);
            if (z && a2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(a2);
                return;
            }
            return;
        }
        i(view, i2);
    }

    private static void i(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            O(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                O((View) parent);
            }
        }
    }

    public static void g(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Rect a2 = a();
            boolean z = false;
            Object parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                a2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !a2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            j(view, i2);
            if (z && a2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(a2);
                return;
            }
            return;
        }
        j(view, i2);
    }

    private static void j(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            O(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                O((View) parent);
            }
        }
    }

    private static void O(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void a(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static Rect E(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static boolean F(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean G(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static void a(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, i3);
        }
    }

    public static void a(View view, t tVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (tVar != null ? tVar.a() : null));
        }
    }

    public static Display H(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (F(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    static boolean a(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return g.a(view).a(keyEvent);
    }

    static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return g.a(view).a(view, keyEvent);
    }

    public static boolean I(View view) {
        Boolean c2 = b().c(view);
        if (c2 == null) {
            return false;
        }
        return c2.booleanValue();
    }

    /* compiled from: source */
    /* renamed from: androidx.core.h.w$2 */
    class AnonymousClass2 extends b<Boolean> {
        AnonymousClass2(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        @Override // androidx.core.h.w.b
        /* renamed from: a */
        public Boolean b(View view) {
            return Boolean.valueOf(view.isScreenReaderFocusable());
        }
    }

    private static b<Boolean> b() {
        return new b<Boolean>(a.b.tag_screen_reader_focusable, Boolean.class, 28) { // from class: androidx.core.h.w.2
            AnonymousClass2(int i2, Class cls, int i22) {
                super(i2, cls, i22);
            }

            @Override // androidx.core.h.w.b
            /* renamed from: a */
            public Boolean b(View view) {
                return Boolean.valueOf(view.isScreenReaderFocusable());
            }
        };
    }

    public static CharSequence J(View view) {
        return c().c(view);
    }

    /* compiled from: source */
    /* renamed from: androidx.core.h.w$3 */
    class AnonymousClass3 extends b<CharSequence> {
        AnonymousClass3(int i, Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        @Override // androidx.core.h.w.b
        /* renamed from: a */
        public CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }
    }

    private static b<CharSequence> c() {
        return new b<CharSequence>(a.b.tag_accessibility_pane_title, CharSequence.class, 8, 28) { // from class: androidx.core.h.w.3
            AnonymousClass3(int i2, Class cls, int i22, int i3) {
                super(i2, cls, i22, i3);
            }

            @Override // androidx.core.h.w.b
            /* renamed from: a */
            public CharSequence b(View view) {
                return view.getAccessibilityPaneTitle();
            }
        };
    }

    public static boolean K(View view) {
        Boolean c2 = d().c(view);
        if (c2 == null) {
            return false;
        }
        return c2.booleanValue();
    }

    /* compiled from: source */
    /* renamed from: androidx.core.h.w$4 */
    class AnonymousClass4 extends b<Boolean> {
        AnonymousClass4(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        @Override // androidx.core.h.w.b
        /* renamed from: a */
        public Boolean b(View view) {
            return Boolean.valueOf(view.isAccessibilityHeading());
        }
    }

    private static b<Boolean> d() {
        return new b<Boolean>(a.b.tag_accessibility_heading, Boolean.class, 28) { // from class: androidx.core.h.w.4
            AnonymousClass4(int i2, Class cls, int i22) {
                super(i2, cls, i22);
            }

            @Override // androidx.core.h.w.b
            /* renamed from: a */
            public Boolean b(View view) {
                return Boolean.valueOf(view.isAccessibilityHeading());
            }
        };
    }

    /* compiled from: source */
    static abstract class b<T> {
        private final int a;
        private final Class<T> b;
        private final int c;

        abstract T b(View view);

        b(int i, Class<T> cls, int i2) {
            this(i, cls, 0, i2);
        }

        b(int i, Class<T> cls, int i2, int i3) {
            this.a = i;
            this.b = cls;
            this.c = i3;
        }

        T c(View view) {
            if (a()) {
                return b(view);
            }
            if (!b()) {
                return null;
            }
            T t = (T) view.getTag(this.a);
            if (this.b.isInstance(t)) {
                return t;
            }
            return null;
        }

        private boolean a() {
            return Build.VERSION.SDK_INT >= this.c;
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= 19;
        }
    }

    static void h(View view, int i2) {
        if (((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z = J(view) != null;
            if (j(view) != 0 || (z && view.getVisibility() == 0)) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : 2048);
                obtain.setContentChangeTypes(i2);
                view.sendAccessibilityEventUnchecked(obtain);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    /* compiled from: source */
    static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        private WeakHashMap<View, Boolean> a = new WeakHashMap<>();

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            for (Map.Entry<View, Boolean> entry : this.a.entrySet()) {
                a(entry.getKey(), entry.getValue().booleanValue());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            a(view);
        }

        private void a(View view, boolean z) {
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                if (z2) {
                    w.h(view, 16);
                }
                this.a.put(view, Boolean.valueOf(z2));
            }
        }

        private void a(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: source */
    static class g {
        private static final ArrayList<WeakReference<View>> a = new ArrayList<>();
        private WeakHashMap<View, Boolean> b = null;
        private SparseArray<WeakReference<View>> c = null;
        private WeakReference<KeyEvent> d = null;

        g() {
        }

        private SparseArray<WeakReference<View>> a() {
            if (this.c == null) {
                this.c = new SparseArray<>();
            }
            return this.c;
        }

        static g a(View view) {
            g gVar = (g) view.getTag(a.b.tag_unhandled_key_event_manager);
            if (gVar != null) {
                return gVar;
            }
            g gVar2 = new g();
            view.setTag(a.b.tag_unhandled_key_event_manager, gVar2);
            return gVar2;
        }

        boolean a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                b();
            }
            View b = b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (b != null && !KeyEvent.isModifierKey(keyCode)) {
                    a().put(keyCode, new WeakReference<>(b));
                }
            }
            return b != null;
        }

        private View b(View view, KeyEvent keyEvent) {
            if (this.b == null || !this.b.containsKey(view)) {
                return null;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View b = b(viewGroup.getChildAt(childCount), keyEvent);
                    if (b != null) {
                        return b;
                    }
                }
            }
            if (c(view, keyEvent)) {
                return view;
            }
            return null;
        }

        boolean a(KeyEvent keyEvent) {
            int indexOfKey;
            if (this.d != null && this.d.get() == keyEvent) {
                return false;
            }
            this.d = new WeakReference<>(keyEvent);
            WeakReference<View> weakReference = null;
            SparseArray<WeakReference<View>> a2 = a();
            if (keyEvent.getAction() == 1 && (indexOfKey = a2.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference = a2.valueAt(indexOfKey);
                a2.removeAt(indexOfKey);
            }
            if (weakReference == null) {
                weakReference = a2.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = weakReference.get();
            if (view != null && w.F(view)) {
                c(view, keyEvent);
            }
            return true;
        }

        private boolean c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(a.b.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((f) arrayList.get(size)).a(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void b() {
            if (this.b != null) {
                this.b.clear();
            }
            if (a.isEmpty()) {
                return;
            }
            synchronized (a) {
                if (this.b == null) {
                    this.b = new WeakHashMap<>();
                }
                for (int size = a.size() - 1; size >= 0; size--) {
                    View view = a.get(size).get();
                    if (view == null) {
                        a.remove(size);
                    } else {
                        this.b.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.b.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: source */
    private static class c {
        static ae a(View view, ae aeVar, Rect rect) {
            WindowInsets l = aeVar.l();
            if (l != null) {
                return ae.a(view.computeSystemWindowInsets(l, rect));
            }
            rect.setEmpty();
            return aeVar;
        }
    }

    /* compiled from: source */
    private static class d {
        public static WindowInsets a(View view) {
            return view.getRootWindowInsets();
        }
    }

    /* compiled from: source */
    private static class e {
        static void a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }
    }
}
