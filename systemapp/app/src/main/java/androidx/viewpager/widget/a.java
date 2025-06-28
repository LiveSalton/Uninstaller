package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class a {
    private final DataSetObservable a = new DataSetObservable();
    private DataSetObserver b;

    public abstract int a();

    public int a(Object obj) {
        return -1;
    }

    public CharSequence a(int i) {
        return null;
    }

    public void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Deprecated
    public void a(View view) {
    }

    public abstract boolean a(View view, Object obj);

    public float b(int i) {
        return 1.0f;
    }

    public Parcelable b() {
        return null;
    }

    @Deprecated
    public void b(View view) {
    }

    @Deprecated
    public void b(View view, int i, Object obj) {
    }

    public void a(ViewGroup viewGroup) {
        a((View) viewGroup);
    }

    public Object a(ViewGroup viewGroup, int i) {
        return a((View) viewGroup, i);
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        a((View) viewGroup, i, obj);
    }

    public void b(ViewGroup viewGroup, int i, Object obj) {
        b((View) viewGroup, i, obj);
    }

    public void b(ViewGroup viewGroup) {
        b((View) viewGroup);
    }

    @Deprecated
    public Object a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void a(DataSetObserver dataSetObserver) {
        this.a.registerObserver(dataSetObserver);
    }

    public void b(DataSetObserver dataSetObserver) {
        this.a.unregisterObserver(dataSetObserver);
    }

    void c(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.b = dataSetObserver;
        }
    }
}
