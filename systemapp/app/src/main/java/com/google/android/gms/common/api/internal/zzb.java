package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import androidx.b.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzb extends Fragment implements LifecycleFragment {
    private static WeakHashMap<Activity, WeakReference<zzb>> a = new WeakHashMap<>();
    private Map<String, LifecycleCallback> b = Collections.synchronizedMap(new a());
    private int c = 0;
    private Bundle d;

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = 1;
        this.d = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.b.entrySet()) {
            entry.getValue().a(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.c = 2;
        Iterator<LifecycleCallback> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.c = 3;
        Iterator<LifecycleCallback> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Iterator<LifecycleCallback> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().a(i, i2, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.b.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().b(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.c = 4;
        Iterator<LifecycleCallback> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.c = 5;
        Iterator<LifecycleCallback> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator<LifecycleCallback> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().a(str, fileDescriptor, printWriter, strArr);
        }
    }
}
