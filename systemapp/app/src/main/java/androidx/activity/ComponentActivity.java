package androidx.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.f;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import androidx.lifecycle.k;
import androidx.lifecycle.s;
import androidx.lifecycle.x;
import androidx.lifecycle.y;

/* compiled from: source */
/* loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements c, j, y, androidx.savedstate.c {
    private final k a;
    private final androidx.savedstate.b b;
    private x c;
    private final OnBackPressedDispatcher d;
    private int e;

    @Deprecated
    public Object a() {
        return null;
    }

    /* compiled from: source */
    static final class a {
        Object a;
        x b;

        a() {
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.activity.ComponentActivity$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.super.onBackPressed();
        }
    }

    public ComponentActivity() {
        this.a = new k(this);
        this.b = androidx.savedstate.b.a(this);
        this.d = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.ComponentActivity.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ComponentActivity.super.onBackPressed();
            }
        });
        if (b() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            b().a(new h() { // from class: androidx.activity.ComponentActivity.2
                AnonymousClass2() {
                }

                @Override // androidx.lifecycle.h
                public void a(j jVar, f.a aVar) {
                    if (aVar == f.a.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View peekDecorView = window != null ? window.peekDecorView() : null;
                        if (peekDecorView != null) {
                            peekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
        b().a(new h() { // from class: androidx.activity.ComponentActivity.3
            AnonymousClass3() {
            }

            @Override // androidx.lifecycle.h
            public void a(j jVar, f.a aVar) {
                if (aVar != f.a.ON_DESTROY || ComponentActivity.this.isChangingConfigurations()) {
                    return;
                }
                ComponentActivity.this.c().b();
            }
        });
        if (19 > Build.VERSION.SDK_INT || Build.VERSION.SDK_INT > 23) {
            return;
        }
        b().a(new ImmLeaksCleaner(this));
    }

    /* compiled from: source */
    /* renamed from: androidx.activity.ComponentActivity$2 */
    class AnonymousClass2 implements h {
        AnonymousClass2() {
        }

        @Override // androidx.lifecycle.h
        public void a(j jVar, f.a aVar) {
            if (aVar == f.a.ON_STOP) {
                Window window = ComponentActivity.this.getWindow();
                View peekDecorView = window != null ? window.peekDecorView() : null;
                if (peekDecorView != null) {
                    peekDecorView.cancelPendingInputEvents();
                }
            }
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.activity.ComponentActivity$3 */
    class AnonymousClass3 implements h {
        AnonymousClass3() {
        }

        @Override // androidx.lifecycle.h
        public void a(j jVar, f.a aVar) {
            if (aVar != f.a.ON_DESTROY || ComponentActivity.this.isChangingConfigurations()) {
                return;
            }
            ComponentActivity.this.c().b();
        }
    }

    public ComponentActivity(int i) {
        this();
        this.e = i;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.a(bundle);
        s.a(this);
        if (this.e != 0) {
            setContentView(this.e);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        f b = b();
        if (b instanceof k) {
            ((k) b).b(f.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.b.b(bundle);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        a aVar;
        Object a2 = a();
        x xVar = this.c;
        if (xVar == null && (aVar = (a) getLastNonConfigurationInstance()) != null) {
            xVar = aVar.b;
        }
        if (xVar == null && a2 == null) {
            return null;
        }
        a aVar2 = new a();
        aVar2.a = a2;
        aVar2.b = xVar;
        return aVar2;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.j
    public f b() {
        return this.a;
    }

    @Override // androidx.lifecycle.y
    public x c() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.c == null) {
            a aVar = (a) getLastNonConfigurationInstance();
            if (aVar != null) {
                this.c = aVar.b;
            }
            if (this.c == null) {
                this.c = new x();
            }
        }
        return this.c;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.d.a();
    }

    @Override // androidx.activity.c
    public final OnBackPressedDispatcher d() {
        return this.d;
    }

    @Override // androidx.savedstate.c
    public final androidx.savedstate.a e() {
        return this.b.a();
    }
}
