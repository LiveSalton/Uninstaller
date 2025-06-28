package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public class y {
    public View b;
    public final Map<String, Object> a = new HashMap();
    final ArrayList<Transition> c = new ArrayList<>();

    @Deprecated
    public y() {
    }

    public y(View view) {
        this.b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.b == yVar.b && this.a.equals(yVar.a);
    }

    public int hashCode() {
        return (31 * this.b.hashCode()) + this.a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.b + "\n") + "    values:";
        for (String str2 : this.a.keySet()) {
            str = str + "    " + str2 + ": " + this.a.get(str2) + "\n";
        }
        return str;
    }
}
