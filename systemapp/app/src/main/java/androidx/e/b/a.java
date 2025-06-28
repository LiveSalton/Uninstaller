package androidx.e.b;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: source */
/* loaded from: classes.dex */
public class a<D> {
    int a;
    InterfaceC0034a<D> b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;

    /* compiled from: source */
    /* renamed from: androidx.e.b.a$a */
    public interface InterfaceC0034a<D> {
    }

    protected void b() {
    }

    protected boolean d() {
        return false;
    }

    protected void f() {
    }

    protected void h() {
    }

    protected void j() {
    }

    public void a(InterfaceC0034a<D> interfaceC0034a) {
        if (this.b == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.b != interfaceC0034a) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.b = null;
    }

    public final void a() {
        this.c = true;
        this.e = false;
        this.d = false;
        b();
    }

    public boolean c() {
        return d();
    }

    public void e() {
        this.c = false;
        f();
    }

    public void g() {
        this.d = true;
        h();
    }

    public void i() {
        j();
        this.e = true;
        this.c = false;
        this.d = false;
        this.f = false;
        this.g = false;
    }

    public String a(D d) {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.g.a.a(d, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.g.a.a(this, sb);
        sb.append(" id=");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.a);
        printWriter.print(" mListener=");
        printWriter.println(this.b);
        if (this.c || this.f || this.g) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.c);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.g);
        }
        if (this.d || this.e) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.d);
            printWriter.print(" mReset=");
            printWriter.println(this.e);
        }
    }
}
