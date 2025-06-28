package com.jumobile.manager.systemapp.a;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.ads.consent.ConsentInformation;
import com.google.ads.consent.ConsentStatus;
import com.jumobile.manager.systemapp.R;

/* compiled from: source */
/* loaded from: classes.dex */
public class b {
    protected Activity a;
    protected ViewGroup b;
    protected int c = 6;
    protected boolean d = false;
    protected a e;
    private com.jumobile.manager.systemapp.g.a.a f;

    /* compiled from: source */
    public interface a {
        void a();
    }

    public View a(int i, boolean z) {
        return null;
    }

    protected void b() {
    }

    protected void c() {
    }

    protected void d() {
    }

    protected void e() {
    }

    public boolean f() {
        return false;
    }

    protected void g() {
    }

    protected boolean n() {
        return false;
    }

    protected boolean o() {
        return false;
    }

    protected void p() {
    }

    protected void q() {
    }

    protected void r() {
    }

    public boolean t() {
        return false;
    }

    protected int u() {
        return 0;
    }

    protected void v() {
    }

    public static b j() {
        return new com.jumobile.manager.systemapp.a.a();
    }

    public static boolean a(Activity activity) {
        b j = j();
        j.n(activity);
        return j.l();
    }

    public static boolean b(Activity activity) {
        b j = j();
        j.n(activity);
        return j.m();
    }

    public static void c(Activity activity) {
        b j = j();
        j.n(activity);
        j.a(!j.m());
    }

    public static boolean d(Activity activity) {
        b j = j();
        j.n(activity);
        return j.n();
    }

    public static boolean e(Activity activity) {
        b j = j();
        j.n(activity);
        return j.o();
    }

    public static void f(Activity activity) {
        b j = j();
        j.n(activity);
        j.p();
    }

    public static void g(Activity activity) {
        b j = j();
        j.n(activity);
        j.q();
    }

    public static boolean h(Activity activity) {
        b j = j();
        j.n(activity);
        return j.t();
    }

    public static int i(Activity activity) {
        b j = j();
        j.n(activity);
        return j.u();
    }

    public static void j(Activity activity) {
        b j = j();
        j.n(activity);
        j.v();
    }

    public static void k(Activity activity) {
        b j = j();
        j.n(activity);
        j.a();
    }

    public static void l(Activity activity) {
        b j = j();
        j.n(activity);
        j.r();
    }

    public void a(Fragment fragment, View view) {
        FragmentActivity m = fragment.m();
        if (m == null) {
            return;
        }
        n(m);
        a((ViewGroup) view.findViewById(R.id.ads_container));
        s();
    }

    public void a(int i) {
        this.c = i;
    }

    public void m(Activity activity) {
        if (activity == null) {
            return;
        }
        n(activity);
        if ((this.c & 2) != 0) {
            a((ViewGroup) activity.findViewById(R.id.ads_container));
        }
        s();
    }

    public void k() {
        g();
        if (this.b != null) {
            this.b.removeAllViews();
            this.b = null;
        }
        if (this.f != null) {
            this.f.a();
        }
        this.a = null;
    }

    public void h() {
        com.jumobile.manager.systemapp.f.a.b(this.a.getApplicationContext(), "ads_enabled", false);
    }

    protected b() {
    }

    protected void n(Activity activity) {
        this.a = activity;
    }

    protected void a(ViewGroup viewGroup) {
        this.b = viewGroup;
    }

    protected boolean l() {
        return com.jumobile.manager.systemapp.e.a.a(this.a.getApplicationContext(), "ads_closeable", false);
    }

    protected boolean m() {
        return com.jumobile.manager.systemapp.f.a.a(this.a.getApplicationContext(), "ads_enabled", true);
    }

    protected void a(boolean z) {
        com.jumobile.manager.systemapp.f.a.b(this.a.getApplicationContext(), "ads_enabled", z);
    }

    protected void a() {
        com.jumobile.manager.systemapp.a.b = true;
    }

    protected void s() {
        if (com.jumobile.manager.systemapp.f.a.a(this.a.getApplicationContext(), "ads_enabled", true)) {
            ConsentInformation a2 = ConsentInformation.a(this.a);
            if (!a2.e()) {
                this.d = false;
            } else if (a2.f().equals(ConsentStatus.PERSONALIZED)) {
                this.d = false;
            } else {
                this.d = true;
            }
            Log.d("GPDR", "NPA: " + this.d);
            if (this.b != null && (this.c & 2) != 0) {
                b();
            }
            if (com.jumobile.manager.systemapp.a.b.booleanValue() && (this.c & 4) != 0) {
                c();
            }
            if ((this.c & 16) != 0) {
                d();
            }
            if ((this.c & 8) != 0) {
                e();
            }
        }
    }

    public void a(a aVar) {
        this.e = aVar;
    }
}
