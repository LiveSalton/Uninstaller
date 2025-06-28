package com.google.android.gms.internal.ads;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdwc {
    public static String a(@NullableDecl String str) {
        return als.b(str);
    }

    @NullableDecl
    public static String b(@NullableDecl String str) {
        return als.c(str);
    }

    public static boolean c(@NullableDecl String str) {
        return als.a(str);
    }

    public static String a(@NullableDecl String str, @NullableDecl Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i = 0;
        for (int i2 = 0; i2 < objArr.length; i2++) {
            objArr[i2] = a(objArr[i2]);
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (16 * objArr.length));
        int i3 = 0;
        while (i < objArr.length && (indexOf = valueOf.indexOf("%s", i3)) != -1) {
            sb.append((CharSequence) valueOf, i3, indexOf);
            sb.append(objArr[i]);
            i3 = indexOf + 2;
            i++;
        }
        sb.append((CharSequence) valueOf, i3, valueOf.length());
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    private static String a(@NullableDecl Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e) {
            String name = obj.getClass().getName();
            String hexString = Integer.toHexString(System.identityHashCode(obj));
            StringBuilder sb = new StringBuilder(1 + String.valueOf(name).length() + String.valueOf(hexString).length());
            sb.append(name);
            sb.append('@');
            sb.append(hexString);
            String sb2 = sb.toString();
            Logger logger = Logger.getLogger("com.google.common.base.Strings");
            Level level = Level.WARNING;
            String valueOf = String.valueOf(sb2);
            logger.logp(level, "com.google.common.base.Strings", "lenientToString", valueOf.length() != 0 ? "Exception during lenientFormat for ".concat(valueOf) : new String("Exception during lenientFormat for "), (Throwable) e);
            String name2 = e.getClass().getName();
            StringBuilder sb3 = new StringBuilder(9 + String.valueOf(sb2).length() + String.valueOf(name2).length());
            sb3.append("<");
            sb3.append(sb2);
            sb3.append(" threw ");
            sb3.append(name2);
            sb3.append(">");
            return sb3.toString();
        }
    }
}
