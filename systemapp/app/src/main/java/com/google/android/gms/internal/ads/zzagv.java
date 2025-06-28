package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzagv extends zzafw {
    private final OnPublisherAdViewLoadedListener a;

    @Override // com.google.android.gms.internal.ads.zzafx
    public final void a(zzxg zzxgVar, IObjectWrapper iObjectWrapper) {
        if (zzxgVar == null || iObjectWrapper == null) {
            return;
        }
        PublisherAdView publisherAdView = new PublisherAdView((Context) ObjectWrapper.a(iObjectWrapper));
        try {
            if (zzxgVar.p() instanceof zzvg) {
                zzvg zzvgVar = (zzvg) zzxgVar.p();
                publisherAdView.setAdListener(zzvgVar != null ? zzvgVar.g() : null);
            }
        } catch (RemoteException e) {
            zzaza.c("", e);
        }
        try {
            if (zzxgVar.o() instanceof zzvt) {
                zzvt zzvtVar = (zzvt) zzxgVar.o();
                publisherAdView.setAppEventListener(zzvtVar != null ? zzvtVar.a() : null);
            }
        } catch (RemoteException e2) {
            zzaza.c("", e2);
        }
        zzayr.a.post(new aa(this, publisherAdView, zzxgVar));
    }
}
