package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdrz {
    private final Executor a;
    private final zzaze b;

    public zzdrz(Executor executor, zzaze zzazeVar) {
        this.a = executor;
        this.b = zzazeVar;
    }

    public final void a(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public final void a(String str) {
        this.a.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.ake
            private final zzdrz a;
            private final String b;

            {
                this.a = this;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.b(this.b);
            }
        });
    }

    final /* synthetic */ void b(String str) {
        this.b.a(str);
    }
}
