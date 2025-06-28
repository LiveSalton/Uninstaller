package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.IOUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcpj implements zzdqv<zzcpm, zzcpl> {
    private final Context a;
    private final String b;
    private final zzaty c;
    private final String d;
    private final int e;

    public zzcpj(Context context, String str, zzaty zzatyVar, String str2, int i) {
        this.a = context;
        this.b = str;
        this.c = zzatyVar;
        this.d = str2;
        this.e = i;
    }

    private final zzcpl a(String str, zzatr zzatrVar, JSONObject jSONObject, String str2) throws zzcme {
        HttpURLConnection httpURLConnection;
        byte[] bArr;
        int responseCode;
        Throwable th;
        InputStreamReader inputStreamReader;
        Throwable th2;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        JSONObject jSONObject2 = jSONObject;
        try {
            int optInt = jSONObject2.optInt("http_timeout_millis", 60000);
            if (zzatrVar.a() != -2) {
                if (zzatrVar.a() == 1) {
                    if (zzatrVar.b() != null) {
                        zzd.c(TextUtils.join(", ", zzatrVar.b()));
                    }
                    throw new zzcme(zzdok.INVALID_REQUEST, "Error building request URL.");
                }
                throw new zzcme(zzdok.INTERNAL_ERROR);
            }
            zzcpl zzcplVar = new zzcpl();
            String valueOf = String.valueOf(this.b);
            zzd.d(valueOf.length() != 0 ? "SDK version: ".concat(valueOf) : new String("SDK version: "));
            String valueOf2 = String.valueOf(str);
            zzd.b(valueOf2.length() != 0 ? "AdRequestServiceImpl: Sending request: ".concat(valueOf2) : new String("AdRequestServiceImpl: Sending request: "));
            URL url = new URL(str);
            HashMap hashMap = new HashMap();
            long b = zzp.j().b();
            int i = 0;
            while (true) {
                this.c.a(this.e);
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection = httpURLConnection2;
                } catch (zzcme e) {
                    e = e;
                    httpURLConnection = httpURLConnection2;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                }
                try {
                    try {
                        zzp.c().a(this.a, this.b, false, httpURLConnection2, false, optInt);
                        if (!TextUtils.isEmpty(str2)) {
                            httpURLConnection.addRequestProperty("Cookie", str2);
                        }
                        if (zzatrVar.f()) {
                            JSONObject optJSONObject = jSONObject2.optJSONObject("pii");
                            if (optJSONObject != null) {
                                if (!TextUtils.isEmpty(optJSONObject.optString("doritos", ""))) {
                                    httpURLConnection.addRequestProperty("x-afma-drt-cookie", optJSONObject.optString("doritos", ""));
                                }
                                if (!TextUtils.isEmpty(optJSONObject.optString("doritos_v2", ""))) {
                                    httpURLConnection.addRequestProperty("x-afma-drt-v2-cookie", optJSONObject.optString("doritos_v2", ""));
                                }
                            } else {
                                zzd.a("DSID signal does not exist.");
                            }
                        }
                        if (zzatrVar == null || TextUtils.isEmpty(zzatrVar.d())) {
                            bArr = null;
                        } else {
                            httpURLConnection.setDoOutput(true);
                            bArr = zzatrVar.d().getBytes();
                            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                            try {
                                bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                            } catch (Throwable th4) {
                                th2 = th4;
                                bufferedOutputStream = null;
                            }
                            try {
                                bufferedOutputStream2.write(bArr);
                                IOUtils.a(bufferedOutputStream2);
                            } catch (Throwable th5) {
                                th2 = th5;
                                bufferedOutputStream = bufferedOutputStream2;
                                IOUtils.a(bufferedOutputStream);
                                throw th2;
                            }
                        }
                        zzayu zzayuVar = new zzayu();
                        zzayuVar.a(httpURLConnection, bArr);
                        responseCode = httpURLConnection.getResponseCode();
                        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
                            String key = entry.getKey();
                            List<String> value = entry.getValue();
                            if (hashMap.containsKey(key)) {
                                ((List) hashMap.get(key)).addAll(value);
                            } else {
                                hashMap.put(key, new ArrayList(value));
                            }
                        }
                        zzayuVar.a(httpURLConnection, responseCode);
                        zzcplVar.a = responseCode;
                        zzcplVar.b = hashMap;
                        zzcplVar.c = "";
                        if (responseCode >= 200 && responseCode < 300) {
                            try {
                                inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                                try {
                                    zzp.c();
                                    String a = com.google.android.gms.ads.internal.util.zzm.a(inputStreamReader);
                                    IOUtils.a(inputStreamReader);
                                    zzayuVar.a(a);
                                    zzcplVar.c = a;
                                    if (TextUtils.isEmpty(a)) {
                                        if (!((Boolean) zzwq.e().a(zzabf.cL)).booleanValue()) {
                                            throw new zzcme(zzdok.NO_FILL);
                                        }
                                    }
                                    zzcplVar.d = zzp.j().b() - b;
                                    httpURLConnection.disconnect();
                                    this.c.a();
                                    return zzcplVar;
                                } catch (Throwable th6) {
                                    th = th6;
                                    IOUtils.a(inputStreamReader);
                                    throw th;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                inputStreamReader = null;
                            }
                        } else {
                            if (responseCode < 300 || responseCode >= 400) {
                                break;
                            }
                            String headerField = httpURLConnection.getHeaderField("Location");
                            if (TextUtils.isEmpty(headerField)) {
                                zzd.e("No location header to follow redirect.");
                                throw new zzcme(zzdok.INTERNAL_ERROR, "No location header to follow redirect");
                            }
                            url = new URL(headerField);
                            int i2 = i + 1;
                            if (i2 > ((Integer) zzwq.e().a(zzabf.cy)).intValue()) {
                                zzd.e("Too many redirects.");
                                throw new zzcme(zzdok.INTERNAL_ERROR, "Too many redirects");
                            }
                            httpURLConnection.disconnect();
                            this.c.a();
                            i = i2;
                            jSONObject2 = jSONObject;
                        }
                    } catch (zzcme e2) {
                        e = e2;
                        zzcme zzcmeVar = e;
                        if (((Boolean) zzwq.e().a(zzabf.ey)).booleanValue()) {
                            zzcplVar.d = zzp.j().b() - b;
                            httpURLConnection.disconnect();
                            this.c.a();
                            return zzcplVar;
                        }
                        throw zzcmeVar;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    Throwable th9 = th;
                    httpURLConnection.disconnect();
                    this.c.a();
                    throw th9;
                }
            }
            StringBuilder sb = new StringBuilder(46);
            sb.append("Received error HTTP response code: ");
            sb.append(responseCode);
            zzd.e(sb.toString());
            zzdok zzdokVar = zzdok.INTERNAL_ERROR;
            StringBuilder sb2 = new StringBuilder(46);
            sb2.append("Received error HTTP response code: ");
            sb2.append(responseCode);
            throw new zzcme(zzdokVar, sb2.toString());
        } catch (IOException e3) {
            String valueOf3 = String.valueOf(e3.getMessage());
            String concat = valueOf3.length() != 0 ? "Error while connecting to ad server: ".concat(valueOf3) : new String("Error while connecting to ad server: ");
            zzd.e(concat);
            throw new zzcme(zzdok.INTERNAL_ERROR, concat, e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdqv
    public final /* synthetic */ zzcpl a(zzcpm zzcpmVar) throws Exception {
        zzatr zzatrVar;
        zzatr zzatrVar2;
        JSONObject jSONObject;
        zzcpm zzcpmVar2 = zzcpmVar;
        zzatrVar = zzcpmVar2.b;
        String e = zzatrVar.e();
        zzatrVar2 = zzcpmVar2.b;
        jSONObject = zzcpmVar2.a;
        return a(e, zzatrVar2, jSONObject, this.d);
    }
}
