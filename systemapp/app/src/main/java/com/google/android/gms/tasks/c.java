package com.google.android.gms.tasks;

/* compiled from: source */
/* loaded from: classes.dex */
final class c implements Runnable {
    private final /* synthetic */ Task a;
    private final /* synthetic */ b b;

    c(b bVar, Task task) {
        this.b = bVar;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        i iVar2;
        i iVar3;
        Continuation continuation;
        i iVar4;
        i iVar5;
        if (this.a.c()) {
            iVar5 = this.b.c;
            iVar5.f();
            return;
        }
        try {
            continuation = this.b.b;
            Object a = continuation.a(this.a);
            iVar4 = this.b.c;
            iVar4.a((i) a);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                iVar3 = this.b.c;
                iVar3.a((Exception) e.getCause());
            } else {
                iVar2 = this.b.c;
                iVar2.a((Exception) e);
            }
        } catch (Exception e2) {
            iVar = this.b.c;
            iVar.a(e2);
        }
    }
}
