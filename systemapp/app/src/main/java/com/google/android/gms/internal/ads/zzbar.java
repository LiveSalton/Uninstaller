package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbar extends FrameLayout implements zzbam {
    private final zzbbe a;
    private final FrameLayout b;
    private final zzabs c;
    private final gr d;
    private final long e;
    private zzbap f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private long k;
    private long l;
    private String m;
    private String[] n;
    private Bitmap o;
    private ImageView p;
    private boolean q;

    public static void a(zzbbe zzbbeVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        zzbbeVar.a("onVideoEvent", hashMap);
    }

    public static void a(zzbbe zzbbeVar, Map<String, List<Map<String, Object>>> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("mimeTypes", map);
        zzbbeVar.a("onVideoEvent", hashMap);
    }

    public static void a(zzbbe zzbbeVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("error", str);
        zzbbeVar.a("onVideoEvent", hashMap);
    }

    public zzbar(Context context, zzbbe zzbbeVar, int i, boolean z, zzabs zzabsVar, zzbbf zzbbfVar) {
        super(context);
        this.a = zzbbeVar;
        this.c = zzabsVar;
        this.b = new FrameLayout(context);
        if (((Boolean) zzwq.e().a(zzabf.C)).booleanValue()) {
            this.b.setBackgroundResource(R.color.black);
        }
        addView(this.b, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.a(zzbbeVar.h());
        this.f = zzbbeVar.h().b.a(context, zzbbeVar, i, z, zzabsVar, zzbbfVar);
        if (this.f != null) {
            this.b.addView(this.f, new FrameLayout.LayoutParams(-1, -1, 17));
            if (((Boolean) zzwq.e().a(zzabf.t)).booleanValue()) {
                m();
            }
        }
        this.p = new ImageView(context);
        this.e = ((Long) zzwq.e().a(zzabf.x)).longValue();
        this.j = ((Boolean) zzwq.e().a(zzabf.v)).booleanValue();
        if (this.c != null) {
            this.c.a("spinner_used", this.j ? "1" : "0");
        }
        this.d = new gr(this);
        if (this.f != null) {
            this.f.a(this);
        }
        if (this.f == null) {
            a("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        if (i3 == 0 || i4 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        this.b.setLayoutParams(layoutParams);
        requestLayout();
    }

    public final void a(String str, String[] strArr) {
        this.m = str;
        this.n = strArr;
    }

    public final void a(float f, float f2) {
        if (this.f != null) {
            this.f.a(f, f2);
        }
    }

    public final void h() {
        if (this.f == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.m)) {
            this.f.a(this.m, this.n);
        } else {
            b("no_src", new String[0]);
        }
    }

    public final void i() {
        if (this.f == null) {
            return;
        }
        this.f.d();
    }

    public final void j() {
        if (this.f == null) {
            return;
        }
        this.f.c();
    }

    public final void a(int i) {
        if (this.f == null) {
            return;
        }
        this.f.a(i);
    }

    public final void k() {
        if (this.f == null) {
            return;
        }
        zzbap zzbapVar = this.f;
        zzbapVar.b.a(true);
        zzbapVar.h();
    }

    public final void l() {
        if (this.f == null) {
            return;
        }
        zzbap zzbapVar = this.f;
        zzbapVar.b.a(false);
        zzbapVar.h();
    }

    public final void setVolume(float f) {
        if (this.f == null) {
            return;
        }
        zzbap zzbapVar = this.f;
        zzbapVar.b.a(f);
        zzbapVar.h();
    }

    public final void b(int i) {
        this.f.c(i);
    }

    public final void c(int i) {
        this.f.d(i);
    }

    public final void d(int i) {
        this.f.e(i);
    }

    public final void e(int i) {
        this.f.f(i);
    }

    public final void f(int i) {
        this.f.g(i);
    }

    @TargetApi(14)
    public final void a(MotionEvent motionEvent) {
        if (this.f == null) {
            return;
        }
        this.f.dispatchTouchEvent(motionEvent);
    }

    @TargetApi(14)
    public final void m() {
        if (this.f == null) {
            return;
        }
        TextView textView = new TextView(this.f.getContext());
        String valueOf = String.valueOf(this.f.a());
        textView.setText(valueOf.length() != 0 ? "AdMob - ".concat(valueOf) : new String("AdMob - "));
        textView.setTextColor(-65536);
        textView.setBackgroundColor(-256);
        this.b.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        this.b.bringChildToFront(textView);
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final void a() {
        this.d.b();
        com.google.android.gms.ads.internal.util.zzm.a.post(new gj(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final void b() {
        if (this.f != null && this.l == 0) {
            b("canplaythrough", "duration", String.valueOf(this.f.getDuration() / 1000.0f), "videoWidth", String.valueOf(this.f.getVideoWidth()), "videoHeight", String.valueOf(this.f.getVideoHeight()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final void c() {
        if (this.a.g() != null && !this.h) {
            this.i = (this.a.g().getWindow().getAttributes().flags & 128) != 0;
            if (!this.i) {
                this.a.g().getWindow().addFlags(128);
                this.h = true;
            }
        }
        this.g = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final void d() {
        b("pause", new String[0]);
        q();
        this.g = false;
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final void e() {
        b("ended", new String[0]);
        q();
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final void a(String str, String str2) {
        b("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final void f() {
        if (this.q && this.o != null && !p()) {
            this.p.setImageBitmap(this.o);
            this.p.invalidate();
            this.b.addView(this.p, new FrameLayout.LayoutParams(-1, -1));
            this.b.bringChildToFront(this.p);
        }
        this.d.a();
        this.l = this.k;
        com.google.android.gms.ads.internal.util.zzm.a.post(new gm(this));
    }

    public final void n() {
        this.d.a();
        if (this.f != null) {
            this.f.b();
        }
        q();
    }

    public final void finalize() throws Throwable {
        try {
            this.d.a();
            if (this.f != null) {
                zzbap zzbapVar = this.f;
                zzdzc zzdzcVar = zzazj.e;
                zzbapVar.getClass();
                zzdzcVar.execute(gi.a(zzbapVar));
            }
        } finally {
            super.finalize();
        }
    }

    final void o() {
        if (this.f == null) {
            return;
        }
        long currentPosition = this.f.getCurrentPosition();
        if (this.k == currentPosition || currentPosition <= 0) {
            return;
        }
        float f = currentPosition / 1000.0f;
        if (((Boolean) zzwq.e().a(zzabf.aW)).booleanValue()) {
            b("timeupdate", "time", String.valueOf(f), "totalBytes", String.valueOf(this.f.getTotalBytes()), "qoeCachedBytes", String.valueOf(this.f.f()), "qoeLoadedBytes", String.valueOf(this.f.e()), "droppedFrames", String.valueOf(this.f.g()), "reportTime", String.valueOf(zzp.j().a()));
        } else {
            b("timeupdate", "time", String.valueOf(f));
        }
        this.k = currentPosition;
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final void g() {
        if (this.g && p()) {
            this.b.removeView(this.p);
        }
        if (this.o != null) {
            long b = zzp.j().b();
            if (this.f.getBitmap(this.o) != null) {
                this.q = true;
            }
            long b2 = zzp.j().b() - b;
            if (zzd.a()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(b2);
                sb.append("ms");
                zzd.a(sb.toString());
            }
            if (b2 > this.e) {
                zzd.e("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.j = false;
                this.o = null;
                if (this.c != null) {
                    this.c.a("spinner_jank", Long.toString(b2));
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final void a(int i, int i2) {
        if (this.j) {
            int max = Math.max(i / ((Integer) zzwq.e().a(zzabf.w)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzwq.e().a(zzabf.w)).intValue(), 1);
            if (this.o != null && this.o.getWidth() == max && this.o.getHeight() == max2) {
                return;
            }
            this.o = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
            this.q = false;
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.d.b();
        } else {
            this.d.a();
            this.l = this.k;
        }
        com.google.android.gms.ads.internal.util.zzm.a.post(new Runnable(this, z) { // from class: com.google.android.gms.internal.ads.gk
            private final zzbar a;
            private final boolean b;

            {
                this.a = this;
                this.b = z;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(this.b);
            }
        });
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbam
    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.d.b();
            z = true;
        } else {
            this.d.a();
            this.l = this.k;
            z = false;
        }
        com.google.android.gms.ads.internal.util.zzm.a.post(new gl(this, z));
    }

    private final boolean p() {
        return this.p.getParent() != null;
    }

    public final void b(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.a.a("onVideoEvent", hashMap);
    }

    private final void q() {
        if (this.a.g() == null || !this.h || this.i) {
            return;
        }
        this.a.g().getWindow().clearFlags(128);
        this.h = false;
    }

    final /* synthetic */ void a(boolean z) {
        b("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }
}
