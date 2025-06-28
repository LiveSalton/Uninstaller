package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdat implements zzdfi<zzdar> {
    private final String a;
    private final zzdzc b;
    private final zzciq c;

    public zzdat(String str, zzdzc zzdzcVar, zzciq zzciqVar) {
        this.a = str;
        this.b = zzdzcVar;
        this.c = zzciqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdar> a() {
        if (new BigInteger(this.a).equals(BigInteger.ONE)) {
            if (!zzdwc.c((String) zzwq.e().a(zzabf.aJ))) {
                return this.b.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.acn
                    private final zzdat a;

                    {
                        this.a = this;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.a.b();
                    }
                });
            }
        }
        return zzdyr.a(new zzdar(new Bundle()));
    }

    private static Bundle a(zzdoe zzdoeVar) {
        Bundle bundle = new Bundle();
        try {
            if (zzdoeVar.n() != null) {
                bundle.putString("sdk_version", zzdoeVar.n().toString());
            }
        } catch (zzdnr unused) {
        }
        try {
            if (zzdoeVar.m() != null) {
                bundle.putString("adapter_version", zzdoeVar.m().toString());
            }
        } catch (zzdnr unused2) {
        }
        return bundle;
    }

    final /* synthetic */ zzdar b() throws Exception {
        List<String> asList = Arrays.asList(((String) zzwq.e().a(zzabf.aJ)).split(";"));
        Bundle bundle = new Bundle();
        for (String str : asList) {
            try {
                bundle.putBundle(str, a(this.c.a(str, new JSONObject())));
            } catch (zzdnr unused) {
            }
        }
        return new zzdar(bundle);
    }
}
