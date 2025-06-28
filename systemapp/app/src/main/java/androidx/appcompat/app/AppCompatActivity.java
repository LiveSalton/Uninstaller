package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.b;
import androidx.appcompat.widget.ak;
import androidx.core.app.n;
import androidx.fragment.app.FragmentActivity;

/* compiled from: source */
/* loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements b, n.a {
    private c k;
    private Resources l;

    @Override // androidx.appcompat.app.b
    public androidx.appcompat.view.b a(b.a aVar) {
        return null;
    }

    protected void a(int i) {
    }

    @Override // androidx.appcompat.app.b
    public void a(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.appcompat.app.b
    public void b(androidx.appcompat.view.b bVar) {
    }

    public void b(n nVar) {
    }

    @Deprecated
    public void j() {
    }

    public AppCompatActivity() {
    }

    public AppCompatActivity(int i) {
        super(i);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(k().b(context));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        c k = k();
        k.h();
        k.a(bundle);
        super.onCreate(bundle);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        k().a(i);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        k().b(bundle);
    }

    public ActionBar f() {
        return k().a();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return k().b();
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        k().c(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        k().a(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        k().a(view, layoutParams);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        k().b(view, layoutParams);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.l != null) {
            this.l.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        k().a(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        k().e();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        k().c();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        k().d();
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) k().b(i);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar f = f();
        if (menuItem.getItemId() != 16908332 || f == null || (f.a() & 4) == 0) {
            return false;
        }
        return h();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        k().g();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        k().a(charSequence);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void g() {
        k().f();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        k().f();
    }

    public void a(n nVar) {
        nVar.a((Activity) this);
    }

    public boolean h() {
        Intent i = i();
        if (i == null) {
            return false;
        }
        if (a(i)) {
            n a = n.a((Context) this);
            a(a);
            b(a);
            a.a();
            try {
                androidx.core.app.a.a((Activity) this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        }
        b(i);
        return true;
    }

    @Override // androidx.core.app.n.a
    public Intent i() {
        return androidx.core.app.f.a(this);
    }

    public boolean a(Intent intent) {
        return androidx.core.app.f.a(this, intent);
    }

    public void b(Intent intent) {
        androidx.core.app.f.b(this, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        j();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        k().c(bundle);
    }

    public c k() {
        if (this.k == null) {
            this.k = c.a(this, this);
        }
        return this.k;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar f = f();
        if (keyCode == 82 && f != null && f.a(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.l == null && ak.a()) {
            this.l = new ak(this, super.getResources());
        }
        return this.l == null ? super.getResources() : this.l;
    }

    private boolean b(KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (b(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        ActionBar f = f();
        if (getWindow().hasFeature(0)) {
            if (f == null || !f.c()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        ActionBar f = f();
        if (getWindow().hasFeature(0)) {
            if (f == null || !f.d()) {
                super.closeOptionsMenu();
            }
        }
    }
}
