package com.google.android.gms.internal.measurement;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzim extends Enum<zzim> {
    public static final zzim i;
    public static final zzim k;
    public static final zzim l;
    private static final /* synthetic */ zzim[] u;
    private final zzip s;
    private final int t;
    public static final zzim a = new zzim("DOUBLE", 0, zzip.DOUBLE, 1);
    public static final zzim b = new zzim("FLOAT", 1, zzip.FLOAT, 5);
    public static final zzim c = new zzim("INT64", 2, zzip.LONG, 0);
    public static final zzim d = new zzim("UINT64", 3, zzip.LONG, 0);
    public static final zzim e = new zzim("INT32", 4, zzip.INT, 0);
    public static final zzim f = new zzim("FIXED64", 5, zzip.LONG, 1);
    public static final zzim g = new zzim("FIXED32", 6, zzip.INT, 5);
    public static final zzim h = new zzim("BOOL", 7, zzip.BOOLEAN, 0);
    public static final zzim j = new zzim("GROUP", 9, zzip.MESSAGE, 3) { // from class: com.google.android.gms.internal.measurement.cy
        {
            int i6 = 9;
            int i7 = 3;
            cu cuVar = null;
        }
    };
    public static final zzim m = new zzim("UINT32", 12, zzip.INT, 0);
    public static final zzim n = new zzim("ENUM", 13, zzip.ENUM, 0);
    public static final zzim o = new zzim("SFIXED32", 14, zzip.INT, 5);
    public static final zzim p = new zzim("SFIXED64", 15, zzip.LONG, 1);
    public static final zzim q = new zzim("SINT32", 16, zzip.INT, 0);
    public static final zzim r = new zzim("SINT64", 17, zzip.LONG, 0);

    public static zzim[] values() {
        return (zzim[]) u.clone();
    }

    private zzim(String str, int i2, zzip zzipVar, int i3) {
        super(str, i2);
        this.s = zzipVar;
        this.t = i3;
    }

    public final zzip a() {
        return this.s;
    }

    /* synthetic */ zzim(String str, int i2, zzip zzipVar, int i3, cu cuVar) {
        this(str, i2, zzipVar, i3);
    }

    static {
        int i2 = 2;
        i = new zzim("STRING", 8, zzip.STRING, i2) { // from class: com.google.android.gms.internal.measurement.cw
            {
                int i5 = 8;
                int i6 = 2;
                cu cuVar = null;
            }
        };
        k = new zzim("MESSAGE", 10, zzip.MESSAGE, i2) { // from class: com.google.android.gms.internal.measurement.cx
            {
                int i7 = 10;
                int i8 = 2;
                cu cuVar = null;
            }
        };
        l = new zzim("BYTES", 11, zzip.BYTE_STRING, i2) { // from class: com.google.android.gms.internal.measurement.cz
            {
                int i8 = 11;
                int i9 = 2;
                cu cuVar = null;
            }
        };
        u = new zzim[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r};
    }
}
