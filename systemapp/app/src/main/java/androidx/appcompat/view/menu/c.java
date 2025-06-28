package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class c {
    final Context a;
    private androidx.b.g<androidx.core.a.a.b, MenuItem> b;
    private androidx.b.g<androidx.core.a.a.c, SubMenu> c;

    c(Context context) {
        this.a = context;
    }

    final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof androidx.core.a.a.b)) {
            return menuItem;
        }
        androidx.core.a.a.b bVar = (androidx.core.a.a.b) menuItem;
        if (this.b == null) {
            this.b = new androidx.b.g<>();
        }
        MenuItem menuItem2 = this.b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        j jVar = new j(this.a, bVar);
        this.b.put(bVar, jVar);
        return jVar;
    }

    final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof androidx.core.a.a.c)) {
            return subMenu;
        }
        androidx.core.a.a.c cVar = (androidx.core.a.a.c) subMenu;
        if (this.c == null) {
            this.c = new androidx.b.g<>();
        }
        SubMenu subMenu2 = this.c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        s sVar = new s(this.a, cVar);
        this.c.put(cVar, sVar);
        return sVar;
    }

    final void a() {
        if (this.b != null) {
            this.b.clear();
        }
        if (this.c != null) {
            this.c.clear();
        }
    }

    final void a(int i) {
        if (this.b == null) {
            return;
        }
        int i2 = 0;
        while (i2 < this.b.size()) {
            if (this.b.b(i2).getGroupId() == i) {
                this.b.d(i2);
                i2--;
            }
            i2++;
        }
    }

    final void b(int i) {
        if (this.b == null) {
            return;
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            if (this.b.b(i2).getItemId() == i) {
                this.b.d(i2);
                return;
            }
        }
    }
}
