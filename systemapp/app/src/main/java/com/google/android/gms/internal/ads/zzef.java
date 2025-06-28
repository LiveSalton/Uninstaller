package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzef {
    private static final String[] e = {"/aclk", "/pcs/click", "/dbm/clk"};
    private String a = "googleads.g.doubleclick.net";
    private String b = "/pagead/ads";
    private String c = "ad.doubleclick.net";
    private String[] d = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private zzdv f;

    public zzef(zzdv zzdvVar) {
        this.f = zzdvVar;
    }

    private final boolean c(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.c);
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public final boolean a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String str : this.d) {
                if (host.endsWith(str)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public final zzdv a() {
        return this.f;
    }

    public final Uri a(Uri uri, Context context) throws zzei {
        return a(uri, this.f.a(context));
    }

    public final void a(MotionEvent motionEvent) {
        this.f.a(motionEvent);
    }

    public final Uri a(Uri uri, Context context, View view, Activity activity) throws zzei {
        try {
            return a(uri, this.f.a(context, uri.getQueryParameter("ai"), view, activity));
        } catch (UnsupportedOperationException unused) {
            throw new zzei("Provided Uri is not in a valid state");
        }
    }

    public final boolean b(Uri uri) {
        if (a(uri)) {
            for (String str : e) {
                if (uri.getPath().endsWith(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final Uri a(Uri uri, String str) throws zzei {
        try {
            boolean c = c(uri);
            if (c) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzei("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzei("Query parameter already exists: ms");
            }
            if (c) {
                String uri2 = uri.toString();
                int indexOf = uri2.indexOf(";adurl");
                if (indexOf != -1) {
                    int i = indexOf + 1;
                    return Uri.parse(uri2.substring(0, i) + "dc_ms=" + str + ";" + uri2.substring(i));
                }
                String encodedPath = uri.getEncodedPath();
                int indexOf2 = uri2.indexOf(encodedPath);
                return Uri.parse(uri2.substring(0, encodedPath.length() + indexOf2) + ";dc_ms=" + str + ";" + uri2.substring(indexOf2 + encodedPath.length()));
            }
            String uri3 = uri.toString();
            int indexOf3 = uri3.indexOf("&adurl");
            if (indexOf3 == -1) {
                indexOf3 = uri3.indexOf("?adurl");
            }
            if (indexOf3 != -1) {
                int i2 = indexOf3 + 1;
                return Uri.parse(uri3.substring(0, i2) + "ms=" + str + "&" + uri3.substring(i2));
            }
            return uri.buildUpon().appendQueryParameter("ms", str).build();
        } catch (UnsupportedOperationException unused) {
            throw new zzei("Provided Uri is not in a valid state");
        }
    }
}
