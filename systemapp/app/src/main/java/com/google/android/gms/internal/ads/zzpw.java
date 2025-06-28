package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

/* compiled from: source */
@TargetApi(17)
/* loaded from: classes.dex */
public final class zzpw extends Surface {
    private static boolean a;
    private static boolean b;
    private final boolean c;
    private final bbg d;
    private boolean e;

    public static synchronized boolean a(Context context) {
        boolean z;
        synchronized (zzpw.class) {
            if (!b) {
                if (zzpt.a >= 17) {
                    boolean z2 = false;
                    String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                    if (eglQueryString != null && eglQueryString.contains("EGL_EXT_protected_content")) {
                        if (!(zzpt.a == 24 && (zzpt.d.startsWith("SM-G950") || zzpt.d.startsWith("SM-G955")) && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"))) {
                            z2 = true;
                        }
                    }
                    a = z2;
                }
                b = true;
            }
            z = a;
        }
        return z;
    }

    public static zzpw a(Context context, boolean z) {
        if (zzpt.a < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
        zzpc.b(!z || a(context));
        return new bbg().a(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    zzpw(bbg bbgVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.d = bbgVar;
        this.c = z;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.d) {
            if (!this.e) {
                this.d.a();
                this.e = true;
            }
        }
    }

    /* synthetic */ zzpw(bbg bbgVar, SurfaceTexture surfaceTexture, boolean z, bbh bbhVar) {
        this(bbgVar, surfaceTexture, z);
    }
}
