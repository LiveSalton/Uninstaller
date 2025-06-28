package com.jumobile.manager.systemapp.inappbilling;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.View;
import com.jumobile.manager.systemapp.R;
import com.jumobile.manager.systemapp.inappbilling.util.b;
import com.jumobile.manager.systemapp.inappbilling.util.c;
import com.jumobile.manager.systemapp.inappbilling.util.d;
import com.jumobile.manager.systemapp.inappbilling.util.e;
import com.jumobile.manager.systemapp.inappbilling.util.g;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public class a {
    private static final String c = "a";
    private Activity d;
    private Context e;
    private b f;
    private BroadcastReceiver i;
    private boolean g = false;
    private String h = "$0.99";
    b.d a = new b.d() { // from class: com.jumobile.manager.systemapp.inappbilling.a.5
        AnonymousClass5() {
        }

        @Override // com.jumobile.manager.systemapp.inappbilling.util.b.d
        public void a(c cVar, d dVar) {
            if (a.this.f == null || cVar.c()) {
                return;
            }
            if (dVar.b("remover_no_ads")) {
                com.jumobile.manager.systemapp.f.a.b(a.this.e, "ads_enabled", false);
                androidx.f.a.a.a(a.this.d.getApplicationContext()).a(new Intent("com.jumobile.manager.systemapp.ACTION_ADS_REMOVED"));
            }
            g a = dVar.a("remover_no_ads");
            if (a != null) {
                a.this.h = a.b();
                com.jumobile.manager.systemapp.f.a.b(a.this.e, "price_pro_edition", a.this.h);
            }
        }
    };
    b.InterfaceC0091b b = new b.InterfaceC0091b() { // from class: com.jumobile.manager.systemapp.inappbilling.a.6
        AnonymousClass6() {
        }

        @Override // com.jumobile.manager.systemapp.inappbilling.util.b.InterfaceC0091b
        public void a(c cVar, e eVar) {
            if (a.this.f == null || cVar.c() || !eVar.b().equals("remover_no_ads")) {
                return;
            }
            com.jumobile.manager.systemapp.f.a.b(a.this.e, "ads_enabled", false);
            androidx.f.a.a.a(a.this.d.getApplicationContext()).a(new Intent("com.jumobile.manager.systemapp.ACTION_ADS_REMOVED"));
        }
    };

    public void a(Activity activity) {
        this.d = activity;
        this.e = activity.getApplicationContext();
        if (com.jumobile.manager.systemapp.f.a.a(this.e, "ads_enabled", true)) {
            this.h = com.jumobile.manager.systemapp.f.a.a(this.e, "price_pro_edition", "$1.99");
            this.f = new b(this.e, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAh5+Zz9jaJWqL/XqZf7IcFKDD/1iR7m++K3bbpVRsQdeiOk1z3aMeGvJlQp+LiffS8fgE99L3VmhqOzfHuANSoq35PfhN7GM99W4hNWACVmjDstapzOazp0N+FFwFEfQIv8VJL1Lkz+i+cvpR8uFL8H9t3G2lv7BAOxzR0tsNn4h12aEDnHyVsrup+1MusRr2iN5eoLXkbJ7Nunu9Gpvev0lXMGkpCDiNrGvgmJ8U5+e2agPcJwUlSKJE5gDw3wyVMYDcv7jpEmQZyBkZthxTlefR4ECh7WUlA4AmxvnhNRwooQgs9nWfQ+gveFjCl0jml61WVTD/jQw+pCc7SHLHWwIDAQAB");
            this.f.a(new b.c() { // from class: com.jumobile.manager.systemapp.inappbilling.a.1
                AnonymousClass1() {
                }

                @Override // com.jumobile.manager.systemapp.inappbilling.util.b.c
                public void a(c cVar) {
                    if (!cVar.b()) {
                        Log.d(a.c, "Problem setting up In-app Billing: " + cVar);
                        return;
                    }
                    a.this.g = true;
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("remover_no_ads");
                        a.this.f.a(true, arrayList, null, a.this.a);
                    } catch (b.a unused) {
                        Log.d(a.c, "Error querying inventory. Another async operation in progress.");
                    }
                }
            });
            this.i = new BroadcastReceiver() { // from class: com.jumobile.manager.systemapp.inappbilling.a.2
                AnonymousClass2() {
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    a.this.c();
                }
            };
            androidx.f.a.a.a(this.e).a(this.i, new IntentFilter(activity.getClass().getName() + "SHOW_DIALOG"));
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.inappbilling.a$1 */
    class AnonymousClass1 implements b.c {
        AnonymousClass1() {
        }

        @Override // com.jumobile.manager.systemapp.inappbilling.util.b.c
        public void a(c cVar) {
            if (!cVar.b()) {
                Log.d(a.c, "Problem setting up In-app Billing: " + cVar);
                return;
            }
            a.this.g = true;
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add("remover_no_ads");
                a.this.f.a(true, arrayList, null, a.this.a);
            } catch (b.a unused) {
                Log.d(a.c, "Error querying inventory. Another async operation in progress.");
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.inappbilling.a$2 */
    class AnonymousClass2 extends BroadcastReceiver {
        AnonymousClass2() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a.this.c();
        }
    }

    public void a() {
        if (this.f != null) {
            try {
                this.f.a();
            } catch (Exception unused) {
            }
            this.f = null;
        }
        if (this.i != null) {
            androidx.f.a.a.a(this.e.getApplicationContext()).a(this.i);
        }
    }

    public void a(int i, int i2, Intent intent) {
        if (this.f != null) {
            this.f.a(i, i2, intent);
        }
    }

    public void b() {
        if (this.g) {
            try {
                this.f.a(this.d, "remover_no_ads", 6, this.b, "");
            } catch (b.a unused) {
                Log.d(c, "Error launching purchase flow. Another async operation in progress.");
            }
        }
    }

    public void c() {
        com.jumobile.manager.systemapp.ui.a.e eVar = new com.jumobile.manager.systemapp.ui.a.e(this.d, this.e.getString(R.string.google_iap_purchase_pro_detail, this.h));
        eVar.d.setText(R.string.google_iap_remove_ads);
        eVar.g.setText(R.string.google_iap_purchase_pro_button);
        eVar.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.inappbilling.a.3
            final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

            AnonymousClass3(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                eVar = eVar2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                eVar.dismiss();
                a.this.b();
            }
        });
        eVar2.h.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.inappbilling.a.4
            final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

            AnonymousClass4(com.jumobile.manager.systemapp.ui.a.e eVar2) {
                eVar = eVar2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                eVar.dismiss();
            }
        });
        if (this.d.isFinishing()) {
            return;
        }
        eVar2.show();
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.inappbilling.a$3 */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass3(com.jumobile.manager.systemapp.ui.a.e eVar2) {
            eVar = eVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            eVar.dismiss();
            a.this.b();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.inappbilling.a$4 */
    class AnonymousClass4 implements View.OnClickListener {
        final /* synthetic */ com.jumobile.manager.systemapp.ui.a.e a;

        AnonymousClass4(com.jumobile.manager.systemapp.ui.a.e eVar2) {
            eVar = eVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            eVar.dismiss();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.inappbilling.a$5 */
    class AnonymousClass5 implements b.d {
        AnonymousClass5() {
        }

        @Override // com.jumobile.manager.systemapp.inappbilling.util.b.d
        public void a(c cVar, d dVar) {
            if (a.this.f == null || cVar.c()) {
                return;
            }
            if (dVar.b("remover_no_ads")) {
                com.jumobile.manager.systemapp.f.a.b(a.this.e, "ads_enabled", false);
                androidx.f.a.a.a(a.this.d.getApplicationContext()).a(new Intent("com.jumobile.manager.systemapp.ACTION_ADS_REMOVED"));
            }
            g a = dVar.a("remover_no_ads");
            if (a != null) {
                a.this.h = a.b();
                com.jumobile.manager.systemapp.f.a.b(a.this.e, "price_pro_edition", a.this.h);
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.inappbilling.a$6 */
    class AnonymousClass6 implements b.InterfaceC0091b {
        AnonymousClass6() {
        }

        @Override // com.jumobile.manager.systemapp.inappbilling.util.b.InterfaceC0091b
        public void a(c cVar, e eVar) {
            if (a.this.f == null || cVar.c() || !eVar.b().equals("remover_no_ads")) {
                return;
            }
            com.jumobile.manager.systemapp.f.a.b(a.this.e, "ads_enabled", false);
            androidx.f.a.a.a(a.this.d.getApplicationContext()).a(new Intent("com.jumobile.manager.systemapp.ACTION_ADS_REMOVED"));
        }
    }
}
