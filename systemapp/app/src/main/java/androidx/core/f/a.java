package androidx.core.f;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* compiled from: source */
/* loaded from: classes.dex */
public final class a {
    private final boolean f;
    private final int g;
    private final d h;
    static final d a = e.c;
    private static final String d = Character.toString(8206);
    private static final String e = Character.toString(8207);
    static final a b = new a(false, 2, a);
    static final a c = new a(true, 2, a);

    /* compiled from: source */
    /* renamed from: androidx.core.f.a$a */
    public static final class C0022a {
        private boolean a;
        private int b;
        private d c;

        public C0022a() {
            a(a.a(Locale.getDefault()));
        }

        private void a(boolean z) {
            this.a = z;
            this.c = a.a;
            this.b = 2;
        }

        private static a b(boolean z) {
            return z ? a.c : a.b;
        }

        public a a() {
            if (this.b == 2 && this.c == a.a) {
                return b(this.a);
            }
            return new a(this.a, this.b, this.c);
        }
    }

    public static a a() {
        return new C0022a().a();
    }

    a(boolean z, int i, d dVar) {
        this.f = z;
        this.g = i;
        this.h = dVar;
    }

    public boolean b() {
        return (this.g & 2) != 0;
    }

    private String a(CharSequence charSequence, d dVar) {
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        if (this.f || !(a2 || b(charSequence) == 1)) {
            return this.f ? (!a2 || b(charSequence) == -1) ? e : "" : "";
        }
        return d;
    }

    private String b(CharSequence charSequence, d dVar) {
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        if (this.f || !(a2 || c(charSequence) == 1)) {
            return this.f ? (!a2 || c(charSequence) == -1) ? e : "" : "";
        }
        return d;
    }

