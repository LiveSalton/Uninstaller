package androidx.work;

import android.util.Log;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class h {
    private static h a;
    private static final int b = 23 - "WM-".length();

    public abstract void a(String str, String str2, Throwable... thArr);

    public abstract void b(String str, String str2, Throwable... thArr);

    public abstract void c(String str, String str2, Throwable... thArr);

    public abstract void d(String str, String str2, Throwable... thArr);

    public abstract void e(String str, String str2, Throwable... thArr);

    public static synchronized void a(h hVar) {
        synchronized (h.class) {
            a = hVar;
        }
    }

    public static String a(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        if (length >= b) {
            sb.append(str.substring(0, b));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            if (a == null) {
                a = new a(3);
            }
            hVar = a;
        }
        return hVar;
    }

    public h(int i) {
    }

    /* compiled from: source */
    public static class a extends h {
        private int a;

        public a(int i) {
            super(i);
            this.a = i;
        }

        @Override // androidx.work.h
        public void a(String str, String str2, Throwable... thArr) {
            if (this.a <= 2) {
                if (thArr != null && thArr.length >= 1) {
                    Log.v(str, str2, thArr[0]);
                } else {
                    Log.v(str, str2);
                }
            }
        }

        @Override // androidx.work.h
        public void b(String str, String str2, Throwable... thArr) {
            if (this.a <= 3) {
                if (thArr != null && thArr.length >= 1) {
                    Log.d(str, str2, thArr[0]);
                } else {
                    Log.d(str, str2);
                }
            }
        }

        @Override // androidx.work.h
        public void c(String str, String str2, Throwable... thArr) {
            if (this.a <= 4) {
                if (thArr != null && thArr.length >= 1) {
                    Log.i(str, str2, thArr[0]);
                } else {
                    Log.i(str, str2);
                }
            }
        }

        @Override // androidx.work.h
        public void d(String str, String str2, Throwable... thArr) {
            if (this.a <= 5) {
                if (thArr != null && thArr.length >= 1) {
                    Log.w(str, str2, thArr[0]);
                } else {
                    Log.w(str, str2);
                }
            }
        }

        @Override // androidx.work.h
        public void e(String str, String str2, Throwable... thArr) {
            if (this.a <= 6) {
                if (thArr != null && thArr.length >= 1) {
                    Log.e(str, str2, thArr[0]);
                } else {
                    Log.e(str, str2);
                }
            }
        }
    }
}
