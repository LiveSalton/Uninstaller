package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

/* compiled from: source */
@Deprecated
/* loaded from: classes.dex */
public class NativeContentAdMapper extends NativeAdMapper {
    private String e;
    private List<NativeAd.Image> f;
    private String g;
    private NativeAd.Image h;
    private String i;
    private String j;

    public final void a(String str) {
        this.e = str;
    }

    public final void a(List<NativeAd.Image> list) {
        this.f = list;
    }

    public final void b(String str) {
        this.g = str;
    }

    public final void a(NativeAd.Image image) {
        this.h = image;
    }

    public final void c(String str) {
        this.i = str;
    }

    public final void d(String str) {
        this.j = str;
    }

    public final String i() {
        return this.e;
    }

    public final List<NativeAd.Image> j() {
        return this.f;
    }

    public final String k() {
        return this.g;
    }

    public final NativeAd.Image l() {
        return this.h;
    }

    public final String m() {
        return this.i;
    }

    public final String n() {
        return this.j;
    }
}
