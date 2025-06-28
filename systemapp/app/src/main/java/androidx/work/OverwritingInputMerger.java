package androidx.work;

import androidx.work.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class OverwritingInputMerger extends g {
    @Override // androidx.work.g
    public e a(List<e> list) {
        e.a aVar = new e.a();
        HashMap hashMap = new HashMap();
        Iterator<e> it = list.iterator();
        while (it.hasNext()) {
            hashMap.putAll(it.next().a());
        }
        aVar.a(hashMap);
        return aVar.a();
    }
}
