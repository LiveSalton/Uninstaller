package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.af;
import androidx.appcompat.widget.p;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: source */
/* loaded from: classes.dex */
public class g extends MenuInflater {
    static final Class<?>[] a = {Context.class};
    static final Class<?>[] b = a;
    final Object[] c;
    final Object[] d;
    Context e;
    private Object f;

    public g(Context context) {
        super(context);
        this.e = context;
        this.c = new Object[]{context};
        this.d = this.c;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof androidx.core.a.a.a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                XmlResourceParser layout = this.e.getResources().getLayout(i);
                try {
                    a(layout, Xml.asAttributeSet(layout), menu);
                    if (layout != null) {
                        layout.close();
                    }
                } catch (IOException e) {
                    e = e;
                    throw new InflateException("Error inflating menu XML", e);
                } catch (XmlPullParserException e2) {
                    e = e2;
                    throw new InflateException("Error inflating menu XML", e);
                } catch (Throwable th) {
                    th = th;
                    xmlResourceParser = layout;
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (XmlPullParserException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0048, code lost:
    
        r4 = r9.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004c, code lost:
    
        if (r5 == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0052, code lost:
    
        if (r4.equals(r6) == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0054, code lost:
    
        r6 = null;
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00cb, code lost:
    
        r4 = r9.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005e, code lost:
    
        if (r4.equals("group") == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
    
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
    
        if (r4.equals("item") == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0071, code lost:
    
        if (r0.d() != false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
    
        if (r0.a == null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007d, code lost:
    
        if (r0.a.c() == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007f, code lost:
    
        r0.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0083, code lost:
    
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008d, code lost:
    
        if (r4.equals("menu") == false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008f, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0091, code lost:
    
        if (r5 == false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0094, code lost:
    
        r4 = r9.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009e, code lost:
    
        if (r4.equals("group") == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a0, code lost:
    
        r0.a(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00aa, code lost:
    
        if (r4.equals("item") == false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ac, code lost:
    
        r0.b(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b6, code lost:
    
        if (r4.equals("menu") == false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b8, code lost:
    
        a(r9, r10, r0.c());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c0, code lost:
    
        r5 = true;
        r6 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ca, code lost:
    
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d1, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003b, code lost:
    
        r4 = r11;
        r6 = null;
        r11 = false;
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0041, code lost:
    
        if (r11 != false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0043, code lost:
    
        switch(r4) {
            case 1: goto L128;
            case 2: goto L108;
            case 3: goto L87;
            default: goto L140;
        };
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.view.Menu r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r8 = this;
            androidx.appcompat.view.g$b r0 = new androidx.appcompat.view.g$b
            r0.<init>(r11)
            int r11 = r9.getEventType()
        L9:
            r1 = 2
            r2 = 1
            if (r11 != r1) goto L35
            java.lang.String r11 = r9.getName()
            java.lang.String r1 = "menu"
            boolean r1 = r11.equals(r1)
            if (r1 == 0) goto L1e
            int r11 = r9.next()
            goto L3b
        L1e:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Expecting menu, got "
            r10.append(r0)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L35:
            int r11 = r9.next()
            if (r11 != r2) goto L9
        L3b:
            r1 = 0
            r3 = 0
            r4 = r11
            r6 = r1
            r11 = r3
            r5 = r11
        L41:
            if (r11 != 0) goto Ld1
            switch(r4) {
                case 1: goto Lc3;
                case 2: goto L91;
                case 3: goto L48;
                default: goto L46;
            }
        L46:
            goto Lcb
        L48:
            java.lang.String r4 = r9.getName()
            if (r5 == 0) goto L58
            boolean r7 = r4.equals(r6)
            if (r7 == 0) goto L58
            r6 = r1
            r5 = r3
            goto Lcb
        L58:
            java.lang.String r7 = "group"
            boolean r7 = r4.equals(r7)
            if (r7 == 0) goto L65
            r0.a()
            goto Lcb
        L65:
            java.lang.String r7 = "item"
            boolean r7 = r4.equals(r7)
            if (r7 == 0) goto L87
            boolean r4 = r0.d()
            if (r4 != 0) goto Lcb
            androidx.core.h.b r4 = r0.a
            if (r4 == 0) goto L83
            androidx.core.h.b r4 = r0.a
            boolean r4 = r4.c()
            if (r4 == 0) goto L83
            r0.c()
            goto Lcb
        L83:
            r0.b()
            goto Lcb
        L87:
            java.lang.String r7 = "menu"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto Lcb
            r11 = r2
            goto Lcb
        L91:
            if (r5 == 0) goto L94
            goto Lcb
        L94:
            java.lang.String r4 = r9.getName()
            java.lang.String r7 = "group"
            boolean r7 = r4.equals(r7)
            if (r7 == 0) goto La4
            r0.a(r10)
            goto Lcb
        La4:
            java.lang.String r7 = "item"
            boolean r7 = r4.equals(r7)
            if (r7 == 0) goto Lb0
            r0.b(r10)
            goto Lcb
        Lb0:
            java.lang.String r7 = "menu"
            boolean r7 = r4.equals(r7)
            if (r7 == 0) goto Lc0
            android.view.SubMenu r4 = r0.c()
            r8.a(r9, r10, r4)
            goto Lcb
        Lc0:
            r5 = r2
            r6 = r4
            goto Lcb
        Lc3:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.String r10 = "Unexpected end of document"
            r9.<init>(r10)
            throw r9
        Lcb:
            int r4 = r9.next()
            goto L41
        Ld1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.g.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    Object a() {
        if (this.f == null) {
            this.f = a(this.e);
        }
        return this.f;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* compiled from: source */
    private static class a implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] a = {MenuItem.class};
        private Object b;
        private Method c;

        public a(Object obj, String str) {
            this.b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.c = cls.getMethod(str, a);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.c.invoke(this.b, menuItem)).booleanValue();
                }
                this.c.invoke(this.b, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* compiled from: source */
    private class b {
        private String A;
        private String B;
        private CharSequence C;
        private CharSequence D;
        private ColorStateList E = null;
        private PorterDuff.Mode F = null;
        androidx.core.h.b a;
        private Menu c;
        private int d;
        private int e;
        private int f;
        private int g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int k;
        private int l;
        private CharSequence m;
        private CharSequence n;
        private int o;
        private char p;
        private int q;
        private char r;
        private int s;
        private int t;
        private boolean u;
        private boolean v;
        private boolean w;
        private int x;
        private int y;
        private String z;

        public b(Menu menu) {
            this.c = menu;
            a();
        }

        public void a() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = true;
            this.i = true;
        }

        public void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.e.obtainStyledAttributes(attributeSet, a.j.MenuGroup);
            this.d = obtainStyledAttributes.getResourceId(a.j.MenuGroup_android_id, 0);
            this.e = obtainStyledAttributes.getInt(a.j.MenuGroup_android_menuCategory, 0);
            this.f = obtainStyledAttributes.getInt(a.j.MenuGroup_android_orderInCategory, 0);
            this.g = obtainStyledAttributes.getInt(a.j.MenuGroup_android_checkableBehavior, 0);
            this.h = obtainStyledAttributes.getBoolean(a.j.MenuGroup_android_visible, true);
            this.i = obtainStyledAttributes.getBoolean(a.j.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void b(AttributeSet attributeSet) {
            af a = af.a(g.this.e, attributeSet, a.j.MenuItem);
            this.k = a.g(a.j.MenuItem_android_id, 0);
            this.l = (a.a(a.j.MenuItem_android_menuCategory, this.e) & (-65536)) | (a.a(a.j.MenuItem_android_orderInCategory, this.f) & 65535);
            this.m = a.c(a.j.MenuItem_android_title);
            this.n = a.c(a.j.MenuItem_android_titleCondensed);
            this.o = a.g(a.j.MenuItem_android_icon, 0);
            this.p = a(a.d(a.j.MenuItem_android_alphabeticShortcut));
            this.q = a.a(a.j.MenuItem_alphabeticModifiers, 4096);
            this.r = a(a.d(a.j.MenuItem_android_numericShortcut));
            this.s = a.a(a.j.MenuItem_numericModifiers, 4096);
            if (a.g(a.j.MenuItem_android_checkable)) {
                this.t = a.a(a.j.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.t = this.g;
            }
            this.u = a.a(a.j.MenuItem_android_checked, false);
            this.v = a.a(a.j.MenuItem_android_visible, this.h);
            this.w = a.a(a.j.MenuItem_android_enabled, this.i);
            this.x = a.a(a.j.MenuItem_showAsAction, -1);
            this.B = a.d(a.j.MenuItem_android_onClick);
            this.y = a.g(a.j.MenuItem_actionLayout, 0);
            this.z = a.d(a.j.MenuItem_actionViewClass);
            this.A = a.d(a.j.MenuItem_actionProviderClass);
            boolean z = this.A != null;
            if (z && this.y == 0 && this.z == null) {
                this.a = (androidx.core.h.b) a(this.A, g.b, g.this.d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.a = null;
            }
            this.C = a.c(a.j.MenuItem_contentDescription);
            this.D = a.c(a.j.MenuItem_tooltipText);
            if (a.g(a.j.MenuItem_iconTintMode)) {
                this.F = p.a(a.a(a.j.MenuItem_iconTintMode, -1), this.F);
            } else {
                this.F = null;
            }
            if (a.g(a.j.MenuItem_iconTint)) {
                this.E = a.e(a.j.MenuItem_iconTint);
            } else {
                this.E = null;
            }
            a.b();
            this.j = false;
        }

        private char a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private void a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.u).setVisible(this.v).setEnabled(this.w).setCheckable(this.t >= 1).setTitleCondensed(this.n).setIcon(this.o);
            if (this.x >= 0) {
                menuItem.setShowAsAction(this.x);
            }
            if (this.B != null) {
                if (g.this.e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.a(), this.B));
            }
            if (this.t >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.i) {
                    ((androidx.appcompat.view.menu.i) menuItem).a(true);
                } else if (menuItem instanceof j) {
                    ((j) menuItem).a(true);
                }
            }
            if (this.z != null) {
                menuItem.setActionView((View) a(this.z, g.a, g.this.c));
                z = true;
            }
            if (this.y > 0) {
                if (!z) {
                    menuItem.setActionView(this.y);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if (this.a != null) {
                androidx.core.h.h.a(menuItem, this.a);
            }
            androidx.core.h.h.a(menuItem, this.C);
            androidx.core.h.h.b(menuItem, this.D);
            androidx.core.h.h.b(menuItem, this.p, this.q);
            androidx.core.h.h.a(menuItem, this.r, this.s);
            if (this.F != null) {
                androidx.core.h.h.a(menuItem, this.F);
            }
            if (this.E != null) {
                androidx.core.h.h.a(menuItem, this.E);
            }
        }

        public void b() {
            this.j = true;
            a(this.c.add(this.d, this.k, this.l, this.m));
        }

        public SubMenu c() {
            this.j = true;
            SubMenu addSubMenu = this.c.addSubMenu(this.d, this.k, this.l, this.m);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.j;
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.e.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }
}
