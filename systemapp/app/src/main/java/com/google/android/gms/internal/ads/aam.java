package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
final class aam {
    private static boolean b = false;
    private static MessageDigest c;
    private static final Object d = new Object();
    private static final Object e = new Object();
    static CountDownLatch a = new CountDownLatch(1);

    static void a() {
        synchronized (e) {
            if (!b) {
                b = true;
                new Thread(new abo()).start();
            }
        }
    }

    private static MessageDigest b() {
        boolean z;
        a();
        try {
            z = a.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            z = false;
        }
        if (z && c != null) {
            return c;
        }
        return null;
    }

    static String a(zzcf.zza zzaVar, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] a2;
        byte[] l = zzaVar.l();
        if (!((Boolean) zzwq.e().a(zzabf.bn)).booleanValue()) {
            if (axm.a == null) {
                throw new GeneralSecurityException();
            }
            a2 = ((zzcf.zzf) ((zzekh) zzcf.zzf.a().a(zzeiu.a(axm.a.a(l, str != null ? str.getBytes() : new byte[0]))).a(zzcm.TINK_HYBRID).g())).l();
        } else {
            Vector<byte[]> a3 = a(l, 255);
            if (a3 == null || a3.size() == 0) {
                a2 = a(a(zzcf.zza.zzd.PSN_ENCODE_SIZE_FAIL).l(), str, true);
            } else {
                zzcf.zzf.zza a4 = zzcf.zzf.a();
                Iterator<byte[]> it = a3.iterator();
                while (it.hasNext()) {
                    a4.a(zzeiu.a(a(it.next(), str, false)));
                }
                a4.b(zzeiu.a(a(l)));
                a2 = ((zzcf.zzf) ((zzekh) a4.g())).l();
            }
        }
        return zzcv.a(a2, true);
    }

    private static Vector<byte[]> a(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    private static zzcf.zza a(zzcf.zza.zzd zzdVar) {
        zzcf.zza.C0060zza h = zzcf.zza.h();
        h.j(zzdVar.a());
        return (zzcf.zza) ((zzekh) h.g());
    }

    private static byte[] a(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] array;
        int i = z ? 239 : 255;
        if (bArr.length > i) {
            bArr = a(zzcf.zza.zzd.PSN_ENCODE_SIZE_FAIL).l();
        }
        if (bArr.length < i) {
            byte[] bArr2 = new byte[i - bArr.length];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            array = ByteBuffer.allocate(256).put(a(array)).put(array).array();
        }
        byte[] bArr3 = new byte[256];
        for (adt adtVar : new zzdc().cN) {
            adtVar.a(array, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzeil(str.getBytes("UTF-8")).a(bArr3);
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (d) {
            MessageDigest b2 = b();
            if (b2 == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            b2.reset();
            b2.update(bArr);
            digest = c.digest();
        }
        return digest;
    }
}
