package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdvq {
    private final String a;
    private final alp b;
    private alp c;
    private boolean d;

    /* JADX INFO: Access modifiers changed from: private */
    zzdvq(String str) {
        this.b = new alp();
        this.c = this.b;
        this.d = false;
        this.a = (String) zzdvv.a(str);
    }

    public final zzdvq a(@NullableDecl Object obj) {
        alp alpVar = new alp();
        this.c.b = alpVar;
        this.c = alpVar;
        alpVar.a = obj;
        return this;
    }

    public final String toString() {
        String str = "";
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.a);
        sb.append('{');
        for (alp alpVar = this.b.b; alpVar != null; alpVar = alpVar.b) {
            Object obj = alpVar.a;
            sb.append(str);
            str = ", ";
            if (obj != null && obj.getClass().isArray()) {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
            } else {
                sb.append(obj);
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /* synthetic */ zzdvq(String str, alo aloVar) {
        this(str);
    }
}
