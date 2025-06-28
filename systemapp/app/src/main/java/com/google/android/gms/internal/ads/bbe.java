package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* compiled from: source */
/* loaded from: classes.dex */
final class bbe implements ThreadFactory {
    private final /* synthetic */ String a;

    bbe(String str) {
        this.a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.a);
    }
}
