package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzai;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzl;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class m extends com.google.android.gms.internal.ads.zzbh {
    private final /* synthetic */ byte[] a;
    private final /* synthetic */ Map b;
    private final /* synthetic */ zzayu c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    m(zzax zzaxVar, int i, String str, com.google.android.gms.internal.ads.zzal zzalVar, zzai zzaiVar, byte[] bArr, Map map, zzayu zzayuVar) {
        super(i, str, zzalVar, zzaiVar);
        this.a = bArr;
        this.b = map;
        this.c = zzayuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    public final byte[] a() throws zzl {
        return this.a == null ? super.a() : this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    public final Map<String, String> b() throws zzl {
        return this.b == null ? super.b() : this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    /* renamed from: a */
    public final void a2(String str) {
        this.c.a(str);
        super.a(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbh, com.google.android.gms.internal.ads.zzaa
    protected final /* synthetic */ void a(String str) {
        a(str);
    }
}
