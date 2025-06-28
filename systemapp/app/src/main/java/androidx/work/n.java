package androidx.work;

import java.util.Set;
import java.util.UUID;

/* compiled from: source */
/* loaded from: classes.dex */
public final class n {
    private UUID a;
    private a b;
    private e c;
    private Set<String> d;
    private int e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (this.e == nVar.e && this.a.equals(nVar.a) && this.b == nVar.b && this.c.equals(nVar.c)) {
            return this.d.equals(nVar.d);
        }
        return false;
    }

    public int hashCode() {
        return (31 * ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode())) + this.e;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.a + "', mState=" + this.b + ", mOutputData=" + this.c + ", mTags=" + this.d + '}';
    }

    /* compiled from: source */
    public enum a {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public boolean a() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }
}
