package androidx.core.h.a;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
public final class a extends ClickableSpan {
    private final int a;
    private final d b;
    private final int c;

    public a(int i, d dVar, int i2) {
        this.a = i;
        this.b = dVar;
        this.c = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.a);
        this.b.a(this.c, bundle);
    }
}
