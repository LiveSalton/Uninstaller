package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.util.Log;

/* compiled from: source */
/* loaded from: classes.dex */
public class f {
    final ICustomTabsCallback a;
    private final a b = new a() { // from class: androidx.browser.customtabs.f.1
        AnonymousClass1() {
        }

        @Override // androidx.browser.customtabs.a
        public void a(int i, Bundle bundle) {
            try {
                f.this.a.onNavigationEvent(i, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.a
        public void a(String str, Bundle bundle) {
            try {
                f.this.a.extraCallback(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.a
        public void a(Bundle bundle) {
            try {
                f.this.a.onMessageChannelReady(bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.a
        public void b(String str, Bundle bundle) {
            try {
                f.this.a.onPostMessage(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.a
        public void a(int i, Uri uri, boolean z, Bundle bundle) {
            try {
                f.this.a.onRelationshipValidationResult(i, uri, z, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }
    };

    f(ICustomTabsCallback iCustomTabsCallback) {
        this.a = iCustomTabsCallback;
    }

    /* compiled from: source */
    /* renamed from: androidx.browser.customtabs.f$1 */
    class AnonymousClass1 extends a {
        AnonymousClass1() {
        }

        @Override // androidx.browser.customtabs.a
        public void a(int i, Bundle bundle) {
            try {
                f.this.a.onNavigationEvent(i, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.a
        public void a(String str, Bundle bundle) {
            try {
                f.this.a.extraCallback(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.a
        public void a(Bundle bundle) {
            try {
                f.this.a.onMessageChannelReady(bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.a
        public void b(String str, Bundle bundle) {
            try {
                f.this.a.onPostMessage(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.a
        public void a(int i, Uri uri, boolean z, Bundle bundle) {
            try {
                f.this.a.onRelationshipValidationResult(i, uri, z, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }
    }

    IBinder a() {
        return this.a.asBinder();
    }

    public int hashCode() {
        return a().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return ((f) obj).a().equals(this.a.asBinder());
        }
        return false;
    }
}
