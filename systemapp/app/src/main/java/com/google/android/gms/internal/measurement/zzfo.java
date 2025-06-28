package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzfo extends IOException {
    private zzgo a;

    public zzfo(String str) {
        super(str);
        this.a = null;
    }

    static zzfo a() {
        return new zzfo("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzfo b() {
        return new zzfo("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }
}
