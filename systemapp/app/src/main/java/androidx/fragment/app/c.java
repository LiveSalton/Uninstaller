package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class c {
    public abstract View a(int i);

    public abstract boolean a();

    @Deprecated
    public Fragment a(Context context, String str, Bundle bundle) {
        return Fragment.a(context, str, bundle);
    }
}
