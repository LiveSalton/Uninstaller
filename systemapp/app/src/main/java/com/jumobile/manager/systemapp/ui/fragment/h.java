package com.jumobile.manager.systemapp.ui.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
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
import com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity;
import com.jumobile.manager.systemapp.ui.activity.ResultActivity;
import com.jumobile.manager.systemapp.ui.widget.ActionBar;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public class h extends com.jumobile.manager.systemapp.ui.fragment.c implements TextWatcher, View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private static final String X = "h";
    private Context Y;
    private g Z;
    private com.jumobile.manager.systemapp.c.e aa;
    private TextView ab;
    private TextView ac;
    private ListView ad;
    private Button ae;
    private EditText af;
    private BroadcastReceiver ai;
    private ImageButton aj;
    final b U = new b();
    private int ag = 4;
    private com.jumobile.manager.systemapp.a.b ah = com.jumobile.manager.systemapp.a.b.j();
    private d ak = null;
    private a al = null;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // androidx.fragment.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.Y = activity.getApplicationContext();
        this.ag = com.jumobile.manager.systemapp.f.a.a(this.Y, "system_app_sort_by", 4);
    }

    @Override // androidx.fragment.app.Fragment
    public void f(Bundle bundle) {
        super.f(bundle);
        this.aa = new com.jumobile.manager.systemapp.c.e(this.Y);
        this.aa.a(this.U, 1);
        this.Z = new g(this.Y);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.jumobile.manager.systemapp.h.a.c()) {
                return;
            }
            h.this.U.sendEmptyMessage(2);
        }
    }

    public void aw() {
        new Thread(new Runnable() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.jumobile.manager.systemapp.h.a.c()) {
                    return;
                }
                h.this.U.sendEmptyMessage(2);
            }
        }).start();
    }

    @Override // androidx.fragment.app.Fragment
    public void K() {
        if (this.ai != null) {
            androidx.f.a.a.a(this.Y.getApplicationContext()).a(this.ai);
        }
        this.ah.k();
        if (this.aa != null) {
            this.aa.a(this.U);
            this.aa.a();
        }
        super.K();
    }

    @Override // androidx.fragment.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_system_app, viewGroup, false);
        d(inflate);
        this.ah.a(this, inflate);
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
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$7 */
    class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentActivity m = h.this.m();
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
        actionBar.a.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.7
            AnonymousClass7() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FragmentActivity m = h.this.m();
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
        if (com.jumobile.manager.systemapp.f.a.a(this.Y, "ads_enabled", true)) {
            this.aj = actionBar.a(R.drawable.remove_ads, new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.8
                AnonymousClass8() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    FragmentActivity m = h.this.m();
                    if (m != null) {
                        androidx.f.a.a.a(h.this.Y.getApplicationContext()).a(new Intent(m.getClass().getName() + "SHOW_DIALOG"));
                    }
                }
            });
            this.ai = new BroadcastReceiver() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.9
                AnonymousClass9() {
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    h.this.ah.h();
                    h.this.aj.setVisibility(8);
                }
            };
            androidx.f.a.a.a(this.Y).a(this.ai, new IntentFilter("com.jumobile.manager.systemapp.ACTION_ADS_REMOVED"));
        }
        actionBar.a(R.drawable.ic_action_trash, new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.10
            AnonymousClass10() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FragmentActivity m = h.this.m();
                if (m != null) {
                    h.this.a(new Intent(m, (Class<?>) RecycleBinActivity.class));
                    m.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                }
            }
        });
        actionBar.a(R.drawable.ic_action_menu, new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.11
            AnonymousClass11() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FragmentActivity m = h.this.m();
                if (m != null) {
                    c cVar = h.this.new c(m);
                    if (m.isFinishing()) {
                        return;
                    }
                    cVar.show();
                }
            }
        });
        actionBar.setEditChangeListener(this);
        if (com.jumobile.manager.systemapp.f.a.a(this.Y, "system_app_show_long_press_hint", true)) {
            View findViewById = view.findViewById(R.id.long_press_hint);
            findViewById.setVisibility(0);
            view.findViewById(R.id.long_press_hint_btn_i_know).setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.12
                final /* synthetic */ View a;

                AnonymousClass12(View findViewById2) {
                    findViewById = findViewById2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    findViewById.setVisibility(8);
                    com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_show_long_press_hint", false);
                }
            });
        }
        this.af = (EditText) view.findViewById(R.id.filter_edit_text);
        ay();
        this.ab = (TextView) view.findViewById(R.id.summary_total);
        this.ac = (TextView) view.findViewById(R.id.summary_selected);
        this.ad = (ListView) view.findViewById(android.R.id.list);
        this.ad.setEmptyView((TextView) view.findViewById(R.id.list_empty_view));
        this.ad.setOnItemClickListener(this);
        this.ad.setOnItemLongClickListener(this);
        this.ad.setAdapter((ListAdapter) this.Z);
        this.ae = (Button) view.findViewById(R.id.btn_uninstall);
        this.ae.setOnClickListener(this);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$8 */
    class AnonymousClass8 implements View.OnClickListener {
        AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            FragmentActivity m = h.this.m();
            if (m != null) {
                androidx.f.a.a.a(h.this.Y.getApplicationContext()).a(new Intent(m.getClass().getName() + "SHOW_DIALOG"));
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$9 */
    class AnonymousClass9 extends BroadcastReceiver {
        AnonymousClass9() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            h.this.ah.h();
            h.this.aj.setVisibility(8);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$10 */
    class AnonymousClass10 implements View.OnClickListener {
        AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            FragmentActivity m = h.this.m();
            if (m != null) {
                h.this.a(new Intent(m, (Class<?>) RecycleBinActivity.class));
                m.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$11 */
    class AnonymousClass11 implements View.OnClickListener {
        AnonymousClass11() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            FragmentActivity m = h.this.m();
            if (m != null) {
                c cVar = h.this.new c(m);
                if (m.isFinishing()) {
                    return;
                }
                cVar.show();
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$12 */
    class AnonymousClass12 implements View.OnClickListener {
        final /* synthetic */ View a;

        AnonymousClass12(View findViewById2) {
            findViewById = findViewById2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            findViewById.setVisibility(8);
            com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_show_long_press_hint", false);
        }
    }

    private boolean ax() {
        return com.jumobile.manager.systemapp.h.a.c();
    }

    public void ay() {
        if ((com.jumobile.manager.systemapp.f.a.a(this.Y, "system_app_extra_info", 0) & 16) != 0) {
            this.af.setVisibility(0);
            this.af.requestFocus();
            this.af.addTextChangedListener(this);
            return;
        }
        this.af.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ak == null && view.getId() == R.id.btn_uninstall && aC()) {
            az();
        }
    }

    private void az() {
        if (!ax()) {
            com.jumobile.manager.systemapp.util.f.a(this.Y, R.string.system_app_dialog_title_no_root);
            return;
        }
        ArrayList<com.jumobile.manager.systemapp.d.f> a2 = this.Z.a();
        if (a2.size() > 0) {
            if (this.ak == null) {
                this.ak = new d(a2);
                a(a2);
                return;
            }
            return;
        }
        com.jumobile.manager.systemapp.util.f.a(this.Y, R.string.system_app_no_target_to_uninstall);
    }

    private void a(ArrayList<com.jumobile.manager.systemapp.d.f> arrayList) {
        FragmentActivity m = m();
        if (m == null) {
            this.ak = null;
            return;
        }
        com.jumobile.manager.systemapp.ui.a.e eVar = new com.jumobile.manager.systemapp.ui.a.e(m, com.jumobile.manager.systemapp.util.f.a(this.Y, R.string.system_app_confirm_dialog_content, R.color.green, String.valueOf(arrayList.size())), R.string.system_app_confirm_dialog_hint);
        eVar.g.setText(R.string.system_app_confirm_dialog_btn_left);
        eVar.g.setBackgroundResource(R.drawable.selector_btn_warning);
        eVar.h.setText(R.string.system_app_confirm_dialog_btn_right);
        eVar.h.setBackgroundResource(R.drawable.selector_btn_recommend);
        eVar.h.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.13
            final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

            AnonymousClass13(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                eVar = eVar2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                eVar.dismiss();
                h.this.ak = null;
            }
        });
        eVar2.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.14
            final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

            AnonymousClass14(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                eVar = eVar2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                eVar.dismiss();
                if (h.this.ak == null || AsyncTask.Status.PENDING != h.this.ak.getStatus()) {
                    return;
                }
                switch (h.this.ak.c()) {
                    case 0:
                        h.this.ak.execute(new Integer[0]);
                        break;
                    case 1:
                        h.this.l(true);
                        break;
                    case 2:
                        h.this.l(false);
                        break;
                }
            }
        });
        eVar2.setCancelable(false);
        eVar2.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.2
            AnonymousClass2() {
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                dialogInterface.dismiss();
                h.this.ak = null;
                return true;
            }
        });
        if (m.isFinishing()) {
            return;
        }
        eVar2.show();
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$13 */
    class AnonymousClass13 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass13(com.jumobile.manager.systemapp.ui.a.e eVar2) {
            eVar = eVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            eVar.dismiss();
            h.this.ak = null;
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$14 */
    class AnonymousClass14 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass14(com.jumobile.manager.systemapp.ui.a.e eVar2) {
            eVar = eVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            eVar.dismiss();
            if (h.this.ak == null || AsyncTask.Status.PENDING != h.this.ak.getStatus()) {
                return;
            }
            switch (h.this.ak.c()) {
                case 0:
                    h.this.ak.execute(new Integer[0]);
                    break;
                case 1:
                    h.this.l(true);
                    break;
                case 2:
                    h.this.l(false);
                    break;
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$2 */
    class AnonymousClass2 implements DialogInterface.OnKeyListener {
        AnonymousClass2() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            dialogInterface.dismiss();
            h.this.ak = null;
            return true;
        }
    }

    public void l(boolean z) {
        FragmentActivity m = m();
        if (m == null) {
            this.ak = null;
            return;
        }
        com.jumobile.manager.systemapp.ui.a.e eVar = new com.jumobile.manager.systemapp.ui.a.e(m, z ? R.string.system_app_confirm_no_sdcard : R.string.system_app_confirm_no_enough_space);
        eVar.g.setText(R.string.system_app_confirm_dialog_btn_left);
        eVar.g.setBackgroundResource(R.drawable.selector_btn_warning);
        eVar.h.setText(R.string.system_app_confirm_dialog_btn_right);
        eVar.h.setBackgroundResource(R.drawable.selector_btn_recommend);
        eVar.h.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.3
            final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

            AnonymousClass3(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                eVar = eVar2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                eVar.dismiss();
                h.this.ak = null;
            }
        });
        eVar2.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.4
            final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

            AnonymousClass4(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                eVar = eVar2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                eVar.dismiss();
                if (h.this.ak == null || AsyncTask.Status.PENDING != h.this.ak.getStatus()) {
                    return;
                }
                h.this.ak.execute(new Integer[0]);
            }
        });
        eVar2.setCancelable(false);
        eVar2.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.5
            AnonymousClass5() {
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                dialogInterface.dismiss();
                h.this.ak = null;
                return true;
            }
        });
        if (m.isFinishing()) {
            return;
        }
        eVar2.show();
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$3 */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass3(com.jumobile.manager.systemapp.ui.a.e eVar2) {
            eVar = eVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            eVar.dismiss();
            h.this.ak = null;
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$4 */
    class AnonymousClass4 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass4(com.jumobile.manager.systemapp.ui.a.e eVar2) {
            eVar = eVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            eVar.dismiss();
            if (h.this.ak == null || AsyncTask.Status.PENDING != h.this.ak.getStatus()) {
                return;
            }
            h.this.ak.execute(new Integer[0]);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$5 */
    class AnonymousClass5 implements DialogInterface.OnKeyListener {
        AnonymousClass5() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            dialogInterface.dismiss();
            h.this.ak = null;
            return true;
        }
    }

    public void at() {
        this.Z.a(this.aa.b());
        this.Z.notifyDataSetChanged();
        aA();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.jumobile.manager.systemapp.d.f a2;
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox_app_selected);
        if (checkBox == null || (a2 = this.Z.a(i)) == null) {
            return;
        }
        if (60 == a2.a) {
            com.jumobile.manager.systemapp.util.f.a(this.Y, R.string.system_app_type_never_delete);
            return;
        }
        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
            a2.i = false;
        } else {
            checkBox.setChecked(true);
            a2.i = true;
        }
        this.Z.notifyDataSetChanged();
        aA();
    }

    public void aA() {
        long c2 = this.Z.c();
        if (0 == c2) {
            this.ae.setText(R.string.system_app_btn_uninstall_noselect);
        } else {
            this.ae.setText(this.Y.getString(R.string.system_app_btn_uninstall_selected, com.jumobile.manager.systemapp.util.f.a(c2)));
        }
        this.ab.setText(com.jumobile.manager.systemapp.util.f.a(this.Y, R.string.system_app_summary_total, R.color.green, String.valueOf(this.Z.getCount())));
        this.ac.setText(com.jumobile.manager.systemapp.util.f.a(this.Y, R.string.system_app_summary_selected, R.color.green, String.valueOf(this.Z.b())));
    }

    /* compiled from: source */
    class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b(message);
                    break;
                case 2:
                    a(message);
                    break;
            }
        }

        private void a(Message message) {
            FragmentActivity m = h.this.m();
            if (m == null) {
                return;
            }
            com.jumobile.manager.systemapp.ui.a.e eVar = new com.jumobile.manager.systemapp.ui.a.e(m, R.string.system_app_no_root_access);
            eVar.setTitle(R.string.common_warning);
            eVar.h.setText(R.string.common_i_know);
            if (m.isFinishing()) {
                return;
            }
            eVar.show();
        }

        private void b(Message message) {
            int i = message.arg1;
            if (i == 4) {
                h.this.aw();
            }
            switch (i) {
                case 2:
                    h.this.at();
                    break;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void F() {
        super.F();
        if (this.ak != null) {
            this.ak.a();
        }
        aB();
    }

    private void aB() {
        int a2 = com.jumobile.manager.systemapp.f.a.a(this.Y, "system_app_sort_by", 4);
        if (a2 == this.ag) {
        }
        this.ag = a2;
        switch (a2) {
            case 1:
                this.aa.g();
                break;
            case 2:
                this.aa.h();
                break;
            case 3:
                this.aa.i();
                break;
            case 4:
                this.aa.f();
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void I() {
        if (this.ak != null) {
            this.ak.b();
        }
        super.I();
    }

    /* compiled from: source */
    private class d extends AsyncTask<Integer, Integer, Integer> {
        private ArrayList<com.jumobile.manager.systemapp.d.f> c;
        private final int b = 1;
        private String d = "";
        private boolean e = false;
        private int f = 0;
        private int g = 0;
        private com.jumobile.manager.systemapp.ui.a.f h = null;

        public d(ArrayList<com.jumobile.manager.systemapp.d.f> arrayList) {
            this.c = null;
            this.c = arrayList;
        }

        public void a() {
            if (this.h != null) {
                this.h.show();
            }
        }

        public void b() {
            if (this.h != null) {
                this.h.dismiss();
            }
        }

        public int c() {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return 1;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().toString());
            long availableBlocks = statFs.getAvailableBlocks() * statFs.getBlockSize();
            long j = 0;
            Iterator<com.jumobile.manager.systemapp.d.f> it = this.c.iterator();
            while (it.hasNext()) {
                j += it.next().h;
            }
            return availableBlocks < j ? 2 : 0;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            FragmentActivity m = h.this.m();
            if (m == null) {
                return;
            }
            this.h = new com.jumobile.manager.systemapp.ui.a.f(m);
            this.h.a(0, this.c.size());
            this.h.setCancelable(true);
            this.h.a(new f.a() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.d.1
                AnonymousClass1() {
                }

                @Override // com.jumobile.manager.systemapp.ui.a.f.a
                public boolean a() {
                    d.this.e = true;
                    return false;
                }
            });
            if (this.c.size() == 1) {
                this.h.f.setVisibility(8);
            }
            if (m.isFinishing()) {
                return;
            }
            this.h.show();
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$d$1 */
        class AnonymousClass1 implements f.a {
            AnonymousClass1() {
            }

            @Override // com.jumobile.manager.systemapp.ui.a.f.a
            public boolean a() {
                d.this.e = true;
                return false;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(Integer... numArr) {
            int i = 0;
            while (i < this.c.size()) {
                com.jumobile.manager.systemapp.d.f fVar = this.c.get(i);
                if (this.e) {
                    return 2;
                }
                this.d = fVar.f;
                i++;
                publishProgress(1, Integer.valueOf(i), Integer.valueOf(this.c.size()));
                if (com.jumobile.manager.systemapp.util.f.j(h.this.Y, fVar.b.packageName)) {
                    com.jumobile.manager.systemapp.b.a.d(h.this.Y, fVar.b.packageName);
                }
                com.jumobile.manager.systemapp.b.a.c(h.this.Y, fVar.b.packageName);
                try {
                    if (h.this.aa.a(fVar)) {
                        this.f++;
                        fVar.i = false;
                    } else {
                        this.g++;
                    }
                } catch (Exception unused) {
                }
            }
            return 0;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (h.this.t() && numArr[0].intValue() == 1) {
                this.h.a(numArr[1].intValue(), numArr[2].intValue());
                this.h.a(h.this.a(R.string.system_app_uninstall_entry, this.d));
                h.this.aA();
                h.this.Z.notifyDataSetChanged();
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            try {
                this.h.dismiss();
            } catch (Exception e) {
                Log.w(h.X, "Failed to dismiss mProgressDialog: " + e.getMessage());
            }
            h.this.aA();
            h.this.Z.notifyDataSetChanged();
            this.h = null;
            h.this.ak = null;
            FragmentActivity m = h.this.m();
            if (m == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            if (2 == num.intValue()) {
                sb.append(h.this.Y.getString(R.string.system_app_uninstall_result_dialog_user_canceled));
                sb.append("\n");
            }
            if (this.f > 0) {
                sb.append(h.this.Y.getString(R.string.system_app_uninstall_result_dialog_success_count, Integer.valueOf(this.f)));
            }
            if (this.g > 0) {
                if (this.f > 0) {
                    sb.append("\n");
                }
                sb.append(h.this.Y.getString(R.string.system_app_uninstall_result_dialog_failed_count, Integer.valueOf(this.g)));
            }
            Intent intent = new Intent(m, (Class<?>) ResultActivity.class);
            intent.putExtra("extra_title", m.getString(R.string.system_app_uninstall_result_dialog_title));
            intent.putExtra("extra_message", sb.toString());
            m.startActivity(intent);
            m.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        }
    }

    private void b(com.jumobile.manager.systemapp.d.f fVar) {
        FragmentActivity m = m();
        if (m == null) {
            return;
        }
        com.jumobile.manager.systemapp.ui.a.h hVar = new com.jumobile.manager.systemapp.ui.a.h(m, fVar);
        if (m.isFinishing()) {
            return;
        }
        hVar.show();
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.jumobile.manager.systemapp.d.f a2 = this.Z.a(i);
        if (a2 == null) {
            return false;
        }
        b(a2);
        return false;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.aa.a(editable.toString());
    }

    /* compiled from: source */
    private class c extends Dialog implements DialogInterface.OnKeyListener, View.OnClickListener {
        public c(Context context) {
            super(context, R.style.BaseDialog);
            setContentView(R.layout.dialog_menu_system_app_more);
            setCancelable(false);
            setCanceledOnTouchOutside(true);
            setOnKeyListener(this);
            Window window = getWindow();
            window.setGravity(21);
            window.setWindowAnimations(R.style.menu_dailog_anim);
            int a = com.jumobile.manager.systemapp.f.a.a(h.this.Y, "system_app_extra_info", 0);
            CheckBox checkBox = (CheckBox) findViewById(R.id.extra_info_install_time);
            checkBox.setChecked((a & 2) != 0);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.c.1
                final /* synthetic */ h a;

                AnonymousClass1(h hVar) {
                    r2 = hVar;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    int a2 = com.jumobile.manager.systemapp.f.a.a(h.this.Y, "system_app_extra_info", 0);
                    if (z) {
                        com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_extra_info", a2 | 2);
                    } else {
                        com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_extra_info", a2 & (-3));
                    }
                    h.this.at();
                }
            });
            CheckBox checkBox2 = (CheckBox) findViewById(R.id.extra_info_package_name);
            checkBox2.setChecked((a & 4) != 0);
            checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.c.2
                final /* synthetic */ h a;

                AnonymousClass2(h hVar) {
                    r2 = hVar;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    int a2 = com.jumobile.manager.systemapp.f.a.a(h.this.Y, "system_app_extra_info", 0);
                    if (z) {
                        com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_extra_info", a2 | 4);
                    } else {
                        com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_extra_info", a2 & (-5));
                    }
                    h.this.at();
                }
            });
            CheckBox checkBox3 = (CheckBox) findViewById(R.id.extra_info_apk_path);
            checkBox3.setChecked((a & 8) != 0);
            checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.c.3
                final /* synthetic */ h a;

                AnonymousClass3(h hVar) {
                    r2 = hVar;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    int a2 = com.jumobile.manager.systemapp.f.a.a(h.this.Y, "system_app_extra_info", 0);
                    if (z) {
                        com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_extra_info", a2 | 8);
                    } else {
                        com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_extra_info", a2 & (-9));
                    }
                    h.this.at();
                }
            });
            CheckBox checkBox4 = (CheckBox) findViewById(R.id.extra_info_filter_text);
            checkBox4.setChecked((a & 16) != 0);
            checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.c.4
                final /* synthetic */ h a;

                AnonymousClass4(h hVar) {
                    r2 = hVar;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    int a2 = com.jumobile.manager.systemapp.f.a.a(h.this.Y, "system_app_extra_info", 0);
                    if (z) {
                        com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_extra_info", a2 | 16);
                    } else {
                        com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_extra_info", a2 & (-17));
                    }
                    h.this.ay();
                }
            });
            RadioButton radioButton = (RadioButton) findViewById(R.id.menu_sort_by_type);
            radioButton.setOnClickListener(this);
            RadioButton radioButton2 = (RadioButton) findViewById(R.id.menu_sort_by_label);
            radioButton2.setOnClickListener(this);
            RadioButton radioButton3 = (RadioButton) findViewById(R.id.menu_sort_by_size);
            radioButton3.setOnClickListener(this);
            RadioButton radioButton4 = (RadioButton) findViewById(R.id.menu_sort_by_time);
            radioButton4.setOnClickListener(this);
            RadioButton radioButton5 = (RadioButton) findViewById(R.id.menu_sort_by_file_name);
            radioButton5.setOnClickListener(this);
            int a2 = com.jumobile.manager.systemapp.f.a.a(h.this.Y, "system_app_sort_by", 4);
            if (a2 != 6) {
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
                    case 4:
                        radioButton.setChecked(true);
                        break;
                    default:
                        radioButton.setChecked(true);
                        break;
                }
            } else {
                radioButton5.setChecked(true);
            }
            findViewById(R.id.btn_share_app_details).setOnClickListener(this);
            findViewById(R.id.btn_apk_extractor).setOnClickListener(this);
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$c$1 */
        class AnonymousClass1 implements CompoundButton.OnCheckedChangeListener {
            final /* synthetic */ h a;

            AnonymousClass1(h hVar) {
                r2 = hVar;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(h.this.Y, "system_app_extra_info", 0);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_extra_info", a2 | 2);
                } else {
                    com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_extra_info", a2 & (-3));
                }
                h.this.at();
            }
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$c$2 */
        class AnonymousClass2 implements CompoundButton.OnCheckedChangeListener {
            final /* synthetic */ h a;

            AnonymousClass2(h hVar) {
                r2 = hVar;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(h.this.Y, "system_app_extra_info", 0);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_extra_info", a2 | 4);
                } else {
                    com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_extra_info", a2 & (-5));
                }
                h.this.at();
            }
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$c$3 */
        class AnonymousClass3 implements CompoundButton.OnCheckedChangeListener {
            final /* synthetic */ h a;

            AnonymousClass3(h hVar) {
                r2 = hVar;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(h.this.Y, "system_app_extra_info", 0);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_extra_info", a2 | 8);
                } else {
                    com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_extra_info", a2 & (-9));
                }
                h.this.at();
            }
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$c$4 */
        class AnonymousClass4 implements CompoundButton.OnCheckedChangeListener {
            final /* synthetic */ h a;

            AnonymousClass4(h hVar) {
                r2 = hVar;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int a2 = com.jumobile.manager.systemapp.f.a.a(h.this.Y, "system_app_extra_info", 0);
                if (z) {
                    com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_extra_info", a2 | 16);
                } else {
                    com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_extra_info", a2 & (-17));
                }
                h.this.ay();
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
                case R.id.btn_apk_extractor /* 2131230842 */:
                    if (h.this.al == null) {
                        ArrayList<com.jumobile.manager.systemapp.d.f> a = h.this.Z.a();
                        if (a.size() > 0) {
                            if (h.this.al == null) {
                                h.this.al = h.this.new a(a);
                                h.this.al.execute(new Integer[0]);
                                break;
                            }
                        } else {
                            com.jumobile.manager.systemapp.util.f.a(h.this.Y, R.string.user_app_backup_no_target);
                            break;
                        }
                    }
                    break;
                case R.id.btn_share_app_details /* 2131230853 */:
                    ArrayList<com.jumobile.manager.systemapp.d.f> a2 = h.this.Z.a();
                    if (a2.size() <= 0) {
                        com.jumobile.manager.systemapp.util.f.a(h.this.Y, R.string.common_at_least_one);
                        break;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        Iterator<com.jumobile.manager.systemapp.d.f> it = a2.iterator();
                        while (it.hasNext()) {
                            com.jumobile.manager.systemapp.d.f next = it.next();
                            sb.append(next.f);
                            sb.append("\n");
                            sb.append(com.jumobile.manager.systemapp.util.f.d(h.this.Y, next.g));
                            sb.append("\n");
                            sb.append(h.this.Y.getString(R.string.app_info_dialog_detail_size));
                            sb.append(com.jumobile.manager.systemapp.util.f.a(next.h));
                            sb.append("\n");
                            sb.append(h.this.Y.getString(R.string.app_info_dialog_detail_package));
                            sb.append(next.b.packageName);
                            sb.append("\n");
                            sb.append(h.this.Y.getString(R.string.app_info_dialog_detail_source_dir));
                            sb.append(next.b.sourceDir);
                            sb.append("\n");
                            sb.append("\n");
                        }
                        Intent intent = new Intent("android.intent.action.SEND");
                        intent.putExtra("android.intent.extra.TEXT", sb.toString());
                        intent.setType("text/plain");
                        intent.addFlags(268435456);
                        h.this.a(Intent.createChooser(intent, h.this.a(R.string.share_app_default_title)));
                        break;
                    }
                case R.id.menu_sort_by_file_name /* 2131230979 */:
                    h.this.aa.j();
                    com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_sort_by", 6);
                    break;
                case R.id.menu_sort_by_label /* 2131230980 */:
                    h.this.aa.g();
                    com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_sort_by", 1);
                    break;
                case R.id.menu_sort_by_size /* 2131230982 */:
                    h.this.aa.h();
                    com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_sort_by", 2);
                    break;
                case R.id.menu_sort_by_time /* 2131230984 */:
                    h.this.aa.i();
                    com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_sort_by", 3);
                    break;
                case R.id.menu_sort_by_type /* 2131230985 */:
                    h.this.aa.f();
                    com.jumobile.manager.systemapp.f.a.b(h.this.Y, "system_app_sort_by", 4);
                    break;
            }
        }
    }

    @Override // com.jumobile.manager.systemapp.ui.fragment.c
    public boolean av() {
        return this.ah.f();
    }

    /* compiled from: source */
    private class a extends AsyncTask<Integer, Integer, Integer> {
        private ArrayList<com.jumobile.manager.systemapp.d.f> b;
        private int c = 0;
        private String d = "";
        private com.jumobile.manager.systemapp.ui.a.f e = null;
        private boolean f = false;
        private final int g = 1;
        private final int h = 1;
        private final int i = 2;
        private final int j = 3;
        private final int k = 4;

        public a(ArrayList<com.jumobile.manager.systemapp.d.f> arrayList) {
            this.b = null;
            this.b = arrayList;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(Integer... numArr) {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return 1;
            }
            File file = new File(com.jumobile.manager.systemapp.c.f.a(h.this.Y));
            if (!file.exists() && !file.mkdirs()) {
                return 2;
            }
            int size = this.b.size();
            int i = 0;
            while (i < this.b.size()) {
                com.jumobile.manager.systemapp.d.f fVar = this.b.get(i);
                if (this.f) {
                    return 3;
                }
                this.d = fVar.f;
                i++;
                publishProgress(1, Integer.valueOf(i), Integer.valueOf(this.b.size()));
                if (h.this.a(fVar)) {
                    this.c++;
                } else {
                    fVar.i = false;
                }
            }
            publishProgress(1, Integer.valueOf(size), Integer.valueOf(size));
            return 4;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            FragmentActivity m = h.this.m();
            if (m == null) {
                return;
            }
            this.e = new com.jumobile.manager.systemapp.ui.a.f(m);
            this.e.a(0, this.b.size());
            this.e.setCancelable(true);
            this.e.a(new f.a() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.a.1
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
        /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$a$1 */
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
            if (h.this.t() && numArr[0].intValue() == 1) {
                this.e.a(numArr[1].intValue(), numArr[2].intValue());
                this.e.a(h.this.a(R.string.user_app_backup_progress_title, this.d));
                h.this.Z.notifyDataSetChanged();
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
                Log.w(h.X, "Failed to dismiss mProgressDialog: " + e.getMessage());
            }
            h.this.al = null;
            FragmentActivity m = h.this.m();
            if (m == null) {
                return;
            }
            switch (num.intValue()) {
                case 1:
                    string = h.this.Y.getString(R.string.user_app_backup_none_sdcard);
                    string2 = h.this.Y.getString(R.string.user_app_backup_fail_title);
                    break;
                case 2:
                    string = h.this.Y.getString(R.string.user_app_backup_write_error);
                    string2 = h.this.Y.getString(R.string.user_app_backup_fail_title);
                    break;
                case 3:
                    string = h.this.Y.getString(R.string.user_app_backup_user_canceled, Integer.valueOf(this.c), com.jumobile.manager.systemapp.c.f.a(h.this.Y));
                    string2 = h.this.Y.getString(R.string.user_app_backup_finished_title);
                    break;
                case 4:
                    if (this.c == this.b.size()) {
                        string = h.this.Y.getString(R.string.user_app_backup_finished, Integer.valueOf(this.c), com.jumobile.manager.systemapp.c.f.a(h.this.Y));
                    } else {
                        string = h.this.Y.getString(R.string.user_app_backup_finished_with_error, Integer.valueOf(this.c), com.jumobile.manager.systemapp.c.f.a(h.this.Y));
                    }
                    string2 = h.this.Y.getString(R.string.user_app_backup_finished_title);
                    break;
                default:
                    string = h.this.Y.getString(R.string.user_app_backup_write_error);
                    string2 = h.this.Y.getString(R.string.user_app_backup_fail_title);
                    break;
            }
            Intent intent = new Intent(m, (Class<?>) ResultActivity.class);
            intent.putExtra("extra_title", string2);
            intent.putExtra("extra_message", string);
            m.startActivity(intent);
            m.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        }
    }

    public boolean a(com.jumobile.manager.systemapp.d.f fVar) {
        try {
            File file = new File(com.jumobile.manager.systemapp.c.f.a(this.Y));
            File file2 = new File(fVar.b.sourceDir);
            File file3 = new File(file.toString() + "/" + fVar.c(this.Y));
            if (file3.exists()) {
                try {
                    if (file3.length() == file2.length()) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            if (this.aa != null) {
                return this.aa.a(fVar, file.toString());
            }
            return false;
        } catch (IOException unused2) {
            return false;
        }
    }

    private boolean aC() {
        ArrayList arrayList = new ArrayList();
        if (androidx.core.content.a.b(this.Y, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (arrayList.size() == 0) {
            return true;
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        a(strArr, 10);
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
        if (i == 10) {
            if (a(iArr)) {
                az();
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
            eVar.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.fragment.h.6
                final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

                AnonymousClass6(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                    eVar = eVar2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.parse("package:" + h.this.Y.getPackageName()));
                    h.this.a(intent);
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
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.h$6 */
    class AnonymousClass6 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass6(com.jumobile.manager.systemapp.ui.a.e eVar2) {
            eVar = eVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + h.this.Y.getPackageName()));
            h.this.a(intent);
            eVar.dismiss();
        }
    }
}
