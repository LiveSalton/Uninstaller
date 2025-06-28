package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzbh extends zzaa<String> {
    private final Object a;
    private zzal<String> b;

    public zzbh(int i, String str, zzal<String> zzalVar, zzai zzaiVar) {
        super(i, str, zzaiVar);
        this.a = new Object();
        this.b = zzalVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    public void a(String str) {
        zzal<String> zzalVar;
        synchronized (this.a) {
            zzalVar = this.b;
        }
        if (zzalVar != null) {
            zzalVar.a(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    protected final zzaj<String> a(zzy zzyVar) {
        String str;
        String str2;
        try {
            byte[] bArr = zzyVar.b;
            Map<String, String> map = zzyVar.c;
            String str3 = "ISO-8859-1";
            if (map != null && (str2 = map.get("Content-Type")) != null) {
                String[] split = str2.split(";", 0);
                int i = 1;
                while (true) {
                    if (i >= split.length) {
                        break;
                    }
                    String[] split2 = split[i].trim().split("=", 0);
                    if (split2.length == 2 && split2[0].equals("charset")) {
                        str3 = split2[1];
                        break;
                    }
                    i++;
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzyVar.b);
        }
        return zzaj.a(str, zzbc.a(zzyVar));
    }
}
