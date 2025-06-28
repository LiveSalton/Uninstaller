package com.jumobile.manager.systemapp.d;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class c {
    static long j = 1;
    public String f;
    public String g;
    public long h;
    public boolean i;
    public final long k;

    public abstract Drawable b(Context context);

    public c() {
        long j2 = j;
        j = 1 + j2;
        this.k = j2;
    }
}
