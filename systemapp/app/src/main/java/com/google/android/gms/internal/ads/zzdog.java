package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdog {
    public static ParcelFileDescriptor a(InputStream inputStream) throws IOException {
        ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
        zzazj.a.execute(new Runnable(inputStream, createPipe[1]) { // from class: com.google.android.gms.internal.ads.ais
            private final InputStream a;
            private final ParcelFileDescriptor b;

            {
                this.a = inputStream;
                this.b = parcelFileDescriptor2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                InputStream inputStream2 = this.a;
                try {
                    try {
                        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(this.b);
                        try {
                            IOUtils.a(inputStream2, autoCloseOutputStream);
                            autoCloseOutputStream.close();
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                        } catch (Throwable th) {
                            try {
                                autoCloseOutputStream.close();
                            } catch (Throwable th2) {
                                zzeid.a(th, th2);
                            }
                            throw th;
                        }
                    } finally {
                    }
                } catch (IOException unused) {
                }
            }
        });
        return parcelFileDescriptor;
    }
}
