package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzble {
    private final zzckq a;
    private final zzdnj b;

    public zzble(zzckq zzckqVar, zzdnj zzdnjVar) {
        this.a = zzckqVar;
        this.b = zzdnjVar;
    }

    public final void a(long j, int i) {
        String str;
        zzckp a = this.a.a().a(this.b.b.b).a("action", "ad_closed").a("show_time", String.valueOf(j)).a("ad_format", "app_open_ad");
        switch (lm.a[i - 1]) {
            case 1:
                str = "bb";
                break;
            case 2:
                str = "h";
                break;
            case 3:
                str = "cc";
                break;
            case 4:
                str = "ac";
                break;
            case 5:
                str = "cb";
                break;
            case 6:
                str = "u";
                break;
            default:
                str = "u";
                break;
        }
        a.a("acr", str).a();
    }
}
