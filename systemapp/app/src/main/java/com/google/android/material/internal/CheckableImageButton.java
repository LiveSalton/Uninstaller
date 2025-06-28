package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.appcompat.a;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.h.w;

/* compiled from: source */
/* loaded from: classes.dex */
public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] a = {R.attr.state_checked};
    private boolean b;

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0001a.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        w.a(this, new androidx.core.h.a() { // from class: com.google.android.material.internal.CheckableImageButton.1
            AnonymousClass1() {
            }

            @Override // androidx.core.h.a
            public void d(View view, AccessibilityEvent accessibilityEvent) {
                super.d(view, accessibilityEvent);
                accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
            }

            @Override // androidx.core.h.a
            public void a(View view, androidx.core.h.a.d dVar) {
                super.a(view, dVar);
                dVar.a(true);
                dVar.b(CheckableImageButton.this.isChecked());
            }
        });
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.internal.CheckableImageButton$1 */
    class AnonymousClass1 extends androidx.core.h.a {
        AnonymousClass1() {
        }

        @Override // androidx.core.h.a
        public void d(View view, AccessibilityEvent accessibilityEvent) {
            super.d(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // androidx.core.h.a
        public void a(View view, androidx.core.h.a.d dVar) {
            super.a(view, dVar);
            dVar.a(true);
            dVar.b(CheckableImageButton.this.isChecked());
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.b != z) {
            this.b = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.b;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.b);
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        if (this.b) {
            return mergeDrawableStates(super.onCreateDrawableState(i + a.length), a);
        }
        return super.onCreateDrawableState(i);
    }
}
