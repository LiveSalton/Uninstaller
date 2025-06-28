package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: source */
/* loaded from: classes.dex */
final class bci implements Comparator<zzry> {
    bci(zzrt zzrtVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzry zzryVar, zzry zzryVar2) {
        zzry zzryVar3 = zzryVar;
        zzry zzryVar4 = zzryVar2;
        int i = zzryVar3.c - zzryVar4.c;
        return i != 0 ? i : (int) (zzryVar3.a - zzryVar4.a);
    }
}
