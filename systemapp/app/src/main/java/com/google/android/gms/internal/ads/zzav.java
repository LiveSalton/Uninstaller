package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzav implements zzk {
    private final Map<String, el> a;
    private long b;
    private final zzaz c;
    private final int d;

    public zzav(File file, int i) {
        this.a = new LinkedHashMap(16, 0.75f, true);
        this.b = 0L;
        this.c = new ez(this, file);
        this.d = 20971520;
    }

    private zzav(zzaz zzazVar, int i) {
        this.a = new LinkedHashMap(16, 0.75f, true);
        this.b = 0L;
        this.c = zzazVar;
        this.d = 5242880;
    }

    public zzav(zzaz zzazVar) {
        this(zzazVar, 5242880);
    }

    @Override // com.google.android.gms.internal.ads.zzk
    public final synchronized zzn a(String str) {
        el elVar = this.a.get(str);
        if (elVar == null) {
            return null;
        }
        File d = d(str);
        try {
            fv fvVar = new fv(new BufferedInputStream(a(d)), d.length());
            try {
                el a = el.a(fvVar);
                if (!TextUtils.equals(str, a.b)) {
                    zzaq.b("%s: key=%s, found=%s", d.getAbsolutePath(), str, a.b);
                    e(str);
                    return null;
                }
                byte[] a2 = a(fvVar, fvVar.a());
                zzn zznVar = new zzn();
                zznVar.a = a2;
                zznVar.b = elVar.c;
                zznVar.c = elVar.d;
                zznVar.d = elVar.e;
                zznVar.e = elVar.f;
                zznVar.f = elVar.g;
                List<zzu> list = elVar.h;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (zzu zzuVar : list) {
                    treeMap.put(zzuVar.a(), zzuVar.b());
                }
                zznVar.g = treeMap;
                zznVar.h = Collections.unmodifiableList(elVar.h);
                return zznVar;
            } finally {
                fvVar.close();
            }
        } catch (IOException e) {
            zzaq.b("%s: %s", d.getAbsolutePath(), e.toString());
            b(str);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzk
    public final synchronized void a() {
        long length;
        fv fvVar;
        File a = this.c.a();
        if (!a.exists()) {
            if (!a.mkdirs()) {
                zzaq.c("Unable to create cache dir %s", a.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = a.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            try {
                length = file.length();
                fvVar = new fv(new BufferedInputStream(a(file)), length);
            } catch (IOException unused) {
                file.delete();
            }
            try {
                el a2 = el.a(fvVar);
                a2.a = length;
                a(a2.b, a2);
                fvVar.close();
            } catch (Throwable th) {
                fvVar.close();
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzk
    public final synchronized void a(String str, boolean z) {
        zzn a = a(str);
        if (a != null) {
            a.f = 0L;
            a.e = 0L;
            a(str, a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzk
    public final synchronized void a(String str, zzn zznVar) {
        if (this.b + zznVar.a.length <= this.d || zznVar.a.length <= this.d * 0.9f) {
            File d = d(str);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(d));
                el elVar = new el(str, zznVar);
                if (!elVar.a(bufferedOutputStream)) {
                    bufferedOutputStream.close();
                    zzaq.b("Failed to write header for %s", d.getAbsolutePath());
                    throw new IOException();
                }
                bufferedOutputStream.write(zznVar.a);
                bufferedOutputStream.close();
                elVar.a = d.length();
                a(str, elVar);
                if (this.b >= this.d) {
                    if (zzaq.a) {
                        zzaq.a("Pruning old cache entries.", new Object[0]);
                    }
                    long j = this.b;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    Iterator<Map.Entry<String, el>> it = this.a.entrySet().iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        el value = it.next().getValue();
                        if (d(value.b).delete()) {
                            this.b -= value.a;
                        } else {
                            zzaq.b("Could not delete cache entry for key=%s, filename=%s", value.b, c(value.b));
                        }
                        it.remove();
                        i++;
                        if (this.b < this.d * 0.9f) {
                            break;
                        }
                    }
                    if (zzaq.a) {
                        zzaq.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                    }
                }
            } catch (IOException unused) {
                if (!d.delete()) {
                    zzaq.b("Could not clean up file %s", d.getAbsolutePath());
                }
                if (this.c.a().exists()) {
                    return;
                }
                zzaq.b("Re-initializing cache after external clearing.", new Object[0]);
                this.a.clear();
                this.b = 0L;
                a();
            }
        }
    }

    private final synchronized void b(String str) {
        boolean delete = d(str).delete();
        e(str);
        if (!delete) {
            zzaq.b("Could not delete cache entry for key=%s, filename=%s", str, c(str));
        }
    }

    private static String c(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private final File d(String str) {
        return new File(this.c.a(), c(str));
    }

    private final void a(String str, el elVar) {
        if (!this.a.containsKey(str)) {
            this.b += elVar.a;
        } else {
            this.b += elVar.a - this.a.get(str).a;
        }
        this.a.put(str, elVar);
    }

    private final void e(String str) {
        el remove = this.a.remove(str);
        if (remove != null) {
            this.b -= remove.a;
        }
    }

    private static byte[] a(fv fvVar, long j) throws IOException {
        long a = fvVar.a();
        if (j >= 0 && j <= a) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(fvVar).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb = new StringBuilder(73);
        sb.append("streamToBytes length=");
        sb.append(j);
        sb.append(", maxLength=");
        sb.append(a);
        throw new IOException(sb.toString());
    }

    private static InputStream a(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    private static int c(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read == -1) {
            throw new EOFException();
        }
        return read;
    }

    static void a(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write(i >>> 24);
    }

    static int a(InputStream inputStream) throws IOException {
        return (c(inputStream) << 24) | c(inputStream) | 0 | (c(inputStream) << 8) | (c(inputStream) << 16);
    }

    static void a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) j);
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static long b(InputStream inputStream) throws IOException {
        return (c(inputStream) & 255) | 0 | ((c(inputStream) & 255) << 8) | ((c(inputStream) & 255) << 16) | ((c(inputStream) & 255) << 24) | ((c(inputStream) & 255) << 32) | ((c(inputStream) & 255) << 40) | ((c(inputStream) & 255) << 48) | ((255 & c(inputStream)) << 56);
    }

    static void a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static String a(fv fvVar) throws IOException {
        return new String(a(fvVar, b((InputStream) fvVar)), "UTF-8");
    }

    static List<zzu> b(fv fvVar) throws IOException {
        int a = a((InputStream) fvVar);
        if (a < 0) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("readHeaderList size=");
            sb.append(a);
            throw new IOException(sb.toString());
        }
        List<zzu> emptyList = a == 0 ? Collections.emptyList() : new ArrayList<>();
        for (int i = 0; i < a; i++) {
            emptyList.add(new zzu(a(fvVar).intern(), a(fvVar).intern()));
        }
        return emptyList;
    }
}
