package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaqk extends zzaqu {
    private static final Set<String> a = CollectionUtils.a("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private String b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private final Object j;
    private final zzbdv k;
    private final Activity l;
    private zzbfn m;
    private ImageView n;
    private LinearLayout o;
    private zzaqx p;
    private PopupWindow q;
    private RelativeLayout r;
    private ViewGroup s;

    public zzaqk(zzbdv zzbdvVar, zzaqx zzaqxVar) {
        super(zzbdvVar, "resize");
        this.b = "top-right";
        this.c = true;
        this.d = 0;
        this.e = 0;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.i = -1;
        this.j = new Object();
        this.k = zzbdvVar;
        this.l = zzbdvVar.g();
        this.p = zzaqxVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x0237 A[Catch: all -> 0x04af, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:10:0x0012, B:12:0x001a, B:13:0x001f, B:15:0x0021, B:17:0x002d, B:18:0x0032, B:20:0x0034, B:22:0x003c, B:23:0x0041, B:25:0x0043, B:27:0x0051, B:28:0x0062, B:30:0x0070, B:31:0x0081, B:33:0x008f, B:34:0x00a0, B:36:0x00ae, B:37:0x00bf, B:39:0x00cd, B:40:0x00db, B:42:0x00e9, B:43:0x00eb, B:45:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:59:0x0130, B:62:0x0136, B:64:0x013a, B:67:0x0140, B:69:0x0144, B:71:0x0148, B:76:0x0295, B:77:0x029a, B:79:0x029c, B:81:0x02be, B:83:0x02c2, B:85:0x02d2, B:86:0x0306, B:87:0x036c, B:91:0x03b6, B:92:0x03b9, B:93:0x03e6, B:94:0x03e9, B:96:0x0401, B:97:0x0420, B:99:0x0428, B:100:0x0431, B:101:0x0456, B:105:0x0459, B:107:0x046a, B:108:0x0474, B:110:0x0486, B:111:0x049f, B:113:0x046f, B:114:0x03bd, B:115:0x03c4, B:116:0x03cb, B:117:0x03d2, B:118:0x03d8, B:119:0x03df, B:120:0x0370, B:123:0x037a, B:126:0x0383, B:129:0x038d, B:132:0x0397, B:135:0x03a1, B:138:0x0301, B:139:0x04a1, B:140:0x04a6, B:142:0x0237, B:144:0x023b, B:145:0x024c, B:148:0x0278, B:150:0x027c, B:151:0x028c, B:152:0x027f, B:154:0x0286, B:155:0x026e, B:157:0x0273, B:159:0x014f, B:161:0x0153, B:162:0x0159, B:165:0x019a, B:166:0x019d, B:167:0x020a, B:169:0x0218, B:171:0x021b, B:173:0x021f, B:176:0x01a0, B:177:0x01b3, B:178:0x01c8, B:179:0x01d7, B:180:0x01ee, B:181:0x01ff, B:182:0x015d, B:185:0x0167, B:188:0x0171, B:191:0x017b, B:194:0x0185, B:197:0x018f, B:201:0x0227, B:202:0x022d, B:203:0x04a8, B:204:0x04ad), top: B:3:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0295 A[Catch: all -> 0x04af, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:10:0x0012, B:12:0x001a, B:13:0x001f, B:15:0x0021, B:17:0x002d, B:18:0x0032, B:20:0x0034, B:22:0x003c, B:23:0x0041, B:25:0x0043, B:27:0x0051, B:28:0x0062, B:30:0x0070, B:31:0x0081, B:33:0x008f, B:34:0x00a0, B:36:0x00ae, B:37:0x00bf, B:39:0x00cd, B:40:0x00db, B:42:0x00e9, B:43:0x00eb, B:45:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:59:0x0130, B:62:0x0136, B:64:0x013a, B:67:0x0140, B:69:0x0144, B:71:0x0148, B:76:0x0295, B:77:0x029a, B:79:0x029c, B:81:0x02be, B:83:0x02c2, B:85:0x02d2, B:86:0x0306, B:87:0x036c, B:91:0x03b6, B:92:0x03b9, B:93:0x03e6, B:94:0x03e9, B:96:0x0401, B:97:0x0420, B:99:0x0428, B:100:0x0431, B:101:0x0456, B:105:0x0459, B:107:0x046a, B:108:0x0474, B:110:0x0486, B:111:0x049f, B:113:0x046f, B:114:0x03bd, B:115:0x03c4, B:116:0x03cb, B:117:0x03d2, B:118:0x03d8, B:119:0x03df, B:120:0x0370, B:123:0x037a, B:126:0x0383, B:129:0x038d, B:132:0x0397, B:135:0x03a1, B:138:0x0301, B:139:0x04a1, B:140:0x04a6, B:142:0x0237, B:144:0x023b, B:145:0x024c, B:148:0x0278, B:150:0x027c, B:151:0x028c, B:152:0x027f, B:154:0x0286, B:155:0x026e, B:157:0x0273, B:159:0x014f, B:161:0x0153, B:162:0x0159, B:165:0x019a, B:166:0x019d, B:167:0x020a, B:169:0x0218, B:171:0x021b, B:173:0x021f, B:176:0x01a0, B:177:0x01b3, B:178:0x01c8, B:179:0x01d7, B:180:0x01ee, B:181:0x01ff, B:182:0x015d, B:185:0x0167, B:188:0x0171, B:191:0x017b, B:194:0x0185, B:197:0x018f, B:201:0x0227, B:202:0x022d, B:203:0x04a8, B:204:0x04ad), top: B:3:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x029c A[Catch: all -> 0x04af, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:10:0x0012, B:12:0x001a, B:13:0x001f, B:15:0x0021, B:17:0x002d, B:18:0x0032, B:20:0x0034, B:22:0x003c, B:23:0x0041, B:25:0x0043, B:27:0x0051, B:28:0x0062, B:30:0x0070, B:31:0x0081, B:33:0x008f, B:34:0x00a0, B:36:0x00ae, B:37:0x00bf, B:39:0x00cd, B:40:0x00db, B:42:0x00e9, B:43:0x00eb, B:45:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:59:0x0130, B:62:0x0136, B:64:0x013a, B:67:0x0140, B:69:0x0144, B:71:0x0148, B:76:0x0295, B:77:0x029a, B:79:0x029c, B:81:0x02be, B:83:0x02c2, B:85:0x02d2, B:86:0x0306, B:87:0x036c, B:91:0x03b6, B:92:0x03b9, B:93:0x03e6, B:94:0x03e9, B:96:0x0401, B:97:0x0420, B:99:0x0428, B:100:0x0431, B:101:0x0456, B:105:0x0459, B:107:0x046a, B:108:0x0474, B:110:0x0486, B:111:0x049f, B:113:0x046f, B:114:0x03bd, B:115:0x03c4, B:116:0x03cb, B:117:0x03d2, B:118:0x03d8, B:119:0x03df, B:120:0x0370, B:123:0x037a, B:126:0x0383, B:129:0x038d, B:132:0x0397, B:135:0x03a1, B:138:0x0301, B:139:0x04a1, B:140:0x04a6, B:142:0x0237, B:144:0x023b, B:145:0x024c, B:148:0x0278, B:150:0x027c, B:151:0x028c, B:152:0x027f, B:154:0x0286, B:155:0x026e, B:157:0x0273, B:159:0x014f, B:161:0x0153, B:162:0x0159, B:165:0x019a, B:166:0x019d, B:167:0x020a, B:169:0x0218, B:171:0x021b, B:173:0x021f, B:176:0x01a0, B:177:0x01b3, B:178:0x01c8, B:179:0x01d7, B:180:0x01ee, B:181:0x01ff, B:182:0x015d, B:185:0x0167, B:188:0x0171, B:191:0x017b, B:194:0x0185, B:197:0x018f, B:201:0x0227, B:202:0x022d, B:203:0x04a8, B:204:0x04ad), top: B:3:0x0007, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.util.Map<java.lang.String, java.lang.String> r18) {
        /*
            Method dump skipped, instructions count: 1288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqk.a(java.util.Map):void");
    }

    public final void a(boolean z) {
        synchronized (this.j) {
            if (this.q != null) {
                this.q.dismiss();
                this.r.removeView(this.k.getView());
                if (this.s != null) {
                    this.s.removeView(this.n);
                    this.s.addView(this.k.getView());
                    this.k.a(this.m);
                }
                if (z) {
                    c("default");
                    if (this.p != null) {
                        this.p.a();
                    }
                }
                this.q = null;
                this.r = null;
                this.s = null;
                this.o = null;
            }
        }
    }

    public final void a(int i, int i2, boolean z) {
        synchronized (this.j) {
            this.d = i;
            this.e = i2;
            PopupWindow popupWindow = this.q;
        }
    }

    public final boolean a() {
        boolean z;
        synchronized (this.j) {
            z = this.q != null;
        }
        return z;
    }

    public final void a(int i, int i2) {
        this.d = i;
        this.e = i2;
    }
}
