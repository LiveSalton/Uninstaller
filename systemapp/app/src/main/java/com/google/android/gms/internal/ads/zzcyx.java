package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbwp;
import com.google.android.gms.internal.ads.zzczo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcyx extends zzaxt {
    private static final List<String> a = new ArrayList(Arrays.asList("/aclk", "/pcs/click"));
    private static final List<String> b = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com"));
    private static final List<String> c = new ArrayList(Arrays.asList("/pagead/adview", "/pcs/view", "/pagead/conversion"));
    private static final List<String> d = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"));
    private zzbgm e;
    private Context f;
    private zzef g;
    private zzazh h;
    private zzdod<zzcgh> i;
    private final zzdzc j;
    private final ScheduledExecutorService k;
    private zzasl l;
    private Point m = new Point();
    private Point n = new Point();

    public zzcyx(zzbgm zzbgmVar, Context context, zzef zzefVar, zzazh zzazhVar, zzdod<zzcgh> zzdodVar, zzdzc zzdzcVar, ScheduledExecutorService scheduledExecutorService) {
        this.e = zzbgmVar;
        this.f = context;
        this.g = zzefVar;
        this.h = zzazhVar;
        this.i = zzdodVar;
        this.j = zzdzcVar;
        this.k = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzaxq
    public final IObjectWrapper a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaxq
    public final IObjectWrapper b(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaxq
    public final void a(IObjectWrapper iObjectWrapper, zzaxw zzaxwVar, zzaxp zzaxpVar) {
        this.f = (Context) ObjectWrapper.a(iObjectWrapper);
        Context context = this.f;
        String str = zzaxwVar.a;
        String str2 = zzaxwVar.b;
        zzvn zzvnVar = zzaxwVar.c;
        zzvk zzvkVar = zzaxwVar.d;
        zzcyy q = this.e.q();
        zzbrg.zza a2 = new zzbrg.zza().a(context);
        zzdnp zzdnpVar = new zzdnp();
        if (str == null) {
            str = "adUnitId";
        }
        zzdnp a3 = zzdnpVar.a(str);
        if (zzvkVar == null) {
            zzvkVar = new zzvj().a();
        }
        zzdnp a4 = a3.a(zzvkVar);
        if (zzvnVar == null) {
            zzvnVar = new zzvn();
        }
        zzdyr.a(q.a(a2.a(a4.a(zzvnVar).e()).a()).a(new zzczo(new zzczo.zza().a(str2))).a(new zzbwp.zza().a()).a().a(), new abz(this, zzaxpVar), this.e.a());
    }

    @Override // com.google.android.gms.internal.ads.zzaxq
    public final void a(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzwq.e().a(zzabf.dX)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.a(iObjectWrapper);
            this.m = com.google.android.gms.ads.internal.util.zzbq.a(motionEvent, this.l == null ? null : this.l.a);
            if (motionEvent.getAction() == 0) {
                this.n = this.m;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setLocation(this.m.x, this.m.y);
            this.g.a(obtain);
            obtain.recycle();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxq
    public final void a(zzasl zzaslVar) {
        this.l = zzaslVar;
        this.i.a(1);
    }

    @Override // com.google.android.gms.internal.ads.zzaxq
    public final void a(List<Uri> list, IObjectWrapper iObjectWrapper, zzasa zzasaVar) {
        if (!((Boolean) zzwq.e().a(zzabf.dX)).booleanValue()) {
            try {
                zzasaVar.a("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e) {
                zzaza.c("", e);
                return;
            }
        }
        zzdyz submit = this.j.submit(new Callable(this, list, iObjectWrapper) { // from class: com.google.android.gms.internal.ads.abp
            private final zzcyx a;
            private final List b;
            private final IObjectWrapper c;

            {
                this.a = this;
                this.b = list;
                this.c = iObjectWrapper;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.a(this.b, this.c);
            }
        });
        if (a()) {
            submit = zzdyr.a(submit, new zzdyb(this) { // from class: com.google.android.gms.internal.ads.abn
                private final zzcyx a;

                {
                    this.a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdyb
                public final zzdyz a(Object obj) {
                    return this.a.a((ArrayList) obj);
                }
            }, this.j);
        } else {
            zzd.d("Asset view map is empty.");
        }
        zzdyr.a(submit, new aby(this, zzasaVar), this.e.a());
    }

    @Override // com.google.android.gms.internal.ads.zzaxq
    public final void b(List<Uri> list, IObjectWrapper iObjectWrapper, zzasa zzasaVar) {
        try {
            if (!((Boolean) zzwq.e().a(zzabf.dX)).booleanValue()) {
                zzasaVar.a("The updating URL feature is not enabled.");
                return;
            }
            if (list.size() != 1) {
                zzasaVar.a("There should be only 1 click URL.");
                return;
            }
            Uri uri = list.get(0);
            if (!a(uri, a, b)) {
                String valueOf = String.valueOf(uri);
                StringBuilder sb = new StringBuilder(18 + String.valueOf(valueOf).length());
                sb.append("Not a Google URL: ");
                sb.append(valueOf);
                zzd.e(sb.toString());
                zzasaVar.a(list);
                return;
            }
            zzdyz submit = this.j.submit(new Callable(this, uri, iObjectWrapper) { // from class: com.google.android.gms.internal.ads.abr
                private final zzcyx a;
                private final Uri b;
                private final IObjectWrapper c;

                {
                    this.a = this;
                    this.b = uri;
                    this.c = iObjectWrapper;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.a(this.b, this.c);
                }
            });
            if (a()) {
                submit = zzdyr.a(submit, new zzdyb(this) { // from class: com.google.android.gms.internal.ads.abq
                    private final zzcyx a;

                    {
                        this.a = this;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdyb
                    public final zzdyz a(Object obj) {
                        return this.a.a((Uri) obj);
                    }
                }, this.j);
            } else {
                zzd.d("Asset view map is empty.");
            }
            zzdyr.a(submit, new aca(this, zzasaVar), this.e.a());
        } catch (RemoteException e) {
            zzaza.c("", e);
        }
    }

    private static boolean b(Uri uri) {
        return a(uri, c, d);
    }

    /* renamed from: b */
    public final Uri a(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        try {
            uri = this.g.a(uri, this.f, (View) ObjectWrapper.a(iObjectWrapper), null);
        } catch (zzei e) {
            zzaza.d("", e);
        }
        if (uri.getQueryParameter("ms") == null) {
            throw new Exception("Failed to append spam signals to click url.");
        }
        return uri;
    }

    private static boolean a(Uri uri, List<String> list, List<String> list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (host == null || path == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (path.contains(it.next())) {
                Iterator<String> it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (host.endsWith(it2.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final zzdyz<String> a(String str) {
        zzcgh[] zzcghVarArr = new zzcgh[1];
        zzdyz a2 = zzdyr.a(this.i.a(), new zzdyb(this, zzcghVarArr, str) { // from class: com.google.android.gms.internal.ads.abx
            private final zzcyx a;
            private final zzcgh[] b;
            private final String c;

            {
                this.a = this;
                this.b = zzcghVarArr;
                this.c = str;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a(this.b, this.c, (zzcgh) obj);
            }
        }, this.j);
        a2.a(new Runnable(this, zzcghVarArr) { // from class: com.google.android.gms.internal.ads.abw
            private final zzcyx a;
            private final zzcgh[] b;

            {
                this.a = this;
                this.b = zzcghVarArr;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(this.b);
            }
        }, this.j);
        return zzdyi.c(a2).a(((Integer) zzwq.e().a(zzabf.dY)).intValue(), TimeUnit.MILLISECONDS, this.k).a(abv.a, this.j).a(Exception.class, abu.a, this.j);
    }

    private static Uri a(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf != -1) {
            int i = indexOf + 1;
            return Uri.parse(uri2.substring(0, i) + str + "=" + str2 + "&" + uri2.substring(i));
        }
        return uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    private final boolean a() {
        return (this.l == null || this.l.b == null || this.l.b.isEmpty()) ? false : true;
    }

    final /* synthetic */ void a(zzcgh[] zzcghVarArr) {
        if (zzcghVarArr[0] != null) {
            this.i.a(zzdyr.a(zzcghVarArr[0]));
        }
    }

    final /* synthetic */ zzdyz a(zzcgh[] zzcghVarArr, String str, zzcgh zzcghVar) throws Exception {
        zzcghVarArr[0] = zzcghVar;
        JSONObject a2 = com.google.android.gms.ads.internal.util.zzbq.a(this.f, this.l.b, this.l.b, this.l.a);
        JSONObject a3 = com.google.android.gms.ads.internal.util.zzbq.a(this.f, this.l.a);
        JSONObject a4 = com.google.android.gms.ads.internal.util.zzbq.a(this.l.a);
        JSONObject b2 = com.google.android.gms.ads.internal.util.zzbq.b(this.f, this.l.a);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", a2);
        jSONObject.put("ad_view_signal", a3);
        jSONObject.put("scroll_view_signal", a4);
        jSONObject.put("lock_screen_signal", b2);
        if (str == "google.afma.nativeAds.getPublisherCustomRenderedClickSignals") {
            jSONObject.put("click_signal", com.google.android.gms.ads.internal.util.zzbq.a((String) null, this.f, this.n, this.m));
        }
        return zzcghVar.a(str, jSONObject);
    }

    static final /* synthetic */ String a(Exception exc) {
        zzaza.c("", exc);
        return null;
    }

    static /* synthetic */ Uri a(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? a(uri, "nas", str) : uri;
    }

    static /* synthetic */ ArrayList a(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!b(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(a(uri, "nas", str));
            }
        }
        return arrayList;
    }

    final /* synthetic */ zzdyz a(Uri uri) throws Exception {
        return zzdyr.a(a("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzdvm(this, uri) { // from class: com.google.android.gms.internal.ads.abs
            private final zzcyx a;
            private final Uri b;

            {
                this.a = this;
                this.b = uri;
            }

            @Override // com.google.android.gms.internal.ads.zzdvm
            public final Object a(Object obj) {
                return zzcyx.a(this.b, (String) obj);
            }
        }, this.j);
    }

    final /* synthetic */ zzdyz a(ArrayList arrayList) throws Exception {
        return zzdyr.a(a("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzdvm(this, arrayList) { // from class: com.google.android.gms.internal.ads.abt
            private final zzcyx a;
            private final List b;

            {
                this.a = this;
                this.b = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzdvm
            public final Object a(Object obj) {
                return zzcyx.a(this.b, (String) obj);
            }
        }, this.j);
    }

    final /* synthetic */ ArrayList a(List list, IObjectWrapper iObjectWrapper) throws Exception {
        String a2 = this.g.a() != null ? this.g.a().a(this.f, (View) ObjectWrapper.a(iObjectWrapper), (Activity) null) : "";
        if (TextUtils.isEmpty(a2)) {
            throw new Exception("Failed to get view signals.");
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!b(uri)) {
                String valueOf = String.valueOf(uri);
                StringBuilder sb = new StringBuilder(18 + String.valueOf(valueOf).length());
                sb.append("Not a Google URL: ");
                sb.append(valueOf);
                zzd.e(sb.toString());
                arrayList.add(uri);
            } else {
                arrayList.add(a(uri, "ms", a2));
            }
        }
        if (arrayList.isEmpty()) {
            throw new Exception("Empty impression URLs result.");
        }
        return arrayList;
    }
}
