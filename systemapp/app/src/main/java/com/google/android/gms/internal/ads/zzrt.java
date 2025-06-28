package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzrt {
    private final int b;
    private final zzrq d = new zzrx();
    private final int a = 6;
    private final int c = 0;

    public zzrt(int i) {
        this.b = i;
    }

    public final String a(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            String str = arrayList2.get(i);
            i++;
            sb.append(str.toLowerCase(Locale.US));
            sb.append('\n');
        }
        return a(sb.toString());
    }

    @VisibleForTesting
    private final String a(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        bcj bcjVar = new bcj();
        PriorityQueue priorityQueue = new PriorityQueue(this.b, new bci(this));
        for (String str2 : split) {
            String[] a = zzru.a(str2, false);
            if (a.length != 0) {
                zzrz.a(a, this.b, this.a, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                bcjVar.a(this.d.a(((zzry) it.next()).b));
            } catch (IOException e) {
                zzd.c("Error while writing hash to byteStream", e);
            }
        }
        return bcjVar.toString();
    }
}
