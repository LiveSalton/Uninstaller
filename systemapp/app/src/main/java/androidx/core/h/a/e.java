package androidx.core.h.a;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class e {
    private final Object a;

    public d a(int i) {
        return null;
    }

    public List<d> a(String str, int i) {
        return null;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    public d b(int i) {
        return null;
    }

    /* compiled from: source */
    static class a extends AccessibilityNodeProvider {
        final e a;

        a(e eVar) {
            this.a = eVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            d a = this.a.a(i);
            if (a == null) {
                return null;
            }
            return a.a();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List<d> a = this.a.a(str, i);
            if (a == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = a.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(a.get(i2).a());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.a.a(i, i2, bundle);
        }
    }

    /* compiled from: source */
    static class b extends a {
        b(e eVar) {
            super(eVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            d b = this.a.b(i);
            if (b == null) {
                return null;
            }
            return b.a();
        }
    }

    public e() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.a = new b(this);
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.a = new a(this);
        } else {
            this.a = null;
        }
    }

    public e(Object obj) {
        this.a = obj;
    }

    public Object a() {
        return this.a;
    }
}
