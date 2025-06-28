package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.os.Bundle;
import androidx.b.a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzc extends Fragment implements LifecycleFragment {
    private static WeakHashMap<FragmentActivity, WeakReference<zzc>> U = new WeakHashMap<>();
    private Map<String, LifecycleCallback> V = Collections.synchronizedMap(new a());
    private int W = 0;
    private Bundle X;

    @Override // androidx.fragment.app.Fragment
    public final void f(Bundle bundle) {
        super.f(bundle);
        this.W = 1;
        this.X = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.V.entrySet()) {
            entry.getValue().a(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void F() {
        super.F();
        this.W = 2;
        Iterator<LifecycleCallback> it = this.V.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void G() {
        super.G();
        this.W = 3;
        Iterator<LifecycleCallback> it = this.V.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        Iterator<LifecycleCallback> it = this.V.values().iterator();
        while (it.hasNext()) {
            it.next().a(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void j(Bundle bundle) {
        super.j(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.V.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().b(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void I() {
        super.I();
        this.W = 4;
        Iterator<LifecycleCallback> it = this.V.values().iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void K() {
        super.K();
        this.W = 5;
        Iterator<LifecycleCallback> it = this.V.values().iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        Iterator<LifecycleCallback> it = this.V.values().iterator();
        while (it.hasNext()) {
            it.next().a(str, fileDescriptor, printWriter, strArr);
        }
    }
}
