package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzadt extends RelativeLayout {
    private static final float[] a = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private AnimationDrawable b;

    public zzadt(Context context, zzadq zzadqVar, RelativeLayout.LayoutParams layoutParams) {
        super(context);
        Preconditions.a(zzadqVar);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(a, null, null));
        shapeDrawable.getPaint().setColor(zzadqVar.d());
        setLayoutParams(layoutParams);
        zzp.e();
        setBackground(shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzadqVar.a())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzadqVar.a());
            textView.setTextColor(zzadqVar.e());
            textView.setTextSize(zzadqVar.f());
            zzwq.a();
            int a2 = zzayr.a(context, 4);
            zzwq.a();
            textView.setPadding(a2, 0, zzayr.a(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<zzadv> c = zzadqVar.c();
        if (c != null && c.size() > 1) {
            this.b = new AnimationDrawable();
            Iterator<zzadv> it = c.iterator();
            while (it.hasNext()) {
                try {
                    this.b.addFrame((Drawable) ObjectWrapper.a(it.next().a()), zzadqVar.g());
                } catch (Exception e) {
                    zzd.c("Error while getting drawable.", e);
                }
            }
            zzp.e();
            imageView.setBackground(this.b);
        } else if (c.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) ObjectWrapper.a(c.get(0).a()));
            } catch (Exception e2) {
                zzd.c("Error while getting drawable.", e2);
            }
        }
        addView(imageView);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        if (this.b != null) {
            this.b.start();
        }
        super.onAttachedToWindow();
    }
}
