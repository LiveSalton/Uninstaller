package com.google.android.gms.internal.measurement;

import java.lang.reflect.Type;

/* compiled from: source */
/* loaded from: classes.dex */
public enum zzex {
    DOUBLE(0, au.SCALAR, zzfq.DOUBLE),
    FLOAT(1, au.SCALAR, zzfq.FLOAT),
    INT64(2, au.SCALAR, zzfq.LONG),
    UINT64(3, au.SCALAR, zzfq.LONG),
    INT32(4, au.SCALAR, zzfq.INT),
    FIXED64(5, au.SCALAR, zzfq.LONG),
    FIXED32(6, au.SCALAR, zzfq.INT),
    BOOL(7, au.SCALAR, zzfq.BOOLEAN),
    STRING(8, au.SCALAR, zzfq.STRING),
    MESSAGE(9, au.SCALAR, zzfq.MESSAGE),
    BYTES(10, au.SCALAR, zzfq.BYTE_STRING),
    UINT32(11, au.SCALAR, zzfq.INT),
    ENUM(12, au.SCALAR, zzfq.ENUM),
    SFIXED32(13, au.SCALAR, zzfq.INT),
    SFIXED64(14, au.SCALAR, zzfq.LONG),
    SINT32(15, au.SCALAR, zzfq.INT),
    SINT64(16, au.SCALAR, zzfq.LONG),
    GROUP(17, au.SCALAR, zzfq.MESSAGE),
    DOUBLE_LIST(18, au.VECTOR, zzfq.DOUBLE),
    FLOAT_LIST(19, au.VECTOR, zzfq.FLOAT),
    INT64_LIST(20, au.VECTOR, zzfq.LONG),
    UINT64_LIST(21, au.VECTOR, zzfq.LONG),
    INT32_LIST(22, au.VECTOR, zzfq.INT),
    FIXED64_LIST(23, au.VECTOR, zzfq.LONG),
    FIXED32_LIST(24, au.VECTOR, zzfq.INT),
    BOOL_LIST(25, au.VECTOR, zzfq.BOOLEAN),
    STRING_LIST(26, au.VECTOR, zzfq.STRING),
    MESSAGE_LIST(27, au.VECTOR, zzfq.MESSAGE),
    BYTES_LIST(28, au.VECTOR, zzfq.BYTE_STRING),
    UINT32_LIST(29, au.VECTOR, zzfq.INT),
    ENUM_LIST(30, au.VECTOR, zzfq.ENUM),
    SFIXED32_LIST(31, au.VECTOR, zzfq.INT),
    SFIXED64_LIST(32, au.VECTOR, zzfq.LONG),
    SINT32_LIST(33, au.VECTOR, zzfq.INT),
    SINT64_LIST(34, au.VECTOR, zzfq.LONG),
    DOUBLE_LIST_PACKED(35, au.PACKED_VECTOR, zzfq.DOUBLE),
    FLOAT_LIST_PACKED(36, au.PACKED_VECTOR, zzfq.FLOAT),
    INT64_LIST_PACKED(37, au.PACKED_VECTOR, zzfq.LONG),
    UINT64_LIST_PACKED(38, au.PACKED_VECTOR, zzfq.LONG),
    INT32_LIST_PACKED(39, au.PACKED_VECTOR, zzfq.INT),
    FIXED64_LIST_PACKED(40, au.PACKED_VECTOR, zzfq.LONG),
    FIXED32_LIST_PACKED(41, au.PACKED_VECTOR, zzfq.INT),
    BOOL_LIST_PACKED(42, au.PACKED_VECTOR, zzfq.BOOLEAN),
    UINT32_LIST_PACKED(43, au.PACKED_VECTOR, zzfq.INT),
    ENUM_LIST_PACKED(44, au.PACKED_VECTOR, zzfq.ENUM),
    SFIXED32_LIST_PACKED(45, au.PACKED_VECTOR, zzfq.INT),
    SFIXED64_LIST_PACKED(46, au.PACKED_VECTOR, zzfq.LONG),
    SINT32_LIST_PACKED(47, au.PACKED_VECTOR, zzfq.INT),
    SINT64_LIST_PACKED(48, au.PACKED_VECTOR, zzfq.LONG),
    GROUP_LIST(49, au.VECTOR, zzfq.MESSAGE),
    MAP(50, au.MAP, zzfq.VOID);

    private static final zzex[] ae;
    private static final Type[] af = new Type[0];
    private final zzfq Z;
    private final int aa;
    private final au ab;
    private final Class<?> ac;
    private final boolean ad;

    zzex(int i, au auVar, zzfq zzfqVar) {
        this.aa = i;
        this.ab = auVar;
        this.Z = zzfqVar;
        switch (auVar) {
            case MAP:
                this.ac = zzfqVar.a();
                break;
            case VECTOR:
                this.ac = zzfqVar.a();
                break;
            default:
                this.ac = null;
                break;
        }
        boolean z = false;
        if (auVar == au.SCALAR) {
            switch (zzfqVar) {
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

    static {
        zzex[] values = values();
        ae = new zzex[values.length];
        for (zzex zzexVar : values) {
            ae[zzexVar.aa] = zzexVar;
        }
    }
}
