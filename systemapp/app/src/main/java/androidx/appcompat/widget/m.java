package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: source */
/* loaded from: classes.dex */
class m {
    private static final RectF a = new RectF();
    private static ConcurrentHashMap<String, Method> b = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Field> c = new ConcurrentHashMap<>();
    private int d = 0;
    private boolean e = false;
    private float f = -1.0f;
    private float g = -1.0f;
    private float h = -1.0f;
    private int[] i = new int[0];
    private boolean j = false;
    private TextPaint k;
    private final TextView l;
    private final Context m;
    private final a n;

    /* compiled from: source */
    private static class a {
        void a(StaticLayout.Builder builder, TextView textView) {
        }

        a() {
        }

        boolean a(TextView textView) {
            return ((Boolean) m.a(textView, "getHorizontallyScrolling", false)).booleanValue();
        }
    }

    /* compiled from: source */
    private static class b extends a {
        b() {
        }

        @Override // androidx.appcompat.widget.m.a
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) m.a(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* compiled from: source */
    private static class c extends b {
        c() {
        }

        @Override // androidx.appcompat.widget.m.a
        boolean a(TextView textView) {
            return textView.isHorizontallyScrollable();
        }

        @Override // androidx.appcompat.widget.m.b, androidx.appcompat.widget.m.a
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }
    }

