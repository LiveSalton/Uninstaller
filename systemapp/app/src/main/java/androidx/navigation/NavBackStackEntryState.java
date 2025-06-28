package androidx.navigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

/* compiled from: source */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class NavBackStackEntryState implements Parcelable {
    public static final Parcelable.Creator<NavBackStackEntryState> CREATOR = new Parcelable.Creator<NavBackStackEntryState>() { // from class: androidx.navigation.NavBackStackEntryState.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public NavBackStackEntryState createFromParcel(Parcel parcel) {
            return new NavBackStackEntryState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public NavBackStackEntryState[] newArray(int i) {
            return new NavBackStackEntryState[i];
        }
    };
    private final UUID a;
    private final int b;
    private final Bundle c;
    private final Bundle d;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    NavBackStackEntryState(Parcel parcel) {
        this.a = UUID.fromString(parcel.readString());
        this.b = parcel.readInt();
        this.c = parcel.readBundle(getClass().getClassLoader());
        this.d = parcel.readBundle(getClass().getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a.toString());
        parcel.writeInt(this.b);
        parcel.writeBundle(this.c);
        parcel.writeBundle(this.d);
    }

    /* compiled from: source */
    /* renamed from: androidx.navigation.NavBackStackEntryState$1 */
    class AnonymousClass1 implements Parcelable.Creator<NavBackStackEntryState> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public NavBackStackEntryState createFromParcel(Parcel parcel) {
            return new NavBackStackEntryState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public NavBackStackEntryState[] newArray(int i) {
            return new NavBackStackEntryState[i];
        }
    }
}
