package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public final class Objects {
    @KeepForSdk
    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @KeepForSdk
    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    @KeepForSdk
    public static ToStringHelper a(Object obj) {
        return new ToStringHelper(obj);
    }

    /* compiled from: source */
    @KeepForSdk
    public static final class ToStringHelper {
        private final List<String> a;
        private final Object b;

        private ToStringHelper(Object obj) {
            this.b = Preconditions.a(obj);
            this.a = new ArrayList();
        }

        @KeepForSdk
        public final ToStringHelper a(String str, Object obj) {
            List<String> list = this.a;
            String str2 = (String) Preconditions.a(str);
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(1 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
            sb.append(str2);
            sb.append("=");
            sb.append(valueOf);
            list.add(sb.toString());
            return this;
        }

        @KeepForSdk
        public final String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.b.getClass().getSimpleName());
            sb.append('{');
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                sb.append(this.a.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }

        /* synthetic */ ToStringHelper(Object obj, f fVar) {
            this(obj);
        }
    }

    private Objects() {
        throw new AssertionError("Uninstantiable");
    }
}
