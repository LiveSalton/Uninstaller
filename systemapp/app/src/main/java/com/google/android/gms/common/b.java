package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class b extends zzn {
    private int a;

    protected b(byte[] bArr) {
        Preconditions.b(bArr.length == 25);
        this.a = Arrays.hashCode(bArr);
    }

    abstract byte[] c();

    public int hashCode() {
        return this.a;
    }

    public boolean equals(Object obj) {
        IObjectWrapper a;
        if (obj == null || !(obj instanceof zzl)) {
            return false;
        }
        try {
            zzl zzlVar = (zzl) obj;
            if (zzlVar.b() == hashCode() && (a = zzlVar.a()) != null) {
                return Arrays.equals(c(), (byte[]) ObjectWrapper.a(a));
            }
            return false;
        } catch (RemoteException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            return false;
        }
    }

    @Override // com.google.android.gms.common.internal.zzl
    public final IObjectWrapper a() {
        return ObjectWrapper.a(c());
    }

    @Override // com.google.android.gms.common.internal.zzl
    public final int b() {
        return hashCode();
    }

    protected static byte[] a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
