package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoOptions;

/* compiled from: source */
/* loaded from: classes.dex */
public final class NativeAdOptions {
    private final boolean a;
    private final int b;
    private final int c;
    private final boolean d;
    private final int e;
    private final VideoOptions f;
    private final boolean g;

    /* compiled from: source */
    public @interface AdChoicesPlacement {
    }

    /* compiled from: source */
    public @interface NativeMediaAspectRatio {
    }

    private NativeAdOptions(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.f;
        this.f = builder.e;
        this.g = builder.g;
    }

    /* compiled from: source */
    public static final class Builder {
        private VideoOptions e;
        private boolean a = false;
        private int b = -1;
        private int c = 0;
        private boolean d = false;
        private int f = 1;
        private boolean g = false;

        public final Builder a(boolean z) {
            this.a = z;
            return this;
        }

        @Deprecated
        public final Builder a(int i) {
            this.b = i;
            return this;
        }

        public final Builder b(boolean z) {
            this.d = z;
            return this;
        }

        public final Builder b(@AdChoicesPlacement int i) {
            this.f = i;
            return this;
        }

        public final Builder a(VideoOptions videoOptions) {
            this.e = videoOptions;
            return this;
        }

        public final NativeAdOptions a() {
            return new NativeAdOptions(this);
        }
    }

    public final boolean a() {
        return this.a;
    }

    @Deprecated
    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public final VideoOptions f() {
        return this.f;
    }

    public final boolean g() {
        return this.g;
    }

    /* synthetic */ NativeAdOptions(Builder builder, a aVar) {
        this(builder);
    }
}
