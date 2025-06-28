package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class bz<FieldDescriptorType> extends ca<FieldDescriptorType, Object> {
    bz(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.measurement.ca
    public final void a() {
        if (!b()) {
            for (int i = 0; i < c(); i++) {
                Map.Entry<FieldDescriptorType, Object> b = b(i);
                if (((zzey) b.getKey()).c()) {
                    b.setValue(Collections.unmodifiableList((List) b.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : d()) {
                if (((zzey) entry.getKey()).c()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
