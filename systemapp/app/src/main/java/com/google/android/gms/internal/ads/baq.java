package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* compiled from: source */
/* loaded from: classes.dex */
final class baq implements Runnable {
    private final /* synthetic */ bar a;
    private final /* synthetic */ bam b;

    baq(bam bamVar, bar barVar) {
        this.b = bamVar;
        this.a = barVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        this.a.a();
        sparseArray = this.b.p;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            sparseArray2 = this.b.p;
            ((zzni) sparseArray2.valueAt(i)).b();
        }
    }
}
