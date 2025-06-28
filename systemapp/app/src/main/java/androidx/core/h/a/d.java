package androidx.core.h.a;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.a;
import androidx.core.h.a.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class d {
    private static int d;
    private final AccessibilityNodeInfo b;
    public int a = -1;
    private int c = -1;

    private static String c(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            default:
                switch (i) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            default:
                                switch (i) {
                                    case 4:
                                        return "ACTION_SELECT";
                                    case 8:
                                        return "ACTION_CLEAR_SELECTION";
                                    case 16:
                                        return "ACTION_CLICK";
                                    case 32:
                                        return "ACTION_LONG_CLICK";
                                    case 64:
                                        return "ACTION_ACCESSIBILITY_FOCUS";
                                    case 128:
                                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                                    case 256:
                                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                                    case 512:
                                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                                    case 1024:
                                        return "ACTION_NEXT_HTML_ELEMENT";
                                    case 2048:
                                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                                    case 4096:
                                        return "ACTION_SCROLL_FORWARD";
                                    case 8192:
                                        return "ACTION_SCROLL_BACKWARD";
                                    case 16384:
                                        return "ACTION_COPY";
                                    case 32768:
                                        return "ACTION_PASTE";
                                    case 65536:
                                        return "ACTION_CUT";
                                    case 131072:
                                        return "ACTION_SET_SELECTION";
                                    case 262144:
                                        return "ACTION_EXPAND";
                                    case 524288:
                                        return "ACTION_COLLAPSE";
                                    case 2097152:
                                        return "ACTION_SET_TEXT";
                                    case R.id.accessibilityActionMoveWindow:
                                        return "ACTION_MOVE_WINDOW";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    /* compiled from: source */
    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a a = new a(1, null);
        public static final a b = new a(2, null);
        public static final a c = new a(4, null);
        public static final a d = new a(8, null);
        public static final a e = new a(16, null);
        public static final a f = new a(32, null);
        public static final a g = new a(64, null);
        public static final a h = new a(128, null);
        public static final a i = new a(256, null, g.b.class);
        public static final a j = new a(512, null, g.b.class);
        public static final a k = new a(1024, null, g.c.class);
        public static final a l = new a(2048, null, g.c.class);
        public static final a m = new a(4096, null);
        public static final a n = new a(8192, null);
        public static final a o = new a(16384, null);
        public static final a p = new a(32768, null);
        public static final a q = new a(65536, null);
        public static final a r = new a(131072, null, g.C0026g.class);
        public static final a s = new a(262144, null);
        public static final a t = new a(524288, null);
        public static final a u = new a(1048576, null);
        public static final a v = new a(2097152, null, g.h.class);
        public static final a w;
        public static final a x;
        public static final a y;
        public static final a z;
        final Object L;
        protected final g M;
        private final int N;
        private final Class<? extends g.a> O;

        static {
            w = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
            x = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R.id.accessibilityActionScrollToPosition, null, null, g.e.class);
            y = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
            z = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id.accessibilityActionScrollLeft, null, null, null);
            A = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id.accessibilityActionScrollDown, null, null, null);
            B = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
            C = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            D = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            E = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            F = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            G = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id.accessibilityActionContextClick, null, null, null);
            H = new a(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, g.f.class);
            I = new a(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, g.d.class);
            J = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            K = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
        }

        public a(int i2, CharSequence charSequence) {
            this(null, i2, charSequence, null, null);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        private a(int i2, CharSequence charSequence, Class<? extends g.a> cls) {
            this(null, i2, charSequence, null, cls);
        }

        a(Object obj, int i2, CharSequence charSequence, g gVar, Class<? extends g.a> cls) {
            this.N = i2;
            this.M = gVar;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                this.L = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            } else {
                this.L = obj;
            }
            this.O = cls;
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.L).getId();
            }
            return 0;
        }

        public CharSequence b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.L).getLabel();
            }
            return null;
        }

        public boolean a(View view, Bundle bundle) {
            g.a newInstance;
            if (this.M == null) {
                return false;
            }
            g.a aVar = null;
            if (this.O != null) {
                try {
                    newInstance = this.O.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    newInstance.a(bundle);
                    aVar = newInstance;
                } catch (Exception e3) {
                    e = e3;
                    aVar = newInstance;
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (this.O == null ? "null" : this.O.getName()), e);
                    return this.M.a(view, aVar);
                }
            }
            return this.M.a(view, aVar);
        }

        public a a(CharSequence charSequence, g gVar) {
            return new a(null, this.N, charSequence, gVar, this.O);
        }

        public int hashCode() {
            if (this.L != null) {
                return this.L.hashCode();
            }
            return 0;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.L == null ? aVar.L == null : this.L.equals(aVar.L);
        }
    }

    /* compiled from: source */
    public static class b {
        final Object a;

        public static b a(int i, int i2, boolean z, int i3) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new b(null);
        }

        b(Object obj) {
            this.a = obj;
        }
    }

    /* compiled from: source */
    public static class c {
        final Object a;

        public static c a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new c(null);
        }

        c(Object obj) {
            this.a = obj;
        }
    }

    private d(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.b = accessibilityNodeInfo;
    }

    public static d a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new d(accessibilityNodeInfo);
    }

    public AccessibilityNodeInfo a() {
        return this.b;
    }

    public static d a(View view) {
        return a(AccessibilityNodeInfo.obtain(view));
    }

    public static d b() {
        return a(AccessibilityNodeInfo.obtain());
    }

    public static d a(d dVar) {
        return a(AccessibilityNodeInfo.obtain(dVar.b));
    }

    public void b(View view) {
        this.c = -1;
        this.b.setSource(view);
    }

    public void a(View view, int i) {
        this.c = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.b.setSource(view, i);
        }
    }

    public int c() {
        return this.b.getChildCount();
    }

    public void c(View view) {
        this.b.addChild(view);
    }

    public void b(View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.b.addChild(view, i);
        }
    }

    public int d() {
        return this.b.getActions();
    }

    public void a(int i) {
        this.b.addAction(i);
    }

    private List<Integer> a(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.b.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.b.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public void a(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.b.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.L);
        }
    }

    public boolean b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.b.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.L);
        }
        return false;
    }

    public boolean a(int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.b.performAction(i, bundle);
        }
        return false;
    }

    public void b(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.b.setMovementGranularities(i);
        }
    }

    public int e() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.b.getMovementGranularities();
        }
        return 0;
    }

    public void d(View view) {
        this.a = -1;
        this.b.setParent(view);
    }

    public void c(View view, int i) {
        this.a = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.b.setParent(view, i);
        }
    }

    @Deprecated
    public void a(Rect rect) {
        this.b.getBoundsInParent(rect);
    }

    @Deprecated
    public void b(Rect rect) {
        this.b.setBoundsInParent(rect);
    }

    public void c(Rect rect) {
        this.b.getBoundsInScreen(rect);
    }

    public void d(Rect rect) {
        this.b.setBoundsInScreen(rect);
    }

    public boolean f() {
        return this.b.isCheckable();
    }

    public void a(boolean z) {
        this.b.setCheckable(z);
    }

    public boolean g() {
        return this.b.isChecked();
    }

    public void b(boolean z) {
        this.b.setChecked(z);
    }

    public boolean h() {
        return this.b.isFocusable();
    }

    public void c(boolean z) {
        this.b.setFocusable(z);
    }

    public boolean i() {
        return this.b.isFocused();
    }

    public void d(boolean z) {
        this.b.setFocused(z);
    }

    public boolean j() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.b.isVisibleToUser();
        }
        return false;
    }

    public void e(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.b.setVisibleToUser(z);
        }
    }

    public boolean k() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.b.isAccessibilityFocused();
        }
        return false;
    }

    public void f(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.b.setAccessibilityFocused(z);
        }
    }

    public boolean l() {
        return this.b.isSelected();
    }

    public void g(boolean z) {
        this.b.setSelected(z);
    }

    public boolean m() {
        return this.b.isClickable();
    }

    public void h(boolean z) {
        this.b.setClickable(z);
    }

    public boolean n() {
        return this.b.isLongClickable();
    }

    public void i(boolean z) {
        this.b.setLongClickable(z);
    }

    public boolean o() {
        return this.b.isEnabled();
    }

    public void j(boolean z) {
        this.b.setEnabled(z);
    }

    public boolean p() {
        return this.b.isPassword();
    }

    public boolean q() {
        return this.b.isScrollable();
    }

    public void k(boolean z) {
        this.b.setScrollable(z);
    }

    public CharSequence r() {
        return this.b.getPackageName();
    }

    public void a(CharSequence charSequence) {
        this.b.setPackageName(charSequence);
    }

    public CharSequence s() {
        return this.b.getClassName();
    }

    public void b(CharSequence charSequence) {
        this.b.setClassName(charSequence);
    }

    public CharSequence t() {
        if (z()) {
            List<Integer> a2 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List<Integer> a3 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List<Integer> a4 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List<Integer> a5 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SpannableString spannableString = new SpannableString(TextUtils.substring(this.b.getText(), 0, this.b.getText().length()));
            for (int i = 0; i < a2.size(); i++) {
                spannableString.setSpan(new androidx.core.h.a.a(a5.get(i).intValue(), this, y().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), a2.get(i).intValue(), a3.get(i).intValue(), a4.get(i).intValue());
            }
            return spannableString;
        }
        return this.b.getText();
    }

    public void c(CharSequence charSequence) {
        this.b.setText(charSequence);
    }

    public void a(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 26) {
            return;
        }
        A();
        g(view);
        ClickableSpan[] d2 = d(charSequence);
        if (d2 == null || d2.length <= 0) {
            return;
        }
        y().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", a.b.accessibility_action_clickable_span);
        SparseArray<WeakReference<ClickableSpan>> e = e(view);
        for (int i = 0; d2 != null && i < d2.length; i++) {
            int a2 = a(d2[i], e);
            e.put(a2, new WeakReference<>(d2[i]));
            a(d2[i], (Spanned) charSequence, a2);
        }
    }

    private SparseArray<WeakReference<ClickableSpan>> e(View view) {
        SparseArray<WeakReference<ClickableSpan>> f = f(view);
        if (f != null) {
            return f;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(a.b.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> f(View view) {
        return (SparseArray) view.getTag(a.b.tag_accessibility_clickable_spans);
    }

    public static ClickableSpan[] d(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private int a(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals(sparseArray.valueAt(i).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = d;
        d = i2 + 1;
        return i2;
    }

    private boolean z() {
        return !a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private void A() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private void a(ClickableSpan clickableSpan, Spanned spanned, int i) {
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
    }

    private void g(View view) {
        SparseArray<WeakReference<ClickableSpan>> f = f(view);
        if (f != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < f.size(); i++) {
                if (f.valueAt(i).get() == null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                f.remove(((Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    public CharSequence u() {
        return this.b.getContentDescription();
    }

    public void e(CharSequence charSequence) {
        this.b.setContentDescription(charSequence);
    }

    public void v() {
        this.b.recycle();
    }

    public String w() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.b.getViewIdResourceName();
        }
        return null;
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.b.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).a);
        }
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.b.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).a);
        }
    }

    public List<a> x() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.b.getActionList() : null;
        if (actionList != null) {
            ArrayList arrayList = new ArrayList();
            int size = actionList.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new a(actionList.get(i)));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void l(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.b.setContentInvalid(z);
        }
    }

    public void f(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.b.setHintText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void g(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.b.setError(charSequence);
        }
    }

    public void m(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.b.setCanOpenPopup(z);
        }
    }

    public Bundle y() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.b.getExtras();
        }
        return new Bundle();
    }

    public void h(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.b.setPaneTitle(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void n(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.b.setScreenReaderFocusable(z);
        } else {
            a(1, z);
        }
    }

    public void o(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.b.setShowingHintText(z);
        } else {
            a(4, z);
        }
    }

    public void p(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.b.setHeading(z);
        } else {
            a(2, z);
        }
    }

    public int hashCode() {
        if (this.b == null) {
            return 0;
        }
        return this.b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.b == null) {
            if (dVar.b != null) {
                return false;
            }
        } else if (!this.b.equals(dVar.b)) {
            return false;
        }
        return this.c == dVar.c && this.a == dVar.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: " + rect);
        c(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(r());
        sb.append("; className: ");
        sb.append(s());
        sb.append("; text: ");
        sb.append(t());
        sb.append("; contentDescription: ");
        sb.append(u());
        sb.append("; viewId: ");
        sb.append(w());
        sb.append("; checkable: ");
        sb.append(f());
        sb.append("; checked: ");
        sb.append(g());
        sb.append("; focusable: ");
        sb.append(h());
        sb.append("; focused: ");
        sb.append(i());
        sb.append("; selected: ");
        sb.append(l());
        sb.append("; clickable: ");
        sb.append(m());
        sb.append("; longClickable: ");
        sb.append(n());
        sb.append("; enabled: ");
        sb.append(o());
        sb.append("; password: ");
        sb.append(p());
        sb.append("; scrollable: " + q());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> x = x();
            for (int i = 0; i < x.size(); i++) {
                a aVar = x.get(i);
                String c2 = c(aVar.a());
                if (c2.equals("ACTION_UNKNOWN") && aVar.b() != null) {
                    c2 = aVar.b().toString();
                }
                sb.append(c2);
                if (i != x.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int d2 = d();
            while (d2 != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(d2);
                d2 &= ~numberOfTrailingZeros;
                sb.append(c(numberOfTrailingZeros));
                if (d2 != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void a(int i, boolean z) {
        Bundle y = y();
        if (y != null) {
            int i2 = y.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i);
            if (!z) {
                i = 0;
            }
            y.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }
}
