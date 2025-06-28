package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzdu implements Serializable, Iterable<Byte> {
    public static final zzdu a = new ak(zzff.b);
    private static final ai b;
    private static final Comparator<zzdu> d;
    private int c = 0;

    zzdu() {
    }

    public static int b(byte b2) {
        return b2 & 255;
    }

    public abstract byte a(int i);

    public abstract int a();

    protected abstract int a(int i, int i2, int i3);

    public abstract zzdu a(int i, int i2);

    protected abstract String a(Charset charset);

    abstract byte b(int i);

    public abstract boolean c();

    public abstract boolean equals(Object obj);

    public static zzdu a(String str) {
        return new ak(str.getBytes(zzff.a));
    }

    public final String b() {
        return a() == 0 ? "" : a(zzff.a);
    }

    public final int hashCode() {
        int i = this.c;
        if (i == 0) {
            int a2 = a();
            i = a(a2, 0, a2);
            if (i == 0) {
                i = 1;
            }
            this.c = i;
        }
        return i;
    }

    protected final int d() {
        return this.c;
    }

    static int b(int i, int i2, int i3) {
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
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(a()));
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new af(this);
    }

    static {
        b = ad.a() ? new am(null) : new ag(null);
        d = new ae();
    }
}
