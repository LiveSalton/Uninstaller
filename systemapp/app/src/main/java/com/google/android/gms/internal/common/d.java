package com.google.android.gms.internal.common;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
final class d<T> implements zzo<T>, Serializable {
    private final zzo<T> a;
    private volatile transient boolean b;

    @NullableDecl
    private transient T c;

    d(zzo<T> zzoVar) {
        this.a = (zzo) zzl.a(zzoVar);
    }

    @Override // com.google.android.gms.internal.common.zzo
    public final T a() {
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    T a = this.a.a();
                    this.c = a;
                    this.b = true;
                    return a;
                }
            }
        }
        return this.c;
    }

    public final String toString() {
        Object obj;
        if (this.b) {
            String valueOf = String.valueOf(this.c);
            StringBuilder sb = new StringBuilder(25 + String.valueOf(valueOf).length());
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
        } else {
            obj = this.a;
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(19 + String.valueOf(valueOf2).length());
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
