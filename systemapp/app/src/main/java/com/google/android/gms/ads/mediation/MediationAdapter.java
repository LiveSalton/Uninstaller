package com.google.android.gms.ads.mediation;

import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public interface MediationAdapter extends MediationExtrasReceiver {

    /* compiled from: source */
    public static class zza {
        private int a;

        public final zza a(int i) {
            this.a = 1;
            return this;
        }

        public final Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.a);
            return bundle;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
