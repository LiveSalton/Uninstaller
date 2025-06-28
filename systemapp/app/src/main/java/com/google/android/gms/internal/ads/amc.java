package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;

/* compiled from: source */
/* loaded from: classes.dex */
class amc<E> extends zzdwn<E> {
    Object[] a;
    int b;
    boolean c;

    amc(int i) {
        alz.a(i, "initialCapacity");
        this.a = new Object[i];
        this.b = 0;
    }

    private final void a(int i) {
        if (this.a.length < i) {
            Object[] objArr = this.a;
            int length = this.a.length;
            if (i < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i2 = length + (length >> 1) + 1;
            if (i2 < i) {
                i2 = Integer.highestOneBit(i - 1) << 1;
            }
            if (i2 < 0) {
                i2 = Integer.MAX_VALUE;
            }
            this.a = Arrays.copyOf(objArr, i2);
            this.c = false;
            return;
        }
        if (this.c) {
            this.a = (Object[]) this.a.clone();
            this.c = false;
        }
    }

    public amc<E> a(E e) {
        zzdvv.a(e);
        a(this.b + 1);
        Object[] objArr = this.a;
        int i = this.b;
        this.b = i + 1;
        objArr[i] = e;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdwn
    public zzdwn<E> a(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            a(this.b + collection.size());
            if (collection instanceof zzdwl) {
                this.b = ((zzdwl) collection).a(this.a, this.b);
                return this;
            }
        }
        super.a((Iterable) iterable);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdwn
    public /* synthetic */ zzdwn b(Object obj) {
        return a((amc<E>) obj);
    }
}
