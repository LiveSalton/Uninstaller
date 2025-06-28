package com.google.android.gms.internal.ads;

import android.util.Log;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeou extends zzeox {
    private String a;

    public zzeou(String str) {
        this.a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzeox
    public final void a(String str) {
        String str2 = this.a;
        StringBuilder sb = new StringBuilder(1 + String.valueOf(str2).length() + String.valueOf(str).length());
        sb.append(str2);
        sb.append(":");
        sb.append(str);
        Log.d("isoparser", sb.toString());
    }
}
