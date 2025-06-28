package androidx.core.h.a;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;

/* compiled from: source */
/* loaded from: classes.dex */
public final class c {

    /* compiled from: source */
    public interface a {
        void a(boolean z);
    }

    public static boolean a(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.addTouchExplorationStateChangeListener(new b(aVar));
    }

    public static boolean b(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.removeTouchExplorationStateChangeListener(new b(aVar));
    }

    /* compiled from: source */
    private static final class b implements AccessibilityManager.TouchExplorationStateChangeListener {
        final a a;

        b(a aVar) {
            this.a = aVar;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z) {
            this.a.a(z);
        }
    }
}
