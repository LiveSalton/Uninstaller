package com.google.android.gms.ads;

import android.app.IntentService;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzanj;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzwq;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public class AdService extends IntentService {
    public AdService() {
        super("AdService");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        try {
            zzwq.b().a(this, new zzanj()).a(intent);
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(50 + String.valueOf(valueOf).length());
            sb.append("RemoteException calling handleNotificationIntent: ");
            sb.append(valueOf);
            zzaza.c(sb.toString());
        }
    }
}
