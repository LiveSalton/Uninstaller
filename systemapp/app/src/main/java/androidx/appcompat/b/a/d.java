package androidx.appcompat.b.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.b.a.b;
import androidx.appcompat.c.a;
import androidx.appcompat.widget.v;
import androidx.core.content.a.g;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: source */
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
class d extends b {
    private a a;
    private boolean b;

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    d() {
        this(null, null);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int b = this.a.b(iArr);
        if (b < 0) {
            b = this.a.b(StateSet.WILD_CARD);
        }
        return a(b) || onStateChange;
    }

    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray a2 = g.a(resources, theme, attributeSet, a.b.StateListDrawable);
        setVisible(a2.getBoolean(a.b.StateListDrawable_android_visible, true), true);
        a(a2);
        a(resources);
        a2.recycle();
        a(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    private void a(TypedArray typedArray) {
        a aVar = this.a;
        if (Build.VERSION.SDK_INT >= 21) {
            aVar.f |= typedArray.getChangingConfigurations();
        }
        aVar.k = typedArray.getBoolean(a.b.StateListDrawable_android_variablePadding, aVar.k);
        aVar.n = typedArray.getBoolean(a.b.StateListDrawable_android_constantSize, aVar.n);
        aVar.C = typedArray.getInt(a.b.StateListDrawable_android_enterFadeDuration, aVar.C);
        aVar.D = typedArray.getInt(a.b.StateListDrawable_android_exitFadeDuration, aVar.D);
        aVar.z = typedArray.getBoolean(a.b.StateListDrawable_android_dither, aVar.z);
    }

    private void a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        a aVar = this.a;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next2 == 3) {
                return;
            }
            if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray a2 = g.a(resources, theme, attributeSet, a.b.StateListDrawableItem);
                int resourceId = a2.getResourceId(a.b.StateListDrawableItem_android_drawable, -1);
                Drawable a3 = resourceId > 0 ? v.a().a(context, resourceId) : null;
                a2.recycle();
                int[] a4 = a(attributeSet);
                if (a3 == null) {
                    do {
                        next = xmlPullParser.next();
                    } while (next == 4);
                    if (next != 2) {
                        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                    } else {
                        a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                    }
                }
                aVar.a(a4, a3);
            }
        }
    }

    int[] a(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.b && super.mutate() == this) {
            this.a.a();
            this.b = true;
        }
        return this;
    }

    @Override // androidx.appcompat.b.a.b
    /* renamed from: b */
    public a c() {
        return new a(this.a, this, null);
    }

    /* compiled from: source */
    static class a extends b.AbstractC0006b {
        int[][] L;

        a(a aVar, d dVar, Resources resources) {
            super(aVar, dVar, resources);
            if (aVar != null) {
                this.L = aVar.L;
            } else {
                this.L = new int[c()][];
            }
        }

        @Override // androidx.appcompat.b.a.b.AbstractC0006b
        void a() {
            int[][] iArr = new int[this.L.length][];
            for (int length = this.L.length - 1; length >= 0; length--) {
                iArr[length] = this.L[length] != null ? (int[]) this.L[length].clone() : null;
            }
            this.L = iArr;
        }

        int a(int[] iArr, Drawable drawable) {
            int a = a(drawable);
            this.L[a] = iArr;
            return a;
        }

        int b(int[] iArr) {
            int[][] iArr2 = this.L;
            int d = d();
            for (int i = 0; i < d; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new d(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }

        @Override // androidx.appcompat.b.a.b.AbstractC0006b
        public void e(int i, int i2) {
            super.e(i, i2);
            int[][] iArr = new int[i2][];
            System.arraycopy(this.L, 0, iArr, 0, i);
            this.L = iArr;
        }
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.b.a.b
    void a(b.AbstractC0006b abstractC0006b) {
        super.a(abstractC0006b);
        if (abstractC0006b instanceof a) {
            this.a = (a) abstractC0006b;
        }
    }

    d(a aVar, Resources resources) {
        a(new a(aVar, this, resources));
        onStateChange(getState());
    }

    d(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }
}
