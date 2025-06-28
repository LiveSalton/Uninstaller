package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzckz {
    private List<Map<String, String>> a = new ArrayList();
    private boolean b = false;
    private boolean c = false;
    private String d;
    private zzckv e;

    public zzckz(String str, zzckv zzckvVar) {
        this.d = str;
        this.e = zzckvVar;
    }

    public final synchronized void a(String str) {
        if (((Boolean) zzwq.e().a(zzabf.aY)).booleanValue()) {
            Map<String, String> c = c();
            c.put("action", "adapter_init_started");
            c.put("ancn", str);
            this.a.add(c);
        }
    }

    public final synchronized void b(String str) {
        if (((Boolean) zzwq.e().a(zzabf.aY)).booleanValue()) {
            Map<String, String> c = c();
            c.put("action", "adapter_init_finished");
            c.put("ancn", str);
            this.a.add(c);
        }
    }

    public final synchronized void a(String str, String str2) {
        if (((Boolean) zzwq.e().a(zzabf.aY)).booleanValue()) {
            Map<String, String> c = c();
            c.put("action", "adapter_init_finished");
            c.put("ancn", str);
            c.put("rqe", str2);
            this.a.add(c);
        }
    }

    public final synchronized void a() {
        if (((Boolean) zzwq.e().a(zzabf.aY)).booleanValue()) {
            if (!this.b) {
                Map<String, String> c = c();
                c.put("action", "init_started");
                this.a.add(c);
                this.b = true;
            }
        }
    }

    public final synchronized void b() {
        if (((Boolean) zzwq.e().a(zzabf.aY)).booleanValue()) {
            if (!this.c) {
                Map<String, String> c = c();
                c.put("action", "init_finished");
                this.a.add(c);
                Iterator<Map<String, String>> it = this.a.iterator();
                while (it.hasNext()) {
                    this.e.a(it.next());
                }
                this.c = true;
            }
        }
    }

    private final Map<String, String> c() {
        Map<String, String> a = this.e.a();
        a.put("tms", Long.toString(zzp.j().b(), 10));
        a.put("tid", this.d);
        return a;
    }
}
