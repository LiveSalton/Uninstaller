package com.jumobile.manager.systemapp.ui.fragment;

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
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
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
import com.jumobile.manager.systemapp.ui.activity.DirectoryChooserActivity;
import com.jumobile.manager.systemapp.ui.activity.MainActivity;
import com.jumobile.manager.systemapp.ui.activity.ResultActivity;
import com.jumobile.manager.systemapp.ui.widget.ActionBar;
import java.io.File;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public class b extends com.jumobile.manager.systemapp.ui.fragment.c implements DialogInterface.OnCancelListener, TextWatcher, View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private static final String X = "b";
    private ImageButton Z;
    private TextView aa;
    private TextView ab;
    private EditText af;
    private Context ag;
    private BroadcastReceiver aj;
    private ImageButton ak;
    private com.jumobile.manager.systemapp.ui.fragment.a Y = null;
    private ListView ac = null;
    private Button ad = null;
    private Button ae = null;
    private com.jumobile.manager.systemapp.c.a ah = null;
    private com.jumobile.manager.systemapp.a.b ai = com.jumobile.manager.systemapp.a.b.j();
    final HandlerC0096b U = new HandlerC0096b();
    private a al = null;
    private g am = null;
    private e an = null;
    private f ao = null;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // androidx.fragment.app.Fragment
    public void f(Bundle bundle) {
        super.f(bundle);
        ax();
    }

    @Override // androidx.fragment.app.Fragment
    public void K() {
        if (this.aj != null) {
            androidx.f.a.a.a(this.ag.getApplicationContext()).a(this.aj);
        }
        this.ai.k();
        if (this.ah != null) {
            this.ah.a(this.U);
            this.ah.a();
        }
        super.K();
    }

    @Override // androidx.fragment.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_apk_file, viewGroup, false);
        d(inflate);
        this.ai.a(this, inflate);
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

    private void ax() {
        this.ag = m().getApplicationContext();
        this.ah = new com.jumobile.manager.systemapp.c.a(this.ag);
        this.ah.a(this.U, 1);
        this.Y = new com.jumobile.manager.systemapp.ui.fragment.a(this.ag);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentActivity m = b.this.m();
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
        actionBar.a.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FragmentActivity m = b.this.m();
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
        if (com.jumobile.manager.systemapp.f.a.a(this.ag, "ads_enabled", true)) {
            this.ak = actionBar.a(R.drawable.remove_ads, new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.6
                AnonymousClass6() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    FragmentActivity m = b.this.m();
                    if (m != null) {
                        androidx.f.a.a.a(b.this.ag.getApplicationContext()).a(new Intent(m.getClass().getName() + "SHOW_DIALOG"));
                    }
                }
            });
            this.aj = new BroadcastReceiver() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.7
                AnonymousClass7() {
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    b.this.ai.h();
                    b.this.ak.setVisibility(8);
                }
            };
            androidx.f.a.a.a(this.ag).a(this.aj, new IntentFilter("com.jumobile.manager.systemapp.ACTION_ADS_REMOVED"));
        }
        this.Z = actionBar.a(R.drawable.ic_action_refresh, new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.8
            AnonymousClass8() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.ah.d();
            }
        });
        actionBar.a(R.drawable.ic_action_menu, new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.9
            AnonymousClass9() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FragmentActivity m = b.this.m();
                if (m != null) {
                    d dVar = b.this.new d(m);
                    if (m.isFinishing()) {
                        return;
                    }
                    dVar.show();
                }
            }
        });
        actionBar.setEditChangeListener(this);
        if (com.jumobile.manager.systemapp.f.a.a(this.ag, "apk_file_show_long_press_hint", true)) {
            View findViewById = view.findViewById(R.id.long_press_hint);
            findViewById.setVisibility(0);
            view.findViewById(R.id.long_press_hint_btn_i_know).setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.10
                final /* synthetic */ View a;

                AnonymousClass10(View findViewById2) {
                    findViewById = findViewById2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    findViewById.setVisibility(8);
                    com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_show_long_press_hint", false);
                }
            });
        }
        this.af = (EditText) view.findViewById(R.id.filter_edit_text);
        ay();
        this.aa = (TextView) view.findViewById(R.id.summary_total);
        this.ab = (TextView) view.findViewById(R.id.summary_selected);
        this.ac = (ListView) view.findViewById(android.R.id.list);
        this.ad = (Button) view.findViewById(R.id.btn_right);
        this.ae = (Button) view.findViewById(R.id.btn_left);
        view.findViewById(R.id.btn_more).setOnClickListener(this);
        this.ac.setEmptyView((TextView) view.findViewById(R.id.list_empty_view));
        this.ac.setOnItemClickListener(this);
        this.ac.setOnItemLongClickListener(this);
        this.ac.setAdapter((ListAdapter) this.Y);
        this.ad.setOnClickListener(this);
        this.ae.setOnClickListener(this);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$6 */
    class AnonymousClass6 implements View.OnClickListener {
        AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            FragmentActivity m = b.this.m();
            if (m != null) {
                androidx.f.a.a.a(b.this.ag.getApplicationContext()).a(new Intent(m.getClass().getName() + "SHOW_DIALOG"));
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$7 */
    class AnonymousClass7 extends BroadcastReceiver {
        AnonymousClass7() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            b.this.ai.h();
            b.this.ak.setVisibility(8);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$8 */
    class AnonymousClass8 implements View.OnClickListener {
        AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            b.this.ah.d();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$9 */
    class AnonymousClass9 implements View.OnClickListener {
        AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            FragmentActivity m = b.this.m();
            if (m != null) {
                d dVar = b.this.new d(m);
                if (m.isFinishing()) {
                    return;
                }
                dVar.show();
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$10 */
    class AnonymousClass10 implements View.OnClickListener {
        final /* synthetic */ View a;

        AnonymousClass10(View findViewById2) {
            findViewById = findViewById2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            findViewById.setVisibility(8);
            com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_show_long_press_hint", false);
        }
    }

    public void ay() {
        if ((com.jumobile.manager.systemapp.f.a.a(this.ag, "apk_file_extra_info", 0) & 16) != 0) {
            this.af.setVisibility(0);
            this.af.requestFocus();
            this.af.addTextChangedListener(this);
            return;
        }
        this.af.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void F() {
        super.F();
        if (this.am != null) {
            this.am.a();
        }
        if (this.al != null) {
            this.al.a();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void I() {
        if (this.am != null) {
            this.am.b();
        }
        if (this.al != null) {
            this.al.b();
        }
        super.I();
    }

    @Override // androidx.fragment.app.Fragment
    public void a(int i, int i2, Intent intent) {
        FragmentActivity m;
        super.a(i, i2, intent);
        if (i == 2) {
            File file = new File(this.ag.getCacheDir().getPath() + "/apk_file/intermediate_install_file.apk");
            if (file.exists()) {
                file.delete();
            }
            au();
            return;
        }
        if (i == 5 && i2 == -1 && (m = m()) != null) {
            ArrayList<com.jumobile.manager.systemapp.d.a> a2 = this.Y.a();
            String stringExtra = intent.getStringExtra("extra_directory");
            com.jumobile.manager.systemapp.ui.a.e eVar = new com.jumobile.manager.systemapp.ui.a.e(m, com.jumobile.manager.systemapp.util.f.a(this.ag, R.string.apk_file_move_to_directory_confirm_message, R.color.green, String.valueOf(a2.size()), stringExtra));
            eVar.setTitle(R.string.common_hint);
            eVar.i.setVisibility(0);
            eVar.i.setText(R.string.apk_file_move_to_directory_delete_duplicate);
            eVar.i.setChecked(true);
            eVar.g.setBackgroundResource(R.drawable.selector_btn_recommend);
            eVar.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.11
                final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;
                final /* synthetic */ ArrayList b;
                final /* synthetic */ String c;

                AnonymousClass11(com.jumobile.manager.systemapp.ui.a.e eVar2, ArrayList a22, String stringExtra2) {
                    eVar = eVar2;
                    a2 = a22;
                    stringExtra = stringExtra2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    eVar.dismiss();
                    if (b.this.an == null) {
                        b.this.an = b.this.new e(a2, stringExtra, eVar.i.isChecked());
                        b.this.an.execute(new Integer[0]);
                    }
                }
            });
            eVar2.h.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.12
                final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

                AnonymousClass12(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                    eVar = eVar2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    eVar.dismiss();
                }
            });
            eVar2.setCancelable(false);
            eVar2.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.13
                AnonymousClass13() {
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                    if (keyEvent.getAction() != 1) {
                        return true;
                    }
                    if (i3 != 4) {
                        return false;
                    }
                    dialogInterface.dismiss();
                    return true;
                }
            });
            if (m.isFinishing()) {
                return;
            }
            eVar2.show();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$11 */
    class AnonymousClass11 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;
        final /* synthetic */ ArrayList b;
        final /* synthetic */ String c;

        AnonymousClass11(com.jumobile.manager.systemapp.ui.a.e eVar2, ArrayList a22, String stringExtra2) {
            eVar = eVar2;
            a2 = a22;
            stringExtra = stringExtra2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            eVar.dismiss();
            if (b.this.an == null) {
                b.this.an = b.this.new e(a2, stringExtra, eVar.i.isChecked());
                b.this.an.execute(new Integer[0]);
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$12 */
    class AnonymousClass12 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass12(com.jumobile.manager.systemapp.ui.a.e eVar2) {
            eVar = eVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            eVar.dismiss();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$13 */
    class AnonymousClass13 implements DialogInterface.OnKeyListener {
        AnonymousClass13() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 1) {
                return true;
            }
            if (i3 != 4) {
                return false;
            }
            dialogInterface.dismiss();
            return true;
        }
    }

    public void at() {
        if (this.ah != null) {
            ArrayList<com.jumobile.manager.systemapp.d.a> b = this.ah.b();
            this.Y.a(b);
            boolean z = b.size() > 0;
            this.ad.setEnabled(z);
            this.ae.setEnabled(z);
            this.Y.notifyDataSetChanged();
            az();
        }
    }

    public void az() {
        this.aa.setText(com.jumobile.manager.systemapp.util.f.a(this.ag, R.string.system_app_summary_total, R.color.green, String.valueOf(this.Y.getCount())));
        this.ab.setText(com.jumobile.manager.systemapp.util.f.a(this.ag, R.string.system_app_summary_selected, R.color.green, String.valueOf(this.Y.b())));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.al == null && this.am == null) {
            switch (view.getId()) {
                case R.id.btn_left /* 2131230847 */:
                    aA();
                    break;
                case R.id.btn_more /* 2131230848 */:
                    FragmentActivity m = m();
                    if (m != null) {
                        c cVar = new c(m);
                        if (!m.isFinishing()) {
                            cVar.show();
                            break;
                        }
                    }
                    break;
                case R.id.btn_right /* 2131230850 */:
                    if (this.Y.a().size() > 0) {
                        if (aB()) {
                            this.am = new g(this.Y.a());
                            this.am.execute(new Integer[0]);
                            break;
                        } else {
                            au();
                            break;
                        }
                    } else {
                        com.jumobile.manager.systemapp.util.f.a(this.ag, R.string.apk_file_install_no_target);
                        break;
                    }
            }
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
        } else {
            checkBox.setChecked(true);
            this.Y.a(i).i = true;
        }
        az();
    }

    public void aA() {
        ArrayList<com.jumobile.manager.systemapp.d.a> a2 = this.Y.a();
        if (a2.size() > 0) {
            FragmentActivity m = m();
            if (m == null) {
                return;
            }
            com.jumobile.manager.systemapp.ui.a.e eVar = new com.jumobile.manager.systemapp.ui.a.e(m, com.jumobile.manager.systemapp.util.f.a(this.ag, R.string.apk_file_delete_confirm_message, R.color.green, String.valueOf(a2.size())));
            eVar.setTitle(R.string.common_warning);
            eVar.g.setBackgroundResource(R.drawable.selector_btn_warning);
            eVar.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.2
                final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

                AnonymousClass2(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                    eVar = eVar2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    eVar.dismiss();
                    b.this.al = b.this.new a(b.this.Y.a());
                    b.this.al.execute(new Integer[0]);
                }
            });
            eVar2.h.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.3
                final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

                AnonymousClass3(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                    eVar = eVar2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    eVar.dismiss();
                }
            });
            eVar2.setCancelable(false);
            eVar2.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.4
                AnonymousClass4() {
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
                    return true;
                }
            });
            if (m.isFinishing()) {
                return;
            }
            eVar2.show();
            return;
        }
        com.jumobile.manager.systemapp.util.f.a(this.ag, R.string.apk_file_install_no_target);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$2 */
    class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass2(com.jumobile.manager.systemapp.ui.a.e eVar2) {
            eVar = eVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            eVar.dismiss();
            b.this.al = b.this.new a(b.this.Y.a());
            b.this.al.execute(new Integer[0]);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$3 */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass3(com.jumobile.manager.systemapp.ui.a.e eVar2) {
            eVar = eVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            eVar.dismiss();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$4 */
    class AnonymousClass4 implements DialogInterface.OnKeyListener {
        AnonymousClass4() {
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
            return true;
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.jumobile.manager.systemapp.d.a a2 = this.Y.a(i);
        if (a2 == null) {
            return false;
        }
        a(a2);
        return false;
    }

    private void a(com.jumobile.manager.systemapp.d.a aVar) {
        FragmentActivity m = m();
        if (m == null) {
            return;
        }
        com.jumobile.manager.systemapp.ui.a.a aVar2 = new com.jumobile.manager.systemapp.ui.a.a(m, aVar);
        if (m.isFinishing()) {
            return;
        }
        aVar2.show();
    }

    public void au() {
        com.jumobile.manager.systemapp.d.a c2;
        FragmentActivity m = m();
        if (m == null || this.ah == null || (c2 = this.Y.c()) == null) {
            return;
        }
        this.ah.a(c2, m, 2);
        c2.i = false;
        this.Y.notifyDataSetChanged();
    }

    /* compiled from: source */
    private class a extends AsyncTask<Integer, Integer, Integer> {
        private ArrayList<com.jumobile.manager.systemapp.d.a> b;
        private String c = "";
        private com.jumobile.manager.systemapp.ui.a.f d = null;
        private boolean e = false;
        private final int f = 1;
        private final int g = 1;
        private final int h = 2;

        public a(ArrayList<com.jumobile.manager.systemapp.d.a> arrayList) {
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
            int size = this.b.size();
            int i = 0;
            while (i < this.b.size()) {
                com.jumobile.manager.systemapp.d.a aVar = this.b.get(i);
                if (this.e) {
                    return 1;
                }
                aVar.i = false;
                this.c = aVar.f;
                i++;
                publishProgress(1, Integer.valueOf(i), Integer.valueOf(this.b.size()));
                try {
                    b.this.ah.a(aVar);
                } catch (Exception unused) {
                }
            }
            publishProgress(1, Integer.valueOf(size), Integer.valueOf(size));
            return 2;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            FragmentActivity m = b.this.m();
            if (m == null) {
                return;
            }
            this.d = new com.jumobile.manager.systemapp.ui.a.f(m);
            this.d.a(0, this.b.size());
            this.d.setCancelable(true);
            this.d.a(new f.a() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.a.1
                AnonymousClass1() {
                }

                @Override // com.jumobile.manager.systemapp.ui.a.f.a
                public boolean a() {
                    a.this.e = true;
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
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$a$1 */
        class AnonymousClass1 implements f.a {
            AnonymousClass1() {
            }

            @Override // com.jumobile.manager.systemapp.ui.a.f.a
            public boolean a() {
                a.this.e = true;
                return false;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (b.this.t() && numArr[0].intValue() == 1) {
                this.d.a(numArr[1].intValue(), numArr[2].intValue());
                this.d.a(b.this.a(R.string.apk_file_delete_entry, this.c));
                b.this.Y.notifyDataSetChanged();
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            try {
                this.d.dismiss();
            } catch (Exception e) {
                Log.w(b.X, "Failed to dismiss mProgressDialog: " + e.getMessage());
            }
            b.this.al = null;
            FragmentActivity m = b.this.m();
            if (m == null) {
                return;
            }
            Intent intent = new Intent(m, (Class<?>) ResultActivity.class);
            intent.putExtra("extra_title", m.getString(R.string.common_hint));
            intent.putExtra("extra_message", m.getString(R.string.apk_file_delete_task_done));
            m.startActivity(intent);
            m.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        }
    }

    /* compiled from: source */
    private class g extends AsyncTask<Integer, Integer, Integer> {
        private ArrayList<com.jumobile.manager.systemapp.d.a> b;
        private String c = "";
        private com.jumobile.manager.systemapp.ui.a.f d = null;
        private final int e = 1;
        private boolean f = false;
        private int g = 0;
        private int h = 0;

        public g(ArrayList<com.jumobile.manager.systemapp.d.a> arrayList) {
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
            for (int i = 0; i < this.b.size(); i++) {
                com.jumobile.manager.systemapp.d.a aVar = this.b.get(i);
                if (this.f) {
                    return 2;
                }
                this.c = aVar.f;
                try {
                    publishProgress(1, Integer.valueOf(i + 1), Integer.valueOf(this.b.size()));
                    if (Build.VERSION.SDK_INT >= 28) {
                        com.jumobile.manager.systemapp.h.a.a("cat " + aVar.a + " | pm install -S " + aVar.h, 300000L);
                    } else if (Build.VERSION.SDK_INT >= 17) {
                        com.jumobile.manager.systemapp.h.a.a("pm install -r -d " + aVar.a, 300000L);
                    } else {
                        com.jumobile.manager.systemapp.h.a.a("pm install -r " + aVar.a, 300000L);
                    }
                    PackageInfo packageInfo = null;
                    try {
                        packageInfo = b.this.ag.getPackageManager().getPackageInfo(aVar.e, 0);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                    if (packageInfo != null && packageInfo.versionCode == aVar.c) {
                        this.g++;
                        aVar.i = false;
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
                Log.w(b.X, "Failed to dismiss mProgressDialog: " + e.getMessage());
            }
            b.this.Y.notifyDataSetChanged();
            this.d = null;
            b.this.am = null;
            FragmentActivity m = b.this.m();
            if (m == null) {
                return;
            }
            if (this.g == 0) {
                com.jumobile.manager.systemapp.ui.a.e eVar = new com.jumobile.manager.systemapp.ui.a.e(m, R.string.apk_file_install_result_none_success);
                eVar.setTitle(R.string.common_warning);
                eVar.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.g.1
                    final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

                    AnonymousClass1(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                        eVar = eVar2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        eVar.dismiss();
                        b.this.au();
                    }
                });
                if (m.isFinishing()) {
                    return;
                }
                eVar2.show();
                return;
            }
            StringBuilder sb = new StringBuilder();
            if (2 == num.intValue()) {
                sb.append(b.this.ag.getString(R.string.apk_file_install_user_canceled));
                sb.append("\n");
            }
            if (this.g > 0) {
                sb.append(b.this.ag.getString(R.string.apk_file_install_result_success_count, Integer.valueOf(this.g)));
            }
            if (this.h > 0) {
                if (this.g > 0) {
                    sb.append("\n");
                }
                sb.append(b.this.ag.getString(R.string.apk_file_install_result_failed_count, Integer.valueOf(this.h)));
            }
            Intent intent = new Intent(m, (Class<?>) ResultActivity.class);
            intent.putExtra("extra_title", m.getString(R.string.common_hint));
            intent.putExtra("extra_message", sb.toString());
            m.startActivity(intent);
            m.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$g$1 */
        class AnonymousClass1 implements View.OnClickListener {
            final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

            AnonymousClass1(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                eVar = eVar2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                eVar.dismiss();
                b.this.au();
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            FragmentActivity m = b.this.m();
            if (m == null) {
                return;
            }
            this.d = new com.jumobile.manager.systemapp.ui.a.f(m);
            this.d.a(0, this.b.size());
            this.d.setCancelable(true);
            this.d.a(new f.a() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.g.2
                AnonymousClass2() {
                }

                @Override // com.jumobile.manager.systemapp.ui.a.f.a
                public boolean a() {
                    g.this.f = true;
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
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$g$2 */
        class AnonymousClass2 implements f.a {
            AnonymousClass2() {
            }

            @Override // com.jumobile.manager.systemapp.ui.a.f.a
            public boolean a() {
                g.this.f = true;
                return false;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (b.this.t() && numArr[0].intValue() == 1) {
                this.d.a(numArr[1].intValue(), numArr[2].intValue());
                this.d.a(b.this.a(R.string.apk_file_install_entry, this.c));
                b.this.Y.notifyDataSetChanged();
            }
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.U.sendEmptyMessage(2);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$b */
    class HandlerC0096b extends Handler {
        HandlerC0096b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.a(message);
                    break;
                case 2:
                    if (b.this.ah != null) {
                        b.this.ah.c();
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
                case 1:
                    if (this.Z != null) {
                        this.Z.startAnimation(AnimationUtils.loadAnimation(this.ag, R.anim.rotate_circle));
                        break;
                    }
                    break;
                case 2:
                    at();
                    break;
            }
        }
        aC();
        if (this.Z != null) {
            this.Z.clearAnimation();
        }
    }

    private boolean aB() {
        return com.jumobile.manager.systemapp.h.a.c();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.ah.a(editable.toString());
    }

    /* compiled from: source */
    private class d extends Dialog implements DialogInterface.OnKeyListener, View.OnClickListener {
        public d(Context context) {
            super(context, R.style.BaseDialog);
            setContentView(R.layout.dialog_menu_apk_file_more);
            setCancelable(false);
            setCanceledOnTouchOutside(true);
            setOnKeyListener(this);
            Window window = getWindow();
            window.setGravity(21);
            window.setWindowAnimations(R.style.menu_dailog_anim);
            int a = com.jumobile.manager.systemapp.f.a.a(b.this.ag, "apk_file_extra_info", 0);
            CheckBox checkBox = (CheckBox) findViewById(R.id.extra_info_install_time);
            checkBox.setChecked((a & 2) != 0);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.d.1
                final /* synthetic */ b a;

                AnonymousClass1(b bVar) {
                    r2 = bVar;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    int a2 = com.jumobile.manager.systemapp.f.a.a(b.this.ag, "apk_file_extra_info", 0);
                    if (z) {
                        com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_extra_info", a2 | 2);
                    } else {
                        com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_extra_info", a2 & (-3));
                    }
                    b.this.at();
                }
            });
            CheckBox checkBox2 = (CheckBox) findViewById(R.id.extra_info_package_name);
            checkBox2.setChecked((a & 4) != 0);
            checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.d.2
                final /* synthetic */ b a;

                AnonymousClass2(b bVar) {
                    r2 = bVar;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    int a2 = com.jumobile.manager.systemapp.f.a.a(b.this.ag, "apk_file_extra_info", 0);
                    if (z) {
                        com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_extra_info", a2 | 4);
                    } else {
                        com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_extra_info", a2 & (-5));
                    }
                    b.this.at();
                }
            });
            CheckBox checkBox3 = (CheckBox) findViewById(R.id.extra_info_apk_path);
            checkBox3.setChecked((a & 8) != 0);
            checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.d.3
                final /* synthetic */ b a;

                AnonymousClass3(b bVar) {
                    r2 = bVar;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    int a2 = com.jumobile.manager.systemapp.f.a.a(b.this.ag, "apk_file_extra_info", 0);
                    if (z) {
                        com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_extra_info", a2 | 8);
                    } else {
                        com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_extra_info", a2 & (-9));
                    }
                    b.this.at();
                }
            });
            CheckBox checkBox4 = (CheckBox) findViewById(R.id.extra_info_filter_text);
            checkBox4.setChecked((a & 16) != 0);
            checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.d.4
                final /* synthetic */ b a;

                AnonymousClass4(b bVar) {
                    r2 = bVar;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    int a2 = com.jumobile.manager.systemapp.f.a.a(b.this.ag, "apk_file_extra_info", 0);
                    if (z) {
                        com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_extra_info", a2 | 16);
                    } else {
                        com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_extra_info", a2 & (-17));
                    }
                    b.this.ay();
                }
            });
            RadioButton radioButton = (RadioButton) findViewById(R.id.menu_sort_by_state);
            radioButton.setOnClickListener(this);
            RadioButton radioButton2 = (RadioButton) findViewById(R.id.menu_sort_by_label);
            radioButton2.setOnClickListener(this);
            RadioButton radioButton3 = (RadioButton) findViewById(R.id.menu_sort_by_size);
            radioButton3.setOnClickListener(this);
            RadioButton radioButton4 = (RadioButton) findViewById(R.id.menu_sort_by_time);
            radioButton4.setOnClickListener(this);
            RadioButton radioButton5 = (RadioButton) findViewById(R.id.menu_sort_by_file_name);
            radioButton5.setOnClickListener(this);
            switch (com.jumobile.manager.systemapp.f.a.a(b.this.ag, "apk_file_sort_by", 5)) {
                case 1:
                    radioButton2.setChecked(true);
                    break;
                case 2:
                    radioButton3.setChecked(true);
                    break;
                case 3:
                    radioButton4.setChecked(true);
                    break;
                case 4:
                default:
                    radioButton.setChecked(true);
                    break;
                case 5:
                    radioButton.setChecked(true);
                    break;
                case 6:
                    radioButton5.setChecked(true);
                    break;
            }
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$d$1 */
        class AnonymousClass1 implements CompoundButton.OnCheckedChangeListener {
            final /* synthetic */ b a;

            AnonymousClass1(b bVar) {
                r2 = bVar;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(b.this.ag, "apk_file_extra_info", 0);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_extra_info", a2 | 2);
                } else {
                    com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_extra_info", a2 & (-3));
                }
                b.this.at();
            }
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$d$2 */
        class AnonymousClass2 implements CompoundButton.OnCheckedChangeListener {
            final /* synthetic */ b a;

            AnonymousClass2(b bVar) {
                r2 = bVar;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(b.this.ag, "apk_file_extra_info", 0);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_extra_info", a2 | 4);
                } else {
                    com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_extra_info", a2 & (-5));
                }
                b.this.at();
            }
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$d$3 */
        class AnonymousClass3 implements CompoundButton.OnCheckedChangeListener {
            final /* synthetic */ b a;

            AnonymousClass3(b bVar) {
                r2 = bVar;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(b.this.ag, "apk_file_extra_info", 0);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_extra_info", a2 | 8);
                } else {
                    com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_extra_info", a2 & (-9));
                }
                b.this.at();
            }
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$d$4 */
        class AnonymousClass4 implements CompoundButton.OnCheckedChangeListener {
            final /* synthetic */ b a;

            AnonymousClass4(b bVar) {
                r2 = bVar;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(b.this.ag, "apk_file_extra_info", 0);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_extra_info", a2 | 16);
                } else {
                    com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_extra_info", a2 & (-17));
                }
                b.this.ay();
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
                case R.id.menu_sort_by_file_name /* 2131230979 */:
                    b.this.ah.j();
                    com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_sort_by", 6);
                    break;
                case R.id.menu_sort_by_label /* 2131230980 */:
                    b.this.ah.g();
                    com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_sort_by", 1);
                    break;
                case R.id.menu_sort_by_size /* 2131230982 */:
                    b.this.ah.h();
                    com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_sort_by", 2);
                    break;
                case R.id.menu_sort_by_state /* 2131230983 */:
                    b.this.ah.f();
                    com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_sort_by", 5);
                    break;
                case R.id.menu_sort_by_time /* 2131230984 */:
                    b.this.ah.i();
                    com.jumobile.manager.systemapp.f.a.b(b.this.ag, "apk_file_sort_by", 3);
                    break;
            }
        }
    }

    /* compiled from: source */
    private class c extends Dialog implements DialogInterface.OnKeyListener, View.OnClickListener {
        private CheckBox b;
        private CheckBox c;
        private CheckBox d;
        private CheckBox e;
        private CheckBox f;

        public c(Context context) {
            super(context, R.style.BaseDialog);
            setContentView(R.layout.dialog_menu_apk_file_more_buttons);
            setCancelable(false);
            setCanceledOnTouchOutside(true);
            setOnKeyListener(this);
            this.b = (CheckBox) findViewById(R.id.select_all);
            this.c = (CheckBox) findViewById(R.id.select_new);
            this.d = (CheckBox) findViewById(R.id.select_old);
            this.f = (CheckBox) findViewById(R.id.select_installed);
            this.e = (CheckBox) findViewById(R.id.select_other);
            this.b.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.e.setOnClickListener(this);
            findViewById(R.id.action_move_to_directory).setOnClickListener(this);
            findViewById(R.id.action_batch_rename).setOnClickListener(this);
            findViewById(R.id.action_delete_all_duplicate).setOnClickListener(this);
            a();
        }

        private void a() {
            int count = b.this.Y.getCount();
            int b = b.this.Y.b();
            this.b.setText(com.jumobile.manager.systemapp.util.f.a(b.this.ag, String.format(String.format("%s [%s, %s]", b.this.a(R.string.common_select_all), b.this.a(R.string.system_app_summary_total), b.this.a(R.string.system_app_summary_selected)), String.valueOf(count), String.valueOf(b)), R.color.green, String.valueOf(count), String.valueOf(b)));
            this.b.setChecked(count == b);
            int d = b.this.Y.d(3);
            int e = b.this.Y.e(3);
            this.c.setText(com.jumobile.manager.systemapp.util.f.a(b.this.ag, String.format(String.format("%s [%s, %s]", b.this.a(R.string.apk_file_intall_state_new_version), b.this.a(R.string.system_app_summary_total), b.this.a(R.string.system_app_summary_selected)), String.valueOf(d), String.valueOf(e)), R.color.green, String.valueOf(d), String.valueOf(e)));
            this.c.setChecked(d == e);
            int d2 = b.this.Y.d(1);
            int e2 = b.this.Y.e(1);
            this.d.setText(com.jumobile.manager.systemapp.util.f.a(b.this.ag, String.format(String.format("%s [%s, %s]", b.this.a(R.string.apk_file_intall_state_old_version), b.this.a(R.string.system_app_summary_total), b.this.a(R.string.system_app_summary_selected)), String.valueOf(d2), String.valueOf(e2)), R.color.green, String.valueOf(d2), String.valueOf(e2)));
            this.d.setChecked(d2 == e2);
            int d3 = b.this.Y.d(2);
            int e3 = b.this.Y.e(2);
            this.f.setText(com.jumobile.manager.systemapp.util.f.a(b.this.ag, String.format(String.format("%s [%s, %s]", b.this.a(R.string.apk_file_intall_state_installed), b.this.a(R.string.system_app_summary_total), b.this.a(R.string.system_app_summary_selected)), String.valueOf(d3), String.valueOf(e3)), R.color.green, String.valueOf(d3), String.valueOf(e3)));
            this.f.setChecked(d3 == e3);
            int d4 = b.this.Y.d(0);
            int e4 = b.this.Y.e(0);
            this.e.setText(com.jumobile.manager.systemapp.util.f.a(b.this.ag, String.format(String.format("%s [%s, %s]", b.this.a(R.string.common_select_other), b.this.a(R.string.system_app_summary_total), b.this.a(R.string.system_app_summary_selected)), String.valueOf(d4), String.valueOf(e4)), R.color.green, String.valueOf(d4), String.valueOf(e4)));
            this.e.setChecked(d4 == e4);
            b.this.az();
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
                return;
            }
            int id = view.getId();
            if (id == R.id.action_batch_rename) {
                if (b.this.Y.a().size() <= 0) {
                    com.jumobile.manager.systemapp.util.f.a(b.this.ag, R.string.apk_file_install_no_target);
                    return;
                }
                FragmentActivity m = b.this.m();
                if (m != null) {
                    com.jumobile.manager.systemapp.ui.a.b bVar = new com.jumobile.manager.systemapp.ui.a.b(m);
                    bVar.a(b.this.ag.getString(R.string.apk_file_btn_batch_raname));
                    bVar.a(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.c.1
                        AnonymousClass1() {
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (b.this.ao == null) {
                                b.this.ao = b.this.new f(b.this.Y.a());
                                b.this.ao.execute(new Integer[0]);
                            }
                        }
                    });
                    if (!m.isFinishing()) {
                        bVar.show();
                    }
                }
                dismiss();
                return;
            }
            if (id == R.id.action_delete_all_duplicate) {
                if (b.this.ah.a(false) <= 0) {
                    com.jumobile.manager.systemapp.util.f.a(b.this.ag, R.string.apk_file_btn_delete_all_duplicate_none);
                    return;
                }
                b.this.at();
                b.this.aA();
                dismiss();
                return;
            }
            if (id == R.id.action_move_to_directory) {
                if (b.this.Y.a().size() <= 0) {
                    com.jumobile.manager.systemapp.util.f.a(b.this.ag, R.string.apk_file_install_no_target);
                    return;
                }
                FragmentActivity m2 = b.this.m();
                if (m2 != null) {
                    b.this.a(new Intent(m2, (Class<?>) DirectoryChooserActivity.class), 5);
                    m2.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                }
                dismiss();
                return;
            }
            if (id != R.id.select_all) {
                switch (id) {
                    case R.id.select_installed /* 2131231045 */:
                        b.this.Y.c(2);
                        b.this.Y.notifyDataSetChanged();
                        a();
                        break;
                    case R.id.select_new /* 2131231046 */:
                        b.this.Y.c(3);
                        b.this.Y.notifyDataSetChanged();
                        a();
                        break;
                    case R.id.select_old /* 2131231047 */:
                        b.this.Y.c(1);
                        b.this.Y.notifyDataSetChanged();
                        a();
                        break;
                    case R.id.select_other /* 2131231048 */:
                        b.this.Y.c(0);
                        b.this.Y.notifyDataSetChanged();
                        a();
                        break;
                }
                return;
            }
            b.this.Y.a(!b.this.Y.d());
            b.this.Y.notifyDataSetChanged();
            a();
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$c$1 */
        class AnonymousClass1 implements View.OnClickListener {
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.ao == null) {
                    b.this.ao = b.this.new f(b.this.Y.a());
                    b.this.ao.execute(new Integer[0]);
                }
            }
        }
    }

    /* compiled from: source */
    private class e extends AsyncTask<Integer, Integer, Integer> {
        private ArrayList<com.jumobile.manager.systemapp.d.a> b;
        private final String c;
        private String d;
        private final boolean g;
        private int e = 0;
        private int f = 0;
        private com.jumobile.manager.systemapp.ui.a.f h = null;
        private boolean i = false;
        private final int j = 1;
        private final int k = 1;
        private final int l = 2;

        public e(ArrayList<com.jumobile.manager.systemapp.d.a> arrayList, String str, boolean z) {
            this.b = null;
            this.b = arrayList;
            this.c = str;
            this.g = z;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(Integer... numArr) {
            int size = this.b.size();
            File file = new File(this.c);
            int i = 0;
            while (i < this.b.size()) {
                com.jumobile.manager.systemapp.d.a aVar = this.b.get(i);
                if (this.i) {
                    return 1;
                }
                aVar.i = false;
                this.d = aVar.f;
                i++;
                publishProgress(1, Integer.valueOf(i), Integer.valueOf(this.b.size()));
                try {
                    File file2 = new File(aVar.a);
                    String str = file.getPath() + "/" + file2.getName();
                    File file3 = new File(str);
                    if (aVar.a.equals(str)) {
                        this.e++;
                    } else if (file3.exists() && file2.length() == file3.length()) {
                        if (this.g) {
                            file2.delete();
                            this.f++;
                        }
                    } else {
                        this.e++;
                        if (!file2.renameTo(file3)) {
                            com.jumobile.manager.systemapp.util.a.a(aVar.a, str);
                            file2.delete();
                        }
                    }
                } catch (Exception unused) {
                }
            }
            publishProgress(1, Integer.valueOf(size), Integer.valueOf(size));
            return 2;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            FragmentActivity m = b.this.m();
            if (m == null) {
                return;
            }
            this.h = new com.jumobile.manager.systemapp.ui.a.f(m);
            this.h.a(0, this.b.size());
            this.h.setCancelable(true);
            this.h.a(new f.a() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.e.1
                AnonymousClass1() {
                }

                @Override // com.jumobile.manager.systemapp.ui.a.f.a
                public boolean a() {
                    e.this.i = true;
                    return false;
                }
            });
            if (this.b.size() == 1) {
                this.h.f.setVisibility(8);
            }
            if (m.isFinishing()) {
                return;
            }
            this.h.show();
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$e$1 */
        class AnonymousClass1 implements f.a {
            AnonymousClass1() {
            }

            @Override // com.jumobile.manager.systemapp.ui.a.f.a
            public boolean a() {
                e.this.i = true;
                return false;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (b.this.t() && numArr[0].intValue() == 1) {
                this.h.a(numArr[1].intValue(), numArr[2].intValue());
                this.h.a(b.this.a(R.string.move_app_move_entry, this.d));
                b.this.Y.notifyDataSetChanged();
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Integer num) {
            SpannableStringBuilder a;
            super.onPostExecute(num);
            try {
                this.h.dismiss();
            } catch (Exception e) {
                Log.w(b.X, "Failed to dismiss mProgressDialog: " + e.getMessage());
            }
            b.this.an = null;
            b.this.ah.d();
            FragmentActivity m = b.this.m();
            if (m == null) {
                return;
            }
            if (this.f > 0) {
                a = com.jumobile.manager.systemapp.util.f.a(b.this.ag, String.format(String.format("%s\n%%s\n%s", b.this.a(R.string.apk_file_move_to_directory_result_moved), b.this.a(R.string.apk_file_move_to_directory_result_deleted)), String.valueOf(this.e), this.c, String.valueOf(this.f)), R.color.green, String.valueOf(this.e), this.c, String.valueOf(this.f));
            } else {
                a = com.jumobile.manager.systemapp.util.f.a(b.this.ag, String.format(String.format("%s\n%%s", b.this.a(R.string.apk_file_move_to_directory_result_moved)), String.valueOf(this.e), this.c), R.color.green, String.valueOf(this.e), this.c);
            }
            Intent intent = new Intent(m, (Class<?>) ResultActivity.class);
            intent.putExtra("extra_title", m.getString(R.string.common_hint));
            intent.putExtra("extra_message", a);
            m.startActivity(intent);
            m.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        }
    }

    /* compiled from: source */
    private class f extends AsyncTask<Integer, Integer, Integer> {
        private ArrayList<com.jumobile.manager.systemapp.d.a> b;
        private String c;
        private int d = 0;
        private com.jumobile.manager.systemapp.ui.a.f e = null;
        private boolean f = false;
        private final int g = 1;
        private final int h = 1;
        private final int i = 2;

        public f(ArrayList<com.jumobile.manager.systemapp.d.a> arrayList) {
            this.b = null;
            this.b = arrayList;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(Integer... numArr) {
            int size = this.b.size();
            int i = 0;
            while (i < this.b.size()) {
                com.jumobile.manager.systemapp.d.a aVar = this.b.get(i);
                if (this.f) {
                    return 1;
                }
                aVar.i = false;
                this.c = aVar.f;
                i++;
                publishProgress(1, Integer.valueOf(i), Integer.valueOf(this.b.size()));
                try {
                    File file = new File(aVar.a);
                    String str = file.getParent() + "/" + aVar.c(b.this.ag);
                    File file2 = new File(str);
                    if (aVar.a.equals(str)) {
                        this.d++;
                    } else if (!file2.exists() || file2.length() == file.length()) {
                        if (file.renameTo(file2)) {
                            this.d++;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            publishProgress(1, Integer.valueOf(size), Integer.valueOf(size));
            return 2;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            FragmentActivity m = b.this.m();
            if (m == null) {
                return;
            }
            this.e = new com.jumobile.manager.systemapp.ui.a.f(m);
            this.e.a(0, this.b.size());
            this.e.setCancelable(true);
            this.e.a(new f.a() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.f.1
                AnonymousClass1() {
                }

                @Override // com.jumobile.manager.systemapp.ui.a.f.a
                public boolean a() {
                    f.this.f = true;
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
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$f$1 */
        class AnonymousClass1 implements f.a {
            AnonymousClass1() {
            }

            @Override // com.jumobile.manager.systemapp.ui.a.f.a
            public boolean a() {
                f.this.f = true;
                return false;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (b.this.t() && numArr[0].intValue() == 1) {
                this.e.a(numArr[1].intValue(), numArr[2].intValue());
                this.e.a(b.this.a(R.string.move_app_move_entry, this.c));
                b.this.Y.notifyDataSetChanged();
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            try {
                this.e.dismiss();
            } catch (Exception e) {
                Log.w(b.X, "Failed to dismiss mProgressDialog: " + e.getMessage());
            }
            b.this.ao = null;
            b.this.ah.d();
            FragmentActivity m = b.this.m();
            if (m == null) {
                return;
            }
            Intent intent = new Intent(m, (Class<?>) ResultActivity.class);
            intent.putExtra("extra_title", m.getString(R.string.common_hint));
            intent.putExtra("extra_message", m.getString(R.string.apk_file_btn_batch_raname_result, new Object[]{String.valueOf(this.d)}));
            m.startActivity(intent);
            m.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        }
    }

    @Override // com.jumobile.manager.systemapp.ui.fragment.c
    public boolean av() {
        return this.ai.f();
    }

    private boolean aC() {
        ArrayList arrayList = new ArrayList();
        if (androidx.core.content.a.b(this.ag, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (arrayList.size() == 0) {
            return true;
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        a(strArr, 11);
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
        if (i == 11) {
            if (a(iArr)) {
                this.ah.d();
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
            eVar.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.b.5
                final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

                AnonymousClass5(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                    eVar = eVar2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.parse("package:" + b.this.ag.getPackageName()));
                    b.this.a(intent);
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
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.b$5 */
    class AnonymousClass5 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass5(com.jumobile.manager.systemapp.ui.a.e eVar2) {
            eVar = eVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + b.this.ag.getPackageName()));
            b.this.a(intent);
            eVar.dismiss();
        }
    }
}
