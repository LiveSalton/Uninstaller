package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* compiled from: source */
/* loaded from: classes.dex */
public class s extends aq {
    private float a = 3.0f;
    private int b = 80;

    public void a(int i) {
        this.b = i;
    }

    @Override // androidx.transition.w
    public long a(ViewGroup viewGroup, Transition transition, y yVar, y yVar2) {
        int i;
        int i2;
        int i3;
        y yVar3 = yVar;
        if (yVar3 == null && yVar2 == null) {
            return 0L;
        }
        Rect o = transition.o();
        if (yVar2 == null || b(yVar3) == 0) {
            i = -1;
        } else {
            yVar3 = yVar2;
            i = 1;
        }
        int c = c(yVar3);
        int d = d(yVar3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int round = iArr[0] + Math.round(viewGroup.getTranslationX());
        int round2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = round + viewGroup.getWidth();
        int height = round2 + viewGroup.getHeight();
        if (o != null) {
            i2 = o.centerX();
            i3 = o.centerY();
        } else {
            i2 = (round + width) / 2;
            i3 = (round2 + height) / 2;
        }
        float a = a(viewGroup, c, d, i2, i3, round, round2, width, height) / a(viewGroup);
        long b = transition.b();
        if (b < 0) {
            b = 300;
        }
        return Math.round(((b * i) / this.a) * a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0017, code lost:
    
        r7 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0028, code lost:
    
        if ((androidx.core.h.w.h(r7) == 1) != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
    
        if ((androidx.core.h.w.h(r7) == 1) != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
    
        r7 = 5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a(android.view.View r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15) {
        /*
            r6 = this;
            int r0 = r6.b
            r1 = 3
            r2 = 5
            r3 = 0
            r4 = 1
            r5 = 8388611(0x800003, float:1.1754948E-38)
            if (r0 != r5) goto L19
            int r7 = androidx.core.h.w.h(r7)
            if (r7 != r4) goto L12
            goto L13
        L12:
            r4 = r3
        L13:
            if (r4 == 0) goto L17
        L15:
            r7 = r2
            goto L2d
        L17:
            r7 = r1
            goto L2d
        L19:
            int r0 = r6.b
            r5 = 8388613(0x800005, float:1.175495E-38)
            if (r0 != r5) goto L2b
            int r7 = androidx.core.h.w.h(r7)
            if (r7 != r4) goto L27
            goto L28
        L27:
            r4 = r3
        L28:
            if (r4 == 0) goto L15
            goto L17
        L2b:
            int r7 = r6.b
        L2d:
            if (r7 == r1) goto L55
            if (r7 == r2) goto L4c
            r11 = 48
            if (r7 == r11) goto L43
            r11 = 80
            if (r7 == r11) goto L3a
            goto L5d
        L3a:
            int r9 = r9 - r13
            int r10 = r10 - r8
            int r7 = java.lang.Math.abs(r10)
            int r3 = r9 + r7
            goto L5d
        L43:
            int r15 = r15 - r9
            int r10 = r10 - r8
            int r7 = java.lang.Math.abs(r10)
            int r3 = r15 + r7
            goto L5d
        L4c:
            int r8 = r8 - r12
            int r11 = r11 - r9
            int r7 = java.lang.Math.abs(r11)
            int r3 = r8 + r7
            goto L5d
        L55:
            int r14 = r14 - r8
            int r11 = r11 - r9
            int r7 = java.lang.Math.abs(r11)
            int r3 = r14 + r7
        L5d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.s.a(android.view.View, int, int, int, int, int, int, int, int):int");
    }

    private int a(ViewGroup viewGroup) {
        int i = this.b;
        if (i == 3 || i == 5 || i == 8388611 || i == 8388613) {
            return viewGroup.getWidth();
        }
        return viewGroup.getHeight();
    }
}
