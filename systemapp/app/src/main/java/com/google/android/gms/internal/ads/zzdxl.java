package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdxl implements FilenameFilter {
    private final Pattern a;

    public zzdxl(Pattern pattern) {
        this.a = (Pattern) zzdvv.a(pattern);
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(@NullableDecl File file, String str) {
        return this.a.matcher(str).matches();
    }
}
