package androidx.fragment.app;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;

/* compiled from: source */
@Deprecated
/* loaded from: classes.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    private final ArrayList<a> a;
    private Context b;
    private i c;
    private int d;
    private TabHost.OnTabChangeListener e;
    private a f;
    private boolean g;

    /* compiled from: source */
    static final class a {
        final String a;
        final Class<?> b;
        final Bundle c;
        Fragment d;
    }

    /* compiled from: source */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.fragment.app.FragmentTabHost.SavedState.1
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
        String a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.a + "}";
        }

        /* compiled from: source */
        /* renamed from: androidx.fragment.app.FragmentTabHost$SavedState$1 */
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

    @Deprecated
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new ArrayList<>();
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        this.d = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.e = onTabChangeListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.a.size();
        n nVar = null;
        for (int i = 0; i < size; i++) {
            a aVar = this.a.get(i);
            aVar.d = this.c.a(aVar.a);
            if (aVar.d != null && !aVar.d.u()) {
                if (aVar.a.equals(currentTabTag)) {
                    this.f = aVar;
                } else {
                    if (nVar == null) {
                        nVar = this.c.a();
                    }
                    nVar.a(aVar.d);
                }
            }
        }
        this.g = true;
        n a2 = a(currentTabTag, nVar);
        if (a2 != null) {
            a2.b();
            this.c.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g = false;
    }

    @Override // android.view.View
    @Deprecated
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = getCurrentTabTag();
        return savedState;
    }

    @Override // android.view.View
    @Deprecated
    protected void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.a);
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(String str) {
        n a2;
        if (this.g && (a2 = a(str, (n) null)) != null) {
            a2.b();
        }
        if (this.e != null) {
            this.e.onTabChanged(str);
        }
    }

    private n a(String str, n nVar) {
        a a2 = a(str);
        if (this.f != a2) {
            if (nVar == null) {
                nVar = this.c.a();
            }
            if (this.f != null && this.f.d != null) {
                nVar.a(this.f.d);
            }
            if (a2 != null) {
                if (a2.d == null) {
                    a2.d = this.c.y().c(this.b.getClassLoader(), a2.b.getName());
                    a2.d.b(a2.c);
                    nVar.a(this.d, a2.d, a2.a);
                } else {
                    nVar.b(a2.d);
                }
            }
            this.f = a2;
        }
        return nVar;
    }

    private a a(String str) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.a.get(i);
            if (aVar.a.equals(str)) {
                return aVar;
            }
        }
        return null;
    }
}
