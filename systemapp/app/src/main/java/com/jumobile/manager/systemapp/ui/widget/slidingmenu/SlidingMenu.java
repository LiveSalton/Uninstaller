package com.jumobile.manager.systemapp.ui.widget.slidingmenu;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.jumobile.manager.systemapp.R;
import com.jumobile.manager.systemapp.ui.widget.slidingmenu.CustomViewAbove;

/* compiled from: source */
/* loaded from: classes.dex */
public class SlidingMenu extends RelativeLayout {
    private boolean a;
    private CustomViewAbove b;
    private CustomViewBehind c;
    private d d;
    private b e;
    private Handler f;

    /* compiled from: source */
    public interface a {
        void a(Canvas canvas, float f);
    }

    /* compiled from: source */
    public interface b {
        void a();
    }

    /* compiled from: source */
    public interface c {
        void a();
    }

    /* compiled from: source */
    public interface d {
        void a();
    }

    /* compiled from: source */
    public interface e {
        void a();
    }

    public SlidingMenu(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlidingMenu(Activity activity, int i) {
        this(activity, (AttributeSet) null);
        a(activity, i);
    }

    public SlidingMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
        this.f = new Handler();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.c = new CustomViewBehind(context);
        addView(this.c, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        this.b = new CustomViewAbove(context);
        addView(this.b, layoutParams2);
        this.b.setCustomViewBehind(this.c);
        this.c.setCustomViewAbove(this.b);
        this.b.setOnPageChangeListener(new CustomViewAbove.a() { // from class: com.jumobile.manager.systemapp.ui.widget.slidingmenu.SlidingMenu.1
            @Override // com.jumobile.manager.systemapp.ui.widget.slidingmenu.CustomViewAbove.a
            public void a(int i2, float f, int i3) {
            }

            AnonymousClass1() {
            }

            @Override // com.jumobile.manager.systemapp.ui.widget.slidingmenu.CustomViewAbove.a
            public void a(int i2) {
                if (i2 != 0 || SlidingMenu.this.d == null) {
                    if (i2 != 1 || SlidingMenu.this.e == null) {
                        return;
                    }
                    SlidingMenu.this.e.a();
                    return;
                }
                SlidingMenu.this.d.a();
            }
        });
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlidingMenu);
        setMode(obtainStyledAttributes.getInt(5, 0));
        int resourceId = obtainStyledAttributes.getResourceId(12, -1);
        if (resourceId != -1) {
            setContent(resourceId);
        } else {
            setContent(new FrameLayout(context));
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(13, -1);
        if (resourceId2 != -1) {
            setMenu(resourceId2);
        } else {
            setMenu(new FrameLayout(context));
        }
        setTouchModeAbove(obtainStyledAttributes.getInt(10, 0));
        setTouchModeBehind(obtainStyledAttributes.getInt(11, 0));
        int dimension = (int) obtainStyledAttributes.getDimension(0, -1.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(2, -1.0f);
        if (dimension != -1 && dimension2 != -1) {
            throw new IllegalStateException("Cannot set both behindOffset and behindWidth for a SlidingMenu");
        }
        if (dimension != -1) {
            setBehindOffset(dimension);
        } else if (dimension2 != -1) {
            setBehindWidth(dimension2);
        } else {
            setBehindOffset(0);
        }
        setBehindScrollScale(obtainStyledAttributes.getFloat(1, 0.33f));
        int resourceId3 = obtainStyledAttributes.getResourceId(8, -1);
        if (resourceId3 != -1) {
            setShadowDrawable(resourceId3);
        }
        setShadowWidth((int) obtainStyledAttributes.getDimension(9, 0.0f));
        setFadeEnabled(obtainStyledAttributes.getBoolean(4, true));
        setFadeDegree(obtainStyledAttributes.getFloat(3, 0.33f));
        setSelectorEnabled(obtainStyledAttributes.getBoolean(7, false));
        int resourceId4 = obtainStyledAttributes.getResourceId(6, -1);
        if (resourceId4 != -1) {
            setSelectorDrawable(resourceId4);
        }
        obtainStyledAttributes.recycle();
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.widget.slidingmenu.SlidingMenu$1 */
    class AnonymousClass1 implements CustomViewAbove.a {
        @Override // com.jumobile.manager.systemapp.ui.widget.slidingmenu.CustomViewAbove.a
        public void a(int i2, float f, int i3) {
        }

        AnonymousClass1() {
        }

        @Override // com.jumobile.manager.systemapp.ui.widget.slidingmenu.CustomViewAbove.a
        public void a(int i2) {
            if (i2 != 0 || SlidingMenu.this.d == null) {
                if (i2 != 1 || SlidingMenu.this.e == null) {
                    return;
                }
                SlidingMenu.this.e.a();
                return;
            }
            SlidingMenu.this.d.a();
        }
    }

    public void a(Activity activity, int i) {
        a(activity, i, false);
    }

    public void a(Activity activity, int i, boolean z) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("slideStyle must be either SLIDING_WINDOW or SLIDING_CONTENT");
        }
        if (getParent() != null) {
            throw new IllegalStateException("This SlidingMenu appears to already be attached");
        }
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{android.R.attr.windowBackground});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        switch (i) {
            case 0:
                this.a = false;
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
                viewGroup2.setBackgroundResource(resourceId);
                viewGroup.removeView(viewGroup2);
                viewGroup.addView(this);
                setContent(viewGroup2);
                return;
            case 1:
                this.a = z;
                ViewGroup viewGroup3 = (ViewGroup) activity.findViewById(android.R.id.content);
                View childAt = viewGroup3.getChildAt(0);
                viewGroup3.removeView(childAt);
                viewGroup3.addView(this);
                setContent(childAt);
                if (childAt.getBackground() == null) {
                    childAt.setBackgroundResource(resourceId);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setContent(int i) {
        setContent(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null));
    }

    public void setContent(View view) {
        this.b.setContent(view);
        a();
    }

    public View getContent() {
        return this.b.getContent();
    }

    public void setMenu(int i) {
        setMenu(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null));
    }

    public void setMenu(View view) {
        this.c.setContent(view);
    }

    public View getMenu() {
        return this.c.getContent();
    }

    public void setSecondaryMenu(int i) {
        setSecondaryMenu(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null));
    }

