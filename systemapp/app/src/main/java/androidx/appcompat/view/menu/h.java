package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.a;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.m;

/* compiled from: source */
/* loaded from: classes.dex */
class h implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, m.a {
    e a;
    private g b;
    private androidx.appcompat.app.a c;
    private m.a d;

    public h(g gVar) {
        this.b = gVar;
    }

    public void a(IBinder iBinder) {
        g gVar = this.b;
        a.C0004a c0004a = new a.C0004a(gVar.f());
        this.a = new e(c0004a.a(), a.g.abc_list_menu_item_layout);
        this.a.a(this);
        this.b.a(this.a);
        c0004a.a(this.a.a(), this);
        View p = gVar.p();
        if (p != null) {
            c0004a.a(p);
        } else {
            c0004a.a(gVar.o()).a(gVar.n());
        }
        c0004a.a(this);
        this.c = c0004a.b();
        this.c.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.c.show();
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.b.a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.b.performShortcut(i, keyEvent, 0);
    }

    public void a() {
        if (this.c != null) {
            this.c.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.a.a(this.b, true);
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void a(g gVar, boolean z) {
        if (z || gVar == this.b) {
            a();
        }
        if (this.d != null) {
            this.d.a(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean a(g gVar) {
        if (this.d != null) {
            return this.d.a(gVar);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.b.a((i) this.a.a().getItem(i), 0);
    }
}
