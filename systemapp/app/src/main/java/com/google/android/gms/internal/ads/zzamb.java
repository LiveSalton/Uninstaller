package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzamb implements zzakj, zzaly {
    private final zzalz a;
    private final HashSet<AbstractMap.SimpleEntry<String, zzahv<? super zzalz>>> b = new HashSet<>();

    public zzamb(zzalz zzalzVar) {
        this.a = zzalzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzakj
    public final void a(String str, String str2) {
        zzaki.a(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzakb
    public final void a(String str, Map map) {
        zzaki.a(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzaky
    public final void a(String str, JSONObject jSONObject) {
        zzaki.a(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzakj, com.google.android.gms.internal.ads.zzakb
    public final void b(String str, JSONObject jSONObject) {
        zzaki.b(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzakj, com.google.android.gms.internal.ads.zzaky
    public final void d(String str) {
        this.a.d(str);
    }

    @Override // com.google.android.gms.internal.ads.zzalz
    public final void a(String str, zzahv<? super zzalz> zzahvVar) {
        this.a.a(str, zzahvVar);
        this.b.add(new AbstractMap.SimpleEntry<>(str, zzahvVar));
    }

    @Override // com.google.android.gms.internal.ads.zzalz
    public final void b(String str, zzahv<? super zzalz> zzahvVar) {
        this.a.b(str, zzahvVar);
        this.b.remove(new AbstractMap.SimpleEntry(str, zzahvVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final void a() {
        Iterator<AbstractMap.SimpleEntry<String, zzahv<? super zzalz>>> it = this.b.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry<String, zzahv<? super zzalz>> next = it.next();
            String valueOf = String.valueOf(next.getValue().toString());
            zzd.a(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.a.b(next.getKey(), next.getValue());
        }
        this.b.clear();
    }
}
