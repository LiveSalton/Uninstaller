package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzcf;
import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class alb implements zzdsl {
    private final Object a;
    private final zzdua b;
    private final zzdum c;
    private final zzdsi d;

    alb(Object obj, zzdua zzduaVar, zzdum zzdumVar, zzdsi zzdsiVar) {
        this.a = obj;
        this.b = zzduaVar;
        this.c = zzdumVar;
        this.d = zzdsiVar;
    }

    final zzdua a() {
        return this.b;
    }

    final synchronized boolean b() throws zzduk {
        try {
        } catch (Exception e) {
            throw new zzduk(2001, e);
        }
        return ((Boolean) this.a.getClass().getDeclaredMethod("init", new Class[0]).invoke(this.a, new Object[0])).booleanValue();
    }

    public final synchronized void c() throws zzduk {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.a.getClass().getDeclaredMethod("close", new Class[0]).invoke(this.a, new Object[0]);
            this.d.a(3001, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzduk(2003, e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdsl
    public final synchronized String a(Context context, String str) {
        Map<String, Object> a;
        a = this.c.a();
        a.put("f", "q");
        a.put("ctx", context);
        a.put("aid", null);
        return a(a((Map<String, String>) null, a));
    }

    @Override // com.google.android.gms.internal.ads.zzdsl
    public final synchronized String a(Context context, String str, View view, Activity activity) {
        Map<String, Object> b;
        b = this.c.b();
        b.put("f", "v");
        b.put("ctx", context);
        b.put("aid", null);
        b.put("view", view);
        b.put("act", activity);
        return a(a((Map<String, String>) null, b));
    }

    @Override // com.google.android.gms.internal.ads.zzdsl
    public final synchronized String a(Context context, String str, String str2, View view, Activity activity) {
        Map<String, Object> c;
        c = this.c.c();
        c.put("f", "c");
        c.put("ctx", context);
        c.put("cs", str2);
        c.put("aid", null);
        c.put("view", view);
        c.put("act", activity);
        return a(a((Map<String, String>) null, c));
    }

    @Override // com.google.android.gms.internal.ads.zzdsl
    public final synchronized void a(String str, MotionEvent motionEvent) throws zzduk {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("aid", null);
            hashMap.put("evt", motionEvent);
            this.a.getClass().getDeclaredMethod("he", Map.class).invoke(this.a, hashMap);
            this.d.a(3003, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzduk(2005, e);
        }
    }

    public final synchronized int d() throws zzduk {
        try {
        } catch (Exception e) {
            throw new zzduk(2006, e);
        }
        return ((Integer) this.a.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.a, new Object[0])).intValue();
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(((zzcf.zzf) ((zzekh) zzcf.zzf.a().a(zzcm.DG).a(zzeiu.a(bArr)).g())).l(), 11);
    }

    private final synchronized byte[] a(Map<String, String> map, Map<String, Object> map2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e) {
            this.d.a(2007, System.currentTimeMillis() - currentTimeMillis, e);
            return null;
        }
        return (byte[]) this.a.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(this.a, null, map2);
    }
}
