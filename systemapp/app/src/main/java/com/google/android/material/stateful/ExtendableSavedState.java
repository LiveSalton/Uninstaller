package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.b.g;
import androidx.customview.view.AbsSavedState;

/* compiled from: source */
/* loaded from: classes.dex */
public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new Parcelable.ClassLoaderCreator<ExtendableSavedState>() { // from class: com.google.android.material.stateful.ExtendableSavedState.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: a */
        public ExtendableSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new ExtendableSavedState(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ExtendableSavedState createFromParcel(Parcel parcel) {
            return new ExtendableSavedState(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ExtendableSavedState[] newArray(int i) {
            return new ExtendableSavedState[i];
        }
    };
    public final g<String, Bundle> a;

    /* synthetic */ ExtendableSavedState(Parcel parcel, ClassLoader classLoader, AnonymousClass1 anonymousClass1) {
        this(parcel, classLoader);
    }

    public ExtendableSavedState(Parcelable parcelable) {
        super(parcelable);
        this.a = new g<>();
    }

    private ExtendableSavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.a = new g<>(readInt);
        for (int i = 0; i < readInt; i++) {
            this.a.put(strArr[i], bundleArr[i]);
        }
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        int size = this.a.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = this.a.b(i2);
            bundleArr[i2] = this.a.c(i2);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.a + "}";
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.stateful.ExtendableSavedState$1 */
    static class AnonymousClass1 implements Parcelable.ClassLoaderCreator<ExtendableSavedState> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: a */
        public ExtendableSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new ExtendableSavedState(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ExtendableSavedState createFromParcel(Parcel parcel) {
            return new ExtendableSavedState(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ExtendableSavedState[] newArray(int i) {
            return new ExtendableSavedState[i];
        }
    }
}
