package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzaak;

/* compiled from: source */
/* loaded from: classes.dex */
public final class VideoOptions {
    private final boolean a;
    private final boolean b;
    private final boolean c;

    public VideoOptions(zzaak zzaakVar) {
        this.a = zzaakVar.a;
        this.b = zzaakVar.b;
        this.c = zzaakVar.c;
    }

    /* compiled from: source */
    public static final class Builder {
        private boolean a = true;
        private boolean b = false;
        private boolean c = false;

        public final Builder a(boolean z) {
            this.a = z;
            return this;
        }

        public final VideoOptions a() {
            return new VideoOptions(this);
        }
    }

    private VideoOptions(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
    }

    public final boolean a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    /* synthetic */ VideoOptions(Builder builder, c cVar) {
        this(builder);
    }
}
