package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: source */
/* loaded from: classes.dex */
final class ba implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzazq a;
    private final /* synthetic */ zzait b;

    ba(zzait zzaitVar, zzazq zzazqVar) {
        this.b = zzaitVar;
        this.a = zzazqVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void a(Bundle bundle) {
        zzaii zzaiiVar;
        try {
            zzazq zzazqVar = this.a;
            zzaiiVar = this.b.a;
            zzazqVar.b(zzaiiVar.w());
        } catch (DeadObjectException e) {
            this.a.a(e);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void a(int i) {
        zzazq zzazqVar = this.a;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i);
        zzazqVar.a(new RuntimeException(sb.toString()));
    }
}
