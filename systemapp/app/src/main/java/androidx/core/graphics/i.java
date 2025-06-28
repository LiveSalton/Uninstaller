package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.content.a.c;
import androidx.core.e.b;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: source */
/* loaded from: classes.dex */
public class i extends j {
    @Override // androidx.core.graphics.j
    protected b.C0021b a(b.C0021b[] c0021bArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.j
    protected Typeface a(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.j
    public Typeface a(Context context, CancellationSignal cancellationSignal, b.C0021b[] c0021bArr, int i) {
        int i2;
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        FontFamily.Builder builder = null;
        for (b.C0021b c0021b : c0021bArr) {
            try {
                openFileDescriptor = contentResolver.openFileDescriptor(c0021b.a(), "r", cancellationSignal);
            } catch (IOException unused) {
                continue;
            }
            if (openFileDescriptor != null) {
                try {
                    Font build = new Font.Builder(openFileDescriptor).setWeight(c0021b.c()).setSlant(c0021b.d() ? 1 : 0).setTtcIndex(c0021b.b()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                    i2 = openFileDescriptor == null ? i2 + 1 : 0;
                } catch (Throwable th) {
                    if (openFileDescriptor != null) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } else if (openFileDescriptor == null) {
            }
            openFileDescriptor.close();
        }
        if (builder == null) {
            return null;
        }
        return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0)).build();
    }

    @Override // androidx.core.graphics.j
    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        FontFamily.Builder builder = null;
        for (c.C0018c c0018c : bVar.a()) {
            try {
                Font build = new Font.Builder(resources, c0018c.f()).setWeight(c0018c.b()).setSlant(c0018c.c() ? 1 : 0).setTtcIndex(c0018c.e()).setFontVariationSettings(c0018c.d()).build();
                if (builder == null) {
                    builder = new FontFamily.Builder(build);
                } else {
                    builder.addFont(build);
                }
            } catch (IOException unused) {
            }
        }
        if (builder == null) {
            return null;
        }
        return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0)).build();
    }

    @Override // androidx.core.graphics.j
    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        try {
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(new Font.Builder(resources, i).build()).build()).setStyle(new FontStyle((i2 & 1) != 0 ? 700 : 400, (i2 & 2) != 0 ? 1 : 0)).build();
        } catch (IOException unused) {
            return null;
        }
    }
}
