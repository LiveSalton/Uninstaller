package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzcdz implements zzccm {
    private final zzanv a;
    private final zzanw b;
    private final zzaob c;
    private final zzbsl d;
    private final zzbrt e;
    private final Context f;
    private final zzdmu g;
    private final zzazh h;
    private final zzdnn i;
    private boolean j = false;
    private boolean k = false;
    private boolean l = true;

    public zzcdz(zzanv zzanvVar, zzanw zzanwVar, zzaob zzaobVar, zzbsl zzbslVar, zzbrt zzbrtVar, Context context, zzdmu zzdmuVar, zzazh zzazhVar, zzdnn zzdnnVar) {
        this.a = zzanvVar;
        this.b = zzanwVar;
        this.c = zzaobVar;
        this.d = zzbslVar;
        this.e = zzbrtVar;
        this.f = context;
        this.g = zzdmuVar;
        this.h = zzazhVar;
        this.i = zzdnnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final JSONObject a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(View view, MotionEvent motionEvent, View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(zzage zzageVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void b(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void c() {
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final boolean c(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void d() {
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void f() {
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void g() {
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        try {
            IObjectWrapper a = ObjectWrapper.a(view);
            this.l = a(map, map2);
            HashMap<String, View> a2 = a(map);
            HashMap<String, View> a3 = a(map2);
            if (this.c != null) {
                this.c.a(a, ObjectWrapper.a(a2), ObjectWrapper.a(a3));
                return;
            }
            if (this.a != null) {
                this.a.a(a, ObjectWrapper.a(a2), ObjectWrapper.a(a3));
                this.a.b(a);
            } else if (this.b != null) {
                this.b.a(a, ObjectWrapper.a(a2), ObjectWrapper.a(a3));
                this.b.b(a);
            }
        } catch (RemoteException e) {
            zzd.d("Failed to call trackView", e);
        }
    }

    private static HashMap<String, View> a(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                View view = entry.getValue().get();
                if (view != null) {
                    hashMap.put(entry.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(View view, Map<String, WeakReference<View>> map) {
        try {
            IObjectWrapper a = ObjectWrapper.a(view);
            if (this.c != null) {
                this.c.b(a);
            } else if (this.a != null) {
                this.a.c(a);
            } else if (this.b != null) {
                this.b.c(a);
            }
        } catch (RemoteException e) {
            zzd.d("Failed to call untrackView", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (this.k && this.g.G) {
            return;
        }
        b(view);
    }

    private final void b(View view) {
        try {
            if (this.c != null && !this.c.q()) {
                this.c.a(ObjectWrapper.a(view));
                this.e.e();
            } else if (this.a != null && !this.a.k()) {
                this.a.a(ObjectWrapper.a(view));
                this.e.e();
            } else {
                if (this.b == null || this.b.i()) {
                    return;
                }
                this.b.a(ObjectWrapper.a(view));
                this.e.e();
            }
        } catch (RemoteException e) {
            zzd.d("Failed to call handleClick", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.k) {
            zzd.e("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.g.G) {
            zzd.e("Custom click reporting for 3p ads failed. Ad unit id not whitelisted.");
        } else {
            b(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a() {
        this.k = true;
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final boolean b() {
        return this.g.G;
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void b(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        try {
            if (!this.j && this.g.B != null) {
                this.j |= zzp.m().b(this.f, this.h.a, this.g.B.toString(), this.i.f);
            }
            if (this.l) {
                if (this.c != null && !this.c.p()) {
                    this.c.r();
                    this.d.a();
                } else if (this.a != null && !this.a.j()) {
                    this.a.i();
                    this.d.a();
                } else {
                    if (this.b == null || this.b.h()) {
                        return;
                    }
                    this.b.g();
                    this.d.a();
                }
            }
        } catch (RemoteException e) {
            zzd.d("Failed to call recordImpression", e);
        }
    }

    private final boolean a(Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        View view;
        JSONObject jSONObject = this.g.af;
        if (!((Boolean) zzwq.e().a(zzabf.aR)).booleanValue() || jSONObject.length() == 0) {
            return true;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(map2);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONArray optJSONArray = jSONObject.optJSONArray(next);
            if (optJSONArray != null) {
                WeakReference weakReference = (WeakReference) hashMap.get(next);
                if (weakReference == null || (view = (View) weakReference.get()) == null) {
                    return false;
                }
                Class<?> cls = view.getClass();
                try {
                    ArrayList arrayList = new ArrayList();
                    com.google.android.gms.ads.internal.util.zzbk.a(optJSONArray, arrayList);
                    zzp.c();
                    if (!com.google.android.gms.ads.internal.util.zzm.a(this.f.getClassLoader(), cls, arrayList)) {
                        return false;
                    }
                } catch (JSONException unused) {
                    continue;
                }
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(zzyd zzydVar) {
        zzd.e("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(zzxz zzxzVar) {
        zzd.e("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void e() {
        zzd.e("Mute This Ad is not supported for 3rd party ads");
    }
}
