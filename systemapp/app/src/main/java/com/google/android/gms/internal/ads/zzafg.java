package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzafg implements NativeCustomTemplateAd {
    private final zzaff a;
    private final MediaView b;
    private final VideoController c = new VideoController();

    @VisibleForTesting
    public zzafg(zzaff zzaffVar) {
        Context context;
        this.a = zzaffVar;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.a(zzaffVar.f());
        } catch (RemoteException | NullPointerException e) {
            zzaza.c("", e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (this.a.a(ObjectWrapper.a(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e2) {
                zzaza.c("", e2);
            }
        }
        this.b = mediaView;
    }

    public final zzaff b() {
        return this.a;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final String a() {
        try {
            return this.a.b();
        } catch (RemoteException e) {
            zzaza.c("", e);
            return null;
        }
    }
}
