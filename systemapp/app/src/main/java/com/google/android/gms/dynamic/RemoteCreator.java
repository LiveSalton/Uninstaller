package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public abstract class RemoteCreator<T> {
    private final String a;
    private T b;

    @KeepForSdk
    protected RemoteCreator(String str) {
        this.a = str;
    }

    @KeepForSdk
    protected abstract T a(IBinder iBinder);

    /* compiled from: source */
    @KeepForSdk
    public static class RemoteCreatorException extends Exception {
        public RemoteCreatorException(String str) {
            super(str);
        }

        public RemoteCreatorException(String str, Throwable th) {
            super(str, th);
        }
    }

    @KeepForSdk
    protected final T a(Context context) throws RemoteCreatorException {
        if (this.b == null) {
            Preconditions.a(context);
            Context a = GooglePlayServicesUtilLight.a(context);
            if (a == null) {
                throw new RemoteCreatorException("Could not get remote context.");
            }
            try {
                this.b = a((IBinder) a.getClassLoader().loadClass(this.a).newInstance());
            } catch (ClassNotFoundException e) {
                throw new RemoteCreatorException("Could not load creator class.", e);
            } catch (IllegalAccessException e2) {
                throw new RemoteCreatorException("Could not access creator.", e2);
            } catch (InstantiationException e3) {
                throw new RemoteCreatorException("Could not instantiate creator.", e3);
            }
        }
        return this.b;
    }
}
