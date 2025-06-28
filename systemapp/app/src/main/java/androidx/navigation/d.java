package androidx.navigation;

import java.util.HashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public class d {
    private static final HashMap<String, Class<?>> a = new HashMap<>();
    private e b;
    private int c;
    private String d;
    private CharSequence e;

    final void a(e eVar) {
        this.b = eVar;
    }

    public final e a() {
        return this.b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        if (this.d == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(this.c));
        } else {
            sb.append(this.d);
        }
        sb.append(")");
        if (this.e != null) {
            sb.append(" label=");
            sb.append(this.e);
        }
        return sb.toString();
    }
}
