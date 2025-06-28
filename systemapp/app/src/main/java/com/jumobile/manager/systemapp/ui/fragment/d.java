package com.jumobile.manager.systemapp.ui.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.jumobile.manager.systemapp.R;
import com.jumobile.manager.systemapp.ui.activity.MainActivity;
import com.jumobile.manager.systemapp.ui.widget.ActionBar;

/* compiled from: source */
/* loaded from: classes.dex */
public class d extends c {
    private static final String U = "d";
    private Context X;
    private int Y;
    private int Z;
    private int aa;
    private BroadcastReceiver ab;
    private ImageButton ac;
    private com.jumobile.manager.systemapp.a.b ad = com.jumobile.manager.systemapp.a.b.j();

    public void a(int i, int i2, int i3) {
        this.Y = i;
        this.Z = i2;
        this.aa = i3;
    }

    @Override // androidx.fragment.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.X = activity.getApplicationContext();
    }

    @Override // androidx.fragment.app.Fragment
    public void f(Bundle bundle) {
        super.f(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void K() {
        if (this.ab != null) {
            androidx.f.a.a.a(this.X.getApplicationContext()).a(this.ab);
        }
        this.ad.k();
        super.K();
    }

    @Override // androidx.fragment.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_hint, viewGroup, false);
        d(inflate);
        this.ad.a(this, inflate);
        this.W = true;
        if (this.V) {
            as();
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void J() {
        this.W = false;
        super.J();
    }

    @Override // com.jumobile.manager.systemapp.ui.fragment.c
    public void as() {
        super.as();
        boolean z = this.W;
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.d$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentActivity m = d.this.m();
            if (m != null) {
                if (m instanceof MainActivity) {
                    ((MainActivity) m).n();
                } else {
                    m.finish();
                    m.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
                }
            }
        }
    }

    private void d(View view) {
        ActionBar actionBar = (ActionBar) view.findViewById(R.id.action_bar);
        actionBar.a.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.d.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FragmentActivity m = d.this.m();
                if (m != null) {
                    if (m instanceof MainActivity) {
                        ((MainActivity) m).n();
                    } else {
                        m.finish();
                        m.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
                    }
                }
            }
        });
        actionBar.b.setText(this.Y);
        if (com.jumobile.manager.systemapp.f.a.a(this.X, "ads_enabled", true)) {
            this.ac = actionBar.a(R.drawable.remove_ads, new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.d.2
                AnonymousClass2() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    FragmentActivity m = d.this.m();
                    if (m != null) {
                        androidx.f.a.a.a(d.this.X.getApplicationContext()).a(new Intent(m.getClass().getName() + "SHOW_DIALOG"));
                    }
                }
            });
            this.ab = new BroadcastReceiver() { // from class: com.jumobile.manager.systemapp.ui.fragment.d.3
                AnonymousClass3() {
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    d.this.ad.h();
                    d.this.ac.setVisibility(8);
                }
            };
            androidx.f.a.a.a(this.X).a(this.ab, new IntentFilter("com.jumobile.manager.systemapp.ACTION_ADS_REMOVED"));
        }
        ((TextView) view.findViewById(R.id.content)).setText(this.Z);
        ((TextView) view.findViewById(R.id.hint)).setText(this.aa);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.d$2 */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            FragmentActivity m = d.this.m();
            if (m != null) {
                androidx.f.a.a.a(d.this.X.getApplicationContext()).a(new Intent(m.getClass().getName() + "SHOW_DIALOG"));
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.d$3 */
    class AnonymousClass3 extends BroadcastReceiver {
        AnonymousClass3() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            d.this.ad.h();
            d.this.ac.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void F() {
        super.F();
    }

    @Override // androidx.fragment.app.Fragment
    public void I() {
        super.I();
    }

    @Override // com.jumobile.manager.systemapp.ui.fragment.c
    public boolean av() {
        return this.ad.f();
    }
}
