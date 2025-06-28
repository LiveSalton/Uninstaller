package com.google.ads.consent;

import com.google.gson.annotations.SerializedName;

/* compiled from: source */
/* loaded from: classes.dex */
public final class AdProvider {

    @SerializedName("company_id")
    private String id;

    @SerializedName("company_name")
    private String name;

    @SerializedName("policy_url")
    private String privacyPolicyUrlString;

    public String a() {
        return this.id;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.id.equals(((AdProvider) obj).id);
    }

    public int hashCode() {
        return this.id.hashCode();
    }
}
