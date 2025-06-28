package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* compiled from: source */
/* loaded from: classes.dex */
final class k {
    private TextView a;
    private TextClassifier b;

    k(TextView textView) {
        this.a = (TextView) androidx.core.g.e.a(textView);
    }

    public void a(TextClassifier textClassifier) {
        this.b = textClassifier;
    }

    public TextClassifier a() {
        if (this.b == null) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) this.a.getContext().getSystemService(TextClassificationManager.class);
            if (textClassificationManager != null) {
                return textClassificationManager.getTextClassifier();
            }
            return TextClassifier.NO_OP;
        }
        return this.b;
    }
}
