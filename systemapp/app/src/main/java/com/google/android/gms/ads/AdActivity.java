package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzarj;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzwq;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public final class AdActivity extends Activity {
    private zzarj a;

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = zzwq.b().a(this);
        if (this.a == null) {
            zzaza.e("#007 Could not call remote method.", null);
            finish();
            return;
        }
        try {
            this.a.a(bundle);
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onRestart() {
        super.onRestart();
        try {
            if (this.a != null) {
                this.a.g();
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onStart() {
        super.onStart();
        try {
            if (this.a != null) {
                this.a.h();
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            this.a.e();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // android.app.Activity
    protected final void onResume() {
        super.onResume();
        try {
            if (this.a != null) {
                this.a.i();
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onPause() {
        try {
            if (this.a != null) {
                this.a.j();
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.a != null) {
                this.a.b(bundle);
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected final void onStop() {
        try {
            if (this.a != null) {
                this.a.k();
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        try {
            if (this.a != null) {
                this.a.l();
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    private final void a() {
        if (this.a != null) {
            try {
                this.a.m();
            } catch (RemoteException e) {
                zzaza.e("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i) {
        super.setContentView(i);
        a();
    }

    @Override // android.app.Activity
    public final void setContentView(View view) {
        super.setContentView(view);
        a();
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        a();
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        boolean z = true;
        try {
            if (this.a != null) {
                z = this.a.f();
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
        if (z) {
            super.onBackPressed();
            try {
                this.a.d();
            } catch (RemoteException e2) {
                zzaza.e("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.a.a(i, i2, intent);
        } catch (Exception e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.a.a(ObjectWrapper.a(configuration));
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }
}
