package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public interface zzccm {
    JSONObject a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2);

    void a();

    void a(Bundle bundle);

    void a(View view);

    void a(View view, MotionEvent motionEvent, View view2);

    void a(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z);

    void a(View view, Map<String, WeakReference<View>> map);

    void a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener);

    void a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z);

    void a(zzage zzageVar);

    void a(zzxz zzxzVar);

    void a(zzyd zzydVar);

    void a(String str);

    void b(Bundle bundle);

    void b(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2);

    boolean b();

    void c();

    boolean c(Bundle bundle);

    void d();

    void e();

    void f();

    void g();
}
