package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public final class DynamiteModule {

    @GuardedBy("DynamiteModule.class")
    private static Boolean g = null;

    @GuardedBy("DynamiteModule.class")
    private static zzk h = null;

    @GuardedBy("DynamiteModule.class")
    private static zzm i = null;

    @GuardedBy("DynamiteModule.class")
    private static String j = null;

    @GuardedBy("DynamiteModule.class")
    private static int k = -1;
    private final Context o;
    private static final ThreadLocal<a> l = new ThreadLocal<>();
    private static final VersionPolicy.zzb m = new com.google.android.gms.dynamite.b();

    @KeepForSdk
    public static final VersionPolicy a = new com.google.android.gms.dynamite.a();

    @KeepForSdk
    public static final VersionPolicy b = new d();

    @KeepForSdk
    public static final VersionPolicy c = new c();

    @KeepForSdk
    public static final VersionPolicy d = new f();

    @KeepForSdk
    public static final VersionPolicy e = new e();

    @KeepForSdk
    public static final VersionPolicy f = new h();
    private static final VersionPolicy n = new g();

    /* compiled from: source */
    @DynamiteApi
    public static class DynamiteLoaderClassLoader {

        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    /* compiled from: source */
    public interface VersionPolicy {

        /* compiled from: source */
        public static class zza {
            public int a = 0;
            public int b = 0;
            public int c = 0;
        }

        /* compiled from: source */
        public interface zzb {
            int a(Context context, String str);

            int a(Context context, String str, boolean z) throws LoadingException;
        }

        zza a(Context context, String str, zzb zzbVar) throws LoadingException;
    }

    /* compiled from: source */
    private static class a {
        public Cursor a;

        private a() {
        }

        /* synthetic */ a(com.google.android.gms.dynamite.b bVar) {
            this();
        }
    }

    @KeepForSdk
    public static DynamiteModule a(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        a aVar = l.get();
        a aVar2 = new a(null);
        l.set(aVar2);
        try {
            VersionPolicy.zza a2 = versionPolicy.a(context, str, m);
            int i2 = a2.a;
            int i3 = a2.b;
            StringBuilder sb = new StringBuilder(68 + String.valueOf(str).length() + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i2);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i3);
            Log.i("DynamiteModule", sb.toString());
            if (a2.c != 0 && ((a2.c != -1 || a2.a != 0) && (a2.c != 1 || a2.b != 0))) {
                if (a2.c == -1) {
                    DynamiteModule c2 = c(context, str);
                    if (aVar2.a != null) {
                        aVar2.a.close();
                    }
                    l.set(aVar);
                    return c2;
                }
                if (a2.c != 1) {
                    int i4 = a2.c;
                    StringBuilder sb2 = new StringBuilder(47);
                    sb2.append("VersionPolicy returned invalid code:");
                    sb2.append(i4);
                    throw new LoadingException(sb2.toString(), (com.google.android.gms.dynamite.b) null);
                }
                try {
                    DynamiteModule a3 = a(context, str, a2.b);
                    if (aVar2.a != null) {
                        aVar2.a.close();
                    }
                    l.set(aVar);
                    return a3;
                } catch (LoadingException e2) {
                    String valueOf = String.valueOf(e2.getMessage());
                    Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
                    if (a2.a == 0 || versionPolicy.a(context, str, new b(a2.a, 0)).c != -1) {
                        throw new LoadingException("Remote load failed. No local fallback found.", e2, null);
                    }
                    DynamiteModule c3 = c(context, str);
                    if (aVar2.a != null) {
                        aVar2.a.close();
                    }
                    l.set(aVar);
                    return c3;
                }
            }
            int i5 = a2.a;
            int i6 = a2.b;
            StringBuilder sb3 = new StringBuilder(91);
            sb3.append("No acceptable module found. Local version is ");
            sb3.append(i5);
            sb3.append(" and remote version is ");
            sb3.append(i6);
            sb3.append(".");
            throw new LoadingException(sb3.toString(), (com.google.android.gms.dynamite.b) null);
        } catch (Throwable th) {
            if (aVar2.a != null) {
                aVar2.a.close();
            }
            l.set(aVar);
            throw th;
        }
    }

    /* compiled from: source */
    @KeepForSdk
    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, com.google.android.gms.dynamite.b bVar) {
            this(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, com.google.android.gms.dynamite.b bVar) {
            this(str, th);
        }
    }

    /* compiled from: source */
    private static class b implements VersionPolicy.zzb {
        private final int a;
        private final int b = 0;

        public b(int i, int i2) {
            this.a = i;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb
        public final int a(Context context, String str, boolean z) {
            return 0;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb
        public final int a(Context context, String str) {
            return this.a;
        }
    }

    @KeepForSdk
    public static int a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(61 + String.valueOf(str).length());
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (!declaredField.get(null).equals(str)) {
                String valueOf = String.valueOf(declaredField.get(null));
                StringBuilder sb2 = new StringBuilder(51 + String.valueOf(valueOf).length() + String.valueOf(str).length());
                sb2.append("Module descriptor id '");
                sb2.append(valueOf);
                sb2.append("' didn't match expected id '");
                sb2.append(str);
                sb2.append("'");
                Log.e("DynamiteModule", sb2.toString());
                return 0;
            }
            return declaredField2.getInt(null);
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(45 + String.valueOf(str).length());
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    public static int a(Context context, String str, boolean z) {
        Field declaredField;
        ClassLoader iVar;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = g;
                if (bool == null) {
                    try {
                        declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        String valueOf = String.valueOf(e2);
                        StringBuilder sb = new StringBuilder(30 + String.valueOf(valueOf).length());
                        sb.append("Failed to load module via V2: ");
                        sb.append(valueOf);
                        Log.w("DynamiteModule", sb.toString());
                        bool = Boolean.FALSE;
                    }
                    synchronized (declaredField.getDeclaringClass()) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader != null) {
                            if (classLoader == ClassLoader.getSystemClassLoader()) {
                                bool = Boolean.FALSE;
                            } else {
                                try {
                                    a(classLoader);
                                } catch (LoadingException unused) {
                                }
                                bool = Boolean.TRUE;
                            }
                        } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                            bool = Boolean.FALSE;
                        } else {
                            try {
                                int c2 = c(context, str, z);
                                if (j != null && !j.isEmpty()) {
                                    if (Build.VERSION.SDK_INT >= 29) {
                                        iVar = new DelegateLastClassLoader(j, ClassLoader.getSystemClassLoader());
                                    } else {
                                        iVar = new i(j, ClassLoader.getSystemClassLoader());
                                    }
                                    a(iVar);
                                    declaredField.set(null, iVar);
                                    g = Boolean.TRUE;
                                    return c2;
                                }
                                return c2;
                            } catch (LoadingException unused2) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                            }
                        }
                        g = bool;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return c(context, str, z);
                    } catch (LoadingException e3) {
                        String valueOf2 = String.valueOf(e3.getMessage());
                        Log.w("DynamiteModule", valueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf2) : new String("Failed to retrieve remote module version: "));
                        return 0;
                    }
                }
                return b(context, str, z);
            }
        } catch (Throwable th) {
            CrashUtils.a(context, th);
            throw th;
        }
    }

    private static int b(Context context, String str, boolean z) {
        zzk a2 = a(context);
        if (a2 == null) {
            return 0;
        }
        try {
            if (a2.a() >= 2) {
                return a2.b(ObjectWrapper.a(context), str, z);
            }
            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
            return a2.a(ObjectWrapper.a(context), str, z);
        } catch (RemoteException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int c(android.content.Context r8, java.lang.String r9, boolean r10) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La3
            if (r10 == 0) goto La
            java.lang.String r8 = "api_force_staging"
            goto Lc
        La:
            java.lang.String r8 = "api"
        Lc:
            r10 = 42
            java.lang.String r2 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La3
            int r2 = r2.length()     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La3
            int r10 = r10 + r2
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La3
            int r2 = r2.length()     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La3
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La3
            r2.<init>(r10)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La3
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La3
            r2.append(r8)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La3
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La3
            r2.append(r9)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La3
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La3
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La3
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La3
            if (r8 == 0) goto L92
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8d
            if (r9 != 0) goto L4e
            goto L92
        L4e:
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8d
            if (r9 <= 0) goto L83
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8d
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch: java.lang.Throwable -> L80
            com.google.android.gms.dynamite.DynamiteModule.j = r1     // Catch: java.lang.Throwable -> L80
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L80
            if (r1 < 0) goto L6d
            int r1 = r8.getInt(r1)     // Catch: java.lang.Throwable -> L80
            com.google.android.gms.dynamite.DynamiteModule.k = r1     // Catch: java.lang.Throwable -> L80
        L6d:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L80
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$a> r10 = com.google.android.gms.dynamite.DynamiteModule.l     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8d
            java.lang.Object r10 = r10.get()     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8d
            com.google.android.gms.dynamite.DynamiteModule$a r10 = (com.google.android.gms.dynamite.DynamiteModule.a) r10     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8d
            if (r10 == 0) goto L83
            android.database.Cursor r1 = r10.a     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8d
            if (r1 != 0) goto L83
            r10.a = r8     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8d
            r8 = r0
            goto L83
        L80:
            r9 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L80
            throw r9     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8d
        L83:
            if (r8 == 0) goto L88
            r8.close()
        L88:
            return r9
        L89:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto Lb4
        L8d:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto La5
        L92:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8d
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r9 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8d
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>(r10, r0)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8d
            throw r9     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8d
        La1:
            r8 = move-exception
            goto Lb4
        La3:
            r8 = move-exception
            r9 = r0
        La5:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch: java.lang.Throwable -> Lb2
            if (r10 == 0) goto Laa
            throw r8     // Catch: java.lang.Throwable -> Lb2
        Laa:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch: java.lang.Throwable -> Lb2
            throw r10     // Catch: java.lang.Throwable -> Lb2
        Lb2:
            r8 = move-exception
            r0 = r9
        Lb4:
            if (r0 == 0) goto Lb9
            r0.close()
        Lb9:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.c(android.content.Context, java.lang.String, boolean):int");
    }

    @KeepForSdk
    public static int b(Context context, String str) {
        return a(context, str, false);
    }

    private static DynamiteModule c(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static DynamiteModule a(Context context, String str, int i2) throws LoadingException {
        Boolean bool;
        IObjectWrapper a2;
        try {
            synchronized (DynamiteModule.class) {
                bool = g;
            }
            if (bool == null) {
                throw new LoadingException("Failed to determine which loading route to use.", (com.google.android.gms.dynamite.b) null);
            }
            if (bool.booleanValue()) {
                return b(context, str, i2);
            }
            StringBuilder sb = new StringBuilder(51 + String.valueOf(str).length());
            sb.append("Selected remote version of ");
            sb.append(str);
            sb.append(", version >= ");
            sb.append(i2);
            Log.i("DynamiteModule", sb.toString());
            zzk a3 = a(context);
            if (a3 == null) {
                throw new LoadingException("Failed to create IDynamiteLoader.", (com.google.android.gms.dynamite.b) null);
            }
            if (a3.a() >= 2) {
                a2 = a3.b(ObjectWrapper.a(context), str, i2);
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                a2 = a3.a(ObjectWrapper.a(context), str, i2);
            }
            if (ObjectWrapper.a(a2) == null) {
                throw new LoadingException("Failed to load remote module.", (com.google.android.gms.dynamite.b) null);
            }
            return new DynamiteModule((Context) ObjectWrapper.a(a2));
        } catch (RemoteException e2) {
            throw new LoadingException("Failed to load remote module.", e2, null);
        } catch (LoadingException e3) {
            throw e3;
        } catch (Throwable th) {
            CrashUtils.a(context, th);
            throw new LoadingException("Failed to load remote module.", th, null);
        }
    }

    private static zzk a(Context context) {
        zzk zzjVar;
        synchronized (DynamiteModule.class) {
            if (h != null) {
                return h;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzjVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof zzk) {
                        zzjVar = (zzk) queryLocalInterface;
                    } else {
                        zzjVar = new zzj(iBinder);
                    }
                }
                if (zzjVar != null) {
                    h = zzjVar;
                    return zzjVar;
                }
            } catch (Exception e2) {
                String valueOf = String.valueOf(e2.getMessage());
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
            return null;
        }
    }

    @KeepForSdk
    public final Context a() {
        return this.o;
    }

    private static DynamiteModule b(Context context, String str, int i2) throws LoadingException, RemoteException {
        zzm zzmVar;
        IObjectWrapper a2;
        StringBuilder sb = new StringBuilder(51 + String.valueOf(str).length());
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i2);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            zzmVar = i;
        }
        if (zzmVar == null) {
            throw new LoadingException("DynamiteLoaderV2 was not cached.", (com.google.android.gms.dynamite.b) null);
        }
        a aVar = l.get();
        if (aVar == null || aVar.a == null) {
            throw new LoadingException("No result cursor", (com.google.android.gms.dynamite.b) null);
        }
        Context applicationContext = context.getApplicationContext();
        Cursor cursor = aVar.a;
        ObjectWrapper.a((Object) null);
        if (b().booleanValue()) {
            Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
            a2 = zzmVar.b(ObjectWrapper.a(applicationContext), str, i2, ObjectWrapper.a(cursor));
        } else {
            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
            a2 = zzmVar.a(ObjectWrapper.a(applicationContext), str, i2, ObjectWrapper.a(cursor));
        }
        Context context2 = (Context) ObjectWrapper.a(a2);
        if (context2 == null) {
            throw new LoadingException("Failed to get module context", (com.google.android.gms.dynamite.b) null);
        }
        return new DynamiteModule(context2);
    }

    private static Boolean b() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(k >= 2);
        }
        return valueOf;
    }

    @GuardedBy("DynamiteModule.class")
    private static void a(ClassLoader classLoader) throws LoadingException {
        zzm zzlVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzlVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzm) {
                    zzlVar = (zzm) queryLocalInterface;
                } else {
                    zzlVar = new zzl(iBinder);
                }
            }
            i = zzlVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to instantiate dynamite loader", e2, null);
        }
    }

    @KeepForSdk
    public final IBinder a(String str) throws LoadingException {
        try {
            return (IBinder) this.o.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            String valueOf = String.valueOf(str);
            throw new LoadingException(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e2, null);
        }
    }

    private DynamiteModule(Context context) {
        this.o = (Context) Preconditions.a(context);
    }
}
