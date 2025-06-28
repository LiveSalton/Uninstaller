package androidx.core.h.a;

import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* compiled from: source */
/* loaded from: classes.dex */
public class f {
    private final AccessibilityRecord a;

    public static void a(AccessibilityRecord accessibilityRecord, View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            accessibilityRecord.setSource(view, i);
        }
    }

    public static void a(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    @Deprecated
    public int hashCode() {
        if (this.a == null) {
            return 0;
        }
        return this.a.hashCode();
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.a == null) {
            if (fVar.a != null) {
                return false;
            }
        } else if (!this.a.equals(fVar.a)) {
            return false;
        }
        return true;
    }
}
