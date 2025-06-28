package com.jumobile.manager.systemapp.service;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.jumobile.manager.systemapp.R;
import com.jumobile.manager.systemapp.util.f;
import java.io.File;

/* compiled from: source */
/* loaded from: classes.dex */
public class DownloadEntry implements Parcelable {
    public static final Parcelable.Creator<DownloadEntry> CREATOR = new Parcelable.Creator<DownloadEntry>() { // from class: com.jumobile.manager.systemapp.service.DownloadEntry.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadEntry createFromParcel(Parcel parcel) {
            return new DownloadEntry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadEntry[] newArray(int i) {
            return new DownloadEntry[i];
        }
    };
    public String a;
    public String b;
    public long c;
    public String d;
    public long f;
    public int e = -1;
    public int g = 0;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DownloadEntry() {
    }

    public DownloadEntry(String str, String str2, long j, String str3, String str4) {
        a(str, str2, j, str3, str4);
    }

    public void a(String str, String str2, long j, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = str4;
        File file = new File(str2);
        File file2 = new File(b());
        if (file.exists()) {
            this.g = 4;
            this.f = file.length();
            this.c = file.length();
        } else if (file2.exists()) {
            File file3 = new File(c());
            if (file3.exists()) {
                if (this.d.equals((String) f.d(c()))) {
                    this.g = 6;
                    this.f = file2.length();
                    return;
                } else {
                    file3.delete();
                    file2.delete();
                    return;
                }
            }
            file2.delete();
        }
    }

    public DownloadEntry(Parcel parcel) {
        a(parcel);
    }

    public void a(Parcel parcel) {
        this.e = parcel.readInt();
        this.c = parcel.readLong();
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.d = parcel.readString();
        this.f = parcel.readLong();
        this.g = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.e);
        parcel.writeLong(this.c);
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.d);
        parcel.writeLong(this.f);
        parcel.writeInt(this.g);
    }

    public boolean a(DownloadEntry downloadEntry) {
        return this.b.endsWith(downloadEntry.b) && this.a.equals(downloadEntry.a) && this.d.equals(downloadEntry.d);
    }

    public int a() {
        return Math.min((int) ((this.f * 100) / this.c), 100);
    }

    public String b() {
        return this.b + ".tmp";
    }

    public String c() {
        return this.b + ".unique";
    }

    public String d() {
        return this.b + ".time";
    }

    public void e() {
        this.g = 2;
    }

    public void f() {
        this.g = 3;
    }

    public void a(long j, long j2) {
        this.f = j;
        this.c = j2;
    }

    public void a(int i) {
        if (i == 0) {
            this.g = 4;
        } else if (i == 2) {
            this.g = 6;
        } else {
            this.g = 7;
        }
    }

    public void g() {
        new File(c()).delete();
        new File(d()).delete();
        new File(b()).delete();
        this.g = 0;
        this.f = 0L;
    }

    public String a(Context context) {
        switch (this.g) {
            case 0:
            default:
                return "";
            case 1:
                return context.getString(R.string.download_service_state_waiting);
            case 2:
                return context.getString(R.string.download_service_state_connecting);
            case 3:
                return String.format("%d%%", Integer.valueOf(a()));
            case 4:
                return context.getString(R.string.download_service_state_success);
            case 5:
                return context.getString(R.string.download_service_state_canceling);
            case 6:
                return context.getString(R.string.download_service_state_paused);
            case 7:
                return context.getString(R.string.download_service_state_failed);
        }
    }

    public String h() {
        return f.a(this.f) + "/" + f.a(this.c);
    }
}
