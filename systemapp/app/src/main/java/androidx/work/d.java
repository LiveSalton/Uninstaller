package androidx.work;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class d {
    private final Set<a> a = new HashSet();

    public void a(Uri uri, boolean z) {
        this.a.add(new a(uri, z));
    }

    public Set<a> a() {
        return this.a;
    }

    public int b() {
        return this.a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((d) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    /* compiled from: source */
    public static final class a {
        private final Uri a;
        private final boolean b;

        a(Uri uri, boolean z) {
            this.a = uri;
            this.b = z;
        }

        public Uri a() {
            return this.a;
        }

        public boolean b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && this.a.equals(aVar.a);
        }

        public int hashCode() {
            return (31 * this.a.hashCode()) + (this.b ? 1 : 0);
        }
    }
}
