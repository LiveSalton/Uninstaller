package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
final class bar {
    private final zzjw[] a;
    private final zzjy b;
    private zzjw c;

    public bar(zzjw[] zzjwVarArr, zzjy zzjyVar) {
        this.a = zzjwVarArr;
        this.b = zzjyVar;
    }

    public final zzjw a(zzjz zzjzVar, Uri uri) throws IOException, InterruptedException {
        if (this.c != null) {
            return this.c;
        }
        zzjw[] zzjwVarArr = this.a;
        int length = zzjwVarArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zzjw zzjwVar = zzjwVarArr[i];
            try {
            } catch (EOFException unused) {
            } finally {
                zzjzVar.a();
            }
            if (zzjwVar.a(zzjzVar)) {
                this.c = zzjwVar;
                break;
            }
            i++;
        }
        if (this.c == null) {
            String a = zzpt.a(this.a);
            StringBuilder sb = new StringBuilder(58 + String.valueOf(a).length());
            sb.append("None of the available extractors (");
            sb.append(a);
            sb.append(") could read the stream.");
            throw new zznt(sb.toString(), uri);
        }
        this.c.a(this.b);
        return this.c;
    }

    public final void a() {
        if (this.c != null) {
            this.c.c();
            this.c = null;
        }
    }
}
