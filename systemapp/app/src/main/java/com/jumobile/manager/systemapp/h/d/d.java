package com.jumobile.manager.systemapp.h.d;

import android.content.Context;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class d {
    protected d() {
    }

    public static void a() {
        com.jumobile.manager.systemapp.h.a.a(new d());
    }

    public boolean b() throws TimeoutException {
        LineNumberReader lineNumberReader;
        FileReader fileReader;
        String readLine;
        FileReader fileReader2 = null;
        r0 = null;
        LineNumberReader lineNumberReader2 = null;
        try {
            if (!com.jumobile.manager.systemapp.h.a.a("/data/local/tmp")) {
                com.jumobile.manager.systemapp.h.c.b bVar = new com.jumobile.manager.systemapp.h.c.b(0, false, "mkdir /data/local/tmp");
                com.jumobile.manager.systemapp.h.c.c.h().a(bVar);
                a(bVar, 1000L);
            }
            b.f = new HashSet();
            String d = com.jumobile.manager.systemapp.h.a.d("/");
            com.jumobile.manager.systemapp.h.a.a("/", "rw");
            com.jumobile.manager.systemapp.h.c.c.h().a(new com.jumobile.manager.systemapp.h.c.b(0, false, "chmod 0777 /init.rc"));
            com.jumobile.manager.systemapp.h.c.c.h().a(new com.jumobile.manager.systemapp.h.c.b(0, false, "dd if=/init.rc of=/data/local/tmp/init.rc"));
            com.jumobile.manager.systemapp.h.c.b bVar2 = new com.jumobile.manager.systemapp.h.c.b(0, false, "chmod 0777 /data/local/tmp/init.rc");
            com.jumobile.manager.systemapp.h.c.c.h().a(bVar2);
            a(bVar2, 2000L);
            com.jumobile.manager.systemapp.h.a.a("/", d);
            FileReader fileReader3 = new FileReader("/data/local/tmp/init.rc");
            try {
                lineNumberReader = new LineNumberReader(fileReader3);
                do {
                    try {
                        readLine = lineNumberReader.readLine();
                        if (readLine == null) {
                            try {
                                fileReader3.close();
                            } catch (Exception unused) {
                            }
                            try {
                                lineNumberReader.close();
                            } catch (Exception unused2) {
                            }
                            return false;
                        }
                        com.jumobile.manager.systemapp.h.a.e(readLine);
                    } catch (Exception e) {
                        e = e;
                        lineNumberReader2 = lineNumberReader;
                        fileReader = fileReader3;
                        try {
                            if (com.jumobile.manager.systemapp.h.a.a) {
                                com.jumobile.manager.systemapp.h.a.e("Error: " + e.getMessage());
                                e.printStackTrace();
                            }
                            try {
                                fileReader.close();
                            } catch (Exception unused3) {
                            }
                            try {
                                lineNumberReader2.close();
                            } catch (Exception unused4) {
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            FileReader fileReader4 = fileReader;
                            lineNumberReader = lineNumberReader2;
                            fileReader2 = fileReader4;
                            try {
                                fileReader2.close();
                            } catch (Exception unused5) {
                            }
                            try {
                                lineNumberReader.close();
                                throw th;
                            } catch (Exception unused6) {
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileReader2 = fileReader3;
                        fileReader2.close();
                        lineNumberReader.close();
                        throw th;
                    }
                } while (!readLine.contains("export PATH"));
                b.f = new HashSet(Arrays.asList(readLine.substring(readLine.indexOf("/")).split(":")));
                try {
                    fileReader3.close();
                } catch (Exception unused7) {
                }
                try {
                    lineNumberReader.close();
                } catch (Exception unused8) {
                }
                return true;
            } catch (Exception e2) {
                fileReader = fileReader3;
                e = e2;
            } catch (Throwable th3) {
                th = th3;
                lineNumberReader = null;
            }
        } catch (Exception e3) {
            e = e3;
            fileReader = null;
        } catch (Throwable th4) {
            th = th4;
            lineNumberReader = null;
        }
    }

    public com.jumobile.manager.systemapp.h.a.b a(String str) {
        String str2 = str.split(" ")[0];
        if (str2.length() != 10) {
            return null;
        }
        if (str2.charAt(0) != '-' && str2.charAt(0) != 'd' && str2.charAt(0) != 'l') {
            return null;
        }
        if (str2.charAt(1) != '-' && str2.charAt(1) != 'r') {
            return null;
        }
        if (str2.charAt(2) != '-' && str2.charAt(2) != 'w') {
            return null;
        }
        com.jumobile.manager.systemapp.h.a.e(str2);
        com.jumobile.manager.systemapp.h.a.b bVar = new com.jumobile.manager.systemapp.h.a.b();
        bVar.b(str2.substring(0, 1));
        com.jumobile.manager.systemapp.h.a.e(bVar.a());
        bVar.c(str2.substring(1, 4));
        com.jumobile.manager.systemapp.h.a.e(bVar.c());
        bVar.d(str2.substring(4, 7));
        com.jumobile.manager.systemapp.h.a.e(bVar.d());
        bVar.e(str2.substring(7, 10));
        com.jumobile.manager.systemapp.h.a.e(bVar.e());
        StringBuilder sb = new StringBuilder();
        sb.append(c(str2));
        sb.append(b(bVar.c()));
        sb.append(b(bVar.d()));
        sb.append(b(bVar.e()));
        bVar.a(Integer.parseInt(sb.toString()));
        return bVar;
    }

    public int b(String str) {
        int i = str.charAt(0) == 'r' ? 4 : 0;
        com.jumobile.manager.systemapp.h.a.e("permission " + i);
        com.jumobile.manager.systemapp.h.a.e("character " + str.charAt(0));
        int i2 = str.charAt(1) == 'w' ? i + 2 : i + 0;
        com.jumobile.manager.systemapp.h.a.e("permission " + i2);
        com.jumobile.manager.systemapp.h.a.e("character " + str.charAt(1));
        int i3 = str.charAt(2) == 'x' ? i2 + 1 : i2 + 0;
        com.jumobile.manager.systemapp.h.a.e("permission " + i3);
        com.jumobile.manager.systemapp.h.a.e("character " + str.charAt(2));
        return i3;
    }

    public int c(String str) {
        int i = str.charAt(2) == 's' ? 4 : 0;
        if (str.charAt(5) == 's') {
            i += 2;
        }
        if (str.charAt(8) == 't') {
            i++;
        }
        com.jumobile.manager.systemapp.h.a.e("special permissions " + i);
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0079, code lost:
    
        if (r12.c() == 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x007b, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007d, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b5, code lost:
    
        if (r12.c() == 0) goto L81;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r9, java.lang.String r10, boolean r11, boolean r12, long r13) {
        /*
            Method dump skipped, instructions count: 449
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumobile.manager.systemapp.h.d.d.a(java.lang.String, java.lang.String, boolean, boolean, long):boolean");
    }

    public boolean d(String str) {
        String num;
        if (!com.jumobile.manager.systemapp.h.a.b(str)) {
            return false;
        }
        ArrayList<String> arrayList = new ArrayList();
        arrayList.addAll(com.jumobile.manager.systemapp.h.a.b);
        for (String str2 : arrayList) {
            com.jumobile.manager.systemapp.h.a.b c = com.jumobile.manager.systemapp.h.a.c(str2 + "/" + str);
            if (c != null) {
                if (Integer.toString(c.b()).length() > 3) {
                    num = Integer.toString(c.b()).substring(1);
                } else {
                    num = Integer.toString(c.b());
                }
                if (num.equals("755") || num.equals("777") || num.equals("775")) {
                    com.jumobile.manager.systemapp.h.a.c = str2 + "/" + str;
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00e9 A[Catch: Exception -> 0x001f, TRY_LEAVE, TryCatch #0 {Exception -> 0x001f, blocks: (B:32:0x0019, B:3:0x0022, B:5:0x002b, B:7:0x005a, B:10:0x00e9, B:19:0x0061, B:21:0x006b, B:23:0x009a, B:24:0x00a0, B:26:0x00a8, B:28:0x00b2, B:30:0x00e1), top: B:31:0x0019 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r7, boolean r8, long r9) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "'"
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = "'"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r0 = 0
            if (r8 == 0) goto L22
            java.lang.String r1 = "RW"
            com.jumobile.manager.systemapp.h.a.a(r7, r1)     // Catch: java.lang.Exception -> L1f
            goto L22
        L1f:
            r7 = move-exception
            goto Lf0
        L22:
            java.lang.String r1 = "rm"
            boolean r1 = r6.d(r1)     // Catch: java.lang.Exception -> L1f
            r2 = 1
            if (r1 == 0) goto L61
            java.lang.String r1 = "rm command is available!"
            com.jumobile.manager.systemapp.h.a.e(r1)     // Catch: java.lang.Exception -> L1f
            com.jumobile.manager.systemapp.h.c.b r1 = new com.jumobile.manager.systemapp.h.c.b     // Catch: java.lang.Exception -> L1f
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch: java.lang.Exception -> L1f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1f
            r4.<init>()     // Catch: java.lang.Exception -> L1f
            java.lang.String r5 = "rm -r "
            r4.append(r5)     // Catch: java.lang.Exception -> L1f
            r4.append(r7)     // Catch: java.lang.Exception -> L1f
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L1f
            r3[r0] = r4     // Catch: java.lang.Exception -> L1f
            r1.<init>(r0, r0, r3)     // Catch: java.lang.Exception -> L1f
            com.jumobile.manager.systemapp.h.c.c r3 = com.jumobile.manager.systemapp.h.c.c.h()     // Catch: java.lang.Exception -> L1f
            r3.a(r1)     // Catch: java.lang.Exception -> L1f
            r6.a(r1, r9)     // Catch: java.lang.Exception -> L1f
            int r9 = r1.c()     // Catch: java.lang.Exception -> L1f
            if (r9 == 0) goto Le7
            java.lang.String r9 = "target not exist or unable to delete file"
            com.jumobile.manager.systemapp.h.a.e(r9)     // Catch: java.lang.Exception -> L1f
            goto Le6
        L61:
            java.lang.String r1 = "rm"
            java.lang.String r3 = "toolbox"
            boolean r1 = r6.a(r1, r3)     // Catch: java.lang.Exception -> L1f
            if (r1 == 0) goto La0
            java.lang.String r1 = "rm command is available!"
            com.jumobile.manager.systemapp.h.a.e(r1)     // Catch: java.lang.Exception -> L1f
            com.jumobile.manager.systemapp.h.c.b r1 = new com.jumobile.manager.systemapp.h.c.b     // Catch: java.lang.Exception -> L1f
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch: java.lang.Exception -> L1f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1f
            r4.<init>()     // Catch: java.lang.Exception -> L1f
            java.lang.String r5 = "rm -r "
            r4.append(r5)     // Catch: java.lang.Exception -> L1f
            r4.append(r7)     // Catch: java.lang.Exception -> L1f
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L1f
            r3[r0] = r4     // Catch: java.lang.Exception -> L1f
            r1.<init>(r0, r0, r3)     // Catch: java.lang.Exception -> L1f
            com.jumobile.manager.systemapp.h.c.c r3 = com.jumobile.manager.systemapp.h.c.c.h()     // Catch: java.lang.Exception -> L1f
            r3.a(r1)     // Catch: java.lang.Exception -> L1f
            r6.a(r1, r9)     // Catch: java.lang.Exception -> L1f
            int r9 = r1.c()     // Catch: java.lang.Exception -> L1f
            if (r9 == 0) goto Le7
            java.lang.String r9 = "target not exist or unable to delete file"
            com.jumobile.manager.systemapp.h.a.e(r9)     // Catch: java.lang.Exception -> L1f
            goto Le6
        La0:
            java.lang.String r1 = "busybox"
            boolean r1 = r6.d(r1)     // Catch: java.lang.Exception -> L1f
            if (r1 == 0) goto Le7
            java.lang.String r1 = "rm"
            java.lang.String r3 = "busybox"
            boolean r1 = r6.a(r1, r3)     // Catch: java.lang.Exception -> L1f
            if (r1 == 0) goto Le7
            java.lang.String r1 = "busybox cp command is available!"
            com.jumobile.manager.systemapp.h.a.e(r1)     // Catch: java.lang.Exception -> L1f
            com.jumobile.manager.systemapp.h.c.b r1 = new com.jumobile.manager.systemapp.h.c.b     // Catch: java.lang.Exception -> L1f
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch: java.lang.Exception -> L1f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1f
            r4.<init>()     // Catch: java.lang.Exception -> L1f
            java.lang.String r5 = "busybox rm -rf "
            r4.append(r5)     // Catch: java.lang.Exception -> L1f
            r4.append(r7)     // Catch: java.lang.Exception -> L1f
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L1f
            r3[r0] = r4     // Catch: java.lang.Exception -> L1f
            r1.<init>(r0, r0, r3)     // Catch: java.lang.Exception -> L1f
            com.jumobile.manager.systemapp.h.c.c r3 = com.jumobile.manager.systemapp.h.c.c.h()     // Catch: java.lang.Exception -> L1f
            r3.a(r1)     // Catch: java.lang.Exception -> L1f
            r6.a(r1, r9)     // Catch: java.lang.Exception -> L1f
            int r9 = r1.c()     // Catch: java.lang.Exception -> L1f
            if (r9 == 0) goto Le7
            java.lang.String r9 = "target not exist or unable to delete file"
            com.jumobile.manager.systemapp.h.a.e(r9)     // Catch: java.lang.Exception -> L1f
        Le6:
            r2 = r0
        Le7:
            if (r8 == 0) goto Lee
            java.lang.String r8 = "RO"
            com.jumobile.manager.systemapp.h.a.a(r7, r8)     // Catch: java.lang.Exception -> L1f
        Lee:
            r0 = r2
            goto Lf3
        Lf0:
            r7.printStackTrace()
        Lf3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumobile.manager.systemapp.h.d.d.a(java.lang.String, boolean, long):boolean");
    }

    public boolean e(String str) {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = new com.jumobile.manager.systemapp.h.c.b(0, false, new String[]{"ls " + str}) { // from class: com.jumobile.manager.systemapp.h.d.d.1
            final /* synthetic */ List l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(int i, boolean z, String[] strArr, List arrayList2) {
                super(i, z, strArr);
                arrayList = arrayList2;
            }

            @Override // com.jumobile.manager.systemapp.h.c.a
            public void c(int i, String str2) {
                com.jumobile.manager.systemapp.h.a.e(str2);
                arrayList.add(str2);
            }
        };
        try {
            if (!com.jumobile.manager.systemapp.h.c.c.g()) {
                com.jumobile.manager.systemapp.h.c.c.i().a(anonymousClass1);
                a(anonymousClass1, 2000L);
            } else {
                com.jumobile.manager.systemapp.h.c.c.f().a(anonymousClass1);
                a(anonymousClass1, 2000L);
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                if (((String) it.next()).trim().equals(str)) {
                    return true;
                }
            }
            try {
                com.jumobile.manager.systemapp.h.a.a(false);
            } catch (Exception unused) {
            }
            arrayList2.clear();
            try {
                com.jumobile.manager.systemapp.h.c.c.h().a(anonymousClass1);
                a(anonymousClass1, 2000L);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(arrayList2);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    if (((String) it2.next()).trim().equals(str)) {
                        return true;
                    }
                }
                return false;
            } catch (Exception unused2) {
                return false;
            }
        } catch (Exception unused3) {
            return false;
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.h.d.d$1 */
    class AnonymousClass1 extends com.jumobile.manager.systemapp.h.c.b {
        final /* synthetic */ List l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Last argument in varargs method is not array: java.util.List arrayList */
        AnonymousClass1(int i, boolean z, String[] strArr, List arrayList2) {
            super(i, z, strArr);
            arrayList = arrayList2;
        }

        @Override // com.jumobile.manager.systemapp.h.c.a
        public void c(int i, String str2) {
            com.jumobile.manager.systemapp.h.a.e(str2);
            arrayList.add(str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean f(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumobile.manager.systemapp.h.d.d.f(java.lang.String):boolean");
    }

    public boolean c() {
        try {
            com.jumobile.manager.systemapp.h.a.e("Checking for Root access");
            b.a = false;
            AnonymousClass3 anonymousClass3 = new com.jumobile.manager.systemapp.h.c.b(2, false, "id") { // from class: com.jumobile.manager.systemapp.h.d.d.3
                AnonymousClass3(int i, boolean z, String... strArr) {
                    super(i, z, strArr);
                }

                @Override // com.jumobile.manager.systemapp.h.c.a
                public void c(int i, String str) {
                    if (i == 2) {
                        Iterator it = new HashSet(Arrays.asList(str.split(" "))).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            String str2 = (String) it.next();
                            com.jumobile.manager.systemapp.h.a.e(str2);
                            if (str2.toLowerCase().contains("uid=0")) {
                                b.a = true;
                                com.jumobile.manager.systemapp.h.a.e("Access Given");
                                break;
                            }
                        }
                        if (b.a) {
                            return;
                        }
                        com.jumobile.manager.systemapp.h.a.e("Access Denied?");
                    }
                }
            };
            com.jumobile.manager.systemapp.h.c.c.h().a(anonymousClass3);
            a(anonymousClass3, 60000L);
            return b.a;
        } catch (Exception unused) {
            return false;
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.h.d.d$3 */
    class AnonymousClass3 extends com.jumobile.manager.systemapp.h.c.b {
        AnonymousClass3(int i, boolean z, String... strArr) {
            super(i, z, strArr);
        }

        @Override // com.jumobile.manager.systemapp.h.c.a
        public void c(int i, String str) {
            if (i == 2) {
                Iterator it = new HashSet(Arrays.asList(str.split(" "))).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str2 = (String) it.next();
                    com.jumobile.manager.systemapp.h.a.e(str2);
                    if (str2.toLowerCase().contains("uid=0")) {
                        b.a = true;
                        com.jumobile.manager.systemapp.h.a.e("Access Given");
                        break;
                    }
                }
                if (b.a) {
                    return;
                }
                com.jumobile.manager.systemapp.h.a.e("Access Denied?");
            }
        }
    }

    public com.jumobile.manager.systemapp.h.a.b g(String str) {
        com.jumobile.manager.systemapp.h.a.e("Checking permissions for " + str);
        if (!com.jumobile.manager.systemapp.h.a.a(str)) {
            return null;
        }
        com.jumobile.manager.systemapp.h.a.e(str + " was found.");
        try {
            AnonymousClass4 anonymousClass4 = new com.jumobile.manager.systemapp.h.c.b(1, false, "ls -l " + str, "busybox ls -l " + str, "/system/bin/failsafe/toolbox ls -l " + str, "toolbox ls -l " + str) { // from class: com.jumobile.manager.systemapp.h.d.d.4
                AnonymousClass4(int i, boolean z, String... strArr) {
                    super(i, z, strArr);
                }

                @Override // com.jumobile.manager.systemapp.h.c.a
                public void c(int i, String str2) {
                    if (i == 1) {
                        String str3 = "";
                        if (str2.split(" ")[0].length() != 10) {
                            return;
                        }
                        com.jumobile.manager.systemapp.h.a.e("Line " + str2);
                        try {
                            String[] split = str2.split(" ");
                            if (split[split.length - 2].equals("->")) {
                                com.jumobile.manager.systemapp.h.a.e("Symlink found.");
                                str3 = split[split.length - 1];
                            }
                        } catch (Exception unused) {
                        }
                        try {
                            b.i = d.this.a(str2);
                            if (b.i != null) {
                                b.i.a(str3);
                            }
                        } catch (Exception e) {
                            com.jumobile.manager.systemapp.h.a.e(e.getMessage());
                        }
                    }
                }
            };
            com.jumobile.manager.systemapp.h.c.c.h().a(anonymousClass4);
            a(anonymousClass4, 2000L);
            return b.i;
        } catch (Exception e) {
            com.jumobile.manager.systemapp.h.a.e(e.getMessage());
            return null;
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.h.d.d$4 */
    class AnonymousClass4 extends com.jumobile.manager.systemapp.h.c.b {
        AnonymousClass4(int i, boolean z, String... strArr) {
            super(i, z, strArr);
        }

        @Override // com.jumobile.manager.systemapp.h.c.a
        public void c(int i, String str2) {
            if (i == 1) {
                String str3 = "";
                if (str2.split(" ")[0].length() != 10) {
                    return;
                }
                com.jumobile.manager.systemapp.h.a.e("Line " + str2);
                try {
                    String[] split = str2.split(" ");
                    if (split[split.length - 2].equals("->")) {
                        com.jumobile.manager.systemapp.h.a.e("Symlink found.");
                        str3 = split[split.length - 1];
                    }
                } catch (Exception unused) {
                }
                try {
                    b.i = d.this.a(str2);
                    if (b.i != null) {
                        b.i.a(str3);
                    }
                } catch (Exception e) {
                    com.jumobile.manager.systemapp.h.a.e(e.getMessage());
                }
            }
        }
    }

    public ArrayList<com.jumobile.manager.systemapp.h.a.a> d() throws Exception {
        LineNumberReader lineNumberReader;
        Throwable th;
        FileReader fileReader;
        try {
            fileReader = new FileReader("/proc/mounts");
            try {
                lineNumberReader = new LineNumberReader(fileReader);
            } catch (Throwable th2) {
                lineNumberReader = null;
                th = th2;
            }
        } catch (Throwable th3) {
            lineNumberReader = null;
            th = th3;
            fileReader = null;
        }
        try {
            ArrayList<com.jumobile.manager.systemapp.h.a.a> arrayList = new ArrayList<>();
            while (true) {
                String readLine = lineNumberReader.readLine();
                if (readLine == null) {
                    break;
                }
                com.jumobile.manager.systemapp.h.a.e(readLine);
                String[] split = readLine.split(" ");
                arrayList.add(new com.jumobile.manager.systemapp.h.a.a(new File(split[0]), new File(split[1]), split[2], split[3]));
            }
            b.g = arrayList;
            if (b.g != null) {
                ArrayList<com.jumobile.manager.systemapp.h.a.a> arrayList2 = b.g;
                try {
                    fileReader.close();
                } catch (Exception unused) {
                }
                try {
                    lineNumberReader.close();
                } catch (Exception unused2) {
                }
                return arrayList2;
            }
            throw new Exception();
        } catch (Throwable th4) {
            th = th4;
            try {
                fileReader.close();
            } catch (Exception unused3) {
            }
            try {
                lineNumberReader.close();
                throw th;
            } catch (Exception unused4) {
                throw th;
            }
        }
    }

    public String h(String str) throws Exception {
        b.g = d();
        if (b.g != null) {
            Iterator<com.jumobile.manager.systemapp.h.a.a> it = b.g.iterator();
            while (it.hasNext()) {
                com.jumobile.manager.systemapp.h.a.a next = it.next();
                if (str.contains(next.b().getAbsolutePath())) {
                    com.jumobile.manager.systemapp.h.a.e((String) next.c().toArray()[0]);
                    return (String) next.c().toArray()[0];
                }
            }
            throw new Exception();
        }
        throw new Exception();
    }

    public Set<String> e() throws Exception {
        if (b.f != null) {
            return b.f;
        }
        if (b()) {
            return b.f;
        }
        throw new Exception();
    }

    public boolean a(String str, String str2) {
        StringBuilder sb;
        b.c = false;
        if (!str2.endsWith("toolbox") && !str2.endsWith("busybox")) {
            return false;
        }
        try {
            String[] strArr = new String[1];
            if (str2.endsWith("toolbox")) {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(" ");
                sb.append(str);
            } else {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(" --list");
            }
            strArr[0] = sb.toString();
            AnonymousClass5 anonymousClass5 = new com.jumobile.manager.systemapp.h.c.b(0, false, strArr) { // from class: com.jumobile.manager.systemapp.h.d.d.5
                final /* synthetic */ String l;
                final /* synthetic */ String m;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass5(int i, boolean z, String[] strArr2, String str22, String str3) {
                    super(i, z, strArr2);
                    str2 = str22;
                    str = str3;
                }

                @Override // com.jumobile.manager.systemapp.h.c.a
                public void c(int i, String str3) {
                    if (str2.endsWith("toolbox")) {
                        if (str3.contains("no such tool")) {
                            b.c = true;
                        }
                    } else if (str2.endsWith("busybox") && str3.contains(str)) {
                        com.jumobile.manager.systemapp.h.a.e("Found util!");
                        b.c = true;
                    }
                }
            };
            com.jumobile.manager.systemapp.h.a.b(true).a(anonymousClass5);
            a(anonymousClass5, 2000L);
            if (b.c) {
                com.jumobile.manager.systemapp.h.a.e("Box contains " + str3 + " util!");
                return true;
            }
            com.jumobile.manager.systemapp.h.a.e("Box does not contain " + str3 + " util!");
            return false;
        } catch (Exception e) {
            com.jumobile.manager.systemapp.h.a.e(e.getMessage());
            return false;
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.h.d.d$5 */
    class AnonymousClass5 extends com.jumobile.manager.systemapp.h.c.b {
        final /* synthetic */ String l;
        final /* synthetic */ String m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Last argument in varargs method is not array: java.lang.String str */
        AnonymousClass5(int i, boolean z, String[] strArr2, String str22, String str3) {
            super(i, z, strArr2);
            str2 = str22;
            str = str3;
        }

        @Override // com.jumobile.manager.systemapp.h.c.a
        public void c(int i, String str3) {
            if (str2.endsWith("toolbox")) {
                if (str3.contains("no such tool")) {
                    b.c = true;
                }
            } else if (str2.endsWith("busybox") && str3.contains(str)) {
                com.jumobile.manager.systemapp.h.a.e("Found util!");
                b.c = true;
            }
        }
    }

    public boolean a(Context context, int i, String str, String str2) {
        try {
            return new a(context).a(i, str, str2);
        } catch (IOException e) {
            if (!com.jumobile.manager.systemapp.h.a.a) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public void a(String str, long j) {
        try {
            com.jumobile.manager.systemapp.h.c.b bVar = new com.jumobile.manager.systemapp.h.c.b(0, str);
            com.jumobile.manager.systemapp.h.c.c.h().a(bVar);
            a(bVar, j);
        } catch (Exception e) {
            com.jumobile.manager.systemapp.h.a.a("doCommand failed, command = " + str, 2, e);
        }
    }

    public List<String> b(String str, long j) {
        ArrayList arrayList = new ArrayList();
        try {
            AnonymousClass2 anonymousClass2 = new com.jumobile.manager.systemapp.h.c.b(0, new String[]{str}) { // from class: com.jumobile.manager.systemapp.h.d.d.2
                final /* synthetic */ List l;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(int i, String[] strArr, List arrayList2) {
                    super(i, strArr);
                    arrayList = arrayList2;
                }

                @Override // com.jumobile.manager.systemapp.h.c.a
                public void c(int i, String str2) {
                    arrayList.add(str2);
                }
            };
            com.jumobile.manager.systemapp.h.c.c.h().a(anonymousClass2);
            a(anonymousClass2, j);
        } catch (Exception e) {
            com.jumobile.manager.systemapp.h.a.a("getCommandOutput failed, command = " + str, 2, e);
        }
        return arrayList2;
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.h.d.d$2 */
    class AnonymousClass2 extends com.jumobile.manager.systemapp.h.c.b {
        final /* synthetic */ List l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Last argument in varargs method is not array: java.util.List arrayList */
        AnonymousClass2(int i, String[] strArr, List arrayList2) {
            super(i, strArr);
            arrayList = arrayList2;
        }

        @Override // com.jumobile.manager.systemapp.h.c.a
        public void c(int i, String str2) {
            arrayList.add(str2);
        }
    }

    private void a(com.jumobile.manager.systemapp.h.c.a aVar, long j) {
        synchronized (aVar) {
            try {
                aVar.wait(j);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
