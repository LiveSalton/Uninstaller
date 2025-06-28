package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public class UnifiedNativeAdMapper {
    private String a;
    private List<NativeAd.Image> b;
    private String c;
    private NativeAd.Image d;
    private String e;
    private String f;
    private Double g;
    private String h;
    private String i;
    private VideoController j;
    private boolean k;
    private View l;
    private View m;
    private Object n;
    private Bundle o = new Bundle();
    private boolean p;
    private boolean q;
    private float r;

    public void a(View view) {
    }

    public void a(View view, Map<String, View> map, Map<String, View> map2) {
    }

    public void b(View view) {
    }

    public float o() {
        return 0.0f;
    }

    public float p() {
        return 0.0f;
    }

    public void u() {
    }

    public final void a(String str) {
        this.a = str;
    }

    public final void a(List<NativeAd.Image> list) {
        this.b = list;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final void a(NativeAd.Image image) {
        this.d = image;
    }

    public final void c(String str) {
        this.e = str;
    }

    public final void d(String str) {
        this.f = str;
    }

    public final void a(Double d) {
        this.g = d;
    }

    public final void e(String str) {
        this.h = str;
    }

    public final void f(String str) {
        this.i = str;
    }

    public final void a(VideoController videoController) {
        this.j = videoController;
    }

    public final void a(Object obj) {
        this.n = obj;
    }

    public final void a(boolean z) {
        this.p = z;
    }

    public final void b(boolean z) {
        this.q = z;
    }

    public final String a() {
        return this.a;
    }

    public final List<NativeAd.Image> b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final NativeAd.Image d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public final String f() {
        return this.f;
    }

    public final Double g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public final String i() {
        return this.i;
    }

    public final VideoController j() {
        return this.j;
    }

    public boolean k() {
        return this.k;
    }

    public View l() {
        return this.l;
    }

    public final View m() {
        return this.m;
    }

    public float n() {
        return this.r;
    }

    public final Object q() {
        return this.n;
    }

    public final Bundle r() {
        return this.o;
    }

    public final boolean s() {
        return this.p;
    }

    public final boolean t() {
        return this.q;
    }
}
