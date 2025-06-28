package com.google.android.gms.tasks;

/* compiled from: source */
/* loaded from: classes.dex */
final class d implements Runnable {
    private final /* synthetic */ Task a;
    private final /* synthetic */ e b;

    d(e eVar, Task task) {
        this.b = eVar;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnFailureListener onFailureListener;
        OnFailureListener onFailureListener2;
        obj = this.b.b;
        synchronized (obj) {
            onFailureListener = this.b.c;
            if (onFailureListener != null) {
                onFailureListener2 = this.b.c;
                onFailureListener2.a(this.a.e());
            }
        }
    }
}
