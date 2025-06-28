package com.google.android.gms.internal.ads;

import java.lang.Thread;

/* compiled from: source */
/* loaded from: classes.dex */
final class du implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ Thread.UncaughtExceptionHandler a;
    private final /* synthetic */ zzasn b;

    du(zzasn zzasnVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.b = zzasnVar;
        this.a = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            try {
                this.b.a(thread, th);
                if (this.a != null) {
                    this.a.uncaughtException(thread, th);
                }
            } catch (Throwable unused) {
                zzaza.c("AdMob exception reporter failed reporting the exception.");
                if (this.a != null) {
                    this.a.uncaughtException(thread, th);
                }
            }
        } catch (Throwable th2) {
            if (this.a != null) {
                this.a.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
