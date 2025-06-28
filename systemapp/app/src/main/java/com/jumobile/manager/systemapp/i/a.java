package com.jumobile.manager.systemapp.i;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.jumobile.manager.systemapp.util.f;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class a extends Thread {
    private static final String a = "a";
    private int b = 0;
    private String c = Environment.getExternalStorageDirectory().getAbsolutePath();
    private ArrayList<String> d = new ArrayList<>();
    private ArrayList<String> e = new ArrayList<>();
    private boolean f = true;
    private InterfaceC0090a g;
    private final Context h;
    private b i;

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.i.a$a */
    public interface InterfaceC0090a {
        void a(String str);
    }

    /* compiled from: source */
    public interface b {
        void a(int i);

        void a(com.jumobile.manager.systemapp.d.a aVar);

        boolean a();

        void b();

        void c();
    }

    public void a(boolean z) {
        this.f = z;
    }

    public a(Context context, b bVar) {
        this.i = null;
        this.h = context;
        this.i = bVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        Process.setThreadPriority(10);
        this.i.b();
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            this.i.a(9);
            return;
        }
        HashSet<String> hashSet = new HashSet<>();
        List<String> l = f.l(this.h, "apkfile.cache");
        if (l != null) {
            for (String str : l) {
                if (this.i.a()) {
                    this.i.a(2);
                    return;
                } else if (new File(str).exists()) {
                    com.jumobile.manager.systemapp.d.a aVar = new com.jumobile.manager.systemapp.d.a(str);
                    if (aVar.a(this.h)) {
                        this.i.a(aVar);
                        hashSet.add(str);
                    } else if (this.g != null) {
                        this.g.a(str);
                    }
                }
            }
        }
        if (hashSet.size() > 0) {
            this.i.c();
        }
        List<String> f = f.f(this.h, "apkdir.conf");
        if (f != null) {
            Iterator<String> it = f.iterator();
            while (it.hasNext()) {
                String[] split = it.next().split(";");
                if (split[0].equals("1")) {
                    this.d.add(split[1]);
                } else if (split[0].equals("0")) {
                    this.e.add(split[1]);
                }
            }
        }
        Iterator<String> it2 = a(this.h).iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            File file = new File(next);
            if (file.exists()) {
                this.c = file.getPath();
                a(new File(next), 0, hashSet);
            }
        }
        if (2 == this.b) {
            this.i.a(2);
            return;
        }
        this.i.a(0);
        f.a(this.h, "apkfile.cache", new ArrayList(hashSet));
    }

    public static ArrayList<String> a(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                for (String str : (String[]) Class.forName("android.os.storage.StorageManager").getMethod("getVolumePaths", new Class[0]).invoke(context.getSystemService("storage"), new Object[0])) {
                    arrayList.add(str);
                }
            } else {
                String path = Environment.getExternalStorageDirectory().getPath();
                if (!TextUtils.isEmpty(path)) {
                    arrayList.add(path);
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/proc/mounts"))));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.contains("uid=1000") && readLine.contains("gid=1015") && !readLine.contains("asec")) {
                        String[] split = readLine.split(" ");
                        if (split.length >= 4) {
                            String str2 = split[1];
                            if (!arrayList.contains(str2)) {
                                arrayList.add(str2);
                            }
                        }
                    }
                }
                bufferedReader.close();
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:7|(2:54|(1:56)(2:57|(5:59|10|11|12|(1:14)(4:15|(2:17|(3:46|47|48)(3:19|(4:21|(3:23|(2:25|(1:27)(2:28|(1:30)))|31)|32|(2:36|37))(2:41|(2:43|44)(1:45))|39))|49|50))))|9|10|11|12|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0025, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0026, code lost:
    
        android.util.Log.e(com.jumobile.manager.systemapp.i.a.a, "xxx", r9);
        r9 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0030 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.io.File r9, int r10, java.util.HashSet<java.lang.String> r11) {
        /*
            r8 = this;
            boolean r0 = r8.f
            if (r0 == 0) goto L8
            r0 = 5
            if (r10 <= r0) goto L8
            return
        L8:
            boolean r0 = r8.f
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
        Le:
            r0 = r2
            goto L1f
        L10:
            boolean r0 = r8.b(r9)
            if (r0 == 0) goto L17
            return
        L17:
            boolean r0 = r8.a(r9)
            if (r0 == 0) goto L1e
            goto Le
        L1e:
            r0 = r1
        L1f:
            r3 = 0
            java.io.File[] r9 = r9.listFiles()     // Catch: java.lang.Exception -> L25
            goto L2e
        L25:
            r9 = move-exception
            java.lang.String r4 = com.jumobile.manager.systemapp.i.a.a
            java.lang.String r5 = "xxx"
            android.util.Log.e(r4, r5, r9)
            r9 = r3
        L2e:
            if (r9 != 0) goto L31
            return
        L31:
            int r3 = r9.length
            r4 = r1
        L33:
            if (r1 >= r3) goto La6
            r5 = r9[r1]
            com.jumobile.manager.systemapp.i.a$b r6 = r8.i
            boolean r6 = r6.a()
            if (r6 == 0) goto L43
            r9 = 2
            r8.b = r9
            return
        L43:
            boolean r6 = r5.isFile()
            if (r6 == 0) goto L98
            java.lang.String r6 = r5.getName()
            java.lang.String r6 = r6.toLowerCase()
            java.lang.String r7 = ".apk"
            boolean r6 = r6.endsWith(r7)
            if (r6 == 0) goto L8f
            java.lang.String r0 = r5.getPath()
            boolean r0 = r11.contains(r0)
            if (r0 != 0) goto L8e
            com.jumobile.manager.systemapp.d.a r0 = new com.jumobile.manager.systemapp.d.a
            java.lang.String r6 = r5.getPath()
            r0.<init>(r6)
            android.content.Context r6 = r8.h
            boolean r6 = r0.a(r6)
            if (r6 == 0) goto L81
            com.jumobile.manager.systemapp.i.a$b r6 = r8.i
            r6.a(r0)
            java.lang.String r0 = r5.getPath()
            r11.add(r0)
            goto L8e
        L81:
            com.jumobile.manager.systemapp.i.a$a r0 = r8.g
            if (r0 == 0) goto L8e
            com.jumobile.manager.systemapp.i.a$a r0 = r8.g
            java.lang.String r5 = r5.getPath()
            r0.a(r5)
        L8e:
            r0 = r2
        L8f:
            int r4 = r4 + 1
            if (r0 != 0) goto La3
            r5 = 10
            if (r4 < r5) goto La3
            return
        L98:
            boolean r6 = r5.isDirectory()
            if (r6 == 0) goto La3
            int r6 = r10 + 1
            r8.a(r5, r6, r11)
        La3:
            int r1 = r1 + 1
            goto L33
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumobile.manager.systemapp.i.a.a(java.io.File, int, java.util.HashSet):void");
    }

    private boolean a(File file) {
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.endsWith(this.c)) {
            return true;
        }
        return this.d.contains(absolutePath.substring(this.c.length()));
    }

    private boolean b(File file) {
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.endsWith(this.c)) {
            return false;
        }
        return this.e.contains(absolutePath.substring(this.c.length()));
    }
}
