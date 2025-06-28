package androidx.transition;

import android.view.View;
import android.view.WindowId;

/* compiled from: source */
/* loaded from: classes.dex */
class as implements at {
    private final WindowId a;

    as(View view) {
        this.a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof as) && ((as) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
