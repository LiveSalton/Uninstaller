package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeik;
import com.google.android.gms.internal.ads.zzein;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzeik<MessageType extends zzeik<MessageType, BuilderType>, BuilderType extends zzein<MessageType, BuilderType>> implements zzels {
    protected int zziij = 0;

    @Override // com.google.android.gms.internal.ads.zzels
    public final zzeiu k() {
        try {
            asw c = zzeiu.c(q());
            a(c.b());
            return c.a();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(62 + String.valueOf(name).length() + String.valueOf("ByteString").length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final byte[] l() {
        try {
            byte[] bArr = new byte[q()];
            zzejo a = zzejo.a(bArr);
            a(a);
            a.b();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(62 + String.valueOf(name).length() + String.valueOf("byte array").length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    int m() {
        throw new UnsupportedOperationException();
    }

    void a(int i) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void a(Iterable<T> iterable, List<? super T> list) {
        zzekk.a(iterable);
        if (iterable instanceof zzekz) {
            List<?> l_ = ((zzekz) iterable).l_();
            zzekz zzekzVar = (zzekz) list;
            int size = list.size();
            for (Object obj : l_) {
                if (obj == null) {
                    int size2 = zzekzVar.size() - size;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size3 = zzekzVar.size() - 1; size3 >= size; size3--) {
                        zzekzVar.remove(size3);
                    }
                    throw new NullPointerException(sb2);
                }
                if (obj instanceof zzeiu) {
                    zzekzVar.a((zzeiu) obj);
                } else {
                    zzekzVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof auu) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size4 = list.size();
        for (T t : iterable) {
            if (t == null) {
                int size5 = list.size() - size4;
                StringBuilder sb3 = new StringBuilder(37);
                sb3.append("Element at index ");
                sb3.append(size5);
                sb3.append(" is null.");
                String sb4 = sb3.toString();
                for (int size6 = list.size() - 1; size6 >= size4; size6--) {
                    list.remove(size6);
                }
                throw new NullPointerException(sb4);
            }
            list.add(t);
        }
    }
}
