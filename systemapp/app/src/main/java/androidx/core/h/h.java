package androidx.core.h;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;

/* compiled from: source */
/* loaded from: classes.dex */
public final class h {
    public static MenuItem a(MenuItem menuItem, b bVar) {
        if (menuItem instanceof androidx.core.a.a.b) {
            return ((androidx.core.a.a.b) menuItem).a(bVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof androidx.core.a.a.b) {
            ((androidx.core.a.a.b) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    public static void b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof androidx.core.a.a.b) {
            ((androidx.core.a.a.b) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }

    public static void a(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof androidx.core.a.a.b) {
            ((androidx.core.a.a.b) menuItem).setNumericShortcut(c, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c, i);
        }
    }

    public static void b(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof androidx.core.a.a.b) {
            ((androidx.core.a.a.b) menuItem).setAlphabeticShortcut(c, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c, i);
        }
    }

    public static void a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof androidx.core.a.a.b) {
            ((androidx.core.a.a.b) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    public static void a(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof androidx.core.a.a.b) {
            ((androidx.core.a.a.b) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }
}
