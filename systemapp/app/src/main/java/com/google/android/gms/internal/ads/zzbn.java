package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzbn extends zzeop implements Closeable {
    private static zzeox f = zzeox.a(zzbn.class);

    public zzbn(zzeor zzeorVar, zzbo zzboVar) throws IOException {
        a(zzeorVar, zzeorVar.a(), zzboVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeop, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    @Override // com.google.android.gms.internal.ads.zzeop
    public String toString() {
        String obj = this.b.toString();
        StringBuilder sb = new StringBuilder(7 + String.valueOf(obj).length());
        sb.append("model(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
