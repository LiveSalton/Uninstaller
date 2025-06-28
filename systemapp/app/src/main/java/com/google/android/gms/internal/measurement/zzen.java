package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Logger;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzen extends zzdv {
    private static final Logger a = Logger.getLogger(zzen.class.getName());
    private static final boolean b = co.a();

    /* compiled from: source */
    public static class zza extends IOException {
        zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private zzen() {
    }
}
