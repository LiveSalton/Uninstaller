package androidx.transition;

import android.os.IBinder;

/* compiled from: source */
/* loaded from: classes.dex */
class ar implements at {
    private final IBinder a;

    ar(IBinder iBinder) {
        this.a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ar) && ((ar) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
