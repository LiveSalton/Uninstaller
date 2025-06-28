package com.google.android.gms.ads.internal.overlay;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzwq;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzr extends FrameLayout implements View.OnClickListener {
    private final ImageButton a;
    private final zzz b;

    public zzr(Context context, zzq zzqVar, zzz zzzVar) {
        super(context);
        this.b = zzzVar;
        setOnClickListener(this);
        this.a = new ImageButton(context);
        this.a.setImageResource(R.drawable.btn_dialog);
        this.a.setBackgroundColor(0);
        this.a.setOnClickListener(this);
        ImageButton imageButton = this.a;
        zzwq.a();
        int a = zzayr.a(context, zzqVar.a);
        zzwq.a();
        int a2 = zzayr.a(context, 0);
        zzwq.a();
        int a3 = zzayr.a(context, zzqVar.b);
        zzwq.a();
        imageButton.setPadding(a, a2, a3, zzayr.a(context, zzqVar.d));
        this.a.setContentDescription("Interstitial close button");
        ImageButton imageButton2 = this.a;
        zzwq.a();
        int a4 = zzayr.a(context, zzqVar.e + zzqVar.a + zzqVar.b);
        zzwq.a();
        addView(imageButton2, new FrameLayout.LayoutParams(a4, zzayr.a(context, zzqVar.e + zzqVar.d), 17));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.b != null) {
            this.b.j_();
        }
    }

    public final void a(boolean z) {
        if (z) {
            this.a.setVisibility(8);
        } else {
            this.a.setVisibility(0);
        }
    }
}
