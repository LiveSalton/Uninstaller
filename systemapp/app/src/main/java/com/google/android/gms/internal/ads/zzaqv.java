package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaqv extends zzaqu implements zzahv<zzbdv> {
    private final zzbdv a;
    private final Context b;
    private final WindowManager c;
    private final zzaam d;
    private DisplayMetrics e;
    private float f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;

    public zzaqv(zzbdv zzbdvVar, Context context, zzaam zzaamVar) {
        super(zzbdvVar);
        this.g = -1;
        this.h = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.a = zzbdvVar;
        this.b = context;
        this.d = zzaamVar;
        this.c = (WindowManager) context.getSystemService("window");
    }

    public final void a(int i, int i2) {
        int i3 = 0;
        if (this.b instanceof Activity) {
            zzp.c();
            i3 = com.google.android.gms.ads.internal.util.zzm.c((Activity) this.b)[0];
        }
        if (this.a.x() == null || !this.a.x().e()) {
            int width = this.a.getWidth();
            int height = this.a.getHeight();
            if (((Boolean) zzwq.e().a(zzabf.I)).booleanValue()) {
                if (width == 0 && this.a.x() != null) {
                    width = this.a.x().b;
                }
                if (height == 0 && this.a.x() != null) {
                    height = this.a.x().a;
                }
            }
            this.l = zzwq.a().b(this.b, width);
            this.m = zzwq.a().b(this.b, height);
        }
        b(i, i2 - i3, this.l, this.m);
        this.a.z().a(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final /* synthetic */ void a(zzbdv zzbdvVar, Map map) {
        this.e = new DisplayMetrics();
        Display defaultDisplay = this.c.getDefaultDisplay();
        defaultDisplay.getMetrics(this.e);
        this.f = this.e.density;
        this.i = defaultDisplay.getRotation();
        zzwq.a();
        this.g = zzayr.b(this.e, this.e.widthPixels);
        zzwq.a();
        this.h = zzayr.b(this.e, this.e.heightPixels);
        Activity g = this.a.g();
        if (g == null || g.getWindow() == null) {
            this.j = this.g;
            this.k = this.h;
        } else {
            zzp.c();
            int[] a = com.google.android.gms.ads.internal.util.zzm.a(g);
            zzwq.a();
            this.j = zzayr.b(this.e, a[0]);
            zzwq.a();
            this.k = zzayr.b(this.e, a[1]);
        }
        if (this.a.x().e()) {
            this.l = this.g;
            this.m = this.h;
        } else {
            this.a.measure(0, 0);
        }
        a(this.g, this.h, this.j, this.k, this.f, this.i);
        this.a.b("onDeviceFeaturesReceived", new zzaqq(new zzaqs().b(this.d.a()).a(this.d.b()).c(this.d.d()).d(this.d.c()).e(true)).a());
        int[] iArr = new int[2];
        this.a.getLocationOnScreen(iArr);
        a(zzwq.a().b(this.b, iArr[0]), zzwq.a().b(this.b, iArr[1]));
        if (zzd.a(2)) {
            zzd.d("Dispatching Ready Event.");
        }
        b(this.a.m().a);
    }
}
