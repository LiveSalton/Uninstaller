package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public class SafeParcelReader {

    /* compiled from: source */
    public static class ParseException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ParseException(java.lang.String r4, android.os.Parcel r5) {
            /*
                r3 = this;
                int r0 = r5.dataPosition()
                int r5 = r5.dataSize()
                java.lang.String r1 = java.lang.String.valueOf(r4)
                int r1 = r1.length()
                r2 = 41
                int r2 = r2 + r1
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r2)
                r1.append(r4)
                java.lang.String r4 = " Parcel: pos="
                r1.append(r4)
                r1.append(r0)
                java.lang.String r4 = " size="
                r1.append(r4)
                r1.append(r5)
                java.lang.String r4 = r1.toString()
                r3.<init>(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    private SafeParcelReader() {
    }

    public static int a(int i) {
        return i & 65535;
    }

    public static int a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int a(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static void b(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + a(parcel, i));
    }

    private static void a(Parcel parcel, int i, int i2) {
        int a = a(parcel, i);
        if (a != i2) {
            String hexString = Integer.toHexString(a);
            StringBuilder sb = new StringBuilder(46 + String.valueOf(hexString).length());
            sb.append("Expected size ");
            sb.append(i2);
            sb.append(" got ");
            sb.append(a);
            sb.append(" (0x");
            sb.append(hexString);
            sb.append(")");
            throw new ParseException(sb.toString(), parcel);
        }
    }

    public static int b(Parcel parcel) {
        int a = a(parcel);
        int a2 = a(parcel, a);
        int dataPosition = parcel.dataPosition();
        if (a(a) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(a));
            throw new ParseException(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i = a2 + dataPosition;
        if (i >= dataPosition && i <= parcel.dataSize()) {
            return i;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("Size read is invalid start=");
        sb.append(dataPosition);
        sb.append(" end=");
        sb.append(i);
        throw new ParseException(sb.toString(), parcel);
    }

    public static boolean c(Parcel parcel, int i) {
        a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static int d(Parcel parcel, int i) {
        a(parcel, i, 4);
        return parcel.readInt();
    }

    public static long e(Parcel parcel, int i) {
        a(parcel, i, 8);
        return parcel.readLong();
    }

    public static float f(Parcel parcel, int i) {
        a(parcel, i, 4);
        return parcel.readFloat();
    }

    public static String g(Parcel parcel, int i) {
        int a = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + a);
        return readString;
    }

    public static IBinder h(Parcel parcel, int i) {
        int a = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + a);
        return readStrongBinder;
    }

    public static <T extends Parcelable> T a(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int a = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + a);
        return createFromParcel;
    }

    public static Bundle i(Parcel parcel, int i) {
        int a = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + a);
        return readBundle;
    }

    public static byte[] j(Parcel parcel, int i) {
        int a = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + a);
        return createByteArray;
    }

    public static String[] k(Parcel parcel, int i) {
        int a = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + a);
        return createStringArray;
    }

    public static ArrayList<Integer> l(Parcel parcel, int i) {
        int a = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + a);
        return arrayList;
    }

    public static ArrayList<String> m(Parcel parcel, int i) {
        int a = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + a);
        return createStringArrayList;
    }

    public static <T> T[] b(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int a = a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + a);
        return tArr;
    }

    public static void n(Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Overread allowed size end=");
            sb.append(i);
            throw new ParseException(sb.toString(), parcel);
        }
    }
}
