package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzabs {
    private zzabs e;
    private final List<zzabq> b = new LinkedList();
    private final Map<String, String> c = new LinkedHashMap();
    private final Object d = new Object();

    @VisibleForTesting
    final boolean a = true;

    public zzabs(boolean z, String str, String str2) {
        this.c.put("action", str);
        this.c.put("ad_format", str2);
    }

    public final void a(zzabs zzabsVar) {
        synchronized (this.d) {
            this.e = zzabsVar;
        }
    }

    public final zzabq a(long j) {
        if (this.a) {
            return new zzabq(j, null, null);
        }
        return null;
    }

    public final boolean a(zzabq zzabqVar, long j, String... strArr) {
        synchronized (this.d) {
            for (String str : strArr) {
                this.b.add(new zzabq(j, str, zzabqVar));
            }
        }
        return true;
    }

    public final zzabv a() {
        zzabv zzabvVar;
        boolean booleanValue = ((Boolean) zzwq.e().a(zzabf.aW)).booleanValue();
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        synchronized (this.d) {
            for (zzabq zzabqVar : this.b) {
                long a = zzabqVar.a();
                String b = zzabqVar.b();
                zzabq c = zzabqVar.c();
                if (c != null && a > 0) {
                    long a2 = a - c.a();
                    sb.append(b);
                    sb.append('.');
                    sb.append(a2);
                    sb.append(',');
                    if (booleanValue) {
                        if (!hashMap.containsKey(Long.valueOf(c.a()))) {
                            hashMap.put(Long.valueOf(c.a()), new StringBuilder(b));
                        } else {
                            StringBuilder sb2 = (StringBuilder) hashMap.get(Long.valueOf(c.a()));
                            sb2.append('+');
                            sb2.append(b);
                        }
                    }
                }
            }
            this.b.clear();
            String str = null;
            if (!TextUtils.isEmpty(null)) {
                sb.append((String) null);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            StringBuilder sb3 = new StringBuilder();
            if (booleanValue) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb3.append((CharSequence) entry.getValue());
                    sb3.append('.');
                    sb3.append(zzp.j().a() + (((Long) entry.getKey()).longValue() - zzp.j().b()));
                    sb3.append(',');
                }
                if (sb3.length() > 0) {
                    sb3.setLength(sb3.length() - 1);
                }
                str = sb3.toString();
            }
            zzabvVar = new zzabv(sb.toString(), str);
        }
        return zzabvVar;
    }

    public final void a(String str, String str2) {
        zzabi a;
        if (!this.a || TextUtils.isEmpty(str2) || (a = zzp.g().a()) == null) {
            return;
        }
        synchronized (this.d) {
            zzabm a2 = a.a(str);
            Map<String, String> map = this.c;
            map.put(str, a2.a(map.get(str), str2));
        }
    }

    @VisibleForTesting
    public final Map<String, String> b() {
        synchronized (this.d) {
            zzabi a = zzp.g().a();
            if (a != null && this.e != null) {
                return a.a(this.c, this.e.b());
            }
            return this.c;
        }
    }
}
