package com.google.android.gms.ads;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class RequestConfiguration {
    public static final List<String> a = Arrays.asList("MA", "T", "PG", "G");
    private final int b;
    private final int c;
    private final String d;
    private final List<String> e;

    /* compiled from: source */
    @Retention(RetentionPolicy.SOURCE)
    public @interface MaxAdContentRating {
    }

    /* compiled from: source */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForChildDirectedTreatment {
    }

    /* compiled from: source */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForUnderAgeOfConsent {
    }

    private RequestConfiguration(int i, int i2, String str, List<String> list) {
        this.b = i;
        this.c = i2;
        this.d = str;
        this.e = list;
    }

    /* compiled from: source */
    public static class Builder {
        private int a = -1;
        private int b = -1;
        private String c = null;
        private final List<String> d = new ArrayList();

        public RequestConfiguration a() {
            return new RequestConfiguration(this.a, this.b, this.c, this.d);
        }
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public String c() {
        return this.d == null ? "" : this.d;
    }

    public List<String> d() {
        return new ArrayList(this.e);
    }

    /* synthetic */ RequestConfiguration(int i, int i2, String str, List list, b bVar) {
        this(i, i2, str, list);
    }
}
