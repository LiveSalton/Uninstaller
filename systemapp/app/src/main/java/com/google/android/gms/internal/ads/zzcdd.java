package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcdd implements View.OnClickListener {
    String a;
    Long b;
    WeakReference<View> c;
    private final zzcgh d;
    private final Clock e;
    private zzage f;
    private zzahv<Object> g;

    public zzcdd(zzcgh zzcghVar, Clock clock) {
        this.d = zzcghVar;
        this.e = clock;
    }

    public final void a(zzage zzageVar) {
        this.f = zzageVar;
        if (this.g != null) {
            this.d.b("/unconfirmedClick", this.g);
        }
        this.g = new zzahv(this, zzageVar) { // from class: com.google.android.gms.internal.ads.rf
            private final zzcdd a;
            private final zzage b;

            {
                this.a = this;
                this.b = zzageVar;
            }

            @Override // com.google.android.gms.internal.ads.zzahv
            public final void a(Object obj, Map map) {
                zzcdd zzcddVar = this.a;
                zzage zzageVar2 = this.b;
                try {
                    zzcddVar.b = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
                } catch (NumberFormatException unused) {
                    zzd.c("Failed to call parse unconfirmedClickTimestamp.");
                }
                zzcddVar.a = (String) map.get("id");
                String str = (String) map.get("asset_id");
                if (zzageVar2 == null) {
                    zzd.b("Received unconfirmed click but UnconfirmedClickListener is null.");
                    return;
                }
                try {
                    zzageVar2.a(str);
                } catch (RemoteException e) {
                    zzaza.e("#007 Could not call remote method.", e);
                }
            }
        };
        this.d.a("/unconfirmedClick", this.g);
    }

    public final zzage a() {
        return this.f;
    }

    public final void b() {
        if (this.f == null || this.b == null) {
            return;
        }
        c();
        try {
            this.f.a();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.c == null || this.c.get() != view) {
            return;
        }
        if (this.a != null && this.b != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("id", this.a);
            hashMap.put("time_interval", String.valueOf(this.e.a() - this.b.longValue()));
            hashMap.put("messageType", "onePointFiveClick");
            this.d.a("sendMessageToNativeJs", hashMap);
        }
        c();
    }

    private final void c() {
        View view;
        this.a = null;
        this.b = null;
        if (this.c == null || (view = this.c.get()) == null) {
            return;
        }
        view.setClickable(false);
        view.setOnClickListener(null);
        this.c = null;
    }
}
