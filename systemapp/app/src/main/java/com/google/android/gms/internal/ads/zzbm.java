package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzbm implements zzbo {
    private static Logger a = Logger.getLogger(zzbm.class.getName());
    private ThreadLocal<ByteBuffer> b = new ll(this);

    public abstract zzbp a(String str, byte[] bArr, String str2);

    @Override // com.google.android.gms.internal.ads.zzbo
    public final zzbp a(zzeor zzeorVar, zzbs zzbsVar) throws IOException {
        int a2;
        long a3;
        long b = zzeorVar.b();
        this.b.get().rewind().limit(8);
        do {
            a2 = zzeorVar.a(this.b.get());
            if (a2 == 8) {
                this.b.get().rewind();
                long a4 = zzbq.a(this.b.get());
                byte[] bArr = null;
                if (a4 < 8 && a4 > 1) {
                    Logger logger = a;
                    Level level = Level.SEVERE;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Plausibility check failed: size < 8 (size = ");
                    sb.append(a4);
                    sb.append("). Stop parsing!");
                    logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                    return null;
                }
                String f = zzbq.f(this.b.get());
                if (a4 == 1) {
                    this.b.get().limit(16);
                    zzeorVar.a(this.b.get());
                    this.b.get().position(8);
                    a3 = zzbq.c(this.b.get()) - 16;
                } else {
                    a3 = a4 == 0 ? zzeorVar.a() - zzeorVar.b() : a4 - 8;
                }
                if ("uuid".equals(f)) {
                    this.b.get().limit(this.b.get().limit() + 16);
                    zzeorVar.a(this.b.get());
                    bArr = new byte[16];
                    for (int position = this.b.get().position() - 16; position < this.b.get().position(); position++) {
                        bArr[position - (this.b.get().position() - 16)] = this.b.get().get(position);
                    }
                    a3 -= 16;
                }
                long j = a3;
                zzbp a5 = a(f, bArr, zzbsVar instanceof zzbp ? ((zzbp) zzbsVar).a() : "");
                a5.a(zzbsVar);
                this.b.get().rewind();
                a5.a(zzeorVar, this.b.get(), j, this);
                return a5;
            }
        } while (a2 >= 0);
        zzeorVar.a(b);
        throw new EOFException();
    }
}
