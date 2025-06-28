package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: source */
/* loaded from: classes.dex */
public class i extends androidx.core.h.a {
    final RecyclerView a;
    final androidx.core.h.a b = new a(this);

    public i(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    boolean b() {
        return this.a.v();
    }

    @Override // androidx.core.h.a
    public boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        if (b() || this.a.getLayoutManager() == null) {
            return false;
        }
        return this.a.getLayoutManager().a(i, bundle);
    }

    @Override // androidx.core.h.a
    public void a(View view, androidx.core.h.a.d dVar) {
        super.a(view, dVar);
        dVar.b((CharSequence) RecyclerView.class.getName());
        if (b() || this.a.getLayoutManager() == null) {
            return;
        }
        this.a.getLayoutManager().a(dVar);
    }

    @Override // androidx.core.h.a
    public void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if (!(view instanceof RecyclerView) || b()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().a(accessibilityEvent);
        }
    }

    public androidx.core.h.a c() {
        return this.b;
    }

    /* compiled from: source */
    public static class a extends androidx.core.h.a {
        final i a;

        public a(i iVar) {
            this.a = iVar;
        }

        @Override // androidx.core.h.a
        public void a(View view, androidx.core.h.a.d dVar) {
            super.a(view, dVar);
            if (this.a.b() || this.a.a.getLayoutManager() == null) {
                return;
            }
            this.a.a.getLayoutManager().a(view, dVar);
        }

        @Override // androidx.core.h.a
        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            if (this.a.b() || this.a.a.getLayoutManager() == null) {
                return false;
            }
            return this.a.a.getLayoutManager().a(view, i, bundle);
        }
    }
}
