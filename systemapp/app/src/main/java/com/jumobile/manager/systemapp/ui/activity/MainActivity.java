package com.jumobile.manager.systemapp.ui.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import com.jumobile.manager.systemapp.R;
import com.jumobile.manager.systemapp.ui.fragment.h;
import com.jumobile.manager.systemapp.ui.fragment.i;
import com.jumobile.manager.systemapp.util.f;

/* compiled from: source */
/* loaded from: classes.dex */
public class MainActivity extends AppCompatActivity {
    private static final String k = "MainActivity";
    private Context l;
    private com.jumobile.manager.systemapp.ui.fragment.c m;
    private int n;
    private DrawerLayout p;
    private com.jumobile.manager.systemapp.ui.a.e r;
    private com.jumobile.manager.systemapp.inappbilling.a o = new com.jumobile.manager.systemapp.inappbilling.a();
    private boolean q = true;

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = getApplicationContext();
        com.jumobile.manager.systemapp.util.e.a(this.l).a(k);
        if (!com.jumobile.manager.systemapp.util.d.a(this.l)) {
            finish();
        }
        t();
        s();
        this.o.a(this);
    }

    private void r() {
        int a = com.jumobile.manager.systemapp.f.a.a(this.l, "settings_home_page", 1);
        if (this.m == null || a != this.n) {
            this.n = a;
            switch (a) {
                case 1:
                    this.m = new h();
                    break;
                case 2:
                    this.m = new i();
                    break;
                case 3:
                    this.m = new com.jumobile.manager.systemapp.ui.fragment.b();
                    break;
                case 4:
                    this.m = d(1);
                    break;
                case 5:
                    this.m = d(2);
                    break;
            }
            this.m.as();
            m().a().b(R.id.content_frame, this.m).b();
        }
    }

    private com.jumobile.manager.systemapp.ui.fragment.c d(int i) {
        if (7 >= Build.VERSION.SDK_INT || f.a()) {
            com.jumobile.manager.systemapp.ui.fragment.d dVar = new com.jumobile.manager.systemapp.ui.fragment.d();
            int i2 = R.string.move_app_title_to_sdcard;
            switch (i) {
                case 2:
                    i2 = R.string.move_app_title_to_phone;
                    break;
            }
            if (f.a()) {
                dVar.a(i2, R.string.move_app_empty_view_below_sdcard_emulate_content, R.string.move_app_empty_view_below_sdcard_emulate_hint);
                return dVar;
            }
            dVar.a(i2, R.string.move_app_empty_view_below_not_support_content, R.string.move_app_empty_view_below_not_support_hint);
            return dVar;
        }
        com.jumobile.manager.systemapp.ui.fragment.f fVar = new com.jumobile.manager.systemapp.ui.fragment.f();
        fVar.e(i);
        return fVar;
    }

    private void s() {
        setContentView(R.layout.activity_main);
        this.p = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    private void t() {
        try {
            com.jumobile.manager.systemapp.h.a.a = false;
            com.jumobile.manager.systemapp.a.b.k(this);
        } catch (Exception unused) {
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        r();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.o.a();
        com.jumobile.manager.systemapp.a.b.l(this);
        com.jumobile.manager.systemapp.util.e.a(this.l).b(k);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1) {
            return true;
        }
        if (i != 4) {
            if (i == 82) {
                n();
                return true;
            }
            return super.onKeyUp(i, keyEvent);
        }
        if (!this.p.e()) {
            this.p.c();
        } else if (this.m.av()) {
            this.q = false;
        } else if (this.q) {
            if (this.r != null && this.r.isShowing()) {
                this.r.dismiss();
            } else {
                y();
                this.q = false;
            }
        } else {
            finish();
        }
        return true;
    }

    public void n() {
        if (this.p.e()) {
            this.p.d();
        } else {
            this.p.c();
        }
    }

    private void u() {
        this.r = new com.jumobile.manager.systemapp.ui.a.e(this, R.string.app_exit_dialog_type_support);
        this.r.i.setVisibility(0);
        this.r.i.setText(R.string.app_exit_dialog_no_remind_text);
        this.r.i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.1
            AnonymousClass1() {
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                com.jumobile.manager.systemapp.f.a.b(MainActivity.this.l, "app_exit_dialog_type", z ? 3 : 1);
            }
        });
        this.r.d.setText(R.string.app_exit_dialog_title);
        this.r.g.setText(R.string.app_exit_dialog_button_support);
        this.r.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.12
            AnonymousClass12() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.p();
            }
        });
        this.r.h.setText(R.string.app_exit_dialog_button_exit);
        this.r.h.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.14
            AnonymousClass14() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MainActivity.this.r == null || !MainActivity.this.r.isShowing()) {
                    return;
                }
                MainActivity.this.r.dismiss();
                MainActivity.this.finish();
            }
        });
        this.r.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.15
            AnonymousClass15() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                MainActivity.this.r = null;
            }
        });
        this.r.show();
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$1 */
    class AnonymousClass1 implements CompoundButton.OnCheckedChangeListener {
        AnonymousClass1() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            com.jumobile.manager.systemapp.f.a.b(MainActivity.this.l, "app_exit_dialog_type", z ? 3 : 1);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$12 */
    class AnonymousClass12 implements View.OnClickListener {
        AnonymousClass12() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.p();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$14 */
    class AnonymousClass14 implements View.OnClickListener {
        AnonymousClass14() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MainActivity.this.r == null || !MainActivity.this.r.isShowing()) {
                return;
            }
            MainActivity.this.r.dismiss();
            MainActivity.this.finish();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$15 */
    class AnonymousClass15 implements DialogInterface.OnDismissListener {
        AnonymousClass15() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            MainActivity.this.r = null;
        }
    }

    private void v() {
        this.r = new com.jumobile.manager.systemapp.ui.a.e(this, R.string.ads_remove_ads_dialog_content);
        this.r.i.setVisibility(0);
        this.r.i.setText(R.string.app_exit_dialog_no_remind_text);
        this.r.i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.16
            AnonymousClass16() {
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                com.jumobile.manager.systemapp.f.a.b(MainActivity.this.l, "app_exit_dialog_type", z ? 3 : 1);
            }
        });
        this.r.d.setText(R.string.app_exit_dialog_title);
        this.r.g.setText(R.string.ads_remove_ads_btn_text);
        this.r.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.17
            AnonymousClass17() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.jumobile.manager.systemapp.a.b.j(MainActivity.this);
                if (MainActivity.this.r == null || !MainActivity.this.r.isShowing()) {
                    return;
                }
                MainActivity.this.r.dismiss();
            }
        });
        this.r.h.setText(R.string.app_exit_dialog_button_exit);
        this.r.h.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.18
            AnonymousClass18() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MainActivity.this.r == null || !MainActivity.this.r.isShowing()) {
                    return;
                }
                MainActivity.this.r.dismiss();
                MainActivity.this.finish();
            }
        });
        this.r.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.19
            AnonymousClass19() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                MainActivity.this.r = null;
            }
        });
        this.r.show();
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$16 */
    class AnonymousClass16 implements CompoundButton.OnCheckedChangeListener {
        AnonymousClass16() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            com.jumobile.manager.systemapp.f.a.b(MainActivity.this.l, "app_exit_dialog_type", z ? 3 : 1);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$17 */
    class AnonymousClass17 implements View.OnClickListener {
        AnonymousClass17() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.jumobile.manager.systemapp.a.b.j(MainActivity.this);
            if (MainActivity.this.r == null || !MainActivity.this.r.isShowing()) {
                return;
            }
            MainActivity.this.r.dismiss();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$18 */
    class AnonymousClass18 implements View.OnClickListener {
        AnonymousClass18() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MainActivity.this.r == null || !MainActivity.this.r.isShowing()) {
                return;
            }
            MainActivity.this.r.dismiss();
            MainActivity.this.finish();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$19 */
    class AnonymousClass19 implements DialogInterface.OnDismissListener {
        AnonymousClass19() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            MainActivity.this.r = null;
        }
    }

    private void w() {
        this.r = new com.jumobile.manager.systemapp.ui.a.e(this, R.string.ads_recommend_dialog_content);
        this.r.i.setVisibility(0);
        this.r.i.setText(R.string.app_exit_dialog_no_remind_text);
        this.r.i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.20
            AnonymousClass20() {
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                com.jumobile.manager.systemapp.f.a.b(MainActivity.this.l, "app_exit_dialog_type", z ? 3 : 4);
            }
        });
        this.r.d.setText(R.string.app_exit_dialog_title);
        this.r.g.setText(R.string.ads_recommend_btn_show);
        this.r.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.jumobile.manager.systemapp.a.b.f(MainActivity.this);
                if (MainActivity.this.r == null || !MainActivity.this.r.isShowing()) {
                    return;
                }
                MainActivity.this.r.dismiss();
            }
        });
        this.r.h.setText(R.string.app_exit_dialog_button_exit);
        this.r.h.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.3
            AnonymousClass3() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MainActivity.this.r == null || !MainActivity.this.r.isShowing()) {
                    return;
                }
                MainActivity.this.r.dismiss();
                MainActivity.this.finish();
            }
        });
        this.r.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.4
            AnonymousClass4() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                MainActivity.this.r = null;
            }
        });
        this.r.show();
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$20 */
    class AnonymousClass20 implements CompoundButton.OnCheckedChangeListener {
        AnonymousClass20() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            com.jumobile.manager.systemapp.f.a.b(MainActivity.this.l, "app_exit_dialog_type", z ? 3 : 4);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$2 */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.jumobile.manager.systemapp.a.b.f(MainActivity.this);
            if (MainActivity.this.r == null || !MainActivity.this.r.isShowing()) {
                return;
            }
            MainActivity.this.r.dismiss();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$3 */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MainActivity.this.r == null || !MainActivity.this.r.isShowing()) {
                return;
            }
            MainActivity.this.r.dismiss();
            MainActivity.this.finish();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$4 */
    class AnonymousClass4 implements DialogInterface.OnDismissListener {
        AnonymousClass4() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            MainActivity.this.r = null;
        }
    }

    private void x() {
        this.r = new com.jumobile.manager.systemapp.ui.a.e(this, this.l.getString(R.string.google_iap_purchase_pro_detail, com.jumobile.manager.systemapp.f.a.a(this.l, "price_pro_edition", "$1.99")));
        this.r.i.setVisibility(0);
        this.r.i.setText(R.string.app_exit_dialog_no_remind_text);
        this.r.i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.5
            AnonymousClass5() {
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                com.jumobile.manager.systemapp.f.a.b(MainActivity.this.l, "app_exit_dialog_type", z ? 3 : 5);
            }
        });
        this.r.d.setText(R.string.app_exit_dialog_title);
        this.r.g.setText(R.string.ads_remove_ads_btn_text);
        this.r.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.6
            AnonymousClass6() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.o.b();
                if (MainActivity.this.r == null || !MainActivity.this.r.isShowing()) {
                    return;
                }
                MainActivity.this.r.dismiss();
            }
        });
        this.r.h.setText(R.string.app_exit_dialog_button_exit);
        this.r.h.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.7
            AnonymousClass7() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MainActivity.this.r == null || !MainActivity.this.r.isShowing()) {
                    return;
                }
                MainActivity.this.r.dismiss();
                MainActivity.this.finish();
            }
        });
        this.r.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.8
            AnonymousClass8() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                MainActivity.this.r = null;
            }
        });
        this.r.show();
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$5 */
    class AnonymousClass5 implements CompoundButton.OnCheckedChangeListener {
        AnonymousClass5() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            com.jumobile.manager.systemapp.f.a.b(MainActivity.this.l, "app_exit_dialog_type", z ? 3 : 5);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$6 */
    class AnonymousClass6 implements View.OnClickListener {
        AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.o.b();
            if (MainActivity.this.r == null || !MainActivity.this.r.isShowing()) {
                return;
            }
            MainActivity.this.r.dismiss();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$7 */
    class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MainActivity.this.r == null || !MainActivity.this.r.isShowing()) {
                return;
            }
            MainActivity.this.r.dismiss();
            MainActivity.this.finish();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$8 */
    class AnonymousClass8 implements DialogInterface.OnDismissListener {
        AnonymousClass8() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            MainActivity.this.r = null;
        }
    }

    private void y() {
        switch (com.jumobile.manager.systemapp.f.a.a(this.l, "app_exit_dialog_type", 3)) {
            case 1:
                if (com.jumobile.manager.systemapp.a.b.h(this) && com.jumobile.manager.systemapp.a.b.i(this) <= 0) {
                    v();
                    break;
                } else {
                    u();
                    break;
                }
            case 2:
                this.r = new com.jumobile.manager.systemapp.ui.a.e(this, R.string.app_exit_dialog_type_share);
                this.r.i.setVisibility(0);
                this.r.i.setText(R.string.app_exit_dialog_no_remind_text);
                this.r.i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.9
                    AnonymousClass9() {
                    }

                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        com.jumobile.manager.systemapp.f.a.b(MainActivity.this.l, "app_exit_dialog_type", z ? 3 : 2);
                    }
                });
                this.r.d.setText(R.string.app_exit_dialog_title);
                this.r.g.setText(R.string.app_exit_dialog_button_share);
                this.r.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.10
                    AnonymousClass10() {
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MainActivity.this.o();
                    }
                });
                this.r.h.setText(R.string.app_exit_dialog_button_exit);
                this.r.h.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.11
                    AnonymousClass11() {
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (MainActivity.this.r == null || !MainActivity.this.r.isShowing()) {
                            return;
                        }
                        MainActivity.this.r.dismiss();
                        MainActivity.this.finish();
                    }
                });
                this.r.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.jumobile.manager.systemapp.ui.activity.MainActivity.13
                    AnonymousClass13() {
                    }

                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        MainActivity.this.r = null;
                    }
                });
                this.r.show();
                break;
            case 3:
                finish();
                break;
            case 4:
                w();
                break;
            case 5:
                if (com.jumobile.manager.systemapp.f.a.a(this.l, "ads_enabled", true)) {
                    x();
                    break;
                } else {
                    finish();
                    break;
                }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$9 */
    class AnonymousClass9 implements CompoundButton.OnCheckedChangeListener {
        AnonymousClass9() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            com.jumobile.manager.systemapp.f.a.b(MainActivity.this.l, "app_exit_dialog_type", z ? 3 : 2);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$10 */
    class AnonymousClass10 implements View.OnClickListener {
        AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.o();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$11 */
    class AnonymousClass11 implements View.OnClickListener {
        AnonymousClass11() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MainActivity.this.r == null || !MainActivity.this.r.isShowing()) {
                return;
            }
            MainActivity.this.r.dismiss();
            MainActivity.this.finish();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.MainActivity$13 */
    class AnonymousClass13 implements DialogInterface.OnDismissListener {
        AnonymousClass13() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            MainActivity.this.r = null;
        }
    }

    public void o() {
        try {
            String a = com.jumobile.manager.systemapp.e.a.a(this.l, "share_app_text");
            if (TextUtils.isEmpty(a)) {
                a = getString(R.string.share_app_default_text, new Object[]{getString(R.string.app_name), TextUtils.isEmpty("") ? String.format("https://play.google.com/store/apps/details?id=%s", getPackageName()) : ""});
            }
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", a);
            intent.setType("text/plain");
            intent.addFlags(268435456);
            startActivity(Intent.createChooser(intent, getString(R.string.share_app_default_title)));
        } catch (Exception unused) {
        }
    }

    public void p() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName()));
            intent.addFlags(268435456);
            startActivity(intent);
            com.jumobile.manager.systemapp.f.a.b(this.l, "app_exit_dialog_type", 2);
        } catch (Exception unused) {
        }
    }

    public void q() {
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 6) {
            this.o.a(i, i2, intent);
        }
        try {
            this.m.a(i, i2, intent);
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.a.InterfaceC0017a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        try {
            this.m.a(i, strArr, iArr);
        } catch (Exception unused) {
        }
    }
}
