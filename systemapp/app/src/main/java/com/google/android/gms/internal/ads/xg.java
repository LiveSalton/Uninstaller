package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzue;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
final class xg implements zzdyo<Bundle> {
    final /* synthetic */ zzcqe a;
    private final /* synthetic */ boolean b;

    xg(zzcqe zzcqeVar, boolean z) {
        this.a = zzcqeVar;
        this.b = z;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        zzd.c("Failed to get signals bundle");
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(Bundle bundle) {
        ArrayList c;
        zzue.zzo.zzc b;
        zzue.zzm a;
        zzcpr zzcprVar;
        Bundle bundle2 = bundle;
        zzcqe zzcqeVar = this.a;
        c = zzcqe.c(bundle2);
        zzcqe zzcqeVar2 = this.a;
        b = zzcqe.b(bundle2);
        a = this.a.a(bundle2);
        zzcprVar = this.a.e;
        zzcprVar.a(new zzdqv(this, this.b, c, a, b) { // from class: com.google.android.gms.internal.ads.xh
            private final xg a;
            private final boolean b;
            private final ArrayList c;
            private final zzue.zzm d;
            private final zzue.zzo.zzc e;

            {
                this.a = this;
                this.b = z;
                this.c = c;
                this.d = a;
                this.e = b;
            }

            @Override // com.google.android.gms.internal.ads.zzdqv
            public final Object a(Object obj) {
                byte[] a2;
                xg xgVar = this.a;
                boolean z2 = this.b;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                a2 = xgVar.a.a(z2, this.c, this.d, this.e);
                ContentValues contentValues = new ContentValues();
                contentValues.put("timestamp", Long.valueOf(zzp.j().a()));
                contentValues.put("serialized_proto_data", a2);
                sQLiteDatabase.insert("offline_signal_contents", null, contentValues);
                sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", "total_requests"));
                if (!z2) {
                    sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", "failed_requests"));
                }
                return null;
            }
        });
    }
}
