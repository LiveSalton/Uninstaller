package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import java.util.Map;

/* compiled from: source */
@Deprecated
/* loaded from: classes.dex */
public class NativeAdMapper {
    protected boolean a;
    protected boolean b;
    protected Bundle c = new Bundle();
    protected View d;
    private View e;
    private VideoController f;
    private boolean g;

    @Deprecated
    public void a(View view) {
    }

    public void a(View view, Map<String, View> map, Map<String, View> map2) {
    }

    public void b(View view) {
    }

    public void c(View view) {
    }

    public void e() {
    }

    public final void a(boolean z) {
        this.a = z;
    }

    public final void b(boolean z) {
        this.b = z;
    }

    public final boolean a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public final Bundle c() {
        return this.c;
    }

    public View d() {
        return this.d;
    }

    public final View f() {
        return this.e;
    }

    public final void a(VideoController videoController) {
        this.f = videoController;
    }

    public final VideoController g() {
        return this.f;
    }

    public boolean h() {
        return this.g;
    }
}
