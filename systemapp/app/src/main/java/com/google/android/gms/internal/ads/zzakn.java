package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class zzakn<ReferenceT> implements zzakk {
    private final Map<String, CopyOnWriteArrayList<zzahv<? super ReferenceT>>> a = new HashMap();
    private ReferenceT b;

    public final void a(ReferenceT referencet) {
        this.b = referencet;
    }

    @Override // com.google.android.gms.internal.ads.zzakk
    public final boolean h(String str) {
        return str != null && a(Uri.parse(str));
    }

    public final boolean a(Uri uri) {
        if (!"gmsg".equalsIgnoreCase(uri.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            return false;
        }
        b(uri);
        return true;
    }

    public final void b(Uri uri) {
        String path = uri.getPath();
        zzp.c();
        a(path, com.google.android.gms.ads.internal.util.zzm.b(uri));
    }

    private final synchronized void a(String str, Map<String, String> map) {
        if (zzd.a(2)) {
            String valueOf = String.valueOf(str);
            zzd.a(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                StringBuilder sb = new StringBuilder(4 + String.valueOf(str2).length() + String.valueOf(str3).length());
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                zzd.a(sb.toString());
            }
        }
        CopyOnWriteArrayList<zzahv<? super ReferenceT>> copyOnWriteArrayList = this.a.get(str);
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator<zzahv<? super ReferenceT>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                zzazj.e.execute(new Runnable(this, it.next(), map) { // from class: com.google.android.gms.internal.ads.bh
                    private final zzakn a;
                    private final zzahv b;
                    private final Map c;

                    {
                        this.a = this;
                        this.b = next;
                        this.c = map;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.a(this.b, this.c);
                    }
                });
            }
        } else if (((Boolean) zzwq.e().a(zzabf.dS)).booleanValue() && zzp.g().a() != null) {
            zzazj.a.execute(new Runnable(str) { // from class: com.google.android.gms.internal.ads.bi
                private final String a;

                {
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzp.g().a().b(this.a.substring(1));
                }
            });
        }
    }

    public final synchronized void a(String str, zzahv<? super ReferenceT> zzahvVar) {
        CopyOnWriteArrayList<zzahv<? super ReferenceT>> copyOnWriteArrayList = this.a.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.a.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(zzahvVar);
    }

    public final synchronized void b(String str, zzahv<? super ReferenceT> zzahvVar) {
        CopyOnWriteArrayList<zzahv<? super ReferenceT>> copyOnWriteArrayList = this.a.get(str);
        if (copyOnWriteArrayList == null) {
            return;
        }
        copyOnWriteArrayList.remove(zzahvVar);
    }

    public final synchronized void a(String str, Predicate<zzahv<? super ReferenceT>> predicate) {
        CopyOnWriteArrayList<zzahv<? super ReferenceT>> copyOnWriteArrayList = this.a.get(str);
        if (copyOnWriteArrayList == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            zzahv<? super ReferenceT> zzahvVar = (zzahv) it.next();
            if (predicate.a(zzahvVar)) {
                arrayList.add(zzahvVar);
            }
        }
        copyOnWriteArrayList.removeAll(arrayList);
    }

    public final synchronized void d() {
        this.a.clear();
    }

    final /* synthetic */ void a(zzahv zzahvVar, Map map) {
        zzahvVar.a(this.b, map);
    }
}
