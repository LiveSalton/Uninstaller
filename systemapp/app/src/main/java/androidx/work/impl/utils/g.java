package androidx.work.impl.utils;

import androidx.work.WorkerParameters;

/* compiled from: source */
/* loaded from: classes.dex */
public class g implements Runnable {
    private androidx.work.impl.h a;
    private String b;
    private WorkerParameters.a c;

    public g(androidx.work.impl.h hVar, String str, WorkerParameters.a aVar) {
        this.a = hVar;
        this.b = str;
        this.c = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f().a(this.b, this.c);
    }
}
