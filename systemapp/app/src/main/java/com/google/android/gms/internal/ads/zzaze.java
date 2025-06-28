package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaze implements zzayv {
    private final String a;

    public zzaze() {
        this(null);
    }

    public zzaze(String str) {
        this.a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzayv
    public final void a(String str) {
        try {
            try {
                try {
                    if (ClientLibraryUtils.a()) {
                        TrafficStats.setThreadStatsTag(263);
                    }
                    String valueOf = String.valueOf(str);
                    zzaza.b(valueOf.length() != 0 ? "Pinging URL: ".concat(valueOf) : new String("Pinging URL: "));
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        zzwq.a();
                        zzayr.a(true, httpURLConnection, this.a);
                        zzayu zzayuVar = new zzayu();
                        zzayuVar.a(httpURLConnection, (byte[]) null);
                        int responseCode = httpURLConnection.getResponseCode();
                        zzayuVar.a(httpURLConnection, responseCode);
                        if (responseCode < 200 || responseCode >= 300) {
                            StringBuilder sb = new StringBuilder(65 + String.valueOf(str).length());
                            sb.append("Received non-success response code ");
                            sb.append(responseCode);
                            sb.append(" from pinging URL: ");
                            sb.append(str);
                            zzaza.e(sb.toString());
                        }
                        if (ClientLibraryUtils.a()) {
                            TrafficStats.clearThreadStatsTag();
                        }
                    } finally {
                        httpURLConnection.disconnect();
                    }
                } catch (IndexOutOfBoundsException e) {
                    String message = e.getMessage();
                    StringBuilder sb2 = new StringBuilder(32 + String.valueOf(str).length() + String.valueOf(message).length());
                    sb2.append("Error while parsing ping URL: ");
                    sb2.append(str);
                    sb2.append(". ");
                    sb2.append(message);
                    zzaza.e(sb2.toString());
                    if (ClientLibraryUtils.a()) {
                        TrafficStats.clearThreadStatsTag();
                    }
                } catch (RuntimeException e2) {
                    String message2 = e2.getMessage();
                    StringBuilder sb3 = new StringBuilder(27 + String.valueOf(str).length() + String.valueOf(message2).length());
                    sb3.append("Error while pinging URL: ");
                    sb3.append(str);
                    sb3.append(". ");
                    sb3.append(message2);
                    zzaza.e(sb3.toString());
                    if (ClientLibraryUtils.a()) {
                        TrafficStats.clearThreadStatsTag();
                    }
                }
            } catch (IOException e3) {
                String message3 = e3.getMessage();
                StringBuilder sb4 = new StringBuilder(27 + String.valueOf(str).length() + String.valueOf(message3).length());
                sb4.append("Error while pinging URL: ");
                sb4.append(str);
                sb4.append(". ");
                sb4.append(message3);
                zzaza.e(sb4.toString());
                if (ClientLibraryUtils.a()) {
                    TrafficStats.clearThreadStatsTag();
                }
            }
        } catch (Throwable th) {
            if (ClientLibraryUtils.a()) {
                TrafficStats.clearThreadStatsTag();
            }
            throw th;
        }
    }
}
