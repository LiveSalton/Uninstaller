package androidx.core.h;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.a;
import androidx.core.h.a.d;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class a {
    private static final View.AccessibilityDelegate a = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate b;
    private final View.AccessibilityDelegate c;

    /* compiled from: source */
    /* renamed from: androidx.core.h.a$a */
    static final class C0025a extends View.AccessibilityDelegate {
        final a a;

        C0025a(a aVar) {
            this.a = aVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.a.b(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.d(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            androidx.core.h.a.d a = androidx.core.h.a.d.a(accessibilityNodeInfo);
            a.n(w.I(view));
            a.p(w.K(view));
            a.h(w.J(view));
            this.a.a(view, a);
            a.a(accessibilityNodeInfo.getText(), view);
            List<d.a> b = a.b(view);
            for (int i = 0; i < b.size(); i++) {
                a.a(b.get(i));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.c(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.a.a(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            this.a.a(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            androidx.core.h.a.e a = this.a.a(view);
            if (a != null) {
                return (AccessibilityNodeProvider) a.a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.a.a(view, i, bundle);
        }
    }

    public a() {
        this(a);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.b = accessibilityDelegate;
        this.c = new C0025a(this);
    }

    View.AccessibilityDelegate a() {
        return this.c;
    }

    public void a(View view, int i) {
        this.b.sendAccessibilityEvent(view, i);
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        this.b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean b(View view, AccessibilityEvent accessibilityEvent) {
        return this.b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.b.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        this.b.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void a(View view, androidx.core.h.a.d dVar) {
        this.b.onInitializeAccessibilityNodeInfo(view, dVar.a());
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public androidx.core.h.a.e a(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.b.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new androidx.core.h.a.e(accessibilityNodeProvider);
    }

    public boolean a(View view, int i, Bundle bundle) {
        List<d.a> b = b(view);
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= b.size()) {
                break;
            }
            d.a aVar = b.get(i2);
            if (aVar.a() == i) {
                z = aVar.a(view, bundle);
                break;
            }
            i2++;
        }
        if (!z && Build.VERSION.SDK_INT >= 16) {
            z = this.b.performAccessibilityAction(view, i, bundle);
        }
        return (z || i != a.b.accessibility_action_clickable_span) ? z : a(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    private boolean a(int i, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(a.b.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!a(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    private boolean a(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] d = androidx.core.h.a.d.d(view.createAccessibilityNodeInfo().getText());
            for (int i = 0; d != null && i < d.length; i++) {
                if (clickableSpan.equals(d[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    static List<d.a> b(View view) {
        List<d.a> list = (List) view.getTag(a.b.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }
}
