package com.google.android.gms.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzyz;
import com.google.android.gms.internal.ads.zzza;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;

/* compiled from: source */
@VisibleForTesting
/* loaded from: classes.dex */
public final class AdRequest {
    private final zzza a;

    /* compiled from: source */
    @Retention(RetentionPolicy.SOURCE)
    @Deprecated
    public @interface MaxAdContentRating {
    }

    /* compiled from: source */
    @Retention(RetentionPolicy.SOURCE)
    @Deprecated
    public @interface TagForUnderAgeOfConsent {
    }

    private AdRequest(Builder builder) {
        this.a = new zzza(builder.a);
    }

    /* compiled from: source */
    @VisibleForTesting
    public static final class Builder {
        private final zzyz a = new zzyz();

        public Builder() {
            this.a.b("B3EEABB8EE11C2BE770B684D95219ECB");
        }

        public final Builder a(String str) {
            this.a.a(str);
            return this;
        }

        public final Builder a(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
            this.a.a(cls, bundle);
            if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.a.c("B3EEABB8EE11C2BE770B684D95219ECB");
            }
            return this;
        }

        @Deprecated
        public final Builder b(String str) {
            this.a.b(str);
            return this;
        }

        public final AdRequest a() {
            return new AdRequest(this);
        }

        @Deprecated
        public final Builder a(Date date) {
            this.a.a(date);
            return this;
        }

        @Deprecated
        public final Builder a(int i) {
            this.a.a(i);
            return this;
        }

        public final Builder a(Location location) {
            this.a.a(location);
            return this;
        }

        @Deprecated
        public final Builder a(boolean z) {
            this.a.a(z);
            return this;
        }

        @Deprecated
        public final Builder b(boolean z) {
            this.a.b(z);
            return this;
        }
    }

    public final zzza a() {
        return this.a;
    }

    /* synthetic */ AdRequest(Builder builder, a aVar) {
        this(builder);
    }
}
