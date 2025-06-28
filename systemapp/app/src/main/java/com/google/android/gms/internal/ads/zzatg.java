package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: source */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class zzatg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatg> CREATOR = new zzati();

    @SafeParcelable.Field
    private ParcelFileDescriptor a;
    private Parcelable b = null;
    private boolean c = true;

    @SafeParcelable.Constructor
    public zzatg(@SafeParcelable.Param ParcelFileDescriptor parcelFileDescriptor) {
        this.a = parcelFileDescriptor;
    }

    public final <T extends SafeParcelable> T a(Parcelable.Creator<T> creator) {
        if (this.c) {
            if (this.a == null) {
                zzd.c("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.a));
            try {
                try {
                    byte[] bArr = new byte[dataInputStream.readInt()];
                    dataInputStream.readFully(bArr, 0, bArr.length);
                    IOUtils.a(dataInputStream);
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.unmarshall(bArr, 0, bArr.length);
                        obtain.setDataPosition(0);
                        this.b = creator.createFromParcel(obtain);
                        obtain.recycle();
                        this.c = false;
                    } catch (Throwable th) {
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    IOUtils.a(dataInputStream);
                    throw th2;
                }
            } catch (IOException e) {
                zzd.c("Could not read from parcel file descriptor", e);
                IOUtils.a(dataInputStream);
                return null;
            }
        }
        return (T) this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        a();
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, (Parcelable) this.a, i, false);
        SafeParcelWriter.a(parcel, a);
    }

    private final ParcelFileDescriptor a() {
        if (this.a == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.b.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                this.a = a(marshall);
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
        }
        return this.a;
    }

    private static <T> ParcelFileDescriptor a(byte[] bArr) {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(createPipe[1]);
            try {
                zzazj.a.execute(new Runnable(autoCloseOutputStream, bArr) { // from class: com.google.android.gms.internal.ads.dw
                    private final OutputStream a;
                    private final byte[] b;

                    {
                        this.a = autoCloseOutputStream;
                        this.b = bArr;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzatg.a(this.a, this.b);
                    }
                });
                return createPipe[0];
            } catch (IOException e) {
                e = e;
                zzd.c("Error transporting the ad response", e);
                zzp.g().a(e, "LargeParcelTeleporter.pipeData.2");
                IOUtils.a(autoCloseOutputStream);
                return null;
            }
        } catch (IOException e2) {
            e = e2;
            autoCloseOutputStream = null;
        }
    }

    static final /* synthetic */ void a(OutputStream outputStream, byte[] bArr) {
        DataOutputStream dataOutputStream = null;
        try {
            try {
                DataOutputStream dataOutputStream2 = new DataOutputStream(outputStream);
                try {
                    dataOutputStream2.writeInt(bArr.length);
                    dataOutputStream2.write(bArr);
                    IOUtils.a(dataOutputStream2);
                } catch (IOException e) {
                    e = e;
                    dataOutputStream = dataOutputStream2;
                    zzd.c("Error transporting the ad response", e);
                    zzp.g().a(e, "LargeParcelTeleporter.pipeData.1");
                    if (dataOutputStream == null) {
                        IOUtils.a(outputStream);
                    } else {
                        IOUtils.a(dataOutputStream);
                    }
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    if (dataOutputStream == null) {
                        IOUtils.a(outputStream);
                    } else {
                        IOUtils.a(dataOutputStream);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }
}
