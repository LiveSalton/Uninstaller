package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/* compiled from: source */
/* loaded from: classes.dex */
final class bbg extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {
    private final int[] a;
    private Handler b;
    private SurfaceTexture c;
    private Error d;
    private RuntimeException e;
    private zzpw f;

    public bbg() {
        super("dummySurface");
        this.a = new int[1];
    }

    public final zzpw a(boolean z) {
        boolean z2;
        start();
        this.b = new Handler(getLooper(), this);
        synchronized (this) {
            z2 = false;
            this.b.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
            while (this.f == null && this.e == null && this.d == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        if (this.e != null) {
            throw this.e;
        }
        if (this.d != null) {
            throw this.d;
        }
        return this.f;
    }

    public final void a() {
        this.b.sendEmptyMessage(3);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.b.sendEmptyMessage(2);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int[] iArr;
        int[] iArr2;
        try {
            try {
            } catch (Throwable th) {
                Log.e("DummySurface", "Failed to release dummy surface", th);
            } finally {
                quit();
            }
            switch (message.what) {
                case 1:
                    try {
                        try {
                            boolean z = message.arg1 != 0;
                            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                            zzpc.b(eglGetDisplay != null, "eglGetDisplay failed");
                            int[] iArr3 = new int[2];
                            zzpc.b(EGL14.eglInitialize(eglGetDisplay, iArr3, 0, iArr3, 1), "eglInitialize failed");
                            EGLConfig[] eGLConfigArr = new EGLConfig[1];
                            int[] iArr4 = new int[1];
                            zzpc.b(EGL14.eglChooseConfig(eglGetDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr4, 0) && iArr4[0] > 0 && eGLConfigArr[0] != null, "eglChooseConfig failed");
                            EGLConfig eGLConfig = eGLConfigArr[0];
                            if (z) {
                                iArr = new int[]{12440, 2, 12992, 1, 12344};
                            } else {
                                iArr = new int[]{12440, 2, 12344};
                            }
                            EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
                            zzpc.b(eglCreateContext != null, "eglCreateContext failed");
                            if (z) {
                                iArr2 = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
                            } else {
                                iArr2 = new int[]{12375, 1, 12374, 1, 12344};
                            }
                            EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, iArr2, 0);
                            zzpc.b(eglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
                            zzpc.b(EGL14.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext), "eglMakeCurrent failed");
                            GLES20.glGenTextures(1, this.a, 0);
                            this.c = new SurfaceTexture(this.a[0]);
                            this.c.setOnFrameAvailableListener(this);
                            this.f = new zzpw(this, this.c, z);
                            synchronized (this) {
                                notify();
                            }
                        } catch (RuntimeException e) {
                            Log.e("DummySurface", "Failed to initialize dummy surface", e);
                            this.e = e;
                            synchronized (this) {
                                notify();
                            }
                        }
                    } catch (Error e2) {
                        Log.e("DummySurface", "Failed to initialize dummy surface", e2);
                        this.d = e2;
                        synchronized (this) {
                            notify();
                        }
                    }
                    return true;
                case 2:
                    this.c.updateTexImage();
                    return true;
                case 3:
                    try {
                        this.c.release();
                        return true;
                    } finally {
                        this.f = null;
                        this.c = null;
                        GLES20.glDeleteTextures(1, this.a, 0);
                    }
                default:
                    return true;
            }
        } catch (Throwable th2) {
            synchronized (this) {
                notify();
                throw th2;
            }
        }
    }
}
