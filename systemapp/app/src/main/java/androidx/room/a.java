package androidx.room;

import android.content.Context;
import androidx.g.a.c;
import androidx.room.i;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public class a {
    public final c.InterfaceC0038c a;
    public final Context b;
    public final String c;
    public final i.d d;
    public final List<i.b> e;
    public final boolean f;
    public final i.c g;
    public final Executor h;
    public final Executor i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    private final Set<Integer> m;

    public a(Context context, String str, c.InterfaceC0038c interfaceC0038c, i.d dVar, List<i.b> list, boolean z, i.c cVar, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set<Integer> set) {
        this.a = interfaceC0038c;
        this.b = context;
        this.c = str;
        this.d = dVar;
        this.e = list;
        this.f = z;
        this.g = cVar;
        this.h = executor;
        this.i = executor2;
        this.j = z2;
        this.k = z3;
        this.l = z4;
        this.m = set;
    }

    public boolean a(int i, int i2) {
        if ((i > i2) && this.l) {
            return false;
        }
        return this.k && (this.m == null || !this.m.contains(Integer.valueOf(i)));
    }
}
