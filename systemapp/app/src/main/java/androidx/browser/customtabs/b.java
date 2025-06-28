package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;

/* compiled from: source */
/* loaded from: classes.dex */
public class b {
    private final ICustomTabsService a;
    private final ComponentName b;

    b(ICustomTabsService iCustomTabsService, ComponentName componentName) {
        this.a = iCustomTabsService;
        this.b = componentName;
    }

    public static boolean a(Context context, String str, d dVar) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, dVar, 33);
    }

    public boolean a(long j) {
        try {
            return this.a.warmup(j);
        } catch (RemoteException unused) {
            return false;
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.browser.customtabs.b$1 */
    class AnonymousClass1 extends ICustomTabsCallback.Stub {
        final /* synthetic */ a a;
        private Handler c = new Handler(Looper.getMainLooper());

        AnonymousClass1(a aVar) {
            aVar = aVar;
        }

        /* compiled from: source */
        /* renamed from: androidx.browser.customtabs.b$1$1 */
        class RunnableC00121 implements Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ Bundle b;

            RunnableC00121(int i, Bundle bundle) {
                i = i;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                aVar.a(i, bundle);
            }
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onNavigationEvent(int i, Bundle bundle) {
            if (aVar == null) {
                return;
            }
            this.c.post(new Runnable() { // from class: androidx.browser.customtabs.b.1.1
                final /* synthetic */ int a;
                final /* synthetic */ Bundle b;

                RunnableC00121(int i2, Bundle bundle2) {
                    i = i2;
                    bundle = bundle2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    aVar.a(i, bundle);
                }
            });
        }

        /* compiled from: source */
        /* renamed from: androidx.browser.customtabs.b$1$2 */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ Bundle b;

            AnonymousClass2(String str, Bundle bundle) {
                str = str;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                aVar.a(str, bundle);
            }
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void extraCallback(String str, Bundle bundle) throws RemoteException {
            if (aVar == null) {
                return;
            }
            this.c.post(new Runnable() { // from class: androidx.browser.customtabs.b.1.2
                final /* synthetic */ String a;
                final /* synthetic */ Bundle b;

                AnonymousClass2(String str2, Bundle bundle2) {
                    str = str2;
                    bundle = bundle2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    aVar.a(str, bundle);
                }
            });
        }

        /* compiled from: source */
        /* renamed from: androidx.browser.customtabs.b$1$3 */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ Bundle a;

            AnonymousClass3(Bundle bundle) {
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                aVar.a(bundle);
            }
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onMessageChannelReady(Bundle bundle) throws RemoteException {
            if (aVar == null) {
                return;
            }
            this.c.post(new Runnable() { // from class: androidx.browser.customtabs.b.1.3
                final /* synthetic */ Bundle a;

                AnonymousClass3(Bundle bundle2) {
                    bundle = bundle2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    aVar.a(bundle);
                }
            });
        }

        /* compiled from: source */
        /* renamed from: androidx.browser.customtabs.b$1$4 */
        class AnonymousClass4 implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ Bundle b;

            AnonymousClass4(String str, Bundle bundle) {
                str = str;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                aVar.b(str, bundle);
            }
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onPostMessage(String str, Bundle bundle) throws RemoteException {
            if (aVar == null) {
                return;
            }
            this.c.post(new Runnable() { // from class: androidx.browser.customtabs.b.1.4
                final /* synthetic */ String a;
                final /* synthetic */ Bundle b;

                AnonymousClass4(String str2, Bundle bundle2) {
                    str = str2;
                    bundle = bundle2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    aVar.b(str, bundle);
                }
            });
        }

        /* compiled from: source */
        /* renamed from: androidx.browser.customtabs.b$1$5 */
        class AnonymousClass5 implements Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ Uri b;
            final /* synthetic */ boolean c;
            final /* synthetic */ Bundle d;

            AnonymousClass5(int i, Uri uri, boolean z, Bundle bundle) {
                i = i;
                uri = uri;
                z = z;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                aVar.a(i, uri, z, bundle);
            }
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) throws RemoteException {
            if (aVar == null) {
                return;
            }
            this.c.post(new Runnable() { // from class: androidx.browser.customtabs.b.1.5
                final /* synthetic */ int a;
                final /* synthetic */ Uri b;
                final /* synthetic */ boolean c;
                final /* synthetic */ Bundle d;

                AnonymousClass5(int i2, Uri uri2, boolean z2, Bundle bundle2) {
                    i = i2;
                    uri = uri2;
                    z = z2;
                    bundle = bundle2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    aVar.a(i, uri, z, bundle);
                }
            });
        }
    }

    public e a(a aVar) {
        AnonymousClass1 anonymousClass1 = new ICustomTabsCallback.Stub() { // from class: androidx.browser.customtabs.b.1
            final /* synthetic */ a a;
            private Handler c = new Handler(Looper.getMainLooper());

            AnonymousClass1(a aVar2) {
                aVar = aVar2;
            }

            /* compiled from: source */
            /* renamed from: androidx.browser.customtabs.b$1$1 */
            class RunnableC00121 implements Runnable {
                final /* synthetic */ int a;
                final /* synthetic */ Bundle b;

                RunnableC00121(int i2, Bundle bundle2) {
                    i = i2;
                    bundle = bundle2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    aVar.a(i, bundle);
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void onNavigationEvent(int i2, Bundle bundle2) {
                if (aVar == null) {
                    return;
                }
                this.c.post(new Runnable() { // from class: androidx.browser.customtabs.b.1.1
                    final /* synthetic */ int a;
                    final /* synthetic */ Bundle b;

                    RunnableC00121(int i22, Bundle bundle22) {
                        i = i22;
                        bundle = bundle22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(i, bundle);
                    }
                });
            }

            /* compiled from: source */
            /* renamed from: androidx.browser.customtabs.b$1$2 */
            class AnonymousClass2 implements Runnable {
                final /* synthetic */ String a;
                final /* synthetic */ Bundle b;

                AnonymousClass2(String str2, Bundle bundle2) {
                    str = str2;
                    bundle = bundle2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    aVar.a(str, bundle);
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void extraCallback(String str2, Bundle bundle2) throws RemoteException {
                if (aVar == null) {
                    return;
                }
                this.c.post(new Runnable() { // from class: androidx.browser.customtabs.b.1.2
                    final /* synthetic */ String a;
                    final /* synthetic */ Bundle b;

                    AnonymousClass2(String str22, Bundle bundle22) {
                        str = str22;
                        bundle = bundle22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(str, bundle);
                    }
                });
            }

            /* compiled from: source */
            /* renamed from: androidx.browser.customtabs.b$1$3 */
            class AnonymousClass3 implements Runnable {
                final /* synthetic */ Bundle a;

                AnonymousClass3(Bundle bundle2) {
                    bundle = bundle2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    aVar.a(bundle);
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void onMessageChannelReady(Bundle bundle2) throws RemoteException {
                if (aVar == null) {
                    return;
                }
                this.c.post(new Runnable() { // from class: androidx.browser.customtabs.b.1.3
                    final /* synthetic */ Bundle a;

                    AnonymousClass3(Bundle bundle22) {
                        bundle = bundle22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(bundle);
                    }
                });
            }

            /* compiled from: source */
            /* renamed from: androidx.browser.customtabs.b$1$4 */
            class AnonymousClass4 implements Runnable {
                final /* synthetic */ String a;
                final /* synthetic */ Bundle b;

                AnonymousClass4(String str2, Bundle bundle2) {
                    str = str2;
                    bundle = bundle2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    aVar.b(str, bundle);
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void onPostMessage(String str2, Bundle bundle2) throws RemoteException {
                if (aVar == null) {
                    return;
                }
                this.c.post(new Runnable() { // from class: androidx.browser.customtabs.b.1.4
                    final /* synthetic */ String a;
                    final /* synthetic */ Bundle b;

                    AnonymousClass4(String str22, Bundle bundle22) {
                        str = str22;
                        bundle = bundle22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.b(str, bundle);
                    }
                });
            }

            /* compiled from: source */
            /* renamed from: androidx.browser.customtabs.b$1$5 */
            class AnonymousClass5 implements Runnable {
                final /* synthetic */ int a;
                final /* synthetic */ Uri b;
                final /* synthetic */ boolean c;
                final /* synthetic */ Bundle d;

                AnonymousClass5(int i2, Uri uri2, boolean z2, Bundle bundle2) {
                    i = i2;
                    uri = uri2;
                    z = z2;
                    bundle = bundle2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    aVar.a(i, uri, z, bundle);
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void onRelationshipValidationResult(int i2, Uri uri2, boolean z2, Bundle bundle2) throws RemoteException {
                if (aVar == null) {
                    return;
                }
                this.c.post(new Runnable() { // from class: androidx.browser.customtabs.b.1.5
                    final /* synthetic */ int a;
                    final /* synthetic */ Uri b;
                    final /* synthetic */ boolean c;
                    final /* synthetic */ Bundle d;

                    AnonymousClass5(int i22, Uri uri22, boolean z22, Bundle bundle22) {
                        i = i22;
                        uri = uri22;
                        z = z22;
                        bundle = bundle22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(i, uri, z, bundle);
                    }
                });
            }
        };
        try {
            if (this.a.newSession(anonymousClass1)) {
                return new e(this.a, anonymousClass1, this.b);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }
}
