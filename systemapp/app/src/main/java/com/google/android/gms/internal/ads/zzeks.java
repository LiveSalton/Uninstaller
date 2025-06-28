package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzeks extends IOException {
    private zzels a;

    public zzeks(String str) {
        super(str);
        this.a = null;
    }

    public final zzeks a(zzels zzelsVar) {
        this.a = zzelsVar;
        return this;
    }

    static zzeks a() {
        return new zzeks("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzeks b() {
        return new zzeks("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzeks c() {
        return new zzeks("CodedInputStream encountered a malformed varint.");
    }

    static zzeks d() {
        return new zzeks("Protocol message contained an invalid tag (zero).");
    }

    static zzeks e() {
        return new zzeks("Protocol message end-group tag did not match expected tag.");
    }

    static zzekr f() {
        return new zzekr("Protocol message tag had invalid wire type.");
    }

    static zzeks g() {
        return new zzeks("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzeks h() {
        return new zzeks("Failed to parse the message.");
    }

    static zzeks i() {
        return new zzeks("Protocol message had invalid UTF-8.");
    }
}
