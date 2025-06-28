package com.github.ybq.android.spinkit.a;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Log;
import android.util.Property;
import android.view.animation.Interpolator;
import com.github.ybq.android.spinkit.b.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public class d {
    private f a;
    private Interpolator b;
    private int c = -1;
    private long d = 2000;
    private int e = 0;
    private Map<String, b> f = new HashMap();

    /* compiled from: source */
    class b<T> {
        float[] b;
        Property c;
        T[] d;

        public b(float[] fArr, Property property, T[] tArr) {
            this.b = fArr;
            this.c = property;
            this.d = tArr;
        }
    }

    /* compiled from: source */
    class c extends b<Integer> {
        public c(float[] fArr, Property property, Integer[] numArr) {
            super(fArr, property, numArr);
        }
    }

    /* compiled from: source */
    class a extends b<Float> {
        public a(float[] fArr, Property property, Float[] fArr2) {
            super(fArr, property, fArr2);
        }
    }

    public d(f fVar) {
        this.a = fVar;
    }

    public d a(float[] fArr, Float... fArr2) {
        a(fArr, f.k, fArr2);
        return this;
    }

    public d a(float[] fArr, Integer... numArr) {
        a(fArr, f.l, numArr);
        return this;
    }

    public d b(float[] fArr, Float... fArr2) {
        a(fArr, f.j, fArr2);
        return this;
    }

    public d b(float[] fArr, Integer... numArr) {
        a(fArr, f.b, numArr);
        return this;
    }

    public d c(float[] fArr, Integer... numArr) {
        a(fArr, f.d, numArr);
        return this;
    }

    public d d(float[] fArr, Integer... numArr) {
        a(fArr, f.c, numArr);
        return this;
    }

    public d c(float[] fArr, Float... fArr2) {
        a(fArr, f.g, fArr2);
        return this;
    }

    public d d(float[] fArr, Float... fArr2) {
        a(fArr, f.h, fArr2);
        return this;
    }

    private void a(float[] fArr, Property property, Float[] fArr2) {
        a(fArr.length, fArr2.length);
        this.f.put(property.getName(), new a(fArr, property, fArr2));
    }

    private void a(float[] fArr, Property property, Integer[] numArr) {
        a(fArr.length, numArr.length);
        this.f.put(property.getName(), new c(fArr, property, numArr));
    }

    private void a(int i, int i2) {
        if (i != i2) {
            throw new IllegalStateException(String.format(Locale.getDefault(), "The fractions.length must equal values.length, fraction.length[%d], values.length[%d]", Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public d a(Interpolator interpolator) {
        this.b = interpolator;
        return this;
    }

    public d a(float... fArr) {
        a(com.github.ybq.android.spinkit.a.a.b.a(fArr));
        return this;
    }

    public d a(long j) {
        this.d = j;
        return this;
    }

    public d a(int i) {
        if (i < 0) {
            Log.w("SpriteAnimatorBuilder", "startFrame should always be non-negative");
            i = 0;
        }
        this.e = i;
        return this;
    }

    public ObjectAnimator a() {
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[this.f.size()];
        Iterator<Map.Entry<String, b>> it = this.f.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            b value = it.next().getValue();
            Keyframe[] keyframeArr = new Keyframe[value.b.length];
            float[] fArr = value.b;
            float f = fArr[this.e];
            for (int i2 = this.e; i2 < this.e + value.d.length; i2++) {
                int i3 = i2 - this.e;
                int length = i2 % value.d.length;
                float f2 = fArr[length] - f;
                if (f2 < 0.0f) {
                    f2 += fArr[fArr.length - 1];
                }
                if (value instanceof c) {
                    keyframeArr[i3] = Keyframe.ofInt(f2, ((Integer) value.d[length]).intValue());
                } else if (value instanceof a) {
                    keyframeArr[i3] = Keyframe.ofFloat(f2, ((Float) value.d[length]).floatValue());
                } else {
                    keyframeArr[i3] = Keyframe.ofObject(f2, value.d[length]);
                }
            }
            propertyValuesHolderArr[i] = PropertyValuesHolder.ofKeyframe(value.c, keyframeArr);
            i++;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.a, propertyValuesHolderArr);
        ofPropertyValuesHolder.setDuration(this.d);
        ofPropertyValuesHolder.setRepeatCount(this.c);
        ofPropertyValuesHolder.setInterpolator(this.b);
        return ofPropertyValuesHolder;
    }
}
