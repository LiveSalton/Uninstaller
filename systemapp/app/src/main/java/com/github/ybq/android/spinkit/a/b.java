package com.github.ybq.android.spinkit.a;

import android.util.Property;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class b<T> extends Property<T, Float> {
    public abstract void a(T t, float f);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* synthetic */ void set(Object obj, Float f) {
        a((b<T>) obj, f);
    }

    public b(String str) {
        super(Float.class, str);
    }

    public final void a(T t, Float f) {
        a((b<T>) t, f.floatValue());
    }
}
