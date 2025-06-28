package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.h.e;
import androidx.lifecycle.f;
import androidx.lifecycle.s;

/* compiled from: source */
/* loaded from: classes.dex */
public class ComponentActivity extends Activity implements e.a, androidx.lifecycle.j {
    private androidx.b.g<Class<? extends Object>, Object> a = new androidx.b.g<>();
    private androidx.lifecycle.k b = new androidx.lifecycle.k(this);

    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        s.a(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.b.a(f.b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    public androidx.lifecycle.f b() {
        return this.b;
    }

    @Override // androidx.core.h.e.a
    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.h.e.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.h.e.a(decorView, keyEvent)) {
            return androidx.core.h.e.a(this, decorView, this, keyEvent);
        }
        return true;
    }
}
