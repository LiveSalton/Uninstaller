package com.google.android.gms.internal.ads;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
final class ami<K, V> extends zzdwq<K, V> {
    private static final zzdwq<Object, Object> a = new ami(null, new Object[0], 0);
    private final transient Object b;
    private final transient Object[] c;
    private final transient int d;

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
    
        r2[r7] = (byte) r3;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0096, code lost:
    
        r2[r7] = (short) r3;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00cb, code lost:
    
        r2[r8] = r3;
        r1 = r1 + 1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [int[]] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static <K, V> com.google.android.gms.internal.ads.ami<K, V> a(int r11, java.lang.Object[] r12) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ami.a(int, java.lang.Object[]):com.google.android.gms.internal.ads.ami");
    }

    private static IllegalArgumentException a(Object obj, Object obj2, Object[] objArr, int i) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i]);
        String valueOf4 = String.valueOf(objArr[i ^ 1]);
        StringBuilder sb = new StringBuilder(39 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("Multiple entries with same key: ");
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        sb.append(" and ");
        sb.append(valueOf3);
        sb.append("=");
        sb.append(valueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    private ami(Object obj, Object[] objArr, int i) {
        this.b = obj;
        this.c = objArr;
        this.d = i;
    }

    @Override // java.util.Map
    public final int size() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzdwq, java.util.Map
    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.b;
        Object[] objArr = this.c;
        int i = this.d;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[0].equals(obj)) {
                return (V) objArr[1];
            }
            return null;
        }
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof byte[]) {
            byte[] bArr = (byte[]) obj2;
            int length = bArr.length - 1;
            int a2 = amb.a(obj.hashCode());
            while (true) {
                int i2 = a2 & length;
                int i3 = bArr[i2] & 255;
                if (i3 == 255) {
                    return null;
                }
                if (objArr[i3].equals(obj)) {
                    return (V) objArr[i3 ^ 1];
                }
                a2 = i2 + 1;
            }
        } else if (obj2 instanceof short[]) {
            short[] sArr = (short[]) obj2;
            int length2 = sArr.length - 1;
            int a3 = amb.a(obj.hashCode());
            while (true) {
                int i4 = a3 & length2;
                int i5 = sArr[i4] & 65535;
                if (i5 == 65535) {
                    return null;
                }
                if (objArr[i5].equals(obj)) {
                    return (V) objArr[i5 ^ 1];
                }
                a3 = i4 + 1;
            }
        } else {
            int[] iArr = (int[]) obj2;
            int length3 = iArr.length - 1;
            int a4 = amb.a(obj.hashCode());
            while (true) {
                int i6 = a4 & length3;
                int i7 = iArr[i6];
                if (i7 == -1) {
                    return null;
                }
                if (objArr[i7].equals(obj)) {
                    return (V) objArr[i7 ^ 1];
                }
                a4 = i6 + 1;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdwq
    final zzdwt<Map.Entry<K, V>> a() {
        return new amh(this, this.c, 0, this.d);
    }

    @Override // com.google.android.gms.internal.ads.zzdwq
    final zzdwt<K> b() {
        return new amj(this, new amm(this.c, 0, this.d));
    }

    @Override // com.google.android.gms.internal.ads.zzdwq
    final zzdwl<V> c() {
        return new amm(this.c, 1, this.d);
    }
}