    public CharSequence a(CharSequence charSequence, d dVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (b() && z) {
            spannableStringBuilder.append((CharSequence) b(charSequence, a2 ? e.b : e.a));
        }
        if (a2 != this.f) {
            spannableStringBuilder.append(a2 ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) a(charSequence, a2 ? e.b : e.a));
        }
        return spannableStringBuilder;
    }

    public CharSequence a(CharSequence charSequence) {
        return a(charSequence, this.h, true);
    }

    static boolean a(Locale locale) {
        return f.a(locale) == 1;
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).b();
    }

    private static int c(CharSequence charSequence) {
        return new b(charSequence, false).a();
    }

    /* compiled from: source */
    private static class b {
        private static final byte[] a = new byte[1792];
        private final CharSequence b;
        private final boolean c;
        private final int d;
        private int e;
        private char f;

        static {
            for (int i = 0; i < 1792; i++) {
                a[i] = Character.getDirectionality(i);
            }
        }

        b(CharSequence charSequence, boolean z) {
            this.b = charSequence;
            this.c = z;
            this.d = charSequence.length();
        }

        int a() {
            this.e = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.e < this.d && i == 0) {
                byte c = c();
                if (c != 9) {
                    switch (c) {
                        case 0:
                            if (i3 == 0) {
                                return -1;
                            }
                            i = i3;
                            break;
                        case 1:
                        case 2:
                            if (i3 == 0) {
                                return 1;
                            }
                            i = i3;
                            break;
                        default:
                            switch (c) {
                                case 14:
                                case 15:
                                    i3++;
                                    i2 = -1;
                                    continue;
                                case 16:
                                case 17:
                                    i3++;
                                    i2 = 1;
                                    continue;
                                case 18:
                                    i3--;
                                    i2 = 0;
                                    continue;
                            }
                            i = i3;
                            break;
                    }
                }
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.e > 0) {
                switch (d()) {
                    case 14:
                    case 15:
                        if (i != i3) {
                            i3--;
                            break;
                        } else {
                            return -1;
                        }
                    case 16:
                    case 17:
                        if (i != i3) {
                            i3--;
                            break;
                        } else {
                            return 1;
                        }
                    case 18:
                        i3++;
                        break;
                }
            }
            return 0;
        }

        int b() {
            this.e = this.d;
            int i = 0;
            int i2 = 0;
            while (this.e > 0) {
                byte d = d();
                if (d != 9) {
                    switch (d) {
                        case 0:
                            if (i2 != 0) {
                                if (i != 0) {
                                    break;
                                } else {
                                    i = i2;
                                    break;
                                }
                            } else {
                                return -1;
                            }
                        case 1:
                        case 2:
                            if (i2 != 0) {
                                if (i != 0) {
                                    break;
                                } else {
                                    i = i2;
                                    break;
                                }
                            } else {
                                return 1;
                            }
                        default:
                            switch (d) {
                                case 14:
                                case 15:
                                    if (i == i2) {
                                        return -1;
                                    }
                                    i2--;
                                    continue;
                                case 16:
                                case 17:
                                    if (i == i2) {
                                        return 1;
                                    }
                                    i2--;
                                    continue;
                                case 18:
                                    i2++;
                                    continue;
                                default:
                                    if (i != 0) {
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                            i = i2;
                            break;
                    }
                }
            }
            return 0;
        }

        private static byte a(char c) {
            return c < 1792 ? a[c] : Character.getDirectionality(c);
        }

        byte c() {
            this.f = this.b.charAt(this.e);
            if (Character.isHighSurrogate(this.f)) {
                int codePointAt = Character.codePointAt(this.b, this.e);
                this.e += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.e++;
            byte a2 = a(this.f);
            if (!this.c) {
                return a2;
            }
            if (this.f == '<') {
                return e();
            }
            return this.f == '&' ? g() : a2;
        }

        byte d() {
            this.f = this.b.charAt(this.e - 1);
            if (Character.isLowSurrogate(this.f)) {
                int codePointBefore = Character.codePointBefore(this.b, this.e);
                this.e -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.e--;
            byte a2 = a(this.f);
            if (!this.c) {
                return a2;
            }
            if (this.f == '>') {
                return f();
            }
            return this.f == ';' ? h() : a2;
        }

        private byte e() {
            int i = this.e;
            while (this.e < this.d) {
                CharSequence charSequence = this.b;
                int i2 = this.e;
                this.e = i2 + 1;
                this.f = charSequence.charAt(i2);
                if (this.f == '>') {
                    return (byte) 12;
                }
                if (this.f == '\"' || this.f == '\'') {
                    char c = this.f;
                    while (this.e < this.d) {
                        CharSequence charSequence2 = this.b;
                        int i3 = this.e;
                        this.e = i3 + 1;
                        char charAt = charSequence2.charAt(i3);
                        this.f = charAt;
                        if (charAt != c) {
                        }
                    }
                }
            }
            this.e = i;
            this.f = '<';
            return (byte) 13;
        }

        private byte f() {
            int i = this.e;
            while (this.e > 0) {
                CharSequence charSequence = this.b;
                int i2 = this.e - 1;
                this.e = i2;
                this.f = charSequence.charAt(i2);
                if (this.f == '<') {
                    return (byte) 12;
                }
                if (this.f == '>') {
                    break;
                }
                if (this.f == '\"' || this.f == '\'') {
                    char c = this.f;
                    while (this.e > 0) {
                        CharSequence charSequence2 = this.b;
                        int i3 = this.e - 1;
                        this.e = i3;
                        char charAt = charSequence2.charAt(i3);
                        this.f = charAt;
                        if (charAt != c) {
                        }
                    }
                }
            }
            this.e = i;
            this.f = '>';
            return (byte) 13;
        }

        private byte g() {
            while (this.e < this.d) {
                CharSequence charSequence = this.b;
                int i = this.e;
                this.e = i + 1;
                char charAt = charSequence.charAt(i);
                this.f = charAt;
                if (charAt == ';') {
                    return (byte) 12;
                }
            }
            return (byte) 12;
        }

        private byte h() {
            int i = this.e;
            while (this.e > 0) {
                CharSequence charSequence = this.b;
                int i2 = this.e - 1;
                this.e = i2;
                this.f = charSequence.charAt(i2);
                if (this.f == '&') {
                    return (byte) 12;
                }
                if (this.f == ';') {
                    break;
                }
            }
            this.e = i;
            this.f = ';';
            return (byte) 13;
        }
    }
}
