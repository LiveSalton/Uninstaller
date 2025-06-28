package com.google.android.gms.internal.ads;

import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
final class als {
    private static final Logger a = Logger.getLogger(als.class.getName());
    private static final alq b = new a();

    /* compiled from: source */
    static final class a {
        private a() {
        }

        /* synthetic */ a(alr alrVar) {
            this();
        }
    }

    private als() {
    }

    static String b(@NullableDecl String str) {
        return str == null ? "" : str;
    }

    static boolean a(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }

    static String c(@NullableDecl String str) {
        if (a(str)) {
            return null;
        }
        return str;
    }
}
