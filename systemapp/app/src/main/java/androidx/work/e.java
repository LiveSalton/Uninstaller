package androidx.work;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class e {
    Map<String, Object> b;
    private static final String c = h.a("Data");
    public static final e a = new a().a();

    e() {
    }

    public e(e eVar) {
        this.b = new HashMap(eVar.b);
    }

    e(Map<String, ?> map) {
        this.b = new HashMap(map);
    }

    public String a(String str) {
        Object obj = this.b.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public Map<String, Object> a() {
        return Collections.unmodifiableMap(this.b);
    }

    public int b() {
        return this.b.size();
    }

    public static byte[] a(e eVar) throws IllegalStateException {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeInt(eVar.b());
                    for (Map.Entry<String, Object> entry : eVar.b.entrySet()) {
                        objectOutputStream.writeUTF(entry.getKey());
                        objectOutputStream.writeObject(entry.getValue());
                    }
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e) {
                            Log.e(c, "Error in Data#toByteArray: ", e);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        Log.e(c, "Error in Data#toByteArray: ", e2);
                    }
                    if (byteArrayOutputStream.size() > 10240) {
                        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (IOException e3) {
                    e = e3;
                    objectOutputStream2 = objectOutputStream;
                    Log.e(c, "Error in Data#toByteArray: ", e);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e4) {
                            Log.e(c, "Error in Data#toByteArray: ", e4);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                        Log.e(c, "Error in Data#toByteArray: ", e5);
                    }
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e6) {
                            Log.e(c, "Error in Data#toByteArray: ", e6);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (IOException e7) {
                        Log.e(c, "Error in Data#toByteArray: ", e7);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream = objectOutputStream2;
            }
        } catch (IOException e8) {
            e = e8;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0067 -> B:18:0x006e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.work.e a(byte[] r6) throws java.lang.IllegalStateException {
        /*
            r0 = 10240(0x2800, float:1.4349E-41)
            int r1 = r6.length
            if (r1 <= r0) goto Ld
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r6.<init>(r0)
            throw r6
        Ld:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r6)
            r6 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L45 java.lang.Throwable -> L49
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L45 java.lang.Throwable -> L49
            int r6 = r2.readInt()     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L74
        L21:
            if (r6 <= 0) goto L31
            java.lang.String r3 = r2.readUTF()     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L74
            java.lang.Object r4 = r2.readObject()     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L74
            r0.put(r3, r4)     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L74
            int r6 = r6 + (-1)
            goto L21
        L31:
            if (r2 == 0) goto L3f
            r2.close()     // Catch: java.io.IOException -> L37
            goto L3f
        L37:
            r6 = move-exception
            java.lang.String r2 = androidx.work.e.c
            java.lang.String r3 = "Error in Data#fromByteArray: "
            android.util.Log.e(r2, r3, r6)
        L3f:
            r1.close()     // Catch: java.io.IOException -> L66
            goto L6e
        L43:
            r6 = move-exception
            goto L4d
        L45:
            r0 = move-exception
            r2 = r6
            r6 = r0
            goto L75
        L49:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
        L4d:
            java.lang.String r3 = androidx.work.e.c     // Catch: java.lang.Throwable -> L74
            java.lang.String r4 = "Error in Data#fromByteArray: "
            android.util.Log.e(r3, r4, r6)     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L62
            r2.close()     // Catch: java.io.IOException -> L5a
            goto L62
        L5a:
            r6 = move-exception
            java.lang.String r2 = androidx.work.e.c
            java.lang.String r3 = "Error in Data#fromByteArray: "
            android.util.Log.e(r2, r3, r6)
        L62:
            r1.close()     // Catch: java.io.IOException -> L66
            goto L6e
        L66:
            r6 = move-exception
            java.lang.String r1 = androidx.work.e.c
            java.lang.String r2 = "Error in Data#fromByteArray: "
            android.util.Log.e(r1, r2, r6)
        L6e:
            androidx.work.e r6 = new androidx.work.e
            r6.<init>(r0)
            return r6
        L74:
            r6 = move-exception
        L75:
            if (r2 == 0) goto L83
            r2.close()     // Catch: java.io.IOException -> L7b
            goto L83
        L7b:
            r0 = move-exception
            java.lang.String r2 = androidx.work.e.c
            java.lang.String r3 = "Error in Data#fromByteArray: "
            android.util.Log.e(r2, r3, r0)
        L83:
            r1.close()     // Catch: java.io.IOException -> L87
            goto L8f
        L87:
            r0 = move-exception
            java.lang.String r1 = androidx.work.e.c
            java.lang.String r2 = "Error in Data#fromByteArray: "
            android.util.Log.e(r1, r2, r0)
        L8f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.e.a(byte[]):androidx.work.e");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.b.equals(((e) obj).b);
    }

    public int hashCode() {
        return 31 * this.b.hashCode();
    }

    static Boolean[] a(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    static Byte[] b(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    static Integer[] a(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    static Long[] a(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    static Float[] a(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    static Double[] a(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    /* compiled from: source */
    public static final class a {
        private Map<String, Object> a = new HashMap();

        public a a(String str, String str2) {
            this.a.put(str, str2);
            return this;
        }

        public a a(e eVar) {
            a(eVar.b);
            return this;
        }

        public a a(Map<String, Object> map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public a a(String str, Object obj) {
            if (obj == null) {
                this.a.put(str, null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    this.a.put(str, obj);
                } else if (cls == boolean[].class) {
                    this.a.put(str, e.a((boolean[]) obj));
                } else if (cls == byte[].class) {
                    this.a.put(str, e.b((byte[]) obj));
                } else if (cls == int[].class) {
                    this.a.put(str, e.a((int[]) obj));
                } else if (cls == long[].class) {
                    this.a.put(str, e.a((long[]) obj));
                } else if (cls == float[].class) {
                    this.a.put(str, e.a((float[]) obj));
                } else if (cls == double[].class) {
                    this.a.put(str, e.a((double[]) obj));
                } else {
                    throw new IllegalArgumentException(String.format("Key %s has invalid type %s", str, cls));
                }
            }
            return this;
        }

        public e a() {
            e eVar = new e((Map<String, ?>) this.a);
            e.a(eVar);
            return eVar;
        }
    }
}
