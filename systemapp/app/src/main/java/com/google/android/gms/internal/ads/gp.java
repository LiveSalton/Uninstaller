package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzd;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
final class gp implements SensorEventListener {
    private final SensorManager a;
    private final Display c;

    @GuardedBy("sensorThreadLock")
    private float[] f;
    private Handler g;
    private gq h;
    private final float[] d = new float[9];
    private final float[] e = new float[9];
    private final Object b = new Object();

    gp(Context context) {
        this.a = (SensorManager) context.getSystemService("sensor");
        this.c = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    final void a() {
        if (this.g != null) {
            return;
        }
        Sensor defaultSensor = this.a.getDefaultSensor(11);
        if (defaultSensor == null) {
            zzd.c("No Sensor of TYPE_ROTATION_VECTOR");
            return;
        }
        HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
        handlerThread.start();
        this.g = new zzduw(handlerThread.getLooper());
        if (this.a.registerListener(this, defaultSensor, 0, this.g)) {
            return;
        }
        zzd.c("SensorManager.registerListener failed.");
        b();
    }

    final void b() {
        if (this.g == null) {
            return;
        }
        this.a.unregisterListener(this);
        this.g.post(new go(this));
        this.g = null;
    }

    final void a(gq gqVar) {
        this.h = gqVar;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] == 0.0f && fArr[1] == 0.0f && fArr[2] == 0.0f) {
            return;
        }
        synchronized (this.b) {
            if (this.f == null) {
                this.f = new float[9];
            }
        }
        SensorManager.getRotationMatrixFromVector(this.d, fArr);
        switch (this.c.getRotation()) {
            case 1:
                SensorManager.remapCoordinateSystem(this.d, 2, 129, this.e);
                break;
            case 2:
                SensorManager.remapCoordinateSystem(this.d, 129, 130, this.e);
                break;
            case 3:
                SensorManager.remapCoordinateSystem(this.d, 130, 1, this.e);
                break;
            default:
                System.arraycopy(this.d, 0, this.e, 0, 9);
                break;
        }
        a(1, 3);
        a(2, 6);
        a(5, 7);
        synchronized (this.b) {
            System.arraycopy(this.e, 0, this.f, 0, 9);
        }
        if (this.h != null) {
            this.h.c();
        }
    }

    final boolean a(float[] fArr) {
        synchronized (this.b) {
            if (this.f == null) {
                return false;
            }
            System.arraycopy(this.f, 0, fArr, 0, this.f.length);
            return true;
        }
    }

    private final void a(int i, int i2) {
        float f = this.e[i];
        this.e[i] = this.e[i2];
        this.e[i2] = f;
    }
}
