package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
final class el {
    long a;
    final String b;
    final String c;
    final long d;
    final long e;
    final long f;
    final long g;
    final List<zzu> h;

    private el(String str, String str2, long j, long j2, long j3, long j4, List<zzu> list) {
        this.b = str;
        this.c = "".equals(str2) ? null : str2;
        this.d = j;
        this.e = j2;
        this.f = j3;
        this.g = j4;
        this.h = list;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    el(java.lang.String r14, com.google.android.gms.internal.ads.zzn r15) {
        /*
            r13 = this;
            java.lang.String r2 = r15.b
            long r3 = r15.c
            long r5 = r15.d
            long r7 = r15.e
            long r9 = r15.f
            java.util.List<com.google.android.gms.internal.ads.zzu> r0 = r15.h
            if (r0 == 0) goto L12
            java.util.List<com.google.android.gms.internal.ads.zzu> r15 = r15.h
            r11 = r15
            goto L47
        L12:
            java.util.Map<java.lang.String, java.lang.String> r15 = r15.g
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r15.size()
            r0.<init>(r1)
            java.util.Set r15 = r15.entrySet()
            java.util.Iterator r15 = r15.iterator()
        L25:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L46
            java.lang.Object r1 = r15.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            com.google.android.gms.internal.ads.zzu r11 = new com.google.android.gms.internal.ads.zzu
            java.lang.Object r12 = r1.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r11.<init>(r12, r1)
            r0.add(r11)
            goto L25
        L46:
            r11 = r0
        L47:
            r0 = r13
            r1 = r14
            r0.<init>(r1, r2, r3, r5, r7, r9, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.el.<init>(java.lang.String, com.google.android.gms.internal.ads.zzn):void");
    }

    static el a(fv fvVar) throws IOException {
        if (zzav.a((InputStream) fvVar) != 538247942) {
            throw new IOException();
        }
        return new el(zzav.a(fvVar), zzav.a(fvVar), zzav.b((InputStream) fvVar), zzav.b((InputStream) fvVar), zzav.b((InputStream) fvVar), zzav.b((InputStream) fvVar), zzav.b(fvVar));
    }

    final boolean a(OutputStream outputStream) {
        try {
            zzav.a(outputStream, 538247942);
            zzav.a(outputStream, this.b);
            zzav.a(outputStream, this.c == null ? "" : this.c);
            zzav.a(outputStream, this.d);
            zzav.a(outputStream, this.e);
            zzav.a(outputStream, this.f);
            zzav.a(outputStream, this.g);
            List<zzu> list = this.h;
            if (list != null) {
                zzav.a(outputStream, list.size());
                for (zzu zzuVar : list) {
                    zzav.a(outputStream, zzuVar.a());
                    zzav.a(outputStream, zzuVar.b());
                }
            } else {
                zzav.a(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e) {
            zzaq.b("%s", e.toString());
            return false;
        }
    }
}
