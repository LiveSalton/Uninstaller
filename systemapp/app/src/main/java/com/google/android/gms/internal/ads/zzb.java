package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzb {
    /* JADX WARN: Removed duplicated region for block: B:14:0x005a A[Catch: all -> 0x029a, TryCatch #2 {all -> 0x029a, blocks: (B:3:0x0009, B:5:0x000f, B:6:0x0030, B:8:0x0031, B:10:0x0049, B:14:0x005a, B:15:0x0061, B:16:0x0062, B:18:0x006a, B:19:0x008a, B:20:0x008b, B:22:0x0094, B:23:0x009b, B:26:0x00a2, B:27:0x00ba, B:28:0x00bb, B:30:0x00ee, B:33:0x00ff, B:38:0x0115, B:40:0x0122, B:41:0x013a, B:42:0x013b, B:44:0x015e, B:45:0x0180, B:46:0x0181, B:48:0x019d, B:49:0x01a4, B:50:0x01a5, B:51:0x01b2, B:53:0x01b8, B:80:0x01c0, B:81:0x01d8, B:55:0x01d9, B:59:0x01eb, B:72:0x01f7, B:73:0x0223, B:61:0x0224, B:65:0x022d, B:63:0x024a, B:76:0x024f, B:77:0x026f, B:83:0x0270, B:84:0x0277, B:85:0x0278, B:86:0x0291, B:87:0x0292, B:88:0x0299), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0062 A[Catch: all -> 0x029a, TryCatch #2 {all -> 0x029a, blocks: (B:3:0x0009, B:5:0x000f, B:6:0x0030, B:8:0x0031, B:10:0x0049, B:14:0x005a, B:15:0x0061, B:16:0x0062, B:18:0x006a, B:19:0x008a, B:20:0x008b, B:22:0x0094, B:23:0x009b, B:26:0x00a2, B:27:0x00ba, B:28:0x00bb, B:30:0x00ee, B:33:0x00ff, B:38:0x0115, B:40:0x0122, B:41:0x013a, B:42:0x013b, B:44:0x015e, B:45:0x0180, B:46:0x0181, B:48:0x019d, B:49:0x01a4, B:50:0x01a5, B:51:0x01b2, B:53:0x01b8, B:80:0x01c0, B:81:0x01d8, B:55:0x01d9, B:59:0x01eb, B:72:0x01f7, B:73:0x0223, B:61:0x0224, B:65:0x022d, B:63:0x024a, B:76:0x024f, B:77:0x026f, B:83:0x0270, B:84:0x0277, B:85:0x0278, B:86:0x0291, B:87:0x0292, B:88:0x0299), top: B:2:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.security.cert.X509Certificate[][] a(java.lang.String r21) throws com.google.android.gms.internal.ads.zzh, java.lang.SecurityException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 672
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzb.a(java.lang.String):java.security.cert.X509Certificate[][]");
    }

    private static X509Certificate[][] a(FileChannel fileChannel, aof aofVar) throws SecurityException {
        ByteBuffer byteBuffer;
        long j;
        long j2;
        long j3;
        ByteBuffer byteBuffer2;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                byteBuffer = aofVar.a;
                ByteBuffer a = a(byteBuffer);
                int i = 0;
                while (a.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(a(a(a), hashMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        StringBuilder sb = new StringBuilder(48);
                        sb.append("Failed to parse/verify signer #");
                        sb.append(i);
                        sb.append(" block");
                        throw new SecurityException(sb.toString(), e);
                    }
                }
                if (i <= 0) {
                    throw new SecurityException("No signers found");
                }
                if (!hashMap.isEmpty()) {
                    j = aofVar.b;
                    j2 = aofVar.c;
                    j3 = aofVar.d;
                    byteBuffer2 = aofVar.e;
                    if (hashMap.isEmpty()) {
                        throw new SecurityException("No digests provided");
                    }
                    axj axjVar = new axj(fileChannel, 0L, j);
                    axj axjVar2 = new axj(fileChannel, j2, j3 - j2);
                    ByteBuffer duplicate = byteBuffer2.duplicate();
                    duplicate.order(ByteOrder.LITTLE_ENDIAN);
                    zzi.a(duplicate, j);
                    ace aceVar = new ace(duplicate);
                    int[] iArr = new int[hashMap.size()];
                    Iterator it = hashMap.keySet().iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        iArr[i2] = ((Integer) it.next()).intValue();
                        i2++;
                    }
                    try {
                        byte[][] a2 = a(iArr, new qi[]{axjVar, axjVar2, aceVar});
                        for (int i3 = 0; i3 < iArr.length; i3++) {
                            int i4 = iArr[i3];
                            if (!MessageDigest.isEqual((byte[]) hashMap.get(Integer.valueOf(i4)), a2[i3])) {
                                throw new SecurityException(String.valueOf(b(i4)).concat(" digest of contents did not verify"));
                            }
                        }
                        return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
                    } catch (DigestException e2) {
                        throw new SecurityException("Failed to compute digest(s) of contents", e2);
                    }
                }
                throw new SecurityException("No content digests found");
            } catch (IOException e3) {
                throw new SecurityException("Failed to read list of signers", e3);
            }
        } catch (CertificateException e4) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0016 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x004d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.security.cert.X509Certificate[] a(java.nio.ByteBuffer r22, java.util.Map<java.lang.Integer, byte[]> r23, java.security.cert.CertificateFactory r24) throws java.lang.SecurityException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 856
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzb.a(java.nio.ByteBuffer, java.util.Map, java.security.cert.CertificateFactory):java.security.cert.X509Certificate[]");
    }

    private static byte[][] a(int[] iArr, qi[] qiVarArr) throws DigestException {
        long j;
        qi[] qiVarArr2 = qiVarArr;
        long j2 = 0;
        int i = 0;
        int length = qiVarArr2.length;
        long j3 = 0;
        int i2 = 0;
        while (true) {
            j = 1048576;
            if (i2 >= length) {
                break;
            }
            j3 += ((qiVarArr2[i2].a() + 1048576) - 1) / 1048576;
            i2++;
        }
        if (j3 >= 2097151) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Too many chunks: ");
            sb.append(j3);
            throw new DigestException(sb.toString());
        }
        int i3 = (int) j3;
        byte[][] bArr = new byte[iArr.length][];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            byte[] bArr2 = new byte[5 + (c(iArr[i4]) * i3)];
            bArr2[0] = 90;
            a(i3, bArr2, 1);
            bArr[i4] = bArr2;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        MessageDigest[] messageDigestArr = new MessageDigest[iArr.length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            String b = b(iArr[i5]);
            try {
                messageDigestArr[i5] = MessageDigest.getInstance(b);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(String.valueOf(b).concat(" digest not supported"), e);
            }
        }
        int length2 = qiVarArr2.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length2) {
            qi qiVar = qiVarArr2[i6];
            long j4 = j2;
            int i8 = length2;
            long a = qiVar.a();
            while (a > j2) {
                int min = (int) Math.min(a, j);
                a(min, bArr3, 1);
                for (MessageDigest messageDigest : messageDigestArr) {
                    messageDigest.update(bArr3);
                }
                long j5 = j4;
                try {
                    qiVar.a(messageDigestArr, j5, min);
                    int i9 = 0;
                    while (i9 < iArr.length) {
                        int i10 = iArr[i9];
                        byte[] bArr4 = bArr3;
                        byte[] bArr5 = bArr[i9];
                        int c = c(i10);
                        qi qiVar2 = qiVar;
                        MessageDigest messageDigest2 = messageDigestArr[i9];
                        MessageDigest[] messageDigestArr2 = messageDigestArr;
                        int digest = messageDigest2.digest(bArr5, 5 + (i7 * c), c);
                        if (digest != c) {
                            String algorithm = messageDigest2.getAlgorithm();
                            StringBuilder sb2 = new StringBuilder(46 + String.valueOf(algorithm).length());
                            sb2.append("Unexpected output size of ");
                            sb2.append(algorithm);
                            sb2.append(" digest: ");
                            sb2.append(digest);
                            throw new RuntimeException(sb2.toString());
                        }
                        i9++;
                        bArr3 = bArr4;
                        qiVar = qiVar2;
                        messageDigestArr = messageDigestArr2;
                    }
                    long j6 = min;
                    j4 = j5 + j6;
                    a -= j6;
                    i7++;
                    j2 = 0;
                    j = 1048576;
                } catch (IOException e2) {
                    StringBuilder sb3 = new StringBuilder(59);
                    sb3.append("Failed to digest chunk #");
                    sb3.append(i7);
                    sb3.append(" of section #");
                    sb3.append(i);
                    throw new DigestException(sb3.toString(), e2);
                }
            }
            i++;
            i6++;
            length2 = i8;
            qiVarArr2 = qiVarArr;
            j2 = 0;
            j = 1048576;
        }
        byte[][] bArr6 = new byte[iArr.length][];
        for (int i11 = 0; i11 < iArr.length; i11++) {
            int i12 = iArr[i11];
            byte[] bArr7 = bArr[i11];
            String b2 = b(i12);
            try {
                bArr6[i11] = MessageDigest.getInstance(b2).digest(bArr7);
            } catch (NoSuchAlgorithmException e3) {
                throw new RuntimeException(String.valueOf(b2).concat(" digest not supported"), e3);
            }
        }
        return bArr6;
    }

    private static int a(int i) {
        if (i == 769) {
            return 1;
        }
        switch (i) {
            case 257:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                switch (i) {
                    case 513:
                        return 1;
                    case 514:
                        return 2;
                    default:
                        String valueOf = String.valueOf(Long.toHexString(i));
                        throw new IllegalArgumentException(valueOf.length() != 0 ? "Unknown signature algorithm: 0x".concat(valueOf) : new String("Unknown signature algorithm: 0x"));
                }
        }
    }

    private static String b(int i) {
        switch (i) {
            case 1:
                return "SHA-256";
            case 2:
                return "SHA-512";
            default:
                StringBuilder sb = new StringBuilder(44);
                sb.append("Unknown content digest algorthm: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
        }
    }

    private static int c(int i) {
        switch (i) {
            case 1:
                return 32;
            case 2:
                return 64;
            default:
                StringBuilder sb = new StringBuilder(44);
                sb.append("Unknown content digest algorthm: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
        }
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i, int i2) {
        if (i2 < 8) {
            StringBuilder sb = new StringBuilder(38);
            sb.append("end < start: ");
            sb.append(i2);
            sb.append(" < 8");
            throw new IllegalArgumentException(sb.toString());
        }
        int capacity = byteBuffer.capacity();
        if (i2 > byteBuffer.capacity()) {
            StringBuilder sb2 = new StringBuilder(41);
            sb2.append("end > capacity: ");
            sb2.append(i2);
            sb2.append(" > ");
            sb2.append(capacity);
            throw new IllegalArgumentException(sb2.toString());
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            byteBuffer.position(8);
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
        }
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        if (i < 0) {
            StringBuilder sb = new StringBuilder(17);
            sb.append("size: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i2 = i + position;
        if (i2 < position || i2 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    private static ByteBuffer a(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() < 4) {
            int remaining = byteBuffer.remaining();
            StringBuilder sb = new StringBuilder(93);
            sb.append("Remaining buffer too short to contain length of length-prefixed field. Remaining: ");
            sb.append(remaining);
            throw new IOException(sb.toString());
        }
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i > byteBuffer.remaining()) {
            int remaining2 = byteBuffer.remaining();
            StringBuilder sb2 = new StringBuilder(101);
            sb2.append("Length-prefixed field longer than remaining buffer. Field length: ");
            sb2.append(i);
            sb2.append(", remaining: ");
            sb2.append(remaining2);
            throw new IOException(sb2.toString());
        }
        return a(byteBuffer, i);
    }

    private static byte[] b(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        }
        if (i > byteBuffer.remaining()) {
            int remaining = byteBuffer.remaining();
            StringBuilder sb = new StringBuilder(90);
            sb.append("Underflow while reading length-prefixed value. Length: ");
            sb.append(i);
            sb.append(", available: ");
            sb.append(remaining);
            throw new IOException(sb.toString());
        }
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }

    private static void a(int i, byte[] bArr, int i2) {
        bArr[1] = (byte) i;
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) (i >>> 16);
        bArr[4] = (byte) (i >>> 24);
    }
}
