package android.support.multidex;

import android.app.Application;
import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public class MultiDexApplication extends Application {
    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }
}
