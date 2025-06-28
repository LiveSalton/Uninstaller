package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: source */
@TargetApi(14)
/* loaded from: classes.dex */
public final class zzbbc extends Thread implements SurfaceTexture.OnFrameAvailableListener, gq {
    private static final float[] a = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private volatile boolean A;
    private volatile boolean B;
    private final gp b;
    private final float[] c;
    private final float[] d;
    private final float[] e;
    private final float[] f;
    private final float[] g;
    private final float[] h;
    private final float[] i;
    private float j;
    private float k;
    private float l;
    private int m;
    private int n;
    private SurfaceTexture o;
    private SurfaceTexture p;
    private int q;
    private int r;
    private int s;
    private FloatBuffer t;
    private final CountDownLatch u;
    private final Object v;
    private EGL10 w;
    private EGLDisplay x;
    private EGLContext y;
    private EGLSurface z;

    public zzbbc(Context context) {
        super("SphericalVideoProcessor");
        this.t = ByteBuffer.allocateDirect(a.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.t.put(a).position(0);
        this.c = new float[9];
        this.d = new float[9];
        this.e = new float[9];
        this.f = new float[9];
        this.g = new float[9];
        this.h = new float[9];
        this.i = new float[9];
        this.j = Float.NaN;
        this.b = new gp(context);
        this.b.a(this);
        this.u = new CountDownLatch(1);
        this.v = new Object();
    }

    public final void a(SurfaceTexture surfaceTexture, int i, int i2) {
        this.n = i;
        this.m = i2;
        this.p = surfaceTexture;
    }

    public final void a(int i, int i2) {
        synchronized (this.v) {
            this.n = i;
            this.m = i2;
            this.A = true;
            this.v.notifyAll();
        }
    }

    public final void a() {
        synchronized (this.v) {
            this.B = true;
            this.p = null;
            this.v.notifyAll();
        }
    }

    public final SurfaceTexture b() {
        if (this.p == null) {
            return null;
        }
        try {
            this.u.await();
        } catch (InterruptedException unused) {
        }
        return this.o;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.s++;
        synchronized (this.v) {
            this.v.notifyAll();
        }
    }

    @Override // com.google.android.gms.internal.ads.gq
    public final void c() {
        synchronized (this.v) {
            this.v.notifyAll();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00c8  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1042
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbc.run():void");
    }

    public final void a(float f, float f2) {
        float f3;
        float f4;
        if (this.n > this.m) {
            f3 = (f * 1.7453293f) / this.n;
            f4 = (1.7453293f * f2) / this.n;
        } else {
            f3 = (f * 1.7453293f) / this.m;
            f4 = (1.7453293f * f2) / this.m;
        }
        this.k -= f3;
        this.l -= f4;
        if (this.l < -1.5707964f) {
            this.l = -1.5707964f;
        }
        if (this.l > 1.5707964f) {
            this.l = 1.5707964f;
        }
    }

    private static void a(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3]) + (fArr2[2] * fArr3[6]);
        fArr[1] = (fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4]) + (fArr2[2] * fArr3[7]);
        fArr[2] = (fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5]) + (fArr2[2] * fArr3[8]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3]) + (fArr2[5] * fArr3[6]);
        fArr[4] = (fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4]) + (fArr2[5] * fArr3[7]);
        fArr[5] = (fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5]) + (fArr2[5] * fArr3[8]);
        fArr[6] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3]) + (fArr2[8] * fArr3[6]);
        fArr[7] = (fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4]) + (fArr2[8] * fArr3[7]);
        fArr[8] = (fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5]) + (fArr2[8] * fArr3[8]);
    }

    private static void a(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d = f;
        fArr[4] = (float) Math.cos(d);
        fArr[5] = (float) (-Math.sin(d));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d);
        fArr[8] = (float) Math.cos(d);
    }

    private static void b(float[] fArr, float f) {
        double d = f;
        fArr[0] = (float) Math.cos(d);
        fArr[1] = (float) (-Math.sin(d));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d);
        fArr[4] = (float) Math.cos(d);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static int a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        a("createShader");
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        a("shaderSource");
        GLES20.glCompileShader(glCreateShader);
        a("compileShader");
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        a("getShaderiv");
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Could not compile shader ");
        sb.append(i);
        sb.append(":");
        Log.e("SphericalVideoRenderer", sb.toString());
        Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        a("deleteShader");
        return 0;
    }

    @VisibleForTesting
    private final boolean d() {
        boolean z = false;
        if (this.z != null && this.z != EGL10.EGL_NO_SURFACE) {
            z = this.w.eglDestroySurface(this.x, this.z) | this.w.eglMakeCurrent(this.x, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT) | false;
            this.z = null;
        }
        if (this.y != null) {
            z |= this.w.eglDestroyContext(this.x, this.y);
            this.y = null;
        }
        if (this.x == null) {
            return z;
        }
        boolean eglTerminate = z | this.w.eglTerminate(this.x);
        this.x = null;
        return eglTerminate;
    }

    private static void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            StringBuilder sb = new StringBuilder(21 + String.valueOf(str).length());
            sb.append(str);
            sb.append(": glError ");
            sb.append(glGetError);
            Log.e("SphericalVideoRenderer", sb.toString());
        }
    }
}
