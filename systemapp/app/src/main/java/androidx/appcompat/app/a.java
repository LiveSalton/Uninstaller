package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.a;
import androidx.appcompat.app.AlertController;

/* compiled from: source */
/* loaded from: classes.dex */
public class a extends d implements DialogInterface {
    final AlertController a;

    protected a(Context context, int i) {
        super(context, a(context, i));
        this.a = new AlertController(getContext(), this, getWindow());
    }

    static int a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.C0001a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView a() {
        return this.a.b();
    }

    @Override // androidx.appcompat.app.d, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.a.a(charSequence);
    }

    @Override // androidx.appcompat.app.d, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a.a();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.a.a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.a.b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.app.a$a */
    public static class C0004a {
        private final AlertController.a a;
        private final int b;

        public C0004a(Context context) {
            this(context, a.a(context, 0));
        }

        public C0004a(Context context, int i) {
            this.a = new AlertController.a(new ContextThemeWrapper(context, a.a(context, i)));
            this.b = i;
        }

        public Context a() {
            return this.a.a;
        }

        public C0004a a(CharSequence charSequence) {
            this.a.f = charSequence;
            return this;
        }

        public C0004a a(View view) {
            this.a.g = view;
            return this;
        }

        public C0004a a(Drawable drawable) {
            this.a.d = drawable;
            return this;
        }

        public C0004a a(DialogInterface.OnKeyListener onKeyListener) {
            this.a.u = onKeyListener;
            return this;
        }

        public C0004a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.a.w = listAdapter;
            this.a.x = onClickListener;
            return this;
        }

        public C0004a a(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            this.a.w = listAdapter;
            this.a.x = onClickListener;
            this.a.I = i;
            this.a.H = true;
            return this;
        }

        public a b() {
            a aVar = new a(this.a.a, this.b);
            this.a.a(aVar.a);
            aVar.setCancelable(this.a.r);
            if (this.a.r) {
                aVar.setCanceledOnTouchOutside(true);
            }
            aVar.setOnCancelListener(this.a.s);
            aVar.setOnDismissListener(this.a.t);
            if (this.a.u != null) {
                aVar.setOnKeyListener(this.a.u);
            }
            return aVar;
        }
    }
}
