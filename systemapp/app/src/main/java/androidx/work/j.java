package androidx.work;

import android.os.Build;
import androidx.work.p;

/* compiled from: source */
/* loaded from: classes.dex */
public final class j extends p {
    j(a aVar) {
        super(aVar.b, aVar.c, aVar.d);
    }

    /* compiled from: source */
    public static final class a extends p.a<a, j> {
        @Override // androidx.work.p.a
        /* renamed from: b */
        public a c() {
            return this;
        }

        public a(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.c.d = OverwritingInputMerger.class.getName();
        }

        @Override // androidx.work.p.a
        /* renamed from: a */
        public j d() {
            if (this.a && Build.VERSION.SDK_INT >= 23 && this.c.j.c()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            return new j(this);
        }
    }
}
