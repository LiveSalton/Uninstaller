package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;

/* compiled from: source */
/* loaded from: classes.dex */
public final class a extends g {
    public a(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.view.menu.g, android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
    }

    @Override // androidx.appcompat.view.menu.g
    protected MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        if (size() + 1 > 5) {
            throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
        }
        h();
        MenuItem a = super.a(i, i2, i3, charSequence);
        if (a instanceof i) {
            ((i) a).a(true);
        }
        i();
        return a;
    }
}
