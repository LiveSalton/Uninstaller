package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzmd;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzka {
    private static final zzml c = new ayx();
    private static final Pattern d = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int a = -1;
    public int b = -1;

    public final boolean a(zzmd zzmdVar) {
        for (int i = 0; i < zzmdVar.a(); i++) {
            zzmd.zza a = zzmdVar.a(i);
            if (a instanceof zzmj) {
                zzmj zzmjVar = (zzmj) a;
                if (a(zzmjVar.a, zzmjVar.b)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean a(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = d.matcher(str2);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group(1), 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.a = parseInt;
                    this.b = parseInt2;
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public final boolean a() {
        return (this.a == -1 || this.b == -1) ? false : true;
    }
}
