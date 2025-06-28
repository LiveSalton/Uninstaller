package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* compiled from: source */
/* loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {
    long a;
    boolean b;
    boolean c;
    boolean d;
    private final Runnable e;
    private final Runnable f;

    /* compiled from: source */
    /* renamed from: androidx.core.widget.ContentLoadingProgressBar$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentLoadingProgressBar.this.b = false;
            ContentLoadingProgressBar.this.a = -1L;
            ContentLoadingProgressBar.this.setVisibility(8);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.core.widget.ContentLoadingProgressBar$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentLoadingProgressBar.this.c = false;
            if (ContentLoadingProgressBar.this.d) {
                return;
            }
            ContentLoadingProgressBar.this.a = System.currentTimeMillis();
            ContentLoadingProgressBar.this.setVisibility(0);
        }
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.a = -1L;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = new Runnable() { // from class: androidx.core.widget.ContentLoadingProgressBar.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ContentLoadingProgressBar.this.b = false;
                ContentLoadingProgressBar.this.a = -1L;
                ContentLoadingProgressBar.this.setVisibility(8);
            }
        };
        this.f = new Runnable() { // from class: androidx.core.widget.ContentLoadingProgressBar.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ContentLoadingProgressBar.this.c = false;
                if (ContentLoadingProgressBar.this.d) {
                    return;
                }
                ContentLoadingProgressBar.this.a = System.currentTimeMillis();
                ContentLoadingProgressBar.this.setVisibility(0);
            }
        };
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    private void a() {
        removeCallbacks(this.e);
        removeCallbacks(this.f);
    }
}
