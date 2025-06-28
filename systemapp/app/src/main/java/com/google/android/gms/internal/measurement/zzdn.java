package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdl;
import com.google.android.gms.internal.measurement.zzdn;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzdn<MessageType extends zzdl<MessageType, BuilderType>, BuilderType extends zzdn<MessageType, BuilderType>> implements zzgn {
    @Override // 
    /* renamed from: a */
    public abstract BuilderType clone();

    protected abstract BuilderType a(MessageType messagetype);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzgn
    public final /* synthetic */ zzgn a(zzgo zzgoVar) {
        if (!g().getClass().isInstance(zzgoVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        return a((zzdn<MessageType, BuilderType>) zzgoVar);
    }
}
