package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzard {
    private static final Object a = new Object();

    @VisibleForTesting
    @GuardedBy("lock")
    private static boolean b = false;

    @VisibleForTesting
    @GuardedBy("lock")
    private static boolean c = false;

    @VisibleForTesting
    private zzdse d;

    public final boolean a(Context context) {
        synchronized (a) {
            if (!((Boolean) zzwq.e().a(zzabf.cz)).booleanValue()) {
                return false;
            }
            if (b) {
                return true;
            }
            try {
                c(context);
                boolean a2 = this.d.a(ObjectWrapper.a(context));
                b = a2;
                return a2;
            } catch (RemoteException | NullPointerException e) {
                zzaza.e("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    @VisibleForTesting
    private final void c(Context context) {
        synchronized (a) {
            if (((Boolean) zzwq.e().a(zzabf.cz)).booleanValue() && !c) {
                try {
                    c = true;
                    this.d = (zzdse) zzazd.a(context, "com.google.android.gms.ads.omid.DynamiteOmid", dr.a);
                } catch (zzazf e) {
                    zzaza.e("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final String b(Context context) {
        if (!((Boolean) zzwq.e().a(zzabf.cz)).booleanValue()) {
            return null;
        }
        try {
            c(context);
            String valueOf = String.valueOf(this.d.a());
            return valueOf.length() != 0 ? "a.".concat(valueOf) : new String("a.");
        } catch (RemoteException | NullPointerException e) {
            zzaza.e("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final IObjectWrapper a(String str, WebView webView, String str2, String str3, String str4) {
        return a(str, webView, str2, str3, str4, "Google");
    }

    public final IObjectWrapper a(String str, WebView webView, String str2, String str3, String str4, String str5) {
        synchronized (a) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (((Boolean) zzwq.e().a(zzabf.cz)).booleanValue() && b) {
                    try {
                        return this.d.a(str, ObjectWrapper.a(webView), str2, str3, str4, str5);
                    } catch (RemoteException | NullPointerException e) {
                        zzaza.e("#007 Could not call remote method.", e);
                        return null;
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public final IObjectWrapper a(String str, WebView webView, String str2, String str3, String str4, zzarg zzargVar, zzare zzareVar, String str5) {
        return b(str, webView, str2, str3, str4, "Google", zzargVar, zzareVar, str5);
    }

    private final IObjectWrapper b(String str, WebView webView, String str2, String str3, String str4, String str5, zzarg zzargVar, zzare zzareVar, String str6) {
        synchronized (a) {
            try {
                try {
                    if (((Boolean) zzwq.e().a(zzabf.cz)).booleanValue() && b) {
                        if (!((Boolean) zzwq.e().a(zzabf.cB)).booleanValue()) {
                            return a(str, webView, str2, str3, str4, str5);
                        }
                        try {
                            return this.d.b(str, ObjectWrapper.a(webView), str2, str3, str4, str5, zzargVar.toString(), zzareVar.toString(), str6);
                        } catch (RemoteException | NullPointerException e) {
                            zzaza.e("#007 Could not call remote method.", e);
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public final IObjectWrapper a(String str, WebView webView, String str2, String str3, String str4, String str5, zzarg zzargVar, zzare zzareVar, String str6) {
        synchronized (a) {
            try {
                try {
                    if (((Boolean) zzwq.e().a(zzabf.cz)).booleanValue() && b) {
                        if (!((Boolean) zzwq.e().a(zzabf.cC)).booleanValue()) {
                            return a(str, webView, str2, str3, str4, str5);
                        }
                        try {
                            return this.d.a(str, ObjectWrapper.a(webView), str2, str3, str4, str5, zzargVar.toString(), zzareVar.toString(), str6);
                        } catch (RemoteException | NullPointerException e) {
                            zzaza.e("#007 Could not call remote method.", e);
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public final void a(IObjectWrapper iObjectWrapper) {
        synchronized (a) {
            if (((Boolean) zzwq.e().a(zzabf.cz)).booleanValue() && b) {
                try {
                    this.d.b(iObjectWrapper);
                } catch (RemoteException | NullPointerException e) {
                    zzaza.e("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void b(IObjectWrapper iObjectWrapper) {
        synchronized (a) {
            if (((Boolean) zzwq.e().a(zzabf.cz)).booleanValue() && b) {
                try {
                    this.d.c(iObjectWrapper);
                } catch (RemoteException | NullPointerException e) {
                    zzaza.e("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void a(IObjectWrapper iObjectWrapper, View view) {
        synchronized (a) {
            if (((Boolean) zzwq.e().a(zzabf.cz)).booleanValue() && b) {
                try {
                    this.d.a(iObjectWrapper, ObjectWrapper.a(view));
                } catch (RemoteException | NullPointerException e) {
                    zzaza.e("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void b(IObjectWrapper iObjectWrapper, View view) {
        synchronized (a) {
            if (((Boolean) zzwq.e().a(zzabf.cz)).booleanValue() && b) {
                try {
                    this.d.b(iObjectWrapper, ObjectWrapper.a(view));
                } catch (RemoteException | NullPointerException e) {
                    zzaza.e("#007 Could not call remote method.", e);
                }
            }
        }
    }
}
