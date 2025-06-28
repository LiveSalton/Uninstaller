package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaqq {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;

    /* JADX INFO: Access modifiers changed from: private */
    zzaqq(zzaqs zzaqsVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        z = zzaqsVar.a;
        this.a = z;
        z2 = zzaqsVar.b;
        this.b = z2;
        z3 = zzaqsVar.c;
        this.c = z3;
        z4 = zzaqsVar.d;
        this.d = z4;
        z5 = zzaqsVar.e;
        this.e = z5;
    }

    public final JSONObject a() {
        try {
            return new JSONObject().put("sms", this.a).put("tel", this.b).put("calendar", this.c).put("storePicture", this.d).put("inlineVideo", this.e);
        } catch (JSONException e) {
            zzd.c("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }

    /* synthetic */ zzaqq(zzaqs zzaqsVar, dq dqVar) {
        this(zzaqsVar);
    }
}
