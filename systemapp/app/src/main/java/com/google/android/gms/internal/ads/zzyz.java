package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.query.AdInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzyz {
    private Date g;
    private String h;
    private Location k;
    private String m;
    private String n;
    private boolean p;
    private AdInfo q;
    private String s;
    private final HashSet<String> a = new HashSet<>();
    private final Bundle b = new Bundle();
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> c = new HashMap<>();
    private final HashSet<String> d = new HashSet<>();
    private final Bundle e = new Bundle();
    private final HashSet<String> f = new HashSet<>();
    private final List<String> i = new ArrayList();
    private int j = -1;
    private boolean l = false;
    private int o = -1;
    private int r = -1;
    private int t = 60000;

    public final void a(String str) {
        this.a.add(str);
    }

    public final void a(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
        this.b.putBundle(cls.getName(), bundle);
    }

    public final void b(String str) {
        this.d.add(str);
    }

    public final void c(String str) {
        this.d.remove(str);
    }

    @Deprecated
    public final void a(Date date) {
        this.g = date;
    }

    @Deprecated
    public final void a(int i) {
        this.j = i;
    }

    public final void a(Location location) {
        this.k = location;
    }

    @Deprecated
    public final void a(boolean z) {
        this.o = z ? 1 : 0;
    }

    @Deprecated
    public final void b(boolean z) {
        this.p = z;
    }
}
