package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

/* compiled from: source */
/* loaded from: classes.dex */
class o {
    static PropertyValuesHolder a(Property<?, PointF> property, Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return PropertyValuesHolder.ofObject(property, (TypeConverter) null, path);
        }
        return PropertyValuesHolder.ofFloat(new n(property, path), 0.0f, 1.0f);
    }
}
