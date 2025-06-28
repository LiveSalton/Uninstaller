package androidx.activity;

import android.annotation.SuppressLint;
import androidx.lifecycle.f;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import java.util.ArrayDeque;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    final ArrayDeque<b> a;
    private final Runnable b;

    public OnBackPressedDispatcher() {
        this(null);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.a = new ArrayDeque<>();
        this.b = runnable;
    }

    androidx.activity.a a(b bVar) {
        this.a.add(bVar);
        a aVar = new a(bVar);
        bVar.a(aVar);
        return aVar;
    }

    @SuppressLint({"LambdaLast"})
    public void a(j jVar, b bVar) {
        f b = jVar.b();
        if (b.a() == f.b.DESTROYED) {
            return;
        }
        bVar.a(new LifecycleOnBackPressedCancellable(b, bVar));
    }

    public void a() {
        Iterator<b> descendingIterator = this.a.descendingIterator();
        while (descendingIterator.hasNext()) {
            b next = descendingIterator.next();
            if (next.a()) {
                next.c();
                return;
            }
        }
        if (this.b != null) {
            this.b.run();
        }
    }

    /* compiled from: source */
    private class a implements androidx.activity.a {
        private final b b;

        a(b bVar) {
            this.b = bVar;
        }

        @Override // androidx.activity.a
        public void a() {
            OnBackPressedDispatcher.this.a.remove(this.b);
            this.b.b(this);
        }
    }

    /* compiled from: source */
    private class LifecycleOnBackPressedCancellable implements androidx.activity.a, h {
        private final f b;
        private final b c;
        private androidx.activity.a d;

        LifecycleOnBackPressedCancellable(f fVar, b bVar) {
            this.b = fVar;
            this.c = bVar;
            fVar.a(this);
        }

        @Override // androidx.lifecycle.h
        public void a(j jVar, f.a aVar) {
            if (aVar == f.a.ON_START) {
                this.d = OnBackPressedDispatcher.this.a(this.c);
                return;
            }
            if (aVar == f.a.ON_STOP) {
                if (this.d != null) {
                    this.d.a();
                }
            } else if (aVar == f.a.ON_DESTROY) {
                a();
            }
        }

        @Override // androidx.activity.a
        public void a() {
            this.b.b(this);
            this.c.b(this);
            if (this.d != null) {
                this.d.a();
                this.d = null;
            }
        }
    }
}
