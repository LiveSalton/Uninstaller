package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.y;

/* compiled from: source */
/* loaded from: classes.dex */
public class d {
    private final f<?> a;

    public static d a(f<?> fVar) {
        return new d((f) androidx.core.g.e.a(fVar, "callbacks == null"));
    }

    private d(f<?> fVar) {
        this.a = fVar;
    }

    public i a() {
        return this.a.b;
    }

    public Fragment a(String str) {
        return this.a.b.b(str);
    }

    public void a(Fragment fragment) {
        this.a.b.a(this.a, this.a, fragment);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a.b.B().onCreateView(view, str, context, attributeSet);
    }

    public void b() {
        this.a.b.m();
    }

    public Parcelable c() {
        return this.a.b.k();
    }

    public void a(Parcelable parcelable) {
        if (!(this.a instanceof y)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        this.a.b.a(parcelable);
    }

    public void d() {
        this.a.b.n();
    }

    public void e() {
        this.a.b.o();
    }

    public void f() {
        this.a.b.p();
    }

    public void g() {
        this.a.b.q();
    }

    public void h() {
        this.a.b.r();
    }

    public void i() {
        this.a.b.s();
    }

    public void j() {
        this.a.b.u();
    }

    public void a(boolean z) {
        this.a.b.b(z);
    }

    public void b(boolean z) {
        this.a.b.c(z);
    }

    public void a(Configuration configuration) {
        this.a.b.a(configuration);
    }

    public void k() {
        this.a.b.v();
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.a.b.a(menu, menuInflater);
    }

    public boolean a(Menu menu) {
        return this.a.b.a(menu);
    }

    public boolean a(MenuItem menuItem) {
        return this.a.b.a(menuItem);
    }

    public boolean b(MenuItem menuItem) {
        return this.a.b.b(menuItem);
    }

    public void b(Menu menu) {
        this.a.b.b(menu);
    }

    public boolean l() {
        return this.a.b.a(true);
    }
}
