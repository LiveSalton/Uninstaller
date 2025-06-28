package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzaaq<T> {
    private final int a;
    private final String b;
    private final T c;

    private zzaaq(int i, String str, T t) {
        this.a = i;
        this.b = str;
        this.c = t;
        zzwq.d().a(this);
    }

    protected abstract T a(SharedPreferences sharedPreferences);

    public abstract T a(Bundle bundle);

    protected abstract T a(JSONObject jSONObject);

    public abstract void a(SharedPreferences.Editor editor, T t);

    public final String a() {
        return this.b;
    }

    public final T b() {
        return this.c;
    }

    public static zzaaq<Boolean> a(int i, String str, Boolean bool) {
        return new f(i, str, bool);
    }

    public static zzaaq<Integer> a(int i, String str, int i2) {
        return new e(1, str, Integer.valueOf(i2));
    }

    public static zzaaq<Long> a(int i, String str, long j) {
        return new h(1, str, Long.valueOf(j));
    }

    public static zzaaq<Float> a(int i, String str, float f) {
        return new g(1, str, Float.valueOf(0.0f));
    }

    public static zzaaq<String> a(int i, String str, String str2) {
        return new i(1, str, str2);
    }

    public static zzaaq<String> a(int i, String str) {
        zzaaq<String> a = a(1, str, (String) null);
        zzwq.d().c(a);
        return a;
    }

    public final int c() {
        return this.a;
    }

    /* synthetic */ zzaaq(int i, String str, Object obj, f fVar) {
        this(i, str, obj);
    }
}
