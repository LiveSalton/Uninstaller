package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;

/* compiled from: source */
/* loaded from: classes.dex */
final class anz extends TimeoutException {
    /* JADX INFO: Access modifiers changed from: private */
    anz(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    /* synthetic */ anz(String str, anx anxVar) {
        this(str);
    }
}
