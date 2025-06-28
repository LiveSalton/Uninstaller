package com.google.ads;

/* compiled from: source */
@Deprecated
/* loaded from: classes.dex */
public final class a {

    /* compiled from: source */
    public enum b {
        UNKNOWN,
        MALE,
        FEMALE
    }

    /* compiled from: source */
    /* renamed from: com.google.ads.a$a */
    public enum EnumC0056a {
        INVALID_REQUEST("Invalid Ad request."),
        NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
        NETWORK_ERROR("A network error occurred."),
        INTERNAL_ERROR("There was an internal error.");

        private final String e;

        EnumC0056a(String str) {
            this.e = str;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.e;
        }
    }
}
