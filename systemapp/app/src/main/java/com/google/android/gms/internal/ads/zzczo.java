package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzue;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzczo {
    private String a;

    /* compiled from: source */
    public static class zza {
        private String a;

        public final zza a(String str) {
            this.a = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    zzczo(zza zzaVar) {
        this.a = zzaVar.a;
    }

    public final Set<String> a() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.a.toLowerCase(Locale.ROOT));
        return hashSet;
    }

    public final String b() {
        return this.a.toLowerCase(Locale.ROOT);
    }

    public final zzue.zza.EnumC0075zza c() {
        char c;
        String str = this.a;
        int hashCode = str.hashCode();
        if (hashCode == -1999289321) {
            if (str.equals("NATIVE")) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode == -1372958932) {
            if (str.equals("INTERSTITIAL")) {
                c = 1;
            }
            c = 65535;
        } else if (hashCode != 543046670) {
            if (hashCode == 1951953708 && str.equals("BANNER")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals("REWARDED")) {
                c = 3;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                return zzue.zza.EnumC0075zza.BANNER;
            case 1:
                return zzue.zza.EnumC0075zza.INTERSTITIAL;
            case 2:
                return zzue.zza.EnumC0075zza.AD_LOADER;
            case 3:
                return zzue.zza.EnumC0075zza.REWARD_BASED_VIDEO_AD;
            default:
                return zzue.zza.EnumC0075zza.AD_INITIATER_UNSPECIFIED;
        }
    }

    /* synthetic */ zzczo(zza zzaVar, acb acbVar) {
        this(zzaVar);
    }
}
