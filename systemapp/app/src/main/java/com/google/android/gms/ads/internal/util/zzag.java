package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzwq;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzag {
    private final Context a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private int g;
    private PointF h;
    private PointF i;
    private Handler j;
    private Runnable k;

    public zzag(Context context) {
        this.f = 0;
        this.k = new Runnable(this) { // from class: com.google.android.gms.ads.internal.util.b
            private final zzag a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.d();
            }
        };
        this.a = context;
        this.g = ViewConfiguration.get(context).getScaledTouchSlop();
        zzp.q().a();
        this.j = zzp.q().b();
    }

    public zzag(Context context, String str) {
        this(context);
        this.b = str;
    }

    public final void a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.f = 0;
            this.h = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        if (this.f == -1) {
            return;
        }
        boolean z = true;
        if (this.f == 0 && actionMasked == 5) {
            this.f = 5;
            this.i = new PointF(motionEvent.getX(1), motionEvent.getY(1));
            this.j.postDelayed(this.k, ((Long) zzwq.e().a(zzabf.ci)).longValue());
            return;
        }
        if (this.f == 5) {
            if (pointerCount == 2) {
                if (actionMasked == 2) {
                    boolean z2 = false;
                    for (int i = 0; i < historySize; i++) {
                        if (!a(motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i), motionEvent.getHistoricalX(1, i), motionEvent.getHistoricalY(1, i))) {
                            z2 = true;
                        }
                    }
                    if (a(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1))) {
                        z = z2;
                    }
                } else {
                    z = false;
                }
            }
            if (z) {
                this.f = -1;
                this.j.removeCallbacks(this.k);
            }
        }
    }

    private final boolean a(float f, float f2, float f3, float f4) {
        return Math.abs(this.h.x - f) < ((float) this.g) && Math.abs(this.h.y - f2) < ((float) this.g) && Math.abs(this.i.x - f3) < ((float) this.g) && Math.abs(this.i.y - f4) < ((float) this.g);
    }

    public final void a() {
        try {
            if (!(this.a instanceof Activity)) {
                zzd.d("Can not create dialog without Activity Context");
                return;
            }
            String str = !TextUtils.isEmpty(zzp.m().a()) ? "Creative Preview (Enabled)" : "Creative Preview";
            String str2 = zzp.m().b() ? "Troubleshooting (Enabled)" : "Troubleshooting";
            ArrayList arrayList = new ArrayList();
            int a = a((List<String>) arrayList, "Ad Information", true);
            int a2 = a((List<String>) arrayList, str, true);
            int a3 = a((List<String>) arrayList, str2, true);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a, zzp.e().a());
            builder.setTitle("Select a Debug Mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener(this, a, a2, a3) { // from class: com.google.android.gms.ads.internal.util.d
                private final zzag a;
                private final int b;
                private final int c;
                private final int d;

                {
                    this.a = this;
                    this.b = a;
                    this.c = a2;
                    this.d = a3;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.a.a(this.b, this.c, this.d, dialogInterface, i);
                }
            });
            builder.create().show();
        } catch (WindowManager.BadTokenException e) {
            zzd.a("", e);
        }
    }

    public final void a(String str) {
        this.c = str;
    }

    public final void b(String str) {
        this.d = str;
    }

    public final void c(String str) {
        this.b = str;
    }

    public final void d(String str) {
        this.e = str;
    }

    private static int a(List<String> list, String str, boolean z) {
        list.add(str);
        return list.size() - 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.b);
        sb.append(",DebugSignal: ");
        sb.append(this.e);
        sb.append(",AFMA Version: ");
        sb.append(this.d);
        sb.append(",Ad Unit ID: ");
        sb.append(this.c);
        sb.append("}");
        return sb.toString();
    }

    final /* synthetic */ void b() {
        zzp.m().a(this.a, this.c, this.d, this.e);
    }

    final /* synthetic */ void c() {
        zzp.m().a(this.a, this.c, this.d);
    }

    final /* synthetic */ void a(String str, DialogInterface dialogInterface, int i) {
        zzp.c();
        zzm.a(this.a, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006e, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) == false) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ void a(int r1, int r2, int r3, android.content.DialogInterface r4, int r5) {
        /*
            r0 = this;
            if (r5 != r1) goto L9b
            android.content.Context r1 = r0.a
            boolean r1 = r1 instanceof android.app.Activity
            if (r1 != 0) goto Le
            java.lang.String r1 = "Can not create dialog without Activity Context"
            com.google.android.gms.ads.internal.util.zzd.d(r1)
            return
        Le:
            java.lang.String r1 = r0.b
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L71
            java.lang.String r2 = "\\+"
            java.lang.String r3 = "%20"
            java.lang.String r1 = r1.replaceAll(r2, r3)
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            android.net.Uri$Builder r1 = r2.encodedQuery(r1)
            android.net.Uri r1 = r1.build()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.google.android.gms.ads.internal.zzp.c()
            java.util.Map r1 = com.google.android.gms.ads.internal.util.zzm.b(r1)
            java.util.Set r3 = r1.keySet()
            java.util.Iterator r3 = r3.iterator()
        L3f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L62
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r5 = " = "
            r2.append(r5)
            java.lang.Object r4 = r1.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r4 = "\n\n"
            r2.append(r4)
            goto L3f
        L62:
            java.lang.String r1 = r2.toString()
            java.lang.String r1 = r1.trim()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L71
            goto L73
        L71:
            java.lang.String r1 = "No debug information"
        L73:
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            android.content.Context r3 = r0.a
            r2.<init>(r3)
            r2.setMessage(r1)
            java.lang.String r3 = "Ad Information"
            r2.setTitle(r3)
            java.lang.String r3 = "Share"
            com.google.android.gms.ads.internal.util.c r4 = new com.google.android.gms.ads.internal.util.c
            r4.<init>(r0, r1)
            r2.setPositiveButton(r3, r4)
            java.lang.String r1 = "Close"
            android.content.DialogInterface$OnClickListener r3 = com.google.android.gms.ads.internal.util.f.a
            r2.setNegativeButton(r1, r3)
            android.app.AlertDialog r1 = r2.create()
            r1.show()
            return
        L9b:
            if (r5 != r2) goto Lad
            java.lang.String r1 = "Debug mode [Creative Preview] selected."
            com.google.android.gms.ads.internal.util.zzd.b(r1)
            com.google.android.gms.internal.ads.zzdzc r1 = com.google.android.gms.internal.ads.zzazj.a
            com.google.android.gms.ads.internal.util.e r2 = new com.google.android.gms.ads.internal.util.e
            r2.<init>(r0)
            r1.execute(r2)
            return
        Lad:
            if (r5 != r3) goto Lbe
            java.lang.String r1 = "Debug mode [Troubleshooting] selected."
            com.google.android.gms.ads.internal.util.zzd.b(r1)
            com.google.android.gms.internal.ads.zzdzc r1 = com.google.android.gms.internal.ads.zzazj.a
            com.google.android.gms.ads.internal.util.g r2 = new com.google.android.gms.ads.internal.util.g
            r2.<init>(r0)
            r1.execute(r2)
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzag.a(int, int, int, android.content.DialogInterface, int):void");
    }

    final /* synthetic */ void d() {
        this.f = 4;
        a();
    }
}
