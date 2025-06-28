package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;

/* compiled from: source */
/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {
    final a a;
    final FrameLayout b;
    final FrameLayout c;
    androidx.core.h.b d;
    final DataSetObserver e;
    PopupWindow.OnDismissListener f;
    boolean g;
    int h;
    private final b i;
    private final View j;
    private final Drawable k;
    private final ImageView l;
    private final ImageView m;
    private final int n;
    private final ViewTreeObserver.OnGlobalLayoutListener o;
    private ListPopupWindow p;
    private boolean q;
    private int r;

    /* compiled from: source */
    /* renamed from: androidx.appcompat.widget.ActivityChooserView$1 */
    class AnonymousClass1 extends DataSetObserver {
        AnonymousClass1() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.a.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.a.notifyDataSetInvalidated();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.widget.ActivityChooserView$2 */
    class AnonymousClass2 implements ViewTreeObserver.OnGlobalLayoutListener {
        AnonymousClass2() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ActivityChooserView.this.c()) {
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().d();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().a_();
                if (ActivityChooserView.this.d != null) {
                    ActivityChooserView.this.d.a(true);
                }
            }
        }
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new DataSetObserver() { // from class: androidx.appcompat.widget.ActivityChooserView.1
            AnonymousClass1() {
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.a.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.a.notifyDataSetInvalidated();
            }
        };
        this.o = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.ActivityChooserView.2
            AnonymousClass2() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (ActivityChooserView.this.c()) {
                    if (!ActivityChooserView.this.isShown()) {
                        ActivityChooserView.this.getListPopupWindow().d();
                        return;
                    }
                    ActivityChooserView.this.getListPopupWindow().a_();
                    if (ActivityChooserView.this.d != null) {
                        ActivityChooserView.this.d.a(true);
                    }
                }
            }
        };
        this.h = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ActivityChooserView, i, 0);
        androidx.core.h.w.a(this, context, a.j.ActivityChooserView, attributeSet, obtainStyledAttributes, i, 0);
        this.h = obtainStyledAttributes.getInt(a.j.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(a.j.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(a.g.abc_activity_chooser_view, (ViewGroup) this, true);
        this.i = new b();
        this.j = findViewById(a.f.activity_chooser_view_content);
        this.k = this.j.getBackground();
        this.c = (FrameLayout) findViewById(a.f.default_activity_button);
        this.c.setOnClickListener(this.i);
        this.c.setOnLongClickListener(this.i);
        this.m = (ImageView) this.c.findViewById(a.f.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(a.f.expand_activities_button);
        frameLayout.setOnClickListener(this.i);
        frameLayout.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: androidx.appcompat.widget.ActivityChooserView.3
            AnonymousClass3() {
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                androidx.core.h.a.d.a(accessibilityNodeInfo).m(true);
            }
        });
        frameLayout.setOnTouchListener(new s(frameLayout) { // from class: androidx.appcompat.widget.ActivityChooserView.4
            AnonymousClass4(View frameLayout2) {
                super(frameLayout2);
            }

            @Override // androidx.appcompat.widget.s
            public androidx.appcompat.view.menu.p a() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            @Override // androidx.appcompat.widget.s
            protected boolean b() {
                ActivityChooserView.this.a();
                return true;
            }

            @Override // androidx.appcompat.widget.s
            protected boolean c() {
                ActivityChooserView.this.b();
                return true;
            }
        });
        this.b = frameLayout2;
        this.l = (ImageView) frameLayout2.findViewById(a.f.image);
        this.l.setImageDrawable(drawable);
        this.a = new a();
        this.a.registerDataSetObserver(new DataSetObserver() { // from class: androidx.appcompat.widget.ActivityChooserView.5
            AnonymousClass5() {
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.d();
            }
        });
        Resources resources = context.getResources();
        this.n = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.widget.ActivityChooserView$3 */
    class AnonymousClass3 extends View.AccessibilityDelegate {
        AnonymousClass3() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            androidx.core.h.a.d.a(accessibilityNodeInfo).m(true);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.widget.ActivityChooserView$4 */
    class AnonymousClass4 extends s {
        AnonymousClass4(View frameLayout2) {
            super(frameLayout2);
        }

        @Override // androidx.appcompat.widget.s
        public androidx.appcompat.view.menu.p a() {
            return ActivityChooserView.this.getListPopupWindow();
        }

        @Override // androidx.appcompat.widget.s
        protected boolean b() {
            ActivityChooserView.this.a();
            return true;
        }

        @Override // androidx.appcompat.widget.s
        protected boolean c() {
            ActivityChooserView.this.b();
            return true;
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.widget.ActivityChooserView$5 */
    class AnonymousClass5 extends DataSetObserver {
        AnonymousClass5() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.d();
        }
    }

    public void setActivityChooserModel(c cVar) {
        this.a.a(cVar);
        if (c()) {
            b();
            a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.l.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.l.setContentDescription(getContext().getString(i));
    }

    public void setProvider(androidx.core.h.b bVar) {
        this.d = bVar;
    }

    public boolean a() {
        if (c() || !this.q) {
            return false;
        }
        this.g = false;
        a(this.h);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [boolean, int] */
    void a(int i) {
        if (this.a.e() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.o);
        ?? r0 = this.c.getVisibility() == 0 ? 1 : 0;
        int c = this.a.c();
        if (i != Integer.MAX_VALUE && c > i + r0) {
            this.a.a(true);
            this.a.a(i - 1);
        } else {
            this.a.a(false);
            this.a.a(i);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (listPopupWindow.e()) {
            return;
        }
        if (this.g || r0 == 0) {
            this.a.a(true, r0);
        } else {
            this.a.a(false, false);
        }
        listPopupWindow.h(Math.min(this.a.a(), this.n));
        listPopupWindow.a_();
        if (this.d != null) {
            this.d.a(true);
        }
        listPopupWindow.g().setContentDescription(getContext().getString(a.h.abc_activitychooserview_choose_application));
        listPopupWindow.g().setSelector(new ColorDrawable(0));
    }

    public boolean b() {
        if (!c()) {
            return true;
        }
        getListPopupWindow().d();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.o);
        return true;
    }

    public boolean c() {
        return getListPopupWindow().e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        c e = this.a.e();
        if (e != null) {
            e.registerObserver(this.e);
        }
        this.q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c e = this.a.e();
        if (e != null) {
            e.unregisterObserver(this.e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.o);
        }
        if (c()) {
            b();
        }
        this.q = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View view = this.j;
        if (this.c.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.j.layout(0, 0, i3 - i, i4 - i2);
        if (c()) {
            return;
        }
        b();
    }

    public c getDataModel() {
        return this.a.e();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.h = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.r = i;
    }

    ListPopupWindow getListPopupWindow() {
        if (this.p == null) {
            this.p = new ListPopupWindow(getContext());
            this.p.a(this.a);
            this.p.b(this);
            this.p.a(true);
            this.p.a((AdapterView.OnItemClickListener) this.i);
            this.p.a((PopupWindow.OnDismissListener) this.i);
        }
        return this.p;
    }

    void d() {
        if (this.a.getCount() > 0) {
            this.b.setEnabled(true);
        } else {
            this.b.setEnabled(false);
        }
        int c = this.a.c();
        int d = this.a.d();
        if (c == 1 || (c > 1 && d > 0)) {
            this.c.setVisibility(0);
            ResolveInfo b2 = this.a.b();
            PackageManager packageManager = getContext().getPackageManager();
            this.m.setImageDrawable(b2.loadIcon(packageManager));
            if (this.r != 0) {
                this.c.setContentDescription(getContext().getString(this.r, b2.loadLabel(packageManager)));
            }
        } else {
            this.c.setVisibility(8);
        }
        if (this.c.getVisibility() == 0) {
            this.j.setBackgroundDrawable(this.k);
        } else {
            this.j.setBackgroundDrawable(null);
        }
    }

    /* compiled from: source */
    private class b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    ActivityChooserView.this.b();
                    if (ActivityChooserView.this.g) {
                        if (i > 0) {
                            ActivityChooserView.this.a.e().c(i);
                            return;
                        }
                        return;
                    }
                    if (!ActivityChooserView.this.a.f()) {
                        i++;
                    }
                    Intent b = ActivityChooserView.this.a.e().b(i);
                    if (b != null) {
                        b.addFlags(524288);
                        ActivityChooserView.this.getContext().startActivity(b);
                        return;
                    }
                    return;
                case 1:
                    ActivityChooserView.this.a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == ActivityChooserView.this.c) {
                ActivityChooserView.this.b();
                Intent b = ActivityChooserView.this.a.e().b(ActivityChooserView.this.a.e().a(ActivityChooserView.this.a.b()));
                if (b != null) {
                    b.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(b);
                    return;
                }
                return;
            }
            if (view == ActivityChooserView.this.b) {
                ActivityChooserView.this.g = false;
                ActivityChooserView.this.a(ActivityChooserView.this.h);
                return;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view == ActivityChooserView.this.c) {
                if (ActivityChooserView.this.a.getCount() > 0) {
                    ActivityChooserView.this.g = true;
                    ActivityChooserView.this.a(ActivityChooserView.this.h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            if (ActivityChooserView.this.d != null) {
                ActivityChooserView.this.d.a(false);
            }
        }

        private void a() {
            if (ActivityChooserView.this.f != null) {
                ActivityChooserView.this.f.onDismiss();
            }
        }
    }

    /* compiled from: source */
    private class a extends BaseAdapter {
        private c b;
        private int c = 4;
        private boolean d;
        private boolean e;
        private boolean f;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        a() {
        }

        public void a(c cVar) {
            c e = ActivityChooserView.this.a.e();
            if (e != null && ActivityChooserView.this.isShown()) {
                e.unregisterObserver(ActivityChooserView.this.e);
            }
            this.b = cVar;
            if (cVar != null && ActivityChooserView.this.isShown()) {
                cVar.registerObserver(ActivityChooserView.this.e);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (this.f && i == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int a = this.b.a();
            if (!this.d && this.b.b() != null) {
                a--;
            }
            int min = Math.min(a, this.c);
            return this.f ? min + 1 : min;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!this.d && this.b.b() != null) {
                        i++;
                    }
                    return this.b.a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != a.f.list_item) {
                        view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                    ImageView imageView = (ImageView) view.findViewById(a.f.icon);
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(a.f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.d && i == 0 && this.e) {
                        view.setActivated(true);
                    } else {
                        view.setActivated(false);
                    }
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, viewGroup, false);
                    inflate.setId(1);
                    ((TextView) inflate.findViewById(a.f.title)).setText(ActivityChooserView.this.getContext().getString(a.h.abc_activity_chooser_view_see_all));
                    return inflate;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int a() {
            int i = this.c;
            this.c = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            int i2 = 0;
            View view = null;
            for (int i3 = 0; i3 < count; i3++) {
                view = getView(i3, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = Math.max(i2, view.getMeasuredWidth());
            }
            this.c = i;
            return i2;
        }

        public void a(int i) {
            if (this.c != i) {
                this.c = i;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo b() {
            return this.b.b();
        }

        public void a(boolean z) {
            if (this.f != z) {
                this.f = z;
                notifyDataSetChanged();
            }
        }

        public int c() {
            return this.b.a();
        }

        public int d() {
            return this.b.c();
        }

        public c e() {
            return this.b;
        }

        public void a(boolean z, boolean z2) {
            if (this.d == z && this.e == z2) {
                return;
            }
            this.d = z;
            this.e = z2;
            notifyDataSetChanged();
        }

        public boolean f() {
            return this.d;
        }
    }

    /* compiled from: source */
    public static class InnerLayout extends LinearLayout {
        private static final int[] a = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            af a2 = af.a(context, attributeSet, a);
            setBackgroundDrawable(a2.a(0));
            a2.b();
        }
    }
}
