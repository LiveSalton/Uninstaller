package androidx.navigation;

import androidx.lifecycle.f;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
class NavController$1 implements h {
    final /* synthetic */ b a;

    @Override // androidx.lifecycle.h
    public void a(j jVar, f.a aVar) {
        if (this.a.a != null) {
            Iterator<a> it = this.a.b.iterator();
            while (it.hasNext()) {
                it.next().a(aVar);
            }
        }
    }
}
