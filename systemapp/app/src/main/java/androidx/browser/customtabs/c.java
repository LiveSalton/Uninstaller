package androidx.browser.customtabs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public final class c {
    public final Intent a;
    public final Bundle b;

    public void a(Context context, Uri uri) {
        this.a.setData(uri);
        androidx.core.content.a.a(context, this.a, this.b);
    }

    c(Intent intent, Bundle bundle) {
        this.a = intent;
        this.b = bundle;
    }

    /* compiled from: source */
    public static final class a {
        private final Intent a;
        private ArrayList<Bundle> b;
        private Bundle c;
        private ArrayList<Bundle> d;
        private boolean e;

        public a() {
            this(null);
        }

        public a(e eVar) {
            this.a = new Intent("android.intent.action.VIEW");
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = true;
            if (eVar != null) {
                this.a.setPackage(eVar.b().getPackageName());
            }
            Bundle bundle = new Bundle();
            androidx.core.app.e.a(bundle, "android.support.customtabs.extra.SESSION", eVar != null ? eVar.a() : null);
            this.a.putExtras(bundle);
        }

        public c a() {
            if (this.b != null) {
                this.a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", this.b);
            }
            if (this.d != null) {
                this.a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", this.d);
            }
            this.a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.e);
            return new c(this.a, this.c);
        }
    }
}
