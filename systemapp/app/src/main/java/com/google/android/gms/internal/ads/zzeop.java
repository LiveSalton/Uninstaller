package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzeop implements zzbs, Closeable, Iterator<zzbp> {
    private static final zzbp f = new awy("eof ");
    private static zzeox g = zzeox.a(zzeop.class);
    protected zzbo a;
    protected zzeor b;
    private zzbp h = null;
    long c = 0;
    long d = 0;
    long e = 0;
    private List<zzbp> i = new ArrayList();

    public final List<zzbp> b() {
        if (this.b != null && this.h != f) {
            return new zzeov(this.i, this);
        }
        return this.i;
    }

    public void a(zzeor zzeorVar, long j, zzbo zzboVar) throws IOException {
        this.b = zzeorVar;
        long b = zzeorVar.b();
        this.d = b;
        this.c = b;
        zzeorVar.a(zzeorVar.b() + j);
        this.e = zzeorVar.b();
        this.a = zzboVar;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.h == f) {
            return false;
        }
        if (this.h != null) {
            return true;
        }
        try {
            this.h = (zzbp) next();
            return true;
        } catch (NoSuchElementException unused) {
            this.h = f;
            return false;
        }
    }

    @Override // java.util.Iterator
    /* renamed from: a */
    public final zzbp next() {
        zzbp a;
        if (this.h != null && this.h != f) {
            zzbp zzbpVar = this.h;
            this.h = null;
            return zzbpVar;
        }
        if (this.b == null || this.c >= this.e) {
            this.h = f;
            throw new NoSuchElementException();
        }
        try {
            synchronized (this.b) {
                this.b.a(this.c);
                a = this.a.a(this.b, this);
                this.c = this.b.b();
            }
            return a;
        } catch (EOFException unused) {
            throw new NoSuchElementException();
        } catch (IOException unused2) {
            throw new NoSuchElementException();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.i.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.i.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public void close() throws IOException {
        this.b.close();
    }
}
