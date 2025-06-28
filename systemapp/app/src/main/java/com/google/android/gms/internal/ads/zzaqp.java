package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaqp extends zzaqu {
    private final Map<String, String> a;
    private final Context b;

    public zzaqp(zzbdv zzbdvVar, Map<String, String> map) {
        super(zzbdvVar, "storePicture");
        this.a = map;
        this.b = zzbdvVar.g();
    }

    public final void a() {
        if (this.b == null) {
            a("Activity context is not available");
            return;
        }
        zzp.c();
        if (!com.google.android.gms.ads.internal.util.zzm.e(this.b).c()) {
            a("Feature is not supported by the device.");
            return;
        }
        String str = this.a.get("iurl");
        if (TextUtils.isEmpty(str)) {
            a("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            String valueOf = String.valueOf(str);
            a(valueOf.length() != 0 ? "Invalid image url: ".concat(valueOf) : new String("Invalid image url: "));
            return;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        zzp.c();
        if (!com.google.android.gms.ads.internal.util.zzm.b(lastPathSegment)) {
            String valueOf2 = String.valueOf(lastPathSegment);
            a(valueOf2.length() != 0 ? "Image type not recognized: ".concat(valueOf2) : new String("Image type not recognized: "));
            return;
        }
        Resources d = zzp.g().d();
        zzp.c();
        AlertDialog.Builder d2 = com.google.android.gms.ads.internal.util.zzm.d(this.b);
        d2.setTitle(d != null ? d.getString(R.string.s1) : "Save image");
        d2.setMessage(d != null ? d.getString(R.string.s2) : "Allow Ad to store image in Picture gallery?");
        d2.setPositiveButton(d != null ? d.getString(R.string.s3) : "Accept", new Cdo(this, str, lastPathSegment));
        d2.setNegativeButton(d != null ? d.getString(R.string.s4) : "Decline", new dp(this));
        d2.create().show();
    }
}
