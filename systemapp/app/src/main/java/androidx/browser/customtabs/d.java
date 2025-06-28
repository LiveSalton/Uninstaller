package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsService;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class d implements ServiceConnection {
    public abstract void a(ComponentName componentName, b bVar);

    /* compiled from: source */
    /* renamed from: androidx.browser.customtabs.d$1 */
    class AnonymousClass1 extends b {
        AnonymousClass1(ICustomTabsService iCustomTabsService, ComponentName componentName) {
            super(iCustomTabsService, componentName);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a(componentName, new b(ICustomTabsService.Stub.asInterface(iBinder), componentName) { // from class: androidx.browser.customtabs.d.1
            AnonymousClass1(ICustomTabsService iCustomTabsService, ComponentName componentName2) {
                super(iCustomTabsService, componentName2);
            }
        });
    }
}
