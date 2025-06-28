package com.jumobile.manager.systemapp.h.c;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

/* compiled from: source */
/* loaded from: classes.dex */
public class c {
    private static String f = "";
    private static c g = null;
    private static c h = null;
    private static c i = null;
    private static int j = 25000;
    private final Process a;
    private final BufferedReader b;
    private final OutputStreamWriter c;
    private final List<com.jumobile.manager.systemapp.h.c.a> d = new ArrayList();
    private boolean e = false;
    private Runnable k = new Runnable() { // from class: com.jumobile.manager.systemapp.h.c.c.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = 0;
            while (true) {
                try {
                    try {
                        synchronized (c.this.d) {
                            while (!c.this.e && i2 >= c.this.d.size()) {
                                c.this.d.wait();
                            }
                        }
                        if (i2 < c.this.d.size()) {
                            com.jumobile.manager.systemapp.h.c.a aVar = (com.jumobile.manager.systemapp.h.c.a) c.this.d.get(i2);
                            aVar.d();
                            c.this.c.write(aVar.b());
                            c.this.c.write("\necho F*D^W@#FGF " + i2 + " $?\n");
                            c.this.c.flush();
                            i2++;
                        } else if (c.this.e) {
                            c.this.c.write("\nexit 0\n");
                            c.this.c.flush();
                            com.jumobile.manager.systemapp.h.a.e("Closing shell");
                            return;
                        }
                    } catch (IOException e) {
                        com.jumobile.manager.systemapp.h.a.a(e.getMessage(), 2, e);
                        return;
                    } catch (InterruptedException e2) {
                        com.jumobile.manager.systemapp.h.a.a(e2.getMessage(), 2, e2);
                        return;
                    }
                } finally {
                    c.this.a(c.this.c);
                }
            }
        }
    };
    private Runnable l = new Runnable() { // from class: com.jumobile.manager.systemapp.h.c.c.2
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jumobile.manager.systemapp.h.c.a aVar;
            String readLine;
            int i2;
            int i3;
            int i4 = 0;
            loop0: while (true) {
                aVar = null;
                while (!c.this.e && (readLine = c.this.b.readLine()) != null) {
                    try {
                        if (aVar == null) {
                            if (i4 >= c.this.d.size()) {
                                if (c.this.e) {
                                    break loop0;
                                }
                            } else {
                                aVar = (com.jumobile.manager.systemapp.h.c.a) c.this.d.get(i4);
                            }
                        }
                        if (readLine.indexOf("F*D^W@#FGF") == -1) {
                            aVar.c(aVar.j, readLine);
                        } else {
                            String[] split = readLine.split(" ");
                            if (split.length >= 2 && split[1] != null) {
                                try {
                                    i2 = Integer.parseInt(split[1]);
                                } catch (NumberFormatException unused) {
                                    i2 = 0;
                                }
                                try {
                                    i3 = Integer.parseInt(split[2]);
                                } catch (NumberFormatException unused2) {
                                    i3 = -1;
                                }
                                if (i2 == i4) {
                                    break;
                                }
                            }
                        }
                    } catch (IOException e) {
                        com.jumobile.manager.systemapp.h.a.a(e.getMessage(), 2, e);
                        return;
                    }
                }
                aVar.a(i3);
                aVar.a();
                i4++;
            }
            com.jumobile.manager.systemapp.h.a.e("Read all output");
            try {
                c.this.a.waitFor();
                c.this.a.destroy();
            } catch (Exception unused3) {
            }
            c.this.a(c.this.c);
            c.this.a(c.this.b);
            com.jumobile.manager.systemapp.h.a.e("Shell destroyed");
            while (i4 < c.this.d.size()) {
                if (aVar == null) {
                    aVar = (com.jumobile.manager.systemapp.h.c.a) c.this.d.get(i4);
                }
                aVar.b("Unexpected Termination.");
                i4++;
                aVar = null;
            }
        }
    };

    private c(String str) throws IOException, TimeoutException, com.jumobile.manager.systemapp.h.b.a {
        com.jumobile.manager.systemapp.h.a.e("Starting shell: " + str);
        this.a = new ProcessBuilder(str).redirectErrorStream(true).start();
        this.b = new BufferedReader(new InputStreamReader(this.a.getInputStream(), "UTF-8"));
        this.c = new OutputStreamWriter(this.a.getOutputStream(), "UTF-8");
        a aVar = new a(this.a, this.b, this.c);
        aVar.start();
        try {
            aVar.join(j);
            if (aVar.a == -911) {
                try {
                    this.a.destroy();
                } catch (Exception unused) {
                }
                a(this.b);
                a(this.c);
                throw new TimeoutException(f);
            }
            if (aVar.a == -42) {
                try {
                    this.a.destroy();
                } catch (Exception unused2) {
                }
                a(this.b);
                a(this.c);
                throw new com.jumobile.manager.systemapp.h.b.a("Root Access Denied");
            }
            new Thread(this.k, "Shell Input").start();
            new Thread(this.l, "Shell Output").start();
        } catch (InterruptedException unused3) {
            aVar.interrupt();
            Thread.currentThread().interrupt();
            throw new TimeoutException();
        }
    }

    public com.jumobile.manager.systemapp.h.c.a a(com.jumobile.manager.systemapp.h.c.a aVar) throws IOException {
        if (this.e) {
            throw new IllegalStateException("Unable to add commands to a closed shell");
        }
        synchronized (this.d) {
            this.d.add(aVar);
            this.d.notifyAll();
        }
        return aVar;
    }

    public void a(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (Exception unused) {
            }
        }
    }

    public void a(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (Exception unused) {
            }
        }
    }

    public void a() throws IOException {
        if (this == g) {
            g = null;
        } else if (this == h) {
            h = null;
        } else if (this == i) {
            i = null;
        }
        synchronized (this.d) {
            this.e = true;
            this.d.notifyAll();
        }
    }

    public static void b() throws IOException {
        if (i == null) {
            return;
        }
        i.a();
    }

    public static void c() throws IOException {
        if (g == null) {
            return;
        }
        g.a();
    }

    public static void d() throws IOException {
        if (h == null) {
            return;
        }
        h.a();
    }

    public static void e() throws IOException {
        d();
        c();
        b();
    }

    public static c f() {
        if (i != null) {
            return i;
        }
        if (g != null) {
            return g;
        }
        return h;
    }

    public static boolean g() {
        return (h == null && g == null && i == null) ? false : true;
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.h.c.c$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = 0;
            while (true) {
                try {
                    try {
                        synchronized (c.this.d) {
                            while (!c.this.e && i2 >= c.this.d.size()) {
                                c.this.d.wait();
                            }
                        }
                        if (i2 < c.this.d.size()) {
                            com.jumobile.manager.systemapp.h.c.a aVar = (com.jumobile.manager.systemapp.h.c.a) c.this.d.get(i2);
                            aVar.d();
                            c.this.c.write(aVar.b());
                            c.this.c.write("\necho F*D^W@#FGF " + i2 + " $?\n");
                            c.this.c.flush();
                            i2++;
                        } else if (c.this.e) {
                            c.this.c.write("\nexit 0\n");
                            c.this.c.flush();
                            com.jumobile.manager.systemapp.h.a.e("Closing shell");
                            return;
                        }
                    } catch (IOException e) {
                        com.jumobile.manager.systemapp.h.a.a(e.getMessage(), 2, e);
                        return;
                    } catch (InterruptedException e2) {
                        com.jumobile.manager.systemapp.h.a.a(e2.getMessage(), 2, e2);
                        return;
                    }
                } finally {
                    c.this.a(c.this.c);
                }
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.h.c.c$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jumobile.manager.systemapp.h.c.a aVar;
            String readLine;
            int i2;
            int i3;
            int i4 = 0;
            loop0: while (true) {
                aVar = null;
                while (!c.this.e && (readLine = c.this.b.readLine()) != null) {
                    try {
                        if (aVar == null) {
                            if (i4 >= c.this.d.size()) {
                                if (c.this.e) {
                                    break loop0;
                                }
                            } else {
                                aVar = (com.jumobile.manager.systemapp.h.c.a) c.this.d.get(i4);
                            }
                        }
                        if (readLine.indexOf("F*D^W@#FGF") == -1) {
                            aVar.c(aVar.j, readLine);
                        } else {
                            String[] split = readLine.split(" ");
                            if (split.length >= 2 && split[1] != null) {
                                try {
                                    i2 = Integer.parseInt(split[1]);
                                } catch (NumberFormatException unused) {
                                    i2 = 0;
                                }
                                try {
                                    i3 = Integer.parseInt(split[2]);
                                } catch (NumberFormatException unused2) {
                                    i3 = -1;
                                }
                                if (i2 == i4) {
                                    break;
                                }
                            }
                        }
                    } catch (IOException e) {
                        com.jumobile.manager.systemapp.h.a.a(e.getMessage(), 2, e);
                        return;
                    }
                }
                aVar.a(i3);
                aVar.a();
                i4++;
            }
            com.jumobile.manager.systemapp.h.a.e("Read all output");
            try {
                c.this.a.waitFor();
                c.this.a.destroy();
            } catch (Exception unused3) {
            }
            c.this.a(c.this.c);
            c.this.a(c.this.b);
            com.jumobile.manager.systemapp.h.a.e("Shell destroyed");
            while (i4 < c.this.d.size()) {
                if (aVar == null) {
                    aVar = (com.jumobile.manager.systemapp.h.c.a) c.this.d.get(i4);
                }
                aVar.b("Unexpected Termination.");
                i4++;
                aVar = null;
            }
        }
    }

    public static c h() throws IOException, TimeoutException, com.jumobile.manager.systemapp.h.b.a {
        return a(20000, 3);
    }

    public static c a(int i2) throws IOException, TimeoutException, com.jumobile.manager.systemapp.h.b.a {
        return a(i2, 3);
    }

    public static c a(int i2, int i3) throws IOException, TimeoutException, com.jumobile.manager.systemapp.h.b.a {
        j = i2;
        if (g == null) {
            com.jumobile.manager.systemapp.h.a.e("Starting Root Shell!");
            int i4 = 0;
            while (g == null) {
                try {
                    g = new c("su");
                } catch (IOException e) {
                    int i5 = i4 + 1;
                    if (i4 >= i3) {
                        com.jumobile.manager.systemapp.h.a.e("IOException, could not start shell");
                        throw e;
                    }
                    i4 = i5;
                }
            }
        } else {
            com.jumobile.manager.systemapp.h.a.e("Using Existing Root Shell!");
        }
        return g;
    }

    public static c i() throws IOException, TimeoutException {
        return b(20000);
    }

    public static c b(int i2) throws IOException, TimeoutException {
        j = i2;
        try {
            if (h == null) {
                com.jumobile.manager.systemapp.h.a.e("Starting Shell!");
                h = new c("/system/bin/sh");
            } else {
                com.jumobile.manager.systemapp.h.a.e("Using Existing Shell!");
            }
            return h;
        } catch (com.jumobile.manager.systemapp.h.b.a unused) {
            throw new IOException();
        }
    }

    /* compiled from: source */
    protected static class a extends Thread {
        public int a;
        public Process b;
        public BufferedReader c;
        public OutputStreamWriter d;

        /* synthetic */ a(Process process, BufferedReader bufferedReader, OutputStreamWriter outputStreamWriter, AnonymousClass1 anonymousClass1) {
            this(process, bufferedReader, outputStreamWriter);
        }

        private a(Process process, BufferedReader bufferedReader, OutputStreamWriter outputStreamWriter) {
            this.a = -911;
            this.b = process;
            this.c = bufferedReader;
            this.d = outputStreamWriter;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.d.write("echo Started\n");
                this.d.flush();
                while (true) {
                    String readLine = this.c.readLine();
                    if (readLine == null) {
                        throw new EOFException();
                    }
                    if (!"".equals(readLine)) {
                        if (!"Started".equals(readLine)) {
                            String unused = c.f = "unkown error occured.";
                        } else {
                            this.a = 1;
                            return;
                        }
                    }
                }
            } catch (IOException e) {
                this.a = -42;
                if (e.getMessage() != null) {
                    String unused2 = c.f = e.getMessage();
                } else {
                    String unused3 = c.f = "RootAccess denied?.";
                }
            }
        }
    }
}
