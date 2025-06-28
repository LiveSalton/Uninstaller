package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: source */
@SuppressLint({"InlinedApi"})
@TargetApi(16)
/* loaded from: classes.dex */
public final class zzlz {
    private static final zzls a = zzls.a("OMX.google.raw.decoder");
    private static final Pattern b = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<a, List<zzls>> c = new HashMap<>();
    private static final SparseIntArray d;
    private static final SparseIntArray e;
    private static final Map<String, Integer> f;
    private static int g = -1;

    public static zzls a() {
        return a;
    }

    public static zzls a(String str, boolean z) throws zzma {
        List<zzls> b2 = b(str, z);
        if (b2.isEmpty()) {
            return null;
        }
        return b2.get(0);
    }

    /* compiled from: source */
    static final class a {
        public final String a;
        public final boolean b;

        public a(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        public final int hashCode() {
            return (((this.a == null ? 0 : this.a.hashCode()) + 31) * 31) + (this.b ? 1231 : 1237);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            return TextUtils.equals(this.a, aVar.a) && this.b == aVar.b;
        }
    }

    private static synchronized List<zzls> b(String str, boolean z) throws zzma {
        synchronized (zzlz.class) {
            a aVar = new a(str, z);
            List<zzls> list = c.get(aVar);
            if (list != null) {
                return list;
            }
            List<zzls> a2 = a(aVar, zzpt.a >= 21 ? new bah(z) : new baf());
            if (z && a2.isEmpty() && 21 <= zzpt.a && zzpt.a <= 23) {
                a2 = a(aVar, new baf());
                if (!a2.isEmpty()) {
                    String str2 = a2.get(0).a;
                    StringBuilder sb = new StringBuilder(63 + String.valueOf(str).length() + String.valueOf(str2).length());
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(str2);
                    Log.w("MediaCodecUtil", sb.toString());
                }
            }
            List<zzls> unmodifiableList = Collections.unmodifiableList(a2);
            c.put(aVar, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static int b() throws zzma {
        int i;
        if (g == -1) {
            int i2 = 0;
            zzls a2 = a("video/avc", false);
            if (a2 != null) {
                MediaCodecInfo.CodecProfileLevel[] a3 = a2.a();
                int length = a3.length;
                int i3 = 0;
                while (i2 < length) {
                    switch (a3[i2].level) {
                        case 1:
                        case 2:
                            i = 25344;
                            break;
                        case 8:
                        case 16:
                        case 32:
                            i = 101376;
                            break;
                        case 64:
                            i = 202752;
                            break;
                        case 128:
                        case 256:
                            i = 414720;
                            break;
                        case 512:
                            i = 921600;
                            break;
                        case 1024:
                            i = 1310720;
                            break;
                        case 2048:
                        case 4096:
                            i = 2097152;
                            break;
                        case 8192:
                            i = 2228224;
                            break;
                        case 16384:
                            i = 5652480;
                            break;
                        case 32768:
                        case 65536:
                            i = 9437184;
                            break;
                        default:
                            i = -1;
                            break;
                    }
                    i3 = Math.max(i, i3);
                    i2++;
                }
                i2 = Math.max(i3, zzpt.a >= 21 ? 345600 : 172800);
            }
            g = i2;
        }
        return g;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0029, code lost:
    
        if (r3.equals("hev1") != false) goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> a(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlz.a(java.lang.String):android.util.Pair");
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01b4 A[Catch: Exception -> 0x02ba, TryCatch #2 {Exception -> 0x02ba, blocks: (B:3:0x0004, B:5:0x0016, B:8:0x0026, B:11:0x0030, B:13:0x0036, B:15:0x003e, B:17:0x0046, B:19:0x004e, B:21:0x0056, B:23:0x005e, B:26:0x0068, B:28:0x006e, B:31:0x0078, B:33:0x007c, B:35:0x0084, B:38:0x0090, B:40:0x0096, B:42:0x009e, B:44:0x00a8, B:46:0x00b2, B:48:0x00bc, B:50:0x00c6, B:52:0x00d0, B:54:0x00da, B:56:0x00e4, B:58:0x00ee, B:60:0x00f8, B:62:0x0102, B:64:0x010c, B:67:0x0118, B:69:0x011c, B:71:0x0124, B:73:0x012e, B:75:0x0138, B:77:0x0142, B:80:0x014d, B:82:0x0153, B:84:0x015b, B:86:0x0165, B:88:0x016f, B:90:0x0179, B:92:0x0183, B:94:0x018d, B:97:0x0198, B:99:0x019c, B:101:0x01a6, B:106:0x01b4, B:108:0x01bc, B:143:0x0239, B:145:0x023f, B:147:0x0245, B:150:0x026c, B:151:0x02a3), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0201 A[Catch: Exception -> 0x01fa, TryCatch #1 {Exception -> 0x01fa, blocks: (B:158:0x01d4, B:160:0x01de, B:162:0x01e8, B:164:0x01f0, B:120:0x0201, B:124:0x020f, B:126:0x020a), top: B:157:0x01d4 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x023f A[Catch: Exception -> 0x02ba, TryCatch #2 {Exception -> 0x02ba, blocks: (B:3:0x0004, B:5:0x0016, B:8:0x0026, B:11:0x0030, B:13:0x0036, B:15:0x003e, B:17:0x0046, B:19:0x004e, B:21:0x0056, B:23:0x005e, B:26:0x0068, B:28:0x006e, B:31:0x0078, B:33:0x007c, B:35:0x0084, B:38:0x0090, B:40:0x0096, B:42:0x009e, B:44:0x00a8, B:46:0x00b2, B:48:0x00bc, B:50:0x00c6, B:52:0x00d0, B:54:0x00da, B:56:0x00e4, B:58:0x00ee, B:60:0x00f8, B:62:0x0102, B:64:0x010c, B:67:0x0118, B:69:0x011c, B:71:0x0124, B:73:0x012e, B:75:0x0138, B:77:0x0142, B:80:0x014d, B:82:0x0153, B:84:0x015b, B:86:0x0165, B:88:0x016f, B:90:0x0179, B:92:0x0183, B:94:0x018d, B:97:0x0198, B:99:0x019c, B:101:0x01a6, B:106:0x01b4, B:108:0x01bc, B:143:0x0239, B:145:0x023f, B:147:0x0245, B:150:0x026c, B:151:0x02a3), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x026c A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02af A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<com.google.android.gms.internal.ads.zzls> a(com.google.android.gms.internal.ads.zzlz.a r19, com.google.android.gms.internal.ads.bag r20) throws com.google.android.gms.internal.ads.zzma {
        /*
            Method dump skipped, instructions count: 707
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlz.a(com.google.android.gms.internal.ads.zzlz$a, com.google.android.gms.internal.ads.bag):java.util.List");
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr) {
        Integer valueOf;
        Integer num;
        if (strArr.length < 2) {
            String valueOf2 = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf2) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                num = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length >= 3) {
                Integer valueOf3 = Integer.valueOf(Integer.parseInt(strArr[1]));
                valueOf = Integer.valueOf(Integer.parseInt(strArr[2]));
                num = valueOf3;
            } else {
                String valueOf4 = String.valueOf(str);
                Log.w("MediaCodecUtil", valueOf4.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf4) : new String("Ignoring malformed AVC codec string: "));
                return null;
            }
            Integer valueOf5 = Integer.valueOf(d.get(num.intValue()));
            if (valueOf5 == null) {
                String valueOf6 = String.valueOf(num);
                StringBuilder sb = new StringBuilder(21 + String.valueOf(valueOf6).length());
                sb.append("Unknown AVC profile: ");
                sb.append(valueOf6);
                Log.w("MediaCodecUtil", sb.toString());
                return null;
            }
            Integer valueOf7 = Integer.valueOf(e.get(valueOf.intValue()));
            if (valueOf7 == null) {
                String valueOf8 = String.valueOf(valueOf);
                StringBuilder sb2 = new StringBuilder(19 + String.valueOf(valueOf8).length());
                sb2.append("Unknown AVC level: ");
                sb2.append(valueOf8);
                Log.w("MediaCodecUtil", sb2.toString());
                return null;
            }
            return new Pair<>(valueOf5, valueOf7);
        } catch (NumberFormatException unused) {
            String valueOf9 = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf9.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf9) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        d = sparseIntArray;
        sparseIntArray.put(66, 1);
        d.put(77, 2);
        d.put(88, 4);
        d.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        e = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        e.put(11, 4);
        e.put(12, 8);
        e.put(13, 16);
        e.put(20, 32);
        e.put(21, 64);
        e.put(22, 128);
        e.put(30, 256);
        e.put(31, 512);
        e.put(32, 1024);
        e.put(40, 2048);
        e.put(41, 4096);
        e.put(42, 8192);
        e.put(50, 16384);
        e.put(51, 32768);
        e.put(52, 65536);
        HashMap hashMap = new HashMap();
        f = hashMap;
        hashMap.put("L30", 1);
        f.put("L60", 4);
        f.put("L63", 16);
        f.put("L90", 64);
        f.put("L93", 256);
        f.put("L120", 1024);
        f.put("L123", 4096);
        f.put("L150", 16384);
        f.put("L153", 65536);
        f.put("L156", 262144);
        f.put("L180", 1048576);
        f.put("L183", 4194304);
        f.put("L186", 16777216);
        f.put("H30", 2);
        f.put("H60", 8);
        f.put("H63", 32);
        f.put("H90", 128);
        f.put("H93", 512);
        f.put("H120", 2048);
        f.put("H123", 8192);
        f.put("H150", 32768);
        f.put("H153", 131072);
        f.put("H156", 524288);
        f.put("H180", 2097152);
        f.put("H183", 8388608);
        f.put("H186", 33554432);
    }
}
