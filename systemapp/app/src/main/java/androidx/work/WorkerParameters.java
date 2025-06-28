package androidx.work;

import android.net.Network;
import android.net.Uri;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class WorkerParameters {
    private UUID a;
    private e b;
    private Set<String> c;
    private a d;
    private int e;
    private Executor f;
    private androidx.work.impl.utils.b.a g;
    private q h;

    /* compiled from: source */
    public static class a {
        public List<String> a = Collections.emptyList();
        public List<Uri> b = Collections.emptyList();
        public Network c;
    }

    public WorkerParameters(UUID uuid, e eVar, Collection<String> collection, a aVar, int i, Executor executor, androidx.work.impl.utils.b.a aVar2, q qVar) {
        this.a = uuid;
        this.b = eVar;
        this.c = new HashSet(collection);
        this.d = aVar;
        this.e = i;
        this.f = executor;
        this.g = aVar2;
        this.h = qVar;
    }

    public UUID a() {
        return this.a;
    }

    public e b() {
        return this.b;
    }

    public Set<String> c() {
        return this.c;
    }

    public List<Uri> d() {
        return this.d.b;
    }

    public List<String> e() {
        return this.d.a;
    }

    public Network f() {
        return this.d.c;
    }

    public int g() {
        return this.e;
    }

    public Executor h() {
        return this.f;
    }

    public androidx.work.impl.utils.b.a i() {
        return this.g;
    }

    public q j() {
        return this.h;
    }
}
