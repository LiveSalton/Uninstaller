package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbns extends FrameLayout implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private final Context a;
    private View b;

    public static zzbns a(Context context, View view, zzdmu zzdmuVar) {
        zzbns zzbnsVar = new zzbns(context);
        zzbnsVar.b = view;
        zzbnsVar.addView(view);
        zzp.z();
        zzazy.a((View) zzbnsVar, (ViewTreeObserver.OnScrollChangedListener) zzbnsVar);
        zzp.z();
        zzazy.a((View) zzbnsVar, (ViewTreeObserver.OnGlobalLayoutListener) zzbnsVar);
        JSONObject jSONObject = zzdmuVar.ad;
        if (jSONObject != null) {
            RelativeLayout relativeLayout = new RelativeLayout(zzbnsVar.a);
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            if (optJSONObject != null) {
                zzbnsVar.a(optJSONObject, relativeLayout, 10);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("footer");
            if (optJSONObject2 != null) {
                zzbnsVar.a(optJSONObject2, relativeLayout, 12);
            }
            zzbnsVar.addView(relativeLayout);
        }
        return zzbnsVar;
    }

    private zzbns(Context context) {
        super(context);
        this.a = context;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        getLocationInWindow(new int[2]);
        this.b.setY(-r0[1]);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        getLocationInWindow(new int[2]);
        this.b.setY(-r0[1]);
    }

    private final void a(JSONObject jSONObject, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(this.a);
        textView.setTextColor(-1);
        textView.setBackgroundColor(-16777216);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int a = a(jSONObject.optDouble("padding", 0.0d));
        textView.setPadding(0, a, 0, a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, a(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i);
        relativeLayout.addView(textView, layoutParams);
    }

    private final int a(double d) {
        zzwq.a();
        return zzayr.a(this.a, (int) d);
    }
}
