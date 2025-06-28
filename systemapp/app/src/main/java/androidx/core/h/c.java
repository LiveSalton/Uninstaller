package androidx.core.h;

/* compiled from: source */
/* loaded from: classes.dex */
public final class c {
    private final Object a;

    private c(Object obj) {
        this.a = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.a == null) {
            return cVar.a == null;
        }
        return this.a.equals(cVar.a);
    }

    public int hashCode() {
        if (this.a == null) {
            return 0;
        }
        return this.a.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.a + "}";
    }

    static c a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new c(obj);
    }
}
