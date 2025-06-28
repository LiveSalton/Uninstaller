package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzeox {
    public abstract void a(String str);

    public static zzeox a(Class cls) {
        return System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik") ? new zzeou(cls.getSimpleName()) : new zzeow(cls.getSimpleName());
    }
}
