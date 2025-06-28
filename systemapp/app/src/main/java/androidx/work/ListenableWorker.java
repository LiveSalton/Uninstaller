package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.annotation.Keep;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class ListenableWorker {
    private Context a;
    private WorkerParameters b;
    private volatile boolean c;
    private boolean d;

    public void onStopped() {
    }

    public abstract com.google.a.a.a.a<a> startWork();

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.a = context;
        this.b = workerParameters;
    }

    public final Context getApplicationContext() {
        return this.a;
    }

    public final UUID getId() {
        return this.b.a();
    }

    public final e getInputData() {
        return this.b.b();
    }

    public final Set<String> getTags() {
        return this.b.c();
    }

    public final List<Uri> getTriggeredContentUris() {
        return this.b.d();
    }

    public final List<String> getTriggeredContentAuthorities() {
        return this.b.e();
    }

    public final Network getNetwork() {
        return this.b.f();
    }

    public final int getRunAttemptCount() {
        return this.b.g();
    }

    public final boolean isStopped() {
        return this.c;
    }

    public final void stop() {
        this.c = true;
        onStopped();
    }

    public final boolean isUsed() {
        return this.d;
    }

    public final void setUsed() {
        this.d = true;
    }

    public Executor getBackgroundExecutor() {
        return this.b.h();
    }

    public androidx.work.impl.utils.b.a getTaskExecutor() {
        return this.b.i();
    }

    public q getWorkerFactory() {
        return this.b.j();
    }

    /* compiled from: source */
    public static abstract class a {
        public static a a() {
            return new c();
        }

        public static a a(e eVar) {
            return new c(eVar);
        }

        public static a b() {
            return new b();
        }

        public static a c() {
            return new C0050a();
        }

        a() {
        }

        /* compiled from: source */
        public static final class c extends a {
            private final e a;

            public c() {
                this(e.a);
            }

            public c(e eVar) {
                this.a = eVar;
            }

            public e d() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                return this.a.equals(((c) obj).a);
            }

            public int hashCode() {
                return (31 * c.class.getName().hashCode()) + this.a.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.a + '}';
            }
        }

        /* compiled from: source */
        /* renamed from: androidx.work.ListenableWorker$a$a */
        public static final class C0050a extends a {
            private final e a;

            public C0050a() {
                this(e.a);
            }

            public C0050a(e eVar) {
                this.a = eVar;
            }

            public e d() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                return this.a.equals(((C0050a) obj).a);
            }

            public int hashCode() {
                return (31 * C0050a.class.getName().hashCode()) + this.a.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.a + '}';
            }
        }

        /* compiled from: source */
        public static final class b extends a {
            public String toString() {
                return "Retry";
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass();
            }

            public int hashCode() {
                return b.class.getName().hashCode();
            }
        }
    }
}
