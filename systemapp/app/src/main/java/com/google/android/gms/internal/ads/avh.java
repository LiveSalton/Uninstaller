package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class avh<FieldDescriptorType> extends avi<FieldDescriptorType, Object> {
    avh(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.ads.avi
    public final void a() {
        if (!b()) {
            for (int i = 0; i < c(); i++) {
                Map.Entry<FieldDescriptorType, Object> b = b(i);
                if (((zzejz) b.getKey()).d()) {
                    b.setValue(Collections.unmodifiableList((List) b.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : d()) {
                if (((zzejz) entry.getKey()).d()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