    public void setSecondaryMenu(View view) {
        this.c.setSecondaryContent(view);
    }

    public View getSecondaryMenu() {
        return this.c.getSecondaryContent();
    }

    public void setSlidingEnabled(boolean z) {
        this.b.setSlidingEnabled(z);
    }

    public void setMode(int i) {
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalStateException("SlidingMenu mode must be LEFT, RIGHT, or LEFT_RIGHT");
        }
        this.c.setMode(i);
    }

    public int getMode() {
        return this.c.getMode();
    }

    public void setStatic(boolean z) {
        if (z) {
            setSlidingEnabled(false);
            this.b.setCustomViewBehind(null);
            this.b.setCurrentItem(1);
        } else {
            this.b.setCurrentItem(1);
            this.b.setCustomViewBehind(this.c);
            setSlidingEnabled(true);
        }
    }

    public void a(boolean z) {
        this.b.a(0, z);
    }

    public void b(boolean z) {
        this.b.a(2, z);
    }

    public void a() {
        c(true);
    }

    public void c(boolean z) {
        this.b.a(1, z);
    }

    public boolean b() {
        return this.b.getCurrentItem() == 0 || this.b.getCurrentItem() == 2;
    }

    public boolean c() {
        return this.b.getCurrentItem() == 2;
    }

    public int getBehindOffset() {
        return ((RelativeLayout.LayoutParams) this.c.getLayoutParams()).rightMargin;
    }

    public void setBehindOffset(int i) {
        this.c.setWidthOffset(i);
    }

    public void setBehindOffsetRes(int i) {
        setBehindOffset((int) getContext().getResources().getDimension(i));
    }

    public void setAboveOffset(int i) {
        this.b.setAboveOffset(i);
    }

    public void setAboveOffsetRes(int i) {
        setAboveOffset((int) getContext().getResources().getDimension(i));
    }

    public void setBehindWidth(int i) {
        int width;
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        try {
            Point point = new Point();
            Display.class.getMethod("getSize", Point.class).invoke(defaultDisplay, point);
            width = point.x;
        } catch (Exception unused) {
            width = defaultDisplay.getWidth();
        }
        setBehindOffset(width - i);
    }

    public void setBehindWidthRes(int i) {
        setBehindWidth((int) getContext().getResources().getDimension(i));
    }

    public float getBehindScrollScale() {
        return this.c.getScrollScale();
    }

    public int getTouchmodeMarginThreshold() {
        return this.c.getMarginThreshold();
    }

    public void setTouchmodeMarginThreshold(int i) {
        this.c.setMarginThreshold(i);
    }

    public void setBehindScrollScale(float f) {
        if (f < 0.0f && f > 1.0f) {
            throw new IllegalStateException("ScrollScale must be between 0 and 1");
        }
        this.c.setScrollScale(f);
    }

    public void setBehindCanvasTransformer(a aVar) {
        this.c.setCanvasTransformer(aVar);
    }

    public int getTouchModeAbove() {
        return this.b.getTouchMode();
    }

    public void setTouchModeAbove(int i) {
        if (i != 1 && i != 0 && i != 2) {
            throw new IllegalStateException("TouchMode must be set to eitherTOUCHMODE_FULLSCREEN or TOUCHMODE_MARGIN or TOUCHMODE_NONE.");
        }
        this.b.setTouchMode(i);
    }

    public void setTouchModeBehind(int i) {
        if (i != 1 && i != 0 && i != 2) {
            throw new IllegalStateException("TouchMode must be set to eitherTOUCHMODE_FULLSCREEN or TOUCHMODE_MARGIN or TOUCHMODE_NONE.");
        }
        this.c.setTouchMode(i);
    }

    public void setShadowDrawable(int i) {
        setShadowDrawable(getContext().getResources().getDrawable(i));
    }

    public void setShadowDrawable(Drawable drawable) {
        this.c.setShadowDrawable(drawable);
    }

    public void setSecondaryShadowDrawable(int i) {
        setSecondaryShadowDrawable(getContext().getResources().getDrawable(i));
    }

    public void setSecondaryShadowDrawable(Drawable drawable) {
        this.c.setSecondaryShadowDrawable(drawable);
    }

    public void setShadowWidthRes(int i) {
        setShadowWidth((int) getResources().getDimension(i));
    }

    public void setShadowWidth(int i) {
        this.c.setShadowWidth(i);
    }

    public void setFadeEnabled(boolean z) {
        this.c.setFadeEnabled(z);
    }

    public void setFadeDegree(float f) {
        this.c.setFadeDegree(f);
    }

    public void setSelectorEnabled(boolean z) {
        this.c.setSelectorEnabled(true);
    }

    public void setSelectedView(View view) {
        this.c.setSelectedView(view);
    }

    public void setSelectorDrawable(int i) {
        this.c.setSelectorBitmap(BitmapFactory.decodeResource(getResources(), i));
    }

    public void setSelectorBitmap(Bitmap bitmap) {
        this.c.setSelectorBitmap(bitmap);
    }

    public void setOnOpenListener(d dVar) {
        this.d = dVar;
    }

    public void setOnCloseListener(b bVar) {
        this.e = bVar;
    }

    public void setOnOpenedListener(e eVar) {
        this.b.setOnOpenedListener(eVar);
    }

    public void setOnClosedListener(c cVar) {
        this.b.setOnClosedListener(cVar);
    }

    /* compiled from: source */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.jumobile.manager.systemapp.ui.widget.slidingmenu.SlidingMenu.SavedState.1
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private final int a;

        /* synthetic */ SavedState(Parcel parcel, AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.a = i;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }

        public int a() {
            return this.a;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.ui.widget.slidingmenu.SlidingMenu$SavedState$1 */
        static class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.b.getCurrentItem());
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.b.setCurrentItem(savedState.a());
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    protected boolean fitSystemWindows(Rect rect) {
        int i = rect.left;
        int i2 = rect.right;
        int i3 = rect.top;
        int i4 = rect.bottom;
        if (this.a) {
            return true;
        }
        Log.v("SlidingMenu", "setting padding!");
        setPadding(i, i3, i2, i4);
        return true;
    }

    @TargetApi(11)
    public void a(float f) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1)) > 0 && (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1)) < 0 ? 2 : 0;
        if (i != getContent().getLayerType()) {
            this.f.post(new Runnable() { // from class: com.jumobile.manager.systemapp.ui.widget.slidingmenu.SlidingMenu.2
                final /* synthetic */ int a;

                AnonymousClass2(int i2) {
                    i = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("changing layerType. hardware? ");
                    sb.append(i == 2);
                    Log.v("SlidingMenu", sb.toString());
                    SlidingMenu.this.getContent().setLayerType(i, null);
                    SlidingMenu.this.getMenu().setLayerType(i, null);
                    if (SlidingMenu.this.getSecondaryMenu() != null) {
                        SlidingMenu.this.getSecondaryMenu().setLayerType(i, null);
                    }
                }
            });
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.widget.slidingmenu.SlidingMenu$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int a;

        AnonymousClass2(int i2) {
            i = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb = new StringBuilder();
            sb.append("changing layerType. hardware? ");
            sb.append(i == 2);
            Log.v("SlidingMenu", sb.toString());
            SlidingMenu.this.getContent().setLayerType(i, null);
            SlidingMenu.this.getMenu().setLayerType(i, null);
            if (SlidingMenu.this.getSecondaryMenu() != null) {
                SlidingMenu.this.getSecondaryMenu().setLayerType(i, null);
            }
        }
    }
}
