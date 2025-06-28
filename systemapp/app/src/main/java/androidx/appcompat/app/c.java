package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class c {
    private static int a = -100;
    private static final androidx.b.b<WeakReference<c>> b = new androidx.b.b<>();
    private static final Object c = new Object();

    public abstract ActionBar a();

    public void a(int i) {
    }

    @Deprecated
    public void a(Context context) {
    }

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(View view);

    public abstract void a(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void a(CharSequence charSequence);

    public abstract MenuInflater b();

    public abstract <T extends View> T b(int i);

    public abstract void b(Bundle bundle);

    public abstract void b(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void c();

    public abstract void c(int i);

    public abstract void c(Bundle bundle);

    public abstract void d();

    public abstract boolean d(int i);

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public int i() {
        return -100;
    }

    public static c a(Activity activity, b bVar) {
        return new AppCompatDelegateImpl(activity, bVar);
    }

    public static c a(Dialog dialog, b bVar) {
        return new AppCompatDelegateImpl(dialog, bVar);
    }

    c() {
    }

    public Context b(Context context) {
        a(context);
        return context;
    }

    public static int j() {
        return a;
    }

    static void a(c cVar) {
        synchronized (c) {
            c(cVar);
            b.add(new WeakReference<>(cVar));
        }
    }

    static void b(c cVar) {
        synchronized (c) {
            c(cVar);
        }
    }

    private static void c(c cVar) {
        synchronized (c) {
            Iterator<WeakReference<c>> it = b.iterator();
            while (it.hasNext()) {
                c cVar2 = it.next().get();
                if (cVar2 == cVar || cVar2 == null) {
                    it.remove();
                }
            }
        }
    }
}
