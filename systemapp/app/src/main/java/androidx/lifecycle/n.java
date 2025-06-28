package androidx.lifecycle;

import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public class n {
    private Map<String, Integer> a = new HashMap();

    public boolean a(String str, int i) {
        Integer num = this.a.get(str);
        int intValue = num != null ? num.intValue() : 0;
        boolean z = (intValue & i) != 0;
        this.a.put(str, Integer.valueOf(i | intValue));
        return !z;
    }
}
