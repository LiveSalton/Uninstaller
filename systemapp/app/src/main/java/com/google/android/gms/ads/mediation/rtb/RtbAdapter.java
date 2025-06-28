package com.google.android.gms.ads.mediation.rtb;

import com.google.android.gms.ads.mediation.Adapter;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class RtbAdapter extends Adapter {
    public abstract void collectSignals(RtbSignalData rtbSignalData, SignalCallbacks signalCallbacks);
}
