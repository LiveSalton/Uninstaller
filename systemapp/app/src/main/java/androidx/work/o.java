package androidx.work;

import android.content.Context;
import java.util.Collections;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class o {
    public abstract k a(String str);

    public abstract k a(List<? extends p> list);

    public static o a(Context context) {
        return androidx.work.impl.h.b(context);
    }

    public static void a(Context context, b bVar) {
        androidx.work.impl.h.b(context, bVar);
    }

    public final k a(p pVar) {
        return a(Collections.singletonList(pVar));
    }

    protected o() {
    }
}
