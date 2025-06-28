package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class f<E> extends c {
    private final Activity a;
    final i b;
    private final Context c;
    private final Handler d;
    private final int e;

    @Override // androidx.fragment.app.c
    public View a(int i) {
        return null;
    }

    public void a(Fragment fragment, String[] strArr, int i) {
    }

    @Override // androidx.fragment.app.c
    public boolean a() {
        return true;
    }

    public boolean a(Fragment fragment) {
        return true;
    }

    void b(Fragment fragment) {
    }

    public void g() {
    }

    public abstract E h();

    f(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    f(Activity activity, Context context, Handler handler, int i) {
        this.b = new j();
        this.a = activity;
        this.c = (Context) androidx.core.g.e.a(context, "context == null");
        this.d = (Handler) androidx.core.g.e.a(handler, "handler == null");
        this.e = i;
    }

    public LayoutInflater e() {
        return LayoutInflater.from(this.c);
    }

    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.c.startActivity(intent);
    }

    Activity i() {
        return this.a;
    }

    Context j() {
        return this.c;
    }

    Handler k() {
        return this.d;
    }
}
