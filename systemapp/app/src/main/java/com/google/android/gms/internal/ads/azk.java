package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
final class azk extends azh {
    public final long aP;
    public final List<azj> aQ;
    public final List<azk> aR;

    public azk(int i, long j) {
        super(i);
        this.aP = j;
        this.aQ = new ArrayList();
        this.aR = new ArrayList();
    }

    public final void a(azj azjVar) {
        this.aQ.add(azjVar);
    }

    public final void a(azk azkVar) {
        this.aR.add(azkVar);
    }

    public final azj d(int i) {
        int size = this.aQ.size();
        for (int i2 = 0; i2 < size; i2++) {
            azj azjVar = this.aQ.get(i2);
            if (azjVar.aO == i) {
                return azjVar;
            }
        }
        return null;
    }

    public final azk e(int i) {
        int size = this.aR.size();
        for (int i2 = 0; i2 < size; i2++) {
            azk azkVar = this.aR.get(i2);
            if (azkVar.aO == i) {
                return azkVar;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.azh
    public final String toString() {
        String c = c(this.aO);
        String arrays = Arrays.toString(this.aQ.toArray());
        String arrays2 = Arrays.toString(this.aR.toArray());
        StringBuilder sb = new StringBuilder(22 + String.valueOf(c).length() + String.valueOf(arrays).length() + String.valueOf(arrays2).length());
        sb.append(c);
        sb.append(" leaves: ");
        sb.append(arrays);
        sb.append(" containers: ");
        sb.append(arrays2);
        return sb.toString();
    }
}
