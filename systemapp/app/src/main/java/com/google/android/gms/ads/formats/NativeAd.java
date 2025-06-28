package com.google.android.gms.ads.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class NativeAd {

    /* compiled from: source */
    public static abstract class AdChoicesInfo {
    }

    /* compiled from: source */
    public static abstract class Image {
        public abstract Drawable a();

        public abstract Uri b();

        public abstract double c();

        public int d() {
            return -1;
        }

        public int e() {
            return -1;
        }
    }

    protected abstract Object a();
}
