package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;
import androidx.appcompat.view.b;
import androidx.core.h.e;

/* compiled from: source */
/* loaded from: classes.dex */
public class d extends Dialog implements b {
    private c a;
    private final e.a b;

    @Override // androidx.appcompat.app.b
    public androidx.appcompat.view.b a(b.a aVar) {
        return null;
    }

    @Override // androidx.appcompat.app.b
    public void a(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.appcompat.app.b
    public void b(androidx.appcompat.view.b bVar) {
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.app.d$1 */
    class AnonymousClass1 implements e.a {
        AnonymousClass1() {
        }

        @Override // androidx.core.h.e.a
        public boolean a(KeyEvent keyEvent) {
            return d.this.a(keyEvent);
        }
    }

    public d(Context context, int i) {
        super(context, a(context, i));
        this.b = new e.a() { // from class: androidx.appcompat.app.d.1
            AnonymousClass1() {
            }

            @Override // androidx.core.h.e.a
            public boolean a(KeyEvent keyEvent) {
                return d.this.a(keyEvent);
            }
        };
        c b = b();
        b.a(a(context, i));
        b.a((Bundle) null);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        b().h();
        super.onCreate(bundle);
        b().a(bundle);
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        b().c(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        b().a(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        b().a(view, layoutParams);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) b().b(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        b().a(charSequence);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        b().a(getContext().getString(i));
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        b().b(view, layoutParams);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        b().d();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        b().g();
    }

    public boolean a(int i) {
        return b().d(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        b().f();
    }

    public c b() {
        if (this.a == null) {
            this.a = c.a(this, this);
        }
        return this.a;
    }

    private static int a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.C0001a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return androidx.core.h.e.a(this.b, getWindow().getDecorView(), this, keyEvent);
    }
}
