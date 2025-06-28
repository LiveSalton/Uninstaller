package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbcp {
    private long a;

    public final long a(ByteBuffer byteBuffer) {
        zzbu zzbuVar;
        zzbr zzbrVar;
        if (this.a > 0) {
            return this.a;
        }
        try {
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.flip();
            Iterator<zzbp> it = new zzbn(new hp(duplicate), hr.a).b().iterator();
            while (true) {
                zzbuVar = null;
                if (!it.hasNext()) {
                    zzbrVar = null;
                    break;
                }
                zzbp next = it.next();
                if (next instanceof zzbr) {
                    zzbrVar = (zzbr) next;
                    break;
                }
            }
            Iterator<zzbp> it2 = zzbrVar.b().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                zzbp next2 = it2.next();
                if (next2 instanceof zzbu) {
                    zzbuVar = (zzbu) next2;
                    break;
                }
            }
            this.a = (1000 * zzbuVar.c()) / zzbuVar.b();
            return this.a;
        } catch (IOException | RuntimeException unused) {
            return 0L;
        }
    }
}
