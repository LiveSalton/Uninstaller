package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.IPostMessageService;

/* compiled from: source */
/* loaded from: classes.dex */
public class PostMessageService extends Service {
    private IPostMessageService.Stub a = new IPostMessageService.Stub() { // from class: androidx.browser.customtabs.PostMessageService.1
        AnonymousClass1() {
        }

        @Override // android.support.customtabs.IPostMessageService
        public void onMessageChannelReady(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) throws RemoteException {
            iCustomTabsCallback.onMessageChannelReady(bundle);
        }

        @Override // android.support.customtabs.IPostMessageService
        public void onPostMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) throws RemoteException {
            iCustomTabsCallback.onPostMessage(str, bundle);
        }
    };

    /* compiled from: source */
    /* renamed from: androidx.browser.customtabs.PostMessageService$1 */
    class AnonymousClass1 extends IPostMessageService.Stub {
        AnonymousClass1() {
        }

        @Override // android.support.customtabs.IPostMessageService
        public void onMessageChannelReady(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) throws RemoteException {
            iCustomTabsCallback.onMessageChannelReady(bundle);
        }

        @Override // android.support.customtabs.IPostMessageService
        public void onPostMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) throws RemoteException {
            iCustomTabsCallback.onPostMessage(str, bundle);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.a;
    }
}
