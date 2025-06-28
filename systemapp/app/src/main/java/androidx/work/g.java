package androidx.work;

import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class g {
    private static final String a = h.a("InputMerger");

    public abstract e a(List<e> list);

    public static g a(String str) {
        try {
            return (g) Class.forName(str).newInstance();
        } catch (Exception e) {
            h.a().e(a, "Trouble instantiating + " + str, e);
            return null;
        }
    }
}
