package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class bf extends zzbfz {
    private final /* synthetic */ zzaka a;

    /* JADX INFO: Access modifiers changed from: private */
    bf(zzaka zzakaVar) {
        this.a = zzakaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfz
    public final void a(zzbfy zzbfyVar) {
        zzakr zzakrVar;
        zzakr zzakrVar2;
        zzakrVar = this.a.b;
        if (zzakrVar != null) {
            zzakrVar2 = this.a.b;
            zzakrVar2.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfz
    public final void b(zzbfy zzbfyVar) {
        this.a.a(zzbfyVar.b);
    }

    @Override // com.google.android.gms.internal.ads.zzbfz
    public final boolean c(zzbfy zzbfyVar) {
        return this.a.a(zzbfyVar.b);
    }

    /* synthetic */ bf(zzaka zzakaVar, bd bdVar) {
        this(zzakaVar);
    }
}
