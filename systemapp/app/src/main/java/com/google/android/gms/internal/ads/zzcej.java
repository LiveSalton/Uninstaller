package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.zzax;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcej {
    private final zzax a;
    private final Clock b;
    private final Executor c;

    public zzcej(zzax zzaxVar, Clock clock, Executor executor) {
        this.a = zzaxVar;
        this.b = clock;
        this.c = executor;
    }

    public final zzdyz<Bitmap> a(String str, double d, boolean z) {
        return zzdyr.a(zzax.a(str), new rt(this, d, z), this.c);
    }

    public final Bitmap a(byte[] bArr, double d, boolean z) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (d * 160.0d);
        if (!z) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        if (((Boolean) zzwq.e().a(zzabf.dp)).booleanValue()) {
            options.inJustDecodeBounds = true;
            a(bArr, options);
            options.inJustDecodeBounds = false;
            int i = options.outWidth * options.outHeight;
            if (i > 0) {
                int i2 = i - 1;
                options.inSampleSize = 1 << ((33 - Integer.numberOfLeadingZeros(i2 / ((Integer) zzwq.e().a(zzabf.dq)).intValue())) / 2);
            }
        }
        return a(bArr, options);
    }

    private final Bitmap a(byte[] bArr, BitmapFactory.Options options) {
        long b = this.b.b();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        long b2 = this.b.b();
        if (Build.VERSION.SDK_INT >= 19 && decodeByteArray != null) {
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            int allocationByteCount = decodeByteArray.getAllocationByteCount();
            long j = b2 - b;
            boolean z = Looper.getMainLooper().getThread() == Thread.currentThread();
            StringBuilder sb = new StringBuilder(108);
            sb.append("Decoded image w: ");
            sb.append(width);
            sb.append(" h:");
            sb.append(height);
            sb.append(" bytes: ");
            sb.append(allocationByteCount);
            sb.append(" time: ");
            sb.append(j);
            sb.append(" on ui thread: ");
            sb.append(z);
            zzd.a(sb.toString());
        }
        return decodeByteArray;
    }
}
