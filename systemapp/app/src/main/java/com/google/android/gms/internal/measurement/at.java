package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class at<T extends zzey<T>> {
    private static final at d = new at(true);
    final ca<T, Object> a;
    private boolean b;
    private boolean c;

    private at() {
        this.a = ca.a(16);
    }

    private at(boolean z) {
        this(ca.a(0));
        b();
    }

    private at(ca<T, Object> caVar) {
        this.a = caVar;
        b();
    }

    public static <T extends zzey<T>> at<T> a() {
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
        if (obj instanceof at) {
            return this.a.equals(((at) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> d() {
        if (this.c) {
            return new az(this.a.entrySet().iterator());
        }
        return this.a.entrySet().iterator();
    }

    private final Object a(T t) {
        Object obj = this.a.get(t);
        if (!(obj instanceof zzfp)) {
            return obj;
        }
        return zzfp.a();
    }

    private final void a(T t, Object obj) {
        if (t.c()) {
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
                a(t.a(), obj2);
            }
            obj = arrayList;
        } else {
            a(t.a(), obj);
        }
        if (obj instanceof zzfp) {
            this.c = true;
        }
        this.a.a((ca<T, Object>) t, (T) obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzfp) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzfi) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        if ((r3 instanceof byte[]) == false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.google.android.gms.internal.measurement.zzim r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.zzff.a(r3)
            int[] r0 = com.google.android.gms.internal.measurement.as.a
            com.google.android.gms.internal.measurement.zzip r2 = r2.a()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzgo
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzfp
            if (r2 == 0) goto L14
            goto L42
        L1f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzfi
            if (r2 == 0) goto L14
            goto L42
        L28:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzdu
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.at.a(com.google.android.gms.internal.measurement.zzim, java.lang.Object):void");
    }

    public final boolean e() {
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

    private static <T extends zzey<T>> boolean a(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.b() == zzip.MESSAGE) {
            if (key.c()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzgo) it.next()).o_()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzgo) {
                    if (!((zzgo) value).o_()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzfp) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void a(at<T> atVar) {
        for (int i = 0; i < atVar.a.c(); i++) {
            b(atVar.a.b(i));
        }
        Iterator<Map.Entry<T, Object>> it = atVar.a.d().iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    private static Object a(Object obj) {
        if (obj instanceof zzgt) {
            return ((zzgt) obj).clone();
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
        zzgo f;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzfp) {
            value = zzfp.a();
        }
        if (key.c()) {
            Object a = a((at<T>) key);
            if (a == null) {
                a = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) a).add(a(it.next()));
            }
            this.a.a((ca<T, Object>) key, (T) a);
            return;
        }
        if (key.b() == zzip.MESSAGE) {
            Object a2 = a((at<T>) key);
            if (a2 == null) {
                this.a.a((ca<T, Object>) key, (T) a(value));
                return;
            }
            if (a2 instanceof zzgt) {
                f = key.a((zzgt) a2, (zzgt) value);
            } else {
                f = key.a(((zzgo) a2).d(), (zzgo) value).f();
            }
            this.a.a((ca<T, Object>) key, (T) f);
            return;
        }
        this.a.a((ca<T, Object>) key, (T) a(value));
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        at atVar = new at();
        for (int i = 0; i < this.a.c(); i++) {
            Map.Entry<T, Object> b = this.a.b(i);
            atVar.a((at) b.getKey(), b.getValue());
        }
        for (Map.Entry<T, Object> entry : this.a.d()) {
            atVar.a((at) entry.getKey(), entry.getValue());
        }
        atVar.c = this.c;
        return atVar;
    }
}
