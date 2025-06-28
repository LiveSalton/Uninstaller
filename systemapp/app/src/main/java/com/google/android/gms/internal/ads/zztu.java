package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zztu {

    /* compiled from: source */
    public static final class zza extends zzekh<zza, zzb> implements zzelu {
        private static final zza zzbvv;
        private static volatile zzemb<zza> zzei;

        /* compiled from: source */
        /* renamed from: com.google.android.gms.internal.ads.zztu$zza$zza */
        public enum EnumC0074zza implements zzekj {
            UNKNOWN_EVENT_TYPE(0),
            AD_REQUEST(1),
            AD_LOADED(2),
            AD_IMPRESSION(5),
            AD_FIRST_CLICK(6),
            AD_SUBSEQUENT_CLICK(7),
            REQUEST_WILL_START(8),
            REQUEST_DID_END(9),
            REQUEST_WILL_UPDATE_SIGNALS(10),
            REQUEST_DID_UPDATE_SIGNALS(11),
            REQUEST_WILL_BUILD_URL(12),
            REQUEST_DID_BUILD_URL(13),
            REQUEST_WILL_MAKE_NETWORK_REQUEST(14),
            REQUEST_DID_RECEIVE_NETWORK_RESPONSE(15),
            REQUEST_WILL_PROCESS_RESPONSE(16),
            REQUEST_DID_PROCESS_RESPONSE(17),
            REQUEST_WILL_RENDER(18),
            REQUEST_DID_RENDER(19),
            AD_FAILED_TO_LOAD(3),
            AD_FAILED_TO_LOAD_NO_FILL(4),
            AD_FAILED_TO_LOAD_INVALID_REQUEST(100),
            AD_FAILED_TO_LOAD_NETWORK_ERROR(101),
            AD_FAILED_TO_LOAD_TIMEOUT(102),
            AD_FAILED_TO_LOAD_CANCELLED(103),
            AD_FAILED_TO_LOAD_NO_ERROR(104),
            AD_FAILED_TO_LOAD_NOT_FOUND(105),
            REQUEST_WILL_UPDATE_GMS_SIGNALS(1000),
            REQUEST_DID_UPDATE_GMS_SIGNALS(1001),
            REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS(1002),
            REQUEST_FAILED_TO_BUILD_URL(1003),
            REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST(1004),
            REQUEST_FAILED_TO_PROCESS_RESPONSE(1005),
            REQUEST_FAILED_TO_UPDATE_SIGNALS(1006),
            REQUEST_FAILED_TO_RENDER(1007),
            REQUEST_IS_PREFETCH(1100),
            REQUEST_SAVED_TO_CACHE(1101),
            REQUEST_LOADED_FROM_CACHE(1102),
            REQUEST_PREFETCH_INTERCEPTED(1103),
            REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED(1104),
            REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED(1105),
            NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED(1106),
            NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED(1107),
            REQUEST_FAILED_TO_LOAD_FROM_CACHE(1108),
            BANNER_SIZE_INVALID(10000),
            BANNER_SIZE_VALID(10001),
            ANDROID_WEBVIEW_CRASH(10002),
            OFFLINE_UPLOAD(10003),
            DELAY_PAGE_LOAD_CANCELLED_AD(10004);

            private static final zzekm<EnumC0074zza> W = new bcw();
            private final int X;

            @Override // com.google.android.gms.internal.ads.zzekj
            public final int a() {
                return this.X;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.X + " name=" + name() + '>';
            }

            EnumC0074zza(int i) {
                this.X = i;
            }
        }

        private zza() {
        }

        /* compiled from: source */
        public static final class zzb extends zzekh.zza<zza, zzb> implements zzelu {
            private zzb() {
                super(zza.zzbvv);
            }

            /* synthetic */ zzb(bcv bcvVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.zzekh
        protected final Object a(int i, Object obj, Object obj2) {
            switch (bcv.a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(null);
                case 3:
                    return a(zzbvv, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zzbvv;
                case 5:
                    zzemb<zza> zzembVar = zzei;
                    if (zzembVar == null) {
                        synchronized (zza.class) {
                            zzembVar = zzei;
                            if (zzembVar == null) {
                                zzembVar = new zzekh.zzc<>(zzbvv);
                                zzei = zzembVar;
                            }
                        }
                    }
                    return zzembVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zzaVar = new zza();
            zzbvv = zzaVar;
            zzekh.a((Class<zza>) zza.class, zzaVar);
        }
    }
}
