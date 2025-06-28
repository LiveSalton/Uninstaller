package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzabi {

    @VisibleForTesting
    private String d;

    @VisibleForTesting
    private Context e;

    @VisibleForTesting
    private String f;
    private AtomicBoolean h;
    private File i;

    @VisibleForTesting
    private BlockingQueue<zzabs> a = new ArrayBlockingQueue(100);

    @VisibleForTesting
    private LinkedHashMap<String, String> b = new LinkedHashMap<>();

    @VisibleForTesting
    private Map<String, zzabm> c = new HashMap();
    private final HashSet<String> g = new HashSet<>(Arrays.asList("noop", "activeViewPingSent", "viewabilityChanged", "visibilityChanged"));

    public final void a(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.e = context;
        this.f = str;
        this.d = str2;
        this.h = new AtomicBoolean(false);
        this.h.set(zzacx.c.a().booleanValue());
        if (this.h.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.i = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.b.put(entry.getKey(), entry.getValue());
        }
        zzazj.a.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.o
            private final zzabi a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a();
            }
        });
        this.c.put("action", zzabm.b);
        this.c.put("ad_format", zzabm.b);
        this.c.put("e", zzabm.c);
    }

    public final boolean a(zzabs zzabsVar) {
        return this.a.offer(zzabsVar);
    }

    private final void a(Map<String, String> map, zzabv zzabvVar) {
        Uri.Builder buildUpon = Uri.parse(this.d).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        String uri = buildUpon.build().toString();
        if (zzabvVar != null) {
            StringBuilder sb = new StringBuilder(uri);
            if (!TextUtils.isEmpty(zzabvVar.a())) {
                sb.append("&it=");
                sb.append(zzabvVar.a());
            }
            if (!TextUtils.isEmpty(zzabvVar.b())) {
                sb.append("&blat=");
                sb.append(zzabvVar.b());
            }
            uri = sb.toString();
        }
        if (this.h.get()) {
            File file = this.i;
            if (file != null) {
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
                        try {
                            fileOutputStream2.write(uri.getBytes());
                            fileOutputStream2.write(10);
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e) {
                                zzd.d("CsiReporter: Cannot close file: sdk_csi_data.txt.", e);
                            }
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            zzd.d("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                    zzd.d("CsiReporter: Cannot close file: sdk_csi_data.txt.", e3);
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    zzd.d("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e5) {
                    e = e5;
                }
            } else {
                zzd.e("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
            }
        } else {
            zzp.c();
            com.google.android.gms.ads.internal.util.zzm.a(this.e, this.f, uri);
        }
    }

    final Map<String, String> a(Map<String, String> map, Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            linkedHashMap.put(key, a(key).a((String) linkedHashMap.get(key), value));
        }
        return linkedHashMap;
    }

    public final zzabm a(String str) {
        zzabm zzabmVar = this.c.get(str);
        return zzabmVar != null ? zzabmVar : zzabm.a;
    }

    public final void b(String str) {
        if (this.g.contains(str)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sdkVersion", this.f);
        linkedHashMap.put("ue", str);
        a(a(this.b, linkedHashMap), (zzabv) null);
    }

    final /* synthetic */ void a() {
        while (true) {
            try {
                zzabs take = this.a.take();
                zzabv a = take.a();
                if (a != null && !TextUtils.isEmpty(a.a())) {
                    a(a(this.b, take.b()), a);
                }
            } catch (InterruptedException e) {
                zzd.d("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }
}
