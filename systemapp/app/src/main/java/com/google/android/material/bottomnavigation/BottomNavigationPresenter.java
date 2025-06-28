package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.r;

/* compiled from: source */
/* loaded from: classes.dex */
public class BottomNavigationPresenter implements m {
    private g a;
    private BottomNavigationMenuView b;
    private boolean c = false;
    private int d;

    @Override // androidx.appcompat.view.menu.m
    public void a(g gVar, boolean z) {
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(m.a aVar) {
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean a(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean a(r rVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean b(g gVar, i iVar) {
        return false;
    }

    public void a(BottomNavigationMenuView bottomNavigationMenuView) {
        this.b = bottomNavigationMenuView;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(Context context, g gVar) {
        this.a = gVar;
        this.b.a(this.a);
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(boolean z) {
        if (this.c) {
            return;
        }
        if (z) {
            this.b.b();
        } else {
            this.b.c();
        }
    }

    public void a(int i) {
        this.d = i;
    }

    @Override // androidx.appcompat.view.menu.m
    public int c() {
        return this.d;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable f() {
        SavedState savedState = new SavedState();
        savedState.a = this.b.getSelectedItemId();
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.b.b(((SavedState) parcelable).a);
        }
    }

    public void b(boolean z) {
        this.c = z;
    }

    /* compiled from: source */
    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.material.bottomnavigation.BottomNavigationPresenter.SavedState.1
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
        int a;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.a = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
        }

        /* compiled from: source */
        /* renamed from: com.google.android.material.bottomnavigation.BottomNavigationPresenter$SavedState$1 */
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
}
