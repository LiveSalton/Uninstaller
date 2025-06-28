package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeik;
import com.google.android.gms.internal.ads.zzein;
import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzein<MessageType extends zzeik<MessageType, BuilderType>, BuilderType extends zzein<MessageType, BuilderType>> implements zzelr {
    protected abstract BuilderType a(MessageType messagetype);

    public abstract BuilderType a(zzejj zzejjVar, zzeju zzejuVar) throws IOException;

    @Override // 
    /* renamed from: b */
    public abstract BuilderType clone();

    public BuilderType a(byte[] bArr, int i, int i2, zzeju zzejuVar) throws zzeks {
        try {
            zzejj a = zzejj.a(bArr, 0, i2, false);
            a(a, zzejuVar);
            a.a(0);
            return this;
        } catch (zzeks e) {
            throw e;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(60 + String.valueOf(name).length() + String.valueOf("byte array").length());
            sb.append("Reading ");
            sb.append(name);
            sb.append(" from a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzelr
    public final /* synthetic */ zzelr a(zzels zzelsVar) {
        if (!w().getClass().isInstance(zzelsVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        return a((zzein<MessageType, BuilderType>) zzelsVar);
    }
}
