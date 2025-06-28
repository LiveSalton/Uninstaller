package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zztu;
import com.google.android.gms.internal.ads.zzue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzts {
    private final zztx a;

    @GuardedBy("this")
    private final zzue.zzi.zza b;
    private final boolean c;

    public static zzts a() {
        return new zzts();
    }

    public zzts(zztx zztxVar) {
        this.b = zzue.zzi.d();
        this.a = zztxVar;
        this.c = ((Boolean) zzwq.e().a(zzabf.ct)).booleanValue();
    }

    private zzts() {
        this.b = zzue.zzi.d();
        this.c = false;
        this.a = new zztx();
    }

    public final synchronized void a(zztu.zza.EnumC0074zza enumC0074zza) {
        if (this.c) {
            if (((Boolean) zzwq.e().a(zzabf.cu)).booleanValue()) {
                c(enumC0074zza);
            } else {
                b(enumC0074zza);
            }
        }
    }

    private final synchronized void b(zztu.zza.EnumC0074zza enumC0074zza) {
        this.b.h().a(b());
        this.a.a(((zzue.zzi) ((zzekh) this.b.g())).l()).b(enumC0074zza.a()).a();
        String valueOf = String.valueOf(Integer.toString(enumC0074zza.a(), 10));
        zzd.a(valueOf.length() != 0 ? "Logging Event with event code : ".concat(valueOf) : new String("Logging Event with event code : "));
    }

    private final synchronized void c(zztu.zza.EnumC0074zza enumC0074zza) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
            try {
                try {
                    fileOutputStream.write(d(enumC0074zza).getBytes());
                } catch (IOException unused) {
                    zzd.a("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                        zzd.a("Could not close Clearcut output stream.");
                    }
                }
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException unused3) {
                    zzd.a("Could not close Clearcut output stream.");
                }
            }
        } catch (FileNotFoundException unused4) {
            zzd.a("Could not find file for Clearcut");
        }
    }

    private final synchronized String d(zztu.zza.EnumC0074zza enumC0074zza) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", this.b.a(), Long.valueOf(zzp.j().b()), Integer.valueOf(enumC0074zza.a()), Base64.encodeToString(((zzue.zzi) ((zzekh) this.b.g())).l(), 3));
    }

    public final synchronized void a(zztv zztvVar) {
        if (this.c) {
            try {
                zztvVar.a(this.b);
            } catch (NullPointerException e) {
                zzp.g().a(e, "AdMobClearcutLogger.modify");
            }
        }
    }

    private static List<Long> b() {
        List<String> b = zzabf.b();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = b.iterator();
        while (it.hasNext()) {
            for (String str : it.next().split(",")) {
                try {
                    arrayList.add(Long.valueOf(str));
                } catch (NumberFormatException unused) {
                    zzd.a("Experiment ID is not a number");
                }
            }
        }
        return arrayList;
    }
}
