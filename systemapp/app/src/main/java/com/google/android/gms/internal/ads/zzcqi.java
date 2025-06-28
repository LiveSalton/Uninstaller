package com.google.android.gms.internal.ads;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.internal.ads.zzue;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcqi {
    public static ArrayList<zzue.zzo.zza> a(SQLiteDatabase sQLiteDatabase) {
        ArrayList<zzue.zzo.zza> arrayList = new ArrayList<>();
        Cursor query = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, null, null, null, null, null);
        while (query.moveToNext()) {
            try {
                arrayList.add(zzue.zzo.zza.a(query.getBlob(query.getColumnIndexOrThrow("serialized_proto_data"))));
            } catch (zzeks e) {
                zzd.c("Unable to deserialize proto from offline signals database:");
                zzd.c(e.getMessage());
            }
        }
        query.close();
        return arrayList;
    }

    public static int a(SQLiteDatabase sQLiteDatabase, int i) {
        int i2 = 0;
        if (i == 2) {
            return 0;
        }
        Cursor c = c(sQLiteDatabase, i);
        if (c.getCount() > 0) {
            c.moveToNext();
            i2 = 0 + c.getInt(c.getColumnIndexOrThrow("value"));
        }
        c.close();
        return i2;
    }

    public static long b(SQLiteDatabase sQLiteDatabase, int i) {
        Cursor c = c(sQLiteDatabase, 2);
        long j = 0;
        if (c.getCount() > 0) {
            c.moveToNext();
            j = 0 + c.getLong(c.getColumnIndexOrThrow("value"));
        }
        c.close();
        return j;
    }

    private static Cursor c(SQLiteDatabase sQLiteDatabase, int i) {
        String[] strArr = {"value"};
        String[] strArr2 = new String[1];
        switch (i) {
            case 0:
                strArr2[0] = "failed_requests";
                break;
            case 1:
                strArr2[0] = "total_requests";
                break;
            case 2:
                strArr2[0] = "last_successful_request_time";
                break;
        }
        return sQLiteDatabase.query("offline_signal_statistics", strArr, "statistic_name = ?", strArr2, null, null, null);
    }
}
