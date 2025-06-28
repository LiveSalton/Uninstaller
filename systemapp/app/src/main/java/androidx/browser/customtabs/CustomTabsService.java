package androidx.browser.customtabs;

import android.app.Service;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class CustomTabsService extends Service {
    final Map<IBinder, IBinder.DeathRecipient> a = new androidx.b.a();
    private ICustomTabsService.Stub b = new ICustomTabsService.Stub() { // from class: androidx.browser.customtabs.CustomTabsService.1
        AnonymousClass1() {
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean warmup(long j) {
            return CustomTabsService.this.a(j);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean newSession(ICustomTabsCallback iCustomTabsCallback) {
            f fVar = new f(iCustomTabsCallback);
            try {
                C00111 c00111 = new IBinder.DeathRecipient() { // from class: androidx.browser.customtabs.CustomTabsService.1.1
                    final /* synthetic */ f a;

                    C00111(f fVar2) {
                        fVar = fVar2;
                    }

                    @Override // android.os.IBinder.DeathRecipient
                    public void binderDied() {
                        CustomTabsService.this.a(fVar);
                    }
                };
                synchronized (CustomTabsService.this.a) {
                    iCustomTabsCallback.asBinder().linkToDeath(c00111, 0);
                    CustomTabsService.this.a.put(iCustomTabsCallback.asBinder(), c00111);
                }
                return CustomTabsService.this.b(fVar2);
            } catch (RemoteException unused) {
                return false;
            }
        }

        /* compiled from: source */
        /* renamed from: androidx.browser.customtabs.CustomTabsService$1$1 */
        class C00111 implements IBinder.DeathRecipient {
            final /* synthetic */ f a;

            C00111(f fVar2) {
                fVar = fVar2;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                CustomTabsService.this.a(fVar);
            }
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean mayLaunchUrl(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List<Bundle> list) {
            return CustomTabsService.this.a(new f(iCustomTabsCallback), uri, bundle, list);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public Bundle extraCommand(String str, Bundle bundle) {
            return CustomTabsService.this.a(str, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean updateVisuals(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return CustomTabsService.this.a(new f(iCustomTabsCallback), bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannel(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
            return CustomTabsService.this.a(new f(iCustomTabsCallback), uri);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public int postMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            return CustomTabsService.this.a(new f(iCustomTabsCallback), str, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean validateRelationship(ICustomTabsCallback iCustomTabsCallback, int i, Uri uri, Bundle bundle) {
            return CustomTabsService.this.a(new f(iCustomTabsCallback), i, uri, bundle);
        }
    };

    protected abstract int a(f fVar, String str, Bundle bundle);

    protected abstract Bundle a(String str, Bundle bundle);

    protected abstract boolean a(long j);

    protected abstract boolean a(f fVar, int i, Uri uri, Bundle bundle);

    protected abstract boolean a(f fVar, Uri uri);

    protected abstract boolean a(f fVar, Uri uri, Bundle bundle, List<Bundle> list);

    protected abstract boolean a(f fVar, Bundle bundle);

    protected abstract boolean b(f fVar);

    /* compiled from: source */
    /* renamed from: androidx.browser.customtabs.CustomTabsService$1 */
    class AnonymousClass1 extends ICustomTabsService.Stub {
        AnonymousClass1() {
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean warmup(long j) {
            return CustomTabsService.this.a(j);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean newSession(ICustomTabsCallback iCustomTabsCallback) {
            f fVar2 = new f(iCustomTabsCallback);
            try {
                C00111 c00111 = new IBinder.DeathRecipient() { // from class: androidx.browser.customtabs.CustomTabsService.1.1
                    final /* synthetic */ f a;

                    C00111(f fVar22) {
                        fVar = fVar22;
                    }

                    @Override // android.os.IBinder.DeathRecipient
                    public void binderDied() {
                        CustomTabsService.this.a(fVar);
                    }
                };
                synchronized (CustomTabsService.this.a) {
                    iCustomTabsCallback.asBinder().linkToDeath(c00111, 0);
                    CustomTabsService.this.a.put(iCustomTabsCallback.asBinder(), c00111);
                }
                return CustomTabsService.this.b(fVar22);
            } catch (RemoteException unused) {
                return false;
            }
        }

        /* compiled from: source */
        /* renamed from: androidx.browser.customtabs.CustomTabsService$1$1 */
        class C00111 implements IBinder.DeathRecipient {
            final /* synthetic */ f a;

            C00111(f fVar22) {
                fVar = fVar22;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                CustomTabsService.this.a(fVar);
            }
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean mayLaunchUrl(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List<Bundle> list) {
            return CustomTabsService.this.a(new f(iCustomTabsCallback), uri, bundle, list);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public Bundle extraCommand(String str, Bundle bundle) {
            return CustomTabsService.this.a(str, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean updateVisuals(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return CustomTabsService.this.a(new f(iCustomTabsCallback), bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannel(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
            return CustomTabsService.this.a(new f(iCustomTabsCallback), uri);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public int postMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            return CustomTabsService.this.a(new f(iCustomTabsCallback), str, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean validateRelationship(ICustomTabsCallback iCustomTabsCallback, int i, Uri uri, Bundle bundle) {
            return CustomTabsService.this.a(new f(iCustomTabsCallback), i, uri, bundle);
        }
    }

    protected boolean a(f fVar) {
        try {
            synchronized (this.a) {
                IBinder a = fVar.a();
                a.unlinkToDeath(this.a.get(a), 0);
                this.a.remove(a);
            }
            return true;
        } catch (NoSuchElementException unused) {
            return false;
        }
    }
}
