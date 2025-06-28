package androidx.appcompat.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.support.multidex.BuildConfig;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.view.b;
import androidx.appcompat.view.f;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.af;
import androidx.appcompat.widget.ak;
import androidx.appcompat.widget.al;
import androidx.appcompat.widget.n;
import androidx.appcompat.widget.r;
import androidx.core.content.a.f;
import androidx.core.h.aa;
import androidx.core.h.ab;
import androidx.core.h.ac;
import androidx.core.h.ae;
import androidx.core.h.e;
import androidx.core.h.r;
import androidx.core.h.w;
import androidx.lifecycle.f;
import java.lang.Thread;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: source */
/* loaded from: classes.dex */
class AppCompatDelegateImpl extends androidx.appcompat.app.c implements LayoutInflater.Factory2, g.a {
    private static final androidx.b.g<String, Integer> u = new androidx.b.g<>();
    private static final boolean v;
    private static final int[] w;
    private static final boolean x;
    private static final boolean y;
    private static boolean z;
    private c A;
    private CharSequence B;
    private n C;
    private a D;
    private l E;
    private boolean F;
    private boolean G;
    private TextView H;
    private View I;
    private boolean J;
    private boolean K;
    private boolean L;
    private PanelFeatureState[] M;
    private PanelFeatureState N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private int S;
    private int T;
    private boolean U;
    private boolean V;
    private e W;
    private e X;
    private final Runnable Y;
    private boolean Z;
    final Object a;
    private Rect aa;
    private Rect ab;
    private androidx.appcompat.app.e ac;
    final Context b;
    Window c;
    final androidx.appcompat.app.b d;
    ActionBar e;
    MenuInflater f;
    androidx.appcompat.view.b g;
    ActionBarContextView h;
    PopupWindow i;
    Runnable j;
    aa k;
    ViewGroup l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    boolean s;
    int t;

