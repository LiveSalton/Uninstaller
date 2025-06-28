package androidx.customview.view;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: source */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public abstract class AbsSavedState implements Parcelable {
    private final Parcelable a;
    public static final AbsSavedState c = new AbsSavedState() { // from class: androidx.customview.view.AbsSavedState.1
        AnonymousClass1() {
        }
    };
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new Parcelable.ClassLoaderCreator<AbsSavedState>() { // from class: androidx.customview.view.AbsSavedState.2
        AnonymousClass2() {
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: a */
        public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) != null) {
                throw new IllegalStateException("superState must be null");
            }
            return AbsSavedState.c;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AbsSavedState[] newArray(int i) {
            return new AbsSavedState[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* compiled from: source */
    /* renamed from: androidx.customview.view.AbsSavedState$1 */
    class AnonymousClass1 extends AbsSavedState {
        AnonymousClass1() {
        }
    }

    /* synthetic */ AbsSavedState(AnonymousClass1 anonymousClass1) {
        this();
    }

    private AbsSavedState() {
        this.a = null;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.a = parcelable == c ? null : parcelable;
    }

    protected AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.a = readParcelable == null ? c : readParcelable;
    }

    public final Parcelable a() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
    }

    /* compiled from: source */
    /* renamed from: androidx.customview.view.AbsSavedState$2 */
    class AnonymousClass2 implements Parcelable.ClassLoaderCreator<AbsSavedState> {
        AnonymousClass2() {
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: a */
        public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) != null) {
                throw new IllegalStateException("superState must be null");
            }
            return AbsSavedState.c;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AbsSavedState[] newArray(int i) {
            return new AbsSavedState[i];
        }
    }
}
