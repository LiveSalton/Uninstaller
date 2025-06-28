package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
@TargetApi(21)
/* loaded from: classes.dex */
final class eh {
    private static final Map<String, String> a;
    private final Context b;
    private final List<String> c;
    private final zzawh d;

    eh(Context context, List<String> list, zzawh zzawhVar) {
        this.b = context;
        this.c = list;
        this.d = zzawhVar;
    }

    final List<String> a(String[] strArr) {
        boolean z;
        boolean z2;
        String valueOf;
        String valueOf2;
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Iterator<String> it = this.c.iterator();
            do {
                z = true;
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                String next = it.next();
                if (next.equals(str)) {
                    break;
                }
                valueOf = String.valueOf("android.webkit.resource.");
                valueOf2 = String.valueOf(next);
            } while (!(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).equals(str));
            z2 = true;
            if (z2) {
                if (a.containsKey(str)) {
                    zzp.c();
                    if (!com.google.android.gms.ads.internal.util.zzm.a(this.b, a.get(str))) {
                        z = false;
                    }
                }
                if (z) {
                    arrayList.add(str);
                } else {
                    this.d.c(str);
                }
            } else {
                this.d.b(str);
            }
        }
        return arrayList;
    }

    static {
        HashMap hashMap = new HashMap();
        if (PlatformVersion.g()) {
            hashMap.put("android.webkit.resource.AUDIO_CAPTURE", "android.permission.RECORD_AUDIO");
            hashMap.put("android.webkit.resource.VIDEO_CAPTURE", "android.permission.CAMERA");
        }
        a = hashMap;
    }
}
