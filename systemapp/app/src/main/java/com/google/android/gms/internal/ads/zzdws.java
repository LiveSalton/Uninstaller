package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdws<E> extends amc<E> {

    @NullableDecl
    private Object[] d;
    private int e;

    public zzdws() {
        super(4);
    }

    zzdws(int i) {
        super(i);
        this.d = new Object[zzdwt.a(i)];
    }

    public final zzdwt<E> a() {
        zzdwt<E> b;
        boolean b2;
        switch (this.b) {
            case 0:
                return aml.a;
            case 1:
                return zzdwt.a(this.a[0]);
            default:
                if (this.d != null && zzdwt.a(this.b) == this.d.length) {
                    b2 = zzdwt.b(this.b, this.a.length);
                    b = new aml<>(b2 ? Arrays.copyOf(this.a, this.b) : this.a, this.e, this.d, this.d.length - 1, this.b);
                } else {
                    b = zzdwt.b(this.b, this.a);
                    this.b = b.size();
                }
                this.c = true;
                this.d = null;
                return b;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.amc, com.google.android.gms.internal.ads.zzdwn
    public final /* synthetic */ zzdwn a(Iterable iterable) {
        zzdvv.a(iterable);
        if (this.d != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
        } else {
            super.a(iterable);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.amc
    public final /* synthetic */ amc a(Object obj) {
        return (zzdws) b(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdwn
    public final /* synthetic */ zzdwn a(Iterator it) {
        zzdvv.a(it);
        while (it.hasNext()) {
            b(it.next());
        }
        return this;
    }

    @Override // com.google.android.gms.internal.ads.amc, com.google.android.gms.internal.ads.zzdwn
    public final /* synthetic */ zzdwn b(Object obj) {
        zzdvv.a(obj);
        if (this.d != null && zzdwt.a(this.b) <= this.d.length) {
            int length = this.d.length - 1;
            int hashCode = obj.hashCode();
            int a = amb.a(hashCode);
            while (true) {
                int i = a & length;
                Object obj2 = this.d[i];
                if (obj2 == null) {
                    this.d[i] = obj;
                    this.e += hashCode;
                    super.a((zzdws<E>) obj);
                    break;
                }
                if (obj2.equals(obj)) {
                    break;
                }
                a = i + 1;
            }
            return this;
        }
        this.d = null;
        super.a((zzdws<E>) obj);
        return this;
    }
}
