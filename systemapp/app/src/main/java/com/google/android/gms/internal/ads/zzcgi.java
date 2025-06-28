package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcgi implements zzahv<Object> {
    private final zzafp a;
    private final zzcgh b;
    private final zzeoz<zzcgb> c;

    public zzcgi(zzccl zzcclVar, zzcce zzcceVar, zzcgh zzcghVar, zzeoz<zzcgb> zzeozVar) {
        this.a = zzcclVar.b(zzcceVar.u());
        this.b = zzcghVar;
        this.c = zzeozVar;
    }

    public final void a() {
        if (this.a == null) {
            return;
        }
        this.b.a("/nativeAdCustomClick", this);
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final void a(Object obj, Map<String, String> map) {
        String str = map.get("asset");
        try {
            this.a.a(this.c.b(), str);
        } catch (RemoteException e) {
            StringBuilder sb = new StringBuilder(40 + String.valueOf(str).length());
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            zzd.d(sb.toString(), e);
        }
    }
}
