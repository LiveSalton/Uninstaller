package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: source */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() { // from class: androidx.fragment.app.FragmentManagerState.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FragmentManagerState[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    };
    ArrayList<FragmentState> a;
    ArrayList<String> b;
    BackStackState[] c;
    int d;
    String e;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public FragmentManagerState() {
        this.e = null;
    }

    public FragmentManagerState(Parcel parcel) {
        this.e = null;
        this.a = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.b = parcel.createStringArrayList();
        this.c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.d = parcel.readInt();
        this.e = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.a);
        parcel.writeStringList(this.b);
        parcel.writeTypedArray(this.c, i);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.FragmentManagerState$1 */
    static class AnonymousClass1 implements Parcelable.Creator<FragmentManagerState> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FragmentManagerState[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    }
}
