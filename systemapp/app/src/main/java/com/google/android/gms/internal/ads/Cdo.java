package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* renamed from: com.google.android.gms.internal.ads.do */
/* loaded from: classes.dex */
final class Cdo implements DialogInterface.OnClickListener {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;
    private final /* synthetic */ zzaqp c;

    Cdo(zzaqp zzaqpVar, String str, String str2) {
        this.c = zzaqpVar;
        this.a = str;
        this.b = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        context = this.c.b;
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        try {
            String str = this.a;
            String str2 = this.b;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            zzp.e();
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.c.a("Could not store picture.");
        }
    }
}
