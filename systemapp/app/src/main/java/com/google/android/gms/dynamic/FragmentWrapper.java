package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IFragmentWrapper;

/* compiled from: source */
@KeepForSdk
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public final class FragmentWrapper extends IFragmentWrapper.Stub {
    private Fragment a;

    @KeepForSdk
    public static FragmentWrapper a(Fragment fragment) {
        if (fragment != null) {
            return new FragmentWrapper(fragment);
        }
        return null;
    }

    private FragmentWrapper(Fragment fragment) {
        this.a = fragment;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper a() {
        return ObjectWrapper.a(this.a.getActivity());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final Bundle b() {
        return this.a.getArguments();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int c() {
        return this.a.getId();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper d() {
        return a(this.a.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper e() {
        return ObjectWrapper.a(this.a.getResources());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean f() {
        return this.a.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final String g() {
        return this.a.getTag();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper h() {
        return a(this.a.getTargetFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int i() {
        return this.a.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean j() {
        return this.a.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper k() {
        return ObjectWrapper.a(this.a.getView());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean l() {
        return this.a.isAdded();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean m() {
        return this.a.isDetached();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean n() {
        return this.a.isHidden();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean o() {
        return this.a.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean p() {
        return this.a.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean q() {
        return this.a.isResumed();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean r() {
        return this.a.isVisible();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void a(IObjectWrapper iObjectWrapper) {
        this.a.registerForContextMenu((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void a(boolean z) {
        this.a.setHasOptionsMenu(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void b(boolean z) {
        this.a.setMenuVisibility(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void c(boolean z) {
        this.a.setRetainInstance(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void d(boolean z) {
        this.a.setUserVisibleHint(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void a(Intent intent) {
        this.a.startActivity(intent);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void a(Intent intent, int i) {
        this.a.startActivityForResult(intent, i);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void b(IObjectWrapper iObjectWrapper) {
        this.a.unregisterForContextMenu((View) ObjectWrapper.a(iObjectWrapper));
    }
}
