package com.jumobile.manager.systemapp.inappbilling.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* compiled from: source */
/* loaded from: classes.dex */
public class b {
    Context j;
    IInAppBillingService k;
    ServiceConnection l;
    int m;
    String n;
    String o;
    InterfaceC0091b p;
    boolean a = false;
    String b = "IabHelper";
    boolean c = false;
    boolean d = false;
    boolean e = false;
    boolean f = false;
    boolean g = false;
    boolean h = false;
    private final Object q = new Object();
    String i = "";

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.inappbilling.util.b$b */
    public interface InterfaceC0091b {
        void a(com.jumobile.manager.systemapp.inappbilling.util.c cVar, e eVar);
    }

    /* compiled from: source */
    public interface c {
        void a(com.jumobile.manager.systemapp.inappbilling.util.c cVar);
    }

    /* compiled from: source */
    public interface d {
        void a(com.jumobile.manager.systemapp.inappbilling.util.c cVar, com.jumobile.manager.systemapp.inappbilling.util.d dVar);
    }

    public b(Context context, String str) {
        this.o = null;
        this.j = context.getApplicationContext();
        this.o = str;
        c("IAB helper created.");
    }

    public void a(c cVar) {
        c();
        if (this.c) {
            throw new IllegalStateException("IAB helper is already set up.");
        }
        c("Starting in-app billing setup.");
        this.l = new ServiceConnection() { // from class: com.jumobile.manager.systemapp.inappbilling.util.b.1
            final /* synthetic */ c a;

            AnonymousClass1(c cVar2) {
                cVar = cVar2;
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                b.this.c("Billing service disconnected.");
                b.this.k = null;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (b.this.d) {
                    return;
                }
                b.this.c("Billing service connected.");
                b.this.k = IInAppBillingService.Stub.asInterface(iBinder);
                String packageName = b.this.j.getPackageName();
                try {
                    b.this.c("Checking for in-app billing 3 support.");
                    int isBillingSupported = b.this.k.isBillingSupported(3, packageName, "inapp");
                    if (isBillingSupported != 0) {
                        if (cVar != null) {
                            cVar.a(new com.jumobile.manager.systemapp.inappbilling.util.c(isBillingSupported, "Error checking for billing v3 support."));
                        }
                        b.this.f = false;
                        b.this.g = false;
                        return;
                    }
                    b.this.c("In-app billing version 3 supported for " + packageName);
                    if (b.this.k.isBillingSupported(5, packageName, "subs") == 0) {
                        b.this.c("Subscription re-signup AVAILABLE.");
                        b.this.g = true;
                    } else {
                        b.this.c("Subscription re-signup not available.");
                        b.this.g = false;
                    }
                    if (b.this.g) {
                        b.this.f = true;
                    } else {
                        int isBillingSupported2 = b.this.k.isBillingSupported(3, packageName, "subs");
                        if (isBillingSupported2 == 0) {
                            b.this.c("Subscriptions AVAILABLE.");
                            b.this.f = true;
                        } else {
                            b.this.c("Subscriptions NOT AVAILABLE. Response: " + isBillingSupported2);
                            b.this.f = false;
                            b.this.g = false;
                        }
                    }
                    b.this.c = true;
                    if (cVar != null) {
                        cVar.a(new com.jumobile.manager.systemapp.inappbilling.util.c(0, "Setup successful."));
                    }
                } catch (RemoteException e) {
                    if (cVar != null) {
                        cVar.a(new com.jumobile.manager.systemapp.inappbilling.util.c(-1001, "RemoteException while setting up in-app billing."));
                    }
                    e.printStackTrace();
                }
            }
        };
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> queryIntentServices = this.j.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            this.j.bindService(intent, this.l, 1);
        } else if (cVar2 != null) {
            cVar2.a(new com.jumobile.manager.systemapp.inappbilling.util.c(3, "Billing service unavailable on device."));
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.inappbilling.util.b$1 */
    class AnonymousClass1 implements ServiceConnection {
        final /* synthetic */ c a;

        AnonymousClass1(c cVar2) {
            cVar = cVar2;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.c("Billing service disconnected.");
            b.this.k = null;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (b.this.d) {
                return;
            }
            b.this.c("Billing service connected.");
            b.this.k = IInAppBillingService.Stub.asInterface(iBinder);
            String packageName = b.this.j.getPackageName();
            try {
                b.this.c("Checking for in-app billing 3 support.");
                int isBillingSupported = b.this.k.isBillingSupported(3, packageName, "inapp");
                if (isBillingSupported != 0) {
                    if (cVar != null) {
                        cVar.a(new com.jumobile.manager.systemapp.inappbilling.util.c(isBillingSupported, "Error checking for billing v3 support."));
                    }
                    b.this.f = false;
                    b.this.g = false;
                    return;
                }
                b.this.c("In-app billing version 3 supported for " + packageName);
                if (b.this.k.isBillingSupported(5, packageName, "subs") == 0) {
                    b.this.c("Subscription re-signup AVAILABLE.");
                    b.this.g = true;
                } else {
                    b.this.c("Subscription re-signup not available.");
                    b.this.g = false;
                }
                if (b.this.g) {
                    b.this.f = true;
                } else {
                    int isBillingSupported2 = b.this.k.isBillingSupported(3, packageName, "subs");
                    if (isBillingSupported2 == 0) {
                        b.this.c("Subscriptions AVAILABLE.");
                        b.this.f = true;
                    } else {
                        b.this.c("Subscriptions NOT AVAILABLE. Response: " + isBillingSupported2);
                        b.this.f = false;
                        b.this.g = false;
                    }
                }
                b.this.c = true;
                if (cVar != null) {
                    cVar.a(new com.jumobile.manager.systemapp.inappbilling.util.c(0, "Setup successful."));
                }
            } catch (RemoteException e) {
                if (cVar != null) {
                    cVar.a(new com.jumobile.manager.systemapp.inappbilling.util.c(-1001, "RemoteException while setting up in-app billing."));
                }
                e.printStackTrace();
            }
        }
    }

    public void a() throws a {
        synchronized (this.q) {
            if (this.h) {
                throw new a("Can't dispose because an async operation (" + this.i + ") is in progress.");
            }
        }
        c("Disposing.");
        this.c = false;
        if (this.l != null) {
            c("Unbinding from service.");
            if (this.j != null) {
                this.j.unbindService(this.l);
            }
        }
        this.d = true;
        this.j = null;
        this.l = null;
        this.k = null;
        this.p = null;
    }

    private void c() {
        if (this.d) {
            throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
        }
    }

    public void a(Activity activity, String str, int i, InterfaceC0091b interfaceC0091b, String str2) throws a {
        a(activity, str, "inapp", null, i, interfaceC0091b, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009b A[Catch: RemoteException -> 0x0115, SendIntentException -> 0x0140, TryCatch #2 {SendIntentException -> 0x0140, RemoteException -> 0x0115, blocks: (B:12:0x0035, B:14:0x0053, B:17:0x005a, B:19:0x005e, B:21:0x006c, B:24:0x0070, B:25:0x0095, B:27:0x009b, B:29:0x00bf, B:32:0x00c3, B:34:0x0084), top: B:11:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c3 A[Catch: RemoteException -> 0x0115, SendIntentException -> 0x0140, TRY_LEAVE, TryCatch #2 {SendIntentException -> 0x0140, RemoteException -> 0x0115, blocks: (B:12:0x0035, B:14:0x0053, B:17:0x005a, B:19:0x005e, B:21:0x006c, B:24:0x0070, B:25:0x0095, B:27:0x009b, B:29:0x00bf, B:32:0x00c3, B:34:0x0084), top: B:11:0x0035 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.app.Activity r15, java.lang.String r16, java.lang.String r17, java.util.List<java.lang.String> r18, int r19, com.jumobile.manager.systemapp.inappbilling.util.b.InterfaceC0091b r20, java.lang.String r21) throws com.jumobile.manager.systemapp.inappbilling.util.b.a {
        /*
            Method dump skipped, instructions count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumobile.manager.systemapp.inappbilling.util.b.a(android.app.Activity, java.lang.String, java.lang.String, java.util.List, int, com.jumobile.manager.systemapp.inappbilling.util.b$b, java.lang.String):void");
    }

    public boolean a(int i, int i2, Intent intent) {
        if (i != this.m) {
            return false;
        }
        c();
        a("handleActivityResult");
        b();
        if (intent == null) {
            d("Null data in IAB activity result.");
            com.jumobile.manager.systemapp.inappbilling.util.c cVar = new com.jumobile.manager.systemapp.inappbilling.util.c(-1002, "Null data in IAB result");
            if (this.p != null) {
                this.p.a(cVar, null);
            }
            return true;
        }
        int a2 = a(intent);
        String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
        String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
        if (i2 == -1 && a2 == 0) {
            c("Successful resultcode from purchase activity.");
            c("Purchase data: " + stringExtra);
            c("Data signature: " + stringExtra2);
            c("Extras: " + intent.getExtras());
            c("Expected item type: " + this.n);
            if (stringExtra == null || stringExtra2 == null) {
                d("BUG: either purchaseData or dataSignature is null.");
                c("Extras: " + intent.getExtras().toString());
                com.jumobile.manager.systemapp.inappbilling.util.c cVar2 = new com.jumobile.manager.systemapp.inappbilling.util.c(-1008, "IAB returned null purchaseData or dataSignature");
                if (this.p != null) {
                    this.p.a(cVar2, null);
                }
                return true;
            }
            try {
                e eVar = new e(this.n, stringExtra, stringExtra2);
                String b = eVar.b();
                if (!f.a(this.o, stringExtra, stringExtra2)) {
                    d("Purchase signature verification FAILED for sku " + b);
                    com.jumobile.manager.systemapp.inappbilling.util.c cVar3 = new com.jumobile.manager.systemapp.inappbilling.util.c(-1003, "Signature verification failed for sku " + b);
                    if (this.p != null) {
                        this.p.a(cVar3, eVar);
                    }
                    return true;
                }
                c("Purchase signature successfully verified.");
                if (this.p != null) {
                    this.p.a(new com.jumobile.manager.systemapp.inappbilling.util.c(0, "Success"), eVar);
                }
            } catch (JSONException e) {
                d("Failed to parse purchase data.");
                e.printStackTrace();
                com.jumobile.manager.systemapp.inappbilling.util.c cVar4 = new com.jumobile.manager.systemapp.inappbilling.util.c(-1002, "Failed to parse purchase data.");
                if (this.p != null) {
                    this.p.a(cVar4, null);
                }
                return true;
            }
        } else if (i2 == -1) {
            c("Result code was OK but in-app billing response was not OK: " + a(a2));
            if (this.p != null) {
                this.p.a(new com.jumobile.manager.systemapp.inappbilling.util.c(a2, "Problem purchashing item."), null);
            }
        } else if (i2 == 0) {
            c("Purchase canceled - Response: " + a(a2));
            com.jumobile.manager.systemapp.inappbilling.util.c cVar5 = new com.jumobile.manager.systemapp.inappbilling.util.c(-1005, "User canceled.");
            if (this.p != null) {
                this.p.a(cVar5, null);
            }
        } else {
            d("Purchase failed. Result code: " + Integer.toString(i2) + ". Response: " + a(a2));
            com.jumobile.manager.systemapp.inappbilling.util.c cVar6 = new com.jumobile.manager.systemapp.inappbilling.util.c(-1006, "Unknown purchase response.");
            if (this.p != null) {
                this.p.a(cVar6, null);
            }
        }
        return true;
    }

    public com.jumobile.manager.systemapp.inappbilling.util.d a(boolean z, List<String> list, List<String> list2) throws com.jumobile.manager.systemapp.inappbilling.util.a {
        int a2;
        int a3;
        c();
        a("queryInventory");
        try {
            com.jumobile.manager.systemapp.inappbilling.util.d dVar = new com.jumobile.manager.systemapp.inappbilling.util.d();
            int a4 = a(dVar, "inapp");
            if (a4 != 0) {
                throw new com.jumobile.manager.systemapp.inappbilling.util.a(a4, "Error refreshing inventory (querying owned items).");
            }
            if (z && (a3 = a("inapp", dVar, list)) != 0) {
                throw new com.jumobile.manager.systemapp.inappbilling.util.a(a3, "Error refreshing inventory (querying prices of items).");
            }
            if (this.f) {
                int a5 = a(dVar, "subs");
                if (a5 != 0) {
                    throw new com.jumobile.manager.systemapp.inappbilling.util.a(a5, "Error refreshing inventory (querying owned subscriptions).");
                }
                if (z && (a2 = a("subs", dVar, list2)) != 0) {
                    throw new com.jumobile.manager.systemapp.inappbilling.util.a(a2, "Error refreshing inventory (querying prices of subscriptions).");
                }
            }
            return dVar;
        } catch (RemoteException e) {
            throw new com.jumobile.manager.systemapp.inappbilling.util.a(-1001, "Remote exception while refreshing inventory.", e);
        } catch (JSONException e2) {
            throw new com.jumobile.manager.systemapp.inappbilling.util.a(-1002, "Error parsing JSON response while refreshing inventory.", e2);
        }
    }

    public void a(boolean z, List<String> list, List<String> list2, d dVar) throws a {
        Handler handler = new Handler();
        c();
        a("queryInventory");
        b("refresh inventory");
        new Thread(new Runnable() { // from class: com.jumobile.manager.systemapp.inappbilling.util.b.2
            final /* synthetic */ boolean a;
            final /* synthetic */ List b;
            final /* synthetic */ List c;
            final /* synthetic */ d d;
            final /* synthetic */ Handler e;

            AnonymousClass2(boolean z2, List list3, List list22, d dVar2, Handler handler2) {
                z = z2;
                list = list3;
                list2 = list22;
                dVar = dVar2;
                handler = handler2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.jumobile.manager.systemapp.inappbilling.util.d dVar2;
                com.jumobile.manager.systemapp.inappbilling.util.c cVar = new com.jumobile.manager.systemapp.inappbilling.util.c(0, "Inventory refresh successful.");
                try {
                    dVar2 = b.this.a(z, list, list2);
                } catch (com.jumobile.manager.systemapp.inappbilling.util.a e) {
                    cVar = e.a();
                    dVar2 = null;
                }
                b.this.b();
                if (b.this.d || dVar == null) {
                    return;
                }
                handler.post(new Runnable() { // from class: com.jumobile.manager.systemapp.inappbilling.util.b.2.1
                    final /* synthetic */ com.jumobile.manager.systemapp.inappbilling.util.c a;
                    final /* synthetic */ com.jumobile.manager.systemapp.inappbilling.util.d b;

                    AnonymousClass1(com.jumobile.manager.systemapp.inappbilling.util.c cVar2, com.jumobile.manager.systemapp.inappbilling.util.d dVar22) {
                        cVar = cVar2;
                        dVar2 = dVar22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.a(cVar, dVar2);
                    }
                });
            }

            /* compiled from: source */
            /* renamed from: com.jumobile.manager.systemapp.inappbilling.util.b$2$1 */
            class AnonymousClass1 implements Runnable {
                final /* synthetic */ com.jumobile.manager.systemapp.inappbilling.util.c a;
                final /* synthetic */ com.jumobile.manager.systemapp.inappbilling.util.d b;

                AnonymousClass1(com.jumobile.manager.systemapp.inappbilling.util.c cVar2, com.jumobile.manager.systemapp.inappbilling.util.d dVar22) {
                    cVar = cVar2;
                    dVar2 = dVar22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    dVar.a(cVar, dVar2);
                }
            }
        }).start();
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.inappbilling.util.b$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ List b;
        final /* synthetic */ List c;
        final /* synthetic */ d d;
        final /* synthetic */ Handler e;

        AnonymousClass2(boolean z2, List list3, List list22, d dVar2, Handler handler2) {
            z = z2;
            list = list3;
            list2 = list22;
            dVar = dVar2;
            handler = handler2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jumobile.manager.systemapp.inappbilling.util.d dVar22;
            com.jumobile.manager.systemapp.inappbilling.util.c cVar2 = new com.jumobile.manager.systemapp.inappbilling.util.c(0, "Inventory refresh successful.");
            try {
                dVar22 = b.this.a(z, list, list2);
            } catch (com.jumobile.manager.systemapp.inappbilling.util.a e) {
                cVar2 = e.a();
                dVar22 = null;
            }
            b.this.b();
            if (b.this.d || dVar == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.jumobile.manager.systemapp.inappbilling.util.b.2.1
                final /* synthetic */ com.jumobile.manager.systemapp.inappbilling.util.c a;
                final /* synthetic */ com.jumobile.manager.systemapp.inappbilling.util.d b;

                AnonymousClass1(com.jumobile.manager.systemapp.inappbilling.util.c cVar22, com.jumobile.manager.systemapp.inappbilling.util.d dVar222) {
                    cVar = cVar22;
                    dVar2 = dVar222;
                }

                @Override // java.lang.Runnable
                public void run() {
                    dVar.a(cVar, dVar2);
                }
            });
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.inappbilling.util.b$2$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ com.jumobile.manager.systemapp.inappbilling.util.c a;
            final /* synthetic */ com.jumobile.manager.systemapp.inappbilling.util.d b;

            AnonymousClass1(com.jumobile.manager.systemapp.inappbilling.util.c cVar22, com.jumobile.manager.systemapp.inappbilling.util.d dVar222) {
                cVar = cVar22;
                dVar2 = dVar222;
            }

            @Override // java.lang.Runnable
            public void run() {
                dVar.a(cVar, dVar2);
            }
        }
    }

