package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzau implements zzx {
    private static final boolean a = zzaq.a;

    @Deprecated
    private final zzbe b;
    private final zzar c;
    private final zzat d;

    public zzau(zzar zzarVar) {
        this(zzarVar, new zzat(4096));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private zzau(zzar zzarVar, zzat zzatVar) {
        this.c = zzarVar;
        this.b = zzarVar;
        this.d = zzatVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x013a, code lost:
    
        if (r13 > 3000) goto L221;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0194, code lost:
    
        throw new java.io.IOException();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x021b A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.gms.internal.ads.zzy a(com.google.android.gms.internal.ads.zzaa<?> r24) throws com.google.android.gms.internal.ads.zzao {
        /*
            Method dump skipped, instructions count: 591
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzau.a(com.google.android.gms.internal.ads.zzaa):com.google.android.gms.internal.ads.zzy");
    }

    private static void a(String str, zzaa<?> zzaaVar, zzao zzaoVar) throws zzao {
        zzan k = zzaaVar.k();
        int j = zzaaVar.j();
        try {
            k.a(zzaoVar);
            zzaaVar.b(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(j)));
        } catch (zzao e) {
            zzaaVar.b(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(j)));
            throw e;
        }
    }

    private final byte[] a(InputStream inputStream, int i) throws IOException, zzam {
        zzbi zzbiVar = new zzbi(this.d, i);
        byte[] bArr = null;
        try {
            if (inputStream == null) {
                throw new zzam();
            }
            byte[] a2 = this.d.a(1024);
            while (true) {
                try {
                    int read = inputStream.read(a2);
                    if (read == -1) {
                        break;
                    }
                    zzbiVar.write(a2, 0, read);
                } catch (Throwable th) {
                    th = th;
                    bArr = a2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                            zzaq.a("Error occurred when closing InputStream", new Object[0]);
                        }
                    }
                    this.d.a(bArr);
                    zzbiVar.close();
                    throw th;
                }
            }
            byte[] byteArray = zzbiVar.toByteArray();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    zzaq.a("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.d.a(a2);
            zzbiVar.close();
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
