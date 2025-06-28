package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.JsonWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzayu {
    private static boolean b = false;
    private static boolean c = false;
    private final List<String> f;
    private static Object a = new Object();
    private static Clock d = DefaultClock.d();
    private static final Set<String> e = new HashSet(Arrays.asList(new String[0]));

    public zzayu() {
        this(null);
    }

    public zzayu(String str) {
        List<String> asList;
        if (!c()) {
            asList = new ArrayList<>();
        } else {
            String[] strArr = new String[1];
            String valueOf = String.valueOf(UUID.randomUUID().toString());
            strArr[0] = valueOf.length() != 0 ? "network_request_".concat(valueOf) : new String("network_request_");
            asList = Arrays.asList(strArr);
        }
        this.f = asList;
    }

    public final void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        if (c()) {
            b(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), httpURLConnection.getRequestProperties() == null ? null : new HashMap(httpURLConnection.getRequestProperties()), bArr);
        }
    }

    public final void a(String str, String str2, Map<String, ?> map, byte[] bArr) {
        if (c()) {
            b(str, str2, map, bArr);
        }
    }

    private final void b(String str, String str2, Map<String, ?> map, byte[] bArr) {
        a("onNetworkRequest", new fm(str, str2, map, bArr) { // from class: com.google.android.gms.internal.ads.fj
            private final String a;
            private final String b;
            private final Map c;
            private final byte[] d;

            {
                this.a = str;
                this.b = str2;
                this.c = map;
                this.d = bArr;
            }

            @Override // com.google.android.gms.internal.ads.fm
            public final void a(JsonWriter jsonWriter) {
                zzayu.a(this.a, this.b, this.c, this.d, jsonWriter);
            }
        });
    }

    public final void a(HttpURLConnection httpURLConnection, int i) {
        String str;
        if (c()) {
            b(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i);
            if (i < 200 || i >= 300) {
                try {
                    str = httpURLConnection.getResponseMessage();
                } catch (IOException e2) {
                    String valueOf = String.valueOf(e2.getMessage());
                    zzaza.e(valueOf.length() != 0 ? "Can not get error message from error HttpURLConnection\n".concat(valueOf) : new String("Can not get error message from error HttpURLConnection\n"));
                    str = null;
                }
                b(str);
            }
        }
    }

    public final void a(Map<String, ?> map, int i) {
        if (c()) {
            b(map, i);
            if (i < 200 || i >= 300) {
                b(null);
            }
        }
    }

    private final void b(Map<String, ?> map, int i) {
        a("onNetworkResponse", new fm(i, map) { // from class: com.google.android.gms.internal.ads.fi
            private final int a;
            private final Map b;

            {
                this.a = i;
                this.b = map;
            }

            @Override // com.google.android.gms.internal.ads.fm
            public final void a(JsonWriter jsonWriter) {
                zzayu.a(this.a, this.b, jsonWriter);
            }
        });
    }

    public final void a(String str) {
        if (c() && str != null) {
            a(str.getBytes());
        }
    }

    public final void a(byte[] bArr) {
        a("onNetworkResponseBody", new fm(bArr) { // from class: com.google.android.gms.internal.ads.fl
            private final byte[] a;

            {
                this.a = bArr;
            }

            @Override // com.google.android.gms.internal.ads.fm
            public final void a(JsonWriter jsonWriter) {
                zzayu.a(this.a, jsonWriter);
            }
        });
    }

    private final void b(String str) {
        a("onNetworkRequestError", new fm(str) { // from class: com.google.android.gms.internal.ads.fk
            private final String a;

            {
                this.a = str;
            }

            @Override // com.google.android.gms.internal.ads.fm
            public final void a(JsonWriter jsonWriter) {
                zzayu.a(this.a, jsonWriter);
            }
        });
    }

    private static void a(JsonWriter jsonWriter, Map<String, ?> map) throws IOException {
        if (map == null) {
            return;
        }
        jsonWriter.name("headers").beginArray();
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, ?> next = it.next();
            String key = next.getKey();
            if (!e.contains(key)) {
                if (next.getValue() instanceof List) {
                    for (String str : (List) next.getValue()) {
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(key);
                        jsonWriter.name("value").value(str);
                        jsonWriter.endObject();
                    }
                } else if (next.getValue() instanceof String) {
                    jsonWriter.beginObject();
                    jsonWriter.name("name").value(key);
                    jsonWriter.name("value").value((String) next.getValue());
                    jsonWriter.endObject();
                } else {
                    zzaza.c("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                    break;
                }
            }
        }
        jsonWriter.endArray();
    }

    private final void a(String str, fm fmVar) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(d.a());
            jsonWriter.name("event").value(str);
            jsonWriter.name("components").beginArray();
            Iterator<String> it = this.f.iterator();
            while (it.hasNext()) {
                jsonWriter.value(it.next());
            }
            jsonWriter.endArray();
            fmVar.a(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e2) {
            zzaza.c("unable to log", e2);
        }
        c(stringWriter.toString());
    }

    private static synchronized void c(String str) {
        synchronized (zzayu.class) {
            zzaza.d("GMA Debug BEGIN");
            int i = 0;
            while (i < str.length()) {
                int i2 = i + 4000;
                String valueOf = String.valueOf(str.substring(i, Math.min(i2, str.length())));
                zzaza.d(valueOf.length() != 0 ? "GMA Debug CONTENT ".concat(valueOf) : new String("GMA Debug CONTENT "));
                i = i2;
            }
            zzaza.d("GMA Debug FINISH");
        }
    }

    public static void a() {
        synchronized (a) {
            b = false;
            c = false;
            zzaza.e("Ad debug logging enablement is out of date.");
        }
    }

    public static void a(boolean z) {
        synchronized (a) {
            b = true;
            c = z;
        }
    }

    public static boolean b() {
        boolean z;
        synchronized (a) {
            z = b;
        }
        return z;
    }

    public static boolean c() {
        boolean z;
        synchronized (a) {
            z = b && c;
        }
        return z;
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT < 17 || !zzacw.a.a().booleanValue()) {
            return false;
        }
        try {
            return Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
        } catch (Exception e2) {
            zzaza.d("Fail to determine debug setting.", e2);
            return false;
        }
    }

    static final /* synthetic */ void a(String str, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        if (str != null) {
            jsonWriter.name("error_description").value(str);
        }
        jsonWriter.endObject();
    }

    static final /* synthetic */ void a(byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        int length = bArr.length;
        String a2 = Base64Utils.a(bArr);
        if (length < 10000) {
            jsonWriter.name("body").value(a2);
        } else {
            String a3 = zzayr.a(a2);
            if (a3 != null) {
                jsonWriter.name("bodydigest").value(a3);
            }
        }
        jsonWriter.name("bodylength").value(length);
        jsonWriter.endObject();
    }

    static final /* synthetic */ void a(int i, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value(i);
        jsonWriter.endObject();
        a(jsonWriter, (Map<String, ?>) map);
        jsonWriter.endObject();
    }

    static final /* synthetic */ void a(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        a(jsonWriter, (Map<String, ?>) map);
        if (bArr != null) {
            jsonWriter.name("body").value(Base64Utils.a(bArr));
        }
        jsonWriter.endObject();
    }
}
