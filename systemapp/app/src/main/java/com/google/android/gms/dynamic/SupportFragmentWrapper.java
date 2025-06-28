package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IFragmentWrapper;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public final class SupportFragmentWrapper extends IFragmentWrapper.Stub {
    private Fragment a;

    @KeepForSdk
    public static SupportFragmentWrapper a(Fragment fragment) {
        if (fragment != null) {
            return new SupportFragmentWrapper(fragment);
        }
        return null;
    }

    private SupportFragmentWrapper(Fragment fragment) {
        this.a = fragment;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper a() {
        return ObjectWrapper.a(this.a.m());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final Bundle b() {
        return this.a.g();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int c() {
        return this.a.d();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper d() {
        return a(this.a.s());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper e() {
        return ObjectWrapper.a(this.a.p());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean f() {
        return this.a.B();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final String g() {
        return this.a.f();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper h() {
        return a(this.a.i());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int i() {
        return this.a.j();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean j() {
        return this.a.C();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper k() {
        return ObjectWrapper.a(this.a.D());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean l() {
        return this.a.t();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean m() {
        return this.a.u();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean n() {
        return this.a.A();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean o() {
        return this.a.x();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean p() {
        return this.a.v();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean q() {
        return this.a.y();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean r() {
        return this.a.z();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void a(IObjectWrapper iObjectWrapper) {
        this.a.a((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void a(boolean z) {
        this.a.c(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void b(boolean z) {
        this.a.d(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void c(boolean z) {
        this.a.b(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void d(boolean z) {
        this.a.e(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void a(Intent intent) {
        this.a.a(intent);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void a(Intent intent, int i) {
        this.a.a(intent, i);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void b(IObjectWrapper iObjectWrapper) {
        this.a.b((View) ObjectWrapper.a(iObjectWrapper));
    }
}
