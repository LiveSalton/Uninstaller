package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Debug;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class adl implements Callable {
    static final Callable a = new adl();

    private adl() {
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Bundle bundle = new Bundle();
        if (((Boolean) zzwq.e().a(zzabf.z)).booleanValue()) {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            bundle.putString("debug_info_dalvik_private_dirty", Integer.toString(memoryInfo.dalvikPrivateDirty));
            bundle.putString("debug_info_dalvik_pss", Integer.toString(memoryInfo.dalvikPss));
            bundle.putString("debug_info_dalvik_shared_dirty", Integer.toString(memoryInfo.dalvikSharedDirty));
            bundle.putString("debug_info_native_private_dirty", Integer.toString(memoryInfo.nativePrivateDirty));
            bundle.putString("debug_info_native_pss", Integer.toString(memoryInfo.nativePss));
            bundle.putString("debug_info_native_shared_dirty", Integer.toString(memoryInfo.nativeSharedDirty));
            bundle.putString("debug_info_other_private_dirty", Integer.toString(memoryInfo.otherPrivateDirty));
            bundle.putString("debug_info_other_pss", Integer.toString(memoryInfo.otherPss));
            bundle.putString("debug_info_other_shared_dirty", Integer.toString(memoryInfo.otherSharedDirty));
        }
        Runtime runtime = Runtime.getRuntime();
        bundle.putLong("runtime_free", runtime.freeMemory());
        bundle.putLong("runtime_max", runtime.maxMemory());
        bundle.putLong("runtime_total", runtime.totalMemory());
        bundle.putInt("web_view_count", zzp.g().g());
        return new zzddc(bundle);
    }
}
