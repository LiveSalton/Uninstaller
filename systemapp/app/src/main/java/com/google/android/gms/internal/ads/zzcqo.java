package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcqo extends SQLiteOpenHelper {
    private final Context a;
    private final zzdzc b;

    public zzcqo(Context context, zzdzc zzdzcVar) {
        super(context, "AdMobOfflineBufferedPings.db", (SQLiteDatabase.CursorFactory) null, ((Integer) zzwq.e().a(zzabf.eB)).intValue());
        this.a = context;
        this.b = zzdzcVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_buffered_pings (timestamp INTEGER PRIMARY_KEY, gws_query_id TEXT, url TEXT, event_state INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    private final void a(zzdqv<SQLiteDatabase, Void> zzdqvVar) {
        zzdyr.a(this.b.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.xl
            private final zzcqo a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.getWritableDatabase();
            }
        }), new xq(this, zzdqvVar), this.b);
    }

    private static void a(SQLiteDatabase sQLiteDatabase, zzaze zzazeVar) {
        sQLiteDatabase.beginTransaction();
        try {
            StringBuilder sb = new StringBuilder(25);
            sb.append("event_state = 1");
            Cursor query = sQLiteDatabase.query("offline_buffered_pings", new String[]{"url"}, sb.toString(), null, null, null, "timestamp ASC", null);
            String[] strArr = new String[query.getCount()];
            int i = 0;
            while (query.moveToNext()) {
                int columnIndex = query.getColumnIndex("url");
                if (columnIndex != -1) {
                    strArr[i] = query.getString(columnIndex);
                }
                i++;
            }
            query.close();
            sQLiteDatabase.delete("offline_buffered_pings", "event_state = ?", new String[]{Integer.toString(1)});
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            for (String str : strArr) {
                zzazeVar.a(str);
            }
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
    }

    public final void a(zzaze zzazeVar) {
        a(new zzdqv(zzazeVar) { // from class: com.google.android.gms.internal.ads.xn
            private final zzaze a;

            {
                this.a = zzazeVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdqv
            public final Object a(Object obj) {
                return zzcqo.a(this.a, (SQLiteDatabase) obj);
            }
        });
    }

    final void a(SQLiteDatabase sQLiteDatabase, zzaze zzazeVar, String str) {
        this.b.execute(new Runnable(sQLiteDatabase, str, zzazeVar) { // from class: com.google.android.gms.internal.ads.xm
            private final SQLiteDatabase a;
            private final String b;
            private final zzaze c;

            {
                this.a = sQLiteDatabase;
                this.b = str;
                this.c = zzazeVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzcqo.a(this.a, this.b, this.c);
            }
        });
    }

    public final void a(zzaze zzazeVar, String str) {
        a(new zzdqv(this, zzazeVar, str) { // from class: com.google.android.gms.internal.ads.xp
            private final zzcqo a;
            private final zzaze b;
            private final String c;

            {
                this.a = this;
                this.b = zzazeVar;
                this.c = str;
            }

            @Override // com.google.android.gms.internal.ads.zzdqv
            public final Object a(Object obj) {
                return this.a.a(this.b, this.c, (SQLiteDatabase) obj);
            }
        });
    }

    static void a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.delete("offline_buffered_pings", "gws_query_id = ? AND event_state = ?", new String[]{str, Integer.toString(0)});
    }

    public final void a(String str) {
        a(new zzdqv(this, str) { // from class: com.google.android.gms.internal.ads.xo
            private final zzcqo a;
            private final String b;

            {
                this.a = this;
                this.b = str;
            }

            @Override // com.google.android.gms.internal.ads.zzdqv
            public final Object a(Object obj) {
                zzcqo.a((SQLiteDatabase) obj, this.b);
                return null;
            }
        });
    }

    public final void a(zzcqv zzcqvVar) {
        a(new zzdqv(this, zzcqvVar) { // from class: com.google.android.gms.internal.ads.xr
            private final zzcqo a;
            private final zzcqv b;

            {
                this.a = this;
                this.b = zzcqvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdqv
            public final Object a(Object obj) {
                return this.a.a(this.b, (SQLiteDatabase) obj);
            }
        });
    }

    final /* synthetic */ Void a(zzcqv zzcqvVar, SQLiteDatabase sQLiteDatabase) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzcqvVar.a));
        contentValues.put("gws_query_id", zzcqvVar.b);
        contentValues.put("url", zzcqvVar.c);
        contentValues.put("event_state", Integer.valueOf(zzcqvVar.d - 1));
        sQLiteDatabase.insert("offline_buffered_pings", null, contentValues);
        zzp.c();
        com.google.android.gms.ads.internal.util.zzbf s = com.google.android.gms.ads.internal.util.zzm.s(this.a);
        if (s != null) {
            try {
                s.zzap(ObjectWrapper.a(this.a));
            } catch (RemoteException e) {
                zzd.a("Failed to schedule offline ping sender.", e);
            }
        }
        return null;
    }

    final /* synthetic */ Void a(zzaze zzazeVar, String str, SQLiteDatabase sQLiteDatabase) throws Exception {
        a(sQLiteDatabase, zzazeVar, str);
        return null;
    }

    static final /* synthetic */ void a(SQLiteDatabase sQLiteDatabase, String str, zzaze zzazeVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_state", (Integer) 1);
        sQLiteDatabase.update("offline_buffered_pings", contentValues, "gws_query_id = ?", new String[]{str});
        a(sQLiteDatabase, zzazeVar);
    }

    static final /* synthetic */ Void a(zzaze zzazeVar, SQLiteDatabase sQLiteDatabase) throws Exception {
        a(sQLiteDatabase, zzazeVar);
        return null;
    }
}
