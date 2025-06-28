package com.google.android.material.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

/* compiled from: source */
/* loaded from: classes.dex */
public class a {
    public static ColorStateList a(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList a;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (a = androidx.appcompat.a.a.a.a(context, resourceId)) == null) ? typedArray.getColorStateList(i) : a;
    }

    public static Drawable b(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable b;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (b = androidx.appcompat.a.a.a.b(context, resourceId)) == null) ? typedArray.getDrawable(i) : b;
    }

    public static b c(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return new b(context, resourceId);
    }

    static int a(TypedArray typedArray, int i, int i2) {
        return typedArray.hasValue(i) ? i : i2;
    }
}
