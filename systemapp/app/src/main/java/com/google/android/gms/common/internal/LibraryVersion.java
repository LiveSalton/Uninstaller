package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public class LibraryVersion {
    private static final GmsLogger a = new GmsLogger("LibraryVersion", "");
    private static LibraryVersion b = new LibraryVersion();
    private ConcurrentHashMap<String, String> c = new ConcurrentHashMap<>();

    @VisibleForTesting
    protected LibraryVersion() {
    }
}
