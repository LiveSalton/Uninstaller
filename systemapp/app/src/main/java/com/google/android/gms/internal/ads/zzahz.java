package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdk;
import com.google.android.gms.internal.ads.zzbeq;
import com.google.android.gms.internal.ads.zzbew;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzbff;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzva;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzahz<T extends zzva & zzbdk & zzbeq & zzbex & zzbew & zzbfa & zzbff & zzbfh> implements zzahv<T> {
    private final zza a;
    private final zzckq b;
    private final zzaze c = new zzaze();
    private final zzaqk d;
    private final zzcqo e;

    public zzahz(zza zzaVar, zzaqk zzaqkVar, zzcqo zzcqoVar, zzckq zzckqVar) {
        this.a = zzaVar;
        this.d = zzaqkVar;
        this.e = zzcqoVar;
        this.b = zzckqVar;
    }

    private final boolean a(T t, Context context, String str, String str2) {
        zzp.c();
        boolean p = com.google.android.gms.ads.internal.util.zzm.p(context);
        zzp.c();
        com.google.android.gms.ads.internal.util.zzbf s = com.google.android.gms.ads.internal.util.zzm.s(context);
        if (this.b != null) {
            zzcqy.a(context, this.b, this.e, str2, "offline_open");
        }
        if (p) {
            this.e.a(this.c, str2);
            return false;
        }
        zzp.c();
        if (com.google.android.gms.ads.internal.util.zzm.r(context) && s != null) {
            if (((Boolean) zzwq.e().a(zzabf.eC)).booleanValue()) {
                zzp.c();
                AlertDialog.Builder d = com.google.android.gms.ads.internal.util.zzm.d(context);
                Resources d2 = zzp.g().d();
                d.setTitle(d2 == null ? "Open ad when you're back online." : d2.getString(R.string.offline_opt_in_title)).setMessage(d2 == null ? "We'll send you a notification with a link to the advertiser site." : d2.getString(R.string.offline_opt_in_message)).setPositiveButton(d2 == null ? "OK" : d2.getString(R.string.offline_opt_in_confirm), new DialogInterface.OnClickListener(this, context, str2, s, str, d2) { // from class: com.google.android.gms.internal.ads.ar
                    private final zzahz a;
                    private final Context b;
                    private final String c;
                    private final com.google.android.gms.ads.internal.util.zzbf d;
                    private final String e;
                    private final Resources f;

                    {
                        this.a = this;
                        this.b = context;
                        this.c = str2;
                        this.d = s;
                        this.e = str;
                        this.f = d2;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.a.a(this.b, this.c, this.d, this.e, this.f, dialogInterface, i);
                    }
                }).setNegativeButton(d2 == null ? "No thanks" : d2.getString(R.string.offline_opt_in_decline), new DialogInterface.OnClickListener(this, str2, context) { // from class: com.google.android.gms.internal.ads.at
                    private final zzahz a;
                    private final String b;
                    private final Context c;

                    {
                        this.a = this;
                        this.b = str2;
                        this.c = context;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.a.a(this.b, this.c, dialogInterface, i);
                    }
                }).setOnCancelListener(new DialogInterface.OnCancelListener(this, str2, context) { // from class: com.google.android.gms.internal.ads.as
                    private final zzahz a;
                    private final String b;
                    private final Context c;

                    {
                        this.a = this;
                        this.b = str2;
                        this.c = context;
                    }

                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        this.a.a(this.b, this.c, dialogInterface);
                    }
                });
                d.create().show();
                if (this.b != null) {
                    zzcqy.a(context, this.b, this.e, str2, "dialog_impression");
                }
                t.e();
                return true;
            }
        }
        this.e.a(str2);
        if (this.b != null) {
            HashMap hashMap = new HashMap();
            zzp.c();
            if (!com.google.android.gms.ads.internal.util.zzm.r(context)) {
                hashMap.put("dialog_not_shown_reason", "notifications_disabled");
            } else if (s == null) {
                hashMap.put("dialog_not_shown_reason", "work_manager_unavailable");
            } else {
                hashMap.put("dialog_not_shown_reason", "notification_flow_disabled");
            }
            zzcqy.a(context, this.b, this.e, str2, "dialog_not_shown", hashMap);
        }
        return false;
    }

    private final void a(int i) {
        if (this.b == null) {
            return;
        }
        this.b.a().a("action", "cct_action").a("cct_open_status", zzach.f[i - 1]).a();
    }

    private static boolean a(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int b(Map<String, String> map) {
        String str = map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            zzp.e();
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            zzp.e();
            return 6;
        }
        if ("c".equalsIgnoreCase(str)) {
            return zzp.e().b();
        }
        return -1;
    }

    private final void a(boolean z) {
        if (this.d != null) {
            this.d.a(z);
        }
    }

    @VisibleForTesting
    static Uri a(Context context, zzef zzefVar, Uri uri, View view, Activity activity) {
        if (zzefVar == null) {
            return uri;
        }
        try {
            return zzefVar.b(uri) ? zzefVar.a(uri, context, view, activity) : uri;
        } catch (zzei unused) {
            return uri;
        } catch (Exception e) {
            zzp.g().a(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    @VisibleForTesting
    static Uri a(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            String valueOf = String.valueOf(uri.toString());
            zzd.c(valueOf.length() != 0 ? "Error adding click uptime parameter to url: ".concat(valueOf) : new String("Error adding click uptime parameter to url: "), e);
        }
        return uri;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzahv
    public final /* synthetic */ void a(Object obj, Map map) {
        String str;
        boolean z;
        zzva zzvaVar = (zzva) obj;
        zzbex zzbexVar = (zzbex) zzvaVar;
        String a = zzaxm.a((String) map.get("u"), zzbexVar.getContext(), true);
        String str2 = (String) map.get("a");
        if (str2 == null) {
            zzd.e("Action missing from an open GMSG.");
            return;
        }
        if (this.a != null && !this.a.b()) {
            this.a.a(a);
            return;
        }
        zzdmu q = ((zzbdk) zzvaVar).q();
        zzdmz S = ((zzbeq) zzvaVar).S();
        if (q == null || S == null) {
            str = "";
            z = false;
        } else {
            z = q.ae;
            str = S.b;
        }
        if ("expand".equalsIgnoreCase(str2)) {
            if (((zzbew) zzvaVar).E()) {
                zzd.e("Cannot expand WebView that is already expanded.");
                return;
            } else {
                a(false);
                ((zzbfa) zzvaVar).b(a((Map<String, String>) map), b(map));
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str2)) {
            a(false);
            if (a != null) {
                ((zzbfa) zzvaVar).a(a((Map<String, String>) map), b(map), a);
                return;
            } else {
                ((zzbfa) zzvaVar).a(a((Map<String, String>) map), b(map), (String) map.get("html"), (String) map.get("baseurl"));
                return;
            }
        }
        if ("chrome_custom_tab".equalsIgnoreCase(str2)) {
            if (((Boolean) zzwq.e().a(zzabf.cg)).booleanValue()) {
                a(true);
                if (TextUtils.isEmpty(a)) {
                    zzd.e("Cannot open browser with null or empty url");
                    a(zzach.e);
                    return;
                }
                Uri a2 = a(a(zzbexVar.getContext(), ((zzbff) zzvaVar).C(), Uri.parse(a), ((zzbfh) zzvaVar).getView(), zzbexVar.g()));
                if (z && this.e != null && a((zzahz<T>) zzvaVar, zzbexVar.getContext(), a2.toString(), str)) {
                    return;
                }
                try {
                    try {
                        a(zzp.c().a(((zzbex) zzvaVar).g(), a2));
                        return;
                    } catch (ActivityNotFoundException e) {
                        zzd.e(e.getMessage());
                        a(5);
                        return;
                    }
                } catch (Throwable th) {
                    a(7);
                    throw th;
                }
            }
        }
        if ("app".equalsIgnoreCase(str2) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
            a(true);
            Intent a3 = new zzaic(zzbexVar.getContext(), ((zzbff) zzvaVar).C(), ((zzbfh) zzvaVar).getView()).a((Map<String, String>) map);
            if (!z || this.e == null || a3 == null || !a((zzahz<T>) zzvaVar, zzbexVar.getContext(), a3.getData().toString(), str)) {
                try {
                    ((zzbfa) zzvaVar).a(new com.google.android.gms.ads.internal.overlay.zzb(a3));
                    return;
                } catch (ActivityNotFoundException e2) {
                    zzd.e(e2.getMessage());
                    return;
                }
            }
            return;
        }
        if ("open_app".equalsIgnoreCase(str2)) {
            if (((Boolean) zzwq.e().a(zzabf.eu)).booleanValue()) {
                a(true);
                String str3 = (String) map.get("p");
                if (str3 == null) {
                    zzd.e("Package name missing from open app action.");
                    return;
                }
                if (z && this.e != null && a((zzahz<T>) zzvaVar, zzbexVar.getContext(), str3, str)) {
                    return;
                }
                PackageManager packageManager = zzbexVar.getContext().getPackageManager();
                if (packageManager == null) {
                    zzd.e("Cannot get package manager from open app action.");
                    return;
                }
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str3);
                if (launchIntentForPackage != null) {
                    ((zzbfa) zzvaVar).a(new com.google.android.gms.ads.internal.overlay.zzb(launchIntentForPackage));
                    return;
                }
                return;
            }
            return;
        }
        a(true);
        String str4 = (String) map.get("intent_url");
        Intent intent = null;
        if (!TextUtils.isEmpty(str4)) {
            try {
                intent = Intent.parseUri(str4, 0);
            } catch (URISyntaxException e3) {
                String valueOf = String.valueOf(str4);
                zzd.c(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e3);
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            if (!Uri.EMPTY.equals(data)) {
                Uri a4 = a(a(zzbexVar.getContext(), ((zzbff) zzvaVar).C(), data, ((zzbfh) zzvaVar).getView(), zzbexVar.g()));
                if (!TextUtils.isEmpty(intent.getType())) {
                    if (((Boolean) zzwq.e().a(zzabf.ev)).booleanValue()) {
                        intent.setDataAndType(a4, intent.getType());
                    }
                }
                intent.setData(a4);
            }
        }
        if (intent != null) {
            if (z && this.e != null && a((zzahz<T>) zzvaVar, zzbexVar.getContext(), intent.getData().toString(), str)) {
                return;
            }
            ((zzbfa) zzvaVar).a(new com.google.android.gms.ads.internal.overlay.zzb(intent));
            return;
        }
        if (!TextUtils.isEmpty(a)) {
            a = a(a(zzbexVar.getContext(), ((zzbff) zzvaVar).C(), Uri.parse(a), ((zzbfh) zzvaVar).getView(), zzbexVar.g())).toString();
        }
        String str5 = a;
        if (z && this.e != null && a((zzahz<T>) zzvaVar, zzbexVar.getContext(), str5, str)) {
            return;
        }
        ((zzbfa) zzvaVar).a(new com.google.android.gms.ads.internal.overlay.zzb((String) map.get("i"), str5, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
    }

    final /* synthetic */ void a(String str, Context context, DialogInterface dialogInterface) {
        this.e.a(str);
        if (this.b != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_action", "dismiss");
            zzcqy.a(context, this.b, this.e, str, "dialog_click", hashMap);
        }
    }

    final /* synthetic */ void a(String str, Context context, DialogInterface dialogInterface, int i) {
        this.e.a(str);
        if (this.b != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_action", "dismiss");
            zzcqy.a(context, this.b, this.e, str, "dialog_click", hashMap);
        }
    }

    final /* synthetic */ void a(Context context, String str, com.google.android.gms.ads.internal.util.zzbf zzbfVar, String str2, Resources resources, DialogInterface dialogInterface, int i) {
        boolean z;
        if (this.b != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_action", "confirm");
            zzcqy.a(context, this.b, this.e, str, "dialog_click", hashMap);
        }
        try {
            z = zzbfVar.zzd(ObjectWrapper.a(context), str2, str);
        } catch (RemoteException e) {
            zzd.c("Failed to schedule offline notification poster.", e);
            z = false;
        }
        if (!z) {
            this.e.a(str);
            if (this.b != null) {
                zzcqy.a(context, this.b, this.e, str, "offline_notification_worker_not_scheduled");
            }
        }
        zzp.c();
        AlertDialog.Builder d = com.google.android.gms.ads.internal.util.zzm.d(context);
        d.setMessage(resources == null ? "You'll get a notification with the link when you're back online" : resources.getString(R.string.offline_opt_in_confirmation));
        AlertDialog create = d.create();
        create.show();
        Timer timer = new Timer();
        timer.schedule(new au(this, create, timer), 3000L);
    }
}
