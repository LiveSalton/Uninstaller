package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: source */
/* loaded from: classes.dex */
final class eb implements Comparator<byte[]> {
    eb() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(byte[] bArr, byte[] bArr2) {
        return bArr.length - bArr2.length;
    }
}
