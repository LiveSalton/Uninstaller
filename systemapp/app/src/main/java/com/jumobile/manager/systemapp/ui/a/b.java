package com.jumobile.manager.systemapp.ui.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.jumobile.manager.systemapp.R;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public class b extends Dialog implements DialogInterface.OnKeyListener, View.OnClickListener {
    private static final String a = "b";
    private final Context b;
    private CheckBox c;
    private CheckBox d;
    private CheckBox e;
    private CheckBox f;
    private TextView g;
    private Button h;
    private String i;
    private View.OnClickListener j;

    public b(Context context) {
        super(context, R.style.BaseDialog);
        this.b = context;
        setContentView(R.layout.dialog_apk_name_config);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setOnKeyListener(this);
        a();
    }

    public void a(String str) {
        this.i = str;
        if (this.h != null) {
            this.h.setText(this.i);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    private void a() {
        this.c = (CheckBox) findViewById(R.id.apk_name_config_app_name);
        this.d = (CheckBox) findViewById(R.id.apk_name_config_package_name);
        this.e = (CheckBox) findViewById(R.id.apk_name_config_version_name);
        this.f = (CheckBox) findViewById(R.id.apk_name_config_version_code);
        this.g = (TextView) findViewById(R.id.preview);
        this.h = (Button) findViewById(R.id.btn_batch_rename);
        if (!TextUtils.isEmpty(this.i)) {
            this.h.setText(this.i);
        }
        b();
        this.c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.a.b.1
            AnonymousClass1() {
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(b.this.b, "apk_name_config", 20);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(b.this.b, "apk_name_config", a2 | 2);
                } else if (b.this.d.isChecked()) {
                    com.jumobile.manager.systemapp.f.a.b(b.this.b, "apk_name_config", a2 & (-3));
                } else {
                    com.jumobile.manager.systemapp.util.f.m(b.this.b, b.this.b.getString(R.string.apk_name_config_app_name) + "\n" + b.this.b.getString(R.string.apk_name_config_package_name) + "\n" + b.this.b.getString(R.string.common_at_least_one));
                }
                b.this.b();
            }
        });
        this.d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.a.b.2
            AnonymousClass2() {
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(b.this.b, "apk_name_config", 20);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(b.this.b, "apk_name_config", a2 | 4);
                } else if (b.this.c.isChecked()) {
                    com.jumobile.manager.systemapp.f.a.b(b.this.b, "apk_name_config", a2 & (-5));
                } else {
                    com.jumobile.manager.systemapp.util.f.m(b.this.b, b.this.b.getString(R.string.apk_name_config_app_name) + "\n" + b.this.b.getString(R.string.apk_name_config_package_name) + "\n" + b.this.b.getString(R.string.common_at_least_one));
                }
                b.this.b();
            }
        });
        this.e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.a.b.3
            AnonymousClass3() {
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(b.this.b, "apk_name_config", 20);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(b.this.b, "apk_name_config", a2 | 8);
                } else if (b.this.f.isChecked()) {
                    com.jumobile.manager.systemapp.f.a.b(b.this.b, "apk_name_config", a2 & (-9));
                } else {
                    com.jumobile.manager.systemapp.util.f.m(b.this.b, b.this.b.getString(R.string.apk_name_config_version_name) + "\n" + b.this.b.getString(R.string.apk_name_config_version_code) + "\n" + b.this.b.getString(R.string.common_at_least_one));
                }
                b.this.b();
            }
        });
        this.f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.a.b.4
            AnonymousClass4() {
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(b.this.b, "apk_name_config", 20);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(b.this.b, "apk_name_config", a2 | 16);
                } else if (b.this.e.isChecked()) {
                    com.jumobile.manager.systemapp.f.a.b(b.this.b, "apk_name_config", a2 & (-17));
                } else {
                    com.jumobile.manager.systemapp.util.f.m(b.this.b, b.this.b.getString(R.string.apk_name_config_version_name) + "\n" + b.this.b.getString(R.string.apk_name_config_version_code) + "\n" + b.this.b.getString(R.string.common_at_least_one));
                }
                b.this.b();
            }
        });
        this.h.setOnClickListener(this);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.a.b$1 */
    class AnonymousClass1 implements CompoundButton.OnCheckedChangeListener {
        AnonymousClass1() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            int a2 = com.jumobile.manager.systemapp.f.a.a(b.this.b, "apk_name_config", 20);
            if (z) {
                com.jumobile.manager.systemapp.f.a.b(b.this.b, "apk_name_config", a2 | 2);
            } else if (b.this.d.isChecked()) {
                com.jumobile.manager.systemapp.f.a.b(b.this.b, "apk_name_config", a2 & (-3));
            } else {
                com.jumobile.manager.systemapp.util.f.m(b.this.b, b.this.b.getString(R.string.apk_name_config_app_name) + "\n" + b.this.b.getString(R.string.apk_name_config_package_name) + "\n" + b.this.b.getString(R.string.common_at_least_one));
            }
            b.this.b();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.a.b$2 */
    class AnonymousClass2 implements CompoundButton.OnCheckedChangeListener {
        AnonymousClass2() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            int a2 = com.jumobile.manager.systemapp.f.a.a(b.this.b, "apk_name_config", 20);
            if (z) {
                com.jumobile.manager.systemapp.f.a.b(b.this.b, "apk_name_config", a2 | 4);
            } else if (b.this.c.isChecked()) {
                com.jumobile.manager.systemapp.f.a.b(b.this.b, "apk_name_config", a2 & (-5));
            } else {
                com.jumobile.manager.systemapp.util.f.m(b.this.b, b.this.b.getString(R.string.apk_name_config_app_name) + "\n" + b.this.b.getString(R.string.apk_name_config_package_name) + "\n" + b.this.b.getString(R.string.common_at_least_one));
            }
            b.this.b();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.a.b$3 */
    class AnonymousClass3 implements CompoundButton.OnCheckedChangeListener {
        AnonymousClass3() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            int a2 = com.jumobile.manager.systemapp.f.a.a(b.this.b, "apk_name_config", 20);
            if (z) {
                com.jumobile.manager.systemapp.f.a.b(b.this.b, "apk_name_config", a2 | 8);
            } else if (b.this.f.isChecked()) {
                com.jumobile.manager.systemapp.f.a.b(b.this.b, "apk_name_config", a2 & (-9));
            } else {
                com.jumobile.manager.systemapp.util.f.m(b.this.b, b.this.b.getString(R.string.apk_name_config_version_name) + "\n" + b.this.b.getString(R.string.apk_name_config_version_code) + "\n" + b.this.b.getString(R.string.common_at_least_one));
            }
            b.this.b();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.a.b$4 */
    class AnonymousClass4 implements CompoundButton.OnCheckedChangeListener {
        AnonymousClass4() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            int a2 = com.jumobile.manager.systemapp.f.a.a(b.this.b, "apk_name_config", 20);
            if (z) {
                com.jumobile.manager.systemapp.f.a.b(b.this.b, "apk_name_config", a2 | 16);
            } else if (b.this.e.isChecked()) {
                com.jumobile.manager.systemapp.f.a.b(b.this.b, "apk_name_config", a2 & (-17));
            } else {
                com.jumobile.manager.systemapp.util.f.m(b.this.b, b.this.b.getString(R.string.apk_name_config_version_name) + "\n" + b.this.b.getString(R.string.apk_name_config_version_code) + "\n" + b.this.b.getString(R.string.common_at_least_one));
            }
            b.this.b();
        }
    }

    public void b() {
        int a2 = com.jumobile.manager.systemapp.f.a.a(this.b, "apk_name_config", 20);
        ArrayList arrayList = new ArrayList();
        if ((a2 & 2) != 0) {
            this.c.setChecked(true);
            arrayList.add(this.b.getString(R.string.apk_name_config_app_name));
        } else {
            this.c.setChecked(false);
        }
        if ((a2 & 4) != 0) {
            this.d.setChecked(true);
            arrayList.add(this.b.getString(R.string.apk_name_config_package_name));
        } else {
            this.d.setChecked(false);
        }
        if ((a2 & 8) != 0) {
            this.e.setChecked(true);
            arrayList.add(this.b.getString(R.string.apk_name_config_version_name));
        } else {
            this.e.setChecked(false);
        }
        if ((a2 & 16) != 0) {
            this.f.setChecked(true);
            arrayList.add(this.b.getString(R.string.apk_name_config_version_code));
        } else {
            this.f.setChecked(false);
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
        this.g.setText(com.jumobile.manager.systemapp.util.f.a(this.b, R.string.apk_name_config_format, R.color.green, sb.toString()));
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && view.getId() == R.id.btn_batch_rename) {
            if (this.j != null) {
                this.j.onClick(view);
            }
            dismiss();
        }
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
}
