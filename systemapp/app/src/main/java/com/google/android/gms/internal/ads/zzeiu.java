package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzeiu implements Serializable, Iterable<Byte> {
    public static final zzeiu a = new asx(zzekk.b);
    private static final asu b;
    private static final Comparator<zzeiu> d;
    private int c = 0;

    zzeiu() {
    }

    public static int b(byte b2) {
        return b2 & 255;
    }

    public abstract byte a(int i);

    protected abstract int a(int i, int i2, int i3);

    public abstract zzeiu a(int i, int i2);

    protected abstract String a(Charset charset);

    abstract void a(zzeiv zzeivVar) throws IOException;

    abstract byte b(int i);

    public abstract int b();

    protected abstract int b(int i, int i2, int i3);

    protected abstract void b(byte[] bArr, int i, int i2, int i3);

    public abstract boolean equals(Object obj);

    public abstract boolean f();

    public abstract zzejj g();

    protected abstract int i();

    protected abstract boolean j();

    @Override // java.lang.Iterable
    /* renamed from: a */
    public zzejd iterator() {
        return new asr(this);
    }

    public final boolean c() {
        return b() == 0;
    }

    public static zzeiu a(byte[] bArr, int i, int i2) {
        c(i, i + i2, bArr.length);
        return new asx(b.a(bArr, i, i2));
    }

    public static zzeiu a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    static zzeiu b(byte[] bArr) {
        return new asx(bArr);
    }

    public static zzeiu a(String str) {
        return new asx(str.getBytes(zzekk.a));
    }

    public static zzeiu a(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        int i = 256;
        while (true) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            zzeiu a2 = i2 == 0 ? null : a(bArr, 0, i2);
            if (a2 != null) {
                arrayList.add(a2);
                i = Math.min(i << 1, 8192);
            } else {
                return a(arrayList);
            }
        }
    }

    public static zzeiu a(Iterable<zzeiu> iterable) {
        int size;
        if (!(iterable instanceof Collection)) {
            size = 0;
            Iterator<zzeiu> it = iterable.iterator();
            while (it.hasNext()) {
                it.next();
                size++;
            }
        } else {
            size = ((Collection) iterable).size();
        }
        if (size == 0) {
            return a;
        }
        return a(iterable.iterator(), size);
    }

    private static zzeiu a(Iterator<zzeiu> it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i)));
        }
        if (i == 1) {
            return it.next();
        }
        int i2 = i >>> 1;
        zzeiu a2 = a(it, i2);
        zzeiu a3 = a(it, i - i2);
        if (Integer.MAX_VALUE - a2.b() < a3.b()) {
            int b2 = a2.b();
            int b3 = a3.b();
            StringBuilder sb = new StringBuilder(53);
            sb.append("ByteString would be too long: ");
            sb.append(b2);
            sb.append("+");
            sb.append(b3);
            throw new IllegalArgumentException(sb.toString());
        }
        return ava.a(a2, a3);
    }

    @Deprecated
    public final void a(byte[] bArr, int i, int i2, int i3) {
        c(i, i + i3, b());
        c(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            b(bArr, i, i2, i3);
        }
    }

    public final byte[] d() {
        int b2 = b();
        if (b2 == 0) {
            return zzekk.b;
        }
        byte[] bArr = new byte[b2];
        b(bArr, 0, 0, b2);
        return bArr;
    }

    public final String e() {
        return b() == 0 ? "" : a(zzekk.a);
    }

    public final int hashCode() {
        int i = this.c;
        if (i == 0) {
            int b2 = b();
            i = b(b2, 0, b2);
            if (i == 0) {
                i = 1;
            }
            this.c = i;
        }
        return i;
    }

    public static zzejh h() {
        return new zzejh(128);
    }

    static asw c(int i) {
        return new asw(i, null);
    }

    protected final int k() {
        return this.c;
    }

    static void b(int i, int i2) {
        if (((i2 - (i + 1)) | i) < 0) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder(22);
                sb.append("Index < 0: ");
                sb.append(i);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Index > length: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
    }

    static int c(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("End index: ");
        sb3.append(i2);
        sb3.append(" >= ");
        sb3.append(i3);
        throw new IndexOutOfBoundsException(sb3.toString());
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(b());
        objArr[2] = b() <= 50 ? avs.a(this) : String.valueOf(avs.a(a(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    static {
        b = asn.a() ? new asz(null) : new ass(null);
        d = new asq();
    }
}
