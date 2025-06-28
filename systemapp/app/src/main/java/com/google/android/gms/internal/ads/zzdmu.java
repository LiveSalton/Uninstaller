package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.nonagon.transaction.omid.OmidSettings;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdmu {
    public final String A;
    public final JSONObject B;
    public final JSONObject C;
    public final String D;
    public final boolean E;
    public final boolean F;
    public final boolean G;
    public final boolean H;
    public final boolean I;
    public final boolean J;
    public final boolean K;
    public final int L;
    public final int M;
    public final boolean N;
    public final String O;
    public final OmidSettings P;
    public final boolean Q;
    public final boolean R;
    public final int S;
    public final boolean T;
    public final String U;
    public final int V;
    public final String W;
    public final boolean X;
    public final zzaro Y;
    public final boolean Z;
    public final List<String> a;
    public final zzvp aa;
    public final String ab;
    public final boolean ac;
    public final JSONObject ad;
    public final boolean ae;
    public final JSONObject af;
    public final String ag;
    public final int b;
    public final List<String> c;
    public final List<String> d;
    public final int e;
    public final List<String> f;
    public final List<String> g;
    public final List<String> h;
    public final List<String> i;
    public final String j;
    public final String k;
    public final zzava l;
    public final List<String> m;
    public final List<String> n;
    public final List<String> o;
    public final int p;
    public final List<zzdmx> q;
    public final zzdnb r;
    public final List<String> s;
    public final List<zzdmx> t;
    public final JSONObject u;
    public final String v;
    public final String w;
    public final String x;
    public final String y;
    public final zzawp z;

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0458. Please report as an issue. */
    zzdmu(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        List<String> list;
        char c;
        zzava zzavaVar;
        List<String> list2;
        List<String> emptyList = Collections.emptyList();
        List<String> emptyList2 = Collections.emptyList();
        List<String> emptyList3 = Collections.emptyList();
        List<String> emptyList4 = Collections.emptyList();
        List<String> emptyList5 = Collections.emptyList();
        Collections.emptyList();
        List<String> emptyList6 = Collections.emptyList();
        List<String> emptyList7 = Collections.emptyList();
        List<String> emptyList8 = Collections.emptyList();
        List<String> emptyList9 = Collections.emptyList();
        List<String> emptyList10 = Collections.emptyList();
        List<zzdmx> emptyList11 = Collections.emptyList();
        List<String> emptyList12 = Collections.emptyList();
        List<zzdmx> emptyList13 = Collections.emptyList();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        JSONObject jSONObject6 = new JSONObject();
        jsonReader.beginObject();
        List<String> list3 = emptyList10;
        List<zzdmx> list4 = emptyList11;
        List<String> list5 = emptyList12;
        List<zzdmx> list6 = emptyList13;
        String str = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        JSONObject jSONObject7 = jSONObject;
        JSONObject jSONObject8 = jSONObject2;
        String str6 = "";
        JSONObject jSONObject9 = jSONObject3;
        String str7 = "";
        String str8 = "";
        String str9 = "";
        JSONObject jSONObject10 = jSONObject4;
        String str10 = "";
        JSONObject jSONObject11 = jSONObject5;
        JSONObject jSONObject12 = jSONObject6;
        int i = -1;
        int i2 = -1;
        zzava zzavaVar2 = null;
        zzdnb zzdnbVar = null;
        zzawp zzawpVar = null;
        zzaro zzaroVar = null;
        zzvp zzvpVar = null;
        String str11 = null;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i4 = 0;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        int i5 = 0;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = true;
        boolean z14 = false;
        boolean z15 = false;
        String str12 = "";
        List<String> list7 = emptyList8;
        List<String> list8 = emptyList9;
        List<String> list9 = emptyList6;
        List<String> list10 = emptyList7;
        String str13 = "";
        int i6 = 0;
        List<String> list11 = emptyList4;
        List<String> list12 = emptyList5;
        List<String> list13 = emptyList2;
        List<String> list14 = emptyList3;
        List<String> list15 = emptyList;
        int i7 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            String str14 = nextName == null ? "" : nextName;
            switch (str14.hashCode()) {
                case -1980587809:
                    list = list8;
                    if (str14.equals("debug_signals")) {
                        c = 28;
                        break;
                    }
                    c = 65535;
                    break;
                case -1965512151:
                    list = list8;
                    if (str14.equals("omid_settings")) {
                        c = ')';
                        break;
                    }
                    c = 65535;
                    break;
                case -1812055556:
                    list = list8;
                    if (str14.equals("play_prewarm_options")) {
                        c = '2';
                        break;
                    }
                    c = 65535;
                    break;
                case -1662989631:
                    list = list8;
                    if (str14.equals("is_interscroller")) {
                        c = '6';
                        break;
                    }
                    c = 65535;
                    break;
                case -1620470467:
                    list = list8;
                    if (str14.equals("backend_query_id")) {
                        c = '0';
                        break;
                    }
                    c = 65535;
                    break;
                case -1440104884:
                    list = list8;
                    if (str14.equals("is_custom_close_blocked")) {
                        c = '#';
                        break;
                    }
                    c = 65535;
                    break;
                case -1439500848:
                    list = list8;
                    if (str14.equals("orientation")) {
                        c = '%';
                        break;
                    }
                    c = 65535;
                    break;
                case -1428969291:
                    list = list8;
                    if (str14.equals("enable_omid")) {
                        c = '\'';
                        break;
                    }
                    c = 65535;
                    break;
                case -1403779768:
                    list = list8;
                    if (str14.equals("showable_impression_type")) {
                        c = ',';
                        break;
                    }
                    c = 65535;
                    break;
                case -1375413093:
                    list = list8;
                    if (str14.equals("ad_cover")) {
                        c = '7';
                        break;
                    }
                    c = 65535;
                    break;
                case -1360811658:
                    list = list8;
                    if (str14.equals("ad_sizes")) {
                        c = 19;
                        break;
                    }
                    c = 65535;
                    break;
                case -1306015996:
                    list = list8;
                    if (str14.equals("adapters")) {
                        c = 20;
                        break;
                    }
                    c = 65535;
                    break;
                case -1303332046:
                    list = list8;
                    if (str14.equals("test_mode_enabled")) {
                        c = '\"';
                        break;
                    }
                    c = 65535;
                    break;
                case -1289032093:
                    list = list8;
                    if (str14.equals("extras")) {
                        c = 29;
                        break;
                    }
                    c = 65535;
                    break;
                case -1240082064:
                    list = list8;
                    if (str14.equals("ad_event_value")) {
                        c = '4';
                        break;
                    }
                    c = 65535;
                    break;
                case -1234181075:
                    list = list8;
                    if (str14.equals("allow_pub_rendered_attribution")) {
                        c = 30;
                        break;
                    }
                    c = 65535;
                    break;
                case -1181000426:
                    list = list8;
                    if (str14.equals("is_augmented_reality_ad")) {
                        c = '-';
                        break;
                    }
                    c = 65535;
                    break;
                case -1168140544:
                    list = list8;
                    if (str14.equals("presentation_error_urls")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case -1152230954:
                    list = list8;
                    if (str14.equals("ad_type")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1146534047:
                    list = list8;
                    if (str14.equals("is_scroll_aware")) {
                        c = '+';
                        break;
                    }
                    c = 65535;
                    break;
                case -1115838944:
                    list = list8;
                    if (str14.equals("fill_urls")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case -1081936678:
                    list = list8;
                    if (str14.equals("allocation_id")) {
                        c = 21;
                        break;
                    }
                    c = 65535;
                    break;
                case -1078050970:
                    list = list8;
                    if (str14.equals("video_complete_urls")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -1051269058:
                    list = list8;
                    if (str14.equals("active_view")) {
                        c = 25;
                        break;
                    }
                    c = 65535;
                    break;
                case -982608540:
                    list = list8;
                    if (str14.equals("valid_from_timestamp")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -776859333:
                    list = list8;
                    if (str14.equals("click_urls")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -544216775:
                    list = list8;
                    if (str14.equals("safe_browsing")) {
                        c = 26;
                        break;
                    }
                    c = 65535;
                    break;
                case -437057161:
                    list = list8;
                    if (str14.equals("imp_urls")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -404433734:
                    list = list8;
                    if (str14.equals("rtb_native_required_assets")) {
                        c = ':';
                        break;
                    }
                    c = 65535;
                    break;
                case -404326515:
                    list = list8;
                    if (str14.equals("render_timeout_ms")) {
                        c = '&';
                        break;
                    }
                    c = 65535;
                    break;
                case -397704715:
                    list = list8;
                    if (str14.equals("ad_close_time_ms")) {
                        c = '.';
                        break;
                    }
                    c = 65535;
                    break;
                case -388807511:
                    list = list8;
                    if (str14.equals("content_url")) {
                        c = ';';
                        break;
                    }
                    c = 65535;
                    break;
                case -369773488:
                    list = list8;
                    if (str14.equals("is_close_button_enabled")) {
                        c = '3';
                        break;
                    }
                    c = 65535;
                    break;
                case -213424028:
                    list = list8;
                    if (str14.equals("watermark")) {
                        c = '/';
                        break;
                    }
                    c = 65535;
                    break;
                case -154616268:
                    list = list8;
                    if (str14.equals("is_offline_ad")) {
                        c = '9';
                        break;
                    }
                    c = 65535;
                    break;
                case -29338502:
                    list = list8;
                    if (str14.equals("allow_custom_click_gesture")) {
                        c = ' ';
                        break;
                    }
                    c = 65535;
                    break;
                case 3107:
                    list = list8;
                    if (str14.equals("ad")) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                case 3355:
                    list = list8;
                    if (str14.equals("id")) {
                        c = 23;
                        break;
                    }
                    c = 65535;
                    break;
                case 3076010:
                    list = list8;
                    if (str14.equals("data")) {
                        c = 22;
                        break;
                    }
                    c = 65535;
                    break;
                case 63195984:
                    list = list8;
                    if (str14.equals("render_test_label")) {
                        c = '!';
                        break;
                    }
                    c = 65535;
                    break;
                case 107433883:
                    list = list8;
                    if (str14.equals("qdata")) {
                        c = 24;
                        break;
                    }
                    c = 65535;
                    break;
                case 230323073:
                    list = list8;
                    if (str14.equals("ad_load_urls")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 418392395:
                    list = list8;
                    if (str14.equals("is_closable_area_disabled")) {
                        c = '$';
                        break;
                    }
                    c = 65535;
                    break;
                case 549176928:
                    list = list8;
                    if (str14.equals("presentation_error_timeout_ms")) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 597473788:
                    list = list8;
                    if (str14.equals("debug_dialog_string")) {
                        c = 27;
                        break;
                    }
                    c = 65535;
                    break;
                case 673261304:
                    list = list8;
                    if (str14.equals("reward_granted_urls")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 754887508:
                    list = list8;
                    if (str14.equals("container_sizes")) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case 791122864:
                    list = list8;
                    if (str14.equals("impression_type")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1010584092:
                    list = list8;
                    if (str14.equals("transaction_id")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 1100650276:
                    list = list8;
                    if (str14.equals("rewards")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 1321720943:
                    list = list8;
                    if (str14.equals("allow_pub_owned_ad_view")) {
                        c = 31;
                        break;
                    }
                    c = 65535;
                    break;
                case 1637553475:
                    list = list8;
                    if (str14.equals("bid_response")) {
                        c = '(';
                        break;
                    }
                    c = 65535;
                    break;
                case 1638957285:
                    list = list8;
                    if (str14.equals("video_start_urls")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1686319423:
                    list = list8;
                    if (str14.equals("ad_network_class_name")) {
                        c = '8';
                        break;
                    }
                    c = 65535;
                    break;
                case 1688341040:
                    list = list8;
                    if (str14.equals("video_reward_urls")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 1799285870:
                    list = list8;
                    if (str14.equals("use_third_party_container_height")) {
                        c = '1';
                        break;
                    }
                    c = 65535;
                    break;
                case 1839650832:
                    list = list8;
                    if (str14.equals("renderers")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1875425491:
                    list = list8;
                    if (str14.equals("is_analytics_logging_enabled")) {
                        c = '*';
                        break;
                    }
                    c = 65535;
                    break;
                case 2068142375:
                    list = list8;
                    if (str14.equals("rule_line_external_id")) {
                        c = '5';
                        break;
                    }
                    c = 65535;
                    break;
                case 2072888499:
                    list = list8;
                    if (str14.equals("manual_tracking_urls")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    list = list8;
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    zzavaVar = zzavaVar2;
                    list2 = list7;
                    list15 = com.google.android.gms.ads.internal.util.zzbk.a(jsonReader);
                    list8 = list;
                    list7 = list2;
                    zzavaVar2 = zzavaVar;
                    break;
                case 1:
                    zzavaVar = zzavaVar2;
                    list2 = list7;
                    String nextString = jsonReader.nextString();
                    i7 = "banner".equals(nextString) ? 1 : "interstitial".equals(nextString) ? 2 : "native_express".equals(nextString) ? 3 : "native".equals(nextString) ? 4 : "rewarded".equals(nextString) ? 5 : "app_open_ad".equals(nextString) ? 6 : 0;
                    list8 = list;
                    list7 = list2;
                    zzavaVar2 = zzavaVar;
                    break;
                case 2:
                    zzavaVar = zzavaVar2;
                    list2 = list7;
                    list13 = com.google.android.gms.ads.internal.util.zzbk.a(jsonReader);
                    list8 = list;
                    list7 = list2;
                    zzavaVar2 = zzavaVar;
                    break;
                case 3:
                    zzavaVar = zzavaVar2;
                    list2 = list7;
                    list14 = com.google.android.gms.ads.internal.util.zzbk.a(jsonReader);
                    list8 = list;
                    list7 = list2;
                    zzavaVar2 = zzavaVar;
                    break;
                case 4:
                    zzavaVar = zzavaVar2;
                    list2 = list7;
                    list11 = com.google.android.gms.ads.internal.util.zzbk.a(jsonReader);
                    list8 = list;
                    list7 = list2;
                    zzavaVar2 = zzavaVar;
                    break;
                case 5:
                    zzavaVar = zzavaVar2;
                    list2 = list7;
                    int nextInt = jsonReader.nextInt();
                    if (nextInt != 0 && nextInt != 1) {
                        i6 = 0;
                        list8 = list;
                        list7 = list2;
                        zzavaVar2 = zzavaVar;
                        break;
                    }
                    i6 = nextInt;
                    list8 = list;
                    list7 = list2;
                    zzavaVar2 = zzavaVar;
                    break;
                case 6:
                    zzavaVar = zzavaVar2;
                    list12 = com.google.android.gms.ads.internal.util.zzbk.a(jsonReader);
                    list8 = list;
                    zzavaVar2 = zzavaVar;
                    break;
                case 7:
                    zzavaVar = zzavaVar2;
                    list2 = list7;
                    com.google.android.gms.ads.internal.util.zzbk.a(jsonReader);
                    list8 = list;
                    list7 = list2;
                    zzavaVar2 = zzavaVar;
                    break;
                case '\b':
                    zzavaVar = zzavaVar2;
                    list9 = com.google.android.gms.ads.internal.util.zzbk.a(jsonReader);
                    list8 = list;
                    zzavaVar2 = zzavaVar;
                    break;
                case '\t':
                    zzavaVar = zzavaVar2;
                    list10 = com.google.android.gms.ads.internal.util.zzbk.a(jsonReader);
                    list8 = list;
                    zzavaVar2 = zzavaVar;
                    break;
                case '\n':
                    zzavaVar = zzavaVar2;
                    str13 = jsonReader.nextString();
                    list8 = list;
                    zzavaVar2 = zzavaVar;
                    break;
                case 11:
                    zzavaVar = zzavaVar2;
                    str12 = jsonReader.nextString();
                    list8 = list;
                    zzavaVar2 = zzavaVar;
                    break;
                case '\f':
                    zzavaVar2 = zzava.a(com.google.android.gms.ads.internal.util.zzbk.d(jsonReader));
                    list8 = list;
                    break;
                case '\r':
                    zzavaVar = zzavaVar2;
                    list7 = com.google.android.gms.ads.internal.util.zzbk.a(jsonReader);
                    list8 = list;
                    zzavaVar2 = zzavaVar;
                    break;
                case 14:
                    zzavaVar = zzavaVar2;
                    list8 = com.google.android.gms.ads.internal.util.zzbk.a(jsonReader);
                    zzavaVar2 = zzavaVar;
                    break;
                case 15:
                    zzavaVar = zzavaVar2;
                    list3 = com.google.android.gms.ads.internal.util.zzbk.a(jsonReader);
                    list8 = list;
                    zzavaVar2 = zzavaVar;
                    break;
                case 16:
                    zzavaVar = zzavaVar2;
                    i3 = jsonReader.nextInt();
                    list8 = list;
                    zzavaVar2 = zzavaVar;
                    break;
                case 17:
                    zzavaVar = zzavaVar2;
                    list4 = zzdmx.a(jsonReader);
                    list8 = list;
                    zzavaVar2 = zzavaVar;
                    break;
                case 18:
                    zzavaVar = zzavaVar2;
                    zzdnbVar = new zzdnb(jsonReader);
                    list8 = list;
                    zzavaVar2 = zzavaVar;
                    break;
                case 19:
                    list6 = zzdmx.a(jsonReader);
                    list8 = list;
                    break;
                case 20:
                    list5 = com.google.android.gms.ads.internal.util.zzbk.a(jsonReader);
                    list8 = list;
                    break;
                case 21:
                    str = jsonReader.nextString();
                    list8 = list;
                    break;
                case 22:
                    jSONObject7 = com.google.android.gms.ads.internal.util.zzbk.c(jsonReader);
                    list8 = list;
                    break;
                case 23:
                    str2 = jsonReader.nextString();
                    list8 = list;
                    break;
                case 24:
                    str3 = jsonReader.nextString();
                    list8 = list;
                    break;
                case 25:
                    str4 = com.google.android.gms.ads.internal.util.zzbk.c(jsonReader).toString();
                    list8 = list;
                    break;
                case 26:
                    zzawpVar = zzawp.a(com.google.android.gms.ads.internal.util.zzbk.c(jsonReader));
                    list8 = list;
                    break;
                case 27:
                    str5 = jsonReader.nextString();
                    list8 = list;
                    break;
                case 28:
                    jSONObject8 = com.google.android.gms.ads.internal.util.zzbk.c(jsonReader);
                    list8 = list;
                    break;
                case 29:
                    jSONObject9 = com.google.android.gms.ads.internal.util.zzbk.c(jsonReader);
                    list8 = list;
                    break;
                case 30:
                    z = jsonReader.nextBoolean();
                    list8 = list;
                    break;
                case 31:
                    z2 = jsonReader.nextBoolean();
                    list8 = list;
                    break;
                case ' ':
                    z3 = jsonReader.nextBoolean();
                    list8 = list;
                    break;
                case '!':
                    z4 = jsonReader.nextBoolean();
                    list8 = list;
                    break;
                case '\"':
                    z5 = jsonReader.nextBoolean();
                    list8 = list;
                    break;
                case '#':
                    z6 = jsonReader.nextBoolean();
                    list8 = list;
                    break;
                case '$':
                    z7 = jsonReader.nextBoolean();
                    list8 = list;
                    break;
                case '%':
                    zzavaVar = zzavaVar2;
                    list2 = list7;
                    String nextString2 = jsonReader.nextString();
                    if ("landscape".equalsIgnoreCase(nextString2)) {
                        zzp.e();
                        i = 6;
                    } else if ("portrait".equalsIgnoreCase(nextString2)) {
                        zzp.e();
                        i = 7;
                    } else {
                        i = -1;
                    }
                    list8 = list;
                    list7 = list2;
                    zzavaVar2 = zzavaVar;
                    break;
                case '&':
                    i4 = jsonReader.nextInt();
                    list8 = list;
                    break;
                case '\'':
                    z8 = jsonReader.nextBoolean();
                    list8 = list;
                    break;
                case '(':
                    str6 = jsonReader.nextString();
                    list8 = list;
                    break;
                case ')':
                    jSONObject10 = com.google.android.gms.ads.internal.util.zzbk.c(jsonReader);
                    list8 = list;
                    break;
                case '*':
                    z9 = jsonReader.nextBoolean();
                    list8 = list;
                    break;
                case '+':
                    z10 = jsonReader.nextBoolean();
                    list8 = list;
                    break;
                case ',':
                    i5 = jsonReader.nextInt();
                    list8 = list;
                    break;
                case '-':
                    z11 = jsonReader.nextBoolean();
                    list8 = list;
                    break;
                case '.':
                    i2 = jsonReader.nextInt();
                    list8 = list;
                    break;
                case '/':
                    str7 = jsonReader.nextString();
                    list8 = list;
                    break;
                case '0':
                    str8 = jsonReader.nextString();
                    list8 = list;
                    break;
                case '1':
                    z12 = jsonReader.nextBoolean();
                    list8 = list;
                    break;
                case '2':
                    JSONObject c2 = com.google.android.gms.ads.internal.util.zzbk.c(jsonReader);
                    if (c2 == null) {
                        zzavaVar = zzavaVar2;
                        list2 = list7;
                        zzaroVar = null;
                    } else {
                        list2 = list7;
                        zzavaVar = zzavaVar2;
                        zzaroVar = new zzaro(c2.optBoolean("enable_prewarming", false), c2.optString("prefetch_url", ""));
                    }
                    list8 = list;
                    list7 = list2;
                    zzavaVar2 = zzavaVar;
                    break;
                case '3':
                    z13 = jsonReader.nextBoolean();
                    list8 = list;
                    break;
                case '4':
                    zzvpVar = zzvp.a(com.google.android.gms.ads.internal.util.zzbk.c(jsonReader));
                    list8 = list;
                    break;
                case '5':
                    str9 = jsonReader.nextString();
                    list8 = list;
                    break;
                case '6':
                    z14 = jsonReader.nextBoolean();
                    list8 = list;
                    break;
                case '7':
                    jSONObject11 = com.google.android.gms.ads.internal.util.zzbk.c(jsonReader);
                    list8 = list;
                    break;
                case '8':
                    str10 = jsonReader.nextString();
                    list8 = list;
                    break;
                case '9':
                    z15 = jsonReader.nextBoolean();
                    list8 = list;
                    break;
                case ':':
                    jSONObject12 = com.google.android.gms.ads.internal.util.zzbk.c(jsonReader);
                    list8 = list;
                    break;
                case ';':
                    str11 = jsonReader.nextString();
                    list8 = list;
                    break;
                default:
                    zzavaVar = zzavaVar2;
                    list2 = list7;
                    jsonReader.skipValue();
                    list8 = list;
                    list7 = list2;
                    zzavaVar2 = zzavaVar;
                    break;
            }
        }
        jsonReader.endObject();
        this.a = list15;
        this.b = i7;
        this.c = list13;
        this.d = list14;
        this.f = list11;
        this.e = i6;
        this.g = list12;
        this.h = list9;
        this.i = list10;
        this.j = str13;
        this.k = str12;
        this.l = zzavaVar2;
        this.m = list7;
        this.n = list8;
        this.o = list3;
        this.p = i3;
        this.q = list4;
        this.r = zzdnbVar;
        this.s = list5;
        this.t = list6;
        this.v = str;
        this.u = jSONObject7;
        this.w = str2;
        this.x = str3;
        this.y = str4;
        this.z = zzawpVar;
        this.A = str5;
        this.B = jSONObject8;
        this.C = jSONObject9;
        this.E = z;
        this.F = z2;
        this.G = z3;
        this.H = z4;
        this.I = z5;
        this.J = z6;
        this.K = z7;
        this.L = i;
        this.M = i4;
        this.N = z8;
        this.O = str6;
        this.P = new OmidSettings(jSONObject10);
        this.Q = z9;
        this.R = z10;
        this.S = i5;
        this.T = z11;
        this.U = str7;
        this.V = i2;
        this.W = str8;
        this.X = z12;
        this.Y = zzaroVar;
        this.Z = z13;
        this.aa = zzvpVar;
        this.ab = str9;
        this.ac = z14;
        this.ad = jSONObject11;
        this.D = str10;
        this.ae = z15;
        this.af = jSONObject12;
        this.ag = str11;
    }
}
