package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzanj;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzwq;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public class OfflineNotificationPoster extends Worker {
    private final zzaqw b;

    public OfflineNotificationPoster(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.b = zzwq.b().a(context, new zzanj());
    }

    @Override // androidx.work.Worker
    public ListenableWorker.a doWork() {
        try {
            this.b.a(ObjectWrapper.a(getApplicationContext()), getInputData().a("uri"), getInputData().a("gws_query_id"));
            return ListenableWorker.a.a();
        } catch (RemoteException unused) {
            return ListenableWorker.a.c();
        }
    }
}
