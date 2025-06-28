package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbct implements zzahv<zzbbe> {
    @Override // com.google.android.gms.internal.ads.zzahv
    public final /* synthetic */ void a(zzbbe zzbbeVar, Map map) {
        zzbbe zzbbeVar2 = zzbbeVar;
        zzbep d = zzbbeVar2.d();
        if (d == null) {
            try {
                zzbep zzbepVar = new zzbep(zzbbeVar2, Float.parseFloat((String) map.get("duration")), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                zzbbeVar2.a(zzbepVar);
                d = zzbepVar;
            } catch (NullPointerException | NumberFormatException e) {
                zzd.c("Unable to parse videoMeta message.", e);
                zzp.g().a(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float parseFloat = Float.parseFloat((String) map.get("duration"));
        boolean equals = "1".equals(map.get("muted"));
        float parseFloat2 = Float.parseFloat((String) map.get("currentTime"));
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        if (parseInt < 0 || 3 < parseInt) {
            parseInt = 0;
        }
        String str = (String) map.get("aspectRatio");
        float parseFloat3 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
        if (zzd.a(3)) {
            StringBuilder sb = new StringBuilder(140 + String.valueOf(str).length());
            sb.append("Video Meta GMSG: currentTime : ");
            sb.append(parseFloat2);
            sb.append(" , duration : ");
            sb.append(parseFloat);
            sb.append(" , isMuted : ");
            sb.append(equals);
            sb.append(" , playbackState : ");
            sb.append(parseInt);
            sb.append(" , aspectRatio : ");
            sb.append(str);
            zzd.b(sb.toString());
        }
        d.a(parseFloat2, parseFloat, parseInt, equals, parseFloat3);
    }
}
