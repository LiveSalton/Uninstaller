package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: source */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new Parcelable.Creator<ParcelImpl>() { // from class: androidx.versionedparcelable.ParcelImpl.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ParcelImpl[] newArray(int i) {
            return new ParcelImpl[i];
        }
    };
    private final c a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected ParcelImpl(Parcel parcel) {
        this.a = new b(parcel).j();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        new b(parcel).a(this.a);
    }

    /* compiled from: source */
    /* renamed from: androidx.versionedparcelable.ParcelImpl$1 */
    static class AnonymousClass1 implements Parcelable.Creator<ParcelImpl> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ParcelImpl[] newArray(int i) {
            return new ParcelImpl[i];
        }
    }
}
