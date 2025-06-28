package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.f;
import androidx.lifecycle.s;

/* compiled from: source */
/* loaded from: classes.dex */
public class r implements j {
    private static final r i = new r();
    private Handler f;
    private int b = 0;
    private int c = 0;
    private boolean d = true;
    private boolean e = true;
    private final k g = new k(this);
    private Runnable h = new Runnable() { // from class: androidx.lifecycle.r.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.g();
            r.this.h();
        }
    };
    s.a a = new s.a() { // from class: androidx.lifecycle.r.2
        @Override // androidx.lifecycle.s.a
        public void a() {
        }

        AnonymousClass2() {
        }

        @Override // androidx.lifecycle.s.a
        public void b() {
            r.this.c();
        }

        @Override // androidx.lifecycle.s.a
        public void c() {
            r.this.d();
        }
    };

    /* compiled from: source */
    /* renamed from: androidx.lifecycle.r$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.g();
            r.this.h();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.lifecycle.r$2 */
    class AnonymousClass2 implements s.a {
        @Override // androidx.lifecycle.s.a
        public void a() {
        }

        AnonymousClass2() {
        }

        @Override // androidx.lifecycle.s.a
        public void b() {
            r.this.c();
        }

        @Override // androidx.lifecycle.s.a
        public void c() {
            r.this.d();
        }
    }

    public static j a() {
        return i;
    }

    static void a(Context context) {
        i.b(context);
    }

    void c() {
        this.b++;
        if (this.b == 1 && this.e) {
            this.g.a(f.a.ON_START);
            this.e = false;
        }
    }

    void d() {
        this.c++;
        if (this.c == 1) {
            if (this.d) {
                this.g.a(f.a.ON_RESUME);
                this.d = false;
            } else {
                this.f.removeCallbacks(this.h);
            }
        }
    }

    void e() {
        this.c--;
        if (this.c == 0) {
            this.f.postDelayed(this.h, 700L);
        }
    }

    void f() {
        this.b--;
        h();
    }

    void g() {
        if (this.c == 0) {
            this.d = true;
            this.g.a(f.a.ON_PAUSE);
        }
    }

    void h() {
        if (this.b == 0 && this.d) {
            this.g.a(f.a.ON_STOP);
            this.e = true;
        }
    }

    private r() {
    }

    void b(Context context) {
        this.f = new Handler();
        this.g.a(f.a.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new b() { // from class: androidx.lifecycle.r.3
            AnonymousClass3() {
            }

            /* compiled from: source */
            /* renamed from: androidx.lifecycle.r$3$1 */
            class AnonymousClass1 extends b {
                AnonymousClass1() {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPostStarted(Activity activity) {
                    r.this.c();
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPostResumed(Activity activity) {
                    r.this.d();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPreCreated(Activity activity, Bundle bundle) {
                activity.registerActivityLifecycleCallbacks(new b() { // from class: androidx.lifecycle.r.3.1
                    AnonymousClass1() {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPostStarted(Activity activity2) {
                        r.this.c();
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPostResumed(Activity activity2) {
                        r.this.d();
                    }
                });
            }

            @Override // androidx.lifecycle.b, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (Build.VERSION.SDK_INT < 29) {
                    s.b(activity).a(r.this.a);
                }
            }

            @Override // androidx.lifecycle.b, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                r.this.e();
            }

            @Override // androidx.lifecycle.b, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                r.this.f();
            }
        });
    }

    /* compiled from: source */
    /* renamed from: androidx.lifecycle.r$3 */
    class AnonymousClass3 extends b {
        AnonymousClass3() {
        }

        /* compiled from: source */
        /* renamed from: androidx.lifecycle.r$3$1 */
        class AnonymousClass1 extends b {
            AnonymousClass1() {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity2) {
                r.this.c();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity2) {
                r.this.d();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            activity.registerActivityLifecycleCallbacks(new b() { // from class: androidx.lifecycle.r.3.1
                AnonymousClass1() {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPostStarted(Activity activity2) {
                    r.this.c();
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPostResumed(Activity activity2) {
                    r.this.d();
                }
            });
        }

        @Override // androidx.lifecycle.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 29) {
                s.b(activity).a(r.this.a);
            }
        }

        @Override // androidx.lifecycle.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            r.this.e();
        }

        @Override // androidx.lifecycle.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            r.this.f();
        }
    }

    @Override // androidx.lifecycle.j
    public f b() {
        return this.g;
    }
}
