package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.internal.ads.zzadu;
import com.google.android.gms.internal.ads.zzadw;

/* compiled from: source */
/* loaded from: classes.dex */
public class MediaView extends FrameLayout {
    private MediaContent a;
    private boolean b;
    private zzadu c;
    private ImageView.ScaleType d;
    private boolean e;
    private zzadw f;

    public MediaView(Context context) {
        super(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public MediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.b = true;
        this.a = mediaContent;
        if (this.c != null) {
            this.c.a(mediaContent);
        }
    }

    protected final synchronized void a(zzadu zzaduVar) {
        this.c = zzaduVar;
        if (this.b) {
            zzaduVar.a(this.a);
        }
    }

    public void setImageScaleType(ImageView.ScaleType scaleType) {
        this.e = true;
        this.d = scaleType;
        if (this.f != null) {
            this.f.a(this.d);
        }
    }

    protected final synchronized void a(zzadw zzadwVar) {
        this.f = zzadwVar;
        if (this.e) {
            zzadwVar.a(this.d);
        }
    }
}
