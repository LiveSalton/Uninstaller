package com.jumobile.manager.systemapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import com.jumobile.manager.systemapp.R;
import com.jumobile.manager.systemapp.d.b;
import com.jumobile.manager.systemapp.service.DownloadEntry;
import com.jumobile.manager.systemapp.util.f;

/* compiled from: source */
/* loaded from: classes.dex */
public class CpaReceiver extends BroadcastReceiver {
    private static final String a = "CpaReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("extra_cpa_data");
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
        obtain.setDataPosition(0);
        b bVar = new b();
        bVar.a(obtain);
        if (f.a(context, bVar.d)) {
            f.h(context, bVar.d);
            return;
        }
        DownloadEntry a2 = bVar.a();
        if (a2.g == 4) {
            f.m(context, context.getString(R.string.download_service_state_downloaded, bVar.b));
            f.b(context, a2.b);
        }
    }
}
