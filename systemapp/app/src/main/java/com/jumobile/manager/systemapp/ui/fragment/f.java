package com.jumobile.manager.systemapp.ui.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
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
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public class f extends com.jumobile.manager.systemapp.ui.fragment.c implements TextWatcher, View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private static final String X = "f";
    private Context Z;
    private e aa;
    private com.jumobile.manager.systemapp.c.f ab;
    private TextView ac;
    private TextView ad;
    private ListView ae;
    private Button af;
    private View ag;
    private EditText aj;
    private BroadcastReceiver am;
    private ImageButton an;
    private int Y = 1;
    private CheckBox ah = null;
    private boolean ai = false;
    final a U = new a();
    private int ak = 4;
    private com.jumobile.manager.systemapp.a.b al = com.jumobile.manager.systemapp.a.b.j();
    private boolean ao = false;
    private c ap = null;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void e(int i) {
        this.Y = i;
    }

    @Override // androidx.fragment.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.Z = activity.getApplicationContext();
        this.ak = com.jumobile.manager.systemapp.f.a.a(this.Z, "system_app_sort_by", 4);
    }

    @Override // androidx.fragment.app.Fragment
    public void f(Bundle bundle) {
        super.f(bundle);
        this.ab = new com.jumobile.manager.systemapp.c.f(this.Z);
        this.ab.a(true);
        this.ab.a(this.U, 1);
        this.aa = new e(this.Z, this.Y);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.f$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.jumobile.manager.systemapp.h.a.c()) {
                f.this.ao = true;
            } else {
                f.this.ao = false;
            }
            f.this.U.sendEmptyMessage(2);
        }
    }

    public void aw() {
        new Thread(new Runnable() { // from class: com.jumobile.manager.systemapp.ui.fragment.f.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.jumobile.manager.systemapp.h.a.c()) {
                    f.this.ao = true;
                } else {
                    f.this.ao = false;
                }
                f.this.U.sendEmptyMessage(2);
            }
        }).start();
    }

    @Override // androidx.fragment.app.Fragment
    public void K() {
        if (this.am != null) {
            androidx.f.a.a.a(this.Z.getApplicationContext()).a(this.am);
        }
        this.al.k();
        if (this.ab != null) {
            this.ab.a(this.U);
            this.ab.a();
        }
        super.K();
    }

    @Override // androidx.fragment.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_move_app, viewGroup, false);
        d(inflate);
        this.al.a(this, inflate);
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

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.f$2 */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentActivity m = f.this.m();
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
        actionBar.a.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.f.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FragmentActivity m = f.this.m();
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
        actionBar.setEditChangeListener(this);
        if (com.jumobile.manager.systemapp.f.a.a(this.Z, "move_app_show_long_press_hint", true)) {
            View findViewById = view.findViewById(R.id.long_press_hint);
            findViewById.setVisibility(0);
            view.findViewById(R.id.long_press_hint_btn_i_know).setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.f.3
                final /* synthetic */ View a;

                AnonymousClass3(View findViewById2) {
                    findViewById = findViewById2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    findViewById.setVisibility(8);
                    com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_show_long_press_hint", false);
                }
            });
        }
        this.aj = (EditText) view.findViewById(R.id.filter_edit_text);
        ax();
        this.ac = (TextView) view.findViewById(R.id.summary_total);
        this.ad = (TextView) view.findViewById(R.id.summary_selected);
        this.ae = (ListView) view.findViewById(android.R.id.list);
        this.ae.setEmptyView((TextView) view.findViewById(R.id.list_empty_view));
        this.ae.setOnItemClickListener(this);
        this.ae.setOnItemLongClickListener(this);
        this.ae.setAdapter((ListAdapter) this.aa);
        this.ah = (CheckBox) view.findViewById(R.id.checkbox_select_all);
        this.ag = view.findViewById(R.id.btn_container);
        this.af = (Button) view.findViewById(R.id.btn_move);
        this.af.setOnClickListener(this);
        this.ah.setChecked(false);
        this.ai = false;
        this.ah.setOnClickListener(this);
        switch (this.Y) {
            case 1:
                actionBar.b.setText(R.string.move_app_title_to_sdcard);
                this.af.setText(R.string.move_app_btn_move_to_sdcard);
                break;
            case 2:
                actionBar.b.setText(R.string.move_app_title_to_phone);
                this.af.setText(R.string.move_app_btn_move_to_phone);
                break;
        }
        if (com.jumobile.manager.systemapp.f.a.a(this.Z, "ads_enabled", true)) {
            this.an = actionBar.a(R.drawable.remove_ads, new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.f.4
                AnonymousClass4() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    FragmentActivity m = f.this.m();
                    if (m != null) {
                        androidx.f.a.a.a(f.this.Z.getApplicationContext()).a(new Intent(m.getClass().getName() + "SHOW_DIALOG"));
                    }
                }
            });
            this.am = new BroadcastReceiver() { // from class: com.jumobile.manager.systemapp.ui.fragment.f.5
                AnonymousClass5() {
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    f.this.al.h();
                    f.this.an.setVisibility(8);
                }
            };
            androidx.f.a.a.a(this.Z).a(this.am, new IntentFilter("com.jumobile.manager.systemapp.ACTION_ADS_REMOVED"));
        }
        actionBar.a(R.drawable.ic_action_menu, new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.f.6
            AnonymousClass6() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FragmentActivity m = f.this.m();
                if (m != null) {
                    b bVar = f.this.new b(m);
                    if (m.isFinishing()) {
                        return;
                    }
                    bVar.show();
                }
            }
        });
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.f$3 */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ View a;

        AnonymousClass3(View findViewById2) {
            findViewById = findViewById2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            findViewById.setVisibility(8);
            com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_show_long_press_hint", false);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.f$4 */
    class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            FragmentActivity m = f.this.m();
            if (m != null) {
                androidx.f.a.a.a(f.this.Z.getApplicationContext()).a(new Intent(m.getClass().getName() + "SHOW_DIALOG"));
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.f$5 */
    class AnonymousClass5 extends BroadcastReceiver {
        AnonymousClass5() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            f.this.al.h();
            f.this.an.setVisibility(8);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.f$6 */
    class AnonymousClass6 implements View.OnClickListener {
        AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            FragmentActivity m = f.this.m();
            if (m != null) {
                b bVar = f.this.new b(m);
                if (m.isFinishing()) {
                    return;
                }
                bVar.show();
            }
        }
    }

    public void ax() {
        if ((com.jumobile.manager.systemapp.f.a.a(this.Z, "move_app_extra_info", 0) & 16) != 0) {
            this.aj.setVisibility(0);
            this.aj.requestFocus();
            this.aj.addTextChangedListener(this);
            return;
        }
        this.aj.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ap != null) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_move) {
            if (id != R.id.checkbox_select_all) {
                return;
            }
            this.ai = !this.ai;
            this.ah.setChecked(this.ai);
            this.aa.b(this.ai);
            this.aa.notifyDataSetChanged();
            az();
            return;
        }
        if (!this.ao) {
            com.jumobile.manager.systemapp.util.f.a(this.Z, R.string.system_app_dialog_title_no_root);
            return;
        }
        ArrayList<com.jumobile.manager.systemapp.d.g> b2 = this.aa.b();
        if (b2.size() > 0) {
            if (this.ap == null) {
                this.ap = new c(b2);
                this.ap.execute(new Integer[0]);
                return;
            }
            return;
        }
        com.jumobile.manager.systemapp.util.f.a(this.Z, R.string.move_app_no_target_to_uninstall);
    }

    public void at() {
        this.aa.a(ay());
        this.aa.a(this.ao);
        this.aa.notifyDataSetChanged();
        az();
        if (this.ao) {
            this.ag.setVisibility(0);
            this.ai = this.aa.a();
            this.ah.setChecked(this.ai);
            return;
        }
        this.ag.setVisibility(8);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x005f, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.ArrayList<com.jumobile.manager.systemapp.d.g> ay() {
        /*
            r4 = this;
            com.jumobile.manager.systemapp.c.f r0 = r4.ab
            java.util.ArrayList r0 = r0.b()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r4.Y
            switch(r2) {
                case 1: goto L38;
                case 2: goto L11;
                default: goto L10;
            }
        L10:
            goto L5f
        L11:
            java.util.Iterator r0 = r0.iterator()
        L15:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L5f
            java.lang.Object r2 = r0.next()
            com.jumobile.manager.systemapp.d.g r2 = (com.jumobile.manager.systemapp.d.g) r2
            boolean r3 = r2.b()
            if (r3 != 0) goto L15
            boolean r3 = r2.c()
            if (r3 == 0) goto L2e
            goto L15
        L2e:
            boolean r3 = r2.a()
            if (r3 == 0) goto L15
            r1.add(r2)
            goto L15
        L38:
            java.util.Iterator r0 = r0.iterator()
        L3c:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L5f
            java.lang.Object r2 = r0.next()
            com.jumobile.manager.systemapp.d.g r2 = (com.jumobile.manager.systemapp.d.g) r2
            boolean r3 = r2.b()
            if (r3 != 0) goto L3c
            boolean r3 = r2.c()
            if (r3 == 0) goto L55
            goto L3c
        L55:
            boolean r3 = r2.a()
            if (r3 != 0) goto L3c
            r1.add(r2)
            goto L3c
        L5f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumobile.manager.systemapp.ui.fragment.f.ay():java.util.ArrayList");
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.jumobile.manager.systemapp.d.g a2;
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox_app_selected);
        if (checkBox == null || (a2 = this.aa.a(i)) == null) {
            return;
        }
        if (!this.ao) {
            if (com.jumobile.manager.systemapp.d.g.l != a2.a(this.Z)) {
                com.jumobile.manager.systemapp.util.f.a(this.Z, R.string.move_app_toast_need_root_permission);
                return;
            }
            this.ab.a(a2);
            switch (this.Y) {
                case 1:
                    com.jumobile.manager.systemapp.util.f.a(this.Z, this.Z.getString(R.string.move_app_toast_click_move_button, this.Z.getString(R.string.move_app_btn_move_to_sdcard)), 1);
                    break;
                case 2:
                    com.jumobile.manager.systemapp.util.f.a(this.Z, this.Z.getString(R.string.move_app_toast_click_move_button, this.Z.getString(R.string.move_app_btn_move_to_phone)), 1);
                    break;
            }
            return;
        }
        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
            a2.i = false;
            this.ah.setChecked(false);
            this.ai = false;
        } else {
            checkBox.setChecked(true);
            a2.i = true;
            if (this.aa.a()) {
                this.ai = true;
                this.ah.setChecked(true);
            }
        }
        this.aa.notifyDataSetChanged();
        az();
    }

    public void az() {
        long d = this.aa.d();
        int i = this.Y == 1 ? R.string.move_app_btn_move_to_sdcard : R.string.move_app_btn_move_to_phone;
        if (0 == d) {
            this.af.setText(i);
        } else {
            this.af.setText(this.Z.getString(i) + this.Z.getString(R.string.common_note, com.jumobile.manager.systemapp.util.f.a(d)));
        }
        this.ac.setText(com.jumobile.manager.systemapp.util.f.a(this.Z, R.string.system_app_summary_total, R.color.green, String.valueOf(this.aa.getCount())));
        if (this.ao) {
            this.ad.setVisibility(0);
            this.ad.setText(com.jumobile.manager.systemapp.util.f.a(this.Z, R.string.system_app_summary_selected, R.color.green, String.valueOf(this.aa.c())));
        } else {
            this.ad.setVisibility(8);
        }
    }

    /* compiled from: source */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    a(message);
                    break;
                case 2:
                    f.this.at();
                    break;
            }
        }

        private void a(Message message) {
            int i = message.arg1;
            if (i == 4) {
                f.this.aw();
            }
            switch (i) {
                case 2:
                    f.this.at();
                    break;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void F() {
        super.F();
        if (this.ap != null) {
            this.ap.a();
        }
        aA();
    }

    private void aA() {
        int a2 = com.jumobile.manager.systemapp.f.a.a(this.Z, "system_app_sort_by", 4);
        if (a2 == this.ak) {
        }
        this.ak = a2;
        switch (a2) {
            case 1:
                this.ab.d();
                break;
            case 2:
                this.ab.e();
                break;
            case 3:
                this.ab.f();
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void I() {
        if (this.ap != null) {
            this.ap.b();
        }
        super.I();
    }

    /* compiled from: source */
    private class c extends AsyncTask<Integer, Integer, Integer> {
        private ArrayList<com.jumobile.manager.systemapp.d.g> g;
        private final int b = 1;
        private final int c = 1;
        private final int d = 2;
        private final int e = 3;
        private final int f = 4;
        private String h = "";
        private boolean i = false;
        private int j = 0;
        private com.jumobile.manager.systemapp.ui.a.f k = null;

        public c(ArrayList<com.jumobile.manager.systemapp.d.g> arrayList) {
            this.g = null;
            this.g = arrayList;
        }

        public void a() {
            if (this.k != null) {
                this.k.show();
            }
        }

        public void b() {
            if (this.k != null) {
                this.k.dismiss();
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            FragmentActivity m = f.this.m();
            if (m == null) {
                return;
            }
            this.k = new com.jumobile.manager.systemapp.ui.a.f(m);
            this.k.a(0, this.g.size());
            this.k.setCancelable(true);
            this.k.a(new f.a() { // from class: com.jumobile.manager.systemapp.ui.fragment.f.c.1
                AnonymousClass1() {
                }

                @Override // com.jumobile.manager.systemapp.ui.a.f.a
                public boolean a() {
                    c.this.i = true;
                    return false;
                }
            });
            if (this.g.size() == 1) {
                this.k.f.setVisibility(8);
            }
            if (m.isFinishing()) {
                return;
            }
            this.k.show();
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.f$c$1 */
        class AnonymousClass1 implements f.a {
            AnonymousClass1() {
            }

            @Override // com.jumobile.manager.systemapp.ui.a.f.a
            public boolean a() {
                c.this.i = true;
                return false;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(Integer... numArr) {
            int a;
            for (int i = 0; i < this.g.size(); i++) {
                com.jumobile.manager.systemapp.d.g gVar = this.g.get(i);
                if (this.i) {
                    return 1;
                }
                this.h = gVar.f;
                try {
                    publishProgress(1, Integer.valueOf(i), Integer.valueOf(this.g.size()));
                    switch (f.this.Y) {
                        case 1:
                            a = com.jumobile.manager.systemapp.b.a.a(f.this.Z, gVar.b.packageName);
                            break;
                        case 2:
                            a = com.jumobile.manager.systemapp.b.a.b(f.this.Z, gVar.b.packageName);
                            break;
                        default:
                            a = 0;
                            break;
                    }
                } catch (Exception unused) {
                }
                if (a == -101) {
                    return 4;
                }
                if (a == 0) {
                    gVar.i = false;
                    this.j++;
                } else {
                    return 3;
                }
            }
            return 2;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (f.this.t() && numArr[0].intValue() == 1) {
                this.k.a(numArr[1].intValue(), numArr[2].intValue());
                this.k.a(f.this.a(R.string.move_app_move_entry, this.h));
                f.this.az();
                f.this.aa.notifyDataSetChanged();
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            try {
                this.k.dismiss();
            } catch (Exception e) {
                Log.w(f.X, "Failed to dismiss mProgressDialog: " + e.getMessage());
            }
            f.this.az();
            f.this.aa.notifyDataSetChanged();
            this.k = null;
            f.this.ap = null;
            FragmentActivity m = f.this.m();
            if (m == null) {
                return;
            }
            switch (num.intValue()) {
                case 1:
                case 2:
                    if (this.j > 0) {
                        Intent intent = new Intent(m, (Class<?>) ResultActivity.class);
                        intent.putExtra("extra_title", m.getString(R.string.common_hint));
                        intent.putExtra("extra_message", m.getString(R.string.move_app_toast_move_result, new Object[]{Integer.valueOf(this.j)}));
                        m.startActivity(intent);
                        m.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                        break;
                    }
                    break;
                case 4:
                    com.jumobile.manager.systemapp.ui.a.e eVar = new com.jumobile.manager.systemapp.ui.a.e(m, R.string.move_app_failed_insufficient_storage);
                    eVar.setTitle(R.string.common_warning);
                    eVar.g.setVisibility(8);
                    eVar.h.setBackgroundResource(R.drawable.selector_btn_recommend);
                    eVar.h.setText(R.string.common_yes);
                    if (!m.isFinishing()) {
                        eVar.show();
                        break;
                    }
                    break;
            }
            if (f.this.aa.a()) {
                f.this.ai = true;
                f.this.ah.setChecked(true);
            } else {
                f.this.ai = false;
                f.this.ah.setChecked(false);
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.jumobile.manager.systemapp.d.g a2 = this.aa.a(i);
        if (a2 == null) {
            return false;
        }
        a(a2);
        return false;
    }

    private void a(com.jumobile.manager.systemapp.d.g gVar) {
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

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.ab.a(editable.toString());
    }

    /* compiled from: source */
    private class b extends Dialog implements DialogInterface.OnKeyListener, View.OnClickListener {
        public b(Context context) {
            super(context, R.style.BaseDialog);
            setContentView(R.layout.dialog_menu_move_app_more);
            setCancelable(false);
            setCanceledOnTouchOutside(true);
            setOnKeyListener(this);
            Window window = getWindow();
            window.setGravity(21);
            window.setWindowAnimations(R.style.menu_dailog_anim);
            int a = com.jumobile.manager.systemapp.f.a.a(f.this.Z, "move_app_extra_info", 0);
            CheckBox checkBox = (CheckBox) findViewById(R.id.extra_info_install_time);
            checkBox.setChecked((a & 2) != 0);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.f.b.1
                final /* synthetic */ f a;

                AnonymousClass1(f fVar) {
                    r2 = fVar;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    int a2 = com.jumobile.manager.systemapp.f.a.a(f.this.Z, "move_app_extra_info", 0);
                    if (z) {
                        com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_extra_info", a2 | 2);
                    } else {
                        com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_extra_info", a2 & (-3));
                    }
                    f.this.at();
                }
            });
            CheckBox checkBox2 = (CheckBox) findViewById(R.id.extra_info_package_name);
            checkBox2.setChecked((a & 4) != 0);
            checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.f.b.2
                final /* synthetic */ f a;

                AnonymousClass2(f fVar) {
                    r2 = fVar;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    int a2 = com.jumobile.manager.systemapp.f.a.a(f.this.Z, "move_app_extra_info", 0);
                    if (z) {
                        com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_extra_info", a2 | 4);
                    } else {
                        com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_extra_info", a2 & (-5));
                    }
                    f.this.at();
                }
            });
            CheckBox checkBox3 = (CheckBox) findViewById(R.id.extra_info_apk_path);
            checkBox3.setChecked((a & 8) != 0);
            checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.f.b.3
                final /* synthetic */ f a;

                AnonymousClass3(f fVar) {
                    r2 = fVar;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    int a2 = com.jumobile.manager.systemapp.f.a.a(f.this.Z, "move_app_extra_info", 0);
                    if (z) {
                        com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_extra_info", a2 | 8);
                    } else {
                        com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_extra_info", a2 & (-9));
                    }
                    f.this.at();
                }
            });
            CheckBox checkBox4 = (CheckBox) findViewById(R.id.extra_info_filter_text);
            checkBox4.setChecked((a & 16) != 0);
            checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.f.b.4
                final /* synthetic */ f a;

                AnonymousClass4(f fVar) {
                    r2 = fVar;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    int a2 = com.jumobile.manager.systemapp.f.a.a(f.this.Z, "move_app_extra_info", 0);
                    if (z) {
                        com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_extra_info", a2 | 16);
                    } else {
                        com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_extra_info", a2 & (-17));
                    }
                    f.this.ax();
                }
            });
            RadioButton radioButton = (RadioButton) findViewById(R.id.menu_sort_by_movable);
            radioButton.setOnClickListener(this);
            RadioButton radioButton2 = (RadioButton) findViewById(R.id.menu_sort_by_label);
            radioButton2.setOnClickListener(this);
            RadioButton radioButton3 = (RadioButton) findViewById(R.id.menu_sort_by_size);
            radioButton3.setOnClickListener(this);
            RadioButton radioButton4 = (RadioButton) findViewById(R.id.menu_sort_by_time);
            radioButton4.setOnClickListener(this);
            int a2 = com.jumobile.manager.systemapp.f.a.a(f.this.Z, "move_app_sort_by", 7);
            if (a2 == 7) {
                radioButton.setChecked(true);
            }
            switch (a2) {
                case 1:
                    radioButton2.setChecked(true);
                    break;
                case 2:
                    radioButton3.setChecked(true);
                    break;
                case 3:
                    radioButton4.setChecked(true);
                    break;
                default:
                    radioButton.setChecked(true);
                    break;
            }
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.f$b$1 */
        class AnonymousClass1 implements CompoundButton.OnCheckedChangeListener {
            final /* synthetic */ f a;

            AnonymousClass1(f fVar) {
                r2 = fVar;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(f.this.Z, "move_app_extra_info", 0);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_extra_info", a2 | 2);
                } else {
                    com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_extra_info", a2 & (-3));
                }
                f.this.at();
            }
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.f$b$2 */
        class AnonymousClass2 implements CompoundButton.OnCheckedChangeListener {
            final /* synthetic */ f a;

            AnonymousClass2(f fVar) {
                r2 = fVar;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(f.this.Z, "move_app_extra_info", 0);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_extra_info", a2 | 4);
                } else {
                    com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_extra_info", a2 & (-5));
                }
                f.this.at();
            }
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.f$b$3 */
        class AnonymousClass3 implements CompoundButton.OnCheckedChangeListener {
            final /* synthetic */ f a;

            AnonymousClass3(f fVar) {
                r2 = fVar;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(f.this.Z, "move_app_extra_info", 0);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_extra_info", a2 | 8);
                } else {
                    com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_extra_info", a2 & (-9));
                }
                f.this.at();
            }
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.f$b$4 */
        class AnonymousClass4 implements CompoundButton.OnCheckedChangeListener {
            final /* synthetic */ f a;

            AnonymousClass4(f fVar) {
                r2 = fVar;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(f.this.Z, "move_app_extra_info", 0);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_extra_info", a2 | 16);
                } else {
                    com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_extra_info", a2 & (-17));
                }
                f.this.ax();
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
                case R.id.menu_sort_by_label /* 2131230980 */:
                    f.this.ab.d();
                    com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_sort_by", 1);
                    break;
                case R.id.menu_sort_by_movable /* 2131230981 */:
                    f.this.ab.h();
                    com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_sort_by", 7);
                    break;
                case R.id.menu_sort_by_size /* 2131230982 */:
                    f.this.ab.e();
                    com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_sort_by", 2);
                    break;
                case R.id.menu_sort_by_time /* 2131230984 */:
                    f.this.ab.f();
                    com.jumobile.manager.systemapp.f.a.b(f.this.Z, "move_app_sort_by", 3);
                    break;
            }
        }
    }

    @Override // com.jumobile.manager.systemapp.ui.fragment.c
    public boolean av() {
        return this.al.f();
    }
}
