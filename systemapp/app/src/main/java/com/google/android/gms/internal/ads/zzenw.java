package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzenw extends Enum<zzenw> {
    public static final zzenw i;
    public static final zzenw k;
    public static final zzenw l;
    private static final /* synthetic */ zzenw[] u;
    private final zzenz s;
    private final int t;
    public static final zzenw a = new zzenw("DOUBLE", 0, zzenz.DOUBLE, 1);
    public static final zzenw b = new zzenw("FLOAT", 1, zzenz.FLOAT, 5);
    public static final zzenw c = new zzenw("INT64", 2, zzenz.LONG, 0);
    public static final zzenw d = new zzenw("UINT64", 3, zzenz.LONG, 0);
    public static final zzenw e = new zzenw("INT32", 4, zzenz.INT, 0);
    public static final zzenw f = new zzenw("FIXED64", 5, zzenz.LONG, 1);
    public static final zzenw g = new zzenw("FIXED32", 6, zzenz.INT, 5);
    public static final zzenw h = new zzenw("BOOL", 7, zzenz.BOOLEAN, 0);
    public static final zzenw j = new zzenw("GROUP", 9, zzenz.MESSAGE, 3) { // from class: com.google.android.gms.internal.ads.awl
        {
            int i6 = 9;
            int i7 = 3;
            awh awhVar = null;
        }
    };
    public static final zzenw m = new zzenw("UINT32", 12, zzenz.INT, 0);
    public static final zzenw n = new zzenw("ENUM", 13, zzenz.ENUM, 0);
    public static final zzenw o = new zzenw("SFIXED32", 14, zzenz.INT, 5);
    public static final zzenw p = new zzenw("SFIXED64", 15, zzenz.LONG, 1);
    public static final zzenw q = new zzenw("SINT32", 16, zzenz.INT, 0);
    public static final zzenw r = new zzenw("SINT64", 17, zzenz.LONG, 0);

    public static zzenw[] values() {
        return (zzenw[]) u.clone();
    }

    private zzenw(String str, int i2, zzenz zzenzVar, int i3) {
        super(str, i2);
        this.s = zzenzVar;
        this.t = i3;
    }

    public final zzenz a() {
        return this.s;
    }

    public final int b() {
        return this.t;
    }

    /* synthetic */ zzenw(String str, int i2, zzenz zzenzVar, int i3, awh awhVar) {
        this(str, i2, zzenzVar, i3);
    }

    static {
        int i2 = 2;
        i = new zzenw("STRING", 8, zzenz.STRING, i2) { // from class: com.google.android.gms.internal.ads.awj
            {
                int i5 = 8;
                int i6 = 2;
                awh awhVar = null;
            }
        };
        k = new zzenw("MESSAGE", 10, zzenz.MESSAGE, i2) { // from class: com.google.android.gms.internal.ads.awk
            {
                int i7 = 10;
                int i8 = 2;
                awh awhVar = null;
            }
        };
        l = new zzenw("BYTES", 11, zzenz.BYTE_STRING, i2) { // from class: com.google.android.gms.internal.ads.awn
            {
                int i8 = 11;
                int i9 = 2;
                awh awhVar = null;
            }
        };
        u = new zzenw[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r};
    }
}
