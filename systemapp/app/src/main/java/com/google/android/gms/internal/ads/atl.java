package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class atl<T extends zzejz<T>> {
    private static final atl d = new atl(true);
    final avi<T, Object> a;
    private boolean b;
    private boolean c;

    private atl() {
        this.a = avi.a(16);
    }

    private atl(boolean z) {
        this(avi.a(0));
        b();
    }

    private atl(avi<T, Object> aviVar) {
        this.a = aviVar;
        b();
    }

    public static <T extends zzejz<T>> atl<T> a() {
        return d;
    }

    public final void b() {
        if (this.b) {
            return;
        }
        this.a.a();
        this.b = true;
    }

    public final boolean c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof atl) {
            return this.a.equals(((atl) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> d() {
        if (this.c) {
            return new atw(this.a.entrySet().iterator());
        }
        return this.a.entrySet().iterator();
    }

    final Iterator<Map.Entry<T, Object>> e() {
        if (this.c) {
            return new atw(this.a.e().iterator());
        }
        return this.a.e().iterator();
    }

    private final Object a(T t) {
        Object obj = this.a.get(t);
        if (!(obj instanceof zzekt)) {
            return obj;
        }
        return zzekt.a();
    }

    private final void b(T t, Object obj) {
        if (t.d()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                a(t.b(), obj2);
            }
            obj = arrayList;
        } else {
            a(t.b(), obj);
        }
        if (obj instanceof zzekt) {
            this.c = true;
        }
        this.a.a((avi<T, Object>) t, (T) obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        if ((r3 instanceof com.google.android.gms.internal.ads.zzekt) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        if ((r3 instanceof com.google.android.gms.internal.ads.zzekj) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        if ((r3 instanceof byte[]) == false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.google.android.gms.internal.ads.zzenw r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.ads.zzekk.a(r3)
            int[] r0 = com.google.android.gms.internal.ads.atn.a
            com.google.android.gms.internal.ads.zzenz r2 = r2.a()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L31;
                case 7: goto L28;
                case 8: goto L1f;
                case 9: goto L16;
                default: goto L14;
            }
        L14:
            r0 = r1
            goto L42
        L16:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzels
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzekt
            if (r2 == 0) goto L14
            goto L42
        L1f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzekj
            if (r2 == 0) goto L14
            goto L42
        L28:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzeiu
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L14
            goto L42
        L31:
            boolean r0 = r3 instanceof java.lang.String
            goto L42
        L34:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L42
        L37:
            boolean r0 = r3 instanceof java.lang.Double
            goto L42
        L3a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L42
        L3d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L42
        L40:
            boolean r0 = r3 instanceof java.lang.Integer
        L42:
            if (r0 != 0) goto L4c
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.atl.a(com.google.android.gms.internal.ads.zzenw, java.lang.Object):void");
    }

    public final boolean f() {
        for (int i = 0; i < this.a.c(); i++) {
            if (!a((Map.Entry) this.a.b(i))) {
                return false;
            }
        }
        Iterator<Map.Entry<T, Object>> it = this.a.d().iterator();
        while (it.hasNext()) {
            if (!a((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzejz<T>> boolean a(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.c() == zzenz.MESSAGE) {
            if (key.d()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzels) it.next()).o()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzels) {
                    if (!((zzels) value).o()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzekt) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void a(atl<T> atlVar) {
        for (int i = 0; i < atlVar.a.c(); i++) {
            b(atlVar.a.b(i));
        }
        Iterator<Map.Entry<T, Object>> it = atlVar.a.d().iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    private static Object a(Object obj) {
        if (obj instanceof zzelx) {
            return ((zzelx) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void b(Map.Entry<T, Object> entry) {
        zzels g;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzekt) {
            value = zzekt.a();
        }
        if (key.d()) {
            Object a = a((atl<T>) key);
            if (a == null) {
                a = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) a).add(a(it.next()));
            }
            this.a.a((avi<T, Object>) key, (T) a);
            return;
        }
        if (key.c() == zzenz.MESSAGE) {
            Object a2 = a((atl<T>) key);
            if (a2 == null) {
                this.a.a((avi<T, Object>) key, (T) a(value));
                return;
            }
            if (a2 instanceof zzelx) {
                g = key.a((zzelx) a2, (zzelx) value);
            } else {
                g = key.a(((zzels) a2).u(), (zzels) value).g();
            }
            this.a.a((avi<T, Object>) key, (T) g);
            return;
        }
        this.a.a((avi<T, Object>) key, (T) a(value));
    }

    static void a(zzejo zzejoVar, zzenw zzenwVar, int i, Object obj) throws IOException {
        if (zzenwVar == zzenw.j) {
            zzels zzelsVar = (zzels) obj;
            zzekk.a(zzelsVar);
            zzejoVar.a(i, 3);
            zzelsVar.a(zzejoVar);
            zzejoVar.a(i, 4);
        }
        zzejoVar.a(i, zzenwVar.b());
        switch (atn.b[zzenwVar.ordinal()]) {
            case 1:
                zzejoVar.a(((Double) obj).doubleValue());
                break;
            case 2:
                zzejoVar.a(((Float) obj).floatValue());
                break;
            case 3:
                zzejoVar.a(((Long) obj).longValue());
                break;
            case 4:
                zzejoVar.a(((Long) obj).longValue());
                break;
            case 5:
                zzejoVar.a(((Integer) obj).intValue());
                break;
            case 6:
                zzejoVar.c(((Long) obj).longValue());
                break;
            case 7:
                zzejoVar.d(((Integer) obj).intValue());
                break;
            case 8:
                zzejoVar.a(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzels) obj).a(zzejoVar);
                break;
            case 10:
                zzejoVar.a((zzels) obj);
                break;
            case 11:
                if (obj instanceof zzeiu) {
                    zzejoVar.a((zzeiu) obj);
                    break;
                } else {
                    zzejoVar.a((String) obj);
                    break;
                }
            case 12:
                if (obj instanceof zzeiu) {
                    zzejoVar.a((zzeiu) obj);
                    break;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzejoVar.b(bArr, 0, bArr.length);
                    break;
                }
            case 13:
                zzejoVar.b(((Integer) obj).intValue());
                break;
            case 14:
                zzejoVar.d(((Integer) obj).intValue());
                break;
            case 15:
                zzejoVar.c(((Long) obj).longValue());
                break;
            case 16:
                zzejoVar.c(((Integer) obj).intValue());
                break;
            case 17:
                zzejoVar.b(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof zzekj) {
                    zzejoVar.a(((zzekj) obj).a());
                    break;
                } else {
                    zzejoVar.a(((Integer) obj).intValue());
                    break;
                }
        }
    }

    public final int g() {
        int i = 0;
        for (int i2 = 0; i2 < this.a.c(); i2++) {
            i += c(this.a.b(i2));
        }
        Iterator<Map.Entry<T, Object>> it = this.a.d().iterator();
        while (it.hasNext()) {
            i += c(it.next());
        }
        return i;
    }

    private static int c(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.c() == zzenz.MESSAGE && !key.d() && !key.e()) {
            if (value instanceof zzekt) {
                return zzejo.b(entry.getKey().a(), (zzekt) value);
            }
            return zzejo.b(entry.getKey().a(), (zzels) value);
        }
        return a((zzejz<?>) key, value);
    }

    static int a(zzenw zzenwVar, int i, Object obj) {
        int e = zzejo.e(i);
        if (zzenwVar == zzenw.j) {
            zzekk.a((zzels) obj);
            e <<= 1;
        }
        return e + b(zzenwVar, obj);
    }

    private static int b(zzenw zzenwVar, Object obj) {
        switch (atn.b[zzenwVar.ordinal()]) {
            case 1:
                return zzejo.b(((Double) obj).doubleValue());
            case 2:
                return zzejo.b(((Float) obj).floatValue());
            case 3:
                return zzejo.d(((Long) obj).longValue());
            case 4:
                return zzejo.e(((Long) obj).longValue());
            case 5:
                return zzejo.f(((Integer) obj).intValue());
            case 6:
                return zzejo.g(((Long) obj).longValue());
            case 7:
                return zzejo.i(((Integer) obj).intValue());
            case 8:
                return zzejo.b(((Boolean) obj).booleanValue());
            case 9:
                return zzejo.c((zzels) obj);
            case 10:
                if (obj instanceof zzekt) {
                    return zzejo.a((zzekt) obj);
                }
                return zzejo.b((zzels) obj);
            case 11:
                if (obj instanceof zzeiu) {
                    return zzejo.b((zzeiu) obj);
                }
                return zzejo.b((String) obj);
            case 12:
                if (obj instanceof zzeiu) {
                    return zzejo.b((zzeiu) obj);
                }
                return zzejo.b((byte[]) obj);
            case 13:
                return zzejo.g(((Integer) obj).intValue());
            case 14:
                return zzejo.j(((Integer) obj).intValue());
            case 15:
                return zzejo.h(((Long) obj).longValue());
            case 16:
                return zzejo.h(((Integer) obj).intValue());
            case 17:
                return zzejo.f(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzekj) {
                    return zzejo.k(((zzekj) obj).a());
                }
                return zzejo.k(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int a(zzejz<?> zzejzVar, Object obj) {
        zzenw b = zzejzVar.b();
        int a = zzejzVar.a();
        if (zzejzVar.d()) {
            int i = 0;
            if (zzejzVar.e()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i += b(b, it.next());
                }
                return zzejo.e(a) + i + zzejo.l(i);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                i += a(b, a, it2.next());
            }
            return i;
        }
        return a(b, a, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        atl atlVar = new atl();
        for (int i = 0; i < this.a.c(); i++) {
            Map.Entry<T, Object> b = this.a.b(i);
            atlVar.b((atl) b.getKey(), b.getValue());
        }
        for (Map.Entry<T, Object> entry : this.a.d()) {
            atlVar.b((atl) entry.getKey(), entry.getValue());
        }
        atlVar.c = this.c;
        return atlVar;
    }
}
