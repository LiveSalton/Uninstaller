package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* compiled from: source */
/* loaded from: classes.dex */
class n<T> extends Property<T, Float> {
    private final Property<T, PointF> a;
    private final PathMeasure b;
    private final float c;
    private final float[] d;
    private final PointF e;
    private float f;

    n(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.d = new float[2];
        this.e = new PointF();
        this.a = property;
        this.b = new PathMeasure(path, false);
        this.c = this.b.getLength();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Float get(T t) {
        return Float.valueOf(this.f);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(T t, Float f) {
        this.f = f.floatValue();
        this.b.getPosTan(this.c * f.floatValue(), this.d, null);
        this.e.x = this.d[0];
        this.e.y = this.d[1];
        this.a.set(t, this.e);
    }
}
