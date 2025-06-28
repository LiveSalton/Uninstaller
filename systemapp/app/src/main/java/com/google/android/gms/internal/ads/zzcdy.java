package com.google.android.gms.internal.ads;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public interface zzcdy extends View.OnClickListener, View.OnTouchListener {
    void a(String str, View view, boolean z);

    View a_(String str);

    FrameLayout b();

    View c();

    zzqq d();

    Map<String, WeakReference<View>> e();

    Map<String, WeakReference<View>> f();

    Map<String, WeakReference<View>> g();

    String h();

    IObjectWrapper i();

    JSONObject j();
}
