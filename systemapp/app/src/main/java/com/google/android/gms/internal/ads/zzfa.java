package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzcf;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzfa {
    private static final String b = "zzfa";
    protected Context a;
    private ExecutorService c;
    private DexClassLoader d;
    private zzeh e;
    private byte[] f;
    private boolean j;
    private zzdt m;
    private Map<Pair<String, String>, zzgj> p;
    private zzey r;
    private volatile AdvertisingIdClient g = null;
    private volatile boolean h = false;
    private Future i = null;
    private volatile zzcf.zza k = null;
    private Future l = null;
    private boolean n = false;
    private boolean o = false;
    private boolean q = false;

    public static zzfa a(Context context, String str, String str2, boolean z) {
        zzfa zzfaVar = new zzfa(context);
        try {
            zzfaVar.c = Executors.newCachedThreadPool(new axi());
            zzfaVar.h = z;
            if (z) {
                zzfaVar.i = zzfaVar.c.submit(new axl(zzfaVar));
            }
            zzfaVar.c.execute(new axn(zzfaVar));
            try {
                GoogleApiAvailabilityLight a = GoogleApiAvailabilityLight.a();
                zzfaVar.n = a.b(zzfaVar.a) > 0;
                zzfaVar.o = a.a(zzfaVar.a) == 0;
            } catch (Throwable unused) {
            }
            zzfaVar.a(0, true);
        } catch (zzet unused2) {
        }
        if (zzff.a() && ((Boolean) zzwq.e().a(zzabf.bo)).booleanValue()) {
            throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
        }
        zzfaVar.e = new zzeh(null);
        try {
            zzfaVar.f = zzfaVar.e.a(str);
            try {
                try {
                    File cacheDir = zzfaVar.a.getCacheDir();
                    if (cacheDir == null && (cacheDir = zzfaVar.a.getDir("dex", 0)) == null) {
                        throw new zzet();
                    }
                    File file = new File(String.format("%s/%s.jar", cacheDir, "1596060835607"));
                    if (!file.exists()) {
                        byte[] a2 = zzfaVar.e.a(zzfaVar.f, str2);
                        file.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(a2, 0, a2.length);
                        fileOutputStream.close();
                    }
                    zzfaVar.b(cacheDir, "1596060835607");
                    try {
                        zzfaVar.d = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), null, zzfaVar.a.getClassLoader());
                        a(file);
                        zzfaVar.a(cacheDir, "1596060835607");
                        a(String.format("%s/%s.dex", cacheDir, "1596060835607"));
                        zzfaVar.m = new zzdt(zzfaVar);
                        zzfaVar.q = true;
                        return zzfaVar;
                    } catch (Throwable th) {
                        a(file);
                        zzfaVar.a(cacheDir, "1596060835607");
                        a(String.format("%s/%s.dex", cacheDir, "1596060835607"));
                        throw th;
                    }
                } catch (zzek e) {
                    throw new zzet(e);
                } catch (FileNotFoundException e2) {
                    throw new zzet(e2);
                }
            } catch (IOException e3) {
                throw new zzet(e3);
            } catch (NullPointerException e4) {
                throw new zzet(e4);
            }
        } catch (zzek e5) {
            throw new zzet(e5);
        }
    }

    public final Context a() {
        return this.a;
    }

    public final boolean b() {
        return this.q;
    }

    public final ExecutorService c() {
        return this.c;
    }

    public final DexClassLoader d() {
        return this.d;
    }

    public final zzeh e() {
        return this.e;
    }

    public final byte[] f() {
        return this.f;
    }

    public final boolean g() {
        return this.n;
    }

    public final zzdt h() {
        return this.m;
    }

    public final boolean i() {
        return this.o;
    }

    public final boolean j() {
        return this.r.a();
    }

    final zzey k() {
        return this.r;
    }

    public final zzcf.zza l() {
        return this.k;
    }

    public final Future m() {
        return this.l;
    }

    private zzfa(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.j = applicationContext != null;
        this.a = this.j ? applicationContext : context;
        this.p = new HashMap();
        if (this.r == null) {
            this.r = new zzey(this.a);
        }
    }

    private final void a(File file, String str) {
        FileInputStream fileInputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (file2.exists()) {
            return;
        }
        File file3 = new File(String.format("%s/%s.dex", file, str));
        if (!file3.exists()) {
            return;
        }
        long length = file3.length();
        if (length <= 0) {
            return;
        }
        byte[] bArr = new byte[(int) length];
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file3);
            try {
                try {
                    if (fileInputStream.read(bArr) <= 0) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                        a(file3);
                        return;
                    }
                    System.out.print("test");
                    System.out.print("test");
                    System.out.print("test");
                    zzcf.zzc.zza c = zzcf.zzc.e().d(zzeiu.a(Build.VERSION.SDK.getBytes())).c(zzeiu.a(str.getBytes()));
                    byte[] bytes = this.e.a(this.f, bArr).getBytes();
                    c.a(zzeiu.a(bytes)).b(zzeiu.a(aam.a(bytes)));
                    file2.createNewFile();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        byte[] l = ((zzcf.zzc) ((zzekh) c.g())).l();
                        fileOutputStream2.write(l, 0, l.length);
                        fileOutputStream2.close();
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused3) {
                        }
                        a(file3);
                    } catch (zzek | IOException | NoSuchAlgorithmException unused4) {
                        fileOutputStream = fileOutputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused6) {
                            }
                        }
                        a(file3);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused7) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused8) {
                            }
                        }
                        a(file3);
                        throw th;
                    }
                } catch (zzek | IOException | NoSuchAlgorithmException unused9) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (zzek | IOException | NoSuchAlgorithmException unused10) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    private static void a(String str) {
        a(new File(str));
    }

    private static void a(File file) {
        if (!file.exists()) {
            Log.d(b, String.format("File %s not found. No need for deletion", file.getAbsolutePath()));
        } else {
            file.delete();
        }
    }

    private final boolean b(File file, String str) {
        FileInputStream fileInputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (!file2.exists()) {
            return false;
        }
        File file3 = new File(String.format("%s/%s.dex", file, str));
        if (file3.exists()) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            long length = file2.length();
            if (length <= 0) {
                a(file2);
                return false;
            }
            byte[] bArr = new byte[(int) length];
            fileInputStream = new FileInputStream(file2);
            try {
                try {
                    if (fileInputStream.read(bArr) <= 0) {
                        Log.d(b, "Cannot read the cache data.");
                        a(file2);
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                        return false;
                    }
                    zzcf.zzc a = zzcf.zzc.a(bArr, zzeju.b());
                    if (str.equals(new String(a.c().d())) && Arrays.equals(a.b().d(), aam.a(a.a().d())) && Arrays.equals(a.d().d(), Build.VERSION.SDK.getBytes())) {
                        byte[] a2 = this.e.a(this.f, new String(a.a().d()));
                        file3.createNewFile();
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                        try {
                            fileOutputStream2.write(a2, 0, a2.length);
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused3) {
                            }
                            return true;
                        } catch (zzek | IOException | NoSuchAlgorithmException unused4) {
                            fileOutputStream = fileOutputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused5) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused6) {
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused7) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    throw th;
                                } catch (IOException unused8) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    }
                    a(file2);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused9) {
                    }
                    return false;
                } catch (zzek | IOException | NoSuchAlgorithmException unused10) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (zzek | IOException | NoSuchAlgorithmException unused11) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public final boolean a(String str, String str2, Class<?>... clsArr) {
        if (this.p.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.p.put(new Pair<>(str, str2), new zzgj(this, str, str2, clsArr));
        return true;
    }

    public final Method a(String str, String str2) {
        zzgj zzgjVar = this.p.get(new Pair(str, str2));
        if (zzgjVar == null) {
            return null;
        }
        return zzgjVar.a();
    }

    public final void p() {
        try {
            if (this.g == null && this.j) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.a);
                advertisingIdClient.start();
                this.g = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.g = null;
        }
    }

    final void a(int i, boolean z) {
        if (this.o) {
            Future<?> submit = this.c.submit(new axk(this, i, z));
            if (i == 0) {
                this.l = submit;
            }
        }
    }

    final zzcf.zza b(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException unused) {
            }
        }
        return q();
    }

    public static boolean b(int i, zzcf.zza zzaVar) {
        if (i < 4) {
            return zzaVar == null || !zzaVar.a() || zzaVar.b().equals("0000000000000000000000000000000000000000000000000000000000000000") || !zzaVar.f() || !zzaVar.g().a() || zzaVar.g().b() == -2;
        }
        return false;
    }

    private final zzcf.zza q() {
        try {
            return zzdsp.a(this.a, this.a.getPackageName(), Integer.toString(this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final AdvertisingIdClient n() {
        if (!this.h) {
            return null;
        }
        if (this.g != null) {
            return this.g;
        }
        if (this.i != null) {
            try {
                this.i.get(2000L, TimeUnit.MILLISECONDS);
                this.i = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.i.cancel(true);
            }
        }
        return this.g;
    }

    public final int o() {
        if (this.m != null) {
            return zzdt.a();
        }
        return Integer.MIN_VALUE;
    }
}
