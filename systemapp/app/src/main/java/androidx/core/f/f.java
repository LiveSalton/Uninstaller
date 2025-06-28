package androidx.core.f;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* compiled from: source */
/* loaded from: classes.dex */
public final class f {
    private static final Locale a = new Locale("", "");

    public static int a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale == null || locale.equals(a)) {
            return 0;
        }
        String a2 = b.a(locale);
        if (a2 == null) {
            return b(locale);
        }
        return (a2.equalsIgnoreCase("Arab") || a2.equalsIgnoreCase("Hebr")) ? 1 : 0;
    }

    private static int b(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case 1:
            case 2:
                return 1;
            default:
                return 0;
        }
    }
}
