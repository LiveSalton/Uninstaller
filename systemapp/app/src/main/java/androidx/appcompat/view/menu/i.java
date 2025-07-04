package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.n;
import androidx.core.h.b;

/* compiled from: source */
/* loaded from: classes.dex */
public final class i implements androidx.core.a.a.b {
    private View A;
    private androidx.core.h.b B;
    private MenuItem.OnActionExpandListener C;
    private ContextMenu.ContextMenuInfo E;
    g a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private CharSequence f;
    private CharSequence g;
    private Intent h;
    private char i;
    private char k;
    private Drawable m;
    private r o;
    private Runnable p;
    private MenuItem.OnMenuItemClickListener q;
    private CharSequence r;
    private CharSequence s;
    private int z;
    private int j = 4096;
    private int l = 4096;
    private int n = 0;
    private ColorStateList t = null;
    private PorterDuff.Mode u = null;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private int y = 16;
    private boolean D = false;

    i(g gVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.z = 0;
        this.a = gVar;
        this.b = i2;
        this.c = i;
        this.d = i3;
        this.e = i4;
        this.f = charSequence;
        this.z = i5;
    }

    public boolean b() {
        if ((this.q != null && this.q.onMenuItemClick(this)) || this.a.a(this.a, this)) {
            return true;
        }
        if (this.p != null) {
            this.p.run();
            return true;
        }
        if (this.h != null) {
            try {
                this.a.f().startActivity(this.h);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        return this.B != null && this.B.b();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.y |= 16;
        } else {
            this.y &= -17;
        }
        this.a.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.c;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.b;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.h;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.h = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.k == c) {
            return this;
        }
        this.k = Character.toLowerCase(c);
        this.a.b(false);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.k == c && this.l == i) {
            return this;
        }
        this.k = Character.toLowerCase(c);
        this.l = KeyEvent.normalizeMetaState(i);
        this.a.b(false);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.l;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.i;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.j;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.i == c) {
            return this;
        }
        this.i = c;
        this.a.b(false);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        if (this.i == c && this.j == i) {
            return this;
        }
        this.i = c;
        this.j = KeyEvent.normalizeMetaState(i);
        this.a.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.i = c;
        this.k = Character.toLowerCase(c2);
        this.a.b(false);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.i = c;
        this.j = KeyEvent.normalizeMetaState(i);
        this.k = Character.toLowerCase(c2);
        this.l = KeyEvent.normalizeMetaState(i2);
        this.a.b(false);
        return this;
    }

    char d() {
        return this.a.c() ? this.k : this.i;
    }

    String e() {
        char d = d();
        if (d == 0) {
            return "";
        }
        Resources resources = this.a.f().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.a.f()).hasPermanentMenuKey()) {
            sb.append(resources.getString(a.h.abc_prepend_shortcut_label));
        }
        int i = this.a.c() ? this.l : this.j;
        a(sb, i, 65536, resources.getString(a.h.abc_menu_meta_shortcut_label));
        a(sb, i, 4096, resources.getString(a.h.abc_menu_ctrl_shortcut_label));
        a(sb, i, 2, resources.getString(a.h.abc_menu_alt_shortcut_label));
        a(sb, i, 1, resources.getString(a.h.abc_menu_shift_shortcut_label));
        a(sb, i, 4, resources.getString(a.h.abc_menu_sym_shortcut_label));
        a(sb, i, 8, resources.getString(a.h.abc_menu_function_shortcut_label));
        if (d == '\b') {
            sb.append(resources.getString(a.h.abc_menu_delete_shortcut_label));
        } else if (d == '\n') {
            sb.append(resources.getString(a.h.abc_menu_enter_shortcut_label));
        } else if (d == ' ') {
            sb.append(resources.getString(a.h.abc_menu_space_shortcut_label));
        } else {
            sb.append(d);
        }
        return sb.toString();
    }

    private static void a(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    boolean f() {
        return this.a.d() && d() != 0;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.o != null;
    }

    public void a(r rVar) {
        this.o = rVar;
        rVar.setHeaderTitle(getTitle());
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f;
    }

    CharSequence a(n.a aVar) {
        if (aVar != null && aVar.a()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f = charSequence;
        this.a.b(false);
        if (this.o != null) {
            this.o.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        return setTitle(this.a.f().getString(i));
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.g != null ? this.g : this.f;
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.g = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f;
        }
        this.a.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        if (this.m != null) {
            return a(this.m);
        }
        if (this.n == 0) {
            return null;
        }
        Drawable b = androidx.appcompat.a.a.a.b(this.a.f(), this.n);
        this.n = 0;
        this.m = b;
        return a(b);
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.n = 0;
        this.m = drawable;
        this.x = true;
        this.a.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.m = null;
        this.n = i;
        this.x = true;
        this.a.b(false);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.t = colorStateList;
        this.v = true;
        this.x = true;
        this.a.b(false);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.t;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.u = mode;
        this.w = true;
        this.x = true;
        this.a.b(false);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.u;
    }

    private Drawable a(Drawable drawable) {
        if (drawable != null && this.x && (this.v || this.w)) {
            drawable = androidx.core.graphics.drawable.a.g(drawable).mutate();
            if (this.v) {
                androidx.core.graphics.drawable.a.a(drawable, this.t);
            }
            if (this.w) {
                androidx.core.graphics.drawable.a.a(drawable, this.u);
            }
            this.x = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.y;
        this.y = (z ? 1 : 0) | (this.y & (-2));
        if (i != this.y) {
            this.a.b(false);
        }
        return this;
    }

    public void a(boolean z) {
        this.y = (z ? 4 : 0) | (this.y & (-5));
    }

    public boolean g() {
        return (this.y & 4) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.y & 4) != 0) {
            this.a.a((MenuItem) this);
        } else {
            b(z);
        }
        return this;
    }

    void b(boolean z) {
        int i = this.y;
        this.y = (z ? 2 : 0) | (this.y & (-3));
        if (i != this.y) {
            this.a.b(false);
        }
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.B == null || !this.B.d()) ? (this.y & 8) == 0 : (this.y & 8) == 0 && this.B.e();
    }

    boolean c(boolean z) {
        int i = this.y;
        this.y = (z ? 0 : 8) | (this.y & (-9));
        return i != this.y;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (c(z)) {
            this.a.a(this);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.q = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        if (this.f != null) {
            return this.f.toString();
        }
        return null;
    }

    void a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    public void h() {
        this.a.b(this);
    }

    public boolean i() {
        return this.a.r();
    }

    public boolean j() {
        return (this.y & 32) == 32;
    }

    public boolean k() {
        return (this.z & 1) == 1;
    }

    public boolean l() {
        return (this.z & 2) == 2;
    }

    public void d(boolean z) {
        if (z) {
            this.y |= 32;
        } else {
            this.y &= -33;
        }
    }

    public boolean m() {
        return (this.z & 4) == 4;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.z = i;
                this.a.b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    /* renamed from: a */
    public androidx.core.a.a.b setActionView(View view) {
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && this.b > 0) {
            view.setId(this.b);
        }
        this.a.b(this);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    /* renamed from: a */
    public androidx.core.a.a.b setActionView(int i) {
        Context f = this.a.f();
        setActionView(LayoutInflater.from(f).inflate(i, (ViewGroup) new LinearLayout(f), false));
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public View getActionView() {
        if (this.A != null) {
            return this.A;
        }
        if (this.B == null) {
            return null;
        }
        this.A = this.B.a(this);
        return this.A;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // androidx.core.a.a.b
    public androidx.core.h.b a() {
        return this.B;
    }

    @Override // androidx.core.a.a.b
    public androidx.core.a.a.b a(androidx.core.h.b bVar) {
        if (this.B != null) {
            this.B.f();
        }
        this.A = null;
        this.B = bVar;
        this.a.b(true);
        if (this.B != null) {
            this.B.a(new b.InterfaceC0027b() { // from class: androidx.appcompat.view.menu.i.1
                AnonymousClass1() {
                }

                @Override // androidx.core.h.b.InterfaceC0027b
                public void a(boolean z) {
                    i.this.a.a(i.this);
                }
            });
        }
        return this;
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.view.menu.i$1 */
    class AnonymousClass1 implements b.InterfaceC0027b {
        AnonymousClass1() {
        }

        @Override // androidx.core.h.b.InterfaceC0027b
        public void a(boolean z) {
            i.this.a.a(i.this);
        }
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    /* renamed from: b */
    public androidx.core.a.a.b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!n()) {
            return false;
        }
        if (this.C == null || this.C.onMenuItemActionExpand(this)) {
            return this.a.c(this);
        }
        return false;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        if (this.C == null || this.C.onMenuItemActionCollapse(this)) {
            return this.a.d(this);
        }
        return false;
    }

    public boolean n() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null && this.B != null) {
            this.A = this.B.a(this);
        }
        return this.A != null;
    }

    public void e(boolean z) {
        this.D = z;
        this.a.b(false);
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    /* renamed from: a */
    public androidx.core.a.a.b setContentDescription(CharSequence charSequence) {
        this.r = charSequence;
        this.a.b(false);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.r;
    }

    @Override // android.view.MenuItem
    /* renamed from: b */
    public androidx.core.a.a.b setTooltipText(CharSequence charSequence) {
        this.s = charSequence;
        this.a.b(false);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.s;
    }
}
