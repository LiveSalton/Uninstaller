package com.jumobile.manager.systemapp.ui.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.jumobile.manager.systemapp.R;
import com.jumobile.manager.systemapp.ui.a.f;
import com.jumobile.manager.systemapp.ui.activity.MainActivity;
import com.jumobile.manager.systemapp.ui.activity.ResultActivity;
import com.jumobile.manager.systemapp.ui.widget.ActionBar;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public class i extends com.jumobile.manager.systemapp.ui.fragment.c implements DialogInterface.OnCancelListener, TextWatcher, View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private static final String X = "i";
    private TextView aa;
    private TextView ab;
    private EditText ag;
    private Context ah;
    private BroadcastReceiver al;
    private ImageButton am;
    private com.jumobile.manager.systemapp.ui.activity.e Y = null;
    private boolean Z = false;
    private ListView ac = null;
    private Button ad = null;
    private Button ae = null;
    private CheckBox af = null;
    private com.jumobile.manager.systemapp.c.f ai = null;
    final b U = new b();
    private int aj = 1;
    private com.jumobile.manager.systemapp.a.b ak = com.jumobile.manager.systemapp.a.b.j();
    private a an = null;
    private d ao = null;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // androidx.fragment.app.Fragment
    public void f(Bundle bundle) {
        super.f(bundle);
        ay();
    }

    @Override // androidx.fragment.app.Fragment
    public void K() {
        if (this.al != null) {
            androidx.f.a.a.a(this.ah.getApplicationContext()).a(this.al);
        }
        this.ak.k();
        if (this.ai != null) {
            this.ai.a(this.U);
            this.ai.a();
        }
        super.K();
    }

    @Override // androidx.fragment.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_user_app, viewGroup, false);
        d(inflate);
        this.ak.a(this, inflate);
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
        if (this.W) {
            at();
        }
    }

    private void ay() {
        this.ah = m().getApplicationContext();
        this.aj = com.jumobile.manager.systemapp.f.a.a(this.ah, "user_app_sort_by", 1);
        this.ai = new com.jumobile.manager.systemapp.c.f(this.ah);
        this.ai.a(this.U, 1);
        this.Y = new com.jumobile.manager.systemapp.ui.activity.e(this.ah);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.i$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentActivity m = i.this.m();
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
        actionBar.a.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.i.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FragmentActivity m = i.this.m();
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
        if (com.jumobile.manager.systemapp.f.a.a(this.ah, "ads_enabled", true)) {
            this.am = actionBar.a(R.drawable.remove_ads, new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.i.3
                AnonymousClass3() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    FragmentActivity m = i.this.m();
                    if (m != null) {
                        androidx.f.a.a.a(i.this.ah.getApplicationContext()).a(new Intent(m.getClass().getName() + "SHOW_DIALOG"));
                    }
                }
            });
            this.al = new BroadcastReceiver() { // from class: com.jumobile.manager.systemapp.ui.fragment.i.4
                AnonymousClass4() {
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    i.this.ak.h();
                    i.this.am.setVisibility(8);
                }
            };
            androidx.f.a.a.a(this.ah).a(this.al, new IntentFilter("com.jumobile.manager.systemapp.ACTION_ADS_REMOVED"));
        }
        actionBar.a(R.drawable.ic_action_menu, new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.i.5
            AnonymousClass5() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FragmentActivity m = i.this.m();
                if (m != null) {
                    c cVar = i.this.new c(m);
                    if (m.isFinishing()) {
                        return;
                    }
                    cVar.show();
                }
            }
        });
        actionBar.setEditChangeListener(this);
        if (com.jumobile.manager.systemapp.f.a.a(this.ah, "user_app_show_long_press_hint", true)) {
            View findViewById = view.findViewById(R.id.long_press_hint);
            findViewById.setVisibility(0);
            view.findViewById(R.id.long_press_hint_btn_i_know).setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.i.6
                final /* synthetic */ View a;

                AnonymousClass6(View findViewById2) {
                    findViewById = findViewById2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    findViewById.setVisibility(8);
                    com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_show_long_press_hint", false);
                }
            });
        }
        this.ag = (EditText) view.findViewById(R.id.filter_edit_text);
        aB();
        this.aa = (TextView) view.findViewById(R.id.summary_total);
        this.ab = (TextView) view.findViewById(R.id.summary_selected);
        this.ac = (ListView) view.findViewById(android.R.id.list);
        this.ad = (Button) view.findViewById(R.id.btn_right);
        this.ae = (Button) view.findViewById(R.id.btn_left);
        this.af = (CheckBox) view.findViewById(R.id.checkbox_select_all);
        this.ac.setEmptyView((TextView) view.findViewById(R.id.list_empty_view));
        this.ac.setOnItemClickListener(this);
        this.ac.setOnItemLongClickListener(this);
        this.ac.setAdapter((ListAdapter) this.Y);
        this.ad.setOnClickListener(this);
        this.ae.setOnClickListener(this);
        this.af.setChecked(false);
        this.Z = false;
        this.af.setOnClickListener(this);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.i$3 */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            FragmentActivity m = i.this.m();
            if (m != null) {
                androidx.f.a.a.a(i.this.ah.getApplicationContext()).a(new Intent(m.getClass().getName() + "SHOW_DIALOG"));
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.i$4 */
    class AnonymousClass4 extends BroadcastReceiver {
        AnonymousClass4() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            i.this.ak.h();
            i.this.am.setVisibility(8);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.i$5 */
    class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            FragmentActivity m = i.this.m();
            if (m != null) {
                c cVar = i.this.new c(m);
                if (m.isFinishing()) {
                    return;
                }
                cVar.show();
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.i$6 */
    class AnonymousClass6 implements View.OnClickListener {
        final /* synthetic */ View a;

        AnonymousClass6(View findViewById2) {
            findViewById = findViewById2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            findViewById.setVisibility(8);
            com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_show_long_press_hint", false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void F() {
        super.F();
        if (this.ao != null) {
            this.ao.a();
        }
        if (this.an != null) {
            this.an.a();
        }
        az();
    }

    private void az() {
        int a2 = com.jumobile.manager.systemapp.f.a.a(this.ah, "user_app_sort_by", 1);
        if (a2 == this.aj) {
        }
        this.aj = a2;
        switch (a2) {
            case 1:
                this.ai.d();
                break;
            case 2:
                this.ai.e();
                break;
            case 3:
                this.ai.f();
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void I() {
        if (this.ao != null) {
            this.ao.b();
        }
        if (this.an != null) {
            this.an.b();
        }
        super.I();
    }

    @Override // androidx.fragment.app.Fragment
    public void a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i != 1) {
            return;
        }
        aw();
    }

    public void at() {
        if (this.ai != null) {
            ArrayList<com.jumobile.manager.systemapp.d.g> b2 = this.ai.b();
            this.Y.a(b2);
            boolean z = b2.size() > 0;
            this.ad.setEnabled(z);
            this.ae.setEnabled(z);
            this.af.setEnabled(z);
            this.Y.notifyDataSetChanged();
            aA();
        }
    }

    private void aA() {
        this.aa.setText(com.jumobile.manager.systemapp.util.f.a(this.ah, R.string.system_app_summary_total, R.color.green, String.valueOf(this.Y.getCount())));
        this.ab.setText(com.jumobile.manager.systemapp.util.f.a(this.ah, R.string.system_app_summary_selected, R.color.green, String.valueOf(this.Y.c())));
    }

    public void aB() {
        if ((com.jumobile.manager.systemapp.f.a.a(this.ah, "user_app_extra_info", 0) & 16) != 0) {
            this.ag.setVisibility(0);
            this.ag.requestFocus();
            this.ag.addTextChangedListener(this);
            return;
        }
        this.ag.setVisibility(8);
    }

    private void aC() {
        ArrayList<com.jumobile.manager.systemapp.d.g> b2 = this.Y.b();
        if (b2.size() > 0) {
            if (this.an == null) {
                this.an = new a(b2);
                this.an.execute(new Integer[0]);
                return;
            }
            return;
        }
        com.jumobile.manager.systemapp.util.f.a(this.ah, R.string.user_app_backup_no_target);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.an == null && this.ao == null) {
            int id = view.getId();
            if (id != R.id.btn_left) {
                if (id == R.id.btn_right) {
                    if (aE()) {
                        aC();
                        return;
                    }
                    return;
                } else {
                    if (id != R.id.checkbox_select_all) {
                        return;
                    }
                    this.Z = !this.Z;
                    this.af.setChecked(this.Z);
                    this.Y.a(this.Z);
                    this.Y.notifyDataSetChanged();
                    aA();
                    return;
                }
            }
            ArrayList<com.jumobile.manager.systemapp.d.g> b2 = this.Y.b();
            if (b2.size() > 0) {
                if (aD()) {
                    FragmentActivity m = m();
                    if (m == null) {
                        return;
                    }
                    com.jumobile.manager.systemapp.ui.a.e eVar = new com.jumobile.manager.systemapp.ui.a.e(m, com.jumobile.manager.systemapp.util.f.a(this.ah, R.string.user_app_dialog_uninstall_confirm_content, R.color.green, String.valueOf(b2.size())));
                    eVar.setTitle(R.string.common_warning);
                    eVar.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.i.7
                        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

                        AnonymousClass7(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                            eVar = eVar2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            eVar.dismiss();
                            i.this.ao = i.this.new d(i.this.Y.b());
                            i.this.ao.execute(new Integer[0]);
                        }
                    });
                    eVar2.h.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.i.8
                        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

                        AnonymousClass8(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                            eVar = eVar2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            eVar.dismiss();
                            i.this.ao = null;
                        }
                    });
                    eVar2.setCancelable(false);
                    eVar2.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.i.9
                        AnonymousClass9() {
                        }

                        @Override // android.content.DialogInterface.OnKeyListener
                        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                            if (keyEvent.getAction() != 1) {
                                return true;
                            }
                            if (i != 4) {
                                return false;
                            }
                            dialogInterface.dismiss();
                            i.this.ao = null;
                            return true;
                        }
                    });
                    if (m.isFinishing()) {
                        return;
                    }
                    eVar2.show();
                    return;
                }
                aw();
                return;
            }
            com.jumobile.manager.systemapp.util.f.a(this.ah, R.string.user_app_uninstall_no_target);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.i$7 */
    class AnonymousClass7 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass7(com.jumobile.manager.systemapp.ui.a.e eVar2) {
            eVar = eVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            eVar.dismiss();
            i.this.ao = i.this.new d(i.this.Y.b());
            i.this.ao.execute(new Integer[0]);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.i$8 */
    class AnonymousClass8 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass8(com.jumobile.manager.systemapp.ui.a.e eVar2) {
            eVar = eVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            eVar.dismiss();
            i.this.ao = null;
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.i$9 */
    class AnonymousClass9 implements DialogInterface.OnKeyListener {
        AnonymousClass9() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 1) {
                return true;
            }
            if (i != 4) {
                return false;
            }
            dialogInterface.dismiss();
            i.this.ao = null;
            return true;
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox_app_selected);
        if (checkBox == null) {
            return;
        }
        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
            this.Y.a(i).i = false;
            this.af.setChecked(false);
            this.Z = false;
        } else {
            checkBox.setChecked(true);
            this.Y.a(i).i = true;
            if (this.Y.d()) {
                this.Z = true;
                this.af.setChecked(true);
            }
        }
        aA();
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.jumobile.manager.systemapp.d.g a2 = this.Y.a(i);
        if (a2 == null) {
            return false;
        }
        b(a2);
        return false;
    }

    private void b(com.jumobile.manager.systemapp.d.g gVar) {
        FragmentActivity m = m();
        if (m == null) {
            return;
        }
        com.jumobile.manager.systemapp.ui.a.i iVar = new com.jumobile.manager.systemapp.ui.a.i(m, gVar);
        if (m.isFinishing()) {
            return;
        }
        iVar.show();
    }

    public boolean au() {
        return com.jumobile.manager.systemapp.f.a.a(this.ah, "settings_user_app_auto_backup", false);
    }

    public boolean a(com.jumobile.manager.systemapp.d.g gVar) {
        try {
            File file = new File(com.jumobile.manager.systemapp.c.f.a(this.ah));
            File file2 = new File(gVar.b.sourceDir);
            File file3 = new File(file.toString() + "/" + gVar.e(this.ah));
            if (file3.exists()) {
                try {
                    if (file3.length() == file2.length()) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            if (this.ai != null) {
                return this.ai.a(gVar, file.toString());
            }
            return false;
        } catch (IOException unused2) {
            return false;
        }
    }

    public void aw() {
        com.jumobile.manager.systemapp.d.g a2;
        FragmentActivity m = m();
        if (m == null || this.ai == null || (a2 = this.Y.a()) == null) {
            return;
        }
        if (this.ai.b(a2)) {
            c(a2);
            return;
        }
        if (au()) {
            a(a2);
        }
        this.ai.a(a2, m, 1);
        a2.i = false;
        this.af.setChecked(false);
        this.Z = false;
        this.Y.notifyDataSetChanged();
    }

    /* compiled from: source */
    private class a extends AsyncTask<Integer, Integer, Integer> {
        private ArrayList<com.jumobile.manager.systemapp.d.g> b;
        private int c = 0;
        private String d = "";
        private com.jumobile.manager.systemapp.ui.a.f e = null;
        private boolean f = false;
        private final int g = 1;
        private final int h = 1;
        private final int i = 2;
        private final int j = 3;
        private final int k = 4;

        public a(ArrayList<com.jumobile.manager.systemapp.d.g> arrayList) {
            this.b = null;
            this.b = arrayList;
        }

        public void a() {
            if (this.e != null) {
                this.e.show();
            }
        }

        public void b() {
            if (this.e != null) {
                this.e.dismiss();
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(Integer... numArr) {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return 1;
            }
            File file = new File(com.jumobile.manager.systemapp.c.f.a(i.this.ah));
            if (!file.exists() && !file.mkdirs()) {
                return 2;
            }
            int size = this.b.size();
            int i = 0;
            while (i < this.b.size()) {
                com.jumobile.manager.systemapp.d.g gVar = this.b.get(i);
                if (this.f) {
                    return 3;
                }
                this.d = gVar.f;
                i++;
                publishProgress(1, Integer.valueOf(i), Integer.valueOf(this.b.size()));
                if (i.this.a(gVar)) {
                    this.c++;
                    gVar.d = true;
                } else {
                    gVar.i = false;
                }
            }
            publishProgress(1, Integer.valueOf(size), Integer.valueOf(size));
            return 4;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            FragmentActivity m = i.this.m();
            if (m == null) {
                return;
            }
            this.e = new com.jumobile.manager.systemapp.ui.a.f(m);
            this.e.a(0, this.b.size());
            this.e.setCancelable(true);
            this.e.a(new f.a() { // from class: com.jumobile.manager.systemapp.ui.fragment.i.a.1
                AnonymousClass1() {
                }

                @Override // com.jumobile.manager.systemapp.ui.a.f.a
                public boolean a() {
                    a.this.f = true;
                    return false;
                }
            });
            if (this.b.size() == 1) {
                this.e.f.setVisibility(8);
            }
            if (m.isFinishing()) {
                return;
            }
            this.e.show();
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.i$a$1 */
        class AnonymousClass1 implements f.a {
            AnonymousClass1() {
            }

            @Override // com.jumobile.manager.systemapp.ui.a.f.a
            public boolean a() {
                a.this.f = true;
                return false;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (i.this.t() && numArr[0].intValue() == 1) {
                this.e.a(numArr[1].intValue(), numArr[2].intValue());
                this.e.a(i.this.a(R.string.user_app_backup_progress_title, this.d));
                boolean d = i.this.Y.d();
                i.this.af.setChecked(d);
                i.this.Z = d;
                i.this.Y.notifyDataSetChanged();
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Integer num) {
            String string;
            String string2;
            super.onPostExecute(num);
            try {
                this.e.dismiss();
            } catch (Exception e) {
                Log.w(i.X, "Failed to dismiss mProgressDialog: " + e.getMessage());
            }
            i.this.an = null;
            FragmentActivity m = i.this.m();
            if (m == null) {
                return;
            }
            switch (num.intValue()) {
                case 1:
                    string = i.this.ah.getString(R.string.user_app_backup_none_sdcard);
                    string2 = i.this.ah.getString(R.string.user_app_backup_fail_title);
                    break;
                case 2:
                    string = i.this.ah.getString(R.string.user_app_backup_write_error);
                    string2 = i.this.ah.getString(R.string.user_app_backup_fail_title);
                    break;
                case 3:
                    string = i.this.ah.getString(R.string.user_app_backup_user_canceled, Integer.valueOf(this.c), com.jumobile.manager.systemapp.c.f.a(i.this.ah));
                    string2 = i.this.ah.getString(R.string.user_app_backup_finished_title);
                    break;
                case 4:
                    if (this.c == this.b.size()) {
                        string = i.this.ah.getString(R.string.user_app_backup_finished, Integer.valueOf(this.c), com.jumobile.manager.systemapp.c.f.a(i.this.ah));
                    } else {
                        string = i.this.ah.getString(R.string.user_app_backup_finished_with_error, Integer.valueOf(this.c), com.jumobile.manager.systemapp.c.f.a(i.this.ah));
                    }
                    string2 = i.this.ah.getString(R.string.user_app_backup_finished_title);
                    break;
                default:
                    string = i.this.ah.getString(R.string.user_app_backup_write_error);
                    string2 = i.this.ah.getString(R.string.user_app_backup_fail_title);
                    break;
            }
            Intent intent = new Intent(m, (Class<?>) ResultActivity.class);
            intent.putExtra("extra_title", string2);
            intent.putExtra("extra_message", string);
            m.startActivity(intent);
            m.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        }
    }

    /* compiled from: source */
    private class d extends AsyncTask<Integer, Integer, Integer> {
        private ArrayList<com.jumobile.manager.systemapp.d.g> b;
        private String c = "";
        private com.jumobile.manager.systemapp.ui.a.f d = null;
        private final int e = 1;
        private boolean f = false;
        private int g = 0;
        private int h = 0;

        public d(ArrayList<com.jumobile.manager.systemapp.d.g> arrayList) {
            this.b = null;
            this.b = arrayList;
        }

        public void a() {
            if (this.d != null) {
                this.d.show();
            }
        }

        public void b() {
            if (this.d != null) {
                this.d.dismiss();
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(Integer... numArr) {
            PackageInfo packageInfo;
            boolean z;
            for (int i = 0; i < this.b.size(); i++) {
                com.jumobile.manager.systemapp.d.g gVar = this.b.get(i);
                if (this.f) {
                    return 2;
                }
                this.c = gVar.f;
                gVar.i = false;
                try {
                    publishProgress(1, Integer.valueOf(i + 1), Integer.valueOf(this.b.size()));
                    if (com.jumobile.manager.systemapp.util.f.j(i.this.ah, gVar.b.packageName)) {
                        com.jumobile.manager.systemapp.b.a.d(i.this.ah, gVar.b.packageName);
                    }
                    com.jumobile.manager.systemapp.b.a.c(i.this.ah, gVar.b.packageName);
                    if (i.this.au()) {
                        i.this.a(gVar);
                    }
                    com.jumobile.manager.systemapp.h.a.a("pm uninstall " + gVar.b.packageName, 20000L);
                    try {
                        packageInfo = i.this.ah.getPackageManager().getPackageInfo(gVar.b.packageName, 0);
                        z = false;
                    } catch (PackageManager.NameNotFoundException unused) {
                        packageInfo = null;
                        z = true;
                    }
                    if (packageInfo != null && (packageInfo.applicationInfo.flags & 1) != 0 && (packageInfo.applicationInfo.flags & 128) == 0) {
                        z = true;
                    }
                    if (z) {
                        this.g++;
                    } else {
                        this.h++;
                    }
                } catch (Exception unused2) {
                }
            }
            return 0;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            try {
                this.d.dismiss();
            } catch (Exception e) {
                Log.w(i.X, "Failed to dismiss mProgressDialog: " + e.getMessage());
            }
            i.this.Y.notifyDataSetChanged();
            this.d = null;
            i.this.ao = null;
            FragmentActivity m = i.this.m();
            if (m == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            if (2 == num.intValue()) {
                sb.append(i.this.ah.getString(R.string.system_app_uninstall_result_dialog_user_canceled));
                sb.append("\n");
            }
            if (this.g > 0) {
                sb.append(i.this.ah.getString(R.string.system_app_uninstall_result_dialog_success_count, Integer.valueOf(this.g)));
            }
            if (this.h > 0) {
                if (this.g > 0) {
                    sb.append("\n");
                }
                sb.append(i.this.ah.getString(R.string.system_app_uninstall_result_dialog_failed_count, Integer.valueOf(this.h)));
            }
            Intent intent = new Intent(m, (Class<?>) ResultActivity.class);
            intent.putExtra("extra_title", m.getString(R.string.system_app_uninstall_result_dialog_title));
            intent.putExtra("extra_message", sb.toString());
            m.startActivity(intent);
            m.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            FragmentActivity m = i.this.m();
            if (m == null) {
                return;
            }
            this.d = new com.jumobile.manager.systemapp.ui.a.f(m);
            this.d.a(0, this.b.size());
            this.d.setCancelable(true);
            this.d.a(new f.a() { // from class: com.jumobile.manager.systemapp.ui.fragment.i.d.1
                AnonymousClass1() {
                }

                @Override // com.jumobile.manager.systemapp.ui.a.f.a
                public boolean a() {
                    d.this.f = true;
                    return false;
                }
            });
            if (this.b.size() == 1) {
                this.d.f.setVisibility(8);
            }
            if (m.isFinishing()) {
                return;
            }
            this.d.show();
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.i$d$1 */
        class AnonymousClass1 implements f.a {
            AnonymousClass1() {
            }

            @Override // com.jumobile.manager.systemapp.ui.a.f.a
            public boolean a() {
                d.this.f = true;
                return false;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (i.this.t() && numArr[0].intValue() == 1) {
                this.d.a(numArr[1].intValue(), numArr[2].intValue());
                this.d.a(i.this.a(R.string.system_app_uninstall_entry, this.c));
                i.this.Y.notifyDataSetChanged();
            }
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.U.sendEmptyMessage(2);
    }

    /* compiled from: source */
    class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    i.this.a(message);
                    break;
                case 2:
                    if (i.this.ai != null) {
                        i.this.ai.c();
                        break;
                    }
                    break;
            }
        }
    }

    public void a(Message message) {
        int i = message.arg1;
        if (i != 4) {
            switch (i) {
                case 2:
                    at();
                    break;
            }
        }
    }

    private boolean aD() {
        return com.jumobile.manager.systemapp.h.a.c();
    }

    private void c(com.jumobile.manager.systemapp.d.g gVar) {
        FragmentActivity m = m();
        if (m == null) {
            return;
        }
        com.jumobile.manager.systemapp.ui.a.e eVar = new com.jumobile.manager.systemapp.ui.a.e(m, this.ah.getString(R.string.user_app_uninstall_fail_active_admin, gVar.f));
        eVar.setTitle(R.string.common_warning);
        eVar.g.setText(R.string.user_app_uninstall_fail_btn);
        eVar.h.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.i.10
            final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;
            final /* synthetic */ com.jumobile.manager.systemapp.d.g b;

            AnonymousClass10(com.jumobile.manager.systemapp.ui.a.e eVar2, com.jumobile.manager.systemapp.d.g gVar2) {
                eVar = eVar2;
                gVar = gVar2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                eVar.dismiss();
                FragmentActivity m2 = i.this.m();
                if (m2 != null) {
                    com.jumobile.manager.systemapp.util.f.a((Activity) m2, gVar.b.packageName);
                }
            }
        });
        if (m.isFinishing()) {
            return;
        }
        eVar2.show();
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.i$10 */
    class AnonymousClass10 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;
        final /* synthetic */ com.jumobile.manager.systemapp.d.g b;

        AnonymousClass10(com.jumobile.manager.systemapp.ui.a.e eVar2, com.jumobile.manager.systemapp.d.g gVar2) {
            eVar = eVar2;
            gVar = gVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            eVar.dismiss();
            FragmentActivity m2 = i.this.m();
            if (m2 != null) {
                com.jumobile.manager.systemapp.util.f.a((Activity) m2, gVar.b.packageName);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.ai.a(editable.toString());
    }

    /* compiled from: source */
    private class c extends Dialog implements DialogInterface.OnKeyListener, View.OnClickListener {
        public c(Context context) {
            super(context, R.style.BaseDialog);
            setContentView(R.layout.dialog_menu_user_app_more);
            setCancelable(false);
            setCanceledOnTouchOutside(true);
            setOnKeyListener(this);
            Window window = getWindow();
            window.setGravity(21);
            window.setWindowAnimations(R.style.menu_dailog_anim);
            int a = com.jumobile.manager.systemapp.f.a.a(i.this.ah, "user_app_extra_info", 0);
            CheckBox checkBox = (CheckBox) findViewById(R.id.extra_info_install_time);
            checkBox.setChecked((a & 2) != 0);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.i.c.1
                final /* synthetic */ i a;

                AnonymousClass1(i iVar) {
                    r2 = iVar;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    int a2 = com.jumobile.manager.systemapp.f.a.a(i.this.ah, "user_app_extra_info", 0);
                    if (z) {
                        com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_extra_info", a2 | 2);
                    } else {
                        com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_extra_info", a2 & (-3));
                    }
                    i.this.at();
                }
            });
            CheckBox checkBox2 = (CheckBox) findViewById(R.id.extra_info_package_name);
            checkBox2.setChecked((a & 4) != 0);
            checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.i.c.2
                final /* synthetic */ i a;

                AnonymousClass2(i iVar) {
                    r2 = iVar;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    int a2 = com.jumobile.manager.systemapp.f.a.a(i.this.ah, "user_app_extra_info", 0);
                    if (z) {
                        com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_extra_info", a2 | 4);
                    } else {
                        com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_extra_info", a2 & (-5));
                    }
                    i.this.at();
                }
            });
            CheckBox checkBox3 = (CheckBox) findViewById(R.id.extra_info_apk_path);
            checkBox3.setChecked((a & 8) != 0);
            checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.i.c.3
                final /* synthetic */ i a;

                AnonymousClass3(i iVar) {
                    r2 = iVar;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    int a2 = com.jumobile.manager.systemapp.f.a.a(i.this.ah, "user_app_extra_info", 0);
                    if (z) {
                        com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_extra_info", a2 | 8);
                    } else {
                        com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_extra_info", a2 & (-9));
                    }
                    i.this.at();
                }
            });
            CheckBox checkBox4 = (CheckBox) findViewById(R.id.extra_info_filter_text);
            checkBox4.setChecked((a & 16) != 0);
            checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.i.c.4
                final /* synthetic */ i a;

                AnonymousClass4(i iVar) {
                    r2 = iVar;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    int a2 = com.jumobile.manager.systemapp.f.a.a(i.this.ah, "user_app_extra_info", 0);
                    if (z) {
                        com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_extra_info", a2 | 16);
                    } else {
                        com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_extra_info", a2 & (-17));
                    }
                    i.this.aB();
                }
            });
            RadioButton radioButton = (RadioButton) findViewById(R.id.menu_sort_by_label);
            radioButton.setOnClickListener(this);
            RadioButton radioButton2 = (RadioButton) findViewById(R.id.menu_sort_by_size);
            radioButton2.setOnClickListener(this);
            RadioButton radioButton3 = (RadioButton) findViewById(R.id.menu_sort_by_time);
            radioButton3.setOnClickListener(this);
            RadioButton radioButton4 = (RadioButton) findViewById(R.id.menu_sort_by_file_name);
            radioButton4.setOnClickListener(this);
            int a2 = com.jumobile.manager.systemapp.f.a.a(i.this.ah, "user_app_sort_by", 1);
            if (a2 != 6) {
                switch (a2) {
                    case 1:
                        radioButton.setChecked(true);
                        break;
                    case 2:
                        radioButton2.setChecked(true);
                        break;
                    case 3:
                        radioButton3.setChecked(true);
                        break;
                    default:
                        radioButton.setChecked(true);
                        break;
                }
            } else {
                radioButton4.setChecked(true);
            }
            findViewById(R.id.btn_share_app_details).setOnClickListener(this);
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.i$c$1 */
        class AnonymousClass1 implements CompoundButton.OnCheckedChangeListener {
            final /* synthetic */ i a;

            AnonymousClass1(i iVar) {
                r2 = iVar;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(i.this.ah, "user_app_extra_info", 0);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_extra_info", a2 | 2);
                } else {
                    com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_extra_info", a2 & (-3));
                }
                i.this.at();
            }
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.i$c$2 */
        class AnonymousClass2 implements CompoundButton.OnCheckedChangeListener {
            final /* synthetic */ i a;

            AnonymousClass2(i iVar) {
                r2 = iVar;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(i.this.ah, "user_app_extra_info", 0);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_extra_info", a2 | 4);
                } else {
                    com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_extra_info", a2 & (-5));
                }
                i.this.at();
            }
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.i$c$3 */
        class AnonymousClass3 implements CompoundButton.OnCheckedChangeListener {
            final /* synthetic */ i a;

            AnonymousClass3(i iVar) {
                r2 = iVar;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(i.this.ah, "user_app_extra_info", 0);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_extra_info", a2 | 8);
                } else {
                    com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_extra_info", a2 & (-9));
                }
                i.this.at();
            }
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.i$c$4 */
        class AnonymousClass4 implements CompoundButton.OnCheckedChangeListener {
            final /* synthetic */ i a;

            AnonymousClass4(i iVar) {
                r2 = iVar;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(i.this.ah, "user_app_extra_info", 0);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_extra_info", a2 | 16);
                } else {
                    com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_extra_info", a2 & (-17));
                }
                i.this.aB();
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null) {
            }
            switch (view.getId()) {
                case R.id.btn_share_app_details /* 2131230853 */:
                    ArrayList<com.jumobile.manager.systemapp.d.g> b = i.this.Y.b();
                    if (b.size() <= 0) {
                        com.jumobile.manager.systemapp.util.f.a(i.this.ah, R.string.common_at_least_one);
                        break;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        Iterator<com.jumobile.manager.systemapp.d.g> it = b.iterator();
                        while (it.hasNext()) {
                            com.jumobile.manager.systemapp.d.g next = it.next();
                            sb.append(next.f);
                            sb.append("\n");
                            sb.append(com.jumobile.manager.systemapp.util.f.d(i.this.ah, next.g));
                            sb.append("\n");
                            sb.append(i.this.ah.getString(R.string.app_info_dialog_detail_size));
                            sb.append(com.jumobile.manager.systemapp.util.f.a(next.h));
                            sb.append("\n");
                            sb.append(i.this.ah.getString(R.string.app_info_dialog_detail_package));
                            sb.append(next.b.packageName);
                            sb.append("\n");
                            sb.append(i.this.ah.getString(R.string.app_info_dialog_detail_source_dir));
                            sb.append(next.b.sourceDir);
                            sb.append("\n");
                            sb.append("\n");
                        }
                        Intent intent = new Intent("android.intent.action.SEND");
                        intent.putExtra("android.intent.extra.TEXT", sb.toString());
                        intent.setType("text/plain");
                        intent.addFlags(268435456);
                        i.this.a(Intent.createChooser(intent, i.this.a(R.string.share_app_default_title)));
                        break;
                    }
                case R.id.menu_sort_by_file_name /* 2131230979 */:
                    i.this.ai.g();
                    com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_sort_by", 6);
                    break;
                case R.id.menu_sort_by_label /* 2131230980 */:
                    i.this.ai.d();
                    com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_sort_by", 1);
                    break;
                case R.id.menu_sort_by_size /* 2131230982 */:
                    i.this.ai.e();
                    com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_sort_by", 2);
                    break;
                case R.id.menu_sort_by_time /* 2131230984 */:
                    i.this.ai.f();
                    com.jumobile.manager.systemapp.f.a.b(i.this.ah, "user_app_sort_by", 3);
                    break;
            }
        }
    }

    @Override // com.jumobile.manager.systemapp.ui.fragment.c
    public boolean av() {
        return this.ak.f();
    }

    private boolean aE() {
        ArrayList arrayList = new ArrayList();
        if (androidx.core.content.a.b(this.ah, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (arrayList.size() == 0) {
            return true;
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        a(strArr, 12);
        return false;
    }

    private boolean a(int[] iArr) {
        for (int i : iArr) {
            if (i == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void a(int i, String[] strArr, int[] iArr) {
        super.a(i, strArr, iArr);
        if (i == 12) {
            if (a(iArr)) {
                aC();
                return;
            }
            FragmentActivity m = m();
            if (m == null) {
                return;
            }
            com.jumobile.manager.systemapp.ui.a.e eVar = new com.jumobile.manager.systemapp.ui.a.e(m, R.string.common_no_permisson);
            eVar.setTitle(R.string.common_warning);
            eVar.h.setVisibility(8);
            eVar.g.setText(R.string.common_yes);
            eVar.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.i.2
                final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

                AnonymousClass2(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                    eVar = eVar2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.parse("package:" + i.this.ah.getPackageName()));
                    i.this.a(intent);
                    eVar.dismiss();
                }
            });
            if (m.isFinishing()) {
                return;
            }
            eVar2.show();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.i$2 */
    class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass2(com.jumobile.manager.systemapp.ui.a.e eVar2) {
            eVar = eVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + i.this.ah.getPackageName()));
            i.this.a(intent);
            eVar.dismiss();
        }
    }
}
