package com.jumobile.manager.systemapp.ui.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.jumobile.manager.systemapp.R;
import com.jumobile.manager.systemapp.c.f;
import com.jumobile.manager.systemapp.ui.widget.ActionBar;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public class SettingsActivity extends Activity implements View.OnClickListener {
    private static final String a = "SettingsActivity";
    private Context b;
    private b c = null;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = getApplicationContext();
        com.jumobile.manager.systemapp.util.e.a(this.b).a(a);
        setContentView(R.layout.activity_settings);
        b();
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.SettingsActivity$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SettingsActivity.this.finish();
            SettingsActivity.this.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
        }
    }

    private void b() {
        ((ActionBar) findViewById(R.id.action_bar)).a.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.SettingsActivity.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingsActivity.this.finish();
                SettingsActivity.this.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
            }
        });
        findViewById(R.id.setting_home_container).setOnClickListener(this);
        c();
        if (com.jumobile.manager.systemapp.a.b.a(this)) {
            findViewById(R.id.setting_common_remove_ads_container).setOnClickListener(this);
            d();
        } else {
            findViewById(R.id.setting_common_remove_ads_container).setVisibility(8);
            findViewById(R.id.setting_common_remove_ads_divider).setVisibility(8);
        }
        findViewById(R.id.version_container).setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.version);
        try {
            textView.setText(this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 0).versionName);
        } catch (Exception unused) {
            textView.setText(R.string.settings_version);
        }
        findViewById(R.id.hide_core_container).setOnClickListener(this);
        findViewById(R.id.system_app_recycle_bin_path_container).setOnClickListener(this);
        findViewById(R.id.system_app_auto_backup_container).setOnClickListener(this);
        e();
        g();
        f();
        findViewById(R.id.user_app_backup_path_container).setOnClickListener(this);
        findViewById(R.id.user_app_backup_name_container).setOnClickListener(this);
        findViewById(R.id.user_app_auto_backup_container).setOnClickListener(this);
        h();
        j();
        i();
    }

    public void c() {
        TextView textView = (TextView) findViewById(R.id.setting_home);
        switch (com.jumobile.manager.systemapp.f.a.a(this.b, "settings_home_page", 1)) {
            case 1:
                textView.setText(R.string.system_app_title);
                break;
            case 2:
                textView.setText(R.string.user_app_title);
                break;
            case 3:
                textView.setText(R.string.apk_file_title);
                break;
            case 4:
                textView.setText(R.string.move_app_title_to_sdcard);
                break;
            case 5:
                textView.setText(R.string.move_app_title_to_phone);
                break;
        }
    }

    private void d() {
        ((CheckBox) findViewById(R.id.setting_common_remove_ads_checkbox)).setChecked(!com.jumobile.manager.systemapp.a.b.b(this));
    }

    public void e() {
        ((CheckBox) findViewById(R.id.hide_core_checkbox)).setChecked(com.jumobile.manager.systemapp.f.a.a(this.b, "settings_system_app_hide_core", true));
    }

    private void f() {
        ((CheckBox) findViewById(R.id.system_app_auto_backup_checkbox)).setChecked(com.jumobile.manager.systemapp.f.a.a(this.b, "settings_system_app_auto_backup", true));
    }

    private void g() {
        ((TextView) findViewById(R.id.system_app_recycle_bin_path_content)).setText(com.jumobile.manager.systemapp.c.e.a(this.b));
    }

    private void h() {
        ((TextView) findViewById(R.id.user_app_backup_path_content)).setText(f.a(this.b));
    }

    private void i() {
        ((CheckBox) findViewById(R.id.user_app_auto_backup_checkbox)).setChecked(com.jumobile.manager.systemapp.f.a.a(this.b, "settings_user_app_auto_backup", false));
    }

    public void j() {
        TextView textView = (TextView) findViewById(R.id.user_app_backup_name_content);
        int a2 = com.jumobile.manager.systemapp.f.a.a(this.b, "apk_name_config", 20);
        ArrayList arrayList = new ArrayList();
        if ((a2 & 2) != 0) {
            arrayList.add(this.b.getString(R.string.apk_name_config_app_name));
        }
        if ((a2 & 4) != 0) {
            arrayList.add(this.b.getString(R.string.apk_name_config_package_name));
        }
        if ((a2 & 8) != 0) {
            arrayList.add(this.b.getString(R.string.apk_name_config_version_name));
        }
        if ((a2 & 16) != 0) {
            arrayList.add(this.b.getString(R.string.apk_name_config_version_code));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            if (i > 0) {
                sb.append("_");
            }
            sb.append(str);
        }
        sb.append(".apk");
        textView.setText(sb);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.jumobile.manager.systemapp.util.e.a(this.b).b(a);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
        }
        switch (view.getId()) {
            case R.id.hide_core_container /* 2131230921 */:
                if (com.jumobile.manager.systemapp.f.a.a(this.b, "settings_system_app_hide_core", true)) {
                    com.jumobile.manager.systemapp.ui.a.e eVar = new com.jumobile.manager.systemapp.ui.a.e(this, R.string.settings_system_app_hide_core_warning);
                    eVar.setTitle(R.string.common_warning);
                    eVar.g.setBackgroundResource(R.drawable.selector_btn_warning);
                    eVar.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.SettingsActivity.4
                        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

                        AnonymousClass4(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                            eVar = eVar2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            eVar.dismiss();
                            com.jumobile.manager.systemapp.f.a.b(SettingsActivity.this.b, "settings_system_app_hide_core", false);
                            SettingsActivity.this.e();
                        }
                    });
                    if (!isFinishing()) {
                        eVar2.show();
                        break;
                    }
                } else {
                    com.jumobile.manager.systemapp.f.a.b(this.b, "settings_system_app_hide_core", true);
                    e();
                    break;
                }
                break;
            case R.id.setting_common_remove_ads_container /* 2131231052 */:
                if (com.jumobile.manager.systemapp.a.b.h(this) && com.jumobile.manager.systemapp.a.b.i(this) <= 0) {
                    com.jumobile.manager.systemapp.ui.a.e eVar2 = new com.jumobile.manager.systemapp.ui.a.e(this, R.string.ads_remove_ads_dialog_content);
                    eVar2.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.SettingsActivity.2
                        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

                        AnonymousClass2(com.jumobile.manager.systemapp.ui.a.e eVar22) {
                            eVar2 = eVar22;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            eVar2.dismiss();
                            com.jumobile.manager.systemapp.a.b.j(SettingsActivity.this);
                        }
                    });
                    eVar22.g.setText(R.string.ads_remove_ads_btn_text);
                    eVar22.h.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.SettingsActivity.3
                        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

                        AnonymousClass3(com.jumobile.manager.systemapp.ui.a.e eVar22) {
                            eVar2 = eVar22;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            eVar2.dismiss();
                        }
                    });
                    if (!isFinishing()) {
                        eVar22.show();
                        break;
                    }
                } else {
                    com.jumobile.manager.systemapp.a.b.c(this);
                    d();
                    break;
                }
                break;
            case R.id.setting_home_container /* 2131231055 */:
                a aVar = new a(this);
                if (!isFinishing()) {
                    aVar.show();
                    break;
                }
                break;
            case R.id.system_app_auto_backup_container /* 2131231083 */:
                com.jumobile.manager.systemapp.f.a.b(this.b, "settings_system_app_auto_backup", !com.jumobile.manager.systemapp.f.a.a(this.b, "settings_system_app_auto_backup", true));
                f();
                break;
            case R.id.system_app_recycle_bin_path_container /* 2131231084 */:
                startActivityForResult(new Intent(this, (Class<?>) DirectoryChooserActivity.class), 3);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                break;
            case R.id.user_app_auto_backup_container /* 2131231144 */:
                com.jumobile.manager.systemapp.f.a.b(this.b, "settings_user_app_auto_backup", !com.jumobile.manager.systemapp.f.a.a(this.b, "settings_user_app_auto_backup", false));
                i();
                break;
            case R.id.user_app_backup_name_container /* 2131231145 */:
                com.jumobile.manager.systemapp.ui.a.b bVar = new com.jumobile.manager.systemapp.ui.a.b(this);
                bVar.a(this.b.getString(R.string.common_yes));
                bVar.a(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.SettingsActivity.5
                    AnonymousClass5() {
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        SettingsActivity.this.j();
                    }
                });
                if (!isFinishing()) {
                    bVar.show();
                    break;
                }
                break;
            case R.id.user_app_backup_path_container /* 2131231149 */:
                startActivityForResult(new Intent(this, (Class<?>) DirectoryChooserActivity.class), 4);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                break;
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.SettingsActivity$2 */
    class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass2(com.jumobile.manager.systemapp.ui.a.e eVar22) {
            eVar2 = eVar22;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            eVar2.dismiss();
            com.jumobile.manager.systemapp.a.b.j(SettingsActivity.this);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.SettingsActivity$3 */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass3(com.jumobile.manager.systemapp.ui.a.e eVar22) {
            eVar2 = eVar22;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            eVar2.dismiss();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.SettingsActivity$4 */
    class AnonymousClass4 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass4(com.jumobile.manager.systemapp.ui.a.e eVar2) {
            eVar = eVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            eVar.dismiss();
            com.jumobile.manager.systemapp.f.a.b(SettingsActivity.this.b, "settings_system_app_hide_core", false);
            SettingsActivity.this.e();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.SettingsActivity$5 */
    class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SettingsActivity.this.j();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 3:
                if (i2 == -1) {
                    String a2 = com.jumobile.manager.systemapp.c.e.a(this.b);
                    String stringExtra = intent.getStringExtra("extra_directory");
                    if (!a2.equalsIgnoreCase(stringExtra) && this.c == null) {
                        this.c = new b(a2, stringExtra, R.string.settings_system_app_recycle_bin_path_title);
                        this.c.a(".apk.backup");
                        this.c.a(".odex.backup");
                        this.c.a(".conf.backup");
                        this.c.execute(new Integer[0]);
                    }
                    com.jumobile.manager.systemapp.f.a.b(this.b, "settings_system_app_recycle_bin_path", stringExtra);
                    g();
                    break;
                }
                break;
            case 4:
                if (i2 == -1) {
                    String a3 = f.a(this.b);
                    String stringExtra2 = intent.getStringExtra("extra_directory");
                    if (!a3.equalsIgnoreCase(stringExtra2) && this.c == null) {
                        this.c = new b(a3, stringExtra2, R.string.user_app_backup_path_path_title);
                        this.c.a(".apk");
                        this.c.execute(new Integer[0]);
                    }
                    com.jumobile.manager.systemapp.f.a.b(this.b, "settings_user_app_backup_path", stringExtra2);
                    h();
                    break;
                }
                break;
        }
    }

    /* compiled from: source */
    private class a extends Dialog implements DialogInterface.OnKeyListener, View.OnClickListener {
        public a(Context context) {
            super(context, R.style.BaseDialog);
            setContentView(R.layout.dialog_menu_settings_home_page);
            setCancelable(false);
            setCanceledOnTouchOutside(false);
            setOnKeyListener(this);
            findViewById(R.id.home_page_system_app).setOnClickListener(this);
            findViewById(R.id.home_page_user_app).setOnClickListener(this);
            findViewById(R.id.home_page_move_to_sdcard).setOnClickListener(this);
            findViewById(R.id.home_page_move_to_phone).setOnClickListener(this);
            findViewById(R.id.home_page_apk_manager).setOnClickListener(this);
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 1) {
                return true;
            }
            if (i != 4) {
                return false;
            }
            dismiss();
            return true;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null) {
            }
            switch (view.getId()) {
                case R.id.home_page_apk_manager /* 2131230925 */:
                    com.jumobile.manager.systemapp.f.a.b(SettingsActivity.this.b, "settings_home_page", 3);
                    SettingsActivity.this.c();
                    dismiss();
                    break;
                case R.id.home_page_move_to_phone /* 2131230926 */:
                    com.jumobile.manager.systemapp.f.a.b(SettingsActivity.this.b, "settings_home_page", 5);
                    SettingsActivity.this.c();
                    dismiss();
                    break;
                case R.id.home_page_move_to_sdcard /* 2131230927 */:
                    com.jumobile.manager.systemapp.f.a.b(SettingsActivity.this.b, "settings_home_page", 4);
                    SettingsActivity.this.c();
                    dismiss();
                    break;
                case R.id.home_page_system_app /* 2131230928 */:
                    com.jumobile.manager.systemapp.f.a.b(SettingsActivity.this.b, "settings_home_page", 1);
                    SettingsActivity.this.c();
                    dismiss();
                    break;
                case R.id.home_page_user_app /* 2131230929 */:
                    com.jumobile.manager.systemapp.f.a.b(SettingsActivity.this.b, "settings_home_page", 2);
                    SettingsActivity.this.c();
                    dismiss();
                    break;
            }
        }
    }

    /* compiled from: source */
    private class b extends AsyncTask<Integer, Integer, Integer> {
        private final String b;
        private final String c;
        private final String d;
        private ArrayList<String> e = new ArrayList<>();
        private com.jumobile.manager.systemapp.ui.a.f f = null;
        private final int g = 1;
        private final int h = 0;
        private int i = 0;

        public b(String str, String str2, int i) {
            this.b = str;
            this.c = str2;
            this.d = SettingsActivity.this.getString(i);
        }

        public void a(String str) {
            this.e.add(str);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x007f A[SYNTHETIC] */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Integer doInBackground(java.lang.Integer... r11) {
            /*
                r10 = this;
                java.io.File r11 = new java.io.File
                java.lang.String r0 = r10.b
                r11.<init>(r0)
                boolean r0 = r11.exists()
                r1 = 2
                r2 = 3
                r3 = 0
                r4 = 1
                if (r0 == 0) goto L81
                java.io.File[] r11 = r11.listFiles()
                if (r11 == 0) goto L81
                int r0 = r11.length
                r5 = r3
            L19:
                int r6 = r11.length
                if (r5 >= r6) goto L81
                java.lang.Integer[] r6 = new java.lang.Integer[r2]
                java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
                r6[r3] = r7
                int r7 = r5 + 1
                java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
                r6[r4] = r8
                java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
                r6[r1] = r8
                r10.publishProgress(r6)
                r5 = r11[r5]
                java.lang.String r6 = r5.getPath()
                java.util.ArrayList<java.lang.String> r8 = r10.e
                int r8 = r8.size()
                if (r8 <= 0) goto L5e
                java.util.ArrayList<java.lang.String> r8 = r10.e
                java.util.Iterator r8 = r8.iterator()
            L49:
                boolean r9 = r8.hasNext()
                if (r9 == 0) goto L5c
                java.lang.Object r9 = r8.next()
                java.lang.String r9 = (java.lang.String) r9
                boolean r9 = r6.endsWith(r9)
                if (r9 == 0) goto L49
                goto L5e
            L5c:
                r8 = r3
                goto L5f
            L5e:
                r8 = r4
            L5f:
                if (r8 == 0) goto L7f
                java.lang.String r8 = r10.b
                java.lang.String r9 = r10.c
                java.lang.String r8 = r6.replace(r8, r9)
                java.io.File r9 = new java.io.File
                r9.<init>(r8)
                boolean r9 = r5.renameTo(r9)
                if (r9 != 0) goto L7a
                com.jumobile.manager.systemapp.util.a.a(r6, r8)
                r5.delete()
            L7a:
                int r5 = r10.i
                int r5 = r5 + r4
                r10.i = r5
            L7f:
                r5 = r7
                goto L19
            L81:
                java.lang.Integer[] r11 = new java.lang.Integer[r2]
                java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
                r11[r3] = r0
                r0 = 100
                java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
                r11[r4] = r2
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                r11[r1] = r0
                r10.publishProgress(r11)
                java.lang.Integer r11 = java.lang.Integer.valueOf(r3)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumobile.manager.systemapp.ui.activity.SettingsActivity.b.doInBackground(java.lang.Integer[]):java.lang.Integer");
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            this.f = new com.jumobile.manager.systemapp.ui.a.f(SettingsActivity.this);
            this.f.a(0, 100);
            this.f.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.jumobile.manager.systemapp.ui.activity.SettingsActivity.b.1
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return false;
                }

                AnonymousClass1() {
                }
            });
            this.f.setCancelable(false);
            this.f.i.setVisibility(4);
            this.f.f.setVisibility(8);
            if (SettingsActivity.this.isFinishing()) {
                return;
            }
            this.f.show();
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.activity.SettingsActivity$b$1 */
        class AnonymousClass1 implements DialogInterface.OnKeyListener {
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }

            AnonymousClass1() {
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (numArr[0].intValue() == 1) {
                this.f.a(numArr[1].intValue(), numArr[2].intValue());
                this.f.a(SettingsActivity.this.getString(R.string.move_app_move_entry, new Object[]{this.d}));
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            try {
                this.f.dismiss();
            } catch (Exception e) {
                Log.w(SettingsActivity.a, "Failed to dismiss mProgressDialog: " + e.getMessage());
            }
            SettingsActivity.this.c = null;
            com.jumobile.manager.systemapp.util.f.m(SettingsActivity.this.b, SettingsActivity.this.getString(R.string.move_file_done_toast, new Object[]{Integer.valueOf(this.i)}));
        }
    }
}
