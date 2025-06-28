package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdvl {
    private final String a;

    public static zzdvl a(String str) {
        return new zzdvl(str);
    }

    private zzdvl(String str) {
        this.a = (String) zzdvv.a(str);
    }

    public final StringBuilder a(StringBuilder sb, Iterator<?> it) {
        try {
            zzdvv.a(sb);
            if (it.hasNext()) {
                sb.append(a(it.next()));
                while (it.hasNext()) {
                    sb.append((CharSequence) this.a);
                    sb.append(a(it.next()));
                }
            }
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    private static CharSequence a(Object obj) {
        zzdvv.a(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
