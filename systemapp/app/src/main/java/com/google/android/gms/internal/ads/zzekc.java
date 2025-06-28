package com.google.android.gms.internal.ads;

import java.lang.reflect.Type;

/* compiled from: source */
/* loaded from: classes.dex */
public enum zzekc {
    DOUBLE(0, atq.SCALAR, zzeku.DOUBLE),
    FLOAT(1, atq.SCALAR, zzeku.FLOAT),
    INT64(2, atq.SCALAR, zzeku.LONG),
    UINT64(3, atq.SCALAR, zzeku.LONG),
    INT32(4, atq.SCALAR, zzeku.INT),
    FIXED64(5, atq.SCALAR, zzeku.LONG),
    FIXED32(6, atq.SCALAR, zzeku.INT),
    BOOL(7, atq.SCALAR, zzeku.BOOLEAN),
    STRING(8, atq.SCALAR, zzeku.STRING),
    MESSAGE(9, atq.SCALAR, zzeku.MESSAGE),
    BYTES(10, atq.SCALAR, zzeku.BYTE_STRING),
    UINT32(11, atq.SCALAR, zzeku.INT),
    ENUM(12, atq.SCALAR, zzeku.ENUM),
    SFIXED32(13, atq.SCALAR, zzeku.INT),
    SFIXED64(14, atq.SCALAR, zzeku.LONG),
    SINT32(15, atq.SCALAR, zzeku.INT),
    SINT64(16, atq.SCALAR, zzeku.LONG),
    GROUP(17, atq.SCALAR, zzeku.MESSAGE),
    DOUBLE_LIST(18, atq.VECTOR, zzeku.DOUBLE),
    FLOAT_LIST(19, atq.VECTOR, zzeku.FLOAT),
    INT64_LIST(20, atq.VECTOR, zzeku.LONG),
    UINT64_LIST(21, atq.VECTOR, zzeku.LONG),
    INT32_LIST(22, atq.VECTOR, zzeku.INT),
    FIXED64_LIST(23, atq.VECTOR, zzeku.LONG),
    FIXED32_LIST(24, atq.VECTOR, zzeku.INT),
    BOOL_LIST(25, atq.VECTOR, zzeku.BOOLEAN),
    STRING_LIST(26, atq.VECTOR, zzeku.STRING),
    MESSAGE_LIST(27, atq.VECTOR, zzeku.MESSAGE),
    BYTES_LIST(28, atq.VECTOR, zzeku.BYTE_STRING),
    UINT32_LIST(29, atq.VECTOR, zzeku.INT),
    ENUM_LIST(30, atq.VECTOR, zzeku.ENUM),
    SFIXED32_LIST(31, atq.VECTOR, zzeku.INT),
    SFIXED64_LIST(32, atq.VECTOR, zzeku.LONG),
    SINT32_LIST(33, atq.VECTOR, zzeku.INT),
    SINT64_LIST(34, atq.VECTOR, zzeku.LONG),
    DOUBLE_LIST_PACKED(35, atq.PACKED_VECTOR, zzeku.DOUBLE),
    FLOAT_LIST_PACKED(36, atq.PACKED_VECTOR, zzeku.FLOAT),
    INT64_LIST_PACKED(37, atq.PACKED_VECTOR, zzeku.LONG),
    UINT64_LIST_PACKED(38, atq.PACKED_VECTOR, zzeku.LONG),
    INT32_LIST_PACKED(39, atq.PACKED_VECTOR, zzeku.INT),
    FIXED64_LIST_PACKED(40, atq.PACKED_VECTOR, zzeku.LONG),
    FIXED32_LIST_PACKED(41, atq.PACKED_VECTOR, zzeku.INT),
    BOOL_LIST_PACKED(42, atq.PACKED_VECTOR, zzeku.BOOLEAN),
    UINT32_LIST_PACKED(43, atq.PACKED_VECTOR, zzeku.INT),
    ENUM_LIST_PACKED(44, atq.PACKED_VECTOR, zzeku.ENUM),
    SFIXED32_LIST_PACKED(45, atq.PACKED_VECTOR, zzeku.INT),
    SFIXED64_LIST_PACKED(46, atq.PACKED_VECTOR, zzeku.LONG),
    SINT32_LIST_PACKED(47, atq.PACKED_VECTOR, zzeku.INT),
    SINT64_LIST_PACKED(48, atq.PACKED_VECTOR, zzeku.LONG),
    GROUP_LIST(49, atq.VECTOR, zzeku.MESSAGE),
    MAP(50, atq.MAP, zzeku.VOID);

    private static final zzekc[] ae;
    private static final Type[] af = new Type[0];
    private final zzeku Z;
    private final int aa;
    private final atq ab;
    private final Class<?> ac;
    private final boolean ad;

    zzekc(int i, atq atqVar, zzeku zzekuVar) {
        this.aa = i;
        this.ab = atqVar;
        this.Z = zzekuVar;
        switch (atqVar) {
            case MAP:
                this.ac = zzekuVar.a();
                break;
            case VECTOR:
                this.ac = zzekuVar.a();
                break;
            default:
                this.ac = null;
                break;
        }
        boolean z = false;
        if (atqVar == atq.SCALAR) {
            switch (zzekuVar) {
                case BYTE_STRING:
                case MESSAGE:
                case STRING:
                    break;
                default:
                    z = true;
                    break;
            }
        }
        this.ad = z;
    }

    public final int a() {
        return this.aa;
    }

    static {
        zzekc[] values = values();
        ae = new zzekc[values.length];
        for (zzekc zzekcVar : values) {
            ae[zzekcVar.aa] = zzekcVar;
        }
    }
}
