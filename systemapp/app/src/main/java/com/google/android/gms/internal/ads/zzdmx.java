package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdmx {
    public final int a;
    public final int b;
    public final boolean c;

    public zzdmx(int i, int i2, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    static List<zzdmx> a(JsonReader jsonReader) throws IllegalStateException, IOException, NumberFormatException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            int i = 0;
            int i2 = 0;
            boolean z = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("width".equals(nextName)) {
                    i = jsonReader.nextInt();
                } else if ("height".equals(nextName)) {
                    i2 = jsonReader.nextInt();
                } else if ("is_fluid_height".equals(nextName)) {
                    z = jsonReader.nextBoolean();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            arrayList.add(new zzdmx(i, i2, z));
        }
        jsonReader.endArray();
        return arrayList;
    }
}
