package com.jumobile.manager.systemapp.service;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public class a extends Thread {
    private static int d = 1;
    private final Context a;
    private final DownloadEntry b;
    private final InterfaceC0092a c;
    private final int e;

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.service.a$a */
    public interface InterfaceC0092a {
        void a(int i, int i2);

        void a(int i, long j, long j2);

        boolean a(int i);

        void b(int i);

        void c(int i);
    }

    public a(Context context, DownloadEntry downloadEntry, InterfaceC0092a interfaceC0092a) {
        int i = d;
        d = i + 1;
        this.e = i;
        this.a = context;
        this.b = downloadEntry;
        this.c = interfaceC0092a;
    }

    public int a() {
        return this.e;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:(2:17|(1:91)(25:23|24|(1:26)|27|28|29|30|31|32|34|35|36|37|(1:39)|40|(3:41|42|(5:44|45|(1:47)|48|(2:51|52)(1:50))(2:78|79))|53|54|(2:69|70)|(2:64|65)|(1:58)|59|(1:61)|62|63))|28|29|30|31|32|34|35|36|37|(0)|40|(4:41|42|(0)(0)|50)|53|54|(0)|(0)|(0)|59|(0)|62|63) */
    /* JADX WARN: Can't wrap try/catch for region: R(31:11|12|13|14|15|(2:17|(1:91)(25:23|24|(1:26)|27|28|29|30|31|32|34|35|36|37|(1:39)|40|(3:41|42|(5:44|45|(1:47)|48|(2:51|52)(1:50))(2:78|79))|53|54|(2:69|70)|(2:64|65)|(1:58)|59|(1:61)|62|63))|92|24|(0)|27|28|29|30|31|32|34|35|36|37|(0)|40|(4:41|42|(0)(0)|50)|53|54|(0)|(0)|(0)|59|(0)|62|63) */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0169, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x016a, code lost:
    
        r5 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x016e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x016f, code lost:
    
        r5 = r0;
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0174, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0175, code lost:
    
        r5 = r0;
        r7 = null;
        r9 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010c A[Catch: IOException -> 0x0169, TryCatch #0 {IOException -> 0x0169, blocks: (B:37:0x0100, B:39:0x010c, B:40:0x010e, B:41:0x0116), top: B:36:0x0100 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0189 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x017f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0158 A[SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumobile.manager.systemapp.service.a.run():void");
    }
}
