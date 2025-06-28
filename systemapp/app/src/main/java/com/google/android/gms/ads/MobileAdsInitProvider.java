package com.google.android.gms.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.internal.ads.zzzj;

/* compiled from: source */
@KeepForSdkWithMembers
/* loaded from: classes.dex */
public class MobileAdsInitProvider extends ContentProvider {
    private final zzzj a = new zzzj();

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.a.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return this.a.onCreate();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.a.query(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return this.a.getType(uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.a.insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.a.delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.a.update(uri, contentValues, str, strArr);
    }
}
