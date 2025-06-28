package com.google.android.gms.ads.mediation.rtb;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class RtbSignalData {
    private final Context a;
    private final List<MediationConfiguration> b;
    private final Bundle c;
    private final AdSize d;

    public RtbSignalData(Context context, List<MediationConfiguration> list, Bundle bundle, AdSize adSize) {
        this.a = context;
        this.b = list;
        this.c = bundle;
        this.d = adSize;
    }
}
