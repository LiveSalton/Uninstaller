package androidx.work.impl.b;

/* compiled from: source */
/* loaded from: classes.dex */
public class d {
    public final String a;
    public final int b;

    public d(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.b != dVar.b) {
            return false;
        }
        return this.a.equals(dVar.a);
    }

    public int hashCode() {
        return (31 * this.a.hashCode()) + this.b;
    }
}
