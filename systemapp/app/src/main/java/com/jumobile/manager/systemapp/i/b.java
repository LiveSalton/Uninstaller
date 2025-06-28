package com.jumobile.manager.systemapp.i;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* compiled from: source */
/* loaded from: classes.dex */
public class b extends Thread {
    boolean a = false;
    private final Context b;
    private final a c;
    private String d;

    /* compiled from: source */
    public interface a {
        String a(b bVar);

        void a(b bVar, int i);

        void a(String str, Drawable drawable);

        boolean a();
    }

    public b(Context context, a aVar) {
        this.b = context;
        this.c = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x014c, code lost:
    
        if (r5 == null) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x014e, code lost:
    
        r5.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x017e, code lost:
    
        if (r1 != 0) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0180, code lost:
    
        com.jumobile.manager.systemapp.util.f.a(r6);
        new java.io.File(r6).renameTo(r4);
        r0 = android.graphics.drawable.Drawable.createFromPath(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x018f, code lost:
    
        if (r0 == null) goto L265;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0191, code lost:
    
        r13.c.a(r13.d, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x017b, code lost:
    
        if (r5 == null) goto L214;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x015f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0164 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumobile.manager.systemapp.i.b.run():void");
    }
}
