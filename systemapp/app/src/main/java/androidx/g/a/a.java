package androidx.g.a;

/* compiled from: source */
/* loaded from: classes.dex */
public final class a implements e {
    private final String a;
    private final Object[] b;

    public a(String str, Object[] objArr) {
        this.a = str;
        this.b = objArr;
    }

    public a(String str) {
        this(str, null);
    }

    @Override // androidx.g.a.e
    public String b() {
        return this.a;
    }

    @Override // androidx.g.a.e
    public void a(d dVar) {
        a(dVar, this.b);
    }

    public static void a(d dVar, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            a(dVar, i, obj);
        }
    }

    private static void a(d dVar, int i, Object obj) {
        if (obj == null) {
            dVar.a(i);
            return;
        }
        if (obj instanceof byte[]) {
            dVar.a(i, (byte[]) obj);
            return;
        }
        if (obj instanceof Float) {
            dVar.a(i, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            dVar.a(i, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Long) {
            dVar.a(i, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Integer) {
            dVar.a(i, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            dVar.a(i, ((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Byte) {
            dVar.a(i, ((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof String) {
            dVar.a(i, (String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            dVar.a(i, ((Boolean) obj).booleanValue() ? 1L : 0L);
            return;
        }
        throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i + " Supported types: null, byte[], float, double, long, int, short, byte, string");
    }
}
