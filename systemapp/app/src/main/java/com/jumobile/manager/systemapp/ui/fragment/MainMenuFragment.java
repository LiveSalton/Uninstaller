package com.jumobile.manager.systemapp.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.jumobile.manager.systemapp.R;
import com.jumobile.manager.systemapp.ui.activity.ApkFileActivity;
import com.jumobile.manager.systemapp.ui.activity.FeedBackActivity;
import com.jumobile.manager.systemapp.ui.activity.MainActivity;
import com.jumobile.manager.systemapp.ui.activity.MoveAppActivity;
import com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity;
import com.jumobile.manager.systemapp.ui.activity.RootHelpActivity;
import com.jumobile.manager.systemapp.ui.activity.SettingsActivity;
import com.jumobile.manager.systemapp.ui.activity.SystemAppActivity;
import com.jumobile.manager.systemapp.ui.activity.ThanksActivity;
import com.jumobile.manager.systemapp.ui.activity.UserAppActivity;
import com.jumobile.manager.systemapp.ui.activity.WebPageActivity;

/* compiled from: source */
/* loaded from: classes.dex */
public class MainMenuFragment extends c implements View.OnClickListener {
    private static final String U = "MainMenuFragment";
    private Context X;

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
        super.K();
    }

    @Override // androidx.fragment.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_main_menu, viewGroup, false);
        d(inflate);
        this.W = true;
        if (this.V) {
            as();
        }
        return inflate;
    }

    private void d(View view) {
        view.findViewById(R.id.menu_item_recycle_bin).setOnClickListener(this);
        view.findViewById(R.id.menu_item_system_app).setOnClickListener(this);
        view.findViewById(R.id.menu_item_normal_app).setOnClickListener(this);
        view.findViewById(R.id.menu_item_move_to_sdcard).setOnClickListener(this);
        view.findViewById(R.id.menu_item_move_to_phone).setOnClickListener(this);
        view.findViewById(R.id.menu_item_apk_file).setOnClickListener(this);
        view.findViewById(R.id.menu_item_settings).setOnClickListener(this);
        if (com.jumobile.manager.systemapp.a.b.d(m())) {
            view.findViewById(R.id.menu_item_recommend_app).setOnClickListener(this);
        } else {
            view.findViewById(R.id.menu_item_recommend_app).setVisibility(8);
            view.findViewById(R.id.menu_item_recommend_app_divider).setVisibility(8);
        }
        if (com.jumobile.manager.systemapp.a.b.e(m())) {
            view.findViewById(R.id.menu_item_recommend_game).setOnClickListener(this);
        } else {
            view.findViewById(R.id.menu_item_recommend_game).setVisibility(8);
            view.findViewById(R.id.menu_item_recommend_game_divider).setVisibility(8);
        }
        if (com.jumobile.manager.systemapp.e.a.a(this.X, "get_pro_edition_enable", true)) {
            view.findViewById(R.id.menu_item_get_pro_edition).setOnClickListener(this);
            view.findViewById(R.id.menu_item_get_pro_edition).setVisibility(0);
            view.findViewById(R.id.menu_item_get_pro_edition_divider).setVisibility(0);
        }
        view.findViewById(R.id.menu_item_feedback).setOnClickListener(this);
        view.findViewById(R.id.menu_item_root_help).setOnClickListener(this);
        view.findViewById(R.id.menu_item_share).setOnClickListener(this);
        view.findViewById(R.id.menu_item_review).setOnClickListener(this);
        view.findViewById(R.id.menu_item_thanks).setOnClickListener(this);
        view.findViewById(R.id.menu_item_terms_service).setOnClickListener(this);
        view.findViewById(R.id.menu_item_privacy_policy).setOnClickListener(this);
        view.findViewById(R.id.menu_item_exit).setOnClickListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void J() {
        this.W = false;
        super.J();
    }

    @Override // com.jumobile.manager.systemapp.ui.fragment.c
    public void as() {
        super.as();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentActivity m;
        if (view == null || (m = m()) == null || !(m instanceof MainActivity)) {
            return;
        }
        switch (view.getId()) {
            case R.id.menu_item_apk_file /* 2131230958 */:
                a(new Intent(m, (Class<?>) ApkFileActivity.class));
                ((MainActivity) m).q();
                com.jumobile.manager.systemapp.f.a.b(this.X, "settings_home_page", 3);
                break;
            case R.id.menu_item_exit /* 2131230959 */:
                ((MainActivity) m).finish();
                break;
            case R.id.menu_item_feedback /* 2131230960 */:
                a(new Intent(m, (Class<?>) FeedBackActivity.class));
                ((MainActivity) m).overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                break;
            case R.id.menu_item_get_pro_edition /* 2131230961 */:
                try {
                    String a = com.jumobile.manager.systemapp.e.a.a(this.X, "get_pro_edition_package");
                    if (TextUtils.isEmpty(a)) {
                        a = "com.jumobile.manager.systemapp.pro";
                    }
                    a(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + a)));
                    break;
                } catch (Exception unused) {
                    return;
                }
            case R.id.menu_item_move_to_phone /* 2131230963 */:
                a(new Intent(m, (Class<?>) MoveAppActivity.class).putExtra("extra_type", 2));
                ((MainActivity) m).q();
                com.jumobile.manager.systemapp.f.a.b(this.X, "settings_home_page", 5);
                break;
            case R.id.menu_item_move_to_sdcard /* 2131230964 */:
                a(new Intent(m, (Class<?>) MoveAppActivity.class).putExtra("extra_type", 1));
                ((MainActivity) m).q();
                com.jumobile.manager.systemapp.f.a.b(this.X, "settings_home_page", 4);
                break;
            case R.id.menu_item_normal_app /* 2131230965 */:
                a(new Intent(m, (Class<?>) UserAppActivity.class));
                ((MainActivity) m).q();
                com.jumobile.manager.systemapp.f.a.b(this.X, "settings_home_page", 2);
                break;
            case R.id.menu_item_privacy_policy /* 2131230966 */:
                Intent intent = new Intent(this.X, (Class<?>) WebPageActivity.class);
                intent.putExtra("extra_url", "http://www.multiabc.com/wp-content/uploads/privacy_policy_system_app_remover.html");
                a(intent);
                ((MainActivity) m).overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                break;
            case R.id.menu_item_recommend_app /* 2131230967 */:
                com.jumobile.manager.systemapp.a.b.f(m);
                ((MainActivity) m).overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                break;
            case R.id.menu_item_recommend_game /* 2131230969 */:
                com.jumobile.manager.systemapp.a.b.g(m);
                ((MainActivity) m).overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                break;
            case R.id.menu_item_recycle_bin /* 2131230971 */:
                a(new Intent(m, (Class<?>) RecycleBinActivity.class));
                ((MainActivity) m).q();
                break;
            case R.id.menu_item_review /* 2131230972 */:
                ((MainActivity) m).p();
                break;
            case R.id.menu_item_root_help /* 2131230973 */:
                a(new Intent(m, (Class<?>) RootHelpActivity.class));
                ((MainActivity) m).q();
                break;
            case R.id.menu_item_settings /* 2131230974 */:
                a(new Intent(m, (Class<?>) SettingsActivity.class));
                ((MainActivity) m).overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                break;
            case R.id.menu_item_share /* 2131230975 */:
                ((MainActivity) m).o();
                break;
            case R.id.menu_item_system_app /* 2131230976 */:
                a(new Intent(m, (Class<?>) SystemAppActivity.class));
                ((MainActivity) m).q();
                com.jumobile.manager.systemapp.f.a.b(this.X, "settings_home_page", 1);
                break;
            case R.id.menu_item_terms_service /* 2131230977 */:
                Intent intent2 = new Intent(this.X, (Class<?>) WebPageActivity.class);
                intent2.putExtra("extra_url", "http://www.multiabc.com/wp-content/uploads/terms_service_system_app_remover.html");
                a(intent2);
                ((MainActivity) m).overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                break;
            case R.id.menu_item_thanks /* 2131230978 */:
                a(new Intent(m, (Class<?>) ThanksActivity.class));
                ((MainActivity) m).overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void G() {
        super.G();
    }
}
