package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzeoo implements zzbp {
    private static zzeox b = zzeox.a(zzeoo.class);
    private String c;
    private zzbs d;
    private ByteBuffer f;
    private long g;
    private long h;
    private zzeor j;
    private long i = -1;
    private ByteBuffer k = null;
    private boolean e = true;
    boolean a = true;

    private final synchronized void b() {
        if (!this.e) {
            try {
                zzeox zzeoxVar = b;
                String valueOf = String.valueOf(this.c);
                zzeoxVar.a(valueOf.length() != 0 ? "mem mapping ".concat(valueOf) : new String("mem mapping "));
                this.f = this.j.a(this.g, this.i);
                this.e = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected abstract void a(ByteBuffer byteBuffer);

    protected zzeoo(String str) {
        this.c = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final void a(zzeor zzeorVar, ByteBuffer byteBuffer, long j, zzbo zzboVar) throws IOException {
        this.g = zzeorVar.b();
        this.h = this.g - byteBuffer.remaining();
        this.i = j;
        this.j = zzeorVar;
        zzeorVar.a(zzeorVar.b() + j);
        this.e = false;
        this.a = false;
        d();
    }

    public final synchronized void d() {
        b();
        zzeox zzeoxVar = b;
        String valueOf = String.valueOf(this.c);
        zzeoxVar.a(valueOf.length() != 0 ? "parsing details of ".concat(valueOf) : new String("parsing details of "));
        if (this.f != null) {
            ByteBuffer byteBuffer = this.f;
            this.a = true;
            byteBuffer.rewind();
            a(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.k = byteBuffer.slice();
            }
            this.f = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final String a() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final void a(zzbs zzbsVar) {
        this.d = zzbsVar;
    }
}
