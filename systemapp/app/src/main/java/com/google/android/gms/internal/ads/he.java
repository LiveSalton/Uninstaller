package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: source */
/* loaded from: classes.dex */
final class he extends SSLSocketFactory {
    private SSLSocketFactory a = (SSLSocketFactory) SSLSocketFactory.getDefault();
    private final /* synthetic */ hc b;

    he(hc hcVar) {
        this.b = hcVar;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.a.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return a(this.a.createSocket(socket, str, i, z));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) throws IOException {
        return a(this.a.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return a(this.a.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return a(this.a.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return a(this.a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    private final Socket a(Socket socket) throws SocketException {
        int i;
        int i2;
        i = this.b.r;
        if (i > 0) {
            i2 = this.b.r;
            socket.setReceiveBufferSize(i2);
        }
        this.b.a(socket);
        return socket;
    }
}
