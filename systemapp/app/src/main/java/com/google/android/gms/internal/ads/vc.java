package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
final class vc extends zzaja {
    private final /* synthetic */ Object a;
    private final /* synthetic */ String b;
    private final /* synthetic */ long c;
    private final /* synthetic */ zzazq d;
    private final /* synthetic */ zzclp e;

    vc(zzclp zzclpVar, Object obj, String str, long j, zzazq zzazqVar) {
        this.e = zzclpVar;
        this.a = obj;
        this.b = str;
        this.c = j;
        this.d = zzazqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzajb
    public final void a() {
        zzckz zzckzVar;
        synchronized (this.a) {
            this.e.a(this.b, true, "", (int) (zzp.j().b() - this.c));
            zzckzVar = this.e.k;
            zzckzVar.b(this.b);
            this.d.b(true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajb
    public final void a(String str) {
        zzckz zzckzVar;
        synchronized (this.a) {
            this.e.a(this.b, false, str, (int) (zzp.j().b() - this.c));
            zzckzVar = this.e.k;
            zzckzVar.a(this.b, "error");
            this.d.b(false);
        }
    }
}
