package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: source */
/* loaded from: classes.dex */
final class xc implements zzdyo<SQLiteDatabase> {
    private final /* synthetic */ zzdqv a;

    xc(zzcpr zzcprVar, zzdqv zzdqvVar) {
        this.a = zzdqvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        String valueOf = String.valueOf(th.getMessage());
        zzd.c(valueOf.length() != 0 ? "Failed to get offline signal database: ".concat(valueOf) : new String("Failed to get offline signal database: "));
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a.a(sQLiteDatabase);
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzd.c(valueOf.length() != 0 ? "Error executing function on offline signal database: ".concat(valueOf) : new String("Error executing function on offline signal database: "));
        }
    }
}
