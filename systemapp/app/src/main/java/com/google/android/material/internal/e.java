package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: source */
/* loaded from: classes.dex */
public class e {
    private static Method a;
    private static boolean b;

    public static boolean a(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        return b(drawableContainer, constantState);
    }

    private static boolean b(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        if (!b) {
            try {
                a = DrawableContainer.class.getDeclaredMethod("setConstantState", DrawableContainer.DrawableContainerState.class);
                a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
            }
            b = true;
        }
        if (a != null) {
            try {
                a.invoke(drawableContainer, constantState);
                return true;
            } catch (Exception unused2) {
                Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
            }
        }
        return false;
    }
}
