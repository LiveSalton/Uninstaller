package com.jumobile.manager.systemapp.ui.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.jumobile.manager.systemapp.R;
import com.jumobile.manager.systemapp.ui.activity.a;
import com.jumobile.manager.systemapp.ui.widget.ActionBar;
import com.jumobile.manager.systemapp.util.f;
import java.io.File;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public class DirectoryChooserActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final String a = "DirectoryChooserActivity";
    private Context b;
    private String c;
    private String d;
    private ListView e;
    private TextView f;
    private com.jumobile.manager.systemapp.ui.activity.a g;
    private ArrayList<String> h = new ArrayList<>();
    private final Comparator<com.jumobile.manager.systemapp.d.d> i = new Comparator<com.jumobile.manager.systemapp.d.d>() { // from class: com.jumobile.manager.systemapp.ui.activity.DirectoryChooserActivity.7
        private final Collator b = Collator.getInstance();

        AnonymousClass7() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.d dVar, com.jumobile.manager.systemapp.d.d dVar2) {
            return this.b.compare(dVar.b, dVar2.b);
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = getApplicationContext();
        com.jumobile.manager.systemapp.util.e.a(this.b).a(a);
        setContentView(R.layout.activity_directory_chooser);
        b();
        c();
        if (e()) {
            d();
        }
        if (this.h.size() > 1) {
            a();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.DirectoryChooserActivity$1 */
    class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.d a;

        AnonymousClass1(com.jumobile.manager.systemapp.ui.a.d dVar) {
            dVar = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DirectoryChooserActivity.this.d = (String) view.getTag();
            if (!DirectoryChooserActivity.this.d.endsWith("/")) {
                DirectoryChooserActivity.this.d = DirectoryChooserActivity.this.d + "/";
            }
            DirectoryChooserActivity.this.c = DirectoryChooserActivity.this.d;
            dVar.dismiss();
            DirectoryChooserActivity.this.d();
        }
    }

    public void a() {
        com.jumobile.manager.systemapp.ui.a.d dVar = new com.jumobile.manager.systemapp.ui.a.d(this, R.string.directory_chooser_select_sdcard);
        AnonymousClass1 anonymousClass1 = new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.DirectoryChooserActivity.1
            final /* synthetic */ com.jumobile.manager.systemapp.ui.a.d a;

            AnonymousClass1(com.jumobile.manager.systemapp.ui.a.d dVar2) {
                dVar = dVar2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DirectoryChooserActivity.this.d = (String) view.getTag();
                if (!DirectoryChooserActivity.this.d.endsWith("/")) {
                    DirectoryChooserActivity.this.d = DirectoryChooserActivity.this.d + "/";
                }
                DirectoryChooserActivity.this.c = DirectoryChooserActivity.this.d;
                dVar.dismiss();
                DirectoryChooserActivity.this.d();
            }
        };
        Iterator<String> it = this.h.iterator();
        while (it.hasNext()) {
            String next = it.next();
            dVar2.a(next, anonymousClass1).setTag(next);
        }
        dVar2.show();
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.DirectoryChooserActivity$2 */
    class AnonymousClass2 implements a.InterfaceC0094a {
        AnonymousClass2() {
        }

        @Override // com.jumobile.manager.systemapp.ui.activity.a.InterfaceC0094a
        public void a(int i) {
            com.jumobile.manager.systemapp.d.d a = DirectoryChooserActivity.this.g.a(i);
            DirectoryChooserActivity.this.a(DirectoryChooserActivity.this.c + a.b + "/");
        }
    }

    private void b() {
        this.g = new com.jumobile.manager.systemapp.ui.activity.a(this.b);
        this.g.a(new a.InterfaceC0094a() { // from class: com.jumobile.manager.systemapp.ui.activity.DirectoryChooserActivity.2
            AnonymousClass2() {
            }

            @Override // com.jumobile.manager.systemapp.ui.activity.a.InterfaceC0094a
            public void a(int i) {
                com.jumobile.manager.systemapp.d.d a2 = DirectoryChooserActivity.this.g.a(i);
                DirectoryChooserActivity.this.a(DirectoryChooserActivity.this.c + a2.b + "/");
            }
        });
        this.d = Environment.getExternalStorageDirectory().getPath();
        if (!this.d.endsWith("/")) {
            this.d += "/";
        }
        this.c = this.d;
        Iterator<String> it = f.b(this.b).iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (new File(next).canWrite()) {
                this.h.add(next);
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.DirectoryChooserActivity$3 */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DirectoryChooserActivity.this.finish();
            DirectoryChooserActivity.this.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
        }
    }

    private void c() {
        ActionBar actionBar = (ActionBar) findViewById(R.id.action_bar);
        actionBar.a.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.DirectoryChooserActivity.3
            AnonymousClass3() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DirectoryChooserActivity.this.finish();
                DirectoryChooserActivity.this.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
            }
        });
        if (this.h.size() > 1) {
            actionBar.a(R.drawable.ic_sdcard, new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.DirectoryChooserActivity.4
                AnonymousClass4() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DirectoryChooserActivity.this.a();
                }
            });
        }
        actionBar.a(R.drawable.ic_back, new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.DirectoryChooserActivity.5
            AnonymousClass5() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DirectoryChooserActivity.this.c.equals(DirectoryChooserActivity.this.d)) {
                    f.a(DirectoryChooserActivity.this.b, R.string.directory_chooser_toast_root_directory);
                    return;
                }
                DirectoryChooserActivity.this.c = new File(DirectoryChooserActivity.this.c).getParent();
                if (!DirectoryChooserActivity.this.c.endsWith("/")) {
                    DirectoryChooserActivity.this.c = DirectoryChooserActivity.this.c + "/";
                }
                DirectoryChooserActivity.this.d();
            }
        });
        actionBar.a(R.drawable.ic_new, new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.DirectoryChooserActivity.6
            AnonymousClass6() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = DirectoryChooserActivity.this.new a(DirectoryChooserActivity.this);
                if (DirectoryChooserActivity.this.isFinishing()) {
                    return;
                }
                aVar.show();
            }
        });
        findViewById(R.id.btn_right).setOnClickListener(this);
        this.e = (ListView) findViewById(android.R.id.list);
        this.e.setEmptyView(findViewById(R.id.list_empty_view));
        this.e.setOnItemClickListener(this);
        this.e.setAdapter((ListAdapter) this.g);
        this.f = (TextView) findViewById(R.id.current_directory);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.DirectoryChooserActivity$4 */
    class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DirectoryChooserActivity.this.a();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.DirectoryChooserActivity$5 */
    class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DirectoryChooserActivity.this.c.equals(DirectoryChooserActivity.this.d)) {
                f.a(DirectoryChooserActivity.this.b, R.string.directory_chooser_toast_root_directory);
                return;
            }
            DirectoryChooserActivity.this.c = new File(DirectoryChooserActivity.this.c).getParent();
            if (!DirectoryChooserActivity.this.c.endsWith("/")) {
                DirectoryChooserActivity.this.c = DirectoryChooserActivity.this.c + "/";
            }
            DirectoryChooserActivity.this.d();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.DirectoryChooserActivity$6 */
    class AnonymousClass6 implements View.OnClickListener {
        AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = DirectoryChooserActivity.this.new a(DirectoryChooserActivity.this);
            if (DirectoryChooserActivity.this.isFinishing()) {
                return;
            }
            aVar.show();
        }
    }

    public void d() {
        File[] fileArr;
        ArrayList<com.jumobile.manager.systemapp.d.d> arrayList = new ArrayList<>();
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            ((TextView) findViewById(R.id.list_empty_view)).setText(R.string.common_no_sdcard);
            findViewById(R.id.btn_right).setEnabled(false);
        } else {
            ((TextView) findViewById(R.id.list_empty_view)).setText(R.string.directory_chooser_empty_view_hint);
            findViewById(R.id.btn_right).setEnabled(true);
            try {
                fileArr = new File(this.c).listFiles();
            } catch (Exception unused) {
                fileArr = null;
            }
            if (fileArr != null && fileArr.length > 0) {
                for (File file : fileArr) {
                    if (file.isDirectory()) {
                        com.jumobile.manager.systemapp.d.d dVar = new com.jumobile.manager.systemapp.d.d();
                        dVar.b = file.getName();
                        arrayList.add(dVar);
                    }
                }
            }
        }
        this.f.setText(this.c);
        Collections.sort(arrayList, this.i);
        this.g.a(arrayList);
        this.g.notifyDataSetChanged();
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
        int id;
        if (view == null || (id = view.getId()) == R.id.btn_left || id != R.id.btn_right) {
            return;
        }
        a(this.c);
    }

    public void a(String str) {
        Intent intent = new Intent();
        intent.putExtra("extra_directory", str);
        setResult(-1, intent);
        finish();
        overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.c += this.g.a(i).b + "/";
        d();
    }

    /* compiled from: source */
    private class a extends Dialog implements DialogInterface.OnKeyListener, View.OnClickListener {
        private EditText b;

        public a(Context context) {
            super(context, R.style.BaseDialog);
            setContentView(R.layout.dialog_menu_directory_chooser_new_folder);
            setCancelable(false);
            setCanceledOnTouchOutside(true);
            setOnKeyListener(this);
            this.b = (EditText) findViewById(R.id.folder_name);
            this.b.requestFocus();
            findViewById(R.id.btn_left).setOnClickListener(this);
            findViewById(R.id.btn_right).setOnClickListener(this);
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
            if (id != R.id.btn_left) {
                if (id != R.id.btn_right) {
                    return;
                }
                dismiss();
                return;
            }
            String obj = this.b.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                return;
            }
            if (new File(DirectoryChooserActivity.this.c + obj).mkdir()) {
                f.a(DirectoryChooserActivity.this.b, R.string.directory_chooser_new_folder_success);
            } else {
                f.a(DirectoryChooserActivity.this.b, R.string.directory_chooser_new_folder_failed);
            }
            dismiss();
            DirectoryChooserActivity.this.d();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.DirectoryChooserActivity$7 */
    class AnonymousClass7 implements Comparator<com.jumobile.manager.systemapp.d.d> {
        private final Collator b = Collator.getInstance();

        AnonymousClass7() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.jumobile.manager.systemapp.d.d dVar, com.jumobile.manager.systemapp.d.d dVar2) {
            return this.b.compare(dVar.b, dVar2.b);
        }
    }

    private boolean e() {
        ArrayList arrayList = new ArrayList();
        if (androidx.core.content.a.b(this.b, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (arrayList.size() == 0) {
            return true;
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        androidx.core.app.a.a(this, strArr, 14);
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
        if (i == 14) {
            if (a(iArr)) {
                d();
                return;
            }
            com.jumobile.manager.systemapp.ui.a.e eVar = new com.jumobile.manager.systemapp.ui.a.e(this, R.string.common_no_permisson);
            eVar.setTitle(R.string.common_warning);
            eVar.h.setVisibility(8);
            eVar.g.setText(R.string.common_yes);
            eVar.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.DirectoryChooserActivity.8
                final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

                AnonymousClass8(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                    eVar = eVar2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.parse("package:" + DirectoryChooserActivity.this.b.getPackageName()));
                    DirectoryChooserActivity.this.startActivity(intent);
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
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.DirectoryChooserActivity$8 */
    class AnonymousClass8 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass8(com.jumobile.manager.systemapp.ui.a.e eVar2) {
            eVar = eVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + DirectoryChooserActivity.this.b.getPackageName()));
            DirectoryChooserActivity.this.startActivity(intent);
            eVar.dismiss();
        }
    }
}