    public static String a(int i) {
        String[] split = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] split2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        if (i <= -1000) {
            int i2 = (-1000) - i;
            if (i2 >= 0 && i2 < split2.length) {
                return split2[i2];
            }
            return String.valueOf(i) + ":Unknown IAB Helper Error";
        }
        if (i < 0 || i >= split.length) {
            return String.valueOf(i) + ":Unknown";
        }
        return split[i];
    }

    void a(String str) {
        if (this.c) {
            return;
        }
        d("Illegal state for operation (" + str + "): IAB helper is not set up.");
        throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + str);
    }

    int a(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            c("Bundle with null response code, assuming OK (known issue)");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return (int) ((Long) obj).longValue();
        }
        d("Unexpected type for bundle response code.");
        d(obj.getClass().getName());
        throw new RuntimeException("Unexpected type for bundle response code: " + obj.getClass().getName());
    }

    int a(Intent intent) {
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            d("Intent with no response code, assuming OK (known issue)");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return (int) ((Long) obj).longValue();
        }
        d("Unexpected type for intent response code.");
        d(obj.getClass().getName());
        throw new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
    }

    void b(String str) throws a {
        synchronized (this.q) {
            if (this.h) {
                throw new a("Can't start async operation (" + str + ") because another async operation (" + this.i + ") is in progress.");
            }
            this.i = str;
            this.h = true;
            c("Starting async operation: " + str);
        }
    }

    void b() {
        synchronized (this.q) {
            c("Ending async operation: " + this.i);
            this.i = "";
            this.h = false;
            if (this.e) {
                try {
                    a();
                } catch (a unused) {
                }
            }
        }
    }

    /* compiled from: source */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0178, code lost:
    
        return -1002;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int a(com.jumobile.manager.systemapp.inappbilling.util.d r13, java.lang.String r14) throws org.json.JSONException, android.os.RemoteException {
        /*
            Method dump skipped, instructions count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumobile.manager.systemapp.inappbilling.util.b.a(com.jumobile.manager.systemapp.inappbilling.util.d, java.lang.String):int");
    }

    int a(String str, com.jumobile.manager.systemapp.inappbilling.util.d dVar, List<String> list) throws RemoteException, JSONException {
        c("Querying SKU details.");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(dVar.c(str));
        if (list != null) {
            for (String str2 : list) {
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        if (arrayList.size() == 0) {
            c("queryPrices: nothing to do because there are no SKUs.");
            return 0;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size() / 20;
        int size2 = arrayList.size() % 20;
        for (int i = 0; i < size; i++) {
            ArrayList arrayList3 = new ArrayList();
            int i2 = i * 20;
            Iterator it = arrayList.subList(i2, i2 + 20).iterator();
            while (it.hasNext()) {
                arrayList3.add((String) it.next());
            }
            arrayList2.add(arrayList3);
        }
        if (size2 != 0) {
            ArrayList arrayList4 = new ArrayList();
            int i3 = size * 20;
            Iterator it2 = arrayList.subList(i3, size2 + i3).iterator();
            while (it2.hasNext()) {
                arrayList4.add((String) it2.next());
            }
            arrayList2.add(arrayList4);
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            ArrayList<String> arrayList5 = (ArrayList) it3.next();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList5);
            Bundle skuDetails = this.k.getSkuDetails(3, this.j.getPackageName(), str, bundle);
            if (!skuDetails.containsKey("DETAILS_LIST")) {
                int a2 = a(skuDetails);
                if (a2 != 0) {
                    c("getSkuDetails() failed: " + a(a2));
                    return a2;
                }
                d("getSkuDetails() returned a bundle with neither an error nor a detail list.");
                return -1002;
            }
            Iterator<String> it4 = skuDetails.getStringArrayList("DETAILS_LIST").iterator();
            while (it4.hasNext()) {
                g gVar = new g(str, it4.next());
                c("Got sku details: " + gVar);
                dVar.a(gVar);
            }
        }
        return 0;
    }

    void c(String str) {
        if (this.a) {
            Log.d(this.b, str);
        }
    }

    void d(String str) {
        Log.e(this.b, "In-app billing error: " + str);
    }

    void e(String str) {
        Log.w(this.b, "In-app billing warning: " + str);
    }
}
