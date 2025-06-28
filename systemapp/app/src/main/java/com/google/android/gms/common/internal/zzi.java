package com.google.android.gms.common.internal;

import android.net.Uri;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzi {
    private static final Uri a;
    private static final Uri b;

    static {
        Uri parse = Uri.parse("https://plus.google.com/");
        a = parse;
        b = parse.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