    void a(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.c
    public void c(Bundle bundle) {
    }

    static {
        v = Build.VERSION.SDK_INT < 21;
        w = new int[]{R.attr.windowBackground};
        x = !"robolectric".equals(Build.FINGERPRINT);
        y = Build.VERSION.SDK_INT >= 17;
        if (!v || z) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.1
            final /* synthetic */ Thread.UncaughtExceptionHandler a;

            AnonymousClass1(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
                defaultUncaughtExceptionHandler = uncaughtExceptionHandler;
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                if (a(th)) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                    notFoundException.initCause(th.getCause());
                    notFoundException.setStackTrace(th.getStackTrace());
                    defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                    return;
                }
                defaultUncaughtExceptionHandler.uncaughtException(thread, th);
            }

            private boolean a(Throwable th) {
                String message;
                if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                    return false;
                }
                return message.contains("drawable") || message.contains("Drawable");
            }
        });
        z = true;
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$1 */
    class AnonymousClass1 implements Thread.UncaughtExceptionHandler {
        final /* synthetic */ Thread.UncaughtExceptionHandler a;

        AnonymousClass1(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            defaultUncaughtExceptionHandler = uncaughtExceptionHandler;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (a(th)) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                notFoundException.initCause(th.getCause());
                notFoundException.setStackTrace(th.getStackTrace());
                defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                return;
            }
            defaultUncaughtExceptionHandler.uncaughtException(thread, th);
        }

        private boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if ((AppCompatDelegateImpl.this.t & 1) != 0) {
                AppCompatDelegateImpl.this.h(0);
            }
            if ((AppCompatDelegateImpl.this.t & 4096) != 0) {
                AppCompatDelegateImpl.this.h(108);
            }
            AppCompatDelegateImpl.this.s = false;
            AppCompatDelegateImpl.this.t = 0;
        }
    }

    AppCompatDelegateImpl(Activity activity, androidx.appcompat.app.b bVar) {
        this(activity, null, bVar, activity);
    }

    AppCompatDelegateImpl(Dialog dialog, androidx.appcompat.app.b bVar) {
        this(dialog.getContext(), dialog.getWindow(), bVar, dialog);
    }

    private AppCompatDelegateImpl(Context context, Window window, androidx.appcompat.app.b bVar, Object obj) {
        Integer num;
        AppCompatActivity A;
        this.k = null;
        this.F = true;
        this.S = -100;
        this.Y = new Runnable() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if ((AppCompatDelegateImpl.this.t & 1) != 0) {
                    AppCompatDelegateImpl.this.h(0);
                }
                if ((AppCompatDelegateImpl.this.t & 4096) != 0) {
                    AppCompatDelegateImpl.this.h(108);
                }
                AppCompatDelegateImpl.this.s = false;
                AppCompatDelegateImpl.this.t = 0;
            }
        };
        this.b = context;
        this.d = bVar;
        this.a = obj;
        if (this.S == -100 && (this.a instanceof Dialog) && (A = A()) != null) {
            this.S = A.k().i();
        }
        if (this.S == -100 && (num = u.get(this.a.getClass().getName())) != null) {
            this.S = num.intValue();
            u.remove(this.a.getClass().getName());
        }
        if (window != null) {
            a(window);
        }
        androidx.appcompat.widget.f.a();
    }

    @Override // androidx.appcompat.app.c
    public Context b(Context context) {
        this.P = true;
        int a2 = a(context, C());
        if (y && (context instanceof ContextThemeWrapper)) {
            try {
                j.a((ContextThemeWrapper) context, a(context, a2, (Configuration) null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.d) {
            try {
                ((androidx.appcompat.view.d) context).a(a(context, a2, (Configuration) null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!x) {
            return super.b(context);
        }
        try {
            Configuration configuration = context.getPackageManager().getResourcesForApplication(context.getApplicationInfo()).getConfiguration();
            Configuration configuration2 = context.getResources().getConfiguration();
            Configuration a3 = a(context, a2, configuration.equals(configuration2) ? null : a(configuration, configuration2));
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, a.i.Theme_AppCompat_Empty);
            dVar.a(a3);
            boolean z2 = false;
            try {
                if (context.getTheme() != null) {
                    z2 = true;
                }
            } catch (NullPointerException unused3) {
            }
            if (z2) {
                f.b.a(dVar.getTheme());
            }
            return super.b(dVar);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Application failed to obtain resources from itself", e2);
        }
    }

    /* compiled from: source */
    private static class j {
        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    @Override // androidx.appcompat.app.c
    public void a(Bundle bundle) {
        this.P = true;
        b(false);
        w();
        if (this.a instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.f.b((Activity) this.a);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                ActionBar k2 = k();
                if (k2 == null) {
                    this.Z = true;
                } else {
                    k2.c(true);
                }
            }
            a(this);
        }
        this.Q = true;
    }

    @Override // androidx.appcompat.app.c
    public void b(Bundle bundle) {
        x();
    }

    @Override // androidx.appcompat.app.c
    public ActionBar a() {
        u();
        return this.e;
    }

    final ActionBar k() {
        return this.e;
    }

    final Window.Callback l() {
        return this.c.getCallback();
    }

    private void u() {
        x();
        if (this.m && this.e == null) {
            if (this.a instanceof Activity) {
                this.e = new androidx.appcompat.app.j((Activity) this.a, this.n);
            } else if (this.a instanceof Dialog) {
                this.e = new androidx.appcompat.app.j((Dialog) this.a);
            }
            if (this.e != null) {
                this.e.c(this.Z);
            }
        }
    }

    final Context m() {
        ActionBar a2 = a();
        Context b2 = a2 != null ? a2.b() : null;
        return b2 == null ? this.b : b2;
    }

    @Override // androidx.appcompat.app.c
    public MenuInflater b() {
        if (this.f == null) {
            u();
            this.f = new androidx.appcompat.view.g(this.e != null ? this.e.b() : this.b);
        }
        return this.f;
    }

    @Override // androidx.appcompat.app.c
    public <T extends View> T b(int i2) {
        x();
        return (T) this.c.findViewById(i2);
    }

    @Override // androidx.appcompat.app.c
    public void a(Configuration configuration) {
        ActionBar a2;
        if (this.m && this.G && (a2 = a()) != null) {
            a2.a(configuration);
        }
        androidx.appcompat.widget.f.b().a(this.b);
        b(false);
    }

    @Override // androidx.appcompat.app.c
    public void c() {
        this.R = true;
        t();
    }

    @Override // androidx.appcompat.app.c
    public void d() {
        this.R = false;
        ActionBar a2 = a();
        if (a2 != null) {
            a2.d(false);
        }
    }

    @Override // androidx.appcompat.app.c
    public void e() {
        ActionBar a2 = a();
        if (a2 != null) {
            a2.d(true);
        }
    }

    @Override // androidx.appcompat.app.c
    public void a(View view) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.l.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.A.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.c
    public void c(int i2) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.l.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.b).inflate(i2, viewGroup);
        this.A.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.c
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.l.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.A.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.c
    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        x();
        ((ViewGroup) this.l.findViewById(R.id.content)).addView(view, layoutParams);
        this.A.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.c
    public void g() {
        if (this.a instanceof Activity) {
            b(this);
        }
        if (this.s) {
            this.c.getDecorView().removeCallbacks(this.Y);
        }
        this.R = false;
        this.r = true;
        if (this.S != -100 && (this.a instanceof Activity) && ((Activity) this.a).isChangingConfigurations()) {
            u.put(this.a.getClass().getName(), Integer.valueOf(this.S));
        } else {
            u.remove(this.a.getClass().getName());
        }
        if (this.e != null) {
            this.e.g();
        }
        v();
    }

    private void v() {
        if (this.W != null) {
            this.W.e();
        }
        if (this.X != null) {
            this.X.e();
        }
    }

    @Override // androidx.appcompat.app.c
    public void a(int i2) {
        this.T = i2;
    }

    private void w() {
        if (this.c == null && (this.a instanceof Activity)) {
            a(((Activity) this.a).getWindow());
        }
        if (this.c == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private void a(Window window) {
        if (this.c != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof c) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.A = new c(callback);
        window.setCallback(this.A);
        af a2 = af.a(this.b, (AttributeSet) null, w);
        Drawable b2 = a2.b(0);
        if (b2 != null) {
            window.setBackgroundDrawable(b2);
        }
        a2.b();
        this.c = window;
    }

    private void x() {
        if (this.G) {
            return;
        }
        this.l = y();
        CharSequence n = n();
        if (!TextUtils.isEmpty(n)) {
            if (this.C != null) {
                this.C.setWindowTitle(n);
            } else if (k() != null) {
                k().a(n);
            } else if (this.H != null) {
                this.H.setText(n);
            }
        }
        z();
        a(this.l);
        this.G = true;
        PanelFeatureState a2 = a(0, false);
        if (this.r) {
            return;
        }
        if (a2 == null || a2.j == null) {
            i(108);
        }
    }

    private ViewGroup y() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.b.obtainStyledAttributes(a.j.AppCompatTheme);
        if (!obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowActionBar)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowNoTitle, false)) {
            d(1);
        } else if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionBar, false)) {
            d(108);
        }
        if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionBarOverlay, false)) {
            d(109);
        }
        if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionModeOverlay, false)) {
            d(10);
        }
        this.p = obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        w();
        this.c.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.b);
        if (!this.q) {
            if (this.p) {
                viewGroup = (ViewGroup) from.inflate(a.g.abc_dialog_title_material, (ViewGroup) null);
                this.n = false;
                this.m = false;
            } else if (this.m) {
                TypedValue typedValue = new TypedValue();
                this.b.getTheme().resolveAttribute(a.C0001a.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new androidx.appcompat.view.d(this.b, typedValue.resourceId);
                } else {
                    context = this.b;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(a.g.abc_screen_toolbar, (ViewGroup) null);
                this.C = (n) viewGroup.findViewById(a.f.decor_content_parent);
                this.C.setWindowCallback(l());
                if (this.n) {
                    this.C.a(109);
                }
                if (this.J) {
                    this.C.a(2);
                }
                if (this.K) {
                    this.C.a(5);
                }
            } else {
                viewGroup = null;
            }
        } else {
            viewGroup = this.o ? (ViewGroup) from.inflate(a.g.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(a.g.abc_screen_simple, (ViewGroup) null);
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.m + ", windowActionBarOverlay: " + this.n + ", android:windowIsFloating: " + this.p + ", windowActionModeOverlay: " + this.o + ", windowNoTitle: " + this.q + " }");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            w.a(viewGroup, new r() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.3
                AnonymousClass3() {
                }

                @Override // androidx.core.h.r
                public ae a(View view, ae aeVar) {
                    int b2 = aeVar.b();
                    int a2 = AppCompatDelegateImpl.this.a(aeVar, (Rect) null);
                    if (b2 != a2) {
                        aeVar = aeVar.a(aeVar.a(), a2, aeVar.c(), aeVar.d());
                    }
                    return w.a(view, aeVar);
                }
            });
        } else if (viewGroup instanceof androidx.appcompat.widget.r) {
            ((androidx.appcompat.widget.r) viewGroup).setOnFitSystemWindowsListener(new r.a() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.4
                AnonymousClass4() {
                }

                @Override // androidx.appcompat.widget.r.a
                public void a(Rect rect) {
                    rect.top = AppCompatDelegateImpl.this.a((ae) null, rect);
                }
            });
        }
        if (this.C == null) {
            this.H = (TextView) viewGroup.findViewById(a.f.title);
        }
        al.b(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(a.f.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.c.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.c.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.a() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.5
            @Override // androidx.appcompat.widget.ContentFrameLayout.a
            public void a() {
            }

            AnonymousClass5() {
            }

            @Override // androidx.appcompat.widget.ContentFrameLayout.a
            public void b() {
                AppCompatDelegateImpl.this.s();
            }
        });
        return viewGroup;
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$3 */
    class AnonymousClass3 implements androidx.core.h.r {
        AnonymousClass3() {
        }

        @Override // androidx.core.h.r
        public ae a(View view, ae aeVar) {
            int b2 = aeVar.b();
            int a2 = AppCompatDelegateImpl.this.a(aeVar, (Rect) null);
            if (b2 != a2) {
                aeVar = aeVar.a(aeVar.a(), a2, aeVar.c(), aeVar.d());
            }
            return w.a(view, aeVar);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$4 */
    class AnonymousClass4 implements r.a {
        AnonymousClass4() {
        }

        @Override // androidx.appcompat.widget.r.a
        public void a(Rect rect) {
            rect.top = AppCompatDelegateImpl.this.a((ae) null, rect);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$5 */
    class AnonymousClass5 implements ContentFrameLayout.a {
        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        AnonymousClass5() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void b() {
            AppCompatDelegateImpl.this.s();
        }
    }

    private void z() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.l.findViewById(R.id.content);
        View decorView = this.c.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.b.obtainStyledAttributes(a.j.AppCompatTheme);
        obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    @Override // androidx.appcompat.app.c
    public boolean d(int i2) {
        int j2 = j(i2);
        if (this.q && j2 == 108) {
            return false;
        }
        if (this.m && j2 == 1) {
            this.m = false;
        }
        switch (j2) {
            case 1:
                B();
                this.q = true;
                return true;
            case 2:
                B();
                this.J = true;
                return true;
            case 5:
                B();
                this.K = true;
                return true;
            case 10:
                B();
                this.o = true;
                return true;
            case 108:
                B();
                this.m = true;
                return true;
            case 109:
                B();
                this.n = true;
                return true;
            default:
                return this.c.requestFeature(j2);
        }
    }

    @Override // androidx.appcompat.app.c
    public final void a(CharSequence charSequence) {
        this.B = charSequence;
        if (this.C != null) {
            this.C.setWindowTitle(charSequence);
        } else if (k() != null) {
            k().a(charSequence);
        } else if (this.H != null) {
            this.H.setText(charSequence);
        }
    }

    final CharSequence n() {
        if (this.a instanceof Activity) {
            return ((Activity) this.a).getTitle();
        }
        return this.B;
    }

    void e(int i2) {
        if (i2 == 108) {
            ActionBar a2 = a();
            if (a2 != null) {
                a2.e(false);
                return;
            }
            return;
        }
        if (i2 == 0) {
            PanelFeatureState a3 = a(i2, true);
            if (a3.o) {
                a(a3, false);
            }
        }
    }

    void f(int i2) {
        ActionBar a2;
        if (i2 != 108 || (a2 = a()) == null) {
            return;
        }
        a2.e(true);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        PanelFeatureState a2;
        Window.Callback l2 = l();
        if (l2 == null || this.r || (a2 = a((Menu) gVar.q())) == null) {
            return false;
        }
        return l2.onMenuItemSelected(a2.a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void a(androidx.appcompat.view.menu.g gVar) {
        a(true);
    }

    public androidx.appcompat.view.b a(b.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.g != null) {
            this.g.c();
        }
        b bVar = new b(aVar);
        ActionBar a2 = a();
        if (a2 != null) {
            this.g = a2.a(bVar);
            if (this.g != null && this.d != null) {
                this.d.a(this.g);
            }
        }
        if (this.g == null) {
            this.g = b(bVar);
        }
        return this.g;
    }

    @Override // androidx.appcompat.app.c
    public void f() {
        ActionBar a2 = a();
        if (a2 == null || !a2.e()) {
            i(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.appcompat.view.b b(androidx.appcompat.view.b.a r8) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.b(androidx.appcompat.view.b$a):androidx.appcompat.view.b");
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$6 */
    class AnonymousClass6 implements Runnable {
        AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl.this.i.showAtLocation(AppCompatDelegateImpl.this.h, 55, 0, 0);
            AppCompatDelegateImpl.this.q();
            if (AppCompatDelegateImpl.this.o()) {
                AppCompatDelegateImpl.this.h.setAlpha(0.0f);
                AppCompatDelegateImpl.this.k = w.o(AppCompatDelegateImpl.this.h).a(1.0f);
                AppCompatDelegateImpl.this.k.a(new ac() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.6.1
                    AnonymousClass1() {
                    }

                    @Override // androidx.core.h.ac, androidx.core.h.ab
                    public void a(View view) {
                        AppCompatDelegateImpl.this.h.setVisibility(0);
                    }

                    @Override // androidx.core.h.ac, androidx.core.h.ab
                    public void b(View view) {
                        AppCompatDelegateImpl.this.h.setAlpha(1.0f);
                        AppCompatDelegateImpl.this.k.a((ab) null);
                        AppCompatDelegateImpl.this.k = null;
                    }
                });
                return;
            }
            AppCompatDelegateImpl.this.h.setAlpha(1.0f);
            AppCompatDelegateImpl.this.h.setVisibility(0);
        }

        /* compiled from: source */
        /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$6$1 */
        class AnonymousClass1 extends ac {
            AnonymousClass1() {
            }

            @Override // androidx.core.h.ac, androidx.core.h.ab
            public void a(View view) {
                AppCompatDelegateImpl.this.h.setVisibility(0);
            }

            @Override // androidx.core.h.ac, androidx.core.h.ab
            public void b(View view) {
                AppCompatDelegateImpl.this.h.setAlpha(1.0f);
                AppCompatDelegateImpl.this.k.a((ab) null);
                AppCompatDelegateImpl.this.k = null;
            }
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$7 */
    class AnonymousClass7 extends ac {
        AnonymousClass7() {
        }

        @Override // androidx.core.h.ac, androidx.core.h.ab
        public void a(View view) {
            AppCompatDelegateImpl.this.h.setVisibility(0);
            AppCompatDelegateImpl.this.h.sendAccessibilityEvent(32);
            if (AppCompatDelegateImpl.this.h.getParent() instanceof View) {
                w.t((View) AppCompatDelegateImpl.this.h.getParent());
            }
        }

        @Override // androidx.core.h.ac, androidx.core.h.ab
        public void b(View view) {
            AppCompatDelegateImpl.this.h.setAlpha(1.0f);
            AppCompatDelegateImpl.this.k.a((ab) null);
            AppCompatDelegateImpl.this.k = null;
        }
    }

    final boolean o() {
        return this.G && this.l != null && w.C(this.l);
    }

    public boolean p() {
        return this.F;
    }

    void q() {
        if (this.k != null) {
            this.k.b();
        }
    }

    boolean r() {
        if (this.g != null) {
            this.g.c();
            return true;
        }
        ActionBar a2 = a();
        return a2 != null && a2.f();
    }

    boolean a(int i2, KeyEvent keyEvent) {
        ActionBar a2 = a();
        if (a2 != null && a2.a(i2, keyEvent)) {
            return true;
        }
        if (this.N != null && a(this.N, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.N != null) {
                this.N.n = true;
            }
            return true;
        }
        if (this.N == null) {
            PanelFeatureState a3 = a(0, true);
            b(a3, keyEvent);
            boolean a4 = a(a3, keyEvent.getKeyCode(), keyEvent, 1);
            a3.m = false;
            if (a4) {
                return true;
            }
        }
        return false;
    }

    boolean a(KeyEvent keyEvent) {
        View decorView;
        if (((this.a instanceof e.a) || (this.a instanceof androidx.appcompat.app.d)) && (decorView = this.c.getDecorView()) != null && androidx.core.h.e.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.A.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? c(keyCode, keyEvent) : b(keyCode, keyEvent);
    }

    boolean b(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z2 = this.O;
            this.O = false;
            PanelFeatureState a2 = a(0, false);
            if (a2 != null && a2.o) {
                if (!z2) {
                    a(a2, true);
                }
                return true;
            }
            if (r()) {
                return true;
            }
        } else if (i2 == 82) {
            e(0, keyEvent);
            return true;
        }
        return false;
    }

    boolean c(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.O = (keyEvent.getFlags() & 128) != 0;
        } else if (i2 == 82) {
            d(0, keyEvent);
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z2 = false;
        if (this.ac == null) {
            String string = this.b.obtainStyledAttributes(a.j.AppCompatTheme).getString(a.j.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.ac = new androidx.appcompat.app.e();
            } else {
                try {
                    this.ac = (androidx.appcompat.app.e) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.ac = new androidx.appcompat.app.e();
                }
            }
        }
        if (v) {
            if (attributeSet instanceof XmlPullParser) {
                if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    z2 = true;
                }
            } else {
                z2 = a((ViewParent) view);
            }
        }
        return this.ac.a(view, str, context, attributeSet, z2, v, true, ak.a());
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.c.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || w.F((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    @Override // androidx.appcompat.app.c
    public void h() {
        LayoutInflater from = LayoutInflater.from(this.b);
        if (from.getFactory() == null) {
            androidx.core.h.f.a(from, this);
        } else {
            if (from.getFactory2() instanceof AppCompatDelegateImpl) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return a(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private AppCompatActivity A() {
        for (Context context = this.b; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
        }
        return null;
    }

    private void a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (panelFeatureState.o || this.r) {
            return;
        }
        if (panelFeatureState.a == 0) {
            if ((this.b.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback l2 = l();
        if (l2 != null && !l2.onMenuOpened(panelFeatureState.a, panelFeatureState.j)) {
            a(panelFeatureState, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.b.getSystemService("window");
        if (windowManager != null && b(panelFeatureState, keyEvent)) {
            if (panelFeatureState.g == null || panelFeatureState.q) {
                if (panelFeatureState.g == null) {
                    if (!a(panelFeatureState) || panelFeatureState.g == null) {
                        return;
                    }
                } else if (panelFeatureState.q && panelFeatureState.g.getChildCount() > 0) {
                    panelFeatureState.g.removeAllViews();
                }
                if (!c(panelFeatureState) || !panelFeatureState.a()) {
                    panelFeatureState.q = true;
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = panelFeatureState.h.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                }
                panelFeatureState.g.setBackgroundResource(panelFeatureState.b);
                ViewParent parent = panelFeatureState.h.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(panelFeatureState.h);
                }
                panelFeatureState.g.addView(panelFeatureState.h, layoutParams2);
                if (!panelFeatureState.h.hasFocus()) {
                    panelFeatureState.h.requestFocus();
                }
            } else if (panelFeatureState.i != null && (layoutParams = panelFeatureState.i.getLayoutParams()) != null && layoutParams.width == -1) {
                i2 = -1;
                panelFeatureState.n = false;
                WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.d, panelFeatureState.e, 1002, 8519680, -3);
                layoutParams3.gravity = panelFeatureState.c;
                layoutParams3.windowAnimations = panelFeatureState.f;
                windowManager.addView(panelFeatureState.g, layoutParams3);
                panelFeatureState.o = true;
            }
            i2 = -2;
            panelFeatureState.n = false;
            WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.d, panelFeatureState.e, 1002, 8519680, -3);
            layoutParams32.gravity = panelFeatureState.c;
            layoutParams32.windowAnimations = panelFeatureState.f;
            windowManager.addView(panelFeatureState.g, layoutParams32);
            panelFeatureState.o = true;
        }
    }

    private boolean a(PanelFeatureState panelFeatureState) {
        panelFeatureState.a(m());
        panelFeatureState.g = new k(panelFeatureState.l);
        panelFeatureState.c = 81;
        return true;
    }

    private void a(boolean z2) {
        if (this.C != null && this.C.e() && (!ViewConfiguration.get(this.b).hasPermanentMenuKey() || this.C.g())) {
            Window.Callback l2 = l();
            if (!this.C.f() || !z2) {
                if (l2 == null || this.r) {
                    return;
                }
                if (this.s && (this.t & 1) != 0) {
                    this.c.getDecorView().removeCallbacks(this.Y);
                    this.Y.run();
                }
                PanelFeatureState a2 = a(0, true);
                if (a2.j == null || a2.r || !l2.onPreparePanel(0, a2.i, a2.j)) {
                    return;
                }
                l2.onMenuOpened(108, a2.j);
                this.C.h();
                return;
            }
            this.C.i();
            if (this.r) {
                return;
            }
            l2.onPanelClosed(108, a(0, true).j);
            return;
        }
        PanelFeatureState a3 = a(0, true);
        a3.q = true;
        a(a3, false);
        a(a3, (KeyEvent) null);
    }

    private boolean b(PanelFeatureState panelFeatureState) {
        Context context = this.b;
        if ((panelFeatureState.a == 0 || panelFeatureState.a == 108) && this.C != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(a.C0001a.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(a.C0001a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(a.C0001a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        gVar.a(this);
        panelFeatureState.a(gVar);
        return true;
    }

    private boolean c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.i != null) {
            panelFeatureState.h = panelFeatureState.i;
            return true;
        }
        if (panelFeatureState.j == null) {
            return false;
        }
        if (this.E == null) {
            this.E = new l();
        }
        panelFeatureState.h = (View) panelFeatureState.a(this.E);
        return panelFeatureState.h != null;
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (this.r) {
            return false;
        }
        if (panelFeatureState.m) {
            return true;
        }
        if (this.N != null && this.N != panelFeatureState) {
            a(this.N, false);
        }
        Window.Callback l2 = l();
        if (l2 != null) {
            panelFeatureState.i = l2.onCreatePanelView(panelFeatureState.a);
        }
        boolean z2 = panelFeatureState.a == 0 || panelFeatureState.a == 108;
        if (z2 && this.C != null) {
            this.C.j();
        }
        if (panelFeatureState.i == null && (!z2 || !(k() instanceof androidx.appcompat.app.g))) {
            if (panelFeatureState.j == null || panelFeatureState.r) {
                if (panelFeatureState.j == null && (!b(panelFeatureState) || panelFeatureState.j == null)) {
                    return false;
                }
                if (z2 && this.C != null) {
                    if (this.D == null) {
                        this.D = new a();
                    }
                    this.C.a(panelFeatureState.j, this.D);
                }
                panelFeatureState.j.h();
                if (!l2.onCreatePanelMenu(panelFeatureState.a, panelFeatureState.j)) {
                    panelFeatureState.a((androidx.appcompat.view.menu.g) null);
                    if (z2 && this.C != null) {
                        this.C.a(null, this.D);
                    }
                    return false;
                }
                panelFeatureState.r = false;
            }
            panelFeatureState.j.h();
            if (panelFeatureState.s != null) {
                panelFeatureState.j.d(panelFeatureState.s);
                panelFeatureState.s = null;
            }
            if (!l2.onPreparePanel(0, panelFeatureState.i, panelFeatureState.j)) {
                if (z2 && this.C != null) {
                    this.C.a(null, this.D);
                }
                panelFeatureState.j.i();
                return false;
            }
            panelFeatureState.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.j.setQwertyMode(panelFeatureState.p);
            panelFeatureState.j.i();
        }
        panelFeatureState.m = true;
        panelFeatureState.n = false;
        this.N = panelFeatureState;
        return true;
    }

    void b(androidx.appcompat.view.menu.g gVar) {
        if (this.L) {
            return;
        }
        this.L = true;
        this.C.k();
        Window.Callback l2 = l();
        if (l2 != null && !this.r) {
            l2.onPanelClosed(108, gVar);
        }
        this.L = false;
    }

    void g(int i2) {
        a(a(i2, true), true);
    }

    void a(PanelFeatureState panelFeatureState, boolean z2) {
        if (z2 && panelFeatureState.a == 0 && this.C != null && this.C.f()) {
            b(panelFeatureState.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.b.getSystemService("window");
        if (windowManager != null && panelFeatureState.o && panelFeatureState.g != null) {
            windowManager.removeView(panelFeatureState.g);
            if (z2) {
                a(panelFeatureState.a, panelFeatureState, (Menu) null);
            }
        }
        panelFeatureState.m = false;
        panelFeatureState.n = false;
        panelFeatureState.o = false;
        panelFeatureState.h = null;
        panelFeatureState.q = true;
        if (this.N == panelFeatureState) {
            this.N = null;
        }
    }

    private boolean d(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState a2 = a(i2, true);
        if (a2.o) {
            return false;
        }
        return b(a2, keyEvent);
    }

    private boolean e(int i2, KeyEvent keyEvent) {
        boolean z2;
        boolean z3;
        if (this.g != null) {
            return false;
        }
        PanelFeatureState a2 = a(i2, true);
        if (i2 == 0 && this.C != null && this.C.e() && !ViewConfiguration.get(this.b).hasPermanentMenuKey()) {
            if (!this.C.f()) {
                if (!this.r && b(a2, keyEvent)) {
                    z2 = this.C.h();
                }
                z2 = false;
            } else {
                z2 = this.C.i();
            }
        } else if (a2.o || a2.n) {
            z2 = a2.o;
            a(a2, true);
        } else {
            if (a2.m) {
                if (a2.r) {
                    a2.m = false;
                    z3 = b(a2, keyEvent);
                } else {
                    z3 = true;
                }
                if (z3) {
                    a(a2, keyEvent);
                    z2 = true;
                }
            }
            z2 = false;
        }
        if (z2) {
            AudioManager audioManager = (AudioManager) this.b.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z2;
    }

    void a(int i2, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i2 >= 0 && i2 < this.M.length) {
                panelFeatureState = this.M[i2];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.o) && !this.r) {
            this.A.a().onPanelClosed(i2, menu);
        }
    }

    PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.M;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
            if (panelFeatureState != null && panelFeatureState.j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    protected PanelFeatureState a(int i2, boolean z2) {
        PanelFeatureState[] panelFeatureStateArr = this.M;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i2) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i2 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.M = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i2);
        panelFeatureStateArr[i2] = panelFeatureState2;
        return panelFeatureState2;
    }

    private boolean a(PanelFeatureState panelFeatureState, int i2, KeyEvent keyEvent, int i3) {
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.m || b(panelFeatureState, keyEvent)) && panelFeatureState.j != null) {
            z2 = panelFeatureState.j.performShortcut(i2, keyEvent, i3);
        }
        if (z2 && (i3 & 1) == 0 && this.C == null) {
            a(panelFeatureState, true);
        }
        return z2;
    }

    private void i(int i2) {
        this.t = (1 << i2) | this.t;
        if (this.s) {
            return;
        }
        w.a(this.c.getDecorView(), this.Y);
        this.s = true;
    }

    void h(int i2) {
        PanelFeatureState a2;
        PanelFeatureState a3 = a(i2, true);
        if (a3.j != null) {
            Bundle bundle = new Bundle();
            a3.j.c(bundle);
            if (bundle.size() > 0) {
                a3.s = bundle;
            }
            a3.j.h();
            a3.j.clear();
        }
        a3.r = true;
        a3.q = true;
        if ((i2 != 108 && i2 != 0) || this.C == null || (a2 = a(0, false)) == null) {
            return;
        }
        a2.m = false;
        b(a2, (KeyEvent) null);
    }

    final int a(ae aeVar, Rect rect) {
        int i2;
        boolean z2;
        boolean z3;
        if (aeVar != null) {
            i2 = aeVar.b();
        } else {
            i2 = rect != null ? rect.top : 0;
        }
        if (this.h == null || !(this.h.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.h.getLayoutParams();
            if (this.h.isShown()) {
                if (this.aa == null) {
                    this.aa = new Rect();
                    this.ab = new Rect();
                }
                Rect rect2 = this.aa;
                Rect rect3 = this.ab;
                if (aeVar == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(aeVar.a(), aeVar.b(), aeVar.c(), aeVar.d());
                }
                al.a(this.l, rect2, rect3);
                int i3 = rect2.top;
                int i4 = rect2.left;
                int i5 = rect2.right;
                ae v2 = w.v(this.l);
                int a2 = v2 == null ? 0 : v2.a();
                int c2 = v2 == null ? 0 : v2.c();
                if (marginLayoutParams.topMargin == i3 && marginLayoutParams.leftMargin == i4 && marginLayoutParams.rightMargin == i5) {
                    z3 = false;
                } else {
                    marginLayoutParams.topMargin = i3;
                    marginLayoutParams.leftMargin = i4;
                    marginLayoutParams.rightMargin = i5;
                    z3 = true;
                }
                if (i3 > 0 && this.I == null) {
                    this.I = new View(this.b);
                    this.I.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = a2;
                    layoutParams.rightMargin = c2;
                    this.l.addView(this.I, -1, layoutParams);
                } else if (this.I != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.I.getLayoutParams();
                    if (marginLayoutParams2.height != marginLayoutParams.topMargin || marginLayoutParams2.leftMargin != a2 || marginLayoutParams2.rightMargin != c2) {
                        marginLayoutParams2.height = marginLayoutParams.topMargin;
                        marginLayoutParams2.leftMargin = a2;
                        marginLayoutParams2.rightMargin = c2;
                        this.I.setLayoutParams(marginLayoutParams2);
                    }
                }
                z2 = this.I != null;
                if (z2 && this.I.getVisibility() != 0) {
                    b(this.I);
                }
                if (!this.o && z2) {
                    i2 = 0;
                }
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z3 = true;
                z2 = false;
            } else {
                z3 = false;
                z2 = false;
            }
            if (z3) {
                this.h.setLayoutParams(marginLayoutParams);
            }
        }
        if (this.I != null) {
            this.I.setVisibility(z2 ? 0 : 8);
        }
        return i2;
    }

    private void b(View view) {
        int c2;
        if ((w.s(view) & 8192) != 0) {
            c2 = androidx.core.content.a.c(this.b, a.c.abc_decor_view_status_guard_light);
        } else {
            c2 = androidx.core.content.a.c(this.b, a.c.abc_decor_view_status_guard);
        }
        view.setBackgroundColor(c2);
    }

    private void B() {
        if (this.G) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int j(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i2 != 9) {
            return i2;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    void s() {
        if (this.C != null) {
            this.C.k();
        }
        if (this.i != null) {
            this.c.getDecorView().removeCallbacks(this.j);
            if (this.i.isShowing()) {
                try {
                    this.i.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.i = null;
        }
        q();
        PanelFeatureState a2 = a(0, false);
        if (a2 == null || a2.j == null) {
            return;
        }
        a2.j.close();
    }

    public boolean t() {
        return b(true);
    }

    private boolean b(boolean z2) {
        if (this.r) {
            return false;
        }
        int C = C();
        boolean b2 = b(a(this.b, C), z2);
        if (C == 0) {
            c(this.b).d();
        } else if (this.W != null) {
            this.W.e();
        }
        if (C == 3) {
            d(this.b).d();
        } else if (this.X != null) {
            this.X.e();
        }
        return b2;
    }

    @Override // androidx.appcompat.app.c
    public int i() {
        return this.S;
    }

    int a(Context context, int i2) {
        if (i2 == -100) {
            return -1;
        }
        switch (i2) {
            case BuildConfig.VERSION_CODE /* -1 */:
            case 1:
            case 2:
                return i2;
            case 0:
                if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() != 0) {
                    return c(context).a();
                }
                return -1;
            case 3:
                return d(context).a();
            default:
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
        }
    }

    private int C() {
        return this.S != -100 ? this.S : j();
    }

    private Configuration a(Context context, int i2, Configuration configuration) {
        int i3;
        switch (i2) {
            case 1:
                i3 = 16;
                break;
            case 2:
                i3 = 32;
                break;
            default:
                i3 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
                break;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    private boolean b(int i2, boolean z2) {
        boolean z3;
        Configuration a2 = a(this.b, i2, (Configuration) null);
        boolean D = D();
        int i3 = this.b.getResources().getConfiguration().uiMode & 48;
        int i4 = a2.uiMode & 48;
        if (i3 != i4 && z2 && !D && this.P && ((x || this.Q) && (this.a instanceof Activity) && !((Activity) this.a).isChild())) {
            androidx.core.app.a.b((Activity) this.a);
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3 && i3 != i4) {
            a(i4, D, (Configuration) null);
            z3 = true;
        }
        if (z3 && (this.a instanceof AppCompatActivity)) {
            ((AppCompatActivity) this.a).a(i2);
        }
        return z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(int i2, boolean z2, Configuration configuration) {
        Resources resources = this.b.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i2 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        if (Build.VERSION.SDK_INT < 26) {
            androidx.appcompat.app.f.a(resources);
        }
        if (this.T != 0) {
            this.b.setTheme(this.T);
            if (Build.VERSION.SDK_INT >= 23) {
                this.b.getTheme().applyStyle(this.T, true);
            }
        }
        if (z2 && (this.a instanceof Activity)) {
            Activity activity = (Activity) this.a;
            if (activity instanceof androidx.lifecycle.j) {
                if (((androidx.lifecycle.j) activity).b().a().a(f.b.STARTED)) {
                    activity.onConfigurationChanged(configuration2);
                }
            } else if (this.R) {
                activity.onConfigurationChanged(configuration2);
            }
        }
    }

    private e c(Context context) {
        if (this.W == null) {
            this.W = new f(androidx.appcompat.app.i.a(context));
        }
        return this.W;
    }

    private e d(Context context) {
        if (this.X == null) {
            this.X = new d(context);
        }
        return this.X;
    }

    private boolean D() {
        int i2;
        if (!this.V && (this.a instanceof Activity)) {
            PackageManager packageManager = this.b.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    i2 = 269221888;
                } else {
                    i2 = Build.VERSION.SDK_INT >= 24 ? 786432 : 0;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.b, this.a.getClass()), i2);
                this.U = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.U = false;
            }
        }
        this.V = true;
        return this.U;
    }

    /* compiled from: source */
    class b implements b.a {
        private b.a b;

        public b(b.a aVar) {
            this.b = aVar;
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(androidx.appcompat.view.b bVar, Menu menu) {
            return this.b.a(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(androidx.appcompat.view.b bVar, Menu menu) {
            w.t(AppCompatDelegateImpl.this.l);
            return this.b.b(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(androidx.appcompat.view.b bVar, MenuItem menuItem) {
            return this.b.a(bVar, menuItem);
        }

        @Override // androidx.appcompat.view.b.a
        public void a(androidx.appcompat.view.b bVar) {
            this.b.a(bVar);
            if (AppCompatDelegateImpl.this.i != null) {
                AppCompatDelegateImpl.this.c.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.j);
            }
            if (AppCompatDelegateImpl.this.h != null) {
                AppCompatDelegateImpl.this.q();
                AppCompatDelegateImpl.this.k = w.o(AppCompatDelegateImpl.this.h).a(0.0f);
                AppCompatDelegateImpl.this.k.a(new ac() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.b.1
                    AnonymousClass1() {
                    }

                    @Override // androidx.core.h.ac, androidx.core.h.ab
                    public void b(View view) {
                        AppCompatDelegateImpl.this.h.setVisibility(8);
                        if (AppCompatDelegateImpl.this.i != null) {
                            AppCompatDelegateImpl.this.i.dismiss();
                        } else if (AppCompatDelegateImpl.this.h.getParent() instanceof View) {
                            w.t((View) AppCompatDelegateImpl.this.h.getParent());
                        }
                        AppCompatDelegateImpl.this.h.removeAllViews();
                        AppCompatDelegateImpl.this.k.a((ab) null);
                        AppCompatDelegateImpl.this.k = null;
                        w.t(AppCompatDelegateImpl.this.l);
                    }
                });
            }
            if (AppCompatDelegateImpl.this.d != null) {
                AppCompatDelegateImpl.this.d.b(AppCompatDelegateImpl.this.g);
            }
            AppCompatDelegateImpl.this.g = null;
            w.t(AppCompatDelegateImpl.this.l);
        }

        /* compiled from: source */
        /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$b$1 */
        class AnonymousClass1 extends ac {
            AnonymousClass1() {
            }

            @Override // androidx.core.h.ac, androidx.core.h.ab
            public void b(View view) {
                AppCompatDelegateImpl.this.h.setVisibility(8);
                if (AppCompatDelegateImpl.this.i != null) {
                    AppCompatDelegateImpl.this.i.dismiss();
                } else if (AppCompatDelegateImpl.this.h.getParent() instanceof View) {
                    w.t((View) AppCompatDelegateImpl.this.h.getParent());
                }
                AppCompatDelegateImpl.this.h.removeAllViews();
                AppCompatDelegateImpl.this.k.a((ab) null);
                AppCompatDelegateImpl.this.k = null;
                w.t(AppCompatDelegateImpl.this.l);
            }
        }
    }

    /* compiled from: source */
    private final class l implements m.a {
        l() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
            androidx.appcompat.view.menu.g q = gVar.q();
            boolean z2 = q != gVar;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                gVar = q;
            }
            PanelFeatureState a = appCompatDelegateImpl.a((Menu) gVar);
            if (a != null) {
                if (z2) {
                    AppCompatDelegateImpl.this.a(a.a, a, q);
                    AppCompatDelegateImpl.this.a(a, true);
                } else {
                    AppCompatDelegateImpl.this.a(a, z);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            Window.Callback l;
            if (gVar != gVar.q() || !AppCompatDelegateImpl.this.m || (l = AppCompatDelegateImpl.this.l()) == null || AppCompatDelegateImpl.this.r) {
                return true;
            }
            l.onMenuOpened(108, gVar);
            return true;
        }
    }

    /* compiled from: source */
    private final class a implements m.a {
        a() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            Window.Callback l = AppCompatDelegateImpl.this.l();
            if (l == null) {
                return true;
            }
            l.onMenuOpened(108, gVar);
            return true;
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
            AppCompatDelegateImpl.this.b(gVar);
        }
    }

    /* compiled from: source */
    protected static final class PanelFeatureState {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        androidx.appcompat.view.menu.g j;
        androidx.appcompat.view.menu.e k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        PanelFeatureState(int i) {
            this.a = i;
        }

        public boolean a() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.a().getCount() > 0;
        }

        void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(a.C0001a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(a.C0001a.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(a.i.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(a.j.AppCompatTheme);
            this.b = obtainStyledAttributes.getResourceId(a.j.AppCompatTheme_panelBackground, 0);
            this.f = obtainStyledAttributes.getResourceId(a.j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void a(androidx.appcompat.view.menu.g gVar) {
            if (gVar == this.j) {
                return;
            }
            if (this.j != null) {
                this.j.b(this.k);
            }
            this.j = gVar;
            if (gVar == null || this.k == null) {
                return;
            }
            gVar.a(this.k);
        }

        androidx.appcompat.view.menu.n a(m.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new androidx.appcompat.view.menu.e(this.l, a.g.abc_list_menu_item_layout);
                this.k.a(aVar);
                this.j.a(this.k);
            }
            return this.k.a(this.g);
        }

        /* compiled from: source */
        @SuppressLint({"BanParcelableUsage"})
        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState.1
                AnonymousClass1() {
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, null);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };
            int a;
            boolean b;
            Bundle c;

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            SavedState() {
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.b ? 1 : 0);
                if (this.b) {
                    parcel.writeBundle(this.c);
                }
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.a = parcel.readInt();
                savedState.b = parcel.readInt() == 1;
                if (savedState.b) {
                    savedState.c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            /* compiled from: source */
            /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState$SavedState$1 */
            class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
                AnonymousClass1() {
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, null);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            }
        }
    }

    /* compiled from: source */
    private class k extends ContentFrameLayout {
        public k(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                AppCompatDelegateImpl.this.g(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
        }

        private boolean a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }

    /* compiled from: source */
    class c extends androidx.appcompat.view.i {
        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onContentChanged() {
        }

        c(Window.Callback callback) {
            super(callback);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.a(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof androidx.appcompat.view.menu.g)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            androidx.appcompat.view.menu.g gVar = menu instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menu : null;
            if (i == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (gVar != null) {
                gVar.c(false);
            }
            return onPreparePanel;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImpl.this.f(i);
            return true;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImpl.this.e(i);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.p()) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        final ActionMode a(ActionMode.Callback callback) {
            f.a aVar = new f.a(AppCompatDelegateImpl.this.b, callback);
            androidx.appcompat.view.b a = AppCompatDelegateImpl.this.a(aVar);
            if (a != null) {
                return aVar.b(a);
            }
            return null;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (AppCompatDelegateImpl.this.p() && i == 0) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            PanelFeatureState a = AppCompatDelegateImpl.this.a(0, true);
            if (a != null && a.j != null) {
                super.onProvideKeyboardShortcuts(list, a.j, i);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i);
            }
        }
    }

    /* compiled from: source */
    abstract class e {
        private BroadcastReceiver a;

        abstract int a();

        abstract void b();

        abstract IntentFilter c();

        e() {
        }

        void d() {
            e();
            IntentFilter c = c();
            if (c == null || c.countActions() == 0) {
                return;
            }
            if (this.a == null) {
                this.a = new BroadcastReceiver() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.e.1
                    AnonymousClass1() {
                    }

                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        e.this.b();
                    }
                };
            }
            AppCompatDelegateImpl.this.b.registerReceiver(this.a, c);
        }

        /* compiled from: source */
        /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$e$1 */
        class AnonymousClass1 extends BroadcastReceiver {
            AnonymousClass1() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                e.this.b();
            }
        }

        void e() {
            if (this.a != null) {
                try {
                    AppCompatDelegateImpl.this.b.unregisterReceiver(this.a);
                } catch (IllegalArgumentException unused) {
                }
                this.a = null;
            }
        }
    }

    /* compiled from: source */
    private class f extends e {
        private final androidx.appcompat.app.i c;

        f(androidx.appcompat.app.i iVar) {
            super();
            this.c = iVar;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.e
        public int a() {
            return this.c.a() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.e
        public void b() {
            AppCompatDelegateImpl.this.t();
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.e
        IntentFilter c() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }
    }

    /* compiled from: source */
    private class d extends e {
        private final PowerManager c;

        d(Context context) {
            super();
            this.c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.e
        public int a() {
            return (Build.VERSION.SDK_INT < 21 || !this.c.isPowerSaveMode()) ? 1 : 2;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.e
        public void b() {
            AppCompatDelegateImpl.this.t();
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.e
        IntentFilter c() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }
    }

    private static Configuration a(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 == null || configuration.diff(configuration2) == 0) {
            return configuration3;
        }
        if (configuration.fontScale != configuration2.fontScale) {
            configuration3.fontScale = configuration2.fontScale;
        }
        if (configuration.mcc != configuration2.mcc) {
            configuration3.mcc = configuration2.mcc;
        }
        if (configuration.mnc != configuration2.mnc) {
            configuration3.mnc = configuration2.mnc;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            h.a(configuration, configuration2, configuration3);
        } else if (!androidx.core.g.c.a(configuration.locale, configuration2.locale)) {
            configuration3.locale = configuration2.locale;
        }
        if (configuration.touchscreen != configuration2.touchscreen) {
            configuration3.touchscreen = configuration2.touchscreen;
        }
        if (configuration.keyboard != configuration2.keyboard) {
            configuration3.keyboard = configuration2.keyboard;
        }
        if (configuration.keyboardHidden != configuration2.keyboardHidden) {
            configuration3.keyboardHidden = configuration2.keyboardHidden;
        }
        if (configuration.navigation != configuration2.navigation) {
            configuration3.navigation = configuration2.navigation;
        }
        if (configuration.navigationHidden != configuration2.navigationHidden) {
            configuration3.navigationHidden = configuration2.navigationHidden;
        }
        if (configuration.orientation != configuration2.orientation) {
            configuration3.orientation = configuration2.orientation;
        }
        if ((configuration.screenLayout & 15) != (configuration2.screenLayout & 15)) {
            configuration3.screenLayout |= configuration2.screenLayout & 15;
        }
        if ((configuration.screenLayout & 192) != (configuration2.screenLayout & 192)) {
            configuration3.screenLayout |= configuration2.screenLayout & 192;
        }
        if ((configuration.screenLayout & 48) != (configuration2.screenLayout & 48)) {
            configuration3.screenLayout |= configuration2.screenLayout & 48;
        }
        if ((configuration.screenLayout & 768) != (configuration2.screenLayout & 768)) {
            configuration3.screenLayout |= configuration2.screenLayout & 768;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            i.a(configuration, configuration2, configuration3);
        }
        if ((configuration.uiMode & 15) != (configuration2.uiMode & 15)) {
            configuration3.uiMode |= configuration2.uiMode & 15;
        }
        if ((configuration.uiMode & 48) != (configuration2.uiMode & 48)) {
            configuration3.uiMode |= configuration2.uiMode & 48;
        }
        if (configuration.screenWidthDp != configuration2.screenWidthDp) {
            configuration3.screenWidthDp = configuration2.screenWidthDp;
        }
        if (configuration.screenHeightDp != configuration2.screenHeightDp) {
            configuration3.screenHeightDp = configuration2.screenHeightDp;
        }
        if (configuration.smallestScreenWidthDp != configuration2.smallestScreenWidthDp) {
            configuration3.smallestScreenWidthDp = configuration2.smallestScreenWidthDp;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            g.a(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    /* compiled from: source */
    static class g {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if (configuration.densityDpi != configuration2.densityDpi) {
                configuration3.densityDpi = configuration2.densityDpi;
            }
        }
    }

    /* compiled from: source */
    static class h {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }
    }

    /* compiled from: source */
    static class i {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                configuration3.colorMode |= configuration2.colorMode & 3;
            }
            if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                configuration3.colorMode |= configuration2.colorMode & 12;
            }
        }
    }
}
