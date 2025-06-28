package com.jumobile.manager.systemapp.d;

import android.os.Environment;
import android.os.Parcel;
import com.jumobile.manager.systemapp.service.DownloadEntry;

/* compiled from: source */
/* loaded from: classes.dex */
public class b {
    private static long g = 1;
    public final long a;
    public String b;
    public Long c;
    public String d;
    public String e;
    public String f;

    public b() {
        long j = g;
        g = 1 + j;
        this.a = j;
    }

    public void a(Parcel parcel) {
        this.b = parcel.readString();
        this.c = Long.valueOf(parcel.readLong());
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
    }

    public DownloadEntry a() {
        String b = com.jumobile.manager.systemapp.util.f.b(this.f);
        return new DownloadEntry(this.f, Environment.getExternalStorageDirectory().getPath() + "/jumobile/cache/" + b + ".apk", this.c.longValue(), this.b, b);
    }
}
