package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
final class rd implements zzadx {
    private final /* synthetic */ zzcdy a;
    private final /* synthetic */ ViewGroup b;
    private final /* synthetic */ zzcda c;

    rd(zzcda zzcdaVar, zzcdy zzcdyVar, ViewGroup viewGroup) {
        this.c = zzcdaVar;
        this.a = zzcdyVar;
        this.b = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final void a() {
        boolean a;
        zzcda zzcdaVar = this.c;
        a = zzcda.a(this.a, zzccy.a);
        if (a) {
            this.a.onClick(this.b);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final void a(MotionEvent motionEvent) {
        this.a.onTouch(null, motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final JSONObject b() {
        return this.a.j();
    }
}
