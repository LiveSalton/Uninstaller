package com.google.android.material.internal;

import android.graphics.Outline;

/* compiled from: source */
/* loaded from: classes.dex */
public class b extends a {
    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        copyBounds(this.b);
        outline.setOval(this.b);
    }
}
