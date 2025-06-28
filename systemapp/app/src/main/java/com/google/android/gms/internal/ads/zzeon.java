package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzeon extends zzeop implements zzbp {
    private zzbs f;
    private String g;
    private boolean h;
    private long i;

    public zzeon(String str) {
        this.g = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final void a(zzbs zzbsVar) {
        this.f = zzbsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final String a() {
        return this.g;
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final void a(zzeor zzeorVar, ByteBuffer byteBuffer, long j, zzbo zzboVar) throws IOException {
        this.i = zzeorVar.b() - byteBuffer.remaining();
        this.h = byteBuffer.remaining() == 16;
        a(zzeorVar, j, zzboVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeop
    public final void a(zzeor zzeorVar, long j, zzbo zzboVar) throws IOException {
        this.b = zzeorVar;
        this.c = zzeorVar.b();
        this.d = this.c - ((this.h || 8 + j >= 4294967296L) ? 16 : 8);
        zzeorVar.a(zzeorVar.b() + j);
        this.e = zzeorVar.b();
        this.a = zzboVar;
    }
}
