package androidx.navigation;

import androidx.lifecycle.f;
import androidx.lifecycle.j;
import androidx.lifecycle.k;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import java.util.UUID;

/* compiled from: source */
/* loaded from: classes.dex */
public final class a implements j, y, androidx.savedstate.c {
    final UUID a;
    private final k b;
    private final androidx.savedstate.b c;
    private f.b d;
    private f.b e;
    private c f;

    @Override // androidx.lifecycle.j
    public f b() {
        return this.b;
    }

    void a(f.a aVar) {
        this.d = b(aVar);
        a();
    }

    void a() {
        if (this.d.ordinal() < this.e.ordinal()) {
            this.b.b(this.d);
        } else {
            this.b.b(this.e);
        }
    }

    @Override // androidx.lifecycle.y
    public x c() {
        if (this.f == null) {
            throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
        }
        return this.f.a(this.a);
    }

    @Override // androidx.savedstate.c
    public androidx.savedstate.a e() {
        return this.c.a();
    }

    private static f.b b(f.a aVar) {
        switch (aVar) {
            case ON_CREATE:
            case ON_STOP:
                return f.b.CREATED;
            case ON_START:
            case ON_PAUSE:
                return f.b.STARTED;
            case ON_RESUME:
                return f.b.RESUMED;
            case ON_DESTROY:
                return f.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }
}
