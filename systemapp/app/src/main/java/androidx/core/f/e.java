package androidx.core.f;

import java.util.Locale;

/* compiled from: source */
/* loaded from: classes.dex */
public final class e {
    public static final androidx.core.f.d a = new C0024e(null, false);
    public static final androidx.core.f.d b = new C0024e(null, true);
    public static final androidx.core.f.d c = new C0024e(b.a, false);
    public static final androidx.core.f.d d = new C0024e(b.a, true);
    public static final androidx.core.f.d e = new C0024e(a.a, false);
    public static final androidx.core.f.d f = f.a;

    /* compiled from: source */
    private interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    static int a(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    static int b(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                switch (i) {
                    case 14:
                    case 15:
                        return 1;
                    case 16:
                    case 17:
                        return 0;
                    default:
                        return 2;
                }
        }
    }

    /* compiled from: source */
    private static abstract class d implements androidx.core.f.d {
        private final c a;

        protected abstract boolean a();

        d(c cVar) {
            this.a = cVar;
        }

        @Override // androidx.core.f.d
        public boolean a(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            if (this.a == null) {
                return a();
            }
            return b(charSequence, i, i2);
        }

        private boolean b(CharSequence charSequence, int i, int i2) {
            switch (this.a.a(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return a();
            }
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.core.f.e$e */
    private static class C0024e extends d {
        private final boolean a;

        C0024e(c cVar, boolean z) {
            super(cVar);
            this.a = z;
        }

        @Override // androidx.core.f.e.d
        protected boolean a() {
            return this.a;
        }
    }

    /* compiled from: source */
    private static class b implements c {
        static final b a = new b();

        @Override // androidx.core.f.e.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = e.b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }

        private b() {
        }
    }

    /* compiled from: source */
    private static class a implements c {
        static final a a = new a(true);
        private final boolean b;

        @Override // androidx.core.f.e.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                switch (e.a(Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (this.b) {
                            return 0;
                        }
                        z = true;
                        i++;
                        z = z;
                    case 1:
                        if (!this.b) {
                            return 1;
                        }
                        z = true;
                        i++;
                        z = z;
                    default:
                        i++;
                        z = z;
                }
            }
            if (z) {
                return this.b ? 1 : 0;
            }
            return 2;
        }

        private a(boolean z) {
            this.b = z;
        }
    }

    /* compiled from: source */
    private static class f extends d {
        static final f a = new f();

        f() {
            super(null);
        }

        @Override // androidx.core.f.e.d
        protected boolean a() {
            return androidx.core.f.f.a(Locale.getDefault()) == 1;
        }
    }
}
