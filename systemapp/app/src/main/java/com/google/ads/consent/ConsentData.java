package com.google.ads.consent;

import com.google.gson.annotations.SerializedName;
import java.util.HashSet;

/* compiled from: source */
/* loaded from: classes.dex */
class ConsentData {
    private static final String SDK_PLATFORM = "android";
    private static final String SDK_VERSION = "1.0.8";

    @SerializedName("consent_source")
    private String consentSource;

    @SerializedName("providers")
    private HashSet<AdProvider> adProviders = new HashSet<>();

    @SerializedName("consented_providers")
    private HashSet<AdProvider> consentedAdProviders = new HashSet<>();

    @SerializedName("pub_ids")
    private HashSet<String> publisherIds = new HashSet<>();

    @SerializedName("tag_for_under_age_of_consent")
    private Boolean underAgeOfConsent = false;

    @SerializedName("consent_state")
    private ConsentStatus consentStatus = ConsentStatus.UNKNOWN;

    @SerializedName("is_request_in_eea_or_unknown")
    private boolean isRequestLocationInEeaOrUnknown = false;

    @SerializedName("has_any_npa_pub_id")
    private boolean hasNonPersonalizedPublisherId = false;

    @SerializedName("version")
    private final String sdkVersionString = SDK_VERSION;

    @SerializedName("plat")
    private final String sdkPlatformString = SDK_PLATFORM;

    @SerializedName("raw_response")
    private String rawResponse = "";

    ConsentData() {
    }

    HashSet<AdProvider> a() {
        return this.adProviders;
    }

    void a(HashSet<AdProvider> hashSet) {
        this.adProviders = hashSet;
    }

    ConsentStatus b() {
        return this.consentStatus;
    }

    void a(ConsentStatus consentStatus) {
        this.consentStatus = consentStatus;
    }

    void b(HashSet<String> hashSet) {
        this.publisherIds = hashSet;
    }

    boolean c() {
        return this.isRequestLocationInEeaOrUnknown;
    }

    void a(boolean z) {
        this.isRequestLocationInEeaOrUnknown = z;
    }

    HashSet<AdProvider> d() {
        return this.consentedAdProviders;
    }

    void c(HashSet<AdProvider> hashSet) {
        this.consentedAdProviders = hashSet;
    }

    boolean e() {
        return this.hasNonPersonalizedPublisherId;
    }

    void b(boolean z) {
        this.hasNonPersonalizedPublisherId = z;
    }

    public String f() {
        return this.sdkVersionString;
    }

    public String g() {
        return this.sdkPlatformString;
    }

    public void a(String str) {
        this.consentSource = str;
    }

    void b(String str) {
        this.rawResponse = str;
    }
}
