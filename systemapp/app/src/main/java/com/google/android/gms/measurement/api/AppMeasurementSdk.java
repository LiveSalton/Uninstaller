package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.measurement.internal.zzgx;
import com.google.android.gms.measurement.internal.zzha;
import java.util.List;
import java.util.Map;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public class AppMeasurementSdk {
    private final zzx a;

    /* compiled from: source */
    @KeepForSdk
    public static final class ConditionalUserProperty {
        private ConditionalUserProperty() {
        }
    }

    /* compiled from: source */
    @ShowFirstParty
    @KeepForSdk
    public interface EventInterceptor extends zzgx {
    }

    /* compiled from: source */
    @ShowFirstParty
    @KeepForSdk
    public interface OnEventListener extends zzha {
    }

    @KeepForSdk
    public static AppMeasurementSdk a(Context context, String str, String str2, String str3, Bundle bundle) {
        return zzx.a(context, str, str2, str3, bundle).a();
    }

    public AppMeasurementSdk(zzx zzxVar) {
        this.a = zzxVar;
    }

    @KeepForSdk
    public void a(String str, String str2, Bundle bundle) {
        this.a.a(str, str2, bundle);
    }

    @KeepForSdk
    public void a(String str, String str2, Object obj) {
        this.a.a(str, str2, obj);
    }

    @KeepForSdk
    public Map<String, Object> a(String str, String str2, boolean z) {
        return this.a.a(str, str2, z);
    }

    @KeepForSdk
    public void a(Bundle bundle) {
        this.a.a(bundle);
    }

    @KeepForSdk
    public void b(String str, String str2, Bundle bundle) {
        this.a.b(str, str2, bundle);
    }

    @KeepForSdk
    public List<Bundle> a(String str, String str2) {
        return this.a.a(str, str2);
    }

    @KeepForSdk
    public String a() {
        return this.a.e();
    }

    @KeepForSdk
    public String b() {
        return this.a.f();
    }

    @KeepForSdk
    public String c() {
        return this.a.c();
    }

    @KeepForSdk
    public String d() {
        return this.a.b();
    }

    @KeepForSdk
    public long e() {
        return this.a.d();
    }

    @KeepForSdk
    public void a(String str) {
        this.a.a(str);
    }

    @KeepForSdk
    public void b(String str) {
        this.a.b(str);
    }

    @KeepForSdk
    public Bundle b(Bundle bundle) {
        return this.a.a(bundle, true);
    }

    @KeepForSdk
    public void c(Bundle bundle) {
        this.a.a(bundle, false);
    }

    @KeepForSdk
    public int c(String str) {
        return this.a.c(str);
    }

    @KeepForSdk
    public void a(Activity activity, String str, String str2) {
        this.a.a(activity, str, str2);
    }

    @KeepForSdk
    public String f() {
        return this.a.g();
    }
}
