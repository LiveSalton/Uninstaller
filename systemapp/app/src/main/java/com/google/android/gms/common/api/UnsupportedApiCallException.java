package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;

/* compiled from: source */
/* loaded from: classes.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature a;

    @Override // java.lang.Throwable
    public final String getMessage() {
        String valueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(8 + String.valueOf(valueOf).length());
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