    m(TextView textView) {
        this.l = textView;
        this.m = this.l.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.n = new c();
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.n = new b();
        } else {
            this.n = new a();
        }
    }

    void a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.m.obtainStyledAttributes(attributeSet, a.j.AppCompatTextView, i, 0);
        androidx.core.h.w.a(this.l, this.l.getContext(), a.j.AppCompatTextView, attributeSet, obtainStyledAttributes, i, 0);
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTextView_autoSizeTextType)) {
            this.d = obtainStyledAttributes.getInt(a.j.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(a.j.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(a.j.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(a.j.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(a.j.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(a.j.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(a.j.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTextView_autoSizePresetSizes) && (resourceId = obtainStyledAttributes.getResourceId(a.j.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            a(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (k()) {
            if (this.d == 1) {
                if (!this.j) {
                    DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
                    if (dimension2 == -1.0f) {
                        dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    if (dimension3 == -1.0f) {
                        dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    if (dimension == -1.0f) {
                        dimension = 1.0f;
                    }
                    a(dimension2, dimension3, dimension);
                }
                i();
                return;
            }
            return;
        }
        this.d = 0;
    }

    void a(int i) {
        if (k()) {
            switch (i) {
                case 0:
                    j();
                    return;
                case 1:
                    DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
                    a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (i()) {
                        f();
                        return;
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown auto-size text type: " + i);
            }
        }
    }

    void a(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (k()) {
            DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
            a(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (i()) {
                f();
            }
        }
    }

    void a(int[] iArr, int i) throws IllegalArgumentException {
        if (k()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                this.i = a(iArr2);
                if (!h()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.j = false;
            }
            if (i()) {
                f();
            }
        }
    }

    int a() {
        return this.d;
    }

    int b() {
        return Math.round(this.f);
    }

    int c() {
        return Math.round(this.g);
    }

    int d() {
        return Math.round(this.h);
    }

    int[] e() {
        return this.i;
    }

    private void a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.i = a(iArr);
            h();
        }
    }

    private boolean h() {
        this.j = this.i.length > 0;
        if (this.j) {
            this.d = 1;
            this.g = this.i[0];
            this.h = this.i[r0 - 1];
            this.f = -1.0f;
        }
        return this.j;
    }

    private int[] a(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    private void a(float f, float f2, float f3) throws IllegalArgumentException {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        }
        if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        }
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        }
        this.d = 1;
        this.g = f;
        this.h = f2;
        this.f = f3;
        this.j = false;
    }

    private boolean i() {
        if (k() && this.d == 1) {
            if (!this.j || this.i.length == 0) {
                int floor = ((int) Math.floor((this.h - this.g) / this.f)) + 1;
                int[] iArr = new int[floor];
                for (int i = 0; i < floor; i++) {
                    iArr[i] = Math.round(this.g + (i * this.f));
                }
                this.i = a(iArr);
            }
            this.e = true;
        } else {
            this.e = false;
        }
        return this.e;
    }

    void f() {
        if (g()) {
            if (this.e) {
                if (this.l.getMeasuredHeight() <= 0 || this.l.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.n.a(this.l) ? 1048576 : (this.l.getMeasuredWidth() - this.l.getTotalPaddingLeft()) - this.l.getTotalPaddingRight();
                int height = (this.l.getHeight() - this.l.getCompoundPaddingBottom()) - this.l.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                synchronized (a) {
                    a.setEmpty();
                    a.right = measuredWidth;
                    a.bottom = height;
                    float a2 = a(a);
                    if (a2 != this.l.getTextSize()) {
                        a(0, a2);
                    }
                }
            }
            this.e = true;
        }
    }

    private void j() {
        this.d = 0;
        this.g = -1.0f;
        this.h = -1.0f;
        this.f = -1.0f;
        this.i = new int[0];
        this.e = false;
    }

    void a(int i, float f) {
        Resources resources;
        if (this.m == null) {
            resources = Resources.getSystem();
        } else {
            resources = this.m.getResources();
        }
        a(TypedValue.applyDimension(i, f, resources.getDisplayMetrics()));
    }

    private void a(float f) {
        if (f != this.l.getPaint().getTextSize()) {
            this.l.getPaint().setTextSize(f);
            boolean isInLayout = Build.VERSION.SDK_INT >= 18 ? this.l.isInLayout() : false;
            if (this.l.getLayout() != null) {
                this.e = false;
                try {
                    Method a2 = a("nullLayouts");
                    if (a2 != null) {
                        a2.invoke(this.l, new Object[0]);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (!isInLayout) {
                    this.l.requestLayout();
                } else {
                    this.l.forceLayout();
                }
                this.l.invalidate();
            }
        }
    }

    private int a(RectF rectF) {
        int i;
        int length = this.i.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i2 = 0;
        int i3 = 1;
        int i4 = length - 1;
        while (true) {
            int i5 = i3;
            int i6 = i2;
            i2 = i5;
            while (i2 <= i4) {
                i = (i2 + i4) / 2;
                if (a(this.i[i], rectF)) {
                    break;
                }
                i6 = i - 1;
                i4 = i6;
            }
            return this.i[i6];
            i3 = i + 1;
        }
    }

    void b(int i) {
        if (this.k == null) {
            this.k = new TextPaint();
        } else {
            this.k.reset();
        }
        this.k.set(this.l.getPaint());
        this.k.setTextSize(i);
    }

    StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b(charSequence, alignment, i, i2);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return a(charSequence, alignment, i);
        }
        return b(charSequence, alignment, i);
    }

    private boolean a(int i, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.l.getText();
        TransformationMethod transformationMethod = this.l.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.l)) != null) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.l.getMaxLines() : -1;
        b(i);
        StaticLayout a2 = a(text, (Layout.Alignment) a(this.l, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (a2.getLineCount() <= maxLines && a2.getLineEnd(a2.getLineCount() - 1) == text.length())) && ((float) a2.getHeight()) <= rectF.bottom;
    }

    private StaticLayout b(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.k, i);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(this.l.getLineSpacingExtra(), this.l.getLineSpacingMultiplier()).setIncludePad(this.l.getIncludeFontPadding()).setBreakStrategy(this.l.getBreakStrategy()).setHyphenationFrequency(this.l.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i2);
        try {
            this.n.a(obtain, this.l);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return obtain.build();
    }

    private StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i) {
        return new StaticLayout(charSequence, this.k, i, alignment, this.l.getLineSpacingMultiplier(), this.l.getLineSpacingExtra(), this.l.getIncludeFontPadding());
    }

    private StaticLayout b(CharSequence charSequence, Layout.Alignment alignment, int i) {
        return new StaticLayout(charSequence, this.k, i, alignment, ((Float) b(this.l, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) b(this.l, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) b(this.l, "mIncludePad", true)).booleanValue());
    }

    static <T> T a(Object obj, String str, T t) {
        try {
            return (T) a(str).invoke(obj, new Object[0]);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return t;
        }
    }

    private static <T> T b(Object obj, String str, T t) {
        try {
            Field b2 = b(str);
            return b2 == null ? t : (T) b2.get(obj);
        } catch (IllegalAccessException e) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e);
            return t;
        }
    }

    private static Method a(String str) {
        try {
            Method method = b.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                b.put(str, method);
            }
            return method;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    private static Field b(String str) {
        try {
            Field field = c.get(str);
            if (field == null && (field = TextView.class.getDeclaredField(str)) != null) {
                field.setAccessible(true);
                c.put(str, field);
            }
            return field;
        } catch (NoSuchFieldException e) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e);
            return null;
        }
    }

    boolean g() {
        return k() && this.d != 0;
    }

    private boolean k() {
        return !(this.l instanceof AppCompatEditText);
    }
}
