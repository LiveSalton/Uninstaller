package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class bn {
    static String a(zzgo zzgoVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        a(zzgoVar, sb, 0);
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x022e, code lost:
    
        if (((java.lang.Double) r6).doubleValue() == 0.0d) goto L239;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01f8, code lost:
    
        if (((java.lang.Boolean) r6).booleanValue() == false) goto L239;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01fa, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x020b, code lost:
    
        if (((java.lang.Integer) r6).intValue() == 0) goto L239;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x021c, code lost:
    
        if (((java.lang.Float) r6).floatValue() == 0.0f) goto L239;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.google.android.gms.internal.measurement.zzgo r12, java.lang.StringBuilder r13, int r14) {
        /*
            Method dump skipped, instructions count: 689
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.bn.a(com.google.android.gms.internal.measurement.zzgo, java.lang.StringBuilder, int):void");
    }

    static final void a(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                a(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                a(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(ch.a(zzdu.a((String) obj)));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzdu) {
            sb.append(": \"");
            sb.append(ch.a((zzdu) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzfd) {
            sb.append(" {");
            a((zzfd) obj, sb, i + 2);
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int i4 = i + 2;
            a(sb, i4, "key", entry.getKey());
            a(sb, i4, "value", entry.getValue());
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        sb.append(": ");
        sb.append(obj.toString());
    }

    private static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
