package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;

/* compiled from: source */
@TargetApi(14)
/* loaded from: classes.dex */
public final class zzbbj implements AudioManager.OnAudioFocusChangeListener {
    private final AudioManager a;
    private final gs b;
    private boolean c;
    private boolean d;
    private boolean e;
    private float f = 1.0f;

    public zzbbj(Context context, gs gsVar) {
        this.a = (AudioManager) context.getSystemService("audio");
        this.b = gsVar;
    }

    public final void a(boolean z) {
        this.e = z;
        d();
    }

    public final void a(float f) {
        this.f = f;
        d();
    }

    public final float a() {
        float f = this.e ? 0.0f : this.f;
        if (this.c) {
            return f;
        }
        return 0.0f;
    }

    public final void b() {
        this.d = true;
        d();
    }

    public final void c() {
        this.d = false;
        d();
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        this.c = i > 0;
        this.b.h();
    }

    private final void d() {
        boolean z = this.d && !this.e && this.f > 0.0f;
        if (z && !this.c) {
            if (this.a != null && !this.c) {
                this.c = this.a.requestAudioFocus(this, 3, 2) == 1;
            }
            this.b.h();
            return;
        }
        if (z || !this.c) {
            return;
        }
        if (this.a != null && this.c) {
            this.c = this.a.abandonAudioFocus(this) == 0;
        }
        this.b.h();
    }
}
