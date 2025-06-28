package androidx.work.impl.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.h;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class c<T> extends d<T> {
    private static final String d = h.a("BrdcstRcvrCnstrntTrckr");
    private final BroadcastReceiver e;

    public abstract void a(Context context, Intent intent);

    public abstract IntentFilter b();

    /* compiled from: source */
    /* renamed from: androidx.work.impl.a.b.c$1 */
    class AnonymousClass1 extends BroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                c.this.a(context, intent);
            }
        }
    }

    public c(Context context, androidx.work.impl.utils.b.a aVar) {
        super(context, aVar);
        this.e = new BroadcastReceiver() { // from class: androidx.work.impl.a.b.c.1
            AnonymousClass1() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (intent != null) {
                    c.this.a(context2, intent);
                }
            }
        };
    }

    @Override // androidx.work.impl.a.b.d
    public void d() {
        h.a().b(d, String.format("%s: registering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.b.registerReceiver(this.e, b());
    }

    @Override // androidx.work.impl.a.b.d
    public void e() {
        h.a().b(d, String.format("%s: unregistering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.b.unregisterReceiver(this.e);
    }
}
