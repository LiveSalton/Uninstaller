package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdbm implements zzdfi<zzdbn> {
    private final zzdzc a;
    private final Context b;

    public zzdbm(zzdzc zzdzcVar, Context context) {
        this.a = zzdzcVar;
        this.b = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdbn> a() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.acw
            private final zzdbm a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.b();
            }
        });
    }

    final /* synthetic */ zzdbn b() throws Exception {
        AudioManager audioManager = (AudioManager) this.b.getSystemService("audio");
        return new zzdbn(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzp.h().a(), zzp.h().b());
    }
}
