package com.jumobile.manager.systemapp.h.c;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class a {
    final String[] c;
    int j;
    Handler a = null;
    boolean b = false;
    boolean d = false;
    Context e = null;
    boolean f = false;
    boolean g = false;
    boolean h = true;
    int i = -1;
    int k = 50000;

    public abstract void a(int i, int i2);

    public abstract void a(int i, String str);

    public abstract void b(int i, String str);

    public a(int i, String... strArr) {
        this.j = 0;
        this.c = strArr;
        this.j = i;
        a(com.jumobile.manager.systemapp.h.a.d);
    }

    public a(int i, boolean z, String... strArr) {
        this.j = 0;
        this.c = strArr;
        this.j = i;
        a(z);
    }

    protected void a() {
        if (this.g) {
            return;
        }
        synchronized (this) {
            if (this.a != null && this.h) {
                Message obtainMessage = this.a.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("action", 2);
                obtainMessage.setData(bundle);
                this.a.sendMessage(obtainMessage);
            } else {
                a(this.j, this.i);
            }
            com.jumobile.manager.systemapp.h.a.e("Command " + this.j + " finished.");
            this.b = false;
            this.f = true;
            notifyAll();
        }
    }

    private void a(boolean z) {
        this.h = z;
        if (Looper.myLooper() == null || !z) {
            return;
        }
        this.a = new HandlerC0089a();
    }

    public String b() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (this.d) {
            String path = this.e.getFilesDir().getPath();
            while (i < this.c.length) {
                sb.append("dalvikvm -cp " + path + "/anbuild.dex com.stericson.RootTools.containers.RootClass " + this.c[i]);
                sb.append('\n');
                i++;
            }
        } else {
            while (i < this.c.length) {
                sb.append(this.c[i]);
                sb.append('\n');
                i++;
            }
        }
        com.jumobile.manager.systemapp.h.a.e("Sending command(s): " + sb.toString());
        return sb.toString();
    }

    public int c() {
        return this.i;
    }

    protected void a(int i) {
        synchronized (this) {
            this.i = i;
        }
    }

    protected void d() {
        new b().start();
        this.b = true;
    }

    public void a(String str) {
        try {
            c.e();
            com.jumobile.manager.systemapp.h.a.e("Terminating all shells.");
            b(str);
        } catch (IOException unused) {
        }
    }

    protected void b(String str) {
        synchronized (this) {
            if (this.a != null && this.h) {
                Message obtainMessage = this.a.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("action", 3);
                bundle.putString("text", str);
                obtainMessage.setData(bundle);
                this.a.sendMessage(obtainMessage);
            } else {
                b(this.j, str);
            }
            com.jumobile.manager.systemapp.h.a.e("Command " + this.j + " did not finish because it was terminated. Termination reason: " + str);
            a(-1);
            this.g = true;
            this.f = true;
            this.b = false;
            notifyAll();
        }
    }

    protected void c(int i, String str) {
        if (this.a != null && this.h) {
            Message obtainMessage = this.a.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putInt("action", 1);
            bundle.putString("text", str);
            obtainMessage.setData(bundle);
            this.a.sendMessage(obtainMessage);
            return;
        }
        a(i, str);
    }

    /* compiled from: source */
    private class b extends Thread {
        private b() {
        }

        /* synthetic */ b(a aVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!a.this.f) {
                synchronized (a.this) {
                    try {
                        a.this.wait(a.this.k);
                    } catch (InterruptedException unused) {
                    }
                }
                if (!a.this.f) {
                    a.this.f = true;
                    com.jumobile.manager.systemapp.h.a.e("Timeout Exception has occurred.");
                    a.this.a("Timeout Exception");
                }
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.h.c.a$a */
    private class HandlerC0089a extends Handler {
        private HandlerC0089a() {
        }

        /* synthetic */ HandlerC0089a(a aVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.getData().getInt("action");
            String string = message.getData().getString("text");
            switch (i) {
                case 1:
                    a.this.a(a.this.j, string);
                    break;
                case 2:
                    a.this.a(a.this.j, a.this.i);
                    break;
                case 3:
                    a.this.b(a.this.j, string);
                    break;
            }
        }
    }
}
