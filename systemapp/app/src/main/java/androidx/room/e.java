package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
class e {
    final Set<LiveData> a = Collections.newSetFromMap(new IdentityHashMap());
    private final i b;

    e(i iVar) {
        this.b = iVar;
    }
}
