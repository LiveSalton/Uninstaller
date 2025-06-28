package com.jumobile.manager.systemapp.h.d;

import android.content.Context;
import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
class a {
    Context a;
    String b;

    public a(Context context) throws IOException {
        this.a = context;
        this.b = context.getFilesDir().getCanonicalPath();
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010c A[Catch: all -> 0x0105, TRY_LEAVE, TryCatch #6 {all -> 0x0105, blocks: (B:78:0x003f, B:89:0x0108, B:91:0x010c), top: B:4:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean a(int r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumobile.manager.systemapp.h.d.a.a(int, java.lang.String, java.lang.String):boolean");
    }

    private void a(com.jumobile.manager.systemapp.h.c.a aVar) {
        synchronized (aVar) {
            try {
                aVar.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
