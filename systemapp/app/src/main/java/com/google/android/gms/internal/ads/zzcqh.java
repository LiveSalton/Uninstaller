package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zztu;
import com.google.android.gms.internal.ads.zzue;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcqh {
    private zzts a;
    private Context b;
    private zzcpr c;
    private zzazh d;

    public zzcqh(Context context, zzazh zzazhVar, zzts zztsVar, zzcpr zzcprVar) {
        this.b = context;
        this.d = zzazhVar;
        this.a = zztsVar;
        this.c = zzcprVar;
    }

    public final void a() {
        try {
            this.c.a(new zzdqv(this) { // from class: com.google.android.gms.internal.ads.xj
                private final zzcqh a;

                {
                    this.a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdqv
                public final Object a(Object obj) {
                    return this.a.a((SQLiteDatabase) obj);
                }
            });
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzd.c(valueOf.length() != 0 ? "Error in offline signals database startup: ".concat(valueOf) : new String("Error in offline signals database startup: "));
        }
    }

    final /* synthetic */ Void a(SQLiteDatabase sQLiteDatabase) throws Exception {
        ArrayList<zzue.zzo.zza> a = zzcqi.a(sQLiteDatabase);
        zzue.zzo zzoVar = (zzue.zzo) ((zzekh) zzue.zzo.a().a(this.b.getPackageName()).b(Build.MODEL).a(zzcqi.a(sQLiteDatabase, 0)).a(a).b(zzcqi.a(sQLiteDatabase, 1)).a(zzp.j().a()).b(zzcqi.b(sQLiteDatabase, 2)).g());
        ArrayList<zzue.zzo.zza> arrayList = a;
        int size = arrayList.size();
        int i = 0;
        long j = 0;
        while (i < size) {
            zzue.zzo.zza zzaVar = arrayList.get(i);
            i++;
            zzue.zzo.zza zzaVar2 = zzaVar;
            if (zzaVar2.b() == zzuo.ENUM_TRUE && zzaVar2.a() > j) {
                j = zzaVar2.a();
            }
        }
        if (j != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", Long.valueOf(j));
            sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", null);
        }
        this.a.a(new zztv(zzoVar) { // from class: com.google.android.gms.internal.ads.xi
            private final zzue.zzo a;

            {
                this.a = zzoVar;
            }

            @Override // com.google.android.gms.internal.ads.zztv
            public final void a(zzue.zzi.zza zzaVar3) {
                zzaVar3.a(this.a);
            }
        });
        this.a.a(new zztv((zzue.zzu) ((zzekh) zzue.zzu.a().a(this.d.b).b(this.d.c).c(this.d.d ? 0 : 2).g())) { // from class: com.google.android.gms.internal.ads.xk
            private final zzue.zzu a;

            {
                this.a = zzuVar;
            }

            @Override // com.google.android.gms.internal.ads.zztv
            public final void a(zzue.zzi.zza zzaVar3) {
                zzaVar3.a(zzaVar3.i().p().a(this.a));
            }
        });
        this.a.a(zztu.zza.EnumC0074zza.OFFLINE_UPLOAD);
        sQLiteDatabase.delete("offline_signal_contents", null, null);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("value", (Integer) 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues2, "statistic_name = ?", new String[]{"failed_requests"});
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("value", (Integer) 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues3, "statistic_name = ?", new String[]{"total_requests"});
        return null;
    }
}
