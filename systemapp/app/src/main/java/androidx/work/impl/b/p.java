package androidx.work.impl.b;

import androidx.work.d;
import androidx.work.n;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public class p {
    public static int a(n.a aVar) {
        switch (aVar) {
            case ENQUEUED:
                return 0;
            case RUNNING:
                return 1;
            case SUCCEEDED:
                return 2;
            case FAILED:
                return 3;
            case BLOCKED:
                return 4;
            case CANCELLED:
                return 5;
            default:
                throw new IllegalArgumentException("Could not convert " + aVar + " to int");
        }
    }

    public static n.a a(int i) {
        switch (i) {
            case 0:
                return n.a.ENQUEUED;
            case 1:
                return n.a.RUNNING;
            case 2:
                return n.a.SUCCEEDED;
            case 3:
                return n.a.FAILED;
            case 4:
                return n.a.BLOCKED;
            case 5:
                return n.a.CANCELLED;
            default:
                throw new IllegalArgumentException("Could not convert " + i + " to State");
        }
    }

    public static int a(androidx.work.a aVar) {
        switch (aVar) {
            case EXPONENTIAL:
                return 0;
            case LINEAR:
                return 1;
            default:
                throw new IllegalArgumentException("Could not convert " + aVar + " to int");
        }
    }

    public static androidx.work.a b(int i) {
        switch (i) {
            case 0:
                return androidx.work.a.EXPONENTIAL;
            case 1:
                return androidx.work.a.LINEAR;
            default:
                throw new IllegalArgumentException("Could not convert " + i + " to BackoffPolicy");
        }
    }

    public static int a(androidx.work.i iVar) {
        switch (iVar) {
            case NOT_REQUIRED:
                return 0;
            case CONNECTED:
                return 1;
            case UNMETERED:
                return 2;
            case NOT_ROAMING:
                return 3;
            case METERED:
                return 4;
            default:
                throw new IllegalArgumentException("Could not convert " + iVar + " to int");
        }
    }

    public static androidx.work.i c(int i) {
        switch (i) {
            case 0:
                return androidx.work.i.NOT_REQUIRED;
            case 1:
                return androidx.work.i.CONNECTED;
            case 2:
                return androidx.work.i.UNMETERED;
            case 3:
                return androidx.work.i.NOT_ROAMING;
            case 4:
                return androidx.work.i.METERED;
            default:
                throw new IllegalArgumentException("Could not convert " + i + " to NetworkType");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0069 -> B:17:0x006c). Please report as a decompilation issue!!! */
    public static byte[] a(androidx.work.d dVar) {
        ObjectOutputStream objectOutputStream;
        boolean hasNext;
        ObjectOutputStream objectOutputStream2 = null;
        ObjectOutputStream objectOutputStream3 = null;
        objectOutputStream2 = null;
        if (dVar.b() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream.writeInt(dVar.b());
                        Iterator<d.a> it = dVar.a().iterator();
                        while (true) {
                            hasNext = it.hasNext();
                            if (hasNext == 0) {
                                break;
                            }
                            d.a next = it.next();
                            objectOutputStream.writeUTF(next.a().toString());
                            objectOutputStream.writeBoolean(next.b());
                        }
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        byteArrayOutputStream.close();
                        objectOutputStream2 = hasNext;
                    } catch (IOException e2) {
                        e = e2;
                        objectOutputStream3 = objectOutputStream;
                        e.printStackTrace();
                        if (objectOutputStream3 != null) {
                            try {
                                objectOutputStream3.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        byteArrayOutputStream.close();
                        objectOutputStream2 = objectOutputStream3;
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th) {
                        th = th;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                            throw th;
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            throw th;
                        }
                    }
                } catch (IOException e6) {
                    e = e6;
                }
            } catch (IOException e7) {
                e7.printStackTrace();
                objectOutputStream2 = objectOutputStream2;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream = objectOutputStream2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.work.d a(byte[] r6) {
        /*
            androidx.work.d r0 = new androidx.work.d
            r0.<init>()
            if (r6 != 0) goto L8
            return r0
        L8:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r6)
            r6 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3f
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3f
            int r6 = r2.readInt()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L59
        L17:
            if (r6 <= 0) goto L2b
            java.lang.String r3 = r2.readUTF()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L59
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L59
            boolean r4 = r2.readBoolean()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L59
            r0.a(r3, r4)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L59
            int r6 = r6 + (-1)
            goto L17
        L2b:
            if (r2 == 0) goto L35
            r2.close()     // Catch: java.io.IOException -> L31
            goto L35
        L31:
            r6 = move-exception
            r6.printStackTrace()
        L35:
            r1.close()     // Catch: java.io.IOException -> L54
            goto L58
        L39:
            r6 = move-exception
            goto L43
        L3b:
            r0 = move-exception
            r2 = r6
            r6 = r0
            goto L5a
        L3f:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
        L43:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L59
            if (r2 == 0) goto L50
            r2.close()     // Catch: java.io.IOException -> L4c
            goto L50
        L4c:
            r6 = move-exception
            r6.printStackTrace()
        L50:
            r1.close()     // Catch: java.io.IOException -> L54
            goto L58
        L54:
            r6 = move-exception
            r6.printStackTrace()
        L58:
            return r0
        L59:
            r6 = move-exception
        L5a:
            if (r2 == 0) goto L64
            r2.close()     // Catch: java.io.IOException -> L60
            goto L64
        L60:
            r0 = move-exception
            r0.printStackTrace()
        L64:
            r1.close()     // Catch: java.io.IOException -> L68
            goto L6c
        L68:
            r0 = move-exception
            r0.printStackTrace()
        L6c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.b.p.a(byte[]):androidx.work.d");
    }
}
