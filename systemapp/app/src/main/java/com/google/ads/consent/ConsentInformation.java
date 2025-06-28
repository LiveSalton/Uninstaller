package com.google.ads.consent;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class ConsentInformation {
    private static final String CONSENT_DATA_KEY = "consent_string";
    private static final String MOBILE_ADS_SERVER_URL = "https://adservice.google.com/getconfig/pubvendors";
    private static final String PREFERENCES_FILE_KEY = "mobileads_consent";
    private static final String TAG = "ConsentInformation";
    private static ConsentInformation instance;
    private final Context context;
    private DebugGeography debugGeography = DebugGeography.DEBUG_GEOGRAPHY_DISABLED;
    private List<String> testDevices = new ArrayList();
    private String hashedDeviceId = a();

    /* compiled from: source */
    private static class ConsentInfoUpdateResponse {
        String responseInfo;
        boolean success;

        ConsentInfoUpdateResponse(boolean z, String str) {
            this.success = z;
            this.responseInfo = str;
        }
    }

    private ConsentInformation(Context context) {
        this.context = context.getApplicationContext();
    }

    public static synchronized ConsentInformation a(Context context) {
        ConsentInformation consentInformation;
        synchronized (ConsentInformation.class) {
            if (instance == null) {
                instance = new ConsentInformation(context);
            }
            consentInformation = instance;
        }
        return consentInformation;
    }

    protected String a() {
        ContentResolver contentResolver = this.context.getContentResolver();
        String string = contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id");
        if (string == null || g()) {
            string = "emulator";
        }
        return a(string);
    }

    private String a(String str) {
        for (int i = 0; i < 3; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return String.format("%032X", new BigInteger(1, messageDigest.digest()));
            } catch (ArithmeticException unused) {
                return null;
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        return null;
    }

    private boolean g() {
        return Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT);
    }

    public boolean b() {
        return g() || this.testDevices.contains(this.hashedDeviceId);
    }

    public DebugGeography c() {
        return this.debugGeography;
    }

    /* compiled from: source */
    private static class AdNetworkLookupResponse {

        @SerializedName("company_ids")
        private List<String> companyIds;

        @SerializedName("ad_network_id")
        private String id;

        @SerializedName("is_npa")
        private boolean isNPA;

        @SerializedName("lookup_failed")
        private boolean lookupFailed;

        @SerializedName("not_found")
        private boolean notFound;

        private AdNetworkLookupResponse() {
        }
    }

    /* compiled from: source */
    @VisibleForTesting
    protected static class ServerResponse {

        @SerializedName("ad_network_ids")
        List<AdNetworkLookupResponse> adNetworkLookupResponses;
        List<AdProvider> companies;

        @SerializedName("is_request_in_eea_or_unknown")
        Boolean isRequestLocationInEeaOrUnknown;

        protected ServerResponse() {
        }
    }

    /* compiled from: source */
    private static class ConsentInfoUpdateTask extends AsyncTask<Void, Void, ConsentInfoUpdateResponse> {
        private static final String UPDATE_SUCCESS = "Consent update successful.";
        private final ConsentInformation consentInformation;
        private final ConsentInfoUpdateListener listener;
        private final List<String> publisherIds;
        private final String url;

        ConsentInfoUpdateTask(String str, ConsentInformation consentInformation, List<String> list, ConsentInfoUpdateListener consentInfoUpdateListener) {
            this.url = str;
            this.listener = consentInfoUpdateListener;
            this.publisherIds = list;
            this.consentInformation = consentInformation;
        }

        private String a(InputStream inputStream) {
            byte[] bArr = new byte[1024];
            StringBuilder sb = new StringBuilder();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            while (true) {
                try {
                    try {
                        int read = bufferedInputStream.read(bArr);
                        if (read != -1) {
                            sb.append(new String(bArr, 0, read));
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                            }
                        }
                    } catch (IOException e2) {
                        Log.e(ConsentInformation.TAG, e2.getLocalizedMessage());
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                            Log.e(ConsentInformation.TAG, e3.getLocalizedMessage());
                        }
                        return null;
                    }
                } finally {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e4) {
                        Log.e(ConsentInformation.TAG, e4.getLocalizedMessage());
                    }
                }
            }
            return sb.toString();
        }

        private ConsentInfoUpdateResponse a(String str) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                if (httpURLConnection.getResponseCode() == 200) {
                    String a = a(httpURLConnection.getInputStream());
                    httpURLConnection.disconnect();
                    this.consentInformation.a(a, this.publisherIds);
                    return new ConsentInfoUpdateResponse(true, UPDATE_SUCCESS);
                }
                return new ConsentInfoUpdateResponse(false, httpURLConnection.getResponseMessage());
            } catch (Exception e) {
                return new ConsentInfoUpdateResponse(false, e.getLocalizedMessage());
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public ConsentInfoUpdateResponse doInBackground(Void... voidArr) {
            String join = TextUtils.join(",", this.publisherIds);
            ConsentData d = this.consentInformation.d();
            Uri.Builder appendQueryParameter = Uri.parse(this.url).buildUpon().appendQueryParameter("pubs", join).appendQueryParameter("es", "2").appendQueryParameter("plat", d.g()).appendQueryParameter("v", d.f());
            if (this.consentInformation.b() && this.consentInformation.c() != DebugGeography.DEBUG_GEOGRAPHY_DISABLED) {
                appendQueryParameter = appendQueryParameter.appendQueryParameter("debug_geo", this.consentInformation.c().a().toString());
            }
            return a(appendQueryParameter.build().toString());
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(ConsentInfoUpdateResponse consentInfoUpdateResponse) {
            if (consentInfoUpdateResponse.success) {
                this.listener.a(this.consentInformation.f());
            } else {
                this.listener.a(consentInfoUpdateResponse.responseInfo);
            }
        }
    }

    public void a(String[] strArr, ConsentInfoUpdateListener consentInfoUpdateListener) {
        a(strArr, MOBILE_ADS_SERVER_URL, consentInfoUpdateListener);
    }

    @VisibleForTesting
    protected void a(String[] strArr, String str, ConsentInfoUpdateListener consentInfoUpdateListener) {
        if (b()) {
            Log.i(TAG, "This request is sent from a test device.");
        } else {
            String a = a();
            StringBuilder sb = new StringBuilder(93 + String.valueOf(a).length());
            sb.append("Use ConsentInformation.getInstance(context).addTestDevice(\"");
            sb.append(a);
            sb.append("\") to get test ads on this device.");
            Log.i(TAG, sb.toString());
        }
        new ConsentInfoUpdateTask(str, this, Arrays.asList(strArr), consentInfoUpdateListener).execute(new Void[0]);
    }

    private void a(ServerResponse serverResponse) throws Exception {
        if (serverResponse.isRequestLocationInEeaOrUnknown == null) {
            throw new Exception("Could not parse Event FE preflight response.");
        }
        if (serverResponse.companies == null && serverResponse.isRequestLocationInEeaOrUnknown.booleanValue()) {
            throw new Exception("Could not parse Event FE preflight response.");
        }
        if (serverResponse.isRequestLocationInEeaOrUnknown.booleanValue()) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (AdNetworkLookupResponse adNetworkLookupResponse : serverResponse.adNetworkLookupResponses) {
                if (adNetworkLookupResponse.lookupFailed) {
                    hashSet.add(adNetworkLookupResponse.id);
                }
                if (adNetworkLookupResponse.notFound) {
                    hashSet2.add(adNetworkLookupResponse.id);
                }
            }
            if (hashSet.isEmpty() && hashSet2.isEmpty()) {
                return;
            }
            StringBuilder sb = new StringBuilder("Response error.");
            if (!hashSet.isEmpty()) {
                sb.append(String.format(" Lookup failure for: %s.", TextUtils.join(",", hashSet)));
            }
            if (!hashSet2.isEmpty()) {
                sb.append(String.format(" Publisher Ids not found: %s", TextUtils.join(",", hashSet2)));
            }
            throw new Exception(sb.toString());
        }
    }

    private HashSet<AdProvider> a(List<AdProvider> list, HashSet<String> hashSet) {
        ArrayList arrayList = new ArrayList();
        for (AdProvider adProvider : list) {
            if (hashSet.contains(adProvider.a())) {
                arrayList.add(adProvider);
            }
        }
        return new HashSet<>(arrayList);
    }

    public synchronized void a(String str, List<String> list) throws Exception {
        boolean z;
        HashSet<AdProvider> hashSet;
        ServerResponse serverResponse = (ServerResponse) new Gson().fromJson(str, ServerResponse.class);
        a(serverResponse);
        HashSet<String> hashSet2 = new HashSet<>();
        boolean z2 = true;
        if (serverResponse.adNetworkLookupResponses != null) {
            z = false;
            for (AdNetworkLookupResponse adNetworkLookupResponse : serverResponse.adNetworkLookupResponses) {
                if (adNetworkLookupResponse.isNPA) {
                    List list2 = adNetworkLookupResponse.companyIds;
                    if (list2 != null) {
                        hashSet2.addAll(list2);
                    }
                    z = true;
                }
            }
        } else {
            z = false;
        }
        if (serverResponse.companies == null) {
            hashSet = new HashSet<>();
        } else if (z) {
            hashSet = a(serverResponse.companies, hashSet2);
        } else {
            hashSet = new HashSet<>(serverResponse.companies);
        }
        ConsentData d = d();
        if (d.e() == z) {
            z2 = false;
        }
        d.b(z);
        d.b(str);
        d.b(new HashSet<>(list));
        d.a(hashSet);
        d.a(serverResponse.isRequestLocationInEeaOrUnknown.booleanValue());
        if (!serverResponse.isRequestLocationInEeaOrUnknown.booleanValue()) {
            a(d);
            return;
        }
        if (!d.d().containsAll(d.a()) || z2) {
            d.a("sdk");
            d.a(ConsentStatus.UNKNOWN);
            d.c(new HashSet<>());
        }
        a(d);
    }

    protected ConsentData d() {
        String string = this.context.getSharedPreferences(PREFERENCES_FILE_KEY, 0).getString(CONSENT_DATA_KEY, "");
        if (TextUtils.isEmpty(string)) {
            return new ConsentData();
        }
        return (ConsentData) new Gson().fromJson(string, ConsentData.class);
    }

    private void a(ConsentData consentData) {
        SharedPreferences.Editor edit = this.context.getSharedPreferences(PREFERENCES_FILE_KEY, 0).edit();
        edit.putString(CONSENT_DATA_KEY, new Gson().toJson(consentData));
        edit.apply();
    }

    public boolean e() {
        return d().c();
    }

    protected synchronized void a(ConsentStatus consentStatus, String str) {
        ConsentData d = d();
        if (consentStatus == ConsentStatus.UNKNOWN) {
            d.c(new HashSet<>());
        } else {
            d.c(d.a());
        }
        d.a(str);
        d.a(consentStatus);
        a(d);
    }

    public synchronized ConsentStatus f() {
        return d().b();
    }
}
