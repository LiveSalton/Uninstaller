package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.a;
import androidx.lifecycle.f;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: source */
/* loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements a.InterfaceC0017a, a.c {
    final d a;
    final androidx.lifecycle.k b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    int i;
    androidx.b.h<String> j;

    public void a(Fragment fragment) {
    }

    public FragmentActivity() {
        this.a = d.a(new a());
        this.b = new androidx.lifecycle.k(this);
        this.e = true;
    }

    public FragmentActivity(int i) {
        super(i);
        this.a = d.a(new a());
        this.b = new androidx.lifecycle.k(this);
        this.e = true;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        this.a.b();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String a2 = this.j.a(i4);
            this.j.b(i4);
            if (a2 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a3 = this.a.a(a2);
            if (a3 == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + a2);
                return;
            }
            a3.a(i & 65535, i2, intent);
            return;
        }
        a.b a4 = androidx.core.app.a.a();
        if (a4 == null || !a4.a(this, i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.a.a(z);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.a.b(z);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.a.b();
        this.a.a(configuration);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.a.a((Fragment) null);
        if (bundle != null) {
            this.a.a(bundle.getParcelable("android:support:fragments"));
            if (bundle.containsKey("android:support:next_request_index")) {
                this.i = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.j = new androidx.b.h<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.j.b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.j == null) {
            this.j = new androidx.b.h<>();
            this.i = 0;
        }
        super.onCreate(bundle);
        this.b.a(f.a.ON_CREATE);
        this.a.d();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            return super.onCreatePanelMenu(i, menu) | this.a.a(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a2 = a(view, str, context, attributeSet);
        return a2 == null ? super.onCreateView(view, str, context, attributeSet) : a2;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View a2 = a((View) null, str, context, attributeSet);
        return a2 == null ? super.onCreateView(str, context, attributeSet) : a2;
    }

    final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a.a(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.a.j();
        this.b.a(f.a.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.a.k();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.a.a(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.a.b(menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.a.b(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.d = false;
        this.a.h();
        this.b.a(f.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    protected void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.a.b();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.a.b();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.d = true;
        this.a.b();
        this.a.l();
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        l();
    }

    protected void l() {
        this.b.a(f.a.ON_RESUME);
        this.a.g();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i == 0) {
            return a(view, menu) | this.a.a(menu);
        }
        return super.onPreparePanel(i, view, menu);
    }

    @Deprecated
    protected boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        f();
        this.b.a(f.a.ON_STOP);
        Parcelable c = this.a.c();
        if (c != null) {
            bundle.putParcelable("android:support:fragments", c);
        }
        if (this.j.b() > 0) {
            bundle.putInt("android:support:next_request_index", this.i);
            int[] iArr = new int[this.j.b()];
            String[] strArr = new String[this.j.b()];
            for (int i = 0; i < this.j.b(); i++) {
                iArr[i] = this.j.d(i);
                strArr[i] = this.j.e(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.e = false;
        if (!this.c) {
            this.c = true;
            this.a.e();
        }
        this.a.b();
        this.a.l();
        this.b.a(f.a.ON_START);
        this.a.f();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.e = true;
        f();
        this.a.i();
        this.b.a(f.a.ON_STOP);
    }

    @Deprecated
    public void g() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.c);
        printWriter.print(" mResumed=");
        printWriter.print(this.d);
        printWriter.print(" mStopped=");
        printWriter.print(this.e);
        if (getApplication() != null) {
            androidx.e.a.a.a(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.a.a().a(str, fileDescriptor, printWriter, strArr);
    }

    public i m() {
        return this.a.a();
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        if (!this.h && i != -1) {
            c(i);
        }
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (!this.h && i != -1) {
            c(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        if (!this.g && i != -1) {
            c(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (!this.g && i != -1) {
            c(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    static void c(int i) {
        if ((i & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    @Override // androidx.core.app.a.c
    public final void b(int i) {
        if (this.f || i == -1) {
            return;
        }
        c(i);
    }

    @Override // android.app.Activity, androidx.core.app.a.InterfaceC0017a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.a.b();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String a2 = this.j.a(i3);
            this.j.b(i3);
            if (a2 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a3 = this.a.a(a2);
            if (a3 == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + a2);
                return;
            }
            a3.a(i & 65535, strArr, iArr);
        }
    }

    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        this.h = true;
        try {
            if (i == -1) {
                androidx.core.app.a.a(this, intent, -1, bundle);
            } else {
                c(i);
                androidx.core.app.a.a(this, intent, ((b(fragment) + 1) << 16) + (i & 65535), bundle);
            }
        } finally {
            this.h = false;
        }
    }

    private int b(Fragment fragment) {
        if (this.j.b() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.j.f(this.i) >= 0) {
            this.i = (this.i + 1) % 65534;
        }
        int i = this.i;
        this.j.b(i, fragment.f);
        this.i = (this.i + 1) % 65534;
        return i;
    }

    void a(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            androidx.core.app.a.a(this, strArr, i);
            return;
        }
        c(i);
        try {
            this.f = true;
            androidx.core.app.a.a(this, strArr, ((b(fragment) + 1) << 16) + (i & 65535));
        } finally {
            this.f = false;
        }
    }

    /* compiled from: source */
    class a extends f<FragmentActivity> implements androidx.activity.c, y {
        public a() {
            super(FragmentActivity.this);
        }

        @Override // androidx.lifecycle.j
        public androidx.lifecycle.f b() {
            return FragmentActivity.this.b;
        }

        @Override // androidx.lifecycle.y
        public x c() {
            return FragmentActivity.this.c();
        }

        @Override // androidx.activity.c
        public OnBackPressedDispatcher d() {
            return FragmentActivity.this.d();
        }

        @Override // androidx.fragment.app.f
        public boolean a(Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        @Override // androidx.fragment.app.f
        public LayoutInflater e() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // androidx.fragment.app.f
        /* renamed from: f */
        public FragmentActivity h() {
            return FragmentActivity.this;
        }

        @Override // androidx.fragment.app.f
        public void g() {
            FragmentActivity.this.g();
        }

        @Override // androidx.fragment.app.f
        public void a(Fragment fragment, Intent intent, int i, Bundle bundle) {
            FragmentActivity.this.a(fragment, intent, i, bundle);
        }

        @Override // androidx.fragment.app.f
        public void a(Fragment fragment, String[] strArr, int i) {
            FragmentActivity.this.a(fragment, strArr, i);
        }

        @Override // androidx.fragment.app.f
        public void b(Fragment fragment) {
            FragmentActivity.this.a(fragment);
        }

        @Override // androidx.fragment.app.f, androidx.fragment.app.c
        public View a(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        @Override // androidx.fragment.app.f, androidx.fragment.app.c
        public boolean a() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    private void f() {
        while (a(m(), f.b.CREATED)) {
        }
    }

    private static boolean a(i iVar, f.b bVar) {
        boolean z = false;
        for (Fragment fragment : iVar.f()) {
            if (fragment != null) {
                if (fragment.o() != null) {
                    z |= a(fragment.r(), bVar);
                }
                if (fragment.b().a().a(f.b.STARTED)) {
                    fragment.Q.b(bVar);
                    z = true;
                }
            }
        }
        return z;
    }
}
