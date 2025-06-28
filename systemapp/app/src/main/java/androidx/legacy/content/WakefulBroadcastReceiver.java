package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.os.PowerManager;
import android.util.SparseArray;

/* compiled from: source */
@Deprecated
/* loaded from: classes.dex */
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    private static final SparseArray<PowerManager.WakeLock> a = new SparseArray<>();
    private static int b = 1;
}
