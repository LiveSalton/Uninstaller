package com.jumobile.manager.systemapp.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.jumobile.manager.systemapp.R;
import com.jumobile.manager.systemapp.ui.a.f;
import com.jumobile.manager.systemapp.ui.widget.ActionBar;
import com.jumobile.manager.systemapp.util.f;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public class RecycleBinActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final String b = "RecycleBinActivity";
    private Context c;
    private TextView d;
    private TextView e;
    private ListView f = null;
    private CheckBox g = null;
    private boolean h = false;
    private Button i = null;
    private Button j = null;
    private d k = null;
    private com.jumobile.manager.systemapp.c.d l = null;
    private com.jumobile.manager.systemapp.a.b m = com.jumobile.manager.systemapp.a.b.j();
    final b a = new b();
    private c n = null;
    private a o = null;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = getApplicationContext();
        com.jumobile.manager.systemapp.util.e.a(this.c).a(b);
        setContentView(R.layout.activity_recycle_bin);
        c();
        d();
        a();
        this.m.m(this);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.m.k();
        if (this.l != null) {
            this.l.a(this.a);
            this.l.a();
        }
        super.onDestroy();
        com.jumobile.manager.systemapp.util.e.a(this.c).b(b);
    }

    private void c() {
        this.l = new com.jumobile.manager.systemapp.c.d(this.c);
        this.l.a(this.a, 1);
        this.k = new d(this.c);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecycleBinActivity.this.finish();
            RecycleBinActivity.this.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
        }
    }

    private void d() {
        ((ActionBar) findViewById(R.id.action_bar)).a.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RecycleBinActivity.this.finish();
                RecycleBinActivity.this.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
            }
        });
        this.d = (TextView) findViewById(R.id.summary_total);
        this.e = (TextView) findViewById(R.id.summary_selected);
        this.g = (CheckBox) findViewById(R.id.checkbox_select_all);
        this.g.setChecked(false);
        this.g.setOnClickListener(this);
        this.h = false;
        this.i = (Button) findViewById(R.id.btn_right);
        this.i.setOnClickListener(this);
        this.j = (Button) findViewById(R.id.btn_left);
        this.j.setOnClickListener(this);
        this.f = (ListView) findViewById(android.R.id.list);
        this.f.setEmptyView(findViewById(R.id.list_empty_view));
        this.f.setOnItemClickListener(this);
        this.f.setAdapter((ListAdapter) this.k);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void a() {
        ArrayList<com.jumobile.manager.systemapp.d.e> c2 = this.l.c();
        boolean z = c2.size() > 0;
        this.j.setEnabled(z);
        this.i.setEnabled(z);
        this.g.setEnabled(z);
        this.k.a(c2);
        this.k.notifyDataSetChanged();
        if (this.k.a()) {
            this.h = true;
            this.g.setChecked(this.h);
        } else {
            this.h = false;
            this.g.setChecked(this.h);
        }
        e();
    }

    private void e() {
        this.d.setText(f.a(this.c, R.string.system_app_summary_total, R.color.green, String.valueOf(this.k.getCount())));
        this.e.setText(f.a(this.c, R.string.system_app_summary_selected, R.color.green, String.valueOf(this.k.c())));
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
    public void onStart() {
        super.onStart();
        if (this.n != null) {
            this.n.a();
        }
        if (this.o != null) {
            this.o.a();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        if (this.n != null) {
            this.n.b();
        }
        if (this.o != null) {
            this.o.b();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox_app_selected);
        if (checkBox == null) {
            return;
        }
        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
            this.k.a(i).i = false;
            this.g.setChecked(false);
            this.h = false;
        } else {
            checkBox.setChecked(true);
            this.k.a(i).i = true;
            if (this.k.a()) {
                this.h = true;
                this.g.setChecked(true);
            }
        }
        e();
    }

    private boolean f() {
        return com.jumobile.manager.systemapp.h.a.c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.btn_left) {
            ArrayList<com.jumobile.manager.systemapp.d.e> b2 = this.k.b();
            if (b2.size() > 0) {
                com.jumobile.manager.systemapp.ui.a.e eVar = new com.jumobile.manager.systemapp.ui.a.e(this, f.a(this.c, R.string.recycle_bin_delete_confirm_content, R.color.green, String.valueOf(b2.size())), R.string.recycle_bin_delete_confirm_hint);
                eVar.g.setText(R.string.recycle_bin_delete_confirm_btn_ok);
                eVar.g.setBackgroundResource(R.drawable.selector_btn_warning);
                eVar.h.setText(R.string.recycle_bin_delete_confirm_btn_back);
                eVar.h.setBackgroundResource(R.drawable.selector_btn_grey);
                eVar.h.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity.2
                    final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

                    AnonymousClass2(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                        eVar = eVar2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        eVar.dismiss();
                    }
                });
                eVar2.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity.3
                    final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

                    AnonymousClass3(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                        eVar = eVar2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        eVar.dismiss();
                        if (RecycleBinActivity.this.o == null) {
                            RecycleBinActivity.this.o = RecycleBinActivity.this.new a(RecycleBinActivity.this.k.b());
                            RecycleBinActivity.this.o.execute(new Integer[0]);
                        }
                    }
                });
                eVar2.setCancelable(false);
                eVar2.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity.4
                    AnonymousClass4() {
                    }

                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i != 4) {
                            return false;
                        }
                        dialogInterface.dismiss();
                        return true;
                    }
                });
                if (isFinishing()) {
                    return;
                }
                eVar2.show();
                return;
            }
            f.a(this.c, R.string.recycle_bin_delete_no_target);
            return;
        }
        if (id != R.id.btn_right) {
            if (id == R.id.checkbox_select_all && this.k.getCount() != 0) {
                this.h = !this.h;
                this.g.setChecked(this.h);
                this.k.a(this.h);
                this.k.notifyDataSetChanged();
                e();
                return;
            }
            return;
        }
        if (!f()) {
            f.a(this.c, R.string.system_app_dialog_title_no_root);
            return;
        }
        if (this.k.getCount() == 0) {
            f.a(this.c, R.string.recycle_bin_empty_view_hint);
            return;
        }
        ArrayList<com.jumobile.manager.systemapp.d.e> b3 = this.k.b();
        if (b3.size() > 0) {
            com.jumobile.manager.systemapp.ui.a.e eVar2 = new com.jumobile.manager.systemapp.ui.a.e(this, f.a(this.c, R.string.recycle_bin_restore_confirm_content, R.color.green, String.valueOf(b3.size())), R.string.recycle_bin_restore_confirm_hint);
            eVar2.g.setText(R.string.recycle_bin_restore_confirm_btn_ok);
            eVar2.g.setBackgroundResource(R.drawable.selector_btn_recommend);
            eVar2.h.setText(R.string.recycle_bin_restore_confirm_btn_back);
            eVar2.h.setBackgroundResource(R.drawable.selector_btn_grey);
            eVar2.h.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity.5
                final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

                AnonymousClass5(com.jumobile.manager.systemapp.ui.a.e eVar22) {
                    eVar2 = eVar22;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    eVar2.dismiss();
                }
            });
            eVar22.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity.6
                final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

                AnonymousClass6(com.jumobile.manager.systemapp.ui.a.e eVar22) {
                    eVar2 = eVar22;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    eVar2.dismiss();
                    if (RecycleBinActivity.this.n == null) {
                        ArrayList<com.jumobile.manager.systemapp.d.e> b4 = RecycleBinActivity.this.k.b();
                        if (b4.size() > 0) {
                            RecycleBinActivity.this.n = RecycleBinActivity.this.new c(b4);
                            RecycleBinActivity.this.n.execute(new Integer[0]);
                        }
                    }
                }
            });
            eVar22.setCancelable(false);
            eVar22.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity.7
                AnonymousClass7() {
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i != 4) {
                        return false;
                    }
                    dialogInterface.dismiss();
                    return true;
                }
            });
            if (isFinishing()) {
                return;
            }
            eVar22.show();
            return;
        }
        f.a(this.c, R.string.recycle_bin_restore_no_target);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity$2 */
    class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass2(com.jumobile.manager.systemapp.ui.a.e eVar2) {
            eVar = eVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            eVar.dismiss();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity$3 */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass3(com.jumobile.manager.systemapp.ui.a.e eVar2) {
            eVar = eVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            eVar.dismiss();
            if (RecycleBinActivity.this.o == null) {
                RecycleBinActivity.this.o = RecycleBinActivity.this.new a(RecycleBinActivity.this.k.b());
                RecycleBinActivity.this.o.execute(new Integer[0]);
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity$4 */
    class AnonymousClass4 implements DialogInterface.OnKeyListener {
        AnonymousClass4() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            dialogInterface.dismiss();
            return true;
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity$5 */
    class AnonymousClass5 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass5(com.jumobile.manager.systemapp.ui.a.e eVar22) {
            eVar2 = eVar22;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            eVar2.dismiss();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity$6 */
    class AnonymousClass6 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass6(com.jumobile.manager.systemapp.ui.a.e eVar22) {
            eVar2 = eVar22;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            eVar2.dismiss();
            if (RecycleBinActivity.this.n == null) {
                ArrayList<com.jumobile.manager.systemapp.d.e> b4 = RecycleBinActivity.this.k.b();
                if (b4.size() > 0) {
                    RecycleBinActivity.this.n = RecycleBinActivity.this.new c(b4);
                    RecycleBinActivity.this.n.execute(new Integer[0]);
                }
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity$7 */
    class AnonymousClass7 implements DialogInterface.OnKeyListener {
        AnonymousClass7() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            dialogInterface.dismiss();
            return true;
        }
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
            com.jumobile.manager.systemapp.ui.a.e eVar = new com.jumobile.manager.systemapp.ui.a.e(RecycleBinActivity.this, R.string.system_app_no_root_access);
            eVar.setTitle(R.string.common_warning);
            eVar.h.setText(R.string.common_i_know);
            if (RecycleBinActivity.this.isFinishing()) {
                return;
            }
            eVar.show();
        }

        private void b(Message message) {
            if (RecycleBinActivity.this.l == null) {
            }
            int i = message.arg1;
            if (i == 4) {
                if (RecycleBinActivity.this.h()) {
                    RecycleBinActivity.this.g();
                }
            } else {
                switch (i) {
                    case 2:
                        RecycleBinActivity.this.a();
                        break;
                }
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity$8 */
    class AnonymousClass8 implements Runnable {
        AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.jumobile.manager.systemapp.h.a.c()) {
                return;
            }
            RecycleBinActivity.this.a.sendEmptyMessage(2);
        }
    }

    public void g() {
        new Thread(new Runnable() { // from class: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity.8
            AnonymousClass8() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.jumobile.manager.systemapp.h.a.c()) {
                    return;
                }
                RecycleBinActivity.this.a.sendEmptyMessage(2);
            }
        }).start();
    }

    /* compiled from: source */
    private class c extends AsyncTask<Integer, Integer, Integer> {
        private ArrayList<com.jumobile.manager.systemapp.d.e> d;
        private final int b = 1;
        private com.jumobile.manager.systemapp.ui.a.f c = null;
        private boolean e = false;
        private String f = "";

        public c(ArrayList<com.jumobile.manager.systemapp.d.e> arrayList) {
            this.d = null;
            this.d = arrayList;
        }

        public void a() {
            if (this.c != null) {
                this.c.show();
            }
        }

        public void b() {
            if (this.c != null) {
                this.c.dismiss();
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            this.c = new com.jumobile.manager.systemapp.ui.a.f(RecycleBinActivity.this);
            this.c.a(0, this.d.size());
            this.c.setCancelable(true);
            this.c.a(new f.a() { // from class: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity.c.1
                AnonymousClass1() {
                }

                @Override // com.jumobile.manager.systemapp.ui.a.f.a
                public boolean a() {
                    c.this.e = true;
                    return false;
                }
            });
            if (this.d.size() == 1) {
                this.c.f.setVisibility(8);
            }
            if (RecycleBinActivity.this.isFinishing()) {
                return;
            }
            this.c.show();
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity$c$1 */
        class AnonymousClass1 implements f.a {
            AnonymousClass1() {
            }

            @Override // com.jumobile.manager.systemapp.ui.a.f.a
            public boolean a() {
                c.this.e = true;
                return false;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(Integer... numArr) {
            for (int i = 0; i < this.d.size(); i++) {
                if (this.e) {
                    return 2;
                }
                com.jumobile.manager.systemapp.d.e eVar = this.d.get(i);
                this.f = eVar.f;
                publishProgress(1, Integer.valueOf(i), Integer.valueOf(this.d.size()));
                try {
                    RecycleBinActivity.this.l.b(eVar);
                    eVar.i = false;
                } catch (Exception unused) {
                }
            }
            return 0;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (numArr[0].intValue() != 1 || this.c == null) {
                return;
            }
            this.c.a(numArr[1].intValue(), numArr[2].intValue());
            this.c.a(RecycleBinActivity.this.getString(R.string.recycle_bin_restore_progress_title, new Object[]{this.f}));
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Integer num) {
            if (this.c != null) {
                this.c.a(0, this.d.size());
                try {
                    if (this.c != null) {
                        this.c.dismiss();
                        this.c = null;
                    }
                } catch (Exception e) {
                    Log.w(RecycleBinActivity.b, "Failed to dismiss mProgressDialog: " + e.getMessage());
                }
            }
            RecycleBinActivity.this.n = null;
            RecycleBinActivity.this.k.notifyDataSetChanged();
            RecycleBinActivity.this.h = false;
            RecycleBinActivity.this.g.setChecked(RecycleBinActivity.this.h);
            Intent intent = new Intent(RecycleBinActivity.this, (Class<?>) ResultActivity.class);
            intent.putExtra("extra_title", RecycleBinActivity.this.getString(R.string.common_hint));
            intent.putExtra("extra_message", RecycleBinActivity.this.getString(R.string.recycle_bin_restore_task_done));
            RecycleBinActivity.this.startActivity(intent);
            RecycleBinActivity.this.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        }
    }

    /* compiled from: source */
    private class a extends AsyncTask<Integer, Integer, Integer> {
        private ArrayList<com.jumobile.manager.systemapp.d.e> f;
        private final int b = 1;
        private final int c = 2;
        private final int d = 1;
        private com.jumobile.manager.systemapp.ui.a.f e = null;
        private boolean g = false;
        private String h = "";

        public a(ArrayList<com.jumobile.manager.systemapp.d.e> arrayList) {
            this.f = null;
            this.f = arrayList;
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
        protected void onPreExecute() {
            super.onPreExecute();
            this.e = new com.jumobile.manager.systemapp.ui.a.f(RecycleBinActivity.this);
            this.e.a(0, this.f.size());
            this.e.setCancelable(true);
            this.e.a(new f.a() { // from class: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity.a.1
                AnonymousClass1() {
                }

                @Override // com.jumobile.manager.systemapp.ui.a.f.a
                public boolean a() {
                    a.this.g = true;
                    return false;
                }
            });
            if (this.f.size() == 1) {
                this.e.f.setVisibility(8);
            }
            if (RecycleBinActivity.this.isFinishing()) {
                return;
            }
            this.e.show();
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity$a$1 */
        class AnonymousClass1 implements f.a {
            AnonymousClass1() {
            }

            @Override // com.jumobile.manager.systemapp.ui.a.f.a
            public boolean a() {
                a.this.g = true;
                return false;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(Integer... numArr) {
            for (int i = 0; i < this.f.size(); i++) {
                if (this.g) {
                    return 1;
                }
                com.jumobile.manager.systemapp.d.e eVar = this.f.get(i);
                this.h = eVar.f;
                publishProgress(1, Integer.valueOf(i), Integer.valueOf(this.f.size()));
                RecycleBinActivity.this.l.a(eVar);
                eVar.i = false;
            }
            return 2;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (numArr[0].intValue() != 1 || this.e == null) {
                return;
            }
            this.e.a(numArr[1].intValue(), numArr[2].intValue());
            this.e.a(RecycleBinActivity.this.getString(R.string.recycle_bin_delete_progress_title, new Object[]{this.h}));
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Integer num) {
            if (this.e != null) {
                this.e.a(0, this.f.size());
                try {
                    this.e.dismiss();
                    this.e = null;
                } catch (Exception e) {
                    Log.w(RecycleBinActivity.b, "Failed to dismiss mProgressDialog: " + e.getMessage());
                }
            }
            RecycleBinActivity.this.o = null;
            Intent intent = new Intent(RecycleBinActivity.this, (Class<?>) ResultActivity.class);
            intent.putExtra("extra_title", RecycleBinActivity.this.getString(R.string.common_hint));
            intent.putExtra("extra_message", RecycleBinActivity.this.getString(R.string.recycle_bin_delete_task_done));
            RecycleBinActivity.this.startActivity(intent);
            RecycleBinActivity.this.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        }
    }

    public boolean h() {
        ArrayList arrayList = new ArrayList();
        if (androidx.core.content.a.b(this.c, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (arrayList.size() == 0) {
            return true;
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        androidx.core.app.a.a(this, strArr, 13);
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

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 13) {
            if (a(iArr)) {
                this.l.b();
                return;
            }
            com.jumobile.manager.systemapp.ui.a.e eVar = new com.jumobile.manager.systemapp.ui.a.e(this, R.string.common_no_permisson);
            eVar.setTitle(R.string.common_warning);
            eVar.h.setVisibility(8);
            eVar.g.setText(R.string.common_yes);
            eVar.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity.9
                final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

                AnonymousClass9(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                    eVar = eVar2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.parse("package:" + RecycleBinActivity.this.c.getPackageName()));
                    RecycleBinActivity.this.startActivity(intent);
                    eVar.dismiss();
                }
            });
            if (isFinishing()) {
                return;
            }
            eVar2.show();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.RecycleBinActivity$9 */
    class AnonymousClass9 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass9(com.jumobile.manager.systemapp.ui.a.e eVar2) {
            eVar = eVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + RecycleBinActivity.this.c.getPackageName()));
            RecycleBinActivity.this.startActivity(intent);
            eVar.dismiss();
        }
    }
}
