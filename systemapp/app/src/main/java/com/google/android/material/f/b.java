package com.google.android.material.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.core.content.a.f;
import com.google.android.material.a;

/* compiled from: source */
/* loaded from: classes.dex */
public class b {
    public final float a;
    public final ColorStateList b;
    public final ColorStateList c;
    public final ColorStateList d;
    public final int e;
    public final int f;
    public final String g;
    public final boolean h;
    public final ColorStateList i;
    public final float j;
    public final float k;
    public final float l;
    private final int m;
    private boolean n = false;
    private Typeface o;

    public b(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, a.k.TextAppearance);
        this.a = obtainStyledAttributes.getDimension(a.k.TextAppearance_android_textSize, 0.0f);
        this.b = a.a(context, obtainStyledAttributes, a.k.TextAppearance_android_textColor);
        this.c = a.a(context, obtainStyledAttributes, a.k.TextAppearance_android_textColorHint);
        this.d = a.a(context, obtainStyledAttributes, a.k.TextAppearance_android_textColorLink);
        this.e = obtainStyledAttributes.getInt(a.k.TextAppearance_android_textStyle, 0);
        this.f = obtainStyledAttributes.getInt(a.k.TextAppearance_android_typeface, 1);
        int a = a.a(obtainStyledAttributes, a.k.TextAppearance_fontFamily, a.k.TextAppearance_android_fontFamily);
        this.m = obtainStyledAttributes.getResourceId(a, 0);
        this.g = obtainStyledAttributes.getString(a);
        this.h = obtainStyledAttributes.getBoolean(a.k.TextAppearance_textAllCaps, false);
        this.i = a.a(context, obtainStyledAttributes, a.k.TextAppearance_android_shadowColor);
        this.j = obtainStyledAttributes.getFloat(a.k.TextAppearance_android_shadowDx, 0.0f);
        this.k = obtainStyledAttributes.getFloat(a.k.TextAppearance_android_shadowDy, 0.0f);
        this.l = obtainStyledAttributes.getFloat(a.k.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public Typeface a(Context context) {
        if (this.n) {
            return this.o;
        }
        if (!context.isRestricted()) {
            try {
                this.o = f.a(context, this.m);
                if (this.o != null) {
                    this.o = Typeface.create(this.o, this.e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e) {
                Log.d("TextAppearance", "Error loading font " + this.g, e);
            }
        }
        a();
        this.n = true;
        return this.o;
    }

    public void a(Context context, TextPaint textPaint, f.a aVar) {
        if (this.n) {
            a(textPaint, this.o);
            return;
        }
        a();
        if (context.isRestricted()) {
            this.n = true;
            a(textPaint, this.o);
            return;
        }
        try {
            f.a(context, this.m, new f.a() { // from class: com.google.android.material.f.b.1
                final /* synthetic */ TextPaint a;
                final /* synthetic */ f.a b;

                AnonymousClass1(TextPaint textPaint2, f.a aVar2) {
                    textPaint = textPaint2;
                    aVar = aVar2;
                }

                @Override // androidx.core.content.a.f.a
                public void a(Typeface typeface) {
                    b.this.o = Typeface.create(typeface, b.this.e);
                    b.this.a(textPaint, typeface);
                    b.this.n = true;
                    aVar.a(typeface);
                }

                @Override // androidx.core.content.a.f.a
                public void a(int i) {
                    b.this.a();
                    b.this.n = true;
                    aVar.a(i);
                }
            }, null);
        } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
        } catch (Exception e) {
            Log.d("TextAppearance", "Error loading font " + this.g, e);
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.f.b$1 */
    class AnonymousClass1 extends f.a {
        final /* synthetic */ TextPaint a;
        final /* synthetic */ f.a b;

        AnonymousClass1(TextPaint textPaint2, f.a aVar2) {
            textPaint = textPaint2;
            aVar = aVar2;
        }

        @Override // androidx.core.content.a.f.a
        public void a(Typeface typeface) {
            b.this.o = Typeface.create(typeface, b.this.e);
            b.this.a(textPaint, typeface);
            b.this.n = true;
            aVar.a(typeface);
        }

        @Override // androidx.core.content.a.f.a
        public void a(int i) {
            b.this.a();
            b.this.n = true;
            aVar.a(i);
        }
    }

    public void a() {
        if (this.o == null) {
            this.o = Typeface.create(this.g, this.e);
        }
        if (this.o == null) {
            switch (this.f) {
                case 1:
                    this.o = Typeface.SANS_SERIF;
                    break;
                case 2:
                    this.o = Typeface.SERIF;
                    break;
                case 3:
                    this.o = Typeface.MONOSPACE;
                    break;
                default:
                    this.o = Typeface.DEFAULT;
                    break;
            }
            if (this.o != null) {
                this.o = Typeface.create(this.o, this.e);
            }
        }
    }

    public void b(Context context, TextPaint textPaint, f.a aVar) {
        c(context, textPaint, aVar);
        textPaint.setColor(this.b != null ? this.b.getColorForState(textPaint.drawableState, this.b.getDefaultColor()) : -16777216);
        textPaint.setShadowLayer(this.l, this.j, this.k, this.i != null ? this.i.getColorForState(textPaint.drawableState, this.i.getDefaultColor()) : 0);
    }

    public void c(Context context, TextPaint textPaint, f.a aVar) {
        if (c.a()) {
            a(textPaint, a(context));
            return;
        }
        a(context, textPaint, aVar);
        if (this.n) {
            return;
        }
        a(textPaint, this.o);
    }

    public void a(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i = (~typeface.getStyle()) & this.e;
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.a);
    }
}
